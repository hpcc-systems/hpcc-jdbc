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
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HPCCJDBCUtils
{
    private static boolean trace_enabled = false;

    public static void enableTraceLogging()
    {
        trace_enabled = true;
    }

    public static void disableTraceLogging()
    {
        trace_enabled = false;
    }

    public static void traceout(String tracestmt)
    {
        if (trace_enabled)
        {
            System.out.print("HPCCJDBC-TRACE: " + tracestmt);
        }
    }

    public static void traceoutln(String tracestmt)
    {
        if (trace_enabled)
        {
            System.out.println("HPCCJDBC-TRACE: " + tracestmt);
        }
    }

    public static NumberFormat format       = NumberFormat.getInstance(Locale.US);
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

    // public static String Base64Decode(byte [] input)
    // {
    // StringBuilder out = new StringBuilder("");
    //
    // char c1, c2, c3, c4;
    // char d1, d2, d3, d4;
    //
    // for(int i = 0;;)
    // {
    // c1 = (char)input[i++];
    // if (c1 == 0)
    // break;
    // //else if (!isspace(c1))
    // else if (!String.valueOf(c1).equals(" "))
    // {
    // c2 = (char)input[i++];
    // c3 = (char)input[i++];
    // c4 = (char)input[i++];
    // d1 = BASE64_dec[c1];
    // d2 = BASE64_dec[c2];
    // d3 = BASE64_dec[c3];
    // d4 = BASE64_dec[c4];
    //
    // out.append((char)((d1 << 2) | (d2 >> 4)));
    //
    // if(c3 == pad)
    // break;
    //
    // out.append((char)((d2 << 4) | (d3 >> 2)));
    //
    // if(c4 == pad)
    // break;
    //
    // out.append((char)((d3 << 6) | d4));
    // }
    // }
    //
    // return out.toString();
    // }

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
        String trimmed = str.trim();
        if (trimmed.charAt(0) != '\'' && trimmed.charAt(0) != '\"')
            return false;
        if (trimmed.charAt(trimmed.length() - 1) != '\'' && trimmed.charAt(trimmed.length() - 1) != '\"')
            return false;

        return true;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            format.parse(str);
        }
        catch (ParseException e)
        {
            return false;
        }

        return true;
    }

    public static long stringToLong(String str, long uponError)
    {
        try
        {
            Number num = format.parse(str);
            return num.longValue();
        }
        catch (ParseException e)
        {
            return uponError;
        }
    }

    public static int stringToInt(String str, int uponError)
    {
        try
        {
            Number num = format.parse(str);
            return num.intValue();
        }
        catch (ParseException e)
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

    private final static Pattern QUOTEDSTRPATTERN = Pattern.compile(
            "\\s*(\"|\')(.*?)(\"|\')\\s*",Pattern.DOTALL);

    public static String handleQuotedString(String quotedString)
    {
        if (quotedString == null)
            return "";

        Matcher matcher = QUOTEDSTRPATTERN.matcher(quotedString);

        if(matcher.matches() && matcher.groupCount() >= 3)
            return matcher.group(2).trim();
        else
            return quotedString;
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
}
