/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.entity.Empresa;
import com.nisira.core.util.CoreUtil;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.Utilitarios;
import java.io.Serializable;
import static com.pe.nisira.movil.view.util.WebLog.log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class WebMethodNisira implements Serializable {
    /******************  LOGIN *******************/
    public static String cargarBaseDatos() {
        String base="";
        try {
           ArrayList<String> lista_solution=CoreUtil.valoresBase();
           if(lista_solution.size()>0)
               base = lista_solution.get(4);
       } 
       catch (Exception ex) {
           base=ex.getMessage();
       }
       return base;
    }
    public static Empresa cargarEmpresas(String conexion) {
       Empresa empresa=null;
        try {
           Constantes.conexionORM=conexion;
           Constantes.setConexionORM(conexion);
           EmpresaDao empresadao = new EmpresaDao(true);
           List<Empresa> listEmpresa=empresadao.listar();
           if(listEmpresa.size()>0){
               empresa=listEmpresa.get(0);
           }
       } 
       catch (Exception ex) {
           log.error(ex, ex);
       }
        return empresa;
    }
    /*******ENVIO XML / JSON*******/
    public static final String RUTATEMPORAL = System.getProperty("java.io.tmpdir") + "nisirapolice/";
    public static String envioXml(String nombrearchivo,String xml){
        String b64_zipXml=null;
        String baseName = System.currentTimeMillis() + "";
        //String ruta = "D:\\POLICE".concat("\\").concat("nisira_create").concat(baseName).concat("\\");
        String ruta = RUTATEMPORAL.concat("nisira_create").concat(baseName).concat("/");
        File dir = new File(ruta);
        dir.mkdirs();
        dir.deleteOnExit();
        
        String ruta_zip = ruta.concat(nombrearchivo).concat(".zip");
        String ruta_xml_enzip = ruta.concat(nombrearchivo).concat(".xml");
        try {
            Utilitarios.escribirArchivo(ruta_xml_enzip, xml, "ISO-8859-1");
        } catch (IOException ex) {
            Logger.getLogger(WebMethodNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        
        try {
            fos = new FileOutputStream(ruta_zip);
            zos = new ZipOutputStream(fos);
            Utilitarios.addToZipFile(ruta_xml_enzip, nombrearchivo + ".xml", zos);
            zos.close();
            fos.close();
            b64_zipXml = Utilitarios.FilePathToBase64(ruta_zip);
            new File(ruta_zip).delete();
            new File(ruta_xml_enzip).delete();
            new File(ruta).delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WebMethodNisira.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebMethodNisira.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b64_zipXml;
    }
}
