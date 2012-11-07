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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author rpastrana
 */

public class HPCCPreparedStatement extends HPCCStatement implements PreparedStatement
{
    private HashMap<Integer, Object> parameters    = new HashMap<Integer, Object>();
    protected static final String      className = "HPCCPreparedStatement";

    public HPCCPreparedStatement(Connection connection, String query)
    {
        super(connection);

        System.out.println(className + " Constructor: Sqlquery: " + query);
        this.sqlQuery = query;

        if (sqlQuery != null)
            processQuery();
    }

    public ResultSet executeQuery() throws SQLException
    {
        System.out.println(className + ":executeQuery()");
        executeHPCCQuery(parameters);

        return result;
    }

    public int executeUpdate() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ":  executeUpdate Not supported yet.");
        throw new UnsupportedOperationException(className + ":  executeUpdate Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNull(" + parameterIndex + ", " + sqlType + " )");
        parameters.put(new Integer(parameterIndex), sqlType);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBoolean(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setByte(int parameterIndex, byte x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setByte(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setShort(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setInt(int parameterIndex, int x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setInt(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setLong(int parameterIndex, long x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setLong(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setFloat(int parameterIndex, float x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setFloat(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setString(int parameterIndex, String x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setAsciiStream Not supported yet.");
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setUnicodeStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setBinaryStream Not supported yet.");
    }

    public void clearParameters() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": clearParameters()");
        parameters.clear();
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public boolean execute() throws SQLException
    {
        System.out.println(className + ": execute()");
        System.out.println(  "Attempting to process sql query: " + sqlQuery);
        return executeQuery() != null;
    }

    public void addBatch() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": addBatch()");
        throw new UnsupportedOperationException(className + ":  addBatch Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setCharacterStream(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setRef(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBlob(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setClob(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public ResultSetMetaData getMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": getMetaData()");
        return result != null ? result.getMetaData() : null;
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDate(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setDate Not supported yet.");
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setTime(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setTime Not supported yet.");
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setTimestamp(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setTimestamp Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNull(" + parameterIndex + ", " + sqlType + " )");
        throw new UnsupportedOperationException(className + ": setNull Not supported yet.");
    }

    public void setURL(int parameterIndex, URL x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setURL(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(  "HPCCPREPSTATEMENT getParameterMetaData");
        throw new UnsupportedOperationException(className + ": getParameterMetaData Not supported yet.");
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setRowId(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setRowId Not supported yet.");
    }

    public void setNString(int parameterIndex, String value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNString(" + parameterIndex + ", " + value + " )");
        parameters.put(new Integer(parameterIndex), value);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNCharacterStream(" + parameterIndex + ", " + value + " )");
        throw new UnsupportedOperationException(className + ": setNCharacterStream Not supported yet.");
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNClob(" + parameterIndex + ", " + value + " )");
        parameters.put(new Integer(parameterIndex), value);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBlob(" + parameterIndex + ", " + inputStream + " )");
        throw new UnsupportedOperationException(className + ": setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setNClob Not supported yet.");
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setSQLXML(" + parameterIndex + ", " + xmlObject + " )");
        parameters.put(new Integer(parameterIndex), xmlObject);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setAsciiStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBinaryStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setDouble(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setAsciiStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBinaryStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setCharacterStream(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNCharacterStream(" + parameterIndex + ", " + value + " )");
        throw new UnsupportedOperationException(className + ": setNCharacterStream Not supported yet.");
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setBlob(" + parameterIndex + ", " + inputStream + " )");
        throw new UnsupportedOperationException(className + ": setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": setNClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setNClob Not supported yet.");
    }

    public void close() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(className + ": close()");
        if (!closed)
        {
            super.close();
            parameters = null;
        }
    }
}
