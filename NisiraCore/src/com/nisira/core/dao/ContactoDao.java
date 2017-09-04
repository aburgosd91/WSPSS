/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Contacto;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class ContactoDao extends EntityDao<Contacto>{

    @Override
    public Contacto find(Contacto e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contacto> findAll(Object e) throws Exception {
        ArrayList<Contacto> l = new ArrayList<Contacto>();
        try {
            String sql = "GETREGCLIENTE_CONTACTO_TMPSS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Contacto di = new Contacto();
                di.setIDREGISTRO(rs.getString("IDREGISTRO")!=null?rs.getString("IDREGISTRO").trim():"");
                di.setAPELLIDOMATERNO(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                di.setAPELLIDOPATERNO(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                di.setNOMBRES(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                di.setCORREO(rs.getString("CORREO")!=null?rs.getString("CORREO").trim():"");
                di.setTELFCEL(rs.getString("TELFCEL")!=null?rs.getString("TELFCEL").trim():"");
                di.setDEPARTAMENTO(rs.getString("DEPARTAMENTO")!=null?rs.getString("DEPARTAMENTO").trim():"");
                di.setPROVINCIA(rs.getString("PROVINCIA")!=null?rs.getString("PROVINCIA").trim():"");
                di.setDISTRITO(rs.getString("DISTRITO")!=null?rs.getString("DISTRITO").trim():"");
                di.setDIRECCION(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                di.setDIRTELFFIJO(rs.getString("DIRTELFFIJO")!=null?rs.getString("DIRTELFFIJO").trim():"");
                di.setDIRTELFCEL(rs.getString("DIRTELFCEL")!=null?rs.getString("DIRTELFCEL").trim():"");
                di.setIDCONT(rs.getInt("IDCONT"));
                di.setIDTIPO(rs.getInt("IDTIPO"));
                di.setDCODIGOPOSTAL(rs.getString("DCODIGOPOSTAL")!=null?rs.getString("DCODIGOPOSTAL").trim():"");
                di.setDepartamento_descripcion(rs.getString("DEPARTAMENTO_DESCRIPCION")!=null?rs.getString("DEPARTAMENTO_DESCRIPCION").trim():"");
                di.setProvincia_descripcion(rs.getString("PROVINCIA_DESCRIPCION")!=null?rs.getString("PROVINCIA_DESCRIPCION").trim():"");
                di.setDistrito_descripcio(rs.getString("DISTRITO_DESCRIPCION")!=null?rs.getString("DISTRITO_DESCRIPCION").trim():"");
                l.add(di);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Contacto> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void grabar( List<Contacto>  p) throws Exception {
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(Contacto.class);
        xmlNot = xml + xStream.toXML(p);
        try {
            Integer id = null;
            String sql = "REGCLIE_CONTACTOGRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
