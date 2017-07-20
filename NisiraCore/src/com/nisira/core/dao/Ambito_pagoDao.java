package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ambito_pago;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Ambito_pago_costomo;
import com.nisira.core.entity.Ambito_pago_rutas;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ambito_pagoDao extends BaseDao<Ambito_pago> {

    public Ambito_pagoDao() {
        super(Ambito_pago.class);
    }

    public Ambito_pagoDao(boolean usaCnBase) throws NisiraORMException {
        super(Ambito_pago.class, usaCnBase);
    }

    public Ambito_pago getPorClavePrimaria(String idempresa, String codigo) throws NisiraORMException {
        List<Ambito_pago> l = listar("t0.idempresa = ? and t0.codigo = ? ", idempresa, codigo);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public List<Ambito_pago> lstAmbitoEmpresa(String idempresa) throws NisiraORMException {
        ArrayList<Ambito_pago> lista = new ArrayList<Ambito_pago>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAMBITO_PAGO", idempresa);
            while (rs.next()) {
                Ambito_pago am = new Ambito_pago();
                am.setIdempresa(rs.getString("idempresa").trim());
                am.setCodigo(rs.getString("codigo").trim());
                am.setDescripcion(rs.getString("descripcion").trim());
                am.setNombre_corto(rs.getString("nombre_corto"));
                am.setCosto_por_hora(rs.getFloat("costo_por_hora"));
                am.setCosto_adicional(rs.getFloat("costo_adicional"));
                am.setVisible(rs.getFloat("visible"));
                lista.add(am);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Ambito_pago> lstAmbitoEmpresa_visibles(String idempresa) throws NisiraORMException {
        ArrayList<Ambito_pago> lista = new ArrayList<Ambito_pago>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAMBITO_PAGO_VISIBLE", idempresa);
            while (rs.next()) {
                Ambito_pago am = new Ambito_pago();
                am.setIdempresa(rs.getString("idempresa").trim());
                am.setCodigo(rs.getString("codigo").trim());
                am.setDescripcion(rs.getString("descripcion").trim());
                am.setNombre_corto(rs.getString("nombre_corto"));
                am.setCosto_por_hora(rs.getFloat("costo_por_hora"));
                am.setCosto_adicional(rs.getFloat("costo_adicional"));
                am.setVisible(rs.getFloat("visible"));
                lista.add(am);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Ambito_pago_rutas> detAmbitoPagos(String idempresa, String codigo) throws NisiraORMException {
        ArrayList<Ambito_pago_rutas> lista = new ArrayList<Ambito_pago_rutas>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAMBITO_PAGO_RUTAS", idempresa, codigo);
            while (rs.next()) {
                Ambito_pago_rutas apr = new Ambito_pago_rutas();
                apr.setIdempresa(rs.getString("idempresa").trim());
                apr.setCodigo(rs.getString("codigo").trim());
                apr.setItem(rs.getString("ITEM").trim());
                apr.setIdruta(rs.getString("IDRUTA").trim());
                apr.setDescripcion(rs.getString("descripcion").trim());
                apr.setOrigen(rs.getString("ORIGEND").trim());
                apr.setDestino(rs.getString("DESTINOD").trim());
                lista.add(apr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Ambito_pago_costomo> detAmbitoPagosCosto(String idempresa, String codigo) {
        ArrayList<Ambito_pago_costomo> lista = new ArrayList<Ambito_pago_costomo>();
        try {
            ResultSet rs = null;
            rs = execProcedure("GETAMBITO_PAGO_COSTOMO", idempresa, codigo);
            while (rs.next()) {
                Ambito_pago_costomo apc = new Ambito_pago_costomo();
                apc.setIdempresa(rs.getString("idempresa"));
                apc.setCodigo(rs.getString("codigo"));
                apc.setIdcargo(rs.getString("idcargo"));
                apc.setCosto_bono(rs.getFloat("costo_bono"));
                apc.setIdruta(rs.getString("idruta"));
                apc.setCargo(rs.getString("cargo"));
                apc.setRuta(rs.getString("ruta"));
                apc.setOrigen(rs.getString("origen"));
                apc.setDestino(rs.getString("destino"));
                lista.add(apc);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public String grabar(Ambito_pago obj, List<Ambito_pago_rutas> dobj, List<Ambito_pago_costomo> dobj2) throws Exception {
        String mensaje = "";
        String xmlNot = "";
        String xmlDet = "";
        String xmlDet2 = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Ambito_pago.class);
        xmlNot = xml + xStream.toXML(obj);
        xStream = new XStream();
        xStream.processAnnotations(Ambito_pago_rutas.class);
        xmlDet = xml + xStream.toXML(dobj);
        xStream = new XStream();
        xStream.processAnnotations(Ambito_pago_costomo.class);
        xmlDet2 = xml + xStream.toXML(dobj2);
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_AMBITO_PAGO_GRABAR", obj.getIdempresa(), obj.getCodigo(), xmlNot, xmlDet, xmlDet2);
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }

    public void delAmbitopago(String idempresa, String codigo) throws NisiraORMException {
        ArrayList<Ambito_pago_rutas> lista = new ArrayList<Ambito_pago_rutas>();
        try {
            ResultSet rs = null;
            rs = execProcedure("DELAMBITO_PAGO", idempresa, codigo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
