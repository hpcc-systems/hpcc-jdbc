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

import java.net.MalformedURLException;
import java.net.URL;
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
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Level;

import org.hpccsystems.ws.client.HPCCWsSQLClient;
import org.hpccsystems.ws.client.platform.Cluster;
import org.hpccsystems.ws.client.platform.DataQuerySet;
import org.hpccsystems.ws.client.platform.Platform;
import org.hpccsystems.ws.client.platform.Version;

import org.hpccsystems.ws.client.wrappers.gen.wssql.HPCCQuerySetWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.HPCCTableWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.NamedValueWrapper;
import org.hpccsystems.ws.client.wrappers.wsdfu.DFULogicalFileWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.ExecuteSQLResponseWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.ExecutePreparedSQLResponseWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.GetResultsResponseWrapper;
import org.hpccsystems.ws.client.wrappers.ArrayOfEspExceptionWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wsdfu.DFUSearchDataRequestWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wsdfu.DFUSearchDataResponseWrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.Columns_type1Wrapper;
import org.hpccsystems.ws.client.wrappers.gen.wssql.ECLWorkunitWrapper;

/**
 * The JDBC-HPCC connection consists of up to two distinct service end points.
 * The services are WsSQL and WsECLWatch, which can share the same hostname and port,
 * but could also reside on distinct hosts and/or port
 */
public class HPCCConnection implements Connection
{
    protected final Object       closedLock = new Object();
    private boolean              closed = true;
    private HPCCDatabaseMetaData metadata;
    private Properties           connectionProps;
    private Properties           clientInfo;
    private SQLWarning           warnings = null;
    private String               catalog = HPCCJDBCUtils.HPCCCATALOGNAME;

    private Platform                    hpccPlatform              = null;
    private HPCCWsSQLClient             wsSQLClient               = null;

    private String                      targetcluster;
    private String                      queryset;
    private String                      userName;
    private int                         pageSize;
    private int                         pageOffset;
    private int                         connectTimeoutMillis;
    private int                         readTimoutMillis;
    private int                         eclResultLimit;
    private boolean                     hasTargetWsSQLBeenReached = false;

    public HPCCConnection(Properties props)
    {
        this.connectionProps = props;

        String wsECLWatchAddress = props.getProperty("WsECLWatchAddress", HPCCDriver.SERVERADDRESSDEFAULT);
        String wsSQLAddress = props.getProperty("ServerAddress", HPCCDriver.SERVERADDRESSDEFAULT);

        if (wsSQLAddress.isEmpty())
        {
            SQLWarning warn = new SQLWarning("ServerAddress (WsSQL) not provided!");
            addWarning(warn);
            HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());

            return;
        }

        if (wsECLWatchAddress.isEmpty())
        {
            wsECLWatchAddress = wsSQLAddress;
            SQLWarning warn = new SQLWarning("WsECLWatch configuration not provided, WsSQL and ECLWatch expected on: '" + wsSQLAddress + "'");
            addWarning(warn);
            HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
        }

        this.targetcluster = props.getProperty("TargetCluster", HPCCDriver.CLUSTERDEFAULT);
        this.queryset = props.getProperty("QuerySet", HPCCDriver.QUERYSETDEFAULT);

        this.userName = props.getProperty("username", "");
        this.pageSize = HPCCJDBCUtils.stringToInt(props.getProperty("PageSize"), Integer.valueOf(HPCCDriver.FETCHPAGESIZEDEFAULT));
        this.pageOffset = HPCCJDBCUtils.stringToInt(props.getProperty("PageOffset"), Integer.valueOf(HPCCDriver.FETCHPAGEOFFSETDEFAULT));
        this.connectTimeoutMillis = HPCCJDBCUtils.stringToInt(props.getProperty("ConnectTimeoutMilli"), Integer.valueOf(HPCCDriver.CONNECTTIMEOUTMILDEFAULT));
        this.readTimoutMillis = HPCCJDBCUtils.stringToInt(props.getProperty("ReadTimeoutMilli"), Integer.valueOf(HPCCDriver.READTIMEOUTMILDEFAULT));
        this.eclResultLimit = HPCCJDBCUtils.stringToInt(props.getProperty("EclResultLimit"),HPCCDriver.ECLRESULTLIMDEFAULTINT);
        HPCCJDBCUtils.traceoutln(Level.INFO, "HPCCDatabaseMetaData ServerAddress: " + wsSQLAddress + " TargetCluster: " + targetcluster);

