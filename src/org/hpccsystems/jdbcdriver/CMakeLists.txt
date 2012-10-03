CMAKE_MINIMUM_REQUIRED(VERSION 2.8)

INCLUDE(UseJava)
SET (TEST_PACKAGE_LOCATION tests)
SET (TEST_PACKAGE_SOURCE_DIR ${CMAKE_CURRENT_SOURCE_DIR}/${TEST_PACKAGE_LOCATION})

#Dynamically generate java class with build-time version information
CONFIGURE_FILE("HPCCVersionTracker.java.in" "${CMAKE_CURRENT_SOURCE_DIR}/HPCCVersionTracker.java")

#Setup the jar file name
SET (JAR_FILE "${PRODUCT_PREFIX}-${PROJECT_NAME}-${HPCC_MAJOR}.${HPCC_MINOR}.${HPCC_POINT}${HPCC_MATURITY}")

#list of java files to build
FILE( GLOB JAVA_SOURCE_FILES "${CMAKE_CURRENT_SOURCE_DIR}/*.java" )

IF ( MAKE_TEST_PACKAGE )
    #list of java test files to build
    FILE ( GLOB JAVA_SOURCE_TEST_FILES "${TEST_PACKAGE_SOURCE_DIR}/*.java" )
    #Append "TEST" postfix to target jar file.
    SET (JAR_FILE "${JAR_FILE}-TEST")
ENDIF()

#Compile the source files, create target jar file
ADD_JAR(${JAR_FILE} ${JAVA_SOURCE_FILES} ${JAVA_SOURCE_TEST_FILES})
