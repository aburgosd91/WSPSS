/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pe.nisira.movil.view.bean.MensajeBean;
import java.io.IOException;
import java.text.MessageFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.primefaces.model.UploadedFile;


/**
 *
 * @author Antenor
 */
public class WebUtil {
    public static final String[] strMonths = new String[]{
						"Enero",
						"Febebro",
						"Marzo",
						"Abril",
						"Mayo",
						"Junio",
						"Julio",
						"Agosto",
						"Septiembre",
						"Octubre",
						"Noviembre",
						"Diciembre"};
    /********************************GENERACION DISTRIBUCION ALMACEN********************************************/
    public static String idGeneradoTres(int id){
        if(id<10) return "00"+id;
        else if(id<100) return "0"+id;
        else return String.valueOf(id);
    }
    public static String ubicacionGeneracionRacks(String rack,String almacen,String sucursal){
        return "S"+idGeneradoTres(Integer.parseInt(sucursal))+"A"+idGeneradoTres(Integer.parseInt(almacen))+"R"+idGeneradoTres(Integer.parseInt(rack));
    }
    public static String ubicacionGeneracionPisos(String piso,String rack,String almacen,String sucursal){
        return "S"+idGeneradoTres(Integer.parseInt(sucursal))+"A"+idGeneradoTres(Integer.parseInt(almacen))+"R"+idGeneradoTres(Integer.parseInt(rack))+"P"+idGeneradoTres(Integer.parseInt(piso));
    }
    public static String ubicacionGeneracionFilas(String filas,String piso,String rack,String almacen,String sucursal){
        return "S"+idGeneradoTres(Integer.parseInt(sucursal))+"A"+idGeneradoTres(Integer.parseInt(almacen))+"R"+idGeneradoTres(Integer.parseInt(rack))+"P"+idGeneradoTres(Integer.parseInt(piso))+"F"+idGeneradoTres(Integer.parseInt(filas));
    }
    public static String ubicacionGeneracionColumnas(String columnas,String filas,String piso,String rack,String almacen,String sucursal){
        return "S"+idGeneradoTres(Integer.parseInt(sucursal))+"A"+idGeneradoTres(Integer.parseInt(almacen))+"R"+idGeneradoTres(Integer.parseInt(rack))+"P"+idGeneradoTres(Integer.parseInt(piso))+"F"+idGeneradoTres(Integer.parseInt(filas))+"C"+idGeneradoTres(Integer.parseInt(columnas));
    }
    
    /********************************FECHAS -> STRING OPERACION********************************************/
    public static String fechaDMY(Date fecha, int tipo){
        String forma="";
        switch(tipo){
            case 1:forma="dd-MM-yyyy";break;
            case 2:forma="dd/MM/yy";break;
            case 3:forma="dd-MM-yy:HH:mm:SS Z";break;
            case 4:forma="yyyy-MM-dd HH:mm:ss";break;
        }
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(forma);
        return DATE_FORMAT.format(fecha);
    }
    public static String fechaHoraEspaniol(String fecha){
        if(fecha!=null && !fecha.equals("")){
            String anio=fecha.substring(0,4);
            String dia=fecha.substring(8,10);
            String hora=fecha.substring(11,19);
            return anio+'-'+fecha.substring(5,7)+'-'+dia+' '+hora;
        }else
            return fecha;
    }
    /***************************************CEROS A LA IZQUIERA*********************************************/
    public static String cerosIzquierda(Object e1,int cantidad){
        String cadena="";
        Formatter fmt = new Formatter();
        fmt.format("%0"+cantidad+"d",Integer.parseInt(e1.toString()));
        cadena=fmt.toString();
        return cadena;
    }
    /********************************MSJ DE OPERACION********************************************/
    public static String exitoRegistrar(Object... param) {
        return MessageFormat.format(Constantes.MENSAJE_REGISTRO, param);
    }

    public static String exitoActualizar(Object... param) {
        return MessageFormat.format(Constantes.MENSAJE_ACTUALIZACION, param);
    }

