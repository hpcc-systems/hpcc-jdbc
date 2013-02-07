package org.hpccsystems.jdbcdriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HPCCJDBCLogFormatter  extends Formatter
{
    private static final ThreadLocal<DateFormat> DF =
            new ThreadLocal<DateFormat>()
            {
                @Override
                protected DateFormat initialValue()
                {
                  return new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS");
                }
            };

    private static final String THREAFORMAT = "%5s";

    @Override
    public String format(LogRecord arg0)
    {
        StringBuffer builder = new StringBuffer();

        builder.append(DF.get().format(new Date(arg0.getMillis())))
               .append(" ")
               .append(String.format(THREAFORMAT, Thread.currentThread().getId()).replace(' ', '0'))
               .append(" ")
               .append(formatMessage(arg0))
               .append(HPCCJDBCUtils.newLine);

        return builder.toString();
    }
}
