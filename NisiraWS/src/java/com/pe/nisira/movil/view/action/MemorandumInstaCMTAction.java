/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ConfigsmtpDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Memorandum_instalacion_pssDao;
import com.nisira.core.entity.Atendido;
import com.nisira.core.entity.Configsmtp;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.DetalleMemorandum;
import com.nisira.core.entity.Memorandum_instalacion_pss;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.EnviarDocumentos;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author alejndro zamora
 */
@ManagedBean(name = "memorandumInstaCMTAction")
@SessionScoped
public class MemorandumInstaCMTAction extends AbstactListAction<Memorandum_instalacion_pss> implements Serializable {

    private String mensaje;
    private Cotizacionventas slcCoti;
    private List<Dcotizacionventas> lstDcot;
    private Memorandum_instalacion_pss slcpdfmemo;
    private Memorandum_instalacion_pssDao memoDao;
    private CotizacionventasDao cotDao;
    private DcotizacionventasDao dcotDao;
    private List<Atendido> lstAtencion;
    private Atendido slcAtencion;
    private List<DetalleMemorandum> lstdetMemo;
    private DetalleMemorandum slcMemo;
    public UsuarioBean user;
    private String rutapdf;
    private String filename;

    public MemorandumInstaCMTAction() {
        mensaje = "";
        slcCoti = new Cotizacionventas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lstDcot = new ArrayList<Dcotizacionventas>();
        slcpdfmemo = new Memorandum_instalacion_pss();
        memoDao = new Memorandum_instalacion_pssDao();
        cotDao = new CotizacionventasDao();
        dcotDao = new DcotizacionventasDao();
        lstAtencion = new ArrayList<Atendido>();
        slcAtencion = new Atendido();
        lstdetMemo = new ArrayList<DetalleMemorandum>();
        slcMemo = new DetalleMemorandum();
        rutapdf = "";
        filename = "";
        actualiza_ventana("wMnt_Memorandum_Install_CMT");
    }

    @Override
    public String buscarFiltro(int tipo) {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(memoDao.lstMemorandum(user.getIDEMPRESA(), "002",f_ini,f_fin));
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Memorandum_Install_CMT");
        return "";
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(memoDao.lstMemorandum(user.getIDEMPRESA(), "002",f_ini,f_fin));
            //   filtrar();
            RequestContext.getCurrentInstance().update("datos");
//            RequestContext.getCurrentInstance().execute("javascript:location.reload()");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        slcCoti = new Cotizacionventas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        slcpdfmemo = new Memorandum_instalacion_pss();
        lstDcot = new ArrayList<Dcotizacionventas>();
        memoDao = new Memorandum_instalacion_pssDao();
        cotDao = new CotizacionventasDao();
        dcotDao = new DcotizacionventasDao();
        lstAtencion = new ArrayList<Atendido>();
        slcAtencion = new Atendido();
        lstdetMemo = new ArrayList<DetalleMemorandum>();
        slcMemo = new DetalleMemorandum();
        rutapdf = "";
        filename = "";
        actualiza_ventana("wMnt_Memorandum_Install_CMT");
        return "";
    }

