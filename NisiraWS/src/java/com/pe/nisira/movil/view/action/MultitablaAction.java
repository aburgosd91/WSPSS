/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.entity.Multitabla;
import com.nisira.core.service.MultitablaService;
import com.nisira.core.util.ConstantesBD;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "multitablaAction")
@SessionScoped
public class MultitablaAction extends AbstactListAction<Multitabla> implements Serializable{
    /* NOTAS:
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */

    private String idempresa;
    private String mensaje;
    private String IDVALOR;
    private MultitablaService multitablaService;
    /**
     * *****************************TABLAS*****************************************
     */
    private Multitabla selectMultitablaTabla;
    private List<Multitabla> listMultitablaTabla;
    private List<Multitabla> listMultitablaTablaUp;
    private Multitabla variableMultitabla;
    private boolean botonEditarTabla;
    private boolean botonEliminarTabla;
    /**
     * *****************************DETALLES
     * TABLAS*****************************************
     */
    private Multitabla variableDetalleMultitabla;
    private List<Multitabla> listDetalleMultitablaTabla;
    private List<Multitabla> listDetalleMultitablaTablaUp;
    private List<Multitabla> filtroDetalleMultitablaTabla;
    private Multitabla selectDetalleMultitablaTabla;
    private boolean botonNuevoDetalleTabla;
    private boolean botonEliminarDetalleTabla;
    private UploadedFile upFile;

    public MultitablaAction() {
        idempresa = ConstantesBD.IDEMPRESA;
        IDVALOR = "";
//        Constantes.estadoDocumento=1;
        listMultitablaTabla = new ArrayList<Multitabla>();
        listMultitablaTablaUp = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        botonEditarTabla = true;
        botonEliminarTabla = true;
        listDetalleMultitablaTabla = new ArrayList<Multitabla>();
        listDetalleMultitablaTablaUp = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_multitabla");
        variableDetalleMultitabla = new Multitabla();
    }
    
