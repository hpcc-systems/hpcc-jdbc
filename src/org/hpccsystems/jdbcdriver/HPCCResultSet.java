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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author rpastrana
 */

public class HPCCResultSet implements ResultSet
{
    private boolean                             closed = false;
    private List<List>                          rows;
    private int                                 index = -1;
    private HPCCResultSetMetadata               resultMetadata;
    private Statement                           statement = null;
    private Object                              lastResult;
    private SQLWarning                          warnings = null;

    public HPCCResultSet(List recrows, ArrayList<HPCCColumnMetaData> metadatacols, String tablename) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: HPCCResultSet(recrows, metadatacols, " + tablename +")");
        resultMetadata = new HPCCResultSetMetadata(metadatacols, tablename);
        rows = new ArrayList<List>(recrows);
        lastResult = new Object();
    }

    public HPCCResultSet(Statement statement, NodeList rowList, HPCCResultSetMetadata resultMetadata)
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: HPCCResultSet(statement, rowList, resultMetadata)");
        this.resultMetadata = resultMetadata;
        rows = new ArrayList();
        lastResult = new Object();

        this.statement = statement;

        encapsulateDataSet(rowList);
    }

    public void encapsulateDataSet(NodeList rowList)
    {
        HPCCJDBCUtils.traceoutln(Level.INFO, "HPCCResultSet encapsulateDataSet");
        int rowCount = 0;
        if (rowList != null && (rowCount = rowList.getLength()) > 0)
        {
            HPCCJDBCUtils.traceoutln(Level.INFO,  "Results rows found: " + rowCount);

            for (int j = 0; j < rowCount; j++)
            {
                ArrayList rowValues = resultMetadata.createDefaultResultRow();
                rows.add(rowValues);

                Element row = (Element) rowList.item(j);

                NodeList columnList = row.getChildNodes();

                for (int k = 0; k < columnList.getLength(); k++)
                {
                    Node resultRowElement = columnList.item(k);
                    String resultRowElementName = resultRowElement.getNodeName();

                    if (resultMetadata.containsColByNameOrAlias(resultRowElementName))
                    {
                        HPCCColumnMetaData col = resultMetadata.getColByNameOrAlias(resultRowElementName);
                        rowValues.set(col.getIndex(), resultRowElement.getTextContent());
                    }
                }
            }
        }
    }

    public int getRowCount()
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRowCount");
        return rows.size();
    }

    public boolean next() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet next");
        index++;
        if (index >= rows.size())
        {
            index--;
            return false;
        }
        else
        {
            return true;
        }
    }

    public void close() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet close");
        closed = true;
        //lastResult = null;
        //rows = null;
        //index = -1;
        //resultMetadata = null;
    }

    public boolean wasNull() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet wasNull: " + String.valueOf(lastResult == null).toString());
        return lastResult == null;
    }

    public String getString(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet:getString(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                {
                    HPCCJDBCUtils.traceoutln(Level.FINEST, "....Returned: null");
                    return null;
                }
                HPCCJDBCUtils.traceoutln(Level.FINEST, "....Returned: "+ lastResult.toString());
                return lastResult.toString();
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public boolean getBoolean(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBoolean(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                // content of row field is Object string, need to get value of
                // string and parse as boolean
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return false;
                return Boolean.parseBoolean(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public byte getByte(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getByte(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                return String.valueOf(lastResult).getBytes()[0];
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public short getShort(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getShort(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Short
                return Short.parseShort(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public int getInt(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getInt(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Int
                return Integer.parseInt(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public long getLong(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getLong(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Long
                return Long.parseLong(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public float getFloat(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getFloat(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Float
                return Float.parseFloat(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public double getDouble(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getDouble(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Double
                return Double.parseDouble(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBigDecimal(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as BigDecimal
                BigDecimal bd = new BigDecimal(String.valueOf(lastResult));
                return bd.setScale(scale);
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public byte[] getBytes(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBytes(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return String.valueOf(lastResult).getBytes();
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public Date getDate(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getDate(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Date
                return Date.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public Time getTime(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getTime(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Time
                return Time.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getTimestamp(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Timestamp
                return Timestamp.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getAsciiStream(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getUnicodeStream(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBinaryStream(" + columnIndex + ")");
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public String getString(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet:getString(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found: " + columnLabel);
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return null;

                return lastResult.toString();
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public boolean getBoolean(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBoolean(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return false;
                return Boolean.parseBoolean(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public byte getByte(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getByte(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                return String.valueOf(lastResult).getBytes()[0];
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public short getShort(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet:getShort(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Short
                return Short.parseShort(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public int getInt(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getInt(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Int
                return Integer.parseInt(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public long getLong(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getLong(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Long
                return Long.parseLong(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public float getFloat(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getFloat(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Float
                return Float.parseFloat(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public double getDouble(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getDouble(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int column = resultMetadata.getColumnIndex(columnLabel);
            if (column < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(column - 1);
                if (lastResult == null)
                    return 0;
                // content of row field is Object string, need to get value of
                // string and parse as Double
                return Double.parseDouble(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBigDecimal(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as BigDecimal
                BigDecimal bd = new BigDecimal(String.valueOf(lastResult));
                return bd.setScale(scale);
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public byte[] getBytes(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBytes(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return String.valueOf(lastResult).getBytes();
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public Date getDate(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getDate(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Date
                return Date.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public Time getTime(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getTime(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Time
                return Time.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getTimestamp(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as Timestamp
                return Timestamp.valueOf(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getAsciiStream(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getUnicodeStream(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getUnicodeStream(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet: getBinaryStream(" + columnLabel + ")");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return new ByteArrayInputStream(String.valueOf(lastResult).getBytes());
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public SQLWarning getWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getWarnings");
        return warnings;
    }

    public void clearWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet clearWarnings");
        warnings = null;
    }

    public String getCursorName() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getCursorName");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public ResultSetMetaData getMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getMetaData");
        return resultMetadata;
    }

    public Object getObject(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getObject( " + columnIndex + " )" );
        if (index >= 0 && index <= rows.size())
        {
            lastResult = rows.get(index).get(columnIndex - 1);
            return lastResult;
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public Object getObject(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getObject( " + columnLabel + " )" );
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                return lastResult;
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public int findColumn(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet findColumn( " + columnLabel + " )" );
        return resultMetadata.getColumnIndex(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getCharacterStream( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getCharacterStream( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getBigDecimal( " + columnIndex + " )" );
        if (index >= 0 && index <= rows.size())
            if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
            {
                lastResult = rows.get(index).get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as BigDecimal
                return new BigDecimal(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Invalid Column Index");
        else
            throw new SQLException("Invalid Row Index");
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getBigDecimal( " + columnLabel + " )" );
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                lastResult = row.get(columnIndex - 1);
                if (lastResult == null)
                    return null;
                // content of row field is Object string, need to get value of
                // string and parse as BigDecimal
                return new BigDecimal(String.valueOf(lastResult));
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public boolean isBeforeFirst() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isBeforeFirst");
        return (index < 0) ? true : false;
    }

    public boolean isAfterLast() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isAfterLast");
        return (index > rows.size() - 1) ? true : false;
    }

    public boolean isFirst() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isFirst");
        return index == 0 ? true : false;
    }

    public boolean isLast() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isLast");
        return (index == rows.size() - 1) ? true : false;
    }

    public void beforeFirst() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet beforeFirst");
        throw new UnsupportedOperationException("Not supported");
    }

    public void afterLast() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet afterLast");
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean first() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet first");
        if (rows.size() > 0)
        {
            index = 0;
            return true;
        }
        else
            return false;
    }

    public boolean last() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet last");
        if (rows.size() > 0)
        {
            index = rows.size() - 1;
            return true;
        }
        else
            return false;
    }

    public int getRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRow");
        return index + 1;
    }

    public boolean absolute(int row) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet absolute");
        if (row > 0 && row <= rows.size())
        {
            index = row - 1;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean relative(int rows) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet relative");
        int tmpindex = index + rows;
        if (tmpindex > 0 && tmpindex <= this.rows.size())
        {
            index = tmpindex;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean previous() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet previous");
        if (index > 1)
        {
            index--;
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setFetchDirection(int direction) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet setFetchDirection");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public int getFetchDirection() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getFetchDirection");
        return ResultSet.FETCH_FORWARD;
    }

    public void setFetchSize(int rows) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet setFetchSize");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public int getFetchSize() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getFetchSize");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public int getType() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getType");
        return ResultSet.TYPE_SCROLL_INSENSITIVE;
    }

    public int getConcurrency() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getConcurrency");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public boolean rowUpdated() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet rowUpdated");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public boolean rowInserted() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet rowInserted");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public boolean rowDeleted() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet rowDeleted");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateNull(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNull( " + columnIndex + " )" );;
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBoolean( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateByte(int columnIndex, byte x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateByte( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateShort(int columnIndex, short x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateInt(int columnIndex, int x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateLong(int columnIndex, long x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateFloat(int columnIndex, float x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateDouble(int columnIndex, double x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateDouble");
        throw new UnsupportedOperationException("HPCCResultSet: updateDouble Not supported yet.");
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: updateShort Not supported yet.");
    }

    public void updateString(int columnIndex, String x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: updateShort Not supported yet.");
    }

    public void updateDate(int columnIndex, Date x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateDate");
        throw new UnsupportedOperationException("HPCCResultSet: updateDate Not supported yet.");
    }

    public void updateTime(int columnIndex, Time x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateObject(int columnIndex, Object x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnIndex + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateNull(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNull( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBoolean(String columnLabel, boolean x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBoolean( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateByte(String columnLabel, byte x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateByte( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateShort(String columnLabel, short x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateShort( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateInt(String columnLabel, int x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateInt( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateLong(String columnLabel, long x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateLong( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateFloat(String columnLabel, float x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateFloat( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateDouble(String columnLabel, double x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateDouble( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBigDecimal( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateString(String columnLabel, String x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateString( " + columnLabel + " )" );
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBytes(String columnLabel, byte[] x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBytes");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateDate(String columnLabel, Date x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateDate");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateTime(String columnLabel, Time x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateTime");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateTimestamp");
        throw new UnsupportedOperationException("HPCCResultSet: updateTimestamp Not supported yet.");
    }

    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateAsciiStream");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBinaryStream");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateCharacterStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateCharacterStream Not supported yet.");
    }

    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateObject");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateObject(String columnLabel, Object x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateObject");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void insertRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet insertRow");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateRow");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void deleteRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet deleteRow");
        throw new UnsupportedOperationException("HPCCResultSet: deleteRow Not supported yet.");
    }

    public void refreshRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet refreshRow");
        throw new UnsupportedOperationException("HPCCResultSet: refreshRow Not supported yet.");
    }

    public void cancelRowUpdates() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet cancelRowUpdates");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void moveToInsertRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet moveToInsertRow");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void moveToCurrentRow() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet moveToCurrentRow");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Statement getStatement() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getStatement");
        return statement;
    }

    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getObject");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Ref getRef(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRef");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Blob getBlob(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getBlob");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Clob getClob(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getClob");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Array getArray(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getArray");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getObject");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Ref getRef(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRef");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Blob getBlob(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getBlob");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Clob getClob(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getClob");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Array getArray(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getArray");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getDate");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getDate");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getTime");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getTime");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getTimestamp");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getTimestamp");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public URL getURL(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getURL");
        try
        {
            if (index >= 0 && index <= rows.size())
                if (columnIndex >= 1 && columnIndex <= rows.get(index).size())
                {
                    lastResult = rows.get(index).get(columnIndex - 1);
                    if (lastResult == null)
                        return null;
                    // content of row field is Object string, need to get value
                    // of string and parse as BigDecimal
                    return new URL(String.valueOf(lastResult));
                }
                else
                    throw new SQLException("Invalid Column Index");
            else
                throw new SQLException("Invalid Row Index");
        }
        catch (MalformedURLException e)
        {
            throw new SQLException(e.getMessage());
        }
    }

    public URL getURL(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getURL");
        if (index >= 0 && index <= rows.size())
        {
            int columnIndex = resultMetadata.getColumnIndex(columnLabel);
            if (columnIndex < 0)
                throw new SQLException("Invalid Column Label found");
            List<?> row = rows.get(index);
            if (row != null)
            {
                try
                {
                    lastResult = row.get(columnIndex - 1);
                    if (lastResult == null)
                        return null;
                    return new URL(String.valueOf(lastResult));
                }
                catch (MalformedURLException e)
                {
                    throw new SQLException(e.getMessage());
                }
            }
            else
                throw new SQLException("Null Row found");
        }
        else
            throw new SQLException("Invalid Row Index");
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateRef");
        throw new UnsupportedOperationException("HPCCResultSet: updateRef(int columnIndex, Ref x) Not supported yet.");
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateRef");
        throw new UnsupportedOperationException("HPCCResultSet: updateRef(String columnLabel, Ref x) Not supported yet.");
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException("HPCCResultSet: updateBlob(int columnIndex, Blob x)  Not supported yet.");
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBlob(String columnLabel, Blob x) Not supported yet.");
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException("HPCCResultSet: updateClob(int columnIndex, Clob x) Not supported yet.");
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateClob(String columnLabel, Clob x) Not supported yet.");
    }

    public void updateArray(int columnIndex, Array x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateArray");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateArray(int columnIndex, Array x) Not supported yet.");
    }

    public void updateArray(String columnLabel, Array x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateArray");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateArray(String columnLabel, Array x)  Not supported yet.");
    }

    public RowId getRowId(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRowId");
        throw new UnsupportedOperationException("HPCCResultSet: getRowId(int columnIndex) Not supported yet.");
    }

    public RowId getRowId(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getRowId");
        throw new UnsupportedOperationException("HPCCResultSet: getRowId(String columnLabel) Not supported yet.");
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateRowId");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateRowId(int columnIndex, RowId x) Not supported yet.");
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateRowId");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateRowId(String columnLabel, RowId x) Not supported yet.");
    }

    public int getHoldability() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getHoldability");
        throw new UnsupportedOperationException("HPCCResultSet: getHoldability() Not supported yet.");
    }

    public boolean isClosed() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isClosed");
        return closed;
    }

    public void updateNString(int columnIndex, String nString) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNString");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNString(int columnIndex, String nString) Not supported yet.");
    }

    public void updateNString(String columnLabel, String nString) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNString");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNString(String columnLabel, String nString) Not supported yet.");
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException("HPCCResultSet: Not supported yet.");
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNClob(String columnLabel, NClob nClob) Not supported yet.");
    }

    public NClob getNClob(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNClob");
        throw new UnsupportedOperationException("HPCCResultSet: getNClob(int columnIndex) Not supported yet.");
    }

    public NClob getNClob(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNClob");
        throw new UnsupportedOperationException("HPCCResultSet: getNClob(String columnLabel) Not supported yet.");
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getSQLXML");
        throw new UnsupportedOperationException("HPCCResultSet: getSQLXML(int columnIndex) Not supported yet.");
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getSQLXML");
        throw new UnsupportedOperationException("HPCCResultSet: getSQLXML(String columnLabel) Not supported yet.");
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateSQLXML");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateSQLXML(int columnIndex, SQLXML xmlObject) Not supported yet.");
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateSQLXML");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateSQLXML(String columnLabel, SQLXML xmlObject) Not supported yet.");
    }

    public String getNString(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNString");
        throw new UnsupportedOperationException("HPCCResultSet: getNString(int columnIndex) Not supported yet.");
    }

    public String getNString(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNString");
        throw new UnsupportedOperationException("HPCCResultSet: getNString(String columnLabel) Not supported yet.");
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNCharacterStream");
        throw new UnsupportedOperationException("HPCCResultSet: getNCharacterStream(int columnIndex) Not supported yet.");
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet getNCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: getNCharacterStream(String columnLabel) Not supported yet.");
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNCharacterStream(int columnIndex, Reader x, long length) Not supported yet.");
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNCharacterStream(String columnLabel, Reader reader, long length) Not supported yet.");
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateAsciiStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateAsciiStream(int columnIndex, InputStream x, long length) Not supported yet.");
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBinaryStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBinaryStream(int columnIndex, InputStream x, long length) Not supported yet.");
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateCharacterStream(int columnIndex, Reader x, long length) Not supported yet.");
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateAsciiStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateAsciiStream(String columnLabel, InputStream x, long length) Not supported yet.");
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBinaryStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBinaryStream(String columnLabel, InputStream x, long length) Not supported yet.");
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateCharacterStream(String columnLabel, Reader reader, long length) Not supported yet.");
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBlob(int columnIndex, InputStream inputStream, long length) Not supported yet.");
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBlob(String columnLabel, InputStream inputStream,    long length) Not supported yet.");
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateClob(int columnIndex, Reader reader, long length) Not supported yet.");
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException
    {
    HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateClob(String columnLabel, Reader reader, long length) Not supported yet.");
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNClob(int columnIndex, Reader reader, long length) Not supported yet.");
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNClob(String columnLabel, Reader reader, long length) Not supported yet.");
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNCharacterStream(int columnIndex, Reader x) Not supported yet.");
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNCharacterStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateNCharacterStream(String columnLabel, Reader reader) Not supported yet.");
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateAsciiStream");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateAsciiStream(int columnIndex, InputStream x)Not supported yet.");
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBinaryStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateBinaryStream Not supported yet.");
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateCharacterStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateCharacterStream Not supported yet.");
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateAsciiStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateAsciiStream Not supported yet.");
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBinaryStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateBinaryStream Not supported yet.");
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateCharacterStream");
        throw new UnsupportedOperationException("HPCCResultSet: updateCharacterStream Not supported yet.");
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBlob(int columnIndex, InputStream inputStream) Not supported yet.");
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateBlob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateBlob(String columnLabel, InputStream inputStream) Not supported yet.");
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateClob(int columnIndex, Reader reader) Not supported yet.");
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateClob");
        throw new UnsupportedOperationException(
                "HPCCResultSet: updateClob(String columnLabel, Reader reader)  Not supported yet.");
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException("HPCCResultSet: updateNClob Not supported yet.");
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet updateNClob");
        throw new UnsupportedOperationException("HPCCResultSet: updateNClob Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet unwrap");
        throw new UnsupportedOperationException("HPCCResultSet: unwrap Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCResultSet isWrapperFor");
        throw new UnsupportedOperationException("HPCCResultSet: isWrapperFor Not supported yet.");
    }
}
