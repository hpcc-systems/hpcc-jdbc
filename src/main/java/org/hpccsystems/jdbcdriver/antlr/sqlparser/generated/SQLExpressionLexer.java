// $ANTLR 3.4 /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g 2013-07-16 14:47:34

package  org.hpccsystems.jdbcdriver.antlr.sqlparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SQLExpressionLexer extends Lexer {
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

      @Override
      public void emitErrorMessage(String message)
      {
        throw new RuntimeException(message);
      }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SQLExpressionLexer() {} 
    public SQLExpressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQLExpressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g"; }

    // $ANTLR start "T__183"
    public final void mT__183() throws RecognitionException {
        try {
            int _type = T__183;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:18:8: ( '@' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:18:10: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__183"

    // $ANTLR start "A_i"
    public final void mA_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:236:14: ( 'a' | 'A' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "A_i"

    // $ANTLR start "B_i"
    public final void mB_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:237:14: ( 'b' | 'B' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "B_i"

    // $ANTLR start "C_i"
    public final void mC_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:238:14: ( 'c' | 'C' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "C_i"

    // $ANTLR start "D_i"
    public final void mD_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:239:14: ( 'd' | 'D' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "D_i"

    // $ANTLR start "E_i"
    public final void mE_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:240:14: ( 'e' | 'E' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "E_i"

    // $ANTLR start "F_i"
    public final void mF_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:241:14: ( 'f' | 'F' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "F_i"

    // $ANTLR start "G_i"
    public final void mG_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:242:14: ( 'g' | 'G' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "G_i"

    // $ANTLR start "H_i"
    public final void mH_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:243:14: ( 'h' | 'H' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "H_i"

    // $ANTLR start "I_i"
    public final void mI_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:244:14: ( 'i' | 'I' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "I_i"

    // $ANTLR start "J_i"
    public final void mJ_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:245:14: ( 'j' | 'J' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "J_i"

    // $ANTLR start "K_i"
    public final void mK_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:246:14: ( 'k' | 'K' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "K_i"

    // $ANTLR start "L_i"
    public final void mL_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:247:14: ( 'l' | 'L' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "L_i"

    // $ANTLR start "M_i"
    public final void mM_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:248:14: ( 'm' | 'M' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "M_i"

    // $ANTLR start "N_i"
    public final void mN_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:249:14: ( 'n' | 'N' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "N_i"

    // $ANTLR start "O_i"
    public final void mO_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:250:14: ( 'o' | 'O' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "O_i"

    // $ANTLR start "P_i"
    public final void mP_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:251:14: ( 'p' | 'P' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "P_i"

    // $ANTLR start "Q_i"
    public final void mQ_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:252:14: ( 'q' | 'Q' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Q_i"

    // $ANTLR start "R_i"
    public final void mR_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:253:14: ( 'r' | 'R' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "R_i"

    // $ANTLR start "S_i"
    public final void mS_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:254:14: ( 's' | 'S' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "S_i"

    // $ANTLR start "T_i"
    public final void mT_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:255:14: ( 't' | 'T' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_i"

    // $ANTLR start "U_i"
    public final void mU_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:256:14: ( 'u' | 'U' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "U_i"

    // $ANTLR start "V_i"
    public final void mV_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:257:14: ( 'v' | 'V' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "V_i"

    // $ANTLR start "W_i"
    public final void mW_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:258:14: ( 'w' | 'W' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "W_i"

    // $ANTLR start "X_i"
    public final void mX_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:259:14: ( 'x' | 'X' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "X_i"

    // $ANTLR start "Y_i"
    public final void mY_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:260:14: ( 'y' | 'Y' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Y_i"

    // $ANTLR start "Z_i"
    public final void mZ_i() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:261:14: ( 'z' | 'Z' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Z_i"

    // $ANTLR start "ADD_SYM"
    public final void mADD_SYM() throws RecognitionException {
        try {
            int _type = ADD_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:263:12: ( A_i D_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:263:14: A_i D_i D_i
            {
            mA_i(); 


            mD_i(); 


            mD_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ADD_SYM"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:264:12: ( A_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:264:14: A_i L_i L_i
            {
            mA_i(); 


            mL_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:265:12: ( A_i N_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:265:14: A_i N_i Y_i
            {
            mA_i(); 


            mN_i(); 


            mY_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANY"

    // $ANTLR start "AS_SYM"
    public final void mAS_SYM() throws RecognitionException {
        try {
            int _type = AS_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:266:11: ( A_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:266:13: A_i S_i
            {
            mA_i(); 


            mS_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS_SYM"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:267:12: ( A_i S_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:267:14: A_i S_i C_i
            {
            mA_i(); 


            mS_i(); 


            mC_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "AT_SYM"
    public final void mAT_SYM() throws RecognitionException {
        try {
            int _type = AT_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:268:11: ( A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:268:13: A_i T_i
            {
            mA_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AT_SYM"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:269:12: ( A_i V_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:269:14: A_i V_i G_i
            {
            mA_i(); 


            mV_i(); 


            mG_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AVG"

    // $ANTLR start "BETWEEN"
    public final void mBETWEEN() throws RecognitionException {
        try {
            int _type = BETWEEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:270:12: ( B_i E_i T_i W_i E_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:270:14: B_i E_i T_i W_i E_i E_i N_i
            {
            mB_i(); 


            mE_i(); 


            mT_i(); 


            mW_i(); 


            mE_i(); 


            mE_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BETWEEN"

    // $ANTLR start "BIGINT"
    public final void mBIGINT() throws RecognitionException {
        try {
            int _type = BIGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:271:11: ( B_i I_i G_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:271:13: B_i I_i G_i I_i N_i T_i
            {
            mB_i(); 


            mI_i(); 


            mG_i(); 


            mI_i(); 


            mN_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGINT"

    // $ANTLR start "BIN"
    public final void mBIN() throws RecognitionException {
        try {
            int _type = BIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:272:12: ( B_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:272:14: B_i I_i N_i
            {
            mB_i(); 


            mI_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIN"

    // $ANTLR start "BINARY"
    public final void mBINARY() throws RecognitionException {
        try {
            int _type = BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:273:11: ( B_i I_i N_i A_i R_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:273:13: B_i I_i N_i A_i R_i Y_i
            {
            mB_i(); 


            mI_i(); 


            mN_i(); 


            mA_i(); 


            mR_i(); 


            mY_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BINARY"

    // $ANTLR start "BLOB_SYM"
    public final void mBLOB_SYM() throws RecognitionException {
        try {
            int _type = BLOB_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:274:12: ( B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:274:14: B_i L_i O_i B_i
            {
            mB_i(); 


            mL_i(); 


            mO_i(); 


            mB_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BLOB_SYM"

    // $ANTLR start "BOOL_SYM"
    public final void mBOOL_SYM() throws RecognitionException {
        try {
            int _type = BOOL_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:275:12: ( B_i O_i O_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:275:14: B_i O_i O_i L_i
            {
            mB_i(); 


            mO_i(); 


            mO_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOL_SYM"

    // $ANTLR start "BOOLEAN_SYM"
    public final void mBOOLEAN_SYM() throws RecognitionException {
        try {
            int _type = BOOLEAN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:276:14: ( B_i O_i O_i L_i E_i A_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:276:16: B_i O_i O_i L_i E_i A_i N_i
            {
            mB_i(); 


            mO_i(); 


            mO_i(); 


            mL_i(); 


            mE_i(); 


            mA_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN_SYM"

    // $ANTLR start "BY_SYM"
    public final void mBY_SYM() throws RecognitionException {
        try {
            int _type = BY_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:277:11: ( B_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:277:13: B_i Y_i
            {
            mB_i(); 


            mY_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BY_SYM"

    // $ANTLR start "BYTE_SYM"
    public final void mBYTE_SYM() throws RecognitionException {
        try {
            int _type = BYTE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:278:12: ( B_i Y_i T_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:278:14: B_i Y_i T_i E_i
            {
            mB_i(); 


            mY_i(); 


            mT_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BYTE_SYM"

    // $ANTLR start "CALL_SYM"
    public final void mCALL_SYM() throws RecognitionException {
        try {
            int _type = CALL_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:279:12: ( C_i A_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:279:14: C_i A_i L_i L_i
            {
            mC_i(); 


            mA_i(); 


            mL_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CALL_SYM"

    // $ANTLR start "CASE_SYM"
    public final void mCASE_SYM() throws RecognitionException {
        try {
            int _type = CASE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:280:12: ( C_i A_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:280:14: C_i A_i S_i E_i
            {
            mC_i(); 


            mA_i(); 


            mS_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CASE_SYM"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:281:11: ( C_i H_i A_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:281:13: C_i H_i A_i R_i
            {
            mC_i(); 


            mH_i(); 


            mA_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "CHAR_LENGTH"
    public final void mCHAR_LENGTH() throws RecognitionException {
        try {
            int _type = CHAR_LENGTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:14: ( ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i ) | ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='C'||LA1_0=='c') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='H'||LA1_1=='h') ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2=='A'||LA1_2=='a') ) {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3=='R'||LA1_3=='r') ) {
                            int LA1_4 = input.LA(5);

                            if ( (LA1_4=='_') ) {
                                alt1=1;
                            }
                            else if ( (LA1_4=='A'||LA1_4=='a') ) {
                                alt1=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 4, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:16: ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:16: ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:17: C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i
                    {
                    mC_i(); 


                    mH_i(); 


                    mA_i(); 


                    mR_i(); 


                    match('_'); 

                    mL_i(); 


                    mE_i(); 


                    mN_i(); 


                    mG_i(); 


                    mT_i(); 


                    mH_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:64: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:64: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:282:65: C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i
                    {
                    mC_i(); 


                    mH_i(); 


                    mA_i(); 


                    mR_i(); 


                    mA_i(); 


                    mC_i(); 


                    mT_i(); 


                    mE_i(); 


                    mR_i(); 


                    match('_'); 

                    mL_i(); 


                    mE_i(); 


                    mN_i(); 


                    mG_i(); 


                    mT_i(); 


                    mH_i(); 


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR_LENGTH"

    // $ANTLR start "CHARACTER_SYM"
    public final void mCHARACTER_SYM() throws RecognitionException {
        try {
            int _type = CHARACTER_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:283:15: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:283:17: C_i H_i A_i R_i A_i C_i T_i E_i R_i
            {
            mC_i(); 


            mH_i(); 


            mA_i(); 


            mR_i(); 


            mA_i(); 


            mC_i(); 


            mT_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER_SYM"

    // $ANTLR start "CHARSET"
    public final void mCHARSET() throws RecognitionException {
        try {
            int _type = CHARSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:284:12: ( C_i H_i A_i R_i S_i E_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:284:14: C_i H_i A_i R_i S_i E_i T_i
            {
            mC_i(); 


            mH_i(); 


            mA_i(); 


            mR_i(); 


            mS_i(); 


            mE_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARSET"

    // $ANTLR start "COLUMN_SYM"
    public final void mCOLUMN_SYM() throws RecognitionException {
        try {
            int _type = COLUMN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:285:13: ( C_i O_i L_i U_i M_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:285:15: C_i O_i L_i U_i M_i N_i
            {
            mC_i(); 


            mO_i(); 


            mL_i(); 


            mU_i(); 


            mM_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLUMN_SYM"

    // $ANTLR start "COLUMNS_SYM"
    public final void mCOLUMNS_SYM() throws RecognitionException {
        try {
            int _type = COLUMNS_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:286:14: ( C_i O_i L_i U_i M_i N_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:286:16: C_i O_i L_i U_i M_i N_i S_i
            {
            mC_i(); 


            mO_i(); 


            mL_i(); 


            mU_i(); 


            mM_i(); 


            mN_i(); 


            mS_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLUMNS_SYM"

    // $ANTLR start "CONCAT"
    public final void mCONCAT() throws RecognitionException {
        try {
            int _type = CONCAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:287:11: ( C_i O_i N_i C_i A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:287:13: C_i O_i N_i C_i A_i T_i
            {
            mC_i(); 


            mO_i(); 


            mN_i(); 


            mC_i(); 


            mA_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONCAT"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:288:12: ( C_i O_i U_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:288:14: C_i O_i U_i N_i T_i
            {
            mC_i(); 


            mO_i(); 


            mU_i(); 


            mN_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "DECIMAL_SYM"
    public final void mDECIMAL_SYM() throws RecognitionException {
        try {
            int _type = DECIMAL_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:289:14: ( D_i E_i C_i I_i M_i A_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:289:16: D_i E_i C_i I_i M_i A_i L_i
            {
            mD_i(); 


            mE_i(); 


            mC_i(); 


            mI_i(); 


            mM_i(); 


            mA_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_SYM"

    // $ANTLR start "DEFAULT"
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:290:12: ( D_i E_i F_i A_i U_i L_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:290:14: D_i E_i F_i A_i U_i L_i T_i
            {
            mD_i(); 


            mE_i(); 


            mF_i(); 


            mA_i(); 


            mU_i(); 


            mL_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFAULT"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:291:11: ( D_i E_i S_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:291:13: D_i E_i S_i C_i
            {
            mD_i(); 


            mE_i(); 


            mS_i(); 


            mC_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:292:12: ( D_i I_i S_i T_i I_i N_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:292:14: D_i I_i S_i T_i I_i N_i C_i T_i
            {
            mD_i(); 


            mI_i(); 


            mS_i(); 


            mT_i(); 


            mI_i(); 


            mN_i(); 


            mC_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "DO_SYM"
    public final void mDO_SYM() throws RecognitionException {
        try {
            int _type = DO_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:293:11: ( D_i O_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:293:13: D_i O_i
            {
            mD_i(); 


            mO_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO_SYM"

    // $ANTLR start "DOUBLE_SYM"
    public final void mDOUBLE_SYM() throws RecognitionException {
        try {
            int _type = DOUBLE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:294:13: ( D_i O_i U_i B_i L_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:294:15: D_i O_i U_i B_i L_i E_i
            {
            mD_i(); 


            mO_i(); 


            mU_i(); 


            mB_i(); 


            mL_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_SYM"

    // $ANTLR start "EACH_SYM"
    public final void mEACH_SYM() throws RecognitionException {
        try {
            int _type = EACH_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:295:12: ( E_i A_i C_i H_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:295:14: E_i A_i C_i H_i
            {
            mE_i(); 


            mA_i(); 


            mC_i(); 


            mH_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EACH_SYM"

    // $ANTLR start "ELSE_SYM"
    public final void mELSE_SYM() throws RecognitionException {
        try {
            int _type = ELSE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:296:12: ( E_i L_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:296:14: E_i L_i S_i E_i
            {
            mE_i(); 


            mL_i(); 


            mS_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE_SYM"

    // $ANTLR start "ELSIF_SYM"
    public final void mELSIF_SYM() throws RecognitionException {
        try {
            int _type = ELSIF_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:297:13: ( E_i L_i S_i I_i F_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:297:15: E_i L_i S_i I_i F_i
            {
            mE_i(); 


            mL_i(); 


            mS_i(); 


            mI_i(); 


            mF_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSIF_SYM"

    // $ANTLR start "END_SYM"
    public final void mEND_SYM() throws RecognitionException {
        try {
            int _type = END_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:298:12: ( E_i N_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:298:14: E_i N_i D_i
            {
            mE_i(); 


            mN_i(); 


            mD_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END_SYM"

    // $ANTLR start "EXISTS"
    public final void mEXISTS() throws RecognitionException {
        try {
            int _type = EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:299:11: ( E_i X_i I_i S_i T_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:299:13: E_i X_i I_i S_i T_i S_i
            {
            mE_i(); 


            mX_i(); 


            mI_i(); 


            mS_i(); 


            mT_i(); 


            mS_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXISTS"

    // $ANTLR start "FALSE_SYM"
    public final void mFALSE_SYM() throws RecognitionException {
        try {
            int _type = FALSE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:300:13: ( F_i A_i L_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:300:15: F_i A_i L_i S_i E_i
            {
            mF_i(); 


            mA_i(); 


            mL_i(); 


            mS_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE_SYM"

    // $ANTLR start "FETCH_SYM"
    public final void mFETCH_SYM() throws RecognitionException {
        try {
            int _type = FETCH_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:301:13: ( F_i E_i T_i C_i H_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:301:15: F_i E_i T_i C_i H_i
            {
            mF_i(); 


            mE_i(); 


            mT_i(); 


            mC_i(); 


            mH_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FETCH_SYM"

    // $ANTLR start "FIELD"
    public final void mFIELD() throws RecognitionException {
        try {
            int _type = FIELD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:302:12: ( F_i I_i E_i L_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:302:14: F_i I_i E_i L_i D_i
            {
            mF_i(); 


            mI_i(); 


            mE_i(); 


            mL_i(); 


            mD_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FIELD"

    // $ANTLR start "FILE_SYM"
    public final void mFILE_SYM() throws RecognitionException {
        try {
            int _type = FILE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:303:12: ( F_i I_i L_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:303:14: F_i I_i L_i E_i
            {
            mF_i(); 


            mI_i(); 


            mL_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILE_SYM"

    // $ANTLR start "FLOAT_SYM"
    public final void mFLOAT_SYM() throws RecognitionException {
        try {
            int _type = FLOAT_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:304:13: ( F_i L_i O_i A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:304:15: F_i L_i O_i A_i T_i
            {
            mF_i(); 


            mL_i(); 


            mO_i(); 


            mA_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT_SYM"

    // $ANTLR start "FOR_SYM"
    public final void mFOR_SYM() throws RecognitionException {
        try {
            int _type = FOR_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:305:12: ( F_i O_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:305:14: F_i O_i R_i
            {
            mF_i(); 


            mO_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR_SYM"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:306:11: ( F_i R_i O_i M_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:306:13: F_i R_i O_i M_i
            {
            mF_i(); 


            mR_i(); 


            mO_i(); 


            mM_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:307:11: ( F_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:307:13: F_i U_i L_i L_i
            {
            mF_i(); 


            mU_i(); 


            mL_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "FUNCTION_SYM"
    public final void mFUNCTION_SYM() throws RecognitionException {
        try {
            int _type = FUNCTION_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:308:14: ( F_i U_i N_i C_i T_i I_i O_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:308:16: F_i U_i N_i C_i T_i I_i O_i N_i
            {
            mF_i(); 


            mU_i(); 


            mN_i(); 


            mC_i(); 


            mT_i(); 


            mI_i(); 


            mO_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION_SYM"

    // $ANTLR start "GROUP_SYM"
    public final void mGROUP_SYM() throws RecognitionException {
        try {
            int _type = GROUP_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:309:13: ( G_i R_i O_i U_i P_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:309:15: G_i R_i O_i U_i P_i
            {
            mG_i(); 


            mR_i(); 


            mO_i(); 


            mU_i(); 


            mP_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GROUP_SYM"

    // $ANTLR start "HAVING"
    public final void mHAVING() throws RecognitionException {
        try {
            int _type = HAVING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:310:11: ( H_i A_i V_i I_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:310:13: H_i A_i V_i I_i N_i G_i
            {
            mH_i(); 


            mA_i(); 


            mV_i(); 


            mI_i(); 


            mN_i(); 


            mG_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HAVING"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            int _type = HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:311:12: ( H_i E_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:311:14: H_i E_i X_i
            {
            mH_i(); 


            mE_i(); 


            mX_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:312:11: ( I_i F_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:312:13: I_i F_i
            {
            mI_i(); 


            mF_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IFNULL"
    public final void mIFNULL() throws RecognitionException {
        try {
            int _type = IFNULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:313:11: ( I_i F_i N_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:313:13: I_i F_i N_i U_i L_i L_i
            {
            mI_i(); 


            mF_i(); 


            mN_i(); 


            mU_i(); 


            mL_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFNULL"

    // $ANTLR start "IGNORE_SYM"
    public final void mIGNORE_SYM() throws RecognitionException {
        try {
            int _type = IGNORE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:314:13: ( I_i G_i N_i O_i R_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:314:15: I_i G_i N_i O_i R_i E_i
            {
            mI_i(); 


            mG_i(); 


            mN_i(); 


            mO_i(); 


            mR_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IGNORE_SYM"

    // $ANTLR start "IN_SYM"
    public final void mIN_SYM() throws RecognitionException {
        try {
            int _type = IN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:315:11: ( I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:315:13: I_i N_i
            {
            mI_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN_SYM"

    // $ANTLR start "INDEX_SYM"
    public final void mINDEX_SYM() throws RecognitionException {
        try {
            int _type = INDEX_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:316:13: ( I_i N_i D_i E_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:316:15: I_i N_i D_i E_i X_i
            {
            mI_i(); 


            mN_i(); 


            mD_i(); 


            mE_i(); 


            mX_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INDEX_SYM"

    // $ANTLR start "INNER_SYM"
    public final void mINNER_SYM() throws RecognitionException {
        try {
            int _type = INNER_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:317:13: ( I_i N_i N_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:317:15: I_i N_i N_i E_i R_i
            {
            mI_i(); 


            mN_i(); 


            mN_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INNER_SYM"

    // $ANTLR start "INTEGER_SYM"
    public final void mINTEGER_SYM() throws RecognitionException {
        try {
            int _type = INTEGER_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:318:14: ( I_i N_i T_i E_i G_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:318:16: I_i N_i T_i E_i G_i E_i R_i
            {
            mI_i(); 


            mN_i(); 


            mT_i(); 


            mE_i(); 


            mG_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_SYM"

    // $ANTLR start "IS_SYM"
    public final void mIS_SYM() throws RecognitionException {
        try {
            int _type = IS_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:319:11: ( I_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:319:13: I_i S_i
            {
            mI_i(); 


            mS_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IS_SYM"

    // $ANTLR start "JOIN_SYM"
    public final void mJOIN_SYM() throws RecognitionException {
        try {
            int _type = JOIN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:320:12: ( J_i O_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:320:14: J_i O_i I_i N_i
            {
            mJ_i(); 


            mO_i(); 


            mI_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JOIN_SYM"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:321:11: ( L_i E_i F_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:321:13: L_i E_i F_i T_i
            {
            mL_i(); 


            mE_i(); 


            mF_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:322:12: ( L_i I_i M_i I_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:322:14: L_i I_i M_i I_i T_i
            {
            mL_i(); 


            mI_i(); 


            mM_i(); 


            mI_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "LONG_SYM"
    public final void mLONG_SYM() throws RecognitionException {
        try {
            int _type = LONG_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:323:12: ( L_i O_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:323:14: L_i O_i N_i G_i
            {
            mL_i(); 


            mO_i(); 


            mN_i(); 


            mG_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONG_SYM"

    // $ANTLR start "LONGBLOB"
    public final void mLONGBLOB() throws RecognitionException {
        try {
            int _type = LONGBLOB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:324:12: ( L_i O_i N_i G_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:324:14: L_i O_i N_i G_i B_i L_i O_i B_i
            {
            mL_i(); 


            mO_i(); 


            mN_i(); 


            mG_i(); 


            mB_i(); 


            mL_i(); 


            mO_i(); 


            mB_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONGBLOB"

    // $ANTLR start "LONGTEXT"
    public final void mLONGTEXT() throws RecognitionException {
        try {
            int _type = LONGTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:325:12: ( L_i O_i N_i G_i T_i E_i X_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:325:14: L_i O_i N_i G_i T_i E_i X_i T_i
            {
            mL_i(); 


            mO_i(); 


            mN_i(); 


            mG_i(); 


            mT_i(); 


            mE_i(); 


            mX_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONGTEXT"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            int _type = LOWER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:12: ( ( L_i O_i W_i E_i R_i ) | ( L_i C_i A_i S_i E_i ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='O'||LA2_1=='o') ) {
                    alt2=1;
                }
                else if ( (LA2_1=='C'||LA2_1=='c') ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:14: ( L_i O_i W_i E_i R_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:14: ( L_i O_i W_i E_i R_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:15: L_i O_i W_i E_i R_i
                    {
                    mL_i(); 


                    mO_i(); 


                    mW_i(); 


                    mE_i(); 


                    mR_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:38: ( L_i C_i A_i S_i E_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:38: ( L_i C_i A_i S_i E_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:326:39: L_i C_i A_i S_i E_i
                    {
                    mL_i(); 


                    mC_i(); 


                    mA_i(); 


                    mS_i(); 


                    mE_i(); 


                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "MAX_SYM"
    public final void mMAX_SYM() throws RecognitionException {
        try {
            int _type = MAX_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:327:12: ( M_i A_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:327:14: M_i A_i X_i
            {
            mM_i(); 


            mA_i(); 


            mX_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAX_SYM"

    // $ANTLR start "MEDIUMBLOB"
    public final void mMEDIUMBLOB() throws RecognitionException {
        try {
            int _type = MEDIUMBLOB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:328:13: ( M_i E_i D_i I_i U_i M_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:328:15: M_i E_i D_i I_i U_i M_i B_i L_i O_i B_i
            {
            mM_i(); 


            mE_i(); 


            mD_i(); 


            mI_i(); 


            mU_i(); 


            mM_i(); 


            mB_i(); 


            mL_i(); 


            mO_i(); 


            mB_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MEDIUMBLOB"

    // $ANTLR start "MEDIUMINT"
    public final void mMEDIUMINT() throws RecognitionException {
        try {
            int _type = MEDIUMINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:329:13: ( M_i E_i D_i I_i U_i M_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:329:15: M_i E_i D_i I_i U_i M_i I_i N_i T_i
            {
            mM_i(); 


            mE_i(); 


            mD_i(); 


            mI_i(); 


            mU_i(); 


            mM_i(); 


            mI_i(); 


            mN_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MEDIUMINT"

    // $ANTLR start "MIN_SYM"
    public final void mMIN_SYM() throws RecognitionException {
        try {
            int _type = MIN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:330:15: ( M_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:330:17: M_i I_i N_i
            {
            mM_i(); 


            mI_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MIN_SYM"

    // $ANTLR start "NOT_SYM"
    public final void mNOT_SYM() throws RecognitionException {
        try {
            int _type = NOT_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:12: ( ( N_i O_i T_i ) | ( '!' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='N'||LA3_0=='n') ) {
                alt3=1;
            }
            else if ( (LA3_0=='!') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:14: ( N_i O_i T_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:14: ( N_i O_i T_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:15: N_i O_i T_i
                    {
                    mN_i(); 


                    mO_i(); 


                    mT_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:30: ( '!' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:30: ( '!' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:331:31: '!'
                    {
                    match('!'); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_SYM"

    // $ANTLR start "NULL_SYM"
    public final void mNULL_SYM() throws RecognitionException {
        try {
            int _type = NULL_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:332:12: ( N_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:332:14: N_i U_i L_i L_i
            {
            mN_i(); 


            mU_i(); 


            mL_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL_SYM"

    // $ANTLR start "NUMERIC_SYM"
    public final void mNUMERIC_SYM() throws RecognitionException {
        try {
            int _type = NUMERIC_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:333:14: ( N_i U_i M_i E_i R_i I_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:333:16: N_i U_i M_i E_i R_i I_i C_i
            {
            mN_i(); 


            mU_i(); 


            mM_i(); 


            mE_i(); 


            mR_i(); 


            mI_i(); 


            mC_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMERIC_SYM"

    // $ANTLR start "OCT"
    public final void mOCT() throws RecognitionException {
        try {
            int _type = OCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:334:12: ( O_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:334:14: O_i C_i T_i
            {
            mO_i(); 


            mC_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCT"

    // $ANTLR start "OFFSET_SYM"
    public final void mOFFSET_SYM() throws RecognitionException {
        try {
            int _type = OFFSET_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:335:13: ( O_i F_i F_i S_i E_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:335:15: O_i F_i F_i S_i E_i T_i
            {
            mO_i(); 


            mF_i(); 


            mF_i(); 


            mS_i(); 


            mE_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OFFSET_SYM"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:336:11: ( O_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:336:13: O_i N_i
            {
            mO_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "ORDER_SYM"
    public final void mORDER_SYM() throws RecognitionException {
        try {
            int _type = ORDER_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:337:13: ( O_i R_i D_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:337:15: O_i R_i D_i E_i R_i
            {
            mO_i(); 


            mR_i(); 


            mD_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER_SYM"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:338:10: ( O_i U_i T_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:338:12: O_i U_i T_i E_i R_i
            {
            mO_i(); 


            mU_i(); 


            mT_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "QUOTE"
    public final void mQUOTE() throws RecognitionException {
        try {
            int _type = QUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:339:10: ( Q_i U_i O_i T_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:339:12: Q_i U_i O_i T_i E_i
            {
            mQ_i(); 


            mU_i(); 


            mO_i(); 


            mT_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTE"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:340:9: ( R_i E_i A_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:340:11: R_i E_i A_i L_i
            {
            mR_i(); 


            mE_i(); 


            mA_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:341:10: ( R_i I_i G_i H_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:341:12: R_i I_i G_i H_i T_i
            {
            mR_i(); 


            mI_i(); 


            mG_i(); 


            mH_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:342:11: ( S_i E_i L_i E_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:342:13: S_i E_i L_i E_i C_i T_i
            {
            mS_i(); 


            mE_i(); 


            mL_i(); 


            mE_i(); 


            mC_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "SMALLINT"
    public final void mSMALLINT() throws RecognitionException {
        try {
            int _type = SMALLINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:343:12: ( S_i M_i A_i L_i L_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:343:14: S_i M_i A_i L_i L_i I_i N_i T_i
            {
            mS_i(); 


            mM_i(); 


            mA_i(); 


            mL_i(); 


            mL_i(); 


            mI_i(); 


            mN_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SMALLINT"

    // $ANTLR start "STRAIGHT_JOIN"
    public final void mSTRAIGHT_JOIN() throws RecognitionException {
        try {
            int _type = STRAIGHT_JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:344:15: ( S_i T_i R_i A_i I_i G_i H_i T_i '_' J_i O_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:344:17: S_i T_i R_i A_i I_i G_i H_i T_i '_' J_i O_i I_i N_i
            {
            mS_i(); 


            mT_i(); 


            mR_i(); 


            mA_i(); 


            mI_i(); 


            mG_i(); 


            mH_i(); 


            mT_i(); 


            match('_'); 

            mJ_i(); 


            mO_i(); 


            mI_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRAIGHT_JOIN"

    // $ANTLR start "STRING_SYM"
    public final void mSTRING_SYM() throws RecognitionException {
        try {
            int _type = STRING_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:345:13: ( S_i T_i R_i I_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:345:15: S_i T_i R_i I_i N_i G_i
            {
            mS_i(); 


            mT_i(); 


            mR_i(); 


            mI_i(); 


            mN_i(); 


            mG_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_SYM"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:346:12: ( S_i U_i M_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:346:14: S_i U_i M_i
            {
            mS_i(); 


            mU_i(); 


            mM_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "THEN_SYM"
    public final void mTHEN_SYM() throws RecognitionException {
        try {
            int _type = THEN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:347:12: ( T_i H_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:347:14: T_i H_i E_i N_i
            {
            mT_i(); 


            mH_i(); 


            mE_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN_SYM"

    // $ANTLR start "TIME_SYM"
    public final void mTIME_SYM() throws RecognitionException {
        try {
            int _type = TIME_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:348:12: ( T_i I_i M_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:348:14: T_i I_i M_i E_i
            {
            mT_i(); 


            mI_i(); 


            mM_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TIME_SYM"

    // $ANTLR start "TINYBLOB"
    public final void mTINYBLOB() throws RecognitionException {
        try {
            int _type = TINYBLOB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:349:12: ( T_i I_i N_i Y_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:349:14: T_i I_i N_i Y_i B_i L_i O_i B_i
            {
            mT_i(); 


            mI_i(); 


            mN_i(); 


            mY_i(); 


            mB_i(); 


            mL_i(); 


            mO_i(); 


            mB_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TINYBLOB"

    // $ANTLR start "TINYINT"
    public final void mTINYINT() throws RecognitionException {
        try {
            int _type = TINYINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:350:12: ( T_i I_i N_i Y_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:350:14: T_i I_i N_i Y_i I_i N_i T_i
            {
            mT_i(); 


            mI_i(); 


            mN_i(); 


            mY_i(); 


            mI_i(); 


            mN_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TINYINT"

    // $ANTLR start "TINYTEXT"
    public final void mTINYTEXT() throws RecognitionException {
        try {
            int _type = TINYTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:351:12: ( T_i I_i N_i Y_i T_i E_i X_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:351:14: T_i I_i N_i Y_i T_i E_i X_i T_i
            {
            mT_i(); 


            mI_i(); 


            mN_i(); 


            mY_i(); 


            mT_i(); 


            mE_i(); 


            mX_i(); 


            mT_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TINYTEXT"

    // $ANTLR start "TRUE_SYM"
    public final void mTRUE_SYM() throws RecognitionException {
        try {
            int _type = TRUE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:352:12: ( T_i R_i U_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:352:14: T_i R_i U_i E_i
            {
            mT_i(); 


            mR_i(); 


            mU_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE_SYM"

    // $ANTLR start "UNSIGNED_SYM"
    public final void mUNSIGNED_SYM() throws RecognitionException {
        try {
            int _type = UNSIGNED_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:353:14: ( U_i N_i S_i I_i G_i N_i E_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:353:16: U_i N_i S_i I_i G_i N_i E_i D_i
            {
            mU_i(); 


            mN_i(); 


            mS_i(); 


            mI_i(); 


            mG_i(); 


            mN_i(); 


            mE_i(); 


            mD_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNSIGNED_SYM"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            int _type = UPPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:355:15: ( U_i P_i P_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:355:17: U_i P_i P_i E_i R_i
            {
            mU_i(); 


            mP_i(); 


            mP_i(); 


            mE_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "USE_SYM"
    public final void mUSE_SYM() throws RecognitionException {
        try {
            int _type = USE_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:356:12: ( U_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:356:14: U_i S_i E_i
            {
            mU_i(); 


            mS_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USE_SYM"

    // $ANTLR start "VARBINARY"
    public final void mVARBINARY() throws RecognitionException {
        try {
            int _type = VARBINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:357:13: ( V_i A_i R_i B_i I_i N_i A_i R_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:357:15: V_i A_i R_i B_i I_i N_i A_i R_i Y_i
            {
            mV_i(); 


            mA_i(); 


            mR_i(); 


            mB_i(); 


            mI_i(); 


            mN_i(); 


            mA_i(); 


            mR_i(); 


            mY_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARBINARY"

    // $ANTLR start "VARCHAR"
    public final void mVARCHAR() throws RecognitionException {
        try {
            int _type = VARCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:358:12: ( V_i A_i R_i C_i H_i A_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:358:14: V_i A_i R_i C_i H_i A_i R_i
            {
            mV_i(); 


            mA_i(); 


            mR_i(); 


            mC_i(); 


            mH_i(); 


            mA_i(); 


            mR_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARCHAR"

    // $ANTLR start "WHEN_SYM"
    public final void mWHEN_SYM() throws RecognitionException {
        try {
            int _type = WHEN_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:359:12: ( W_i H_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:359:14: W_i H_i E_i N_i
            {
            mW_i(); 


            mH_i(); 


            mE_i(); 


            mN_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHEN_SYM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:360:12: ( W_i H_i E_i R_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:360:14: W_i H_i E_i R_i E_i
            {
            mW_i(); 


            mH_i(); 


            mE_i(); 


            mR_i(); 


            mE_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "XML_SYM"
    public final void mXML_SYM() throws RecognitionException {
        try {
            int _type = XML_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:361:12: ( X_i M_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:361:14: X_i M_i L_i
            {
            mX_i(); 


            mM_i(); 


            mL_i(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XML_SYM"

    // $ANTLR start "ISNOTNULL"
    public final void mISNOTNULL() throws RecognitionException {
        try {
            int _type = ISNOTNULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:363:14: ( ( 'IS NOT NULL' | 'is not null' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:363:16: ( 'IS NOT NULL' | 'is not null' )
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:363:16: ( 'IS NOT NULL' | 'is not null' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='I') ) {
                alt4=1;
            }
            else if ( (LA4_0=='i') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:363:17: 'IS NOT NULL'
                    {
                    match("IS NOT NULL"); 



                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:363:33: 'is not null'
                    {
                    match("is not null"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ISNOTNULL"

    // $ANTLR start "ISNULL"
    public final void mISNULL() throws RecognitionException {
        try {
            int _type = ISNULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:364:14: ( ( 'IS NULL' | 'is null' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:364:16: ( 'IS NULL' | 'is null' )
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:364:16: ( 'IS NULL' | 'is null' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='I') ) {
                alt5=1;
            }
            else if ( (LA5_0=='i') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:364:17: 'IS NULL'
                    {
                    match("IS NULL"); 



                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:364:29: 'is null'
                    {
                    match("is null"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ISNULL"

    // $ANTLR start "NOT_IN"
    public final void mNOT_IN() throws RecognitionException {
        try {
            int _type = NOT_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:365:14: ( ( 'NOT IN' | 'not in' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:365:16: ( 'NOT IN' | 'not in' )
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:365:16: ( 'NOT IN' | 'not in' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='N') ) {
                alt6=1;
            }
            else if ( (LA6_0=='n') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:365:17: 'NOT IN'
                    {
                    match("NOT IN"); 



                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:365:28: 'not in'
                    {
                    match("not in"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_IN"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:366:13: ( ( D_i I_i V_i ) | '/' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='D'||LA7_0=='d') ) {
                alt7=1;
            }
            else if ( (LA7_0=='/') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:366:15: ( D_i I_i V_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:366:15: ( D_i I_i V_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:366:18: D_i I_i V_i
                    {
                    mD_i(); 


                    mI_i(); 


                    mV_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:366:34: '/'
                    {
                    match('/'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "MOD_SYM"
    public final void mMOD_SYM() throws RecognitionException {
        try {
            int _type = MOD_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:367:14: ( ( M_i O_i D_i ) | '%' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='M'||LA8_0=='m') ) {
                alt8=1;
            }
            else if ( (LA8_0=='%') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:367:16: ( M_i O_i D_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:367:16: ( M_i O_i D_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:367:19: M_i O_i D_i
                    {
                    mM_i(); 


                    mO_i(); 


                    mD_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:367:35: '%'
                    {
                    match('%'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD_SYM"

    // $ANTLR start "OR_SYM"
    public final void mOR_SYM() throws RecognitionException {
        try {
            int _type = OR_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:368:13: ( ( O_i R_i ) | '||' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='O'||LA9_0=='o') ) {
                alt9=1;
            }
            else if ( (LA9_0=='|') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:368:15: ( O_i R_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:368:15: ( O_i R_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:368:18: O_i R_i
                    {
                    mO_i(); 


                    mR_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:368:30: '||'
                    {
                    match("||"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR_SYM"

    // $ANTLR start "AND_SYM"
    public final void mAND_SYM() throws RecognitionException {
        try {
            int _type = AND_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:369:14: ( ( A_i N_i D_i ) | '&&' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='A'||LA10_0=='a') ) {
                alt10=1;
            }
            else if ( (LA10_0=='&') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:369:16: ( A_i N_i D_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:369:16: ( A_i N_i D_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:369:19: A_i N_i D_i
                    {
                    mA_i(); 


                    mN_i(); 


                    mD_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:369:35: '&&'
                    {
                    match("&&"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND_SYM"

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:370:14: ( '=>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:370:16: '=>'
            {
            match("=>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARROW"

    // $ANTLR start "EQ_SYM"
    public final void mEQ_SYM() throws RecognitionException {
        try {
            int _type = EQ_SYM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:371:13: ( '=' | '<=>' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='=') ) {
                alt11=1;
            }
            else if ( (LA11_0=='<') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:371:15: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:371:21: '<=>'
                    {
                    match("<=>"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ_SYM"

    // $ANTLR start "NOT_EQ"
    public final void mNOT_EQ() throws RecognitionException {
        try {
            int _type = NOT_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:372:13: ( '<>' | '!=' | '~=' | '^=' )
            int alt12=4;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt12=1;
                }
                break;
            case '!':
                {
                alt12=2;
                }
                break;
            case '~':
                {
                alt12=3;
                }
                break;
            case '^':
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:372:15: '<>'
                    {
                    match("<>"); 



                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:372:22: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:372:29: '~='
                    {
                    match("~="); 



                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:372:35: '^='
                    {
                    match("^="); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_EQ"

    // $ANTLR start "LET"
    public final void mLET() throws RecognitionException {
        try {
            int _type = LET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:373:14: ( '<=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:373:16: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LET"

    // $ANTLR start "GET"
    public final void mGET() throws RecognitionException {
        try {
            int _type = GET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:374:14: ( '>=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:374:16: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GET"

    // $ANTLR start "SET_VAR"
    public final void mSET_VAR() throws RecognitionException {
        try {
            int _type = SET_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:375:14: ( ':=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:375:16: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET_VAR"

    // $ANTLR start "SHIFT_LEFT"
    public final void mSHIFT_LEFT() throws RecognitionException {
        try {
            int _type = SHIFT_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:376:13: ( '<<' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:376:15: '<<'
            {
            match("<<"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFT_LEFT"

    // $ANTLR start "SHIFT_RIGHT"
    public final void mSHIFT_RIGHT() throws RecognitionException {
        try {
            int _type = SHIFT_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:377:14: ( '>>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:377:16: '>>'
            {
            match(">>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIFT_RIGHT"

    // $ANTLR start "ALL_FIELDS"
    public final void mALL_FIELDS() throws RecognitionException {
        try {
            int _type = ALL_FIELDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:378:13: ( '.*' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:378:15: '.*'
            {
            match(".*"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL_FIELDS"

    // $ANTLR start "SQUOTE"
    public final void mSQUOTE() throws RecognitionException {
        try {
            int _type = SQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:379:13: ( '\\'' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:379:15: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQUOTE"

    // $ANTLR start "DQUOTE"
    public final void mDQUOTE() throws RecognitionException {
        try {
            int _type = DQUOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:380:13: ( '\\\"' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:380:15: '\\\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DQUOTE"

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:381:14: ( '::' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:381:16: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLONCOLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:382:13: ( '$' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:382:15: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:383:14: ( '?' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:383:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:384:13: ( ';' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:384:15: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:385:14: ( ':' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:385:16: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:386:14: ( '.' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:386:16: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:387:14: ( ',' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:387:16: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "ASTERISK"
    public final void mASTERISK() throws RecognitionException {
        try {
            int _type = ASTERISK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:388:14: ( '*' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:388:16: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASTERISK"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:389:13: ( ')' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:389:15: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:390:13: ( '(' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:390:15: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:391:13: ( ']' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:391:15: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:392:13: ( '[' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:392:15: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:393:14: ( '{' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:393:16: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:394:13: ( '}' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:394:15: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:395:13: ( '+' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:395:15: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:396:14: ( '-' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:396:16: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "NEGATION"
    public final void mNEGATION() throws RecognitionException {
        try {
            int _type = NEGATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:397:14: ( '~' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:397:16: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEGATION"

    // $ANTLR start "VERTBAR"
    public final void mVERTBAR() throws RecognitionException {
        try {
            int _type = VERTBAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:398:14: ( '|' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:398:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VERTBAR"

    // $ANTLR start "BITAND"
    public final void mBITAND() throws RecognitionException {
        try {
            int _type = BITAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:399:13: ( '&' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:399:15: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BITAND"

    // $ANTLR start "POWER_OP"
    public final void mPOWER_OP() throws RecognitionException {
        try {
            int _type = POWER_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:400:14: ( '^' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:400:16: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POWER_OP"

    // $ANTLR start "GTH"
    public final void mGTH() throws RecognitionException {
        try {
            int _type = GTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:401:14: ( '>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:401:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GTH"

    // $ANTLR start "LTH"
    public final void mLTH() throws RecognitionException {
        try {
            int _type = LTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:402:14: ( '<' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:402:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LTH"

    // $ANTLR start "INTEGER_NUM"
    public final void mINTEGER_NUM() throws RecognitionException {
        try {
            int _type = INTEGER_NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:405:14: ( ( '0' .. '9' )+ )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:405:16: ( '0' .. '9' )+
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:405:16: ( '0' .. '9' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_NUM"

    // $ANTLR start "HEX_DIGIT_FRAGMENT"
    public final void mHEX_DIGIT_FRAGMENT() throws RecognitionException {
        try {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:407:28: ( ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT_FRAGMENT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            int _type = HEX_DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:410:5: ( ( '0x' ( HEX_DIGIT_FRAGMENT )+ ) | ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='0') ) {
                alt16=1;
            }
            else if ( (LA16_0=='X') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:411:2: ( '0x' ( HEX_DIGIT_FRAGMENT )+ )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:411:2: ( '0x' ( HEX_DIGIT_FRAGMENT )+ )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:411:5: '0x' ( HEX_DIGIT_FRAGMENT )+
                    {
                    match("0x"); 



                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:411:14: ( HEX_DIGIT_FRAGMENT )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '0' && LA14_0 <= '9')||(LA14_0 >= 'A' && LA14_0 <= 'F')||(LA14_0 >= 'a' && LA14_0 <= 'f')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:413:2: ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:413:2: ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:413:5: 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\''
                    {
                    match('X'); 

                    match('\''); 

                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:413:14: ( HEX_DIGIT_FRAGMENT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0 >= '0' && LA15_0 <= '9')||(LA15_0 >= 'A' && LA15_0 <= 'F')||(LA15_0 >= 'a' && LA15_0 <= 'f')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    match('\''); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "BIT_NUM"
    public final void mBIT_NUM() throws RecognitionException {
        try {
            int _type = BIT_NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:417:5: ( ( '0b' ( '0' | '1' )+ ) | ( B_i '\\'' ( '0' | '1' )+ '\\'' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='0') ) {
                alt19=1;
            }
            else if ( (LA19_0=='B'||LA19_0=='b') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:418:2: ( '0b' ( '0' | '1' )+ )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:418:2: ( '0b' ( '0' | '1' )+ )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:418:5: '0b' ( '0' | '1' )+
                    {
                    match("0b"); 



                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:418:13: ( '0' | '1' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0 >= '0' && LA17_0 <= '1')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:420:2: ( B_i '\\'' ( '0' | '1' )+ '\\'' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:420:2: ( B_i '\\'' ( '0' | '1' )+ '\\'' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:420:5: B_i '\\'' ( '0' | '1' )+ '\\''
                    {
                    mB_i(); 


                    match('\''); 

                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:420:14: ( '0' | '1' )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0 >= '0' && LA18_0 <= '1')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '1') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);


                    match('\''); 

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIT_NUM"

    // $ANTLR start "REAL_NUMBER"
    public final void mREAL_NUMBER() throws RecognitionException {
        try {
            int _type = REAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:424:5: ( ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM ) ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM ) ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )?
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM )
            int alt20=4;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:5: INTEGER_NUM DOT INTEGER_NUM
                    {
                    mINTEGER_NUM(); 


                    mDOT(); 


                    mINTEGER_NUM(); 


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:35: INTEGER_NUM DOT
                    {
                    mINTEGER_NUM(); 


                    mDOT(); 


                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:53: DOT INTEGER_NUM
                    {
                    mDOT(); 


                    mINTEGER_NUM(); 


                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:425:71: INTEGER_NUM
                    {
                    mINTEGER_NUM(); 


                    }
                    break;

            }


            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:426:2: ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='E'||LA22_0=='e') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:426:5: ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:426:15: ( PLUS | MINUS )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='+'||LA21_0=='-') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    mINTEGER_NUM(); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL_NUMBER"

    // $ANTLR start "QUOTED_STRING"
    public final void mQUOTED_STRING() throws RecognitionException {
        try {
            int _type = QUOTED_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:430:5: ( SQUOTE ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )* SQUOTE )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:431:5: SQUOTE ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )* SQUOTE
            {
            mSQUOTE(); 


            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:432:5: ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )*
            loop23:
            do {
                int alt23=4;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:433:9: ( SQUOTE SQUOTE )
            	    {
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:433:9: ( SQUOTE SQUOTE )
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:433:10: SQUOTE SQUOTE
            	    {
            	    mSQUOTE(); 


            	    mSQUOTE(); 


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:434:11: ( '\\\\' '\\'' )
            	    {
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:434:11: ( '\\\\' '\\'' )
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:434:12: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:435:11: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            mSQUOTE(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_STRING"

    // $ANTLR start "QUOTED_ID"
    public final void mQUOTED_ID() throws RecognitionException {
        try {
            int _type = QUOTED_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken cont=null;

            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:440:11: ( DQUOTE cont= ID DQUOTE )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:440:13: DQUOTE cont= ID DQUOTE
            {
            mDQUOTE(); 


            int contStart3320 = getCharIndex();
            int contStartLine3320 = getLine();
            int contStartCharPos3320 = getCharPositionInLine();
            mID(); 
            cont = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, contStart3320, getCharIndex()-1);
            cont.setLine(contStartLine3320);
            cont.setCharPositionInLine(contStartCharPos3320);


            mDQUOTE(); 


            setText(cont.getText());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_ID"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:4: ( ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )* )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:6: ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )*
            loop24:
            do {
                int alt24=6;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    {
                    alt24=1;
                    }
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt24=2;
                    }
                    break;
                case '_':
                    {
                    alt24=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt24=4;
                    }
                    break;
                case ':':
                    {
                    alt24=5;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:32: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:43: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:54: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;
            	case 4 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:61: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;
            	case 5 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:442:72: '::'
            	    {
            	    match("::"); 



            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WHITE_SPACE"
    public final void mWHITE_SPACE() throws RecognitionException {
        try {
            int _type = WHITE_SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:444:13: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:444:15: ( ' ' | '\\r' | '\\t' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITE_SPACE"

    public void mTokens() throws RecognitionException {
        // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:8: ( T__183 | ADD_SYM | ALL | ANY | AS_SYM | ASC | AT_SYM | AVG | BETWEEN | BIGINT | BIN | BINARY | BLOB_SYM | BOOL_SYM | BOOLEAN_SYM | BY_SYM | BYTE_SYM | CALL_SYM | CASE_SYM | CHAR | CHAR_LENGTH | CHARACTER_SYM | CHARSET | COLUMN_SYM | COLUMNS_SYM | CONCAT | COUNT | DECIMAL_SYM | DEFAULT | DESC | DISTINCT | DO_SYM | DOUBLE_SYM | EACH_SYM | ELSE_SYM | ELSIF_SYM | END_SYM | EXISTS | FALSE_SYM | FETCH_SYM | FIELD | FILE_SYM | FLOAT_SYM | FOR_SYM | FROM | FULL | FUNCTION_SYM | GROUP_SYM | HAVING | HEX | IF | IFNULL | IGNORE_SYM | IN_SYM | INDEX_SYM | INNER_SYM | INTEGER_SYM | IS_SYM | JOIN_SYM | LEFT | LIMIT | LONG_SYM | LONGBLOB | LONGTEXT | LOWER | MAX_SYM | MEDIUMBLOB | MEDIUMINT | MIN_SYM | NOT_SYM | NULL_SYM | NUMERIC_SYM | OCT | OFFSET_SYM | ON | ORDER_SYM | OUTER | QUOTE | REAL | RIGHT | SELECT | SMALLINT | STRAIGHT_JOIN | STRING_SYM | SUM | THEN_SYM | TIME_SYM | TINYBLOB | TINYINT | TINYTEXT | TRUE_SYM | UNSIGNED_SYM | UPPER | USE_SYM | VARBINARY | VARCHAR | WHEN_SYM | WHERE | XML_SYM | ISNOTNULL | ISNULL | NOT_IN | DIVIDE | MOD_SYM | OR_SYM | AND_SYM | ARROW | EQ_SYM | NOT_EQ | LET | GET | SET_VAR | SHIFT_LEFT | SHIFT_RIGHT | ALL_FIELDS | SQUOTE | DQUOTE | COLONCOLON | DOLLAR | QUESTION | SEMI | COLON | DOT | COMMA | ASTERISK | RPAREN | LPAREN | RBRACK | LBRACK | LCURLY | RCURLY | PLUS | MINUS | NEGATION | VERTBAR | BITAND | POWER_OP | GTH | LTH | INTEGER_NUM | HEX_DIGIT | BIT_NUM | REAL_NUMBER | QUOTED_STRING | QUOTED_ID | ID | WHITE_SPACE )
        int alt25=147;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:10: T__183
                {
                mT__183(); 


                }
                break;
            case 2 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:17: ADD_SYM
                {
                mADD_SYM(); 


                }
                break;
            case 3 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:25: ALL
                {
                mALL(); 


                }
                break;
            case 4 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:29: ANY
                {
                mANY(); 


                }
                break;
            case 5 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:33: AS_SYM
                {
                mAS_SYM(); 


                }
                break;
            case 6 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:40: ASC
                {
                mASC(); 


                }
                break;
            case 7 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:44: AT_SYM
                {
                mAT_SYM(); 


                }
                break;
            case 8 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:51: AVG
                {
                mAVG(); 


                }
                break;
            case 9 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:55: BETWEEN
                {
                mBETWEEN(); 


                }
                break;
            case 10 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:63: BIGINT
                {
                mBIGINT(); 


                }
                break;
            case 11 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:70: BIN
                {
                mBIN(); 


                }
                break;
            case 12 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:74: BINARY
                {
                mBINARY(); 


                }
                break;
            case 13 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:81: BLOB_SYM
                {
                mBLOB_SYM(); 


                }
                break;
            case 14 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:90: BOOL_SYM
                {
                mBOOL_SYM(); 


                }
                break;
            case 15 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:99: BOOLEAN_SYM
                {
                mBOOLEAN_SYM(); 


                }
                break;
            case 16 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:111: BY_SYM
                {
                mBY_SYM(); 


                }
                break;
            case 17 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:118: BYTE_SYM
                {
                mBYTE_SYM(); 


                }
                break;
            case 18 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:127: CALL_SYM
                {
                mCALL_SYM(); 


                }
                break;
            case 19 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:136: CASE_SYM
                {
                mCASE_SYM(); 


                }
                break;
            case 20 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:145: CHAR
                {
                mCHAR(); 


                }
                break;
            case 21 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:150: CHAR_LENGTH
                {
                mCHAR_LENGTH(); 


                }
                break;
            case 22 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:162: CHARACTER_SYM
                {
                mCHARACTER_SYM(); 


                }
                break;
            case 23 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:176: CHARSET
                {
                mCHARSET(); 


                }
                break;
            case 24 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:184: COLUMN_SYM
                {
                mCOLUMN_SYM(); 


                }
                break;
            case 25 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:195: COLUMNS_SYM
                {
                mCOLUMNS_SYM(); 


                }
                break;
            case 26 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:207: CONCAT
                {
                mCONCAT(); 


                }
                break;
            case 27 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:214: COUNT
                {
                mCOUNT(); 


                }
                break;
            case 28 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:220: DECIMAL_SYM
                {
                mDECIMAL_SYM(); 


                }
                break;
            case 29 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:232: DEFAULT
                {
                mDEFAULT(); 


                }
                break;
            case 30 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:240: DESC
                {
                mDESC(); 


                }
                break;
            case 31 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:245: DISTINCT
                {
                mDISTINCT(); 


                }
                break;
            case 32 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:254: DO_SYM
                {
                mDO_SYM(); 


                }
                break;
            case 33 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:261: DOUBLE_SYM
                {
                mDOUBLE_SYM(); 


                }
                break;
            case 34 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:272: EACH_SYM
                {
                mEACH_SYM(); 


                }
                break;
            case 35 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:281: ELSE_SYM
                {
                mELSE_SYM(); 


                }
                break;
            case 36 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:290: ELSIF_SYM
                {
                mELSIF_SYM(); 


                }
                break;
            case 37 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:300: END_SYM
                {
                mEND_SYM(); 


                }
                break;
            case 38 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:308: EXISTS
                {
                mEXISTS(); 


                }
                break;
            case 39 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:315: FALSE_SYM
                {
                mFALSE_SYM(); 


                }
                break;
            case 40 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:325: FETCH_SYM
                {
                mFETCH_SYM(); 


                }
                break;
            case 41 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:335: FIELD
                {
                mFIELD(); 


                }
                break;
            case 42 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:341: FILE_SYM
                {
                mFILE_SYM(); 


                }
                break;
            case 43 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:350: FLOAT_SYM
                {
                mFLOAT_SYM(); 


                }
                break;
            case 44 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:360: FOR_SYM
                {
                mFOR_SYM(); 


                }
                break;
            case 45 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:368: FROM
                {
                mFROM(); 


                }
                break;
            case 46 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:373: FULL
                {
                mFULL(); 


                }
                break;
            case 47 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:378: FUNCTION_SYM
                {
                mFUNCTION_SYM(); 


                }
                break;
            case 48 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:391: GROUP_SYM
                {
                mGROUP_SYM(); 


                }
                break;
            case 49 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:401: HAVING
                {
                mHAVING(); 


                }
                break;
            case 50 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:408: HEX
                {
                mHEX(); 


                }
                break;
            case 51 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:412: IF
                {
                mIF(); 


                }
                break;
            case 52 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:415: IFNULL
                {
                mIFNULL(); 


                }
                break;
            case 53 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:422: IGNORE_SYM
                {
                mIGNORE_SYM(); 


                }
                break;
            case 54 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:433: IN_SYM
                {
                mIN_SYM(); 


                }
                break;
            case 55 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:440: INDEX_SYM
                {
                mINDEX_SYM(); 


                }
                break;
            case 56 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:450: INNER_SYM
                {
                mINNER_SYM(); 


                }
                break;
            case 57 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:460: INTEGER_SYM
                {
                mINTEGER_SYM(); 


                }
                break;
            case 58 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:472: IS_SYM
                {
                mIS_SYM(); 


                }
                break;
            case 59 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:479: JOIN_SYM
                {
                mJOIN_SYM(); 


                }
                break;
            case 60 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:488: LEFT
                {
                mLEFT(); 


                }
                break;
            case 61 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:493: LIMIT
                {
                mLIMIT(); 


                }
                break;
            case 62 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:499: LONG_SYM
                {
                mLONG_SYM(); 


                }
                break;
            case 63 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:508: LONGBLOB
                {
                mLONGBLOB(); 


                }
                break;
            case 64 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:517: LONGTEXT
                {
                mLONGTEXT(); 


                }
                break;
            case 65 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:526: LOWER
                {
                mLOWER(); 


                }
                break;
            case 66 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:532: MAX_SYM
                {
                mMAX_SYM(); 


                }
                break;
            case 67 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:540: MEDIUMBLOB
                {
                mMEDIUMBLOB(); 


                }
                break;
            case 68 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:551: MEDIUMINT
                {
                mMEDIUMINT(); 


                }
                break;
            case 69 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:561: MIN_SYM
                {
                mMIN_SYM(); 


                }
                break;
            case 70 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:569: NOT_SYM
                {
                mNOT_SYM(); 


                }
                break;
            case 71 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:577: NULL_SYM
                {
                mNULL_SYM(); 


                }
                break;
            case 72 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:586: NUMERIC_SYM
                {
                mNUMERIC_SYM(); 


                }
                break;
            case 73 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:598: OCT
                {
                mOCT(); 


                }
                break;
            case 74 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:602: OFFSET_SYM
                {
                mOFFSET_SYM(); 


                }
                break;
            case 75 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:613: ON
                {
                mON(); 


                }
                break;
            case 76 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:616: ORDER_SYM
                {
                mORDER_SYM(); 


                }
                break;
            case 77 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:626: OUTER
                {
                mOUTER(); 


                }
                break;
            case 78 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:632: QUOTE
                {
                mQUOTE(); 


                }
                break;
            case 79 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:638: REAL
                {
                mREAL(); 


                }
                break;
            case 80 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:643: RIGHT
                {
                mRIGHT(); 


                }
                break;
            case 81 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:649: SELECT
                {
                mSELECT(); 


                }
                break;
            case 82 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:656: SMALLINT
                {
                mSMALLINT(); 


                }
                break;
            case 83 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:665: STRAIGHT_JOIN
                {
                mSTRAIGHT_JOIN(); 


                }
                break;
            case 84 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:679: STRING_SYM
                {
                mSTRING_SYM(); 


                }
                break;
            case 85 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:690: SUM
                {
                mSUM(); 


                }
                break;
            case 86 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:694: THEN_SYM
                {
                mTHEN_SYM(); 


                }
                break;
            case 87 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:703: TIME_SYM
                {
                mTIME_SYM(); 


                }
                break;
            case 88 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:712: TINYBLOB
                {
                mTINYBLOB(); 


                }
                break;
            case 89 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:721: TINYINT
                {
                mTINYINT(); 


                }
                break;
            case 90 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:729: TINYTEXT
                {
                mTINYTEXT(); 


                }
                break;
            case 91 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:738: TRUE_SYM
                {
                mTRUE_SYM(); 


                }
                break;
            case 92 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:747: UNSIGNED_SYM
                {
                mUNSIGNED_SYM(); 


                }
                break;
            case 93 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:760: UPPER
                {
                mUPPER(); 


                }
                break;
            case 94 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:766: USE_SYM
                {
                mUSE_SYM(); 


                }
                break;
            case 95 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:774: VARBINARY
                {
                mVARBINARY(); 


                }
                break;
            case 96 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:784: VARCHAR
                {
                mVARCHAR(); 


                }
                break;
            case 97 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:792: WHEN_SYM
                {
                mWHEN_SYM(); 


                }
                break;
            case 98 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:801: WHERE
                {
                mWHERE(); 


                }
                break;
            case 99 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:807: XML_SYM
                {
                mXML_SYM(); 


                }
                break;
            case 100 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:815: ISNOTNULL
                {
                mISNOTNULL(); 


                }
                break;
            case 101 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:825: ISNULL
                {
                mISNULL(); 


                }
                break;
            case 102 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:832: NOT_IN
                {
                mNOT_IN(); 


                }
                break;
            case 103 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:839: DIVIDE
                {
                mDIVIDE(); 


                }
                break;
            case 104 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:846: MOD_SYM
                {
                mMOD_SYM(); 


                }
                break;
            case 105 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:854: OR_SYM
                {
                mOR_SYM(); 


                }
                break;
            case 106 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:861: AND_SYM
                {
                mAND_SYM(); 


                }
                break;
            case 107 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:869: ARROW
                {
                mARROW(); 


                }
                break;
            case 108 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:875: EQ_SYM
                {
                mEQ_SYM(); 


                }
                break;
            case 109 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:882: NOT_EQ
                {
                mNOT_EQ(); 


                }
                break;
            case 110 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:889: LET
                {
                mLET(); 


                }
                break;
            case 111 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:893: GET
                {
                mGET(); 


                }
                break;
            case 112 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:897: SET_VAR
                {
                mSET_VAR(); 


                }
                break;
            case 113 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:905: SHIFT_LEFT
                {
                mSHIFT_LEFT(); 


                }
                break;
            case 114 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:916: SHIFT_RIGHT
                {
                mSHIFT_RIGHT(); 


                }
                break;
            case 115 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:928: ALL_FIELDS
                {
                mALL_FIELDS(); 


                }
                break;
            case 116 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:939: SQUOTE
                {
                mSQUOTE(); 


                }
                break;
            case 117 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:946: DQUOTE
                {
                mDQUOTE(); 


                }
                break;
            case 118 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:953: COLONCOLON
                {
                mCOLONCOLON(); 


                }
                break;
            case 119 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:964: DOLLAR
                {
                mDOLLAR(); 


                }
                break;
            case 120 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:971: QUESTION
                {
                mQUESTION(); 


                }
                break;
            case 121 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:980: SEMI
                {
                mSEMI(); 


                }
                break;
            case 122 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:985: COLON
                {
                mCOLON(); 


                }
                break;
            case 123 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:991: DOT
                {
                mDOT(); 


                }
                break;
            case 124 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:995: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 125 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1001: ASTERISK
                {
                mASTERISK(); 


                }
                break;
            case 126 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1010: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 127 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1017: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 128 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1024: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 129 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1031: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 130 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1038: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 131 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1045: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 132 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1052: PLUS
                {
                mPLUS(); 


                }
                break;
            case 133 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1057: MINUS
                {
                mMINUS(); 


                }
                break;
            case 134 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1063: NEGATION
                {
                mNEGATION(); 


                }
                break;
            case 135 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1072: VERTBAR
                {
                mVERTBAR(); 


                }
                break;
            case 136 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1080: BITAND
                {
                mBITAND(); 


                }
                break;
            case 137 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1087: POWER_OP
                {
                mPOWER_OP(); 


                }
                break;
            case 138 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1096: GTH
                {
                mGTH(); 


                }
                break;
            case 139 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1100: LTH
                {
                mLTH(); 


                }
                break;
            case 140 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1104: INTEGER_NUM
                {
                mINTEGER_NUM(); 


                }
                break;
            case 141 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1116: HEX_DIGIT
                {
                mHEX_DIGIT(); 


                }
                break;
            case 142 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1126: BIT_NUM
                {
                mBIT_NUM(); 


                }
                break;
            case 143 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1134: REAL_NUMBER
                {
                mREAL_NUMBER(); 


                }
                break;
            case 144 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1146: QUOTED_STRING
                {
                mQUOTED_STRING(); 


                }
                break;
            case 145 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1160: QUOTED_ID
                {
                mQUOTED_ID(); 


                }
                break;
            case 146 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1170: ID
                {
                mID(); 


                }
                break;
            case 147 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/main/antlr3/org/hpccsystems/jdbcdriver/antlr/sqlparser/SQLExpression.g:1:1173: WHITE_SPACE
                {
                mWHITE_SPACE(); 


                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA20_eotS =
        "\1\uffff\1\3\2\uffff\1\5\2\uffff";
    static final String DFA20_eofS =
        "\7\uffff";
    static final String DFA20_minS =
        "\2\56\2\uffff\1\60\2\uffff";
    static final String DFA20_maxS =
        "\2\71\2\uffff\1\71\2\uffff";
    static final String DFA20_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\2\1\1";
    static final String DFA20_specialS =
        "\7\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1",
            "",
            "",
            "\12\6",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "425:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM )";
        }
    }
    static final String DFA23_eotS =
        "\1\uffff\1\4\4\uffff\1\3\1\10\1\uffff\1\3";
    static final String DFA23_eofS =
        "\12\uffff";
    static final String DFA23_minS =
        "\1\0\1\47\1\0\3\uffff\2\0\1\uffff\1\0";
    static final String DFA23_maxS =
        "\1\uffff\1\47\1\uffff\3\uffff\2\uffff\1\uffff\1\uffff";
    static final String DFA23_acceptS =
        "\3\uffff\1\3\1\4\1\1\2\uffff\1\2\1\uffff";
    static final String DFA23_specialS =
        "\1\3\1\uffff\1\2\3\uffff\1\4\1\1\1\uffff\1\0}>";
    static final String[] DFA23_transitionS = {
            "\47\3\1\1\64\3\1\2\uffa3\3",
            "\1\5",
            "\47\3\1\6\uffd8\3",
            "",
            "",
            "",
            "\47\10\1\7\uffd8\10",
            "\47\3\1\11\uffd8\3",
            "",
            "\47\10\1\7\uffd8\10"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 432:5: ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_9 = input.LA(1);

                        s = -1;
                        if ( (LA23_9=='\'') ) {s = 7;}

                        else if ( ((LA23_9 >= '\u0000' && LA23_9 <= '&')||(LA23_9 >= '(' && LA23_9 <= '\uFFFF')) ) {s = 8;}

                        else s = 3;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA23_7 = input.LA(1);

                        s = -1;
                        if ( (LA23_7=='\'') ) {s = 9;}

                        else if ( ((LA23_7 >= '\u0000' && LA23_7 <= '&')||(LA23_7 >= '(' && LA23_7 <= '\uFFFF')) ) {s = 3;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA23_2 = input.LA(1);

                        s = -1;
                        if ( (LA23_2=='\'') ) {s = 6;}

                        else if ( ((LA23_2 >= '\u0000' && LA23_2 <= '&')||(LA23_2 >= '(' && LA23_2 <= '\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA23_0 = input.LA(1);

                        s = -1;
                        if ( (LA23_0=='\'') ) {s = 1;}

                        else if ( (LA23_0=='\\') ) {s = 2;}

                        else if ( ((LA23_0 >= '\u0000' && LA23_0 <= '&')||(LA23_0 >= '(' && LA23_0 <= '[')||(LA23_0 >= ']' && LA23_0 <= '\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA23_6 = input.LA(1);

                        s = -1;
                        if ( (LA23_6=='\'') ) {s = 7;}

                        else if ( ((LA23_6 >= '\u0000' && LA23_6 <= '&')||(LA23_6 >= '(' && LA23_6 <= '\uFFFF')) ) {s = 8;}

                        else s = 3;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA25_eotS =
        "\2\uffff\15\70\1\u0098\13\70\2\uffff\1\u00c9\1\u00cb\1\u00cd\1\u00d0"+
        "\1\u00d1\1\u00d2\1\u00d5\1\u00d8\1\u00da\1\u00dc\1\u00de\15\uffff"+
        "\2\u00e0\1\70\2\uffff\3\70\1\u00e9\1\u00ec\4\70\1\u00e9\1\u00ec"+
        "\5\70\1\u00f9\1\uffff\4\70\1\u00f9\10\70\1\u0112\2\70\1\u0112\34"+
        "\70\1\u0136\1\u0137\1\70\1\u013c\1\u0136\1\u0137\1\70\1\u013c\26"+
        "\70\2\uffff\2\70\1\u0162\1\u00c8\3\70\1\u0162\1\u00c8\37\70\1\uffff"+
        "\2\70\2\u0136\2\70\6\uffff\1\u018b\22\uffff\2\u018c\2\u018d\1\u018e"+
        "\1\u00ca\1\u018e\1\u00ca\1\uffff\2\u018f\1\uffff\2\u0190\3\70\1"+
        "\u0195\1\70\1\u0195\4\70\1\uffff\25\70\1\33\1\70\1\33\1\uffff\6"+
        "\70\2\u01ba\14\70\2\u01c7\12\70\2\u01d2\3\uffff\4\70\1\uffff\22"+
        "\70\2\u01ea\2\70\2\u01ed\2\34\3\u0098\4\70\2\u01f3\2\70\1\uffff"+
        "\20\70\2\u0208\14\70\2\u0215\4\70\2\u021e\1\uffff\1\u0098\6\uffff"+
        "\4\70\1\uffff\2\70\2\u0226\2\u0227\2\u022a\2\u022b\2\u022c\2\u022d"+
        "\12\70\2\u023d\4\70\2\u0242\1\u0243\1\70\1\u0243\1\70\1\uffff\10"+
        "\70\2\u024e\2\70\1\uffff\2\u0251\2\u0252\6\70\2\uffff\12\70\2\u0265"+
        "\2\u0266\2\70\2\u0269\4\70\1\uffff\2\70\2\uffff\2\u0274\2\70\1\uffff"+
        "\10\70\2\u027f\12\70\1\uffff\2\u028a\2\u028b\2\70\2\u0292\4\70\1"+
        "\uffff\4\70\1\u029b\1\70\1\u029b\1\70\2\uffff\6\70\2\uffff\2\70"+
        "\4\uffff\11\70\2\u02b0\4\70\1\uffff\4\70\2\uffff\2\u02b9\2\70\2"+
        "\u02bc\2\u02bd\2\u02be\1\uffff\2\u02bf\2\uffff\2\70\2\u02c2\2\70"+
        "\2\uffff\4\70\2\u02c9\2\u02ca\2\70\2\uffff\2\u02cd\1\uffff\4\70"+
        "\4\u02d2\2\70\1\uffff\4\70\2\u02d9\2\u02da\2\u02db\1\uffff\2\u02dc"+
        "\10\70\2\uffff\6\70\1\uffff\2\70\2\u02ed\4\70\1\uffff\2\u02f2\2"+
        "\70\2\u02f5\2\u02f6\10\70\2\u02ff\2\u0302\1\uffff\6\70\2\u0309\1"+
        "\uffff\2\u030a\4\uffff\2\70\1\uffff\2\u030d\2\u030e\2\u030f\2\uffff"+
        "\2\70\1\uffff\4\70\1\uffff\4\70\2\u031c\4\uffff\2\u031d\4\70\2\u0322"+
        "\10\70\1\uffff\4\70\1\uffff\2\u032f\2\uffff\2\u0330\4\70\2\u0335"+
        "\1\uffff\2\u0336\1\uffff\2\u0337\2\u0338\2\70\2\uffff\2\70\3\uffff"+
        "\2\u033d\10\70\2\u0346\2\uffff\4\70\1\uffff\2\70\2\u034d\6\70\2"+
        "\u0354\2\uffff\4\70\4\uffff\2\u0359\2\u035a\1\uffff\2\u035b\2\u035c"+
        "\4\70\1\uffff\2\u0361\2\70\2\u0363\1\uffff\2\u0364\2\u0365\2\70"+
        "\1\uffff\2\70\2\u036a\4\uffff\2\70\2\u036e\1\uffff\1\70\3\uffff"+
        "\2\u0371\2\70\1\uffff\1\70\2\u0376\1\uffff\2\70\1\uffff\2\u0379"+
        "\2\70\1\uffff\2\70\1\uffff\6\70\2\u0384\2\70\1\uffff\2\70\2\u0379";
    static final String DFA25_eofS =
        "\u0389\uffff";
    static final String DFA25_minS =
        "\1\11\1\uffff\1\104\1\47\1\101\1\105\2\101\1\122\1\101\1\106\1\117"+
        "\1\103\1\101\1\117\1\75\1\103\1\125\2\105\1\110\1\116\1\101\1\110"+
        "\1\47\1\106\1\117\2\uffff\1\174\1\46\1\76\1\74\3\75\1\72\1\52\1"+
        "\0\1\101\15\uffff\2\56\1\115\2\uffff\1\104\1\114\1\104\2\60\1\107"+
        "\1\104\1\114\1\104\2\60\1\107\1\124\1\107\2\117\1\60\1\uffff\1\124"+
        "\1\107\2\117\1\60\1\114\1\101\2\114\1\101\1\114\1\103\1\123\1\60"+
        "\1\103\1\123\1\60\1\103\1\123\1\104\1\111\1\103\1\123\1\104\1\111"+
        "\1\114\1\124\1\105\1\117\1\122\1\117\2\114\1\124\1\105\1\117\1\122"+
        "\1\117\1\114\2\117\1\126\1\130\1\126\1\130\1\40\1\60\1\116\3\60"+
        "\1\116\1\60\2\111\1\106\1\115\1\116\1\101\1\106\1\115\1\116\1\101"+
        "\1\130\1\104\1\116\1\104\1\130\1\104\1\116\1\104\2\124\2\114\2\uffff"+
        "\1\124\1\106\2\60\2\124\1\106\2\60\1\124\2\117\1\101\1\107\1\101"+
        "\1\107\1\114\1\101\1\122\1\115\1\114\1\101\1\122\1\115\1\105\1\115"+
        "\1\125\1\105\1\115\1\125\1\123\1\120\1\105\1\123\1\120\1\105\2\122"+
        "\2\105\1\uffff\2\114\1\40\1\60\2\124\6\uffff\1\76\22\uffff\10\60"+
        "\1\uffff\2\60\1\uffff\2\60\2\127\1\111\1\60\1\111\1\60\2\102\2\114"+
        "\1\uffff\2\105\1\114\1\105\1\114\1\105\2\122\1\125\1\103\1\116\1"+
        "\125\1\103\1\116\1\111\1\101\1\103\1\111\1\101\1\103\1\124\1\60"+
        "\1\124\1\60\1\uffff\2\102\2\110\2\105\2\60\4\123\2\103\1\114\1\105"+
        "\1\114\1\105\2\101\2\60\2\115\1\114\1\103\1\114\1\103\2\125\2\111"+
        "\2\60\1\116\2\uffff\2\125\2\117\1\uffff\6\105\2\116\2\124\2\111"+
        "\1\107\1\105\1\107\1\105\2\123\2\60\2\111\4\60\1\40\2\60\1\114\1"+
        "\105\1\114\1\105\2\60\2\123\1\uffff\4\105\2\124\2\114\2\110\2\105"+
        "\2\114\2\101\2\60\2\116\1\105\1\131\1\105\1\131\2\105\2\111\2\105"+
        "\2\60\2\102\2\116\2\60\1\156\1\40\6\uffff\2\105\2\116\1\uffff\2"+
        "\122\14\60\2\115\2\101\2\124\2\115\2\125\2\60\2\111\2\114\3\60\1"+
        "\106\1\60\1\106\1\uffff\2\124\2\105\2\110\2\104\2\60\2\124\1\uffff"+
        "\4\60\2\124\2\120\2\116\1\uffff\1\117\2\114\2\122\2\130\2\122\2"+
        "\107\4\60\2\124\2\60\2\122\2\105\1\uffff\2\125\2\uffff\2\60\2\122"+
        "\1\uffff\2\105\4\122\2\105\2\60\2\124\2\103\2\114\1\111\1\116\1"+
        "\111\1\116\1\uffff\4\60\2\102\2\60\2\107\2\122\1\uffff\1\111\1\110"+
        "\1\111\1\110\1\60\1\105\1\60\1\105\1\uffff\1\157\2\105\2\124\2\131"+
        "\2\uffff\2\101\4\uffff\1\114\1\103\1\105\1\103\1\105\2\116\2\124"+
        "\2\60\2\101\2\114\1\uffff\2\116\2\105\2\uffff\2\60\2\123\6\60\1"+
        "\uffff\2\60\2\uffff\2\111\2\60\2\107\2\uffff\2\114\2\105\4\60\2"+
        "\105\2\uffff\2\60\1\uffff\1\114\1\105\1\114\1\105\4\60\2\115\1\uffff"+
        "\2\111\2\124\6\60\1\uffff\2\60\2\124\2\111\4\107\2\uffff\1\114\1"+
        "\116\1\105\1\114\1\116\1\105\1\uffff\2\116\2\60\2\116\2\101\1\uffff"+
        "\2\60\2\116\4\60\2\116\2\105\4\124\4\60\1\uffff\2\114\2\124\2\103"+
        "\2\60\1\uffff\2\60\4\uffff\2\117\1\uffff\6\60\2\uffff\2\122\1\uffff"+
        "\2\117\2\130\1\uffff\2\102\2\103\2\60\4\uffff\2\60\2\116\2\110\2"+
        "\60\2\117\2\124\2\130\2\105\1\uffff\2\101\2\122\1\uffff\2\60\2\uffff"+
        "\2\60\2\116\2\105\2\60\1\uffff\2\60\1\uffff\4\60\2\124\2\uffff\2"+
        "\116\3\uffff\2\60\2\102\2\124\1\114\1\116\1\114\1\116\2\60\2\uffff"+
        "\4\124\1\uffff\2\102\2\60\2\124\2\104\2\122\2\60\2\uffff\2\107\2"+
        "\122\4\uffff\4\60\1\uffff\4\60\2\117\2\124\1\uffff\2\60\2\137\2"+
        "\60\1\uffff\4\60\2\131\1\uffff\2\124\2\60\4\uffff\2\102\2\60\1\uffff"+
        "\1\112\3\uffff\2\60\2\110\1\uffff\1\114\2\60\1\uffff\2\117\1\uffff"+
        "\2\60\2\105\1\uffff\2\111\1\uffff\4\116\2\107\2\60\2\124\1\uffff"+
        "\2\110\2\60";
    static final String DFA25_maxS =
        "\1\176\1\uffff\1\166\1\171\2\157\1\170\1\165\1\162\1\145\1\163\3"+
        "\157\1\165\1\75\2\165\1\151\1\165\1\162\1\163\1\141\1\150\1\155"+
        "\1\163\1\165\2\uffff\1\174\1\46\2\76\2\75\1\76\1\75\1\71\1\uffff"+
        "\1\172\15\uffff\1\170\1\145\1\155\2\uffff\1\144\1\154\1\171\2\172"+
        "\1\147\1\144\1\154\1\171\2\172\1\147\1\164\1\156\2\157\1\172\1\uffff"+
        "\1\164\1\156\2\157\1\172\1\163\1\141\1\165\1\163\1\141\1\165\1\163"+
        "\1\166\1\172\1\163\1\166\1\172\1\143\1\163\1\144\1\151\1\143\1\163"+
        "\1\144\1\151\1\154\1\164\1\154\1\157\1\162\1\157\1\156\1\154\1\164"+
        "\1\154\1\157\1\162\1\157\1\156\2\157\1\166\1\170\1\166\1\170\2\172"+
        "\1\156\3\172\1\156\1\172\2\151\1\146\1\155\1\167\1\141\1\146\1\155"+
        "\1\167\1\141\1\170\1\144\1\156\1\144\1\170\1\144\1\156\1\144\2\164"+
        "\2\155\2\uffff\1\164\1\146\2\172\2\164\1\146\2\172\1\164\2\157\1"+
        "\141\1\147\1\141\1\147\1\154\1\141\1\162\1\155\1\154\1\141\1\162"+
        "\1\155\1\145\1\156\1\165\1\145\1\156\1\165\1\163\1\160\1\145\1\163"+
        "\1\160\1\145\2\162\2\145\1\uffff\2\154\2\172\2\164\6\uffff\1\76"+
        "\22\uffff\10\172\1\uffff\2\172\1\uffff\2\172\2\167\1\151\1\172\1"+
        "\151\1\172\2\142\2\154\1\uffff\2\145\1\154\1\145\1\154\1\145\2\162"+
        "\1\165\1\143\1\156\1\165\1\143\1\156\1\151\1\141\1\143\1\151\1\141"+
        "\1\143\1\164\1\172\1\164\1\172\1\uffff\2\142\2\150\2\151\2\172\4"+
        "\163\2\143\1\154\1\145\1\154\1\145\2\141\2\172\2\155\1\154\1\143"+
        "\1\154\1\143\2\165\2\151\2\172\1\116\2\uffff\2\165\2\157\1\uffff"+
        "\6\145\2\156\2\164\2\151\1\147\1\145\1\147\1\145\2\163\2\172\2\151"+
        "\7\172\1\154\1\145\1\154\1\145\2\172\2\163\1\uffff\4\145\2\164\2"+
        "\154\2\150\2\145\2\154\2\151\2\172\2\156\1\145\1\171\1\145\1\171"+
        "\2\145\2\151\2\145\2\172\2\143\2\162\2\172\1\156\1\172\6\uffff\2"+
        "\145\2\156\1\uffff\2\162\14\172\2\155\2\141\2\164\2\155\2\165\2"+
        "\172\2\151\2\154\3\172\1\146\1\172\1\146\1\uffff\2\164\2\145\2\150"+
        "\2\144\2\172\2\164\1\uffff\4\172\2\164\2\160\2\156\1\uffff\1\125"+
        "\2\154\2\162\2\170\2\162\2\147\4\172\2\164\2\172\2\162\2\145\1\uffff"+
        "\2\165\2\uffff\2\172\2\162\1\uffff\2\145\4\162\2\145\2\172\2\164"+
        "\2\143\2\154\1\151\1\156\1\151\1\156\1\uffff\4\172\2\164\2\172\2"+
        "\147\2\162\1\uffff\1\151\1\150\1\151\1\150\1\172\1\145\1\172\1\145"+
        "\1\uffff\1\165\2\145\2\164\2\171\2\uffff\2\141\4\uffff\1\154\1\143"+
        "\1\145\1\143\1\145\2\156\2\164\2\172\2\141\2\154\1\uffff\2\156\2"+
        "\145\2\uffff\2\172\2\163\6\172\1\uffff\2\172\2\uffff\2\151\2\172"+
        "\2\147\2\uffff\2\154\2\145\4\172\2\145\2\uffff\2\172\1\uffff\1\154"+
        "\1\145\1\154\1\145\4\172\2\155\1\uffff\2\151\2\164\6\172\1\uffff"+
        "\2\172\2\164\2\151\4\147\2\uffff\1\154\1\156\1\145\1\154\1\156\1"+
        "\145\1\uffff\2\156\2\172\2\156\2\141\1\uffff\2\172\2\156\4\172\2"+
        "\156\2\145\4\164\4\172\1\uffff\2\154\2\164\2\143\2\172\1\uffff\2"+
        "\172\4\uffff\2\157\1\uffff\6\172\2\uffff\2\162\1\uffff\2\157\2\170"+
        "\1\uffff\2\151\2\143\2\172\4\uffff\2\172\2\156\2\150\2\172\2\157"+
        "\2\164\2\170\2\145\1\uffff\2\141\2\162\1\uffff\2\172\2\uffff\2\172"+
        "\2\156\2\145\2\172\1\uffff\2\172\1\uffff\4\172\2\164\2\uffff\2\156"+
        "\3\uffff\2\172\2\142\2\164\1\154\1\156\1\154\1\156\2\172\2\uffff"+
        "\4\164\1\uffff\2\142\2\172\2\164\2\144\2\162\2\172\2\uffff\2\147"+
        "\2\162\4\uffff\4\172\1\uffff\4\172\2\157\2\164\1\uffff\2\172\2\137"+
        "\2\172\1\uffff\4\172\2\171\1\uffff\2\164\2\172\4\uffff\2\142\2\172"+
        "\1\uffff\1\152\3\uffff\2\172\2\150\1\uffff\1\154\2\172\1\uffff\2"+
        "\157\1\uffff\2\172\2\145\1\uffff\2\151\1\uffff\4\156\2\147\2\172"+
        "\2\164\1\uffff\2\150\2\172";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\31\uffff\1\147\1\150\13\uffff\1\167\1\170\1\171\1\174"+
        "\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085"+
        "\3\uffff\1\u0092\1\u0093\21\uffff\1\u008e\113\uffff\1\155\1\106"+
        "\50\uffff\1\u008d\6\uffff\1\151\1\u0087\1\152\1\u0088\1\153\1\154"+
        "\1\uffff\1\161\1\u008b\1\u0086\1\u0089\1\157\1\162\1\u008a\1\160"+
        "\1\166\1\172\1\163\1\173\1\u008f\1\164\1\u0090\1\165\1\u0091\1\u008c"+
        "\10\uffff\1\5\2\uffff\1\7\14\uffff\1\20\30\uffff\1\40\43\uffff\1"+
        "\72\1\63\4\uffff\1\66\45\uffff\1\113\50\uffff\1\156\1\2\1\3\1\4"+
        "\1\6\1\10\4\uffff\1\13\44\uffff\1\45\14\uffff\1\54\12\uffff\1\62"+
        "\27\uffff\1\102\2\uffff\1\105\1\146\4\uffff\1\111\24\uffff\1\125"+
        "\14\uffff\1\136\10\uffff\1\143\7\uffff\1\15\1\16\2\uffff\1\21\1"+
        "\22\1\23\1\24\17\uffff\1\36\4\uffff\1\42\1\43\12\uffff\1\52\2\uffff"+
        "\1\55\1\56\6\uffff\1\144\1\145\12\uffff\1\73\1\74\2\uffff\1\76\12"+
        "\uffff\1\107\12\uffff\1\117\12\uffff\1\126\1\127\6\uffff\1\133\10"+
        "\uffff\1\141\24\uffff\1\33\10\uffff\1\44\2\uffff\1\47\1\50\1\51"+
        "\1\53\2\uffff\1\60\6\uffff\1\67\1\70\2\uffff\1\75\4\uffff\1\101"+
        "\6\uffff\1\114\1\115\1\116\1\120\20\uffff\1\135\4\uffff\1\142\2"+
        "\uffff\1\12\1\14\10\uffff\1\30\2\uffff\1\32\6\uffff\1\41\1\46\2"+
        "\uffff\1\61\1\64\1\65\14\uffff\1\112\1\121\4\uffff\1\124\14\uffff"+
        "\1\11\1\17\4\uffff\1\27\1\31\1\34\1\35\4\uffff\1\71\10\uffff\1\110"+
        "\6\uffff\1\131\6\uffff\1\140\4\uffff\1\37\1\57\1\77\1\100\4\uffff"+
        "\1\122\1\uffff\1\130\1\132\1\134\4\uffff\1\26\3\uffff\1\104\2\uffff"+
        "\1\137\4\uffff\1\103\2\uffff\1\25\12\uffff\1\123\4\uffff";
    static final String DFA25_specialS =
        "\46\uffff\1\0\u0362\uffff}>";
    static final String[] DFA25_transitionS = {
            "\2\71\2\uffff\1\71\22\uffff\1\71\1\17\1\47\1\uffff\1\50\1\34"+
            "\1\36\1\46\1\56\1\55\1\54\1\63\1\53\1\64\1\45\1\33\1\65\11\66"+
            "\1\44\1\52\1\40\1\37\1\43\1\51\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1"+
            "\10\1\11\1\12\1\13\1\70\1\14\1\15\1\16\1\20\1\70\1\21\1\22\1"+
            "\23\1\24\1\25\1\26\1\27\1\30\2\70\1\60\1\uffff\1\57\1\42\2\uffff"+
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\31\1\13\1\70\1\14\1\15"+
            "\1\32\1\20\1\70\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\67\2\70"+
            "\1\61\1\35\1\62\1\41",
            "",
            "\1\72\7\uffff\1\73\1\uffff\1\74\4\uffff\1\75\1\76\1\uffff\1"+
            "\77\15\uffff\1\100\7\uffff\1\101\1\uffff\1\102\4\uffff\1\103"+
            "\1\104\1\uffff\1\105",
            "\1\113\35\uffff\1\106\3\uffff\1\107\2\uffff\1\110\2\uffff\1"+
            "\111\11\uffff\1\112\13\uffff\1\114\3\uffff\1\115\2\uffff\1\116"+
            "\2\uffff\1\117\11\uffff\1\120",
            "\1\121\6\uffff\1\122\6\uffff\1\123\21\uffff\1\124\6\uffff\1"+
            "\125\6\uffff\1\126",
            "\1\127\3\uffff\1\130\5\uffff\1\131\25\uffff\1\132\3\uffff\1"+
            "\133\5\uffff\1\134",
            "\1\135\12\uffff\1\136\1\uffff\1\137\11\uffff\1\140\10\uffff"+
            "\1\141\12\uffff\1\142\1\uffff\1\143\11\uffff\1\144",
            "\1\145\3\uffff\1\146\3\uffff\1\147\2\uffff\1\150\2\uffff\1"+
            "\151\2\uffff\1\152\2\uffff\1\153\13\uffff\1\154\3\uffff\1\155"+
            "\3\uffff\1\156\2\uffff\1\157\2\uffff\1\160\2\uffff\1\161\2\uffff"+
            "\1\162",
            "\1\163\37\uffff\1\164",
            "\1\165\3\uffff\1\166\33\uffff\1\167\3\uffff\1\170",
            "\1\172\1\173\6\uffff\1\174\4\uffff\1\171\22\uffff\1\176\1\177"+
            "\6\uffff\1\u0080\4\uffff\1\175",
            "\1\u0081\37\uffff\1\u0082",
            "\1\u0086\1\uffff\1\u0083\3\uffff\1\u0084\5\uffff\1\u0085\23"+
            "\uffff\1\u008a\1\uffff\1\u0087\3\uffff\1\u0088\5\uffff\1\u0089",
            "\1\u008b\3\uffff\1\u008c\3\uffff\1\u008d\5\uffff\1\u008e\21"+
            "\uffff\1\u008f\3\uffff\1\u0090\3\uffff\1\u0091\5\uffff\1\u0092",
            "\1\u0093\5\uffff\1\u0095\31\uffff\1\u0094\5\uffff\1\u0096",
            "\1\u0097",
            "\1\u0099\2\uffff\1\u009a\7\uffff\1\u009b\3\uffff\1\u009c\2"+
            "\uffff\1\u009d\15\uffff\1\u009e\2\uffff\1\u009f\7\uffff\1\u00a0"+
            "\3\uffff\1\u00a1\2\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a4",
            "\1\u00a5\3\uffff\1\u00a6\33\uffff\1\u00a7\3\uffff\1\u00a8",
            "\1\u00a9\7\uffff\1\u00aa\6\uffff\1\u00ab\1\u00ac\17\uffff\1"+
            "\u00ad\7\uffff\1\u00ae\6\uffff\1\u00af\1\u00b0",
            "\1\u00b1\1\u00b2\10\uffff\1\u00b3\25\uffff\1\u00b4\1\u00b5"+
            "\10\uffff\1\u00b6",
            "\1\u00b7\1\uffff\1\u00b8\2\uffff\1\u00b9\32\uffff\1\u00ba\1"+
            "\uffff\1\u00bb\2\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00c0",
            "\1\u00c1\45\uffff\1\u00c2\37\uffff\1\u00c3",
            "\1\172\1\173\6\uffff\1\174\4\uffff\1\u00c5\22\uffff\1\176\1"+
            "\177\6\uffff\1\u0080\4\uffff\1\u00c4",
            "\1\u00c7\5\uffff\1\u0095\31\uffff\1\u00c6\5\uffff\1\u0096",
            "",
            "",
            "\1\u00c8",
            "\1\u00ca",
            "\1\u00cc",
            "\1\u00cf\1\u00ce\1\u0097",
            "\1\u0097",
            "\1\u0097",
            "\1\u00d3\1\u00d4",
            "\1\u00d7\2\uffff\1\u00d6",
            "\1\u00d9\5\uffff\12\u00db",
            "\0\u00dd",
            "\32\u00df\6\uffff\32\u00df",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00db\1\uffff\12\66\13\uffff\1\u00db\34\uffff\1\113\2\uffff"+
            "\1\u00db\22\uffff\1\u00c1",
            "\1\u00db\1\uffff\12\66\13\uffff\1\u00db\37\uffff\1\u00db",
            "\1\u00c2\37\uffff\1\u00c3",
            "",
            "",
            "\1\u00e1\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e4",
            "\1\u00e6\24\uffff\1\u00e5\12\uffff\1\u00e8\24\uffff\1\u00e7",
            "\13\70\6\uffff\2\70\1\u00ea\27\70\4\uffff\1\70\1\uffff\2\70"+
            "\1\u00eb\27\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00ed\37\uffff\1\u00ee",
            "\1\u00e1\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e4",
            "\1\u00e6\24\uffff\1\u00e5\12\uffff\1\u00e8\24\uffff\1\u00e7",
            "\13\70\6\uffff\2\70\1\u00ea\27\70\4\uffff\1\70\1\uffff\2\70"+
            "\1\u00eb\27\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u00ed\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00f0",
            "\1\u00f1\6\uffff\1\u00f2\30\uffff\1\u00f3\6\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f8",
            "\13\70\6\uffff\23\70\1\u00fa\6\70\4\uffff\1\70\1\uffff\23\70"+
            "\1\u00fb\6\70",
            "",
            "\1\u00ef\37\uffff\1\u00f0",
            "\1\u00f1\6\uffff\1\u00f2\30\uffff\1\u00f3\6\uffff\1\u00f4",
            "\1\u00f5\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f8",
            "\13\70\6\uffff\23\70\1\u00fa\6\70\4\uffff\1\70\1\uffff\23\70"+
            "\1\u00fb\6\70",
            "\1\u00fc\6\uffff\1\u00fd\30\uffff\1\u00fe\6\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0101",
            "\1\u0102\1\uffff\1\u0103\6\uffff\1\u0104\26\uffff\1\u0105\1"+
            "\uffff\1\u0106\6\uffff\1\u0107",
            "\1\u00fc\6\uffff\1\u00fd\30\uffff\1\u00fe\6\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0101",
            "\1\u0102\1\uffff\1\u0103\6\uffff\1\u0104\26\uffff\1\u0105\1"+
            "\uffff\1\u0106\6\uffff\1\u0107",
            "\1\u0108\2\uffff\1\u0109\14\uffff\1\u010a\17\uffff\1\u010b"+
            "\2\uffff\1\u010c\14\uffff\1\u010d",
            "\1\u010e\2\uffff\1\u010f\34\uffff\1\u0110\2\uffff\1\u0111",
            "\13\70\6\uffff\24\70\1\u0113\5\70\4\uffff\1\70\1\uffff\24\70"+
            "\1\u0114\5\70",
            "\1\u0108\2\uffff\1\u0109\14\uffff\1\u010a\17\uffff\1\u010b"+
            "\2\uffff\1\u010c\14\uffff\1\u010d",
            "\1\u010e\2\uffff\1\u010f\34\uffff\1\u0110\2\uffff\1\u0111",
            "\13\70\6\uffff\24\70\1\u0113\5\70\4\uffff\1\70\1\uffff\24\70"+
            "\1\u0114\5\70",
            "\1\u0115\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011c",
            "\1\u0115\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u0120",
            "\1\u0121\6\uffff\1\u0122\30\uffff\1\u0123\6\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u012a",
            "\1\u012b\1\uffff\1\u012c\35\uffff\1\u012d\1\uffff\1\u012e",
            "\1\u011d\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u0120",
            "\1\u0121\6\uffff\1\u0122\30\uffff\1\u0123\6\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0128",
            "\1\u0129\37\uffff\1\u012a",
            "\1\u012b\1\uffff\1\u012c\35\uffff\1\u012d\1\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u0130",
            "\1\u012f\37\uffff\1\u0130",
            "\1\u0131\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0134",
            "\1\u0131\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0134",
            "\1\u0135\17\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff"+
            "\32\70",
            "\13\70\6\uffff\15\70\1\u0138\14\70\4\uffff\1\70\1\uffff\15"+
            "\70\1\u0139\14\70",
            "\1\u013a\37\uffff\1\u013b",
            "\13\70\6\uffff\3\70\1\u013d\11\70\1\u013e\5\70\1\u013f\6\70"+
            "\4\uffff\1\70\1\uffff\3\70\1\u0140\11\70\1\u0141\5\70\1\u0142"+
            "\6\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\15\70\1\u0138\14\70\4\uffff\1\70\1\uffff\15"+
            "\70\1\u0139\14\70",
            "\1\u013a\37\uffff\1\u013b",
            "\13\70\6\uffff\3\70\1\u013d\11\70\1\u013e\5\70\1\u013f\6\70"+
            "\4\uffff\1\70\1\uffff\3\70\1\u0140\11\70\1\u0141\5\70\1\u0142"+
            "\6\70",
            "\1\u0143\37\uffff\1\u0144",
            "\1\u0143\37\uffff\1\u0144",
            "\1\u0145\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0148",
            "\1\u0149\10\uffff\1\u014a\26\uffff\1\u014b\10\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014e",
            "\1\u0145\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0148",
            "\1\u0149\10\uffff\1\u014a\26\uffff\1\u014b\10\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014e",
            "\1\u014f\37\uffff\1\u0150",
            "\1\u0151\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0156",
            "\1\u014f\37\uffff\1\u0150",
            "\1\u0151\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0154",
            "\1\u0155\37\uffff\1\u0156",
            "\1\u0157\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0158",
            "\1\u015a\1\u015b\36\uffff\1\u015c\1\u015d",
            "\1\u015a\1\u015b\36\uffff\1\u015c\1\u015d",
            "",
            "",
            "\1\u015e\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0161",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\3\70\1\u0163\26\70\4\uffff\1\70\1\uffff\3\70"+
            "\1\u0164\26\70",
            "\1\u0165\37\uffff\1\u0166",
            "\1\u015e\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0161",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\3\70\1\u0163\26\70\4\uffff\1\70\1\uffff\3\70"+
            "\1\u0164\26\70",
            "\1\u0165\37\uffff\1\u0166",
            "\1\u0167\37\uffff\1\u0168",
            "\1\u0167\37\uffff\1\u0168",
            "\1\u0169\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016c",
            "\1\u0169\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016e",
            "\1\u016f\37\uffff\1\u0170",
            "\1\u0171\37\uffff\1\u0172",
            "\1\u0173\37\uffff\1\u0174",
            "\1\u016d\37\uffff\1\u016e",
            "\1\u016f\37\uffff\1\u0170",
            "\1\u0171\37\uffff\1\u0172",
            "\1\u0173\37\uffff\1\u0174",
            "\1\u0175\37\uffff\1\u0176",
            "\1\u0177\1\u0178\36\uffff\1\u0179\1\u017a",
            "\1\u017b\37\uffff\1\u017c",
            "\1\u0175\37\uffff\1\u0176",
            "\1\u0177\1\u0178\36\uffff\1\u0179\1\u017a",
            "\1\u017b\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017e",
            "\1\u017f\37\uffff\1\u0180",
            "\1\u0181\37\uffff\1\u0182",
            "\1\u017d\37\uffff\1\u017e",
            "\1\u017f\37\uffff\1\u0180",
            "\1\u0181\37\uffff\1\u0182",
            "\1\u0183\37\uffff\1\u0184",
            "\1\u0183\37\uffff\1\u0184",
            "\1\u0185\37\uffff\1\u0186",
            "\1\u0185\37\uffff\1\u0186",
            "",
            "\1\u0187\37\uffff\1\u0188",
            "\1\u0187\37\uffff\1\u0188",
            "\1\u0189\17\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff"+
            "\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0159\37\uffff\1\u018a",
            "\1\u0159\37\uffff\1\u0158",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00cd",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0191\37\uffff\1\u0192",
            "\1\u0191\37\uffff\1\u0192",
            "\1\u0193\37\uffff\1\u0194",
            "\13\70\6\uffff\1\u0196\31\70\4\uffff\1\70\1\uffff\1\u0197\31"+
            "\70",
            "\1\u0193\37\uffff\1\u0194",
            "\13\70\6\uffff\1\u0196\31\70\4\uffff\1\70\1\uffff\1\u0197\31"+
            "\70",
            "\1\u0198\37\uffff\1\u0199",
            "\1\u0198\37\uffff\1\u0199",
            "\1\u019a\37\uffff\1\u019b",
            "\1\u019a\37\uffff\1\u019b",
            "",
            "\1\u019c\37\uffff\1\u019d",
            "\1\u019c\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a1",
            "\1\u019e\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a1",
            "\1\u01a2\37\uffff\1\u01a3",
            "\1\u01a2\37\uffff\1\u01a3",
            "\1\u01a4\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a7",
            "\1\u01a8\37\uffff\1\u01a9",
            "\1\u01a4\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a7",
            "\1\u01a8\37\uffff\1\u01a9",
            "\1\u01aa\37\uffff\1\u01ab",
            "\1\u01ac\37\uffff\1\u01ad",
            "\1\u01ae\37\uffff\1\u01af",
            "\1\u01aa\37\uffff\1\u01ab",
            "\1\u01ac\37\uffff\1\u01ad",
            "\1\u01ae\37\uffff\1\u01af",
            "\1\u01b0\37\uffff\1\u01b1",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01b0\37\uffff\1\u01b1",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u01b2\37\uffff\1\u01b3",
            "\1\u01b2\37\uffff\1\u01b3",
            "\1\u01b4\37\uffff\1\u01b5",
            "\1\u01b4\37\uffff\1\u01b5",
            "\1\u01b6\3\uffff\1\u01b7\33\uffff\1\u01b8\3\uffff\1\u01b9",
            "\1\u01b6\3\uffff\1\u01b7\33\uffff\1\u01b8\3\uffff\1\u01b9",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01bb\37\uffff\1\u01bc",
            "\1\u01bb\37\uffff\1\u01bc",
            "\1\u01bd\37\uffff\1\u01be",
            "\1\u01bd\37\uffff\1\u01be",
            "\1\u01bf\37\uffff\1\u01c0",
            "\1\u01bf\37\uffff\1\u01c0",
            "\1\u01c1\37\uffff\1\u01c2",
            "\1\u01c3\37\uffff\1\u01c4",
            "\1\u01c1\37\uffff\1\u01c2",
            "\1\u01c3\37\uffff\1\u01c4",
            "\1\u01c5\37\uffff\1\u01c6",
            "\1\u01c5\37\uffff\1\u01c6",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01c8\37\uffff\1\u01c9",
            "\1\u01c8\37\uffff\1\u01c9",
            "\1\u01ca\37\uffff\1\u01cb",
            "\1\u01cc\37\uffff\1\u01cd",
            "\1\u01ca\37\uffff\1\u01cb",
            "\1\u01cc\37\uffff\1\u01cd",
            "\1\u01ce\37\uffff\1\u01cf",
            "\1\u01ce\37\uffff\1\u01cf",
            "\1\u01d0\37\uffff\1\u01d1",
            "\1\u01d0\37\uffff\1\u01d1",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01d3",
            "",
            "",
            "\1\u01d4\37\uffff\1\u01d5",
            "\1\u01d4\37\uffff\1\u01d5",
            "\1\u01d6\37\uffff\1\u01d7",
            "\1\u01d6\37\uffff\1\u01d7",
            "",
            "\1\u01d8\37\uffff\1\u01d9",
            "\1\u01da\37\uffff\1\u01db",
            "\1\u01dc\37\uffff\1\u01dd",
            "\1\u01d8\37\uffff\1\u01d9",
            "\1\u01da\37\uffff\1\u01db",
            "\1\u01dc\37\uffff\1\u01dd",
            "\1\u01de\37\uffff\1\u01df",
            "\1\u01de\37\uffff\1\u01df",
            "\1\u01e0\37\uffff\1\u01e1",
            "\1\u01e0\37\uffff\1\u01e1",
            "\1\u01e2\37\uffff\1\u01e3",
            "\1\u01e2\37\uffff\1\u01e3",
            "\1\u01e4\37\uffff\1\u01e5",
            "\1\u01e6\37\uffff\1\u01e7",
            "\1\u01e4\37\uffff\1\u01e5",
            "\1\u01e6\37\uffff\1\u01e7",
            "\1\u01e8\37\uffff\1\u01e9",
            "\1\u01e8\37\uffff\1\u01e9",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01eb\37\uffff\1\u01ec",
            "\1\u01eb\37\uffff\1\u01ec",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01ee\17\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff"+
            "\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01ef\37\uffff\1\u01f0",
            "\1\u01f1\37\uffff\1\u01f2",
            "\1\u01ef\37\uffff\1\u01f0",
            "\1\u01f1\37\uffff\1\u01f2",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u01f4\37\uffff\1\u01f5",
            "\1\u01f4\37\uffff\1\u01f5",
            "",
            "\1\u01f6\37\uffff\1\u01f7",
            "\1\u01f6\37\uffff\1\u01f7",
            "\1\u01f8\37\uffff\1\u01f9",
            "\1\u01f8\37\uffff\1\u01f9",
            "\1\u01fa\37\uffff\1\u01fb",
            "\1\u01fa\37\uffff\1\u01fb",
            "\1\u01fc\37\uffff\1\u01fd",
            "\1\u01fc\37\uffff\1\u01fd",
            "\1\u01fe\37\uffff\1\u01ff",
            "\1\u01fe\37\uffff\1\u01ff",
            "\1\u0200\37\uffff\1\u0201",
            "\1\u0200\37\uffff\1\u0201",
            "\1\u0202\37\uffff\1\u0203",
            "\1\u0202\37\uffff\1\u0203",
            "\1\u0204\7\uffff\1\u0205\27\uffff\1\u0206\7\uffff\1\u0207",
            "\1\u0204\7\uffff\1\u0205\27\uffff\1\u0206\7\uffff\1\u0207",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0209\37\uffff\1\u020a",
            "\1\u0209\37\uffff\1\u020a",
            "\1\u020b\37\uffff\1\u020c",
            "\1\u020d\37\uffff\1\u020e",
            "\1\u020b\37\uffff\1\u020c",
            "\1\u020d\37\uffff\1\u020e",
            "\1\u020f\37\uffff\1\u0210",
            "\1\u020f\37\uffff\1\u0210",
            "\1\u0211\37\uffff\1\u0212",
            "\1\u0211\37\uffff\1\u0212",
            "\1\u0213\37\uffff\1\u0214",
            "\1\u0213\37\uffff\1\u0214",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0216\1\u0217\36\uffff\1\u0218\1\u0219",
            "\1\u0216\1\u0217\36\uffff\1\u0218\1\u0219",
            "\1\u021a\3\uffff\1\u021b\33\uffff\1\u021c\3\uffff\1\u021d",
            "\1\u021a\3\uffff\1\u021b\33\uffff\1\u021c\3\uffff\1\u021d",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u021f",
            "\1\u01ee\17\uffff\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff"+
            "\32\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0220\37\uffff\1\u0221",
            "\1\u0220\37\uffff\1\u0221",
            "\1\u0222\37\uffff\1\u0223",
            "\1\u0222\37\uffff\1\u0223",
            "",
            "\1\u0224\37\uffff\1\u0225",
            "\1\u0224\37\uffff\1\u0225",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\4\70\1\u0228\25\70\4\uffff\1\70\1\uffff\4\70"+
            "\1\u0229\25\70",
            "\13\70\6\uffff\4\70\1\u0228\25\70\4\uffff\1\70\1\uffff\4\70"+
            "\1\u0229\25\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\1\u022f\21\70\1\u0230\7\70\4\uffff\1\u022e\1"+
            "\uffff\1\u0231\21\70\1\u0232\7\70",
            "\13\70\6\uffff\1\u022f\21\70\1\u0230\7\70\4\uffff\1\u022e\1"+
            "\uffff\1\u0231\21\70\1\u0232\7\70",
            "\1\u0233\37\uffff\1\u0234",
            "\1\u0233\37\uffff\1\u0234",
            "\1\u0235\37\uffff\1\u0236",
            "\1\u0235\37\uffff\1\u0236",
            "\1\u0237\37\uffff\1\u0238",
            "\1\u0237\37\uffff\1\u0238",
            "\1\u0239\37\uffff\1\u023a",
            "\1\u0239\37\uffff\1\u023a",
            "\1\u023b\37\uffff\1\u023c",
            "\1\u023b\37\uffff\1\u023c",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u023e\37\uffff\1\u023f",
            "\1\u023e\37\uffff\1\u023f",
            "\1\u0240\37\uffff\1\u0241",
            "\1\u0240\37\uffff\1\u0241",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0244\37\uffff\1\u0245",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0244\37\uffff\1\u0245",
            "",
            "\1\u0246\37\uffff\1\u0247",
            "\1\u0246\37\uffff\1\u0247",
            "\1\u0248\37\uffff\1\u0249",
            "\1\u0248\37\uffff\1\u0249",
            "\1\u024a\37\uffff\1\u024b",
            "\1\u024a\37\uffff\1\u024b",
            "\1\u024c\37\uffff\1\u024d",
            "\1\u024c\37\uffff\1\u024d",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u024f\37\uffff\1\u0250",
            "\1\u024f\37\uffff\1\u0250",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0253\37\uffff\1\u0254",
            "\1\u0253\37\uffff\1\u0254",
            "\1\u0255\37\uffff\1\u0256",
            "\1\u0255\37\uffff\1\u0256",
            "\1\u0257\37\uffff\1\u0258",
            "\1\u0257\37\uffff\1\u0258",
            "",
            "\1\u0259\5\uffff\1\u025a",
            "\1\u025b\37\uffff\1\u025c",
            "\1\u025b\37\uffff\1\u025c",
            "\1\u025d\37\uffff\1\u025e",
            "\1\u025d\37\uffff\1\u025e",
            "\1\u025f\37\uffff\1\u0260",
            "\1\u025f\37\uffff\1\u0260",
            "\1\u0261\37\uffff\1\u0262",
            "\1\u0261\37\uffff\1\u0262",
            "\1\u0263\37\uffff\1\u0264",
            "\1\u0263\37\uffff\1\u0264",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0267\37\uffff\1\u0268",
            "\1\u0267\37\uffff\1\u0268",
            "\13\70\6\uffff\1\70\1\u026a\21\70\1\u026b\6\70\4\uffff\1\70"+
            "\1\uffff\1\70\1\u026c\21\70\1\u026d\6\70",
            "\13\70\6\uffff\1\70\1\u026a\21\70\1\u026b\6\70\4\uffff\1\70"+
            "\1\uffff\1\70\1\u026c\21\70\1\u026d\6\70",
            "\1\u026e\37\uffff\1\u026f",
            "\1\u026e\37\uffff\1\u026f",
            "\1\u0270\37\uffff\1\u0271",
            "\1\u0270\37\uffff\1\u0271",
            "",
            "\1\u0272\37\uffff\1\u0273",
            "\1\u0272\37\uffff\1\u0273",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0275\37\uffff\1\u0276",
            "\1\u0275\37\uffff\1\u0276",
            "",
            "\1\u0277\37\uffff\1\u0278",
            "\1\u0277\37\uffff\1\u0278",
            "\1\u0279\37\uffff\1\u027a",
            "\1\u0279\37\uffff\1\u027a",
            "\1\u027b\37\uffff\1\u027c",
            "\1\u027b\37\uffff\1\u027c",
            "\1\u027d\37\uffff\1\u027e",
            "\1\u027d\37\uffff\1\u027e",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0280\37\uffff\1\u0281",
            "\1\u0280\37\uffff\1\u0281",
            "\1\u0282\37\uffff\1\u0283",
            "\1\u0282\37\uffff\1\u0283",
            "\1\u0284\37\uffff\1\u0285",
            "\1\u0284\37\uffff\1\u0285",
            "\1\u0286\37\uffff\1\u0287",
            "\1\u0288\37\uffff\1\u0289",
            "\1\u0286\37\uffff\1\u0287",
            "\1\u0288\37\uffff\1\u0289",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u028c\6\uffff\1\u028d\12\uffff\1\u028e\15\uffff\1\u028f"+
            "\6\uffff\1\u0290\12\uffff\1\u0291",
            "\1\u028c\6\uffff\1\u028d\12\uffff\1\u028e\15\uffff\1\u028f"+
            "\6\uffff\1\u0290\12\uffff\1\u0291",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0293\37\uffff\1\u0294",
            "\1\u0293\37\uffff\1\u0294",
            "\1\u0295\37\uffff\1\u0296",
            "\1\u0295\37\uffff\1\u0296",
            "",
            "\1\u0297\37\uffff\1\u0298",
            "\1\u0299\37\uffff\1\u029a",
            "\1\u0297\37\uffff\1\u0298",
            "\1\u0299\37\uffff\1\u029a",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u029c\37\uffff\1\u029d",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u029c\37\uffff\1\u029d",
            "",
            "\1\u0259\5\uffff\1\u025a",
            "\1\u029e\37\uffff\1\u029f",
            "\1\u029e\37\uffff\1\u029f",
            "\1\u02a0\37\uffff\1\u02a1",
            "\1\u02a0\37\uffff\1\u02a1",
            "\1\u02a2\37\uffff\1\u02a3",
            "\1\u02a2\37\uffff\1\u02a3",
            "",
            "",
            "\1\u02a4\37\uffff\1\u02a5",
            "\1\u02a4\37\uffff\1\u02a5",
            "",
            "",
            "",
            "",
            "\1\u02a6\37\uffff\1\u02a7",
            "\1\u02a8\37\uffff\1\u02a9",
            "\1\u02aa\37\uffff\1\u02ab",
            "\1\u02a8\37\uffff\1\u02a9",
            "\1\u02aa\37\uffff\1\u02ab",
            "\1\u02ac\37\uffff\1\u02ad",
            "\1\u02ac\37\uffff\1\u02ad",
            "\1\u02ae\37\uffff\1\u02af",
            "\1\u02ae\37\uffff\1\u02af",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02b1\37\uffff\1\u02b2",
            "\1\u02b1\37\uffff\1\u02b2",
            "\1\u02b3\37\uffff\1\u02b4",
            "\1\u02b3\37\uffff\1\u02b4",
            "",
            "\1\u02b5\37\uffff\1\u02b6",
            "\1\u02b5\37\uffff\1\u02b6",
            "\1\u02b7\37\uffff\1\u02b8",
            "\1\u02b7\37\uffff\1\u02b8",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02ba\37\uffff\1\u02bb",
            "\1\u02ba\37\uffff\1\u02bb",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u02c0\37\uffff\1\u02c1",
            "\1\u02c0\37\uffff\1\u02c1",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02c3\37\uffff\1\u02c4",
            "\1\u02c3\37\uffff\1\u02c4",
            "",
            "",
            "\1\u02c5\37\uffff\1\u02c6",
            "\1\u02c5\37\uffff\1\u02c6",
            "\1\u02c7\37\uffff\1\u02c8",
            "\1\u02c7\37\uffff\1\u02c8",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02cb\37\uffff\1\u02cc",
            "\1\u02cb\37\uffff\1\u02cc",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u02ce\37\uffff\1\u02cf",
            "\1\u02d0\37\uffff\1\u02d1",
            "\1\u02ce\37\uffff\1\u02cf",
            "\1\u02d0\37\uffff\1\u02d1",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02d3\37\uffff\1\u02d4",
            "\1\u02d3\37\uffff\1\u02d4",
            "",
            "\1\u02d5\37\uffff\1\u02d6",
            "\1\u02d5\37\uffff\1\u02d6",
            "\1\u02d7\37\uffff\1\u02d8",
            "\1\u02d7\37\uffff\1\u02d8",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02dd\37\uffff\1\u02de",
            "\1\u02dd\37\uffff\1\u02de",
            "\1\u02df\37\uffff\1\u02e0",
            "\1\u02df\37\uffff\1\u02e0",
            "\1\u02e1\37\uffff\1\u02e2",
            "\1\u02e1\37\uffff\1\u02e2",
            "\1\u02e3\37\uffff\1\u02e4",
            "\1\u02e3\37\uffff\1\u02e4",
            "",
            "",
            "\1\u02e5\37\uffff\1\u02e6",
            "\1\u02e7\37\uffff\1\u02e8",
            "\1\u02e9\37\uffff\1\u02ea",
            "\1\u02e5\37\uffff\1\u02e6",
            "\1\u02e7\37\uffff\1\u02e8",
            "\1\u02e9\37\uffff\1\u02ea",
            "",
            "\1\u02eb\37\uffff\1\u02ec",
            "\1\u02eb\37\uffff\1\u02ec",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02ee\37\uffff\1\u02ef",
            "\1\u02ee\37\uffff\1\u02ef",
            "\1\u02f0\37\uffff\1\u02f1",
            "\1\u02f0\37\uffff\1\u02f1",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02f3\37\uffff\1\u02f4",
            "\1\u02f3\37\uffff\1\u02f4",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u02f7\37\uffff\1\u02f8",
            "\1\u02f7\37\uffff\1\u02f8",
            "\1\u02f9\37\uffff\1\u02fa",
            "\1\u02f9\37\uffff\1\u02fa",
            "\1\u02fb\37\uffff\1\u02fc",
            "\1\u02fb\37\uffff\1\u02fc",
            "\1\u02fd\37\uffff\1\u02fe",
            "\1\u02fd\37\uffff\1\u02fe",
            "\13\70\6\uffff\22\70\1\u0300\7\70\4\uffff\1\70\1\uffff\22\70"+
            "\1\u0301\7\70",
            "\13\70\6\uffff\22\70\1\u0300\7\70\4\uffff\1\70\1\uffff\22\70"+
            "\1\u0301\7\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0303\37\uffff\1\u0304",
            "\1\u0303\37\uffff\1\u0304",
            "\1\u0305\37\uffff\1\u0306",
            "\1\u0305\37\uffff\1\u0306",
            "\1\u0307\37\uffff\1\u0308",
            "\1\u0307\37\uffff\1\u0308",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "",
            "",
            "\1\u030b\37\uffff\1\u030c",
            "\1\u030b\37\uffff\1\u030c",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u0310\37\uffff\1\u0311",
            "\1\u0310\37\uffff\1\u0311",
            "",
            "\1\u0312\37\uffff\1\u0313",
            "\1\u0312\37\uffff\1\u0313",
            "\1\u0314\37\uffff\1\u0315",
            "\1\u0314\37\uffff\1\u0315",
            "",
            "\1\u0316\6\uffff\1\u0317\30\uffff\1\u0318\6\uffff\1\u0319",
            "\1\u0316\6\uffff\1\u0317\30\uffff\1\u0318\6\uffff\1\u0319",
            "\1\u031a\37\uffff\1\u031b",
            "\1\u031a\37\uffff\1\u031b",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u031e\37\uffff\1\u031f",
            "\1\u031e\37\uffff\1\u031f",
            "\1\u0320\37\uffff\1\u0321",
            "\1\u0320\37\uffff\1\u0321",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0323\37\uffff\1\u0324",
            "\1\u0323\37\uffff\1\u0324",
            "\1\u0325\37\uffff\1\u0326",
            "\1\u0325\37\uffff\1\u0326",
            "\1\u0327\37\uffff\1\u0328",
            "\1\u0327\37\uffff\1\u0328",
            "\1\u0329\37\uffff\1\u032a",
            "\1\u0329\37\uffff\1\u032a",
            "",
            "\1\u032b\37\uffff\1\u032c",
            "\1\u032b\37\uffff\1\u032c",
            "\1\u032d\37\uffff\1\u032e",
            "\1\u032d\37\uffff\1\u032e",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0331\37\uffff\1\u0332",
            "\1\u0331\37\uffff\1\u0332",
            "\1\u0333\37\uffff\1\u0334",
            "\1\u0333\37\uffff\1\u0334",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0339\37\uffff\1\u033a",
            "\1\u0339\37\uffff\1\u033a",
            "",
            "",
            "\1\u033b\37\uffff\1\u033c",
            "\1\u033b\37\uffff\1\u033c",
            "",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u033e\37\uffff\1\u033f",
            "\1\u033e\37\uffff\1\u033f",
            "\1\u0340\37\uffff\1\u0341",
            "\1\u0340\37\uffff\1\u0341",
            "\1\u0342\37\uffff\1\u0343",
            "\1\u0344\37\uffff\1\u0345",
            "\1\u0342\37\uffff\1\u0343",
            "\1\u0344\37\uffff\1\u0345",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u0347\37\uffff\1\u0348",
            "\1\u0347\37\uffff\1\u0348",
            "\1\u0349\37\uffff\1\u034a",
            "\1\u0349\37\uffff\1\u034a",
            "",
            "\1\u034b\37\uffff\1\u034c",
            "\1\u034b\37\uffff\1\u034c",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u034e\37\uffff\1\u034f",
            "\1\u034e\37\uffff\1\u034f",
            "\1\u0350\37\uffff\1\u0351",
            "\1\u0350\37\uffff\1\u0351",
            "\1\u0352\37\uffff\1\u0353",
            "\1\u0352\37\uffff\1\u0353",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "",
            "\1\u0355\37\uffff\1\u0356",
            "\1\u0355\37\uffff\1\u0356",
            "\1\u0357\37\uffff\1\u0358",
            "\1\u0357\37\uffff\1\u0358",
            "",
            "",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u035d\37\uffff\1\u035e",
            "\1\u035d\37\uffff\1\u035e",
            "\1\u035f\37\uffff\1\u0360",
            "\1\u035f\37\uffff\1\u0360",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0362",
            "\1\u0362",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0366\37\uffff\1\u0367",
            "\1\u0366\37\uffff\1\u0367",
            "",
            "\1\u0368\37\uffff\1\u0369",
            "\1\u0368\37\uffff\1\u0369",
            "\13\70\6\uffff\32\70\4\uffff\1\u036b\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\u036b\1\uffff\32\70",
            "",
            "",
            "",
            "",
            "\1\u036c\37\uffff\1\u036d",
            "\1\u036c\37\uffff\1\u036d",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u036f\37\uffff\1\u0370",
            "",
            "",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0372\37\uffff\1\u0373",
            "\1\u0372\37\uffff\1\u0373",
            "",
            "\1\u0374\37\uffff\1\u0375",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "",
            "\1\u0377\37\uffff\1\u0378",
            "\1\u0377\37\uffff\1\u0378",
            "",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u037a\37\uffff\1\u037b",
            "\1\u037a\37\uffff\1\u037b",
            "",
            "\1\u037c\37\uffff\1\u037d",
            "\1\u037c\37\uffff\1\u037d",
            "",
            "\1\u037e\37\uffff\1\u037f",
            "\1\u037e\37\uffff\1\u037f",
            "\1\u0380\37\uffff\1\u0381",
            "\1\u0380\37\uffff\1\u0381",
            "\1\u0382\37\uffff\1\u0383",
            "\1\u0382\37\uffff\1\u0383",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\u0385\37\uffff\1\u0386",
            "\1\u0385\37\uffff\1\u0386",
            "",
            "\1\u0387\37\uffff\1\u0388",
            "\1\u0387\37\uffff\1\u0388",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70",
            "\13\70\6\uffff\32\70\4\uffff\1\70\1\uffff\32\70"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__183 | ADD_SYM | ALL | ANY | AS_SYM | ASC | AT_SYM | AVG | BETWEEN | BIGINT | BIN | BINARY | BLOB_SYM | BOOL_SYM | BOOLEAN_SYM | BY_SYM | BYTE_SYM | CALL_SYM | CASE_SYM | CHAR | CHAR_LENGTH | CHARACTER_SYM | CHARSET | COLUMN_SYM | COLUMNS_SYM | CONCAT | COUNT | DECIMAL_SYM | DEFAULT | DESC | DISTINCT | DO_SYM | DOUBLE_SYM | EACH_SYM | ELSE_SYM | ELSIF_SYM | END_SYM | EXISTS | FALSE_SYM | FETCH_SYM | FIELD | FILE_SYM | FLOAT_SYM | FOR_SYM | FROM | FULL | FUNCTION_SYM | GROUP_SYM | HAVING | HEX | IF | IFNULL | IGNORE_SYM | IN_SYM | INDEX_SYM | INNER_SYM | INTEGER_SYM | IS_SYM | JOIN_SYM | LEFT | LIMIT | LONG_SYM | LONGBLOB | LONGTEXT | LOWER | MAX_SYM | MEDIUMBLOB | MEDIUMINT | MIN_SYM | NOT_SYM | NULL_SYM | NUMERIC_SYM | OCT | OFFSET_SYM | ON | ORDER_SYM | OUTER | QUOTE | REAL | RIGHT | SELECT | SMALLINT | STRAIGHT_JOIN | STRING_SYM | SUM | THEN_SYM | TIME_SYM | TINYBLOB | TINYINT | TINYTEXT | TRUE_SYM | UNSIGNED_SYM | UPPER | USE_SYM | VARBINARY | VARCHAR | WHEN_SYM | WHERE | XML_SYM | ISNOTNULL | ISNULL | NOT_IN | DIVIDE | MOD_SYM | OR_SYM | AND_SYM | ARROW | EQ_SYM | NOT_EQ | LET | GET | SET_VAR | SHIFT_LEFT | SHIFT_RIGHT | ALL_FIELDS | SQUOTE | DQUOTE | COLONCOLON | DOLLAR | QUESTION | SEMI | COLON | DOT | COMMA | ASTERISK | RPAREN | LPAREN | RBRACK | LBRACK | LCURLY | RCURLY | PLUS | MINUS | NEGATION | VERTBAR | BITAND | POWER_OP | GTH | LTH | INTEGER_NUM | HEX_DIGIT | BIT_NUM | REAL_NUMBER | QUOTED_STRING | QUOTED_ID | ID | WHITE_SPACE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_38 = input.LA(1);

                        s = -1;
                        if ( ((LA25_38 >= '\u0000' && LA25_38 <= '\uFFFF')) ) {s = 221;}

                        else s = 220;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}