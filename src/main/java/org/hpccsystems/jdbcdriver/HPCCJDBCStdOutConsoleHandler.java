package org.hpccsystems.jdbcdriver;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;

public class HPCCJDBCStdOutConsoleHandler extends ConsoleHandler
{
    protected void setOutputStream(OutputStream out) throws SecurityException
    {
        super.setOutputStream(System.out);
    }
}
