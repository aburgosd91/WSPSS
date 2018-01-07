package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Areas;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Area_concepto_cuenta;
import com.nisira.core.entity.Areas;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreasDao extends BaseDao<Areas> {
    public AreasDao() {
            super(Areas.class);
    }
    public AreasDao(boolean usaCnBase) throws NisiraORMException {
            super(Areas.class, usaCnBase);
    }

    public Areas getPorClavePrimaria(String IDEMPRESA, String IDAREA) throws NisiraORMException {
            List<Areas> l = listar("t0.IDEMPRESA = ? and t0.IDAREA = ? ", IDEMPRESA, IDAREA);
            if (l.isEmpty()) {
                    return null;
            } else {
                    return l.get(0);
            }
    }
    public List<Areas> lstAreasEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Areas> lista = new ArrayList<Areas>();
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_GETAREAS", idempresa);
            while (rs.next()) {
                Areas am = new Areas();
                am.setIdempresa(rs.getString("idempresa").trim());
                am.setIdarea(rs.getString("idarea").trim());
                am.setDescripcion(rs.getString("descripcion").trim());
                am.setEstado(rs.getFloat("estado"));
                lista.add(am);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    public List<Areas> listAreas(String idempresa) throws NisiraORMException {
        List<Areas> list = new ArrayList<Areas>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAREAS_TMPSS", idempresa);
            while (rs.next()) {
                Areas ob = new Areas();
                ob.setIdempresa(rs.getString("IDEMPRESA"));
                ob.setIdarea(rs.getString("IDAREA"));
                ob.setDescripcion(rs.getString("DESCRIPCION"));
                ob.setEstado(rs.getFloat("ESTADO"));
                list.add(ob);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Area_concepto_cuenta> listArea_concepto_cuenta(String idempres, String idarea) throws NisiraORMException {
        List<Area_concepto_cuenta> list = new ArrayList<Area_concepto_cuenta>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAREA_CONCEPTO_CUENTA_TMPSS", idempres, idarea);
            while (rs.next()) {
                Area_concepto_cuenta ob = new Area_concepto_cuenta();
                ob.setIdempresa(rs.getString("IDEMPRESA"));
                ob.setIdarea(rs.getString("IDAREA"));
                ob.setIdconcepto(rs.getString("IDCONCEPTO"));
                ob.setDescripcion(rs.getString("DESCRIPCION"));
                ob.setArea(rs.getString("AREA"));
                ob.setConcepto(rs.getString("CONCEPTO"));
                ob.setIdcuenta(rs.getString("IDCUENTA"));
                list.add(ob);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public void delAreas(String idempres, String idareas,int tipo) throws NisiraORMException {
        try {
            ResultSet rs = null;
            rs = execProcedure("DELAREAS", idempres, idareas, tipo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String grabar(Areas obj, List<Area_concepto_cuenta> dobj) throws Exception {
        String mensaje = "";
        String xmlNot = "";
        String xmlDet = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Areas.class);
        xmlNot = xml + xStream.toXML(obj);
        xStream = new XStream();
        xStream.processAnnotations(Area_concepto_cuenta.class);
        xmlDet = xml + xStream.toXML(dobj);
        try {
            ResultSet rs = null;
            rs = execProcedure("AREA_GRABAR_TMPSS", obj.getIdempresa(), 
                    obj.getIdarea(), xmlNot, xmlDet);
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }    
}