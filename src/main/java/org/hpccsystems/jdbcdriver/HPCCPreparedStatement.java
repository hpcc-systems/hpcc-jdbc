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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import java.util.Set;
import java.util.logging.Level;

import org.hpccsystems.ws.client.gen.extended.wssql.v3_03.ECLWorkunit;
import org.hpccsystems.ws.client.gen.extended.wssql.v3_03.ExecutePreparedSQLResponse;
import org.hpccsystems.ws.client.gen.extended.wssql.v3_03.NamedValue;
import org.hpccsystems.ws.client.platform.Workunit;

/**
 *
 * @author rpastrana
 */

public class HPCCPreparedStatement extends HPCCStatement implements PreparedStatement
{
    private HashMap<Integer, Object> parameters    = new HashMap<Integer, Object>();
    protected static final String      className = "HPCCPreparedStatement";
    private ECLWorkunit preparedSQL = null;

    public HPCCPreparedStatement(Connection connection, String query)
    {
        super(connection);

        HPCCJDBCUtils.traceoutln(Level.INFO, className + " Constructor: Sqlquery: " + query);
        this.sqlQuery = query;

        if (sqlQuery != null)
            prepareQuery();
        else
        {
            if (warnings == null)
                warnings = new SQLWarning();
            warnings.setNextException(new SQLWarning("SQL Query seems to be empty!"));
        }
    }

