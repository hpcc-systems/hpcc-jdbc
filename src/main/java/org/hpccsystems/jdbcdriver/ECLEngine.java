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

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hpccsystems.jdbcdriver.HPCCColumnMetaData.ColumnType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ECLEngine
{
    private HPCCQuery               hpccPublishedQuery = null;
    private String                  expectedDSName = null;
    private NodeList                resultSchema = null;
    private final Properties        hpccConnProps;
    private SQLParser               sqlParser;
    private HPCCDatabaseMetaData    dbMetadata;

    private StringBuilder           eclCode;
    private URL                     hpccRequestUrl;
    private ArrayList<HPCCColumnMetaData> storeProcInParams = null;
    private String[]                    procInParamValues = null;
    private List<HPCCColumnMetaData>    expectedretcolumns = null;

    private static final int            INDEXSCORECRITERIAVARS         = 3;

    private static final int            NumberOfCommonParamInThisIndex_INDEX = 0;
    private static final int            LeftMostKeyIndexPosition_INDEX       = 1;
    private static final int            NumberofColsKeyedInThisIndex_INDEX   = 2;

    private static final int            NumberOfCommonParamInThisIndex_WEIGHT = 5;
    private static final int            LeftMostKeyIndexPosition_WEIGHT       = 3;
    private static final int            NumberofColsKeyedInThisIndex_WEIGHT   = 2;

    private static final String         SELECTOUTPUTNAME = "JDBCSelectQueryResult";

    private DocumentBuilderFactory      dbf = DocumentBuilderFactory.newInstance();

    public ECLEngine(SQLParser parser, HPCCDatabaseMetaData dbmetadata, Properties props)
    {
        this.hpccConnProps = props;
        this.dbMetadata = dbmetadata;
        this.sqlParser = parser;
    }

    public List<HPCCColumnMetaData> getExpectedRetCols()
    {
        return expectedretcolumns;
    }

    private void addFileColsToAvailableCols(DFUFile dfufile, HashMap<String, HPCCColumnMetaData> availablecols)
    {
        Enumeration fields = dfufile.getAllFields();
        while (fields.hasMoreElements())
        {
            HPCCColumnMetaData col = (HPCCColumnMetaData) fields.nextElement();
            availablecols.put(col.getTableName().toUpperCase() + "." + col.getColumnName().toUpperCase(), col);
        }
    }

    public NodeList executeSelectConstant()
    {
        try
        {
            long startTime = System.currentTimeMillis();

            HttpURLConnection conn = dbMetadata.createHPCCESPConnection(hpccRequestUrl);

            return parseDataset(conn.getInputStream(), startTime);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private void generateSelectECL() throws SQLException
    {
        boolean avoidindex = false;

        HashMap<String, String> eclEntities = new HashMap<String, String>();
        HashMap<String, String> eclDSSourceMapping = new HashMap<String, String>();
        HashMap<String, String> translator = null;

        DFUFile indexFileToUse = null;
        int totalWhereClauseExpressions = 0;
        boolean isPayloadIndex = false;
        String indexPosField = null;

        eclCode.append("import std;\n");

        //Currently, query table is always 0th index.
        String queryFileName = HPCCJDBCUtils.handleQuotedString(sqlParser.getTableName(0)).toUpperCase();
        if (!dbMetadata.tableExists("", queryFileName))
            throw new SQLException("Invalid or forbidden table found: " + queryFileName);

        DFUFile hpccQueryFile = dbMetadata.getDFUFile(queryFileName);

        if (!hpccQueryFile.hasFileRecDef())
            throw new SQLException("Cannot query: " + queryFileName
                    + " because it does not contain an ECL record definition.");

        HashMap<String, HPCCColumnMetaData> availablecols = new HashMap<String, HPCCColumnMetaData>();

        addFileColsToAvailableCols(hpccQueryFile, availablecols);

        SQLJoinClause joinclause = sqlParser.getJoinClause();
        if (joinclause != null)
        {
            //TODO is there a way to prevent processing join here, and later on??
            for (int i = 0; i < joinclause.getJoinTablesCount(); i++)
            {
                String joinTableName = joinclause.getJoinTableName(i);
                if (!dbMetadata.tableExists("", joinTableName))
                    throw new SQLException("Invalid or forbidden Join table found: " + joinTableName);

                DFUFile joinTableFile = dbMetadata.getDFUFile(joinTableName);
                if (!joinTableFile.hasFileRecDef())
                    throw new SQLException("Cannot query: "+ joinTableName+" because it does not contain an ECL record definition.");

                addFileColsToAvailableCols(joinTableFile, availablecols);
            }

            avoidindex = true; // will not be using index

            HPCCJDBCUtils.traceoutln(Level.INFO,  "Will not use INDEX files for \"Join\" query.");
        }

        sqlParser.verifyAndProcessALLSelectColumns(availablecols);

        expectedretcolumns = sqlParser.getSelectColumns();

        String tmpindexname = null;
        String indexhint = sqlParser.getIndexHint();

        if (indexhint != null)
        {
            if (indexhint.trim().equals("0"))
            {
                avoidindex = true;
                HPCCJDBCUtils.traceoutln(Level.INFO,  "Will not use any index.");
            }
            if (!avoidindex)
            {
                tmpindexname = findAppropriateIndex(indexhint, expectedretcolumns, sqlParser);
                if (tmpindexname == null)
                    HPCCJDBCUtils.traceoutln(Level.INFO,  "Cannot use USE INDEX hint: " + indexhint);
            }
        } else

        if (hpccQueryFile.hasRelatedIndexes() && !avoidindex)
        {
            tmpindexname = findAppropriateIndex(hpccQueryFile.getRelatedIndexesList(), expectedretcolumns, sqlParser);
        }

        totalWhereClauseExpressions = sqlParser.getWhereClauseExpressionsCount();

        if (tmpindexname != null)
        {
            HPCCJDBCUtils.traceoutln(Level.INFO,  "Generating ECL using index file: " + tmpindexname);
            indexFileToUse = dbMetadata.getDFUFile(tmpindexname);
            indexPosField = indexFileToUse.getIdxFilePosField();

            StringBuilder keyedAndWild = new StringBuilder();
            isPayloadIndex = processIndex(indexFileToUse, keyedAndWild);

            eclEntities.put("KEYEDWILD", keyedAndWild.toString());
            if (isPayloadIndex)
                eclEntities.put("PAYLOADINDEX", "true");

            eclDSSourceMapping.put(queryFileName, "IdxDS");

            StringBuffer idxsetupstr = new StringBuffer();
            idxsetupstr.append("Idx := INDEX(TblDS0, {")
                    .append(indexFileToUse.getKeyedFieldsAsDelmitedString(',', null)).append("}");

            if (indexFileToUse.getNonKeyedColumnsCount() > 0)
                idxsetupstr.append(",{ ")
                            .append(indexFileToUse.getNonKeyedFieldsAsDelmitedString(',', null))
                            .append(" }");

            idxsetupstr.append(",\'~").append(indexFileToUse.getFullyQualifiedName()).append("\');\n");

            eclEntities.put("IndexDef", idxsetupstr.toString());

            idxsetupstr.setLength(0);

            if (isPayloadIndex)
            {
                HPCCJDBCUtils.traceoutln(Level.INFO,  " as PAYLOAD");
                idxsetupstr.append("IdxDS := Idx(").append(keyedAndWild.toString()).append(");\n");
            }
            else
            {
                HPCCJDBCUtils.traceoutln(Level.INFO,  " Not as PAYLOAD");
                idxsetupstr.append("IdxDS := FETCH(TblDS0, Idx( ")
                           .append(keyedAndWild.toString())
                           .append("), RIGHT.")
                           .append(indexFileToUse.getIdxFilePosField())
                           .append(");\n");
            }
            eclEntities.put("IndexRead", idxsetupstr.toString());
        }
        else
            HPCCJDBCUtils.traceoutln(Level.INFO,  "NOT USING INDEX!");

        if (hpccQueryFile.hasFileRecDef())
        {
            if (indexFileToUse != null && indexPosField != null)
                eclCode.append(hpccQueryFile.getFileRecDefwithIndexpos(
                        indexFileToUse.getFieldMetaData(indexPosField), "TblDS0RecDef"));
            else
                eclCode.append(hpccQueryFile.getFileRecDef("TblDS0RecDef"));
            eclCode.append("\n");
        }
        else
            throw new SQLException("Target HPCC file (" + queryFileName + ") does not contain ECL record definition");

        if (!eclDSSourceMapping.containsKey(queryFileName))
            eclDSSourceMapping.put(queryFileName, "TblDS0");

        if (!hpccQueryFile.isKeyFile())
            eclCode.append("TblDS0 := DATASET(\'~").append(hpccQueryFile.getFullyQualifiedName())
                    .append("\', TblDS0RecDef,").append(hpccQueryFile.getFormat()).append(");\n");
        else
        {
            eclCode.append("TblDS0 := INDEX( ");
            eclCode.append('{');
            eclCode.append(hpccQueryFile.getKeyedFieldsAsDelmitedString(',', "TblDS0RecDef"));
            eclCode.append("},{");
            eclCode.append(hpccQueryFile.getNonKeyedFieldsAsDelmitedString(',', "TblDS0RecDef"));
            eclCode.append("},");
            eclCode.append("\'~").append(hpccQueryFile.getFullyQualifiedName()).append("\');\n");
        }

        if (joinclause != null)
        {
            int joinsCount = joinclause.getJoinTablesCount();

            translator = new HashMap<String, String>();
            translator.put(queryFileName, "LEFT");

            /*
             * Each join table triggers a new Join comprised of either the querytable or
             * the previous join, and the current join table.
             *
             * In order to achieve this, the following is performed for each jointable:
             * Define the tables's record definition: TblDSXRecDef := RECORD fields END;
             * Create Dataset based on the table's content:
             *  If the table is not indexed:
             *   TblDSX := DATASET(\'~HPCCFILENAME', TblDSXRecDef, FILEFORMAT)
             *  If the table is indexed:
             *   TblDSX := INDEX({KEYEDFIELDS}, {NONKEYEDFIELDS}, \'~HPCCFILENAME')
             */
            for (int joinTableIndex = 0; joinTableIndex < joinsCount; joinTableIndex++)
            {
                String hpccJoinFileName = HPCCJDBCUtils.handleQuotedString(joinclause
                        .getJoinTableName(joinTableIndex)).toUpperCase();

                if (!dbMetadata.tableExists("", hpccJoinFileName))
                    throw new SQLException("Invalid Join table found: " + hpccJoinFileName);

                DFUFile hpccJoinFile = dbMetadata.getDFUFile(hpccJoinFileName);

                String currntTblDS = "TblDS" + (joinTableIndex+1);
                String currntTblRecDef = currntTblDS + "RecDef";
                String currntJoin = "JndDS" + (joinTableIndex+1);

                if (hpccJoinFile.hasFileRecDef())
                {
                    //Not currently supporting index fetches for join operations
                    // if (indexfiletouse != null && indexposfield != null)
                    // eclcode.append(hpccQueryFile.getFileRecDefwithIndexpos(indexfiletouse.getFieldMetaData(indexposfield),
                    // "TblDS0RecDef"));
                    // else
                    eclCode.append(hpccJoinFile.getFileRecDef("\n" + currntTblRecDef));
                    eclCode.append("\n");
                }
                else
                    throw new SQLException("Target HPCC file (" + hpccJoinFile + ") does not contain ECL record definition");

                eclDSSourceMapping.put(hpccJoinFileName, currntTblDS);

                if (!hpccJoinFile.isKeyFile())
                {
                    eclCode.append(currntTblDS + " := DATASET(\'~")
                            .append(hpccJoinFile.getFullyQualifiedName())
                            .append("\', ")
                            .append(currntTblRecDef)
                            .append(",")
                            .append(hpccJoinFile.getFormat())
                            .append(");\n");
                }
                else
                {
                    eclCode.append(currntTblDS)
                            .append(" := INDEX( ")
                            .append('{')
                            .append(hpccJoinFile.getKeyedFieldsAsDelmitedString(',', currntTblRecDef))
                            .append("},{")
                            .append(hpccJoinFile.getNonKeyedFieldsAsDelmitedString(',', currntTblRecDef))
                            .append("},\'~")
                            .append(hpccJoinFile.getFullyQualifiedName())
                            .append("\');\n");
                }

                eclCode.append("\n").append(currntJoin).append(" := JOIN( ");

                translator.put(hpccJoinFileName, "RIGHT");

                if(joinTableIndex == 0)
                {
                    //First Join, previous DS is TblDS0
                    eclCode.append("TblDS0");
                }
                else
                {
                    //N+1th Join, previous DS is JndDSN
                    eclCode.append("JndDS" + joinTableIndex);
                }

                String translatedAndFilteredOnClause = joinclause.getOnClause().toECLStringTranslateSource(translator,true, false, false, false);

                if (translatedAndFilteredOnClause == null)
                    throw new SQLException("Join condition does not contain proper join condition between tables." + hpccJoinFileName + "and earlier table");

                eclCode.append(", ")
                        .append(currntTblDS)
                        .append(", ")
                        .append(translatedAndFilteredOnClause != null ? translatedAndFilteredOnClause : "TRUE");

                if (totalWhereClauseExpressions > 0)
                {
                    eclCode.append(" AND ").append(sqlParser.getWhereClauseStringTranslateSource(translator, false, false));
                }

                eclCode.append(", ").append(joinclause.getECLTypeStr());

                if (!joinclause.getOnClause().containsEqualityCondition(translator, "LEFT", "RIGHT"))
                {
                    HPCCJDBCUtils.traceoutln(Level.WARNING, "Warning: No Join EQUALITY CONDITION detected!, using ECL ALL option");
                    eclCode.append(", ALL");
                }

                eclCode.append(" );\n");

                //move this file to LEFT for possible next iteration
                translator.put(hpccJoinFileName, "LEFT");

                eclDSSourceMapping.put(hpccJoinFileName, "JndDS"+joinsCount);
            }

            eclDSSourceMapping.put(queryFileName, "JndDS"+joinsCount);
            eclEntities.put("JoinQuery", "1");
        }

        eclEntities.put("SourceDS", eclDSSourceMapping.get(queryFileName));

        if (sqlParser.hasOrderByColumns())
            eclEntities.put("ORDERBY", sqlParser.getOrderByString());
        if (sqlParser.hasGroupByColumns())
            eclEntities.put("GROUPBY", sqlParser.getGroupByString());
        if (sqlParser.hasLimitBy())
            eclEntities.put("LIMIT", Integer.toString(sqlParser.getLimit()));

        if (eclEntities.get("IndexDef") == null)
        {
            if (eclEntities.containsKey("SCALAROUTNAME"))
            {
                eclCode.append("OUTPUT(ScalarOut ,NAMED(\'");
                eclCode.append(eclEntities.get("SCALAROUTNAME"));
                eclCode.append("\'));");
            }
            else
            {
                String latestDS = eclEntities.get("SourceDS");

                //Create filtered DS if there's a where clause, and no join clause,
                //because filtering is applied while performing join.
                if (sqlParser.getWhereClause() != null && !eclEntities.containsKey("JoinQuery"))
                {
                    latestDS += "Filtered";
                    eclCode.append(latestDS).append(" := ");
                    eclCode.append(eclEntities.get("SourceDS"));

                    addFilterClause(eclCode);
                    eclCode.append(";\n");
                }

                // If group by contains HAVING clause, use ECL 'HAVING'
                // function,
                // otherwise group can be done implicitly in table step.
                // since the implicit approach has better performance.
                if (eclEntities.containsKey("GROUPBY") && sqlParser.hasHavingClause())
                {
                    eclCode.append(latestDS).append("Grouped").append(" := GROUP( ");
                    eclCode.append(latestDS);
                    eclCode.append(", ");
                    eclCode.append(eclEntities.get("GROUPBY"));
                    eclCode.append(", ALL);\n");

                    latestDS += "Grouped";

                    if (appendTranslatedHavingClause(eclCode, latestDS))
                        latestDS += "Having";
                }

                createSelectStruct(eclEntities, latestDS);
                eclCode.append(eclEntities.get("SELECTSTRUCT"));

                eclCode.append(latestDS).append("Table").append(" := TABLE( ");
                eclCode.append(latestDS);

                eclCode.append(", SelectStruct ");

                if (eclEntities.containsKey("GROUPBY") && !sqlParser.hasHavingClause())
                {
                    eclCode.append(", ");
                    eclCode.append(eclEntities.get("GROUPBY"));
                }
                eclCode.append(");\n");

                latestDS += "Table";

                if (sqlParser.isSelectDistinct())
                {
                    eclCode.append(latestDS)
                    .append("Deduped := Dedup( ")
                    .append(latestDS)
                    .append(", HASH);\n");
                    latestDS += "Deduped";
                }

                eclCode.append("OUTPUT(CHOOSEN(");
                if (eclEntities.containsKey("ORDERBY"))
                    eclCode.append("SORT( ");

                eclCode.append(latestDS);
                if (eclEntities.containsKey("ORDERBY"))
                {
                    eclCode.append(",");
                    eclCode.append(eclEntities.get("ORDERBY"));
                    eclCode.append(")");
                }
            }
        }
        else
        // use index
        {
            //Not creating a filtered DS because filtering is applied while
            //performing index read/fetch.
            eclCode.append(eclEntities.get("IndexDef"));
            eclCode.append(eclEntities.get("IndexRead"));
            String latestDS = "IdxDS";

            if (eclEntities.containsKey("COUNTDEDUP"))
                eclCode.append(eclEntities.get("COUNTDEDUP"));

            if (eclEntities.containsKey("SCALAROUTNAME"))
            {
                eclCode.append("OUTPUT(ScalarOut ,NAMED(\'");
                eclCode.append(eclEntities.get("SCALAROUTNAME"));
                eclCode.append("\'));\n");
            }
            else
            {
                // If group by contains HAVING clause, use ECL 'HAVING' function,
                // otherwise group can be done implicitly in table step.
                // since the implicit approach has better performance.
                if (eclEntities.containsKey("GROUPBY") && sqlParser.hasHavingClause())
                {
                    eclCode.append(latestDS).append("Grouped").append(" := GROUP( ");
                    eclCode.append(latestDS);
                    eclCode.append(", ");
                    eclCode.append(eclEntities.get("GROUPBY"));
                    eclCode.append(", ALL);\n");

                    latestDS += "Grouped";

                    if (appendTranslatedHavingClause(eclCode, latestDS))
                        latestDS += "Having";
                }

                createSelectStruct(eclEntities, latestDS);

                eclCode.append(eclEntities.get("SELECTSTRUCT"));

                eclCode.append(latestDS)
                .append("Table := TABLE(")
                .append(latestDS)
                .append(", SelectStruct ");

                if (eclEntities.containsKey("GROUPBY") && !sqlParser.hasHavingClause())
                {
                    eclCode.append(", ");
                    eclCode.append(eclEntities.get("GROUPBY"));
                }
                eclCode.append(");\n");
                latestDS += "Table";

                if (sqlParser.isSelectDistinct())
                {
                    eclCode.append(latestDS)
                    .append("Deduped := Dedup( ")
                    .append(latestDS)
                    .append(", HASH);\n");

                    latestDS += "Deduped";
                }

                if (eclEntities.containsKey("ORDERBY"))
                {
                    eclCode.append(latestDS).append("Sorted := SORT( ").append(latestDS).append(", ");
                    eclCode.append(eclEntities.get("ORDERBY"));
                    eclCode.append(");\n");
                    latestDS += "Sorted";
                }

                eclCode.append("OUTPUT(CHOOSEN(");
                eclCode.append(latestDS);
            }
        }

        if (!eclEntities.containsKey("SCALAROUTNAME"))
        {
            eclCode.append(",");
            if (!eclEntities.containsKey("NONSCALAREXPECTED") && !sqlParser.hasGroupByColumns())
                eclCode.append("1");
            else if (eclEntities.containsKey("LIMIT"))
                eclCode.append(eclEntities.get("LIMIT"));
            else
                eclCode.append(hpccConnProps.getProperty("EclResultLimit"));

            eclCode.append("),NAMED(\'")
                    .append(SELECTOUTPUTNAME)
                    .append("\'));");

            expectedDSName = SELECTOUTPUTNAME;
        }
    }

    public void createSelectStruct(HashMap<String, String> eclEntities, String datasource)
    {
        StringBuilder selectStructSB = new StringBuilder("SelectStruct := RECORD\n");

        for (int i = 0; i < expectedretcolumns.size(); i++)
        {
            selectStructSB.append(" ");
            HPCCColumnMetaData col = expectedretcolumns.get(i);

            if (col.getColumnType() == ColumnType.CONSTANT)
            {
                selectStructSB.append(col.getEclType())
                              .append(" ")
                              .append(col.getColumnNameOrAlias())
                              .append(" := ")
                              .append(col.getConstantValue())
                              .append("; ");

                if (i == 0 && expectedretcolumns.size() == 1)
                    eclEntities.put("SCALAROUTNAME", col.getColumnNameOrAlias());
            }
            else if (col.getColumnType() == ColumnType.FUNCTION)
            {
                ECLFunction func = ECLFunctions.getEclFunction(col.getColumnName());
                if (func != null)
                {
                    List<HPCCColumnMetaData> funccols = col.getFunccols();
                    {
                        selectStructSB.append(col.getAlias() + " := ");
                        selectStructSB.append(func.getEclFunction()).append("( ");

                        if (sqlParser.hasGroupByColumns())
                        {
                            selectStructSB.append("GROUP ");
                        }
                        else
                        {
                            if (col.isDistinct())
                            {
                                selectStructSB.append("DEDUP( ");
                                selectStructSB.append(datasource);
                                addFilterClause(selectStructSB);

                                for (int j = 0; j < funccols.size(); j++)
                                {
                                    String paramname = funccols.get(j).getColumnName();
                                    selectStructSB.append(", ");
                                    selectStructSB.append(paramname);
                                }
                                selectStructSB.append(", HASH)");
                            }
                            else
                            {
                                selectStructSB.append(datasource);
                                addFilterClause(selectStructSB);
                            }
                        }

                        if (!(func.getName().equals("COUNT")) && funccols.size() > 0)
                        {
                            String paramname = funccols.get(0).getColumnName();
                            if (!paramname.equals("*") && funccols.get(0).getColumnType() != ColumnType.CONSTANT)
                            {
                                selectStructSB.append(", ");
                                selectStructSB.append(datasource);
                                selectStructSB.append(".");
                                selectStructSB.append(paramname);
                            }
                        }

                        //AS OF community_3.8.6-4 this is causing error:
                        // (0,0): error C3000: assert(!cond) failed - file: /var/jenkins/workspace/<build number>/HPCC-Platform/ecl/hqlcpp/hqlhtcpp.cpp, line XXXXX
                        //Bug reported: https://track.hpccsystems.com/browse/HPCC-8268
                        //Leaving this code out until fix is produced.
                        /*if (eclEntities.containsKey("PAYLOADINDEX")
                                && !sqlParser.hasGroupByColumns()
                                && !col.isDistinct())
                        {
                            selectStructSB.append(", KEYED");
                        }*/

                        selectStructSB.append(" );");
                    }
                }
                else
                    HPCCJDBCUtils.traceoutln(Level.WARNING, "Unrecognized function detected: " + col.getColumnName());
            }
            else
            {
                eclEntities.put("NONSCALAREXPECTED", "TRUE");
                selectStructSB.append(col.getEclType())
                .append(" ")
                .append(col.getColumnNameOrAlias())
                .append(" := ");
                if (col.hasContentModifier())
                    selectStructSB.append(col.getContentModifierStr()).append("( ");

                selectStructSB.append(datasource)
                .append(".")
                .append(col.getColumnName());
                if (col.hasContentModifier())
                    selectStructSB.append(" )");
                selectStructSB.append(";");
            }
            selectStructSB.append("\n");
        }
        selectStructSB.append("END;\n");

        eclEntities.put("SELECTSTRUCT", selectStructSB.toString());
    }

    public void generateECL() throws SQLException
    {
        eclCode = new StringBuilder("");
        hpccRequestUrl = null;

        switch (sqlParser.getSqlType())
        {
            case SELECT:
            {
                generateSelectECL();
                generateSelectURL();

                break;
            }
            case SELECTCONST:
            {
                generateConstSelectECL();
                generateConstSelectURL();

                break;
            }
            case  CALL:
            {
                hpccPublishedQuery =
                        dbMetadata.getHpccQuery(HPCCJDBCUtils.handleQuotedString(sqlParser.getStoredProcName()));

                if (hpccPublishedQuery != null)
                {
                    /*list of published input params for this published query*/
                    storeProcInParams = hpccPublishedQuery.getAllInFields();

                    /*array of values for this query*/
                    procInParamValues = sqlParser.getStoredProcInParamVals();

                    expectedretcolumns = hpccPublishedQuery.getAllNonInFields();

                    expectedDSName = hpccPublishedQuery.getDefaultTableName();

                    int inParamValuesCount = procInParamValues == null ? 0 : procInParamValues.length;

                    if (inParamValuesCount != storeProcInParams.size())
                        //throw new SQLException(hpccPublishedQuery.getName() + " expects "+ storeProcInParams.size() + " input parameters, " + " received " + inParamValuesCount);
                        HPCCJDBCUtils.traceoutln(Level.WARNING,  "WARNING: " + hpccPublishedQuery.getID() + " expects "+ storeProcInParams.size() + " input parameter(s), " + " received " + inParamValuesCount);

                    generateCallURL();

                }
                else
                    throw new SQLException("Invalid Stored Procedure found, verify name and QuerySet: " + sqlParser.getStoredProcName());

                break;
            }
            default:
                throw new SQLException("Invalid SQL type detected!");
        }
    }

    private void generateCallURL() throws SQLException
    {
        String urlString;

        try
        {
            urlString = hpccConnProps.getProperty("WsECLAddress")
                + ":" + hpccConnProps.getProperty("WsECLPort")
                + "/WsEcl/submit/query/" + hpccPublishedQuery.getQuerySet()
                + "/" + hpccPublishedQuery.getName() + "/expanded";

            hpccRequestUrl = HPCCJDBCUtils.makeURL(urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }

        HPCCJDBCUtils.traceoutln(Level.INFO, "HPCC URL created: " + urlString);
    }

    private void generateConstSelectURL() throws SQLException
    {
        String urlString;

        try
        {
            urlString = hpccConnProps.getProperty("WsECLDirectAddress") + ":"
                    + hpccConnProps.getProperty("WsECLDirectPort") + "/EclDirect/RunEcl?Submit";

            if (hpccConnProps.containsKey("TargetCluster"))
            {
                urlString += "&cluster=";
                urlString += hpccConnProps.getProperty("TargetCluster");
            }
            else
                HPCCJDBCUtils.traceoutln(Level.INFO,  "No cluster property found, executing query on EclDirect default cluster");

            urlString += "&eclText=";
            urlString += URLEncoder.encode(eclCode.toString(), "UTF-8");
            hpccRequestUrl = HPCCJDBCUtils.makeURL(urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
        HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCC URL created: " + urlString);
    }

    private void generateConstSelectECL()
    {
        eclCode.append("SelectStruct:=RECORD ");
        expectedretcolumns = sqlParser.getSelectColumns();
        StringBuilder ecloutput = new StringBuilder("OUTPUT(DATASET([{ ");
        for (int i = 1; i <= expectedretcolumns.size(); i++)
        {
            HPCCColumnMetaData col = expectedretcolumns.get(i - 1);
            eclCode.append(col.getEclType()).append(" ").append(col.getColumnName()).append("; ");
            ecloutput.append(col.getConstantValue());
            if (i < expectedretcolumns.size())
                ecloutput.append(", ");
        }
        ecloutput.append("}],SelectStruct), NAMED(\'");
        ecloutput.append(SELECTOUTPUTNAME);
        ecloutput.append("\'));");

        eclCode.append(" END; ");
        eclCode.append(ecloutput.toString());

        expectedDSName = SELECTOUTPUTNAME;
    }

    private void generateSelectURL() throws SQLException
    {
        try
        {
            String urlString = hpccConnProps.getProperty("WsECLDirectAddress") + ":"
                    + hpccConnProps.getProperty("WsECLDirectPort") + "/EclDirect/RunEcl?Submit";

            if (hpccConnProps.containsKey("TargetCluster"))
                urlString += "&cluster=" + hpccConnProps.getProperty("TargetCluster");
            else
                HPCCJDBCUtils.traceoutln(Level.INFO,  "No cluster property found, executing query on EclDirect default cluster");

            hpccRequestUrl = HPCCJDBCUtils.makeURL(urlString);

            HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCC URL created: " + urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public NodeList execute(Map inParameters) throws Exception
    {
        switch (sqlParser.getSqlType())
        {
            case SELECT:
            {
                return executeSelect(inParameters);
            }
            case SELECTCONST:
            {
                return executeSelectConstant();
            }
            case CALL:
            {
                return executeCall(inParameters);
            }
            default:
                break;
        }

        return null;
    }

    public boolean processIndex(DFUFile indexfiletouse, StringBuilder keyedandwild)
    {
        boolean isPayloadIndex =
                containsPayload(indexfiletouse.getAllFieldsProps(), sqlParser.getSelectColumns().iterator());

        Vector<String> keyed = new Vector<String>();
        Vector<String> wild = new Vector<String>();

        // Create keyed and wild string
        Properties keyedcols = indexfiletouse.getKeyedColumns();
        for (int i = 1; i <= keyedcols.size(); i++)
        {
            String keyedcolname = (String) keyedcols.get(i);
            if (sqlParser.whereClauseContainsKey(keyedcolname))

                keyed.add(" " + sqlParser.getExpressionFromColumnName(keyedcolname) + " ");
            else if (keyed.isEmpty())
                wild.add(" " + keyedcolname + " ");
        }

        if (isPayloadIndex)
        {
            if (keyed.size() > 0)
            {
                keyedandwild.append("KEYED( ");
                for (int i = 0; i < keyed.size(); i++)
                {
                    keyedandwild.append(keyed.get(i));
                    if (i < keyed.size() - 1)
                        keyedandwild.append(" AND ");
                }
                keyedandwild.append(" )");
            }
            if (wild.size() > 0)
            {
                // TODO should I bother making sure there's a KEYED entry ?
                for (int i = 0; i < wild.size(); i++)
                {
                    keyedandwild.append(" and WILD( ");
                    keyedandwild.append(wild.get(i));
                    keyedandwild.append(" )");
                }
            }

            keyedandwild.append(" and (").append(sqlParser.getWhereClauseString()).append(" )");
        }
        else
        // non-payload just AND the keyed expressions
        {
            keyedandwild.append("( ");
            keyedandwild.append(sqlParser.getWhereClauseString());
            keyedandwild.append(" )");
        }

        return isPayloadIndex;
    }

    private boolean containsPayload(Properties indexfields, Iterator<HPCCColumnMetaData> selectcolsit)
    {
        while (selectcolsit.hasNext())
        {
            HPCCColumnMetaData currentselectcol = selectcolsit.next();
            String colname = currentselectcol.getColumnName();
            HPCCColumnMetaData.ColumnType type = currentselectcol.getColumnType();
            if (type == ColumnType.FIELD && !indexfields.containsKey(colname.toUpperCase()))
                return false;
            else if (type == ColumnType.FUNCTION  && !containsPayload(indexfields, currentselectcol.getFunccols().iterator()))
                return false;
        }
        return true;
    }

    public NodeList executeSelect(Map inParameters)
    {
        int responseCode = -1;

        try
        {
            StringBuilder sb = new StringBuilder();

            sb.append("&eclText=\n");

            int expectedParamCount = sqlParser.getParameterizedCount();
            if (expectedParamCount > 0 && inParameters != null)
            {
                if (expectedParamCount <= inParameters.size())
                {
                    for (int paramIndex = 1; paramIndex <= inParameters.size(); paramIndex++)
                    {
                        //TODO the type has to be better inferred/determined.
                        String value = (String) inParameters.get(paramIndex);
                        if (HPCCJDBCUtils.isNumeric(value))
                            sb.append("INTEGER ");
                        else
                            sb.append("STRING ");

                        sb.append(SQLParser.parameterizedPrefix).append(paramIndex).append(" := ").append(value).append(";\n");
                    }
                }
                else
                    throw new Exception("Insufficient number of parameters provided");
            }

            sb.append(eclCode.toString());
            sb.append("\n");

            long startTime = System.currentTimeMillis();

            HttpURLConnection conn = dbMetadata.createHPCCESPConnection(hpccRequestUrl);

            HPCCJDBCUtils.traceoutln(Level.INFO,  "Executing ECL: " + sb);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(sb.toString());
            wr.flush();

            responseCode = conn.getResponseCode();

            return parseDataset(conn.getInputStream(), startTime);
        }
        catch (Exception e)
        {
            if (responseCode != 200)
            {
                throw new RuntimeException("HTTP Connection Response code: " + responseCode
                        + "\nVerify access to WsECLDirect: " + hpccRequestUrl, e);
            }
            else
                throw new RuntimeException(e);
        }
    }

    private void addFilterClause(StringBuilder sb)
    {
        String whereclause = sqlParser.getWhereClauseString();
        if (whereclause != null && whereclause.length() > 0)
        {
            sb.append("( ");
            sb.append(whereclause);
            sb.append(" )");
        }
    }

    private boolean appendTranslatedHavingClause(StringBuilder sb, String latesDSName)
    {
        if (sqlParser.hasHavingClause())
        {
            HashMap<String, String> translator = new HashMap<String, String>();
            List<SQLTable> sqltables = sqlParser.getSQLTables();
            for(SQLTable table : sqltables)
            {
                translator.put(table.getName().toUpperCase(), "LEFT");
            }

            String havingclause = sqlParser.getHavingClause().toECLStringTranslateSource(translator, false, true, false, false);

            if (havingclause.length() > 0)
            {
                sb.append(latesDSName).append("Having").append(" := HAVING( ");
                sb.append(latesDSName);
                sb.append(", ");
                sb.append(havingclause);
                sb.append(" );\n");

                return true;
            }
        }

        return false;
    }

    public NodeList executeCall( Map inParameters)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            sb.append(URLEncoder.encode("submit_type_=xml", "UTF-8"));
            sb.append("&").append(URLEncoder.encode("S1=Submit", "UTF-8"));

            if (procInParamValues != null)
            {
                for (int columindex = 0, parameterindex = 0; columindex < procInParamValues.length && columindex < storeProcInParams.size(); columindex++)
                {
                    String key = storeProcInParams.get(columindex).getColumnName();
                    String value = procInParamValues[columindex];

                    if (HPCCJDBCUtils.isParameterizedStr(value))
                    {
                        if (inParameters != null && parameterindex <= inParameters.size())
                        {
                            value = (String) inParameters.get(parameterindex + 1);
                            if (value == null)
                                throw new SQLException("Could not bind parameter");
                            parameterindex++;
                        }
                        else
                            throw new SQLException("Detected empty input parameter list");
                    }
                    sb.append("&").append(key).append("=").append(value);
                }
            }

            long startTime = System.currentTimeMillis();

            HttpURLConnection conn = dbMetadata.createHPCCESPConnection(hpccRequestUrl);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(sb.toString());
            wr.flush();

            HPCCJDBCUtils.traceoutln(Level.INFO,  "Executing: " + hpccRequestUrl + " : " + sb.toString());

            return parseDataset(conn.getInputStream(), startTime);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public NodeList parseDataset(InputStream xml, long startTime) throws Exception
    {
        NodeList rowList = null;

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document dom = db.parse(xml);

        long elapsedTime = System.currentTimeMillis() - startTime;

        HPCCJDBCUtils.traceoutln(Level.INFO, "Total elapsed http request/response time in milliseconds: " + elapsedTime);

        Element docElement = dom.getDocumentElement();

        NodeList dsList = docElement.getElementsByTagName("Dataset");

        HPCCJDBCUtils.traceoutln(Level.INFO, "Parsing results...");

        int dsCount = 0;
        if (dsList != null && (dsCount = dsList.getLength()) > 0)
        {
            HPCCJDBCUtils.traceoutln(Level.INFO, "Results datsets found: " + dsList.getLength());

            // The dataset element is encapsulated within a Result element
            // need to fetch appropriate resulst dataset

            for (int i = 0; i < dsCount; i++)
            {
                Element ds = (Element) dsList.item(i);
                String currentdatsetname = ds.getAttribute("name");
                if (expectedDSName == null || expectedDSName.length() == 0
                        || currentdatsetname.equalsIgnoreCase(expectedDSName))
                {
                    rowList = ds.getElementsByTagName("Row");
                    break;
                }
            }
        }
        else if (docElement.getElementsByTagName("Exception").getLength() > 0)
        {
            NodeList exceptionlist = docElement.getElementsByTagName("Exception");

            if (exceptionlist.getLength() > 0)
            {
                Exception resexception = null;
                NodeList currexceptionelements = exceptionlist.item(0).getChildNodes();

                for (int j = 0; j < currexceptionelements.getLength(); j++)
                {
                    Node exceptionelement = currexceptionelements.item(j);
                    if (exceptionelement.getNodeName().equals("Message"))
                    {
                        resexception = new Exception("HPCCJDBC: Error in response: \'"
                                + exceptionelement.getTextContent() + "\'");
                    }
                }
                if (dsList == null || dsList.getLength() <= 0)
                    throw resexception;
            }
        }
        else
        {
            // The root element is itself the Dataset element
            if (dsCount == 0)
            {
                rowList = docElement.getElementsByTagName("Row");
            }
        }
        HPCCJDBCUtils.traceoutln(Level.INFO,  "Finished Parsing results.");

        return rowList;
    }

    public boolean hasResultSchema()
    {
        return (this.resultSchema != null && this.resultSchema.getLength() > 0);
    }

    public void setResultschema(NodeList resultschema)
    {
        this.resultSchema = resultschema;

        if (this.resultSchema != null && this.resultSchema.getLength() > 0)
        {
            HPCCJDBCUtils.traceoutln(Level.INFO,  "contains resultschema");
        }
    }

    public NodeList getResultschema()
    {
        return resultSchema;
    }

    public String findAppropriateIndex(String index, List<HPCCColumnMetaData> expectedretcolumns, SQLParser parser)
    {
        List<String> indexhint = new ArrayList<String>();
        indexhint.add(index);
        return findAppropriateIndex(indexhint, expectedretcolumns, parser);
    }

    public String findAppropriateIndex(List<String> relindexes, List<HPCCColumnMetaData> expectedretcolumns, SQLParser parser)
    {
        String indextouse = null;
        List<String> sqlqueryparamnames = new ArrayList<String>();
        parser.getUniqueWhereClauseColumnNames(sqlqueryparamnames);
        if (sqlqueryparamnames == null || sqlqueryparamnames.size() <= 0)
            return indextouse;

        int totalparamcount = parser.getWhereClauseExpressionsCount();
        /*[ FieldsInIndexCount ][LeftMostKeyIndex][ColsKeyedcount]*/
        int indexscore[][] = new int[relindexes.size()][INDEXSCORECRITERIAVARS];
        int highscore = Integer.MIN_VALUE;
        boolean payloadIdxWithAtLeast1KeyedFieldFound = false;
        for (int indexcounter = 0; indexcounter < relindexes.size(); indexcounter++)
        {
            String indexname = relindexes.get(indexcounter);
            DFUFile indexfile = dbMetadata.getDFUFile(indexname);
            if (indexfile != null && indexfile.isKeyFile() && indexfile.hasValidIdxFilePosField())
            {
                for (int j = 0; j < expectedretcolumns.size(); j++)
                {
                    if (indexfile.containsField(expectedretcolumns.get(j), true))
                        ++indexscore[indexcounter][NumberOfCommonParamInThisIndex_INDEX];
                }
                if (payloadIdxWithAtLeast1KeyedFieldFound
                        && indexscore[indexcounter][NumberOfCommonParamInThisIndex_INDEX] == 0)
                    break; // Don't bother with this index
                int localleftmostindex = Integer.MAX_VALUE;

                Properties KeyColumns = indexfile.getKeyedColumns();
                if (KeyColumns != null)
                {
                    for (String currentparam : sqlqueryparamnames)
                    {
                        if (KeyColumns.contains(currentparam))
                        {
                            ++indexscore[indexcounter][NumberofColsKeyedInThisIndex_INDEX];
                            int paramindex = indexfile.getKeyColumnIndex(currentparam);
                            if (localleftmostindex > paramindex)
                                localleftmostindex = paramindex;
                        }
                    }
                    indexscore[indexcounter][LeftMostKeyIndexPosition_INDEX] = localleftmostindex;
                }
                if (indexscore[indexcounter][NumberOfCommonParamInThisIndex_INDEX] == expectedretcolumns.size()
                        && indexscore[indexcounter][NumberofColsKeyedInThisIndex_INDEX] > 0
                        && (!parser.whereClauseContainsOrOperator()))
                    payloadIdxWithAtLeast1KeyedFieldFound = true; // during scoring, give this priority
            }
        }

        for (int i = 0; i < relindexes.size(); i++)
        {
            if (indexscore[i][NumberofColsKeyedInThisIndex_INDEX] == 0) // does one imply the other?
                continue; // not good enough
            if (payloadIdxWithAtLeast1KeyedFieldFound
                    && indexscore[i][NumberOfCommonParamInThisIndex_INDEX] < expectedretcolumns.size())
                continue; // not good enough
            if (indexscore[i][NumberofColsKeyedInThisIndex_INDEX] < totalparamcount
                    && parser.whereClauseContainsOrOperator())
                continue; // not so sure about this rule.

            int localscore =
                    ((indexscore[i][NumberOfCommonParamInThisIndex_INDEX] / expectedretcolumns.size()) * NumberOfCommonParamInThisIndex_WEIGHT)
                    - (((indexscore[i][LeftMostKeyIndexPosition_INDEX] / totalparamcount) - 1) * LeftMostKeyIndexPosition_WEIGHT)
                    + ((indexscore[i][NumberofColsKeyedInThisIndex_INDEX]) * NumberofColsKeyedInThisIndex_WEIGHT);

            if (highscore < localscore)
            {
                highscore = localscore;
                indextouse = relindexes.get(i);
            }
        }
        return indextouse;
    }
}
