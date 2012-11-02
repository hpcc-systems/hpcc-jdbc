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

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author rpastrana
 */

public class HPCCConnection implements Connection
{
    private boolean              closed;
    private HPCCDatabaseMetaData metadata;
    private Properties           connectionProps;
    private Properties           clientInfo;

    public HPCCConnection(Properties props)
    {
        this.connectionProps = props;

        metadata = new HPCCDatabaseMetaData(props);

        // TODO not doing anything w/ this yet, just exposing it to comply w/ API definition...
        clientInfo = new Properties();

        closed = false;

        System.out.println("HPCCConnection initialized - server: " + this.connectionProps.getProperty("ServerAddress"));
    }

    public static String createBasicAuth(String username, String passwd)
    {
        return "Basic " + HPCCJDBCUtils.Base64Encode((username + ":" + passwd).getBytes(), false);
    }

    public Properties getProperties()
    {
        return connectionProps;
    }

    public String getProperty(String propname)
    {
        return connectionProps.getProperty(propname, "");
    }

    public String getServerAddress()
    {
        return this.connectionProps.getProperty("ServerAddress");
    }

    public void setServerAddress(String serverAddress)
    {
        this.connectionProps.setProperty("ServerAddress", serverAddress);
    }

    public HPCCDatabaseMetaData getDatabaseMetaData()
    {
        return metadata;
    }

    public void setMetadata(HPCCDatabaseMetaData metadata)
    {
        this.metadata = metadata;
    }

    public Statement createStatement() throws SQLException
    {
        return new HPCCPreparedStatement(this, null);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException
    {
        HPCCPreparedStatement p = new HPCCPreparedStatement(this, query);
        SQLWarning prepstmtexcp = p.getWarnings();
        if (prepstmtexcp != null)
            throw (SQLException)prepstmtexcp.getNextException();

        return p;
    }

    public CallableStatement prepareCall(String sql) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: prepareCall(string sql) Not supported yet.");
    }

    public String nativeSQL(String sql) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: nativeSQL(string sql) Not supported yet.");
        return sql;
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: setAutoCommit(boolean autoCommit) Not supported yet.");
    }

    public boolean getAutoCommit() throws SQLException
    {
        return true;
    }

    public void commit() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: commit Not supported yet.");
    }

    public void rollback() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: rollback Not supported yet.");
    }

    public void close() throws SQLException
    {
        closed = true;
    }

    public boolean isClosed() throws SQLException
    {
        return closed;
    }

    public DatabaseMetaData getMetaData() throws SQLException
    {
        return metadata;
    }

    public void setReadOnly(boolean readOnly) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: setReadOnly");
    }

    public boolean isReadOnly() throws SQLException
    {
        return true;
    }

    public void setCatalog(String catalog) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: setCatalog Not supported yet.");
    }

    public String getCatalog() throws SQLException
    {
        return "HPCC Catalog";
    }

    public void setTransactionIsolation(int level) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: settransactionisolation Not supported yet.");
    }

    public int getTransactionIsolation() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: getTransactionIsolation Not supported yet.");
        return 0;
    }

    public SQLWarning getWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: getWarnings Not supported yet.");
        return null;
    }

    public void clearWarnings() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: clearWarnings Not supported yet.");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: createStatement(resulttype, resultsetcon)##");
        return new HPCCPreparedStatement(this, null);
    }

    public PreparedStatement prepareStatement(String query, int resultSetType, int resultSetConcurrency)
            throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: prepareStatement(" + query + ", resultsetype, resultsetcon)##");
        return new HPCCPreparedStatement(this, query);
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareCall(String sql, int resultSetType, int resultSetConcurrency) Not supported yet.");
    }

    public Map<String, Class<?>> getTypeMap() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: getTypeMap Not supported yet.");
    }

    public void setTypeMap(Map<String, Class<?>> map) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setTypeMap Not supported yet.");
    }

    public void setHoldability(int holdability) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setHoldability Not supported yet.");
    }

    public int getHoldability() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: getHoldability Not supported yet.");
    }

    public Savepoint setSavepoint() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setSavepoint Not supported yet.");
    }

    public Savepoint setSavepoint(String name) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setSavepoint Not supported yet.");
    }

    public void rollback(Savepoint savepoint) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: rollback Not supported yet.");
    }

    public void releaseSavepoint(Savepoint savepoint) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: releaseSavepoint Not supported yet.");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: createStatement Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int autoGeneratedKeys) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int[] columnIndexes) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection:  prepareStatement(String sql, String[] columnNames) Not supported yet.");
    }

    public Clob createClob() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: createClob Not supported yet.");
    }

    public Blob createBlob() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: createBlob Not supported yet.");
    }

    public NClob createNClob() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: createNClob Not supported yet.");
    }

    public SQLXML createSQLXML() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: createSQLXML Not supported yet.");
    }

    public boolean isValid(int timeout) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCConnection: isValid Not supported yet.");
        return timeout >= 0;
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException
    {
        HPCCJDBCUtils.traceoutln("HPCCCONNECTION SETCLIENTINFO(" + name + ", " + value + ")");
        clientInfo.put(name, value);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException
    {
        HPCCJDBCUtils.traceoutln("HPCCCONNECTION SETCLIENTINFO (properties)");
        clientInfo = properties;
    }

    public String getClientInfo(String name) throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCCONNECTION GETCLIENTINFO");
        return clientInfo.getProperty(name);
    }

    public Properties getClientInfo() throws SQLException
    {
        HPCCJDBCUtils.traceoutln("HPCCCONNECTION GETCLIENTINFO");
        return clientInfo;
    }

    public Array createArrayOf(String typeName, Object[] elements) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: createArrayOf(String typeName, Object[] elements) Not supported yet.");
    }

    public Struct createStruct(String typeName, Object[] attributes) throws SQLException
    {
        throw new UnsupportedOperationException(
                "HPCCConnection: createStruct(String typeName, Object[] attributes)Not supported yet.");
    }

    public <T> T unwrap(Class<T> iface) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: unwrap(Class<T> iface) Not supported yet.");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: isWrapperFor(Class<?> iface) sNot supported yet.");
    }
}
