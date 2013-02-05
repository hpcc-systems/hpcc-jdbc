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

import java.util.HashMap;
import java.util.List;

import org.hpccsystems.jdbcdriver.SQLTable;

public class SQLParenthesisExpression extends SQLExpression
{

    private SQLExpression expression;

    public SQLExpression getExpression()
    {
        return expression;
    }

    public SQLParenthesisExpression(SQLExpression expression)
    {
        super();
        this.expression = expression;
    }

    public void updateColumParentName(List<SQLTable> sqlTables) throws Exception
    {
        expression.updateColumParentName(sqlTables);
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTraslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        String translation = expression.toECLStringTranslateSource(map, ignoreMisTraslations, forHaving, funcParam, countFuncParam);
        if (translation == null)
            return null;
        else
            return "( " + translation + " )";
    }

    @Override
    public String toString(boolean fullOutput)
    {
        return "( " + expression.toString(fullOutput) + " )";
    }

    @Override
    public int getExpressionsCount()
    {
        return expression.getExpressionsCount();
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        String result = null;
        String result1 = expression.getExpressionFromColumnName(colname);

        if (result1 != null )
        {
            result = "( " + result1 + " )";
        }

        return result;
    }

    @Override
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames)
    {
        return expression.getUniqueExpressionColumnNames(uniquenames);
    }

    @Override
    public boolean containsKey(String colname)
    {
        return expression.containsKey(colname);
    }

    @Override
    public int getParameterizedCount()
    {
        return expression.getParameterizedCount();
    }

    @Override
    public int setParameterizedNames(int index)
    {
        return expression.setParameterizedNames(index);
    }

    @Override
    public boolean isOrOperatorUsed()
    {
        return expression.isOrOperatorUsed();
    }
}
