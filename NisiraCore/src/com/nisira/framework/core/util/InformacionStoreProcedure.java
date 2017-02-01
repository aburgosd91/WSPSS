/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.util;

import com.nisira.core.dao.BaseDao;
import com.nisira.core.dao.Conexion;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public class InformacionStoreProcedure extends Conexion{

    /**
     * Devuelve la información del procedimiento almacenado
     * @param spName Nombre del Procedimiento almacenado
     * @return
     * @throws Exception 
     */
    public List<ColumnaBD> informacionDeProcemientos(String spName) throws Exception {
        List<ColumnaBD> lista = new ArrayList();
        ColumnaBD dato = null;
        cn = obtenerConexion();
        DatabaseMetaData dbMetaData = cn.getMetaData();
        rs = dbMetaData.getProcedureColumns(null, null, spName, null);
        while (rs.next()) {
            String columnName = rs.getString(4);
            if(!columnName.equalsIgnoreCase("@RETURN_VALUE")){
                short columnReturn = rs.getShort(5);
                String columnReturnTypeName = rs.getString(7);
                int columnPrecision = rs.getInt(8);
                int columnLongitud = rs.getInt(9);
                short columnScale = rs.getShort(10);
                dato = new ColumnaBD();
                dato.setNombreColumna(columnName);
                dato.setTipoSQL(columnReturnTypeName);
                switch (columnReturn) {
                    case 1:
                        dato.setTipoRetorno("IN");
                        break;
                    case 2:
                        dato.setTipoRetorno("INOUT");
                        break;
                    case 4:
                        dato.setTipoRetorno("OUT");
                        break;
                }
                dato.setPrecision(columnPrecision);
                dato.setEscala(columnScale);
                dato.setTamaño(columnLongitud);
                lista.add(dato);
            }
        }
        cerrar(rs);
        cerrar(cn);
        return lista;
    }

    public List<ColumnaBD> informacionDeResulset(ResultSet rs) throws Exception {
        ResultSetMetaData rsMet = rs.getMetaData();
        int tamaño = rsMet.getColumnCount();
        List<ColumnaBD> lista = new ArrayList();
        for (int i = 1; i <= tamaño; i++) {
            ColumnaBD dato = new ColumnaBD();
            dato.setNombreColumna(rsMet.getColumnName(i));
            dato.setNombre(rsMet.getColumnLabel(i));
            dato.setTipoSQL(rsMet.getColumnTypeName(i));
            lista.add(dato);
        }
        rsMet = null;
        return lista;
    }
}
