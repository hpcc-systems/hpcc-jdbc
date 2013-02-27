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

import org.hpccsystems.jdbcdriver.SQLTable;

public class SQLUnaryExpression extends SQLExpression
{
    public static enum SQLUnaryExpressionType
    {
        UNKNOWN,
        NOT,
        ISNULL,
        ISNOTNULL
    }

    SQLExpression operand1;
    SQLUnaryExpressionType type;

    public SQLUnaryExpression()
    {
        super();
        this.operand1 = null;
        this.type = SQLUnaryExpressionType.UNKNOWN;
    }

    public SQLUnaryExpression(SQLExpression operand1, SQLUnaryExpressionType type)
    {
        super();
        this.operand1 = operand1;
        this.type = type;
    }

    public SQLExpression getOperand1()
    {
        return operand1;
    }
    public void setExpression(SQLExpression operand1)
    {
        this.operand1 = operand1;
    }
    public SQLUnaryExpressionType getType()
    {
        return type;
    }
    public void setType(SQLUnaryExpressionType type)
    {
        this.type = type;
    }

    public void updateColumnParentName(List<SQLTable> sqlTables) throws Exception
    {
        operand1.updateColumnParentName(sqlTables);
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        String translation = null;
        String result = null;
        switch (type)
        {
            case ISNOTNULL:
                return " TRUE ";
            case ISNULL:
                return " FALSE ";
            case NOT:
                translation = operand1.toECLStringTranslateSource(map, ignoreMisTranslations, forHaving, funcParam, countFuncParam);
                if (translation == null)
                    return null;
                else
                    return " NOT " + translation;
            case UNKNOWN:
                return null;
        }
        return result;
    }

    @Override
    public boolean containsEqualityCondition(HashMap<String, String> map, String first, String second)
    {
        if (operand1 instanceof SQLBinaryExpression)
        {
            return ((SQLBinaryExpression)operand1).isEqualityCondition(map, first, second);
        }
        else if (operand1 instanceof SQLParenthesisExpression)
        {
            SQLExpression exp = ((SQLParenthesisExpression)operand1).getExpression();
            if ( exp instanceof SQLBinaryExpression)
                return ((SQLBinaryExpression)exp).isEqualityCondition(map, first, second);
            else if ( exp instanceof SQLUnaryExpression)
                return ((SQLUnaryExpression)exp).containsEqualityCondition(map, first, second);
        }

        return false;
    }

    @Override
    public String toString(boolean fullOutput)
    {
        String result = "";
        switch (type)
        {
            case ISNOTNULL:
                result = " TRUE ";
                break;
            case ISNULL:
                result = " FALSE ";
                break;
            case NOT:
                result = " NOT " + operand1.toString(fullOutput);
                break;
            case UNKNOWN:
                result =  operand1.toString(fullOutput);
        }
        return result;
    }

    @Override
    public int getExpressionsCount()
    {
        return operand1.getExpressionsCount();
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        String result = null;

        switch (type)
        {
            case ISNOTNULL:
                result = " TRUE ";
                break;
            case ISNULL:
                result = " FALSE ";
                break;
            case NOT:
                String result1 = operand1.getExpressionFromColumnName(colname);
                if (result1 != null)
                    result = " NOT " + result1;
                break;
        }

        return result;
    }

    @Override
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames)
    {
        return operand1.getUniqueExpressionColumnNames(uniquenames);
    }

    @Override
    public boolean containsKey(String colname)
    {
        return operand1.containsKey(colname);
    }

    @Override
    public int getParameterizedCount()
    {
        return operand1.getParameterizedCount();
    }

    @Override
    public int setParameterizedNames(int index)
    {
        return operand1.setParameterizedNames(index);
    }

    @Override
    public boolean isOrOperatorUsed()
    {
        return operand1.isOrOperatorUsed();
    }
}
