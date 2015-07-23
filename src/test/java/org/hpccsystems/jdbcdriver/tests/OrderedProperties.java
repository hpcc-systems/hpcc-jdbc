package org.hpccsystems.jdbcdriver.tests;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class OrderedProperties extends Properties
{
    private static final long serialVersionUID = 1L;
    private Vector<Object> keynames;

    public OrderedProperties()
    {
        super();

        keynames = new Vector<Object>();
    }

    public Enumeration<Object> propertyNames()
    {
        return keynames.elements();
    }

    public Object put(Object key, Object value)
    {
        if (keynames.contains(key))
        {
            keynames.remove(key);
        }

        keynames.add(key);

        return super.put(key, value);
    }

    public Object remove(Object key)
    {
        keynames.remove(key);

        return super.remove(key);
    }
}
