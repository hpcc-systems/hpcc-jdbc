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

public class SQLFieldValueExpression extends SQLExpression
{
    String parentTableName;
    String fieldName;

    public SQLFieldValueExpression(String parentTableName, String fieldName)
    {
        super();
        this.parentTableName = parentTableName.toUpperCase();
        this.fieldName = fieldName;
    }

    public String getParentTableName()
    {
        return parentTableName;
    }

    public void setParentTableName(String parentTableName)
    {
        this.parentTableName = parentTableName.toUpperCase();
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    /**
     * Compares table name to list of valid tables, changes aliases to actual names,
     * throws exception if table name does not checkout, or is ambiguous
     */
    public void updateColumnParentName(List<SQLTable> sqlTables) throws Exception
    {
        if (parentTableName != null && parentTableName.length() > 0)
        {
            setParentTableName(searchForPossibleTableName(sqlTables));
        }
        else if (sqlTables.size() == 1)
        {
            setParentTableName(sqlTables.get(0).getName());
        }
        else
        {
            throw new Exception("Ambiguous field found: " + toString());
        }
    }

    /**
     * Returns table name if the tablename or alias match Otherwise
     * throw exception
     */
    private String searchForPossibleTableName(List<SQLTable> sqlTables) throws Exception
    {
        for (int i = 0; i < sqlTables.size(); i++)
        {
            SQLTable currTable = sqlTables.get(i);
            if (parentTableName.equalsIgnoreCase(currTable.getAlias()) || parentTableName.equalsIgnoreCase(currTable.getName()))
                return currTable.getName();
        }

        throw new Exception("Invalid field found: " + toString());
    }

    @Override
    public String toECLStringTranslateSource(HashMap<String, String> map, boolean ignoreMisTranslations, boolean forHaving, boolean funcParam, boolean countFuncParam)
    {
        String result = null;
        String translation = map.get(getParentTableName());

        if (translation == null && getParentTableName() != null)
            return null;

        if ( translation != null && translation.length() > 0)
        {
            if (funcParam && forHaving && translation != null && translation.length() > 0)
            {
                result = " ROWS ( " + translation + " ) ";
                if (!countFuncParam)
                    result += ", " + getFieldName();
            }
            else
                result = translation + "." + getFieldName();
        }

        return result;
    }

    @Override
    public String toString(boolean fullOutput)
    {
        return ((fullOutput && parentTableName != null && parentTableName.length() > 0) ? parentTableName + "." : "") + fieldName;
    }

    @Override
    public int getExpressionsCount()
    {
        return 1;
    }

    @Override
    public String getExpressionFromColumnName(String colname)
    {
        if(getFieldName().equals(colname))
            return this.toString();
        else
            return null;
    }

    @Override
    public List<String> getUniqueExpressionColumnNames(List<String> uniquenames)
    {
        if (!uniquenames.contains(getFieldName()))
            uniquenames.add(getFieldName());

        return uniquenames;
    }

    @Override
    public boolean containsKey(String colname)
    {
        return colname.equals(getFieldName());
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
