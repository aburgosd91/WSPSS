/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nisira.core.CoreUtil;
import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.nisira.core.dao.*;
import com.nisira.core.entity.*;
import com.nisira.core.entity.Usuario;
import com.nisira.core.entityservices.ResponseWebService2;
import com.nisira.core.entityservices.ResponseWebService3;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.ClaveMovil;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
@WebService(serviceName = "WebServiceNisira")
public class WebServiceNisira{         
    public void setConexion(String db){
        ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
        EConexion e = new EConexion();
        e.BASEDATOS = lista_solution.get(4);/*BASE DATOS*/
        e.CLAVE = ClaveMovil.Desencriptar_ASCII(lista_solution.get(3));//"amadeus2010";
        e.INSTANCIA = lista_solution.get(1).isEmpty()?"":lista_solution.get(1).trim();
        e.USUARIO = lista_solution.get(2).trim();//"sa";
        //e.SERVIDOR = "localhost";
        e.SERVIDOR = lista_solution.get(0).trim();//"10.250.50.88";
        e.TIPO = "MSSQL";
        com.nisira.core.CoreUtil.conexiones.put("default", e);
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "METHOD_WEB_RETURNID")
    public String METHOD_WEB_RETURNID() {
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            OrdenliquidaciongastoDao ordenliquidaciongastodao =new OrdenliquidaciongastoDao();
            result= ordenliquidaciongastodao.method_web_returnid();
        } catch (NisiraORMException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_TEST_SERVER")
    public String METHOD_TEST_SERVER() {
        String result=null;
        result= "OK";
        return result;
    }
    @WebMethod(operationName = "METHOD_VERIFICATION_USER")
    public String METHOD_VERIFICATION_USER(
            @WebParam(name = "type") String type,
            @WebParam(name = "user") String user,
            @WebParam(name = "password") String password) {
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            UsuarioDao usuariodao =new UsuarioDao();
            Usuario usuario= usuariodao.getSesionUsuarioMovil(idempresa,user, Clave.Encriptar(password));
            if(usuario !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(1,usuario);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Usuario", usuario);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "USUARIO NO ASIGNADO";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "METHOD_LIST_CLIEPROV")
    public String METHOD_LIST_CLIEPROV(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            ClieprovDao clieprovdao =new ClieprovDao();
            List<Clieprov> list= clieprovdao.listarPorEmpresaClieprovService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Clieprov", list);
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_CONSUMIDOR")
    public String METHOD_LIST_CONSUMIDOR(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            ConsumidorDao consumidordao =new ConsumidorDao();
            List<Consumidor> list= consumidordao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Consumidor", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_CARGOS_PERSONAL")
    public String METHOD_LIST_CARGOS_PERSONAL(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            Cargos_personalDao cargos_personaldao =new Cargos_personalDao();
            List<Cargos_personal> list= cargos_personaldao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Cargos_personal", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_CONCEPTO_CUENTA")
    public String METHOD_LIST_CONCEPTO_CUENTA(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            Concepto_cuentaDao concepto_cuentadao =new Concepto_cuentaDao();
            List<Concepto_cuenta> list= concepto_cuentadao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Concepto_cuenta", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_DESTINOADQUISICION")
    public String METHOD_LIST_DESTINOADQUISICION(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            DestinoadquisicionDao destinoadquisicionDao =new DestinoadquisicionDao();
            List<Destinoadquisicion> list= destinoadquisicionDao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Destinoadquisicion", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_DOCUMENTOS")
    public String METHOD_LIST_DOCUMENTOS(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            DocumentosDao documentosdao =new DocumentosDao();
            List<Documentos> list= documentosdao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Documentos", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_NUMEMISOR")
    public String METHOD_LIST_NUMEMISOR(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            NumemisorDao numemisordao =new NumemisorDao();
            List<Numemisor> list= numemisordao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Numemisor", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_PERSONAL_SERVICIO")
    public String METHOD_LIST_PERSONAL_SERVICIO(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            Personal_servicioDao personal_serviciodao =new Personal_servicioDao();
            List<Personal_servicio> list= personal_serviciodao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Personal_servicio", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_DPERSONAL_SERVICIO")
    public String METHOD_LIST_DPERSONAL_SERVICIO(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            Dpersonal_servicioDao dpersonal_serviciodao =new Dpersonal_servicioDao();
            List<Dpersonal_servicio> list= dpersonal_serviciodao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Dpersonal_servicio", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_PRODUCTOS")
    public String METHOD_LIST_PRODUCTOS(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            ProductosDao productosdao =new ProductosDao();
            List<Productos> list= productosdao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Productos", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_RUTAS")
    public String METHOD_LIST_RUTAS(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            RutasDao rustasdao =new RutasDao();
            List<Rutas> list= rustasdao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Rutas", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_SUCURSALES")
    public String METHOD_LIST_SUCURSALES(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            SucursalesDao sucursalesdao =new SucursalesDao();
            List<Sucursales> list= sucursalesdao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Sucursales", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException | SQLException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } 
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_TIPOGASTO")
    public String METHOD_LIST_TIPOGASTO(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            TipogastoDao tipogastodao =new TipogastoDao();
            List<Tipogasto> list= tipogastodao.listarPorEmpresa_Tipogasto(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Tipogasto", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_ORDENLIQUIDACIONGASTO")
    public String METHOD_LIST_ORDENLIQUIDACIONGASTO(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            OrdenliquidaciongastoDao ordenliquidaciongastodao =new OrdenliquidaciongastoDao();
            List<Ordenliquidaciongasto> list= ordenliquidaciongastodao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Ordenliquidaciongasto", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_ORDENSERVICIOCLIENTE")
    public String METHOD_LIST_ORDENSERVICIOCLIENTE(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            OrdenservicioclienteDao ordenservicioclienteDao = new OrdenservicioclienteDao();
            List<Ordenserviciocliente> list = ordenservicioclienteDao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Ordenserviciocliente", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_DORDENLIQUIDACIONGASTO")
    public String METHOD_LIST_DORDENLIQUIDACIONGASTO(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            DordenliquidaciongastoDao dordenliquidaciongastodao =new DordenliquidaciongastoDao();
            List<Dordenliquidaciongasto> list= dordenliquidaciongastodao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Dordenliquidaciongasto", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_LIST_DORDENSERVICIOCLIENTE")
    public String METHOD_LIST_DORDENSERVICIOCLIENTE(@WebParam(name = "type") String type){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
            List<Dordenserviciocliente> list = dordenservicioclienteDao.listarPorEmpresaService(idempresa);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    result = WebUtil.objectGson(list.size(),list);
                }
                if(type.trim().equals("XML")){
                    try {
                        result = WebUtil.objectXml("com.nisira.core.entity.Dordenserviciocliente", list);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        }
        return result;
    }
    @WebMethod(operationName = "getEmpresas")
    public String getEmpresas(@WebParam(name = "dbconexion") String dbconexion, @WebParam(name = "tipoXmlJson") String tipoXmlJson ) {

        String result = null;
        List<Empresa>  lista_empresas = new ArrayList<Empresa>();
        try{
            setConexion(dbconexion);
            EmpresaDao empresadao = new EmpresaDao();                
            lista_empresas = empresadao.listar();   
            if(tipoXmlJson.trim().equals("JSON")){
                Gson gson = new Gson();
                result = gson.toJson(lista_empresas); 
            }
            if(tipoXmlJson.trim().equals("XML")){
                String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xstream = new XStream();
                xstream.processAnnotations(Empresa.class);
                result = xml + xstream.toXML(lista_empresas);
            }
        }catch(Exception ex){
            return ex.toString();                  
        }                              
        return result;             
    }
    
    @WebMethod(operationName = "getUsuarios")
    public String getUsuarios(@WebParam(name = "dbconexion") String dbconexion, @WebParam(name = "tipoXmlJson") String tipoXmlJson ) {
        String result = null;
        List<Usuario>  lista_usuarios = new ArrayList<Usuario>();
        try{
            setConexion(dbconexion);
            UsuarioDao usuariodao = new UsuarioDao();                
            lista_usuarios = usuariodao.listar();   
            if(tipoXmlJson.trim().equals("JSON")){
                Gson gson = new Gson();
                result = gson.toJson(lista_usuarios); 
            }
            if(tipoXmlJson.trim().equals("XML")){
                String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xstream = new XStream();
                xstream.processAnnotations(Usuario.class);
                result = xml + xstream.toXML(lista_usuarios);
            }
        }catch(Exception ex){
            return ex.toString();                  
        }                              
        return result;             
    }
    
    /*SINCRONIZACION DOCUMENTOS*/
    @WebMethod(operationName = "METHOD_ASCENT_ORDENSERVICIOCLIENTE")
    public String METHOD_ASCENT_ORDENSERVICIOCLIENTE(@WebParam(name = "type") String type,@WebParam(name = "datos") String datos,@WebParam(name = "user") String user){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            OrdenservicioclienteDao ordenservicioclienteDao = new OrdenservicioclienteDao();
            
            List<Ordenserviciocliente> list = (List<Ordenserviciocliente>) WebUtil.stringObject("com.nisira.core.entity.Ordenserviciocliente", datos);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    for(Ordenserviciocliente dt:list){
                        result = ordenservicioclienteDao.syncro_movil_object(dt,user);
                    }
                }
                if(type.trim().equals("XML")){
                    result = ordenservicioclienteDao.syncro_movil_list(list,user);
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_ASCENT_DORDENSERVICIOCLIENTE")
    public String METHOD_ASCENT_DORDENSERVICIOCLIENTE(@WebParam(name = "type") String type,@WebParam(name = "datos") String datos,@WebParam(name = "user") String user){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            DordenservicioclienteDao dordenservicioclienteDao = new DordenservicioclienteDao();
            
            List<Dordenserviciocliente> list = (List<Dordenserviciocliente>) WebUtil.stringObject("com.nisira.core.entity.Dordenserviciocliente", datos);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    for(Dordenserviciocliente dt:list){
                        result = dordenservicioclienteDao.syncro_movil_object(dt,user);
                    }
                }
                if(type.trim().equals("XML")){
                    result = dordenservicioclienteDao.syncro_movil_list(list,user);
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_ASCENT_PERSONAL_SERVICIO")
    public String METHOD_ASCENT_PERSONAL_SERVICIO(@WebParam(name = "type") String type,@WebParam(name = "datos") String datos,@WebParam(name = "user") String user){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            
            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            
            Personal_servicioDao personal_servicioDao = new Personal_servicioDao();
            
            List<Personal_servicio> list = (List<Personal_servicio>) WebUtil.stringObject("com.nisira.core.entity.Personal_servicio", datos);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    for(Personal_servicio dt:list){
                        result = personal_servicioDao.syncro_movil_object(dt,user);
                    }
                }
                if(type.trim().equals("XML")){
                    result = personal_servicioDao.syncro_movil_list(list,user);
                }
            }
            else
            {
                result = "ERROR";
            }
            
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @WebMethod(operationName = "METHOD_ASCENT_DPERSONAL_SERVICIO")
    public String METHOD_ASCENT_DPERSONAL_SERVICIO(@WebParam(name = "type") String type,@WebParam(name = "datos") String datos,@WebParam(name = "user") String user){
        String result=null;
        try {
            String conexion = WebMethodNisira.cargarBaseDatos();
            setConexion(conexion);
            ArrayList<String> lista_solution=com.nisira.core.util.CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/            String idempresa = lista_solution.get(5);
            ConstantesBD.setIDEMPRESA(idempresa);
            Dpersonal_servicioDao dpersonal_servicioDao = new Dpersonal_servicioDao();
            List<Dpersonal_servicio> list = (List<Dpersonal_servicio>) WebUtil.stringObject("com.nisira.core.entity.Dpersonal_servicio", datos);
            if(list !=null){
                if(type.trim().equals("JSON")){
                    for(Dpersonal_servicio dt:list){
                        result = dpersonal_servicioDao.syncro_movil_object(dt,user);
                    }
                }
                if(type.trim().equals("XML")){
                    result = dpersonal_servicioDao.syncro_movil_list(list,user);
                }
            }
            else
            {
                result = "ERROR";
            }
        } catch (NisiraORMException  ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
            result = "ERROR :"+ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WebServiceNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
 }
