package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Memorandum_instalacion_pss;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Ambito_pago;
import com.nisira.core.entity.Numemisor;
import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Memorandum_instalacion_pssDao extends BaseDao<Memorandum_instalacion_pss>{

    public Memorandum_instalacion_pssDao() {
        super(Memorandum_instalacion_pss.class);
    }

    public Memorandum_instalacion_pssDao(boolean usaCnBase) throws NisiraORMException {
        super(Memorandum_instalacion_pss.class, usaCnBase);
    }
    //[MEMORANDUN_INSTAL_PSSGRABAR]

    public Memorandum_instalacion_pss getPorClavePrimaria(String IDEMRPESA, String IDCOTIZACIONV) throws NisiraORMException {
        List<Memorandum_instalacion_pss> l = listar("t0.IDEMRPESA = ? and t0.IDCOTIZACIONV = ? ", IDEMRPESA, IDCOTIZACIONV);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public List<Memorandum_instalacion_pss> lstMemorandum(String idempresa,String idtipo)  throws NisiraORMException{
        List<Memorandum_instalacion_pss> memo = new ArrayList<Memorandum_instalacion_pss>();
        try {
            ResultSet rs = null;
            rs = execProcedure("MEMORANDUM_INSTALACION_PSS", idempresa,idtipo);
            while (rs.next()) {
                Memorandum_instalacion_pss me = new Memorandum_instalacion_pss();
                me.setIdemrpesa(rs.getString("IDEMRPESA"));
                me.setIdcotizacionv(rs.getString("IDCOTIZACIONV"));
                me.setIdordenservicio(rs.getString("IDORDENSERVICIO"));
                me.setFecha_inst(rs.getDate("FECHA_INST"));
                me.setHora_inst(rs.getFloat("HORA_INST"));
                me.setDuracion_contrato(rs.getString("DURACION_CONTRATO"));
                me.setTabla_atendido(rs.getString("TABLA_ATENDIDO"));
                me.setTabla_requerimiento(rs.getString("TABLA_REQUERIMIENTO"));
                me.setSalario(rs.getString("SALARIO"));
                me.setCondiciones_comerciales(rs.getString("CONDICIONES_COMERCIALES"));
                me.setObservaciones(rs.getString("OBSERVACIONES"));
                me.setIdusuario(rs.getString("IDUSUARIO"));
                me.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                memo.add(me);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return memo;
    }

    public String grabarMemo(String idempresa, String idords, Memorandum_instalacion_pss memo) throws NisiraORMException {
        String mensaje = "";
        try {

            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Memorandum_instalacion_pss.class);
            xmlNot = xml + xStream.toXML(memo);
            ResultSet rs = null;
            rs = execProcedure("MEMORANDUN_INSTAL_PSSGRABAR", idempresa, idords, xmlNot);
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
