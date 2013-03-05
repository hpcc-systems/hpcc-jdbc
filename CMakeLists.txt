cmake_minimum_required(VERSION 2.8)
project(jdbcdriver Java)

include(version.cmake)

    OPTION(MAKE_TEST_PACKAGE "Create test package." OFF)

    SET ( PRODUCT_PREFIX "hpccsystems" )
    SET ( HPCC_JDBC_PAC_PATH org/hpccsystems/jdbcdriver)
    SET ( HPCC_JDBC_JAVA_SRC_PATH main/java)
    SET ( HPCC_JDBC_REL_PATH src/${HPCC_JDBC_JAVA_SRC_PATH}/${HPCC_JDBC_PAC_PATH})

    SET ( HPCC_ANTLR_SRC_PATH  "${CMAKE_CURRENT_SOURCE_DIR}/src/main/antlr3" )
    SET ( HPCC_TEST_SRC_PATH  "${CMAKE_CURRENT_SOURCE_DIR}/src/test/java" )

    MESSAGE ("-- JAVA Development components are required.")
    FIND_PACKAGE (Java REQUIRED COMPONENTS Development)

    SET ( CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake_modules")

    FIND_PACKAGE(ANTLR REQUIRED)

    ADD_SUBDIRECTORY (${HPCC_JDBC_REL_PATH})

    SET ( INSTALLDIR "${EXEC_DIR}")
