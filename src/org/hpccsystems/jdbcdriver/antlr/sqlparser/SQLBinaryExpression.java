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

package org.hpccsystems.jdbcdriver.antlr.sqlparser;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.hpccsystems.jdbcdriver.HPCCJDBCUtils;
import org.hpccsystems.jdbcdriver.SQLTable;

public class SQLBinaryExpression extends SQLExpression
{
    public static enum SQLBinaryExpressionType
    {
        UNKNOWN,
        EQUALS,
        NOTEQUALS,
        GREATERTHAN,
        LESSTHAN,
        GREATERTHANEQUAL,
        LESSTHANEQUAL,
        AND,
        OR,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        IN,
        NOTIN,
        MOD
    }

    SQLExpression operand1;
    SQLExpression operand2;
    SQLBinaryExpressionType type;

    public SQLBinaryExpression()
    {
        super();
        this.operand1 = null;
        this.operand2 = null;
        this.type = SQLBinaryExpressionType.UNKNOWN;
    }

    public SQLBinaryExpression(SQLExpression operand1, SQLExpression operand2, SQLBinaryExpressionType type)
    {
        super();
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.type = type;
    }

    public SQLExpression getOperand1()
    {
        return operand1;
    }
    public void setOperand1(SQLExpression operand1)
    {
        this.operand1 = operand1;
    }
    public SQLExpression getOperand2()
    {
        return operand2;
    }
    public void setOperand2(SQLExpression operand2)
    {
        this.operand2 = operand2;
    }
    public SQLBinaryExpressionType getType()
    {
        return type;
    }
    public void setType(SQLBinaryExpressionType type)
    {
        this.type = type;
    }

    private String getOpValue()
    {
        String result = "";

        switch (type)
        {
            case AND:
                result += " AND ";
                break;
            case DIVIDE:
                result += " / ";
                break;
            case EQUALS:
                result += " = ";
                break;
            case GREATERTHAN:
                result += " > ";
                break;
            case GREATERTHANEQUAL:
                result += " >= ";
                break;
            case LESSTHAN:
                result += " < ";
                break;
            case LESSTHANEQUAL:
                result += " <= ";
                break;
            case MINUS:
                result += " - ";
                break;
            case MOD:
                result += " % ";
                break;
            case MULTIPLY:
                result += " * ";
                break;
            case NOTEQUALS:
                result += " != ";
                break;
            case OR:
                result += " OR ";
                break;
            case PLUS:
                result += " + ";
                break;
            case IN:
                result += " IN ";
                break;
            case NOTIN:
                result += " NOT IN ";
                break;
            case UNKNOWN:
                break;
        }
        return result;
    }

    @Override
    public void updateColumnParentName(List<SQLTable> sqlTables) throws Exception
    {
        operand1.updateColumnParentName(sqlTables);
        operand2.updateColumnParentName(sqlTables);
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        String translation1 = operand1.toECLStringTranslateSource(map, ignoreMisTranslations, forHaving, false, false);
        String translation2 = operand2.toECLStringTranslateSource(map, ignoreMisTranslations, forHaving, false, false);

        if (translation1 != null && translation2 != null)
        {
            return translation1 + getOpValue() + translation2;
        }
        else if (translation1 == null && translation2 == null)
        {
            return null;
        }
        else if (ignoreMisTranslations)
        {
            /*
             * If operand1 or operand2 could not be translated using the translation map,
             * and ignoreMisTranslations = true, we're going to attempt to return an valid 
             * ECL translation of this binary expression. IF the binary expression is of type 
             * OR | AND, we can substitute the mistranslated operand with the appropriate boolean value 
             * to complete the expression with out changing the gist of the expression.
             *
             * This is typically done when converting an SQL 'WHERE' clause or 'ON' clause to ECL to
             * be used in an ECL JOIN function. In any one particular ECL Join funtion only two datasets 
             * are joined, therefore not all portions of the SQL logic clause might be relevant.
             *
             */

            if (getType() == SQLBinaryExpressionType.OR || getType() == SQLBinaryExpressionType.AND)
            {
                String convert = getType() == SQLBinaryExpressionType.OR ? "FALSE" : "TRUE";

                if (translation1 != null)
                {
                    HPCCJDBCUtils.traceoutln(Level.ALL, "Operand 1 of binary expression could not be translated.");
                    return translation1 + getOpValue() + convert;
                }
                else
                {
                    HPCCJDBCUtils.traceoutln(Level.ALL, "Operand 2 of binary expression could not be translated.");
                    return convert + getOpValue() + translation2;
                }
            }
            else
            {
                HPCCJDBCUtils.traceoutln(Level.ALL, "Binary expression could not be translated.");
                return null;
            }
        }
        else
        {
            HPCCJDBCUtils.traceoutln(Level.ALL, "Binary expression could not be translated.");
            return null;
        }
    }


