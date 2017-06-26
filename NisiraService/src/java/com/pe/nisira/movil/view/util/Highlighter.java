/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

/**
 *
 * @author Antenor
 */
public class Highlighter {
    /*
     protected $colors - key order is important because of highlighting < and >
     chars and not encoding them to &lt; and &gt;
     */
    //protected $colors = Array('chars' => 'grey', 'keywords' => 'blue', 'joins' => 'gray', 'functions' => 'violet', 'constants' => 'red');
    //public String[][] colors = new String[4][1];

    protected String[][] colors = {{"chars", "grey"}, {"keywords", "blue"}, {"joins", "gray"}, {"functions", "violet"}, {"constants", "red"}, {"operators", "grey"}};

    /*
     lists are not complete.
     */
    protected String[][] words = {
        {"keywords", "SELECT"},
        {"keywords", "UPDATE"},
        {"keywords", "INSERT"},
        {"keywords", "DELETE"},
        {"keywords", "REPLACE"},
        {"keywords", "INTO"},
        {"keywords", "CREATE"},
        {"keywords", "ALTER"},
        {"keywords", "TABLE"},
        {"keywords", "DROP"},
        {"keywords", "TRUNCATE"},
        {"keywords", "FROM"},
        {"keywords", "ADD"},
        {"keywords", "CHANGE"},
        {"keywords", "COLUMN"},
        {"keywords", "KEY"},
        {"keywords", "WHERE"},
        {"keywords", "ON"},
        {"keywords", "CASE"},
        {"keywords", "WHEN"},
        {"keywords", "THEN"},
        {"keywords", "END"},
        {"keywords", "ELSE"},
        {"keywords", "AS"},
        {"keywords", "USING"},
        {"keywords", "USE"},
        {"keywords", "INDEX"},
        {"keywords", "CONSTRAINT"},
        {"keywords", "REFERENCES"},
        {"keywords", "DUPLICATE"},
        {"keywords", "LIMIT"},
        {"keywords", "OFFSET"},
        {"keywords", "SET"},
        {"keywords", "SHOW"},
        {"keywords", "STATUS"},
        {"keywords", "BETWEEN"},
        {"keywords", "AND"},
        {"keywords", "IS"},
        {"keywords", "NOT"},
        {"keywords", "OR"},
        {"keywords", "XOR"},
        {"keywords", "INTERVAL"},
        {"keywords", "TOP"},
        {"keywords", "GROUP BY"},
        {"keywords", "ORDER BY"},
        {"keywords", "DESC"},
        {"keywords", "ASC"},
        {"keywords", "COLLATE"},
        {"keywords", "NAMES"},
        {"keywords", "UTF8"},
        {"keywords", "DISTINCT"},
        {"keywords", "DATABASE"},
        {"keywords", "CALC_FOUND_ROWS"},
        {"keywords", "SQL_NO_CACHE"},
        {"keywords", "MATCH"},
        {"keywords", "AGAINST"},
        {"keywords", "LIKE"},
        {"keywords", "REGEXP"},
        {"keywords", "RLIKE"},
        {"keywords", "PRIMARY"},
        {"keywords", "AUTO_INCREMENT"},
        {"keywords", "DEFAULT"},
        {"keywords", "IDENTITY"},
        {"keywords", "VALUES"},
        {"keywords", "PROCEDURE"},
        {"keywords", "FUNCTION"},
        {"keywords", "TRAN"},
        {"keywords", "TRANSACTION"},
        {"keywords", "COMMIT"},
        {"keywords", "ROLLBACK"},
        {"keywords", "SAVEPOINT"},
        {"keywords", "TRIGGER"},
        {"keywords", "CASCADE"},
        {"keywords", "DECLARE"},
        {"keywords", "CURSOR"},
        {"keywords", "FOR"},
        {"keywords", "DEALLOCATE"},
        {"joins", "JOIN"},
        {"joins", "INNER"},
        {"joins", "OUTER"},
        {"joins", "FULL"},
        {"joins", "LEFT"},
        {"joins", "RIGHT"},
        {"chars", "/([\\.,\\(\\)<>:=`]+)/i"},
        {"functions", "MIN"},
        {"functions", "MAX"},
        {"functions", "SUM"},
        {"functions", "COUNT"},
        {"functions", "AVG"},
        {"functions", "CAST"},
        {"functions", "COALESCE"},
        {"functions", "CHAR_LENGTH"},
        {"functions", "LENGTH"},
        {"functions", "SUBSTRING"},
        {"functions", "DAY"},
        {"functions", "MONTH"},
        {"functions", "YEAR"},
        {"functions", "DATE_FORMAT"},
        {"functions", "CRC32"},
        {"functions", "CURDATE"},
        {"functions", "SYSDATE"},
        {"functions", "NOW"},
        {"functions", "GETDATE"},
        {"functions", "FROM_UNIXTIME"},
        {"functions", "FROM_DAYS"},
        {"functions", "TO_DAYS"},
        {"functions", "HOUR"},
        {"functions", "IFNULL"},
        {"functions", "ISNULL"},
        {"functions", "NVL"},
        {"functions", "NVL2"},
        {"functions", "INET_ATON"},
        {"functions", "INET_NTOA"},
        {"functions", "INSTR"},
        {"functions", "FOUND_ROWS"},
        {"functions", "LAST_INSERT_ID"},
        {"functions", "LCASE"},
        {"functions", "LOWER"},
        {"functions", "UCASE"},
        {"functions", "UPPER"},
        {"functions", "LPAD"},
        {"functions", "RPAD"},
        {"functions", "RTRIM"},
        {"functions", "LTRIM"},
        {"functions", "MD5"},
        {"functions", "MINUTE"},
        {"functions", "ROUND"},
        {"functions", "SECOND"},
        {"functions", "SHA1"},
        {"functions", "STDDEV"},
        {"functions", "STR_TO_DATE"},
        {"functions", "WEEK"},
        {"functions", "ABS"},
        {"functions", "CONVERT"},
        {"functions", "CURRENT_TIMESTAMP"},
        {"functions", "CURRENT_USER"},
        {"functions", "NULLIF"},
        {"functions", "SESSION_USER"},
        {"functions", "SPACE"},
        {"functions", "USER"},
        //{"constants","/(\'[^\']*\'|[0-9]+)/i"},
        {"constants", "(\'[^\']*\'|[0-9]+)"},
        {"operators", "ALL"},
        {"operators", "ANY"},
        {"operators", "CROSS"},
        {"operators", "IN"},
        {"operators", "NULL"},
        {"operators", "SOME"}
    };


    /* 
     $colors must be blank or 
     Array('chars' => '', 'keywords' => '', 'joins' => '', 'functions' => '', 'constants' => '')
     */
//  public  Highlighter($colors = 0) {
//    if ($colors) $this->colors = $colors;
//  }
    public String highlight(String sql) {
        sql = sql.replace("\\\'", "\\&#039;");
        String regexp = "";
        for (int i = 0; i < 6; i++) {
            if (colors[i][0].compareTo("constants") > 0) {
                regexp = words[i][1];
            } else {
                if (colors[i][0].compareTo("chars") > 0) {
                    regexp = words[i][1];
                } else {
                    String re = "";
                    for (int k = 0; k < words.length / 2; k++) {
                        if (words[k][0].compareTo(words[i][0]) == 0) {
                            re = re + "|" + words[k][1];
                        }
                    }
                    regexp = "(" + re + ")";
                }

            }
            sql = sql.replaceAll(regexp, "<span style='color:" + colors[i][1] + "'\">1</span>");
        }
        return sql;
    }
}
