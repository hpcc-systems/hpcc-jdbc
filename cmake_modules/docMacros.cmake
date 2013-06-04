
MACRO(RUN_XSLTPROC _xsl _file _out _in_dir _out_dir )
	PARSE_ARGUMENTS(_XSLT "" "" ${ARGN})
	SET(TARG "")
	LIST(LENGTH _XSLT_DEFAULT_ARGS _XSLT_LEN)
	if( _XSLT_LEN )
		LIST(GET _XSLT_DEFAULT_ARGS 0 TARG)
		set(DIRS ${_XSLT_DEFAULT_ARGS})
		LIST(REMOVE_AT DIRS 0)
		LIST(LENGTH DIRS length)
		set(FILES "")
		if ( length )
			foreach( D ${DIRS} )
				file(GLOB_RECURSE _DB_INCLUDES ${D}/*.xml)
				set(FILES ${FILES} ${_DB_INCLUDES})
			endforeach()
		endif()
	endif()
	STRING(REGEX REPLACE "([0-9a-z_-]*).xml" "\\1" _file_base "${_file}")
	SET(_xsl ${_xsl})
	SET(_file ${_file})
	SET(_out ${_out})
	SET(_in_dir ${_in_dir})
	SET(_out_dir ${_out_dir})
	IF( TARG )
		SET(_xslt_target ${ARGN})
		SET(xinclude "-xinclude")
	ELSE()
		SET(_xslt_target)
		SET(xinclude)
	ENDIF()
	CONFIGURE_FILE(${HPCC_SOURCE_DIR}/docs/BuildTools/xsltproc.cmake.in ${CMAKE_CURRENT_BINARY_DIR}/${_out}.cmake @ONLY)
	ADD_CUSTOM_COMMAND(
		COMMAND ${CMAKE_COMMAND} -P ${CMAKE_CURRENT_BINARY_DIR}/${_out}.cmake
		OUTPUT ${_out_dir}/${_out}
		DEPENDS docbook-expand ${_xsl} ${_in_dir}/${_file} ${_xslt_target} ${FILES} ${DOC_IMAGE_LIST}
		)
	set_source_files_properties(${_out_dir}/${_out} PROPERTIES GENERATED TRUE)
	ADD_CUSTOM_TARGET(${_out} DEPENDS ${_out_dir}/${_out} )
ENDMACRO(RUN_XSLTPROC)

MACRO(RUN_FOP _file _out)
	ADD_CUSTOM_COMMAND(
		COMMAND ${CMAKE_COMMAND} -E make_directory ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/docs
		COMMAND ${FOP_EXECUTABLE} ${CMAKE_CURRENT_BINARY_DIR}/${_file} -pdf ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/docs/${_out} 
		OUTPUT ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/docs/${_out}
		DEPENDS ${CMAKE_CURRENT_BINARY_DIR}/${_file}
		)
	set_source_files_properties(${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/docs/${_out} PROPERTIES GENERATED TRUE)
	ADD_CUSTOM_TARGET(${_out} DEPENDS ${CMAKE_BINARY_DIR}/${CMAKE_BUILD_TYPE}/docs/${_out} )
ENDMACRO(RUN_FOP)

MACRO(CLEAN_REL_BOOK _file _version_dir _doc_dir _in_dir _out_dir)
	STRING(REGEX REPLACE "([0-9a-z_-]*).xml" "\\1" _file_base "${_file}")
	SET(_clean_target "clean_${_file}")
	SET(VERSION_DIR ${_version_dir})
	SET(ROOT "book")
	CONFIGURE_FILE(${HPCC_SOURCE_DIR}/docs/BuildTools/relrem.xsl.in ${CMAKE_CURRENT_BINARY_DIR}/${_file_base}.xsl @ONLY)
	RUN_XSLTPROC( ${CMAKE_CURRENT_BINARY_DIR}/${_file_base}.xsl ${_file} ${_file} ${_in_dir} ${_out_dir})
	set_source_files_properties(${_out_dir}/${_file} PROPERTIES GENERATED TRUE)
	ADD_CUSTOM_TARGET( ${_clean_target} DEPENDS ${_in_dir}/${_file} )
ENDMACRO(CLEAN_REL_BOOK)

MACRO(CLEAN_REL_SET _file _version_dir _doc_dir _in_dir _out_dir)
	STRING(REGEX REPLACE "([0-9a-z_-]*).xml" "\\1" _file_base "${_file}")
	SET(_clean_target "clean_${_file}")
	SET(VERSION_DIR ${_version_dir})
	SET(ROOT "set")
	CONFIGURE_FILE(${HPCC_SOURCE_DIR}/docs/BuildTools/relrem.xsl.in ${CMAKE_CURRENT_BINARY_DIR}/${_file_base}.xsl @ONLY)
	RUN_XSLTPROC( ${CMAKE_CURRENT_BINARY_DIR}/${_file_base}.xsl ${_file} ${_file} ${_in_dir} ${_out_dir})
	set_source_files_properties(${_out_dir}/${_file} PROPERTIES GENERATED TRUE)
	ADD_CUSTOM_TARGET( ${_clean_target} DEPENDS ${_in_dir}/${_file} )
ENDMACRO(CLEAN_REL_SET)

MACRO(DOCBOOK_TO_PDF _xsl _file _name)
	PARSE_ARGUMENTS(_DB "" "" ${ARGN})
	LIST(LENGTH _DB_DEFAULT_ARGS length)
	IF(MAKE_DOCS)
		STRING(REGEX REPLACE "([0-9a-z_-]*).xml" "\\1" _file_base "${_file}")
		SET(_fo_file ${_file_base}.fo)
		SET(_pdf_file ${_name}-${version}-${stagever}.pdf)
		SET( _docs_target "doc_${_pdf_file}")  # File to Name of type.
		CLEAN_REL_BOOK(${_file} ${VERSION_DIR} ${DOC_IMAGES} ${CMAKE_CURRENT_SOURCE_DIR} ${CMAKE_CURRENT_BINARY_DIR})
		set_source_files_properties(${CMAKE_CURRENT_BINARY_DIR}/${_file_base}.xsl  PROPERTIES GENERATED TRUE)
		RUN_XSLTPROC(${_xsl} ${_file} ${_fo_file} ${CMAKE_CURRENT_BINARY_DIR} ${CMAKE_CURRENT_BINARY_DIR} "clean_${_file}" ${_DB_DEFAULT_ARGS})
		RUN_FOP(${_fo_file} ${_pdf_file})
		set_source_files_properties(${_pdf_file} PROPERTIES GENERATED TRUE)
		MESSAGE("-- Adding document: ${_pdf_file} -  target: ${_docs_target}")
		ADD_CUSTOM_TARGET(${_docs_target} ALL DEPENDS ${_pdf_file})
		set_property(GLOBAL APPEND PROPERTY DOC_TARGETS "${_docs_target}")
	ENDIF(MAKE_DOCS)
ENDMACRO(DOCBOOK_TO_PDF targetname_suffix srcfile outfile targetdir deps_list)

MACRO(FILE_LIST_GENERATOR outxml filename linkname description)
	set(xmlout "	<file>\n")
	set(xmlout "${xmlout}		<name>${linkname}</name>\n")
	set(xmlout "${xmlout}		<description>${description}</description>\n")
	set(xmlout "${xmlout}		<filename>${filename}</filename>\n")
	set(xmlout "${xmlout}		<version>${DOC_VERSION}</version>\n")
	set(xmlout "${xmlout}	</file>\n")
	message("---- FILE_LIST_GENERATOR: Adding ${filename}")
	set(${outxml} "${${outxml}}${xmlout}")
ENDMACRO(FILE_LIST_GENERATOR)
