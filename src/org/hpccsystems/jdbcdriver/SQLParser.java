/*##############################################################################

Copyright (C) 2011 HPCC Systems.

All rights reserved. This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
############################################################################## */

package org.hpccsystems.jdbcdriver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hpccsystems.jdbcdriver.ECLFunction.FunctionType;
import org.hpccsystems.jdbcdriver.HPCCColumnMetaData.ColumnType;

/**
 * @author rpastrana
 *
 */
public class SQLParser
{
    public enum SQLType
    {
        UNKNOWN,
        SELECT,
        SELECTCONST,
        CALL;
    }

    private List<SQLTable>           sqlTables;
    private SQLType                  sqlType;
    private LinkedList<HPCCColumnMetaData> selectColumns;
    private SQLWhereClause           whereClause;
    private SQLJoinClause            joinClause = null;
    private SQLWhereClause           havingClause = null;
    private List<HPCCColumnMetaData> groupByFragments;
    private List<HPCCColumnMetaData> orderByFragments;
    private String[]                 procInParamValues = null;
    private String                   storedProcName;
    private int                      limit = -1;
    private boolean                  columnsVerified = false;
    private boolean                  selectColsContainWildcard = false;
    private String                   indexHint;
    private boolean                  isSelectDistinct = false;

    private int                      parameterizedCount = 0;

    public final static String       parameterizedPrefix = "PARAM";
    public final static Pattern HAVINGPATTERN = Pattern.compile(
            "\\s*(.*?)\\s*(?i)having\\s+(.*?)",Pattern.DOTALL);

    public final static Pattern DISTINCTPATTERN = Pattern.compile(
            "\\s*(?i)distinct\\s+(.*?)",Pattern.DOTALL);

    public static final Pattern ASCDESCPATERN = Pattern.compile(
            "\\s*(.*?)\\s*(?i)(asc|desc)\\s*",Pattern.DOTALL);

