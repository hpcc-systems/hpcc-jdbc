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

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HPCCDriver implements Driver
{
    public static final String   ECLRESULTLIMDEFAULT      = "100";
    public static final int      ECLRESULTLIMDEFAULTINT   = 100;
    public static final String   CLUSTERDEFAULT           = "hthor";
    public static final String   QUERYSETDEFAULT          = "hthor";
    public static final String   SERVERADDRESSDEFAULT     = HPCCJDBCUtils.defaultprotocol + HPCCJDBCUtils.protocolsep + "localhost";
    public static final String   WSECLWATCHPORTDEFAULT    = "8010";
    public static final String   WSSQLPORTDEFAULT         = "8510";
    public static final String   FETCHPAGESIZEDEFAULT     = "100";
    public static final String   FETCHPAGEOFFSETDEFAULT   = "0";
    public static final String   LAZYLOADDEFAULT          = "true";
    public static final String   CONNECTTIMEOUTMILDEFAULT = "5000";
    public static final String   READTIMEOUTMILDEFAULT    = "15000";
    public static final String   JDBCURLPROTOCOL          = "jdbc:hpcc";
    public static final String   TRACETOFILEDEFAULT       = "false";
    public static final String   TRACELEVELDEFAULT        = HPCCJDBCUtils.defaultLogLevel.getName();

    private static DriverPropertyInfo[] infoArray;

    static
    {
        try
        {
            HPCCDriver driver = new HPCCDriver();
            DriverManager.registerDriver(driver);
            initializePropInfo();

            HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCC JDBC Driver registered.");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public HPCCDriver()
    {
    }

    public Connection connect(String url, Properties info) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCCConnection jdbc url: " + url);

        Properties connprops = new Properties();

        if (info != null && info.size() > 0)
            connprops.putAll(info);

        try
        {
            if (url != null && acceptsURL(url))
            {
                StringTokenizer urltokens = new StringTokenizer(url, ":;");

                while (urltokens.hasMoreTokens())
                {
                    String token = urltokens.nextToken();
                    if (token.contains("="))
                    {
                        StringTokenizer keyvalues = new StringTokenizer(token, "=");
                        while (keyvalues.hasMoreTokens())
                        {
                            String key = keyvalues.nextToken();
                            String value = keyvalues.nextToken();
                            if (!connprops.containsKey(key))
                                connprops.put(key, URLDecoder.decode(value, "UTF-8"));
                            else
                                HPCCJDBCUtils.traceoutln(Level.FINEST,  "Connection property: " + key + " found in info properties and URL, ignoring URL value");
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE, "Issue parsing URL! \"" + url + "\"");
        }

        try
        {
            if (!connprops.containsKey("ServerAddress"))
                connprops.setProperty("ServerAddress", SERVERADDRESSDEFAULT);

            String serverAddress = HPCCJDBCUtils.ensureURLProtocol(connprops.getProperty("ServerAddress"));
            try
            {
                HPCCJDBCUtils.verifyURL(serverAddress);
            }
            catch (Exception e)
            {
                throw new Exception("HPCCDriver found invalid ServerAddress: " + connprops.getProperty("ServerAddress") +": " + e.getLocalizedMessage());
            }

            if (!connprops.containsKey("TraceLevel"))
                connprops.setProperty("TraceLevel", TRACELEVELDEFAULT);

            if (!connprops.containsKey("TraceToFile"))
                connprops.setProperty("TraceToFile", TRACETOFILEDEFAULT);

            if (connprops.containsKey("TraceLevel"))
                HPCCJDBCUtils.initTracing(connprops.getProperty("TraceLevel"),
                    Boolean.parseBoolean(connprops.getProperty("TraceToFile")));

            if (!connprops.containsKey("TargetCluster"))
                connprops.setProperty("TargetCluster", CLUSTERDEFAULT);

            if (!connprops.containsKey("QuerySet"))
                connprops.setProperty("QuerySet", QUERYSETDEFAULT);

            if (!connprops.containsKey("WsECLWatchAddress"))
            {
                connprops.setProperty("WsECLWatchAddress", serverAddress);
            }
            else
            {
                String wseclwatchadd =  HPCCJDBCUtils.ensureURLProtocol(connprops.getProperty("WsECLWatchAddress"));
                try
                {
                    HPCCJDBCUtils.verifyURL(wseclwatchadd);
                    connprops.setProperty("WsECLWatchAddress",wseclwatchadd);
                }
                catch (Exception e)
                {
                    throw new Exception("HPCCDriver found invalid WsECLWatchAddress: " + connprops.getProperty("WsECLWatchAddress") +": " + e.getLocalizedMessage());
                }
            }

            if (!connprops.containsKey("WsECLWatchPort"))
                connprops.setProperty("WsECLWatchPort", WSECLWATCHPORTDEFAULT);

            if (connprops.containsKey("user"))
                connprops.setProperty("username", connprops.getProperty("user"));

            if (!connprops.containsKey("username"))
                connprops.setProperty("username", "");

            if (!connprops.containsKey("password"))
                connprops.setProperty("password", "");

            if (!connprops.containsKey("PageSize") || !HPCCJDBCUtils.isNumeric(connprops.getProperty("PageSize")))
                connprops.setProperty("PageSize", String.valueOf(FETCHPAGESIZEDEFAULT));

            if (!connprops.containsKey("PageOffset") || !HPCCJDBCUtils.isNumeric(connprops.getProperty("PageOffset")))
                connprops.setProperty("PageOffset", String.valueOf(FETCHPAGEOFFSETDEFAULT));

            if (!connprops.containsKey("ConnectTimeoutMilli")
                    || !HPCCJDBCUtils.isNumeric(connprops.getProperty("ConnectTimeoutMilli")))
                connprops.setProperty("ConnectTimeoutMilli", String.valueOf(CONNECTTIMEOUTMILDEFAULT));

            if (!connprops.containsKey("ReadTimeoutMilli")
                    || !HPCCJDBCUtils.isNumeric(connprops.getProperty("ReadTimeoutMilli")))
                connprops.setProperty("ReadTimeoutMilli", String.valueOf(READTIMEOUTMILDEFAULT));

            boolean setdefaultreslim = false;
            if (connprops.containsKey("EclResultLimit"))
            {
                String eclreslim = connprops.getProperty("EclResultLimit").trim();
                try
                {
                    if (!HPCCJDBCUtils.isNumeric(eclreslim))
                        setdefaultreslim = true;
                    else
                    {
                        if(eclreslim.equalsIgnoreCase("ALL"))
                            eclreslim = "0"; // No limit
                        else
                            setdefaultreslim = true;
                    }
                }
                catch (Exception e)
                {
                    setdefaultreslim = true;
                }
            }
            else
                setdefaultreslim = true;

            if (setdefaultreslim)
            {
                connprops.setProperty("EclResultLimit", ECLRESULTLIMDEFAULT);
                HPCCJDBCUtils.traceoutln(Level.WARNING,  "Invalid Numeric EclResultLimit value detected, using default value: " + ECLRESULTLIMDEFAULT);
            }

            String basicAuth = HPCCConnection.createBasicAuth(connprops.getProperty("username"), connprops.getProperty("password"));

            connprops.put("BasicAuth", basicAuth);

            if (!connprops.containsKey("LazyLoad"))
                connprops.setProperty("LazyLoad", LAZYLOADDEFAULT);

            if (!connprops.containsKey("WsSQLport"))
                connprops.setProperty("WsSQLport", WSSQLPORTDEFAULT);

        }
        catch (Exception e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE,   "Issue detected while setting connection properties!");
            HPCCJDBCUtils.traceoutln(Level.SEVERE,   e.getLocalizedMessage());
            return null;
        }

        HPCCJDBCUtils.traceoutln(Level.INFO,"HPCCDriver::connect " + connprops.getProperty("ServerAddress"));

        return new HPCCConnection(connprops);
    }

    public boolean acceptsURL(String url) throws SQLException
    {
        return url != null && url.matches("^(?i)jdbc:hpcc((:|;).*)*?");
    }

    private static void initializePropInfo()
    {
        String [] boolchoices = new String [] {"true", "false"};

        int totalConfigProps = 16;
        infoArray = new DriverPropertyInfo[totalConfigProps];

        infoArray[--totalConfigProps] = new DriverPropertyInfo("ConnectTimeoutMilli", CONNECTTIMEOUTMILDEFAULT);
        infoArray[totalConfigProps].description = "HPCC requests connection time out value in milliseconds.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("ReadTimeoutMilli", READTIMEOUTMILDEFAULT);
        infoArray[totalConfigProps].description = "HPCC requests connection read time out value in milliseconds.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("LazyLoad", LAZYLOADDEFAULT);
        infoArray[totalConfigProps].description = "If disabled, all HPCC metadata loaded and cached at connect time; otherwise HPCC file, and published query info is loaded on-demand";
        infoArray[totalConfigProps].required = false;
        infoArray[totalConfigProps].choices = boolchoices;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("EclResultLimit", ECLRESULTLIMDEFAULT);
        infoArray[totalConfigProps].description = "Default limit on number of result records returned.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("TraceLevel", TRACELEVELDEFAULT);
        infoArray[totalConfigProps].choices = HPCCJDBCUtils.getTraceLevelStrOptions();
        infoArray[totalConfigProps].description = "Logging level (java.util.logging.level).";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("TraceToFile", TRACETOFILEDEFAULT);
        infoArray[totalConfigProps].description = "false -> System.out, true -> " + HPCCJDBCUtils.workingDir +  HPCCJDBCUtils.traceFileName;
        infoArray[totalConfigProps].required = false;
        infoArray[totalConfigProps].choices = boolchoices;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("TargetCluster", CLUSTERDEFAULT);
        infoArray[totalConfigProps].description = "Target cluster on which to execute ECL code.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("QuerySet", QUERYSETDEFAULT);
        infoArray[totalConfigProps].description = "Queryset from which published query (Stored Procedure) is chosen.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("PageSize", FETCHPAGESIZEDEFAULT);
        infoArray[totalConfigProps].description = "Number of HPCC data files (DB tables) or HPCC published queries (DB Stored Procs) displayed.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("PageOffset", FETCHPAGEOFFSETDEFAULT);
        infoArray[totalConfigProps].description = "Starting HPCC data file or HPCC published queries displayed.";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("password", "");
        infoArray[totalConfigProps].description = "HPCC password (*Use JDBC client secure interface if available*).";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("username", "");
        infoArray[totalConfigProps].description = "HPCC username (*Use JDBC client secure interface if available*).";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("WsECLWatchPort", WSECLWATCHPORTDEFAULT);
        infoArray[totalConfigProps].description = "WsECLWatch port (required if HPCC configuration does not use default port).";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("WsECLWatchAddress", "myWsECLWatchAddress");
        infoArray[totalConfigProps].description = "WsECLWatch address (required if different than ServerAddress).";
        infoArray[totalConfigProps].required = false;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("ServerAddress", "myHPCCAddress");
        infoArray[totalConfigProps].description = "Target HPCC ESP Address (used to contact  WsSQL if override not specified).";
        infoArray[totalConfigProps].required = true;

        infoArray[--totalConfigProps] = new DriverPropertyInfo("WsSQLPort", WSSQLPORTDEFAULT);
        infoArray[totalConfigProps].description = "WsSQL port (WsSQL is a web service which has to be installed with the HPCC platfrom and typically runs on port 8015).";
        infoArray[totalConfigProps].required = true;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
    {
        return infoArray;
    }

    public int getMajorVersion()
    {
        return HPCCVersionTracker.HPCCMajor;
    }

    public int getMinorVersion()
    {
        return HPCCVersionTracker.HPCCMinor;
    }

    public boolean jdbcCompliant()
    {
        return true;
    }

    //Introduced in java 1.7 @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException
    {
        return HPCCJDBCUtils.getLogger();
    }

}