    public void addAtendidoRow() {
        Atendido ne = new Atendido();
        ne.setItem(lstAtencion.size() + 1);
        ne.setFechaRepo(null);
        lstAtencion.add(ne);
        setMensaje("Se Agrego Fila");
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:lstAten");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void delAtendidoRow() {
        if (slcAtencion != null) {
            lstAtencion.remove(slcAtencion);
            int i = 1;
            for (Atendido a : lstAtencion) {
                a.setItem(i);
                i++;
            }
        } else {
            setMensaje("Seleccione un detalle de Atencion");
            WebUtil.MensajeAdvertencia(getMensaje());
        }

        RequestContext.getCurrentInstance().update("datos:lstAten");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void addReqRow() {
        DetalleMemorandum ne = new DetalleMemorandum();
        ne.setItem(lstdetMemo.size() + 1);
        ne.setFechaRepo(null);
        ne.setCantidad(0);
        lstdetMemo.add(ne);
        setMensaje("Se Agrego Fila");
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:lstDetDemo");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void delReqRow() {
        if (slcMemo != null) {
            lstdetMemo.remove(slcMemo);
            int i = 1;
            for (DetalleMemorandum a : lstdetMemo) {
                a.setItem(i);
                i++;
            }
        } else {
            setMensaje("Seleccione un detalle de Atencion");
            WebUtil.MensajeAdvertencia(getMensaje());
        }

        RequestContext.getCurrentInstance().update("datos:lstDetDemo");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void verCntCotizacionVenta() {
        CntCotizacionVentasAction.idtiposervicio = "002";
        RequestContext.getCurrentInstance().openDialog("cntCotizacionVentas", modalOptions, null);
    }

    public void valorCotizacionVenta(SelectEvent event) {
        try {
            slcCoti = (Cotizacionventas) event.getObject();
            if (memoDao.validaMemo(slcCoti.getIdcotizacionv())) {
                lstDcot = dcotDao.getListDCotizacionWeb(user.getIDEMPRESA(), slcCoti.getIdcotizacionv());
                getDatoEdicion().setIdcotizacionv(slcCoti.getIdcotizacionv());
                getDatoEdicion().setFecha_inst(slcCoti.getFecha());
                getDatoEdicion().setCondiciones_comerciales(slcCoti.getFormapago());
                getDatoEdicion().setContacto(slcCoti.getContacto());
                getDatoEdicion().setEmail(slcCoti.getContacto_email());
                getDatoEdicion().setTelefono(slcCoti.getTelefono());
                RequestContext.getCurrentInstance().update("datos");
            } else {
                setMensaje("Esta Cotizacion ya ha sido Utilizda.");
                WebUtil.MensajeAdvertencia(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(MemorandumInstaCMTAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Memorandum_instalacion_pss());
        slcCoti = new Cotizacionventas();
        lstDcot = new ArrayList<Dcotizacionventas>();
        lstAtencion = new ArrayList<Atendido>();
        slcAtencion = new Atendido();
        lstdetMemo = new ArrayList<DetalleMemorandum>();
        slcMemo = new DetalleMemorandum();
        getDatoEdicion().setIdemrpesa(user.getIDEMPRESA());
        getDatoEdicion().setIdusuario(user.getIDUSUARIO());
    }

    public void findDetaller() throws NisiraORMException {
        if (getDatoEdicion().getIdcotizacionv() != null) {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<Atendido>>() {
            }.getType();
            lstAtencion = gson.fromJson(getDatoEdicion().getTabla_atendido(), collectionType);
            Type collectionType2 = new TypeToken<List<DetalleMemorandum>>() {
            }.getType();
            getDatoEdicion().setHoraInsta(WebUtil.convertDecimalTime(getDatoEdicion().getHora_inst()));
            lstdetMemo = gson.fromJson(getDatoEdicion().getTabla_requerimiento(), collectionType2);
            slcCoti = (new CotizacionventasDao()).findCotizacion(user.getIDEMPRESA(), getDatoEdicion().getIdcotizacionv());
            lstDcot = dcotDao.getListDCotizacionWeb(user.getIDEMPRESA(), slcCoti.getIdcotizacionv());
        }
    }

    public void envioCorreo() {
        try {
            if (getDatoEdicion().getIdcotizacionv() != null) {
                List<Configsmtp> lstConfigsmtp = (new ConfigsmtpDao()).listarPorEmpresaWeb();
                if (!lstConfigsmtp.isEmpty()) {
                    /**
                     * ****************** CREAR REPORTE ***********************
                     */
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext ext = context.getExternalContext();
                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("memo", getDatoEdicion());
                    params.put("cotventa", slcCoti);
                    JRDataSource atendido = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstAtencion);
                    JRDataSource detcot = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstDcot);
                    params.put("atendido", atendido);
                    params.put("detcot", detcot);
                    JRDataSource datasource = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstdetMemo);
                    String reporte = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jrxml";
                    String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jasper";
                    File f = new File(reporte_compilado);
                    if (!f.isFile()) {
                        JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
                    }
                    getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, params, datasource);
                    jasperPrint.setName("MEMO_" + getDatoEdicion().getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                            + slcCoti.getRazon_social().trim());

                    HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
                    resp.setContentType("application/pdf");

                    
                    filename = "MEMO_" + getDatoEdicion().getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                            + slcCoti.getRazon_social().trim()
                            + ".pdf";
                    /*RUTA*/
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);

                    Constantes.configsmtp = lstConfigsmtp.get(0);
                    /* *********    ENVIAR CORREO  ********* */
                    File file = new File(rutapdf);

                    EnviarDocumentos enviarDocumentos = new EnviarDocumentos();
                    enviarDocumentos.enviarcorreoMemo(slcCoti.getContacto_email(), file,
                            slcCoti.getIddocumento() + slcCoti.getSerie() + "-" + slcCoti.getNumero(),
                            slcCoti.getRazon_social(), filename);

                    mensaje = "Envio de mensaje exitoso";
                    WebUtil.info(mensaje);

                } else {
                    mensaje = "Envio de mensaje no configurado";
                    WebUtil.error(mensaje);
                }
            } else {
                mensaje = "Documento no creado";
                WebUtil.MensajeAdvertencia(mensaje);
            }

        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    public void envioCorreo_listado() {
        try {
            if (slcpdfmemo != null) {
                if (slcpdfmemo.getIdcotizacionv() != null) {
                    List<Configsmtp> lstConfigsmtp = (new ConfigsmtpDao()).listarPorEmpresaWeb();
                    if (!lstConfigsmtp.isEmpty()) {
                        Constantes.configsmtp = lstConfigsmtp.get(0);
                        /* *********    ENVIAR CORREO  ********* */
                        File file = new File(rutapdf);
                        SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                        String filename = "MEMO_" + slcpdfmemo.getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                                + slcpdfmemo.getRazon_social().trim()
                                + ".pdf";
                        EnviarDocumentos enviarDocumentos = new EnviarDocumentos();
                        enviarDocumentos.enviarcorreoMemo(slcCoti.getContacto_email(), file,
                                slcCoti.getIddocumento() + slcCoti.getSerie() + "-" + slcCoti.getNumero(),
                                slcCoti.getRazon_social(), filename);
                        mensaje = "Envio de mensaje exitoso";
                        WebUtil.info(mensaje);
                    } else {
                        mensaje = "Envio de mensaje no configurado";
                        WebUtil.error(mensaje);
                    }
                }
            } else {
                mensaje = "Documento no creado";
                WebUtil.MensajeAdvertencia(mensaje);
            }

        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    public void envioCorreo_open() {
        /**
         * ****************** CREAR REPORTE ***********************
         */
        try {
            if (slcpdfmemo != null) {
                if (slcpdfmemo.getIdcotizacionv() != null) {
                    Gson gson = new Gson();
                    Type collectionType = new TypeToken<List<Atendido>>() {
                    }.getType();
                    lstAtencion = gson.fromJson(slcpdfmemo.getTabla_atendido(), collectionType);
                    Type collectionType2 = new TypeToken<List<DetalleMemorandum>>() {
                    }.getType();
                    slcpdfmemo.setHoraInsta(WebUtil.convertDecimalTime(slcpdfmemo.getHora_inst()));
                    lstdetMemo = gson.fromJson(slcpdfmemo.getTabla_requerimiento(), collectionType2);
                    slcCoti = (new CotizacionventasDao()).findCotizacion(user.getIDEMPRESA(), slcpdfmemo.getIdcotizacionv());
                    lstDcot = dcotDao.getListDCotizacionWeb(user.getIDEMPRESA(), slcCoti.getIdcotizacionv());

                    Map<String, Object> params = new HashMap<String, Object>();
                    params.put("memo", slcpdfmemo);
                    params.put("cotventa", slcCoti);
                    JRDataSource atendido = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstAtencion);
                    JRDataSource detcot = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstDcot);
                    params.put("atendido", atendido);
                    params.put("detcot", detcot);
                    JRDataSource datasource = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstdetMemo);
                    String reporte = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jrxml";
                    String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jasper";
                    File f = new File(reporte_compilado);
                    if (!f.isFile()) {
                        JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
                    }
                    getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, params, datasource);
                    jasperPrint.setName("MEMO_" + slcpdfmemo.getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                            + slcpdfmemo.getRazon_social().trim());

                    
                    filename = "MEMO_" + slcpdfmemo.getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                            + slcpdfmemo.getRazon_social().trim()
                            + ".pdf";
                    /*RUTA*/
                    rutapdf = Constantes.ARCHIVO_REPORTE + File.separator + filename;
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
                    RequestContext.getCurrentInstance().execute("PF('dlg_envio').show()");
                } else {
                    mensaje = "Documento no creado";
                    WebUtil.MensajeAdvertencia(mensaje);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            mensaje = WebUtil.mensajeError();
            WebUtil.MensajeError(mensaje);
        }

    }

    public void PDF_Downloadd() {
        try {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<Atendido>>() {
            }.getType();
            lstAtencion = gson.fromJson(slcpdfmemo.getTabla_atendido(), collectionType);
            Type collectionType2 = new TypeToken<List<DetalleMemorandum>>() {
            }.getType();
            lstdetMemo = gson.fromJson(slcpdfmemo.getTabla_requerimiento(), collectionType2);
            slcCoti = (new CotizacionventasDao()).findCotizacion(user.getIDEMPRESA(), slcpdfmemo.getIdcotizacionv());
            lstDcot = dcotDao.getListDCotizacionWeb(user.getIDEMPRESA(), slcCoti.getIdcotizacionv());
            slcpdfmemo.setHoraInsta(WebUtil.convertDecimalTime(slcpdfmemo.getHora_inst()));
            PDF_Memorandum_Instalacion();
        } catch (NisiraORMException ex) {
            Logger.getLogger(MemorandumInstaCMTAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PDF_Memorandum_Instalacion() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memo", slcpdfmemo);
        params.put("cotventa", slcCoti);
        JRDataSource atendido = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstAtencion);
        JRDataSource detcot = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstDcot);
        params.put("atendido", atendido);
        params.put("detcot", detcot);
        JRDataSource datasource = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstdetMemo);
        String reporte = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jrxml";
        String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jasper";
        File f = new File(reporte_compilado);
        try {
            if (!f.isFile()) {
                JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
            }
            getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
            SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, params, datasource);
            jasperPrint.setName("MEMO_" + slcpdfmemo.getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                    + slcpdfmemo.getRazon_social().trim());
            filename = "MEMO_" + slcpdfmemo.getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                    + slcpdfmemo.getRazon_social().trim()
                    + ".pdf";
            /*RUTA*/
            rutapdf = Constantes.ARCHIVO_REPORTE + File.separator + filename;
            JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
//                    resp.addHeader("Content-Disposition", "inline; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // En la misma pantalla
//                    //resp.addHeader("Content-Disposition", "attachmed; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // Para que lo guardes
            RequestContext.getCurrentInstance().execute("PF('dlg_pdf').show()");
        } catch (Exception e) {
            System.out.println(e.toString());
//            this.estiloMensaje = Constantes.ESTILO_MENSAJE_ERROR;
            mensaje = WebUtil.mensajeError();
            WebUtil.MensajeError(mensaje);
        }
    }

