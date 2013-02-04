grammar SQLExpression;

options
{
  language=Java;
  output=AST;
  ASTLabelType=CommonTree;
  backtrack=true;
}

tokens
{
	PARAMPLACEHOLDER;
	COLUMN;
	TABLENAME;
	PARENEXP;
	LISTEXP;
	FUNCEXP;
}

@header
{
package  org.hpccsystems.jdbcdriver.antlr.sqlparser.generated;
}

@members
{
	@Override
	public void emitErrorMessage(String message)
	{
		throw new RuntimeException(message);
	}
}

@lexer::header
{
package  org.hpccsystems.jdbcdriver.antlr.sqlparser.generated;
}

@lexer::members
{
  @Override
  public void emitErrorMessage(String message)
  {
    throw new RuntimeException(message);
  }
}

expression
    :
    orExpression EOF!
    ;

orExpression
	:
	andExpression
	(
		OR_SYM^ andExpression
	)*
	;

andExpression
	:
	exp1=relationalExpression
	(
		AND_SYM^ relationalExpression
	)*
	;

relationalExpression
	:
	additionExpression
	(
		relational_op^
		additionExpression
	)*
;

additionExpression
	:
	multiplyExpression
	(
		 (PLUS|MINUS)^ multiplyExpression
	)?
	;

multiplyExpression
	:
	listExpression
	(
		(op1=ASTERISK
		|op1=DIVIDE
		|op1=MOD_SYM
		|op1=POWER_OP) ^
		listExpression
	)?
	;

listExpression
	:
	unaryExpression
	(
		 list_op^
		 literalExpressionList
	)?
	;

unaryExpression
	:
	//(PLUS | MINUS | NEGATION | BINARY) simple_expr
	(NEGATION | NOT_SYM )^ simpleExpression
	|
	simpleExpression (ISNOTNULL |  ISNULL)^
	|
	simpleExpression
	;

simpleExpression
	:
	column_spec
	| literal_value
	| function_call
	| parenExpression
	| parameterPlaceHolder
	| literalExpressionList
    ;

parenExpression
	:
	 LPAREN orExpression RPAREN -> ^(PARENEXP orExpression )
	;

literalExpressionList
	:
	LPAREN literal_value( COMMA literal_value )* RPAREN -> {$COMMA != null}? ^(LISTEXP literal_value+)
					                                    ->  ^(LISTEXP literal_value)
	;

function_call
    :
	(  functionList ( LPAREN (functionParam (COMMA functionParam)*)? RPAREN ) ?  ) -> {$COMMA != null}? ^(FUNCEXP functionList  functionParam+)
                                                                                   -> ^(FUNCEXP functionList functionParam)
    ;

functionParam
	:
	literal_value
	| column_spec
	| parameterPlaceHolder
	;

parameterPlaceHolder
	:
	(QUESTION
	| DOLLAR LCURLY ID? RCURLY
	| userVariable)
	-> ^(PARAMPLACEHOLDER)
	;

userVariable:
	'@' ID
;

column_spec
	:
	( quoted_table_name DOT )? quoted_column_name -> ^(COLUMN quoted_column_name quoted_table_name? )
	|( table_name DOT )? column_name -> ^(COLUMN column_name table_name? )
	;

expression_list
    :
	LPAREN orExpression ( COMMA orExpression )* RPAREN
	;

relational_op
	:
	EQ_SYM | LTH | GTH | NOT_EQ | LET | GET
	;

list_op
	:
	IN_SYM | NOT_IN
	;

string_literal:		QUOTED_STRING ;
number_literal
	:
	(PLUS! | MINUS)?
	(INTEGER_NUM | REAL_NUMBER)
	;

hex_literal:        HEX_DIGIT;

boolean_literal:    TRUE_SYM | FALSE_SYM ;

bit_literal:        BIT_NUM;

literal_value
	:
	( string_literal
	| number_literal
	| hex_literal
	| boolean_literal
	)
  ;
