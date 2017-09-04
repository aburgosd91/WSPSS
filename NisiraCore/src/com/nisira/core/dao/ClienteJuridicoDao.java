/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.ClienteJuridico;
import com.nisira.core.entity.ClienteNatural;
import com.nisira.core.entity.Contacto;
import com.nisira.core.entity.Contactosclieprov;
import com.nisira.core.entity.Regcliente_cuenta_deposito;
import com.nisira.core.entity.Representante;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class ClienteJuridicoDao extends EntityDao<ClienteJuridico>{

    @Override
    public ClienteJuridico find(ClienteJuridico e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteJuridico> findAll(Object e) throws Exception {
        ArrayList<ClienteJuridico> l = new ArrayList<ClienteJuridico>();
        try {
            String sql = "GETREGCLIENTE_JURIDICO_TMPSS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                ClienteJuridico di = new ClienteJuridico();
                di.setIDDOCIDENTIDAD(rs.getString("IDDOCIDENTIDAD")!=null?rs.getString("IDDOCIDENTIDAD").trim():"");
                di.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                di.setDEPARTAMENTO(rs.getString("DEPARTAMENTO")!=null?rs.getString("DEPARTAMENTO").trim():"");
                di.setPROVINCIA(rs.getString("PROVINCIA")!=null?rs.getString("PROVINCIA").trim():"");
                di.setDISTRITO(rs.getString("DISTRITO")!=null?rs.getString("DISTRITO").trim():"");
                di.setDIRECCION(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                di.setCODIGOPOSTAL(rs.getString("CODIGOPOSTAL")!=null?rs.getString("CODIGOPOSTAL").trim():"");
                di.setOBJETOSOCIAL(rs.getString("OBJETOSOCIAL")!=null?rs.getString("OBJETOSOCIAL").trim():"");
                di.setREGPODERES(rs.getString("REGPODERES")!=null?rs.getString("REGPODERES").trim():"");
                di.setPUBLICDATA(rs.getInt("PUBLICDATA"));
                di.setTIPOPERSONA(rs.getInt("TIPOPERSONA"));
                di.setDDEPARTAMENTO(rs.getString("DDEPARTAMENTO")!=null?rs.getString("DDEPARTAMENTO").trim():"");
                di.setDPROVINCIA(rs.getString("DPROVINCIA")!=null?rs.getString("DPROVINCIA").trim():"");
                di.setDDISTRITO(rs.getString("DDISTRITO")!=null?rs.getString("DDISTRITO").trim():"");
                
                di.setIDDOCIDENTIDAD_SUNAT(rs.getString("IDDOCIDENTIDAD_SUNAT")!=null?rs.getString("IDDOCIDENTIDAD_SUNAT").trim():"");
                di.setDNI(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                di.setNOMBRE_COMERCIAL(rs.getString("NOMBRE_COMERCIAL")!=null?rs.getString("NOMBRE_COMERCIAL").trim():"");
                di.setCIIU(rs.getString("CIIU")!=null?rs.getString("CIIU").trim():"");
                di.setESTADO_SUNAT(rs.getString("ESTADO_SUNAT")!=null?rs.getString("ESTADO_SUNAT").trim():"");
                di.setCONDICION_SUNAT(rs.getString("CONDICION_SUNAT")!=null?rs.getString("CONDICION_SUNAT").trim():"");
                
                di.setAPELLIDOPATERNO(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                di.setAPELLIDOMATERNO(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                di.setNOMBRES(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                l.add(di);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<ClienteJuridico> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void grabar(ClienteJuridico p,List<Representante> lstRepLegales,List<Contacto> conRecojo,
            List<Contacto> conEntrega,List<Regcliente_cuenta_deposito> lstRegcliente_cuenta_deposito,
            int aprobado,String idempresa,List<Contactosclieprov> lstContactosclieprov) throws Exception {
        List<ClienteJuridico> ln = new ArrayList<ClienteJuridico>();
        ln.add(p);
        String xmlNot = "";
        String xmlRepLegales= "";
        String xmlconRecojo = "";
        String xmlconconEntrega = "";
        String xmlRegcliente_cuenta_deposito = "";
        String xmlContactosclieprov = "";
        
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(ClienteJuridico.class);
        xmlNot = xml + xStream.toXML(ln);
        
        
        xStream = new XStream();
        xStream.processAnnotations(Representante.class);
        xmlRepLegales= xml + xStream.toXML(lstRepLegales);
        
        xStream = new XStream();
        xStream.processAnnotations(Contacto.class);
        xmlconRecojo= xml + xStream.toXML(conRecojo);
        
        xStream = new XStream();
        xStream.processAnnotations(Contacto.class);
        xmlconconEntrega= xml + xStream.toXML(conEntrega);
        
        xStream = new XStream();
        xStream.processAnnotations(Regcliente_cuenta_deposito.class);
        xmlRegcliente_cuenta_deposito= xml + xStream.toXML(lstRegcliente_cuenta_deposito);
        
        xStream = new XStream();
        xStream.processAnnotations(Contactosclieprov.class);
        xmlContactosclieprov= xml + xStream.toXML(lstContactosclieprov);
        
        try {
            Integer id = null;
            String sql = "REGCLIE_JURIDCOGRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
            cl.setObject(1, xmlNot);
            cl.setObject(2, xmlRepLegales);
            cl.setObject(3, xmlconRecojo);
            cl.setObject(4, xmlconconEntrega);
            cl.setObject(5, xmlRegcliente_cuenta_deposito);
            cl.setObject(6, p.getIDDOCIDENTIDAD());
            cl.setObject(7, aprobado);
            cl.setObject(8, idempresa);
            cl.setObject(9, xmlContactosclieprov);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }
}
