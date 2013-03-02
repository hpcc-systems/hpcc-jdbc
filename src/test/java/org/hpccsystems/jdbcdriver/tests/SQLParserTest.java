package org.hpccsystems.jdbcdriver.tests;

import java.util.List;

import org.hpccsystems.jdbcdriver.HPCCColumnMetaData;
import org.hpccsystems.jdbcdriver.SQLParser;

public class SQLParserTest
{
    static private SQLParser parser;

    static
    {
        parser = new SQLParser();
    }

    static private boolean testSelectALL(String tablename)
    {
        boolean success = true;
        try
        {
            parser.process("select * from " + tablename);
            success = parser.getTableName(0).equals(tablename) ? true : false;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }

        return success;
    }

    static private boolean testTableAlias(String tablename, String alias)
    {
        boolean success = true;
        try
        {
            parser.process("select * from " + tablename + " AS " + alias);
            success &= parser.getTableName(0).equals(tablename) ? true : false;
            success &= parser.getTableAlias(0).equals(alias) ? true : false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }

        return success;
    }

    static private boolean testFreeHandSQL(String sql)
    {
        boolean success = true;
        try
        {
            parser.process(sql);

            System.out.print("SQL request type: ");
            List<HPCCColumnMetaData> cols = parser.getSelectColumns();
            switch (parser.getSqlType())
            {
                case SELECT:
                    System.out.println("SELECT");
                    System.out.print("Select Columns: [ ");
                    for (int i = 0; i < cols.size(); i++)
                    {
                        HPCCColumnMetaData col = cols.get(i);
                        System.out.print(col.getColumnName() + " "
                                + (col.getAlias() != null ? "(" + col.getAlias() + ") " : ""));
                    }
                    System.out.println(" ] ");
                    System.out.println("Table Name: " + parser.getTableName(0));
                    System.out.println("Table Alias: " + parser.getTableAlias(0));
                    System.out.println("Index Hint: " + parser.getIndexHint());
                    if (parser.hasJoinClause())
                        System.out.println("Join Clause: " + parser.getJoinClause().toString());
                    System.out.println("Where Clause: " + parser.getWhereClauseString());
                    if (parser.hasGroupByColumns())
                        System.out.println("Group By: " + parser.getGroupByString(','));
                    if (parser.hasOrderByColumns())
                        System.out.println("Group By: " + parser.getOrderByString(','));
                    break;
                case SELECTCONST:
                    System.out.println("SELECT CONSTANT");
                    System.out.println("Select Columns: [ ");
                    for (int i = 0; i < cols.size(); i++)
                    {
                        System.out.println(cols.get(i).getColumnName() + "( " + cols.get(i).getAlias());
                    }
                    System.out.println(" ] ");
                    break;
                case CALL:
                    System.out.println("CALL");
                    System.out.println("Stored Procedure name: " + parser.getStoredProcName());
                    String spvals[] = parser.getStoredProcInParamVals();
                    System.out.print("Stored Procedure input params : (");
                    for (int i = 0; i < spvals.length; i++)
                    {
                        System.out.print(spvals[i] + " ");
                    }
                    System.out.println(")");
                    break;
                case UNKNOWN:
                default:
                    System.out.print("not detected");
                    break;
            }

            if (parser.hasLimitBy())
                System.out.println("Limit by: " + parser.getLimit());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }

        return success;
    }

    public static void main(String[] args) throws Exception
    {
        boolean success = true;

        try
        {
            if (args.length > 0)
            {
                testFreeHandSQL(args[0]);
            }
            else
                throw new RuntimeException("No input SQL detected.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            success = false;
        }

        System.out.println("\nParser test "
                + (success ? " did not cause exceptions, please verify output! " : "failed!"));
    }
}
