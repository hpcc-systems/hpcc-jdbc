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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hpccsystems.ws.client.gen.extended.wssql.v3_03.HPCCColumn;
import org.hpccsystems.ws.client.utils.FileFormat;

public class DFUFile
{
    private String              prefix = null;
    private String              clusterName = null;
    private String              directory = null;
    private String              description = "";
    private int                 parts = -1;
    private String              fullyQualifiedName = null;
    private String              fileName = null;
    private String              owner = null;
    private long                totalSize = -1;
    private long                recordCount = -1;
    private String              modified = null;
    private long                longSize = -1;
    private long                longRecordCount = -1;
    private boolean             isSuperFile = false;
    private boolean             isZipFile = false;
    private boolean             isDirectory = false;
    private int                 replicate = -1;
    private int                 intSize = -1;
    private int                 intRecordCount = -1;
    private boolean             fromRoxieCluster = false;
    private boolean             browseData = false;
    private boolean             isKeyFile = false;
    private FileFormat          format = FileFormat.FLAT;
    private String              csvSeparate = null;
    private String              csvTerminate = null;
    private String              csvQuote = null;
    private String              ecl = null;
    private Properties          fields = new Properties();
    private Properties          keyedColumns = new Properties();
    private Properties          nonKeyedColumns = new Properties();
    private List<String>        relatedIndexes = null;
    private List<String>        subFiles = null;
    private String              idxFilePosField = null;
    private boolean             hasPayLoad = false;
    private boolean             hasKeyedFieldInfoBeenSet = false;

    private final static String RELATEDINDEXKEYWORD = "XDBC:RelIndexes";
    private final static Pattern RELINDEXPATTERN = Pattern.compile(
            "\\s*" + RELATEDINDEXKEYWORD + "\\s*=\\s*\\[(.*?)\\s*\\].*",Pattern.DOTALL);

    private final static String IDXFILEPOSFIELDTAG  = "XDBC:PosField";
    private final static Pattern IDXPOSPATTERN = Pattern.compile(
            "\\s*" + IDXFILEPOSFIELDTAG + "\\s*=\\s*\\[(.*?)\\s*\\].*",Pattern.DOTALL);

    public DFUFile(String prefix, String clusterName, String filename)
    {
        super();
        this.prefix = prefix;
        this.clusterName = clusterName;
        this.fileName = filename;
        this.fullyQualifiedName = filename;
    }

    public DFUFile(String prefix, String clusterName, String directory, String description, int parts, String filename,
            String fullyqualifiedname, String owner, long totalSize, long recordCount, String modified, long longSize,
            long longRecordCount, boolean isSuperFile, boolean isZipFile, boolean isDirectory, int replicate,
            int intSize, int intRecordCount, boolean fromRoxieCluster, boolean browseData, boolean isKeyFile,
            FileFormat format, String csvseparate, String csvterminate, String csvquote, String ecl)
    {
        this.prefix = prefix;
        this.clusterName = clusterName;
        this.directory = directory;
        this.description = description;
        this.parts = parts;
        this.fileName = filename;
        this.fullyQualifiedName = fullyqualifiedname;
        this.owner = owner;
        this.totalSize = totalSize;
        this.recordCount = recordCount;
        this.modified = modified;
        this.longSize = longSize;
        this.longRecordCount = longRecordCount;
        this.isSuperFile = isSuperFile;
        this.isZipFile = isZipFile;
        this.isDirectory = isDirectory;
        this.replicate = replicate;
        this.intSize = intSize;
        this.intRecordCount = intRecordCount;
        this.fromRoxieCluster = fromRoxieCluster;
        this.browseData = browseData;
        this.isKeyFile = isKeyFile;
        this.format = format;
        this.csvSeparate = csvseparate;
        this.csvTerminate = csvterminate;
        this.csvQuote = csvquote;

        if (ecl != null && ecl.length() > 0)
        {
            this.ecl = ecl;
            setFileRecDef(ecl);
        }
    }

    public DFUFile() {}

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getClusterName()
    {
        return clusterName;
    }

    public void setClusterName(String clusterName)
    {
        this.clusterName = clusterName;
    }

    public String getDirectory()
    {
        return directory;
    }