    public static String exitoEliminar(Object... param) {
        return MessageFormat.format(Constantes.MENSAJE_ELIMINAR, param);
    }
    /********************************MSJ DE ALERTAS********************************************/
    public  static void info(String mensaje) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", mensaje));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
    }
    public static void warn(String mensaje) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", mensaje));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
    }
    public static void error(String mensaje) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",mensaje));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje,mensaje));
    }
    public static void fatal(String mensaje) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", mensaje));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, mensaje));
    }
    
    public static Object getObjetoSesion(String objectName) {
        HttpServletRequest request = (HttpServletRequest) getInstancia().getExternalContext().getRequest();
        return request.getSession(false).getAttribute(objectName);
    }

    private static FacesContext getInstancia() {
        return FacesContext.getCurrentInstance();
    }

    public static HttpSession getSesion() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static void sendRedirect(String ruta) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) currentInstance.getExternalContext().getResponse();
        try {
            currentInstance.responseComplete();
            response.sendRedirect(currentInstance.getExternalContext().getRequestContextPath() + "/faces" + ruta);
        } catch (IOException ioe) {
        }
    }

    public static void setObjetoSesion(String objectName, Object object) {
        log.info("SE PUSO EN SESION EL OBJETO " + objectName + " DEL TIPO " + object.getClass());
        HttpServletRequest request = (HttpServletRequest) getInstancia().getExternalContext().getRequest();
        request.getSession(false).setAttribute(objectName, object);
    }

    public static String mensajeError() {
        String codigo ="";// UtilWeb.obtenerFechaActual("ddMMyyyyhhmmss");
        MensajeBean men = ((MensajeBean) getObjetoSesion(Constantes.SESION_MENSAJE));
        men.setMensaje(codigo);
        setObjetoSesion(Constantes.SESION_MENSAJE, men);
        return Constantes.MENSAJE_ERROR + codigo;
    }

    public static String mensajeCritico() {
        String codigo ="";// UtilWeb.obtenerFechaActual("ddMMyyyyhhmmss");
        return Constantes.MENSAJE_EXCEPTION + codigo;
    }

    public static void MensajeAlerta(String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        String msje=msj;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msje, ""));

    }
    public static void MensajeError(String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        String msje=msj;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msje, ""));
    }
    public static void MensajeFatal(String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msj, ""));
    }
    public static void MensajeAdvertencia(String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msj, ""));
    } 
    public static void deleteColumn( Sheet sheet, int columnToDelete ){
                int maxColumn = 0;
                for ( int r=0; r < sheet.getLastRowNum()+1; r++ ){
                        Row     row     = sheet.getRow( r );
                       
                        // if no row exists here; then nothing to do; next!
                        if ( row == null )
                                continue;
                        // if the row doesn't have this many columns then we are good; next!
                        int lastColumn = row.getLastCellNum();
                        if ( lastColumn > maxColumn )
                                maxColumn = lastColumn;
                       
                        if ( lastColumn < columnToDelete )
                                continue;
                       
                        for ( int x=columnToDelete+1; x < lastColumn + 1; x++ ){
                                Cell oldCell    = row.getCell(x-1);
                                if ( oldCell != null )
                                        row.removeCell( oldCell );
                               
                                Cell nextCell   = row.getCell( x );
                                if ( nextCell != null ){
                                        Cell newCell    = row.createCell( x-1, nextCell.getCellType() );
                                        cloneCell(newCell, nextCell);
                                }
                        }
                }
 
               
                // Adjust the column widths
                for ( int c=0; c < maxColumn; c++ ){
                        sheet.setColumnWidth( c, sheet.getColumnWidth(c+1) );
                }
        }

    private static void cloneCell( Cell cNew, Cell cOld ){
            cNew.setCellComment( cOld.getCellComment() );
            cNew.setCellStyle( cOld.getCellStyle() );

            switch ( cNew.getCellType() ){
                    case Cell.CELL_TYPE_BOOLEAN:{
                            cNew.setCellValue( cOld.getBooleanCellValue() );
                            break;
                    }
                    case Cell.CELL_TYPE_NUMERIC:{
                            cNew.setCellValue( cOld.getNumericCellValue() );
                            break;
                    }
                    case Cell.CELL_TYPE_STRING:{
                            cNew.setCellValue( cOld.getStringCellValue() );
                            break;
                    }
                    case Cell.CELL_TYPE_ERROR:{
                            cNew.setCellValue( cOld.getErrorCellValue() );
                            break;
                    }
                    case Cell.CELL_TYPE_FORMULA:{
                            cNew.setCellFormula( cOld.getCellFormula() );
                            break;
                    }
            }

    }
    
    public static void subirArchivo(UploadedFile archivo,String carpeta) throws IOException{
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String path = (String) servletContext.getRealPath(carpeta);
            outputStream = new FileOutputStream(new File(path + "/" + archivo.getFileName()));
            inputStream = archivo.getInputstream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read=inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
//            getArchivoLista(path + "/" + archivo.getFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WebUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             if (inputStream != null) {
            inputStream.close();
         }
         if (outputStream != null) {
            outputStream.close();
         }
        }
    }
    public static void subirFichero(UploadedFile uploadFile,String ruta,String nombreFichero) throws IOException {
        ruta=ruta+nombreFichero;
        File file = new File(ruta);
        FileOutputStream fos=new FileOutputStream(file);
        IOUtils.copy(uploadFile.getInputstream(),fos);
    }
    public static List getArchivoLista(String filename) throws IOException{ /*+++++Excel pasa a Lista++++*/
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        boolean temp=true;
        int cont=0,totalrow=0;
        List data = new ArrayList();
        try {
            fis = new FileInputStream(filename);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fis);
            HSSFWorkbook workbook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext() & temp) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                    totalrow=data.size();
                }
                temp=false;
                data= new ArrayList();
                for(int i=0;i<totalrow;i++)
                    data.add(sheet.getRow(cont).getCell(i)==null?"null":sheet.getRow(cont).getCell(i).getStringCellValue());
                cont++;
                sheetData.add(data);
            }
