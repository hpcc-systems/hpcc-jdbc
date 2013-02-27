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

public class SQLValueExpression extends SQLExpression
{
    public static enum SQLValueType
    {
        UNKNOWN,
        STRING_LITERAL,
        NUMERIC_LITERAL,
        BOOLEAN_LITERAL,
        PARAMETERIZED,
        LIST,
        FUNCTION_FIELD_PARAMETER,
        FUNCTION,
    }

    protected SQLValueType type;
    protected String value;


    public SQLValueExpression()
    {
        super();
        this.type = SQLValueType.UNKNOWN;
        this.value = "";
    }

    public SQLValueExpression(SQLValueType type, String value)
    {
        super();
        this.type = type;
        this.value = value;
    }

    public SQLValueType getType()
    {
        return type;
    }
    public void setType(SQLValueType type)
    {
        this.type = type;
    }
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
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
        return 0;
    }

    @Override
    public int setParameterizedNames(int index)
    {
        return index;
    }
}
