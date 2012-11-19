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
import java.util.List;

import org.hpccsystems.jdbcdriver.SQLExpression.ExpressionType;
import org.hpccsystems.jdbcdriver.SQLFragment.FragmentType;

public class SQLWhereClause
{
    private List<SQLExpression> expressions;
    private List<String>        expressionUniqueColumnNames;
    private int                 expressionsCount;
    private int                 operatorsCount;
    private boolean             orOperatorUsed;

    public final static SQLExpression andOperatorExp = new SQLExpression(SQLOperator.and);
    public final static SQLExpression orOperatorExp = new SQLExpression(SQLOperator.or);

    private final static String otherThanQuote = " [^\'] ";
    private final static String quotedString = String.format(" \' %s* \' ", otherThanQuote);

    private final static String andregex =
            "(?x) "+                    // enable comments, ignore white spaces
            "\\s+(?i)and\\s+"+          // match an isolated, case insensitive AND
            "(?="+                      // start positive look ahead
            "("+                        //   start group 1
            otherThanQuote + "*" +      //     match 'otherThanQuote' zero or more times
            quotedString +              //     match 'quotedString'
            ")*"+                       //   end group 1 and repeat it zero or more times
            otherThanQuote + "*" +      //   match 'otherThanQuote'
            "$"+                        // match the end of the string
            ")";                        // stop positive look ahead

    private final static String orregex =
            "(?x) "+                    // enable comments, ignore white spaces
            "\\s+(?i)or\\s+"+           // match an isolated, case insensitive OR
            "(?="+                      // start positive look ahead
            "("+                        //   start group 1
            otherThanQuote +"*"+        //     match 'otherThanQuote' zero or more times
            quotedString +              //     match 'quotedString'
            ")*"+                       //   end group 1 and repeat it zero or more times
            otherThanQuote +"*"+        //   match 'otherThanQuote'
            "$"+                        // match the end of the string
            ")";                        // stop positive look ahead

    public SQLWhereClause()
    {
        expressions = new ArrayList<SQLExpression>();
        expressionUniqueColumnNames = new ArrayList<String>();
        expressionsCount = 0;
        operatorsCount = 0;
        orOperatorUsed = false;
    }

    public void addExpression(SQLExpression expression)
    {
        expressions.add(expression);
        if (expression.getExpressionType() == ExpressionType.LOGICAL_EXPRESSION)
        {
            expressionsCount++;

            if (expression.getPrefixType() == FragmentType.FIELD || expression.getPrefixType() == FragmentType.FIELD_CONTENT_MODIFIER)
            {
                if (!expressionUniqueColumnNames.contains(expression.getPrefixValue()))
                    expressionUniqueColumnNames.add(expression.getPrefixValue());
            }

            if (expression.getPostfixType() == FragmentType.FIELD || expression.getPostfixType() == FragmentType.FIELD_CONTENT_MODIFIER)
            {
                if (!expressionUniqueColumnNames.contains(expression.getPostfixValue()))
                    expressionUniqueColumnNames.add(expression.getPostfixValue());
            }
        }
        else
        {
            operatorsCount++;
            if (expression.getOperator().getValue().equals(SQLOperator.or))
                orOperatorUsed = true;
        }
    }

    public Iterator<SQLExpression> getExpressions()
    {
        return expressions.iterator();
    }

    public int getExpressionsCount()
    {
        return expressionsCount;
    }

    public int getOperatorsCount()
    {
        return operatorsCount;
    }

    @Override
    public String toString()
    {
        String clause = new String("");
        for (SQLExpression exp : expressions)
        {
            clause += exp.toString();
        }
        return clause;
    }

    public String fullToString()
    {
        String clause = new String("");
        for (SQLExpression exp : expressions)
        {
            clause += exp.fullToString();
        }
        return clause;
    }