    public void process(String insql) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  "INCOMING SQL: " + insql);

        sqlTables = new ArrayList<SQLTable>();
        selectColumns = new LinkedList<HPCCColumnMetaData>();
        whereClause = new SQLWhereClause();
        storedProcName = null;
        sqlType = SQLType.UNKNOWN;
        indexHint = null;
        columnsVerified = false;
        joinClause = null;
        groupByFragments = null;
        orderByFragments = null;
        procInParamValues = null;
        limit = -1;
        selectColsContainWildcard = false;
        isSelectDistinct = false;
        parameterizedCount = 0;

        insql = HPCCJDBCUtils.removeAllNewLines(insql);
        String insqlupcase = insql.toUpperCase();

        if (insql.matches("^(?i)call\\s+(.*?)"))
        {
            sqlType = SQLType.CALL;
            int callstrpos = insqlupcase.lastIndexOf("CALL ");
            int storedprocstrpos = insql.lastIndexOf("(");
            int paramlistend = insql.lastIndexOf(")");
            String paramToken = "";

            if (storedprocstrpos == -1)
                storedProcName = insql.substring(callstrpos + 5);
            else
            {
                if (paramlistend == -1)
                    throw new SQLException("Missing closing param in: " + insql);
                storedProcName = insql.substring(callstrpos + 5, storedprocstrpos);
                paramToken = insql.substring(storedprocstrpos + 1, paramlistend);
            }

            if (paramToken.length() > 0)
            {
                StringTokenizer tokenizer = new StringTokenizer(paramToken, ",");
                procInParamValues = new String[tokenizer.countTokens()];
                int i = 0;
                while (tokenizer.hasMoreTokens())
                {
                    procInParamValues[i++] = tokenizer.nextToken().trim();
                }
            }
        }
        else if (insql.matches("^(?i)select\\s+(.*?)"))
        {
            if (insql.matches("^(?i)select(.*?)\\s+(?i)union\\s+.*"))
                throw new SQLException("SELECT UNIONS are not supported.");

            sqlType = SQLType.SELECT;
            int fromstrpos = insqlupcase.lastIndexOf(" FROM ");

            if (fromstrpos == -1)
            {
                if (parseConstantSelect(insql))
                {
                    HPCCJDBCUtils.traceoutln(Level.INFO,  "Found Select <constant>");
                    sqlType = SQLType.SELECTCONST;
                    return;
                }
                else
                    throw new SQLException("Malformed SQL. Missing FROM statement.");
            }

            int useindexstrpos = insqlupcase.lastIndexOf(" USE INDEX(");
            int joinPos = insqlupcase.lastIndexOf(" JOIN ");
            int wherePos = insqlupcase.lastIndexOf(" WHERE ");
            int groupPos = insqlupcase.lastIndexOf(" GROUP BY ");
            int havingPos = insqlupcase.lastIndexOf(" HAVING ");
            int orderPos = insqlupcase.lastIndexOf(" ORDER BY ");
            int limitPos = insqlupcase.lastIndexOf(" LIMIT ");

            if (useindexstrpos != -1 && useindexstrpos < fromstrpos)
                throw new SQLException("Malformed SQL: USE clause placement.");

            if (joinPos != -1 && joinPos < fromstrpos)
                throw new SQLException("Malformed SQL: Join clause placement.");

            if (wherePos != -1 && wherePos < fromstrpos)
                throw new SQLException("Malformed SQL: WHERE clause placement.");

            if (havingPos != -1 && (groupPos <= -1 || havingPos <= groupPos))
                throw new SQLException("Malformed SQL: HAVING clause without GROUP BY placement.");

            try
            {
                if (limitPos != -1)
                {
                    limit = Integer.valueOf(insql.substring(limitPos + 6).trim());
                    insql = insql.substring(0, limitPos);
                }
            }
            catch (NumberFormatException ne)
            {
                throw new SQLException("Error near :\'" + insqlupcase.substring(limitPos) + "\'");
            }

            String orderByToken = "";
            String groupByToken = "";

            if (groupPos != -1 && (orderPos == -1 || groupPos < orderPos))
            {
                if (orderPos == -1)
                {
                    groupByToken = insql.substring(groupPos + 10);
                }
                else
                {
                    groupByToken = insql.substring(groupPos + 10, orderPos);
                    orderByToken = insql.substring(orderPos + 10);
                }

                insql = insql.substring(0, groupPos);

            }
            else if (orderPos != -1 && (groupPos == -1 || orderPos < groupPos))
            {
                if (groupPos == -1)
                {
                    orderByToken = insql.substring(orderPos + 10);
                }
                else
                {
                    orderByToken = insql.substring(orderPos + 10, groupPos);
                    groupByToken = insql.substring(groupPos + 10);
                }
                insql = insql.substring(0, orderPos);
            }

            if (orderByToken.length() > 0)
            {
                StringTokenizer tokenizer = new StringTokenizer(orderByToken, ",");

                orderByFragments = new ArrayList<HPCCColumnMetaData>();

                while (tokenizer.hasMoreTokens())
                {
                    String orderbycolumn = tokenizer.nextToken().trim();
                    boolean orderbyascending = true;

                    Matcher matcher = ASCDESCPATERN.matcher(orderbycolumn);

                    if (matcher.matches())
                    {
                        orderbycolumn = matcher.group(1).trim();
                        orderbyascending = matcher.group(2).trim().equalsIgnoreCase("ASC");
                    }

                    HPCCColumnMetaData order = new HPCCColumnMetaData(orderbycolumn.toUpperCase(), 0, java.sql.Types.OTHER);

                    if (!orderbyascending)
                        order.setSortAscending(false);

                    orderByFragments.add(order);
                }
            }

            if (groupByToken.length() > 0)
            {

                Matcher matcher = HAVINGPATTERN.matcher(groupByToken);

                if (matcher.matches())
                {
                    groupByToken = matcher.group(1).trim();
                    parseHavingClause(matcher.group(2));
                }

                StringTokenizer tokenizer = new StringTokenizer(groupByToken.toUpperCase(), ",");
                groupByFragments = new ArrayList<HPCCColumnMetaData>();

                while (tokenizer.hasMoreTokens())
                {
                    groupByFragments.add(new HPCCColumnMetaData(tokenizer.nextToken().trim(), 0, java.sql.Types.OTHER));
                }
            }

            String fullTableName = null;

            if (joinPos != -1)
            {
                fullTableName = insql.substring(fromstrpos + 6, joinPos).split("\\s+(?i)inner|(?i)outer\\s*")[0];
            }
            else if (useindexstrpos != -1)
            {
                fullTableName = insql.substring(fromstrpos + 6, useindexstrpos);
            }
            else if (wherePos != -1)
            {
                fullTableName = insql.substring(fromstrpos + 6, wherePos);
            }
            else
            {
                fullTableName = insql.substring(fromstrpos + 6);
            }

            SQLTable queryTable;
            StringTokenizer selTables = new StringTokenizer(fullTableName.trim(), ",");
            while (selTables.hasMoreTokens())
            {
                queryTable = null;

                String splittablefromalias[] = selTables.nextToken().trim().split("\\s+(?i)as(\\s+|$)");
                if (splittablefromalias.length == 1) //Only table name found (no AS keyword)
                {
                    String splittablebyblank[] = splittablefromalias[0].trim().split("\\s+");
                    queryTable = new SQLTable(HPCCJDBCUtils.handleQuotedString(splittablebyblank[0]));
                    if (splittablebyblank.length == 2) //Blank space(s) found, table name and alias detected.
                        queryTable.setAlias(HPCCJDBCUtils.handleQuotedString(splittablebyblank[1]));
                    else if (splittablebyblank.length > 2) //Too many breaks found.
                        throw new SQLException("Invalid SQL: " + splittablefromalias[0]);
                }
                else if (splittablefromalias.length == 2) //Table name and alias found
                {
                    queryTable = new SQLTable(HPCCJDBCUtils.handleQuotedString(splittablefromalias[0]));
                    queryTable.setAlias(HPCCJDBCUtils.handleQuotedString(splittablefromalias[1]));
                }
                else //Multiple 'AS' keywords found?
                    throw new SQLException("Invalid SQL: " + fullTableName);

                sqlTables.add(queryTable);
            }

            if (fromstrpos <= 7)
                throw new SQLException("Invalid SQL: Missing select column(s).");

            String seltoken = insql.substring(7, fromstrpos);

            Matcher matcher = DISTINCTPATTERN.matcher(seltoken);

            if (matcher.matches())
            {
                isSelectDistinct = true;
                seltoken = matcher.group(1).trim();
            }

            StringTokenizer comatokens = new StringTokenizer(seltoken, ",");

            for (int sqlcolpos = 1; comatokens.hasMoreTokens();)
            {
                HPCCColumnMetaData colmetadata = null;
                String colassplit[] = comatokens.nextToken().split("\\s+(?i)as\\s+");
                String col = colassplit[0].trim();

                if (!selectColsContainWildcard && col.contains("*"))
                    selectColsContainWildcard = true;

                if (col.contains("("))
                {
                    int funcparampos = 1;
                    List<HPCCColumnMetaData> funccols = new ArrayList<HPCCColumnMetaData>();

                    String funcname = col.substring(0, col.indexOf('('));
                    ECLFunction func = ECLFunctions.getEclFunction(funcname);

                    if (func != null)
                    {
                        col = col.substring(col.indexOf('(') + 1).trim();

                        if (func.getFunctionType() == FunctionType.CONTENT_MODIFIER)
                        {
                            if (col.contains(")"))
                            {
                                col = col.substring(0, col.indexOf(")")).trim();
                                colmetadata = new HPCCColumnMetaData(col, sqlcolpos++, java.sql.Types.OTHER);
                                colmetadata.setContentModifier(func);
                            }
                            else
                                throw new SQLException("Error while parsing function: " + col);
                        }
                        else
                        {

                            matcher = DISTINCTPATTERN.matcher(col);
                            boolean isDistinctFuncCall = false;
                            if (matcher.matches())
                            {
                                isDistinctFuncCall = true;
                                col = matcher.group(1).trim();
                            }

                            if (col.contains(")"))
                            {
                                col = col.substring(0, col.indexOf(")")).trim();
                                if (col.length() > 0)
                                {
                                    funccols.add(new HPCCColumnMetaData(col, funcparampos++, java.sql.Types.OTHER));
                                }
                            }
                            else
                            {
                                funccols.add(new HPCCColumnMetaData(col, funcparampos++, java.sql.Types.OTHER));
                                while (comatokens.hasMoreTokens())
                                {
                                    col = comatokens.nextToken().trim();
                                    if (col.contains(")"))
                                    {
                                        col = col.substring(0, col.indexOf(")"));
                                        funccols.add(new HPCCColumnMetaData(col, funcparampos++, java.sql.Types.OTHER));
                                        break;
                                    }
                                    funccols.add(new HPCCColumnMetaData(col, funcparampos++, java.sql.Types.OTHER));
                                }
                            }

                            if (ECLFunctions.verifyEclFunction(funcname, funccols))
                                colmetadata = new HPCCColumnMetaData(funcname, sqlcolpos++, funccols);//, func);
                            else
                                throw new SQLException("Function " + funcname + " does not map to ECL as written");

                            colmetadata.setDistinct(isDistinctFuncCall);
                            colmetadata.setSqlType(func.getReturnType().getSqlType());
                        }
                    }
                    else
                        throw new SQLException("ECL Function " + funcname + " is not currently supported");
                }

                if (colmetadata == null)
                    colmetadata = new HPCCColumnMetaData(col, sqlcolpos++, java.sql.Types.OTHER);

                //TODO this has to change
                colmetadata.setTableName(sqlTables.get(0).getName());

                if (colassplit.length > 1)
                    colmetadata.setAlias(HPCCJDBCUtils.handleQuotedString(colassplit[1].trim()));

                selectColumns.add(colmetadata);
            }

            if (useindexstrpos != -1)
            {
                String useindexstr = insql.substring(useindexstrpos + 11);
                int useindexend = useindexstr.indexOf(")");
                if (useindexend < 0)
                    throw new SQLException("Malformed USE INDEX() clause.");
                indexHint = useindexstr.substring(0, useindexend).trim();
                HPCCJDBCUtils.traceoutln(Level.INFO,  "Index hint found: " + indexHint);
            }

            if (sqlTables.size() > 1)
            {
                if (joinPos != -1)
                    throw new SQLException("Implicit and Explicit JOIN not currently supported");

                joinClause = new SQLJoinClause(SQLJoinClause.JoinType.INNER_JOIN);

                for (int i = 1; i < sqlTables.size(); i++)
                    joinClause.addJoinTable(sqlTables.get(i));

                if (wherePos != -1)
                {
                    String strWhere = insql.substring(wherePos + 7);
                    SQLWhereClause onClause = new SQLWhereClause();
                    onClause.parseWhereClause(strWhere);
                    joinClause.setOnClause(onClause);

                    try
                    {
                        joinClause.updateFragments(sqlTables);
                    }
                    catch (Exception e)
                    {
                        throw new SQLException("Invalid field found in implicit Join clause.");
                    }
                }
            }
            else
            {
                if (wherePos != -1)
                {
                    String strWhere = insql.substring(wherePos + 7);
                    whereClause.parseWhereClause(strWhere);

                    insql = insql.substring(0, wherePos);
                }
            }

            if (joinPos != -1)
            {
                int inJoinPos = insqlupcase.lastIndexOf(" INNER JOIN ");

                if (inJoinPos != -1)
                {
                    parseJoinClause(insql.substring(inJoinPos, insql.length()));
                }
                else
                {
                    int outJoinPos = insqlupcase.lastIndexOf(" OUTER JOIN ");

                    if (outJoinPos != -1)
                    {
                        parseJoinClause((insql.substring(outJoinPos, insql.length())));
                    }
                    else
                    {
                        parseJoinClause((insql.substring(joinPos, insql.length())));
                    }
                }
            }

            try
            {
                whereClause.updateFragmentColumnsParent(sqlTables);

                if (havingClause != null)
                    havingClause.updateFragmentColumnsParent(sqlTables);

                assignParameterIndexes();

            }
            catch (Exception e)
            {
                throw new SQLException(e.getMessage());
            }
        }
        else if (insql.matches("^(?i)alter\\s+(.*?)"))
        {
            throw new SQLException("ALTER TABLE statements are not supported.");
        }
        else if (insql.matches("^(?i)drop\\s+(.*?)"))
        {
            throw new SQLException("DROP statements are not supported.");
        }
        else if (insql.matches("^(?i)insert\\s+(.*?)"))
        {
            throw new SQLException("INSERT statements are not supported.");
        }
        else if (insql.matches("^(?i)update\\s+(.*?)"))
        {
            throw new SQLException("UPDATE statements are not supported.");
        }
        else
            throw new SQLException("Invalid SQL found - only supports CALL and/or SELECT statements.");
    }

    private boolean parseHavingClause(String havingConditions) throws SQLException
    {
        //HAVING aggregate_function(column_name) operator value
        try
        {
            havingClause = new SQLWhereClause();

            havingClause.parseWhereClause(havingConditions);
        }
        catch (Exception e)
        {
            throw new SQLException("Error while parsing HAVING clause: " +  e.getLocalizedMessage());
        }

        return false;
    }

    private boolean parseConstantSelect(String sql) throws SQLException
    {
        String sqlUpper = sql.toUpperCase();
        int wherePos = sqlUpper.lastIndexOf(" WHERE ");
        int groupPos = sqlUpper.lastIndexOf(" GROUP BY ");
        int orderPos = sqlUpper.lastIndexOf(" ORDER BY ");
        int limitPos = sqlUpper.lastIndexOf(" LIMIT ");

        if (wherePos > 0 || groupPos > 0 || orderPos > 0)
            return false;
        try
        {
            if (limitPos > 0)
            {
                limit = Integer.valueOf(sqlUpper.substring(limitPos + 6).trim());
                sql = sqlUpper.substring(0, limitPos);
            }
        }
        catch (NumberFormatException ne)
        {
            throw new SQLException("Error near :\'" + sql.substring(limitPos) + "\'");
        }

        // At this point we have select <something>
        StringTokenizer comatokens = new StringTokenizer(sql.substring(6), ",");

        for (int pos = 1; comatokens.hasMoreTokens();)
        {
            String colassplit[] = comatokens.nextToken().split("\\s+(?i)as\\s+");
            String col = colassplit[0].trim();

            HPCCColumnMetaData colmetadata = null;

            if (HPCCJDBCUtils.isLiteralString(col))
            {
                colmetadata = new HPCCColumnMetaData("ConstStr" + pos, pos++, java.sql.Types.VARCHAR);
                colmetadata.setEclType("STRING");
            }
            else if (HPCCJDBCUtils.isNumeric(col))
            {
                colmetadata = new HPCCColumnMetaData("ConstNum" + pos, pos++, java.sql.Types.NUMERIC);
                colmetadata.setEclType("INTEGER");
            }
            else
            {
                throw new SQLException("Invalid SQL detected: " + col);
            }

            colmetadata.setColumnType(ColumnType.CONSTANT);
            colmetadata.setConstantValue(col);

            if (colassplit.length > 1)
                colmetadata.setAlias(colassplit[1]);

            selectColumns.add(colmetadata);
        }
        return true;
    }

    public void parseJoinClause(String joinOnClause) throws SQLException
    {
        if (joinOnClause.length() > 0)
        {
            joinClause = new SQLJoinClause();

            joinClause.parse(joinOnClause);
            sqlTables.add(joinClause.getJoinTable(0));
        }
        else
            throw new SQLException("Error: parsing 'Join' clause.");

        try
        {
            joinClause.updateFragments(sqlTables);
        }
        catch (Exception e)
        {
            throw new SQLException("Invalid field found in Join clause.");
        }
    }

    public int orderByCount()
    {
        return orderByFragments == null ? 0 : orderByFragments.size();
    }

    public boolean hasOrderByColumns()
    {
        return orderByFragments != null && orderByFragments.size() > 0 ? true : false;
    }

    public String getOrderByString()
    {
        return getOrderByString(',');
    }

    public String getOrderByString(char delimiter)
    {
        StringBuilder tmp = new StringBuilder("");
        int orderbycount = orderByFragments.size();
        for (int i = 0; i < orderbycount; i++)
        {
            HPCCColumnMetaData ordercol = orderByFragments.get(i);
            tmp.append((ordercol.isSortAscending() ? "" : "-") + ordercol.getColumnNameOrAlias());
            if (i != orderbycount - 1)
                tmp.append(delimiter);
        }
        return tmp.toString();
    }

    public String getGroupByString()
    {
        return getGroupByString(',');
    }

    public String getGroupByString(char delimiter)
    {
        StringBuilder tmp = new StringBuilder("");

        int groupbycount = groupByFragments.size();
        for (int i = 0; i < groupbycount; i++)
        {
            /* Use column name, not alias b/c grouping is performed before
             * result table is created (which uses aliases)
             * */
            tmp.append(groupByFragments.get(i).getColumnName());
            if (i != groupbycount - 1)
                tmp.append(delimiter);
        }
        return tmp.toString();
    }

    public boolean hasGroupByColumns()
    {
        return groupByFragments != null && groupByFragments.size() > 0 ? true : false;
    }

    public boolean hasLimitBy()
    {
        return limit == -1 ? false : true;
    }

    public String[] getStoredProcInParamVals()
    {
        return procInParamValues;
    }

    public String getStoredProcName()
    {
        return storedProcName;
    }

    public String getTableAlias(int index)
    {
        return sqlTables.get(index).getAlias();
    }

    public SQLType getSqlType()
    {
        return sqlType;
    }

    public int getLimit()
    {
        return limit;
    }

    public String getTableName(int index)
    {
        return sqlTables.get(index).getName();
    }

    public String[] getColumnNames()
    {
        String[] selcols = new String[selectColumns.size()];
        int i = 0;
        for (HPCCColumnMetaData col : selectColumns)
        {
            selcols[i++] = col.getColumnName();
        }

        return selcols;
    }

    public int getParameterizedCount() { return parameterizedCount;}

    public void assignParameterIndexes() throws SQLException
    {
        int paramIndex = 1;
        if (sqlType == SQLType.SELECT)
        {
            if( whereClause != null && whereClause.getExpressionsCount() > 0)
            {
                Iterator<SQLExpression> expressionit = whereClause.getExpressions();
                while (expressionit.hasNext())
                {
                    SQLExpression exp = expressionit.next();
                    paramIndex = exp.setParameterizedNames(paramIndex);
                }
            }
            parameterizedCount = paramIndex - 1;
        }
    }

    public int getWhereClauseExpressionsCount()
    {
        return whereClause.getExpressionsCount();
    }

    public String[] getWhereClauseColumnNames()
    {
        return whereClause.getExpressionColumnNames();
    }

    public Object[] getUniqueWhereClauseColumnNames()
    {
        return whereClause.getUniqueExpressionColumnNames();
    }

    public String getExpressionFromColumnName(String name)
    {
        return whereClause.getExpressionFromColumnName(name);
    }

    public boolean whereClauseContainsKey(String name)
    {
        return whereClause.containsKey(name);
    }

    public String getWhereClauseStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving)
    {
        return whereClause.toStringTranslateSource(map, ignoreMisTranslations, forHaving);
    }

    public String getWhereClauseString()
    {
        return whereClause.toString();
    }

    public boolean whereClauseContainsOrOperator()
    {
        return whereClause.isOrOperatorUsed();
    }

    public List<HPCCColumnMetaData> getSelectColumns()
    {
        return selectColumns;
    }

    private void expandWildCardColumn(HashMap<String, HPCCColumnMetaData> allFields) throws SQLException
    {
        for (int i = 0; i < selectColumns.size(); i++)
        {
            String curColName = selectColumns.get(i).getColumnName();
            if (curColName.contains("*"))
            {
                String nameSplit [] = curColName.split(HPCCJDBCUtils.DOTSEPERATORREGEX);

                if (nameSplit.length <= 0 || nameSplit.length >= 3)
                {
                    throw new SQLException("Invalid column found: " + curColName);
                }
                else
                {
                    String tableName = "";

                    if (nameSplit.length == 2)
                    {
                        tableName = searchForPossibleTableName(nameSplit[0]);

                        if (!nameSplit[1].equals("*"))
                            throw new SQLException("Invalid column found: " + curColName);
                    }
                    else if (!nameSplit[0].equals("*"))
                            throw new SQLException("Invalid column found: " + curColName);

                    selectColumns.remove(i);

                    Iterator<Entry<String, HPCCColumnMetaData>> availablefields = allFields.entrySet().iterator();
                    while (availablefields.hasNext())
                    {
                        HPCCColumnMetaData element = (HPCCColumnMetaData) availablefields.next().getValue();
                        if (tableName.equals("") || tableName.equals(element.getTableName()) )
                        {
                            selectColumns.add(i,element);
                            availablefields.remove();
                        }
                    }
                }
            }
        }
    }

    public boolean areColumnsVerified()
    {
        return columnsVerified;
    }

    public void verifyAndProcessALLSelectColumns(HashMap<String, HPCCColumnMetaData> availableCols) throws SQLException
    {
        if (areColumnsVerified())
            return;

        for (int i = 0; i < selectColumns.size(); i++)
        {
            verifyAndProcessAllColumn(selectColumns.get(i), availableCols);
        }

        if (selectColsContainWildcard)
            expandWildCardColumn(availableCols);

        if (orderByFragments != null)
        {
            for (HPCCColumnMetaData ordercol : orderByFragments)
            {
                verifyColAndDisabiguateName(ordercol);
            }
        }

        if (groupByFragments != null)
        {
            for (HPCCColumnMetaData ordercol : groupByFragments)
            {
                verifyColAndDisabiguateName(ordercol);
            }
        }

        columnsVerified = true;
    }

    public void verifyColAndDisabiguateName(HPCCColumnMetaData column)  throws SQLException
    {
        String fieldName = column.getColumnName();
        String colsplit[] = fieldName.split(HPCCJDBCUtils.DOTSEPERATORREGEX);

        if (colsplit.length == 1)
        {
            fieldName = HPCCJDBCUtils.handleQuotedString(colsplit[0]);
        }
        else if (colsplit.length == 2)
        {
            try
            {
                searchForPossibleTableName(HPCCJDBCUtils.handleQuotedString(colsplit[0]));
            }
            catch (Exception e)
            {
                throw new SQLException("Invalid column found: " + fieldName);
            }

            fieldName = HPCCJDBCUtils.handleQuotedString(colsplit[1]);
        }
        else if (colsplit.length > 2)
            throw new SQLException("Invalid column found: " + fieldName);

        //boolean found = false;
        for (HPCCColumnMetaData selcol : selectColumns)
        {
            String selcolname = selcol.getColumnName();
            String selcolalias = selcol.getAlias();
            if (selcolname.equalsIgnoreCase(fieldName) ||
                (selcolalias != null && selcolalias.equalsIgnoreCase(fieldName)))
            {
                column.setColumnName(selcolname);
                if (selcolalias != null)
                    column.setAlias(selcolalias);
          //      found = true;
                break;
            }
        }
        //if (!found)
        //    throw new SQLException("Invalid column found: " + fieldName);
    }

    public void verifyAndProcessAllColumn(HPCCColumnMetaData column, HashMap<String, HPCCColumnMetaData> availableCols)  throws SQLException
    {
        String fieldName = column.getColumnName();
        //Currently, query table is always 0th index.
        //This will be the default table name.
        String tableName = sqlTables.get(0).getName();

        String colsplit[] = fieldName.split(HPCCJDBCUtils.DOTSEPERATORREGEX);

        if (colsplit.length == 1)
        {
            fieldName = HPCCJDBCUtils.handleQuotedString(colsplit[0]);
        }
        else if (colsplit.length == 2)
        {
            try
            {
                tableName = searchForPossibleTableName(HPCCJDBCUtils.handleQuotedString(colsplit[0]));
            }
            catch (Exception e)
            {
                throw new SQLException("Invalid column found: " + fieldName);
            }

            fieldName = HPCCJDBCUtils.handleQuotedString(colsplit[1]);
        }
        else if (colsplit.length > 2)
            throw new SQLException("Invalid column found: " + fieldName);

        if (!availableCols.containsKey(tableName.toUpperCase() + "." + fieldName.toUpperCase()))
        {
            if (!fieldName.trim().equals("*"))
            {
                if (column.getColumnType() == ColumnType.FUNCTION)
                {
                    ECLFunction func = ECLFunctions.getEclFunction(column.getColumnName());

                    if (column.getAlias() == null)
                        column.setAlias(fieldName + "Out");

                    int highestprecedencecolumn = java.sql.Types.NUMERIC;
                    int highestDecimalDigits = 0;
                    int highestColumnChars = 0;

                    for (HPCCColumnMetaData fncol : column.getFunccols())
                    {
                        verifyAndProcessAllColumn(fncol, availableCols);

                        if (column.getSqlType() == java.sql.Types.NUMERIC && func.returnsSameAsArgumentType())
                        {
                            if (fncol.getDecimalDigits() > highestDecimalDigits)
                                highestDecimalDigits = fncol.getDecimalDigits();

                            if (fncol.getColumnChars() > highestColumnChars)
                                highestColumnChars = fncol.getColumnChars();

                            switch (fncol.getSqlType())
                            {
                                case java.sql.Types.DOUBLE:
                                    highestprecedencecolumn = java.sql.Types.DOUBLE;
                                    break;
                                case java.sql.Types.REAL:
                                    if ( highestprecedencecolumn != java.sql.Types.DOUBLE)
                                        highestprecedencecolumn = java.sql.Types.REAL;
                                    break;
                                case java.sql.Types.DECIMAL:
                                    if ( highestprecedencecolumn != java.sql.Types.REAL)
                                        highestprecedencecolumn = java.sql.Types.DECIMAL;
                                    break;
                                case java.sql.Types.INTEGER:
                                    if ( highestprecedencecolumn != java.sql.Types.REAL &&  highestprecedencecolumn != java.sql.Types.DECIMAL)
                                        highestprecedencecolumn = java.sql.Types.INTEGER;
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (highestprecedencecolumn != java.sql.Types.NUMERIC && func.returnsSameAsArgumentType())
                    {
                        column.setSqlType(highestprecedencecolumn);
                        HPCCJDBCUtils.traceoutln(Level.FINEST,  "Function: " + fieldName.toUpperCase() + " return type: " + highestprecedencecolumn);

                        if (highestprecedencecolumn == java.sql.Types.DECIMAL)
                        {
                            if (highestColumnChars > 0)
                                column.setColumnChars(highestColumnChars);

                            if (highestDecimalDigits > 0)
                                column.setDecimalDigits(highestDecimalDigits);
                        }
                    }

                }
                else if (HPCCJDBCUtils.isLiteralString(fieldName))
                {
                    column.setColumnName("ConstStr" + column.getIndex());
                    column.setEclType("STRING");
                    column.setColumnType(ColumnType.CONSTANT);
                    column.setConstantValue(fieldName);
                }
                else if (HPCCJDBCUtils.isNumeric(fieldName))
                {
                    column.setColumnName("ConstNum" + column.getIndex());
                    column.setEclType("INTEGER");
                    column.setColumnType(ColumnType.CONSTANT);
                    column.setConstantValue(fieldName);
                }
                else
                    throw new SQLException("Invalid column found: " + fieldName);
            }
        }
        else
        {
            column.setTableName(tableName);
            column.setColumnName(fieldName);
            column.setEclType(availableCols.get(tableName.toUpperCase() + "." + fieldName.toUpperCase()).getEclType());
        }
    }

    /**
    * Returns table name if the tablename or alias match Otherwise
    * Throw Exception
    */
    private String searchForPossibleTableName(String searchname) throws SQLException
    {
        for (SQLTable currTable : sqlTables)
        {
            if (searchname.equalsIgnoreCase(currTable.getAlias()) ||
                searchname.equalsIgnoreCase(currTable.getName()))
                return currTable.getName();
        }

        throw new SQLException("Invalid column found");
    }

    public String getIndexHint()
    {
        return indexHint;
    }

    public boolean hasJoinClause()
    {
        return joinClause != null;
    }

    public SQLJoinClause getJoinClause()
    {
        return joinClause;
    }

    public boolean isSelectDistinct()
    {
        return isSelectDistinct;
    }

    public SQLWhereClause getWhereClause()
    {
        return whereClause;
    }

    public boolean hasHavingClause()
    {
        return havingClause != null;
    }

    public SQLWhereClause getHavingClause()
    {
        return havingClause;
    }

    public List<SQLTable> getSQLTables()
    {
        return sqlTables;
    }
}
