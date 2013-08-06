Copyright (C) <2012> <LexisNexis Risk Data Management Inc.>

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

http://hpccsystems.com

JDBC driver for HPCC platform

To build for Linux:
-------------------

1. Check out sources (for example, to directory ~/hpcc-jdbc)
2. Create a build directory
3. cd to the build directory
4. To create makefiles to build native release version for local machine, run cmake ~/hpcc-jdbc
5. To build the makefiles just created above, run make
6. Jar file will be created in <builddir>/src/com/hpccsystems/jdbcdriver/hpccsystems-jdbcdriver-MAJOR.MINOR.POINT.jar

A Test version can be built by augmenting the cmake command with the "MAKE_TEST_PACKAGE" flag turned on.
1. From build directory, run cmake -DMAKE_TEST_PACKAGE=ON ~/hpcc-jdbc
2. Jar file will be created in <builddir>/src/com/hpccsystems/jdbcdriver/hpccsystems-jdbcdriver-MAJOR.MINOR.POINT-TEST.jar
3. Run test: java -cp <jarfile> org.hpccsystems.jdbcdriver.tests.HPCCDriverTest <param==value>...
   If no parameters are passed in, a "full test" will execute (values in code should be altered to match your environment).

To build using Maven:
---------------------

1. Check out sources (same as above)
2. cd to the project root directory
3. Run _mvn install_ to execute the build using Maven (includes running "standalone" unit tests)
4. Jar file will be created in <project_root>/target/jdbcdriver-MAJOR.MINOR.POINT[-SNAPSHOT].jar
5. _TO DO_ - create a Maven profile to run tests requiring a running HPCC system.

NOTE:  When updating the project version in either version.cmake (cmake) or pom.xml (Maven) please make sure to
update the version in both locations.

To Run Test Package:
-------------------
1. Provide a two files:
	a) Containing the configurations for the target Virtual Machine
	b) Containing the Sql scripts to run against the Virtual Machine
	See Example: hpcc-jdbc/src/SampleTestScripts/
2. For configuration parameters pass in:
	Config=<home/user/myfile>
	ReporthPath=<home/user>
	SqlScript=<home/user/myfile1>
3. To execute "Prepared Statements" specify the location of the data file:
**Path must be platform specific.
For Linux: Test1=[true;1;/home/vagrant/mycsvfile.csv]<preparedstament>
For Windows: Test1=[true;1;C:\\Users\\mycsvfile.csv]<preparedstament>
