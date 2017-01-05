/*##############################################################################

  Copyright (C) 2012 HPCC Systems.

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

import java.util.Properties;
import java.io.FileInputStream;

public class HPCCVersionTracker
{
    static String HPCCProject;
    static int HPCCMajor;
    static int HPCCMinor;
    static int HPCCPoint;
    static String HPCCMaturity;
    static int HPCCSequence;

    static {
        try
        {
            Properties jdbcdriver = new Properties();
            FileInputStream in = new FileInputStream("jdbcdriver.properties");
            jdbcdriver.load(in);
            in.close();
            HPCCProject = jdbcdriver.getProperty("version","");
            HPCCMajor = Integer.parseInt(jdbcdriver.getProperty("major","0"));
            HPCCMinor = Integer.parseInt(jdbcdriver.getProperty("minor","0"));
            HPCCPoint = Integer.parseInt(jdbcdriver.getProperty("point","0"));
            HPCCMaturity = jdbcdriver.getProperty("maturity","");
            HPCCSequence = Integer.parseInt(jdbcdriver.getProperty("build","0"));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }		
    }
}
