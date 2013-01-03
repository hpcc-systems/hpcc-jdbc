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

import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;

public class SQLFragment
{
    public enum FragmentType
    {
        UNKNOWN_TYPE,
        NUMERIC_FRAGMENT,
        LITERAL_STRING,
        PARAMETERIZED,
        FIELD,
        LIST,
        FUNCTION_FIELD_PARAMETER,
        FUNCTION,
        BOOLEAN;
    }

    private ECLFunction function = null;
    private String parent   =   null;
    private String value    =   null;
    private FragmentType type = FragmentType.UNKNOWN_TYPE;

    public SQLFragment() {}
    public SQLFragment(String framentStr)
    {
        parseExpressionFragment(framentStr);
    }

    public boolean isParameterized()
    {
        return type == FragmentType.PARAMETERIZED;
    }
    public String getParent()
    {
        return parent;
    }

    public void setParent(String parent)
    {
        this.parent = parent.toUpperCase();
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
    public String getValue(String translation, boolean forHaving)
    {
        if (type == FragmentType.FUNCTION || type ==  FragmentType.FUNCTION_FIELD_PARAMETER)
        {
            String ret = function.getEclFunction() + "( ";
            if (forHaving && translation != null && translation.length() > 0)
            {
                ret += " ROWS ( " + translation + " ) ";

                if (!function.getName().equals("COUNT"))
                        ret += ", " + value;
            }
            else
                ret += value;

            ret += " )";
            return ret;
        }
        else
            return value;
    }

    public String getValue()
    {
        if (type == FragmentType.FUNCTION || type ==  FragmentType.FUNCTION_FIELD_PARAMETER)
            return function.getEclFunction() + "( " + value + " )";
        else
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

    private void handleFieldType(String fragment)
    {
        String fragsplit[] = fragment.split(HPCCJDBCUtils.DOTSEPERATORREGEX, 2);
        if (fragsplit.length == 1)
        {
            setValue(HPCCJDBCUtils.handleQuotedString(fragsplit[0]));
        }
        else
        {
            setParent(HPCCJDBCUtils.handleQuotedString(fragsplit[0]));
            setValue(HPCCJDBCUtils.handleQuotedString(fragsplit[1]));
        }
    }

    public void parseExpressionFragment(String fragment)
    {
        try
        {
            this.type = determineFragmentType(fragment);

            switch (type)
            {
                case LITERAL_STRING:
                    fragment = HPCCJDBCUtils.replaceSQLwithECLEscapeChar(fragment);
                case NUMERIC_FRAGMENT:
                case PARAMETERIZED:
                case BOOLEAN:
                    setValue(fragment);
                    break;
                case FIELD:
                    handleFieldType(fragment);
                    break;
                case LIST:

                    if (HPCCJDBCUtils.hasPossibleEscapedQuoteLiteral(fragment))
                    {
                        StringBuilder tmp = new StringBuilder();

                        StringTokenizer comatokens = new StringTokenizer(HPCCJDBCUtils.getParenContents(fragment), ",");

                        while (comatokens.hasMoreTokens())
                        {
                            if (tmp.length() == 0)
                                tmp.append("[");
                            else
                                tmp.append(", ");

                            tmp.append(HPCCJDBCUtils.replaceSQLwithECLEscapeChar(comatokens.nextToken().trim()));
                        }
                        tmp.append("]");

                        setValue(tmp.toString());
                    }
                    else
                      setValue("[" + HPCCJDBCUtils.getParenContents(fragment) + "]");

                    break;
                case FUNCTION:
                    Matcher matcher = HPCCJDBCUtils.FUNCPATTERN.matcher(fragment);

                    if (matcher.matches())
                    {
                        ECLFunction func = ECLFunctions.getEclFunction(matcher.group(1));

                        if (func != null)
                        {
                            setFunction(func);
                            String subfragment = matcher.group(3).trim();
                            FragmentType subfragtype = determineFragmentType(subfragment);
                            switch (subfragtype)
                            {
                                case FIELD:
                                    handleFieldType(subfragment);
                                    this.type = FragmentType.FUNCTION_FIELD_PARAMETER;
                                    break;
                                case LITERAL_STRING:
                                case NUMERIC_FRAGMENT:
                                case PARAMETERIZED:
                                case BOOLEAN:
                                    setValue(subfragment);
                                    break;
                            }
                        }
                        else
                            throw new SQLException("Function found in logic clause is not be supported: " + fragment);
                    }
                    else
                        throw new SQLException("Error while parsing funtion in logic clause: " + fragment);

                    break;
                default:
                    break;
            }
        }
        catch (Exception e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE,   "Error while parsing SQL fragment: " + fragment);
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
            return FragmentType.PARAMETERIZED;
        }
        else if (HPCCJDBCUtils.isLiteralString(fragStr))
        {
            return FragmentType.LITERAL_STRING;
        }
        else if (HPCCJDBCUtils.isBooleanKeyWord(fragStr))
        {
            return FragmentType.BOOLEAN;
        }
        else if (HPCCJDBCUtils.isNumeric(fragStr))
        {
            return FragmentType.NUMERIC_FRAGMENT;
        }
        else if (HPCCJDBCUtils.isInParenthesis(fragStr))
        {
            return FragmentType.LIST;
        }
        else if (HPCCJDBCUtils.isFunction(fragStr))
        {
            return FragmentType.FUNCTION;
        }
        else
        {
            return FragmentType.FIELD;
        }
    }

    public String getFullColumnName()
    {
        if (type == FragmentType.FIELD || type == FragmentType.FUNCTION_FIELD_PARAMETER)
            return getParent() + "." + getValue();
        else
            return getValue();
    }

    public void updateFragmentColumParent(List<SQLTable> sqlTables) throws Exception
    {
        if (type == FragmentType.FIELD || type == FragmentType.FUNCTION_FIELD_PARAMETER)
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
            if (parent.equalsIgnoreCase(currTable.getAlias()) || parent.equalsIgnoreCase(currTable.getName()))
                return currTable.getName();
        }

        throw new Exception("Invalid field found: " + getFullColumnName());
    }

    public String getFnname()
    {
        return function.getName();
    }

    public void setFunction(ECLFunction func)
    {
        this.function = func;
    }
}
