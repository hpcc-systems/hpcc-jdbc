package org.hpccsystems.jdbcdriver.tests;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hpccsystems.jdbcdriver.HPCCConnection;
import org.hpccsystems.jdbcdriver.HPCCDatabaseMetaData;
import org.hpccsystems.jdbcdriver.HPCCDriver;
import org.hpccsystems.jdbcdriver.HPCCJDBCUtils;
import org.hpccsystems.jdbcdriver.HPCCPreparedStatement;
import org.hpccsystems.jdbcdriver.HPCCResultSet;

public class HPCCDriverTest
{
    static private HPCCDriver driver;

    static
    {
        driver = new HPCCDriver();
        try
        {
            DriverPropertyInfo[] info = driver.getPropertyInfo("", null);

            System.out.println("-----------------Driver Properties----------------------------------");
            for (int i = 0; i < info.length; i++)
               System.out.println("\t" + info[i].name + ": " + info[i].description);
            System.out.println("\n--------------------------------------------------------------------");
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static boolean testLazyLoading(Properties conninfo)
    {
        boolean success = true;
        try
        {
            conninfo.put("LazyLoad", "true");
            HPCCConnection connection = (HPCCConnection) driver.connect("", conninfo);

            System.out.println("No query nor file loading should have occured yet.");

            ResultSet procs = connection.getMetaData().getProcedures(null, null, null);

            System.out.println("Queries should be cached now. No files should be cached yet.");

            System.out.println("procs found: ");
            while (procs.next())
            {
                System.out.println("   " + procs.getString("PROCEDURE_NAME"));
            }

            ResultSet tables = connection.getMetaData().getTables(null, null, "%", new String[]
            { "" });

            System.out.println("Tables found: ");
            while (tables.next())
            {
                System.out.println("   " + tables.getString("TABLE_NAME") + " Remarks: \'"
                        + tables.getString("REMARKS") + "\'");
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
        {
        }
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
        {
        }
        return connection;
    }

    @SuppressWarnings("unused")
    private static boolean printouttable(HPCCConnection connection, String tablename)
    {
        boolean success = true;
        try
        {
            ResultSet table = connection.getMetaData().getTables(null, null, tablename, null);

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
            ResultSet keys = connection.getMetaData().getExportedKeys(null, null, null);

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
            ResultSet tables = connection.getMetaData().getTables(null, null, "%", null);

            System.out.println("Tables found: ");
            while (tables.next())
                System.out.println("\t" + tables.getString("TABLE_NAME"));
        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
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

    private static boolean printoutalltablescols(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet tablecols = connection.getMetaData().getColumns(null, null, "%", "%");

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

    @SuppressWarnings("unused")
    private static boolean printoutprocs(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            ResultSet procs = connection.getMetaData().getProcedures(null, null, null);

            System.out.println("procs found: ");
            while (procs.next())
                System.out.println("\t" + procs.getString("PROCEDURE_NAME"));

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
                System.out.print("[*****" + types.getMetaData().getColumnName(i) + "*****]");
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
            ResultSet proccols = connection.getMetaData().getProcedureColumns(null, null, null, null);

            System.out.println("procs cols found: ");
            while (proccols.next())
                System.out.println("\t" + proccols.getString("PROCEDURE_NAME") + proccols.getString("PROCEDURE_NAME")
                        + "::" + proccols.getString("COLUMN_NAME") + " (" + proccols.getInt("COLUMN_TYPE") + ")");

        }
        catch (Exception e)
        {
            success = false;
        }
        return success;
    }

    private static PreparedStatement createPrepStatement(HPCCConnection hpccconnection, String SQL) throws Exception
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
            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();

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
            HPCCPreparedStatement p = (HPCCPreparedStatement)createPrepStatement(connectionprops, SQL);

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
            HPCCPreparedStatement p = (HPCCPreparedStatement)createPrepStatement(connectionprops, SQL);

            for (int i = 33445; i < 33448; i++)
            {
                p.clearParameters();
                p.setString(1, "'" + Integer.toString(i, 10) + "'");
                success &= reusePrepStatement(p);
            }

            SQL = "call myroxie::fetchpeoplebyzipservice(?)";

            p = (HPCCPreparedStatement)createPrepStatement(connectionprops, SQL);

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
                p = (HPCCPreparedStatement)createPrepStatement(connectionprops, SQL);
            } catch (Exception e)
            {
                System.out.println("Ignoring expected exception: " + e.getLocalizedMessage());
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

    private static void executeFreeHandSQL(Properties conninfo, String SQL, List<String> params, boolean expectPass, int minResults, String testName)
    {
        boolean success = true;
        try
        {
            HPCCConnection connectionprops = connectViaProps(conninfo);
            if (connectionprops == null)
                throw new Exception("Could not connect with properties object");

            PreparedStatement p = connectionprops.prepareStatement(SQL);
            p.clearParameters();

            for (int i = 0; i < params.size(); i++)
            {
                p.setObject(i + 1, params.get(i));
            }

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();

            ResultSetMetaData meta = qrs.getMetaData();
            System.out.println();

            int colcount = meta.getColumnCount();
            int resultcount = qrs.getRowCount();

            if (resultcount > 0 )
            {
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[*****" + meta.getColumnName(i) + "*****]");
                }
                System.out.println("");
                for (int i = 1; i <= colcount; i++)
                {
                    System.out.print("[^^^^^" + meta.getColumnLabel(i) + "^^^^^]");
                }
                System.out.println();
                for (int i = 1; i <= meta.getColumnCount(); i++)
                {
                    System.out.print("[+++++" + HPCCJDBCUtils.convertSQLtype2JavaClassName(meta.getColumnType(i))  + "+++++]");
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

            System.out.println("\nTotal Records found: " + resultcount);

            success = (resultcount >= minResults);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            success = false;
        }

        if (!success && expectPass)
            throw new RuntimeException(testName + " - FAILED!");
        else if ( success && !expectPass)
            throw new RuntimeException(testName + " - UNEXPECTEDLY PASSED!");
    }

    private static boolean testSelect1(HPCCConnection connection)
    {
        boolean success = true;
        try
        {
            PreparedStatement p = connection.prepareStatement("Select 1 AS ONE");

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) p).executeQuery();

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

    private static boolean runParralellTest(HPCCConnection conn)
    {
        List<HPCCDriverTestThread> runnables = new ArrayList<HPCCDriverTestThread>();

        boolean success = true;
        try
        {
            Properties params = new Properties();
            params.put("1", "'90210'");
            HPCCDriverTestThread workThread1 = new HPCCDriverTestThread(conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip = ? limit 100", params);
            runnables.add(workThread1);

            Properties params2 = new Properties();
            params2.put("1", "'33445'");
            HPCCDriverTestThread workThread2 = new HPCCDriverTestThread(conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip = ? limit 100", params2);
            runnables.add(workThread2);

            Properties params3 = new Properties();
            params3.put("1", "'33487'");
            HPCCDriverTestThread workThread3 = new HPCCDriverTestThread(conn,
                    "select * from tutorial::rp::tutorialperson as persons where persons.zip < ? and persons.zip != '65536' limit 10000", params3);
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
            } while (threadsrunning);

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
            System.out.println("************************************************");
            System.out.println("Running full test with following configuration:");
            for(Object okey : propsinfo.keySet() )
            {
                String key = (String) okey;
                infourl += key + "=" + propsinfo.getProperty(key) + ";";
                System.out.println(key +": " + propsinfo.getProperty(key));
            }
            System.out.println("************************************************");

            if (!testLazyLoading(propsinfo))
                    throw new RuntimeException("Lazy loading failed");

            if (!createStandAloneDataMetadata(propsinfo))
                    throw new RuntimeException("Stand-alone metadata failed");

            HPCCConnection connectionprops = connectViaProps(propsinfo);
            if (connectionprops == null)
                throw new RuntimeException("Could not connect with properties object");

            if (! getDatabaseInfo(connectionprops) )
                throw new RuntimeException("Could not fetch DB Info");
            if (! testSelect1(connectionprops) )
                throw new RuntimeException("TestSelect1 failed");

            HPCCConnection connectionurl = connectViaUrl(infourl);
            if (! (connectionurl != null) )
                throw new RuntimeException("Could not connect with URL");
            if (! getDatabaseInfo(connectionurl) )
                throw new RuntimeException("Could not fetch DB Info");

            if (! printouttypeinfo(connectViaProps(propsinfo)))
                throw new RuntimeException("Print ECL types failed");
            if (! printoutalltablescols(connectViaProps(propsinfo)) )
                throw new RuntimeException("printout alltablescols failed");
            if (! testPrepStatementReuse(propsinfo) )
                throw new RuntimeException("testPrepStatementReuse failed");
            if (testClosePrepStatementUse(propsinfo))
                throw new RuntimeException("testClosePrepStatementUse passed");
            if (testPrepStatementReuseBadQuery(propsinfo))
                throw new RuntimeException("testPrepStatementReuseBadQuery passed");
            //if (! runParralellTest(connectionprops) )
            //    throw new RuntimeException("Parrallel Connection reuse test failed");

            executeFreeHandSQL(propsinfo,
                    "call myroxie::fetchpeoplebyzipservice(33488)",
                    params, true,1, "Call fullyqualified published query");

            params.clear();
            params.add("33445");

            executeFreeHandSQL(propsinfo,
                    "call myroxie::fetchpeoplebyzipservice(?)",
                    params, true, 1, "Call fullyqualified published query, parametrized input");

            params.clear();
            executeFreeHandSQL(propsinfo,
                    "call myroxie::fetchpeoplebyzipservice(?)",
                    params, false, 0, "Call parameterized query with empty params");

            executeFreeHandSQL(propsinfo,
                    "call myroxie::fetchpeoplebyzipservice()",
                    params, false, 0, "Call published query not enough in-params");

            executeFreeHandSQL(propsinfo,
                    "call bogusSPName()",
                    params, false, 0, "Call non-existant published query");

            params.add("'33445'");
            params.add("'90210'");

            executeFreeHandSQL(propsinfo,"select 1", params, true, 1, "Select single numeric constant");
            executeFreeHandSQL(propsinfo,"select 1,2,3,4", params, true, 1, "Select four numeric constants");
            executeFreeHandSQL(propsinfo,"select '1a'", params, true, 1, "Select single string constant");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from progguide::exampledata::people peeps where ( peeps.firstname = 'TIMTOHY' ) limit 100 ",
                    params, true, 1, "encapsulated where clause");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from progguide::exampledata::people peeps where ( peeps.firstname IN ('TIMTOHY') ) limit 100 ",
                    params, true, 1, "encapsulated where clause with IN () operator");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from progguide::exampledata::people peeps where ( peeps.firstname NOT IN ('TIMTOHY') ) limit 100 ",
                    params, true, 1, "encapsulated where clause with NOT IN () operator");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from progguide::exampledata::people peeps where ( peeps.firstname IN ('TIMTOHY')  limit 100 ",
                    params, false, 0, "invalid encapsulated where clause missing ) ");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from progguide::exampledata::people peeps where ( peeps.firstname = 'TIMTOHY'  limit 100 ",
                    params, false, 0, "2 invalid encapsulated where clause missing ) ");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from tutorial::rp::tutorialperson as persons, progguide::exampledata::people peeps where  persons.firstname = peeps.firstname and persons.city  = upper('delray beach') limit 100",
                    params, true, 1, "implicit join");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from tutorial::rp::tutorialperson as persons, progguide::exampledata::people peeps where  persons.firstname = peeps.firstname and persons.city is not null limit 100",
                    params, true, 1, "implicit join IS NOT NULL filter");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from tutorial::rp::tutorialperson as persons, progguide::exampledata::people peeps where  persons.firstname = peeps.firstname and persons.city is null limit 100",
                    params, true, 0, "implicit join IS NULL filter");

            executeFreeHandSQL(propsinfo,
                    "select  peeps.gender, peeps.firstname, peeps.lastname from tutorial::rp::tutorialperson as persons, progguide::exampledata::people peeps outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where  persons.firstname = peeps.firstname and persons.city  > upper('delray') limit 100",
                    params, false, 0, "implicit join + explicit join");

            executeFreeHandSQL(propsinfo,
                    "select  * from tutorial::rp::tutorialperson as persons where  persons.city  > upper('delray') limit 100",
                    params, true, 1, "select where upper(\'literal\')");

            executeFreeHandSQL(propsinfo,
                    "select  * from tutorial::rp::tutorialperson as persons where  lower(persons.city)  = 'delray beach' limit 100",
                    params, true, 1, "select where lower(field)");

            executeFreeHandSQL(propsinfo,
                    "select  upper(firstname), lower(lastname) from tutorial::rp::tutorialperson as persons where  persons.city  = 'DELRAY BEACH' limit 100",
                    params, true, 1, "select upper(col) where ");

            executeFreeHandSQL(propsinfo,
                    "select  count( persons.city)  from tutorial::rp::tutorialperson as persons where  persons.city  > 'DELRAY' group by city having count(city) < 22 limit 100",
                    params, true, 1, "count having single field scalar output");

            executeFreeHandSQL(propsinfo,
                    "select  count( persons.zip), zip  from tutorial::rp::tutorialperson as persons where  persons.zip  > '33445' group by zip having count(zip) > 20 limit 100",
                    params, true, 1, "count having single field payload indexed");

            executeFreeHandSQL(propsinfo,
                    "select  count( persons.city), city  from tutorial::rp::tutorialperson as persons where  persons.city  > 'DELRAY' group by zip having count(city) < 22 limit 100",
                    params, true, 1, "count having single field not indexed");

            executeFreeHandSQL(propsinfo,
                   "select  count( persons.zip), zip   from tutorial::rp::tutorialperson as persons where  persons.zip  > '33445' group by zip having count(zip) < 22 order by zip ASC limit 100",
                   params, true, 1, "count having single field payload indexed");

            executeFreeHandSQL(propsinfo,
                    "select  count(  distinct  persons.zip) from tutorial::rp::tutorialperson as persons where  persons.zip  > '33445'  limit 100",
                    params, true, 1, "count distintc single field payload indexed");

            executeFreeHandSQL(propsinfo,
                    "select   distinct  persons.middlename from tutorial::rp::tutorialperson as persons USE INDEX(0)limit 100",
                    params, true, 1, "select distintc single field non indexed");

            executeFreeHandSQL(propsinfo,
                    "select   distinct  persons.middlename, count(distinct middlename) from tutorial::rp::tutorialperson as persons USE INDEX(0) group by middlename limit 100",
                    params, true, 1, "select distintc single field non indexed");

            executeFreeHandSQL(propsinfo,
                    "select   persons.firstname from tutorial::rp::tutorialperson as persons  where  persons.zip  in ('33445') and persons.zip not in ('90210') limit 100",
                    params, true, 1, "multiple keyed field payload indexed");

            executeFreeHandSQL(propsinfo,
                    "select  count(  distinct  persons.zip, persons.firstname) from tutorial::rp::tutorialperson as persons   USE INDEX(0) where  persons.zip  > '33445'  limit 100",
                    params, true, 1, "count distintc multiple field NOT indexed");

            executeFreeHandSQL(propsinfo,
                    "select   persons.zip, firstname, lastname from tutorial::rp::tutorialperson as persons    where  persons.zip  in ('33445','33446'   ,   '',  '33487')  limit 100",
                    params, true, 1, "in operator multiple literals");

            executeFreeHandSQL(propsinfo,
                    "select   persons.zip, firstname, lastname from tutorial::rp::tutorialperson as persons    where  persons.zip  not in ('33445','33446'   ,   '',  '33487')  limit 100",
                    params, true, 1, "not in operator multiple literals");

            executeFreeHandSQL(propsinfo,
                    "select  persons.zip from tutorial::rp::tutorialperson as persons  where  persons.zip  in ('33445')  limit 100",
                    params, true, 1, "count distintc single field NOT indexed");

            executeFreeHandSQL(propsinfo,
                    "select  count(  distinct  persons.zip, persons.firstname) from tutorial::rp::tutorialperson as persons  where  persons.zip  in ('33445')  limit 100",
                    params, true, 1, "count distintc multiple field payload indexed");

            executeFreeHandSQL(propsinfo,
                    "call 'myroxie::fetchpeoplebyzipservice'(33445)",
                    params, true, 1, "Call single quoted published query name");

            executeFreeHandSQL(propsinfo,
                    "call 'myroxie::fetchpeoplebyzipservice'(33445)",
                    params, true, 1, "Call single quoted published query name");

            executeFreeHandSQL(propsinfo,
                    "call 'myroxie::fetchpeoplebyzipservice(33445)'",
                    params, false, 0, "Call single quoted published query name and paramlist");

            executeFreeHandSQL(propsinfo,
                    "call \"myroxie::fetchpeoplebyzipservice\"(33445)",
                    params, true, 1, "Call double quoted published query name");

            executeFreeHandSQL(propsinfo,
                    "select * from 'tutorial::rp::tutorialperson' persons  limit 100",
                    params, true, 100, "Select * single quote valid table");

            executeFreeHandSQL(propsinfo,
                    "select * from \"tutorial::rp::tutorialperson\" persons limit 100",
                    params, true, 1, "Select * double quote valid table");

            executeFreeHandSQL(propsinfo,
                    "select * from \"\" persons",
                    params, false, 0, "Select * double quoted empty table name");

            executeFreeHandSQL(propsinfo,
                    "select * from tutorial::rp::tutorialperson persons where persons.firstname = 'RANDOMNAMEXX' ",
                    params, true, 0, "Select * filter everything out");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.lastname) as zipcount, persons.city as mycity , zip from tutorial::rp::tutorialperson persons USE INDEX(0) limit 100",
                    params, true, 1, "Select agg funtion, field alias, table alias, no index");

            executeFreeHandSQL(propsinfo,
                    "select count(*), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons limit 10",
                    params, true, 10, "select count(*)");

            executeFreeHandSQL(propsinfo,
                    "select count(*), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.zip = '33445' limit 10",
                    params, true, 10, "select count(*) filtered");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.*), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons limit 10",
                    params, true, 1, "Select agg function field alias");

            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where  'a' > persons.firstname limit 10",
                    params, true, 1, "Select 2 columns, filter > 'a' ");

            executeFreeHandSQL(propsinfo,
                    "select * from tutorial::rp::tutorialperson as persons where  'a' > persons.firstname limit 10",
                    params, true, 1, "Select *, filter > 'a' ");

            executeFreeHandSQL(propsinfo,
                    "select *, persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where  'a' > persons.firstname limit 10",
                    params, false, 0, "Select duplicate cols");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.firstname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.zip < '33445' limit 10",
                    params, true, 1, "Select agg function aliased field, and field");

            executeFreeHandSQL(propsinfo,
                    "select min(persons.firstname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.firstname < 'a' limit 10",
                    params, true, 1, "select min()");

            executeFreeHandSQL(propsinfo,
                    "select max(persons.firstname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.zip < '33445' limit 10",
                    params, true, 1, "select max()");

            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where people2.firstname > 'A' limit 10",
                    params, true, 1, "Join where first table is index, and join table is not");

            executeFreeHandSQL(propsinfo,
                    "select *.* from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where people2.firstname > 'A' limit 10",
                    params, false, 0, "Select *.*");

            executeFreeHandSQL(propsinfo,
                    "select * from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where people2.firstname > 'A' limit 10",
                    params, false, 0, "Select redundant fields after expanding wildcard");

            executeFreeHandSQL(propsinfo,
                    "select people.gender, persons.*, people.middleinitial from tutorial::rp::peoplebyzipindex3 as persons outer join progguide::exampledata::people as people on people.zip = persons.zip limit 10",
                    params, true, 1, "Select table-wise wildcard");

            executeFreeHandSQL(propsinfo,
                    "select people.gender, persons.*, people.middleinitial from tutorial::rp::peoplebyzipindex3 as persons outer join progguide::exampledata::people as people on people.zip > persons.zip limit 10",
                    params, false, 0, "Select join inequality");

            executeFreeHandSQL(propsinfo,
                    "select persons.* from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where people2.firstname > 'A' limit 10",
                    params, true, 1, "Select all fields from one table, join");

            executeFreeHandSQL(propsinfo,
                    "select persons.*, people2.* from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where people2.firstname > 'A' limit 10",
                    params, false, 0, "Select all fields from both tables on join");

            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where firstname > 'A' limit 10",
                    params, false, 0, "Select ambiguous field firstname");

            // Seems to fail with this message:
            // ' Keyed joins only support LEFT OUTER/ONLY'
            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::tutorialperson2 as persons outer join tutorial::rp::peoplebyzipindex2 as people2 on people2.firstname = persons.firstname limit 10",
                    params, false, 0, "Join where first table is logical file, and join table is index file");

            // Seems to fail with this message:
            // ' Keyed joins only support LEFT OUTER/ONLY'
            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::peoplebyzipindex3 as persons outer join  tutorial::rp::peoplebyzipindex2 as people2 on people2.firstname = persons.firstname limit 10",
                    params, false, 0, "Join where both tables are index files");

            executeFreeHandSQL(propsinfo,
                    "select min(persons.firstname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.firstname < 'a' limit 10",
                    params, true, 1, "Select min(one field)");

            executeFreeHandSQL(propsinfo,
                    "select max(persons.firstname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.zip < '33445' limit 10",
                    params, true, 1, "Select max(one field)");

            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.firstname >= 'a' order by persons.lastname ASC, persons.firstname DESC limit 10",
                    params, true, 0, "Select Orderby and sortby, everything filtered");

            executeFreeHandSQL(propsinfo,
                    "select persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons where persons.firstname <= 'a' order by persons.lastname ASC, persons.firstname DESC limit 10",
                    params, true, 10, "Select Orderby and sortby, loose filter");

            //ECL doesn't like this...
            executeFreeHandSQL(propsinfo,
                    "select max(persons.lastname), persons.firstname, persons.lastname from tutorial::rp::tutorialperson as persons outer join  tutorial::rp::tutorialperson as people2 on people2.firstname = persons.firstname where persons.firstname > 'a' order by persons.lastname ASC, persons.firstname DESC limit 10",
                    params, false, 0, "Select full outter join on same file");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.zip) as zipcount, persons.city as mycity , zip from super::super::tutorial::rp::tutorialperson as persons where persons.zip > ? AND persons.zip < ? group by zip limit 100",
                    params, true, 1, "Select filter: multiple parametrized");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.zip) as zipcount, persons.city as mycity , zip, p2.ball from super::super::tutorial::rp::tutorialperson as persons join thor::motionchart_motion_chart_test_fixed as p2 on p2.zip = persons.zip where persons.zip > ? group by zip limit 10",
                    params, false, 0, "Select invalid join condition (field doesn't exist)");

            //executeFreeHandSQL(propsinfo,
                    //"select acct.account, acct.personid, persons.firstname, persons.lastname from progguide::exampledata::people as persons outer join  progguide::exampledata::accounts as acct on acct.personid = persons.personid  where persons.personid > 5 limit 10",
                    //params, true, 10, "Select outter join -- Can be lengthly query");

            executeFreeHandSQL(propsinfo,
                    "select acct.account, acct.personid, persons.firstname, persons.lastname from progguide::exampledata::people as persons outer join  progguide::exampledata::accounts as acct on acct.personid = persons.personid  where persons.personid = 5 limit 10",
                    params, true, 10, "Select outter join -- Can be lengthly query");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.zip) as zipcount, persons.city as mycity , zip, p2.ball from super::super::tutorial::rp::tutorialperson as persons join tutorial::rp::tutorialperson2 as p2 on p2.zip = persons.zip where persons.zip > ? group by zip limit 10",
                    params, false, 0, "Select invalid column");

            executeFreeHandSQL(propsinfo,
                    "select count(persons.personid), persons.firstname, persons.lastname from progguide::exampledata::people as persons  limit 10",
                    params, true, 1, "Select count table and field alias");

            if(!printoutalltablescols(connectionprops))
                    throw new RuntimeException("printoutalltablescols failed");

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println("********************************************************************");
            System.out.println("HPCC JDBC Test Package Usage:");
            System.out.println(" Connection Parameters: paramname==paramvalue");
            System.out.println(" eg. ServerAddress==192.168.124.128");
            System.out.println(" Prepared Statement param value: \"param\"==paramvalue");
            System.out.println(" eg. param==\'33445\'");
            System.out.println();
            System.out.println(" By default full test is executed.");
            System.out.println(" To execute free hand sql:");
            System.out.println("  freehandsql==<SQL STATEMENT>");
            System.out.println("  eg. freehandsql==\"select * from tablename where zip=? limit 100\"");
            System.out.println();
            System.out.println("********************************************************************\n");

            Properties info = new Properties();
            List<String> params = new ArrayList<String>();

            Driver ldriver = DriverManager.getDriver("jdbc:hpcc");

            if (!(ldriver instanceof HPCCDriver))
                throw new RuntimeException("Driver fetched with 'jdbc:hpcc' url is not of HPCCDriver type");
            if (!driver.acceptsURL("jdbc:hpcc"))
                throw new RuntimeException("Valid lower case JDBC URL test failed");
            if (!driver.acceptsURL("JDBC:hpcc"))
                throw new RuntimeException("Valid mixed case JDBC URL test1 failed");
            if (!driver.acceptsURL("JDBC:HPCC"))
                throw new RuntimeException("Valid upper case JDBC URL test failed");
            if (!driver.acceptsURL("jdbc:HPCC"))
                throw new RuntimeException("Valid mixed case JDBC URL test2 failed");
            if (!driver.acceptsURL("jDbC:hPcC"))
                throw new RuntimeException("Valid camel case JDBC URL test2 failed");

            if (!driver.acceptsURL("jdbc:hpcc;"))
                throw new RuntimeException("Valid seperator JDBC URL test failed");
            if (!driver.acceptsURL("jdbc:hpcc;prop1=val1;prop2=val2"))
                throw new RuntimeException("Valid properties JDBC URL semicolon test failed");
            if (!driver.acceptsURL("jdbc:hpcc:prop1=val1:prop2=val2"))
                throw new RuntimeException("Valid properties JDBC URL colon test failed");
            if (!driver.acceptsURL("jdbc:hpcc:"))
                throw new RuntimeException("Valid seperator JDBC URL test passed");
            if (driver.acceptsURL("jdbc : hpcc"))
                throw new RuntimeException("Invalid spaces JDBC URL test passed");
            if (!driver.acceptsURL("jdbc:hpcc:prop1=val1;prop2=val2"))
                throw new RuntimeException("Valid JDBC URL test failed");
            if (driver.acceptsURL("  jdbc:hpcc"))
                throw new RuntimeException("Invalid spaces JDBC URL test2 passed");
            if (driver.acceptsURL("Garbage"))
                throw new RuntimeException("Invalid garbage JDBC URL test passed");
            if (driver.acceptsURL("url:jdbc:hpcc"))
                throw new RuntimeException("Invalid prefix JDBC URL test passed");
            if (driver.acceptsURL(""))
                throw new RuntimeException("Invalid empty JDBC URL test passed");
            if (driver.acceptsURL(" "))
                throw new RuntimeException("Invalid singlespace JDBC URL test passed");
            if (driver.acceptsURL(null))
                throw new RuntimeException("Invalid null JDBC URL test passed");

            if (args.length <= 0)
            {
                info.put("ServerAddress", "192.168.124.128"); //your HPCC address here
                info.put("LazyLoad", "true");
                info.put("TargetCluster", "myroxie"); //queries will run on this HPCC target cluster
                info.put("QuerySet", "thor"); //published HPCC queries will run from this queryset
                info.put("WsECLWatchPort", "8010"); //Target HPCC configured to run WsECLWatch on this port
                info.put("WsECLDirectPort", "8008"); //Target HPCC configured to run WsECLDirect on this port
                info.put("EclResultLimit", "ALL"); //I want all records returned
                info.put("PageSize", "20"); //GetTables and GetProcs will only return 20 entries


                if (!runFullTest(info))
                    throw new RuntimeException("Full test failed.");

            }
            else
            {
                for (int i = 0; i < args.length; i++)
                {
                    String[] propsplit = args[i].split("==");
                    if (propsplit.length == 1)
                    {
                        info.put(propsplit[0], "true");
                        System.out.println("added prop: " + propsplit[0] + " = true");
                    }
                    else if (propsplit.length == 2)
                    {
                        if (propsplit[0].equalsIgnoreCase("param"))
                        {
                            params.add(propsplit[1]);
                            System.out.println("added param( " + (params.size()) + " ) = " + propsplit[1]);
                        }
                        else
                        {
                            info.put(propsplit[0], propsplit[1]);
                            System.out.println("added prop: " + propsplit[0] + " = " + propsplit[1]);
                        }
                    }
                    else
                        System.out.println("arg[" + i + "] ignored");
                }

                if (info.containsKey("freehandsql"))
                {
                    executeFreeHandSQL(info, info.getProperty("freehandsql"), params, true, 0, "SQL: "+ info.getProperty("freehandsql"));
                }
                else
                    if (!runFullTest(info))
                        throw new RuntimeException("Full test failed.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println("\nHPCC Driver completed as expected - Verify results.");
    }
}