    @Override
    public void buscarTodo() {
        try {
            actualiza_ventana("wMnt_multitabla");
            setListaDatos(multitablaService.getRecordTabla(idempresa));
            Constantes.estadoDocumento = 0;
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    @Override
    public String getIniciar() {
        idempresa = ConstantesBD.IDEMPRESA;
        IDVALOR = "";
//        Constantes.estadoDocumento=1;
        listMultitablaTabla = new ArrayList<Multitabla>();
        listMultitablaTablaUp = new ArrayList<Multitabla>();
        multitablaService = new MultitablaService();
        botonEditarTabla = true;
        botonEliminarTabla = true;
        listDetalleMultitablaTabla = new ArrayList<Multitabla>();
        listDetalleMultitablaTablaUp = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_multitabla");
        variableDetalleMultitabla = new Multitabla();
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Multitabla());
            listDetalleMultitablaTabla = new ArrayList<Multitabla>();
            getDatoEdicion().setEMPRESA(Integer.valueOf(idempresa));
            getDatoEdicion().setESTADO(true);
            setBotonNuevoDetalleTabla(true);
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getDESCRIPCION().equals("")) {
                this.mensaje = "Ingrese Descripción";
                WebUtil.MensajeError(this.mensaje);
            } else {
                if (getDatoEdicion().getVALOR()==null) {//Nuevo
                    IDVALOR = multitablaService.addMultitabla(getDatoEdicion());
                    getDatoEdicion().setVALOR(IDVALOR);
                    botonNuevoDetalleTabla = false;
//                    Multitabla mdetalle;
//                    if(listDetalleMultitablaTabla.size()>0){
//                        for(int i=0;i<listDetalleMultitablaTabla.size();i++){
//                            mdetalle=listDetalleMultitablaTabla.get(i);
//                            mdetalle.setDEP_ID(tempVALOR);
//                            listDetalleMultitablaTabla.set(i, mdetalle);
//                        }
//                    }
//                    multitablaService.addXmlMultitabla(idempresa,cadenaDetalleMultitablaXml());
                    Constantes.estadoDocumento = 2;
                    RequestContext.getCurrentInstance().update("datos:tbl");
                } else if (getDatoEdicion().getVALOR()!=null) {//Modificar
                    multitablaService.editMultitabla(getDatoEdicion());
                    multitablaService.addXmlMultitabla(idempresa, Integer.parseInt(getDatoEdicion().getVALOR()), cadenaDetalleMultitablaXml());
                }
                getRecordDetalleMultitabla();
                WebUtil.info(WebUtil.exitoRegistrar("Documento Generación de Código", getDatoEdicion().getDESCRIPCION()));
            }
//            RequestContext.getCurrentInstance().update("dlgFormNuevoSucursal");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getDatoSeleccionado().getTABLA_ID().equals("0")) {
//                WebUtil.MensajeAlerta("Ingrese Descripción");
                this.mensaje = "Ingrese IDGENERACIÓN";
            } else {
                setMensaje(multitablaService.deleteMultitabla(getDatoSeleccionado()));
                buscarTodo();
                WebUtil.info(WebUtil.exitoEliminar("Documento Generación", getDatoSeleccionado().getTABLA_ID()));
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void onRowSelect(SelectEvent event) throws IOException {
        selectMultitablaTabla = (Multitabla) event.getObject();
        botonEditarTabla = false;
        botonEliminarTabla = false;
        return;
    }

    /**
     * *************************DETALLE
     * MULTITABLA***********************************
     */
    public void getRecordDetalleMultitabla() {
        try {
            setListDetalleMultitablaTabla(multitablaService.getRecordTablaDetalle(idempresa, getDatoEdicion().getVALOR()));
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void agregarDetalleMultitabla() {
        try {
            if (getVariableDetalleMultitabla().getDESCRIPCION().equalsIgnoreCase("")) {
                this.mensaje = "Deberá ingresar descripción";
                WebUtil.MensajeError(mensaje);
            } else {
                variableDetalleMultitabla.setEMPRESA(Integer.valueOf(idempresa));
                variableDetalleMultitabla.setDEP_ID(getDatoEdicion().getVALOR());
                variableDetalleMultitabla.setESTADO(true);
                variableDetalleMultitabla.setVALOR("" + (listDetalleMultitablaTabla.size() + 1));
                getListDetalleMultitablaTabla().add(variableDetalleMultitabla);
                variableDetalleMultitabla = new Multitabla();
                RequestContext.getCurrentInstance().update("FormularioMultitabla");
                RequestContext.getCurrentInstance().update("FormularioNuevoTablaDetalle");
                RequestContext.getCurrentInstance().update("datos:tbl");
                return;
            }
        } catch (Exception ex) {
            WebUtil.MensajeFatal(ex.getMessage());
            return;
        }
    }

    public void InhabilitarDetalleMultitabla() {
        try {
            int pos = getListDetalleMultitablaTabla().indexOf(getSelectDetalleMultitablaTabla());
            getListDetalleMultitablaTabla().remove(pos);
            restablecerInices();
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void restablecerInices() {
        try {
            Multitabla temp;
            for (int i = 0; i < listDetalleMultitablaTabla.size(); i++) {
                temp = listDetalleMultitablaTabla.get(i);
                temp.setVALOR("" + (i + 1));
                listDetalleMultitablaTabla.set(i, temp);
            }
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void onRowSelectMultitablaDetalle(SelectEvent event) throws IOException {
        selectDetalleMultitablaTabla = ((Multitabla) event.getObject());
        botonEliminarDetalleTabla = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void onRowUnselectMultitablaDetalle(UnselectEvent event) throws IOException {
        selectDetalleMultitablaTabla = ((Multitabla) event.getObject());
        botonEliminarDetalleTabla = false;
        RequestContext.getCurrentInstance().update("datos:tbl");
    }

    public void getActionReturn() {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/sistema/wList_multitabla.xhtml");
//            RequestContext.getCurrentInstance().execute("PF('dlgFormEditarSucursal').show()");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    public void InhabilitarTablaDetalle() {
        try {
            int pos = listDetalleMultitablaTabla.indexOf(selectDetalleMultitablaTabla);
            listDetalleMultitablaTabla.remove(pos);
            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            return;
        }
    }

    

    public String cadenaDetalleMultitablaXml() {
        System.out.println("DETALLE MULTITABLA XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DetalleMultitabla = new XStream();
        xStream_DetalleMultitabla.processAnnotations(Multitabla.class);
        return xml + xStream_DetalleMultitabla.toXML(listDetalleMultitablaTabla);
    }

    public String cadenaDetalleMultitablaXmlExcel(List<Multitabla> temp) {
        System.out.println("DETALLE MULTITABLA XML -> TERMINADO ...");
//        RequestContext.getCurrentInstance().update("datos:tbl");
        //DEFINIENDO XML DE RACK
        String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
        XStream xStream_DetalleMultitabla = new XStream();
        xStream_DetalleMultitabla.processAnnotations(Multitabla.class);
        return xml + xStream_DetalleMultitabla.toXML(temp);
    }

    public StreamedContent downFormatExcel() throws Exception {
        InputStream stream = null;
        StreamedContent arch = null;
        try {
            String folder = "C:\\SOLUTION\\WEB\\FORMATOS_IMPORTACION";
            File ruta = new File(folder);
            if (!ruta.isDirectory()) {
                ruta.mkdirs();
            }
            String rutaArchivo = folder + "\\FI_MULTITABLA.xlsx";
            File fileXls = new File(rutaArchivo);
            if (fileXls.exists()) {
                fileXls.delete();
            }
            fileXls.createNewFile();
            XSSFWorkbook libro = new XSSFWorkbook();
            FileOutputStream file = new FileOutputStream(fileXls);
            XSSFSheet hoja = libro.createSheet("IMPORTAR_MULTITABLA");
            CreationHelper factory = libro.getCreationHelper();
            hoja = libro.getSheetAt(0);
            XSSFCellStyle style = libro.createCellStyle();
            Font font = libro.createFont();
            Font font1 = libro.createFont();
            Drawing drawing = hoja.createDrawingPatriarch();
            ClientAnchor anchor1 = factory.createClientAnchor();
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            font.setFontHeightInPoints((short) 8);
            font1.setFontHeightInPoints((short) 8);
            font1.setFontName("Arial");
            font.setFontName("Arial");
            style.setFillForegroundColor(new XSSFColor(new java.awt.Color(247, 150, 70)));
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setAlignment(CellStyle.VERTICAL_CENTER);
            style.setAlignment(CellStyle.ALIGN_CENTER);
            style.setFont(font);
            for (int f = 0; f < 1; f++) {
                XSSFRow fila = hoja.createRow(f);
                for (int c = 0; c < 4; c++) {
                    XSSFCell celda = fila.createCell(c);
                    celda.setCellStyle(style);
                    anchor1.setCol1(celda.getColumnIndex());
                    anchor1.setCol2(celda.getColumnIndex() + 4);
                    anchor1.setRow1(fila.getRowNum());
                    anchor1.setRow2(fila.getRowNum() + 3);
                    Comment comment = drawing.createCellComment(anchor1);
                    if (f == 0 && c == 0) {
                        RichTextString str = factory.createRichTextString("ADM:\nCampo Obligatorio \n - Indicar si es es Padre (Usar SI o NO).");
                        str.applyFont(font1);
                        str.applyFont(0, 29, font);
                        comment.setString(str);
                        comment.setAuthor("ADM");
                        celda.setCellValue("Es Padre");
                        celda.setCellComment(comment);
                    }else if (f == 0 && c == 1) {
                        RichTextString str = factory.createRichTextString("ADM:\nCampo Opcional \n - Escribir la Abreviatura del campo del cual depende este.");
                        str.applyFont(font1);
                        str.applyFont(0, 29, font);
                        comment.setString(str);
                        comment.setAuthor("ADM");
                        celda.setCellValue("Abreviatura Padre");
                        celda.setCellComment(comment);
                    } else if (f == 0 && c == 2) {
                        RichTextString str = factory.createRichTextString("ADM:\nCampo Obligatorio \n - Descripcion de la multitabla");
                        str.applyFont(font1);
                        str.applyFont(0, 29, font);
                        comment.setString(str);
                        comment.setAuthor("ADM");
                        celda.setCellValue("DESCRIPCION");
                        celda.setCellComment(comment);
                    } else if (f == 0 && c == 3) {
                        RichTextString str = factory.createRichTextString("ADM:\nCampo Obligatorio \n - Abreviatura de la multitabla.");
                        str.applyFont(font1);
                        str.applyFont(0, 29, font);
                        comment.setString(str);
                        comment.setAuthor("ADM");
                        celda.setCellValue("ABREVIATURA");
                        celda.setCellComment(comment);
                    }
                }
            }
            hoja.autoSizeColumn((short) 0);
            hoja.autoSizeColumn((short) 1);
            hoja.autoSizeColumn((short) 2);
            libro.write(file);
            file.close();
            stream = new FileInputStream(new File(rutaArchivo));
            arch = new DefaultStreamedContent(stream, "application/xlsx", "FI_MULTITABLA.xlsx");
        } catch (FileNotFoundException ex) {
            System.out.println("Error al Descargar : " + ex.getMessage());
        }
        return arch;
    }

//    public StreamedContent downExcel() throws ParseException, IOException {
//        InputStream stream = null;
//        StreamedContent arch = null;
//        try {
//            String folder = "C:\\SOLUTION\\WEB\\DATOS_EXPORTACION";
//            File ruta = new File(folder);
//            if (!ruta.isDirectory()) {
//                ruta.mkdirs();
//            }
//            String rutaArchivo = folder + "\\DE_MULTITABLA.xlsx";
//            File fileXls = new File(rutaArchivo);
//            if (fileXls.exists()) {
//                fileXls.delete();
//            }
//            fileXls.createNewFile();
//
//            Workbook libro = new XSSFWorkbook();
//
//            FileOutputStream file = new FileOutputStream(fileXls);
//
//            Sheet hoja = libro.createSheet("MULTITABLA");
//            hoja = libro.getSheetAt(0);
//
//            CellStyle style = libro.createCellStyle();
//            Font font = libro.createFont();
//            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
//            font.setFontHeightInPoints((short) 8);
//            font.setFontName("Arial");
//            style.setAlignment(CellStyle.VERTICAL_CENTER);
//            style.setAlignment(CellStyle.ALIGN_CENTER);
//            style.setFont(font);
//
//            CellStyle style2 = libro.createCellStyle();
//            Font font2 = libro.createFont();
//            font2.setFontHeightInPoints((short) 8);
//            font2.setFontName("Arial");
//            style2.setFont(font2);
//
//            for (int f = 0; f <= listMultitablaTabla.size(); f++) {
//                Row fila = hoja.createRow(f);
//                for (int c = 0; c < 3; c++) {
//                    Cell celda = fila.createCell(c);
//                    if (f == 0) {
//                        celda.setCellStyle(style);
//                        if (c == 0) {
//                            celda.setCellValue("CÓDIGO");
//                        } else if (c == 1) {
//                            celda.setCellValue("DESCRIPCIÓN");
//                        } else if (c == 2) {
//                            celda.setCellValue("ESTADO");
//                        }
//                    } else {
//                        celda.setCellStyle(style2);
//                        if (c == 0) {
//                            celda.setCellValue(getListaDatos().get(f - 1).getIdcultivo());
//                        } else if (c == 1) {
//                            celda.setCellValue(getListaDatos().get(f - 1).getDescripcion());
//                        } else if (c == 2) {
//                            String terminado = "";
//                            if (getListaDatos().get(f - 1).getEstado() == 1) {
//                                terminado = "ACTIVO";
//                            } else {
//                                terminado = "ANULADO";
//                            }
//                            celda.setCellValue(terminado);
//                        }
//                    }
//                }
//            }
//            hoja.autoSizeColumn((short) 0);
//            hoja.autoSizeColumn((short) 1);
//            hoja.autoSizeColumn((short) 2);
//            libro.write(file);
//            file.close();
//            stream = new FileInputStream(new File(rutaArchivo));
//            arch = new DefaultStreamedContent(stream, "application/xlsx", "NSR_MRP_DE_CULTIVO.xlsx");
//        } catch (FileNotFoundException ex) {
//            System.out.println("Error al Obtener Datos : " + ex.getMessage());
//        }
//        return arch;
//    }
    public void upExcel(FileUploadEvent event) throws ParseException {
        try {
            upFile = event.getFile();
            XSSFWorkbook workBook = new XSSFWorkbook(event.getFile().getInputstream());
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            Iterator<Row> rowIterator = hssfSheet.rowIterator();
            boolean exist = false;
            int filaDuplicada = 0;
            boolean estado = false;
            boolean firstLinea = true;
            while (rowIterator.hasNext()) {
                Row hssfRow = rowIterator.next();
                if (firstLinea) {
                    firstLinea = false;
                } else {
                    Multitabla xls = new Multitabla();
                    hssfRow.getCell(1).setCellType(XSSFCell.CELL_TYPE_STRING);
                    xls.setDESCRIPCION(hssfRow.getCell(2).getStringCellValue());
                    xls.setABREV(hssfRow.getCell(3).getStringCellValue());
                    xls.setEMPRESA(Integer.valueOf(idempresa));
                    xls.setESTADO(true);
                    if (hssfRow.getCell(1) != null  && hssfRow.getCell(0).getStringCellValue().equalsIgnoreCase("Si")) {
                        xls.setPalias(hssfRow.getCell(1).getStringCellValue());
                        listDetalleMultitablaTablaUp.add(xls);
                    } else {
                        listMultitablaTablaUp.add(xls);
                    }
                    exist = false;
                    for (int i = 0; i < listMultitablaTablaUp.size() - 1; i++) {
                        if (listMultitablaTablaUp.get(i).getDESCRIPCION().equalsIgnoreCase(hssfRow.getCell(2).getStringCellValue()) && hssfRow.getRowNum() > 1) {
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        filaDuplicada = hssfRow.getRowNum() + 1;
                        break;
                    }
                }
            }
            if (exist) {
                WebUtil.MensajeAlerta("Registro Duplicado. Fila : " + filaDuplicada + ". \n Verifique el Excel e Inténtelo otra vez.");
                listMultitablaTablaUp.clear();
            }
        } catch (IOException e) {
            System.out.println("Error en el Procesamiento : " + e.getMessage());
        }
    }

    public void saveExcel() throws IOException, Exception {
        try {
            if (listMultitablaTablaUp.size() > 0) {
                for (Multitabla mul : listMultitablaTablaUp) {
                    int k = 1;
                    IDVALOR = multitablaService.addMultitabla(mul);
                    List<Multitabla> temp = new ArrayList<Multitabla>();
                    for (Multitabla dmul : listDetalleMultitablaTablaUp) {
                        if (dmul.getPalias() != null) {
                            if (mul.getABREV().equalsIgnoreCase(dmul.getPalias())) {
                                dmul.setDEP_ID(IDVALOR);
                                dmul.setVALOR(""+String.valueOf(k));
                                temp.add(dmul);
                                k++;
                            }
                        }
                        
                    }
                    multitablaService.addXmlMultitabla(idempresa, Integer.parseInt(IDVALOR), cadenaDetalleMultitablaXmlExcel(temp));
                }
                WebUtil.MensajeAlerta("Registros Importados con Éxito");
                listMultitablaTablaUp.clear();
            } else {
                WebUtil.MensajeAlerta("No hay elementos para importar. Intentelo otra vez.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @return the idempresa
     */
    public String getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the multitablaService
     */
    public MultitablaService getMultitablaService() {
        return multitablaService;
    }

    /**
     * @param multitablaService the multitablaService to set
     */
    public void setMultitablaService(MultitablaService multitablaService) {
        this.multitablaService = multitablaService;
    }

    /**
     * @return the selectMultitablaTabla
     */
    public Multitabla getSelectMultitablaTabla() {
        return selectMultitablaTabla;
    }

    /**
     * @param selectMultitablaTabla the selectMultitablaTabla to set
     */
    public void setSelectMultitablaTabla(Multitabla selectMultitablaTabla) {
        this.selectMultitablaTabla = selectMultitablaTabla;
    }

    /**
     * @return the listMultitablaTabla
     */
    public List<Multitabla> getListMultitablaTabla() {
        return listMultitablaTabla;
    }

    /**
     * @param listMultitablaTabla the listMultitablaTabla to set
     */
    public void setListMultitablaTabla(List<Multitabla> listMultitablaTabla) {
        this.listMultitablaTabla = listMultitablaTabla;
    }

    /**
     * @return the botonEditarTabla
     */
    public boolean isBotonEditarTabla() {
        return botonEditarTabla;
    }

    /**
     * @param botonEditarTabla the botonEditarTabla to set
     */
    public void setBotonEditarTabla(boolean botonEditarTabla) {
        this.botonEditarTabla = botonEditarTabla;
    }

    /**
     * @return the botonEliminarTabla
     */
    public boolean isBotonEliminarTabla() {
        return botonEliminarTabla;
    }

    /**
     * @param botonEliminarTabla the botonEliminarTabla to set
     */
    public void setBotonEliminarTabla(boolean botonEliminarTabla) {
        this.botonEliminarTabla = botonEliminarTabla;
    }

    /**
     * @return the filtroMultitablaTabla
     */

    /**
     * @return the variableMultitabla
     */
    public Multitabla getVariableMultitabla() {
        return variableMultitabla;
    }

    /**
     * @param variableMultitabla the variableMultitabla to set
     */
    public void setVariableMultitabla(Multitabla variableMultitabla) {
        this.variableMultitabla = variableMultitabla;
    }

    /**
     * @return the botonNuevoDetalleTabla
     */
    public boolean isBotonNuevoDetalleTabla() {
        return botonNuevoDetalleTabla;
    }

    /**
     * @param botonNuevoDetalleTabla the botonNuevoDetalleTabla to set
     */
    public void setBotonNuevoDetalleTabla(boolean botonNuevoDetalleTabla) {
        this.botonNuevoDetalleTabla = botonNuevoDetalleTabla;
    }

    /**
     * @return the botonEliminarDetalleTabla
     */
    public boolean isBotonEliminarDetalleTabla() {
        return botonEliminarDetalleTabla;
    }

    /**
     * @param botonEliminarDetalleTabla the botonEliminarDetalleTabla to set
     */
    public void setBotonEliminarDetalleTabla(boolean botonEliminarDetalleTabla) {
        this.botonEliminarDetalleTabla = botonEliminarDetalleTabla;
    }

    /**
     * @return the variableDetalleMultitabla
     */
    public Multitabla getVariableDetalleMultitabla() {
        return variableDetalleMultitabla;
    }

    /**
     * @param variableDetalleMultitabla the variableDetalleMultitabla to set
     */
    public void setVariableDetalleMultitabla(Multitabla variableDetalleMultitabla) {
        this.variableDetalleMultitabla = variableDetalleMultitabla;
    }

    /**
     * @return the listDetalleMultitablaTabla
     */
    public List<Multitabla> getListDetalleMultitablaTabla() {
        return listDetalleMultitablaTabla;
    }

    /**
     * @param listDetalleMultitablaTabla the listDetalleMultitablaTabla to set
     */
    public void setListDetalleMultitablaTabla(List<Multitabla> listDetalleMultitablaTabla) {
        this.listDetalleMultitablaTabla = listDetalleMultitablaTabla;
    }

    /**
     * @return the selectDetalleMultitablaTabla
     */
    public Multitabla getSelectDetalleMultitablaTabla() {
        return selectDetalleMultitablaTabla;
    }

    /**
     * @param selectDetalleMultitablaTabla the selectDetalleMultitablaTabla to
     * set
     */
    public void setSelectDetalleMultitablaTabla(Multitabla selectDetalleMultitablaTabla) {
        this.selectDetalleMultitablaTabla = selectDetalleMultitablaTabla;
    }

    /**
     * @return the filtroDetalleMultitablaTabla
     */
    public List<Multitabla> getFiltroDetalleMultitablaTabla() {
        return filtroDetalleMultitablaTabla;
    }

    /**
     * @param filtroDetalleMultitablaTabla the filtroDetalleMultitablaTabla to
     * set
     */
    public void setFiltroDetalleMultitablaTabla(List<Multitabla> filtroDetalleMultitablaTabla) {
        this.filtroDetalleMultitablaTabla = filtroDetalleMultitablaTabla;
    }

    /**
     * @return the IDVALOR
     */
    public String getIDVALOR() {
        return IDVALOR;
    }

    /**
     * @param IDVALOR the IDVALOR to set
     */
    public void setIDVALOR(String IDVALOR) {
        this.IDVALOR = IDVALOR;
    }

    public List<Multitabla> getListMultitablaTablaUp() {
        return listMultitablaTablaUp;
    }

    public void setListMultitablaTablaUp(List<Multitabla> listMultitablaTablaUp) {
        this.listMultitablaTablaUp = listMultitablaTablaUp;
    }

    public List<Multitabla> getListDetalleMultitablaTablaUp() {
        return listDetalleMultitablaTablaUp;
    }

    public void setListDetalleMultitablaTablaUp(List<Multitabla> listDetalleMultitablaTablaUp) {
        this.listDetalleMultitablaTablaUp = listDetalleMultitablaTablaUp;
    }

    public UploadedFile getUpFile() {
        return upFile;
    }

    public void setUpFile(UploadedFile upFile) {
        this.upFile = upFile;
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
