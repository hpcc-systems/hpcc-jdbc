package org.hpccsystems.jdbcdriver.tests;

import java.util.Properties;

import org.hpccsystems.jdbcdriver.HPCCPreparedStatement;
import org.hpccsystems.jdbcdriver.HPCCResultSet;

public class HPCCDriverPrepStmtReuseThread extends Thread
{
    private HPCCPreparedStatement thestatement;
    private Properties     theparams;
    private boolean        success;
    private boolean        running;

    public HPCCDriverPrepStmtReuseThread(HPCCPreparedStatement statement, Properties parameters)
    {
        thestatement = statement;
        theparams = parameters;
        success = true;
        running = false;
    }

    @Override
    public void run()
    {
        try
        {
            thestatement.clearParameters();
            for (int i = 1; i <= theparams.size(); i++)
                thestatement.setObject(i, theparams.getProperty(String.valueOf(i)));

            HPCCResultSet qrs = (HPCCResultSet) ((HPCCPreparedStatement) thestatement).executeQuery();
            HPCCDriverTest.printOutResultSet(qrs, Thread.currentThread().getId());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            success = false;
        }
        finally
        {
            running = false;
        }
    }

    public boolean isSuccess()
    {
        return success;
    }

    public boolean isRunning()
    {
        return running;
    }
}
