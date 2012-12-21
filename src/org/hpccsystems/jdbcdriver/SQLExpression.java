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

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.hpccsystems.jdbcdriver.SQLFragment.FragmentType;

public class SQLExpression
{
    private SQLOperator        prevExpUnifier; // NULL|AND|OR. NULL = First expression in clause.

    private SQLFragment        prefix;
    private SQLOperator        operator;
    private SQLFragment        postfix;

    public final static char   PARENTFIELDSEP = '.';
    public final static char   SINGLEBLANKBUFFER = ' ';

    public SQLExpression()
    {
        prevExpUnifier = null;

        prefix = new SQLFragment();
        operator = null;
        postfix = new SQLFragment();
    }

    public void ParseExpression(String expression) throws SQLException
    {
        String trimmedExpression = expression.trim();

        SQLOperator operator = new SQLOperator(trimmedExpression);

        if (operator == null || operator.getValue() == null || !operator.isValid())
            throw new SQLException("Invalid logical operator found: " + trimmedExpression);

        String splitedsqlexp[] = operator.splitExpressionFragment(trimmedExpression);

        setPrefix(splitedsqlexp[0].trim());

        setOperator(operator);

        if (operator.isBinary())
        {
            if (splitedsqlexp.length == 2)
                setPostfix(splitedsqlexp[1].trim());
            else
                throw new SQLException("Invalid SQL Where clause found around: " + expression);
        }
    }

    public String getPrefixValue()
    {
        return prefix.getValue();
    }

    public String getFullPrefix()
    {
        return prefix.getFullColumnName();
    }

    public String getFullPostfix()
    {
        return postfix.getFullColumnName();
    }

    public void setPrefix(String prefix)
    {
        this.prefix.parseExpressionFragment(prefix);
    }

    public SQLOperator getOperator()
    {
        return operator;
    }

    public void setOperator(SQLOperator operator)
    {
        this.operator = operator;
    }

    public void setOperator(String operator)
    {
        this.operator = new SQLOperator(operator);
    }

    public boolean isOperatorValid()
    {
        return operator != null ? operator.isValid() : false;
    }

    public String getPostfixValue()
    {
        return postfix.getValue();
    }

    public void setPostfix(String postfixstr)
    {
        postfix.parseExpressionFragment(postfixstr);
    }

    public boolean isPrefixParameterized()
    {
        return prefix.isParameterized();
    }

    public boolean isPostfixParameterized()
    {
        return postfix.isParameterized();
    }

    public FragmentType getPrefixType()
    {
        return prefix.getType();
    }

    public FragmentType getPostfixType()
    {
        return postfix.getType();
    }

    @Override
    public String toString()
    {
        return toStringFull(false);
    }

    public String toStringFull(boolean outputfull)
    {
        StringBuffer tmpsb = new StringBuffer();

        if (prevExpUnifier != null)
            tmpsb.append(prevExpUnifier);

        switch (operator.getType())
        {
            case BINARY:
                tmpsb.append(outputfull ? getFullPrefix() : prefix.getValue())
                 .append(SINGLEBLANKBUFFER)
                 .append(operator.toString())
                 .append(SINGLEBLANKBUFFER)
                 .append(outputfull ? getFullPostfix() : postfix.getValue());
           break;
            case PRE_UNARY:
                tmpsb.append(SINGLEBLANKBUFFER)
                 .append(operator.toString())
                 .append(SINGLEBLANKBUFFER)
                 .append(outputfull ? getFullPrefix() : prefix.getValue())
                 .append(SINGLEBLANKBUFFER);
           break;
            case POST_UNARY:
                tmpsb.append(SINGLEBLANKBUFFER)
                 .append(outputfull ? getFullPrefix() : prefix.getValue())
                 .append(SINGLEBLANKBUFFER)
                 .append(operator.toString())
                 .append(SINGLEBLANKBUFFER);
           break;
            case NOOPFALSE:
                tmpsb.append(" false ");
                break;
            case NOOPTRUE:
                tmpsb.append(" true ");
                break;
            case UNKNOWN:
            default:
                return this.toString();
        }

        return tmpsb.toString();
    }

