/*##############################################################################

Copyright (C) 2011 HPCC Systems.

All rights reserved. This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
############################################################################## */

package org.hpccsystems.jdbcdriver;

import java.util.List;

public class SQLFragment
{
    public enum FragmentType
    {
        UNKNOWN_TYPE,
        NUMERIC_FRAGMENT_TYPE,
        LITERAL_STRING_TYPE,
        PARAMETRIZED_TYPE,
        FIELD_TYPE;
    }

    private String parent   =   null;
    private String value    =   null;
    private FragmentType type = FragmentType.UNKNOWN_TYPE;

    public SQLFragment() {}
    public SQLFragment(String framentStr)
    {
        parseExpressionFragment(framentStr);
    }

    public boolean isParametrized()
    {
        return type == FragmentType.PARAMETRIZED_TYPE;
    }
    public String getParent()
    {
        return parent;
    }

    public void setParent(String parent)
    {
        this.parent = parent;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public FragmentType getType()
    {
        return type;
    }

    public void setType(FragmentType type)
    {
        this.type = type;
    }

    public void parseExpressionFragment(String fragment)
    {
        this.type = determineFragmentType(fragment);

        switch (type)
        {
            case LITERAL_STRING_TYPE:
            case NUMERIC_FRAGMENT_TYPE:
            case PARAMETRIZED_TYPE:
                setValue(fragment);
                break;
            case FIELD_TYPE:
                String fragsplit[] = fragment.split("\\.", 2);
                if (fragsplit.length == 1)
                {
                    setValue(fragsplit[0]);
                }
                else
                {
                    setParent(fragsplit[0]);
                    setValue(fragsplit[1]);
                }
                break;
            default:
                break;
        }
    }

    public static SQLFragment createExpressionFragment(String fragment)
    {
        SQLFragment frag = new SQLFragment();

        frag.parseExpressionFragment(fragment);

        return frag;
    }

    public static FragmentType determineFragmentType (String fragStr)
    {
        if (fragStr == null || fragStr.length() <= 0)
        {
            return FragmentType.UNKNOWN_TYPE;
        }
        else if (HPCCJDBCUtils.isParameterizedStr(fragStr))
        {
            return FragmentType.PARAMETRIZED_TYPE;
        }
        else if (HPCCJDBCUtils.isLiteralString(fragStr))
        {
            return FragmentType.LITERAL_STRING_TYPE;
        }
        else if (HPCCJDBCUtils.isNumeric(fragStr))
        {
            return FragmentType.NUMERIC_FRAGMENT_TYPE;
        }
        else
        {
            return FragmentType.FIELD_TYPE;
        }
    }

    public String getFullColumnName()
    {
        if (type == FragmentType.FIELD_TYPE)
            return getParent() + "." + getValue();
        else
            return getValue();
    }

    public void updateFragmentColumParent(List<SQLTable> sqlTables) throws Exception
    {
        if (type == FragmentType.FIELD_TYPE)
        {
            if (parent != null && parent.length() > 0)
            {
                setParent(searchForPossibleTableName(sqlTables));
            }
            else if (sqlTables.size() == 1)
            {
                setParent(sqlTables.get(0).getName());
            }
            else
            {
                throw new Exception("Ambiguous field found: " + getValue());
            }
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
            if (parent.equals(currTable.getAlias()) || parent.equals(currTable.getName()))
                return currTable.getName();
        }

        throw new Exception("Invalid field found: " + getFullColumnName());
    }
}
