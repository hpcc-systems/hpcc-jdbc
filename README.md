JDBC driver
=======================

#### Description
Java Database Connectivity (JDBC) is a standard Java API that enables Java applications or client tools that support JDBC to access data from a presumably SQL-compliant data source via the SQL language.

JDBC makes it possible to write a single database application that can run on different platforms and interact with different database management systems.

Currently there are JDBC drivers available for interaction with many popular data sources.  This project allows the end user to interact with the HPCC Platform as a data source.  This is achieved by exposing HPCC logical files as RDB tables, and HPCC published queries as RDB stored procedures.

#### Maven dependency
To utilize this library as a dependency in your own maven project, simply add the following definition to your pom.xml

```xml
<dependency>
	<groupId>org.hpccsystems</groupId>
	<artifactId>jdbcdriver</artifactId>
	<version>1.0.0</version>
</dependency>
```

#### Build

1. Check out sources (git clone https://github.com/hpcc-systems/hpcc-jdbc.git)
2. cd to the project root directory
3. Run `mvn install` to execute the build using Maven (`mvn install -P jdbc.testsuite` to build unit tests)
4. Jar file will be created in <project_root>/target/jdbcdriver-MAJOR.MINOR.POINT[-SNAPSHOT].jar

#### Testing
First build using the test profile
`mvn clean install -P jdbc.testsuite`

Execute the jar as a target with
`java -jar <jdbcdriver-*-test-jar-with-dependencies.jar> <parameters>

1. Two files are required:
	a) configuration file- Target HPCC system connection information
	b) Test script file- Contains SQL test cases
		Test cases are specified using following format:
		= ["["ExpectSuccess;MinResultExpected[;DataFile]"]"]
		Where:
		ExpectedSuccess = true|false - true signifies that the test case should succeed, false it should fail.
		MinResultExpected = int - the minimum number of records expected if successful.
		DataFile = platform specific path - Path to data file used to populate prepared statements.
		Examples:
		For Linux: Test1=[true;1;/home/vagrant/mycsvfile.csv]
		For Windows: Test1=[true;1;C:\Users\mycsvfile.csv]
		See Example: src/SampleTestScripts/
2)To execute "Regular Statements":
Test1=[true;1]< sqlstatements>

2. Execute HPCCJDBCDriverTest with the following parameters:
	Config=/path/to/configfile.config
	ReporthPath=path/to/reportfiles/
	SqlScript=path/to/testcases.txt

#### Change log
- 1.0.0
  - Updated dependency to org.hpccsystems.wsclient:1.0.0
    - Refactoring for WsClient pooling
  - Readme updates
  - pom packaging and jdbc.testsuite changes

#### Resources
- https://hpccsystems.com
- https://github.com/hpcc-systems/hpcc-jdbc.git

