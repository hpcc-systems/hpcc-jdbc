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

import org.hpccsystems.jdbcdriver.ECLFunction;
import org.hpccsystems.jdbcdriver.SQLTable;

public class SQLFunctionExpression extends SQLExpression
{
    ECLFunction function;
    List<SQLExpression> params;

    public SQLFunctionExpression(ECLFunction function, List<SQLExpression> params)
    {
        super();
        this.function = function;
        this.params = params;
    }

    public String getFnName()
    {
        return (function != null) ? function.getName() : "";
    }

    public List<SQLExpression> getParams()
    {
        return params;
    }

    public void setParams(List<SQLExpression> params)
    {
        this.params = params;
    }

    public String getParamsString(boolean fullOutput)
    {
        String result = "";
        for (int i = 0; i < params.size(); i++)
        {
            result += ((SQLExpression) params.get(i)).toString(fullOutput);
            if ( i + 1 < params.size())
                result += ", ";
        }

        return result;
    }
    /*
     * This method returns an ECL-Centric representation of the
     * fragment's value.
     *
     * If this fragment is a function, the eclname is returned, with the value
     * encapsulated in parens. If a prefix is passed in, the prefix is added.
     * If this value is used within a "Having" clause, the function's
     * parameter is : ROWS( TRANSLATION)
     */
    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        String result = function.getEclFunction() + "( ";

        for (SQLExpression param : params)
        {
            String translation = param.toECLStringTranslateSource(map, ignoreMisTranslations, forHaving, true, function.getName().equals("COUNT"));
            if (!ignoreMisTranslations && translation == null)
                return null;
            result += translation;
        }
        result += " )";

        return result;
    }

    @Override
    public void updateColumnParentName(List<SQLTable> sqlTables) throws Exception
    {
        for (SQLExpression param : params)
        {
            param.updateColumnParentName(sqlTables);
        }
    }

    @Override
    public String toString(boolean fullOutput)
    {
        String result = function.getEclFunction() + " ( ";
        result += getParamsString(fullOutput);
        result += " ) ";

        return result;
    }

    @Override
    public int getExpressionsCount()
    {
        int count = 0;
        for (SQLExpression param : params)
        {
            count += param.getExpressionsCount();
        }
        return count;
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        String result = "";
        for (int i = 0; i < params.size(); i++)
        {
            String paramresult = ((SQLExpression) params.get(i)).getExpressionFromColumnName(colname);

            if (paramresult == null)
                return null;
            result += result;
            if ( i + 1 < params.size())
                result += ", ";
        }

        return result;
    }

    @Override
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames)
    {
        for (SQLExpression param : params)
        {
            param.getUniqueExpressionColumnNames(uniquenames);
        }
        return uniquenames;
    }

    @Override
    public boolean containsKey(String colname)
    {
        for (SQLExpression param : params)
        {
            param.containsKey(colname);
        }
        return false;
    }

    @Override
    public int getParameterizedCount()
    {
        int result = 0;
        for (SQLExpression param : params)
        {
            result += param.getParameterizedCount();
        }
        return result;
    }

    @Override
    public int setParameterizedNames(int index)
    {
        int paramindex = index;
        for (SQLExpression param : params)
        {
            paramindex += param.setParameterizedNames(paramindex);
        }
        return paramindex;
    }
}
