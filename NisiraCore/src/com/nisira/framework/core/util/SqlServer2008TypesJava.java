/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.util;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public enum SqlServer2008TypesJava {

    VARCHAR(String.class),
    INTEGER(Integer.class),
    DECIMAL(Double.class),
    TIMESTAMP(java.util.Date.class),
    DATE(java.util.Date.class),
    TINYINT(Integer.class),
    DATETIME(Timestamp.class),
    SMALLINT(Integer.class),
    BIGINT(Integer.class),
    REAL(Double.class),
    DOUBLE(Double.class),
    FLOAT(Float.class),
    NUMERIC(Double.class),
    YEAR(java.util.Date.class),
    TIME(Timestamp.class),
    BIT(Boolean.class),
    CHAR(String.class),
    BINARY(Integer.class),
    VARBINARY(Integer.class),
    TINYBLOB(Blob.class),
    BLOB(Blob.class),
    MEDIUMBLOB(Blob.class),
    LONGBLOB(Blob.class),
    TINYTEXT(String.class),
    TEXT(String.class),
    MEDIUMTEXT(String.class),
    LONGTEXT(String.class);
    private Class value;

    SqlServer2008TypesJava(Class value) {
        this.value = value;
    }

    public Class getValue() {
        return value;
    }

    public static Class getValue(String type) {
        if (type.equalsIgnoreCase(SqlServer2008TypesString.VARCHAR.getValue())) {
            return VARCHAR.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.INT.getValue())) {
            return INTEGER.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.DECIMAL.getValue())) {
            return DECIMAL.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.TINYINT.getValue())) {
            return TINYINT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.DATETIME.getValue())) {
            return DATETIME.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.SMALLINT.getValue())) {
            return SMALLINT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.BIGINT.getValue())) {
            return BIGINT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.REAL.getValue())) {
            return REAL.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.DOUBLE.getValue())) {
            return DOUBLE.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.FLOAT.getValue())) {
            return FLOAT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.NUMERIC.getValue())) {
            return NUMERIC.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.DATE.getValue())) {
            return DATE.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.YEAR.getValue())) {
            return YEAR.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.TIME.getValue())) {
            return TIME.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.BIT.getValue())) {
            return BIT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.CHAR.getValue())) {
            return CHAR.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.BINARY.getValue())) {
            return BINARY.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.VARBINARY.getValue())) {
            return VARBINARY.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.TINYBLOB.getValue())) {
            return TINYBLOB.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.BLOB.getValue())) {
            return BLOB.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.MEDIUMBLOB.getValue())) {
            return MEDIUMBLOB.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.LONGBLOB.getValue())) {
            return LONGBLOB.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.TINYTEXT.getValue())) {
            return TINYTEXT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.TEXT.getValue())) {
            return TEXT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.MEDIUMTEXT.getValue())) {
            return MEDIUMTEXT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.LONGTEXT.getValue())) {
            return LONGTEXT.getValue();
        }
        return null;
    }
}
