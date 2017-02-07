/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import com.nisira.core.EConexion;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.ConfigWeb;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.util.CoreUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author Antenor
 */

@ManagedBean(name = "Constantes")
@ViewScoped

public class Constantes {
    public static String SYSCONFIGPATH="configweb.properties";
    public static String conexionORM="";
    public static ConfigWeb configWeb;
    public static String REGISTRAR_Personal = "registrarPersonal";
    public static String ACTUALIZAR_Ordencompra = "actualizarOrdenCompra";
    public static String REGISTRAR_Usuario = "registrarUsuario";
    public static String ACTUALIZAR_Usuario = "actualizarUsuario";
    
    //MANEJO DE SESIONES
    public static String SESION_PROPERTIES="webProperty";
    public static String SESION_USUARIO="usuarioBean";
    public static List<String> USUARIOS_TESTING = new ArrayList<String>();
    public static String SESION_MENSAJE="mensajeBean";
    public static String SESION_INIT="init";
    public static int SESION_MAX = 10*60; //  15  * 60000 (1 minuto)
    public static String IDSESION;//para manejar el numero de licencias
    public static boolean ESADMINISTRADOR = false;
    public static String IDUSUARIO = "";
    public static String TIPOSINCRO ="";
    
    public static String IDMODULOGENERAL;
    public static String IDSUCURSALGENERAL;
    public static String IDEMPRESAGENERAL;
    public static String ARCHIVO_DESTINO="D:\\cotizacionesPDF\\";  // 
    public static String NEWIDSUCURSALGENERAL="sucursalGeneral";
    public static String NEWIDEMPRESAGENERAL="empresaGeneral";
    /**************************************************************************/
     public static String ventana;
    public static Sucursal selectSucursal;
    public static Almacen selectAlmacen;
    
    public static int estadoDocumento;
    public static String cbarra;
    //CONTENEDOR DE CATALOGO DE MENUS
    public static List<String> catalagoXHTML(List<String> carpetas) throws Exception{
        List<String> listaCatalogo=new ArrayList<String>();
        if(carpetas!=null){
            for(int i=0;i<carpetas.size();i++){
                File dir = new File(carpetas.get(i));
                String[] ficheros = dir.list();
                for(int j=0;j<ficheros.length;j++)
                    listaCatalogo.add(ficheros[j]);
            }
        }
        return listaCatalogo;
    }
    //VARIABLES DE SESSION
    public static String getIDSESION() {
            return IDSESION;
    }
    public static String getIDEMPRESAGENERAL() {
        return WebUtil.getObjetoSesion(Constantes.NEWIDEMPRESAGENERAL).toString();
    }

    public static void setIDEMPRESAGENERAL(String IDEMPRESAGENERAL) {
        WebUtil.setObjetoSesion(Constantes.NEWIDEMPRESAGENERAL, IDEMPRESAGENERAL);
        Constantes.IDEMPRESAGENERAL = IDEMPRESAGENERAL;
    }

    public static String getIDSUCURSALGENERAL() {
        return WebUtil.getObjetoSesion(Constantes.NEWIDSUCURSALGENERAL).toString();
    }

    public static void setIDSUCURSALGENERAL(String IDSUCURSALGENERAL) {
        WebUtil.setObjetoSesion(Constantes.NEWIDSUCURSALGENERAL, IDSUCURSALGENERAL);
        Constantes.IDSUCURSALGENERAL = IDSUCURSALGENERAL;
    }

    public static String getIDMODULOGENERAL() {
        return IDMODULOGENERAL;
    }