    @Override
    public boolean containsEqualityCondition(HashMap<String, String> map, String first, String second)
    {
        if (this.isEqualityCondition(map, first, second))
        {
            return true;
        }
        else
        {
            boolean operand1Hasequality = false;
            boolean operand2Hasequality = false;

            if (operand1 instanceof SQLUnaryExpression)
            {
                operand1Hasequality =  ((SQLUnaryExpression)operand1).containsEqualityCondition(map, first, second);
            }
            else if (operand1 instanceof SQLBinaryExpression)
            {
                operand1Hasequality = ((SQLBinaryExpression)operand1).isEqualityCondition(map, first, second);
            }
            else if (operand1 instanceof SQLParenthesisExpression)
            {
                SQLExpression exp = ((SQLParenthesisExpression)operand1).getExpression();
                if ( exp instanceof SQLBinaryExpression)
                    operand1Hasequality = ((SQLBinaryExpression)exp).isEqualityCondition(map, first, second);
            }

            if (operand2 instanceof SQLUnaryExpression)
            {
                operand1Hasequality =  ((SQLUnaryExpression)operand2).containsEqualityCondition(map, first, second);
            }
            else if (operand2 instanceof SQLBinaryExpression)
            {
                operand2Hasequality = ((SQLBinaryExpression)operand2).isEqualityCondition(map, first, second);
            }
            else if (operand2 instanceof SQLParenthesisExpression)
            {
                SQLExpression exp = ((SQLParenthesisExpression)operand2).getExpression();
                if ( exp instanceof SQLBinaryExpression)
                    operand1Hasequality = ((SQLBinaryExpression)exp).isEqualityCondition(map, first, second);
            }

            if (type==SQLBinaryExpressionType.OR)
                return (operand1Hasequality && operand2Hasequality);
            else
                return (operand1Hasequality || operand2Hasequality);
        }
    }

    public boolean isEqualityCondition(HashMap<String, String> map, String first, String second)
    {
        String operand1Translate = null;
        String operand2Translate = null;

        if (operand1 instanceof SQLFieldValueExpression)
        {
            operand1Translate = map.get(((SQLFieldValueExpression)operand1).getParentTableName());
        }

        if (operand2 instanceof SQLFieldValueExpression)
        {
            operand2Translate = map.get(((SQLFieldValueExpression)operand2).getParentTableName());
        }

        if (operand1Translate == null || operand2Translate == null)
            return false;

        return ( !operand1Translate.equals(operand2Translate) &&
                 (operand1Translate.equals(first) || operand2Translate.equals(first) &&
                         operand1Translate.equals(second) || operand2Translate.equals(second))
                );

    }

    @Override
    public String toString(boolean fullOutput)
    {
        String result;
        result = operand1.toString(fullOutput);
        result += getOpValue();
        result += operand2.toString(fullOutput);

        return result;

    }

    @Override
    public int getExpressionsCount()
    {
        return operand1.getExpressionsCount() + operand2.getExpressionsCount();
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        String result = null;
        String result1 = operand1.getExpressionFromColumnName(colname);
        String result2 = operand2.getExpressionFromColumnName(colname);

        if (result1 != null && result2 != null)
        {
            result = result1 + getOpValue() + result2;
        }
        else if (type == SQLBinaryExpressionType.OR)
        {
            if (result1 != null)
                result = result1;
            else if (result2 != null)
                result = result2;
        }

        return result;
    }

    @Override
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames)
    {
        return operand1.getUniqueExpressionColumnNames(operand2.getUniqueExpressionColumnNames(uniquenames));
    }

    @Override
    public boolean containsKey(String colname)
    {
        return operand1.containsKey(colname) || operand2.containsKey(colname);
    }

    @Override
    public int getParameterizedCount()
    {
        return operand1.getParameterizedCount() + operand2.getParameterizedCount();
    }

    @Override
    public int setParameterizedNames(int index)
    {
        int op1index = operand1.setParameterizedNames(index);
        int op2index = operand2.setParameterizedNames(op1index);
        return op2index;
    }

    @Override
    public boolean isOrOperatorUsed()
    {
        if (type == SQLBinaryExpressionType.OR)
            return true;
        else
            return operand1.isOrOperatorUsed() || operand2.isOrOperatorUsed();
    }
}
