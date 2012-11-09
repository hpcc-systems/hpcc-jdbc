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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.HashMap;

import org.hpccsystems.jdbcdriver.HPCCJDBCUtils.TraceLevel;
import org.w3c.dom.NodeList;

/**
 *
 * @author ChalaAX, rpastrana
 */

public class HPCCStatement implements Statement
{
    protected boolean                  closed        = false;
    protected String                   sqlQuery;
    protected HPCCConnection           hpccConnection;
    protected SQLWarning               warnings;
    protected HPCCResultSet            result        = null;
    protected HPCCResultSetMetadata    resultMetadata = null;

    protected HPCCDatabaseMetaData     dbMetadata;
    protected ECLEngine                eclQuery = null;
    protected SQLParser                parser = new SQLParser();
    protected static final String      className = "HPCCStatement";
    public static final String         hpccResultSetName = "HPCC Result";

    public HPCCStatement(Connection conn)
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,   className + "Constructor(conn)");
        this.hpccConnection = (HPCCConnection)conn;
        this.dbMetadata = hpccConnection.getDatabaseMetaData();
    }

    protected void processQuery()
    {
        try
        {
            HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  className + "Attempting to process sql query: " + sqlQuery);
            if (!this.closed)
            {
                if (parser != null)
                    parser.process(sqlQuery);
                else
                    throw new SQLException("Error parser is not ready, cannot execute query");

                eclQuery = new ECLEngine(parser, dbMetadata, hpccConnection.getProperties());

                eclQuery.generateECL();
                resultMetadata = new HPCCResultSetMetadata(eclQuery.getExpectedRetCols(), hpccResultSetName);
            }
            else
                throw new SQLException("HPCCPreparedStatement closed, cannot execute query");
        }
        catch (SQLException e)
        {
            HPCCJDBCUtils.traceoutln(TraceLevel.ERROR,  e.getLocalizedMessage());
            if (warnings == null)
                warnings = new SQLWarning();
            warnings.setNextException(e);

            eclQuery = null;
            parser = null;
        }
    }

    protected ResultSet executeHPCCQuery(HashMap<Integer, Object> params) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  className + ": executeQuery()");
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  "\tAttempting to process sql query: " + sqlQuery);
        result = null;

        try
        {
            if (!this.closed)
            {
                if (eclQuery == null)
                {
                    String message = className + ":  Cannot execute SQL command";

                    if (warnings != null)
                    {
                        SQLException  we = warnings.getNextException();
                        if(we != null)
                            message += "\n\t" + we.getLocalizedMessage();
                    }
                    throw new SQLException(message);
                }

                NodeList rowList = eclQuery.execute(params);

                if (rowList != null)
                    result = new HPCCResultSet(this, rowList, resultMetadata);
            }
            else
                throw new SQLException(className + "is closed, cannot execute query");
        }
        catch (Exception e)
        {
            throw convertToSQLExceptionAndAddWarn(e);
        }

        return result;
    }

    private SQLException convertToSQLExceptionAndAddWarn(Exception e)
    {
        SQLException sqlexcept = new SQLException(e.getLocalizedMessage());
        sqlexcept.setStackTrace(e.getStackTrace());

        if (warnings == null)
            warnings = new SQLWarning();

        warnings.setNextException(sqlexcept);

        return sqlexcept;
    }

    public ResultSet executeQuery(String sql) throws SQLException
    {
        sqlQuery = sql;

        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  className + ": executeQuery(" + sql + ")");

        processQuery();

        return executeHPCCQuery(null);
    }

    public int executeUpdate(String sql) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": executeUpdate(String sql) Not supported yet.");
    }

    public void close() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": close( )");
        if (!closed)
        {
            closed = true;
            hpccConnection = null;
            result = null;
            sqlQuery = null;
            dbMetadata = null;
            parser = null;
            eclQuery = null;
        }
    }

    public int getMaxFieldSize() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getMaxFieldSize() Not supported yet.");
    }

    public void setMaxFieldSize(int max) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": setMaxFieldSize(int max) Not supported yet.");
    }

    public int getMaxRows() throws SQLException
    {
        try
        {
            HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": getMaxRows()");
            return Integer.parseInt(this.hpccConnection.getProperty("EclLimit"));
        }
        catch (Exception e)
        {
            throw new SQLException("Could not determine MaxRows");
        }
    }

    public void setMaxRows(int max) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": setMaxRows(int max) Not supported yet.");
    }

    public void setEscapeProcessing(boolean enable) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": setEscapeProcessing(boolean enable) Not supported yet.");
    }

    public int getQueryTimeout() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": getQueryTimeout()");
        return 0;
    }

    public void setQueryTimeout(int seconds) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": setQueryTimeout()");
    }

    public void cancel() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": cancel()  Not supported yet.");
    }

    public SQLWarning getWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": getWarnings()");
        return warnings;
    }

    public void clearWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.VERBOSE,  className + ": clearWarnings()");
        warnings = null;
    }

    public void setCursorName(String name) throws SQLException
    {
        throw new UnsupportedOperationException(className + ":  setCursorName(String name) Not supported yet.");
    }

    public boolean execute(String sql) throws SQLException
    {
        sqlQuery = sql;

        processQuery();

        return execute();
    }

    public boolean execute() throws SQLException
    {
        result = null;
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  className + ": execute()");
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO,  "\tAttempting to process sql query: " + sqlQuery);
        try
        {
            result = (HPCCResultSet) executeHPCCQuery(null);
        }
        catch (Exception e)
        {
            //Unlikely to occur, but if it does, should report in sqlwarnings
            throw convertToSQLExceptionAndAddWarn(e);
        }
        return result != null;
    }

    public ResultSet getResultSet() throws SQLException
    {
        return result;
    }

    public int getUpdateCount() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO, className + ":getUpdateCount: -1");
        return -1;
    }

    public boolean getMoreResults() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getMoreResults Not supported yet.");
    }

    public void setFetchDirection(int direction) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": only ResultSet.FETCH_FORWARD supported");
    }

    public int getFetchDirection() throws SQLException
    {
        return ResultSet.FETCH_FORWARD;
    }

    public void setFetchSize(int rows) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(TraceLevel.INFO, className + ": setFetchSize Not supported yet.");
    }

    public int getFetchSize() throws SQLException
    {
        return -1;
    }

    public int getResultSetConcurrency() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getResultSetConcurrency() Not supported yet.");
    }

    public int getResultSetType() throws SQLException
    {
        throw new UnsupportedOperationException(className + ":  getResultSetType() Not supported yet.");
    }

    public void addBatch(String sql) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": addBatch(String sql) Not supported yet.");
    }

    public void clearBatch() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": clearBatch() Not supported yet.");
    }

    public int[] executeBatch() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": executeBatch() Not supported yet.");
    }

    public Connection getConnection() throws SQLException
    {
        return hpccConnection;
    }

    public boolean getMoreResults(int current) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getMoreResults(int current) Not supported yet.");
    }

    public ResultSet getGeneratedKeys() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getGeneratedKeys() Not supported yet.");
    }

    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ": executeUpdate(String sql, int autoGeneratedKeys) Not supported yet.");
    }

    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ":  executeUpdate(String sql, int[] columnIndexes) Not supported yet.");
    }

    public int executeUpdate(String sql, String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ": executeUpdate(String sql, String[] columnNames) Not supported yet.");
    }

    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ": execute(String sql, int autoGeneratedKeys) Not supported yet.");
    }

    public boolean execute(String sql, int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ":  execute(String sql, int[] columnIndexes) Not supported yet.");
    }

    public boolean execute(String sql, String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException(
                className + ": execute(String sql, String[] columnNames) Not supported yet.");
    }

    public int getResultSetHoldability() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": getResultSetHoldability Not supported yet.");
    }

    public boolean isClosed() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": isClosed() Not supported yet.");
    }

    public void setPoolable(boolean poolable) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": Not supported yet.");
    }

    public boolean isPoolable() throws SQLException
    {
        throw new UnsupportedOperationException(className + ": Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        throw new UnsupportedOperationException(className + ": Not supported yet.");
    }

}
