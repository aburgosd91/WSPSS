package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Formatoreporteweb;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dformatoreporteweb;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FormatoreportewebDao extends BaseDao<Formatoreporteweb> {

    public FormatoreportewebDao() {
        super(Formatoreporteweb.class);
    }

    public FormatoreportewebDao(boolean usaCnBase) throws NisiraORMException {
        super(Formatoreporteweb.class, usaCnBase);
    }

    public Formatoreporteweb getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV, String ITEM) throws NisiraORMException {
        List<Formatoreporteweb> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? and t0.ITEM = ? ", IDEMPRESA, IDCLIEPROV, ITEM);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public List<Formatoreporteweb> findAll(String idempresa) {
        List<Formatoreporteweb> l = new ArrayList<Formatoreporteweb>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETFORMATOWEB", idempresa);
            while (rs.next()) {
                Formatoreporteweb f = new Formatoreporteweb();
                f.setIdempresa(rs.getString("IDEMPRESA"));
                f.setIdclieprov(rs.getString("IDCLIEPROV"));
                f.setItem(rs.getString("ITEM"));
                f.setDescripcion(rs.getString("DESCRIPCION"));
                f.setEstado(rs.getFloat("ESTADO"));
                f.setRazon_social(rs.getString("RAZON_SOCIAL"));
                l.add(f);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public List<Dformatoreporteweb> findDet(String idempresa, String idclieprov, String item) {
        List<Dformatoreporteweb> l = new ArrayList<Dformatoreporteweb>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETDFORMATOREPORTEWEB", idempresa, idclieprov, item);
            while (rs.next()) {
                Dformatoreporteweb df = new Dformatoreporteweb();
                df.setIdempresa(rs.getString("IDEMPRESA"));
                df.setIdclieprov(rs.getString("IDCLIEPROV"));
                df.setItem(rs.getString("ITEM"));
                df.setItem2(rs.getString("ITEM2"));
                df.setParametro(rs.getString("PARAMETRO"));
                df.setOrden(rs.getInt("ORDEN"));
                df.setNivel(rs.getInt("NIVEL"));
                df.setAlias(rs.getString("ALIAS"));
                df.setEtiqueta(rs.getString("ETIQUETA"));
                l.add(df);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public String grabar(Formatoreporteweb obj, List<Dformatoreporteweb> dobj) {
        String mensaje = "";
        String xmlNot = "";
        String xmlDet = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Formatoreporteweb.class);
        xmlNot = xml + xStream.toXML(obj);
        xStream = new XStream();
        xStream.processAnnotations(Dformatoreporteweb.class);
        xmlDet = xml + xStream.toXML(dobj);
        try {
            ResultSet rs = null;
            rs = execProcedure("FORMATORPTWEB_GRABAR", obj.getIdempresa(), obj.getIdclieprov(), obj.getItem(), xmlNot, xmlDet);
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }

    public List<String> tableColumsList(String Tname) throws Exception {
        List<String> col = new ArrayList<String>();
        try {
            ResultSet rs = null;
            rs = execProcedure("nspColumsTable_S", Tname);
            while (rs.next()) {
                String n;
                n = rs.getString("name");
                col.add(n);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return col;
    }
    public void delFormatoWeb(String idempresa, String item,float estado) throws NisiraORMException {
        try {
            ResultSet rs = null;
            rs = execProcedure("FORMATOWEB_ESTADOS", idempresa,item,estado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