    public void PDF_cotizacion() {
        try {
            if (getDatoEdicion().getIdcotizacionv() != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ext = context.getExternalContext();
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("memo", getDatoEdicion());
                params.put("cotventa", slcCoti);
                JRDataSource atendido = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstAtencion);
                JRDataSource detcot = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstDcot);
                params.put("atendido", atendido);
                params.put("detcot", detcot);
                JRDataSource datasource = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lstdetMemo);
                String reporte = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jrxml";
                String reporte_compilado = Constantes.FORMATO_REPORTE + File.separator + "RPT_MEMORANDU_INSTALACION_002" + ".jasper";
                File f = new File(reporte_compilado);

                if (!f.isFile()) {
                    JasperCompileManager.compileReportToFile(reporte, reporte_compilado);
                }
                getParamsReport().put(JRParameter.IS_IGNORE_PAGINATION, true);
                SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte_compilado, params, datasource);
                jasperPrint.setName("MEMO_" + getDatoEdicion().getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                        + slcCoti.getRazon_social().trim());
                HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
                resp.setContentType("application/pdf");
                filename = "MEMO_" + getDatoEdicion().getIdordenservicio() + "_" + sm.format(slcCoti.getFecha()) + "_"
                        + slcCoti.getRazon_social().trim()
                        + ".pdf";
                /*RUTA*/
                rutapdf = Constantes.ARCHIVO_REPORTE + File.separator + filename;
                JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
                context.getApplication().getStateManager().saveView(context);
                context.responseComplete();
