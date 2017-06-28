/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.LibroQuejas;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class LibroQuejasDao extends EntityDao<LibroQuejas> {

    @Override
    public LibroQuejas find(LibroQuejas e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LibroQuejas> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LibroQuejas> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void grabar(LibroQuejas p) throws Exception {
        List<LibroQuejas> ln = new ArrayList<LibroQuejas>();
        ln.add(p);
        String xmlNot = "";
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream = new XStream();
        xStream.processAnnotations(LibroQuejas.class);
        xmlNot = xml + xStream.toXML(ln);
        try {
            Integer id = null;
            String sql = "LIBROQUEJAS_GRABAR";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,)}");
            cl.setObject(1, xmlNot);
            cl.executeUpdate();
        } finally {
            cerrar(cn, cl, rs);
        }
    }

    public String NumDoc(LibroQuejas c) throws Exception {
        String num = "0000001";
        String sql = "SELECT NUMERO FROM NUMEMISOR WHERE IDEMISOR = ? AND IDDOCUMENTO = ? AND SERIE = ? AND IDEMPRESA=?";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        pr.setString(1, "001");
        pr.setString(2, c.getIddocumento());
        pr.setString(3, c.getSerie());
        pr.setString(4, c.getIdempresa());
        rs = pr.executeQuery();
        if (rs.next()) {
            num = rs.getString("NUMERO");
        }
        return num;
    }
    public void anular(Object id) throws Exception{
         String sql= "update LIBROQUEJAS set idestado='AN' where idlibqueja = ?"; 
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        pr.setString(1,id.toString());
        rs = pr.executeQuery();
    }
    public LibroQuejas BuscaIdDoc(String id, String Serie, String Numero) throws Exception {
        LibroQuejas di = new LibroQuejas();
        try {
            String sql = "BUSCALIBROAUEJA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setString(1, id);
            cl.setString(2, Serie);
            cl.setString(3, Numero);
            rs = cl.executeQuery();
            while (rs.next()) {
                di.setIdlibqueja(rs.getString("idlibqueja"));
                di.setIdmotivoreclamo(rs.getString("idmotivoreclamo"));
                di.setIdtipopersona(rs.getString("idtipopersona"));
                di.setIddocidentidad(rs.getString("iddocidentidad"));
                di.setIdclieprov(rs.getString("idclieprov"));
                di.setIddocumentoRef(rs.getString("iddocumentoRef"));
                di.setSerie(rs.getString("serieRef"));
                di.setNumeroRef(rs.getString("numeroRef"));
                di.setGlosa(rs.getString("Glosa"));
                di.setIdestado(rs.getString("idestado"));
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(cn, cl, rs);
        }
        return di;
    }
    public List<LibroQuejas> BuscaIdEmp(String id) throws Exception {
        List<LibroQuejas> lb = new ArrayList<LibroQuejas>();
        try {
            String sql = "LISTAQUEJASEMPRESA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setString(1, id);
            rs = cl.executeQuery();
            while (rs.next()) {
                LibroQuejas di = new LibroQuejas();
                di.setIdlibqueja(rs.getString("idlibqueja"));
                di.setIdmotivoreclamo(rs.getString("idmotivoreclamo"));
                di.setIdtipopersona(rs.getString("idtipopersona"));
                di.setIddocidentidad(rs.getString("iddocidentidad"));
                di.setDocidentidad(rs.getString("docidentidad"));
                di.setNrodocidentidad(rs.getString("nrodocidentidad"));
                di.setIdclieprov(rs.getString("idclieprov"));
                di.setIdreclamo(rs.getString("idreclamo"));
                di.setReclamo(rs.getString("reclamo"));
                di.setIddocumentoRef(rs.getString("iddocumentoRef"));
                di.setSerie(rs.getString("serieRef"));
                di.setNumeroRef(rs.getString("numeroRef"));
                di.setGlosa(rs.getString("Glosa"));
                di.setIdestado(rs.getString("idestado"));
                lb.add(di);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(cn, cl, rs);
        }
        return lb;
    }
}
