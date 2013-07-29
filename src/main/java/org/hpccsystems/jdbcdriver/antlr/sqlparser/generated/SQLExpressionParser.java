// $ANTLR 3.4 /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g 2013-07-16 14:47:32

package  org.hpccsystems.jdbcdriver.antlr.sqlparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class SQLExpressionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD_SYM", "ALL", "ALL_FIELDS", "AND_SYM", "ANY", "ARROW", "ASC", "ASTERISK", "AS_SYM", "AT_SYM", "AVG", "A_i", "BETWEEN", "BIGINT", "BIN", "BINARY", "BITAND", "BIT_NUM", "BLOB_SYM", "BOOLEAN_SYM", "BOOL_SYM", "BYTE_SYM", "BY_SYM", "B_i", "CALL_SYM", "CASE_SYM", "CHAR", "CHARACTER_SYM", "CHARSET", "CHAR_LENGTH", "COLON", "COLONCOLON", "COLUMN", "COLUMNS_SYM", "COLUMN_SYM", "COMMA", "CONCAT", "COUNT", "C_i", "DECIMAL_SYM", "DEFAULT", "DESC", "DISTINCT", "DIVIDE", "DOLLAR", "DOT", "DOUBLE_SYM", "DO_SYM", "DQUOTE", "D_i", "EACH_SYM", "ELSE_SYM", "ELSIF_SYM", "END_SYM", "EQ_SYM", "EXISTS", "E_i", "FALSE_SYM", "FETCH_SYM", "FIELD", "FILE_SYM", "FLOAT_SYM", "FOR_SYM", "FROM", "FULL", "FUNCEXP", "FUNCTION_SYM", "F_i", "GET", "GROUP_SYM", "GTH", "G_i", "HAVING", "HEX", "HEX_DIGIT", "HEX_DIGIT_FRAGMENT", "H_i", "ID", "IF", "IFNULL", "IGNORE_SYM", "INDEX_SYM", "INNER_SYM", "INTEGER_NUM", "INTEGER_SYM", "IN_SYM", "ISNOTNULL", "ISNULL", "IS_SYM", "I_i", "JOIN_SYM", "J_i", "K_i", "LBRACK", "LCURLY", "LEFT", "LET", "LIMIT", "LISTEXP", "LONGBLOB", "LONGTEXT", "LONG_SYM", "LOWER", "LPAREN", "LTH", "L_i", "MAX_SYM", "MEDIUMBLOB", "MEDIUMINT", "MINUS", "MIN_SYM", "MOD_SYM", "M_i", "NEGATION", "NOT_EQ", "NOT_IN", "NOT_SYM", "NULL_SYM", "NUMERIC_SYM", "N_i", "OCT", "OFFSET_SYM", "ON", "ORDER_SYM", "OR_SYM", "OUTER", "O_i", "PARAMPLACEHOLDER", "PARENEXP", "PLUS", "POWER_OP", "P_i", "QUESTION", "QUOTE", "QUOTED_ID", "QUOTED_STRING", "Q_i", "RBRACK", "RCURLY", "REAL", "REAL_NUMBER", "RIGHT", "RPAREN", "R_i", "SELECT", "SEMI", "SET_VAR", "SHIFT_LEFT", "SHIFT_RIGHT", "SMALLINT", "SQUOTE", "STRAIGHT_JOIN", "STRING_SYM", "SUM", "S_i", "TABLENAME", "THEN_SYM", "TIME_SYM", "TINYBLOB", "TINYINT", "TINYTEXT", "TRUE_SYM", "T_i", "UNSIGNED_SYM", "UPPER", "USE_SYM", "U_i", "VARBINARY", "VARCHAR", "VERTBAR", "V_i", "WHEN_SYM", "WHERE", "WHITE_SPACE", "W_i", "XML_SYM", "X_i", "Y_i", "Z_i", "'@'"
    };

    public static final int EOF=-1;
    public static final int T__183=183;
    public static final int ADD_SYM=4;
    public static final int ALL=5;
    public static final int ALL_FIELDS=6;
    public static final int AND_SYM=7;
    public static final int ANY=8;
    public static final int ARROW=9;
    public static final int ASC=10;
    public static final int ASTERISK=11;
    public static final int AS_SYM=12;
    public static final int AT_SYM=13;
    public static final int AVG=14;
    public static final int A_i=15;
    public static final int BETWEEN=16;
    public static final int BIGINT=17;
    public static final int BIN=18;
    public static final int BINARY=19;
    public static final int BITAND=20;
    public static final int BIT_NUM=21;
    public static final int BLOB_SYM=22;
    public static final int BOOLEAN_SYM=23;
    public static final int BOOL_SYM=24;
    public static final int BYTE_SYM=25;
    public static final int BY_SYM=26;
    public static final int B_i=27;
    public static final int CALL_SYM=28;
    public static final int CASE_SYM=29;
    public static final int CHAR=30;
    public static final int CHARACTER_SYM=31;
    public static final int CHARSET=32;
    public static final int CHAR_LENGTH=33;
    public static final int COLON=34;
    public static final int COLONCOLON=35;
    public static final int COLUMN=36;
    public static final int COLUMNS_SYM=37;
    public static final int COLUMN_SYM=38;
    public static final int COMMA=39;
    public static final int CONCAT=40;
    public static final int COUNT=41;
    public static final int C_i=42;
    public static final int DECIMAL_SYM=43;
    public static final int DEFAULT=44;
    public static final int DESC=45;
    public static final int DISTINCT=46;
    public static final int DIVIDE=47;
    public static final int DOLLAR=48;
    public static final int DOT=49;
    public static final int DOUBLE_SYM=50;
    public static final int DO_SYM=51;
    public static final int DQUOTE=52;
    public static final int D_i=53;
    public static final int EACH_SYM=54;
    public static final int ELSE_SYM=55;
    public static final int ELSIF_SYM=56;
    public static final int END_SYM=57;
    public static final int EQ_SYM=58;
    public static final int EXISTS=59;
    public static final int E_i=60;
    public static final int FALSE_SYM=61;
    public static final int FETCH_SYM=62;
    public static final int FIELD=63;
    public static final int FILE_SYM=64;
    public static final int FLOAT_SYM=65;
    public static final int FOR_SYM=66;
    public static final int FROM=67;
    public static final int FULL=68;
    public static final int FUNCEXP=69;
    public static final int FUNCTION_SYM=70;
    public static final int F_i=71;
    public static final int GET=72;
    public static final int GROUP_SYM=73;
    public static final int GTH=74;
    public static final int G_i=75;
    public static final int HAVING=76;
    public static final int HEX=77;
    public static final int HEX_DIGIT=78;
    public static final int HEX_DIGIT_FRAGMENT=79;
    public static final int H_i=80;
    public static final int ID=81;
    public static final int IF=82;
    public static final int IFNULL=83;
    public static final int IGNORE_SYM=84;
    public static final int INDEX_SYM=85;
    public static final int INNER_SYM=86;
    public static final int INTEGER_NUM=87;
    public static final int INTEGER_SYM=88;
    public static final int IN_SYM=89;
    public static final int ISNOTNULL=90;
    public static final int ISNULL=91;
    public static final int IS_SYM=92;
    public static final int I_i=93;
    public static final int JOIN_SYM=94;
    public static final int J_i=95;
    public static final int K_i=96;
    public static final int LBRACK=97;
    public static final int LCURLY=98;
    public static final int LEFT=99;
    public static final int LET=100;
    public static final int LIMIT=101;
    public static final int LISTEXP=102;
    public static final int LONGBLOB=103;
    public static final int LONGTEXT=104;
    public static final int LONG_SYM=105;
    public static final int LOWER=106;
    public static final int LPAREN=107;
    public static final int LTH=108;
    public static final int L_i=109;
    public static final int MAX_SYM=110;
    public static final int MEDIUMBLOB=111;
    public static final int MEDIUMINT=112;
    public static final int MINUS=113;
    public static final int MIN_SYM=114;
    public static final int MOD_SYM=115;
    public static final int M_i=116;
    public static final int NEGATION=117;
    public static final int NOT_EQ=118;
    public static final int NOT_IN=119;
    public static final int NOT_SYM=120;
    public static final int NULL_SYM=121;
    public static final int NUMERIC_SYM=122;
    public static final int N_i=123;
    public static final int OCT=124;
    public static final int OFFSET_SYM=125;
    public static final int ON=126;
    public static final int ORDER_SYM=127;
    public static final int OR_SYM=128;
    public static final int OUTER=129;
    public static final int O_i=130;
    public static final int PARAMPLACEHOLDER=131;
    public static final int PARENEXP=132;
    public static final int PLUS=133;
    public static final int POWER_OP=134;
    public static final int P_i=135;
    public static final int QUESTION=136;
    public static final int QUOTE=137;
    public static final int QUOTED_ID=138;
    public static final int QUOTED_STRING=139;
    public static final int Q_i=140;
    public static final int RBRACK=141;
    public static final int RCURLY=142;
    public static final int REAL=143;
    public static final int REAL_NUMBER=144;
    public static final int RIGHT=145;
    public static final int RPAREN=146;
    public static final int R_i=147;
    public static final int SELECT=148;
    public static final int SEMI=149;
    public static final int SET_VAR=150;
    public static final int SHIFT_LEFT=151;
    public static final int SHIFT_RIGHT=152;
    public static final int SMALLINT=153;
    public static final int SQUOTE=154;
    public static final int STRAIGHT_JOIN=155;
    public static final int STRING_SYM=156;
    public static final int SUM=157;
    public static final int S_i=158;
    public static final int TABLENAME=159;
    public static final int THEN_SYM=160;
    public static final int TIME_SYM=161;
    public static final int TINYBLOB=162;
    public static final int TINYINT=163;
    public static final int TINYTEXT=164;
    public static final int TRUE_SYM=165;
    public static final int T_i=166;
    public static final int UNSIGNED_SYM=167;
    public static final int UPPER=168;
    public static final int USE_SYM=169;
    public static final int U_i=170;
    public static final int VARBINARY=171;
    public static final int VARCHAR=172;
    public static final int VERTBAR=173;
    public static final int V_i=174;
    public static final int WHEN_SYM=175;
    public static final int WHERE=176;
    public static final int WHITE_SPACE=177;
    public static final int W_i=178;
    public static final int XML_SYM=179;
    public static final int X_i=180;
    public static final int Y_i=181;
    public static final int Z_i=182;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SQLExpressionParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQLExpressionParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return SQLExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "/home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g"; }


    	@Override
    	public void emitErrorMessage(String message)
    	{
    		throw new RuntimeException(message);
    	}


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:49:1: expression : orExpression EOF !;
    public final SQLExpressionParser.expression_return expression() throws RecognitionException {
        SQLExpressionParser.expression_return retval = new SQLExpressionParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF2=null;
        SQLExpressionParser.orExpression_return orExpression1 =null;


        CommonTree EOF2_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:50:5: ( orExpression EOF !)
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:51:5: orExpression EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_orExpression_in_expression110);
            orExpression1=orExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpression1.getTree());

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_expression112); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class orExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "orExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:54:1: orExpression : andExpression ( OR_SYM ^ andExpression )* ;
    public final SQLExpressionParser.orExpression_return orExpression() throws RecognitionException {
        SQLExpressionParser.orExpression_return retval = new SQLExpressionParser.orExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OR_SYM4=null;
        SQLExpressionParser.andExpression_return andExpression3 =null;

        SQLExpressionParser.andExpression_return andExpression5 =null;


        CommonTree OR_SYM4_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:55:2: ( andExpression ( OR_SYM ^ andExpression )* )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:56:2: andExpression ( OR_SYM ^ andExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_andExpression_in_orExpression128);
            andExpression3=andExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression3.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:57:2: ( OR_SYM ^ andExpression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OR_SYM) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:58:3: OR_SYM ^ andExpression
            	    {
            	    OR_SYM4=(Token)match(input,OR_SYM,FOLLOW_OR_SYM_in_orExpression135); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR_SYM4_tree = 
            	    (CommonTree)adaptor.create(OR_SYM4)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR_SYM4_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_andExpression_in_orExpression138);
            	    andExpression5=andExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression5.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "orExpression"


    public static class andExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "andExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:62:1: andExpression : exp1= relationalExpression ( AND_SYM ^ relationalExpression )* ;
    public final SQLExpressionParser.andExpression_return andExpression() throws RecognitionException {
        SQLExpressionParser.andExpression_return retval = new SQLExpressionParser.andExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token AND_SYM6=null;
        SQLExpressionParser.relationalExpression_return exp1 =null;

        SQLExpressionParser.relationalExpression_return relationalExpression7 =null;


        CommonTree AND_SYM6_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:63:2: (exp1= relationalExpression ( AND_SYM ^ relationalExpression )* )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:64:2: exp1= relationalExpression ( AND_SYM ^ relationalExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_relationalExpression_in_andExpression156);
            exp1=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exp1.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:65:2: ( AND_SYM ^ relationalExpression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND_SYM) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:66:3: AND_SYM ^ relationalExpression
            	    {
            	    AND_SYM6=(Token)match(input,AND_SYM,FOLLOW_AND_SYM_in_andExpression163); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND_SYM6_tree = 
            	    (CommonTree)adaptor.create(AND_SYM6)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND_SYM6_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_andExpression166);
            	    relationalExpression7=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "andExpression"


    public static class relationalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relationalExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:70:1: relationalExpression : additionExpression ( relational_op ^ additionExpression )* ;
    public final SQLExpressionParser.relationalExpression_return relationalExpression() throws RecognitionException {
        SQLExpressionParser.relationalExpression_return retval = new SQLExpressionParser.relationalExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.additionExpression_return additionExpression8 =null;

        SQLExpressionParser.relational_op_return relational_op9 =null;

        SQLExpressionParser.additionExpression_return additionExpression10 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:71:2: ( additionExpression ( relational_op ^ additionExpression )* )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:72:2: additionExpression ( relational_op ^ additionExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_additionExpression_in_relationalExpression182);
            additionExpression8=additionExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additionExpression8.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:73:2: ( relational_op ^ additionExpression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==EQ_SYM||LA3_0==GET||LA3_0==GTH||LA3_0==LET||LA3_0==LTH||LA3_0==NOT_EQ) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:74:3: relational_op ^ additionExpression
            	    {
            	    pushFollow(FOLLOW_relational_op_in_relationalExpression189);
            	    relational_op9=relational_op();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(relational_op9.getTree(), root_0);

            	    pushFollow(FOLLOW_additionExpression_in_relationalExpression194);
            	    additionExpression10=additionExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additionExpression10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"


    public static class additionExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "additionExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:79:1: additionExpression : multiplyExpression ( ( PLUS | MINUS ) ^ multiplyExpression )? ;
    public final SQLExpressionParser.additionExpression_return additionExpression() throws RecognitionException {
        SQLExpressionParser.additionExpression_return retval = new SQLExpressionParser.additionExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set12=null;
        SQLExpressionParser.multiplyExpression_return multiplyExpression11 =null;

        SQLExpressionParser.multiplyExpression_return multiplyExpression13 =null;


        CommonTree set12_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:80:2: ( multiplyExpression ( ( PLUS | MINUS ) ^ multiplyExpression )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:81:2: multiplyExpression ( ( PLUS | MINUS ) ^ multiplyExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_multiplyExpression_in_additionExpression209);
            multiplyExpression11=multiplyExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpression11.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:82:2: ( ( PLUS | MINUS ) ^ multiplyExpression )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==MINUS||LA4_0==PLUS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:83:4: ( PLUS | MINUS ) ^ multiplyExpression
                    {
                    set12=(Token)input.LT(1);

                    set12=(Token)input.LT(1);

                    if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(set12)
                        , root_0);
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_multiplyExpression_in_additionExpression224);
                    multiplyExpression13=multiplyExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpression13.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "additionExpression"


    public static class multiplyExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multiplyExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:87:1: multiplyExpression : listExpression ( (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP ) ^ listExpression )? ;
    public final SQLExpressionParser.multiplyExpression_return multiplyExpression() throws RecognitionException {
        SQLExpressionParser.multiplyExpression_return retval = new SQLExpressionParser.multiplyExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token op1=null;
        SQLExpressionParser.listExpression_return listExpression14 =null;

        SQLExpressionParser.listExpression_return listExpression15 =null;


        CommonTree op1_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:88:2: ( listExpression ( (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP ) ^ listExpression )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:89:2: listExpression ( (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP ) ^ listExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_listExpression_in_multiplyExpression240);
            listExpression14=listExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, listExpression14.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:90:2: ( (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP ) ^ listExpression )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ASTERISK||LA6_0==DIVIDE||LA6_0==MOD_SYM||LA6_0==POWER_OP) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:91:3: (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP ) ^ listExpression
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:91:3: (op1= ASTERISK |op1= DIVIDE |op1= MOD_SYM |op1= POWER_OP )
                    int alt5=4;
                    switch ( input.LA(1) ) {
                    case ASTERISK:
                        {
                        alt5=1;
                        }
                        break;
                    case DIVIDE:
                        {
                        alt5=2;
                        }
                        break;
                    case MOD_SYM:
                        {
                        alt5=3;
                        }
                        break;
                    case POWER_OP:
                        {
                        alt5=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;

                    }

                    switch (alt5) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:91:4: op1= ASTERISK
                            {
                            op1=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_multiplyExpression250); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op1_tree = 
                            (CommonTree)adaptor.create(op1)
                            ;
                            adaptor.addChild(root_0, op1_tree);
                            }

                            }
                            break;
                        case 2 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:92:4: op1= DIVIDE
                            {
                            op1=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplyExpression257); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op1_tree = 
                            (CommonTree)adaptor.create(op1)
                            ;
                            adaptor.addChild(root_0, op1_tree);
                            }

                            }
                            break;
                        case 3 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:93:4: op1= MOD_SYM
                            {
                            op1=(Token)match(input,MOD_SYM,FOLLOW_MOD_SYM_in_multiplyExpression264); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op1_tree = 
                            (CommonTree)adaptor.create(op1)
                            ;
                            adaptor.addChild(root_0, op1_tree);
                            }

                            }
                            break;
                        case 4 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:94:4: op1= POWER_OP
                            {
                            op1=(Token)match(input,POWER_OP,FOLLOW_POWER_OP_in_multiplyExpression271); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            op1_tree = 
                            (CommonTree)adaptor.create(op1)
                            ;
                            adaptor.addChild(root_0, op1_tree);
                            }

                            }
                            break;

                    }


                    pushFollow(FOLLOW_listExpression_in_multiplyExpression278);
                    listExpression15=listExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listExpression15.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multiplyExpression"


    public static class listExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:99:1: listExpression : unaryExpression ( list_op ^ literalExpressionList )? ;
    public final SQLExpressionParser.listExpression_return listExpression() throws RecognitionException {
        SQLExpressionParser.listExpression_return retval = new SQLExpressionParser.listExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.unaryExpression_return unaryExpression16 =null;

        SQLExpressionParser.list_op_return list_op17 =null;

        SQLExpressionParser.literalExpressionList_return literalExpressionList18 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:100:2: ( unaryExpression ( list_op ^ literalExpressionList )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:101:2: unaryExpression ( list_op ^ literalExpressionList )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unaryExpression_in_listExpression294);
            unaryExpression16=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression16.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:102:2: ( list_op ^ literalExpressionList )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==IN_SYM||LA7_0==NOT_IN) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:103:4: list_op ^ literalExpressionList
                    {
                    pushFollow(FOLLOW_list_op_in_listExpression302);
                    list_op17=list_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(list_op17.getTree(), root_0);

                    pushFollow(FOLLOW_literalExpressionList_in_listExpression308);
                    literalExpressionList18=literalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalExpressionList18.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "listExpression"


    public static class unaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unaryExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:108:1: unaryExpression : ( ( NEGATION | NOT_SYM ) ^ simpleExpression | simpleExpression ( ISNOTNULL | ISNULL ) ^| simpleExpression );
    public final SQLExpressionParser.unaryExpression_return unaryExpression() throws RecognitionException {
        SQLExpressionParser.unaryExpression_return retval = new SQLExpressionParser.unaryExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set19=null;
        Token set22=null;
        SQLExpressionParser.simpleExpression_return simpleExpression20 =null;

        SQLExpressionParser.simpleExpression_return simpleExpression21 =null;

        SQLExpressionParser.simpleExpression_return simpleExpression23 =null;


        CommonTree set19_tree=null;
        CommonTree set22_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:109:2: ( ( NEGATION | NOT_SYM ) ^ simpleExpression | simpleExpression ( ISNOTNULL | ISNULL ) ^| simpleExpression )
            int alt8=3;
            switch ( input.LA(1) ) {
            case NEGATION:
            case NOT_SYM:
                {
                alt8=1;
                }
                break;
            case QUOTED_ID:
                {
                int LA8_2 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA8_3 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;

                }
                }
                break;
            case QUOTED_STRING:
                {
                int LA8_4 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;

                }
                }
                break;
            case PLUS:
                {
                int LA8_5 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 5, input);

                    throw nvae;

                }
                }
                break;
            case MINUS:
                {
                int LA8_6 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;

                }
                }
                break;
            case INTEGER_NUM:
            case REAL_NUMBER:
                {
                int LA8_7 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 7, input);

                    throw nvae;

                }
                }
                break;
            case HEX_DIGIT:
                {
                int LA8_8 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 8, input);

                    throw nvae;

                }
                }
                break;
            case FALSE_SYM:
            case TRUE_SYM:
                {
                int LA8_9 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 9, input);

                    throw nvae;

                }
                }
                break;
            case AVG:
            case COUNT:
            case MAX_SYM:
            case MIN_SYM:
            case SUM:
                {
                int LA8_10 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 10, input);

                    throw nvae;

                }
                }
                break;
            case LOWER:
            case UPPER:
                {
                int LA8_11 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 11, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                int LA8_12 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 12, input);

                    throw nvae;

                }
                }
                break;
            case QUESTION:
                {
                int LA8_13 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 13, input);

                    throw nvae;

                }
                }
                break;
            case DOLLAR:
                {
                int LA8_14 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 14, input);

                    throw nvae;

                }
                }
                break;
            case 183:
                {
                int LA8_15 = input.LA(2);

                if ( (synpred14_SQLExpression()) ) {
                    alt8=2;
                }
                else if ( (true) ) {
                    alt8=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 15, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:110:2: ( NEGATION | NOT_SYM ) ^ simpleExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    set19=(Token)input.LT(1);

                    set19=(Token)input.LT(1);

                    if ( input.LA(1)==NEGATION||input.LA(1)==NOT_SYM ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(set19)
                        , root_0);
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_simpleExpression_in_unaryExpression334);
                    simpleExpression20=simpleExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpression20.getTree());

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:112:2: simpleExpression ( ISNOTNULL | ISNULL ) ^
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_simpleExpression_in_unaryExpression340);
                    simpleExpression21=simpleExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpression21.getTree());

                    set22=(Token)input.LT(1);

                    set22=(Token)input.LT(1);

                    if ( (input.LA(1) >= ISNOTNULL && input.LA(1) <= ISNULL) ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(set22)
                        , root_0);
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:114:2: simpleExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_simpleExpression_in_unaryExpression356);
                    simpleExpression23=simpleExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpression23.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"


    public static class simpleExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:117:1: simpleExpression : ( column_spec | literal_value | function_call | parenExpression | parameterPlaceHolder | literalExpressionList );
    public final SQLExpressionParser.simpleExpression_return simpleExpression() throws RecognitionException {
        SQLExpressionParser.simpleExpression_return retval = new SQLExpressionParser.simpleExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.column_spec_return column_spec24 =null;

        SQLExpressionParser.literal_value_return literal_value25 =null;

        SQLExpressionParser.function_call_return function_call26 =null;

        SQLExpressionParser.parenExpression_return parenExpression27 =null;

        SQLExpressionParser.parameterPlaceHolder_return parameterPlaceHolder28 =null;

        SQLExpressionParser.literalExpressionList_return literalExpressionList29 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:118:2: ( column_spec | literal_value | function_call | parenExpression | parameterPlaceHolder | literalExpressionList )
            int alt9=6;
            switch ( input.LA(1) ) {
            case ID:
            case QUOTED_ID:
                {
                alt9=1;
                }
                break;
            case FALSE_SYM:
            case HEX_DIGIT:
            case INTEGER_NUM:
            case MINUS:
            case PLUS:
            case QUOTED_STRING:
            case REAL_NUMBER:
            case TRUE_SYM:
                {
                alt9=2;
                }
                break;
            case AVG:
            case COUNT:
            case LOWER:
            case MAX_SYM:
            case MIN_SYM:
            case SUM:
            case UPPER:
                {
                alt9=3;
                }
                break;
            case LPAREN:
                {
                switch ( input.LA(2) ) {
                case AVG:
                case COUNT:
                case DOLLAR:
                case ID:
                case LOWER:
                case LPAREN:
                case MAX_SYM:
                case MIN_SYM:
                case NEGATION:
                case NOT_SYM:
                case QUESTION:
                case QUOTED_ID:
                case SUM:
                case UPPER:
                case 183:
                    {
                    alt9=4;
                    }
                    break;
                case QUOTED_STRING:
                    {
                    switch ( input.LA(3) ) {
                    case AND_SYM:
                    case ASTERISK:
                    case DIVIDE:
                    case EQ_SYM:
                    case GET:
                    case GTH:
                    case IN_SYM:
                    case ISNOTNULL:
                    case ISNULL:
                    case LET:
                    case LTH:
                    case MINUS:
                    case MOD_SYM:
                    case NOT_EQ:
                    case NOT_IN:
                    case OR_SYM:
                    case PLUS:
                    case POWER_OP:
                        {
                        alt9=4;
                        }
                        break;
                    case RPAREN:
                        {
                        int LA9_13 = input.LA(4);

                        if ( (synpred18_SQLExpression()) ) {
                            alt9=4;
                        }
                        else if ( (true) ) {
                            alt9=6;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 13, input);

                            throw nvae;

                        }
                        }
                        break;
                    case COMMA:
                        {
                        alt9=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 7, input);

                        throw nvae;

                    }

                    }
                    break;
                case PLUS:
                    {
                    int LA9_8 = input.LA(3);

                    if ( (LA9_8==INTEGER_NUM||LA9_8==REAL_NUMBER) ) {
                        switch ( input.LA(4) ) {
                        case AND_SYM:
                        case ASTERISK:
                        case DIVIDE:
                        case EQ_SYM:
                        case GET:
                        case GTH:
                        case IN_SYM:
                        case ISNOTNULL:
                        case ISNULL:
                        case LET:
                        case LTH:
                        case MINUS:
                        case MOD_SYM:
                        case NOT_EQ:
                        case NOT_IN:
                        case OR_SYM:
                        case PLUS:
                        case POWER_OP:
                            {
                            alt9=4;
                            }
                            break;
                        case RPAREN:
                            {
                            int LA9_15 = input.LA(5);

                            if ( (synpred18_SQLExpression()) ) {
                                alt9=4;
                            }
                            else if ( (true) ) {
                                alt9=6;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 15, input);

                                throw nvae;

                            }
                            }
                            break;
                        case COMMA:
                            {
                            alt9=6;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 10, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 8, input);

                        throw nvae;

                    }
                    }
                    break;
                case MINUS:
                    {
                    int LA9_9 = input.LA(3);

                    if ( (LA9_9==INTEGER_NUM||LA9_9==REAL_NUMBER) ) {
                        switch ( input.LA(4) ) {
                        case AND_SYM:
                        case ASTERISK:
                        case DIVIDE:
                        case EQ_SYM:
                        case GET:
                        case GTH:
                        case IN_SYM:
                        case ISNOTNULL:
                        case ISNULL:
                        case LET:
                        case LTH:
                        case MINUS:
                        case MOD_SYM:
                        case NOT_EQ:
                        case NOT_IN:
                        case OR_SYM:
                        case PLUS:
                        case POWER_OP:
                            {
                            alt9=4;
                            }
                            break;
                        case RPAREN:
                            {
                            int LA9_15 = input.LA(5);

                            if ( (synpred18_SQLExpression()) ) {
                                alt9=4;
                            }
                            else if ( (true) ) {
                                alt9=6;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 15, input);

                                throw nvae;

                            }
                            }
                            break;
                        case COMMA:
                            {
                            alt9=6;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 10, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 9, input);

                        throw nvae;

                    }
                    }
                    break;
                case INTEGER_NUM:
                case REAL_NUMBER:
                    {
                    switch ( input.LA(3) ) {
                    case AND_SYM:
                    case ASTERISK:
                    case DIVIDE:
                    case EQ_SYM:
                    case GET:
                    case GTH:
                    case IN_SYM:
                    case ISNOTNULL:
                    case ISNULL:
                    case LET:
                    case LTH:
                    case MINUS:
                    case MOD_SYM:
                    case NOT_EQ:
                    case NOT_IN:
                    case OR_SYM:
                    case PLUS:
                    case POWER_OP:
                        {
                        alt9=4;
                        }
                        break;
                    case RPAREN:
                        {
                        int LA9_15 = input.LA(4);

                        if ( (synpred18_SQLExpression()) ) {
                            alt9=4;
                        }
                        else if ( (true) ) {
                            alt9=6;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 15, input);

                            throw nvae;

                        }
                        }
                        break;
                    case COMMA:
                        {
                        alt9=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 10, input);

                        throw nvae;

                    }

                    }
                    break;
                case HEX_DIGIT:
                    {
                    switch ( input.LA(3) ) {
                    case AND_SYM:
                    case ASTERISK:
                    case DIVIDE:
                    case EQ_SYM:
                    case GET:
                    case GTH:
                    case IN_SYM:
                    case ISNOTNULL:
                    case ISNULL:
                    case LET:
                    case LTH:
                    case MINUS:
                    case MOD_SYM:
                    case NOT_EQ:
                    case NOT_IN:
                    case OR_SYM:
                    case PLUS:
                    case POWER_OP:
                        {
                        alt9=4;
                        }
                        break;
                    case RPAREN:
                        {
                        int LA9_16 = input.LA(4);

                        if ( (synpred18_SQLExpression()) ) {
                            alt9=4;
                        }
                        else if ( (true) ) {
                            alt9=6;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 16, input);

                            throw nvae;

                        }
                        }
                        break;
                    case COMMA:
                        {
                        alt9=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 11, input);

                        throw nvae;

                    }

                    }
                    break;
                case FALSE_SYM:
                case TRUE_SYM:
                    {
                    switch ( input.LA(3) ) {
                    case AND_SYM:
                    case ASTERISK:
                    case DIVIDE:
                    case EQ_SYM:
                    case GET:
                    case GTH:
                    case IN_SYM:
                    case ISNOTNULL:
                    case ISNULL:
                    case LET:
                    case LTH:
                    case MINUS:
                    case MOD_SYM:
                    case NOT_EQ:
                    case NOT_IN:
                    case OR_SYM:
                    case PLUS:
                    case POWER_OP:
                        {
                        alt9=4;
                        }
                        break;
                    case RPAREN:
                        {
                        int LA9_17 = input.LA(4);

                        if ( (synpred18_SQLExpression()) ) {
                            alt9=4;
                        }
                        else if ( (true) ) {
                            alt9=6;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 17, input);

                            throw nvae;

                        }
                        }
                        break;
                    case COMMA:
                        {
                        alt9=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 12, input);

                        throw nvae;

                    }

                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 4, input);

                    throw nvae;

                }

                }
                break;
            case DOLLAR:
            case QUESTION:
            case 183:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:119:2: column_spec
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_column_spec_in_simpleExpression368);
                    column_spec24=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec24.getTree());

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:120:4: literal_value
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_value_in_simpleExpression373);
                    literal_value25=literal_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_value25.getTree());

                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:121:4: function_call
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_function_call_in_simpleExpression378);
                    function_call26=function_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function_call26.getTree());

                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:122:4: parenExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_parenExpression_in_simpleExpression383);
                    parenExpression27=parenExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parenExpression27.getTree());

                    }
                    break;
                case 5 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:123:4: parameterPlaceHolder
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_parameterPlaceHolder_in_simpleExpression388);
                    parameterPlaceHolder28=parameterPlaceHolder();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterPlaceHolder28.getTree());

                    }
                    break;
                case 6 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:124:4: literalExpressionList
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literalExpressionList_in_simpleExpression393);
                    literalExpressionList29=literalExpressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literalExpressionList29.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleExpression"


    public static class parenExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parenExpression"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:127:1: parenExpression : LPAREN orExpression RPAREN -> ^( PARENEXP orExpression ) ;
    public final SQLExpressionParser.parenExpression_return parenExpression() throws RecognitionException {
        SQLExpressionParser.parenExpression_return retval = new SQLExpressionParser.parenExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN30=null;
        Token RPAREN32=null;
        SQLExpressionParser.orExpression_return orExpression31 =null;


        CommonTree LPAREN30_tree=null;
        CommonTree RPAREN32_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_orExpression=new RewriteRuleSubtreeStream(adaptor,"rule orExpression");
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:128:2: ( LPAREN orExpression RPAREN -> ^( PARENEXP orExpression ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:129:3: LPAREN orExpression RPAREN
            {
            LPAREN30=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_parenExpression409); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN30);


            pushFollow(FOLLOW_orExpression_in_parenExpression411);
            orExpression31=orExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_orExpression.add(orExpression31.getTree());

            RPAREN32=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_parenExpression413); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN32);


            // AST REWRITE
            // elements: orExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 129:30: -> ^( PARENEXP orExpression )
            {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:129:33: ^( PARENEXP orExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARENEXP, "PARENEXP")
                , root_1);

                adaptor.addChild(root_1, stream_orExpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parenExpression"


    public static class literalExpressionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literalExpressionList"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:132:1: literalExpressionList : LPAREN literal_value ( COMMA literal_value )* RPAREN -> {$COMMA != null}? ^( LISTEXP ( literal_value )+ ) -> ^( LISTEXP literal_value ) ;
    public final SQLExpressionParser.literalExpressionList_return literalExpressionList() throws RecognitionException {
        SQLExpressionParser.literalExpressionList_return retval = new SQLExpressionParser.literalExpressionList_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN33=null;
        Token COMMA35=null;
        Token RPAREN37=null;
        SQLExpressionParser.literal_value_return literal_value34 =null;

        SQLExpressionParser.literal_value_return literal_value36 =null;


        CommonTree LPAREN33_tree=null;
        CommonTree COMMA35_tree=null;
        CommonTree RPAREN37_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_literal_value=new RewriteRuleSubtreeStream(adaptor,"rule literal_value");
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:133:2: ( LPAREN literal_value ( COMMA literal_value )* RPAREN -> {$COMMA != null}? ^( LISTEXP ( literal_value )+ ) -> ^( LISTEXP literal_value ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:134:2: LPAREN literal_value ( COMMA literal_value )* RPAREN
            {
            LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_literalExpressionList434); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN33);


            pushFollow(FOLLOW_literal_value_in_literalExpressionList436);
            literal_value34=literal_value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_literal_value.add(literal_value34.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:134:22: ( COMMA literal_value )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:134:24: COMMA literal_value
            	    {
            	    COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_literalExpressionList439); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA35);


            	    pushFollow(FOLLOW_literal_value_in_literalExpressionList441);
            	    literal_value36=literal_value();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_literal_value.add(literal_value36.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            RPAREN37=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_literalExpressionList446); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN37);


            // AST REWRITE
            // elements: literal_value, literal_value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 134:54: -> {$COMMA != null}? ^( LISTEXP ( literal_value )+ )
            if (COMMA35 != null) {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:134:75: ^( LISTEXP ( literal_value )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(LISTEXP, "LISTEXP")
                , root_1);

                if ( !(stream_literal_value.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_literal_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_literal_value.nextTree());

                }
                stream_literal_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            else // 135:42: -> ^( LISTEXP literal_value )
            {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:135:46: ^( LISTEXP literal_value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(LISTEXP, "LISTEXP")
                , root_1);

                adaptor.addChild(root_1, stream_literal_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literalExpressionList"


    public static class function_call_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "function_call"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:138:1: function_call : ( functionList ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )? ) -> {$COMMA != null}? ^( FUNCEXP functionList ( functionParam )+ ) -> ^( FUNCEXP functionList functionParam ) ;
    public final SQLExpressionParser.function_call_return function_call() throws RecognitionException {
        SQLExpressionParser.function_call_return retval = new SQLExpressionParser.function_call_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN39=null;
        Token COMMA41=null;
        Token RPAREN43=null;
        SQLExpressionParser.functionList_return functionList38 =null;

        SQLExpressionParser.functionParam_return functionParam40 =null;

        SQLExpressionParser.functionParam_return functionParam42 =null;


        CommonTree LPAREN39_tree=null;
        CommonTree COMMA41_tree=null;
        CommonTree RPAREN43_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_functionList=new RewriteRuleSubtreeStream(adaptor,"rule functionList");
        RewriteRuleSubtreeStream stream_functionParam=new RewriteRuleSubtreeStream(adaptor,"rule functionParam");
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:139:5: ( ( functionList ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )? ) -> {$COMMA != null}? ^( FUNCEXP functionList ( functionParam )+ ) -> ^( FUNCEXP functionList functionParam ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:2: ( functionList ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )? )
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:2: ( functionList ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:5: functionList ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )?
            {
            pushFollow(FOLLOW_functionList_in_function_call525);
            functionList38=functionList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionList.add(functionList38.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:18: ( LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:20: LPAREN ( functionParam ( COMMA functionParam )* )? RPAREN
                    {
                    LPAREN39=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_function_call529); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN39);


                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:27: ( functionParam ( COMMA functionParam )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==DOLLAR||LA12_0==FALSE_SYM||LA12_0==HEX_DIGIT||LA12_0==ID||LA12_0==INTEGER_NUM||LA12_0==MINUS||LA12_0==PLUS||LA12_0==QUESTION||(LA12_0 >= QUOTED_ID && LA12_0 <= QUOTED_STRING)||LA12_0==REAL_NUMBER||LA12_0==TRUE_SYM||LA12_0==183) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:28: functionParam ( COMMA functionParam )*
                            {
                            pushFollow(FOLLOW_functionParam_in_function_call532);
                            functionParam40=functionParam();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_functionParam.add(functionParam40.getTree());

                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:42: ( COMMA functionParam )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==COMMA) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:43: COMMA functionParam
                            	    {
                            	    COMMA41=(Token)match(input,COMMA,FOLLOW_COMMA_in_function_call535); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA41);


                            	    pushFollow(FOLLOW_functionParam_in_function_call537);
                            	    functionParam42=functionParam();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_functionParam.add(functionParam42.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }


                    RPAREN43=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_function_call543); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN43);


                    }
                    break;

            }


            }


            // AST REWRITE
            // elements: functionParam, functionList, functionParam, functionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 140:81: -> {$COMMA != null}? ^( FUNCEXP functionList ( functionParam )+ )
            if (COMMA41 != null) {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:140:102: ^( FUNCEXP functionList ( functionParam )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FUNCEXP, "FUNCEXP")
                , root_1);

                adaptor.addChild(root_1, stream_functionList.nextTree());

                if ( !(stream_functionParam.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_functionParam.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionParam.nextTree());

                }
                stream_functionParam.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            else // 141:84: -> ^( FUNCEXP functionList functionParam )
            {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:141:87: ^( FUNCEXP functionList functionParam )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FUNCEXP, "FUNCEXP")
                , root_1);

                adaptor.addChild(root_1, stream_functionList.nextTree());

                adaptor.addChild(root_1, stream_functionParam.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function_call"


    public static class functionParam_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionParam"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:144:1: functionParam : ( literal_value | column_spec | parameterPlaceHolder );
    public final SQLExpressionParser.functionParam_return functionParam() throws RecognitionException {
        SQLExpressionParser.functionParam_return retval = new SQLExpressionParser.functionParam_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.literal_value_return literal_value44 =null;

        SQLExpressionParser.column_spec_return column_spec45 =null;

        SQLExpressionParser.parameterPlaceHolder_return parameterPlaceHolder46 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:145:2: ( literal_value | column_spec | parameterPlaceHolder )
            int alt14=3;
            switch ( input.LA(1) ) {
            case FALSE_SYM:
            case HEX_DIGIT:
            case INTEGER_NUM:
            case MINUS:
            case PLUS:
            case QUOTED_STRING:
            case REAL_NUMBER:
            case TRUE_SYM:
                {
                alt14=1;
                }
                break;
            case ID:
            case QUOTED_ID:
                {
                alt14=2;
                }
                break;
            case DOLLAR:
            case QUESTION:
            case 183:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:146:2: literal_value
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_value_in_functionParam672);
                    literal_value44=literal_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal_value44.getTree());

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:147:4: column_spec
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_column_spec_in_functionParam677);
                    column_spec45=column_spec();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, column_spec45.getTree());

                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:148:4: parameterPlaceHolder
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_parameterPlaceHolder_in_functionParam682);
                    parameterPlaceHolder46=parameterPlaceHolder();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parameterPlaceHolder46.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionParam"


    public static class parameterPlaceHolder_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameterPlaceHolder"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:151:1: parameterPlaceHolder : ( QUESTION | DOLLAR LCURLY ( ID )? RCURLY | userVariable ) -> ^( PARAMPLACEHOLDER ) ;
    public final SQLExpressionParser.parameterPlaceHolder_return parameterPlaceHolder() throws RecognitionException {
        SQLExpressionParser.parameterPlaceHolder_return retval = new SQLExpressionParser.parameterPlaceHolder_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QUESTION47=null;
        Token DOLLAR48=null;
        Token LCURLY49=null;
        Token ID50=null;
        Token RCURLY51=null;
        SQLExpressionParser.userVariable_return userVariable52 =null;


        CommonTree QUESTION47_tree=null;
        CommonTree DOLLAR48_tree=null;
        CommonTree LCURLY49_tree=null;
        CommonTree ID50_tree=null;
        CommonTree RCURLY51_tree=null;
        RewriteRuleTokenStream stream_DOLLAR=new RewriteRuleTokenStream(adaptor,"token DOLLAR");
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_userVariable=new RewriteRuleSubtreeStream(adaptor,"rule userVariable");
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:152:2: ( ( QUESTION | DOLLAR LCURLY ( ID )? RCURLY | userVariable ) -> ^( PARAMPLACEHOLDER ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:153:2: ( QUESTION | DOLLAR LCURLY ( ID )? RCURLY | userVariable )
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:153:2: ( QUESTION | DOLLAR LCURLY ( ID )? RCURLY | userVariable )
            int alt16=3;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt16=1;
                }
                break;
            case DOLLAR:
                {
                alt16=2;
                }
                break;
            case 183:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:153:3: QUESTION
                    {
                    QUESTION47=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_parameterPlaceHolder695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION47);


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:154:4: DOLLAR LCURLY ( ID )? RCURLY
                    {
                    DOLLAR48=(Token)match(input,DOLLAR,FOLLOW_DOLLAR_in_parameterPlaceHolder700); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOLLAR.add(DOLLAR48);


                    LCURLY49=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_parameterPlaceHolder702); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY49);


                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:154:18: ( ID )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:154:18: ID
                            {
                            ID50=(Token)match(input,ID,FOLLOW_ID_in_parameterPlaceHolder704); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ID.add(ID50);


                            }
                            break;

                    }


                    RCURLY51=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_parameterPlaceHolder707); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY51);


                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:155:4: userVariable
                    {
                    pushFollow(FOLLOW_userVariable_in_parameterPlaceHolder712);
                    userVariable52=userVariable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_userVariable.add(userVariable52.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 156:2: -> ^( PARAMPLACEHOLDER )
            {
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:156:5: ^( PARAMPLACEHOLDER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PARAMPLACEHOLDER, "PARAMPLACEHOLDER")
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameterPlaceHolder"


    public static class userVariable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "userVariable"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:159:1: userVariable : '@' ID ;
    public final SQLExpressionParser.userVariable_return userVariable() throws RecognitionException {
        SQLExpressionParser.userVariable_return retval = new SQLExpressionParser.userVariable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal53=null;
        Token ID54=null;

        CommonTree char_literal53_tree=null;
        CommonTree ID54_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:159:13: ( '@' ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:160:2: '@' ID
            {
            root_0 = (CommonTree)adaptor.nil();


            char_literal53=(Token)match(input,183,FOLLOW_183_in_userVariable730); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal53_tree = 
            (CommonTree)adaptor.create(char_literal53)
            ;
            adaptor.addChild(root_0, char_literal53_tree);
            }

            ID54=(Token)match(input,ID,FOLLOW_ID_in_userVariable732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID54_tree = 
            (CommonTree)adaptor.create(ID54)
            ;
            adaptor.addChild(root_0, ID54_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "userVariable"


    public static class column_spec_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "column_spec"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:163:1: column_spec : ( ( quoted_table_name DOT )? quoted_column_name -> ^( COLUMN quoted_column_name ( quoted_table_name )? ) | ( table_name DOT )? column_name -> ^( COLUMN column_name ( table_name )? ) );
    public final SQLExpressionParser.column_spec_return column_spec() throws RecognitionException {
        SQLExpressionParser.column_spec_return retval = new SQLExpressionParser.column_spec_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT56=null;
        Token DOT59=null;
        SQLExpressionParser.quoted_table_name_return quoted_table_name55 =null;

        SQLExpressionParser.quoted_column_name_return quoted_column_name57 =null;

        SQLExpressionParser.table_name_return table_name58 =null;

        SQLExpressionParser.column_name_return column_name60 =null;


        CommonTree DOT56_tree=null;
        CommonTree DOT59_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_quoted_column_name=new RewriteRuleSubtreeStream(adaptor,"rule quoted_column_name");
        RewriteRuleSubtreeStream stream_table_name=new RewriteRuleSubtreeStream(adaptor,"rule table_name");
        RewriteRuleSubtreeStream stream_column_name=new RewriteRuleSubtreeStream(adaptor,"rule column_name");
        RewriteRuleSubtreeStream stream_quoted_table_name=new RewriteRuleSubtreeStream(adaptor,"rule quoted_table_name");
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:164:2: ( ( quoted_table_name DOT )? quoted_column_name -> ^( COLUMN quoted_column_name ( quoted_table_name )? ) | ( table_name DOT )? column_name -> ^( COLUMN column_name ( table_name )? ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QUOTED_ID) ) {
                alt19=1;
            }
            else if ( (LA19_0==ID) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:165:2: ( quoted_table_name DOT )? quoted_column_name
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:165:2: ( quoted_table_name DOT )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==QUOTED_ID) ) {
                        int LA17_1 = input.LA(2);

                        if ( (LA17_1==DOT) ) {
                            alt17=1;
                        }
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:165:4: quoted_table_name DOT
                            {
                            pushFollow(FOLLOW_quoted_table_name_in_column_spec745);
                            quoted_table_name55=quoted_table_name();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_quoted_table_name.add(quoted_table_name55.getTree());

                            DOT56=(Token)match(input,DOT,FOLLOW_DOT_in_column_spec747); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT56);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_quoted_column_name_in_column_spec752);
                    quoted_column_name57=quoted_column_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_quoted_column_name.add(quoted_column_name57.getTree());

                    // AST REWRITE
                    // elements: quoted_column_name, quoted_table_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 165:48: -> ^( COLUMN quoted_column_name ( quoted_table_name )? )
                    {
                        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:165:51: ^( COLUMN quoted_column_name ( quoted_table_name )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(COLUMN, "COLUMN")
                        , root_1);

                        adaptor.addChild(root_1, stream_quoted_column_name.nextTree());

                        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:165:79: ( quoted_table_name )?
                        if ( stream_quoted_table_name.hasNext() ) {
                            adaptor.addChild(root_1, stream_quoted_table_name.nextTree());

                        }
                        stream_quoted_table_name.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:166:3: ( table_name DOT )? column_name
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:166:3: ( table_name DOT )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==ID) ) {
                        int LA18_1 = input.LA(2);

                        if ( (LA18_1==DOT) ) {
                            alt18=1;
                        }
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:166:5: table_name DOT
                            {
                            pushFollow(FOLLOW_table_name_in_column_spec770);
                            table_name58=table_name();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_table_name.add(table_name58.getTree());

                            DOT59=(Token)match(input,DOT,FOLLOW_DOT_in_column_spec772); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_DOT.add(DOT59);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_column_name_in_column_spec777);
                    column_name60=column_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_column_name.add(column_name60.getTree());

                    // AST REWRITE
                    // elements: column_name, table_name
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 166:35: -> ^( COLUMN column_name ( table_name )? )
                    {
                        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:166:38: ^( COLUMN column_name ( table_name )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(COLUMN, "COLUMN")
                        , root_1);

                        adaptor.addChild(root_1, stream_column_name.nextTree());

                        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:166:59: ( table_name )?
                        if ( stream_table_name.hasNext() ) {
                            adaptor.addChild(root_1, stream_table_name.nextTree());

                        }
                        stream_table_name.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "column_spec"


    public static class expression_list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression_list"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:169:1: expression_list : LPAREN orExpression ( COMMA orExpression )* RPAREN ;
    public final SQLExpressionParser.expression_list_return expression_list() throws RecognitionException {
        SQLExpressionParser.expression_list_return retval = new SQLExpressionParser.expression_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN61=null;
        Token COMMA63=null;
        Token RPAREN65=null;
        SQLExpressionParser.orExpression_return orExpression62 =null;

        SQLExpressionParser.orExpression_return orExpression64 =null;


        CommonTree LPAREN61_tree=null;
        CommonTree COMMA63_tree=null;
        CommonTree RPAREN65_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:170:5: ( LPAREN orExpression ( COMMA orExpression )* RPAREN )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:171:2: LPAREN orExpression ( COMMA orExpression )* RPAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            LPAREN61=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expression_list804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN61_tree = 
            (CommonTree)adaptor.create(LPAREN61)
            ;
            adaptor.addChild(root_0, LPAREN61_tree);
            }

            pushFollow(FOLLOW_orExpression_in_expression_list806);
            orExpression62=orExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpression62.getTree());

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:171:22: ( COMMA orExpression )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:171:24: COMMA orExpression
            	    {
            	    COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_expression_list810); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA63_tree = 
            	    (CommonTree)adaptor.create(COMMA63)
            	    ;
            	    adaptor.addChild(root_0, COMMA63_tree);
            	    }

            	    pushFollow(FOLLOW_orExpression_in_expression_list812);
            	    orExpression64=orExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpression64.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            RPAREN65=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expression_list817); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN65_tree = 
            (CommonTree)adaptor.create(RPAREN65)
            ;
            adaptor.addChild(root_0, RPAREN65_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression_list"


    public static class relational_op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relational_op"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:174:1: relational_op : ( EQ_SYM | LTH | GTH | NOT_EQ | LET | GET );
    public final SQLExpressionParser.relational_op_return relational_op() throws RecognitionException {
        SQLExpressionParser.relational_op_return retval = new SQLExpressionParser.relational_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set66=null;

        CommonTree set66_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:175:2: ( EQ_SYM | LTH | GTH | NOT_EQ | LET | GET )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set66=(Token)input.LT(1);

            if ( input.LA(1)==EQ_SYM||input.LA(1)==GET||input.LA(1)==GTH||input.LA(1)==LET||input.LA(1)==LTH||input.LA(1)==NOT_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set66)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "relational_op"


    public static class list_op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "list_op"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:179:1: list_op : ( IN_SYM | NOT_IN );
    public final SQLExpressionParser.list_op_return list_op() throws RecognitionException {
        SQLExpressionParser.list_op_return retval = new SQLExpressionParser.list_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set67=null;

        CommonTree set67_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:180:2: ( IN_SYM | NOT_IN )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set67=(Token)input.LT(1);

            if ( input.LA(1)==IN_SYM||input.LA(1)==NOT_IN ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set67)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "list_op"


    public static class string_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "string_literal"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:184:1: string_literal : QUOTED_STRING ;
    public final SQLExpressionParser.string_literal_return string_literal() throws RecognitionException {
        SQLExpressionParser.string_literal_return retval = new SQLExpressionParser.string_literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QUOTED_STRING68=null;

        CommonTree QUOTED_STRING68_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:184:15: ( QUOTED_STRING )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:184:18: QUOTED_STRING
            {
            root_0 = (CommonTree)adaptor.nil();


            QUOTED_STRING68=(Token)match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_string_literal875); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTED_STRING68_tree = 
            (CommonTree)adaptor.create(QUOTED_STRING68)
            ;
            adaptor.addChild(root_0, QUOTED_STRING68_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "string_literal"


    public static class number_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "number_literal"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:185:1: number_literal : ( PLUS !| MINUS )? ( INTEGER_NUM | REAL_NUMBER ) ;
    public final SQLExpressionParser.number_literal_return number_literal() throws RecognitionException {
        SQLExpressionParser.number_literal_return retval = new SQLExpressionParser.number_literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PLUS69=null;
        Token MINUS70=null;
        Token set71=null;

        CommonTree PLUS69_tree=null;
        CommonTree MINUS70_tree=null;
        CommonTree set71_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:186:2: ( ( PLUS !| MINUS )? ( INTEGER_NUM | REAL_NUMBER ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:187:2: ( PLUS !| MINUS )? ( INTEGER_NUM | REAL_NUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:187:2: ( PLUS !| MINUS )?
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==PLUS) ) {
                alt21=1;
            }
            else if ( (LA21_0==MINUS) ) {
                alt21=2;
            }
            switch (alt21) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:187:3: PLUS !
                    {
                    PLUS69=(Token)match(input,PLUS,FOLLOW_PLUS_in_number_literal886); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:187:11: MINUS
                    {
                    MINUS70=(Token)match(input,MINUS,FOLLOW_MINUS_in_number_literal891); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS70_tree = 
                    (CommonTree)adaptor.create(MINUS70)
                    ;
                    adaptor.addChild(root_0, MINUS70_tree);
                    }

                    }
                    break;

            }


            set71=(Token)input.LT(1);

            if ( input.LA(1)==INTEGER_NUM||input.LA(1)==REAL_NUMBER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set71)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "number_literal"


    public static class hex_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hex_literal"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:191:1: hex_literal : HEX_DIGIT ;
    public final SQLExpressionParser.hex_literal_return hex_literal() throws RecognitionException {
        SQLExpressionParser.hex_literal_return retval = new SQLExpressionParser.hex_literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token HEX_DIGIT72=null;

        CommonTree HEX_DIGIT72_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:191:12: ( HEX_DIGIT )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:191:21: HEX_DIGIT
            {
            root_0 = (CommonTree)adaptor.nil();


            HEX_DIGIT72=(Token)match(input,HEX_DIGIT,FOLLOW_HEX_DIGIT_in_hex_literal918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            HEX_DIGIT72_tree = 
            (CommonTree)adaptor.create(HEX_DIGIT72)
            ;
            adaptor.addChild(root_0, HEX_DIGIT72_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "hex_literal"


    public static class boolean_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolean_literal"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:193:1: boolean_literal : ( TRUE_SYM | FALSE_SYM );
    public final SQLExpressionParser.boolean_literal_return boolean_literal() throws RecognitionException {
        SQLExpressionParser.boolean_literal_return retval = new SQLExpressionParser.boolean_literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set73=null;

        CommonTree set73_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:193:16: ( TRUE_SYM | FALSE_SYM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set73=(Token)input.LT(1);

            if ( input.LA(1)==FALSE_SYM||input.LA(1)==TRUE_SYM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set73)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolean_literal"


    public static class bit_literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bit_literal"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:195:1: bit_literal : BIT_NUM ;
    public final SQLExpressionParser.bit_literal_return bit_literal() throws RecognitionException {
        SQLExpressionParser.bit_literal_return retval = new SQLExpressionParser.bit_literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token BIT_NUM74=null;

        CommonTree BIT_NUM74_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:195:12: ( BIT_NUM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:195:21: BIT_NUM
            {
            root_0 = (CommonTree)adaptor.nil();


            BIT_NUM74=(Token)match(input,BIT_NUM,FOLLOW_BIT_NUM_in_bit_literal947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIT_NUM74_tree = 
            (CommonTree)adaptor.create(BIT_NUM74)
            ;
            adaptor.addChild(root_0, BIT_NUM74_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bit_literal"


    public static class literal_value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal_value"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:197:1: literal_value : ( string_literal | number_literal | hex_literal | boolean_literal ) ;
    public final SQLExpressionParser.literal_value_return literal_value() throws RecognitionException {
        SQLExpressionParser.literal_value_return retval = new SQLExpressionParser.literal_value_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.string_literal_return string_literal75 =null;

        SQLExpressionParser.number_literal_return number_literal76 =null;

        SQLExpressionParser.hex_literal_return hex_literal77 =null;

        SQLExpressionParser.boolean_literal_return boolean_literal78 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:198:2: ( ( string_literal | number_literal | hex_literal | boolean_literal ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:199:2: ( string_literal | number_literal | hex_literal | boolean_literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:199:2: ( string_literal | number_literal | hex_literal | boolean_literal )
            int alt22=4;
            switch ( input.LA(1) ) {
            case QUOTED_STRING:
                {
                alt22=1;
                }
                break;
            case INTEGER_NUM:
            case MINUS:
            case PLUS:
            case REAL_NUMBER:
                {
                alt22=2;
                }
                break;
            case HEX_DIGIT:
                {
                alt22=3;
                }
                break;
            case FALSE_SYM:
            case TRUE_SYM:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:199:4: string_literal
                    {
                    pushFollow(FOLLOW_string_literal_in_literal_value959);
                    string_literal75=string_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, string_literal75.getTree());

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:200:4: number_literal
                    {
                    pushFollow(FOLLOW_number_literal_in_literal_value964);
                    number_literal76=number_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, number_literal76.getTree());

                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:201:4: hex_literal
                    {
                    pushFollow(FOLLOW_hex_literal_in_literal_value969);
                    hex_literal77=hex_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hex_literal77.getTree());

                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:202:4: boolean_literal
                    {
                    pushFollow(FOLLOW_boolean_literal_in_literal_value974);
                    boolean_literal78=boolean_literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, boolean_literal78.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal_value"


    public static class functionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionList"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:205:1: functionList : ( group_functions | char_functions );
    public final SQLExpressionParser.functionList_return functionList() throws RecognitionException {
        SQLExpressionParser.functionList_return retval = new SQLExpressionParser.functionList_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        SQLExpressionParser.group_functions_return group_functions79 =null;

        SQLExpressionParser.char_functions_return char_functions80 =null;



        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:206:2: ( group_functions | char_functions )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==AVG||LA23_0==COUNT||LA23_0==MAX_SYM||LA23_0==MIN_SYM||LA23_0==SUM) ) {
                alt23=1;
            }
            else if ( (LA23_0==LOWER||LA23_0==UPPER) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:207:2: group_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_group_functions_in_functionList989);
                    group_functions79=group_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, group_functions79.getTree());

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:208:5: char_functions
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_char_functions_in_functionList995);
                    char_functions80=char_functions();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, char_functions80.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionList"


    public static class char_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "char_functions"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:211:1: char_functions : ( LOWER | UPPER );
    public final SQLExpressionParser.char_functions_return char_functions() throws RecognitionException {
        SQLExpressionParser.char_functions_return retval = new SQLExpressionParser.char_functions_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set81=null;

        CommonTree set81_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:212:5: ( LOWER | UPPER )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set81=(Token)input.LT(1);

            if ( input.LA(1)==LOWER||input.LA(1)==UPPER ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set81)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "char_functions"


    public static class group_functions_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_functions"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:217:1: group_functions : ( AVG | COUNT | MAX_SYM | MIN_SYM | SUM );
    public final SQLExpressionParser.group_functions_return group_functions() throws RecognitionException {
        SQLExpressionParser.group_functions_return retval = new SQLExpressionParser.group_functions_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set82=null;

        CommonTree set82_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:218:5: ( AVG | COUNT | MAX_SYM | MIN_SYM | SUM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set82=(Token)input.LT(1);

            if ( input.LA(1)==AVG||input.LA(1)==COUNT||input.LA(1)==MAX_SYM||input.LA(1)==MIN_SYM||input.LA(1)==SUM ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set82)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_functions"


    public static class schema_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "schema_name"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:226:1: schema_name : ID ;
    public final SQLExpressionParser.schema_name_return schema_name() throws RecognitionException {
        SQLExpressionParser.schema_name_return retval = new SQLExpressionParser.schema_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID83=null;

        CommonTree ID83_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:226:21: ( ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:226:23: ID
            {
            root_0 = (CommonTree)adaptor.nil();


            ID83=(Token)match(input,ID,FOLLOW_ID_in_schema_name1068); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID83_tree = 
            (CommonTree)adaptor.create(ID83)
            ;
            adaptor.addChild(root_0, ID83_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "schema_name"


    public static class table_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "table_name"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:227:1: table_name : ID ;
    public final SQLExpressionParser.table_name_return table_name() throws RecognitionException {
        SQLExpressionParser.table_name_return retval = new SQLExpressionParser.table_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID84=null;

        CommonTree ID84_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:227:21: ( ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:227:23: ID
            {
            root_0 = (CommonTree)adaptor.nil();


            ID84=(Token)match(input,ID,FOLLOW_ID_in_table_name1084); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID84_tree = 
            (CommonTree)adaptor.create(ID84)
            ;
            adaptor.addChild(root_0, ID84_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "table_name"


    public static class quoted_table_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quoted_table_name"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:228:1: quoted_table_name : QUOTED_ID ;
    public final SQLExpressionParser.quoted_table_name_return quoted_table_name() throws RecognitionException {
        SQLExpressionParser.quoted_table_name_return retval = new SQLExpressionParser.quoted_table_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QUOTED_ID85=null;

        CommonTree QUOTED_ID85_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:228:21: ( QUOTED_ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:228:23: QUOTED_ID
            {
            root_0 = (CommonTree)adaptor.nil();


            QUOTED_ID85=(Token)match(input,QUOTED_ID,FOLLOW_QUOTED_ID_in_quoted_table_name1093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTED_ID85_tree = 
            (CommonTree)adaptor.create(QUOTED_ID85)
            ;
            adaptor.addChild(root_0, QUOTED_ID85_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quoted_table_name"


    public static class column_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "column_name"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:229:1: column_name : ID ;
    public final SQLExpressionParser.column_name_return column_name() throws RecognitionException {
        SQLExpressionParser.column_name_return retval = new SQLExpressionParser.column_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID86=null;

        CommonTree ID86_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:229:21: ( ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:229:23: ID
            {
            root_0 = (CommonTree)adaptor.nil();


            ID86=(Token)match(input,ID,FOLLOW_ID_in_column_name1108); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID86_tree = 
            (CommonTree)adaptor.create(ID86)
            ;
            adaptor.addChild(root_0, ID86_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "column_name"


    public static class quoted_column_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quoted_column_name"
    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:230:1: quoted_column_name : QUOTED_ID ;
    public final SQLExpressionParser.quoted_column_name_return quoted_column_name() throws RecognitionException {
        SQLExpressionParser.quoted_column_name_return retval = new SQLExpressionParser.quoted_column_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QUOTED_ID87=null;

        CommonTree QUOTED_ID87_tree=null;

        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:230:21: ( QUOTED_ID )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:230:23: QUOTED_ID
            {
            root_0 = (CommonTree)adaptor.nil();


            QUOTED_ID87=(Token)match(input,QUOTED_ID,FOLLOW_QUOTED_ID_in_quoted_column_name1116); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTED_ID87_tree = 
            (CommonTree)adaptor.create(QUOTED_ID87)
            ;
            adaptor.addChild(root_0, QUOTED_ID87_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "quoted_column_name"

    // $ANTLR start synpred14_SQLExpression
    public final void synpred14_SQLExpression_fragment() throws RecognitionException {
        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:112:2: ( simpleExpression ( ISNOTNULL | ISNULL ) )
        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:112:2: simpleExpression ( ISNOTNULL | ISNULL )
        {
        pushFollow(FOLLOW_simpleExpression_in_synpred14_SQLExpression340);
        simpleExpression();

        state._fsp--;
        if (state.failed) return ;

        if ( (input.LA(1) >= ISNOTNULL && input.LA(1) <= ISNULL) ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }

    }
    // $ANTLR end synpred14_SQLExpression

    // $ANTLR start synpred18_SQLExpression
    public final void synpred18_SQLExpression_fragment() throws RecognitionException {
        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:122:4: ( parenExpression )
        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:122:4: parenExpression
        {
        pushFollow(FOLLOW_parenExpression_in_synpred18_SQLExpression383);
        parenExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred18_SQLExpression

    // Delegated rules

    public final boolean synpred14_SQLExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_SQLExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_SQLExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_SQLExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_orExpression_in_expression110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expression112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression128 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_OR_SYM_in_orExpression135 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_andExpression_in_orExpression138 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_relationalExpression_in_andExpression156 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_AND_SYM_in_andExpression163 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_relationalExpression_in_andExpression166 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression182 = new BitSet(new long[]{0x0400000000000002L,0x0040101000000500L});
    public static final BitSet FOLLOW_relational_op_in_relationalExpression189 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression194 = new BitSet(new long[]{0x0400000000000002L,0x0040101000000500L});
    public static final BitSet FOLLOW_multiplyExpression_in_additionExpression209 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_additionExpression217 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_multiplyExpression_in_additionExpression224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listExpression_in_multiplyExpression240 = new BitSet(new long[]{0x0000800000000802L,0x0008000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_ASTERISK_in_multiplyExpression250 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplyExpression257 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_MOD_SYM_in_multiplyExpression264 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_POWER_OP_in_multiplyExpression271 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_listExpression_in_multiplyExpression278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_listExpression294 = new BitSet(new long[]{0x0000000000000002L,0x0080000002000000L});
    public static final BitSet FOLLOW_list_op_in_listExpression302 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_literalExpressionList_in_listExpression308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryExpression324 = new BitSet(new long[]{0x2001020000004000L,0x00064C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_simpleExpression_in_unaryExpression334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpression_in_unaryExpression340 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_set_in_unaryExpression342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpression_in_unaryExpression356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_simpleExpression368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_value_in_simpleExpression373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_call_in_simpleExpression378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenExpression_in_simpleExpression383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameterPlaceHolder_in_simpleExpression388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literalExpressionList_in_simpleExpression393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parenExpression409 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_orExpression_in_parenExpression411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RPAREN_in_parenExpression413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_literalExpressionList434 = new BitSet(new long[]{0x2000000000000000L,0x0002000000804000L,0x0000002000010820L});
    public static final BitSet FOLLOW_literal_value_in_literalExpressionList436 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_literalExpressionList439 = new BitSet(new long[]{0x2000000000000000L,0x0002000000804000L,0x0000002000010820L});
    public static final BitSet FOLLOW_literal_value_in_literalExpressionList441 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RPAREN_in_literalExpressionList446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionList_in_function_call525 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_LPAREN_in_function_call529 = new BitSet(new long[]{0x2001000000000000L,0x0002000000824000L,0x0080002000050D20L});
    public static final BitSet FOLLOW_functionParam_in_function_call532 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_function_call535 = new BitSet(new long[]{0x2001000000000000L,0x0002000000824000L,0x0080002000010D20L});
    public static final BitSet FOLLOW_functionParam_in_function_call537 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RPAREN_in_function_call543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_value_in_functionParam672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_spec_in_functionParam677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameterPlaceHolder_in_functionParam682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_parameterPlaceHolder695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_parameterPlaceHolder700 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_LCURLY_in_parameterPlaceHolder702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ID_in_parameterPlaceHolder704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_RCURLY_in_parameterPlaceHolder707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_userVariable_in_parameterPlaceHolder712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_userVariable730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_ID_in_userVariable732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quoted_table_name_in_column_spec745 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOT_in_column_spec747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_quoted_column_name_in_column_spec752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_table_name_in_column_spec770 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOT_in_column_spec772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_column_name_in_column_spec777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_expression_list804 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_orExpression_in_expression_list806 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_expression_list810 = new BitSet(new long[]{0x2001020000004000L,0x01264C0000824000L,0x0080012020010D20L});
    public static final BitSet FOLLOW_orExpression_in_expression_list812 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RPAREN_in_expression_list817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_STRING_in_string_literal875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_number_literal886 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L,0x0000000000010000L});
    public static final BitSet FOLLOW_MINUS_in_number_literal891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L,0x0000000000010000L});
    public static final BitSet FOLLOW_set_in_number_literal896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_DIGIT_in_hex_literal918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIT_NUM_in_bit_literal947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_literal_in_literal_value959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_literal_in_literal_value964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hex_literal_in_literal_value969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_literal_value974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_functions_in_functionList989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_char_functions_in_functionList995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_schema_name1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_table_name1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_ID_in_quoted_table_name1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_column_name1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_ID_in_quoted_column_name1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpression_in_synpred14_SQLExpression340 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_set_in_synpred14_SQLExpression342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenExpression_in_synpred18_SQLExpression383 = new BitSet(new long[]{0x0000000000000002L});

}