    public void setDirectory(String directory)
    {
        this.directory = directory;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        if (description != null && description.length() > 0 )
        {
            this.description = description.trim();

            int pos=this.description.indexOf(RELATEDINDEXKEYWORD);
            if ( pos > -1) //found keyword
                setRelatedIndexes(description.substring(pos));

            pos=this.description.indexOf(IDXFILEPOSFIELDTAG);
            if ( pos > -1) //found keyword
                setIdxFilePosField(description.substring(pos));
        }
    }

    private void setIdxFilePosField(String str)
    {
        Matcher matcher = IDXPOSPATTERN.matcher(str);

        if(matcher.matches())
            idxFilePosField = matcher.group(1);
    }

    public String getIdxFilePosField()
    {
        return idxFilePosField != null ? idxFilePosField : getLastNonKeyedNumericField();
    }

    public boolean hasValidIdxFilePosField()
    {
        String tmp = getIdxFilePosField();
        return tmp != null && tmp.length() > 0;
    }

    private String getLastNonKeyedNumericField()
    {
        // TODO get numeric field
        return (String) nonKeyedColumns.get(nonKeyedColumns.size());
    }

    private void setRelatedIndexes(String str)
    {
        Matcher matcher = RELINDEXPATTERN.matcher(str);

        if(matcher.matches())
        {
            StringTokenizer indexeToks = new StringTokenizer(matcher.group(1), ";");

            while (indexeToks.hasMoreTokens())
            {
                addRelatedIndex(indexeToks.nextToken().trim());
            }
        }
        else
            HPCCJDBCUtils.traceoutln(Level.SEVERE, "Could not determine related index for file: " + this.getFullyQualifiedName());
    }

    public int getParts()
    {
        return parts;
    }

    public void setParts(int parts)
    {
        this.parts = parts;
    }

    public String getFullyQualifiedName()
    {
        return fullyQualifiedName;
    }