functionList
	:
	group_functions
	|  char_functions
	;

char_functions
    :
	LOWER
	| UPPER
	;

group_functions
    :
	AVG
	| COUNT
	| MAX_SYM
	| MIN_SYM
	| SUM
	;

schema_name         : ID;
table_name          : ID;
quoted_table_name   : QUOTED_ID;
column_name         : ID;
quoted_column_name  : QUOTED_ID;
//index_name        : ID;
//function_name     : ID;
//procedure_name    : ID;
//alias returns[String value] : ( AS_SYM )? ID {$value=$ID.text;};

fragment A_i :	'a' | 'A';
fragment B_i :	'b' | 'B';
fragment C_i :	'c' | 'C';
fragment D_i :	'd' | 'D';
fragment E_i :	'e' | 'E';
fragment F_i :	'f' | 'F';
fragment G_i :	'g' | 'G';
fragment H_i :	'h' | 'H';
fragment I_i :	'i' | 'I';
fragment J_i :	'j' | 'J';
fragment K_i :	'k' | 'K';
fragment L_i :	'l' | 'L';
fragment M_i :	'm' | 'M';
fragment N_i :	'n' | 'N';
fragment O_i :	'o' | 'O';
fragment P_i :	'p' | 'P';
fragment Q_i :	'q' | 'Q';
fragment R_i :	'r' | 'R';
fragment S_i :	's' | 'S';
fragment T_i :	't' | 'T';
fragment U_i :	'u' | 'U';
fragment V_i :	'v' | 'V';
fragment W_i :  'w' | 'W';
fragment X_i :	'x' | 'X';
fragment Y_i :	'y' | 'Y';
fragment Z_i :	'z' | 'Z';