        synchronized (closedLock)
        {
            try
            {
                URL wsECLWatchURL = null;
                try
                {
                    wsECLWatchURL = new URL(!wsECLWatchAddress.isEmpty() ? wsECLWatchAddress : wsSQLAddress);
                }
                catch (MalformedURLException e)
                {
                    wsECLWatchURL = new URL(HPCCJDBCUtils.defaultprotocol+HPCCJDBCUtils.protocolsep+wsECLWatchURL);
                    SQLWarning warn = new SQLWarning("wsECLWatchAddress URL could not be parsed, defaulting to: '" +wsECLWatchURL.toString() + "'");
                    addWarning(warn);
                    HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                }

                int wsEclWatchPort = -1;
                if (wsECLWatchURL.getPort() == -1)
                    wsEclWatchPort =  HPCCJDBCUtils.stringToInt(props.getProperty("WsSQLPort"), Integer.valueOf(HPCCDriver.WSSQLPORTDEFAULT));
                else
                {
                    wsEclWatchPort = wsECLWatchURL.getPort();
                }

                hpccPlatform = Platform.get(wsECLWatchURL.getProtocol(), wsECLWatchURL.getHost(), wsEclWatchPort, userName, props.getProperty("password", ""));
                if (hpccPlatform.isDisabled())
                {
                    SQLWarning warn = new SQLWarning("ECLWatch not accessible on " + wsECLWatchURL.getProtocol() + "://" + wsECLWatchURL.getHost() + ":" + wsEclWatchPort);
                    addWarning(warn);
                    HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                    return;
                }

                URL wsSQLURL = null;
                try
                {
                    wsSQLURL = new URL(wsSQLAddress);
                }
                catch (MalformedURLException e)
                {
                    wsSQLURL = new URL(HPCCJDBCUtils.defaultprotocol+HPCCJDBCUtils.protocolsep+wsSQLAddress);
                    SQLWarning warn = new SQLWarning("wsSQL (ServerAddress) URL could not be parsed, defaulting to: '" +wsSQLURL.toString() + "'");
                    addWarning(warn);
                    HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                }

                int wsSQLPort = -1;
                if (wsSQLURL.getPort() == -1)
                    wsSQLPort =  HPCCJDBCUtils.stringToInt(props.getProperty("WsSQLPort"), Integer.valueOf(HPCCDriver.WSSQLPORTDEFAULT));
                else
                    wsSQLPort = wsSQLURL.getPort();

                wsSQLClient = HPCCWsSQLClient.get(wsSQLURL.getProtocol(), wsSQLURL.getHost(), Integer.toString(wsSQLPort), userName, props.getProperty("password", ""));

                if (!wsSQLClient.isWsSQLReachable())
                {
                    SQLWarning warn = new SQLWarning("The HPCC WsSQL service could not be reached on " + wsSQLURL + " on port '" + wsSQLPort + "'");
                    addWarning(warn);
                    HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                    return;
                }
                else
                    hasTargetWsSQLBeenReached = true;

                HPCCJDBCUtils.traceoutln(Level.INFO, "HPCCDatabaseMetaData initialized");
            }
            catch (MalformedURLException e)
            {
                SQLWarning warn = new SQLWarning("Error initializing HPCCDatabaseMetaData:" + e.getLocalizedMessage());
                addWarning(warn);
                HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                return;
            }
            catch (Exception e)
            {
                SQLWarning warn = new SQLWarning("Error initializing WsClient in HPCCDatabaseMetaData:" + e.getLocalizedMessage());
                addWarning(warn);
                HPCCJDBCUtils.traceoutln(Level.SEVERE, warn.getMessage());
                return;
            }

            // TODO not doing anything w/ this yet, just exposing it to comply w/ API definition...
            clientInfo = new Properties();

            if (hasTargetWsSQLBeenReached())
            {
                synchronized (closedLock)
                {
                    closed = false;
                }

                //considering that metadata keeps a copy of this connection, I wish metadata would not be exposed by the connection as well
                metadata = new HPCCDatabaseMetaData(this);

                HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCCConnection initialized - server: " + this.connectionProps.getProperty("ServerAddress"));
            }
            else
            {
                SQLWarning warn = new SQLWarning("HPCCConnection not initialized - server: " + this.connectionProps.getProperty("ServerAddress"));
                addWarning(warn);
                HPCCJDBCUtils.traceoutln(Level.INFO, warn.getMessage());
            }
        }
    }

    private void addWarning(SQLWarning warning)
    {
        if (warnings == null)
            warnings = new SQLWarning();
        warnings.setNextException(warning);
    }

    public DFUSearchDataResponseWrapper getDFUData(DFUSearchDataRequestWrapper dfuDataRequest) throws ArrayOfEspExceptionWrapper, Exception
    {
        return hpccPlatform.checkOutHPCCWsClient().getWsDFUClient().getDFUData(dfuDataRequest);
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public static String createBasicAuth(String username, String passwd)
    {
        return "Basic " + HPCCJDBCUtils.Base64Encode((username + ":" + passwd).getBytes(), false);
    }

    public Properties getProperties()
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getProperties(  )");
        return connectionProps;
    }

    public String getProperty(String propname)
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getProperty( " + propname + " )");
        return connectionProps.getProperty(propname, "");
    }

    public String getServerAddress()
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getServerAddress( )");
        return this.connectionProps.getProperty("ServerAddress");
    }

    public void setServerAddress(String serverAddress)
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: setServerAddress( " + serverAddress + " )");
        this.connectionProps.setProperty("ServerAddress", serverAddress);
    }

    public HPCCDatabaseMetaData getDatabaseMetaData()
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getDatabaseMetaData(  )");
        return metadata;
    }

    public void setMetadata(HPCCDatabaseMetaData metadata)
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCCConnection: setMetadata(  )");
        this.metadata = metadata;
    }

    public Statement createStatement() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCCConnection: createStatement(  )");
        return new HPCCStatement(this);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  "HPCCConnection: prepareStatement( " + query + " )");
        HPCCPreparedStatement p = new HPCCPreparedStatement(this, query);
        SQLWarning prepstmtexcp = p.getWarnings();
        if (prepstmtexcp != null)
            throw (SQLException)prepstmtexcp.getNextException();

        return p;
    }

    public CallableStatement prepareCall(String sql) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,"HPCCConnection: prepareCall(string sql) Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: prepareCall(string sql) Not supported yet.");
    }

    public String nativeSQL(String sql) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: nativeSQL(string sql) Not supported yet.");
        return sql;
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: setAutoCommit(boolean autoCommit) Not supported yet.");
    }

    public boolean getAutoCommit() throws SQLException
    {
        return true;
    }

    public void commit() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: commit Not supported yet.");
    }

    public void rollback() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: rollback Not supported yet.");
    }

    public void close() throws SQLException
    {
        synchronized (closedLock)
        {
            HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCConnection: close( )");
            if (!closed)
            {
                closed = true;
                metadata = null;
                hpccPlatform = null;
                wsSQLClient = null;
            }
        }
    }

    public boolean isClosed()
    {
        synchronized (closedLock)
        {
            return closed;
        }
    }

    public DatabaseMetaData getMetaData() throws SQLException
    {
        return metadata;
    }

    public void setReadOnly(boolean readOnly) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: setReadOnly Not supported yet.");
    }

    public boolean isReadOnly() throws SQLException
    {
        return true;
    }

    public void setCatalog(String catalog) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCConnection: setCatalog.");
        this.catalog = catalog;
    }

    public String getCatalog() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST, "HPCCConnection: getCatalog()");
        return catalog;
    }

    public void setTransactionIsolation(int level) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: settransactionisolation Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: settransactionisolation Not supported yet.");
    }

    public int getTransactionIsolation() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getTransactionIsolation Not supported yet.");
        return 0;
    }

    public SQLWarning getWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: getWarnings");
        return warnings;
    }

    public void clearWarnings() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: clearWarnings.");
        warnings = null;
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createStatement(resulttype, resultsetcon)##");
        return new HPCCPreparedStatement(this, null);
    }

    public PreparedStatement prepareStatement(String query, int resultSetType, int resultSetConcurrency)
            throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareStatement(" + query + ", resultsetype, resultsetcon)##");
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
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "releaseSavepoint Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: releaseSavepoint Not supported yet.");
    }

    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: createStatement Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
    }

    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareCall Not supported yet.");
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareStatement(String sql, int autoGeneratedKeys)  Not supported yet.");
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int autoGeneratedKeys) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareStatement(String sql, int[] columnIndexes) Not supported yet.");
        throw new UnsupportedOperationException(
                "HPCCConnection: prepareStatement(String sql, int[] columnIndexes) Not supported yet.");
    }

    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: prepareStatement(String sql, String[] columnNames) Not supported yet.");
        throw new UnsupportedOperationException(
                "HPCCConnection:  prepareStatement(String sql, String[] columnNames) Not supported yet.");
    }

    public Clob createClob() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createClob Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: createClob Not supported yet.");
    }

    public Blob createBlob() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createBlob Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: createBlob Not supported yet.");
    }

    public NClob createNClob() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createNClob Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: createNClob Not supported yet.");
    }

    public SQLXML createSQLXML() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: createSQLXML Not supported yet.");
        throw new UnsupportedOperationException("HPCCConnection: createSQLXML Not supported yet.");
    }

    public boolean isValid(int timeout) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCConnection: isValid");
        if (!isClosed())
            return hasTargetWsSQLBeenReached();

        return false;
    }

    public void setClientInfo(String name, String value) throws SQLClientInfoException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCCONNECTION SETCLIENTINFO(" + name + ", " + value + ")");
        clientInfo.put(name, value);
    }

    public void setClientInfo(Properties properties) throws SQLClientInfoException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCCONNECTION SETCLIENTINFO (properties)");
        clientInfo = properties;
    }

    public String getClientInfo(String name) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCCONNECTION GETCLIENTINFO");
        return clientInfo.getProperty(name);
    }

    public Properties getClientInfo() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCCONNECTION GETCLIENTINFO");
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

    public boolean hasTargetWsSQLBeenReached()
    {
        return hasTargetWsSQLBeenReached;
    }

    public Platform getHPCCPlatform()
    {
        return hpccPlatform;
    }

    public ExecuteSQLResponseWrapper executeSQL(String sqlquery) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        if (wsSQLClient == null)
            throw new SQLException("ERROR: WsSQLClient not available");

        return wsSQLClient.executeSQLFullResponse(sqlquery, targetcluster, queryset, eclResultLimit, pageSize,pageOffset, false, false, userName, readTimoutMillis);
    }

    public List<DFULogicalFileWrapper> getHPCCTables(String filenamefilter) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return hpccPlatform.checkOutHPCCWsClient().getWsDFUClient().getLogicalFiles(filenamefilter, "", pageSize, pageOffset, pageSize);
    }

    public Columns_type1Wrapper getHPCCTableColumns(String filenamefilter) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        HPCCTableWrapper[] table = wsSQLClient.getTables(filenamefilter);
        if (table != null && table.length > 0)
            return table[0].getColumns();

        return null;
    }

    public HPCCQuerySetWrapper[] getStoredProcedures(String querysetname) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return wsSQLClient.getStoredProcedures(querysetname);
    }

    public DataQuerySet[] getDataQuerySets() throws SQLException
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return hpccPlatform.getDataQuerySets();
    }

    public Cluster[] getClusters() throws SQLException
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return hpccPlatform.getClusters();
    }

    public Version getVersion() throws SQLException
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return wsSQLClient.getVersion();
    }

    public ECLWorkunitWrapper prepareSQL(String sqlQuery) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        return wsSQLClient.prepareSQL(sqlQuery, targetcluster, queryset, connectTimeoutMillis);
    }

    public ExecutePreparedSQLResponseWrapper executePreparedSQL(String wuid, NamedValueWrapper[] variables) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        if (wsSQLClient == null)
            throw new SQLException("ERROR: WsSQLClient not available");


        return wsSQLClient.executePreparedSQL(wuid, targetcluster, variables, readTimoutMillis, eclResultLimit, pageOffset, pageSize, userName, false, false);
    }

    public GetResultsResponseWrapper fetchResults(String wuid, int resultWindowStart, int resultWindowCount) throws Exception
    {
        if (isClosed())
            throw new SQLException("ERROR: HPCCConnection is closed");

        if (wsSQLClient == null)
            throw new SQLException("ERROR: WsSQLClient not available");

        return wsSQLClient.getResultResponse(wuid, resultWindowStart, resultWindowCount, true);
    }

    //Introduced in java 1.7@Override
    public void setSchema(String schema) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setSchema Not supported yet.");
    }

    //Introduced in java 1.7@Override
    public String getSchema() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: getSchema Not supported yet.");
    }

    //Introduced in java 1.7@Override
    public void abort(Executor executor) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: abort Not supported yet.");
    }

    //Introduced in java 1.7@Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: setNetworkTimeout Not supported yet.");
    }

    //Introduced in java 1.7@Override
    public int getNetworkTimeout() throws SQLException
    {
        throw new UnsupportedOperationException("HPCCConnection: getNetworkTimeout Not supported yet.");
    }
}