//                    resp.addHeader("Content-Disposition", "inline; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // En la misma pantalla
//                    //resp.addHeader("Content-Disposition", "attachmed; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // Para que lo guardes
                JasperExportManager.exportReportToPdfStream(jasperPrint, resp.getOutputStream());

            } else {
                mensaje = "Documento no creado";
                WebUtil.MensajeAdvertencia(mensaje);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
//            this.estiloMensaje = Constantes.ESTILO_MENSAJE_ERROR;
            mensaje = WebUtil.mensajeError();
            WebUtil.MensajeError(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    public boolean validarGrabar() {
        if (slcCoti.getIdcotizacionv() == null) {
            mensaje = "Tiene que seleccionae una Cotizacion";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (getDatoEdicion().getDuracion_contrato().equalsIgnoreCase("")) {
            mensaje = "Tiene que definir la duracion del contrato";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if(getDatoEdicion().getHoraInsta() == null){
            mensaje = "Tiene que definir la Hora de Instalacion";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (lstAtencion.isEmpty()) {
            mensaje = "Tiene que ingresar Atenciones";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (lstdetMemo.isEmpty()) {
            mensaje = "Tiene que ingresar requerimientos de equipo";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validarGrabar()) {
                Gson gson = new GsonBuilder().create();
                JsonArray AtencionArray = gson.toJsonTree(lstAtencion).getAsJsonArray();
                getDatoEdicion().setTabla_atendido(AtencionArray.toString());

                JsonArray myCustomArray = gson.toJsonTree(lstdetMemo).getAsJsonArray();
                getDatoEdicion().setTabla_requerimiento(myCustomArray.toString());
                getDatoEdicion().setHora_inst(WebUtil.convertTimeDecimal(getDatoEdicion().getHoraInsta()));
                mensaje = memoDao.grabarMemo(getDatoEdicion().getIdemrpesa(), getDatoEdicion().getIdordenservicio(), getDatoEdicion());
                getDatoEdicion().setIdordenservicio(mensaje);
                setMensaje(WebUtil.exitoRegistrar("Memorandum Instalacion", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
            }
            RequestContext.getCurrentInstance().update("datos:growl");
        } catch (NisiraORMException ex) {
            WebUtil.MensajeAdvertencia(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {

            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                memoDao.delMemo(getDatoEdicion().getIdcotizacionv(), getDatoEdicion().getIdemrpesa());
            }
            lista_accion_filtro("wLst_Memorandum_Install_CMT");
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aprobar() {
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Cotizacionventas getSlcCoti() {
        return slcCoti;
    }

    public void setSlcCoti(Cotizacionventas slcCoti) {
        this.slcCoti = slcCoti;
    }

    public List<Dcotizacionventas> getLstDcot() {
        return lstDcot;
    }

    public void setLstDcot(List<Dcotizacionventas> lstDcot) {
        this.lstDcot = lstDcot;
    }

    public Memorandum_instalacion_pssDao getMemoDao() {
        return memoDao;
    }

    public void setMemoDao(Memorandum_instalacion_pssDao memoDao) {
        this.memoDao = memoDao;
    }

    public CotizacionventasDao getCotDao() {
        return cotDao;
    }

    public void setCotDao(CotizacionventasDao cotDao) {
        this.cotDao = cotDao;
    }

    public DcotizacionventasDao getDcotDao() {
        return dcotDao;
    }

    public void setDcotDao(DcotizacionventasDao dcotDao) {
        this.dcotDao = dcotDao;
    }

    public List<Atendido> getLstAtencion() {
        return lstAtencion;
    }

    public void setLstAtencion(List<Atendido> lstAtencion) {
        this.lstAtencion = lstAtencion;
    }

    public List<DetalleMemorandum> getLstdetMemo() {
        return lstdetMemo;
    }

    public void setLstdetMemo(List<DetalleMemorandum> lstdetMemo) {
        this.lstdetMemo = lstdetMemo;
    }

    public Atendido getSlcAtencion() {
        return slcAtencion;
    }

    public void setSlcAtencion(Atendido slcAtencion) {
        this.slcAtencion = slcAtencion;
    }

    public DetalleMemorandum getSlcMemo() {
        return slcMemo;
    }

    public void setSlcMemo(DetalleMemorandum slcMemo) {
        this.slcMemo = slcMemo;
    }

    public Memorandum_instalacion_pss getSlcpdfmemo() {
        return slcpdfmemo;
    }

    public void setSlcpdfmemo(Memorandum_instalacion_pss slcpdfmemo) {
        this.slcpdfmemo = slcpdfmemo;
    }

    public String getRutapdf() {
        return rutapdf;
    }

    public void setRutapdf(String rutapdf) {
        this.rutapdf = rutapdf;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
