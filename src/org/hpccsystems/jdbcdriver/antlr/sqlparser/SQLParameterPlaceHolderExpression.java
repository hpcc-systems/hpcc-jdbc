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

public class SQLParameterPlaceHolderExpression extends SQLExpression
{
    public final static String  parameterizedPrefix = "PARAM";
    private String value = "";

    public SQLParameterPlaceHolderExpression()
    {
        super();
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTraslations,
            boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        return value;
    }


    @Override
    public String toString(boolean fullOutput)
    {
        return value;
    }

    @Override
    public int getExpressionsCount()
    {
        return 0;
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        return value;
    }

    @Override
    public boolean containsKey(String colname)
    {
        return false;
    }

    @Override
    public int getParameterizedCount()
    {
        return 1;
    }

    @Override
    public int setParameterizedNames(int index)
    {
        value = parameterizedPrefix+index;
        return ++index;
    }
}
