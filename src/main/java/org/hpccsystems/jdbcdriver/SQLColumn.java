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

public class SQLColumn
{
    private String          name;
    private String          alias;
    private String          parenttable;
    private int             type;
    private List<SQLColumn> functionParams;
    private String          constVal;
    private int             position;

    final static int        UNKNOWN_COLUMN_TYPE   = -1;
    final static int        CONST_COLUMN_TYPE     = 1;
    final static int        FIELDNAME_COLUMN_TYPE = 2;
    final static int        FUNCTION_COLUMN_TYPE  = 3;

    public SQLColumn()
    {
        name = null;
        alias = null;
        parenttable = null;
        type = UNKNOWN_COLUMN_TYPE;
        functionParams = null;
        constVal = null;
        position = -1;
    }

    public SQLColumn(String fullname, int coltype, int position)
    {
        String[] nameparts = name.split(HPCCJDBCUtils.DOTSEPERATORREGEX);
        if (nameparts.length > 1)
        {
            parenttable = nameparts[0];
        }
        else
            parenttable = null;

        this.name = nameparts[nameparts.length - 1];
        alias = null;
        functionParams = null;
        type = coltype;
        constVal = null;
        this.position = position;
    }

    public SQLColumn(String fullname, int position)
    {

        String[] nameparts = fullname.split(HPCCJDBCUtils.DOTSEPERATORREGEX);
        if (nameparts.length > 1)
        {
            parenttable = nameparts[0];
        }
        else
            parenttable = null;

        this.name = nameparts[nameparts.length - 1];
        alias = null;
        type = UNKNOWN_COLUMN_TYPE;
        functionParams = null;
        constVal = null;
        this.position = position;
    }

    public SQLColumn(String parentname, String columnname, int position)
    {
        parenttable = parentname;
        this.name = columnname;
        alias = null;
        type = FIELDNAME_COLUMN_TYPE;
        functionParams = null;
        constVal = null;
        this.position = position;
    }

    public SQLColumn(String columnname, List<SQLColumn> funcols, int position)
    {
        this.name = columnname;
        alias = null;
        type = FUNCTION_COLUMN_TYPE;
        functionParams = funcols;
        constVal = null;
        this.position = position;
    }

    public SQLColumn(String columnname, String constVal, String alias, int position)
    {
        this.name = columnname;
        this.alias = alias;
        type = CONST_COLUMN_TYPE;
        functionParams = null;
        this.constVal = constVal;
        this.position = position;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getParenttable()
    {
        return parenttable;
    }

    public void setParenttable(String parenttable)
    {
        this.parenttable = parenttable;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public List<SQLColumn> getFunctionParams()
    {
        return functionParams;
    }

    public void setFunctionParams(List<SQLColumn> functionParams)
    {
        this.functionParams = functionParams;
    }

    public String getConstVal()
    {
        return constVal;
    }

    public void setConstVal(String constVal)
    {
        this.constVal = constVal;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

}
