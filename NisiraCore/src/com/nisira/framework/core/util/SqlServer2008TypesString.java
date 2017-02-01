/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.util;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public enum SqlServer2008TypesString {

    INT("INT"),
    VARCHAR("VARCHAR"),
    DECIMAL("DECIMAL"),
    TINYINT("TINYINT"),
    DATETIME("DATETIME"),
    SMALLINT("SMALLINT"),
    BIGINT("BIGINT"),
    REAL("REAL"),
    DOUBLE("DOUBLE"),
    FLOAT("FLOAT"),
    NUMERIC("NUMERIC"),
    DATE("DATE"),
    YEAR("YEAR"),
    TIME("TIME"),
    BIT("BIT"),
    CHAR("CHAR"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY"),
    TINYBLOB("TINYBLOB"),
    BLOB("BLOB"),
    MEDIUMBLOB("MEDIUMBLOB"),
    LONGBLOB("LONGBLOB"),
    TINYTEXT("TINYTEXT"),
    TEXT("TEXT"),
    MEDIUMTEXT("MEDIUMTEXT"),
    LONGTEXT("LONGTEXT");
    private String value;

    SqlServer2008TypesString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(int type) {
        if (type == SqlServer2008Types.INT.getValue()) {
            return INT.getValue();
        }
        if (type == SqlServer2008Types.VARCHAR.getValue()) {
            return VARCHAR.getValue();
        }
        if (type == SqlServer2008Types.DECIMAL.getValue()) {
            return DECIMAL.getValue();
        }
        if (type == SqlServer2008Types.TINYINT.getValue()) {
            return TINYINT.getValue();
        }
        if (type == SqlServer2008Types.DATETIME.getValue()) {
            return DATETIME.getValue();
        }

        if (type == SqlServer2008Types.SMALLINT.getValue()) {
            return SMALLINT.getValue();
        }
        if (type == SqlServer2008Types.BIGINT.getValue()) {
            return BIGINT.getValue();
        }
        if (type == SqlServer2008Types.REAL.getValue()) {
            return REAL.getValue();
        }
        if (type == SqlServer2008Types.DOUBLE.getValue()) {
            return DOUBLE.getValue();
        }
        if (type == SqlServer2008Types.FLOAT.getValue()) {
            return FLOAT.getValue();
        }
        if (type == SqlServer2008Types.NUMERIC.getValue()) {
            return NUMERIC.getValue();
        }
        if (type == SqlServer2008Types.DATE.getValue()) {
            return DATE.getValue();
        }
        if (type == SqlServer2008Types.YEAR.getValue()) {
            return YEAR.getValue();
        }
        if (type == SqlServer2008Types.TIME.getValue()) {
            return TIME.getValue();
        }
        if (type == SqlServer2008Types.BIT.getValue()) {
            return BIT.getValue();
        }
        if (type == SqlServer2008Types.CHAR.getValue()) {
            return CHAR.getValue();
        }
        if (type == SqlServer2008Types.BINARY.getValue()) {
            return BINARY.getValue();
        }
        if (type == SqlServer2008Types.VARBINARY.getValue()) {
            return VARBINARY.getValue();
        }
        if (type == SqlServer2008Types.TINYBLOB.getValue()) {
            return TINYBLOB.getValue();
        }
        if (type == SqlServer2008Types.BLOB.getValue()) {
            return BLOB.getValue();
        }
        if (type == SqlServer2008Types.MEDIUMBLOB.getValue()) {
            return MEDIUMBLOB.getValue();
        }
        if (type == SqlServer2008Types.LONGBLOB.getValue()) {
            return LONGBLOB.getValue();
        }
        if (type == SqlServer2008Types.TINYTEXT.getValue()) {
            return TINYTEXT.getValue();
        }
        if (type == SqlServer2008Types.TEXT.getValue()) {
            return TEXT.getValue();
        }
        if (type == SqlServer2008Types.MEDIUMTEXT.getValue()) {
            return MEDIUMTEXT.getValue();
        }
        if (type == SqlServer2008Types.LONGTEXT.getValue()) {
            return LONGTEXT.getValue();
        }
        return "";
    }
}
