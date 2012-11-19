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
import java.util.ArrayList;
import java.util.List;

public class SQLJoinClause
{
    public enum JoinType
    {
        INNER_JOIN, OUTER_JOIN;

        public String toSQLString()
        {
            switch (this)
            {
                case INNER_JOIN:
                    return "INNER JOIN";
                case OUTER_JOIN:
                    return "OUTER JOIN";
                default:
                    return "";
            }
        }

        public String toECLString()
        {
            switch (this)
            {
                case OUTER_JOIN:
                    return "FULL OUTER";
                case INNER_JOIN:
                    return "INNER";
                default:
                    return "";
            }
        }
    }

    private static final JoinType defaultType = JoinType.INNER_JOIN;

    private JoinType              type;
    private SQLWhereClause        OnClause;
    private List<SQLTable>        joinTables = new ArrayList<SQLTable>();

    public SQLJoinClause()
    {
        this.type = defaultType;
        this.OnClause = new SQLWhereClause();
    }

    public SQLJoinClause(JoinType type)
    {
        this.type = type;
        this.OnClause = new SQLWhereClause();
    }

    public void parse(String joinclausestr) throws SQLException
    {
        this.OnClause = new SQLWhereClause();

        if (joinclausestr.length() > 0)
        {
            String joinSplit[] = joinclausestr.split("\\s+(?i)join\\s+");
            if (joinSplit.length > 1)
            {
                if (joinSplit[0].trim().length() == 0)
                {
                    this.type = SQLJoinClause.defaultType;
                }
                else if (joinSplit[0].trim().equalsIgnoreCase("INNER"))
                {
                    this.type = JoinType.INNER_JOIN;
                }
                else if (joinSplit[0].trim().equalsIgnoreCase("OUTER"))
                {
                    this.type = JoinType.OUTER_JOIN;
                }
                else
                    throw new SQLException("Error: Invalid join clause found: " + type);
            }
            else
                throw new SQLException("Error: No valid join clause found: " + joinclausestr);

            String clausesplit[] = joinSplit[1].split("\\s+(?i)on\\s+", 2);

            if (clausesplit.length > 1)
            {
                SQLTable joinTable = null;
                String splittablefromalias[] = clausesplit[0].trim().split("\\s+(?i)as(\\s+|$)");
                if (splittablefromalias.length == 1)
                {
                    String splittablebyblank[] = splittablefromalias[0].trim().split("\\s+");
                    joinTable = new SQLTable(splittablebyblank[0]);
                    if (splittablebyblank.length == 2)
                        joinTable.setAlias(splittablebyblank[1].trim());
                    else if (splittablebyblank.length > 2)
                        throw new SQLException("Error: " + splittablefromalias[0]);
                }
                else if (splittablefromalias.length == 2)
                {
                    joinTable = new SQLTable(splittablefromalias[0].trim());
                    joinTable.setAlias(splittablefromalias[1].trim());
                }
                else
                    throw new SQLException("Error: Invalid SQL: " + clausesplit[0]);

                joinTables.add(joinTable);
                parseOnClause(clausesplit[1]);
            }
            else
                throw new SQLException("Error: 'Join' clause does not contain 'On' clause.");
        }
    }

    public void addOnClauseExpression(SQLExpression expression)
    {
        OnClause.addExpression(expression);
    }

    public SQLWhereClause getOnClause()
    {
        return this.OnClause;
    }

    public JoinType getType()
    {
        return this.type;
    }

    public String getSQLTypeStr()
    {
        return type.toSQLString();
    }

    public String getECLTypeStr()
    {
        return type.toECLString();
    }

    public SQLTable getJoinTable(int tableindex)
    {
        return joinTables.get(tableindex);
    }

    public void addJoinTable(SQLTable joinTable)
    {
        joinTables.add(joinTable);
    }

    public String getJoinTableName(int tableindex)
    {
        return joinTables.get(tableindex).getName();
    }

    public String getJoinTableAlias(int tableindex)
    {
        return joinTables.get(tableindex).getAlias();
    }

    public int getJoinTablesCount()
    {
        return joinTables.size();
    }

    public void updateFragments(List<SQLTable> sqlTables) throws Exception
    {
        OnClause.updateFragmentColumnsParent(sqlTables);
    }
    @Override
    public String toString()
    {
        StringBuilder tmp = new StringBuilder(getSQLTypeStr());

        for(SQLTable table : joinTables)
        {
            tmp.append(" ")
            .append(table.getName())
            .append(", ");
        }

        tmp.append(" ON ");
        tmp.append( OnClause.fullToString());

        return tmp.toString();
    }

    public void parseOnClause(String clause) throws SQLException
    {
        OnClause.parseWhereClause(clause);
    }

    public void setOnClause(SQLWhereClause in)
    {
        this.OnClause = in;
    }
}
