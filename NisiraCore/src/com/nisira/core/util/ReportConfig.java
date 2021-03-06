/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.util;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.NSRResultSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javatuples.Pair;

/**
 *
 * @author aburgos
 */
public class ReportConfig {
    /*ESTRUCTURA REPORTE*/
    public static Pair<List<String>, List<Object[]>> getDataAndColumnas(ResultSet rs) throws NisiraORMException {
            try {
                    ResultSetMetaData rm = rs.getMetaData();
                    int numCols = rm.getColumnCount();
                    List<String> cabeceras = new ArrayList<String>();
                    for (int i = 0; i < numCols; ++i) {
                            cabeceras.add(rm.getColumnName(i + 1).trim());
                    }
                    List<Object[]> lista;
                    lista = new ArrayList<Object[]>();
                    while (rs.next()) {
                            Object[] reg = new Object[numCols];
                            for (int i = 0; i < numCols; i++) {
                                reg[i] = rs.getObject(i + 1);

                                if (reg[i] instanceof Clob) {
                                    try {
                                        reg[i] = clobToString((Clob)reg[i]);
                                    } catch (IOException ex) {
                                        reg[i]=null;
                                        Logger.getLogger(ReportConfig.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                }
                            }
                            lista.add(reg);
                    }
                    return Pair.with(cabeceras, lista);
            } catch (SQLException e) {
                    throw new NisiraORMException(e.getMessage());
            }
    }

    public static NSRResultSet getNSRResultSet(ResultSet rs) throws NisiraORMException {
            Pair<List<String>, List<Object[]>> values = getDataAndColumnas(rs);
            NSRResultSet nsrrs = new NSRResultSet();
            String[] h = (String[]) values.getValue0().toArray(new String[values.getValue0().size()]);
            nsrrs.setData(values.getValue1(), h);
            return nsrrs;
    }
    public static String clobToString(Clob data) throws IOException, SQLException {
        StringBuilder sb = new StringBuilder();
        Reader reader = data.getCharacterStream();
        BufferedReader br = new BufferedReader(reader);

        String line;
        while(null != (line = br.readLine())) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
