/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

public final class UtilitariosLocal {

    public static String consulta(String procedureName, int cantidad) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("{CALL ").append(procedureName).append("(");
        for (int i = 0; i < cantidad; i++) {
            if (i <= cantidad - 2) {
                sb.append("?,");
            } else {
                sb.append("?");
            }
        }
        sb.append(")}");
        return sb.toString();
    }

    public static String completarConCeros(String text, int maximoDigitos) {
        int numCeros = maximoDigitos - text.length();
        String ceros = "";
        for (int i = 0; i < numCeros; i++) {
            ceros += "0";
        }
        return ceros + text;
    }

    public static java.sql.Timestamp campo_tipo_fecha(Date fecha) {
        if (fecha == null) {
            return null;
        } else {
            return new java.sql.Timestamp(((java.util.Date) fecha).getTime());
        }
    }

    public static java.sql.Timestamp object_fecha(Object fecha) {
        if (fecha == null) {
            return null;
        } else {
            return new java.sql.Timestamp(((java.util.Date) fecha).getTime());
        }
    }

    public static double parseDouble_Null(String str) {
        return str != null ? Double.parseDouble(str) : 0;
    }

    public static Integer parseInteger_Null(String str) {
        return str != null && !str.isEmpty() ? Integer.parseInt(str) : new Integer(0);

    }

    public static String HostLocal() throws UnknownHostException {
        InetAddress l = InetAddress.getLocalHost();
        return l.getHostName();
    }

    public static boolean esDecimal(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
      public static SelectItem[] filtrosTabla_String(List<String> lista) {

        SelectItem[] estados = new SelectItem[lista.size() + 1];
        int x = 0;
        if (lista.isEmpty()) {
            estados[x] = new SelectItem("", "TODOS");
        } else {
            for (String c : lista) {
                if (x == 0) {
                    estados[x] = new SelectItem("", "TODOS");
                    x++;
                    estados[x] = new SelectItem(c, c);
                    x++;
                } else {
                    estados[x] = new SelectItem(c, c);
                    x++;
                }
            }
        }
        return estados;
    }
      public static SelectItem[] filtrosTabla(List<String[]> lista) {

        SelectItem[] estados = new SelectItem[lista.size() + 1];
        int x = 0;
        if (lista.isEmpty()) {
            estados[x] = new SelectItem("", "TODOS");
        } else {
            for (String[] c : lista) {
                if (x == 0) {
                    estados[x] = new SelectItem("", "TODOS");
                    x++;
                    estados[x] = new SelectItem(c[0], c[1]);
                    x++;
                } else {
                    estados[x] = new SelectItem(c[0], c[1]);
                    x++;
                }
            }
        }
        return estados;
    }
      
      public static SelectItem[] filtrosTabla_Dsc(List<String[]> lista) {

        SelectItem[] estados = new SelectItem[lista.size() + 1];
        int x = 0;
        if (lista.isEmpty()) {
            estados[x] = new SelectItem("", "TODOS");
        } else {
            for (String[] c : lista) {
                if (x == 0) {
                    estados[x] = new SelectItem("", "TODOS");
                    x++;
                    estados[x] = new SelectItem(c[1], c[1]);
                    x++;
                } else {
                    estados[x] = new SelectItem(c[1], c[1]);
                    x++;
                }
            }
        }
        return estados;
    }
}
