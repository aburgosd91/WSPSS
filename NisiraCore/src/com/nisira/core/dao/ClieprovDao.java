package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entityservices.*;import java.sql.ResultSet;
public class ClieprovDao extends BaseDao<Clieprov> {
	public ClieprovDao() {
		super(Clieprov.class);
	}
	public ClieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Clieprov.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Clieprov> listarPorEmpresa(String idclieprov) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPEDIDO",idclieprov);
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS"));
                clieprov.setIdempresa(rs.getString("IDEMPRESA"));
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV"));
                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                clieprov.setEstado(rs.getDouble("ESTADO"));
                
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*-Fin-*/
        /*WEB SERVICE*/
        public ArrayList<Clieprov> listarPorEmpresaPersonalService(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"E");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaClieprovService(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa);
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*PAGINA WEB*/
        public ArrayList<Clieprov> listarPorEmpresaClienteWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"C");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaClienteProveedorWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"A");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaProveedorWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"P");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaEmpleadorWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"E");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa);
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Clieprov> listarPorEmpresaPersonalWeb(String idempresa) throws NisiraORMException {
            ArrayList<Clieprov> lista = new ArrayList<Clieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCLIEPROV_TMPSS",idempresa,"E");
            while (rs.next()) {
                Clieprov clieprov = new Clieprov();
                clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                clieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                clieprov.setTipo_clieprov(rs.getString("TIPO_CLIEPROV")!=null?rs.getString("TIPO_CLIEPROV").trim():"");
                clieprov.setTipopersona(rs.getString("TIPOPERSONA")!=null?rs.getString("TIPOPERSONA").trim():"");
                clieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                clieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                clieprov.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                clieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                clieprov.setRazonsocial(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                clieprov.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                clieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                clieprov.setEstado(rs.getDouble("ESTADO"));
                lista.add(clieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}