ADD_SYM				: A_i D_i D_i  ;
ALL				    : A_i L_i L_i  ;
ANY				    : A_i N_i Y_i ;
AS_SYM				: A_i S_i  ;
ASC				    : A_i S_i C_i  ;
AT_SYM				: A_i T_i  ;
AVG				    : A_i V_i G_i;
BETWEEN				: B_i E_i T_i W_i E_i E_i N_i  ;
BIGINT				: B_i I_i G_i I_i N_i T_i  ;
BIN				    : B_i I_i N_i  ;
BINARY				: B_i I_i N_i A_i R_i Y_i  ;
BLOB_SYM			: B_i L_i O_i B_i  ;
BOOL_SYM			: B_i O_i O_i L_i  ;
BOOLEAN_SYM			: B_i O_i O_i L_i E_i A_i N_i  ;
BY_SYM				: B_i Y_i ;
BYTE_SYM			: B_i Y_i T_i E_i  ;
CALL_SYM			: C_i A_i L_i L_i  ;
CASE_SYM			: C_i A_i S_i E_i  ;
CHAR				: C_i H_i A_i R_i  ;
CHAR_LENGTH			: (C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i) | (C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i) ;
CHARACTER_SYM		: C_i H_i A_i R_i A_i C_i T_i E_i R_i  ;
CHARSET				: C_i H_i A_i R_i S_i E_i T_i  ;
COLUMN_SYM			: C_i O_i L_i U_i M_i N_i  ;
COLUMNS_SYM			: C_i O_i L_i U_i M_i N_i S_i  ;
CONCAT				: C_i O_i N_i C_i A_i T_i  ;
COUNT				: C_i O_i U_i N_i T_i  ;
DECIMAL_SYM			: D_i E_i C_i I_i M_i A_i L_i  ;
DEFAULT				: D_i E_i F_i A_i U_i L_i T_i  ;
DESC				: D_i E_i S_i C_i  ;
DISTINCT			: D_i I_i S_i T_i I_i N_i C_i T_i ;
DO_SYM				: D_i O_i  ;
DOUBLE_SYM			: D_i O_i U_i B_i L_i E_i  ;
EACH_SYM			: E_i A_i C_i H_i  ;
ELSE_SYM			: E_i L_i S_i E_i  ;
ELSIF_SYM			: E_i L_i S_i I_i F_i ;
END_SYM				: E_i N_i D_i ;
EXISTS				: E_i X_i I_i S_i T_i S_i ;
FALSE_SYM			: F_i A_i L_i S_i E_i ;
FETCH_SYM			: F_i E_i T_i C_i H_i  ;
FIELD				: F_i I_i E_i L_i D_i  ;
FILE_SYM			: F_i I_i L_i E_i  ;
FLOAT_SYM			: F_i L_i O_i A_i T_i  ;
FOR_SYM				: F_i O_i R_i  ;
FROM				: F_i R_i O_i M_i  ;
FULL				: F_i U_i L_i L_i  ;
FUNCTION_SYM		: F_i U_i N_i C_i T_i I_i O_i N_i  ;
GROUP_SYM			: G_i R_i O_i U_i P_i  ;
HAVING				: H_i A_i V_i I_i N_i G_i  ;
HEX				    : H_i E_i X_i  ;
IF				    : I_i F_i  ;
IFNULL				: I_i F_i N_i U_i L_i L_i  ;
IGNORE_SYM			: I_i G_i N_i O_i R_i E_i  ;
IN_SYM				: I_i N_i  ;
INDEX_SYM			: I_i N_i D_i E_i X_i  ;
INNER_SYM			: I_i N_i N_i E_i R_i  ;
INTEGER_SYM			: I_i N_i T_i E_i G_i E_i R_i  ;
IS_SYM				: I_i S_i  ;
JOIN_SYM			: J_i O_i I_i N_i  ;
LEFT				: L_i E_i F_i T_i  ;
LIMIT				: L_i I_i M_i I_i T_i  ;
LONG_SYM			: L_i O_i N_i G_i  ;
LONGBLOB			: L_i O_i N_i G_i B_i L_i O_i B_i  ;
LONGTEXT			: L_i O_i N_i G_i T_i E_i X_i T_i  ;
LOWER				: (L_i O_i W_i E_i R_i) | (L_i C_i A_i S_i E_i) ;
MAX_SYM				: M_i A_i X_i  ;
MEDIUMBLOB			: M_i E_i D_i I_i U_i M_i B_i L_i O_i B_i  ;
MEDIUMINT			: M_i E_i D_i I_i U_i M_i I_i N_i T_i  ;
MIN_SYM             : M_i I_i N_i  ;
NOT_SYM				: (N_i O_i T_i) | ('!') ;
NULL_SYM			: N_i U_i L_i L_i  ;
NUMERIC_SYM			: N_i U_i M_i E_i R_i I_i C_i  ;
OCT				    : O_i C_i T_i  ;
OFFSET_SYM			: O_i F_i F_i S_i E_i T_i  ;
ON				    : O_i N_i  ;
ORDER_SYM			: O_i R_i D_i E_i R_i  ;
OUTER				: O_i U_i T_i E_i R_i  ;
QUOTE				: Q_i U_i O_i T_i E_i  ;
REAL				: R_i E_i A_i L_i  ;
RIGHT				: R_i I_i G_i H_i T_i  ;
SELECT				: S_i E_i L_i E_i C_i T_i ;
SMALLINT			: S_i M_i A_i L_i L_i I_i N_i T_i  ;
STRAIGHT_JOIN		: S_i T_i R_i A_i I_i G_i H_i T_i  '_' J_i O_i I_i N_i  ;
STRING_SYM			: S_i T_i R_i I_i N_i G_i  ;
SUM				    : S_i U_i M_i  ;
THEN_SYM			: T_i H_i E_i N_i  ;
TIME_SYM			: T_i I_i M_i E_i  ;
TINYBLOB			: T_i I_i N_i Y_i B_i L_i O_i B_i  ;
TINYINT				: T_i I_i N_i Y_i I_i N_i T_i  ;
TINYTEXT			: T_i I_i N_i Y_i T_i E_i X_i T_i  ;
TRUE_SYM			: T_i R_i U_i E_i ;
UNSIGNED_SYM		: U_i N_i S_i I_i G_i N_i E_i D_i  ;
//UPPER				: (U_i P_i P_i E_i R_i) | (U_i C_i A_i S_i E_i)  ;
UPPER               : U_i P_i P_i E_i R_i ;
USE_SYM				: U_i S_i E_i  ;
VARBINARY			: V_i A_i R_i B_i I_i N_i A_i R_i Y_i  ;
VARCHAR				: V_i A_i R_i C_i H_i A_i R_i  ;
WHEN_SYM			: W_i H_i E_i N_i 	;
WHERE				: W_i H_i E_i R_i E_i  ;
XML_SYM				: X_i M_i L_i  ;

