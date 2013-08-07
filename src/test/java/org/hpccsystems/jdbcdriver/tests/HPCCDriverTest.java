package org.hpccsystems.jdbcdriver.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;

import javax.swing.filechooser.FileSystemView;

import org.hpccsystems.jdbcdriver.HPCCConnection;
import org.hpccsystems.jdbcdriver.HPCCDatabaseMetaData;
import org.hpccsystems.jdbcdriver.HPCCDriver;
import org.hpccsystems.jdbcdriver.HPCCJDBCUtils;
import org.hpccsystems.jdbcdriver.HPCCPreparedStatement;
import org.hpccsystems.jdbcdriver.HPCCResultSet;
import org.hpccsystems.jdbcdriver.HPCCStatement;
import org.hpccsystems.jdbcdriver.SQLParser;

public class HPCCDriverTest
{
    static int                err   = 0;
    static File               logFile;
    static Date               cdate = new Date();
    static SimpleDateFormat   sdf   = new SimpleDateFormat(
                                            "yyyy_MM_dd-hh-mm-ss");
    static String             date  = sdf.format(cdate);
    static private HPCCDriver driver;
    static HPCCConnection     connectionprops;
    static String             sline = System.getProperty("line.separator");
    static boolean            vmode = false;

    private static boolean testLazyLoading(Properties conninfo)
    {
        boolean success = true;
        try
        {
            conninfo.put("LazyLoad", "true");
            HPCCConnection connection = (HPCCConnection) driver.connect("",
                    conninfo);

            System.out
                    .println("No query nor file loading should have occured yet.");

            ResultSet procs = connection.getMetaData().getProcedures(null,
                    null, null);

            System.out
                    .println("Queries should be cached now. No files should be cached yet.");

            System.out.println("procs found: ");
            while (procs.next())
            {
                System.out.println("   " + procs.getString("PROCEDURE_NAME"));
            }

            ResultSet tables = connection.getMetaData().getTables(null, null,
                    "%", new String[]
                    { "" });

            System.out.println("Tables found: ");
            while (tables.next())
            {
                System.out.println("   " + tables.getString("TABLE_NAME")
                        + " Remarks: \'" + tables.getString("REMARKS") + "\'");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    private static boolean createStandAloneDataMetadata(Properties conninfo)
    {
        boolean success = true;
        try
        {
            HPCCDatabaseMetaData dbmetadata = new HPCCDatabaseMetaData(conninfo);
            success = getDatabaseInfo(dbmetadata);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    private static HPCCConnection connectViaProps(Properties conninfo)
    {
        HPCCConnection connection = null;
        try
        {
            connection = (HPCCConnection) driver.connect("", conninfo);
        }
        catch (Exception e)
        {}
        return connection;
    }

    private static HPCCConnection connectViaUrl(String conninfo)
    {
        HPCCConnection connection = null;
        try
        {
            connection = (HPCCConnection) driver.connect(conninfo, null);
        }
        catch (Exception e)
        {}
        return connection;
    }

    @SuppressWarnings("unused")
    private static boolean printouttable(HPCCConnection connection,
            String tablename)
    {
        boolean success = true;
        try
        {
            ResultSet table = connection.getMetaData().getTables(null, null,
                    tablename, null);

            while (table.next())
                System.out.println("\t" + table.getString("TABLE_NAME"));
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    @SuppressWarnings("unused")
    private static boolean printoutExportedKeys(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet keys = connection.getMetaData().getExportedKeys(null,
                    null, null);

            // while (table.next())
            // System.out.println("\t" + table.getString("TABLE_NAME"));
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    @SuppressWarnings("unused")
    private static boolean printouttables(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet tables = connection.getMetaData().getTables(null, null,
                    "%", null);
            System.out.println("Tables found: ");
            while (tables.next())
            {
                String tablename=null;
                System.out.println("\t" + tables.getString("TABLE_NAME"));
                tablename=tables.getString("TABLE_NAME");
                if(vmode)
                {
                    ResultSet tablecols = connection.getMetaData().getColumns(null,
                            null, tablename, "%");
                    while (tablecols.next())
                        System.out.println("\t\t"+ tablecols.getString("COLUMN_NAME") + "( "
                                + tablecols.getString("TYPE_NAME") + " )");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    @SuppressWarnings("unused")
    private static boolean printouttablecols(HPCCConnection connection,
            String tablename)
    {
        boolean success = true;
        try
        {
            ResultSet tablecols = connection.getMetaData().getColumns(null,
                    null, tablename, "%");

            System.out.println("Table cols found: ");
            while (tablecols.next())
                System.out.println("\t" + tablecols.getString("TABLE_NAME")
                        + "::" + tablecols.getString("COLUMN_NAME") + "( "
                        + tablecols.getString("TYPE_NAME") + " )");
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    private static boolean printoutalltablescols(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet tablecols = connection.getMetaData().getColumns(null,
                    null, "%", "%");

            System.out.println("Table cols found: ");
            while (tablecols.next())
                System.out.println("\t" + tablecols.getString("TABLE_NAME")
                        + "::" + tablecols.getString("COLUMN_NAME") + "( "
                        + tablecols.getString("TYPE_NAME") + " )");

        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    @SuppressWarnings("unused")
    private static boolean printoutprocs(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            String procname=null;
            ResultSet procs = connection.getMetaData().getProcedures(null,
                    null, null);

            System.out.println("Procedures found: ");
            while (procs.next())
            {
                System.out.println("\t" + procs.getString("PROCEDURE_NAME"));
                if (vmode)
                {
                    procname=procs.getString("PROCEDURE_NAME");
                    ResultSet proccols = connection.getMetaData().getProcedureColumns(
                            null, null, procname, null);
                    while (proccols.next())
                        System.out.println("\t\t"+ proccols.getString("COLUMN_NAME") + " (" + proccols.getInt("COLUMN_TYPE") + ")");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    private static boolean printouttypeinfo(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet types = connection.getMetaData().getTypeInfo();

            System.out.println("ECL Types: ");
            int colcount = types.getMetaData().getColumnCount();

            for (int i = 1; i <= colcount; i++)
            {
                System.out.print("[*****"
                        + types.getMetaData().getColumnName(i) + "*****]");
            }
            System.out.println("");

            while (types.next())
            {
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[ " + types.getObject(i) + " ]");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    @SuppressWarnings("unused")
    private static boolean printoutproccols(HPCCConnection connection)
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
                    System.out.println("\t"
                            + proccols.getString("PROCEDURE_NAME")
                            + proccols.getString("PROCEDURE_NAME") + "::"
                            + proccols.getString("COLUMN_NAME") + " ("
                            + proccols.getInt("COLUMN_TYPE") + ")");
            }

        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    private static PreparedStatement createPrepStatement(
            HPCCConnection hpccconnection, String SQL) throws Exception
    {
        if (hpccconnection == null)
            throw new Exception("Could not connect with properties object");

        return hpccconnection.prepareStatement(SQL);
    }

    private static boolean reusePrepStatement(PreparedStatement p)
    {
        boolean success = true;
        try
        {
            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p)
                    .executeQuery();

            ResultSetMetaData meta = qrs.getMetaData();
            System.out.println();

            int colcount = meta.getColumnCount();
            for (int i = 1; i <= colcount; i++)
            {
                System.out.print("[*****" + meta.getColumnName(i) + "*****]");
            }
            System.out.println("");

            while (qrs.next())
            {
                System.out.println();
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[ " + qrs.getObject(i) + " ]");
                }
            }
            System.out.println("\nTotal Records found: " + qrs.getRowCount());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static boolean testClosePrepStatementUse(Properties conninfo)
    {
        boolean success = true;
        try
        {
            HPCCConnection connectionprops = connectViaProps(conninfo);
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            String SQL = "select * from tutorial::rp::tutorialperson persons where zip= ? limit 100";
            HPCCPreparedStatement p = (HPCCPreparedStatement) createPrepStatement(
                    connectionprops, SQL);

            p.close();
            p.execute();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static boolean testPrepStatementReuse(Properties conninfo)
    {
        boolean success = true;
        try
        {
            HPCCConnection connectionprops = connectViaProps(conninfo);
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            String SQL = "select * from tutorial::rp::tutorialperson persons where zip= ? limit 100";
            HPCCPreparedStatement p = (HPCCPreparedStatement) createPrepStatement(
                    connectionprops, SQL);

            for (int i = 33445; i < 33448; i++)
            {
                p.clearParameters();
                p.setString(1, "'" + Integer.toString(i, 10) + "'");
                success &= reusePrepStatement(p);
            }

            SQL = "call myroxie::fetchpeoplebyzipservice(?)";

            p = (HPCCPreparedStatement) createPrepStatement(connectionprops,
                    SQL);

            for (int i = 33445; i < 33448; i++)
            {
                p.clearParameters();
                p.setString(1, Integer.toString(i, 10));
                success &= reusePrepStatement(p);
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;

    }

    public static boolean testPrepStatementReuseBadQuery(Properties conninfo)
    {
        boolean success = true;
        try
        {
            HPCCConnection connectionprops = connectViaProps(conninfo);
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            String SQL = "call bogusSPname()";
            HPCCPreparedStatement p = null;
            try
            {
                p = (HPCCPreparedStatement) createPrepStatement(
                        connectionprops, SQL);
            }
            catch (Exception e)
            {
                System.out.println("Ignoring expected exception: "
                        + e.getLocalizedMessage());
            }

            p.executeQuery();

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    private static void freeHandSQL_Report(String sql, String status,
            String desc, int count)
    {
        try
        {

            FileWriter fw = new FileWriter(logFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i != count; count--)
            {
                err++;

                bw.write(err + "." + status + " || " + desc + " || " + sql
                        + sline);
                bw.write(sline);

            }

            bw.close();

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
                String q = sql.substring(sql.indexOf("(") + 1,
                        sql.indexOf(")") - 1);

                String[] ar = q.split(",");
                found = ar.length;
            }
        }
        return found;
    }

    private static void executeFreeHandSQL(HPCCConnection connectionprops,
            String SQL, List<String> params, boolean expectPass,
            int minResults, String csvpath, String testName)
            throws SQLException
    {

        // TODO Auto-generated method stub
        String csvFile = csvpath;
        BufferedReader br = null;
        String line = null;
        String cvsSplitBy = ",";
        int errcount = 0;
        boolean success = true;
        String emessage = null;
        String paramVal = null;

        try
        {
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            PreparedStatement p = connectionprops.prepareStatement(SQL);

            p.clearParameters();
            FileReader file = new FileReader(csvFile);

            br = new BufferedReader(new FileReader(csvFile));
            while (!((line = br.readLine()).isEmpty()))
            {
                SQLParser ph = new SQLParser();
                ph.process(SQL);
                int countparam = ph.assignParameterIndexes();
                int callparam = parseCallParams(SQL);

                String[] csvlines = line.split(cvsSplitBy);
                params = Arrays.asList(csvlines);

                for (int i = 0; i < params.size(); i++)
                {
                    p.setObject(i + 1, params.get(i));
                    paramVal = params.get(i);
                    if (vmode)
                    {
                        System.out.println(SQL + "--?=" + paramVal);
                    }
                }
                if (countparam != params.size() && !(SQL.contains("call")))
                {
                    System.out.println("Warning: Parameters size:" + paramVal
                            + " does not match the size of"
                            + "prepared statement:" + SQL);
                }
                if (callparam != params.size() && !(SQL.contains("select")))
                {
                    System.out.println("Warning: Parameters size:" + paramVal
                            + " does not match the size of"
                            + "prepared statement:" + SQL);
                }

                HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p)
                        .executeQuery();

                ResultSetMetaData meta = qrs.getMetaData();

                int colcount = meta.getColumnCount();
                int resultcount = qrs.getRowCount();
                success = (resultcount >= minResults);
                if (success && expectPass)
                {
                    errcount = 1;

                    freeHandSQL_Report(SQL + "--Value:" + paramVal, "PASSED",
                            testName, errcount);
                }

                if (resultcount > 0 && vmode)
                {
                    for (int i = 1; i <= colcount; i++)
                    {
                        System.out.print("[*****" + meta.getColumnName(i)
                                + "*****]");
                    }
                    System.out.println("");
                    for (int i = 1; i <= colcount; i++)
                    {
                        System.out.print("[^^^^^" + meta.getColumnLabel(i)
                                + "^^^^^]");
                    }
                    System.out.println();
                    for (int i = 1; i <= meta.getColumnCount(); i++)
                    {
                        System.out.print("[+++++"
                                + HPCCJDBCUtils
                                        .convertSQLtype2JavaClassName(meta
                                                .getColumnType(i)) + "+++++]");
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

            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {

        }
        catch (Exception e)
        {

            emessage = e.getMessage();

            success = false;

        }

        if (!success && expectPass)
        {
            errcount = 1;
            freeHandSQL_Report(SQL + "--Value:" + paramVal, "FAILED: "
                    + emessage, testName, errcount);

        }
        else if (success && !expectPass)
        {
            errcount = 1;
            freeHandSQL_Report(SQL + "--Value:" + paramVal,
                    "UNEXPECTEDLY PASSED!!", testName, errcount);
        }

        if (br != null)
        {
            try
            {
                br.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void executeFreeHandSQL(HPCCConnection connectionprops,
            String SQL, List<String> params, boolean expectPass,
            int minResults, String testName)
    {

        int errcount = 0;
        boolean success = true;
        String emessage = null;

        try
        {
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            PreparedStatement p = connectionprops.prepareStatement(SQL);
            p.clearParameters();

            for (int i = 0; i < params.size(); i++)
            {
                p.setObject(i + 1, params.get(i));
            }

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p)
                    .executeQuery();

            ResultSetMetaData meta = qrs.getMetaData();

            int colcount = meta.getColumnCount();
            int resultcount = qrs.getRowCount();

            if (resultcount > 0 && vmode)
            {
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[*****" + meta.getColumnName(i)
                            + "*****]");
                }
                System.out.println("");
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[^^^^^" + meta.getColumnLabel(i)
                            + "^^^^^]");
                }
                System.out.println();
                for (int i = 1; i <= meta.getColumnCount(); i++)
                {
                    System.out.print("[+++++"
                            + HPCCJDBCUtils.convertSQLtype2JavaClassName(meta
                                    .getColumnType(i)) + "+++++]");
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

            success = (resultcount >= minResults);

        }
        catch (Exception e)
        {
            emessage = e.getMessage();
            success = false;
        }

        if (!success && expectPass)
        {
            errcount = 1;
            freeHandSQL_Report(SQL, "FAILED: " + emessage, testName, errcount);

        }
        else if (success && !expectPass)
        {
            errcount = 1;
            freeHandSQL_Report(SQL, "UNEXPECTEDLY PASSED!!", testName, errcount);
        }
        else if (success && expectPass)
        {
            errcount = 1;
            freeHandSQL_Report(SQL, "PASSED", testName, errcount);
        }
    }

    private static boolean testSelect1(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            PreparedStatement p = connection
                    .prepareStatement("Select 1 AS ONE");

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p)
                    .executeQuery();

            System.out.println("---------Testing Select 1---------------");

            while (qrs.next())
            {
                if (qrs.getInt(1) != 1)
                    success = false;
            }

            System.out.println("\tTest Success: " + success);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
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
            System.out.println("\tDriver Major: "
                    + dbmetadata.getDriverMajorVersion());
            System.out.println("\tDriver Minor: "
                    + dbmetadata.getDriverMinorVersion());
            System.out.println("\tSQL Key Words: " + sqlkeywords);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static synchronized boolean printOutResultSet(
            HPCCResultSet resultset, long threadid)
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

                for (int y = 0; y < (colname.length() >= padvalue ? 0
                        : (padvalue - colname.length()) / 2); y++)
                    System.out.print(" ");
                System.out.print(colname);

                for (int y = 0; y < (colname.length() >= padvalue ? 0
                        : (padvalue - colname.length()) / 2); y++)
                    System.out.print(" ");

                System.out.print("]");
            }
            System.out.println("");

            for (int i = 1; i <= colcount; i++)
            {
                String collabel = meta.getColumnLabel(i);
                System.out.print("[");

                for (int y = 0; y < (collabel.length() >= padvalue ? 0
                        : (padvalue - collabel.length()) / 2); y++)
                    System.out.print("^");
                System.out.print(collabel);

                for (int y = 0; y < (collabel.length() >= padvalue ? 0
                        : (padvalue - collabel.length()) / 2); y++)
                    System.out.print("^");

                System.out.print("]");
            }
            System.out.println();

            for (int i = 1; i <= colcount; i++)
            {
                String coltype = HPCCJDBCUtils
                        .convertSQLtype2JavaClassName(meta.getColumnType(i));
                System.out.print("[");

                for (int y = 0; y < (coltype.length() >= padvalue ? 0
                        : (padvalue - coltype.length()) / 2); y++)
                    System.out.print(" ");
                System.out.print(coltype);

                for (int y = 0; y < (coltype.length() >= padvalue ? 0
                        : (padvalue - coltype.length()) / 2); y++)
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

                    for (int y = 0; y < (result.length() >= padvalue ? 0
                            : padvalue - result.length()); y++)
                        System.out.print(" ");
                    System.out.print(result);
                    System.out.print("]");
                }
            }

            System.out.println("\nTotal Records found: "
                    + resultset.getRowCount());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            isSuccess = false;
        }
        return isSuccess;
    }

    private static boolean runParralellTest(HPCCConnection conn)
    {
        List<HPCCDriverTestThread> runnables = new ArrayList<HPCCDriverTestThread>();

        boolean success = true;
        try
        {
            Properties params = new Properties();
            params.put("1", "'90210'");
            HPCCDriverTestThread workThread1 = new HPCCDriverTestThread(
                    conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip = ? limit 100",
                    params);
            runnables.add(workThread1);

            Properties params2 = new Properties();
            params2.put("1", "'33445'");
            HPCCDriverTestThread workThread2 = new HPCCDriverTestThread(
                    conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip = ? limit 100",
                    params2);
            runnables.add(workThread2);

            Properties params3 = new Properties();
            params3.put("1", "'33487'");
            HPCCDriverTestThread workThread3 = new HPCCDriverTestThread(
                    conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip < ? and persons.zip != '65536' limit 10000",
                    params3);
            runnables.add(workThread3);

            for (HPCCDriverTestThread thrd : runnables)
            {
                thrd.start();
            }

            boolean threadsrunning;
            do
            {
                threadsrunning = false;
                for (HPCCDriverTestThread thrd : runnables)
                {
                    threadsrunning = thrd.isRunning() || threadsrunning;
                }
                Thread.sleep(250);
            }
            while (threadsrunning);

            for (HPCCDriverTestThread thrd : runnables)
            {
                success &= thrd.isSuccess();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    private static boolean runFullTest(Properties propsinfo)
    {

        List<String> params = new ArrayList<String>();
        boolean success = true;
        String infourl = "jdbc:hpcc;";

        try
        {

            if (!getDatabaseInfo(connectionprops))
                throw new RuntimeException("Could not fetch DB Info");
            if (!testSelect1(connectionprops))
                throw new RuntimeException("TestSelect1 failed");

            HPCCConnection connectionurl = connectViaUrl(infourl);
            if (!(connectionurl != null))
                throw new RuntimeException("Could not connect with URL");

            if (testClosePrepStatementUse(propsinfo))
                throw new RuntimeException("testClosePrepStatementUse passed");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static void usage()
    {

        System.out
                .println("********************************************************************");
        System.out.println("HPCC JDBC Test Package Usage:");
        System.out.println(" HPCCDriverTest "
                + "Config=<configuration file path>"
                + " ReportPath=<Path where report should be created>"
                + " [options]\n" + "where options: "
                + "SqlScript=<path to sql script file>\n" + "-V\n\n");
        System.out
                .println(" eg. Config=C:\\Users\\username\\folder\\config_file.txt");
        System.out
                .println(" eg.For Windows: ReportPath=C:\\Users\\username\\folder");
        System.out
                .println(" eg. SqlScript=C:\\Users\\username\\folder\\Sql_file.txt");
        System.out.println();
        System.out.println(" By default Automated Mode is executed.");
        System.out
                .println(" To execute SqlScript, add sql statement inside of file:");
        System.out.println("  Test1=<SQL STATEMENT>");
        System.out.println("  Test2=<SQL STATEMENT>");
        System.out.println("  eg. Test1=select * from tablename limit 100");
        System.out
                .println("  eg. Test1=[true;1;path to data file]select * from tablename where zip=? limit 100");
        System.out
                .println(" By default TraceLevel is set to INFO if property is not found in configuration file\n");
        System.out
                .println(" If Verbose Mode is actived, Tracelevel is set to ALL and driver properties are written to Report file ");
        System.out.println();
        System.out
                .println("********************************************************************\n");

    }

    public static void runAutoTest(HPCCConnection connProp, Properties configP)
    {
        try
        {
            if (connProp == null)
                throw new RuntimeException(
                        "Could not connect with properties object");

            ResultSet pro = connProp.getDatabaseMetaData().getProcedures(null,
                    null, null);

            if (!runFullTest(configP))
            {
                throw new RuntimeException("Full test failed.");
            }

        }
        catch (SQLException sq)
        {
            sq.printStackTrace();
        }

    }

    public static void main(String[] args)
    {

        try
        {

            FileInputStream fin, fin2 = null;
            File file, Sql_file = null;

            Properties info = new Properties();
            Properties prop = new Properties();
            Properties myargsprop = new Properties();
            if (args.length == 0)
            {
                System.out.println("0 parameters found. Failed");
                usage();
                System.exit(0);
            }

            if (args.length > 4)
            {
                System.out
                        .println("Exceeding number of  parameters found. Failed");
                usage();
                System.exit(0);
            }

            for (int i = 0; i < args.length; i++)
            {
                if (args[i].contains("="))
                {
                    String mysplit[] = args[i].split("=");
                    myargsprop
                            .put(mysplit[0].trim(), HPCCJDBCUtils
                                    .handleQuotedString(mysplit[1].trim()));
                }
            }
            System.out.println("-----------------------HPCCJDBC Driver Test Suite-----------------------");
            System.out.println("========================================================================");
            System.out.println();
            if (args[args.length - 1].equals("-V"))
            {
                vmode = true;
            }

            if (!(myargsprop.containsKey("Config")))
            {
                System.out.println("Config parameter not found. Ended!");
                usage();
                System.exit(0);
            }
            if (!(myargsprop.containsKey("ReportPath")))
            {
                System.out.println("ReportPath parameter not found. Ended!");
                usage();
                System.exit(0);
            }

            String check = myargsprop.getProperty("ReportPath");
            if ((check.endsWith("/")) || (check.endsWith("\\")))
            {
                System.out
                        .println("Remove seperator at the end of 'ReportPath' parameter and run again-Ended!");
                usage();
                System.exit(0);
            }

            List<String> params = new ArrayList<String>();

            driver = new HPCCDriver();
            Driver ldriver = DriverManager.getDriver("jdbc:hpcc");

            if (!(ldriver instanceof HPCCDriver))
                throw new RuntimeException(
                        "Driver fetched with 'jdbc:hpcc' url is not of HPCCDriver type");
            if (!driver.acceptsURL("jdbc:hpcc"))
                throw new RuntimeException(
                        "Valid lower case JDBC URL test failed");
            if (!driver.acceptsURL("JDBC:hpcc"))
                throw new RuntimeException(
                        "Valid mixed case JDBC URL test1 failed");
            if (!driver.acceptsURL("JDBC:HPCC"))
                throw new RuntimeException(
                        "Valid upper case JDBC URL test failed");
            if (!driver.acceptsURL("jdbc:HPCC"))
                throw new RuntimeException(
                        "Valid mixed case JDBC URL test2 failed");
            if (!driver.acceptsURL("jDbC:hPcC"))
                throw new RuntimeException(
                        "Valid camel case JDBC URL test2 failed");

            if (!driver.acceptsURL("jdbc:hpcc;"))
                throw new RuntimeException(
                        "Valid seperator JDBC URL test failed");
            if (!driver.acceptsURL("jdbc:hpcc;prop1=val1;prop2=val2"))
                throw new RuntimeException(
                        "Valid properties JDBC URL semicolon test failed");
            if (!driver.acceptsURL("jdbc:hpcc:prop1=val1:prop2=val2"))
                throw new RuntimeException(
                        "Valid properties JDBC URL colon test failed");
            if (!driver.acceptsURL("jdbc:hpcc:"))
                throw new RuntimeException(
                        "Valid seperator JDBC URL test passed");
            if (driver.acceptsURL("jdbc : hpcc"))
                throw new RuntimeException(
                        "Invalid spaces JDBC URL test passed");
            if (!driver.acceptsURL("jdbc:hpcc:prop1=val1;prop2=val2"))
                throw new RuntimeException("Valid JDBC URL test failed");
            if (driver.acceptsURL("  jdbc:hpcc"))
                throw new RuntimeException(
                        "Invalid spaces JDBC URL test2 passed");
            if (driver.acceptsURL("Garbage"))
                throw new RuntimeException(
                        "Invalid garbage JDBC URL test passed");
            if (driver.acceptsURL("url:jdbc:hpcc"))
                throw new RuntimeException(
                        "Invalid prefix JDBC URL test passed");
            if (driver.acceptsURL(""))
                throw new RuntimeException("Invalid empty JDBC URL test passed");
            if (driver.acceptsURL(" "))
                throw new RuntimeException(
                        "Invalid singlespace JDBC URL test passed");
            if (driver.acceptsURL(null))
                throw new RuntimeException("Invalid null JDBC URL test passed");

            file = new File(myargsprop.getProperty("Config"));
            fin = new FileInputStream(file);
            prop.load(fin);
            connectionprops = connectViaProps(prop);
            if (connectionprops == null)
                throw new RuntimeException(
                        "Could not connect with properties object");

            logFile = new File(check + File.separator + "HPCCJDBCTEST_" + date
                    + ".log");
            FileWriter fw = new FileWriter(logFile, true);
            BufferedWriter bwrite = new BufferedWriter(fw);

            if (!logFile.exists())
            {
                logFile.createNewFile();
            }

            if (!(prop.containsKey("TraceLevel")))
            {
                prop.put("TraceLevel", "INFO");
            }

            if (myargsprop.containsKey("SqlScript"))
            {
                if (vmode)
                {

                    if (!(prop.containsKey("TraceLevel")))
                    {
                        prop.put("TraceLevel", "ALL");
                        System.out.println(prop.getProperty("TraceLevel"));
                    }
                    if (!(prop.containsKey("TraceToFile")))
                    {
                        prop.put("TraceToFile", "true");
                    }
                    System.out.println("Verbose mode ON!");
                    DriverPropertyInfo[] driver_info = driver.getPropertyInfo(
                            "", null);
                    bwrite.write("-----------------Driver Properties----------------------------------"
                            + sline);

                    for (int i = 0; i < driver_info.length; i++)
                        bwrite.write(driver_info[i].name + ": "
                                + driver_info[i].description + sline);
                    bwrite.write("--------------------------------------------------------------------------------------------------------------"
                            + sline);
                }
                else if (!(prop.containsKey("TraceLevel")))
                {

                    prop.put("TraceLevel", "INFO");
                }

                bwrite.write("                         Status                    ||          SQL          ||             Description    "
                        + sline);
                bwrite.write("--------------------------------------------------------------------------------------------------------------"
                        + sline);
                bwrite.close();
                Sql_file = new File(myargsprop.getProperty("SqlScript"));
                fin2 = new FileInputStream(Sql_file);
                info.load(fin2);
                System.out
                        .println("SqlScript parameter found-Scripted Mode Started...\n");

                List<String> testcase = new ArrayList();
                System.out
                        .println("Processing regular and/or prepared statements...");
                for (String key : info.stringPropertyNames())
                {
                    String value = info.getProperty(key);

                    if (HPCCJDBCUtils.testcase(value))
                    {
                        testcase = HPCCJDBCUtils.testcaseList(value);

                        String[] parts_ar = testcase
                                .toArray(new String[testcase.size()]);

                        if (parts_ar[0] == null)
                        {
                            executeFreeHandSQL(connectionprops, value, params,
                                    true, 0, "SQL: " + key);
                        }
                        else if (parts_ar[1] != null)
                        {
                            String rbrackets = parts_ar[0].substring(
                                    parts_ar[0].indexOf("[") + 1,
                                    parts_ar[0].indexOf("]"));

                            String[] location = rbrackets.split(";");
                            boolean checkb = false;
                            int bool = Integer.parseInt(location[1]);

                            String csvpath = "";
                            if (location.length == 2)
                            {
                                if (location[0].equals("true"))
                                {
                                    checkb = true;
                                }
                                else if (location[0].equals("false"))
                                {
                                    checkb = false;
                                }
                                else
                                {
                                    System.out
                                            .println("Unrecognize parameter inside of brackets:"
                                                    + key
                                                    + "=["
                                                    + location[0]
                                                    + "]");
                                    System.exit(0);

                                }
                                executeFreeHandSQL(connectionprops,
                                        parts_ar[1], params, checkb, bool,
                                        "SQL: " + key);
                            }
                            if (location.length == 3)
                            {
                                csvpath = location[2];

                                if (location[0].equals("true"))
                                {
                                    checkb = true;
                                }
                                else if (location[0].equals("false"))
                                {
                                    checkb = false;
                                }
                                else
                                {
                                    System.out
                                            .println("Unrecognize parameter inside of brackets:"
                                                    + key
                                                    + "=["
                                                    + location[0]
                                                    + "]");
                                    System.exit(0);

                                }
                                executeFreeHandSQL(connectionprops,
                                        parts_ar[1], params, checkb, bool,
                                        csvpath, "SQL: " + key);
                            }
                        }

                    }
                }
            }
            else
            {
                System.out
                        .println("SqlScript parameter not found-Displaying target HPCC System info...");
                System.out
                        .println("--------------------------------------------------------");
                System.out.println();
                String infourl = "jdbc:hpcc;";
                if (connectionprops == null)
                    throw new RuntimeException(
                            "Could not connect with properties object");
                HPCCConnection connectionurl = connectViaUrl(infourl);
                if (!(connectionurl != null))
                    throw new RuntimeException("Could not connect with URL");
                if (!getDatabaseInfo(connectionurl))
                    throw new RuntimeException("Could not fetch DB Info");
                if (!printouttypeinfo(connectViaProps(prop)))
                    throw new RuntimeException("Print ECL types failed");
                System.out.println("Connecting with properties from Config file...");
                System.out.println();
                if (!printouttables(connectionprops))
                    throw new RuntimeException("printout alltables failed");
                if (!printoutprocs(connectionprops))
                    throw new RuntimeException("printout procs failed");
                System.out.println("\n Target System Info-Completed");
                System.exit(0);
            }
        }

        catch (FileNotFoundException nf)
        {
            System.out.println(nf);
            System.out.println();
            usage();
            System.exit(0);
        }
        catch (IOException ex)
        {
            System.out.println("Invalid ReportPath location-Ended!");
            System.out.println();
            usage();
            System.exit(0);
        }
        catch (SQLException sql)
        {
            sql.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }

        System.out
                .println("\nHPCC Driver completed test - Statement executed: "
                        + err + " -Verify ReportPath location for Report");

    }

}
