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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
    private String[]                        procInParamValues = null;
    private List<HPCCColumnMetaData> expectedretcolumns = null;

    private static final int            INDEXSCORECRITERIAVARS         = 3;

    private static final int            NumberOfCommonParamInThisIndex_INDEX = 0;
    private static final int            LeftMostKeyIndexPosition_INDEX       = 1;
    private static final int            NumberofColsKeyedInThisIndex_INDEX   = 2;

    private static final int            NumberOfCommonParamInThisIndex_WEIGHT = 5;
    private static final int            LeftMostKeyIndexPosition_WEIGHT       = 3;
    private static final int            NumberofColsKeyedInThisIndex_WEIGHT   = 2;

    private static final String         SELECTOUTPUTNAME = "JDBCSelectQueryResult";

    public ECLEngine(SQLParser parser, HPCCDatabaseMetaData dbmetadata, Properties props)
    {
        this.hpccConnProps = props;
        this.dbMetadata = dbmetadata;
        this.sqlParser = parser;
    }

    public List<HPCCColumnMetaData> getExpectedRetCols ()
    {
        return expectedretcolumns;
    }

    private void addFileColsToAvailableCols(DFUFile dfufile, HashMap<String, HPCCColumnMetaData> availablecols)
    {
        Enumeration fields = dfufile.getAllFields();
        while (fields.hasMoreElements())
        {
            HPCCColumnMetaData col = (HPCCColumnMetaData) fields.nextElement();
            availablecols.put(col.getTableName() + "." + col.getColumnName(), col);
        }
    }

    public ArrayList executeSelectConstant()
    {
        try
        {
            long startTime = System.currentTimeMillis();

            HttpURLConnection conn = dbMetadata.createHPCCESPConnection(hpccRequestUrl);

            return parse(conn.getInputStream(), startTime);
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

        DFUFile indexFileToUse = null;
        int totalParamCount = 0;
        boolean isPayloadIndex = false;
        String indexPosField = null;

        //Currently, query table is always 0th index.
        String queryFileName = HPCCJDBCUtils.handleQuotedString(sqlParser.getTableName(0));
        if (!dbMetadata.tableExists("", queryFileName))
            throw new SQLException("Invalid table found: " + queryFileName);

        DFUFile hpccQueryFile = dbMetadata.getDFUFile(queryFileName);

        if (!hpccQueryFile.hasFileRecDef())
            throw new SQLException("Cannot query: " + queryFileName
                    + " because it does not contain an ECL record definition.");

        HashMap<String, HPCCColumnMetaData> availablecols = new HashMap<String, HPCCColumnMetaData>();

        addFileColsToAvailableCols(hpccQueryFile, availablecols);

        if (sqlParser.hasJoinClause())
        {
            String joinTableName = sqlParser.getJoinClause().getJoinTableName();
            if (!dbMetadata.tableExists("", joinTableName))
                throw new SQLException("Invalid Join table found: " + joinTableName);

            DFUFile joinTableFile = dbMetadata.getDFUFile(joinTableName);
            if (!hpccQueryFile.hasFileRecDef())
                throw new SQLException("Cannot query: " + joinTableName
                        + " because it does not contain an ECL record definition.");

            addFileColsToAvailableCols(joinTableFile, availablecols);

            avoidindex = true; // will not be using index
            System.out.println("Will not use INDEX files for \"Join\" query.");
        }

        sqlParser.verifyAndProcessALLSelectColumns(availablecols );

        expectedretcolumns = sqlParser.getSelectColumns();

        String tmpindexname = null;
        String indexhint = sqlParser.getIndexHint();

        if (indexhint != null)
        {
            if (indexhint.trim().equals("0"))
            {
                avoidindex = true;
                System.out.println("Will not use any index.");
            }
            if (!avoidindex)
            {
                tmpindexname = findAppropriateIndex(indexhint, expectedretcolumns, sqlParser);
                if (tmpindexname == null)
                    System.out.println("Cannot use USE INDEX hint: " + indexhint);
            }
        } else

        if (hpccQueryFile.hasRelatedIndexes() && !avoidindex)
        {
            tmpindexname = findAppropriateIndex(hpccQueryFile.getRelatedIndexesList(), expectedretcolumns, sqlParser);
        }

        totalParamCount = sqlParser.getWhereClauseExpressionsCount();

        eclEntities.put("PARAMCOUNT", Integer.toString(totalParamCount));

        if (tmpindexname != null)
        {
            System.out.print("Generating ECL using index file: " + tmpindexname);
            indexFileToUse = dbMetadata.getDFUFile(tmpindexname);
            indexPosField = indexFileToUse.getIdxFilePosField();

            StringBuilder keyedAndWild = new StringBuilder();
            isPayloadIndex = processIndex(indexFileToUse, keyedAndWild);

            eclEntities.put("KEYEDWILD", keyedAndWild.toString());
            if (isPayloadIndex)
                eclEntities.put("PAYLOADINDEX", "true");

            eclDSSourceMapping.put(queryFileName, "IdxDS");

            StringBuffer idxsetupstr = new StringBuffer();
            idxsetupstr.append("Idx := INDEX(Tbl1DS, {")
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
                System.out.println(" as PAYLOAD");
                idxsetupstr.append("IdxDS := Idx(").append(keyedAndWild.toString()).append(");\n");
            }
            else
            {
                System.out.println(" Not as PAYLOAD");
                idxsetupstr.append("IdxDS := FETCH(Tbl1DS, Idx( ").append(keyedAndWild.toString())
                        .append("), RIGHT.").append(indexFileToUse.getIdxFilePosField()).append(");\n");
            }
            eclEntities.put("IndexRead", idxsetupstr.toString());

        }
        else
            System.out.println("NOT USING INDEX!");

        if (hpccQueryFile.hasFileRecDef())
        {
            if (indexFileToUse != null && indexPosField != null)
                eclCode.append(hpccQueryFile.getFileRecDefwithIndexpos(
                        indexFileToUse.getFieldMetaData(indexPosField), "Tbl1RecDef"));
            else
                eclCode.append(hpccQueryFile.getFileRecDef("Tbl1RecDef"));
            eclCode.append("\n");
        }
        else
            throw new SQLException("Target HPCC file (" + queryFileName
                    + ") does not contain ECL record definition");

        if (!eclDSSourceMapping.containsKey(queryFileName))
            eclDSSourceMapping.put(queryFileName, "Tbl1DS");

        if (!hpccQueryFile.isKeyFile())
            eclCode.append("Tbl1DS := DATASET(\'~").append(hpccQueryFile.getFullyQualifiedName())
                    .append("\', Tbl1RecDef,").append(hpccQueryFile.getFormat()).append("); ");
        else
        {
            eclCode.append("Tbl1DS := INDEX( ");
            eclCode.append('{');
            eclCode.append(hpccQueryFile.getKeyedFieldsAsDelmitedString(',', "Tbl1RecDef"));
            eclCode.append("},{");
            eclCode.append(hpccQueryFile.getNonKeyedFieldsAsDelmitedString(',', "Tbl1RecDef"));
            eclCode.append("},");
            eclCode.append("\'~").append(hpccQueryFile.getFullyQualifiedName()).append("\');");
        }

        if (sqlParser.hasJoinClause())
        {
            String hpccJoinFileName = HPCCJDBCUtils.handleQuotedString(sqlParser.getJoinClause()
                    .getJoinTableName());

            if (!dbMetadata.tableExists("", hpccJoinFileName))
                throw new SQLException("Invalid Join table found: " + hpccJoinFileName);

            DFUFile hpccJoinFile = dbMetadata.getDFUFile(hpccJoinFileName);

            if (hpccJoinFile.hasFileRecDef())
            {
                // if (indexfiletouse != null && indexposfield != null)
                // eclcode.append(hpccQueryFile.getFileRecDefwithIndexpos(indexfiletouse.getFieldMetaData(indexposfield),
                // "Tbl1RecDef"));
                // else
                eclCode.append(hpccJoinFile.getFileRecDef("\nTbl2RecDef"));
                eclCode.append("\n");
            }
            else
                throw new SQLException("Target HPCC file (" + hpccJoinFile
                        + ") does not contain ECL record definition");

            eclDSSourceMapping.put(hpccJoinFile.getFullyQualifiedName(), "Tbl2DS");

            if (!hpccJoinFile.isKeyFile())
                eclCode.append("Tbl2DS := DATASET(\'~").append(hpccJoinFile.getFullyQualifiedName())
                        .append("\', Tbl2RecDef,").append(hpccJoinFile.getFormat()).append("); ");
            else
            {
                eclCode.append("Tbl2DS := INDEX( ");
                eclCode.append('{');
                eclCode.append(hpccJoinFile.getKeyedFieldsAsDelmitedString(',', "Tbl2RecDef"));
                eclCode.append("},{");
                eclCode.append(hpccJoinFile.getNonKeyedFieldsAsDelmitedString(',', "Tbl2RecDef"));
                eclCode.append("},");
                eclCode.append("\'~").append(hpccJoinFile.getFullyQualifiedName()).append("\');");
            }

            HashMap<String, String> translator = new HashMap<String, String>(2);

            translator.put(queryFileName, "LEFT");
            translator.put(hpccJoinFileName, "RIGHT");

            eclCode.append("\n").append("JndDS := JOIN(").append(" Tbl1DS").append(", Tbl2DS").append(", ")
                    .append(sqlParser.getJoinClause().getOnClause().toStringTranslateSource(translator));

            if (totalParamCount > 0)
                eclCode.append(" AND ").append(sqlParser.getWhereClauseStringTranslateSource(translator));
            eclCode.append(", ").append(sqlParser.getJoinClause().getECLTypeStr()).append(" );\n");

            eclDSSourceMapping.put(queryFileName, "JndDS");
            eclDSSourceMapping.put(hpccJoinFileName, "JndDS");

            eclEntities.put("JoinQuery", "1");
        }

        eclEntities.put("SourceDS", eclDSSourceMapping.get(queryFileName));

        StringBuilder selectStructSB = new StringBuilder("SelectStruct := RECORD\n ");

        for (int i = 0; i < expectedretcolumns.size(); i++)
        {
            HPCCColumnMetaData col = expectedretcolumns.get(i);

            String datasource = eclDSSourceMapping.get(col.getTableName());

            if (col.getColumnType() == HPCCColumnMetaData.COLUMN_TYPE_CONSTANT)
            {
                selectStructSB.append(col.getEclType())
                              .append(" ")
                              .append(col.getColumnName())
                              .append(" := ")
                              .append(col.getConstantValue())
                              .append("; ");

                if (i == 0 && expectedretcolumns.size() == 1)
                    eclEntities.put("SCALAROUTNAME", col.getColumnName());
            }

            else if (col.getColumnType() == HPCCColumnMetaData.COLUMN_TYPE_FNCTION)
            {
                if (col.getColumnName().equalsIgnoreCase("COUNT"))
                {
                    eclEntities.put("COUNTFN", "TRUE");
                    selectStructSB.append(col.getAlias() + " := ");
                    if (sqlParser.hasGroupByColumns())
                    {
                        selectStructSB.append(col.getColumnName().toUpperCase()).append("( GROUP");
                        List<HPCCColumnMetaData> funccols = col.getFunccols();

                        if (funccols.size() > 0)
                        {
                            String paramname = funccols.get(0).getColumnName();
                            if (!paramname.equals("*")
                                    && funccols.get(0).getColumnType() != HPCCColumnMetaData.COLUMN_TYPE_CONSTANT)
                            {
                                selectStructSB.append(", ");
                                selectStructSB.append(datasource);
                                selectStructSB.append(".");
                                selectStructSB.append(paramname);
                                selectStructSB.append("<> \'\'");
                            }
                        }
                        selectStructSB.append(" );");
                    }
                    else
                    {
                        selectStructSB.append(" ScalarOut;");
                        if (expectedretcolumns.size() == 1)
                            eclEntities.put("SCALAROUTNAME", col.getColumnName());
                    }

                    col.setSqlType(java.sql.Types.NUMERIC);
                }
                else if (col.getColumnName().equalsIgnoreCase("MAX"))
                {
                    eclEntities.put("MAXFN", "TRUE");
                    selectStructSB.append(col.getAlias() + " := ");

                    if (sqlParser.hasGroupByColumns())
                    {
                        selectStructSB.append("MAX( GROUP ");
                    }
                    else
                    {
                        selectStructSB.append("MAX( ").append(datasource);
                        if (eclEntities.size() > 0)
                            addFilterClause(selectStructSB, eclEntities);
                    }

                    List<HPCCColumnMetaData> funccols = col.getFunccols();
                    if (funccols.size() > 0)
                    {
                        String paramname = funccols.get(0).getColumnName();
                        eclEntities.put("FNCOLS", paramname);
                        if (!paramname.equals("*")
                                && funccols.get(0).getColumnType() != HPCCColumnMetaData.COLUMN_TYPE_CONSTANT)
                        {
                            selectStructSB.append(", ");
                            selectStructSB.append(datasource);
                            selectStructSB.append(".");
                            selectStructSB.append(paramname);
                        }
                    }
                    selectStructSB.append(" );");
                }
                else if (col.getColumnName().equalsIgnoreCase("MIN"))
                {
                    eclEntities.put("MINFN", "TRUE");
                    selectStructSB.append(col.getAlias() + " := ");

                    if (sqlParser.hasGroupByColumns())
                    {
                        selectStructSB.append("MIN( GROUP ");
                    }
                    else
                    {
                        selectStructSB.append("MIN( ").append(datasource);
                        if (eclEntities.size() > 0)
                            addFilterClause(selectStructSB, eclEntities);
                    }

                    List<HPCCColumnMetaData> funccols = col.getFunccols();
                    if (funccols.size() > 0)
                    {
                        String paramname = funccols.get(0).getColumnName();
                        eclEntities.put("FNCOLS", paramname);
                        if (!paramname.equals("*")
                                && funccols.get(0).getColumnType() != HPCCColumnMetaData.COLUMN_TYPE_CONSTANT)
                        {
                            selectStructSB.append(", ");
                            selectStructSB.append(datasource);
                            selectStructSB.append(".");
                            selectStructSB.append(paramname);
                        }
                    }
                    selectStructSB.append(" );");
                }
                else if (col.getColumnName().equalsIgnoreCase("SUM"))
                {
                    eclEntities.put("SUMFN", "TRUE");
                    selectStructSB.append(col.getAlias() + " := ");

                    selectStructSB.append("SUM( ");
                    if (sqlParser.hasGroupByColumns())
                    {
                        selectStructSB.append(" GROUP ");
                    }
                    else
                    {
                        selectStructSB.append(datasource);
                        if (eclEntities.size() > 0)
                            addFilterClause(selectStructSB, eclEntities);
                    }

                    List<HPCCColumnMetaData> funccols = col.getFunccols();
                    if (funccols.size() > 0)
                    {
                        String paramname = funccols.get(0).getColumnName();
                        eclEntities.put("FNCOLS", paramname);
                        if (!paramname.equals("*")
                                && funccols.get(0).getColumnType() != HPCCColumnMetaData.COLUMN_TYPE_CONSTANT)
                        {
                            selectStructSB.append(", ");
                            selectStructSB.append(datasource);
                            selectStructSB.append(".");
                            selectStructSB.append(paramname);
                        }
                    }
                    selectStructSB.append(" );");
                }
            }
            else
                selectStructSB.append(col.getEclType()).append(" ").append(col.getColumnName()).append(" := ")
                        .append(datasource).append(".").append(col.getColumnName()).append("; ");

        }
        selectStructSB.append("\nEND;\n");

        eclEntities.put("SELECTSTRUCT", selectStructSB.toString());

        if (sqlParser.hasOrderByColumns())
            eclEntities.put("ORDERBY", sqlParser.getOrderByString());
        if (sqlParser.hasGroupByColumns())
            eclEntities.put("GROUPBY", sqlParser.getGroupByString());
        if (sqlParser.hasLimitBy())
            eclEntities.put("LIMIT", Integer.toString(sqlParser.getLimit()));

        if (eclEntities.get("IndexDef") == null)
        {
            if (!eclEntities.containsKey("GROUPBY"))
            {
                if (eclEntities.containsKey("COUNTFN"))
                {
                    eclCode.append("ScalarOut := COUNT( ").append(eclEntities.get("SourceDS"));

                    if (eclEntities.size() > 0)
                        addFilterClause(eclCode, eclEntities);
                    eclCode.append(");");
                    eclCode.append("\n");
                }
                else if (eclEntities.containsKey("SUMFN"))
                {
                    eclCode.append("ScalarOut := SUM( ").append(eclEntities.get("SourceDS"));
                    if (eclEntities.size() > 0)
                        addFilterClause(eclCode, eclEntities);

                    eclCode.append(" , ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(");");
                    eclCode.append("\n");
                }
                else if (eclEntities.containsKey("MAXFN"))
                {
                    eclCode.append("ScalarOut := MAX( ").append(eclEntities.get("SourceDS"));
                    if (eclEntities.size() > 0)
                        addFilterClause(eclCode, eclEntities);

                    eclCode.append(" , ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(");");
                    eclCode.append("\n");
                }
                else if (eclEntities.containsKey("MINFN"))
                {
                    eclCode.append("ScalarOut := MIN( ").append(eclEntities.get("SourceDS"));
                    if (eclEntities.size() > 0)
                        addFilterClause(eclCode, eclEntities);

                    eclCode.append(" , ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(");");
                    eclCode.append("\n");
                }
            }

            if (eclEntities.containsKey("SCALAROUTNAME"))
            {
                eclCode.append("OUTPUT(ScalarOut ,NAMED(\'");
                eclCode.append(eclEntities.get("SCALAROUTNAME"));
                eclCode.append("\'));");
            }
            else
            {
                eclCode.append(eclEntities.get("SELECTSTRUCT"));
                eclCode.append("OUTPUT(CHOOSEN(");

                if (eclEntities.containsKey("ORDERBY"))
                    eclCode.append("SORT( ");

                eclCode.append("TABLE( ");
                eclCode.append(eclEntities.get("SourceDS"));

                if (eclEntities.size() > 0 && !eclEntities.containsKey("JoinQuery"))
                    addFilterClause(eclCode, eclEntities);

                eclCode.append(", SelectStruct");
                if (eclEntities.containsKey("GROUPBY"))
                {
                    eclCode.append(",");
                    eclCode.append(eclEntities.get("GROUPBY"));
                }

                eclCode.append(")");

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
            eclCode.append(eclEntities.get("IndexDef"));
            eclCode.append(eclEntities.get("IndexRead"));

            if (!eclEntities.containsKey("GROUPBY"))
            {
                if (eclEntities.containsKey("COUNTFN"))
                {
                    eclCode.append("ScalarOut := COUNT(IdxDS");
                    eclCode.append(eclEntities.containsKey("PAYLOADINDEX") == false ? ");" : ", KEYED);\n");
                }
                if (eclEntities.containsKey("SUMFN"))
                {
                    eclCode.append("ScalarOut := SUM(IdxDS, ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(eclEntities.containsKey("PAYLOADINDEX") == false ? ");" : ", KEYED);\n");
                }
                if (eclEntities.containsKey("MAXFN"))
                {
                    eclCode.append("ScalarOut := MAX(IdxDS, ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(eclEntities.containsKey("PAYLOADINDEX") == false ? ");" : ", KEYED);\n");
                }
                if (eclEntities.containsKey("MINFN"))
                {
                    eclCode.append("ScalarOut := MIN(IdxDS, ");
                    eclCode.append(eclEntities.get("SourceDS"));
                    eclCode.append(".");
                    eclCode.append(eclEntities.get("FNCOLS"));
                    eclCode.append(eclEntities.containsKey("PAYLOADINDEX") == false ? ");" : ", KEYED);\n");
                }
            }

            if (eclEntities.containsKey("SCALAROUTNAME"))
            {
                eclCode.append("OUTPUT(ScalarOut ,NAMED(\'");
                eclCode.append(eclEntities.get("SCALAROUTNAME"));
                eclCode.append("\'));");
            }
            else
            {
                eclCode.append(eclEntities.get("SELECTSTRUCT"));

                eclCode.append("IdxDSTable := TABLE(IdxDS, SelectStruct ");

                if (eclEntities.containsKey("GROUPBY"))
                {
                    eclCode.append(", ");
                    eclCode.append(eclEntities.get("GROUPBY"));
                }
                eclCode.append(");\n");

                if (eclEntities.containsKey("ORDERBY"))
                {
                    eclCode.append("SortedIdxTable := SORT( IdxDSTable, ");
                    eclCode.append(eclEntities.get("ORDERBY"));
                    eclCode.append(");\n");
                    eclCode.append("ResultSet := SortedIdxTable;\n");
                }
                else
                    eclCode.append("ResultSet := IdxDSTable;\n");

                eclCode.append("OUTPUT(CHOOSEN(");
                eclCode.append(" ResultSet ");
            }
        }

        if (!eclEntities.containsKey("SCALAROUTNAME"))
        {
            eclCode.append(",");
            if (eclEntities.containsKey("LIMIT"))
                eclCode.append(eclEntities.get("LIMIT"));
            else
                eclCode.append(hpccConnProps.getProperty("EclResultLimit"));

            eclCode.append("),NAMED(\'")
                    .append(SELECTOUTPUTNAME)
                    .append("\'));");

            expectedDSName = SELECTOUTPUTNAME;
        }
    }

    public void generateECL() throws SQLException
    {
        int sqlReqType = sqlParser.getSqlType();

        eclCode = new StringBuilder("");
        hpccRequestUrl = null;

        switch (sqlReqType)
        {
            case SQLParser.SQL_TYPE_SELECT:
            {
                generateSelectECL();
                generateSelectURL();

                break;
            }
            case SQLParser.SQL_TYPE_SELECTCONST:
            {
                generateConstSelectECL();
                generateConstSelectURL();

                break;
            }
            case SQLParser.SQL_TYPE_CALL:
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
                        throw new SQLException(hpccPublishedQuery.getName() + " expects "+ storeProcInParams.size() + " input parameters, " + " received " + inParamValuesCount);

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
            urlString = "http://" + hpccConnProps.getProperty("WsECLAddress")
                + ":" + hpccConnProps.getProperty("WsECLPort")
                + "/WsEcl/submit/query/" + hpccPublishedQuery.getQuerySet()
                + "/" + hpccPublishedQuery.getName() + "/expanded";

            hpccRequestUrl = new URL(urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }

        System.out.println("HPCC URL created: " + urlString);
    }

    private void generateConstSelectURL() throws SQLException
    {
        String urlString;

        try
        {
            urlString = "http://" + hpccConnProps.getProperty("WsECLDirectAddress") + ":"
                    + hpccConnProps.getProperty("WsECLDirectPort") + "/EclDirect/RunEcl?Submit";

            if (hpccConnProps.containsKey("TargetCluster"))
            {
                urlString += "&cluster=";
                urlString += hpccConnProps.getProperty("TargetCluster");
            }
            else
                System.out.println("No cluster property found, executing query on EclDirect default cluster");

            urlString += "&eclText=";
            urlString += URLEncoder.encode(eclCode.toString(), "UTF-8");
            hpccRequestUrl = new URL(urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }

        System.out.println("HPCC URL created: " + urlString);
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
            String urlString = "http://" + hpccConnProps.getProperty("WsECLDirectAddress") + ":"
                    + hpccConnProps.getProperty("WsECLDirectPort") + "/EclDirect/RunEcl?Submit";

            if (hpccConnProps.containsKey("TargetCluster"))
                urlString += "&cluster=" + hpccConnProps.getProperty("TargetCluster");
            else
                System.out.println("No cluster property found, executing query on EclDirect default cluster");

            hpccRequestUrl = new URL(urlString);

            System.out.println("HPCC URL created: " + urlString);
        }
        catch (Exception e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public ArrayList execute(Map inParameters) throws Exception
    {
        switch (sqlParser.getSqlType())
        {
            case SQLParser.SQL_TYPE_SELECT:
            {
                return executeSelect(inParameters);
            }
            case SQLParser.SQL_TYPE_SELECTCONST:
            {
                return executeSelectConstant();
            }
            case SQLParser.SQL_TYPE_CALL:
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
                keyed.add(" " + sqlParser.getExpressionFromColumnName(keyedcolname).toString() + " ");
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
            int type = currentselectcol.getColumnType();
            if (type == HPCCColumnMetaData.COLUMN_TYPE_DATA && !indexfields.containsKey(colname.toUpperCase()))
                return false;
            else if (type == HPCCColumnMetaData.COLUMN_TYPE_FNCTION
                    && !containsPayload(indexfields, currentselectcol.getFunccols().iterator()))
                return false;
        }
        return true;
    }

    public ArrayList executeSelect(Map inParameters)
    {
        int responseCode = -1;

        try
        {
            StringBuilder sb = new StringBuilder();

            sb.append("&eclText=\n");

            if (sqlParser.getParameterizedCount() > 0 && inParameters != null)
            {
                if (sqlParser.getParameterizedCount() <= inParameters.size())
                {
                    for (int paramIndex = 1; paramIndex <= inParameters.size(); paramIndex++)
                    {
                        //TODO the type has to be better inferred/determined.
                        String value = (String) inParameters.get(new Integer(paramIndex));
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

            System.out.println("Executing ECL: " + sb);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(sb.toString());
            wr.flush();

            responseCode = conn.getResponseCode();

            return parse(conn.getInputStream(), startTime);
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

    private void addFilterClause(StringBuilder sb, HashMap parameters)
    {
        String whereclause = sqlParser.getWhereClauseString();
        if (whereclause != null && whereclause.length() > 0)
        {
            sb.append("( ");
            sb.append(whereclause);
            sb.append(" )");
        }
    }

    public ArrayList executeCall( Map inParameters)
    {
        StringBuilder sb = new StringBuilder();
        try
        {
            sb.append(URLEncoder.encode("submit_type_=xml", "UTF-8"));
            sb.append("&").append(URLEncoder.encode("S1=Submit", "UTF-8"));

            for (int columindex = 0; columindex < procInParamValues.length; columindex++)
            {
                String key = storeProcInParams.get(columindex).getColumnName();
                String value = procInParamValues[columindex];

                if (HPCCJDBCUtils.isParameterizedStr(value))
                {
                    value = (String) inParameters.get(new Integer(columindex + 1));
                    if (value == null)
                        throw new SQLException("Could not bind parameter");
                }

                sb.append("&").append(key).append("=").append(value);
            }

            long startTime = System.currentTimeMillis();

            HttpURLConnection conn = dbMetadata.createHPCCESPConnection(hpccRequestUrl);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(sb.toString());
            wr.flush();

            System.out.println("Executing: " + hpccRequestUrl + " : " + sb.toString());

            return parse(conn.getInputStream(), startTime);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public ArrayList parse(InputStream xml, long startTime) throws Exception
    {
        ArrayList results = null;

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document dom = db.parse(xml);

            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Total elapsed http request/response time in milliseconds: " + elapsedTime);

            Element docElement = dom.getDocumentElement();

            NodeList dsList = docElement.getElementsByTagName("Dataset");

            if (dsList != null && dsList.getLength() > 0)
            {
                // The dataset element is encapsulated within a Result element
                // need to fetch appropriate resulst dataset ie map eclqueryname
                // to dataset name

                ArrayList dsArray = new ArrayList();

                results = dsArray;

                for (int i = 0; i < dsList.getLength(); i++)
                {
                    Element ds = (Element) dsList.item(i);
                    String currentdatsetname = ds.getAttribute("name");
                    if (expectedDSName == null || expectedDSName.length() == 0
                            || currentdatsetname.equalsIgnoreCase(expectedDSName))
                    {
                        NodeList rowList = ds.getElementsByTagName("Row");

                        if (rowList != null && rowList.getLength() > 0)
                        {

                            ArrayList rowArray = new ArrayList();

                            dsArray.add(rowArray);

                            for (int j = 0; j < rowList.getLength(); j++)
                            {
                                Element row = (Element) rowList.item(j);

                                NodeList columnList = row.getChildNodes();

                                ArrayList columnsArray = new ArrayList();
                                rowArray.add(columnsArray);

                                for (int k = 0; k < columnList.getLength(); k++)
                                {
                                    columnsArray.add(new HPCCColumn(columnList.item(k).getNodeName(), columnList.item(k).getTextContent()));
                                }
                            }
                        }
                        break;
                    }
                }
            }
            else if (docElement.getElementsByTagName("Exception").getLength() > 0)
            {
                Exception xmlexception = new Exception();
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
                            resexception = new Exception("HPCCJDBC error in response: \'"
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
                if (dsList.getLength() == 0)
                {
                    ArrayList dsArray = new ArrayList();
                    results = dsArray;
                    NodeList rowList = docElement.getElementsByTagName("Row");

                    if (rowList != null && rowList.getLength() > 0)
                    {
                        ArrayList rowArray = new ArrayList();
                        dsArray.add(rowArray);

                        for (int j = 0; j < rowList.getLength(); j++)
                        {
                            Element row = (Element) rowList.item(j);
                            NodeList columnList = row.getChildNodes();

                            ArrayList columnsArray = new ArrayList();
                            rowArray.add(columnsArray);

                            for (int k = 0; k < columnList.getLength(); k++)
                            {
                                columnsArray.add(new HPCCColumn(columnList.item(k).getNodeName(), columnList.item(k)
                                        .getTextContent()));
                            }
                        }
                    }
                }
            }

            /*
             * not being used right not
             * setResultschema( docElement.getElementsByTagName("XmlSchema"));
             */

            System.out.println("Parsing results...");
            Iterator itr = results.iterator();
            System.out.println("Results datsets found: " + results.size());
            while (itr.hasNext())
            {
                ArrayList rows = (ArrayList) itr.next();
                System.out.println("Results rows found: " + rows.size());
                Iterator itr2 = rows.iterator();
                while (itr2.hasNext())
                {
                    ArrayList cols = (ArrayList) itr2.next();
                    Iterator itr3 = cols.iterator();
                    while (itr3.hasNext())
                    {
                        HPCCColumn element = (HPCCColumn) itr3.next();
                    }
                }
            }
            System.out.println("Finished Parsing results.");
        }
        catch (Exception e)
        {
            throw new Exception(
                    "Invalid response received, verify serveraddress and cluster name and HPCC query/file name:\n"
                            + e.getMessage());
        }

        return results;
    }

    public String convertInputStreamToString(InputStream ists) throws IOException
    {
        if (ists != null)
        {
            StringBuilder sb = new StringBuilder();
            String line;

            try
            {
                BufferedReader r1 = new BufferedReader(new InputStreamReader(ists, "UTF-8"));
                while ((line = r1.readLine()) != null)
                {
                    sb.append(line).append("\n");
                }
            }
            finally
            {
                ists.close();
            }
            return sb.toString();
        }
        else
        {
            return "";
        }
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
            System.out.println("contains resultschema");
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
        String[] sqlqueryparamnames = parser.getWhereClauseColumnNames();
        if (sqlqueryparamnames.length <= 0)
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
                    for (int i = 0; i < sqlqueryparamnames.length; i++)
                    {
                        String currentparam = sqlqueryparamnames[i];
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
