###
## Version Information
##
## NOTE: when updating the version info please make the corresponding changes in pom.xml 
###
execute_process(COMMAND /bin/bash -c "xmllint --xpath \"/*[local-name()='project']/*[local-name()='version']/text()\" pom.xml"
	WORKING_DIRECTORY ${CMAKE_SOURCE_DIR}
	TIMEOUT 10
	OUTPUT_VARIABLE version)

string(REPLACE "." ";" VERSION ${version})
string(REPLACE "-" ";" VERSION "${VERSION}")

set(ver_var HPCC_MAJOR HPCC_MINOR HPCC_POINT HPCC_MATURITY HPCC_SEQUENCE)
set(inc 0)
foreach(var IN LISTS VERSION)
	list(GET ver_var ${inc} var_name)
	set("${var_name}" "${var}")
	math(EXPR inc "${inc}+1")
endforeach()
foreach(var in LISTS ver_var)
	if(NOT DEFINED "${var}")
		set("${var}" "")
	endif()
endforeach()