    public void setFullyQualifiedName(String name)
    {
        this.fullyQualifiedName = name;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public long getTotalSize()
    {
        return totalSize;
    }

    public void setTotalSize(long totalSize)
    {
        this.totalSize = totalSize;
    }

    public long getRecordCount()
    {
        return recordCount;
    }

    public void setRecordCount(long recordCount)
    {
        this.recordCount = recordCount;
    }

    public String getModified()
    {
        return modified;
    }

    public void setModified(String modified)
    {
        this.modified = modified;
    }

    public long getLongSize()
    {
        return longSize;
    }

    public void setLongSize(long longSize)
    {
        this.longSize = longSize;
    }

    public long getLongRecordCount()
    {
        return longRecordCount;
    }

    public void setLongRecordCount(long longRecordCount)
    {
        this.longRecordCount = longRecordCount;
    }

    public boolean isSuperFile()
    {
        return isSuperFile;
    }

    public void setSuperFile(boolean isSuperFile)
    {
        this.isSuperFile = isSuperFile;
    }

    public boolean isZipFile()
    {
        return isZipFile;
    }

    public void setZipFile(boolean isZipFile)
    {
        this.isZipFile = isZipFile;
    }

    public boolean isDirectory()
    {
        return isDirectory;
    }

    public void setDirectory(boolean isDirectory)
    {
        this.isDirectory = isDirectory;
    }

    public int getReplicate()
    {
        return replicate;
    }

    public void setReplicate(int replicate)
    {
        this.replicate = replicate;
    }

    public int getIntSize()
    {
        return intSize;
    }

    public void setIntSize(int intSize)
    {
        this.intSize = intSize;
    }

    public int getIntRecordCount()
    {
        return intRecordCount;
    }

    public void setIntRecordCount(int intRecordCount)
    {
        this.intRecordCount = intRecordCount;
    }

    public boolean isFromRoxieCluster()
    {
        return fromRoxieCluster;
    }

    public void setFromRoxieCluster(boolean fromRoxieCluster)
    {
        this.fromRoxieCluster = fromRoxieCluster;
    }

    public boolean isBrowseData()
    {
        return browseData;
    }

    public void setBrowseData(boolean browseData)
    {
        this.browseData = browseData;
    }

    public boolean isKeyFile()
    {
        return isKeyFile;
    }

    public void setIsKeyFile(boolean isKeyFile)
    {
        this.isKeyFile = isKeyFile;
    }

    public void setFileFields(String eclString)
    {
        ecl = "";
        if (eclString != null && eclString.length() > 0)
        {
            try
            {
                StringTokenizer commatokens = null;
                // ECL RECORD can be defined as { type name,...,type name}; or
                // RECORD type name;...;type name;END;
                // TODO we should handle nested file types
                if (eclString.toUpperCase().contains("RECORD"))
                {
                    String tmp = eclString.substring(eclString.indexOf("RECORD") + 6, eclString.indexOf("END"));
                    commatokens = new StringTokenizer(tmp, ";");
                }
                else if (eclString.contains("{"))
                {
                    String tmp = eclString.substring(eclString.indexOf('{') + 1, eclString.indexOf('}'));
                    commatokens = new StringTokenizer(tmp, ",");
                }

                if (commatokens != null)
                {
                    int index = 0;
                    while (commatokens.hasMoreTokens())
                    {
                        String commatoken = commatokens.nextToken().trim();
                        String spacesplit[] = commatoken.split("\\s+");

                        String name = spacesplit[spacesplit.length - 1];
                        if (name.length() > 0)
                        {
                            StringBuffer type = new StringBuffer();
                            for (int i = 0; i < spacesplit.length - 1; i++)
                            {
                                type.append(spacesplit[i]);
                                if (i + 1 < spacesplit.length - 1)
                                    type.append(" ");
                            }

                            HPCCColumnMetaData columnmeta = new HPCCColumnMetaData(name, index,java.sql.Types.OTHER);

                            columnmeta.setEclType(type.toString());
                            columnmeta.setTableName(this.fullyQualifiedName);

                            ecl += type + " " + name + "; ";
                            fields.put(name.toUpperCase(), columnmeta);

                            index++;
                        }
                    }
                }
            }
            catch (Exception e)
            {
                HPCCJDBCUtils.traceoutln(Level.SEVERE,   "Invalid ECL Record definition found in " + this.getFullyQualifiedName()                        + " details.");
                return;
            }
        }
    }

    public Enumeration<Object> getAllFields()
    {
        return fields.elements();
    }

    public Properties getAllFieldsProps()
    {
        return fields;
    }

    public boolean containsField(String fieldName)
    {
        return fields.containsKey(fieldName.toUpperCase());
    }

    public HPCCColumnMetaData getFieldMetaData(String fieldName)
    {
        return (HPCCColumnMetaData) fields.get(fieldName.toUpperCase());
    }

    public String[] getAllTableFieldsStringArray()
    {
        String[] fieldsstr = new String[fields.size()];
        Enumeration<Object> it = fields.elements();
        while (it.hasMoreElements())
        {
            HPCCColumnMetaData col = ((HPCCColumnMetaData) it.nextElement());
            fieldsstr[col.getIndex()] = col.getColumnName();
        }
        return fieldsstr;
    }

    public String getFormatName()
    {
        return format != null ? format.toString() : "";
    }

    public FileFormat getFormat()
    {
        return format;
    }

    public String getCsvSeparate()
    {
        return csvSeparate;
    }

    public String getCsvTerminate()
    {
        return csvTerminate;
    }

    public void setFormat(String formatstr)
    {
        format = FileFormat.FLAT;

        if (formatstr != null && formatstr.length() > 0)
        {
            try
            {
                format = HPCCJDBCUtils.findEnumValFromString(FileFormat.class, formatstr.trim());
                if (format == FileFormat.KEYED)
                    setIsKeyFile(true);
            }
            catch (Exception e)
            {
                HPCCJDBCUtils.traceoutln(Level.SEVERE,   "Invalid file format detected, treating as FLAT format" + (fullyQualifiedName == null ? "!" : ": " + fullyQualifiedName));
            }
        }
    }

    public void setCsvSeparate(String csvSeparate)
    {
        this.csvSeparate = csvSeparate;
    }

    public void setCsvTerminate(String csvTerminate)
    {
        this.csvTerminate = csvTerminate;
    }

    public void setCsvQuote(String csvQuote)
    {
        this.csvQuote = csvQuote;
    }

    public String getCsvQuote()
    {
        return csvQuote;
    }

    public boolean hasFileRecDef()
    {
        return ecl == null || ecl.length() <= 0 ? false : true;
    }

    public String getFileRecDef(String structname)
    {
        return ecl == null ? null : structname + " := RECORD " + ecl + "END; ";
    }

    public void setFileRecDef(String ecl)
    {
        if (ecl != null && ecl.length() > 0)
            setFileFields(ecl);
    }

    public HPCCColumnMetaData getCompatibleField(String keyName, String keyType)
    {
        // EclColumnMetaData field = (EclColumnMetaData)
        // Fields.get(keyName.toUpperCase());
        // want to match up name and type, for now just check name.
        return (HPCCColumnMetaData) fields.get(keyName.toUpperCase());
    }

    public void setKeyedColumns(Properties keyFields)
    {
        hasKeyedFieldInfoBeenSet = true;
        keyedColumns = keyFields;
    }

    public void setNonKeyedColumns(Properties nonKeyFields)
    {
        hasKeyedFieldInfoBeenSet = true;
        nonKeyedColumns = nonKeyFields;
        if (nonKeyFields != null && nonKeyFields.size() > 0)
            hasPayLoad = true;
    }

    public void addKeyedColumnInOrder(String keyLabel)
    {
        hasKeyedFieldInfoBeenSet = true;
        keyedColumns.put(keyedColumns.size() + 1, keyLabel);
    }

    public void addKeyedColumn(int KeyIndex, String KeyLabel)
    {
        if (!keyedColumns.containsKey(KeyIndex))
            keyedColumns.put(KeyIndex, KeyLabel);
    }

    public void addNonKeyedColumnInOrder(String keyLabel)
    {
        hasKeyedFieldInfoBeenSet = true;
        if (keyLabel.startsWith("__internal_fpos__"))
        {
            // IndexPositionField = KeyLabel;
            return;
        }
        nonKeyedColumns.put(nonKeyedColumns.size() + 1, keyLabel);
    }

    public void addNonKeyedColumn(int nonKeyIndex, String nonKeyLabel)
    {
        hasKeyedFieldInfoBeenSet = true;
        if (!nonKeyedColumns.containsKey(nonKeyIndex))
        {
            nonKeyedColumns.put(nonKeyIndex, nonKeyLabel);
            hasPayLoad = true;
        }
    }

    public boolean hasPayLoad()
    {
        return hasPayLoad;
    }

    public Properties getKeyedColumns()
    {
        return keyedColumns;
    }

    public Properties getNonKeyedColumns()
    {
        return nonKeyedColumns;
    }

    public int getNonKeyColumnIndex(String columnName)
    {
        int cols = nonKeyedColumns.size();
        for (int i = 1; i <= cols; i++)
        {
            if (nonKeyedColumns.get(i).equals(columnName))
                return i;
        }

        return -1;
    }

    public int getKeyColumnIndex(String columnName)
    {
        int cols = keyedColumns.size();
        for (int i = 1; i <= cols; i++)
        {
            if (keyedColumns.get(i).equals(columnName))
                return i;
        }
        return -1;
    }

    public void addRelatedIndex(String indexName)
    {
        if (relatedIndexes == null)
            relatedIndexes = new ArrayList<String>();

        relatedIndexes.add(indexName);
    }

    public void setRelatedIndexes(List<String> indexes)
    {
        relatedIndexes = indexes;
    }

    public boolean isRelatedIndex(String indexname)
    {
        if (relatedIndexes != null)
            return relatedIndexes.contains(indexname);
        return false;
    }

    public Iterator<String> getRelatedIndexes()
    {
        return relatedIndexes == null ? null : relatedIndexes.iterator();
    }

    public String[] getRelatedIndexesAsArray()
    {
        String[] indexes = new String[relatedIndexes.size()];
        for (int i = 0; i < indexes.length; i++)
        {
            indexes[i] = relatedIndexes.get(i);
        }
        return indexes;
    }

    public List<String> getRelatedIndexesList()
    {
        return relatedIndexes;
    }

    public int getRelatedIndexesCount()
    {
        return relatedIndexes == null ? 0 : relatedIndexes.size();
    }

    public Object getFileRecDefwithIndexpos(HPCCColumnMetaData fieldMetaData, String structname)
    {
        if (fieldMetaData != null)
            return structname + " := RECORD " + ecl + fieldMetaData.getEclType() + " " + fieldMetaData.getColumnName()
                    + " {virtual(fileposition)}; END; ";

        return structname + " := RECORD " + ecl + " END; "; // might need to throw exception instead
    }

    public String getKeyedFieldsAsDelmitedString(char c, String prefixtoappend)
    {
        StringBuilder fields = new StringBuilder();
        int colscount = keyedColumns.size();

        for (int i = 1; i <= colscount; i++)
        {
            if (prefixtoappend != null)
                fields.append(prefixtoappend).append('.');
            fields.append(keyedColumns.get(i));
            if (i < colscount)
                fields.append(c).append(" ");
        }
        return fields.toString();
    }

    public String getNonKeyedFieldsAsDelmitedString(char c, String prefixtoappend)
    {
        StringBuilder fields = new StringBuilder();
        int colscount = nonKeyedColumns.size();

        for (int i = 1; i <= colscount; i++)
        {
            if (prefixtoappend != null)
                fields.append(prefixtoappend).append('.');
            fields.append(nonKeyedColumns.get(i));
            if (i < colscount)
                fields.append(c).append(" ");
        }
        return fields.toString();
    }

    public String getAllFieldsAsDelimitedString(char c)
    {
        String[] cols = getAllTableFieldsStringArray();
        StringBuilder fields = new StringBuilder();
        if (cols.length <= 0)
        {
            for (int index = 0; index < cols.length; index++)
            {
                fields.append(cols[index]);

                if (index < cols.length - 1)
                    fields.append(c).append(" ");
            }
        }

        return fields.toString();
    }

    public String getIndexNameByIndex(int i)
    {
        return relatedIndexes.get(i);
    }

    public boolean hasRelatedIndexes()
    {
        return relatedIndexes == null || relatedIndexes.size() <= 0 ? false : true;
    }

    public boolean containsField(HPCCColumnMetaData fieldMetaData, boolean verifyEclType)
    {
        String fieldName = fieldMetaData.getColumnName().toUpperCase();
        if (fields.containsKey(fieldName))
            if (!verifyEclType
                    || ((HPCCColumnMetaData) fields.get(fieldName)).getEclType().equals(fieldMetaData.getEclType()))
                return true;
        return false;
    }

    public boolean containsAllFieldsNames(String[] columnNames)
    {
        if (columnNames != null)
        {
            for (int i = 0; i < columnNames.length; i++)
            {
                if (!this.containsField(columnNames[i]))
                    return false;
            }
            return true;
        }

        return false;
    }

    public int getNonKeyedColumnsCount()
    {
        return nonKeyedColumns == null ? 0 : nonKeyedColumns.size();
    }

    public boolean containsField(HPCCColumnMetaData column)
    {
        return this.containsField(column.getColumnName());
    }

    public int getSubfilesCount()
    {
        return (subFiles == null) ? 0 : subFiles.size();
    }

    public boolean containsSubfiles()
    {
        return (getSubfilesCount() > 0) ? true : false;
    }

    public List<String> getSubfiles()
    {
        return subFiles;
    }

    public String getSubfile(int index)
    {
        String subfilename = "";

        try
        {
            if (subFiles != null)
                subfilename = subFiles.get(index);
        }
        catch (Exception e)
        {
        }

        return subfilename;
    }

    public boolean addSubfile(String subfilename)
    {
        boolean isSuccess = false;

        if (subfilename.length() > 0)
        {
            if (subFiles == null)
                subFiles = new ArrayList<String>();
            try
            {
                isSuccess = subFiles.add(subfilename);
            }
            catch (Exception e)
            {
                isSuccess = false;
            }
        }

        return isSuccess;
    }

    public boolean hasKeyedFieldInfoBeenSet()
    {
        return hasKeyedFieldInfoBeenSet;
    }

    public void setColumns(HPCCColumn[] columns)
    {
        ecl = "";
        for (int index = 0; index < columns.length; index++)
        {
            String name = columns[index].getName();
            String type = columns[index].getType();
            HPCCColumnMetaData columnmeta = new HPCCColumnMetaData(name, index,java.sql.Types.OTHER);

            columnmeta.setEclType(type);
            columnmeta.setTableName(this.fullyQualifiedName);

            ecl += type + " " + name + "; ";
            fields.put(name.toUpperCase(), columnmeta);
        }
    }
}
