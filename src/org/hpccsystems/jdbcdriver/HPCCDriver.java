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
    static
    {
        try
        {
            HPCCDriver driver = new HPCCDriver();
            DriverManager.registerDriver(driver);
            System.out.println("EclDriver initialized");
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
        Properties connprops = new Properties();

        if (info != null && info.size() > 0)
            connprops.putAll(info);

        try
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
                            System.out.println("Connection property: " + key
                                    + " found in info properties and URL, ignoring URL value");
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Issue parsing URL! \"" + url + "\"");
        }

        String serverAddress = connprops.getProperty("ServerAddress");
        System.out.println("EclDriver::connect" + serverAddress);

        return new HPCCConnection(connprops);
    }

    public boolean acceptsURL(String url) throws SQLException
    {
        return true;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
    {
        DriverPropertyInfo[] infoArray = new DriverPropertyInfo[1];
        infoArray[0] = new DriverPropertyInfo("ip", "IP Address");
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
