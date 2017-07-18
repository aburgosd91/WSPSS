package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_tareo_clieprov;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Destructura_tareo_clieprov;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_tareo_clieprovDao extends BaseDao<Estructura_tareo_clieprov> {

    public Estructura_tareo_clieprovDao() {
        super(Estructura_tareo_clieprov.class);
    }

    public Estructura_tareo_clieprovDao(boolean usaCnBase) throws NisiraORMException {
        super(Estructura_tareo_clieprov.class, usaCnBase);
    }

    public Estructura_tareo_clieprov getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV) throws NisiraORMException {
        List<Estructura_tareo_clieprov> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? ", IDEMPRESA, IDCLIEPROV);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public List<Estructura_tareo_clieprov> listEstructuraTare(String idempresa) throws NisiraORMException {
        List<Estructura_tareo_clieprov> list = new ArrayList<Estructura_tareo_clieprov>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETESTRUCTURA_TAREO_CLIEPROV", idempresa);
            while (rs.next()) {
                Estructura_tareo_clieprov ob = new Estructura_tareo_clieprov();
                ob.setIdempresa(rs.getString("IDEMPRESA"));
                ob.setIdclieprov(rs.getString("IDCLIEPROV"));
                ob.setDescripcion(rs.getString("DESCRIPCION"));
                ob.setActivo(rs.getFloat("ACTIVO"));
                ob.setRazon_social(rs.getString("RAZON_SOCIAL"));
                list.add(ob);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Destructura_tareo_clieprov> listDEstructuraTare(String idempres, String idclieprov) throws NisiraORMException {
        List<Destructura_tareo_clieprov> list = new ArrayList<Destructura_tareo_clieprov>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETDESTRUCTURA_TAREO_CLIEPROV", idempres, idclieprov);
            while (rs.next()) {
                Destructura_tareo_clieprov ob = new Destructura_tareo_clieprov();
                ob.setIdempresa(rs.getString("IDEMPRESA"));
                ob.setItem(rs.getString("ITEM"));
                ob.setIdclieprov(rs.getString("IDCLIEPROV"));
                ob.setDescripcion(rs.getString("DESCRIPCION"));
                ob.setHora(rs.getFloat("HORA"));
                ob.setIdruta(rs.getString("IDRUTA"));
                ob.setEsfecha(rs.getFloat("ESFECHA"));
                ob.setRuta(rs.getString("RUTA"));
                ob.setHoraH(CoreUtil.convertDecimalTime(ob.getHora()));
                list.add(ob);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void delEstruc(String idempres, String idclieprov,int tipo) throws NisiraORMException {
        try {
            ResultSet rs = null;
            rs = execProcedure("DELESTRUCTURA_TAREO_CLIEPROV", idempres, idclieprov, tipo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String grabar(Estructura_tareo_clieprov obj, List<Destructura_tareo_clieprov> dobj) throws Exception {
        String mensaje = "";
        String xmlNot = "";
        String xmlDet = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Estructura_tareo_clieprov.class);
        xmlNot = xml + xStream.toXML(obj);
        xStream = new XStream();
        xStream.processAnnotations(Destructura_tareo_clieprov.class);
        xmlDet = xml + xStream.toXML(dobj);
        try {
            ResultSet rs = null;
            rs = execProcedure("ESTRUCTURA_TAREO_CLIENTEGRABAR", obj.getIdempresa(), obj.getIdclieprov(), xmlNot, xmlDet);
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
