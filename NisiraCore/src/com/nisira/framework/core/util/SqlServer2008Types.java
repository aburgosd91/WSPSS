/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.util;

import java.sql.Types;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public enum SqlServer2008Types {

    INT(Types.INTEGER),
    VARCHAR(Types.VARCHAR),
    DECIMAL(Types.DECIMAL),
    TINYINT(Types.TINYINT),
    DATETIME(Types.TIMESTAMP),
    SMALLINT(Types.SMALLINT),
    BIGINT(Types.BIGINT),
    REAL(Types.REAL),
    DOUBLE(Types.DOUBLE),
    FLOAT(Types.FLOAT),
    NUMERIC(Types.NUMERIC),
    DATE(Types.DATE),
    YEAR(Types.TIME),
    TIME(Types.TIME),
    BIT(Types.BIT),
    CHAR(Types.CHAR),
    BINARY(Types.BINARY),
    VARBINARY(Types.VARBINARY),
    TINYBLOB(Types.BLOB),
    BLOB(Types.BLOB),
    MEDIUMBLOB(Types.BLOB),
    LONGBLOB(Types.BLOB),
    TINYTEXT(Types.VARCHAR),
    TEXT(Types.VARCHAR),
    MEDIUMTEXT(Types.VARCHAR),
    LONGTEXT(Types.VARCHAR);
    private int value;

    SqlServer2008Types(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getValue(String type) {
        if (type.equalsIgnoreCase(SqlServer2008TypesString.INT.getValue())) {
            return INT.getValue();
        }
        if (type.equalsIgnoreCase(SqlServer2008TypesString.VARCHAR.getValue())) {
            return VARCHAR.getValue();
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

        return 0;
    }
}
