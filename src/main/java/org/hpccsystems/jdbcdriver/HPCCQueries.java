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

import java.util.Enumeration;
import java.util.Properties;

/**
 * Represents HPCC System published queries.
 * Stores information regarding all published queries found on a particular HPCC System instance.
 * Multiple versions of the same named query can exist, but only one is available via the query name,
 * which is tracked via the aliases properties object.
 *
 */
public class HPCCQueries
{
    private Properties queries;
    private Properties aliases;

    public HPCCQueries()
    {
        queries = new Properties();
        aliases = new Properties();
    }

    public void put(HPCCQuery query)
    {
        queries.put(query.getQuerySet() + "::" + query.getID(), query);
    }

    public void putAlias(String queryset, String alias, String queryid)
    {
        aliases.put(queryset + "::" + alias, queryid);
    }

    public Enumeration<Object> getQueries()
    {
        return queries.elements();
    }

    public Enumeration<Object> getAliases()
    {
        return aliases.keys();
    }

    public HPCCQuery getQuerysetQuery(String eclqueryname)
    {
        String querysplit[] = eclqueryname.split("::");
        if (querysplit.length > 2)
        {
            String name = "";
            for (int i = 1; i < querysplit.length; i++)
                name += "::" + querysplit[i];

            return getQuery(querysplit[0], name);
        }
        else if (querysplit.length == 2)
            return getQuery(querysplit[0], querysplit[1]);
        else if (querysplit.length == 1)
            return getQuery(querysplit[0]);
        else
            return null;
    }

    public HPCCQuery getQuery(String queryset, String eclquerynameorid)
    {
        String eclqueryid = eclquerynameorid;

        if (aliases.containsKey((queryset.length() > 0 ? queryset + "::" : "") + eclquerynameorid))
            eclqueryid = (String) aliases.get((queryset.length() > 0 ? queryset + "::" : "") + eclquerynameorid);

        return (HPCCQuery) queries.get(queryset + "::" + eclqueryid);
    }

    public HPCCQuery getQuery(String eclquerynameorid)
    {
        String eclqueryid = eclquerynameorid;

        if (aliases.containsKey(eclquerynameorid))
            eclqueryid = (String) aliases.get(eclqueryid);

        return (HPCCQuery) queries.get(eclqueryid);
    }

    public int getLength()
    {
        return queries.size();
    }

    public boolean containsQueryName(String eclqueryname)
    {
        return queries.containsKey(eclqueryname);
    }

    public boolean containsQueryName(String queryset, String eclquerynameorid)
    {
        String eclqueryid = eclquerynameorid;

        if (aliases.containsKey((queryset.length() > 0 ? queryset + "::" : "") + eclquerynameorid))
            eclqueryid = (String) aliases.get((queryset.length() > 0 ? queryset + "::" : "") + eclquerynameorid);

        return queries.containsKey((queryset.length() > 0 ? queryset + "::" : "") + eclqueryid);
    }
}
