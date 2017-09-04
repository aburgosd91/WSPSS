/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ClienteNatural;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class ClienteNaturalDao extends EntityDao<ClienteNatural>{

    @Override
    public ClienteNatural find(ClienteNatural e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteNatural> findAll(Object e) throws Exception {
        ArrayList<ClienteNatural> l = new ArrayList<ClienteNatural>();
        try {
            String sql = "GETREGCLIENTE_NATURAL_TMPSS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                ClienteNatural di = new ClienteNatural();
                di.setIDDOCIDENTIDAD(rs.getString("IDDOCIDENTIDAD")!=null?rs.getString("IDDOCIDENTIDAD").trim():"");
                di.setAPELLIDOPATERNO(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                di.setAPELLIDOMATERNO(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                di.setNOMBRES(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                di.setDEPARTAMENTO(rs.getString("DEPARTAMENTO")!=null?rs.getString("DEPARTAMENTO").trim():"");
                di.setPROVINCIA(rs.getString("PROVINCIA")!=null?rs.getString("PROVINCIA").trim():"");
                di.setDISTRITO(rs.getString("DISTRITO")!=null?rs.getString("DISTRITO").trim():"");
                di.setDIRECCION(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                di.setCODIGOPOSTAL(rs.getString("CODIGOPOSTAL")!=null?rs.getString("CODIGOPOSTAL").trim():"");
                di.setTELFFIJO(rs.getString("TELFFIJO")!=null?rs.getString("TELFFIJO").trim():"");
                di.setTELFCEL(rs.getString("TELFCEL")!=null?rs.getString("TELFCEL").trim():"");
                di.setEMAIL(rs.getString("EMAIL")!=null?rs.getString("EMAIL").trim():"");
                di.setIDTIPOSERVICIO(rs.getInt("IDTIPOSERVICIO"));
                di.setTIPDOCSERVICIO(rs.getString("TIPDOCSERVICIO")!=null?rs.getString("TIPDOCSERVICIO").trim():"");
                di.setPUBLICDAT(rs.getInt("PUBLICDATA"));
                l.add(di);
            }
        } finally {
            cerrar(cn, cl, rs);
        }

        return l;
    }

    @Override
    public List<ClienteNatural> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void grabar(ClienteNatural p) throws Exception {
        List<ClienteNatural> ln = new ArrayList<ClienteNatural>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(ClienteNatural.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "REGCLIE_NATURALGRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setObject(1, xmlNot);
            cl.setObject(2, p.getIDDOCIDENTIDAD());
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
