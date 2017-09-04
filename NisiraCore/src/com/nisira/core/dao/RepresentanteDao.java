/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Representante;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class RepresentanteDao extends EntityDao<Representante>{

    @Override
    public Representante find(Representante e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Representante> findAll(Object e) throws Exception {
        ArrayList<Representante> l = new ArrayList<Representante>();
        try {
            String sql = "GETREGCLIENTE_REPRESENTANTES_TMPSS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Representante di = new Representante();
                di.setIDREGISTRO(rs.getString("IDREGISTRO")!=null?rs.getString("IDREGISTRO").trim():"");
                di.setNRODOCUMENTO(rs.getString("NRODOCUMENTO")!=null?rs.getString("NRODOCUMENTO").trim():"");
                di.setAPELLIDOPATERNO(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                di.setAPELLIDOMATERNO(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                di.setNOMBRES(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                di.setCARGO(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                di.setCORREO(rs.getString("CORREO")!=null?rs.getString("CORREO").trim():"");
                di.setIDREP(rs.getInt("IDREP"));
                di.setItem(rs.getInt("ITEM"));
                l.add(di);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Representante> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void grabar(List<Representante> p) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Representante.class);
        xmlNot = xml + xStream.toXML(p);
        try {
            Integer id = null;
            String sql = "REGCLIE_REPRESENTANTEGRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
