/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.util.CoreUtil;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class MultitablaDao extends EntityDao<Multitabla>{
    /*TIPOS DE CONSULTA A PROCEDURE SP_MUTITABLA
        - SELECT TABLA(1)
        - SELECT DETALLE TABLA(2)
        - INSERT(3)
        - UPDATE(4)
        - DELETE(5)->inactivo
    */
    @Override
    public Multitabla find(Multitabla e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Multitabla> findTabla(Object e1) throws Exception {
        Multitabla oMultitabla = null;
        List<Multitabla> listaMultitabla=new ArrayList<Multitabla>();
        try {
            String sql = "SP_MULTITABLA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?)}");
            cl.setInt(1,1);/*GETRECORD DETALLE MUTITABLA(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
//            cl.setString(4,e2.toString());/*++NUMERO DE TABLA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oMultitabla = new Multitabla();
                oMultitabla.setTABLA_ID(rs.getString("TABLA_ID"));
                oMultitabla.setVALOR(rs.getString("VALOR"));
                oMultitabla.setDEP_ID(rs.getString("DEP_ID"));
                oMultitabla.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oMultitabla.setABREV(rs.getString("ABREV"));
                oMultitabla.setESTADO(rs.getBoolean("ESTADO"));
                oMultitabla.setEMPRESA(rs.getInt("IDEMPRESA"));
                listaMultitabla.add(oMultitabla);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMultitabla;
    }
    public List<Multitabla> findDetalleTabla(Object e1,Object e2) throws Exception {
        Multitabla oMultitabla = null;
        List<Multitabla> listaMultitabla=new ArrayList<Multitabla>();
        try {
            String sql = "SP_MULTITABLA";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?)}");
            cl.setInt(1,2);/*GETRECORD DETALLE MUTITABLA(5)*/
            cl.setString(2,"");
            cl.setString(3,e1.toString());/*++IDEMRPESA++*/
            cl.setString(4,e2.toString());/*++NUMERO DE TABLA++*/
            rs = cl.executeQuery();
            while (rs.next()) {
                oMultitabla = new Multitabla();
                oMultitabla.setTABLA_ID(rs.getString("TABLA_ID"));
                oMultitabla.setVALOR(rs.getString("VALOR"));
                oMultitabla.setDEP_ID(rs.getString("DEP_ID"));
                oMultitabla.setDESCRIPCION(rs.getString("DESCRIPCION"));
                oMultitabla.setABREV(rs.getString("ABREV"));
                oMultitabla.setESTADO(rs.getBoolean("ESTADO"));
                oMultitabla.setEMPRESA(rs.getInt("IDEMPRESA"));
                listaMultitabla.add(oMultitabla);
            }
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return listaMultitabla;
    }
    
    public String addMultitabla(Multitabla multitabla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(multitabla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_MULTITABLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,3);
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getTABLA_ID(),"0")));
                cl.setInt(i++,multitabla.getEMPRESA());
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getVALOR(),"0")));
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getDEP_ID(),"0")));
                cl.setString(i++,multitabla.getDESCRIPCION());
                cl.setString(i++,multitabla.getABREV());
                cl.setBoolean(i++,multitabla.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("VALOR"));                
                }
            }
        return resultado;
    }
    public String addXmlMultitabla(String idempresa,int dep_id,String xml) 
            throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
        try {
            if(xml!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_MULTITABLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,6);
                cl.setInt(i++,0);//TablaID
                cl.setString(i++,idempresa);//idempresa
                cl.setInt(i++,0);//valor
                cl.setInt(i++,dep_id);//dep_id
                cl.setString(i++,"");//descripcion
                cl.setString(i++,"");//abrev
                cl.setBoolean(i++,true);//estado
                cl.setString(i++,xml);/*XML*/
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        }
        catch (Exception e)
        {
            resultado = e.toString();
        }
        finally {
            cerrar(cn, cl, rs);
        }
        return resultado;
    }
    public String editMultitabla(Multitabla multitabla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(multitabla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_MULTITABLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,4);
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getTABLA_ID(),"0")));
                cl.setInt(i++,multitabla.getEMPRESA());
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getVALOR(),"0")));
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getDEP_ID(),"0")));
                cl.setString(i++,multitabla.getDESCRIPCION());
                cl.setString(i++,multitabla.getABREV());
                cl.setBoolean(i++,multitabla.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    public String deleteMultitabla(Multitabla multitabla) throws Exception{
        String resultado = "";
        int i=1;
        //DataBaseConeccion db= new DataBaseConeccion(context);
            if(multitabla!=null){
                //String sql = "GRABAR_MOVUBICACION_BYPALETA_WEBMOVIL";
                String sql = "SP_MULTITABLA";
                cn = obtenerConexionJTDS();
                cl = cn.prepareCall("{CALL " + sql + "(?,?,?,?,?,?,?,?)}");
                cl.setInt(i++,5);
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getTABLA_ID(),"0")));
                cl.setInt(i++,multitabla.getEMPRESA());
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getVALOR(),"0")));
                cl.setInt(i++,Integer.parseInt(CoreUtil.isNull(multitabla.getDEP_ID(),"0")));
                cl.setString(i++,multitabla.getDESCRIPCION());
                cl.setString(i++,multitabla.getABREV());
                cl.setBoolean(i++,multitabla.getESTADO());
                rs = cl.executeQuery();
                while (rs.next()) {
                    resultado = (rs.getString("mensaje"));                
                }
            }
        return resultado;
    }
    
    /********************************OPERACIONES DE CONSULTA*****************************/
    public List<Multitabla> findTipoAlmacen(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"1");
    }
    public List<Multitabla> findParametroGeneracionCodigo(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"3");
    }
    public List<Multitabla> findParametroRegla(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"3");
    }
    public List<Multitabla> findDistribucionNivel(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"5");
    }
    public List<Multitabla> findTipoEtiqueta(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"6");
    }
    public List<Multitabla> findTiporRacks(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"7");
    }
    public List<Multitabla> findTiporAccesorio(Object empresa) throws Exception {
        return this.findDetalleTabla(empresa,"14");
    }
    @Override
    public List<Multitabla> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Multitabla> findAll(Object e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