    public ResultSet executeQuery() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO, className + ":executeQuery()");
        HPCCJDBCUtils.traceoutln(Level.INFO,  "\tAttempting to execute Prepared sql query: " + sqlQuery);
        result = null;

        try
        {
            if (!isClosed())
            {
                if (preparedSQL == null || preparedSQL.getWuid().isEmpty() || Workunit.isFailedState(preparedSQL.getState()))
                {
                    String message = className + ":  Cannot execute prepared SQL command";

                    if (warnings != null)
                    {
                        SQLException  we = warnings.getNextException();
                        if(we != null)
                            message += "\n\t" + we.getLocalizedMessage();
                    }
                    throw new SQLException(message);
                }

                NamedValue[] variables = new NamedValue[parameters.size()];

                Set<Integer> keySet = parameters.keySet();
                for (int i = 0; i < keySet.size(); i++)
                {
                    try
                    {
                        variables[i] = new NamedValue("variable-"+(i+1),primitiveToString(parameters.get(i+1)));
                    }
                    catch (IOException e)
                    {
                        throw new SQLException("Could not bind "+ i +"th parameter during query execution: " + e.getLocalizedMessage());
                    }
                }

                //if (Workunit.translateWUState(preparedSQL.getState()) != WUState.COMPILED) for some reason, we can get a:
                //"Attempting to execute a workunit that hasn't been compiled" even if we get a "compiled" state!
                ExecutePreparedSQLResponse executePreparedSQL = hpccConnection.executePreparedSQL(preparedSQL.getWuid(), variables);

                result = new HPCCResultSet(hpccConnection, executePreparedSQL.getWorkunit().getWuid(), hpccResultSetName);
                result.parseDataset("<root>"+executePreparedSQL.getResult()+"</root>");
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

    public static String primitiveToString(Object x) throws IOException
    {
        if (x != null)
        {
            if (x instanceof String)
                return (String)x;
            else if (x instanceof Boolean)
                return String.valueOf(x);
            else if (x instanceof Integer)
                return String.valueOf(x);
            else if (x instanceof Long)
                return String.valueOf(x);
            else if (x instanceof Float)
                return String.valueOf(x);
            else if (x instanceof Byte)
                return Byte.toString((Byte)x);
            else if (x instanceof Short)
                return Short.toString((Short)x);
            else if (x instanceof Double)
                return String.valueOf(x);
            else if (x instanceof BigDecimal)
                return ((BigDecimal)x).toString();
            else if (x instanceof byte[])
                return new String((byte[])x, StandardCharsets.UTF_8);
            else if (x instanceof Time)
                return ((Time)x).toString();
            else if (x instanceof java.sql.Date)
                return ((java.sql.Date)x).toString();
            else if (x instanceof Timestamp)
                return ((Timestamp)x).toString();
            else if (x instanceof Character)
                return String.valueOf((Character)x);
            else if (x instanceof InputStream)
            {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = ((InputStream)x).read(buffer)) != -1)
                {
                    result.write(buffer, 0, length);
                    if (length < buffer.length) //avoids one last input stream read
                        break;
                }

                return result.toString("UTF-8");

                //Requires java 7
                //try(java.util.Scanner s = new java.util.Scanner((InputStream)x, "UTF-8"))
                //{
                //    return s.useDelimiter("\\A").hasNext() ? s.next() : "";
                //}
            }
            else
                return (String)x;
        }
        else
            return null;
    }

    public int executeUpdate() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ":  executeUpdate Not supported yet.");
        throw new UnsupportedOperationException(className + ":  executeUpdate Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNull(" + parameterIndex + ", " + sqlType + " )");
        throw new SQLException("NULL cannot be represented in ECL.");
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBoolean(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setByte(int parameterIndex, byte x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setByte(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setShort(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setInt(int parameterIndex, int x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setInt(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setLong(int parameterIndex, long x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setLong(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setFloat(int parameterIndex, float x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setFloat(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setDouble(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBigDecimal(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setString(int parameterIndex, String x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setString(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBytes(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setDate(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setTime(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setTimestamp(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setAsciiStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setAsciiStream Not supported yet.");
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setUnicodeStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setUnicodeStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBinaryStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ":  setBinaryStream Not supported yet.");
    }

    public void clearParameters() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": clearParameters( )");
        parameters.clear();
    }

    public void setObject(int parameterIndex, Object x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setObject(" + parameterIndex + ", " + x + " )");

        if (x != null)
        {
            if (x instanceof String)
                setString(parameterIndex, (String) x);
            else if (x instanceof Boolean)
                setBoolean(parameterIndex, ((Boolean) x).booleanValue());
            else if (x instanceof Byte)
                setByte(parameterIndex, (Byte) x);
            else if (x instanceof Short)
                setShort(parameterIndex, ((Short) x).shortValue());
            else if (x instanceof Integer)
                setInt(parameterIndex, ((Integer) x).intValue());
            else if (x instanceof Long)
                setLong(parameterIndex, ((Long) x).longValue());
            else if (x instanceof Float)
                setFloat(parameterIndex, ((Float) x).floatValue());
            else if (x instanceof Double)
                setDouble(parameterIndex, ((Double) x).doubleValue());
            else if (x instanceof BigDecimal)
                setBigDecimal(parameterIndex, (BigDecimal) x);
            else if (x instanceof byte[])
                setBytes(parameterIndex, (byte[]) x);
            else if (x instanceof Time)
                setTime(parameterIndex, (Time) x);
            else if (x instanceof java.sql.Date)
                setDate(parameterIndex, (java.sql.Date) x);
            else if (x instanceof Timestamp)
                setTimestamp(parameterIndex, (Timestamp) x);
            else if (x instanceof InputStream)
                setBinaryStream(parameterIndex, (InputStream) x, -1);
            else
                parameters.put(parameterIndex, x);
        }
        else
        {
            setNull(parameterIndex, java.sql.Types.OTHER);
        }
    }

    public boolean execute() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.INFO,  className + ":execute()");
        HPCCJDBCUtils.traceoutln(Level.INFO,  "Attempting to process sql query: " + sqlQuery);
        return executeQuery() != null;
    }

    public void addBatch() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": addBatch(  )");
        throw new UnsupportedOperationException(className + ":  addBatch Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setCharacterStream(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setRef(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBlob(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setClob(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setArray(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public ResultSetMetaData getMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": getMetaData( )");
        return result != null ? result.getMetaData() : null;
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setDate(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setDate Not supported yet.");
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setTime(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setTime Not supported yet.");
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setTimestamp(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setTimestamp Not supported yet.");
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNull(" + parameterIndex + ", " + sqlType + " )");
        setNull(parameterIndex, sqlType);
    }

    public void setURL(int parameterIndex, URL x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setURL(" + parameterIndex + ", " + x + " )");
        parameters.put(parameterIndex, x);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  "HPCCPREPSTATEMENT getParameterMetaData");
        throw new UnsupportedOperationException(className + ": getParameterMetaData Not supported yet.");
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setRowId(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setRowId Not supported yet.");
    }

    public void setNString(int parameterIndex, String value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNString(" + parameterIndex + ", " + value + " )");
        parameters.put(parameterIndex, value);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNCharacterStream(" + parameterIndex + ", " + value + " )");
        throw new UnsupportedOperationException(className + ": setNCharacterStream Not supported yet.");
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNClob(" + parameterIndex + ", " + value + " )");
        parameters.put(parameterIndex, value);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBlob(" + parameterIndex + ", " + inputStream + " )");
        throw new UnsupportedOperationException(className + ": setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setNClob Not supported yet.");
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setSQLXML(" + parameterIndex + ", " + xmlObject + " )");
        parameters.put(parameterIndex, xmlObject);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setObject(" + parameterIndex + ", " + x + ", " + targetSqlType + " )");
        if (x != null)
        {
            setObject(parameterIndex, x, targetSqlType, 0);
        }
        else
        {
            setNull(parameterIndex, targetSqlType);
        }
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setObject(" + parameterIndex + ", " + x + " )");

        String targetSqlTypeName = null;
        try
        {
            targetSqlTypeName = HPCCJDBCUtils.getSQLTypeName(targetSqlType);
        }
        catch (Exception e)
        {
            targetSqlTypeName = "java.sql.Types." + targetSqlType;
        }
        if (x != null)
        {
            try
            {
                Class<?> clazz = x.getClass();

                switch (targetSqlType)
                {
                    case java.sql.Types.CHAR:
                    case java.sql.Types.VARCHAR:
                    case java.sql.Types.LONGVARCHAR:
                        if (clazz.equals(String.class))
                           setString(parameterIndex, (String)x);
                        else
                           setString(parameterIndex, x.toString());
                        break;
                    case java.sql.Types.BIT:
                    case java.sql.Types.BOOLEAN:
                        if (clazz.equals(String.class))
                            setBoolean(parameterIndex, Boolean.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setBoolean(parameterIndex, (Integer)x <= 0 ? false : true);
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setBoolean(parameterIndex, (Boolean)x);
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setBoolean(parameterIndex, Boolean.valueOf(x.toString()));
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setBoolean(parameterIndex, ((Byte)x).intValue() <= 0 ? false : true);
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setBoolean(parameterIndex, ((Double)x) <= 0 ? false : true);
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setBoolean(parameterIndex, ((Long)x) <= 0 ? false : true);
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setBoolean(parameterIndex, ((Float)x) <= 0 ? false : true);
                        else if (clazz.equals(Character.TYPE))
                            throw new Exception();
                        break;
                    case java.sql.Types.FLOAT:
                    case java.sql.Types.DOUBLE:
                        if (clazz.equals(String.class))
                            setDouble(parameterIndex, java.lang.Double.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setDouble(parameterIndex, ((Integer)x).doubleValue());
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setDouble(parameterIndex, ((Boolean)x) == true ? 1.0 : 0.0);
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setDouble(parameterIndex, ((Byte)x).doubleValue());
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setDouble(parameterIndex, ((Short)x).doubleValue());
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setDouble(parameterIndex, (Double)x);
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setDouble(parameterIndex, ((Long)x).doubleValue());
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setDouble(parameterIndex, ((Float)x).doubleValue());
                        else if (clazz.equals(Character.TYPE))
                            throw new Exception();
                        break;

                    case java.sql.Types.NUMERIC:
                    case java.sql.Types.DECIMAL:
                    {
                        BigDecimal bd = null;
                        if (clazz.equals(String.class))
                            bd = new BigDecimal((String)x);
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            bd = new BigDecimal((Integer)x);
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            bd = new BigDecimal((Boolean)x == true ? 1 : 0);
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                            bd = new BigDecimal((Character)x);
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            bd = new BigDecimal((Byte)x);
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            bd = new BigDecimal((Short)x);
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            bd = new BigDecimal((Double)x);
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            bd = new BigDecimal((Long)x);
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            bd = new BigDecimal((Float)x);

                        if (bd != null)
                        {
                            if (scaleOrLength > 0)
                                bd.setScale(scaleOrLength);
                            setBigDecimal(parameterIndex, bd);
                        }
                        else
                            throw new Exception();
                        break;
                    }
                    case java.sql.Types.TINYINT:
                        if (clazz.equals(String.class))
                            setByte(parameterIndex,java.lang.Byte.parseByte((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setByte(parameterIndex, ((Integer)x).byteValue());
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setByte(parameterIndex, ((Boolean)x == true ? ((Integer)1).byteValue() : ((Integer)0).byteValue()));
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                            setByte(parameterIndex,java.lang.Byte.parseByte(x.toString()));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setByte(parameterIndex, (Byte)x);
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setByte(parameterIndex, ((Short)x).byteValue());
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setByte(parameterIndex, ((Double)x).byteValue());
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setByte(parameterIndex, ((Long)x).byteValue());
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setByte(parameterIndex, ((Float)x).byteValue());
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.SMALLINT:
                        if (clazz.equals(String.class))
                            setShort(parameterIndex, java.lang.Short.parseShort((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setShort(parameterIndex, ((Integer)x).shortValue());
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setShort(parameterIndex, ((Boolean)x == true ? ((Integer)1).shortValue() : ((Integer)0).shortValue()));
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                            setShort(parameterIndex, java.lang.Short.parseShort(x.toString()));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setShort(parameterIndex, ((Byte)x).shortValue());
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setShort(parameterIndex, (Short)x);
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setShort(parameterIndex, ((Double)x).shortValue());
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setShort(parameterIndex, ((Long)x).shortValue());
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setShort(parameterIndex, ((Float)x).shortValue());
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.INTEGER:
                        if (clazz.equals(String.class))
                            setInt(parameterIndex, java.lang.Integer.parseInt((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setInt(parameterIndex, ((Integer)x));
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setInt(parameterIndex, ((Boolean)x == true ? 1 : 0));
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                               setInt(parameterIndex, java.lang.Integer.parseInt((String)x));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setInt(parameterIndex, ((Byte)x).intValue());
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setInt(parameterIndex, ((Short)x).intValue());
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setInt(parameterIndex, ((Double)x).intValue());
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setInt(parameterIndex, ((Long)x).intValue());
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setInt(parameterIndex, ((Float)x).intValue());
                        else
                            throw new Exception();
                        break;

                    case java.sql.Types.BIGINT:
                        Long l = null;
                        if (clazz.equals(String.class))
                        {
                            if (scaleOrLength > 0)
                                l = java.lang.Long.parseLong((String)x, scaleOrLength);
                            else
                                l = java.lang.Long.parseLong((String)x);
                        }
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            l = ((Integer)x).longValue();
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            l = ((Boolean)x == true ? ((Integer)1).longValue() : ((Integer)0).longValue());
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                        {
                            if (scaleOrLength > 0)
                                l = java.lang.Long.parseLong(x.toString(), scaleOrLength);
                            else
                                l = java.lang.Long.parseLong(x.toString());
                        }
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            l = ((Byte)x).longValue();
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            l = ((Short)x).longValue();
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            l = ((Double)x).longValue();
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            l = ((Long)x).longValue();
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            l = ((Float)x).longValue();

                        if (l != null)
                        {
                            setLong(parameterIndex, l);
                        }
                        else
                            throw new Exception();

                        break;
                    case java.sql.Types.REAL:
                        if (clazz.equals(String.class))
                            setFloat(parameterIndex, java.lang.Float.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setFloat(parameterIndex, ((Integer)x).floatValue());
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setFloat(parameterIndex, ((Boolean)x == true ? ((Integer)1).floatValue() : ((Integer)0).floatValue()));
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                            setFloat(parameterIndex, java.lang.Float.valueOf((x.toString())));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setFloat(parameterIndex, ((Byte)x).floatValue());
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setFloat(parameterIndex, ((Short)x).floatValue());
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setFloat(parameterIndex, ((Double)x).floatValue());
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setFloat(parameterIndex, (Long)x);
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setFloat(parameterIndex, ((Float)x).floatValue());
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.BINARY:
                    case java.sql.Types.VARBINARY:
                    case java.sql.Types.LONGVARBINARY:
                        if (clazz.equals(String.class))
                            setBytes(parameterIndex, ((String) x).getBytes());
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setBytes(parameterIndex, (((Integer)x).toString()).getBytes());
                        else if (clazz.equals(Boolean.class) || clazz.equals(Boolean.TYPE))
                            setBytes(parameterIndex, ((Boolean)x == true ? "1".getBytes() : "0".getBytes()));
                        else if (clazz.equals(Character.class) || clazz.equals(Character.TYPE))
                            setBytes(parameterIndex, x.toString().getBytes());
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setBytes(parameterIndex, (byte [])x);
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setBytes(parameterIndex, ((Short) x).toString().getBytes());
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setBytes(parameterIndex, ((Double)x).toString().getBytes());
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setBytes(parameterIndex, ((Long)x).toString().getBytes());
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setBytes(parameterIndex, ((Float)x).toString().getBytes());
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.DATE:
                        if (clazz.equals(String.class))
                            setDate(parameterIndex,java.sql.Date.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Integer)x).longValue()));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Byte)x).longValue()));
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Short)x).longValue()));
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Double)x).longValue()));
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Long)x)));
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setDate(parameterIndex, new java.sql.Date(((Float)x).longValue()));
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.TIME:
                        if (clazz.equals(String.class))
                            setTime(parameterIndex, java.sql.Time.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Integer)x).longValue()));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Byte)x).longValue()));
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Short)x).longValue()));
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Double)x).longValue()));
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Long)x)));
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setTime(parameterIndex, new java.sql.Time(((Float)x).longValue()));
                        else
                            throw new Exception();
                        break;
                    case java.sql.Types.TIMESTAMP:
                        if (clazz.equals(String.class))
                            setTimestamp(parameterIndex, java.sql.Timestamp.valueOf((String)x));
                        else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Integer)x).longValue()));
                        else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Byte)x).longValue()));
                        else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Short)x).longValue()));
                        else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Double)x).longValue()));
                        else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Long)x)));
                        else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE))
                            setTimestamp(parameterIndex, new java.sql.Timestamp(((Float)x).longValue()));
                        else
                            throw new Exception();
                        break;
                    default:
                        throw new Exception();
                }
            }
            catch (Exception e)
            {
                throw new SQLException("Cannot convert " + x.toString() + "(" + x.getClass() + ") to: " + targetSqlTypeName);
            }
        }
        else
        {
            setNull(parameterIndex, targetSqlType);
        }

        System.out.println(parameters.get(parameterIndex));
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setAsciiStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBinaryStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setCharacterStream(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setAsciiStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setAsciiStream Not supported yet.");
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBinaryStream(" + parameterIndex + ", " + x + " )");
        throw new UnsupportedOperationException(className + ": setBinaryStream Not supported yet.");
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setCharacterStream(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setCharacterStream Not supported yet.");
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNCharacterStream(" + parameterIndex + ", " + value + " )");
        throw new UnsupportedOperationException(className + ": setNCharacterStream Not supported yet.");
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setClob Not supported yet.");
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setBlob(" + parameterIndex + ", " + inputStream + " )");
        throw new UnsupportedOperationException(className + ": setBlob Not supported yet.");
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException
    {
        HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": setNClob(" + parameterIndex + ", " + reader + " )");
        throw new UnsupportedOperationException(className + ": setNClob Not supported yet.");
    }

    public void close()
    {
        synchronized (closedLock)
        {
            HPCCJDBCUtils.traceoutln(Level.FINEST,  className + ": close( )");
            if (!closed)
            {
                super.close();
                parameters = null;
            }
        }
    }

    protected boolean prepareQuery()
    {
        try
        {
            HPCCJDBCUtils.traceoutln(Level.INFO,  className + "Attempting to prepare sql query: " + sqlQuery);
            if (!isClosed())
            {
                preparedSQL = hpccConnection.prepareSQL(sqlQuery);

                if (preparedSQL == null || preparedSQL.getWuid().isEmpty())
                    throw new SQLException("HPCCPreparedStatement could not be prepared.");

                return true;
            }
            else
                throw new SQLException("HPCCPreparedStatement closed, cannot prepare query");
        }
        catch (SQLException e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE,   e.getLocalizedMessage());
            if (warnings == null)
                warnings = new SQLWarning();
            warnings.setNextException(e);

            close();
        }
        catch (Exception e)
        {
            HPCCJDBCUtils.traceoutln(Level.SEVERE,   e.getLocalizedMessage());
            if (warnings == null)
                warnings = new SQLWarning();
            warnings.setNextException(new SQLException(e.getLocalizedMessage()));

            close();
        }

        return false;
    }
}
