package org.hpccsystems.jdbcdriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HPCCJDBCLogFormatter  extends Formatter
{
    private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS");
    private static final String MESSAGEDELIMITER = " - ";

    @Override
    public String format(LogRecord arg0)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(df.format(new Date(arg0.getMillis()))).append(MESSAGEDELIMITER);
        builder.append(formatMessage(arg0));
        builder.append(HPCCJDBCUtils.newLine);
        return builder.toString();
    }
}
