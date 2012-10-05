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
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

import org.w3c.dom.NodeList;

/**
 *
 * @author rpastrana
 */

public class HPCCPreparedStatement implements PreparedStatement
{
    private boolean                  closed        = false;
    private int                      maxRows       = 100;
    private String                   sqlQuery;
    private HPCCConnection           hpccConnection;
    private HashMap<Integer, Object> parameters    = new HashMap<Integer, Object>();
    private SQLWarning               warnings;
    private HPCCResultSet            result        = null;
    private HPCCResultSetMetadata    resultMetadata = null;

    private HPCCDatabaseMetaData                dbMetadata;
    private ECLEngine                           eclQuery = null;
    private SQLParser                           parser = new SQLParser();

    public HPCCPreparedStatement(Connection connection, String query)
    {
        HPCCJDBCUtils.traceoutln("HPCCPreparedStatement Constructor: Sqlquery: " + query);
        this.sqlQuery = query;
        this.hpccConnection = (HPCCConnection)connection;
        this.dbMetadata = hpccConnection.getDatabaseMetaData();

        if (sqlQuery != null)
            processQuery();
    }

    private void processQuery()
    {
        try
        {
            HPCCJDBCUtils.traceoutln("Attempting to process sql query: " + sqlQuery); 
            if (!this.closed)
            {
                if (parser != null)
                    parser.process(sqlQuery);
                else
                    throw new SQLException("Error parser is not ready, cannot execute query");

                eclQuery = new ECLEngine(parser, dbMetadata, hpccConnection.getProperties());

                eclQuery.generateECL();
                resultMetadata = new HPCCResultSetMetadata(eclQuery.getExpectedRetCols(), "HPCC Result");
            }
            else
                throw new SQLException("HPCCPreparedStatement closed, cannot execute query");
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            if (warnings == null)
                warnings = new SQLWarning();
            warnings.setNextException(e);

            eclQuery = null;
            parser = null;
        }
    }

    public ResultSet executeQuery() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCPreparedStatement:executeQuery()");
        HPCCJDBCUtils.traceoutln("Attempting to process sql query: " + sqlQuery);
        result = null;

        try
        {
            if (!this.closed)
            {
                if (eclQuery == null)
                {
                    String message = "HPCCPreparedStatement: Cannot execute SQL command";

                    if (warnings != null)
                    {
                        SQLException  we = warnings.getNextException();
                        if(we != null)
                            message += "\n\t" + we.getLocalizedMessage();
                    }
                    throw new SQLException(message);
                }

                NodeList rowList = eclQuery.execute(parameters);

                if (rowList != null)
                    result = new HPCCResultSet(this, rowList, resultMetadata);
            }
            else
                throw new SQLException("HPCCPreparedStatement closed, cannot execute query");
        }
        catch (Exception e)
        {
            SQLException sqlexcept = new SQLException(e.getLocalizedMessage());
            sqlexcept.setStackTrace(e.getStackTrace());

            if (warnings == null)
                warnings = new SQLWarning();

            warnings.setNextException(sqlexcept);

            throw sqlexcept;
        }