    public String toStringTranslateSource(HashMap<String, String> map, boolean ignoreprevunifier, boolean ignoreMisTraslations)
    {
            StringBuffer tmpsb = new StringBuffer();

            if (!ignoreprevunifier && prevExpUnifier != null )
                tmpsb.append(prevExpUnifier);

            String prefixtranslate = map.get(prefix.getParent());
            String postfixtranslate = map.get(postfix.getParent());

            if (!ignoreMisTraslations && ((prefixtranslate == null && prefix.getParent() != null) || (postfixtranslate == null) && postfix.getParent() != null))
                return null;

            switch (operator.getType())
            {
                case BINARY:
                    if (prefixtranslate != null)
                    {
                        tmpsb.append(prefixtranslate);
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    else if (prefix.getParent() != null && prefix.getParent().length() > 0)
                    {
                        tmpsb.append(prefix.getParent());
                        tmpsb.append(PARENTFIELDSEP);
                    }

                    tmpsb.append(prefix.getValue()).append(SINGLEBLANKBUFFER).append(operator.toString()).append(SINGLEBLANKBUFFER);
                    if (postfixtranslate != null)
                    {
                        tmpsb.append(postfixtranslate);
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    else if (postfix.getParent() != null && postfix.getParent().length() > 0)
                    {
                        tmpsb.append(postfix.getParent());
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    tmpsb.append(postfix.getValue());
                    break;
                case PRE_UNARY:
                    tmpsb.append(SINGLEBLANKBUFFER).append(operator.toString()).append(SINGLEBLANKBUFFER);
                    if (prefixtranslate != null)
                    {
                        tmpsb.append(prefixtranslate);
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    else if (prefix.getParent() != null && prefix.getParent().length() > 0)
                    {
                        tmpsb.append(prefix.getParent());
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    tmpsb.append(prefix.getValue()).append(SINGLEBLANKBUFFER);
                    break;
                case POST_UNARY:
                    if (prefixtranslate != null)
                    {
                        tmpsb.append(prefixtranslate);
                        tmpsb.append(PARENTFIELDSEP);
                    }
                    else if (prefix.getParent() != null && prefix.getParent().length() > 0)
                    {
                        tmpsb.append(prefix.getParent());
                        tmpsb.append(PARENTFIELDSEP);
                    }

                    tmpsb.append(prefix.getValue()).append(SINGLEBLANKBUFFER);
                    tmpsb.append(operator.toString()).append(SINGLEBLANKBUFFER);

                    break;
                case NOOPFALSE:
                    tmpsb.append(" false ");
                    break;
                case NOOPTRUE:
                    tmpsb.append(" true ");
                    break;
            }

            return tmpsb.toString();
    }

    public boolean isEqualityCondition(HashMap<String, String> map, String first, String second)
    {
        String prefixtranslate = map.get(prefix.getParent());
        String postfixtranslate = map.get(postfix.getParent());

        if (prefixtranslate == null || postfixtranslate == null)
            return false;

        switch (operator.getType())
        {
            case BINARY:
                return ( !prefixtranslate.equals(postfixtranslate) &&
                        (prefixtranslate.equals(first) || postfixtranslate.equals(first) &&
                                prefixtranslate.equals(second) || postfixtranslate.equals(second)));
            case PRE_UNARY:
            case POST_UNARY:
            case NOOPFALSE:
            case NOOPTRUE:
            default:
                return false;
        }
    }

    public void setPrefix(SQLFragment prefix)
    {
        this.prefix = prefix;
    }

    public void setPostfix(SQLFragment postfix)
    {
        this.postfix = postfix;
    }

    public void updateFragmentTables(List<SQLTable> sqlTables) throws Exception
    {
        if (postfix.getType() == FragmentType.FIELD || postfix.getType() == FragmentType.FIELD_CONTENT_MODIFIER || postfix.getType() == FragmentType.AGGREGATE_FUNCTION)
            postfix.updateFragmentColumParent(sqlTables);

        if (prefix.getType() == FragmentType.FIELD || prefix.getType() == FragmentType.FIELD_CONTENT_MODIFIER)
            prefix.updateFragmentColumParent(sqlTables);
    }

    /*
     * Sets parameterized values based on index passed in.
     * Expression could contain multiple parameters, returns
     * appropriately advanced index.
     */
    public int setParameterizedNames(int currentIndex)
    {
        if (prefix.getType() == FragmentType.PARAMETERIZED)
            prefix.setValue(SQLParser.parameterizedPrefix + currentIndex++);

        if (postfix.getType() == FragmentType.PARAMETERIZED)
            postfix.setValue(SQLParser.parameterizedPrefix + currentIndex++);

        return currentIndex;
    }

    public boolean containsKey(String colname)
    {
        if(getPrefixType() == FragmentType.FIELD && getPrefixValue().equals(colname) ||
           getPostfixType() == FragmentType.FIELD && getPostfixValue().equals(colname))
        {
            return true;
        }
        else
            return false;
    }

    public void setPreviousExpUnifier(SQLOperator prevexpunifier)
    {
        this.prevExpUnifier = prevexpunifier;
    }

    public SQLOperator getPreviousExpUnifier()
    {
        return this.prevExpUnifier;
    }
}