ISNOTNULL 	 : IS_SYM WHITE_SPACE NOT_SYM WHITE_SPACE NULL_SYM;
ISNULL 	     : IS_SYM WHITE_SPACE NULL_SYM;
NOT_IN	     : NOT_SYM WHITE_SPACE IN_SYM;
DIVIDE	     : (  D_i I_i V_i ) | '/' ;
MOD_SYM	     : (  M_i O_i D_i ) | '%' ;
OR_SYM	     : (  O_i R_i ) | '||';
AND_SYM	     : (  A_i N_i D_i ) | '&&';
ARROW	     : '=>' ;
EQ_SYM	     : '=' | '<=>' ;
NOT_EQ	     : '<>' | '!=' | '~='| '^=';
LET	         : '<=' ;
GET	         : '>=' ;
SET_VAR	     : ':=' ;
SHIFT_LEFT	 : '<<' ;
SHIFT_RIGHT  : '>>' ;
ALL_FIELDS	 : '.*' ;
SQUOTE	     : '\'' ;
DQUOTE	     : '\"' ;
COLONCOLON   : '::' ;
DOLLAR	     : '$' ;
QUESTION     : '?' ;
SEMI	     : ';' ;
COLON	     : ':' ;
DOT	         : '.' ;
COMMA	     : ',' ;
ASTERISK     : '*' ;
RPAREN	     : ')' ;
LPAREN	     : '(' ;
RBRACK	     : ']' ;
LBRACK	     : '[' ;
LCURLY 	     : '{' ;
RCURLY	     : '}' ;
PLUS	     : '+' ;
MINUS	     : '-' ;
NEGATION     : '~' ;
VERTBAR	     : '|' ;
BITAND	     : '&' ;
POWER_OP     : '^' ;
GTH	         : '>' ;
LTH	         : '<' ;
//DOTASTERISK	: '.*' ; //The Combination of DOT and ASTERISK was only working if seperated by a space in between

INTEGER_NUM		: ('0'..'9')+ ;

fragment HEX_DIGIT_FRAGMENT: ( 'a'..'f' | 'A'..'F' | '0'..'9' ) ;

HEX_DIGIT
    :
	(  '0x'     (HEX_DIGIT_FRAGMENT)+  )
	|
	(  'X' '\'' (HEX_DIGIT_FRAGMENT)+ '\''  )
	;

BIT_NUM
    :
	(  '0b'    ('0'|'1')+  )
	|
	(  B_i '\'' ('0'|'1')+ '\''  )
	;

REAL_NUMBER
    :
	(  INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM  )
	(  ('E'|'e') ( PLUS | MINUS )? INTEGER_NUM  )?
	;

QUOTED_STRING
    :
    SQUOTE
    ( 
        (SQUOTE SQUOTE)
        | ('\\''\'')
        | ~('\'')
    )*
    SQUOTE
	;

QUOTED_ID : DQUOTE cont=ID DQUOTE {setText($cont.getText());};

ID	: ( 'A'..'Z' | 'a'..'z' ) ( 'A'..'Z' | 'a'..'z' | '_'  | '0'..'9' | '::')*;

WHITE_SPACE	: ( ' '|'\r'|'\t'|'\n' ) {$channel=HIDDEN;} ;
