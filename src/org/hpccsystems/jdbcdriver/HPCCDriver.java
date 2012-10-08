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

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import java.util.StringTokenizer;

public class HPCCDriver implements Driver
{
    public static final String   ECLRESULTLIMDEFAULT      = "100";
    public static final String   CLUSTERDEFAULT           = "hthor";
    public static final String   QUERYSETDEFAULT          = "hthor";
    public static final String   SERVERADDRESSDEFAULT     = "localhost";
    public static final String   WSECLWATCHPORTDEFAULT    = "8010";
    public static final String   WSECLPORTDEFAULT         = "8002";
    public static final String   WSECLDIRECTPORTDEFAULT   = "8010";
    public static final String   FETCHPAGESIZEDEFAULT     = "100";
    public static final String   FETCHPAGEOFFSETDEFAULT   = "0";
    public static final String   LAZYLOADDEFAULT          = "true";
    public static final String   CONNECTTIMEOUTMILDEFAULT = "5000";
    public static final String   READTIMEOUTMILDEFAULT    = "15000";
    public static final String   JDBCURLPROTOCOL          = "jdbc:hpcc";

    private static DriverPropertyInfo[] infoArray;

    static
    {
        try
        {
            HPCCDriver driver = new HPCCDriver();
            DriverManager.registerDriver(driver);
            initializePropInfo();
            System.out.println("HPCC JDBC Driver registered.");
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
        HPCCJDBCUtils.traceoutln("HPCCConnection jdbc url: " + url);

        Properties connprops = new Properties();

        if (info != null && info.size() > 0)
            connprops.putAll(info);

        try
        {
            if (url != null && acceptsURL(url))
            {
                StringTokenizer urltokens = new StringTokenizer(url, ";");

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
                                connprops.put(key, value);
                            else
                                System.out.println("Connection property: " + key + " found in info properties and URL, ignoring URL value");
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Issue parsing URL! \"" + url + "\"");
        }

        try
        {
            if (!connprops.containsKey("ServerAddress"))
                connprops.setProperty("ServerAddress", SERVERADDRESSDEFAULT);

            String serverAddress = connprops.getProperty("ServerAddress");

            if (!connprops.containsKey("TargetCluster"))
                connprops.setProperty("TargetCluster", CLUSTERDEFAULT);

            if (!connprops.containsKey("QuerySet"))
                connprops.setProperty("QuerySet", QUERYSETDEFAULT);

            if (!connprops.containsKey("WsECLWatchAddress"))
                connprops.setProperty("WsECLWatchAddress", serverAddress);

            if (!connprops.containsKey("WsECLWatchPort"))
                connprops.setProperty("WsECLWatchPort", WSECLWATCHPORTDEFAULT);

            if (!connprops.containsKey("WsECLAddress"))
                connprops.setProperty("WsECLAddress", serverAddress);

            if (!connprops.containsKey("WsECLPort"))
                connprops.setProperty("WsECLPort", WSECLPORTDEFAULT);

            if (!connprops.containsKey("WsECLDirectAddress"))
                connprops.setProperty("WsECLDirectAddress", serverAddress);

            if (!connprops.containsKey("WsECLDirectPort"))
                connprops.setProperty("WsECLDirectPort", WSECLDIRECTPORTDEFAULT);

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
                    if (HPCCJDBCUtils.isNumeric(eclreslim))
                    {
                        if (Integer.valueOf(eclreslim).intValue() <= 0)
                            setdefaultreslim = true;
                    }
                    else
                    {
                        if (!eclreslim.equalsIgnoreCase("ALL"))
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
                System.out.println("Invalid Numeric EclResultLimit value detected, using default value: "
                        + ECLRESULTLIMDEFAULT);
            }

            String basicAuth = HPCCConnection.createBasicAuth(connprops.getProperty("username"), connprops.getProperty("password"));

            connprops.put("BasicAuth", basicAuth);

            if (!connprops.containsKey("LazyLoad"))
                connprops.setProperty("LazyLoad", LAZYLOADDEFAULT);

            if (connprops.containsKey("LogDebug") && Boolean.parseBoolean(connprops.getProperty("LogDebug")))
                HPCCJDBCUtils.enableTraceLogging();
        }
        catch (Exception e)
        {
            System.out.println("Issue detected while setting connection properties!");
        }

        System.out.println("HPCCDriver::connect" + connprops.getProperty("ServerAddress"));

        return new HPCCConnection(connprops);
    }

    public boolean acceptsURL(String url) throws SQLException
    {
        return url != null && url.matches("^(?i)jdbc:hpcc(;.*)*?");
    }

    private static void initializePropInfo()
    {
        infoArray = new DriverPropertyInfo[18];

        infoArray[0] = new DriverPropertyInfo("ServerAddress", "myHPCCAddress");
        infoArray[0].description = "Target HPCC ESP Address (used to contact WsECLWatch, WsECLDirect, or WsECL if override not specified).";
        infoArray[0].required = true;

        infoArray[1] = new DriverPropertyInfo("WsECLWatchAddress", "myWsECLWatchAddress");
        infoArray[1].description = "WsECLWatch address (required if different than ServerAddress).";
        infoArray[1].required = false;

        infoArray[2] = new DriverPropertyInfo("WsECLWatchPort", WSECLWATCHPORTDEFAULT);
        infoArray[2].description = "WsECLWatch port (required if HPCC configuration does not use default port).";
        infoArray[2].required = false;

        infoArray[3] = new DriverPropertyInfo("WsECLAddress", "myWsECLAddress");
        infoArray[3].description = "WsECLAddress Address (required if different than ServerAddress).";
        infoArray[3].required = false;

        infoArray[4] = new DriverPropertyInfo("WsECLPort", WSECLPORTDEFAULT);
        infoArray[4].description = "WsECL port (required if HPCC configuration does not use default port).";
        infoArray[4].required = false;

        infoArray[5] = new DriverPropertyInfo("WsECLDirectAddress", "myWsECLDirectAddress");
        infoArray[5].description = "WsECLDirect Address (required if different than ServerAddress).";
        infoArray[5].required = false;

        infoArray[6] = new DriverPropertyInfo("WsECLDirectPort", WSECLDIRECTPORTDEFAULT);
        infoArray[6].description = "WsECLDirect port (required if HPCC configuration does not use default port).";
        infoArray[6].required = false;

        infoArray[7] = new DriverPropertyInfo("username", "");
        infoArray[7].description = "HPCC username (*Use JDBC client secure interface if available*).";
        infoArray[7].required = false;

        infoArray[8] = new DriverPropertyInfo("password", "");
        infoArray[8].description = "HPCC password (*Use JDBC client secure interface if available*).";
        infoArray[8].required = false;

        infoArray[9] = new DriverPropertyInfo("TargetCluster", CLUSTERDEFAULT);
        infoArray[9].description = "Target cluster on which to execute ECL code.";
        infoArray[9].required = false;

        infoArray[10] = new DriverPropertyInfo("QuerySet", QUERYSETDEFAULT);
        infoArray[10].description = "Queryset from which published query (Stored Procedure) is chosen.";
        infoArray[10].required = false;

        infoArray[11] = new DriverPropertyInfo("PageSize", FETCHPAGESIZEDEFAULT);
        infoArray[11].description = "Number of HPCC data files (DB tables) or HPCC published queries (DB Stored Procs) displayed.";
        infoArray[11].required = false;

        infoArray[12] = new DriverPropertyInfo("PageOffset", FETCHPAGEOFFSETDEFAULT);
        infoArray[12].description = "Starting HPCC data file or HPCC published queries displayed.";
        infoArray[12].required = false;

        infoArray[13] = new DriverPropertyInfo("ConnectTimeoutMilli", CONNECTTIMEOUTMILDEFAULT);
        infoArray[13].description = "HPCC requests connection time out value in milliseconds.";
        infoArray[13].required = false;

        infoArray[14] = new DriverPropertyInfo("ReadTimeoutMilli", READTIMEOUTMILDEFAULT);
        infoArray[14].description = "HPCC requests connection read time out value in milliseconds.";
        infoArray[14].required = false;

        infoArray[15] = new DriverPropertyInfo("EclResultLimit", ECLRESULTLIMDEFAULT);
        infoArray[15].description = "Default limit on number of result records returned.";
        infoArray[15].required = false;

        infoArray[16] = new DriverPropertyInfo("LazyLoad", LAZYLOADDEFAULT);
        String [] boolchoices = {"true", "false"};
        infoArray[16].choices = boolchoices;
        infoArray[16].description = "If disabled, all HPCC metadata is loaded and cached at connect time, otherwise HPCC file & published query info is loaded on-demand.";
        infoArray[16].required = false;

        infoArray[17] = new DriverPropertyInfo("LogDebug", "false");
        infoArray[17].choices = boolchoices;
        infoArray[17].description = "Trace logging switch.";
        infoArray[17].required = false;
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

}
