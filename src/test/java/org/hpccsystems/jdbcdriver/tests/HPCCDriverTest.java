package org.hpccsystems.jdbcdriver.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.hpccsystems.jdbcdriver.HPCCConnection;
import org.hpccsystems.jdbcdriver.HPCCDatabaseMetaData;
import org.hpccsystems.jdbcdriver.HPCCDriver;
import org.hpccsystems.jdbcdriver.HPCCJDBCUtils;
import org.hpccsystems.jdbcdriver.HPCCPreparedStatement;
import org.hpccsystems.jdbcdriver.HPCCResultSet;
import org.hpccsystems.jdbcdriver.HPCCStatement;


public class HPCCDriverTest
{
    static private HPCCDriver driver;
    static String             sline = System.getProperty("line.separator");
    int testcasecount = 0;
    HPCCConnection connectionByProperties = null;
    Properties connectionProperties = null;

    public int getTestcasecount()
    {
        return testcasecount;
    }

    private BufferedWriter reportBufferedWriter;
    private boolean            vmode = false;

    public boolean isVmode()
    {
        return vmode;
    }

    public void setVmode(boolean vmode)
    {
        this.vmode = vmode;
    }


    private void connectViaProps(Properties conninfo) throws SQLException
    {
        if (driver == null)
            driver = new HPCCDriver();

        connectionProperties = conninfo;
        connectionByProperties = (HPCCConnection) driver.connect("", connectionProperties);
        if (connectionByProperties == null)
            throw new SQLException("Could not connect");
        else if (connectionByProperties.getWarnings() != null)
            throw new SQLException("Could not connect");
        else
        {
            String tempTimeOut="";
            int timeoutvalue = -1;
            if(conninfo.containsKey("ConnectTimeoutMilli"))
            {
                tempTimeOut=conninfo.getProperty("ConnectTimeoutMilli");
            }
            else
            {
                tempTimeOut=HPCCDriver.CONNECTTIMEOUTMILDEFAULT;
            }
            try
            {
                timeoutvalue = Integer.parseInt(tempTimeOut);
            }
            catch (Exception e)
            {
                timeoutvalue = 5000;
            }
            if (!connectionByProperties.isValid(timeoutvalue))
                throw new SQLException("Could not connect - Review configuration file.");
            System.out.println("Connection established successfully...");
        }

    }
    private void printouttables()
    {
        try
        {
            if(connectionByProperties!=null)
            {
                ResultSet tables = connectionByProperties.getMetaData().getTables(null, null, "%", null);

                System.out.println("Tables found: ");
                while (tables.next())
                {
                    String tablename=null;
                    System.out.println("\t" + tables.getString("TABLE_NAME"));
                    tablename=tables.getString("TABLE_NAME");
                    if(vmode)
                    {
                        ResultSet tablecols = connectionByProperties.getMetaData().getColumns(null, null, tablename, "%");
                        while (tablecols.next())
                        {
                            System.out.println("\t\t"+ tablecols.getString("COLUMN_NAME") + "( "+ tablecols.getString("TYPE_NAME") + " )");
                        }
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.println("Could not fetch tables metadata-Null Connection!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unused")
    private static boolean printouttablecols(HPCCConnection connection, String tablename)
    {
        boolean success = true;
        try
        {
            ResultSet tablecols = connection.getMetaData().getColumns(null, null, tablename, "%");

            System.out.println("Table cols found: ");
            while (tablecols.next())
            {
                System.out.println("\t" + tablecols.getString("TABLE_NAME") + "::" + tablecols.getString("COLUMN_NAME")+"( " + tablecols.getString("TYPE_NAME") + " )");
            }
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    private void printoutprocs()
    {
        try
        {
            if(connectionByProperties!=null)
            {
            String procname=null;
            ResultSet procs = connectionByProperties.getMetaData().getProcedures(null, null, null);

            System.out.println("Procedures found: ");
            while (procs.next())
            {
                System.out.println("\t" + procs.getString("PROCEDURE_NAME"));
                if (vmode)
                {
                    procname=procs.getString("PROCEDURE_NAME");
                    ResultSet proccols = connectionByProperties.getMetaData().getProcedureColumns( null, null, procname, null);
                    while (proccols.next())
                        System.out.println("\t\t"+ proccols.getString("COLUMN_NAME") + " (" + proccols.getInt("COLUMN_TYPE") + ")");
                }
                System.out.println();
            }
            }
            else
            {
                System.out.println("Could not fetch stored procedures-Null Connection!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

    @SuppressWarnings("unused")
    private boolean printoutproccols(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet proccols = connection.getMetaData().getProcedureColumns(null, null, null, null);
            if (vmode)
            {
                System.out.println("procs cols found: ");
                while (proccols.next())
                    System.out.println("\t"+ proccols.getString("PROCEDURE_NAME")+ proccols.getString("PROCEDURE_NAME") + "::"+ proccols.getString("COLUMN_NAME") + " ("+ proccols.getInt("COLUMN_TYPE") + ")");
            }

        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }
    private  void freeHandSQL_Report(String status,String caseName,String sqlStatement, String wuid, long roundTripTimeMilli)
    {
        try
        {
                testcasecount++;
                reportBufferedWriter.write(testcasecount + "." + status + " || " + caseName + " || " + wuid + " || " + roundTripTimeMilli + "ms"  + " || " + sqlStatement +  sline + sline);
                reportBufferedWriter.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private void printTableInVerboseMode(ResultSetMetaData meta,HPCCResultSet qrs) throws SQLException
    {
        int colcount;
        colcount = meta.getColumnCount();

        for (int i = 1; i <= colcount; i++)
        {
            System.out.print("[*****" + meta.getColumnName(i)+ "*****]");
        }
        System.out.println("");
        for (int i = 1; i <= colcount; i++)
        {
            System.out.print("[^^^^^" + meta.getColumnLabel(i) + "^^^^^]");
        }
        System.out.println();
        for (int i = 1; i <= meta.getColumnCount(); i++)
        {
            System.out.print("[+++++"+ HPCCJDBCUtils.convertSQLtype2JavaClassName(meta.getColumnType(i)) + "+++++]");
        }
        while (qrs.next())
        {
            System.out.println();
            for (int i = 1; i <= colcount; i++)
            {
                System.out.print("[ " + qrs.getObject(i) + " ]");
            }
        }
    }

    private void executeFreeHandSQL(String sql, boolean expectPass, int minResults, String csvpath, String testName)
    {
        BufferedReader readDataFile = null;
        String line = null;
        String errormessage = null;
        String resultWUID = "";

        try
        {
            PreparedStatement p = null;
            try
            {
                p = connectionByProperties.prepareStatement(sql);
            }
            catch (Exception e)
            {
                errormessage = e.getLocalizedMessage();
                freeHandSQL_Report("FAILED: " + errormessage, testName, sql, resultWUID, 0);
                return;
            }
            p.clearParameters();

            readDataFile = new BufferedReader(new FileReader(csvpath));
            String prepParamValue = null;
            while (!((line = readDataFile.readLine()).isEmpty()))
            {
                boolean success = true;
                String[] csvlines = line.split(";");
                prepParamValue = "";
                HPCCResultSet qrs = null;
                long roundTripTimeMilli = 0;
                int resultcount = -1;
                try
                {
                    for (int i = 0; i < csvlines.length; i++)
                    {
                        String value = null;
                        String currline = csvlines[i];
                        String [] valuesAndTheirTypes = currline.split("[ ]*,[ ]*");

                        value = String.valueOf(valuesAndTheirTypes[0]);
                        if (valuesAndTheirTypes.length > 1)
                        {
                            Object converted = HPCCJDBCUtils.deserializeSQLTypesToJava(valuesAndTheirTypes[1], value);
                            p.setObject(i + 1, converted);
                            if (converted != null)
                                prepParamValue = converted.toString();
                            else
                                prepParamValue = "null";
                        }
                        else
                        {
                            p.setObject(i + 1, value);
                            prepParamValue = value;
                        }
                    }

                    if (vmode)
                    {
                        System.out.print(sql + " values: ");
                        for (int i = 0; i < csvlines.length; i++)
                        {
                            if (i > 0)
                                System.out.print(", ");
                            System.out.print(csvlines[i]);
                        }
                        System.out.println();
                    }

                    try
                    {
                        errormessage = "";
                        long startTime = System.currentTimeMillis();
                        qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();

                        roundTripTimeMilli = (System.currentTimeMillis() - startTime);
                        if (qrs != null)
                        {
                            resultWUID = qrs.getResultWUID();
                            resultcount = qrs.getRowCount();
                        }
                    }
                    catch (Exception sqle)
                    {
                        errormessage = sqle.getMessage();
                        success = false;
                    }
                }
                catch (Exception e)
                {
                    qrs = null;
                    errormessage = e.getLocalizedMessage();
                    success = false;
                }

                if (success && expectPass)
                {
                    if (resultcount < minResults)
                        freeHandSQL_Report("Detected less rows than expected", testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                    else
                        freeHandSQL_Report("EXECUTED AS EXPECTED", testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                }
                else if (!success && !expectPass)
                {
                    freeHandSQL_Report("EXECUTED AS EXPECTED", testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                }
                else if (!success && expectPass)
                {
                    freeHandSQL_Report("UNEXPECTED (failure): " + errormessage, testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                }
                else if (success && !expectPass)
                {
                    freeHandSQL_Report("UNEXPECTED (success)", testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                }
                else
                {
                    freeHandSQL_Report("UNKNOWN Result state", testName, sql + "--Value: " + prepParamValue, resultWUID, roundTripTimeMilli);
                }

                if (resultcount > 0 && vmode)
                {
                    printTableInVerboseMode(qrs.getMetaData(), qrs);
                    System.out.println();
                }
            }
        }
        catch (NullPointerException e)
        {

        }
        catch (Exception e)
        {
            freeHandSQL_Report("Error:"+e.getLocalizedMessage(),testName,sql, resultWUID, 0);
        }
        finally
        {
            if (readDataFile != null)
            {
                try
                {
                    readDataFile.close();
                }
                catch (IOException e)
                {
                    System.out.println("Buffered Reader object inside of executeFreeHandSQL could not be closed.");
                }
            }
        }
    }

    private void executeFreeHandSQL(String SQL, boolean expectPass, int minResults, String testName)
    {
        boolean success = true;
        String errorMessage = null;
        long resultcount = 0;
        String resultWUID = "";
        long roundTripTimeMilli = 0;

        try
        {
            HPCCStatement statement = (HPCCStatement)connectionByProperties.createStatement();
            long startTime = System.currentTimeMillis();
            statement.execute(SQL);
            roundTripTimeMilli = (System.currentTimeMillis() - startTime);

            HPCCResultSet resultSet = (HPCCResultSet) statement.getResultSet();

            ResultSetMetaData meta = resultSet.getMetaData();

            printTableInVerboseMode(meta, resultSet);
            resultcount = resultSet.getTotalRowCount();
            resultWUID = resultSet.getResultWUID();

            if (resultcount > 0 && vmode)
            {
                printTableInVerboseMode( meta, resultSet);
            }
            resultWUID = resultSet.getResultWUID();
        }
        catch (Exception e)
        {
            errorMessage = e.getMessage();
            success = false;
        }

        if (!success && expectPass)
        {
            freeHandSQL_Report("UNEXPECTED (failure): " + errorMessage, testName, SQL, resultWUID, roundTripTimeMilli);
        }
        else if (success && !expectPass)
        {
            freeHandSQL_Report( "UNEXPECTED (success)", testName, SQL, resultWUID, roundTripTimeMilli);
        }
        else if (success && expectPass)
        {
            if(resultcount >= minResults)
            {
                freeHandSQL_Report( "EXECUTED AS EXPECTED", testName, SQL, resultWUID, roundTripTimeMilli);
            }
            else if(resultcount<minResults)
            {
                freeHandSQL_Report( "Detected less rows than expected", testName, SQL, resultWUID, roundTripTimeMilli);
            }
        }
        else if(!success && !expectPass)
        {
            freeHandSQL_Report( "EXECUTED AS EXPECTED", testName, SQL, resultWUID, roundTripTimeMilli);
        }
    }


    private static boolean getDatabaseInfo(HPCCConnection conn)
    {
        try
        {
            return getDatabaseInfo((HPCCDatabaseMetaData) conn.getMetaData());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean getDatabaseInfo(HPCCDatabaseMetaData dbmetadata)
    {
        boolean success = true;
        try
        {
            String hpccname = dbmetadata.getDatabaseProductName();
            String hpccprodver = dbmetadata.getDatabaseProductVersion();
            int major = dbmetadata.getDatabaseMajorVersion();
            int minor = dbmetadata.getDatabaseMinorVersion();
            String sqlkeywords = dbmetadata.getSQLKeywords();

            System.out.println("HPCC System Info:");
            System.out.println("\tProduct Name: " + hpccname);
            System.out.println("\tProduct Version: " + hpccprodver);
            System.out.println("\tProduct Major: " + major);
            System.out.println("\tProduct Minor: " + minor);
            System.out.println("\tDriver Name: " + dbmetadata.getDriverName());
            System.out.println("\tDriver Major: " + dbmetadata.getDriverMajorVersion());
            System.out.println("\tDriver Minor: " + dbmetadata.getDriverMinorVersion());
            System.out.println("\tSQL Key Words: " + sqlkeywords);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static synchronized boolean printOutResultSet(HPCCResultSet resultset, long threadid)
    {
        System.out.println("Servicing thread id: " + threadid);

        int padvalue = 20;
        boolean isSuccess = true;
        try
        {
            ResultSetMetaData meta = resultset.getMetaData();

            System.out.println();
            int colcount = meta.getColumnCount();
            for (int i = 1; i <= colcount; i++)
            {
                String colname = meta.getColumnName(i);
                System.out.print("[");

                for (int y = 0; y < (colname.length() >= padvalue ? 0 : (padvalue - colname.length()) / 2); y++)
                    System.out.print(" ");
                System.out.print(colname);

                for (int y = 0; y < (colname.length() >= padvalue ? 0 : (padvalue - colname.length()) / 2); y++)
                    System.out.print(" ");

                System.out.print("]");
            }
            System.out.println("");

            for (int i = 1; i <= colcount; i++)
            {
                String collabel = meta.getColumnLabel(i);
                System.out.print("[");

                for (int y = 0; y < (collabel.length() >= padvalue ? 0 : (padvalue - collabel.length()) / 2); y++)
                    System.out.print("^");
                System.out.print(collabel);

                for (int y = 0; y < (collabel.length() >= padvalue ? 0 : (padvalue - collabel.length()) / 2); y++)
                    System.out.print("^");

                System.out.print("]");
            }
            System.out.println();

            for (int i = 1; i <= colcount; i++)
            {
                String coltype = HPCCJDBCUtils.convertSQLtype2JavaClassName(meta.getColumnType(i));
                System.out.print("[");

                for (int y = 0; y < (coltype.length() >= padvalue ? 0 : (padvalue - coltype.length()) / 2); y++)
                    System.out.print(" ");
                System.out.print(coltype);

                for (int y = 0; y < (coltype.length() >= padvalue ? 0 : (padvalue - coltype.length()) / 2); y++)
                    System.out.print(" ");

                System.out.print("]");
            }

            while (resultset.next())
            {
                System.out.println();
                for (int i = 1; i <= colcount; i++)
                {
                    String result = (String) resultset.getObject(i);
                    System.out.print("[");

                    for (int y = 0; y < (result.length() >= padvalue ? 0 : padvalue - result.length()); y++)
                        System.out.print(" ");
                    System.out.print(result);
                    System.out.print("]");
                }
            }

            System.out.println("\nTotal Records found: " + resultset.getTotalRowCount());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            isSuccess = false;
        }
        return isSuccess;
    }
    public static void usage()
    {
        System.out.println("********************************************************************");
        System.out.println("HPCC JDBC Test Usage:");
        System.out.println(" HPCCDriverTest "
                + "Config=<File path to HPCC connection config file> "
                + "ReportPath=<Path where report files will be created>"
                + "[options]\n "
                + "where options:\n "
                + "SqlScript=<File path to sql script file>\n "
                + "-V (turns on verbose mode)\n\n");
        System.out.println(" eg. Config=C:\\Users\\username\\folder\\config_file.txt");
        System.out.println(" eg. ReportPath=C:\\Users\\username\\folder");
        System.out.println(" eg. SqlScript=C:\\Users\\username\\folder\\Sql_file.txt");
        System.out.println();
        System.out.println(" SqlScript file should contain one SQL test case per line using the following format:");
        System.out.println(" <testcaselabel>=[\"[\"<boolean expected success>;<minimun result rows expected>;<path to data file>\"]\"] <sql command>");
        System.out.println(" eg. Test1=call roxie::fetchpeoplebyzipservice(33024) ");
        System.out.println(" eg. Test2=[true;1] select 1 limit 100");
        System.out.println(" eg. Test3=[true;1;path/to/data/file.data or path\\to\\data\\file.data]select * from tablename where zip=? limit 100");
        System.out.println(" By default TraceLevel is set to INFO if TraceLevel property is not set in configuration file\n");
        System.out.println(" If Verbose Mode is actived, Tracelevel is set to ALL and driver properties are written to Report file ");
        System.out.println();
        System.out.println("********************************************************************\n");
        System.exit(0);
    }
    private  synchronized void createReportFile(String reportFilePath) throws IOException
    {
        Date               cdate = new Date();
        SimpleDateFormat   sdf   = new SimpleDateFormat("yyyy_MM_dd-hh-mm-ss");
        String             date  = sdf.format(cdate);
        String             filename;
        filename = reportFilePath + "HPCCJDBCTEST_" + date;

        File tmprepfile = new File(reportFilePath);
        if (!tmprepfile.isDirectory())
        {
            if(!tmprepfile.mkdir())
                throw new RuntimeException("Could not create results folder: " + reportFilePath);
        }

        tmprepfile = new File(filename+".log");
        //at this point tmprepfile doesn't exist, unless it was created by a independent run
        for (int i = 1; i <= 11 && tmprepfile.exists(); i++)
        {
            if (i == 11)
                throw new RuntimeException("Failed to create concurrent report file: " + filename + ".log after " + i + " attempts!" );
            tmprepfile = new File(filename + "-" + i + ".log");
        }

        reportBufferedWriter = new BufferedWriter(new FileWriter(tmprepfile, true));
    }

    private void printHeader()
    {
        DriverPropertyInfo[] driver_info;
        try
        {
            if (vmode)
            {
                driver_info = driver.getPropertyInfo("", null);
                reportBufferedWriter.write("-----------------Driver Properties-----------------------------------------------------------------------------------------------------------------------------------"+ sline);
                for (int i = 0; i < driver_info.length; i++)
                    reportBufferedWriter.write(driver_info[i].name + ": "+ driver_info[i].description + sline);
                reportBufferedWriter.write("---------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ sline);
            }
                reportBufferedWriter.write("      Status           ||         Test Case Name        ||      Result WorkUnid ID        ||      Round-trip time (milliseconds) ||             SQL Statement        "+ sline);
                reportBufferedWriter.write("---------------------------------------------------------------------------------------------------------------------------------------------------------------------"+ sline);
                reportBufferedWriter.flush();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public int verifyTestCaseParams(String key,String[] arrayParams)
    {
        int error=0;
        try
        {
            if(arrayParams.length>=2)
            {
                String firstOption = arrayParams[0].trim();
                if(firstOption.equalsIgnoreCase("true") || firstOption.equalsIgnoreCase("false"))
                {
                    Integer.parseInt(arrayParams[1]);
                }
                else
                {
                    error=-1;
                }
            }
            else if(arrayParams.length ==0)
            {
               error=-2;
            }
          }
          catch(Exception e)
          {
              error=-3;
          }
      return error;
    }

    private void executeScript(String targetReportPath, String scriptfilepath) throws IOException, SQLException
    {
        createReportFile(targetReportPath);
        printHeader();
        File propertyFile = new File(scriptfilepath);
        FileInputStream loadparams = new FileInputStream(propertyFile);
        Properties sqltestcases = new OrderedProperties();
        sqltestcases.load(loadparams);
        loadparams.close();
        System.out.println("SqlScript parameter found-Scripted Mode Started...\n");

        List<String> testcaseByGroup = new ArrayList<String>();
        System.out.println("Processing regular and/or prepared statements...");
        Enumeration<?> propertyNames = sqltestcases.propertyNames();
        while(propertyNames.hasMoreElements())
        {
            String testCaseName = (String)propertyNames.nextElement();
            String testCaseValue = sqltestcases.getProperty(testCaseName);

            if (!(testCaseValue.isEmpty()))
            {
                testcaseByGroup = HPCCJDBCUtils.returnTestCaseParams(testCaseValue);
                if (testcaseByGroup.get(0) == null)
                {
                    executeFreeHandSQL( testCaseValue,true, 0, testCaseName);
                }
                else if (testcaseByGroup.get(1) != null)
                {
                    String bracketdoptions = testcaseByGroup.get(0);
                    String optionslist = bracketdoptions.substring(bracketdoptions.indexOf("[")+1,bracketdoptions.indexOf("]"));
                    String[] splittedBracketParams = optionslist.split(";");
                    int error=verifyTestCaseParams(testCaseName,splittedBracketParams);
                    switch(error)
                    {
                        case -1: System.out.println("Warning: Unsupported syntax parameter for test case:"+testCaseName);
                                freeHandSQL_Report("FAILED:Unsupported syntax parameter, refer to README.md",testCaseName,testCaseValue, "", 0);
                                break;
                        case -2: System.out.println("Warning: Please review the usage for supported paramters for test case:"+testCaseName);
                                freeHandSQL_Report("FAILED:Please review the README.md for supported paramters",testCaseName,testCaseValue, "", 0);
                                break;
                        case -3: System.out.println("Warning: Unsupported syntax parameter for test case:"+testCaseName);
                                freeHandSQL_Report("FAILED:Unsupported syntax parameter, refer to README.md",testCaseName,testCaseValue, "", 0);
                                break;
                        case  0:
                                try
                                {
                                    boolean testcaseExpectVal = false;
                                    int expectedRows = 0;
                                    String csvpath = "";

                                    if (splittedBracketParams.length > 0)
                                    {
                                        if (splittedBracketParams[0].equalsIgnoreCase("true"))
                                        {
                                            testcaseExpectVal = true;
                                        }
                                        else if (splittedBracketParams[0].equalsIgnoreCase("false"))
                                        {
                                            testcaseExpectVal = false;
                                        }
                                        else
                                        {
                                            System.out.println("Unrecognized parameter inside of brackets:"+ testCaseName+ "=["+ splittedBracketParams[0]+ "]");
                                            System.exit(0);
                                        }

                                        if (splittedBracketParams.length > 1)
                                            expectedRows = Integer.parseInt(splittedBracketParams[1]);

                                        if (splittedBracketParams.length == 3)
                                            csvpath = (splittedBracketParams[2]);
                                    }

                                    if (csvpath.length() > 0)
                                        executeFreeHandSQL( testcaseByGroup.get(1), testcaseExpectVal, expectedRows,csvpath, testCaseName);
                                    else
                                        executeFreeHandSQL( testcaseByGroup.get(1), testcaseExpectVal, expectedRows, testCaseName);
                                }
                                catch (Exception e)
                                {
                                    System.out.println("\nError attempting to parse test case parameters:" + testCaseName + "=[ "+ optionslist + " ]");
                                    System.exit(0);
                                }
                                break;
                        default:
                                break;
                    }
                }
            }
            else
            {
                System.out.println("Value could not be found for test case:" + testCaseName);
            }
        }
    }

    private void fetchMetaData()
    {
        System.out.println("SqlScript parameter not found-Displaying target HPCC System info...");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        if(!getDatabaseInfo(connectionByProperties))
            throw new RuntimeException("Could not retrieve Database Info-Operation Failed");
        printouttables();
        printoutprocs();
    }

    private static String ensureTrailingPathSeparator(String incomingPath)
    {
        if(incomingPath != null && !incomingPath.isEmpty() && !(incomingPath.trim().endsWith(File.separator)))
        {
            incomingPath= incomingPath+File.separator;
        }
    return incomingPath;
    }

    private void closeWriteBuffers()
    {
        if (reportBufferedWriter != null)
            try
            {
                reportBufferedWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws IOException
    {
        HPCCDriverTest hpccTestObject = null;
        try
        {
            Properties testArgs = new Properties();
            if (args.length == 0)
            {
                System.out.println("0 parameters found. Failed");
                usage();
            }
            else if (args.length > 4)
            {
                System.out.println("Exceeding number of  parameters found. Failed");
                usage();
            }
            else
            {
                for (int i = 0; i < args.length; i++)
                {
                    if (args[i].contains("="))
                    {
                        String splittedArguments[] = args[i].split("=");
                        testArgs.put(splittedArguments[0].trim().toUpperCase(), HPCCJDBCUtils.handleQuotedString(splittedArguments[1].trim()));
                    }
                }
                System.out.println("-----------------------HPCCJDBC Driver Test Suite-----------------------");
                System.out.println("========================================================================");
                System.out.println();
                hpccTestObject = new HPCCDriverTest();
                if (args[args.length - 1].equals("-V"))
                {
                    hpccTestObject.setVmode(true);
                }
                if (!(testArgs.containsKey("CONFIG")))
                {
                    System.out.println("Config parameter not found. Ended!");
                    usage();
                }
                if (!(testArgs.containsKey("REPORTPATH")))
                {
                    System.out.println("ReportPath parameter not found. Ended!");
                    usage();
                }
                String reportFileLocation = ensureTrailingPathSeparator(testArgs.getProperty("REPORTPATH"));

                try
                {
                    Properties connectionProps = new Properties();
                    File propertyFile= new File(testArgs.getProperty("CONFIG"));
                    FileInputStream loadparams = new FileInputStream(propertyFile);
                    connectionProps.load(loadparams);
                    loadparams.close();
                    if (hpccTestObject.isVmode())
                    {
                        if (!(connectionProps.containsKey("TraceLevel")))
                        {
                            connectionProps.put("TraceLevel", "ALL");
                            System.out.println(connectionProps.getProperty("TraceLevel"));
                        }
                        if (!(connectionProps.containsKey("TraceToFile")))
                        {
                            connectionProps.put("TraceToFile", "true");
                        }
                        System.out.println("Verbose mode ON!");
                    }
                    else if (!(connectionProps.containsKey("TraceLevel")))
                    {
                        connectionProps.put("TraceLevel", "INFO");
                    }
                    hpccTestObject.connectViaProps(connectionProps);
                }
                catch (SQLException sql)
                {
                   System.out.println("Could not connect to target HPCC, please review connection properties.");
                   sql.printStackTrace();
                   System.exit(-1);
                }
                catch (IOException ioex)
                {
                    System.out.println("Connection configuration file could not be read. Please check the path.");
                    System.out.println();
                    usage();
                }
                if (testArgs.containsKey("SQLSCRIPT"))
                {
                    try
                    {
                        hpccTestObject.executeScript(reportFileLocation, testArgs.getProperty("SQLSCRIPT"));
                    }
                    catch (Exception e)
                    {
                        System.out.println("Target ReportPath directory was not found.");
                        System.out.println();
                        e.printStackTrace();
                        usage();
                    }
                }
                else
                {
                   hpccTestObject.fetchMetaData();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }
        finally
        {
            if (hpccTestObject.testcasecount!=0)
            {
                hpccTestObject.closeWriteBuffers();
                System.out.println("\nHPCC Driver completed test - Statement executed: "+ hpccTestObject.testcasecount + " -Verify ReportPath location for Report");
            }
            else
            {
                System.out.println("\n HPCC Driver test completed- 0 statement executed.");
            }
        }
    }
}
