def skipTokens = ['set', '(', ')']

def cmakeVarList = []

def f = new File('./version.cmake').eachLine { line ->
  if (! line.startsWith('#')) { 
    def tokens = line.split(' ')
    tokens.each { token ->
      if (! skipTokens.contains(token)) {
        cmakeVarList.add(token)
      }
    }
  }
}

def cmakeVarMap = [:]
cmakeVarMap['HPCC_PROJECT'] = ''

for (i = 0; i < cmakeVarList.size()-1; i+=2) {
    cmakeVarMap[cmakeVarList[i]] = cmakeVarList[i+1]
}

def versionTracker = """
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

public class HPCCVersionTracker
{
    static final String HPCCProject     = "${cmakeVarMap['HPCC_PROJECT']}";
    static final int HPCCMajor          = ${cmakeVarMap['HPCC_MAJOR']};
    static final int HPCCMinor          = ${cmakeVarMap['HPCC_MINOR']};
    static final int HPCCPoint          = ${cmakeVarMap['HPCC_POINT']};
    static final String HPCCPMaturity   = ${cmakeVarMap['HPCC_MATURITY']};
    static final int HPCCSequence       = ${cmakeVarMap['HPCC_SEQUENCE']};
}
"""

new File('src/main/java/org/hpccsystems/jdbcdriver/HPCCVersionTracker.java').write(versionTracker)

println versionTracker