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

public class ECLFunction
{
    private String             name;
    private boolean            acceptsWilCard;
    private boolean            acceptsMultipleInputs;
    private HPCCColumnMetaData returnType;

    public ECLFunction(String thename, boolean acceptswild, HPCCColumnMetaData returntype, boolean multipleInput)
    {
        name = thename;
        acceptsWilCard = acceptswild;
        returnType = returntype;
        acceptsMultipleInputs = multipleInput;
    }

    public ECLFunction(String thename, HPCCColumnMetaData returntype)
    {
        name = thename;
        acceptsWilCard = false;
        returnType = returntype;
    }

    public String getName()
    {
        return name;
    }

    public boolean acceptsWilCard()
    {
        return acceptsWilCard;
    }

    public HPCCColumnMetaData getReturnType()
    {
        return returnType;
    }

    public boolean acceptsMultipleInputs()
    {
        return acceptsMultipleInputs;
    }
}
