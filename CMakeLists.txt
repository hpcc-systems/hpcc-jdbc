cmake_minimum_required(VERSION 2.8)
project(jdbcdriver Java)
include(version.cmake)

SET ( HPCC_SOURCE_DIR ${CMAKE_CURRENT_SOURCE_DIR})
SET ( PRODUCT_PREFIX "hpccsystems" )
SET ( HPCC_JDBC_PAC_PATH org/hpccsystems/jdbcdriver)
SET ( HPCC_JDBC_JAVA_SRC_PATH main/java)
SET ( HPCC_JDBC_REL_PATH src/${HPCC_JDBC_JAVA_SRC_PATH}/${HPCC_JDBC_PAC_PATH})
SET ( CMAKE_MODULE_PATH "${CMAKE_CURRENT_SOURCE_DIR}/cmake_modules")
INCLUDE(${CMAKE_MODULE_PATH}/jdbcSetup.cmake)

IF ( NOT MAKE_DOCS_ONLY )
    MESSAGE (FATAL_ERROR "Deprecated use. For doc build only.")
ENDIF()

ADD_SUBDIRECTORY(docs)
