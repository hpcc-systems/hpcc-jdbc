Tableau Resources
=======================

#### Description
These files provide the needed configuration to connect to HPCC from Tableau. The hpcc-jdbc.tdc file specifies the basic functionality and driver type for the jdbc connection to HPCC. The example.properties file is a template for a connnection properties file; this template file should be used to create a new properties for each HPCC cluster that your Tableau will connect to. These connection files can be placed anywhere on your system.

hpcc-jdbc.tdc should be placed in the `$DOCUMENTS\My Tableau Repository\Datasources` directory. 

#### Connecting to HPCC via JDBC
- Install the HPCC jdbcdriver.jar from this project into the `$Tableau/Drivers` directory.
- Start Tableau and connect via: Other Databases (JDBC).
    - In the pop-up window type `jdbc:hpcc` into the URL field.
    - Under dialect select MySQL.
    - Provide your HPCC credentials.
    - Select the properties file you created above for the HPCC cluster you wish to connect to.