    public String toStringTranslateSource(HashMap<String, String> map)
    {
        String clause = new String("");
        for (SQLExpression exp : expressions)
        {
            clause += exp.toStringTranslateSource(map);
        }
        return clause;
    }

    public String[] getExpressionColumnNames()
    {
        String[] colnames = new String[getExpressionsCount()];

        int i = 0;
        for (SQLExpression exp : expressions)
        {
            if (exp.getExpressionType() == ExpressionType.LOGICAL_EXPRESSION)
            {
                if (exp.getPrefixType() == FragmentType.FIELD || exp.getPrefixType() == FragmentType.FIELD_CONTENT_MODIFIER)
                    colnames[i++] = exp.getPrefixValue();
                if (exp.getPostfixType() == FragmentType.FIELD || exp.getPostfixType() == FragmentType.FIELD_CONTENT_MODIFIER)
                    colnames[i++] = exp.getPostfixValue();
            }
        }

        return colnames;
    }

    public String getExpressionFromColumnName(String colname)
    {
        String expstr = "";
        for (SQLExpression exp : expressions)
        {
            if (exp.getExpressionType() == ExpressionType.LOGICAL_EXPRESSION)
            {

                if(exp.getPrefixType() == FragmentType.FIELD && exp.getPrefixValue().equals(colname) ||
                   exp.getPostfixType() == FragmentType.FIELD && exp.getPostfixValue().equals(colname))
                {
                    if (expstr.length() != 0)
                        expstr += " AND ";
                    expstr += exp.toString();
                }
            }
        }

        return expstr;
    }

    public boolean containsKey(String colname)
    {
        if (expressionUniqueColumnNames.contains(colname))
        {
            for (SQLExpression exp : expressions)
            {
                if(exp.containsKey(colname))
                    return true;
            }
        }

        return false;
    }

    public Object[] getUniqueExpressionColumnNames()
    {
        return expressionUniqueColumnNames.toArray();
    }

    public boolean isOrOperatorUsed()
    {
        return orOperatorUsed;
    }

    public void updateFragmentColumnsParent(List<SQLTable> sqlTables) throws Exception
    {
        for (SQLExpression exp : expressions)
            exp.updateFragmentTables(sqlTables);
    }

   /*
    * Temporary Patch until full logic parser is incorporated
    * Removes surrounding parens, takes into consideration
    * possible inner grouping parens.
    */
    private String handleGroupParens(String group)
    {
        String unencapsulated = group.trim();
        //Encapsulated in parens?
        if (group.charAt(0) == '(' && group.charAt(group.length() - 1) == ')')
        {
            int secopen = group.indexOf('(', 1);
            int firstclose = group.indexOf(')', 1);
            if (secopen < firstclose)
            {
                int sectolastclose = group.substring(0, group.length()-1).lastIndexOf(')');
                int lastopen = group.lastIndexOf('(');
                if (sectolastclose == -1 || sectolastclose > lastopen )
                    unencapsulated = HPCCJDBCUtils.getParenContents(group);
            }
        }
        return unencapsulated;
    }

    public void parseWhereClause(String whereclause) throws SQLException
    {
       whereclause = handleGroupParens(whereclause);

        String[] splitedwhereands = whereclause.split(andregex);

        for (int i = 0; i < splitedwhereands.length; i++)
        {
            splitedwhereands[i] = handleGroupParens(splitedwhereands[i]);

            String splitedwhereandors[] = splitedwhereands[i].split(orregex);
            for (int y = 0; y < splitedwhereandors.length; y++)
            {
                splitedwhereandors[y] = handleGroupParens(splitedwhereandors[y]);

                SQLExpression exp = new SQLExpression( ExpressionType.LOGICAL_EXPRESSION);

                exp.ParseExpression(splitedwhereandors[y]);

                addExpression(exp);

                if (y < splitedwhereandors.length - 1)
                    addExpression(orOperatorExp);
            }

            if (i < splitedwhereands.length - 1)
                addExpression(andOperatorExp);
        }
    }
}
