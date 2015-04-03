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

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.hpccsystems.ws.client.gen.wsworkunits.v1_46.ECLResult;
import org.hpccsystems.ws.client.gen.wsworkunits.v1_46.ECLSchemaItem;
import org.hpccsystems.ws.client.gen.wsworkunits.v1_46.ECLWorkunit;

public class HPCCQuery
{
    private String                   ID;
    private String                   Name;
    private String                   WUID;
    private String                   DLL;
    private String                   Alias;
    private String                   QuerySet;

    private boolean                  Suspended;
    private List<String>             ResultDatasets;
    private List<HPCCColumnMetaData> schema;
    private String                   defaulttable;
    private List<HPCCColumnMetaData> defaultfields;

    public HPCCQuery()
    {
        ID = "";
        Name = "";
        WUID = "";
        Suspended = false;
        Alias = "";
        QuerySet = "";
        ResultDatasets = new ArrayList<String>();
        schema = new ArrayList<HPCCColumnMetaData>();
        defaulttable = null;
        defaultfields = new ArrayList<HPCCColumnMetaData>();
    }

    public String getAlias()
    {
        return Alias;
    }

    public void setAlias(String alias)
    {
        Alias = alias;
    }

    public String[] getAllTableFieldsStringArray(String tablename)
    {
        String fields[] = new String[defaultfields.size()];
        int i = 0;
        Iterator<HPCCColumnMetaData> it = defaultfields.iterator();
        while (it.hasNext())
        {
            HPCCColumnMetaData field = (HPCCColumnMetaData) it.next();
            fields[i++] = field.getColumnName();
        }

        return fields;
    }

    public void addResultElement(HPCCColumnMetaData elem) throws Exception
    {
        if (defaulttable != null)
        {
            if (elem.getTableName().equalsIgnoreCase(defaulttable)
                    || elem.getParamType() == DatabaseMetaData.procedureColumnIn)
            {
                defaultfields.add(elem);
            }

            schema.add(elem);
        }
        else
            throw new Exception("Cannot add Result Elements before adding Result Dataset");

    }

    public void addResultDataset(String ds)
    {
        if (defaulttable == null)
        {
            defaulttable = ds;
            defaultfields.clear();
        }
        ResultDatasets.add(ds);
    }

    public List<String> getAllTables()
    {
        return ResultDatasets;
    }

    public List<HPCCColumnMetaData> getAllFields()
    {
        return defaultfields;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String iD)
    {
        ID = iD;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public String getWUID()
    {
        return WUID;
    }

    public void setWUID(String wUID)
    {
        WUID = wUID;
    }

    public String getDLL()
    {
        return DLL;
    }

    public void setDLL(String dLL)
    {
        DLL = dLL;
    }

    public boolean isSuspended()
    {
        return Suspended;
    }

    public void setSuspended(boolean suspended)
    {
        Suspended = suspended;
    }

    public Iterator<HPCCColumnMetaData> getColumnsMetaDataIterator()
    {
        return schema.iterator();
    }

    public String getDefaultTableName()
    {
        return defaulttable;
    }

    public boolean containsField(String fieldname)
    {
        Iterator<HPCCColumnMetaData> it = defaultfields.iterator();
        while (it.hasNext())
        {
            HPCCColumnMetaData field = (HPCCColumnMetaData) it.next();
            if (field.getColumnName().equalsIgnoreCase(fieldname))
                return true;
        }

        return false;
    }

    public ArrayList<HPCCColumnMetaData> getAllNonInFields()
    {
        ArrayList<HPCCColumnMetaData> expectedretcolumns = new ArrayList();

        Iterator<HPCCColumnMetaData> it = defaultfields.iterator();
        while (it.hasNext())
        {
            HPCCColumnMetaData field = (HPCCColumnMetaData) it.next();
            if (field.getParamType() != HPCCDatabaseMetaData.procedureColumnIn)
                expectedretcolumns.add(field);
        }

        return expectedretcolumns;
    }

    public ArrayList<HPCCColumnMetaData> getAllInFields()
    {
        ArrayList<HPCCColumnMetaData> inparams = new ArrayList();

        Iterator<HPCCColumnMetaData> it = defaultfields.iterator();
        while (it.hasNext())
        {
            HPCCColumnMetaData field = (HPCCColumnMetaData) it.next();
            if (field.getParamType() == HPCCDatabaseMetaData.procedureColumnIn)
                inparams.add(field);
        }

        return inparams;
    }

    public String getQuerySet()
    {
        return QuerySet;
    }

    public void setQueryset(String qsname)
    {
        QuerySet = qsname;
    }

    public boolean isQueryNameMatch(String fullname)
    {
        String querysplit[] = fullname.split("::");
        String inname = "";
        String inqs = "";
        if (querysplit.length > 2)
        {
            for (int i = 1; i < querysplit.length; i++)
                inname += "::" + querysplit[i];
            inqs = querysplit[0];
        }
        else if (querysplit.length == 2)
        {
            inqs = querysplit[0];
            inname = querysplit[1];
        }
        else if (querysplit.length == 1)
            inname = querysplit[0];
        else
            return false;

        if (!inname.equalsIgnoreCase(this.Name) || (inqs.length() > 0 && !inqs.equalsIgnoreCase(this.QuerySet)))
            return false;

        return true;
    }
}
