// $ANTLR 3.4 /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g 2013-02-04 17:46:21

package  org.hpccsystems.jdbcdriver.antlr.sqlparser.generated;


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
    public String getGrammarFileName() { return "/home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g"; }

    // $ANTLR start "T__183"
    public final void mT__183() throws RecognitionException {
        try {
            int _type = T__183;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:18:8: ( '@' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:18:10: '@'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:237:14: ( 'a' | 'A' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:238:14: ( 'b' | 'B' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:239:14: ( 'c' | 'C' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:240:14: ( 'd' | 'D' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:241:14: ( 'e' | 'E' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:242:14: ( 'f' | 'F' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:243:14: ( 'g' | 'G' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:244:14: ( 'h' | 'H' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:245:14: ( 'i' | 'I' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:246:14: ( 'j' | 'J' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:247:14: ( 'k' | 'K' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:248:14: ( 'l' | 'L' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:249:14: ( 'm' | 'M' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:250:14: ( 'n' | 'N' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:251:14: ( 'o' | 'O' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:252:14: ( 'p' | 'P' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:253:14: ( 'q' | 'Q' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:254:14: ( 'r' | 'R' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:255:14: ( 's' | 'S' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:256:14: ( 't' | 'T' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:257:14: ( 'u' | 'U' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:258:14: ( 'v' | 'V' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:259:14: ( 'w' | 'W' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:260:14: ( 'x' | 'X' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:261:14: ( 'y' | 'Y' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:262:14: ( 'z' | 'Z' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:264:12: ( A_i D_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:264:14: A_i D_i D_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:265:12: ( A_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:265:14: A_i L_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:266:12: ( A_i N_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:266:14: A_i N_i Y_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:267:11: ( A_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:267:13: A_i S_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:268:12: ( A_i S_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:268:14: A_i S_i C_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:269:11: ( A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:269:13: A_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:270:12: ( A_i V_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:270:14: A_i V_i G_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:271:12: ( B_i E_i T_i W_i E_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:271:14: B_i E_i T_i W_i E_i E_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:272:11: ( B_i I_i G_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:272:13: B_i I_i G_i I_i N_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:273:12: ( B_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:273:14: B_i I_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:274:11: ( B_i I_i N_i A_i R_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:274:13: B_i I_i N_i A_i R_i Y_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:275:12: ( B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:275:14: B_i L_i O_i B_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:276:12: ( B_i O_i O_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:276:14: B_i O_i O_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:277:15: ( B_i O_i O_i L_i E_i A_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:277:17: B_i O_i O_i L_i E_i A_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:278:11: ( B_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:278:13: B_i Y_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:279:12: ( B_i Y_i T_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:279:14: B_i Y_i T_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:280:12: ( C_i A_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:280:14: C_i A_i L_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:281:12: ( C_i A_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:281:14: C_i A_i S_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:282:9: ( C_i H_i A_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:282:11: C_i H_i A_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:15: ( ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i ) | ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i ) )
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:17: ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:17: ( C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:18: C_i H_i A_i R_i '_' L_i E_i N_i G_i T_i H_i
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:65: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:65: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:283:66: C_i H_i A_i R_i A_i C_i T_i E_i R_i '_' L_i E_i N_i G_i T_i H_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:284:16: ( C_i H_i A_i R_i A_i C_i T_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:284:18: C_i H_i A_i R_i A_i C_i T_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:285:12: ( C_i H_i A_i R_i S_i E_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:285:14: C_i H_i A_i R_i S_i E_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:286:14: ( C_i O_i L_i U_i M_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:286:16: C_i O_i L_i U_i M_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:287:15: ( C_i O_i L_i U_i M_i N_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:287:17: C_i O_i L_i U_i M_i N_i S_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:288:11: ( C_i O_i N_i C_i A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:288:13: C_i O_i N_i C_i A_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:289:10: ( C_i O_i U_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:289:12: C_i O_i U_i N_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:290:15: ( D_i E_i C_i I_i M_i A_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:290:17: D_i E_i C_i I_i M_i A_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:291:12: ( D_i E_i F_i A_i U_i L_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:291:14: D_i E_i F_i A_i U_i L_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:292:9: ( D_i E_i S_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:292:11: D_i E_i S_i C_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:293:12: ( D_i I_i S_i T_i I_i N_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:293:14: D_i I_i S_i T_i I_i N_i C_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:294:11: ( D_i O_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:294:13: D_i O_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:295:14: ( D_i O_i U_i B_i L_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:295:16: D_i O_i U_i B_i L_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:296:12: ( E_i A_i C_i H_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:296:14: E_i A_i C_i H_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:297:12: ( E_i L_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:297:14: E_i L_i S_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:298:13: ( E_i L_i S_i I_i F_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:298:15: E_i L_i S_i I_i F_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:299:12: ( E_i N_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:299:14: E_i N_i D_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:300:11: ( E_i X_i I_i S_i T_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:300:13: E_i X_i I_i S_i T_i S_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:301:13: ( F_i A_i L_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:301:15: F_i A_i L_i S_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:302:13: ( F_i E_i T_i C_i H_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:302:15: F_i E_i T_i C_i H_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:303:10: ( F_i I_i E_i L_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:303:12: F_i I_i E_i L_i D_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:304:12: ( F_i I_i L_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:304:14: F_i I_i L_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:305:13: ( F_i L_i O_i A_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:305:15: F_i L_i O_i A_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:306:12: ( F_i O_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:306:14: F_i O_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:307:9: ( F_i R_i O_i M_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:307:11: F_i R_i O_i M_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:308:9: ( F_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:308:11: F_i U_i L_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:309:15: ( F_i U_i N_i C_i T_i I_i O_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:309:17: F_i U_i N_i C_i T_i I_i O_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:310:13: ( G_i R_i O_i U_i P_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:310:15: G_i R_i O_i U_i P_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:311:11: ( H_i A_i V_i I_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:311:13: H_i A_i V_i I_i N_i G_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:312:12: ( H_i E_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:312:14: H_i E_i X_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:313:11: ( I_i F_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:313:13: I_i F_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:314:11: ( I_i F_i N_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:314:13: I_i F_i N_i U_i L_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:315:14: ( I_i G_i N_i O_i R_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:315:16: I_i G_i N_i O_i R_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:316:11: ( I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:316:13: I_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:317:13: ( I_i N_i D_i E_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:317:15: I_i N_i D_i E_i X_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:318:13: ( I_i N_i N_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:318:15: I_i N_i N_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:319:15: ( I_i N_i T_i E_i G_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:319:17: I_i N_i T_i E_i G_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:320:11: ( I_i S_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:320:13: I_i S_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:321:12: ( J_i O_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:321:14: J_i O_i I_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:322:9: ( L_i E_i F_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:322:11: L_i E_i F_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:323:10: ( L_i I_i M_i I_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:323:12: L_i I_i M_i I_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:324:12: ( L_i O_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:324:14: L_i O_i N_i G_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:325:12: ( L_i O_i N_i G_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:325:14: L_i O_i N_i G_i B_i L_i O_i B_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:326:12: ( L_i O_i N_i G_i T_i E_i X_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:326:14: L_i O_i N_i G_i T_i E_i X_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:10: ( ( L_i O_i W_i E_i R_i ) | ( L_i C_i A_i S_i E_i ) )
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:12: ( L_i O_i W_i E_i R_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:12: ( L_i O_i W_i E_i R_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:13: L_i O_i W_i E_i R_i
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:36: ( L_i C_i A_i S_i E_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:36: ( L_i C_i A_i S_i E_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:327:37: L_i C_i A_i S_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:328:12: ( M_i A_i X_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:328:14: M_i A_i X_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:329:14: ( M_i E_i D_i I_i U_i M_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:329:16: M_i E_i D_i I_i U_i M_i B_i L_i O_i B_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:330:13: ( M_i E_i D_i I_i U_i M_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:330:15: M_i E_i D_i I_i U_i M_i I_i N_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:331:21: ( M_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:331:23: M_i I_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:12: ( ( N_i O_i T_i ) | ( '!' ) )
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:14: ( N_i O_i T_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:14: ( N_i O_i T_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:15: N_i O_i T_i
                    {
                    mN_i(); 


                    mO_i(); 


                    mT_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:30: ( '!' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:30: ( '!' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:332:31: '!'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:333:12: ( N_i U_i L_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:333:14: N_i U_i L_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:334:15: ( N_i U_i M_i E_i R_i I_i C_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:334:17: N_i U_i M_i E_i R_i I_i C_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:335:12: ( O_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:335:14: O_i C_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:336:14: ( O_i F_i F_i S_i E_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:336:16: O_i F_i F_i S_i E_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:337:11: ( O_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:337:13: O_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:338:13: ( O_i R_i D_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:338:15: O_i R_i D_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:339:10: ( O_i U_i T_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:339:12: O_i U_i T_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:340:10: ( Q_i U_i O_i T_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:340:12: Q_i U_i O_i T_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:341:9: ( R_i E_i A_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:341:11: R_i E_i A_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:342:10: ( R_i I_i G_i H_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:342:12: R_i I_i G_i H_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:343:11: ( S_i E_i L_i E_i C_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:343:13: S_i E_i L_i E_i C_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:344:12: ( S_i M_i A_i L_i L_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:344:14: S_i M_i A_i L_i L_i I_i N_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:345:16: ( S_i T_i R_i A_i I_i G_i H_i T_i '_' J_i O_i I_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:345:18: S_i T_i R_i A_i I_i G_i H_i T_i '_' J_i O_i I_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:346:14: ( S_i T_i R_i I_i N_i G_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:346:16: S_i T_i R_i I_i N_i G_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:347:12: ( S_i U_i M_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:347:14: S_i U_i M_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:348:12: ( T_i H_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:348:14: T_i H_i E_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:349:12: ( T_i I_i M_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:349:14: T_i I_i M_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:350:12: ( T_i I_i N_i Y_i B_i L_i O_i B_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:350:14: T_i I_i N_i Y_i B_i L_i O_i B_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:351:12: ( T_i I_i N_i Y_i I_i N_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:351:14: T_i I_i N_i Y_i I_i N_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:352:12: ( T_i I_i N_i Y_i T_i E_i X_i T_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:352:14: T_i I_i N_i Y_i T_i E_i X_i T_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:353:12: ( T_i R_i U_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:353:14: T_i R_i U_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:354:15: ( U_i N_i S_i I_i G_i N_i E_i D_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:354:17: U_i N_i S_i I_i G_i N_i E_i D_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:356:21: ( U_i P_i P_i E_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:356:23: U_i P_i P_i E_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:357:12: ( U_i S_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:357:14: U_i S_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:358:13: ( V_i A_i R_i B_i I_i N_i A_i R_i Y_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:358:15: V_i A_i R_i B_i I_i N_i A_i R_i Y_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:359:12: ( V_i A_i R_i C_i H_i A_i R_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:359:14: V_i A_i R_i C_i H_i A_i R_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:360:12: ( W_i H_i E_i N_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:360:14: W_i H_i E_i N_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:361:10: ( W_i H_i E_i R_i E_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:361:12: W_i H_i E_i R_i E_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:362:12: ( X_i M_i L_i )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:362:14: X_i M_i L_i
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:364:13: ( IS_SYM WHITE_SPACE NOT_SYM WHITE_SPACE NULL_SYM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:364:15: IS_SYM WHITE_SPACE NOT_SYM WHITE_SPACE NULL_SYM
            {
            mIS_SYM(); 


            mWHITE_SPACE(); 


            mNOT_SYM(); 


            mWHITE_SPACE(); 


            mNULL_SYM(); 


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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:365:14: ( IS_SYM WHITE_SPACE NULL_SYM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:365:16: IS_SYM WHITE_SPACE NULL_SYM
            {
            mIS_SYM(); 


            mWHITE_SPACE(); 


            mNULL_SYM(); 


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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:366:13: ( NOT_SYM WHITE_SPACE IN_SYM )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:366:15: NOT_SYM WHITE_SPACE IN_SYM
            {
            mNOT_SYM(); 


            mWHITE_SPACE(); 


            mIN_SYM(); 


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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:367:13: ( ( D_i I_i V_i ) | '/' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='D'||LA4_0=='d') ) {
                alt4=1;
            }
            else if ( (LA4_0=='/') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:367:15: ( D_i I_i V_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:367:15: ( D_i I_i V_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:367:18: D_i I_i V_i
                    {
                    mD_i(); 


                    mI_i(); 


                    mV_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:367:34: '/'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:368:14: ( ( M_i O_i D_i ) | '%' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='M'||LA5_0=='m') ) {
                alt5=1;
            }
            else if ( (LA5_0=='%') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:368:16: ( M_i O_i D_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:368:16: ( M_i O_i D_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:368:19: M_i O_i D_i
                    {
                    mM_i(); 


                    mO_i(); 


                    mD_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:368:35: '%'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:369:13: ( ( O_i R_i ) | '||' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='O'||LA6_0=='o') ) {
                alt6=1;
            }
            else if ( (LA6_0=='|') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:369:15: ( O_i R_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:369:15: ( O_i R_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:369:18: O_i R_i
                    {
                    mO_i(); 


                    mR_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:369:30: '||'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:370:14: ( ( A_i N_i D_i ) | '&&' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='A'||LA7_0=='a') ) {
                alt7=1;
            }
            else if ( (LA7_0=='&') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:370:16: ( A_i N_i D_i )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:370:16: ( A_i N_i D_i )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:370:19: A_i N_i D_i
                    {
                    mA_i(); 


                    mN_i(); 


                    mD_i(); 


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:370:35: '&&'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:371:12: ( '=>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:371:14: '=>'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:372:13: ( '=' | '<=>' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='=') ) {
                alt8=1;
            }
            else if ( (LA8_0=='<') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:372:15: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:372:21: '<=>'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:373:13: ( '<>' | '!=' | '~=' | '^=' )
            int alt9=4;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt9=1;
                }
                break;
            case '!':
                {
                alt9=2;
                }
                break;
            case '~':
                {
                alt9=3;
                }
                break;
            case '^':
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:373:15: '<>'
                    {
                    match("<>"); 



                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:373:22: '!='
                    {
                    match("!="); 



                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:373:29: '~='
                    {
                    match("~="); 



                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:373:35: '^='
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:374:14: ( '<=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:374:16: '<='
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:375:14: ( '>=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:375:16: '>='
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:376:14: ( ':=' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:376:16: ':='
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:377:13: ( '<<' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:377:15: '<<'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:378:14: ( '>>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:378:16: '>>'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:379:13: ( '.*' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:379:15: '.*'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:380:13: ( '\\'' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:380:15: '\\''
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:381:13: ( '\\\"' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:381:15: '\\\"'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:382:14: ( '::' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:382:16: '::'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:383:13: ( '$' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:383:15: '$'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:384:14: ( '?' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:384:16: '?'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:385:11: ( ';' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:385:13: ';'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:386:12: ( ':' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:386:14: ':'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:387:14: ( '.' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:387:16: '.'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:388:12: ( ',' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:388:14: ','
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:389:14: ( '*' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:389:16: '*'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:390:13: ( ')' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:390:15: ')'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:391:13: ( '(' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:391:15: '('
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:392:13: ( ']' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:392:15: ']'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:393:13: ( '[' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:393:15: '['
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:394:14: ( '{' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:394:16: '{'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:395:13: ( '}' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:395:15: '}'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:396:11: ( '+' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:396:13: '+'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:397:12: ( '-' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:397:14: '-'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:398:14: ( '~' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:398:16: '~'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:399:14: ( '|' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:399:16: '|'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:400:13: ( '&' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:400:15: '&'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:401:14: ( '^' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:401:16: '^'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:402:14: ( '>' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:402:16: '>'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:403:14: ( '<' )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:403:16: '<'
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:406:14: ( ( '0' .. '9' )+ )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:406:16: ( '0' .. '9' )+
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:406:16: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:408:28: ( ( 'a' .. 'f' | 'A' .. 'F' | '0' .. '9' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:411:5: ( ( '0x' ( HEX_DIGIT_FRAGMENT )+ ) | ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='0') ) {
                alt13=1;
            }
            else if ( (LA13_0=='X') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:412:2: ( '0x' ( HEX_DIGIT_FRAGMENT )+ )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:412:2: ( '0x' ( HEX_DIGIT_FRAGMENT )+ )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:412:5: '0x' ( HEX_DIGIT_FRAGMENT )+
                    {
                    match("0x"); 



                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:412:14: ( HEX_DIGIT_FRAGMENT )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'F')||(LA11_0 >= 'a' && LA11_0 <= 'f')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:414:2: ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:414:2: ( 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\'' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:414:5: 'X' '\\'' ( HEX_DIGIT_FRAGMENT )+ '\\''
                    {
                    match('X'); 

                    match('\''); 

                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:414:14: ( HEX_DIGIT_FRAGMENT )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'F')||(LA12_0 >= 'a' && LA12_0 <= 'f')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:418:5: ( ( '0b' ( '0' | '1' )+ ) | ( B_i '\\'' ( '0' | '1' )+ '\\'' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='0') ) {
                alt16=1;
            }
            else if ( (LA16_0=='B'||LA16_0=='b') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:419:2: ( '0b' ( '0' | '1' )+ )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:419:2: ( '0b' ( '0' | '1' )+ )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:419:5: '0b' ( '0' | '1' )+
                    {
                    match("0b"); 



                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:419:13: ( '0' | '1' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '0' && LA14_0 <= '1')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:421:2: ( B_i '\\'' ( '0' | '1' )+ '\\'' )
                    {
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:421:2: ( B_i '\\'' ( '0' | '1' )+ '\\'' )
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:421:5: B_i '\\'' ( '0' | '1' )+ '\\''
                    {
                    mB_i(); 


                    match('\''); 

                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:421:14: ( '0' | '1' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0 >= '0' && LA15_0 <= '1')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
    // $ANTLR end "BIT_NUM"

    // $ANTLR start "REAL_NUMBER"
    public final void mREAL_NUMBER() throws RecognitionException {
        try {
            int _type = REAL_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:425:5: ( ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM ) ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )? )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM ) ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )?
            {
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM )
            int alt17=4;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:5: INTEGER_NUM DOT INTEGER_NUM
                    {
                    mINTEGER_NUM(); 


                    mDOT(); 


                    mINTEGER_NUM(); 


                    }
                    break;
                case 2 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:35: INTEGER_NUM DOT
                    {
                    mINTEGER_NUM(); 


                    mDOT(); 


                    }
                    break;
                case 3 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:53: DOT INTEGER_NUM
                    {
                    mDOT(); 


                    mINTEGER_NUM(); 


                    }
                    break;
                case 4 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:426:71: INTEGER_NUM
                    {
                    mINTEGER_NUM(); 


                    }
                    break;

            }


            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:427:2: ( ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='E'||LA19_0=='e') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:427:5: ( 'E' | 'e' ) ( PLUS | MINUS )? INTEGER_NUM
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:427:15: ( PLUS | MINUS )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='+'||LA18_0=='-') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:431:5: ( SQUOTE ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )* SQUOTE )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:432:5: SQUOTE ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )* SQUOTE
            {
            mSQUOTE(); 


            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:433:5: ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )*
            loop20:
            do {
                int alt20=4;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:434:9: ( SQUOTE SQUOTE )
            	    {
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:434:9: ( SQUOTE SQUOTE )
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:434:10: SQUOTE SQUOTE
            	    {
            	    mSQUOTE(); 


            	    mSQUOTE(); 


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:435:11: ( '\\\\' '\\'' )
            	    {
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:435:11: ( '\\\\' '\\'' )
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:435:12: '\\\\' '\\''
            	    {
            	    match('\\'); 

            	    match('\''); 

            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:436:11: ~ ( '\\'' )
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
            	    break loop20;
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

            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:441:11: ( DQUOTE cont= ID DQUOTE )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:441:13: DQUOTE cont= ID DQUOTE
            {
            mDQUOTE(); 


            int contStart3312 = getCharIndex();
            int contStartLine3312 = getLine();
            int contStartCharPos3312 = getCharPositionInLine();
            mID(); 
            cont = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, contStart3312, getCharIndex()-1);
            cont.setLine(contStartLine3312);
            cont.setCharPositionInLine(contStartCharPos3312);


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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:4: ( ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )* )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:6: ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:30: ( 'A' .. 'Z' | 'a' .. 'z' | '_' | '0' .. '9' | '::' )*
            loop21:
            do {
                int alt21=6;
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
                    alt21=1;
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
                    alt21=2;
                    }
                    break;
                case '_':
                    {
                    alt21=3;
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
                    alt21=4;
                    }
                    break;
                case ':':
                    {
                    alt21=5;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:32: 'A' .. 'Z'
            	    {
            	    matchRange('A','Z'); 

            	    }
            	    break;
            	case 2 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:43: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

            	    }
            	    break;
            	case 3 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:54: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;
            	case 4 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:61: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;
            	case 5 :
            	    // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:443:72: '::'
            	    {
            	    match("::"); 



            	    }
            	    break;

            	default :
            	    break loop21;
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
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:445:13: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
            // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:445:15: ( ' ' | '\\r' | '\\t' | '\\n' )
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
        // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:8: ( T__183 | ADD_SYM | ALL | ANY | AS_SYM | ASC | AT_SYM | AVG | BETWEEN | BIGINT | BIN | BINARY | BLOB_SYM | BOOL_SYM | BOOLEAN_SYM | BY_SYM | BYTE_SYM | CALL_SYM | CASE_SYM | CHAR | CHAR_LENGTH | CHARACTER_SYM | CHARSET | COLUMN_SYM | COLUMNS_SYM | CONCAT | COUNT | DECIMAL_SYM | DEFAULT | DESC | DISTINCT | DO_SYM | DOUBLE_SYM | EACH_SYM | ELSE_SYM | ELSIF_SYM | END_SYM | EXISTS | FALSE_SYM | FETCH_SYM | FIELD | FILE_SYM | FLOAT_SYM | FOR_SYM | FROM | FULL | FUNCTION_SYM | GROUP_SYM | HAVING | HEX | IF | IFNULL | IGNORE_SYM | IN_SYM | INDEX_SYM | INNER_SYM | INTEGER_SYM | IS_SYM | JOIN_SYM | LEFT | LIMIT | LONG_SYM | LONGBLOB | LONGTEXT | LOWER | MAX_SYM | MEDIUMBLOB | MEDIUMINT | MIN_SYM | NOT_SYM | NULL_SYM | NUMERIC_SYM | OCT | OFFSET_SYM | ON | ORDER_SYM | OUTER | QUOTE | REAL | RIGHT | SELECT | SMALLINT | STRAIGHT_JOIN | STRING_SYM | SUM | THEN_SYM | TIME_SYM | TINYBLOB | TINYINT | TINYTEXT | TRUE_SYM | UNSIGNED_SYM | UPPER | USE_SYM | VARBINARY | VARCHAR | WHEN_SYM | WHERE | XML_SYM | ISNOTNULL | ISNULL | NOT_IN | DIVIDE | MOD_SYM | OR_SYM | AND_SYM | ARROW | EQ_SYM | NOT_EQ | LET | GET | SET_VAR | SHIFT_LEFT | SHIFT_RIGHT | ALL_FIELDS | SQUOTE | DQUOTE | COLONCOLON | DOLLAR | QUESTION | SEMI | COLON | DOT | COMMA | ASTERISK | RPAREN | LPAREN | RBRACK | LBRACK | LCURLY | RCURLY | PLUS | MINUS | NEGATION | VERTBAR | BITAND | POWER_OP | GTH | LTH | INTEGER_NUM | HEX_DIGIT | BIT_NUM | REAL_NUMBER | QUOTED_STRING | QUOTED_ID | ID | WHITE_SPACE )
        int alt22=147;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:10: T__183
                {
                mT__183(); 


                }
                break;
            case 2 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:17: ADD_SYM
                {
                mADD_SYM(); 


                }
                break;
            case 3 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:25: ALL
                {
                mALL(); 


                }
                break;
            case 4 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:29: ANY
                {
                mANY(); 


                }
                break;
            case 5 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:33: AS_SYM
                {
                mAS_SYM(); 


                }
                break;
            case 6 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:40: ASC
                {
                mASC(); 


                }
                break;
            case 7 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:44: AT_SYM
                {
                mAT_SYM(); 


                }
                break;
            case 8 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:51: AVG
                {
                mAVG(); 


                }
                break;
            case 9 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:55: BETWEEN
                {
                mBETWEEN(); 


                }
                break;
            case 10 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:63: BIGINT
                {
                mBIGINT(); 


                }
                break;
            case 11 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:70: BIN
                {
                mBIN(); 


                }
                break;
            case 12 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:74: BINARY
                {
                mBINARY(); 


                }
                break;
            case 13 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:81: BLOB_SYM
                {
                mBLOB_SYM(); 


                }
                break;
            case 14 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:90: BOOL_SYM
                {
                mBOOL_SYM(); 


                }
                break;
            case 15 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:99: BOOLEAN_SYM
                {
                mBOOLEAN_SYM(); 


                }
                break;
            case 16 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:111: BY_SYM
                {
                mBY_SYM(); 


                }
                break;
            case 17 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:118: BYTE_SYM
                {
                mBYTE_SYM(); 


                }
                break;
            case 18 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:127: CALL_SYM
                {
                mCALL_SYM(); 


                }
                break;
            case 19 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:136: CASE_SYM
                {
                mCASE_SYM(); 


                }
                break;
            case 20 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:145: CHAR
                {
                mCHAR(); 


                }
                break;
            case 21 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:150: CHAR_LENGTH
                {
                mCHAR_LENGTH(); 


                }
                break;
            case 22 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:162: CHARACTER_SYM
                {
                mCHARACTER_SYM(); 


                }
                break;
            case 23 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:176: CHARSET
                {
                mCHARSET(); 


                }
                break;
            case 24 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:184: COLUMN_SYM
                {
                mCOLUMN_SYM(); 


                }
                break;
            case 25 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:195: COLUMNS_SYM
                {
                mCOLUMNS_SYM(); 


                }
                break;
            case 26 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:207: CONCAT
                {
                mCONCAT(); 


                }
                break;
            case 27 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:214: COUNT
                {
                mCOUNT(); 


                }
                break;
            case 28 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:220: DECIMAL_SYM
                {
                mDECIMAL_SYM(); 


                }
                break;
            case 29 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:232: DEFAULT
                {
                mDEFAULT(); 


                }
                break;
            case 30 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:240: DESC
                {
                mDESC(); 


                }
                break;
            case 31 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:245: DISTINCT
                {
                mDISTINCT(); 


                }
                break;
            case 32 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:254: DO_SYM
                {
                mDO_SYM(); 


                }
                break;
            case 33 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:261: DOUBLE_SYM
                {
                mDOUBLE_SYM(); 


                }
                break;
            case 34 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:272: EACH_SYM
                {
                mEACH_SYM(); 


                }
                break;
            case 35 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:281: ELSE_SYM
                {
                mELSE_SYM(); 


                }
                break;
            case 36 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:290: ELSIF_SYM
                {
                mELSIF_SYM(); 


                }
                break;
            case 37 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:300: END_SYM
                {
                mEND_SYM(); 


                }
                break;
            case 38 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:308: EXISTS
                {
                mEXISTS(); 


                }
                break;
            case 39 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:315: FALSE_SYM
                {
                mFALSE_SYM(); 


                }
                break;
            case 40 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:325: FETCH_SYM
                {
                mFETCH_SYM(); 


                }
                break;
            case 41 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:335: FIELD
                {
                mFIELD(); 


                }
                break;
            case 42 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:341: FILE_SYM
                {
                mFILE_SYM(); 


                }
                break;
            case 43 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:350: FLOAT_SYM
                {
                mFLOAT_SYM(); 


                }
                break;
            case 44 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:360: FOR_SYM
                {
                mFOR_SYM(); 


                }
                break;
            case 45 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:368: FROM
                {
                mFROM(); 


                }
                break;
            case 46 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:373: FULL
                {
                mFULL(); 


                }
                break;
            case 47 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:378: FUNCTION_SYM
                {
                mFUNCTION_SYM(); 


                }
                break;
            case 48 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:391: GROUP_SYM
                {
                mGROUP_SYM(); 


                }
                break;
            case 49 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:401: HAVING
                {
                mHAVING(); 


                }
                break;
            case 50 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:408: HEX
                {
                mHEX(); 


                }
                break;
            case 51 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:412: IF
                {
                mIF(); 


                }
                break;
            case 52 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:415: IFNULL
                {
                mIFNULL(); 


                }
                break;
            case 53 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:422: IGNORE_SYM
                {
                mIGNORE_SYM(); 


                }
                break;
            case 54 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:433: IN_SYM
                {
                mIN_SYM(); 


                }
                break;
            case 55 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:440: INDEX_SYM
                {
                mINDEX_SYM(); 


                }
                break;
            case 56 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:450: INNER_SYM
                {
                mINNER_SYM(); 


                }
                break;
            case 57 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:460: INTEGER_SYM
                {
                mINTEGER_SYM(); 


                }
                break;
            case 58 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:472: IS_SYM
                {
                mIS_SYM(); 


                }
                break;
            case 59 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:479: JOIN_SYM
                {
                mJOIN_SYM(); 


                }
                break;
            case 60 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:488: LEFT
                {
                mLEFT(); 


                }
                break;
            case 61 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:493: LIMIT
                {
                mLIMIT(); 


                }
                break;
            case 62 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:499: LONG_SYM
                {
                mLONG_SYM(); 


                }
                break;
            case 63 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:508: LONGBLOB
                {
                mLONGBLOB(); 


                }
                break;
            case 64 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:517: LONGTEXT
                {
                mLONGTEXT(); 


                }
                break;
            case 65 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:526: LOWER
                {
                mLOWER(); 


                }
                break;
            case 66 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:532: MAX_SYM
                {
                mMAX_SYM(); 


                }
                break;
            case 67 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:540: MEDIUMBLOB
                {
                mMEDIUMBLOB(); 


                }
                break;
            case 68 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:551: MEDIUMINT
                {
                mMEDIUMINT(); 


                }
                break;
            case 69 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:561: MIN_SYM
                {
                mMIN_SYM(); 


                }
                break;
            case 70 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:569: NOT_SYM
                {
                mNOT_SYM(); 


                }
                break;
            case 71 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:577: NULL_SYM
                {
                mNULL_SYM(); 


                }
                break;
            case 72 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:586: NUMERIC_SYM
                {
                mNUMERIC_SYM(); 


                }
                break;
            case 73 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:598: OCT
                {
                mOCT(); 


                }
                break;
            case 74 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:602: OFFSET_SYM
                {
                mOFFSET_SYM(); 


                }
                break;
            case 75 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:613: ON
                {
                mON(); 


                }
                break;
            case 76 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:616: ORDER_SYM
                {
                mORDER_SYM(); 


                }
                break;
            case 77 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:626: OUTER
                {
                mOUTER(); 


                }
                break;
            case 78 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:632: QUOTE
                {
                mQUOTE(); 


                }
                break;
            case 79 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:638: REAL
                {
                mREAL(); 


                }
                break;
            case 80 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:643: RIGHT
                {
                mRIGHT(); 


                }
                break;
            case 81 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:649: SELECT
                {
                mSELECT(); 


                }
                break;
            case 82 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:656: SMALLINT
                {
                mSMALLINT(); 


                }
                break;
            case 83 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:665: STRAIGHT_JOIN
                {
                mSTRAIGHT_JOIN(); 


                }
                break;
            case 84 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:679: STRING_SYM
                {
                mSTRING_SYM(); 


                }
                break;
            case 85 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:690: SUM
                {
                mSUM(); 


                }
                break;
            case 86 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:694: THEN_SYM
                {
                mTHEN_SYM(); 


                }
                break;
            case 87 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:703: TIME_SYM
                {
                mTIME_SYM(); 


                }
                break;
            case 88 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:712: TINYBLOB
                {
                mTINYBLOB(); 


                }
                break;
            case 89 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:721: TINYINT
                {
                mTINYINT(); 


                }
                break;
            case 90 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:729: TINYTEXT
                {
                mTINYTEXT(); 


                }
                break;
            case 91 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:738: TRUE_SYM
                {
                mTRUE_SYM(); 


                }
                break;
            case 92 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:747: UNSIGNED_SYM
                {
                mUNSIGNED_SYM(); 


                }
                break;
            case 93 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:760: UPPER
                {
                mUPPER(); 


                }
                break;
            case 94 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:766: USE_SYM
                {
                mUSE_SYM(); 


                }
                break;
            case 95 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:774: VARBINARY
                {
                mVARBINARY(); 


                }
                break;
            case 96 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:784: VARCHAR
                {
                mVARCHAR(); 


                }
                break;
            case 97 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:792: WHEN_SYM
                {
                mWHEN_SYM(); 


                }
                break;
            case 98 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:801: WHERE
                {
                mWHERE(); 


                }
                break;
            case 99 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:807: XML_SYM
                {
                mXML_SYM(); 


                }
                break;
            case 100 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:815: ISNOTNULL
                {
                mISNOTNULL(); 


                }
                break;
            case 101 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:825: ISNULL
                {
                mISNULL(); 


                }
                break;
            case 102 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:832: NOT_IN
                {
                mNOT_IN(); 


                }
                break;
            case 103 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:839: DIVIDE
                {
                mDIVIDE(); 


                }
                break;
            case 104 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:846: MOD_SYM
                {
                mMOD_SYM(); 


                }
                break;
            case 105 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:854: OR_SYM
                {
                mOR_SYM(); 


                }
                break;
            case 106 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:861: AND_SYM
                {
                mAND_SYM(); 


                }
                break;
            case 107 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:869: ARROW
                {
                mARROW(); 


                }
                break;
            case 108 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:875: EQ_SYM
                {
                mEQ_SYM(); 


                }
                break;
            case 109 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:882: NOT_EQ
                {
                mNOT_EQ(); 


                }
                break;
            case 110 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:889: LET
                {
                mLET(); 


                }
                break;
            case 111 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:893: GET
                {
                mGET(); 


                }
                break;
            case 112 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:897: SET_VAR
                {
                mSET_VAR(); 


                }
                break;
            case 113 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:905: SHIFT_LEFT
                {
                mSHIFT_LEFT(); 


                }
                break;
            case 114 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:916: SHIFT_RIGHT
                {
                mSHIFT_RIGHT(); 


                }
                break;
            case 115 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:928: ALL_FIELDS
                {
                mALL_FIELDS(); 


                }
                break;
            case 116 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:939: SQUOTE
                {
                mSQUOTE(); 


                }
                break;
            case 117 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:946: DQUOTE
                {
                mDQUOTE(); 


                }
                break;
            case 118 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:953: COLONCOLON
                {
                mCOLONCOLON(); 


                }
                break;
            case 119 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:964: DOLLAR
                {
                mDOLLAR(); 


                }
                break;
            case 120 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:971: QUESTION
                {
                mQUESTION(); 


                }
                break;
            case 121 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:980: SEMI
                {
                mSEMI(); 


                }
                break;
            case 122 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:985: COLON
                {
                mCOLON(); 


                }
                break;
            case 123 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:991: DOT
                {
                mDOT(); 


                }
                break;
            case 124 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:995: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 125 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1001: ASTERISK
                {
                mASTERISK(); 


                }
                break;
            case 126 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1010: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 127 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1017: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 128 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1024: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 129 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1031: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 130 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1038: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 131 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1045: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 132 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1052: PLUS
                {
                mPLUS(); 


                }
                break;
            case 133 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1057: MINUS
                {
                mMINUS(); 


                }
                break;
            case 134 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1063: NEGATION
                {
                mNEGATION(); 


                }
                break;
            case 135 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1072: VERTBAR
                {
                mVERTBAR(); 


                }
                break;
            case 136 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1080: BITAND
                {
                mBITAND(); 


                }
                break;
            case 137 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1087: POWER_OP
                {
                mPOWER_OP(); 


                }
                break;
            case 138 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1096: GTH
                {
                mGTH(); 


                }
                break;
            case 139 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1100: LTH
                {
                mLTH(); 


                }
                break;
            case 140 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1104: INTEGER_NUM
                {
                mINTEGER_NUM(); 


                }
                break;
            case 141 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1116: HEX_DIGIT
                {
                mHEX_DIGIT(); 


                }
                break;
            case 142 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1126: BIT_NUM
                {
                mBIT_NUM(); 


                }
                break;
            case 143 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1134: REAL_NUMBER
                {
                mREAL_NUMBER(); 


                }
                break;
            case 144 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1146: QUOTED_STRING
                {
                mQUOTED_STRING(); 


                }
                break;
            case 145 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1160: QUOTED_ID
                {
                mQUOTED_ID(); 


                }
                break;
            case 146 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1170: ID
                {
                mID(); 


                }
                break;
            case 147 :
                // /home/hpccuser/GIT/hpcc-jdbc/src/org/hpccsystems/jdbcdriver/antlr/grammar/SQLExpression.g:1:1173: WHITE_SPACE
                {
                mWHITE_SPACE(); 


                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA17_eotS =
        "\1\uffff\1\3\2\uffff\1\5\2\uffff";
    static final String DFA17_eofS =
        "\7\uffff";
    static final String DFA17_minS =
        "\2\56\2\uffff\1\60\2\uffff";
    static final String DFA17_maxS =
        "\2\71\2\uffff\1\71\2\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\2\1\1";
    static final String DFA17_specialS =
        "\7\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\1",
            "",
            "",
            "\12\6",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "426:2: ( INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM )";
        }
    }
    static final String DFA20_eotS =
        "\1\uffff\1\4\4\uffff\1\3\1\10\1\uffff\1\3";
    static final String DFA20_eofS =
        "\12\uffff";
    static final String DFA20_minS =
        "\1\0\1\47\1\0\3\uffff\2\0\1\uffff\1\0";
    static final String DFA20_maxS =
        "\1\uffff\1\47\1\uffff\3\uffff\2\uffff\1\uffff\1\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\3\1\4\1\1\2\uffff\1\2\1\uffff";
    static final String DFA20_specialS =
        "\1\1\1\uffff\1\2\3\uffff\1\4\1\0\1\uffff\1\3}>";
    static final String[] DFA20_transitionS = {
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
            return "()* loopback of 433:5: ( ( SQUOTE SQUOTE ) | ( '\\\\' '\\'' ) |~ ( '\\'' ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_7 = input.LA(1);

                        s = -1;
                        if ( (LA20_7=='\'') ) {s = 9;}

                        else if ( ((LA20_7 >= '\u0000' && LA20_7 <= '&')||(LA20_7 >= '(' && LA20_7 <= '\uFFFF')) ) {s = 3;}

                        else s = 8;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA20_0 = input.LA(1);

                        s = -1;
                        if ( (LA20_0=='\'') ) {s = 1;}

                        else if ( (LA20_0=='\\') ) {s = 2;}

                        else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '&')||(LA20_0 >= '(' && LA20_0 <= '[')||(LA20_0 >= ']' && LA20_0 <= '\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA20_2 = input.LA(1);

                        s = -1;
                        if ( (LA20_2=='\'') ) {s = 6;}

                        else if ( ((LA20_2 >= '\u0000' && LA20_2 <= '&')||(LA20_2 >= '(' && LA20_2 <= '\uFFFF')) ) {s = 3;}

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA20_9 = input.LA(1);

                        s = -1;
                        if ( (LA20_9=='\'') ) {s = 7;}

                        else if ( ((LA20_9 >= '\u0000' && LA20_9 <= '&')||(LA20_9 >= '(' && LA20_9 <= '\uFFFF')) ) {s = 8;}

                        else s = 3;

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA20_6 = input.LA(1);

                        s = -1;
                        if ( (LA20_6=='\'') ) {s = 7;}

                        else if ( ((LA20_6 >= '\u0000' && LA20_6 <= '&')||(LA20_6 >= '(' && LA20_6 <= '\uFFFF')) ) {s = 8;}

                        else s = 3;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA22_eotS =
        "\2\uffff\15\66\1\u0096\11\66\2\uffff\1\u00c4\1\u00c6\1\u00c8\1\u00cb"+
        "\1\u00cc\1\u00cd\1\u00d0\1\u00d3\1\u00d5\1\u00d7\1\u00d9\15\uffff"+
        "\2\u00db\1\66\2\uffff\3\66\1\u00e4\1\u00e7\4\66\1\u00e4\1\u00e7"+
        "\5\66\1\u00f4\1\uffff\4\66\1\u00f4\10\66\1\u010d\2\66\1\u010d\34"+
        "\66\1\u0130\1\66\1\u0135\1\u013c\1\u0130\1\66\1\u0135\1\u013c\26"+
        "\66\3\uffff\2\66\1\u015c\1\u00c3\3\66\1\u015c\1\u00c3\37\66\1\uffff"+
        "\2\66\6\uffff\1\u0183\22\uffff\2\u0184\2\u0185\1\u0186\1\u00c5\1"+
        "\u0186\1\u00c5\1\uffff\2\u0187\1\uffff\2\u0188\3\66\1\u018d\1\66"+
        "\1\u018d\4\66\1\uffff\25\66\1\31\1\66\1\31\1\uffff\6\66\2\u01b2"+
        "\14\66\2\u01bf\12\66\2\u01ca\1\uffff\4\66\1\uffff\6\66\2\uffff\14"+
        "\66\2\u01e3\2\66\2\u01e6\2\32\2\u0096\4\66\2\u01eb\2\66\1\uffff"+
        "\20\66\2\u0200\14\66\2\u020d\4\66\2\u0216\6\uffff\4\66\1\uffff\2"+
        "\66\2\u021d\2\u021e\2\u0221\2\u0222\2\u0223\2\u0224\12\66\2\u0234"+
        "\4\66\2\u0239\1\u023a\1\66\1\u023a\1\66\1\uffff\10\66\2\u0245\2"+
        "\66\1\uffff\2\u0248\2\u0249\6\66\1\uffff\12\66\2\uffff\2\u025b\2"+
        "\u025c\2\66\2\u025f\4\66\1\uffff\2\66\1\uffff\2\u026a\2\66\1\uffff"+
        "\10\66\2\u0275\12\66\1\uffff\2\u0280\2\u0281\2\66\2\u0288\4\66\1"+
        "\uffff\4\66\1\u0291\1\66\1\u0291\1\66\1\uffff\6\66\2\uffff\2\66"+
        "\4\uffff\11\66\2\u02a6\4\66\1\uffff\4\66\2\uffff\2\u02af\2\66\2"+
        "\u02b2\2\u02b3\2\u02b4\1\uffff\2\u02b5\2\uffff\2\66\2\u02b8\6\66"+
        "\2\u02bf\2\u02c0\2\66\3\uffff\2\u02c3\1\uffff\4\66\4\u02c8\2\66"+
        "\1\uffff\4\66\2\u02cf\2\u02d0\2\u02d1\1\uffff\2\u02d2\10\66\2\uffff"+
        "\6\66\1\uffff\2\66\2\u02e3\4\66\1\uffff\2\u02e8\2\66\2\u02eb\2\u02ec"+
        "\10\66\2\u02f5\2\u02f8\1\uffff\6\66\2\u02ff\1\uffff\2\u0300\4\uffff"+
        "\2\66\1\uffff\2\u0303\2\u0304\2\u0305\2\uffff\2\66\1\uffff\4\66"+
        "\1\uffff\4\66\2\u0312\4\uffff\2\u0313\4\66\2\u0318\10\66\1\uffff"+
        "\4\66\1\uffff\2\u0325\2\uffff\2\u0326\4\66\2\u032b\1\uffff\2\u032c"+
        "\1\uffff\2\u032d\2\u032e\2\66\2\uffff\2\66\3\uffff\2\u0333\10\66"+
        "\2\u033c\2\uffff\4\66\1\uffff\2\66\2\u0343\6\66\2\u034a\2\uffff"+
        "\4\66\4\uffff\2\u034f\2\u0350\1\uffff\2\u0351\2\u0352\4\66\1\uffff"+
        "\2\u0357\2\66\2\u0359\1\uffff\2\u035a\2\u035b\2\66\1\uffff\2\66"+
        "\2\u0360\4\uffff\2\66\2\u0364\1\uffff\1\66\3\uffff\2\u0367\2\66"+
        "\1\uffff\1\66\2\u036c\1\uffff\2\66\1\uffff\2\u036f\2\66\1\uffff"+
        "\2\66\1\uffff\6\66\2\u037a\2\66\1\uffff\2\66\2\u036f";
    static final String DFA22_eofS =
        "\u037f\uffff";
    static final String DFA22_minS =
        "\1\11\1\uffff\1\104\1\47\1\101\1\105\2\101\1\122\1\101\1\106\1\117"+
        "\1\103\1\101\1\117\1\11\1\103\1\125\2\105\1\110\1\116\1\101\1\110"+
        "\1\47\2\uffff\1\174\1\46\1\76\1\74\3\75\1\72\1\52\1\0\1\101\15\uffff"+
        "\2\56\1\115\2\uffff\1\104\1\114\1\104\2\60\1\107\1\104\1\114\1\104"+
        "\2\60\1\107\1\124\1\107\2\117\1\60\1\uffff\1\124\1\107\2\117\1\60"+
        "\1\114\1\101\2\114\1\101\1\114\1\103\1\123\1\60\1\103\1\123\1\60"+
        "\1\103\1\123\1\104\1\111\1\103\1\123\1\104\1\111\1\114\1\124\1\105"+
        "\1\117\1\122\1\117\2\114\1\124\1\105\1\117\1\122\1\117\1\114\2\117"+
        "\1\126\1\130\1\126\1\130\1\60\1\116\1\60\1\11\1\60\1\116\1\60\1"+
        "\11\2\111\1\106\1\115\1\116\1\101\1\106\1\115\1\116\1\101\1\130"+
        "\1\104\1\116\1\104\1\130\1\104\1\116\1\104\1\124\1\114\1\124\1\114"+
        "\3\uffff\1\124\1\106\2\60\2\124\1\106\2\60\1\124\2\117\1\101\1\107"+
        "\1\101\1\107\1\114\1\101\1\122\1\115\1\114\1\101\1\122\1\115\1\105"+
        "\1\115\1\125\1\105\1\115\1\125\1\123\1\120\1\105\1\123\1\120\1\105"+
        "\2\122\2\105\1\uffff\2\114\6\uffff\1\76\22\uffff\10\60\1\uffff\2"+
        "\60\1\uffff\2\60\2\127\1\111\1\60\1\111\1\60\2\102\2\114\1\uffff"+
        "\2\105\1\114\1\105\1\114\1\105\2\122\1\125\1\103\1\116\1\125\1\103"+
        "\1\116\1\111\1\101\1\103\1\111\1\101\1\103\1\124\1\60\1\124\1\60"+
        "\1\uffff\2\102\2\110\2\105\2\60\4\123\2\103\1\114\1\105\1\114\1"+
        "\105\2\101\2\60\2\115\1\114\1\103\1\114\1\103\2\125\2\111\2\60\1"+
        "\uffff\2\125\2\117\1\uffff\6\105\1\uffff\1\41\2\116\2\124\2\111"+
        "\1\107\1\105\1\107\1\105\2\123\2\60\2\111\4\60\2\11\1\114\1\105"+
        "\1\114\1\105\2\60\2\123\1\uffff\4\105\2\124\2\114\2\110\2\105\2"+
        "\114\2\101\2\60\2\116\1\105\1\131\1\105\1\131\2\105\2\111\2\105"+
        "\2\60\2\102\2\116\2\60\6\uffff\2\105\2\116\1\uffff\2\122\14\60\2"+
        "\115\2\101\2\124\2\115\2\125\2\60\2\111\2\114\3\60\1\106\1\60\1"+
        "\106\1\uffff\2\124\2\105\2\110\2\104\2\60\2\124\1\uffff\4\60\2\124"+
        "\2\120\2\116\1\uffff\2\114\2\122\2\130\2\122\2\107\1\117\1\uffff"+
        "\4\60\2\124\2\60\2\122\2\105\1\uffff\2\125\1\uffff\2\60\2\122\1"+
        "\uffff\2\105\4\122\2\105\2\60\2\124\2\103\2\114\1\111\1\116\1\111"+
        "\1\116\1\uffff\4\60\2\102\2\60\2\107\2\122\1\uffff\1\111\1\110\1"+
        "\111\1\110\1\60\1\105\1\60\1\105\1\uffff\2\105\2\124\2\131\2\uffff"+
        "\2\101\4\uffff\1\114\1\103\1\105\1\103\1\105\2\116\2\124\2\60\2"+
        "\101\2\114\1\uffff\2\116\2\105\2\uffff\2\60\2\123\6\60\1\uffff\2"+
        "\60\2\uffff\2\111\2\60\2\107\2\114\2\105\4\60\2\105\3\uffff\2\60"+
        "\1\uffff\1\114\1\105\1\114\1\105\4\60\2\115\1\uffff\2\111\2\124"+
        "\6\60\1\uffff\2\60\2\124\2\111\4\107\2\uffff\1\114\1\116\1\105\1"+
        "\114\1\116\1\105\1\uffff\2\116\2\60\2\116\2\101\1\uffff\2\60\2\116"+
        "\4\60\2\116\2\105\4\124\4\60\1\uffff\2\114\2\124\2\103\2\60\1\uffff"+
        "\2\60\4\uffff\2\117\1\uffff\6\60\2\uffff\2\122\1\uffff\2\117\2\130"+
        "\1\uffff\2\102\2\103\2\60\4\uffff\2\60\2\116\2\110\2\60\2\117\2"+
        "\124\2\130\2\105\1\uffff\2\101\2\122\1\uffff\2\60\2\uffff\2\60\2"+
        "\116\2\105\2\60\1\uffff\2\60\1\uffff\4\60\2\124\2\uffff\2\116\3"+
        "\uffff\2\60\2\102\2\124\1\114\1\116\1\114\1\116\2\60\2\uffff\4\124"+
        "\1\uffff\2\102\2\60\2\124\2\104\2\122\2\60\2\uffff\2\107\2\122\4"+
        "\uffff\4\60\1\uffff\4\60\2\117\2\124\1\uffff\2\60\2\137\2\60\1\uffff"+
        "\4\60\2\131\1\uffff\2\124\2\60\4\uffff\2\102\2\60\1\uffff\1\112"+
        "\3\uffff\2\60\2\110\1\uffff\1\114\2\60\1\uffff\2\117\1\uffff\2\60"+
        "\2\105\1\uffff\2\111\1\uffff\4\116\2\107\2\60\2\124\1\uffff\2\110"+
        "\2\60";
    static final String DFA22_maxS =
        "\1\176\1\uffff\1\166\1\171\2\157\1\170\1\165\1\162\1\145\1\163\3"+
        "\157\1\165\1\75\2\165\1\151\1\165\1\162\1\163\1\141\1\150\1\155"+
        "\2\uffff\1\174\1\46\2\76\2\75\1\76\1\75\1\71\1\uffff\1\172\15\uffff"+
        "\1\170\1\145\1\155\2\uffff\1\144\1\154\1\171\2\172\1\147\1\144\1"+
        "\154\1\171\2\172\1\147\1\164\1\156\2\157\1\172\1\uffff\1\164\1\156"+
        "\2\157\1\172\1\163\1\141\1\165\1\163\1\141\1\165\1\163\1\166\1\172"+
        "\1\163\1\166\1\172\1\143\1\163\1\144\1\151\1\143\1\163\1\144\1\151"+
        "\1\154\1\164\1\154\1\157\1\162\1\157\1\156\1\154\1\164\1\154\1\157"+
        "\1\162\1\157\1\156\2\157\1\166\1\170\1\166\1\170\1\172\1\156\3\172"+
        "\1\156\2\172\2\151\1\146\1\155\1\167\1\141\1\146\1\155\1\167\1\141"+
        "\1\170\1\144\1\156\1\144\1\170\1\144\1\156\1\144\1\164\1\155\1\164"+
        "\1\155\3\uffff\1\164\1\146\2\172\2\164\1\146\2\172\1\164\2\157\1"+
        "\141\1\147\1\141\1\147\1\154\1\141\1\162\1\155\1\154\1\141\1\162"+
        "\1\155\1\145\1\156\1\165\1\145\1\156\1\165\1\163\1\160\1\145\1\163"+
        "\1\160\1\145\2\162\2\145\1\uffff\2\154\6\uffff\1\76\22\uffff\10"+
        "\172\1\uffff\2\172\1\uffff\2\172\2\167\1\151\1\172\1\151\1\172\2"+
        "\142\2\154\1\uffff\2\145\1\154\1\145\1\154\1\145\2\162\1\165\1\143"+
        "\1\156\1\165\1\143\1\156\1\151\1\141\1\143\1\151\1\141\1\143\1\164"+
        "\1\172\1\164\1\172\1\uffff\2\142\2\150\2\151\2\172\4\163\2\143\1"+
        "\154\1\145\1\154\1\145\2\141\2\172\2\155\1\154\1\143\1\154\1\143"+
        "\2\165\2\151\2\172\1\uffff\2\165\2\157\1\uffff\6\145\1\uffff\3\156"+
        "\2\164\2\151\1\147\1\145\1\147\1\145\2\163\2\172\2\151\6\172\1\154"+
        "\1\145\1\154\1\145\2\172\2\163\1\uffff\4\145\2\164\2\154\2\150\2"+
        "\145\2\154\2\151\2\172\2\156\1\145\1\171\1\145\1\171\2\145\2\151"+
        "\2\145\2\172\2\143\2\162\2\172\6\uffff\2\145\2\156\1\uffff\2\162"+
        "\14\172\2\155\2\141\2\164\2\155\2\165\2\172\2\151\2\154\3\172\1"+
        "\146\1\172\1\146\1\uffff\2\164\2\145\2\150\2\144\2\172\2\164\1\uffff"+
        "\4\172\2\164\2\160\2\156\1\uffff\2\154\2\162\2\170\2\162\2\147\1"+
        "\165\1\uffff\4\172\2\164\2\172\2\162\2\145\1\uffff\2\165\1\uffff"+
        "\2\172\2\162\1\uffff\2\145\4\162\2\145\2\172\2\164\2\143\2\154\1"+
        "\151\1\156\1\151\1\156\1\uffff\4\172\2\164\2\172\2\147\2\162\1\uffff"+
        "\1\151\1\150\1\151\1\150\1\172\1\145\1\172\1\145\1\uffff\2\145\2"+
        "\164\2\171\2\uffff\2\141\4\uffff\1\154\1\143\1\145\1\143\1\145\2"+
        "\156\2\164\2\172\2\141\2\154\1\uffff\2\156\2\145\2\uffff\2\172\2"+
        "\163\6\172\1\uffff\2\172\2\uffff\2\151\2\172\2\147\2\154\2\145\4"+
        "\172\2\145\3\uffff\2\172\1\uffff\1\154\1\145\1\154\1\145\4\172\2"+
        "\155\1\uffff\2\151\2\164\6\172\1\uffff\2\172\2\164\2\151\4\147\2"+
        "\uffff\1\154\1\156\1\145\1\154\1\156\1\145\1\uffff\2\156\2\172\2"+
        "\156\2\141\1\uffff\2\172\2\156\4\172\2\156\2\145\4\164\4\172\1\uffff"+
        "\2\154\2\164\2\143\2\172\1\uffff\2\172\4\uffff\2\157\1\uffff\6\172"+
        "\2\uffff\2\162\1\uffff\2\157\2\170\1\uffff\2\151\2\143\2\172\4\uffff"+
        "\2\172\2\156\2\150\2\172\2\157\2\164\2\170\2\145\1\uffff\2\141\2"+
        "\162\1\uffff\2\172\2\uffff\2\172\2\156\2\145\2\172\1\uffff\2\172"+
        "\1\uffff\4\172\2\164\2\uffff\2\156\3\uffff\2\172\2\142\2\164\1\154"+
        "\1\156\1\154\1\156\2\172\2\uffff\4\164\1\uffff\2\142\2\172\2\164"+
        "\2\144\2\162\2\172\2\uffff\2\147\2\162\4\uffff\4\172\1\uffff\4\172"+
        "\2\157\2\164\1\uffff\2\172\2\137\2\172\1\uffff\4\172\2\171\1\uffff"+
        "\2\164\2\172\4\uffff\2\142\2\172\1\uffff\1\152\3\uffff\2\172\2\150"+
        "\1\uffff\1\154\2\172\1\uffff\2\157\1\uffff\2\172\2\145\1\uffff\2"+
        "\151\1\uffff\4\156\2\147\2\172\2\164\1\uffff\2\150\2\172";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\27\uffff\1\147\1\150\13\uffff\1\167\1\170\1\171\1\174"+
        "\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085"+
        "\3\uffff\1\u0092\1\u0093\21\uffff\1\u008e\113\uffff\1\155\1\106"+
        "\1\146\50\uffff\1\u008d\2\uffff\1\151\1\u0087\1\152\1\u0088\1\153"+
        "\1\154\1\uffff\1\161\1\u008b\1\u0086\1\u0089\1\157\1\162\1\u008a"+
        "\1\160\1\166\1\172\1\163\1\173\1\u008f\1\164\1\u0090\1\165\1\u0091"+
        "\1\u008c\10\uffff\1\5\2\uffff\1\7\14\uffff\1\20\30\uffff\1\40\42"+
        "\uffff\1\63\4\uffff\1\66\6\uffff\1\72\37\uffff\1\113\46\uffff\1"+
        "\156\1\2\1\3\1\4\1\6\1\10\4\uffff\1\13\44\uffff\1\45\14\uffff\1"+
        "\54\12\uffff\1\62\13\uffff\1\144\14\uffff\1\102\2\uffff\1\105\4"+
        "\uffff\1\111\24\uffff\1\125\14\uffff\1\136\10\uffff\1\143\6\uffff"+
        "\1\15\1\16\2\uffff\1\21\1\22\1\23\1\24\17\uffff\1\36\4\uffff\1\42"+
        "\1\43\12\uffff\1\52\2\uffff\1\55\1\56\20\uffff\1\145\1\73\1\74\2"+
        "\uffff\1\76\12\uffff\1\107\12\uffff\1\117\12\uffff\1\126\1\127\6"+
        "\uffff\1\133\10\uffff\1\141\24\uffff\1\33\10\uffff\1\44\2\uffff"+
        "\1\47\1\50\1\51\1\53\2\uffff\1\60\6\uffff\1\67\1\70\2\uffff\1\75"+
        "\4\uffff\1\101\6\uffff\1\114\1\115\1\116\1\120\20\uffff\1\135\4"+
        "\uffff\1\142\2\uffff\1\12\1\14\10\uffff\1\30\2\uffff\1\32\6\uffff"+
        "\1\41\1\46\2\uffff\1\61\1\64\1\65\14\uffff\1\112\1\121\4\uffff\1"+
        "\124\14\uffff\1\11\1\17\4\uffff\1\27\1\31\1\34\1\35\4\uffff\1\71"+
        "\10\uffff\1\110\6\uffff\1\131\6\uffff\1\140\4\uffff\1\37\1\57\1"+
        "\77\1\100\4\uffff\1\122\1\uffff\1\130\1\132\1\134\4\uffff\1\26\3"+
        "\uffff\1\104\2\uffff\1\137\4\uffff\1\103\2\uffff\1\25\12\uffff\1"+
        "\123\4\uffff";
    static final String DFA22_specialS =
        "\44\uffff\1\0\u035a\uffff}>";
    static final String[] DFA22_transitionS = {
            "\2\67\2\uffff\1\67\22\uffff\1\67\1\17\1\45\1\uffff\1\46\1\32"+
            "\1\34\1\44\1\54\1\53\1\52\1\61\1\51\1\62\1\43\1\31\1\63\11\64"+
            "\1\42\1\50\1\36\1\35\1\41\1\47\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1"+
            "\10\1\11\1\12\1\13\1\66\1\14\1\15\1\16\1\20\1\66\1\21\1\22\1"+
            "\23\1\24\1\25\1\26\1\27\1\30\2\66\1\56\1\uffff\1\55\1\40\2\uffff"+
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\66\1\14\1\15"+
            "\1\16\1\20\1\66\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\65\2\66"+
            "\1\57\1\33\1\60\1\37",
            "",
            "\1\70\7\uffff\1\71\1\uffff\1\72\4\uffff\1\73\1\74\1\uffff\1"+
            "\75\15\uffff\1\76\7\uffff\1\77\1\uffff\1\100\4\uffff\1\101\1"+
            "\102\1\uffff\1\103",
            "\1\111\35\uffff\1\104\3\uffff\1\105\2\uffff\1\106\2\uffff\1"+
            "\107\11\uffff\1\110\13\uffff\1\112\3\uffff\1\113\2\uffff\1\114"+
            "\2\uffff\1\115\11\uffff\1\116",
            "\1\117\6\uffff\1\120\6\uffff\1\121\21\uffff\1\122\6\uffff\1"+
            "\123\6\uffff\1\124",
            "\1\125\3\uffff\1\126\5\uffff\1\127\25\uffff\1\130\3\uffff\1"+
            "\131\5\uffff\1\132",
            "\1\133\12\uffff\1\134\1\uffff\1\135\11\uffff\1\136\10\uffff"+
            "\1\137\12\uffff\1\140\1\uffff\1\141\11\uffff\1\142",
            "\1\143\3\uffff\1\144\3\uffff\1\145\2\uffff\1\146\2\uffff\1"+
            "\147\2\uffff\1\150\2\uffff\1\151\13\uffff\1\152\3\uffff\1\153"+
            "\3\uffff\1\154\2\uffff\1\155\2\uffff\1\156\2\uffff\1\157\2\uffff"+
            "\1\160",
            "\1\161\37\uffff\1\162",
            "\1\163\3\uffff\1\164\33\uffff\1\165\3\uffff\1\166",
            "\1\167\1\170\6\uffff\1\171\4\uffff\1\172\22\uffff\1\173\1\174"+
            "\6\uffff\1\175\4\uffff\1\176",
            "\1\177\37\uffff\1\u0080",
            "\1\u0084\1\uffff\1\u0081\3\uffff\1\u0082\5\uffff\1\u0083\23"+
            "\uffff\1\u0088\1\uffff\1\u0085\3\uffff\1\u0086\5\uffff\1\u0087",
            "\1\u0089\3\uffff\1\u008a\3\uffff\1\u008b\5\uffff\1\u008c\21"+
            "\uffff\1\u008d\3\uffff\1\u008e\3\uffff\1\u008f\5\uffff\1\u0090",
            "\1\u0091\5\uffff\1\u0092\31\uffff\1\u0093\5\uffff\1\u0094",
            "\2\u0097\2\uffff\1\u0097\22\uffff\1\u0097\34\uffff\1\u0095",
            "\1\u0098\2\uffff\1\u0099\7\uffff\1\u009a\3\uffff\1\u009b\2"+
            "\uffff\1\u009c\15\uffff\1\u009d\2\uffff\1\u009e\7\uffff\1\u009f"+
            "\3\uffff\1\u00a0\2\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a3",
            "\1\u00a4\3\uffff\1\u00a5\33\uffff\1\u00a6\3\uffff\1\u00a7",
            "\1\u00a8\7\uffff\1\u00a9\6\uffff\1\u00aa\1\u00ab\17\uffff\1"+
            "\u00ac\7\uffff\1\u00ad\6\uffff\1\u00ae\1\u00af",
            "\1\u00b0\1\u00b1\10\uffff\1\u00b2\25\uffff\1\u00b3\1\u00b4"+
            "\10\uffff\1\u00b5",
            "\1\u00b6\1\uffff\1\u00b7\2\uffff\1\u00b8\32\uffff\1\u00b9\1"+
            "\uffff\1\u00ba\2\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00bf",
            "\1\u00c0\45\uffff\1\u00c1\37\uffff\1\u00c2",
            "",
            "",
            "\1\u00c3",
            "\1\u00c5",
            "\1\u00c7",
            "\1\u00ca\1\u00c9\1\u0095",
            "\1\u0095",
            "\1\u0095",
            "\1\u00ce\1\u00cf",
            "\1\u00d2\2\uffff\1\u00d1",
            "\1\u00d4\5\uffff\12\u00d6",
            "\0\u00d8",
            "\32\u00da\6\uffff\32\u00da",
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
            "\1\u00d6\1\uffff\12\64\13\uffff\1\u00d6\34\uffff\1\111\2\uffff"+
            "\1\u00d6\22\uffff\1\u00c0",
            "\1\u00d6\1\uffff\12\64\13\uffff\1\u00d6\37\uffff\1\u00d6",
            "\1\u00c1\37\uffff\1\u00c2",
            "",
            "",
            "\1\u00dc\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00df",
            "\1\u00e1\24\uffff\1\u00e0\12\uffff\1\u00e3\24\uffff\1\u00e2",
            "\13\66\6\uffff\2\66\1\u00e5\27\66\4\uffff\1\66\1\uffff\2\66"+
            "\1\u00e6\27\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00e8\37\uffff\1\u00e9",
            "\1\u00dc\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00df",
            "\1\u00e1\24\uffff\1\u00e0\12\uffff\1\u00e3\24\uffff\1\u00e2",
            "\13\66\6\uffff\2\66\1\u00e5\27\66\4\uffff\1\66\1\uffff\2\66"+
            "\1\u00e6\27\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00e8\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00eb",
            "\1\u00ec\6\uffff\1\u00ed\30\uffff\1\u00ee\6\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f3",
            "\13\66\6\uffff\23\66\1\u00f5\6\66\4\uffff\1\66\1\uffff\23\66"+
            "\1\u00f6\6\66",
            "",
            "\1\u00ea\37\uffff\1\u00eb",
            "\1\u00ec\6\uffff\1\u00ed\30\uffff\1\u00ee\6\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f3",
            "\13\66\6\uffff\23\66\1\u00f5\6\66\4\uffff\1\66\1\uffff\23\66"+
            "\1\u00f6\6\66",
            "\1\u00f7\6\uffff\1\u00f8\30\uffff\1\u00f9\6\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fc",
            "\1\u00fd\1\uffff\1\u00fe\6\uffff\1\u00ff\26\uffff\1\u0100\1"+
            "\uffff\1\u0101\6\uffff\1\u0102",
            "\1\u00f7\6\uffff\1\u00f8\30\uffff\1\u00f9\6\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fc",
            "\1\u00fd\1\uffff\1\u00fe\6\uffff\1\u00ff\26\uffff\1\u0100\1"+
            "\uffff\1\u0101\6\uffff\1\u0102",
            "\1\u0103\2\uffff\1\u0104\14\uffff\1\u0105\17\uffff\1\u0106"+
            "\2\uffff\1\u0107\14\uffff\1\u0108",
            "\1\u0109\2\uffff\1\u010a\34\uffff\1\u010b\2\uffff\1\u010c",
            "\13\66\6\uffff\24\66\1\u010e\5\66\4\uffff\1\66\1\uffff\24\66"+
            "\1\u010f\5\66",
            "\1\u0103\2\uffff\1\u0104\14\uffff\1\u0105\17\uffff\1\u0106"+
            "\2\uffff\1\u0107\14\uffff\1\u0108",
            "\1\u0109\2\uffff\1\u010a\34\uffff\1\u010b\2\uffff\1\u010c",
            "\13\66\6\uffff\24\66\1\u010e\5\66\4\uffff\1\66\1\uffff\24\66"+
            "\1\u010f\5\66",
            "\1\u0110\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0113",
            "\1\u0114\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0117",
            "\1\u0110\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0113",
            "\1\u0114\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011b",
            "\1\u011c\6\uffff\1\u011d\30\uffff\1\u011e\6\uffff\1\u011f",
            "\1\u0120\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0125",
            "\1\u0126\1\uffff\1\u0127\35\uffff\1\u0128\1\uffff\1\u0129",
            "\1\u0118\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011b",
            "\1\u011c\6\uffff\1\u011d\30\uffff\1\u011e\6\uffff\1\u011f",
            "\1\u0120\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0125",
            "\1\u0126\1\uffff\1\u0127\35\uffff\1\u0128\1\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012b",
            "\1\u012a\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012f",
            "\1\u012c\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012f",
            "\13\66\6\uffff\15\66\1\u0131\14\66\4\uffff\1\66\1\uffff\15"+
            "\66\1\u0132\14\66",
            "\1\u0133\37\uffff\1\u0134",
            "\13\66\6\uffff\3\66\1\u0136\11\66\1\u0137\5\66\1\u0138\6\66"+
            "\4\uffff\1\66\1\uffff\3\66\1\u0139\11\66\1\u013a\5\66\1\u013b"+
            "\6\66",
            "\2\u013d\2\uffff\1\u013d\22\uffff\1\u013d\17\uffff\13\66\6"+
            "\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\15\66\1\u0131\14\66\4\uffff\1\66\1\uffff\15"+
            "\66\1\u0132\14\66",
            "\1\u0133\37\uffff\1\u0134",
            "\13\66\6\uffff\3\66\1\u0136\11\66\1\u0137\5\66\1\u0138\6\66"+
            "\4\uffff\1\66\1\uffff\3\66\1\u0139\11\66\1\u013a\5\66\1\u013b"+
            "\6\66",
            "\2\u013d\2\uffff\1\u013d\22\uffff\1\u013d\17\uffff\13\66\6"+
            "\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u013e\37\uffff\1\u013f",
            "\1\u013e\37\uffff\1\u013f",
            "\1\u0140\37\uffff\1\u0141",
            "\1\u0142\37\uffff\1\u0143",
            "\1\u0144\10\uffff\1\u0145\26\uffff\1\u0146\10\uffff\1\u0147",
            "\1\u0148\37\uffff\1\u0149",
            "\1\u0140\37\uffff\1\u0141",
            "\1\u0142\37\uffff\1\u0143",
            "\1\u0144\10\uffff\1\u0145\26\uffff\1\u0146\10\uffff\1\u0147",
            "\1\u0148\37\uffff\1\u0149",
            "\1\u014a\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0151",
            "\1\u014a\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0151",
            "\1\u0152\37\uffff\1\u0153",
            "\1\u0154\1\u0155\36\uffff\1\u0156\1\u0157",
            "\1\u0152\37\uffff\1\u0153",
            "\1\u0154\1\u0155\36\uffff\1\u0156\1\u0157",
            "",
            "",
            "",
            "\1\u0158\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015b",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\3\66\1\u015d\26\66\4\uffff\1\66\1\uffff\3\66"+
            "\1\u015e\26\66",
            "\1\u015f\37\uffff\1\u0160",
            "\1\u0158\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015b",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\3\66\1\u015d\26\66\4\uffff\1\66\1\uffff\3\66"+
            "\1\u015e\26\66",
            "\1\u015f\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0162",
            "\1\u0161\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0164",
            "\1\u0165\37\uffff\1\u0166",
            "\1\u0163\37\uffff\1\u0164",
            "\1\u0165\37\uffff\1\u0166",
            "\1\u0167\37\uffff\1\u0168",
            "\1\u0169\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016e",
            "\1\u0167\37\uffff\1\u0168",
            "\1\u0169\37\uffff\1\u016a",
            "\1\u016b\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016e",
            "\1\u016f\37\uffff\1\u0170",
            "\1\u0171\1\u0172\36\uffff\1\u0173\1\u0174",
            "\1\u0175\37\uffff\1\u0176",
            "\1\u016f\37\uffff\1\u0170",
            "\1\u0171\1\u0172\36\uffff\1\u0173\1\u0174",
            "\1\u0175\37\uffff\1\u0176",
            "\1\u0177\37\uffff\1\u0178",
            "\1\u0179\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017c",
            "\1\u0177\37\uffff\1\u0178",
            "\1\u0179\37\uffff\1\u017a",
            "\1\u017b\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017e",
            "\1\u017d\37\uffff\1\u017e",
            "\1\u017f\37\uffff\1\u0180",
            "\1\u017f\37\uffff\1\u0180",
            "",
            "\1\u0181\37\uffff\1\u0182",
            "\1\u0181\37\uffff\1\u0182",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c8",
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
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0189\37\uffff\1\u018a",
            "\1\u0189\37\uffff\1\u018a",
            "\1\u018b\37\uffff\1\u018c",
            "\13\66\6\uffff\1\u018e\31\66\4\uffff\1\66\1\uffff\1\u018f\31"+
            "\66",
            "\1\u018b\37\uffff\1\u018c",
            "\13\66\6\uffff\1\u018e\31\66\4\uffff\1\66\1\uffff\1\u018f\31"+
            "\66",
            "\1\u0190\37\uffff\1\u0191",
            "\1\u0190\37\uffff\1\u0191",
            "\1\u0192\37\uffff\1\u0193",
            "\1\u0192\37\uffff\1\u0193",
            "",
            "\1\u0194\37\uffff\1\u0195",
            "\1\u0194\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0197",
            "\1\u0198\37\uffff\1\u0199",
            "\1\u0196\37\uffff\1\u0197",
            "\1\u0198\37\uffff\1\u0199",
            "\1\u019a\37\uffff\1\u019b",
            "\1\u019a\37\uffff\1\u019b",
            "\1\u019c\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a1",
            "\1\u019c\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019f",
            "\1\u01a0\37\uffff\1\u01a1",
            "\1\u01a2\37\uffff\1\u01a3",
            "\1\u01a4\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a7",
            "\1\u01a2\37\uffff\1\u01a3",
            "\1\u01a4\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a7",
            "\1\u01a8\37\uffff\1\u01a9",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01a8\37\uffff\1\u01a9",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01aa\37\uffff\1\u01ab",
            "\1\u01aa\37\uffff\1\u01ab",
            "\1\u01ac\37\uffff\1\u01ad",
            "\1\u01ac\37\uffff\1\u01ad",
            "\1\u01ae\3\uffff\1\u01af\33\uffff\1\u01b0\3\uffff\1\u01b1",
            "\1\u01ae\3\uffff\1\u01af\33\uffff\1\u01b0\3\uffff\1\u01b1",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01b3\37\uffff\1\u01b4",
            "\1\u01b3\37\uffff\1\u01b4",
            "\1\u01b5\37\uffff\1\u01b6",
            "\1\u01b5\37\uffff\1\u01b6",
            "\1\u01b7\37\uffff\1\u01b8",
            "\1\u01b7\37\uffff\1\u01b8",
            "\1\u01b9\37\uffff\1\u01ba",
            "\1\u01bb\37\uffff\1\u01bc",
            "\1\u01b9\37\uffff\1\u01ba",
            "\1\u01bb\37\uffff\1\u01bc",
            "\1\u01bd\37\uffff\1\u01be",
            "\1\u01bd\37\uffff\1\u01be",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01c0\37\uffff\1\u01c1",
            "\1\u01c0\37\uffff\1\u01c1",
            "\1\u01c2\37\uffff\1\u01c3",
            "\1\u01c4\37\uffff\1\u01c5",
            "\1\u01c2\37\uffff\1\u01c3",
            "\1\u01c4\37\uffff\1\u01c5",
            "\1\u01c6\37\uffff\1\u01c7",
            "\1\u01c6\37\uffff\1\u01c7",
            "\1\u01c8\37\uffff\1\u01c9",
            "\1\u01c8\37\uffff\1\u01c9",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01cb\37\uffff\1\u01cc",
            "\1\u01cb\37\uffff\1\u01cc",
            "\1\u01cd\37\uffff\1\u01ce",
            "\1\u01cd\37\uffff\1\u01ce",
            "",
            "\1\u01cf\37\uffff\1\u01d0",
            "\1\u01d1\37\uffff\1\u01d2",
            "\1\u01d3\37\uffff\1\u01d4",
            "\1\u01cf\37\uffff\1\u01d0",
            "\1\u01d1\37\uffff\1\u01d2",
            "\1\u01d3\37\uffff\1\u01d4",
            "",
            "\1\u01d6\54\uffff\1\u01d5\37\uffff\1\u01d5",
            "\1\u01d7\37\uffff\1\u01d8",
            "\1\u01d7\37\uffff\1\u01d8",
            "\1\u01d9\37\uffff\1\u01da",
            "\1\u01d9\37\uffff\1\u01da",
            "\1\u01db\37\uffff\1\u01dc",
            "\1\u01db\37\uffff\1\u01dc",
            "\1\u01dd\37\uffff\1\u01de",
            "\1\u01df\37\uffff\1\u01e0",
            "\1\u01dd\37\uffff\1\u01de",
            "\1\u01df\37\uffff\1\u01e0",
            "\1\u01e1\37\uffff\1\u01e2",
            "\1\u01e1\37\uffff\1\u01e2",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01e4\37\uffff\1\u01e5",
            "\1\u01e4\37\uffff\1\u01e5",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\2\u0097\2\uffff\1\u0097\22\uffff\1\u0097\17\uffff\13\66\6"+
            "\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\2\u0097\2\uffff\1\u0097\22\uffff\1\u0097\17\uffff\13\66\6"+
            "\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01e7\37\uffff\1\u01e8",
            "\1\u01e9\37\uffff\1\u01ea",
            "\1\u01e7\37\uffff\1\u01e8",
            "\1\u01e9\37\uffff\1\u01ea",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01ec\37\uffff\1\u01ed",
            "\1\u01ec\37\uffff\1\u01ed",
            "",
            "\1\u01ee\37\uffff\1\u01ef",
            "\1\u01ee\37\uffff\1\u01ef",
            "\1\u01f0\37\uffff\1\u01f1",
            "\1\u01f0\37\uffff\1\u01f1",
            "\1\u01f2\37\uffff\1\u01f3",
            "\1\u01f2\37\uffff\1\u01f3",
            "\1\u01f4\37\uffff\1\u01f5",
            "\1\u01f4\37\uffff\1\u01f5",
            "\1\u01f6\37\uffff\1\u01f7",
            "\1\u01f6\37\uffff\1\u01f7",
            "\1\u01f8\37\uffff\1\u01f9",
            "\1\u01f8\37\uffff\1\u01f9",
            "\1\u01fa\37\uffff\1\u01fb",
            "\1\u01fa\37\uffff\1\u01fb",
            "\1\u01fc\7\uffff\1\u01fd\27\uffff\1\u01fe\7\uffff\1\u01ff",
            "\1\u01fc\7\uffff\1\u01fd\27\uffff\1\u01fe\7\uffff\1\u01ff",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0201\37\uffff\1\u0202",
            "\1\u0201\37\uffff\1\u0202",
            "\1\u0203\37\uffff\1\u0204",
            "\1\u0205\37\uffff\1\u0206",
            "\1\u0203\37\uffff\1\u0204",
            "\1\u0205\37\uffff\1\u0206",
            "\1\u0207\37\uffff\1\u0208",
            "\1\u0207\37\uffff\1\u0208",
            "\1\u0209\37\uffff\1\u020a",
            "\1\u0209\37\uffff\1\u020a",
            "\1\u020b\37\uffff\1\u020c",
            "\1\u020b\37\uffff\1\u020c",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u020e\1\u020f\36\uffff\1\u0210\1\u0211",
            "\1\u020e\1\u020f\36\uffff\1\u0210\1\u0211",
            "\1\u0212\3\uffff\1\u0213\33\uffff\1\u0214\3\uffff\1\u0215",
            "\1\u0212\3\uffff\1\u0213\33\uffff\1\u0214\3\uffff\1\u0215",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0217\37\uffff\1\u0218",
            "\1\u0217\37\uffff\1\u0218",
            "\1\u0219\37\uffff\1\u021a",
            "\1\u0219\37\uffff\1\u021a",
            "",
            "\1\u021b\37\uffff\1\u021c",
            "\1\u021b\37\uffff\1\u021c",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\4\66\1\u021f\25\66\4\uffff\1\66\1\uffff\4\66"+
            "\1\u0220\25\66",
            "\13\66\6\uffff\4\66\1\u021f\25\66\4\uffff\1\66\1\uffff\4\66"+
            "\1\u0220\25\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\1\u0226\21\66\1\u0227\7\66\4\uffff\1\u0225\1"+
            "\uffff\1\u0228\21\66\1\u0229\7\66",
            "\13\66\6\uffff\1\u0226\21\66\1\u0227\7\66\4\uffff\1\u0225\1"+
            "\uffff\1\u0228\21\66\1\u0229\7\66",
            "\1\u022a\37\uffff\1\u022b",
            "\1\u022a\37\uffff\1\u022b",
            "\1\u022c\37\uffff\1\u022d",
            "\1\u022c\37\uffff\1\u022d",
            "\1\u022e\37\uffff\1\u022f",
            "\1\u022e\37\uffff\1\u022f",
            "\1\u0230\37\uffff\1\u0231",
            "\1\u0230\37\uffff\1\u0231",
            "\1\u0232\37\uffff\1\u0233",
            "\1\u0232\37\uffff\1\u0233",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0235\37\uffff\1\u0236",
            "\1\u0235\37\uffff\1\u0236",
            "\1\u0237\37\uffff\1\u0238",
            "\1\u0237\37\uffff\1\u0238",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u023b\37\uffff\1\u023c",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u023b\37\uffff\1\u023c",
            "",
            "\1\u023d\37\uffff\1\u023e",
            "\1\u023d\37\uffff\1\u023e",
            "\1\u023f\37\uffff\1\u0240",
            "\1\u023f\37\uffff\1\u0240",
            "\1\u0241\37\uffff\1\u0242",
            "\1\u0241\37\uffff\1\u0242",
            "\1\u0243\37\uffff\1\u0244",
            "\1\u0243\37\uffff\1\u0244",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0246\37\uffff\1\u0247",
            "\1\u0246\37\uffff\1\u0247",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u024a\37\uffff\1\u024b",
            "\1\u024a\37\uffff\1\u024b",
            "\1\u024c\37\uffff\1\u024d",
            "\1\u024c\37\uffff\1\u024d",
            "\1\u024e\37\uffff\1\u024f",
            "\1\u024e\37\uffff\1\u024f",
            "",
            "\1\u0250\37\uffff\1\u0251",
            "\1\u0250\37\uffff\1\u0251",
            "\1\u0252\37\uffff\1\u0253",
            "\1\u0252\37\uffff\1\u0253",
            "\1\u0254\37\uffff\1\u0255",
            "\1\u0254\37\uffff\1\u0255",
            "\1\u0256\37\uffff\1\u0257",
            "\1\u0256\37\uffff\1\u0257",
            "\1\u0258\37\uffff\1\u0259",
            "\1\u0258\37\uffff\1\u0259",
            "\1\u01d6\5\uffff\1\u025a\31\uffff\1\u01d6\5\uffff\1\u025a",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u025d\37\uffff\1\u025e",
            "\1\u025d\37\uffff\1\u025e",
            "\13\66\6\uffff\1\66\1\u0260\21\66\1\u0261\6\66\4\uffff\1\66"+
            "\1\uffff\1\66\1\u0262\21\66\1\u0263\6\66",
            "\13\66\6\uffff\1\66\1\u0260\21\66\1\u0261\6\66\4\uffff\1\66"+
            "\1\uffff\1\66\1\u0262\21\66\1\u0263\6\66",
            "\1\u0264\37\uffff\1\u0265",
            "\1\u0264\37\uffff\1\u0265",
            "\1\u0266\37\uffff\1\u0267",
            "\1\u0266\37\uffff\1\u0267",
            "",
            "\1\u0268\37\uffff\1\u0269",
            "\1\u0268\37\uffff\1\u0269",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u026b\37\uffff\1\u026c",
            "\1\u026b\37\uffff\1\u026c",
            "",
            "\1\u026d\37\uffff\1\u026e",
            "\1\u026d\37\uffff\1\u026e",
            "\1\u026f\37\uffff\1\u0270",
            "\1\u026f\37\uffff\1\u0270",
            "\1\u0271\37\uffff\1\u0272",
            "\1\u0271\37\uffff\1\u0272",
            "\1\u0273\37\uffff\1\u0274",
            "\1\u0273\37\uffff\1\u0274",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0276\37\uffff\1\u0277",
            "\1\u0276\37\uffff\1\u0277",
            "\1\u0278\37\uffff\1\u0279",
            "\1\u0278\37\uffff\1\u0279",
            "\1\u027a\37\uffff\1\u027b",
            "\1\u027a\37\uffff\1\u027b",
            "\1\u027c\37\uffff\1\u027d",
            "\1\u027e\37\uffff\1\u027f",
            "\1\u027c\37\uffff\1\u027d",
            "\1\u027e\37\uffff\1\u027f",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0282\6\uffff\1\u0283\12\uffff\1\u0284\15\uffff\1\u0285"+
            "\6\uffff\1\u0286\12\uffff\1\u0287",
            "\1\u0282\6\uffff\1\u0283\12\uffff\1\u0284\15\uffff\1\u0285"+
            "\6\uffff\1\u0286\12\uffff\1\u0287",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0289\37\uffff\1\u028a",
            "\1\u0289\37\uffff\1\u028a",
            "\1\u028b\37\uffff\1\u028c",
            "\1\u028b\37\uffff\1\u028c",
            "",
            "\1\u028d\37\uffff\1\u028e",
            "\1\u028f\37\uffff\1\u0290",
            "\1\u028d\37\uffff\1\u028e",
            "\1\u028f\37\uffff\1\u0290",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0292\37\uffff\1\u0293",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0292\37\uffff\1\u0293",
            "",
            "\1\u0294\37\uffff\1\u0295",
            "\1\u0294\37\uffff\1\u0295",
            "\1\u0296\37\uffff\1\u0297",
            "\1\u0296\37\uffff\1\u0297",
            "\1\u0298\37\uffff\1\u0299",
            "\1\u0298\37\uffff\1\u0299",
            "",
            "",
            "\1\u029a\37\uffff\1\u029b",
            "\1\u029a\37\uffff\1\u029b",
            "",
            "",
            "",
            "",
            "\1\u029c\37\uffff\1\u029d",
            "\1\u029e\37\uffff\1\u029f",
            "\1\u02a0\37\uffff\1\u02a1",
            "\1\u029e\37\uffff\1\u029f",
            "\1\u02a0\37\uffff\1\u02a1",
            "\1\u02a2\37\uffff\1\u02a3",
            "\1\u02a2\37\uffff\1\u02a3",
            "\1\u02a4\37\uffff\1\u02a5",
            "\1\u02a4\37\uffff\1\u02a5",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02a7\37\uffff\1\u02a8",
            "\1\u02a7\37\uffff\1\u02a8",
            "\1\u02a9\37\uffff\1\u02aa",
            "\1\u02a9\37\uffff\1\u02aa",
            "",
            "\1\u02ab\37\uffff\1\u02ac",
            "\1\u02ab\37\uffff\1\u02ac",
            "\1\u02ad\37\uffff\1\u02ae",
            "\1\u02ad\37\uffff\1\u02ae",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02b0\37\uffff\1\u02b1",
            "\1\u02b0\37\uffff\1\u02b1",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u02b6\37\uffff\1\u02b7",
            "\1\u02b6\37\uffff\1\u02b7",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02b9\37\uffff\1\u02ba",
            "\1\u02b9\37\uffff\1\u02ba",
            "\1\u02bb\37\uffff\1\u02bc",
            "\1\u02bb\37\uffff\1\u02bc",
            "\1\u02bd\37\uffff\1\u02be",
            "\1\u02bd\37\uffff\1\u02be",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02c1\37\uffff\1\u02c2",
            "\1\u02c1\37\uffff\1\u02c2",
            "",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u02c4\37\uffff\1\u02c5",
            "\1\u02c6\37\uffff\1\u02c7",
            "\1\u02c4\37\uffff\1\u02c5",
            "\1\u02c6\37\uffff\1\u02c7",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02c9\37\uffff\1\u02ca",
            "\1\u02c9\37\uffff\1\u02ca",
            "",
            "\1\u02cb\37\uffff\1\u02cc",
            "\1\u02cb\37\uffff\1\u02cc",
            "\1\u02cd\37\uffff\1\u02ce",
            "\1\u02cd\37\uffff\1\u02ce",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02d3\37\uffff\1\u02d4",
            "\1\u02d3\37\uffff\1\u02d4",
            "\1\u02d5\37\uffff\1\u02d6",
            "\1\u02d5\37\uffff\1\u02d6",
            "\1\u02d7\37\uffff\1\u02d8",
            "\1\u02d7\37\uffff\1\u02d8",
            "\1\u02d9\37\uffff\1\u02da",
            "\1\u02d9\37\uffff\1\u02da",
            "",
            "",
            "\1\u02db\37\uffff\1\u02dc",
            "\1\u02dd\37\uffff\1\u02de",
            "\1\u02df\37\uffff\1\u02e0",
            "\1\u02db\37\uffff\1\u02dc",
            "\1\u02dd\37\uffff\1\u02de",
            "\1\u02df\37\uffff\1\u02e0",
            "",
            "\1\u02e1\37\uffff\1\u02e2",
            "\1\u02e1\37\uffff\1\u02e2",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02e4\37\uffff\1\u02e5",
            "\1\u02e4\37\uffff\1\u02e5",
            "\1\u02e6\37\uffff\1\u02e7",
            "\1\u02e6\37\uffff\1\u02e7",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02e9\37\uffff\1\u02ea",
            "\1\u02e9\37\uffff\1\u02ea",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u02ed\37\uffff\1\u02ee",
            "\1\u02ed\37\uffff\1\u02ee",
            "\1\u02ef\37\uffff\1\u02f0",
            "\1\u02ef\37\uffff\1\u02f0",
            "\1\u02f1\37\uffff\1\u02f2",
            "\1\u02f1\37\uffff\1\u02f2",
            "\1\u02f3\37\uffff\1\u02f4",
            "\1\u02f3\37\uffff\1\u02f4",
            "\13\66\6\uffff\22\66\1\u02f6\7\66\4\uffff\1\66\1\uffff\22\66"+
            "\1\u02f7\7\66",
            "\13\66\6\uffff\22\66\1\u02f6\7\66\4\uffff\1\66\1\uffff\22\66"+
            "\1\u02f7\7\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u02f9\37\uffff\1\u02fa",
            "\1\u02f9\37\uffff\1\u02fa",
            "\1\u02fb\37\uffff\1\u02fc",
            "\1\u02fb\37\uffff\1\u02fc",
            "\1\u02fd\37\uffff\1\u02fe",
            "\1\u02fd\37\uffff\1\u02fe",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\1\u0301\37\uffff\1\u0302",
            "\1\u0301\37\uffff\1\u0302",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0306\37\uffff\1\u0307",
            "\1\u0306\37\uffff\1\u0307",
            "",
            "\1\u0308\37\uffff\1\u0309",
            "\1\u0308\37\uffff\1\u0309",
            "\1\u030a\37\uffff\1\u030b",
            "\1\u030a\37\uffff\1\u030b",
            "",
            "\1\u030c\6\uffff\1\u030d\30\uffff\1\u030e\6\uffff\1\u030f",
            "\1\u030c\6\uffff\1\u030d\30\uffff\1\u030e\6\uffff\1\u030f",
            "\1\u0310\37\uffff\1\u0311",
            "\1\u0310\37\uffff\1\u0311",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0314\37\uffff\1\u0315",
            "\1\u0314\37\uffff\1\u0315",
            "\1\u0316\37\uffff\1\u0317",
            "\1\u0316\37\uffff\1\u0317",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0319\37\uffff\1\u031a",
            "\1\u0319\37\uffff\1\u031a",
            "\1\u031b\37\uffff\1\u031c",
            "\1\u031b\37\uffff\1\u031c",
            "\1\u031d\37\uffff\1\u031e",
            "\1\u031d\37\uffff\1\u031e",
            "\1\u031f\37\uffff\1\u0320",
            "\1\u031f\37\uffff\1\u0320",
            "",
            "\1\u0321\37\uffff\1\u0322",
            "\1\u0321\37\uffff\1\u0322",
            "\1\u0323\37\uffff\1\u0324",
            "\1\u0323\37\uffff\1\u0324",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0327\37\uffff\1\u0328",
            "\1\u0327\37\uffff\1\u0328",
            "\1\u0329\37\uffff\1\u032a",
            "\1\u0329\37\uffff\1\u032a",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u032f\37\uffff\1\u0330",
            "\1\u032f\37\uffff\1\u0330",
            "",
            "",
            "\1\u0331\37\uffff\1\u0332",
            "\1\u0331\37\uffff\1\u0332",
            "",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0334\37\uffff\1\u0335",
            "\1\u0334\37\uffff\1\u0335",
            "\1\u0336\37\uffff\1\u0337",
            "\1\u0336\37\uffff\1\u0337",
            "\1\u0338\37\uffff\1\u0339",
            "\1\u033a\37\uffff\1\u033b",
            "\1\u0338\37\uffff\1\u0339",
            "\1\u033a\37\uffff\1\u033b",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u033d\37\uffff\1\u033e",
            "\1\u033d\37\uffff\1\u033e",
            "\1\u033f\37\uffff\1\u0340",
            "\1\u033f\37\uffff\1\u0340",
            "",
            "\1\u0341\37\uffff\1\u0342",
            "\1\u0341\37\uffff\1\u0342",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0344\37\uffff\1\u0345",
            "\1\u0344\37\uffff\1\u0345",
            "\1\u0346\37\uffff\1\u0347",
            "\1\u0346\37\uffff\1\u0347",
            "\1\u0348\37\uffff\1\u0349",
            "\1\u0348\37\uffff\1\u0349",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u034b\37\uffff\1\u034c",
            "\1\u034b\37\uffff\1\u034c",
            "\1\u034d\37\uffff\1\u034e",
            "\1\u034d\37\uffff\1\u034e",
            "",
            "",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0353\37\uffff\1\u0354",
            "\1\u0353\37\uffff\1\u0354",
            "\1\u0355\37\uffff\1\u0356",
            "\1\u0355\37\uffff\1\u0356",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0358",
            "\1\u0358",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u035c\37\uffff\1\u035d",
            "\1\u035c\37\uffff\1\u035d",
            "",
            "\1\u035e\37\uffff\1\u035f",
            "\1\u035e\37\uffff\1\u035f",
            "\13\66\6\uffff\32\66\4\uffff\1\u0361\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\u0361\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\1\u0362\37\uffff\1\u0363",
            "\1\u0362\37\uffff\1\u0363",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u0365\37\uffff\1\u0366",
            "",
            "",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0368\37\uffff\1\u0369",
            "\1\u0368\37\uffff\1\u0369",
            "",
            "\1\u036a\37\uffff\1\u036b",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u036d\37\uffff\1\u036e",
            "\1\u036d\37\uffff\1\u036e",
            "",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0370\37\uffff\1\u0371",
            "\1\u0370\37\uffff\1\u0371",
            "",
            "\1\u0372\37\uffff\1\u0373",
            "\1\u0372\37\uffff\1\u0373",
            "",
            "\1\u0374\37\uffff\1\u0375",
            "\1\u0374\37\uffff\1\u0375",
            "\1\u0376\37\uffff\1\u0377",
            "\1\u0376\37\uffff\1\u0377",
            "\1\u0378\37\uffff\1\u0379",
            "\1\u0378\37\uffff\1\u0379",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u037b\37\uffff\1\u037c",
            "\1\u037b\37\uffff\1\u037c",
            "",
            "\1\u037d\37\uffff\1\u037e",
            "\1\u037d\37\uffff\1\u037e",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\13\66\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__183 | ADD_SYM | ALL | ANY | AS_SYM | ASC | AT_SYM | AVG | BETWEEN | BIGINT | BIN | BINARY | BLOB_SYM | BOOL_SYM | BOOLEAN_SYM | BY_SYM | BYTE_SYM | CALL_SYM | CASE_SYM | CHAR | CHAR_LENGTH | CHARACTER_SYM | CHARSET | COLUMN_SYM | COLUMNS_SYM | CONCAT | COUNT | DECIMAL_SYM | DEFAULT | DESC | DISTINCT | DO_SYM | DOUBLE_SYM | EACH_SYM | ELSE_SYM | ELSIF_SYM | END_SYM | EXISTS | FALSE_SYM | FETCH_SYM | FIELD | FILE_SYM | FLOAT_SYM | FOR_SYM | FROM | FULL | FUNCTION_SYM | GROUP_SYM | HAVING | HEX | IF | IFNULL | IGNORE_SYM | IN_SYM | INDEX_SYM | INNER_SYM | INTEGER_SYM | IS_SYM | JOIN_SYM | LEFT | LIMIT | LONG_SYM | LONGBLOB | LONGTEXT | LOWER | MAX_SYM | MEDIUMBLOB | MEDIUMINT | MIN_SYM | NOT_SYM | NULL_SYM | NUMERIC_SYM | OCT | OFFSET_SYM | ON | ORDER_SYM | OUTER | QUOTE | REAL | RIGHT | SELECT | SMALLINT | STRAIGHT_JOIN | STRING_SYM | SUM | THEN_SYM | TIME_SYM | TINYBLOB | TINYINT | TINYTEXT | TRUE_SYM | UNSIGNED_SYM | UPPER | USE_SYM | VARBINARY | VARCHAR | WHEN_SYM | WHERE | XML_SYM | ISNOTNULL | ISNULL | NOT_IN | DIVIDE | MOD_SYM | OR_SYM | AND_SYM | ARROW | EQ_SYM | NOT_EQ | LET | GET | SET_VAR | SHIFT_LEFT | SHIFT_RIGHT | ALL_FIELDS | SQUOTE | DQUOTE | COLONCOLON | DOLLAR | QUESTION | SEMI | COLON | DOT | COMMA | ASTERISK | RPAREN | LPAREN | RBRACK | LBRACK | LCURLY | RCURLY | PLUS | MINUS | NEGATION | VERTBAR | BITAND | POWER_OP | GTH | LTH | INTEGER_NUM | HEX_DIGIT | BIT_NUM | REAL_NUMBER | QUOTED_STRING | QUOTED_ID | ID | WHITE_SPACE );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_36 = input.LA(1);

                        s = -1;
                        if ( ((LA22_36 >= '\u0000' && LA22_36 <= '\uFFFF')) ) {s = 216;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}