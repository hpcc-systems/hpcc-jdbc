package org.hpccsystems.jdbcdriver.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.hpccsystems.jdbcdriver.HPCCConnection;
import org.hpccsystems.jdbcdriver.HPCCDatabaseMetaData;
import org.hpccsystems.jdbcdriver.HPCCDriver;
import org.hpccsystems.jdbcdriver.HPCCJDBCUtils;
import org.hpccsystems.jdbcdriver.HPCCPreparedStatement;
import org.hpccsystems.jdbcdriver.HPCCResultSet;
import org.hpccsystems.jdbcdriver.SQLParser;


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
                throw new SQLException("Could not connect");
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
                    ResultSet tablecols = connectionByProperties.getMetaData().getColumns(null,
                            null, tablename, "%");
                    while (tablecols.next())
                        System.out.println("\t\t"+ tablecols.getString("COLUMN_NAME") + "( "+ tablecols.getString("TYPE_NAME") + " )");
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
                System.out.println("\t" + tablecols.getString("TABLE_NAME") + "::" + tablecols.getString("COLUMN_NAME")
                        + "( " + tablecols.getString("TYPE_NAME") + " )");
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
            ResultSet procs = connectionByProperties.getMetaData().getProcedures(null,
                    null, null);

            System.out.println("Procedures found: ");
            while (procs.next())
            {
                System.out.println("\t" + procs.getString("PROCEDURE_NAME"));
                if (vmode)
                {
                    procname=procs.getString("PROCEDURE_NAME");
                    ResultSet proccols = connectionByProperties.getMetaData().getProcedureColumns(
                            null, null, procname, null);
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
            ResultSet proccols = connection.getMetaData().getProcedureColumns(
                    null, null, null, null);
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

    private  void freeHandSQL_Report(String sql, String status,String desc)
    {
        int loop=1;
        try
        {
            for (int i = 0; i != loop; loop--)
            {
                testcasecount++;

                reportBufferedWriter.write(testcasecount + "." + status + " || " + desc + " || " + sql
                        + sline);
                reportBufferedWriter.write(sline);
                reportBufferedWriter.flush();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static int parseCallParams(String sql)
    {

        int count = 0;
        int found = 0;
        if (sql.contains("${") || sql.contains("?"))
        {
            for (int i = 0; i < sql.length(); i++)
            {
                char[] el = sql.toCharArray();
                if (el[i] == '$')
                {
                    count++;
                }
                if (count == 1 && el[i + 1] == '{')
                {
                    found++;
                }
            }
            sql.toString().trim();
            if (sql.contains("(?"))
            {
                String q = sql.substring(sql.indexOf("(") + 1,sql.indexOf(")") - 1);
                String[] ar = q.split(",");
                found = ar.length;
            }
        }
        return found;
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
    private void executeFreeHandSQL(String SQL, boolean expectPass, int minResults, String csvpath, String testName)
    {
        BufferedReader readDataFile = null;
        String line = null;
        boolean success = true;
        String errormessage = null;

        try
        {
            if (connectionByProperties == null)
                return;

            PreparedStatement p = null;
            try
            {
                p = connectionByProperties.prepareStatement(SQL);
            }
            catch (Exception e)
            {
                errormessage=e.getLocalizedMessage();
                freeHandSQL_Report(SQL, "FAILED: "+ errormessage, testName);
                return;
            }
            p.clearParameters();
            readDataFile = new BufferedReader(new FileReader(csvpath));
            StringBuilder prepParamValue = new StringBuilder();
            while (!((line = readDataFile.readLine()).isEmpty()))
            {
                SQLParser sqlParser = new SQLParser();
                sqlParser.process(SQL);
                int countparam = sqlParser.assignParameterIndexes();
                String[] csvlines = line.split(";");

                for (int i = 0; i < csvlines.length; i++)
                {
                    p.setObject(i + 1, csvlines[i]);
                    prepParamValue.append(csvlines[i]);
                }
                if (vmode)
                {
                    System.out.println(SQL + "values: " + prepParamValue.toString());
                }
                if (countparam != csvlines.length && sqlParser.getSqlType() == SQLParser.SQLType.SELECT)
                {
                    System.out.println("Warning: Parameters size:" + prepParamValue.toString()+ " does not match the size of"+ "prepared statement:" + SQL);
                }
                else if (sqlParser.getSqlType() == SQLParser.SQLType.CALL)
                {
                    int callparam= parseCallParams(SQL);
                    if(callparam!= csvlines.length)
                    {
                        System.out.println("Warning: Parameters size:" + prepParamValue.toString()+ " does not match the size of"+ "prepared statement:" + SQL);
                    }
                }
                HPCCResultSet qrs = null;
                try
                {
                    success = true;
                    errormessage="";
                    qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();
                }
                catch (Exception sqle)
                {
                    errormessage= sqle.getMessage();
                    success = false;
                }
                ResultSetMetaData meta = qrs.getMetaData();
                int resultcount = qrs.getRowCount();
                if (success && (resultcount < minResults))
                {
                    success = false;
                    errormessage = "Detected less rows than expected";
                }
                if (success && expectPass || (!success && !expectPass))
                {
                    freeHandSQL_Report(SQL + "--Value:" + prepParamValue.toString(), "PASSED",testName);
                }

                else if (!success && expectPass)
                {
                    freeHandSQL_Report(SQL + "--Value:" + prepParamValue.toString(), "FAILED: "+ errormessage, testName);
                }
                else if (success && !expectPass)
                {
                    freeHandSQL_Report(SQL + "--Value:" + prepParamValue.toString(),"UNEXPECTEDLY PASSED!!", testName);
                }
                if (resultcount > 0 && vmode)
                {
                    printTableInVerboseMode( meta, qrs);
                    System.out.println();
                }
                prepParamValue.setLength(0);
               }
        }
        catch (NullPointerException e)
        {

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        if (readDataFile != null)
        {
            try
            {
                readDataFile.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void executeFreeHandSQL(String SQL, boolean expectPass, int minResults, String testName)
    {
        boolean success = true;
        String errorMessage = null;

        try
        {
            if (connectionByProperties == null)
                throw new Exception("connectionByProperties failed while trying to execute regular statemtent.");

            PreparedStatement p = connectionByProperties.prepareStatement(SQL);
            p.clearParameters();

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();

            ResultSetMetaData meta = qrs.getMetaData();
            System.out.println();

            int resultcount = qrs.getRowCount();

            if (resultcount > 0 && vmode)
            {
                    printTableInVerboseMode( meta, qrs);
            }

            success = (resultcount >= minResults);
        }
        catch (Exception e)
        {
            errorMessage = e.getMessage();
            success = false;
        }

        if (!success && expectPass)
        {
            freeHandSQL_Report(SQL, "FAILED: " + errorMessage, testName);

        }
        else if (success && !expectPass)
        {
            freeHandSQL_Report(SQL, "UNEXPECTEDLY PASSED!!", testName);
        }
        else if (success && expectPass || (!success && !expectPass))
        {
            freeHandSQL_Report(SQL, "PASSED", testName);
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

            System.out.println("\nTotal Records found: " + resultset.getRowCount());
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
        String pathVerified=validatePath(reportFilePath);
        Date               cdate = new Date();
        SimpleDateFormat   sdf   = new SimpleDateFormat("yyyy_MM_dd-hh-mm-ss");
        String             date  = sdf.format(cdate);
        String             filename;
        filename = pathVerified + File.separator + "HPCCJDBCTEST_" + date;
       File tmprepfile = new File(filename+".log");
          int i;
          for (i = 2; i <= 11 && (tmprepfile.exists()); i++)
          {
              tmprepfile = new File(filename + "-" +i + ".log");
          }
          if (i>=11)
              throw new RuntimeException(i+" Attempts to create Report file failed.");

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
                reportBufferedWriter.write("-----------------Driver Properties----------------------------------"+ sline);
                for (int i = 0; i < driver_info.length; i++)
                    reportBufferedWriter.write(driver_info[i].name + ": "+ driver_info[i].description + sline);
                reportBufferedWriter.write("--------------------------------------------------------------------------------------------------------------"+ sline);
            }
                reportBufferedWriter.write("                         Status                    ||          SQL          ||             Description    "+ sline);
                reportBufferedWriter.write("--------------------------------------------------------------------------------------------------------------"+sline);
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
    public void verifyTestCaseParams(String key,String[] arrayParams)
    {
      try{
        if(arrayParams.length>=2)
        {
            if(arrayParams[0].equals("true") || arrayParams[0].equals("false"))
            {
                Integer.parseInt(arrayParams[1]);
            }
            else
            {
                System.out.println("Error: Unsupported syntax parameter for test case:"+key);
                usage();
            }
        }
        else if(arrayParams.length ==0)
        {
           System.out.println("Error: Please review the usage for supported paramters for test case:"+key);
           usage();
        }
      }
      catch(Exception e)
      {
          System.out.println("Error: Unsupported syntax parameter for test case:"+key);
          usage();
      }
    }

    private void executeScript(String targetReportPath, String scriptfilepath) throws IOException, SQLException
    {
        createReportFile(targetReportPath);
        printHeader();
        File propertyFile = new File(scriptfilepath);
        FileInputStream loadparams = new FileInputStream(propertyFile);
        Properties sqltestcases = new Properties();
        sqltestcases.load(loadparams);
        loadparams.close();
        System.out.println("SqlScript parameter found-Scripted Mode Started...\n");

        List<String> testcaseByGroup = new ArrayList<String>();
        System.out.println("Processing regular and/or prepared statements...");
        for (String key : sqltestcases.stringPropertyNames())
        {
            String value = sqltestcases.getProperty(key);

            if (HPCCJDBCUtils.identifyPattern(value))
            {
                testcaseByGroup = HPCCJDBCUtils.returnTestCaseParams(value);

                String[] testcaseGroups = testcaseByGroup.toArray(new String[testcaseByGroup.size()]);

                if (testcaseGroups[0] == null)
                {
                    executeFreeHandSQL( value,true, 0, "SQL: " + key);
                }
                else if (testcaseGroups[1] != null)
                {
                    String bracketParams = testcaseGroups[0].substring( testcaseGroups[0].indexOf("[") + 1,testcaseGroups[0].indexOf("]"));

                    String[] splittedBracketParams = bracketParams.split(";");
                    verifyTestCaseParams(key,splittedBracketParams);
                    boolean testcaseExpectVal = false;
                    int expectedRows = Integer.parseInt(splittedBracketParams[1]);

                    String csvpath = "";
                    if (splittedBracketParams.length == 2)
                    {
                        if (splittedBracketParams[0].equals("true"))
                        {
                            testcaseExpectVal = true;
                        }
                        else if (splittedBracketParams[0].equals("false"))
                        {
                            testcaseExpectVal = false;
                        }
                        else
                        {
                            System.out.println("Unrecognize parameter inside of brackets:"+ key+ "=["+ splittedBracketParams[0]+ "]");
                            System.exit(0);
                        }
                        executeFreeHandSQL( testcaseGroups[1], testcaseExpectVal, expectedRows,"SQL: " + key);
                    }
                    else if (splittedBracketParams.length == 3)
                    {
                        csvpath = validatePath(splittedBracketParams[2]);

                        if (splittedBracketParams[0].equals("true"))
                        {
                            testcaseExpectVal = true;
                        }
                        else if (splittedBracketParams[0].equals("false"))
                        {
                            testcaseExpectVal = false;
                        }
                        executeFreeHandSQL(testcaseGroups[1], testcaseExpectVal, expectedRows,csvpath, "SQL: " + key);
                    }
                }
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
    private static String validatePath(String incomingPath)
    {
        if(incomingPath == null || incomingPath.length()==0)
        {
            return incomingPath;
        }
        else if(incomingPath.endsWith("/") || incomingPath.endsWith("\\"))
        {
           incomingPath= incomingPath.substring(0, incomingPath.length()-1);
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
                        testArgs.put(splittedArguments[0].trim(), HPCCJDBCUtils.handleQuotedString(splittedArguments[1].trim()));
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
                if (!(testArgs.containsKey("Config")))
                {
                    System.out.println("Config parameter not found. Ended!");
                    usage();
                }
                if (!(testArgs.containsKey("ReportPath")))
                {
                    System.out.println("ReportPath parameter not found. Ended!");
                    usage();
                }
                String reportFileLocation = validatePath(testArgs.getProperty("ReportPath"));

                try
                {
                    Properties connectionProps = new Properties();
                    File propertyFile= new File(validatePath(testArgs.getProperty("Config")));
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
                if (testArgs.containsKey("SqlScript"))
                {
                    try
                    {
                        hpccTestObject.executeScript(reportFileLocation, testArgs.getProperty("SqlScript"));
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
