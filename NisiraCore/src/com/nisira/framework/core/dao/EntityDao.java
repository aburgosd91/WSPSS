/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.dao;

import com.nisira.core.dao.BaseDao;
import com.nisira.framework.core.util.SqlServer2008TypesJava;
import com.nisira.framework.core.util.SqlServer2008TypesString;
import com.nisira.framework.core.util.JavaTypes;
import com.nisira.framework.core.util.SqlServer2008Types;
import com.nisira.framework.core.util.ColumnaBD;
import com.nisira.framework.core.util.ConstantesFramework;
import com.nisira.framework.core.util.InformacionStoreProcedure;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_INSERT;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_UPDATE;
import static com.nisira.framework.core.util.ConstantesFramework.INICIO_DELETE;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_INSERT;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_UPDATE;
import static com.nisira.framework.core.util.ConstantesFramework.FIN_DELETE;
import static com.nisira.core.util.CoreUtil.nombreClase;
import static com.nisira.core.util.NisiraCoreLog.log;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public abstract class EntityDao<E> extends BaseDao<E>  {

    public EntityDao() {
        super();
    }

    @Override
    public E insert(E e) throws Exception {
        String sql = INICIO_INSERT + nombreClase(e) + FIN_INSERT;
        excuteStoreProcedure(e, sql);
        return e;
    }

    @Override
    public E update(E e) throws Exception {
        String sql = INICIO_UPDATE + nombreClase(e) + FIN_UPDATE;
        excuteStoreProcedure(e, sql);
        return e;
    }

    @Override
    public E delete(E e) throws Exception {
        String sql = INICIO_DELETE + nombreClase(e) + FIN_DELETE;
        excuteStoreProcedure(e, sql);
        return e;
    }

    private E excuteStoreProcedure(E e, String procedureName) throws Exception {
        boolean exito = false;
        try {
            InformacionStoreProcedure info = new InformacionStoreProcedure();
            List<ColumnaBD> listaColumnasProcedure = info.informacionDeProcemientos(procedureName);
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append("{CALL ").append(procedureName).append("(");
            int size = listaColumnasProcedure.size();
            for (int i = 0; i < size; i++) {
                if (i <= size - 2) {
                    sb.append("?,");
                } else {
                    sb.append("?");
                }
            }
            sb.append(")}");
            cn = obtenerConexion();
            cn.setAutoCommit(false);
            cl = cn.prepareCall(sb.toString());
            int i = 1;

            for (ColumnaBD c : listaColumnasProcedure) {
                String nombreColumna = c.getNombreColumna().substring(ConstantesFramework.PREFIJO_PROCEDURE.length());
                String nombreMetodoGet = "get" + String.valueOf(nombreColumna.charAt(0)).toUpperCase() + nombreColumna.substring(1);
                Method metodoGet = e.getClass().getMethod(nombreMetodoGet);
                Object valorCampo = metodoGet.invoke(e, new Object[0]);
                sb.append("\n");
                sb.append(c.getNombreColumna());
                sb.append(" = ");
                sb.append(valorCampo);
                if (c.getTipoRetorno().equalsIgnoreCase("IN")) {
                    if (c.getTipoSQL().equalsIgnoreCase("datetime")) {
                        if(valorCampo==null) cl.setTimestamp(i, null);
                        else cl.setTimestamp(i, new java.sql.Timestamp(((java.util.Date) valorCampo).getTime()));
                        
                    } else {
                        cl.setObject(i, valorCampo);
                    }
                } else {
                    cl.registerOutParameter(i, SqlServer2008Types.getValue(c.getTipoSQL()));
                }
                i++;
            }
            cl.executeUpdate();
            i = 1;
            for (ColumnaBD c : listaColumnasProcedure) {
                if (!c.getTipoRetorno().equalsIgnoreCase("IN")) {
                    this.invoke(e, cl, c, i, this.evaluateType(c));
                }
                i++;
            }
            //log.info(sb.toString());
            System.out.print(sb.toString());
            exito = true;
        } finally {
            if (exito && cn != null) {
                cn.commit();
            }else{
                rollback(cn);
            }
            cerrar(cn, cl);
        }

        return e;
    }

    /**
     * Evalua el tipo de columna SQL para decir cual es su equivalente en Java
     * @param c
     * @return retorna el tipo Java
     */
    private JavaTypes evaluateType(ColumnaBD c) {
        JavaTypes type = JavaTypes.OBJECT;
        if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.INT.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.VARCHAR.getValue())) {
            type = JavaTypes.STRING;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.DECIMAL.getValue())) {
            type = JavaTypes.DOUBLE;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.TINYINT.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.DATETIME.getValue())) {
            type = JavaTypes.TIMESTAMP;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.SMALLINT.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.BIGINT.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.REAL.getValue())) {
            type = JavaTypes.DOUBLE;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.DOUBLE.getValue())) {
            type = JavaTypes.DOUBLE;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.FLOAT.getValue())) {
            type = JavaTypes.FLOAT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.NUMERIC.getValue())) {
            type = JavaTypes.SHORT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.DATE.getValue())) {
            type = JavaTypes.DATE;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.YEAR.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.TIME.getValue())) {
            type = JavaTypes.TIMESTAMP;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.BIT.getValue())) {
            type = JavaTypes.BOOLEAN;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.CHAR.getValue())) {
            type = JavaTypes.CHAR;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.BINARY.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.VARBINARY.getValue())) {
            type = JavaTypes.INT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.TINYBLOB.getValue())) {
            type = JavaTypes.OBJECT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.BLOB.getValue())) {
            type = JavaTypes.OBJECT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.MEDIUMBLOB.getValue())) {
            type = JavaTypes.OBJECT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.LONGBLOB.getValue())) {
            type = JavaTypes.OBJECT;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.TINYTEXT.getValue())) {
            type = JavaTypes.STRING;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.TEXT.getValue())) {
            type = JavaTypes.STRING;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.MEDIUMTEXT.getValue())) {
            type = JavaTypes.STRING;
        } else if (c.getTipoSQL().equalsIgnoreCase(SqlServer2008TypesString.LONGTEXT.getValue())) {
            type = JavaTypes.STRING;
        }
        return type;
    }

    /**
     * Sirve para setear el valor del objeto del tipo set
     * @param e El objeto que vamos a setear
     * @param cl El CallableStatement
     * @param c Obtiene la informacion de la columna
     * @param i
     * @param type
     * @throws Exception 
     */
    private void invoke(E e, CallableStatement cl, ColumnaBD c, int i, JavaTypes type) throws Exception {


        String nombreColumna = c.getNombreColumna().substring(ConstantesFramework.PREFIJO_PROCEDURE.length());
        String nombreMetodoSet = "set" + String.valueOf(nombreColumna.charAt(0)).toUpperCase() + nombreColumna.substring(1);

        Class cls = e.getClass();
        Class partypes[] = new Class[1];
        partypes[0] = SqlServer2008TypesJava.getValue(c.getTipoSQL());
        Method method = cls.getMethod(nombreMetodoSet, partypes);
        Object arglist[] = new Object[1];
        switch (type) {
            case BOOLEAN:
                arglist[0] = cl.getBoolean(i);
                break;
            case CHAR:
                arglist[0] = cl.getString(i);
                break;
            case DATE:
                arglist[0] = new java.util.Date(cl.getDate(i).getTime());
                break;
            case DOUBLE:
                arglist[0] = cl.getDouble(i);
                break;
            case FLOAT:
                arglist[0] = cl.getFloat(i);
                break;
            case INT:
                arglist[0] = cl.getInt(i);
                break;
            case LONG:
                arglist[0] = cl.getLong(i);
                break;
            case SHORT:
                arglist[0] = cl.getShort(i);
                break;
            case STRING:
                arglist[0] = cl.getString(i);
                break;
            case TIMESTAMP:
                arglist[0] = new Date(cl.getTimestamp(i).getTime());
                break;
            case OBJECT:
                arglist[0] = cl.getObject(i);
                break;
        }

        method.invoke(e, arglist);
    }
}