    public static void setIDMODULOGENERAL(String IDMODULOGENERAL) {
        Constantes.IDMODULOGENERAL = IDMODULOGENERAL;
    }
    public static void setIDSESION(String IDSESION) {
        Constantes.IDSESION = IDSESION;
    }
    //MENSAJES
    public static String MENSAJE_ERROR="Ocurrio un error inesperado, codigo de error: " ;
    public static String MENSAJE_EXCEPTION="Ocurrio un error inesperado en el sistema, codigo de error: " ;
    public static String MENSAJE_REGISTRO="Se registro el(la) {0} de manera correcta, con código: {1}";
    public static String MENSAJE_ACTUALIZACION="Se actualizo el(la) {0} de manera correcta, con código: {1}";
    public static String MENSAJE_ELIMINAR="Se elimino el(la) {0} de manera correcta, con código: {1}";
    //PAGINA
    public static String PAGINA_ERROR= "/sistema/error.xhtml";
    public static String GIDEMISOR= "001";
    public static String GIDESTADO_INICIAL= "PE";
    public static String GVENTANA_TG30COTVENT= "EDT_COTIZACIONVENTAS_VEHICULOS_WEB";   
    //ESTILOS
    public static final String ESTILO_MENSAJE_SIMPLE_INFO = "infoSimple";
    public static final String ESTILO_MENSAJE_SIMPLE_ALERTA = "alertaSimple";
    public static final String ESTILO_MENSAJE_INFO = "info";
    public static final String ESTILO_MENSAJE_EXITO = "exito";
    public static final String ESTILO_MENSAJE_ALERTA = "alerta";
    public static final String ESTILO_MENSAJE_ERROR = "error";
    public static final String ESTILO_MENSAJE_VACIO = "vacio";

    /**
     * @return the selectGeneracionCodigo
     */

    public static int getEstadoDocumento() {
        return estadoDocumento;
    }

    public static void setEstadoDocumento(int estadoDocumento) {
        Constantes.estadoDocumento = estadoDocumento;
    }

    public static String getVentana() {
        return ventana;
    }

    public static void setVentana(String ventana) {
        Constantes.ventana = ventana;
    }

    public static String getTIPOSINCRO() {
        return TIPOSINCRO;
    }

    public static void setTIPOSINCRO(String aTIPOSINCRO) {
        TIPOSINCRO = aTIPOSINCRO;
    }
    
    public static String getLlenarCeros(int numceros,Object obj){
        String resp="";
        int dig=obj.toString().length();
        for(int i=0;i<numceros-dig;i++){
            resp+="0";
        }
        resp+=obj.toString();
        return resp;
    }
    /****************  ********************/
    public static boolean CrearConfigOrigen(){
        boolean flag=true;
        Properties prop = new Properties();
	OutputStream output = null;
        try {
            output = new FileOutputStream(SYSCONFIGPATH);
            prop.setProperty("idempresa", String.valueOf(configWeb.getIdempresa()));
            prop.setProperty("idsucursal", String.valueOf(configWeb.getIdsucursal()));
            prop.setProperty("disco", configWeb.getDisco());
            prop.setProperty("path", configWeb.getPath());
            prop.setProperty("imgplant", configWeb.getImgplant());
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
            flag=false;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    public static String[] LlenarConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
                input = new FileInputStream("/configweb.properties");
                prop.load(input);
                String idempresa = prop.getProperty("idempresa", "");							/*0*/
                String idsucursal = prop.getProperty("idsucursal", "");
                String disco = prop.getProperty("disco", "");
                String path = prop.getProperty("path", "");
                String imgplant = prop.getProperty("imgplant", "");
                /*17*/
                if (input != null) {
                        try {
                                input.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                        return new String[] { idempresa, idsucursal, disco, path, imgplant};
                }else
                    return null;
        } catch (IOException ex) {
                ex.printStackTrace();
                return null;
        }
    }

    public static void main(String[] args) {
        Constantes.configWeb = new ConfigWeb();
        configWeb.setIdempresa(1);
        configWeb.setIdsucursal(1);
        configWeb.setDisco("C:\\");
        configWeb.setPath("\\SOLUTION\\WEB");
        configWeb.setImgplant("plano_planta1.png");
        Constantes.CrearConfigOrigen();
    }
    /*CORREGIR*/
    public  static void setConexionORM(String db){
        ArrayList<String> lista_solution=CoreUtil.valoresBase();/*Obtener Datos de solution.ini*/
        EConexion e = new EConexion();
        e.BASEDATOS = lista_solution.get(4);/*BASE DATOS*/
        e.CLAVE = ClaveMovil.Desencriptar_ASCII(lista_solution.get(3));//"amadeus2010";
        e.INSTANCIA = "";
        e.USUARIO = lista_solution.get(2).trim();//"sa";
        //e.SERVIDOR = "localhost";
        e.SERVIDOR = lista_solution.get(0).trim();//"10.250.50.88";
        e.TIPO = "MSSQL";
        com.nisira.core.CoreUtil.conexiones.put("default", e);
    }
}
