/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.view.JasperViewer;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 * @param <T>
 */
public abstract class AbstactListAction<T> {

    private String NombreReporte;
    private String NombreArchivo;
    private static Map<String, Object> ParamsReport;
    private String tituloHead;
    private String lst_name;
    private String edt_name;
    private List<T> listaDatos;
    private List<T> filtroDatos;
    private T datoSeleccionado;
    private T datoEdicion;
    private boolean lvalidate;
    private int ladd;
    private String opc_anular_eliminar;
    private String pagina;
    private int aedtiar;
    private int anuevo;
    private int agrabar;
    private int aanular;
    private int aeliminar;
    private int acerrar;
    private int aaprobar;
    /*FILTRO*/
    private Date desde;
    private Date hasta;
    /*ESTADOS*/
    /*
        (0)VISTA
        (1)NUEVO
        (2)EDICION
    */
    protected static Map<String, Object> modalOptions;
    protected static Map<String, Object> modalGoogleMapOptions;
    protected static Map<String, Object> modalParamsOptions;
    static {
        modalOptions = new HashMap<String, Object>();
        modalOptions.put("modal", true);
        modalOptions.put("draggable", true);
        modalOptions.put("resizable", false);
        modalOptions.put("contentHeight", 400);
        /************************************************************/
        modalParamsOptions = new HashMap<String, Object>();
        modalParamsOptions.put("modal", true);
        modalParamsOptions.put("draggable", true);
        modalParamsOptions.put("resizable", false);
        modalParamsOptions.put("contentHeight", 400);
        modalParamsOptions.put("includeViewParams", true);
        /************************************************************/
        modalGoogleMapOptions = new HashMap<String, Object>();
        modalGoogleMapOptions.put("modal", true);
        modalGoogleMapOptions.put("draggable", true);
        modalGoogleMapOptions.put("resizable", false);
        modalGoogleMapOptions.put("contentHeight", 550);
        modalGoogleMapOptions.put("includeViewParams", true);
        /*************************************************************/
        ParamsReport = new HashMap<>();
    }
    public void lista_accion_filtro(String form){
        try {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            this.lst_name = form;
            ctx.redirect(ctxPath + "/sistema/" + lst_name + ".xhtml");
        } catch (Exception ex) {
            Logger.getLogger(AbstactListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualiza_ventana(String form_edicion) {
        try {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            this.lst_name = "wLst_".concat(form_edicion.substring(5));
            this.tituloHead = (new menuDao()).buscar_Titulo(form_edicion.substring(5));
            this.edt_name = form_edicion;
            listaDatos = new ArrayList<T>();
            filtroDatos = new ArrayList<T>();
            if (!initacceso(lst_name)) {
                ctx.redirect(ctxPath + "/sistema/principal.xhtml");
            }
        } catch (Exception ex) {
            Logger.getLogger(AbstactListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pag_acceso(String form) throws IOException {
        boolean access = false;
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        for (String[] a : ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getAccess()) {
            if(a[0]!=null){
                String page = a[0].replace(".xhtml", "").trim().substring(5);
                if (page.equalsIgnoreCase(form.substring(5))) {
                    access = true;
                    this.aedtiar=Integer.parseInt(a[1]);
                    this.anuevo=Integer.parseInt(a[2]);
                    this.agrabar=Integer.parseInt(a[3]);
                    this.aanular=Integer.parseInt(a[4]);
                    this.aeliminar=Integer.parseInt(a[5]);
                    this.setAcerrar(Integer.parseInt(a[6]));
                    this.aaprobar=Integer.parseInt(a[7]);
                }
            }
        }
        if (access == true) {
            if((form.startsWith("wMnt_")|| form.startsWith("edt_"))){
                ctx.redirect(ctxPath + "/sistema/" + form + ".xhtml");
            }else{
                 ctx.redirect(ctxPath + "/sistema/" + lst_name + ".xhtml");
                 /************************************************/
            }
        } else {
            ctx.redirect(ctxPath + "/sistema/principal.xhtml");
        }

    }
    public boolean initacceso(String form) throws IOException {
        boolean access = false;
        for (String[] a : ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getAccess()) {            
            if(a[0]!=null){
                String page = a[0].replace(".xhtml", "").trim().substring(5);
                if (page.equalsIgnoreCase(form.substring(5))) {
                    access = true;
                    this.aedtiar=Integer.parseInt(a[1]);
                    this.anuevo=Integer.parseInt(a[2]);
                    this.agrabar=Integer.parseInt(a[3]);
                    this.aanular=Integer.parseInt(a[4]);
                    this.aeliminar=Integer.parseInt(a[5]);
                    this.acerrar=Integer.parseInt(a[6]);
                    this.aaprobar=Integer.parseInt(a[7]);
                }
            }
        }
        /********************* FECHA ********************/
        desde=new Date();
        hasta=new Date();
        doVerFiltro(1);
        return access;
    }
    public void doVerFiltro(int tipo) throws IOException {
        buscarFiltro(tipo);
        if(tipo == 2)
            this.ladd = 0;
    }
    
    public void doNuevo() throws IOException {
        nuevo();
        pag_acceso(this.edt_name);
        this.ladd = 1;
    }
    /*** CONFIGURACIÓN ****/
    public void doGrabar() {
        grabar();
        if(this.lvalidate)
            this.ladd = 0;
    }
    public boolean isEdicion() {
        return this.ladd >= 1;
    }
    public void doEditar() {
        this.ladd = 2;
    }
    public void doEditar_lista() throws IOException {
        if (this.datoSeleccionado == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            this.datoEdicion = this.datoSeleccionado;
            pag_acceso(this.edt_name);
            this.ladd = 2;
        }
    }
    public void opcionEliminarDocumento(String opcion, String pagina) {
        setOpc_anular_eliminar(opcion);
        setPagina(pagina);
        setDatoEdicion(getDatoSeleccionado());
        if (pagina.equalsIgnoreCase("LST")) {
            if (getDatoSeleccionado() == null) {
                WebUtil.MensajeAdvertencia("Debe seleccionar Registro.");
//            } else if (getDatoSeleccionado().getEstado()==0 && getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                WebUtil.MensajeAdvertencia("Registro tiene estado de ANULADO.");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogeliminar').show()");
            }
        }

        if (pagina.equalsIgnoreCase("MNT")) {
            if (getDatoEdicion()== null) {
                WebUtil.MensajeAdvertencia("No puede eliminar");
//            } else if (getDatoEdicion().getEstado()==0 && getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                WebUtil.MensajeAdvertencia("Registro tiene estado de ANULADO.");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogeliminar').show()");
            }
        }
    }
    public void doVerLista() throws IOException {
        nuevo();
        pag_acceso(this.lst_name);
        this.ladd = 1;
    }
    public void doCancelar() {
        this.ladd = 0;
    }
    public void doCerrar(){
        cerrar();
        this.ladd = 0;
    }
    public void doAprobar(){
        aprobar();
        this.ladd = 0;
    }
    public boolean isBarraVista() {
        return this.ladd == 0;
    }
    
    public abstract String buscarFiltro(int tipo);
    
    public abstract void buscarTodo();

    public abstract String getIniciar();
    
    public abstract void nuevo();
    
    public abstract void grabar();

    public abstract void eliminar();
    
    public abstract void cerrar();
    
    public abstract void aprobar();
    
    public abstract  JRDataSource getDataSourceReport();
    
    public abstract  JRDataSource getDataSourceReport_lst();
    /*CONFIGURACIÓN REPORTE*/
    public JasperPrint getPrintReport() {

        String reporte = Constantes.FORMATO_REPORTE + File.separator + getNombreReporte() + ".jrxml";
        String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + getNombreReporte() + ".jasper";
        try {
            File f = new File(reporte_compilado);
            if (!f.isFile()) {
                JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
            }
            // final JasperReport report =
            // JasperCompileManager.compileReport(reporte);
            getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, getParamsReport(),
                            getDataSourceReport());
            jasperPrint.setName(getNombreArchivo());
            return jasperPrint;
        } catch (Exception e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(Inicio.mainF, "No se pudo abrir el archivo: " + reporte);
                return null;
        }
    }
    
    public JasperPrint getPrintReport_list() {

        String reporte = Constantes.FORMATO_REPORTE + File.separator + getNombreReporte() + ".jrxml";
        String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + getNombreReporte() + ".jasper";
        try {
            File f = new File(reporte_compilado);
            if (!f.isFile()) {
                JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
            }
            // final JasperReport report =
            // JasperCompileManager.compileReport(reporte);
            getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, getParamsReport(),
                            getDataSourceReport_lst());
            jasperPrint.setName(getNombreArchivo());
            return jasperPrint;
        } catch (Exception e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(Inicio.mainF, "No se pudo abrir el archivo: " + reporte);
                return null;
        }
    }
    
    public String getLst_name() {
        return lst_name;
    }

    public void setLst_name(String lst_name) {
        this.lst_name = lst_name;
    }

    public String getEdt_name() {
        return edt_name;
    }

    public void setEdt_name(String edt_name) {
        this.edt_name = edt_name;
    }

    public List<T> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<T> listaDatos) {
        this.listaDatos = listaDatos;
        this.filtroDatos = listaDatos;
    }

    public T getDatoSeleccionado() {
        return datoSeleccionado;
    }

    public void setDatoSeleccionado(T datoSeleccionado) {
        this.datoSeleccionado = datoSeleccionado;
    }

    public T getDatoEdicion() {
        return datoEdicion;
    }

    public void setDatoEdicion(T datoEdicion) {
        this.datoEdicion = datoEdicion;
    }

    public int getLadd() {
        return ladd;
    }

    public void setLadd(int ladd) {
        this.ladd = ladd;
    }

    public int getAedtiar() {
        return aedtiar;
    }

    public void setAedtiar(int aedtiar) {
        this.aedtiar = aedtiar;
    }

    public int getAgrabar() {
        return agrabar;
    }

    public void setAgrabar(int agrabar) {
        this.agrabar = agrabar;
    }

    public int getAanular() {
        return aanular;
    }

    public void setAanular(int aanular) {
        this.aanular = aanular;
    }

    public int getAeliminar() {
        return aeliminar;
    }

    public void setAeliminar(int aeliminar) {
        this.aeliminar = aeliminar;
    }

    public String getOpc_anular_eliminar() {
        return opc_anular_eliminar;
    }

    public void setOpc_anular_eliminar(String opc_anular_eliminar) {
        this.opc_anular_eliminar = opc_anular_eliminar;
    }

    public int getAnuevo() {
        return anuevo;
    }

    public void setAnuevo(int anuevo) {
        this.anuevo = anuevo;
    }

    public String getTituloHead() {
        return tituloHead;
    }

    public void setTituloHead(String tituloHead) {
        this.tituloHead = tituloHead;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }     

    public List<T> getFiltroDatos() {
        return filtroDatos;
    }

    public void setFiltroDatos(List<T> filtroDatos) {
        this.filtroDatos = filtroDatos;
    }

    /**
     * @return the desde
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * @param desde the desde to set
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     * @return the hasta
     */
    public Date getHasta() {
        return hasta;
    }

    /**
     * @param hasta the hasta to set
     */
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }
    /**
     * @return the acerrar
     */
    public int getAcerrar() {
        return acerrar;
    }

    /**
     * @param acerrar the acerrar to set
     */
    public void setAcerrar(int acerrar) {
        this.acerrar = acerrar;
    }

    /**
     * @return the NombreReporte
     */
    public String getNombreReporte() {
        return NombreReporte;
    }

    /**
     * @param NombreReporte the NombreReporte to set
     */
    public void setNombreReporte(String NombreReporte) {
        this.NombreReporte = NombreReporte;
    }

    /**
     * @return the NombreArchivo
     */
    public String getNombreArchivo() {
        return NombreArchivo;
    }

    /**
     * @param NombreArchivo the NombreArchivo to set
     */
    public void setNombreArchivo(String NombreArchivo) {
        this.NombreArchivo = NombreArchivo;
    }

    /**
     * @return the ParamsReport
     */
    public Map<String, Object> getParamsReport() {
        return ParamsReport;
    }

    /**
     * @param ParamsReport the ParamsReport to set
     */
    public void setParamsReport(Map<String, Object> ParamsReport) {
        this.ParamsReport = ParamsReport;
    }
    /***************** REPORTE ******************/
    //PARA IMPRIMIR
    public void doImprimir() {
        JasperPrint print = getPrintReport();
        if (print != null) {
            try {
                JasperPrintManager.printReport(print, true);
            } catch (JRException e) {
                    e.printStackTrace();
            }
        }
    }
	
    //PARA VISTA PREVIA
//    @Override
//    public void doPrevio() {
//            esperarProceso();
//
//            JasperPrint print = getPrintReport();
//
//            if (print != null) {
//                    JasperViewer jv = new JasperViewer(print, false);
//                    jv.setTitle("Vista Previa de " + getNombreArchivo());
//                    jv.setIconImage(new ImageIcon(AbstractDocForm.class.getResource("/resources/nisiralogo.png")).getImage());
//                    jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    jv.setVisible(true);
//            }
//    }

//    //EXPORTAR
//
    // A WORD
//    public void doExportaWord() {
//
//            JasperPrint print = getPrintReport();
//
//            File file = getPathSaveFile(".docx", "docx");
//
//            if (print != null) {
//                    // File doc = new File(getExportar() + ".docx");
//
//                JRDocxExporter exporter = new JRDocxExporter();
//                exporter.setExporterInput(new SimpleExporterInput(print));
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
//                try {
//                        exporter.exportReport();
//                } catch (JRException e) {
//                        e.printStackTrace();
//                }
//            }
//    };
//	
//    // A ODS
//    public void doExportaOds() {
//        JasperPrint print = getPrintReport();
//        File file = getPathSaveFile(".ods", "ods");
//        if (print != null && file != null) {
//                // File doc = new File(getExportar() + ".ods");
//
//                JROdsExporter exporter = new JROdsExporter();
//                exporter.setExporterInput(new SimpleExporterInput(print));
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
//                try {
//                        exporter.exportReport();
//                } catch (JRException e) {
//                        e.printStackTrace();
//                }
//        }
//    };
//
//    // A ODT
//    public void doExportaOdt() {
//
//        JasperPrint print = getPrintReport();
//
//        // File doc = new File(getExportar() + ".odt");
//        File file = getPathSaveFile(".odt", "odt");
//
//        if (print != null && file != null) {
//
//                JROdtExporter exporter = new JROdtExporter();
//                exporter.setExporterInput(new SimpleExporterInput(print));
//                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file.getAbsolutePath()));
//                try {
//                        exporter.exportReport();
//                } catch (JRException e) {
//                        e.printStackTrace();
//                }
//        }
//    };
//	
//    //A PDF
//    public void doExportaPDF() {
//
//        File file = getPathSaveFile(".pdf", "pdf");
//
//        JasperPrint print = getPrintReport();
//
//        if (print != null && file != null) {
//                // final String target = getExportar() + ".pdf";
//                try {
//                        JasperExportManager.exportReportToPdfFile(print, file.getAbsolutePath());
//                } catch (JRException e) {
//                        e.printStackTrace();
//                }
//        }
//    };
//	
//    // A EXCEL
//    public void doExportaExcel() {
//
//        File file = getPathSaveFile(".xlsx", "xlsx");
//        if (file != null) {
//                JasperPrint print = getPrintReport();
//
//                if (print != null) {
//
//                        JRXlsxExporter exporter = new JRXlsxExporter();
//                        exporter.setExporterInput(new SimpleExporterInput(print));
//                        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
//                        try {
//                                exporter.exportReport();
//                        } catch (JRException e) {
//                                e.printStackTrace();
//                        }
//                }
//        }
//    };
    /*
    ESTE METODO LO USO PARA QUE ELIJA UNA RUTA DEL ARCHIVO
    CON MENSAJE PARA REEMPLAZAR, SI ES WEB DEBERÍAS DARLE UNA
    RUTA POR DEFECTO, Y LUEGO DESCARGAR EL ARCHIVO
    */
//    private File getPathSaveFile(String ext, String dsc_ext) {
//        FileNameExtensionFilter filtro = new FileNameExtensionFilter(ext, dsc_ext);
//
//        JFileChooser chooser = new JFileChooser();
//        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
//
//        chooser.setSelectedFile(new File(getNombreArchivo() + ext));
//        chooser.setFileFilter(filtro);
//
//        String destinationFileName;
//        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//            boolean doExport = true;
//
//            boolean overrideExistingFile = false;
//
//            File destinationFile = new File(chooser.getSelectedFile().getAbsolutePath());
//
//            destinationFileName = destinationFile.getAbsolutePath();
//
//            if (!destinationFileName.endsWith(ext)) {
//                    destinationFile = new File(destinationFileName + ext);
//            }
//            while (doExport && destinationFile.exists() && !overrideExistingFile) {
//
//                overrideExistingFile = (UtilMensajes.mensaje_sino("REEMPLAZAR_ARCHIVO") == 0);
//
//                if (!overrideExistingFile) {
//                        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
//                                destinationFile = new File(chooser.getSelectedFile().getAbsolutePath());
//                                destinationFileName = destinationFile.getAbsolutePath();
//                                if (!destinationFileName.endsWith(ext)) {
//                                        destinationFile = new File(destinationFileName + ext);
//                                }
//                        } else {
//                                doExport = false;
//                        }
//                }
//            }
//
//            if (doExport) {
//                    return destinationFile;
//            }
//    }
//    return null;
//
//    }

    /**
     * @return the lvalidate
     */
    public boolean isLvalidate() {
        return lvalidate;
    }

    /**
     * @param lvalidate the lvalidate to set
     */
    public void setLvalidate(boolean lvalidate) {
        this.lvalidate = lvalidate;
    }

    /**
     * @return the aaprobar
     */
    public int getAaprobar() {
        return aaprobar;
    }

    /**
     * @param aaprobar the aaprobar to set
     */
    public void setAaprobar(int aaprobar) {
        this.aaprobar = aaprobar;
    }
}