//          getArchivoExcel(sheetData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return sheetData;
    }
    public static void getArchivoExcel(List sheetData){/*Recorre Lista de Excel*/
        for(int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                Cell cell = (Cell) list.get(j);
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(cell.getRichStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(cell.getBooleanCellValue());
                }
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
        System.out.println("Terminado ...");
    }

    private static void showExelData(List sheetData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void MensajeErrorNuevo(String id,String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(id, new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, ""));
    }
    public  static void MensajeInformativoNuevo(String id,String mensaje) {
        FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
    }
    
    /* AGREDO 02-02-2016 */
    public static String convertArrayJSon(List<Object> obj){
        String json="";
        Gson gson = new Gson();
        json= gson.toJson(obj, ArrayList.class);
        return json;
    }
    public static String convertObjectJSon(Object obj){
        String json="";
        Gson gson = new Gson();
        json= gson.toJson(obj, Object.class);
        return json;
    }
    public static String XmlToString(String clase,Object objecto) throws ClassNotFoundException{
        Class oClase =  Class.forName(clase);
        String xml="<?xml version='1.0' encoding='ISO-8859-1'?>";
        XStream xStream= new XStream();
        xStream.processAnnotations(oClase);
//        return xml + xStream.toXML(objecto);
        return xml+xStream.toXML(objecto);
    }
    public void crearXML(String clase,Object objecto, String ruta) throws FileNotFoundException, ClassNotFoundException{
        Class oClase =  Class.forName(clase);
        String xml="<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream= new XStream();
        xStream.processAnnotations(oClase);
        xStream.toXML(objecto, new FileOutputStream(ruta));
    }
    public static BufferedImage imageToBufferedImage(Image im) {
     BufferedImage bi = new BufferedImage
        (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
     Graphics bg = bi.getGraphics();
     bg.drawImage(im, 0, 0, null);
     bg.dispose();
     return bi;
  }
    /* AGREGADO 27-12-2016*/
    public static float convertTimeDecimal(Date time){
        float timeF=0.0f;
        int hora= time.getHours();
        int minutos= time.getMinutes();
        timeF=((float)hora)+((float)minutos/(float)60);
        return Math.round(timeF*100.0f)/100.0f;
    }
    public static Date convertDecimalTime(float timeF){
        Date obj= new Date();
        int hora = (int)timeF;
        int minutos = (int)((timeF-(float)hora)*60);
        obj.setHours(hora);
        obj.setMinutes(minutos);
        return obj;
    }
    /************** AGREGADO 06/01/2017 **************/
    public static String objectGson(int total,Object obj){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return "{\"total\":"+total+",\"datos\":"+gson.toJson(obj)+"}"; 
    }
    public static String objectGson(Object obj){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj); 
    }
    public static String objectXml(String _class,Object obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        String xml="<?xml version='1.0' encoding='ISO-8859-1'?>";
        
        XStream xStream= new XStream(){
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                 return new MapperWrapper(next) {
                     public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                         try {
                             return definedIn != Object.class || realClass(fieldName) != null;
                         } catch (CannotResolveClassException cnrce) {
                             return false;
                         }
                     }
                 };
             }
        };
        xStream.processAnnotations(oClase);
        return xml+xStream.toXML(obj);
    }
    public static List<? extends Object> stringObject(String _class,String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        XStream xStream= new XStream(){
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                 return new MapperWrapper(next) {
                     public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                         try {
                             return definedIn != Object.class || realClass(fieldName) != null;
                         } catch (CannotResolveClassException cnrce) {
                             return false;
                         }
                     }
                 };
             }
        };
        xStream.processAnnotations(oClase);
        List<? extends Object> object = (List<? extends Object>)xStream.fromXML(obj);
        return object;
    }
    public static List<? extends Object> stringGson(String _class,String obj) throws ClassNotFoundException{
        Class oClase =  Class.forName(_class);
        Gson gson = new Gson();
        List<? extends Object> object = (List<? extends Object>)gson.fromJson(obj, oClase);
        return object;
    }
    /************** AGREGADO 06/02/2017 **************/
    public static String SimpleDateFormatN1(Date fecha){
        if(fecha!=null){
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String stringFecha = f.format(fecha);
            return stringFecha;
        }else{
            return null;
        }
    }
}