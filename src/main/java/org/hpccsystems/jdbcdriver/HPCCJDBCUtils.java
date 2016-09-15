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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HPCCJDBCUtils
{
    public static final String defaultprotocol = "http";
    public static final String protocolsep = "://";

    public static final String DOTSEPERATORREGEX = "\\.";

    public static String newLine = System.getProperty("line.separator");
    public static String fileSep = System.getProperty("file.separator");;
    public static final String HPCCCATALOGNAME = "HPCC System";
    private static String [] values;

    public static final Level defaultLogLevel = Level.INFO;
    public final static String traceFileName = "HPCCJDBC.log";
    public final static String workingDir = System.getProperty("user.dir") + fileSep;
    private static ConsoleHandler cHandler = null;
    private static FileHandler fHandler = null;

    private static HPCCJDBCLogFormatter formatter = new HPCCJDBCLogFormatter();
    private final static Logger logger = Logger.getLogger("org.hpccsystems.jdbcdriver");

    public static Logger getLogger()
    {
        return logger;
    }

    static
    {
        try
        {
            logger.setUseParentHandlers(false);

            cHandler = new HPCCJDBCStdOutConsoleHandler();
            cHandler.setFormatter(formatter);

            fHandler = new FileHandler(traceFileName);
            fHandler.setFormatter(formatter);
            fHandler.setLevel(Level.OFF);

            logger.addHandler(fHandler);
            logger.addHandler(cHandler);

        }
        catch (Exception e)
        {
            System.err.println(e.getStackTrace());
        }
    }

    static
    {
        values = new String [6];
        values[0] = Level.ALL.getName();
        values[1] = Level.SEVERE.getName();
        values[2] = Level.WARNING.getName();
        values[3] = Level.INFO.getName();
        values[4] = Level.FINEST.getName();
        values[5] = Level.OFF.getName();
    }

    public static String [] getTraceLevelStrOptions()
    {
        return values;
    }

    public static void initTracing(String level, boolean tofile)
    {
        Level lev = null;
        try
        {
            lev = Level.parse(level.toUpperCase());
        }
        catch (Exception e)
        {
            logger.log(Level.INFO, "Couldn't determine log level, will log at default level: " + defaultLogLevel.getName());
            lev =  defaultLogLevel;
        }

        for (Handler handler : logger.getHandlers())
        {
            if (tofile && handler.equals(cHandler))
                handler.setLevel(Level.OFF);
            else if (!tofile && handler.equals(fHandler))
                handler.setLevel(Level.OFF);
            else
                handler.setLevel(lev);
        }

        logger.setLevel(lev);
    }

    public static void traceoutln(Level level, String message)
    {
        if (logger != null)
        {
            logger.log(level, message);
        }
    }

    public static final ThreadLocal <NumberFormat> NUMFORMATTER =
            new ThreadLocal <NumberFormat>()
            {
                @Override
                protected NumberFormat initialValue()
                {
                    return NumberFormat.getInstance(Locale.US);
                }
            };

    static final char          pad          = '=';
    static final char          BASE64_enc[] =
                                            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '"' };

    static final char          BASE64_dec[] =
                                            { (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x3e, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x3f, (char) 0x34, (char) 0x35, (char) 0x36, (char) 0x37, (char) 0x38,
            (char) 0x39, (char) 0x3a, (char) 0x3b, (char) 0x3c, (char) 0x3d, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x01, (char) 0x02, (char) 0x03,
            (char) 0x04, (char) 0x05, (char) 0x06, (char) 0x07, (char) 0x08, (char) 0x09, (char) 0x0a, (char) 0x0b,
            (char) 0x0c, (char) 0x0d, (char) 0x0e, (char) 0x0f, (char) 0x10, (char) 0x11, (char) 0x12, (char) 0x13,
            (char) 0x14, (char) 0x15, (char) 0x16, (char) 0x17, (char) 0x18, (char) 0x19, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x1a, (char) 0x1b, (char) 0x1c, (char) 0x1d,
            (char) 0x1e, (char) 0x1f, (char) 0x20, (char) 0x21, (char) 0x22, (char) 0x23, (char) 0x24, (char) 0x25,
            (char) 0x26, (char) 0x27, (char) 0x28, (char) 0x29, (char) 0x2a, (char) 0x2b, (char) 0x2c, (char) 0x2d,
            (char) 0x2e, (char) 0x2f, (char) 0x30, (char) 0x31, (char) 0x32, (char) 0x33, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00, (char) 0x00,
            (char) 0x00, (char) 0x00, (char) 0x00 };

    private final static Pattern TESTCASEPATTERN = Pattern.compile("\\s*(\\[.*\\])?(.*)\\s*",Pattern.DOTALL);
    public static List<String> returnTestCaseParams(String testcase)
    {
        List<String> containsGroups = new ArrayList<String>();
        Matcher matcher = TESTCASEPATTERN.matcher(testcase);
        if (matcher.matches())
        {
            for (int i = 1; i <= matcher.groupCount(); i++)
            {
                containsGroups.add(matcher.group(i));
            }
        }
        return containsGroups;
    }

    static Pattern CALLSTATEMENTSPATTERN = Pattern.compile("(\\$\\{)|(\\?)",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    public static int parseCallParameters(String testcase)
    {
        Matcher matcher = CALLSTATEMENTSPATTERN.matcher(testcase);
        int countOccurences = 0;
        while (matcher.find())
        {
            countOccurences++;
        }
        return countOccurences;
    }

    public static String Base64Encode(byte[] input, boolean addLineBreaks)
    {
        int length = input.length;
        StringBuilder out = new StringBuilder("");
        char one;
        char two;
        char three;

        int i;
        for (i = 0; i < length && length - i >= 3;)
        {
            one = (char) input[i++];
            two = (char) input[i++];
            three = (char) input[i++];

            out.append((char) BASE64_enc[one >> 2]);
            out.append((char) BASE64_enc[((one << 4) & 0x30 | (two >> 4))]);
            out.append((char) BASE64_enc[((two << 2) & 0x3c | (three >> 6))]);
            out.append((char) BASE64_enc[three & 0x3f]);

            if (addLineBreaks && (i % 54 == 0))
                out.append("\n");

            switch (length - i)
            {
                case 2:
                    one = (char) input[i++];
                    two = (char) input[i++];

                    out.append((char) BASE64_enc[one >> 2]);
                    out.append((char) BASE64_enc[((one << 4) & 0x30 | (two >> 4))]);
                    out.append((char) BASE64_enc[((two << 2) & 0x3c)]);
                    out.append(pad);
                    break;

                case 1:
                    one = (char) input[i++];

                    out.append((char) BASE64_enc[one >> 2]);
                    out.append((char) BASE64_enc[((one << 4) & 0x30)]);
                    out.append(pad);
                    out.append(pad);
                    break;
            }

        }
        return out.toString();
    }

    public static String removeAllNewLines(String str)
    {
        return str.trim().replaceAll("\\r\\n|\\r|\\n", " ");
    }

    public static boolean isLiteralString(String str)
    {
        boolean match = QUOTEDSTRPATTERN.matcher(str).matches();

        if (match)
        {
           return !QUOTEDFULLFIELDPATTERN.matcher(str).matches();
        }

        return match;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            NUMFORMATTER.get().parse(str);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    private final static Pattern PARENSTRPATTERN = Pattern.compile(
            "\\s*(\\()(.*?)(\\))\\s*",Pattern.DOTALL);

    public static boolean isInParenthesis(String parenstring)
    {
        if (parenstring == null)
            return false;

        Matcher matcher = PARENSTRPATTERN.matcher(parenstring);

         return matcher.matches();
    }

    public final static Pattern FUNCPATTERN = Pattern.compile(
            "\\s*(.*?)(\\()(.*?)(\\))\\s*",Pattern.DOTALL);

    public static boolean isFunction(String aggfunstr)
    {
        if (aggfunstr == null)
            return false;

        Matcher matcher = FUNCPATTERN.matcher(aggfunstr);

         return matcher.matches();
    }

    public static String getParenContents(String parenstring)
    {
        if (parenstring == null)
        return "";

        Matcher matcher = PARENSTRPATTERN.matcher(parenstring);

        if(matcher.matches())
            return matcher.group(2).trim();
        else
            return parenstring;
    }

    public static long stringToLong(String str, long uponError)
    {
        try
        {
            Number num = NUMFORMATTER.get().parse(str);
            return num.longValue();
        }
        catch (Exception e)
        {
            return uponError;
        }
    }

    public static int stringToInt(String str, int uponError)
    {
        try
        {
            Number num = NUMFORMATTER.get().parse(str);
            return num.intValue();
        }
        catch (Exception e)
        {
            return uponError;
        }
    }

    public static String replaceAll(String input, String forReplace, String replaceWith)
    {
        if (input == null)
            return "null";

        StringBuffer result = new StringBuffer();
        boolean hasMore = true;
        while (hasMore)
        {
            int start = input.indexOf(forReplace);
            int end = start + forReplace.length();
            if (start != -1)
            {
                result.append(input.substring(0, start) + replaceWith);
                input = input.substring(end);
            }
            else
            {
                hasMore = false;
                result.append(input);
            }
        }
        if (result.toString().equals(""))
            return input; // nothing is changed
        else
            return result.toString();
    }

    private final static Pattern QUOTEDFULLFIELDPATTERN = Pattern.compile(
            "\\s*(\"|\')(.*?){1}(\\.)(.*?){1}(\"|\')\\s*",Pattern.DOTALL);

    private final static Pattern QUOTEDSTRPATTERN = Pattern.compile(
            "\\s*(\"|\')(.*?)(\"|\')\\s*",Pattern.DOTALL);

    public static String handleQuotedString(String quotedString)
    {
        if (quotedString == null || quotedString.length() <= 0)
            return "";

        Matcher matcher = QUOTEDSTRPATTERN.matcher(quotedString);

        if(matcher.matches() )
            return matcher.group(2).trim();
        else
            return quotedString;
    }

    public static String ensureECLString(String instr) throws Exception
    {
        if (instr == null)
            return "''";
        return '\'' + replaceSQLwithECLEscapeChar(handleQuotedString(instr)) + '\'';
    }

    public static boolean isParameterizedStr(String value)
    {
        return  (value.contains("${") || value.equals("?"));
    }

    private static Map<Integer, String> SQLFieldMapping = new HashMap<Integer, String>();;

    static
    {
        Field[] fields = java.sql.Types.class.getFields();

        for (int i = 0; i < fields.length; i++)
        {
            try
            {
                String name = fields[i].getName();
                Integer value = (Integer) fields[i].get(null);
                SQLFieldMapping.put(value, name);
            }
            catch (IllegalAccessException e) {}
        }
    }

    public static String getSQLTypeName(Integer sqltypecode) throws Exception
    {
        if (SQLFieldMapping.size() <= 0)
            throw new Exception("java.sql.Types.class.getFields were not feched, cannot get SQL Type name");

        return SQLFieldMapping.get(sqltypecode);
    }

    public final static String EscapedSingleQuote = "\'\'";

    public static boolean hasPossibleEscapedQuoteLiteral(String quotedString) throws Exception
    {
        if (quotedString == null)
            return false;

        return handleQuotedString(quotedString).contains(EscapedSingleQuote);
    }

    private final static  String eclescaped = "\\\'";
    public final static Pattern SQLESCAPEDPATTERN = Pattern.compile(
            "(.*)(\'\')(.*)(\'\')(.*)",Pattern.DOTALL);

    public static String replaceSQLwithECLEscapeChar(String quotedString) throws Exception
    {
        if (quotedString == null)
            return "";

        Matcher m = SQLESCAPEDPATTERN.matcher(quotedString);

        String replaced;
        if (m.matches())
        {
            replaced = m.group(1) + eclescaped + m.group(3) + eclescaped + m.group(5);
        }
        else
        {
            replaced = quotedString.replace("\'", "\\\'");
        }

        return replaced;
    }

    public final static HashMap<String, Integer> mapECLTypeNameToSQLType = new HashMap<String, Integer>();
    static
    {
        mapECLTypeNameToSQLType.put("BOOLEAN", java.sql.Types.BOOLEAN);
        mapECLTypeNameToSQLType.put("STRING", java.sql.Types.VARCHAR);
        mapECLTypeNameToSQLType.put("QSTRING", java.sql.Types.VARCHAR);
        mapECLTypeNameToSQLType.put("FLOAT", java.sql.Types.FLOAT);
        mapECLTypeNameToSQLType.put("DOUBLE", java.sql.Types.DOUBLE);
        mapECLTypeNameToSQLType.put("DECIMAL", java.sql.Types.DECIMAL);
        mapECLTypeNameToSQLType.put("INTEGER", java.sql.Types.INTEGER);
        mapECLTypeNameToSQLType.put("LONG", java.sql.Types.NUMERIC);
        mapECLTypeNameToSQLType.put("INT", java.sql.Types.INTEGER);
        mapECLTypeNameToSQLType.put("SHORT", java.sql.Types.SMALLINT);
        mapECLTypeNameToSQLType.put("UNSIGNED", java.sql.Types.NUMERIC);
        mapECLTypeNameToSQLType.put("DATETIME", java.sql.Types.TIMESTAMP);
        mapECLTypeNameToSQLType.put("TIME", java.sql.Types.TIME);
        mapECLTypeNameToSQLType.put("DATE", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("GDAY", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("GMONTH", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("GYEAR", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("GYEARMONTH", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("GMONTHDAY", java.sql.Types.DATE);
        mapECLTypeNameToSQLType.put("DURATION", java.sql.Types.VARCHAR);
        mapECLTypeNameToSQLType.put("STRING1", java.sql.Types.CHAR);
        mapECLTypeNameToSQLType.put("REAL", java.sql.Types.REAL);
        mapECLTypeNameToSQLType.put("UNICODE", java.sql.Types.VARCHAR);
    }

    public final static HashMap<String, Integer> mapXSDTypeNameToSQLType = new HashMap<String, Integer>();
    static
    {
        mapXSDTypeNameToSQLType.put("ANYURI", java.sql.Types.VARCHAR);           //URI (Uniform Resource Identifier)
        mapXSDTypeNameToSQLType.put("BASE64BINARY", java.sql.Types.BINARY);      //Binary content coded as "base64"
        mapXSDTypeNameToSQLType.put("BOOLEAN", java.sql.Types.BOOLEAN);          //Boolean (true or false)
        mapXSDTypeNameToSQLType.put("BYTE", java.sql.Types.TINYINT);             //Signed value of 8 bits
        mapXSDTypeNameToSQLType.put("DATE", java.sql.Types.DATE);                //Gregorian calendar date
        mapXSDTypeNameToSQLType.put("DATETIME", java.sql.Types.OTHER);           //Instant of time (Gregorian calendar)
        mapXSDTypeNameToSQLType.put("DECIMAL", java.sql.Types.DECIMAL);          //Decimal numbers
        mapXSDTypeNameToSQLType.put("DOUBLE", java.sql.Types.DOUBLE);            //IEEE 64-bit floating-point
        mapXSDTypeNameToSQLType.put("DURATION", java.sql.Types.OTHER);           //Time durations
        mapXSDTypeNameToSQLType.put("ENTITIES", java.sql.Types.OTHER);           //Whitespace-separated list of unparsed entity references
        mapXSDTypeNameToSQLType.put("ENTITY", java.sql.Types.OTHER);             //Reference to an unparsed entity
        mapXSDTypeNameToSQLType.put("FLOAT", java.sql.Types.FLOAT);              //IEEE 32-bit floating-point
        mapXSDTypeNameToSQLType.put("GDAY", java.sql.Types.OTHER);               //Recurring period of time: monthly day
        mapXSDTypeNameToSQLType.put("GMONTH", java.sql.Types.OTHER);             //Recurring period of time: yearly month
        mapXSDTypeNameToSQLType.put("GMONTHDAY", java.sql.Types.OTHER);          //Recurring period of time: yearly day
        mapXSDTypeNameToSQLType.put("GYEAR", java.sql.Types.OTHER);              //Period of one year
        mapXSDTypeNameToSQLType.put("GYEARMONTH", java.sql.Types.OTHER);         //Period of one month
        mapXSDTypeNameToSQLType.put("HEXBINARY", java.sql.Types.BINARY);         //Binary contents coded in hexadecimal
        mapXSDTypeNameToSQLType.put("ID", java.sql.Types.VARCHAR);               //Definition of unique identifiers
        mapXSDTypeNameToSQLType.put("IDREF", java.sql.Types.REF);                //Definition of references to unique identifiers
        mapXSDTypeNameToSQLType.put("IDREFS", java.sql.Types.ARRAY);             //Definition of lists of references to unique identifiers
        mapXSDTypeNameToSQLType.put("INT", java.sql.Types.INTEGER);              //32-bit signed integers
        mapXSDTypeNameToSQLType.put("INTEGER", java.sql.Types.BIGINT);           //Signed integers of arbitrary length
        mapXSDTypeNameToSQLType.put("LANGUAGE", java.sql.Types.OTHER);           //RFC 1766 language codes
        mapXSDTypeNameToSQLType.put("LONG", java.sql.Types.BIGINT);              //64-bit signed integers
        mapXSDTypeNameToSQLType.put("NAME", java.sql.Types.VARCHAR);             //XML 1.O name
        mapXSDTypeNameToSQLType.put("NCNAME", java.sql.Types.VARCHAR);           //Unqualified names
        mapXSDTypeNameToSQLType.put("NEGATIVEINTEGER", java.sql.Types.BIGINT);   //Strictly negative integers of arbitrary length
        mapXSDTypeNameToSQLType.put("NMTOKEN", java.sql.Types.OTHER);            //XML 1.0 name token (NMTOKEN)
        mapXSDTypeNameToSQLType.put("NMTOKENS", java.sql.Types.OTHER);           //List of XML 1.0 name tokens (NMTOKEN)
        mapXSDTypeNameToSQLType.put("NONNEGATIVEINTEGER", java.sql.Types.BIGINT);//Integers of arbitrary length positive or equal to zero
        mapXSDTypeNameToSQLType.put("NONPOSITIVEINTEGER", java.sql.Types.BIGINT);//Integers of arbitrary length negative or equal to zero
        mapXSDTypeNameToSQLType.put("NORMALIZEDSTRING", java.sql.Types.VARCHAR); //Whitespace-replaced strings
        mapXSDTypeNameToSQLType.put("NOTATION", java.sql.Types.OTHER);           //Emulation of the XML 1.0 feature
        mapXSDTypeNameToSQLType.put("POSITIVEINTEGER", java.sql.Types.BIGINT);   //Strictly positive integers of arbitrary length
        mapXSDTypeNameToSQLType.put("QNAME", java.sql.Types.VARCHAR);            //Namespaces in XML-qualified names
        mapXSDTypeNameToSQLType.put("SHORT", java.sql.Types.INTEGER );           //32-bit signed integers
        mapXSDTypeNameToSQLType.put("STRING", java.sql.Types.VARCHAR);           //Any string
        mapXSDTypeNameToSQLType.put("TIME", java.sql.Types.TIME);                //Point in time recurring each day
        mapXSDTypeNameToSQLType.put("TOKEN", java.sql.Types.OTHER);              //Whitespace-replaced and collapsed strings
        mapXSDTypeNameToSQLType.put("UNSIGNEDBYTE", java.sql.Types.TINYINT);     //Unsigned value of 8 bits
        mapXSDTypeNameToSQLType.put("UNSIGNEDINT", java.sql.Types.BIGINT);       //Unsigned integer of 32 bits
        mapXSDTypeNameToSQLType.put("UNSIGNEDLONG", java.sql.Types.BIGINT);      //64-bit signed integers
        mapXSDTypeNameToSQLType.put("UNSIGNEDLONG", java.sql.Types.BIGINT);      //Unsigned integer of 64 bits
        mapXSDTypeNameToSQLType.put("UNSIGNEDSHORT", java.sql.Types.INTEGER);    //Unsigned integer of 16 bits
    }

    public static int mapXSDTypeName2SQLtype(String xsdtype)
    {
        xsdtype = xsdtype.toUpperCase();
        //let's try to find the type as is
        if (mapXSDTypeNameToSQLType.containsKey(xsdtype))
            return mapXSDTypeNameToSQLType.get(xsdtype);
        else
        {
            //let's try to find it without any namespace information
            String postfixUpper = xsdtype.substring(xsdtype.lastIndexOf(':') + 1);
            if (mapXSDTypeNameToSQLType.containsKey(postfixUpper))
                return mapXSDTypeNameToSQLType.get(postfixUpper);
            else
                return java.sql.Types.OTHER;
        }
    }

    public final static Pattern TRAILINGNUMERICPATTERN = Pattern.compile(
            "(.*\\s+?)*([A-Z]+)(([0-9]+)(_([0-9]+))?)*",Pattern.DOTALL);

    public static int mapECLtype2SQLtype(String ecltype)
    {
        if (mapECLTypeNameToSQLType.containsKey(ecltype))
        {
            return mapECLTypeNameToSQLType.get(ecltype); //let's try to find the type as is
        }
        else
        {
            String postfixUpper = ecltype.substring(ecltype.lastIndexOf(':') + 1).toUpperCase();
            if (mapECLTypeNameToSQLType.containsKey(postfixUpper))
                return mapECLTypeNameToSQLType.get(postfixUpper);
            else
            {
                //TRAILINGNUMERICPATTERN attemps to match optional leading spaces
                //followed by a string of alphas, followed by optional string of numerics
                //then we look up the string of alphas in the known ECL type map (group(2))
                Matcher m = TRAILINGNUMERICPATTERN.matcher(postfixUpper);
                if (m.matches() && mapECLTypeNameToSQLType.containsKey(m.group(2)))
                    return mapECLTypeNameToSQLType.get(m.group(2));
                else
                    return java.sql.Types.OTHER;
            }
        }
    }

    public enum EclTypes
    {
        ECLTypeboolean(0),
        ECLTypeint(1),
        ECLTypereal(2),
        ECLTypedecimal(3),
        ECLTypestring(4),
        ECLTypeunused1(5),
        ECLTypedate(6),
        ECLTypeunused2(7),
        ECLTypeunused3(8),
        ECLTypebitfield(9),
        ECLTypeunused4(10),
        ECLTypechar(11),
        ECLTypeenumerated(12),
        ECLTyperecord(13),
        ECLTypevarstring(14),
        ECLTypeblob(15),
        ECLTypedata(16),
        ECLTypepointer(17),
        ECLTypeclass(18),
        ECLTypearray(19),
        ECLTypetable(20),
        ECLTypeset(21),
        ECLTyperow(22),
        ECLTypegroupedtable(23),
        ECLTypevoid(24),
        ECLTypealien(25),
        ECLTypeswapint(26),
        ECLTypepackedint(28),
        ECLTypeunused5(29),
        ECLTypeqstring(30),
        ECLTypeunicode(31),
        ECLTypeany(32),
        ECLTypevarunicode(33),
        ECLTypepattern(34),
        ECLTyperule(35),
        ECLTypetoken(36),
        ECLTypefeature(37),
        ECLTypeevent(38),
        ECLTypenull(39),
        ECLTypescope(40),
        ECLTypeutf8(41),
        ECLTypetransform(42),
        ECLTypeifblock(43), // not a real type -but used for the rtlfield serialization
        ECLTypefunction(44),
        ECLTypesortlist(45),
        ECLTypemodifier(0xff), // used  by  getKind()
        ECLTypeunsigned(0x100), // combined with some of the above, when
                                // returning summary type information. Not
                                // returned by getTypeCode()
        ECLTypeebcdic(0x200), // combined with some of the above, when returning
                              // summary type information. Not returned by
                              // getTypeCode()
        // Some pseudo types - never actually created
        ECLTypestringorunicode(0xfc), // any string/unicode variant
        ECLTypenumeric(0xfd),
        ECLTypescalar(0xfe);

        EclTypes(int eclcode){}
    }

    private final static HashMap<EclTypes, Integer> mapECLtypeCodeToSQLtype = new HashMap<EclTypes, Integer>();
    static
    {
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeboolean, java.sql.Types.BOOLEAN);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypearray, java.sql.Types.ARRAY);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeblob, java.sql.Types.BLOB);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypechar, java.sql.Types.CHAR);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypedate, java.sql.Types.DATE);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypedecimal, java.sql.Types.DECIMAL);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeint, java.sql.Types.INTEGER);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypenull, java.sql.Types.NULL);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypenumeric, java.sql.Types.NUMERIC);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypepackedint, java.sql.Types.INTEGER);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypepointer, java.sql.Types.REF);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeqstring, java.sql.Types.VARCHAR);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypereal, java.sql.Types.REAL);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypestring, java.sql.Types.VARCHAR);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeunsigned, java.sql.Types.NUMERIC);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypevarstring, java.sql.Types.VARCHAR);
        mapECLtypeCodeToSQLtype.put(EclTypes.ECLTypeunicode, java.sql.Types.VARCHAR);
    }

    /**
     * Translates an ecltype element to sql type int (java.sql.Types value)
     *
     * @param ecltype
     *            The ecl type enumerated value.
     * @return The java.sql.Types value to convert to a string
     *            representation.
     */
    public static int convertECLtypeCode2SQLtype(EclTypes ecltype)
    {
        if(mapECLtypeCodeToSQLtype.containsKey(ecltype))
            return mapECLtypeCodeToSQLtype.get(ecltype);
        else
            return java.sql.Types.OTHER;
    }

    private final static HashMap<Integer, String> mapSQLtypeCodeToJavaClass = new HashMap<Integer, String>();
    static
    {
        //http://docs.oracle.com/javase/1.5.0/docs/guide/jdbc/getstart/mapping.html#1051555
        //Adhering to type mapping table in oracle doc referenced above.
        //one exception is the CHAR type, which is mapped to Character in order to
        //appease some ODBC/JDBC bridges.
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.CHAR,          "java.lang.Character");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.VARCHAR,       "java.lang.String");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.LONGVARCHAR,   "java.lang.String");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.NUMERIC,       "java.math.BigDecimal");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.DECIMAL,       "java.math.BigDecimal");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.BIT,           "java.lang.Boolean");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.TINYINT,       "java.lang.Byte");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.SMALLINT,      "java.lang.Short");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.INTEGER,       "java.lang.Integer");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.BIGINT,        "java.lang.Long");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.REAL,          "java.lang.Float");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.FLOAT,         "java.lang.Double");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.DOUBLE,        "java.lang.Double");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.BINARY,        "java.lang.Byte[]");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.VARBINARY,     "java.lang.Byte[]");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.LONGVARBINARY, "java.lang.Byte[]");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.DATE,          "java.sql.Date");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.TIME,          "java.sql.Time");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.TIMESTAMP,     "java.sql.Timestamp");
        mapSQLtypeCodeToJavaClass.put(java.sql.Types.BOOLEAN,       "java.lang.Boolean");
    }

    public final static HashMap<String, Class> mapSQLtypeNameToJavaClass = new HashMap<String, Class>();
    static
    {
        //http://docs.oracle.com/javase/1.5.0/docs/guide/jdbc/getstart/mapping.html#1051555
        //Adhering to type mapping table in oracle doc referenced above.
        //one exception is the CHAR type, which is mapped to Character in order to
        //appease some ODBC/JDBC bridges.
        mapSQLtypeNameToJavaClass.put("CHAR", Character.TYPE);
        mapSQLtypeNameToJavaClass.put("VARCHAR", String.class);
        mapSQLtypeNameToJavaClass.put("LONGVARCHAR", String.class);
        mapSQLtypeNameToJavaClass.put("NUMERIC", java.math.BigDecimal.class);
        mapSQLtypeNameToJavaClass.put("DECIMAL", java.math.BigDecimal.class);
        mapSQLtypeNameToJavaClass.put("BIT", Boolean.TYPE);
        mapSQLtypeNameToJavaClass.put("TINYINT", Byte.TYPE);
        mapSQLtypeNameToJavaClass.put("SMALLINT", Short.TYPE);
        mapSQLtypeNameToJavaClass.put("INT", Integer.TYPE);
        mapSQLtypeNameToJavaClass.put("INTEGER", Integer.TYPE);
        mapSQLtypeNameToJavaClass.put("BIGINT", Long.TYPE);
        mapSQLtypeNameToJavaClass.put("REAL", Float.TYPE);
        mapSQLtypeNameToJavaClass.put("FLOAT", Float.TYPE);
        mapSQLtypeNameToJavaClass.put("DOUBLE", Double.TYPE);
        mapSQLtypeNameToJavaClass.put("BINARY", Byte[].class);
        mapSQLtypeNameToJavaClass.put("VARBINARY", Byte[].class);
        mapSQLtypeNameToJavaClass.put("LONGVARBINARY", Byte[].class);
        mapSQLtypeNameToJavaClass.put("DATE", java.sql.Date.class);
        mapSQLtypeNameToJavaClass.put("TIME", java.sql.Time.class);
        mapSQLtypeNameToJavaClass.put("TIMESTAMP", java.sql.Timestamp.class);
        mapSQLtypeNameToJavaClass.put("BOOLEAN", java.lang.Boolean.TYPE);
        mapSQLtypeNameToJavaClass.put("BOOL", java.lang.Boolean.TYPE);
    }

    final public static SimpleDateFormat HoursColonMinutesColonSeconds24HourFormat = new SimpleDateFormat("HH:mm:ss");

    public static Object deserializeSQLTypesToJava(String sqltypename, String value ) throws ParseException
    {
        Class clazz = String.class;

        String cleantypename = sqltypename.trim().toUpperCase();
        if (mapSQLtypeNameToJavaClass.containsKey(cleantypename))
            clazz = mapSQLtypeNameToJavaClass.get(cleantypename);

        if( Boolean.TYPE == clazz )
            return Boolean.parseBoolean( value );
        else if (Byte[].class == clazz)
            return value.getBytes(Charset.forName("UTF-8"));
        else if( Byte.TYPE == clazz )
            return Byte.parseByte( value );
        else if( Integer.TYPE == clazz )
            return Integer.parseInt( value );
        else if( Long.TYPE == clazz )
            return Long.parseLong( value );
        else if( Float.TYPE == clazz )
            return Float.parseFloat( value );
        else if( Double.TYPE == clazz )
            return Double.parseDouble( value );
        else if ( Short.TYPE == clazz)
            return Short.parseShort(value);
        else if (Character.TYPE == clazz)
            return value.charAt(0);
        else if (java.math.BigDecimal.class == clazz)
            return new BigDecimal(value.replaceAll(",", ""));
        else if (java.sql.Date.class == clazz) //ASSUMES yyyy-MM-dd!!!
            return java.sql.Date.valueOf(value);
        else if (java.sql.Time.class == clazz)//ASSUMES HH:mm:ss!!!
        try
        {
            return new java.sql.Time(((java.util.Date)HoursColonMinutesColonSeconds24HourFormat.parse(value)).getTime());
        }
        catch (ParseException e)
        {
            throw new ParseException("Could not deserialize " + value +" to time (HH:mm:ss) format: " + e.getLocalizedMessage(), e.getErrorOffset());
        }
        catch (Exception e)
        {
            throw new ParseException("Could not deserialize " + value +" to time (HH:mm:ss) format: " + e.getLocalizedMessage(),-1);
        }
        else if (java.sql.Timestamp.class == clazz)
            return Timestamp.valueOf(value); //ASSUMES "2011-10-02 18:48:05.123456";
        else
            return value;
    }

    private final static String JAVA_OBJECT_TYPE_NAME = "java.lang.Object";
    /**
     * Translates a data type from an integer (java.sql.Types value) to a string
     * that represents the corresponding class.
     *
     * @param type
     *            The java.sql.Types value to convert to a string
     *            representation.
     * @return The class name that corresponds to the given java.sql.Types
     *         value, or "java.lang.Object" if the type has no known mapping.
     */
    public static String convertSQLtype2JavaClassName(int type)
    {
        if(mapSQLtypeCodeToJavaClass.containsKey(type))
            return mapSQLtypeCodeToJavaClass.get(type);
        else
            return JAVA_OBJECT_TYPE_NAME;
    }

    public static Object createSqlTypeObjFromStringObj(int sqltype, Object objstrrepresentation)
    {
        if (objstrrepresentation == null)
            return null;
        else
            return createSqlTypeObjFromString(sqltype, objstrrepresentation.toString()); //cast to String instead???
    }

    public static Object createSqlTypeObjFromString(int type, String strrepresentation)
    {
        if (strrepresentation == null)
            return null;
        else
        {
            try
            {
                return Class.forName(convertSQLtype2JavaClassName(type)).getConstructor(String.class).newInstance(strrepresentation);
            }
            catch (Exception e)
            {
                HPCCJDBCUtils.traceoutln(Level.WARNING, "HPCC JDBC: Field of type: java.sql.Types-" + type + " could not be cast to native Java type (treat as String).");
                HPCCJDBCUtils.traceoutln(Level.WARNING,  e.getLocalizedMessage());
                return strrepresentation;
            }
        }
    }

    /**
     * Attempts to map a string value to an enum value of
     * a given enum class.
     *
     * Iterates through all enum values of given enum class,
     * and compares to given string.
     * Returns enum value if it finds match, otherwise throws Exception
     *
     * @param enumclass reference to target enumaration
     * @param strvalue string value to be mapped to enum value
     *
     * @return The corresponding enum value if found
     *
     * @throws IllegalArgumentException if strvalue cannot be mapped to
     * given enum
     *
     **/
    public static <T extends Enum<T>> T findEnumValFromString(Class<T> enumclass, String strvalue)
    {
        for(Enum enumValue : enumclass.getEnumConstants())
        {
            if(enumValue.name().equalsIgnoreCase(strvalue))
            {
                return (T) enumValue;
            }
        }
        throw new IllegalArgumentException(enumclass.getName() +".'" + strvalue + "' is not valid.");
    }

    public static final Pattern BOOLEANPATTERN = Pattern.compile(
            "((?i)true|(?i)false)",Pattern.DOTALL);

    public static boolean isBooleanKeyWord(String str)
    {
       return BOOLEANPATTERN.matcher(str).matches();
    }

    public final static HashMap<Integer, Integer> mapSQLTypeToPrecedence = new HashMap<Integer, Integer>();
    static
    {
        int precedence = Integer.MAX_VALUE;
        mapSQLTypeToPrecedence.put(java.sql.Types.DOUBLE, precedence--);
        mapSQLTypeToPrecedence.put(java.sql.Types.REAL, precedence--);
        mapSQLTypeToPrecedence.put(java.sql.Types.DECIMAL, precedence--);
        mapSQLTypeToPrecedence.put(java.sql.Types.INTEGER, precedence--);
        mapSQLTypeToPrecedence.put(java.sql.Types.SMALLINT, precedence--);
    }

    public static int getNumericSqlTypePrecedence(int sqlType)
    {
        if (mapSQLTypeToPrecedence.containsKey(sqlType))
            return mapSQLTypeToPrecedence.get(sqlType);
        else
            return Integer.MIN_VALUE;
    }

    //public static final Pattern URLPATTERN = Pattern.compile("\\b(?:(https?|ftp|file)://|www\\.)?[-A-Z0-9+&#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]\\.[-A-Z0-9+&@#/%?=~_|$!:,.;]*[A-Z0-9+&@#/%=~_|$]", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    public static final Pattern URLPROTPATTERN = Pattern.compile("((https?|ftp|file)://|www\\.).+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

    public static URL makeURL(String urlstr)
    {
        URL theURL = null;
        try
        {
            theURL = new URL(ensureURLProtocol(urlstr));
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return theURL;
    }

    public static URL verifyURL(String urlstr) throws MalformedURLException
    {
        try
        {
            return new URL(urlstr);
        }
        catch (Exception e)
        {
            throw new MalformedURLException(e.getLocalizedMessage());
        }
    }

    public static String ensureURLProtocol(String urlstr)
    {
        if (!URLPROTPATTERN.matcher(urlstr).matches())
        {
            return defaultprotocol + protocolsep + urlstr;
        }
        else
            return urlstr;
    }
}
