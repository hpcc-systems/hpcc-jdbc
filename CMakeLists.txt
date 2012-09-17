cmake_minimum_required(VERSION 2.8)
project(jdbcdriver Java)

include(version.cmake)

    SET ( PRODUCT_PREFIX "hpccsystems" )
    SET ( HPCC_JDBC_PAC_PATH org/hpccsystems/jdbcdriver)
    SET ( HPCC_JDBC_REL_PATH src/${HPCC_JDBC_PAC_PATH})
    SET ( HPCC_ECLJDBC_SOURCE_DIR ${CMAKE_CURRENT_SOURCE_DIR}/${HPCC_JDBC_REL_PATH})

    MESSAGE ("-- JAVA Development components are required.")
    FIND_PACKAGE (Java REQUIRED COMPONENTS Development)

    ADD_SUBDIRECTORY (${HPCC_JDBC_REL_PATH})

    SET ( INSTALLDIR "${EXEC_DIR}")
