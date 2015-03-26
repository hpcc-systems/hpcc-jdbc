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

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class HPCCResultSetMetadata implements ResultSetMetaData
{

    private List<HPCCColumnMetaData> columnList;
    private String                   tableName;
    //CHANGED FOR ODBC TESTING
    private String                   schemaName  = "";
    private String                   catalogName = HPCCJDBCUtils.HPCCCATALOGNAME;
    private HashMap<String, HPCCColumnMetaData> columnListHash = null;

    private void generateExpectedRetColsHash()
    {
        columnListHash = new HashMap<String, HPCCColumnMetaData>();

        int colIndex = 0;
        for (HPCCColumnMetaData col : columnList)
        {
            col.setIndex(colIndex++);
            columnListHash.put(col.getColumnNameOrAlias().toUpperCase(), col);
        }
    }

    public HPCCResultSetMetadata(List<HPCCColumnMetaData> columnList, String tableName)
    {
        this.columnList = columnList;
        this.tableName = tableName;

        try
        {
            generateExpectedRetColsHash();
        }
        catch (Exception e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE,  "ERROR CREATING HPCCResultSetMetadata Object");
        }
    }

    public boolean containsColByNameOrAlias(String nameOrAlias)
    {
       return  columnListHash.containsKey(nameOrAlias.toUpperCase());
    }

    public HPCCColumnMetaData getColByNameOrAlias(String nameOrAlias)
    {
       return  columnListHash.get(nameOrAlias.toUpperCase());
    }

    @SuppressWarnings("rawtypes")
    public ArrayList createDefaultResultRow()
    {
        ArrayList rowValues = new ArrayList();

        for (int i = 0; i < columnList.size(); i++)
        {
            // some columns might not be nullable!
            // rowValues.add(i, new Object());
            if (columnList.get(i).isConstant())
                rowValues.add(i, columnList.get(i).getConstantValue());
            else
                rowValues.add(i, null);
        }
        return rowValues;
    }

    public int getColumnCount() throws SQLException
    {
        if (columnList != null)
            return columnList.size();

        throw new SQLException("Metadata not set");
    }

    public boolean isAutoIncrement(int column) throws SQLException
    {
        return false;
    }

    public boolean isCaseSensitive(int column) throws SQLException
    {
        return false;
    }

    public boolean isSearchable(int column) throws SQLException
    {
        return true;
    }

    public boolean isCurrency(int column) throws SQLException
    {
        return false;
    }

    public int isNullable(int column) throws SQLException
    {
        //Nothing represented in HPCC is nullable.
        return 0;
    }

    public boolean isSigned(int column) throws SQLException
    {
        return false;
    }

    public int getColumnDisplaySize(int column) throws SQLException
    {
        return 255;
    }

    public String getColumnLabel(int column) throws SQLException
    {
        if (column >= 1 && column <= columnList.size())
            return columnList.get(column - 1).getColumnNameOrAlias();
        else
            throw new SQLException("Invalid Column Index = " + column);
    }

    public String getColumnName(int column) throws SQLException
    {
        if (column >= 1 && column <= columnList.size())
            return columnList.get(column - 1).getColumnName();
        else
            throw new SQLException("Invalid Column Index = column");
    }

    public String getSchemaName(int column) throws SQLException
    {
        return schemaName;
    }

    public int getPrecision(int column) throws SQLException
    {
        //"Get the designated column's number of decimal digits."
        //http://docs.oracle.com/javase/1.4.2/docs/api/java/sql/ResultSetMetaData.html#getScale%28int%29
        HPCCJDBCUtils.traceoutln(Level.ALL,  "getPrecision ( " + column +" )");
        if (column >= 1 && column <= columnList.size())
            return columnList.get(column - 1).getColumnChars();
        else
            throw new SQLException("Invalid Column Index: " + column);
    }

    public int getScale(int column) throws SQLException
    {
        //Gets the designated column's number of digits to right of the decimal point.
        //http://docs.oracle.com/javase/1.4.2/docs/api/java/sql/ResultSetMetaData.html#getScale%28int%29
        HPCCJDBCUtils.traceoutln(Level.ALL,  "getScale ( " + column +" )");
        if (column >= 1 && column <= columnList.size())
            return columnList.get(column - 1).getDecimalDigits();
        else
            throw new SQLException("Invalid Column Index: " + column);
    }

    public String getTableName(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "getTableName ( " + column +" )");
        if (column >= 1 && column <= columnList.size())
            return columnList.get(column - 1).getTableName();
        else
            throw new SQLException("Invalid Column Index: " + column);
    }

    public String getCatalogName(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "getCatalogName ( " + column +" ) : " + catalogName);
        return catalogName;
    }

    public int getColumnType(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "HPCCResultSetMetadata.getColumnType(column : " + column +" )");
        if (column >= 1 && column <= columnList.size())
        {
            int sqlType = columnList.get(column - 1).getSqlType();
            HPCCJDBCUtils.traceoutln(Level.ALL,  "SQLTYPE : " + sqlType +" )");
            return sqlType;
        }
        else
            throw new SQLException("Invalid Column Index = " + column);
    }

    public String getColumnTypeName(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "HPCCResultSetMetadata.getColumnTypeName(column : " + column +" )");
        if (column >= 1 && column <= columnList.size())
        {
            try
            {
                String sqlTypeName = HPCCJDBCUtils.getSQLTypeName(columnList.get(column - 1).getSqlType());
                HPCCJDBCUtils.traceoutln(Level.ALL,  "SQLTYPEName : " + sqlTypeName +" )");
                return sqlTypeName;
            }
            catch (Exception e)
            {
                throw new SQLException(e.getLocalizedMessage());
            }
        }
        else
            throw new SQLException("Invalid Column Index = " + column);
    }

    public boolean isReadOnly(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "isReadOnly ( " + column +" ) : true");
        return true;
    }

    public boolean isWritable(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "isWritable ( " + column +" ) : false");
        return false;
    }

    public boolean isDefinitelyWritable(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "isDefinitelyWritable ( " + column +" ) : false");
        return false;
    }

    public String getColumnClassName(int column) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.ALL,  "HPCCResultSetMetadata.getColumnClassName(column : " + column +" )");
        if (column >= 1 && column <= columnList.size())
        {
            String convertSQLtype2JavaClassName = HPCCJDBCUtils.convertSQLtype2JavaClassName(columnList.get(column - 1).getSqlType());
            HPCCJDBCUtils.traceoutln(Level.ALL,  "Column class name: " + convertSQLtype2JavaClassName +" )");
            return convertSQLtype2JavaClassName;
        }
        else
        {
            throw new SQLException("Invalid Column Index = " + column);
        }
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getColumnIndex(String columnLabel)
    {
        int colindex = -1;
        try
        {
            int columCount = this.getColumnCount();
            for (int col = 1; col <= columCount; col++)
            {
                if (this.getColumnLabel(col).equalsIgnoreCase(columnLabel))
                {
                    colindex = col;
                    break;
                }
            }
        }
        catch (SQLException e)
        {
        }

        return colindex;
    }

    public String[] getInParamNames()
    {
        String[] inparams = new String[this.columnList.size()];
        for (int i = 0; i < columnList.size(); i++)
        {
            inparams[i] = columnList.get(i).getColumnName();
        }

        return inparams;
    }
}