        return result;
    }

    public int executeUpdate() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: executeUpdate Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), sqlType);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setByte(int parameterIndex, byte x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setInt(int parameterIndex, int x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setLong(int parameterIndex, long x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setFloat(int parameterIndex, float x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setString(int parameterIndex, String x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: setAsciiStream Not supported yet.");
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: setUnicodeStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: setBinaryStream Not supported yet.");
    }

    public void clearParameters() throws SQLException
    {
        parameters.clear();
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public boolean execute() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCPreparedStatement:execute()");
        HPCCJDBCUtils.traceoutln("Attempting to process sql query: " + sqlQuery);
        return executeQuery() != null;
    }

    public void addBatch() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: addBatch Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setCharacterStream Not supported yet.");
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public ResultSetMetaData getMetaData() throws SQLException
    {
        return result != null ? result.getMetaData() : null;
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setDate Not supported yet.");
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setTime Not supported yet.");
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setTimestamp Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setNull Not supported yet.");
    }

    public void setURL(int parameterIndex, URL x) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCPREPSTATEMENT getParameterMetaData");
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getParameterMetaData Not supported yet.");
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setRowId Not supported yet.");
    }

    public void setNString(int parameterIndex, String value) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), value);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setNCharacterStream Not supported yet.");
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), value);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setNClob Not supported yet.");
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), xmlObject);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException
    {
        parameters.put(new Integer(parameterIndex), x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setCharacterStream Not supported yet.");
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setCharacterStream Not supported yet.");
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setNCharacterStream Not supported yet.");
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setNClob Not supported yet.");
    }

    public ResultSet executeQuery(String query) throws SQLException
    {
        sqlQuery = query;

        HPCCJDBCUtils.traceoutln("ECLPreparedStatement: executeQuery(" + query + ")");

        processQuery();

        return executeQuery();
    }

    public int executeUpdate(String sql) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:executeUpdate Not supported yet.");
    }

    public void close() throws SQLException
    {
        if (!closed)
        {
            closed = true;
            hpccConnection = null;
            result = null;
            sqlQuery = null;
            dbMetadata = null;
            parameters = null;
            parser = null;
            eclQuery = null;
        }
    }

    public int getMaxFieldSize() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT: getMaxFieldSizeNot supported yet.");
    }

    public void setMaxFieldSize(int max) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setMaxFieldSize Not supported yet.");
    }

    public int getMaxRows() throws SQLException
    {
        return maxRows;
    }

    public void setMaxRows(int max) throws SQLException
    {
        maxRows = max;
    }

    public void setEscapeProcessing(boolean enable) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setEscapeProcessing Not supported yet.");
    }

    public int getQueryTimeout() throws SQLException
    {
        return -1;
    }

    public void setQueryTimeout(int seconds) throws SQLException
    {
        throw new UnsupportedOperationException("ECLPREPSTATEMNT:setQueryTimeout Not supported yet.");
    }

    public void cancel() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:cancel Not supported yet.");
    }

    public SQLWarning getWarnings() throws SQLException
    {
        return warnings;
    }

    public void clearWarnings() throws SQLException
    {
        warnings = null;
    }

    public void setCursorName(String name) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setCursorName Not supported yet.");
    }

    public boolean execute(String sql) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCPreparedStatement:execute(" + sql + ")");
        sqlQuery = sql;

        processQuery();

        return execute();
    }

    public ResultSet getResultSet() throws SQLException
    {
        return result;
    }

    public int getUpdateCount() throws SQLException
    {
        return 0;
    }

    public boolean getMoreResults() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getMoreResults Not supported yet.");
    }

    public void setFetchDirection(int direction) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setFetchDirection Not supported yet.");
    }

    public int getFetchDirection() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getFetchDirection Not supported yet.");
    }

    public void setFetchSize(int rows) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setFetchSize Not supported yet.");
    }

    public int getFetchSize() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getFetchSize Not supported yet.");
    }

    public int getResultSetConcurrency() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getResultSetConcurrency Not supported yet.");
    }

    public int getResultSetType() throws SQLException
    {
        return ResultSet.TYPE_FORWARD_ONLY;
    }

    public void addBatch(String sql) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:addBatch Not supported yet.");
    }

    public void clearBatch() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:clearBatch Not supported yet.");
    }

    public int[] executeBatch() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:executeBatch Not supported yet.");
    }

    public Connection getConnection() throws SQLException
    {
        return hpccConnection;
    }

    public boolean getMoreResults(int current) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getMoreResults Not supported yet.");
    }

    public ResultSet getGeneratedKeys() throws SQLException
    {
        return null;
    }

    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:executeUpdate Not supported yet.");
    }

    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:executeUpdate Not supported yet.");
    }

    public int executeUpdate(String sql, String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:executeUpdate Not supported yet.");
    }

    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCPREPSTATEMNT:execute(String sql, int autoGeneratedKeys) Not supported yet.");
    }

    public boolean execute(String sql, int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCPREPSTATEMNT:execute(String sql, int[] columnIndexes) Not supported yet.");
    }

    public boolean execute(String sql, String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCPREPSTATEMNT:execute(String sql, String[] columnNames) Not supported yet.");
    }

    public int getResultSetHoldability() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:getResultSetHoldability Not supported yet.");
    }

    public boolean isClosed() throws SQLException
    {
        return closed;
    }

    public void setPoolable(boolean poolable) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:setPoolable Not supported yet.");
    }

    public boolean isPoolable() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:isPoolable Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:unwrap Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCPREPSTATEMNT:isWrapperFor Not supported yet.");
    }
}
