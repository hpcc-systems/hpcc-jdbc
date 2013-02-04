package org.hpccsystems.jdbcdriver.antlr.sqlparser;

/*##############################################################################

HPCC SYSTEMS software Copyright (C) 2013 HPCC Systems.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
############################################################################## */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.hpccsystems.jdbcdriver.ECLFunction;
import org.hpccsystems.jdbcdriver.ECLFunctions;
import org.hpccsystems.jdbcdriver.SQLTable;
import org.hpccsystems.jdbcdriver.antlr.sqlparser.SQLBinaryExpression.SQLBinaryExpressionType;
import org.hpccsystems.jdbcdriver.antlr.sqlparser.SQLUnaryExpression.SQLUnaryExpressionType;
import org.hpccsystems.jdbcdriver.antlr.sqlparser.SQLValueExpression.SQLValueType;
import org.hpccsystems.jdbcdriver.antlr.sqlparser.generated.SQLExpressionLexer;
import org.hpccsystems.jdbcdriver.antlr.sqlparser.generated.SQLExpressionParser;


public abstract class SQLExpression
{
    /*
     * Populates list with all (unique) columns used in this expression.
     * @param   List<String> list with names already found.
     *
     * @return  List<String> list containing the unique names of all columns found in this expression.
     */
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames) {return uniquenames;}

    /*
     * Reports whether this expression contains reference to field 'colname'.
     * @param   String name of column
     *
     * @return  boolean Reports whether this expression contains reference to field 'colname'.
     */
    public abstract boolean containsKey(String colname);

    /*
     * Returns string representation of sub-expression containing the field value referenced by incoming
     * parameter.
     *
     * @return  String string representation of sub-expression containing the field value referenced by incoming
     *                 parameter.
     */
    public abstract String getExpressionFromColumnName(String colname);

    /*
     * Returns count of parameterized expression placeholders contained within this expression.
     *
     * @return  int count of parameterized expression placeholders contained within this expression.
     */
    public abstract int getParameterizedCount();

    /*
     * Attempts to label each parameterized expression placeholder, increases the
     * running index value by the number of param placeholder processed.
     *
     * @param   int starting index used to as postfix for placeholder label
     *
     * @return  int running index value. To be used for next param placeholder label.
     */
    public abstract int setParameterizedNames(int index);

    /*
     * Returns number of field value expressions contained within SQL Expression.
     *
     * @return  int number of field value expressions contained within SQL Expression.
     */
    public abstract int getExpressionsCount();

    /*
     * Returns  string representation of this SQLExpression, fully qualifies field values
     *                depending on input param's value.
     * @param   boolean Fully qualify field values.
     *
     * @return  String Representation of this SQLExpression, fields fully-qualified baed on in param.
     */
    public abstract String toString(boolean fullOutput) ;

    /*
     * Translates SQLExpression to ECL in flat string form.
     * @param   map HasMap containing source table names as keys and its translation target
     * @param   ignoreMistranslations option to continue translating expression even if
     *          current expression contains table.field where table not found in map
     * @param   forHaving option to translate for ECL HAVING function
     * @param   funcParam option specifying if expression to be translated is a function parameter
     * @param   countFuncParam option specifying if expression to be translated is an ECL Count() parameter
     *
     * @return  String ECL consumable representation of expression. Can be null if none of expression could be
     *          translated.
     */
    public abstract String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTraslations, boolean forHaving, boolean funcParam, boolean countFuncParam);

    /*
     * Returns string representation of this SQLExpression.
     *
     * @return  String Representation of this SQLExpression, fields not fully qualified.
     */
    public String toString()
    {
        return toString(false);
    }

    /*
     * Returns string representation of this SQLExpression.
     *
     * @param   map HasMap containing source table names and their possible ECL translation
     * @param   String Name of first table.
     * @param   String Name of second table.
     * @return  boolean True if this expression was found to contain equality condition between
     *          table 'first' and table 'second'.
     */
    public boolean containsEqualityCondition(HashMap<String, String> map, String first, String second)
    {
        return false;
    }

    /*
     * Attempts to update any column's parent table name in case an alias was originally used.
     *
     * @param   List Contains all valid tables for this expression, along with their assigned aliases
     */
    public void updateColumParentName(List<SQLTable> sqlTables) throws Exception
    {
    };

    /*
     * Reports if the OR operator was used in this expression.
     *
     * @return boolean
     */
    public boolean isOrOperatorUsed()
    {
        return false;
    }

    /*
     * Returns SQLExpression object based on on incoming SQL expression string.
     *
     * @param   String SQL expression string
     *
     * @return  SQLExpression object representing valid incoming SQL expression.
     */
    public static SQLExpression createExpression(String str) throws SQLException
    {
        CommonTree tree = null;
        try
        {
            SQLExpressionLexer lex = new SQLExpressionLexer(new ANTLRStringStream(str));
            CommonTokenStream tokens = new CommonTokenStream(lex);
            SQLExpressionParser g = new SQLExpressionParser(tokens);

            tree = (CommonTree)g.expression().getTree();
        }
        catch (Exception e)
        {
           throw new SQLException(e.getMessage());
        }

        return SQLExpression.createExpression(tree);
    }

    /*
     * Creates SQLExpression object based on AST tree object. Usually generated by passing
     *         String sql expression through ANTLR generated Lexer and Parser.
     *
     * @param   CommonTree Tree representation of SQLExpression
     *
     * @return  SQLExpression object representing valid incoming SQL expression tree.
     */
    private static SQLExpression createExpression(CommonTree tree)
    {
        if (tree != null)
        {
            switch (tree.getType())
            {
                case SQLExpressionParser.FUNCEXP:
                    String fnName = ((CommonTree)tree.getChild(0)).getText();
                    ECLFunction function = ECLFunctions.getEclFunction(fnName.toUpperCase());
                    List<SQLExpression> params = new ArrayList<SQLExpression>();
                    for (int i = 1; i < tree.getChildCount(); i++)
                    {
                        params.add((SQLExpression)createExpression((CommonTree)tree.getChild(i)));
                    }

                    return new SQLFunctionExpression(function, params);

                case SQLExpressionParser.IN_SYM:
                    return new org.hpccsystems.jdbcdriver.antlr.sqlparser.SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.IN
                            );

                case SQLExpressionParser.NOT_IN:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.NOTIN
                            );

                case SQLExpressionParser.LISTEXP:

                    String list = "[ ";
                    for (int i = 0; i < tree.getChildCount(); i++)
                    {
                        list += ((CommonTree)tree.getChild(i)).getText() + ( i + 1 < tree.getChildCount() ? " , " : "");
                    }
                    list += " ]";

                    return new SQLValueExpression(SQLValueType.LIST, list);

                case SQLExpressionParser.ISNOTNULL:
                    return new SQLUnaryExpression(createExpression((CommonTree)tree.getChild(0)), SQLUnaryExpressionType.ISNOTNULL);
                case SQLExpressionParser.ISNULL:
                    return new SQLUnaryExpression(createExpression((CommonTree)tree.getChild(0)), SQLUnaryExpressionType.ISNULL);
                case SQLExpressionLexer.ID:
                    return new SQLValueExpression(SQLValueType.UNKNOWN, tree.getText());
                case SQLExpressionLexer.COLUMN:
                    String tableName = "";
                    String fieldName = ((CommonTree)tree.getChild(0)).getText();

                    for (int i = 1; i < tree.getChildCount(); i++)
                        tableName += ((CommonTree)tree.getChild(i)).getText();

                    SQLFieldValueExpression field = new SQLFieldValueExpression(tableName, fieldName);

                    //Integer fieldCount = fieldValueCount.get(field.toString());
                    //fieldValueCount.put(field.toString(), fieldCount==null ? 1 : ++fieldCount);
                    //totalFieldExpressionsCount++;
                    return field;
                case SQLExpressionLexer.PARAMPLACEHOLDER:
                    return new SQLParameterPlaceHolderExpression();
                case SQLExpressionParser.TRUE_SYM:
                case SQLExpressionParser.FALSE_SYM:
                    return new SQLValueExpression(SQLValueType.BOOLEAN_LITERAL, tree.getText());
                case SQLExpressionParser.INTEGER_NUM:
                case SQLExpressionParser.REAL_NUMBER:
                case SQLExpressionParser.HEX_DIGIT:
                    return new SQLValueExpression(SQLValueType.NUMERIC_LITERAL, tree.getText());
                case SQLExpressionParser.QUOTED_STRING:
                    return new SQLValueExpression(SQLValueType.STRING_LITERAL, tree.getText());
                case SQLExpressionParser.NEGATION:
                case SQLExpressionParser.NOT_SYM:
                    return new SQLUnaryExpression(createExpression((CommonTree)tree.getChild(0)), SQLUnaryExpressionType.NOT);

                case SQLExpressionParser.EQ_SYM:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.EQUALS
                            );

                case SQLExpressionParser.LTH:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.LESSTHAN
                            );

                case SQLExpressionParser.GTH:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.GREATERTHAN
                            );

                case SQLExpressionParser.GET:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.GREATERTHANEQUAL
                            );

                case SQLExpressionParser.LET:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.LESSTHANEQUAL
                            );

                case SQLExpressionParser.NOT_EQ:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.NOTEQUALS
                            );

                case SQLExpressionParser.ASTERISK:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.MULTIPLY
                            );

                case SQLExpressionParser.DIVIDE:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.DIVIDE
                            );

                case SQLExpressionParser.MOD_SYM:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.MOD
                            );

                //case SQLExpressionParser.POWER_OP:
                case SQLExpressionParser.PLUS:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.PLUS
                            );

                case SQLExpressionParser.MINUS:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.MINUS
                            );

                case SQLExpressionParser.OR_SYM:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.OR
                            );

                case SQLExpressionParser.AND_SYM:
                    return new SQLBinaryExpression(
                            createExpression((CommonTree)tree.getChild(0)),
                            createExpression((CommonTree)tree.getChild(1)),
                            SQLBinaryExpressionType.AND
                            );

                case SQLExpressionParser.PARENEXP:
                    return new SQLParenthesisExpression(createExpression((CommonTree)tree.getChild(0)));

                default:
                    return null;
            }
        }
        else
            return null;
    }
}
