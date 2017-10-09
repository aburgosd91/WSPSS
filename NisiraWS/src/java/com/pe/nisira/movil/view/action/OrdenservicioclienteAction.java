/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Ambito_pagoDao;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costosDao;
import com.nisira.core.dao.Estructura_costos_clieprovDao;
import com.nisira.core.dao.Estructura_costos_mano_obraDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
import com.nisira.core.dao.Estructura_costos_productoDao;
import com.nisira.core.dao.MotivosproduccionDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Privilegio_global_pssDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Ambito_pago;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Codoperaciones_pss;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.entity.Det_tareoweb;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Estructura_costos;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.entity.Estructura_costos_mano_obra;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Privilegio_global_pss;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Ubigeo;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "ordenservicioclienteAction")
@SessionScoped
public class OrdenservicioclienteAction extends AbstactListAction<Ordenserviciocliente> {

    private String idestadoCot;
    /************** FLAG - ACCESOS*******************/
    private boolean fclieprov;
    private boolean fdocreferencia;
    private boolean fproducto;
    private boolean ftabdetalleordenservicio;
    private boolean ftabpersonalservicio;
    private boolean ftabrutas;
    private boolean ftipo_servicio;
    private boolean fmotivo_rc;
    private boolean fnum_repetir;
    /************** BOTONES - DORDENSERVICIO*******************/
    private boolean botonNuevoDOrdenservicio;
    private boolean botonEditarDOrdenservicio;
    private boolean botonEliminarDOrdenservicio;
    /************** BOTONES - PERSONALSERVICIO *******************/
    private boolean botonNuevoPersonal_servicio;
    private boolean botonEditarPersonal_servicio;
    private boolean botonEliminarPersonal_servicio;
    /************** BOTONES - DPERSONALSERVICIO *******************/
    private boolean botonNuevoDPersonal_servicio;
    private boolean botonEditarDPersonal_servicio;
    private boolean botonEliminarDPersonal_servicio;
    /************** BOTONES - RUTASERVICIO *******************/
    private boolean botonNuevoRuta_servicios;
    private boolean botonEditarRuta_servicios;
    private boolean botonEliminarRuta_servicios;
    /*********************************LISTAS*******************************************/
    private List<Estructura_costos_clieprov> listEstructura_costos_clieprov;
    private List<Estructura_costos> listEstructura_costos;
    private List<Ordenserviciocliente> selectListOrdenserviciocliente;
    private List<Clieprov> listClieprov;
    private List<Documentos> listDocumentos;
    private List<Numemisor> listNumemisor;
    private List<Dordenserviciocliente> lstdordenserviciocliente;
    private List<Estados> listEstado;
    private List<Cotizacionventas> listCotizacionventas;
    private List<Dcotizacionventas> listDcotizacionventas;
    private List<Dcotizacionventas> selectListDcotizacionventas;
    private List<Cotizacionventas> selectListCotizacionventas;
    private List<Docreferencia> listDocreferencia;
    private List<Personal_servicio> listPersonal_Servicio;
    private List<Dpersonal_servicio> listDpersonal_Servicio;
    private List<Ruta_servicios> listRuta_servicios;
    private List<Dcotizacionventas_actividades> listDcotizacionventas_actividades;
    private List<Estructura_costos_mano_obra_cotizacionventas> listEstructura_costos_mano_obra_cotizacionventas;
    private List<Motivosproduccion> listMotivoproduccion;
    private List<Cargos_personal> listCargo_personal;
    private List<Ambito_pago> listAmbito_pago;
    /********************************** TABLAS TOTALES *******************************************/
    private List<Personal_servicio> listPersonalservicio_total;
    private List<Dpersonal_servicio> listDpersonalservicio_total;
    private List<Ruta_servicios> listRutasTotales;
    private List<Det_tareoweb> listDet_tareo_verificacion;
    /*************************************DAO***************************************/
    private Estructura_costos_clieprovDao estructura_costos_clieprovDao;
    private Estructura_costosDao estructura_costosDao;
    private OrdenservicioclienteDao ordenservicioclienteDao;
    private DordenservicioclienteDao dordenservicioclienteDao;
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private ClieprovDao clieprovDao;
    private EstadosDao estadosDao;
    private CotizacionventasDao cotizacionventasDao;
    private DcotizacionventasDao dcotizacionventasDao;
    private DocreferenciaDao docreferenciaDao;
    private Personal_servicioDao personal_servicioDao;
    private Ruta_serviciosDao ruta_serviciosDao;
    private Dpersonal_servicioDao dpersonal_servicioDao;
    private Dcotizacionventas_actividadesDao dcotizacionventas_actividadesdao;
    private Estructura_costos_mano_obra_cotizacionventasDao estructura_costos_mano_obra_cotizacionventasDao;
    private Estructura_costos_mano_obraDao estructura_costos_mano_obraDao;
    private MotivosproduccionDao motivosproduccionDao;
    private Cargos_personalDao cargos_personalDao;
    private Estructura_costos_productoDao estructura_costos_productoDao;
    private RutasDao rutasDao;
    private UsuarioDao usuariodao;
    private Ambito_pagoDao ambito_pagodao;
    private Det_tareowebDao det_tareoweb_verificationDao; 
    private Privilegio_global_pssDao privilegio_global_pssDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Date fechaprogramaciont;
    private Date fechaejecuciont;
    private Date fechafinalizaciont;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    private Cotizacionventas selectCotizacionventas;
    private Consumidor selectConsumidor;
    private Dordenserviciocliente dordenserviciocliente;
    private Dordenserviciocliente selectDordenserviciocliente;
    private Docreferencia selectDocreferencia;
    private Personal_servicio selectPersonal_servicio;
    private Personal_servicio personal_servicio;
    private Dpersonal_servicio dpersonal_servicio;
    private Dpersonal_servicio selectDPersonal_servicio;
    private Clieprov selectClieprovPersonal;
    private Ruta_servicios selectRuta_servicios;
    private Ruta_servicios ruta_servicios;
    private Rutas selectRutas;
    private Gmap selectGmap;
    private int indexTab;
    private TabView tabView; 
    private Producto selectProducto;
    private Cargos_personal selectCargos_personal;
    private Estructura_costos_producto selectEstructura_costos_producto;
    private Estructura_costos_clieprov selectEstructura_costos_clieprov;
    private Det_tareoweb cabercerDet_tareoweb;
    private Codoperaciones_pss selectCodoperaciones_pss;
    private List<Float> lstHoras;
    private List<Rutas> lstComboRutas;
    private String log_consola;
    private Rutas newRutas;
    /************************************* DATOS *****************************************/
    private int num_repetir;
    private int num_repetir_detalle;
    private int type_personalservicio;
    public OrdenservicioclienteAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            numero = "";
            mensaje = "";
            fechaprogramaciont = new Date();
            fechaejecuciont = null;
            fechafinalizaciont = null;
            dordenserviciocliente = new Dordenserviciocliente();
            personal_servicio = new Personal_servicio();
            ruta_servicios = new Ruta_servicios();
            dpersonal_servicio = new Dpersonal_servicio();
            cabercerDet_tareoweb = new Det_tareoweb();
            newRutas = new Rutas();
            /*********************************LISTAS*******************************************/
            lstdordenserviciocliente = new ArrayList<Dordenserviciocliente>();
            listDocumentos = new ArrayList<Documentos>();
            listNumemisor = new ArrayList<Numemisor>();
            listEstado = new ArrayList<Estados>();
            listClieprov = new ArrayList<Clieprov>();
            listCotizacionventas = new ArrayList<>();
            listDcotizacionventas = new ArrayList<>();
            listPersonal_Servicio =new ArrayList<>();
            listRuta_servicios = new ArrayList<>();
            listDpersonal_Servicio = new ArrayList<>();
            listDcotizacionventas_actividades = new ArrayList<>();
            listMotivoproduccion = new ArrayList<>();
            listEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
            listPersonalservicio_total = new ArrayList<>();
            listDpersonalservicio_total = new ArrayList<>();
            listRutasTotales = new ArrayList<>();
            listCargo_personal = new ArrayList<>();
            
            lstHoras = new ArrayList<>();
            lstComboRutas = new ArrayList<>();
            listAmbito_pago = new ArrayList<>();
            listDet_tareo_verificacion = new ArrayList<>();
            /*********************************DAO*******************************************/
            cotizacionventasDao = new CotizacionventasDao();
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            docDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            clieprovDao = new ClieprovDao();
            dordenservicioclienteDao = new DordenservicioclienteDao();
            docreferenciaDao = new DocreferenciaDao();
            personal_servicioDao = new Personal_servicioDao();
            ruta_serviciosDao = new Ruta_serviciosDao();
            dpersonal_servicioDao = new Dpersonal_servicioDao();
            dcotizacionventasDao = new DcotizacionventasDao();
            dcotizacionventas_actividadesdao = new Dcotizacionventas_actividadesDao();
            estadosDao = new EstadosDao();
            motivosproduccionDao = new MotivosproduccionDao();
            estructura_costos_mano_obra_cotizacionventasDao = new Estructura_costos_mano_obra_cotizacionventasDao();
            cargos_personalDao = new Cargos_personalDao();
            estructura_costos_clieprovDao = new Estructura_costos_clieprovDao();
            estructura_costos_productoDao = new Estructura_costos_productoDao();
            rutasDao = new RutasDao();
            estructura_costos_mano_obraDao = new Estructura_costos_mano_obraDao();
            usuariodao = new UsuarioDao();
            ambito_pagodao = new Ambito_pagoDao();
            det_tareoweb_verificationDao = new Det_tareowebDao();
            privilegio_global_pssDao = new Privilegio_global_pssDao();
            /**********************************CONTROLADOR********************************/
            /*DETALLE ORDEN SERVICIO*/
            botonNuevoDOrdenservicio=true;
            botonEditarDOrdenservicio=true;
            botonEliminarDOrdenservicio=true;
            /*PERSONAL SERVICIO*/
            botonNuevoPersonal_servicio=true;
            botonEditarPersonal_servicio=true;
            botonEliminarPersonal_servicio=true;
            /*DETALLE PERSONAL SERVICIO*/
            botonNuevoDPersonal_servicio=true;
            botonEditarDPersonal_servicio=true;
            botonEliminarDPersonal_servicio=true;
            /*DETALLE RUTAS*/
            botonNuevoRuta_servicios=true;
            botonEditarRuta_servicios=true;
            botonEliminarRuta_servicios=true;
            ftipo_servicio = true;
            fnum_repetir = false;
            /********************************** CONFIGURACIÓN - SERVIDOR ********************************/
            listDocumentos=docDao.getOrdenServicio(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listMotivoproduccion = motivosproduccionDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listAmbito_pago = ambito_pagodao.lstAmbitoEmpresa_visibles(user.getIDEMPRESA());
            num_repetir = 1;
            type_personalservicio = 1;
            actualiza_ventana("wMnt_Ordenserviciocliente");
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        try {
            /*********************************LISTAS*******************************************/
            setLstdordenserviciocliente(new ArrayList<Dordenserviciocliente>());
            setListDocumentos(new ArrayList<Documentos>());
            setListNumemisor(new ArrayList<Numemisor>());
            setListEstado(new ArrayList<Estados>());
            setListClieprov(new ArrayList<Clieprov>());
            listPersonal_Servicio =new ArrayList<>();
            listRuta_servicios = new ArrayList<>();
            /*********************************DAO*******************************************/
            setOrdenservicioclienteDao(new OrdenservicioclienteDao());
            setDocDao(new DocumentosDao());
            setNumemisorDao(new NumemisorDao());
            setClieprovDao(new ClieprovDao());
            setEstadosDao(new EstadosDao());
            personal_servicioDao = new Personal_servicioDao();
            ruta_serviciosDao = new Ruta_serviciosDao();
            motivosproduccionDao = new MotivosproduccionDao();
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            numero = "";
            mensaje = "";
            fechaprogramaciont = new Date();
            fechaejecuciont = null;
            fechafinalizaciont = null;
            personal_servicio = new Personal_servicio();
            dpersonal_servicio = new Dpersonal_servicio();
            ruta_servicios = new Ruta_servicios();
            /**********************************CONTROLADOR********************************/
            /*DETALLE ORDEN SERVICIO*/
            botonNuevoDOrdenservicio=true;
            botonEditarDOrdenservicio=true;
            botonEliminarDOrdenservicio=true;
            /*PERSONAL SERVICIO*/
            botonNuevoPersonal_servicio=true;
            botonEditarPersonal_servicio=true;
            botonEliminarPersonal_servicio=true;
            /*DETALLE PERSONAL SERVICIO*/
            botonNuevoDPersonal_servicio=true;
            botonEditarDPersonal_servicio=true;
            botonEliminarDPersonal_servicio=true;
            /*DETALLE RUTAS*/
            botonNuevoRuta_servicios=true;
            botonEditarRuta_servicios=true;
            botonEliminarRuta_servicios=true;
            /**********************************CONFIGURACIÓN - SERVIDOR********************************/
            listDocumentos=docDao.getOrdenServicio(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listMotivoproduccion=motivosproduccionDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listAmbito_pago = ambito_pagodao.lstAmbitoEmpresa_visibles(user.getIDEMPRESA());
            actualiza_ventana("wMnt_Ordenserviciocliente");
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void nuevo() {
        try {
            getIniciar();
            setDatoEdicion(new Ordenserviciocliente());
            getDatoEdicion().setFecha(new Date());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setNumero(numero);
            getDatoEdicion().setIdestado("PE");
            Clieprov us = usuariodao.getUsuarioCliente(user.getIDUSUARIO());
            if(us!=null){
                getDatoEdicion().setIdoperario2(us.getIdclieprov());
                getDatoEdicion().setOperario2(us.getRazonsocial());
            }
            RequestContext.getCurrentInstance().update("datos");
        } catch (NisiraORMException ex) {
            this.mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean esVistaValida() {
        if (getDatoEdicion().getIdclieprov().isEmpty() & getDatoEdicion().getRazonsocial().isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Cliente");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getDatoEdicion().getGlosa().isEmpty() & WebUtil.isnull(getDatoEdicion().getTipo_servicio(), "").trim().equals("E")) {
            WebUtil.MensajeAdvertencia("Ingresar Glosa de Documento");
            RequestContext.getCurrentInstance().update("datos:growl");
            //return false;
        }
        if (getDatoEdicion().getContacto().isEmpty() & WebUtil.isnull(getDatoEdicion().getTipo_servicio(), "").trim().equals("E")) {
            WebUtil.MensajeAdvertencia("Ingresar Contacto");
            RequestContext.getCurrentInstance().update("datos:growl");
            //return false;
        }
        if (!this.fdocreferencia & getListDocreferencia().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Documento referencia");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getLstdordenserviciocliente().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle de servicio");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getListPersonalservicio_total().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle de personal");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
//        if (getLstdordenserviciocliente().size() > 0 & WebUtil.isnull(getDatoEdicion().getTipo_servicio(), "").trim().equals("E")) {
//            String msj ="";
//            boolean fl = false;
//            for(Dordenserviciocliente dos:getLstdordenserviciocliente()){
//                if(dos.getGlosa().isEmpty()){
//                    msj+="("+dos.getItem()+") - "+" Cod:"+dos.getCodoperaciones().trim()+
//                            " Horas:"+dos.getHora_rc()+" Ruta:"+dos.getRuta_viaje()+" - Asignar Glosa";
//                    fl=true;
//                }
//            }
//            if(fl){
//                WebUtil.MensajeAdvertencia(msj);
//                RequestContext.getCurrentInstance().update("datos:growl");
//                return false;
//            }
//        }
        return true;
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                if(getLadd()==1){
                    mensaje=getOrdenservicioclienteDao().grabar(1, getDatoEdicion(), 
                            getLstdordenserviciocliente(),getListPersonalservicio_total(),
                            getListDocreferencia(),getListRutasTotales(),getListDpersonalservicio_total(),idestadoCot,user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdordenservicio(mensaje.trim());
                }
                else
                    mensaje=getOrdenservicioclienteDao().grabar(2, getDatoEdicion(), 
                            getLstdordenserviciocliente(),getListPersonalservicio_total(),
                            getListDocreferencia(),getListRutasTotales(),getListDpersonalservicio_total(),idestadoCot,user.getIDUSUARIO());
                setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            setLvalidate(false);
        }
        
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                if(getDatoEdicion().getTipo_servicio().trim().equals("E")){
                    String msj = (new Det_tareowebDao()).verificacionPersonalServicio_det_tareoweb_global(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdordenservicio());
                    if(!msj.trim().equals("")){
                        mostrarLog_txt("************* TAREO EXISTENE *************"+"\n"+msj.trim());
                    }else{
                        getDatoEdicion().setIdestado("AN");
                        mensaje=getOrdenservicioclienteDao().anular(getDatoEdicion(),user.getIDUSUARIO());
                        if(mensaje!=null){
                            setMensaje(WebUtil.exitoEliminar("Orden servicio cliente", mensaje));
                            WebUtil.info(getMensaje());
                            setLvalidate(true);
                            buscarFiltro(2);
                        }
                    }
                }else if(getDatoEdicion().getTipo_servicio().trim().equals("F")){
                    getDatoEdicion().setIdestado("AN");
                    mensaje=getOrdenservicioclienteDao().anular(getDatoEdicion(),user.getIDUSUARIO());
                    if(mensaje!=null){
                        setMensaje(WebUtil.exitoEliminar("Orden servicio cliente", mensaje));
                        WebUtil.info(getMensaje());
                        setLvalidate(true);
                        buscarFiltro(2);
                    }
                }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean verificar_edicion(){
        boolean verification = false;
        if(getDatoSeleccionado() != null){
            if(getDatoSeleccionado().getIdestado()!=null){
                if(getDatoSeleccionado().getIdestado().trim().equals("AN")){
                    this.mensaje = "El documento "+getDatoSeleccionado().getIddocumento()+"-"+getDatoSeleccionado().getSerie()+"-"+getDatoSeleccionado().getNumero()+
                            " se encuentra Anulado";
                    WebUtil.error(getMensaje());
                    verification = true;
                }
                if(getDatoSeleccionado().getIdestado().trim().equals("CR")){
                    this.mensaje = "El documento "+getDatoSeleccionado().getIddocumento()+"-"+getDatoSeleccionado().getSerie()+"-"+getDatoSeleccionado().getNumero()+
                            " se encuentra Cerrado";
                    WebUtil.error(getMensaje());
                    verification = true;
                }
            }
        }
        RequestContext.getCurrentInstance().update("datos:growl");
        return verification;
    }
    @Override
    public String buscarFiltro(int tipo){
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Ordenserviciocliente");
        return "";
    }

    @Override
    public void cerrar() {
        try {
            List lst;
            if(getDatoSeleccionado() != null){
                if(getDatoSeleccionado().getIdestado().trim().equals("AN")){
                    this.mensaje = "Orden se encuentra ANULADA";
                    WebUtil.error(getMensaje());
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(getDatoSeleccionado().getIdestado().trim().equals("CR")){
                    //List<Privilegio_global_pss> lst_= privilegio_global_pssDao.listarPorUsuario(user.getIDUSUARIO());
                    int privilegio = (new menuDao()).buscar_privilegio_activar_usuario(user.getIDUSUARIO(),getLst_name());
                    if(privilegio==1)
                        RequestContext.getCurrentInstance().execute("PF('dialogCerrar').show()");
                    else{
                        this.mensaje = "Orden se encuentra CERRADA";
                        WebUtil.error(getMensaje());
                        RequestContext.getCurrentInstance().update("datos:growl");                        
                    }
                }else if(getDatoSeleccionado().getTipo_servicio().trim().equals("E")){
                    /*VERIFICAR - DATOS*/
                    List<Personal_servicio> lisPers = personal_servicioDao.listarPorOrdenServicioClienteWeb_Total(getDatoSeleccionado().getIdempresa(),
                            getDatoSeleccionado().getIdordenservicio());
                    if(!lisPers.isEmpty()){
                        String msj = verificacionOrdenservicioDetalle_cerrado(lisPers);
                        if(getDatoSeleccionado().getGlosa().isEmpty()){
                           this.mensaje = "Documento no se puede cerrar.\n"+"Documento sin glosa";
                            WebUtil.MensajeError(this.mensaje); 
                        }else if(getDatoSeleccionado().getContacto().isEmpty()){
                           this.mensaje = "Documento no se puede cerrar.\n"+"Documento sin contacto";
                            WebUtil.MensajeError(this.mensaje); 
                        }
                        else if(msj.trim().equals("")){
                            lst = new ArrayList<>();
                            lst.add(getDatoSeleccionado());
                            this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,lst,user.getIDUSUARIO());
                            setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                            WebUtil.info(getMensaje());
                            setSelectListOrdenserviciocliente(new ArrayList<>());
                            buscarFiltro(2);
                        }else{
                            this.mensaje = "Documento no se puede cerrar.\n"+msj;
                            WebUtil.MensajeError(this.mensaje);
                        }
                    }else{
                        this.mensaje = "Documento no se puede cerrar.\n"+"No existe detalle personal";
                        WebUtil.MensajeError(this.mensaje);
                    }
                }else if(getDatoSeleccionado().getTipo_servicio().trim().equals("F")){
                    lst = new ArrayList<>();
                    lst.add(getDatoSeleccionado());
                    this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,lst,user.getIDUSUARIO());
                    setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                    WebUtil.info(getMensaje());
                    setSelectListOrdenserviciocliente(new ArrayList<>());
                    buscarFiltro(2);
                }
                
            }else if(getDatoEdicion()!= null){
                if(getDatoEdicion().getIdestado().trim().equals("AN")){
                    this.mensaje = "Orden se encuentra ANULADA";
                    WebUtil.error(getMensaje());
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(getDatoEdicion().getTipo_servicio().trim().equals("E")){
                    /*VERIFICAR - DATOS*/
                    List<Personal_servicio> lisPers = personal_servicioDao.listarPorOrdenServicioClienteWeb_Total(getDatoEdicion().getIdempresa(),
                            getDatoEdicion().getIdordenservicio());
                    if(!lisPers.isEmpty()){
                        String msj = verificacionOrdenservicioDetalle_cerrado(lisPers);
                        if(msj.trim().equals("")){
                            lst = new ArrayList<>();
                            lst.add(getDatoEdicion());
                            this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,lst,user.getIDUSUARIO());
                            setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                            WebUtil.info(getMensaje());
                            setSelectListOrdenserviciocliente(new ArrayList<>());
                            buscarFiltro(2);
                        }else{
                            this.mensaje = "Documento no se puede cerrar.\n"+msj;
                            WebUtil.MensajeError(this.mensaje);
                        }
                    }else{
                        this.mensaje = "Documento no se puede cerrar.\n"+"No existe detalle personal";
                        WebUtil.MensajeError(this.mensaje);
                    }
                }else if(getDatoEdicion().getTipo_servicio().trim().equals("F")){
                    lst = new ArrayList<>();
                    lst.add(getDatoEdicion());
                    this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,lst,user.getIDUSUARIO());
                    setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                    WebUtil.info(getMensaje());
                    setSelectListOrdenserviciocliente(new ArrayList<>());
                    buscarFiltro(2);
                }
                
            }else{
                this.mensaje = "Seleccionar Documento";
                WebUtil.MensajeError(this.mensaje);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ordenserviciocliente_cierreAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.MensajeError(ex.getMessage());
        }
    }
    public void activarDocumento() {
        try {
            List lst = new ArrayList<>();
            lst.add(getDatoSeleccionado());
            this.mensaje = getOrdenservicioclienteDao().cierreMasivo(4,lst,user.getIDUSUARIO());
            setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
            WebUtil.info(getMensaje());
            setSelectListOrdenserviciocliente(new ArrayList<>());
            buscarFiltro(2);
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.MensajeError(ex.getMessage());
        }
    }
    @Override
    public void mostrarLog_txt(String contenido){
        if(contenido!=null){
            if(!contenido.trim().equals("")){
                log_consola = contenido;
                RequestContext.getCurrentInstance().update("datos:dlg_text");
                RequestContext.getCurrentInstance().execute("PF('dlg_text').show()");
            }
        }
    }
    public String verificacionOrdenservicioDetalle_cerrado(List<Personal_servicio> lstpersonal){
        String msj = "";
        for(Personal_servicio ps:lstpersonal){
            if(ps.getIdpersonal()!=null){
                if(ps.getIdpersonal().trim().equals(""))
                    msj+=ps.getIdcargo()+" - "+ps.getCargo()+" / "+" no asignado.\n";
            }else{
                msj+=ps.getIdcargo()+" - "+ps.getCargo()+" / "+" no asignado.\n";
            }   
        }
        return msj;
    }
    /************** CONFIGURACIÓN *******************/
    public void eliminarTareoOrdenservicio(){
        try {
            if(!WebUtil.isnull(getDatoEdicion().getTipo_servicio(), "").trim().equals("E")) {
                WebUtil.MensajeAdvertencia("Opción habilitada para Tipo [ESPECIAL]");
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(cabercerDet_tareoweb == null) {
                WebUtil.MensajeAdvertencia("No existe tareo asociado");
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                mensaje=getOrdenservicioclienteDao().eliminarRegistroTareo(getDatoEdicion(),user.getIDUSUARIO());
                setMensaje(WebUtil.exitoEliminar("Registro en Tareo ["+getDatoEdicion().getSerietareo()+"]", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').hide()");
                RequestContext.getCurrentInstance().update("datos:growl");
            } 
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            setLvalidate(false);
        }
    }
    public void onSPTabChange(TabChangeEvent event) 
    {   
        tabView = (TabView) event.getComponent();
        indexTab = tabView.getActiveIndex();
//      tabView.setActiveIndex(0);
    }
    public void configuracion_motivo_cabecera(String idmotivo){
        Motivosproduccion motivo =null;
        try {
            motivo = motivosproduccionDao.getPorClavePrimaria_(user.getIDEMPRESA(), idmotivo);
            if(motivo!=null){
                if(motivo.getEs_cotizacion()==1 && motivo.getEs_requerimiento()==0 && motivo.getEs_ingpersonal()==0){
                    fdocreferencia=false;
                    fclieprov = true;
                    /*
                    fproducto = true;
                    botonNuevoDOrdenservicio = true;
                    botonEliminarDOrdenservicio=true;
                    botonNuevoPersonal_servicio = true;
                    botonEliminarPersonal_servicio = true;
                    fmotivo_rc = false;
                    */
                    fproducto = false;
                    botonNuevoDOrdenservicio = false;
                    botonEliminarDOrdenservicio=false;
                    botonNuevoPersonal_servicio = false;
                    botonEliminarPersonal_servicio = false;
                    fmotivo_rc = false;
                }else if(motivo.getEs_cotizacion()==0 && motivo.getEs_requerimiento()==0 && motivo.getEs_ingpersonal()==1){
                    fdocreferencia=true;
                    fclieprov = false;
                    fproducto = false;
                    botonNuevoDOrdenservicio = false;
                    botonEliminarDOrdenservicio=false;
                    botonNuevoPersonal_servicio = true;
                    botonEliminarPersonal_servicio = true;
                    fmotivo_rc = false;
                }else if(motivo.getEs_cotizacion()==0 && motivo.getEs_requerimiento()==1 && motivo.getEs_ingpersonal()==0){
                    fmotivo_rc = true;
                    fdocreferencia=true;
                    fclieprov = false;
                    fproducto = false;
                    botonNuevoDOrdenservicio = false;
                    botonEliminarDOrdenservicio=false;
                    botonNuevoPersonal_servicio = false;
                    botonEliminarPersonal_servicio = false;
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void configuracion_motivo_detalle(String idmotivo){
        Motivosproduccion motivo =null;
        try {
            motivo = motivosproduccionDao.getPorClavePrimaria_(user.getIDEMPRESA(), idmotivo);
            if(motivo!=null){
                if(motivo.getEs_cotizacion()==1 && motivo.getEs_requerimiento()==0 && motivo.getEs_ingpersonal()==0){
                    /*botonNuevoDOrdenservicio = true;
                    botonEliminarDOrdenservicio=true;
                    
                    botonNuevoPersonal_servicio = true;
                    botonEliminarPersonal_servicio = true;*/
                    botonNuevoDOrdenservicio = false;
                    botonEliminarDOrdenservicio=false;
                    
                    botonNuevoPersonal_servicio = false;
                    botonEliminarPersonal_servicio = false;
                }else if(motivo.getEs_cotizacion()==0 && motivo.getEs_requerimiento()==1 && motivo.getEs_ingpersonal()==0){
                    
                }else if(motivo.getEs_cotizacion()==0 && motivo.getEs_requerimiento()==0 && motivo.getEs_ingpersonal()==1){
                    botonNuevoDOrdenservicio = false;
                    botonEliminarDOrdenservicio=false;
                    
                    botonNuevoPersonal_servicio = true;
                    botonEliminarPersonal_servicio = true;
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findetalle() throws Exception {
        try{
            /**************************** RESET SELECTION ********************/
            setSelectDordenserviciocliente(new Dordenserviciocliente());
            setSelectRuta_servicios(new Ruta_servicios());
            setSelectPersonal_servicio(new Personal_servicio());
            setSelectDPersonal_servicio(new Dpersonal_servicio());
            setSelectDocreferencia(new Docreferencia());
            
            listDocreferencia = new ArrayList<>();
            lstdordenserviciocliente = new ArrayList<>();
            listPersonal_Servicio = new ArrayList<>();
            listRuta_servicios = new ArrayList<>();
            listDpersonal_Servicio = new ArrayList<>();
            /*** NUEVO ***/
            listPersonalservicio_total = new ArrayList<>();
            listRutasTotales = new ArrayList<>();
            listDpersonalservicio_total = new ArrayList<>();
            if(!getListMotivoproduccion().isEmpty()){
                Motivosproduccion mov = getListMotivoproduccion().get(0);
                configuracion_motivo_cabecera(mov.getIdmotivo());
            }else{
                this.mensaje="Motivo Orden - vacio";
                WebUtil.error(mensaje);
            }
            listDocreferencia = docreferenciaDao.getOrdenServicioWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
            lstdordenserviciocliente = dordenservicioclienteDao.listarPorEmpresaWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
            if(lstdordenserviciocliente.size()>0){
                listPersonalservicio_total=personal_servicioDao.listarPorOrdenServicioClienteWeb_Total(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio());
                listRutasTotales=ruta_serviciosDao.listarPorOrdenServicioClienteWeb_Total(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio());
                listDpersonalservicio_total=dpersonal_servicioDao.listarPorOrdenServicio_PersonalDetalleWeb_Total(user.getIDEMPRESA(),lstdordenserviciocliente.get(0).getIdordenservicio());
            }
            if(getLadd()==2){/*EDITAR*/
                /**** CARGA DE INFORMACIÓN ****/
                listDocreferencia = docreferenciaDao.getOrdenServicioWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
                lstdordenserviciocliente = dordenservicioclienteDao.listarPorEmpresaWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
                if(lstdordenserviciocliente.size()>0){
                    listPersonalservicio_total=personal_servicioDao.listarPorOrdenServicioClienteWeb_Total(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio());
                    listRutasTotales=ruta_serviciosDao.listarPorOrdenServicioClienteWeb_Total(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio());
                    listDpersonalservicio_total=dpersonal_servicioDao.listarPorOrdenServicio_PersonalDetalleWeb_Total(user.getIDEMPRESA(),lstdordenserviciocliente.get(0).getIdordenservicio());
//                    listPersonal_Servicio=personal_servicioDao.listarPorOrdenServicioClienteWeb(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio(),lstdordenserviciocliente.get(0).getItem());
//                    listRuta_servicios=ruta_serviciosDao.listarPorOrdenServicioClienteWeb(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio(),lstdordenserviciocliente.get(0).getItem());
//                    listDpersonal_Servicio = dpersonal_servicioDao.listarPorOrdenServicio_PersonalDetalleWeb(user.getIDEMPRESA(),lstdordenserviciocliente.get(0).getIdordenservicio(),
//                            lstdordenserviciocliente.get(0).getItem(),listPersonal_Servicio.get(0).getItem2());
                }
                configuracion_motivo_cabecera(getDatoEdicion().getIdmotivo());
                configuracion_motivo_detalle(getDatoEdicion().getIdmotivo());
                if(getDatoEdicion().getTipo_servicio()!=null){
                    if(getDatoEdicion().getTipo_servicio().equalsIgnoreCase("F"))
                        this.ftipo_servicio=true;
                    else if(getDatoEdicion().getTipo_servicio().equalsIgnoreCase("E"))
                        this.ftipo_servicio=false;
                }
            }
            if(getLadd()==1){
                if(!getListMotivoproduccion().isEmpty()){
                    Motivosproduccion mov = getListMotivoproduccion().get(0);
                    getDatoEdicion().setIdmotivo(mov.getIdmotivo());
                    configuracion_motivo_cabecera(getDatoEdicion().getIdmotivo());
                    configuracion_motivo_detalle(getDatoEdicion().getIdmotivo());
                }
                this.ftipo_servicio=false;
            }
//            if(!getListMotivoproduccion().isEmpty()){
//                Motivosproduccion mov = getListMotivoproduccion().get(0);
//                configuracion_motivo_cabecera(mov.getIdmotivo());
//            }
            
            /********************************************************************************************/
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
            RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        }catch(Exception ex){
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void visualizar_tareo() {
        try {
            if(getDatoEdicion().getIdordenservicio()==null){
                this.mensaje="Ordenservicio no creado";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                listDet_tareo_verificacion = det_tareoweb_verificationDao.getVisualizar_tareo_ordenservicio(user.getIDEMPRESA(), getDatoEdicion().getIdordenservicio());
                if(listDet_tareo_verificacion.isEmpty()){
                    this.mensaje="No existe tareo vinculado";
                    WebUtil.MensajeError(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    cabercerDet_tareoweb = listDet_tareo_verificacion.get(0);
                    RequestContext.getCurrentInstance().update("datos:detalleTareoDialog");
                    RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:listDet_tareo_verificacion"); 
                    RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').show()");
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /***************** EVENTOS *********************/
    public void onMotivoOrdenservicio(){
        if(getDatoEdicion().getIdmotivo()!=null){
            configuracion_motivo_cabecera(getDatoEdicion().getIdmotivo());
            /**************************** RESET SELECTION ********************/
            setSelectDordenserviciocliente(new Dordenserviciocliente());
            setSelectRuta_servicios(new Ruta_servicios());
            setSelectPersonal_servicio(new Personal_servicio());
            setSelectDPersonal_servicio(new Dpersonal_servicio());
            setSelectDocreferencia(new Docreferencia());
        }
        else{
            this.mensaje="Seleccionar Motivo Orden";
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:btnbuscarcliente");
        RequestContext.getCurrentInstance().update("datos:btnbuscardocreferencia");
        RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        RequestContext.getCurrentInstance().update("datos:tabs");
    }
    public void onTiposervicio(){
        if(getDatoEdicion().getTipo_servicio()!=null){
            if(getDatoEdicion().getTipo_servicio().trim().equalsIgnoreCase("F")){
                this.ftipo_servicio=true;
            }else if(getDatoEdicion().getTipo_servicio().trim().equalsIgnoreCase("E")){
                this.ftipo_servicio=false;
            }
        }
    }
    public void oncDocChange() throws Exception {
        listNumemisor = numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), getDatoEdicion().getIddocumento());
        numero = null;
        if (!listNumemisor.isEmpty()) {
            int i = 0;
            for (Numemisor n : listNumemisor) {
                if (n.getIddocumento().equalsIgnoreCase(getDatoEdicion().getIddocumento())) {
                    i = Integer.parseInt(n.getNumero());
                }
            }
            numero = WebUtil.cerosIzquierda(i, 7);
        }

    }
    public void onCheckCotizacionventa(){
        try{
            setSelectListDcotizacionventas(new ArrayList<>());
            listDcotizacionventas = getDcotizacionventasDao().getListDCotizacionWeb_ordenservicio(user.getIDEMPRESA(),getSelectCotizacionventas().getIdcotizacionv());
//            setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
            getSelectCotizacionventas().setListDcotizacionventas(listDcotizacionventas);
            RequestContext.getCurrentInstance().update("datos:dlgnew_cotizacionventas:dcotizacionventas");
//            RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void onRowSelectDordenservicio(SelectEvent event) throws IOException, NisiraORMException {
        setBotonEditarDOrdenservicio(false);
        setBotonNuevoRuta_servicios(false);
        /*** CONFIGURACIONES ****/
        configuracion_motivo_detalle(getDatoEdicion().getIdmotivo());
        listPersonal_Servicio = cargarPersonal_servicio(selectDordenserviciocliente);
        listRuta_servicios = cargarRuta_servicios();
        RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        RequestContext.getCurrentInstance().update("datos:tabs:listPersonal_Servicio");
        RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
    }
    public void onRowSelectRuta_Servicios(SelectEvent event) throws IOException {
        setBotonEditarRuta_servicios(false);
        setBotonEliminarRuta_servicios(false);
        //RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
        RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
        //tabView.setActiveIndex(indexTab);
    }
    public void onRowSelectPersonal_Servicio(SelectEvent event) throws IOException {
        try {
            setBotonEditarPersonal_servicio(false);
            /*** CONFIGURACIONES ****/
            configuracion_motivo_detalle(getDatoEdicion().getIdmotivo());
            /*CARGAR DATOS DPERSONAL_SERVICIO*/
            listDpersonal_Servicio = cargarDpersonal_servicio();
            RequestContext.getCurrentInstance().update("datos:tabs");
            ////tabView.setActiveIndex(indexTab);
            //RequestContext.getCurrentInstance().update("datos:tabs:tab_personal_Servicio");
            //RequestContext.getCurrentInstance().update("datos:tabs:tab_personal_Servicio:listPersonal_Servicio");
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onRowSelectDPersonal_Servicio(SelectEvent event) throws IOException {
        setBotonEditarDPersonal_servicio(false);
        setBotonEliminarDPersonal_servicio(false);
        RequestContext.getCurrentInstance().update("datos:tabs");
//        RequestContext.getCurrentInstance().update("datos:tabs:listDpersonal_Servicio");
    }
    public void onRowCancelDocreferencia(RowEditEvent event) {
        try {
            Docreferencia obj =(Docreferencia)event.getObject();
            getListDocreferencia().remove(obj);
            /*ELIMINAR REFERENCIAS - DORDENSERVICIO - */
            List<Dcotizacionventas> lstDcoti = dcotizacionventasDao.getListDCotizacionWeb(user.getIDEMPRESA(),obj.getIdreferencia());
            List<Dordenserviciocliente> lstDordenser = new ArrayList<>();
             List<Personal_servicio> lstPersonal_servicio = new ArrayList<>();
             List<Dpersonal_servicio> lstDpersonal_servicio = new ArrayList<>();
             List<Ruta_servicios> lstRuta_servicio = new ArrayList<>();
            if(!lstDcoti.isEmpty()){
                for(int i=0;i<lstDcoti.size();i++){
                    Dcotizacionventas dc = lstDcoti.get(i);
                    for(int j=0;j<getLstdordenserviciocliente().size();j++){
                        Dordenserviciocliente dos = getLstdordenserviciocliente().get(i);
                        if(!(dc.getIdcompra().trim().equals(dos.getIdreferencia()) && 
                                dc.getItemcotizacion().trim().equals(dos.getItemreferencia()))){
                            lstDordenser.add(dos);
                        }
                    }
                }
                lstdordenserviciocliente = lstDordenser;
                for(int i=0;i<lstDordenser.size();i++){
                    Dordenserviciocliente dosc = lstDordenser.get(i);
                    for(int j=0;j<getListPersonalservicio_total().size();j++){
                        Personal_servicio ps = getListPersonalservicio_total().get(j);
                        if(!(dosc.getIdempresa().trim().equals(ps.getIdempresa()) &&
                            dosc.getItem().trim().equals(ps.getItem()))
                        ){
                            lstPersonal_servicio.add(ps);
                        }
                    }
                }
                listPersonalservicio_total=lstPersonal_servicio;
                for(int i=0;i<lstDordenser.size();i++){
                    Dordenserviciocliente dosc = lstDordenser.get(i);
                    for(int j=0;j<getListRutasTotales().size();j++){
                        Ruta_servicios rs = getListRutasTotales().get(j);
                        if(!(dosc.getIdempresa().trim().equals(rs.getIdempresa()) &&
                            dosc.getItem().trim().equals(rs.getItem()))
                        ){
                            lstRuta_servicio.add(rs);
                        }
                    }
                }
                listRutasTotales = lstRuta_servicio;
                for(int i=0;i<lstPersonal_servicio.size();i++){
                    Personal_servicio ps = lstPersonal_servicio.get(i);
                    for(int j=0;j<getListDpersonalservicio_total().size();j++){
                        Dpersonal_servicio dps = getListDpersonalservicio_total().get(j);
                        if(!(ps.getIdempresa().trim().equals(dps.getIdempresa()) &&
                           ps.getItem().trim().equals(dps.getItem_dordenservicio()) &&
                           ps.getItem2().trim().equals(dps.getItem2()))
                          ){
                          lstDpersonal_servicio.add(dps);
                        }
                    }
                }
                listDpersonalservicio_total = lstDpersonal_servicio;
            }
            RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
            RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
            RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
            RequestContext.getCurrentInstance().update("datos:listDpersonal_Servicio");
            RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
        } catch (NisiraORMException ex) {
            this.mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void blur_hora_llegada(){
        getDpersonal_servicio().setFhora_inicio_serv(getDpersonal_servicio().getFhora_llegada());
//        RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio:hora_inicio");
    }
    public void blur_hora_inicio(){
        /*CONVERTIR A DECIMALES PARA COMPARAR*/
        Float hora_llegada_local=0.0f;
        Float hora_inicio_serv_local=0.0f;
        if(dpersonal_servicio.getFhora_llegada()!=null)
            hora_llegada_local=WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_llegada());
        if(dpersonal_servicio.getFhora_inicio_serv()!=null)
            hora_inicio_serv_local=WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_inicio_serv());
        if(hora_llegada_local>hora_inicio_serv_local){
            getDpersonal_servicio().setFhora_inicio_serv(getDpersonal_servicio().getFhora_llegada());
        }
    }
    public void blur_hora_liberacion(){

    }
    public void blur_hora_fin(){
        getDpersonal_servicio().setFhora_liberacion(getDpersonal_servicio().getFhora_fin_serv());
    }
    public void onNhoras_estructura(){
        try {
            if(getDordenserviciocliente()!=null){
                /*OBTENER ESTRUCTURA_COSTOS_PRODUCTO -> ANALIZAR */
                List<Estructura_costos_producto> lstEscos_codoperaciones =estructura_costos_productoDao.listarCodOperaciones(getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getIdclieprov(),getDordenserviciocliente().getCodoperaciones(),
                        getDordenserviciocliente().getHora_rc(),getDordenserviciocliente().getIdruta_ec());
                if(lstEscos_codoperaciones.isEmpty()){
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()==0){
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()>1){
                    mensaje = "Hay mas de una estructura que cumple con las condiciones";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    Estructura_costos_producto selectEscospro = lstEscos_codoperaciones.get(0);
                    selectEstructura_costos_producto = selectEscospro;
                    getDordenserviciocliente().setIdreferencia(selectEscospro.getCodigo());
                    getDordenserviciocliente().setItemreferencia(selectEscospro.getItem());
                    getDordenserviciocliente().setIdservicio(selectEscospro.getIdproducto());
                }
            }
        } catch (NisiraORMException ex) {
            mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onIdruta_estructura(){
        try {
            if(getDordenserviciocliente()!=null){
                /*OBTENER ESTRUCTURA_COSTOS_PRODUCTO -> ANALIZAR */
                lstHoras = estructura_costos_productoDao.listarNhoras(user.getIDEMPRESA(), getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones(),
                    getDordenserviciocliente().getIdruta_ec());
                /*VERIFICAR ESTRUCTURA CON HORAS PARA SERVICIO*/
                if(lstHoras.isEmpty()){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    mensaje = "No existe Estructura_Producto -> Horas , para el servicio seleccionado";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    getDordenserviciocliente().setHora_rc(lstHoras.get(0));
                    RequestContext.getCurrentInstance().update("datos:growl");
                }
                List<Estructura_costos_producto> lstEscos_codoperaciones =estructura_costos_productoDao.listarCodOperaciones(getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getIdclieprov(),getDordenserviciocliente().getCodoperaciones(),
                        getDordenserviciocliente().getHora_rc(),getDordenserviciocliente().getIdruta_ec());
                if(lstEscos_codoperaciones.isEmpty()){
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()==0){
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()>1){
                    mensaje = "Hay mas de una estructura que cumple con las condiciones";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    Estructura_costos_producto selectEscospro = lstEscos_codoperaciones.get(0);
                    selectEstructura_costos_producto = selectEscospro;
                    getDordenserviciocliente().setIdreferencia(selectEscospro.getCodigo());
                    getDordenserviciocliente().setItemreferencia(selectEscospro.getItem());
                    getDordenserviciocliente().setIdservicio(selectEscospro.getIdproducto());
                }
            }
        } catch (NisiraORMException ex) {
            mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*******************DOC REFERENCIA******************/
    public void addDocreferencia(){
        try {
            /*CREAR DOCREFERENCIA*/
            Docreferencia obj =new Docreferencia();
            obj.setIdempresa(user.getIDEMPRESA());
            obj.setIdorigen(getDatoEdicion().getIdordenservicio());
            obj.setTabla("COTIZACIONVENTAS");
            obj.setIdreferencia(getSelectCotizacionventas().getIdcotizacionv());
            obj.setIddocumento(getSelectCotizacionventas().getIddocumento());
            obj.setSerie(getSelectCotizacionventas().getSerie());
            obj.setNumero(getSelectCotizacionventas().getNumero());
            obj.setFecha(getSelectCotizacionventas().getFecha());
            /*ASIGNAR ORDEN SERVICIO */
            getDatoEdicion().setIdclieprov(getSelectCotizacionventas().getIdclieprov());
            getDatoEdicion().setRazonsocial(getSelectCotizacionventas().getRazon_social());
            /*****************************************/
            getListDocreferencia().add(obj);
            RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
            RequestContext.getCurrentInstance().update("datos:cntClie");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_cotizacionventas').hide()");
            addDetalle();
            /*CREAR DETALLE PERSONAL_SERVICIO*/
            listEstructura_costos_mano_obra_cotizacionventas = estructura_costos_mano_obra_cotizacionventasDao.listarPorEmpresaWebXcotizacion(getSelectCotizacionventas().getIdempresa(),
                    getSelectCotizacionventas().getIdcotizacionv(),lstdordenserviciocliente);
            //setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
            addPersonal_servicio();
            RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
            RequestContext.getCurrentInstance().update("datos:tabs");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /******************* ORDEN SERVICIO ***************************/
    public void verCntDocReferencia() {
        try {
            setListCotizacionventas(getCotizacionventasDao().listarPorEmpresaWebFiltroFechaXordenserviciocliente(user.getIDEMPRESA(),null,null));
            if(getListCotizacionventas()!=null){
                if(getListCotizacionventas().size()>0){
                    setSelectCotizacionventas(getListCotizacionventas().get(0));
                    listDcotizacionventas = getDcotizacionventasDao().getListDCotizacionWeb(user.getIDEMPRESA(),getSelectCotizacionventas().getIdcotizacionv());
                    getSelectCotizacionventas().setListDcotizacionventas(listDcotizacionventas);
                    /*LISTAR DCOTIZACIONVENTAS_ACTIVIDADES*/
//                    setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
                }
            }
            RequestContext.getCurrentInstance().update("datos:dlgnew_cotizacionventas");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_cotizacionventas').show()");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void valorDocReferencia() {
//        dordenserviciocliente
//        this.selectCotizacionventas = (Cotizacionventas) event.getObject();
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').show()");
    }
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        /*********************************CLEAN*************************************/
        listDcotizacionventas = new ArrayList<>();
        listPersonal_Servicio = new ArrayList<>();
        listPersonalservicio_total = new ArrayList<>();
        listRuta_servicios = new ArrayList<>();
        listRutasTotales = new ArrayList<>();
        listDpersonal_Servicio = new ArrayList<>();
        listDpersonalservicio_total = new ArrayList<>();
        selectEstructura_costos_clieprov = null;
        /**********************************************************************/
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazonsocial(selectClieprov.getRazonsocial());
        /*PERMITE INGRESAR PERSONAL*/
        if(getDatoEdicion().getIdmotivo().trim().equalsIgnoreCase("FIP")){
            try {
                /* CONSULTAR ESTRUCTURA COSTOS CLIEPROV*/
                List<Estructura_costos_clieprov> listestcos_clieprov = estructura_costos_clieprovDao.listarPorEmpresaWebXclieprov(user.getIDEMPRESA(),
                        getDatoEdicion().getIdclieprov());
                if(!listestcos_clieprov.isEmpty()){
                    selectEstructura_costos_clieprov=listestcos_clieprov.get(0);
                }else{
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
                    WebUtil.error(mensaje);
                }
            } catch (NisiraORMException ex) {
                Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
                mensaje = ex.getMessage();
                WebUtil.error(mensaje);
                
            }
        }
    }
    /***************** DETALLE ORDEN SERVICIO *********************/
    public void addDetalle(){
        try {
            /****** INICIALIZAR *******/
            lstdordenserviciocliente = new ArrayList<>();
            Dordenserviciocliente obj;
            /*AGREGAR DETALLE DORDENSERVICIOCLIENTE*/
            int total=0;
            if(!getListDcotizacionventas().isEmpty())
                total=getListDcotizacionventas().size();
            int seleccion=0;
            if(!getSelectListDcotizacionventas().isEmpty())
                seleccion=getSelectListDcotizacionventas().size();
            if(total!=0 && seleccion!=0)
                if(total==seleccion)
                    idestadoCot="AT";
                else
                    idestadoCot="TP";
            else
                idestadoCot="PE";
            for(Dcotizacionventas deta:getSelectListDcotizacionventas()){
                obj = new Dordenserviciocliente();
                obj.setIdempresa(deta.getIdempresa());
                obj.setIdordenservicio(getDatoEdicion().getIdordenservicio());
                obj.setItem(agregarItemDordenservicio());
                obj.setIdreferencia(deta.getIdcompra());
                obj.setItemreferencia(deta.getItemcotizacion());
                obj.setDescripcion(deta.getDescripcion());
                obj.setIdservicio(deta.getIdproducto());
                obj.setCodoperaciones(deta.getCodoperativo());
                obj.setHora_rc(deta.getNhoras_op());
                obj.setIdruta_ec(deta.getIdruta_op());
                obj.setRuta_ec(deta.getRuta_op());
                lstdordenserviciocliente.add(obj);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarDordenserviciocliente(){
        try {
            /**** VALIDACIONES ****/
            if(dordenserviciocliente.getCodoperaciones()==null){
                this.mensaje="Seleccionar Servicio - Operación";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(dordenserviciocliente.getHora_rc()==null){
                this.mensaje="Seleccionar Horas de servicio";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(dordenserviciocliente.getHora_reqConvert()==null){
                this.mensaje="Ingresar Hora requerimiento";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(dordenserviciocliente.getIdservicio()==null){
                this.mensaje="Seleccionar Servicio";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(dordenserviciocliente.getIdreferencia()==null || dordenserviciocliente.getItemreferencia()==null){
                this.mensaje="No existe estructura";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(WebUtil.isnull(dordenserviciocliente.getGlosa(),"").trim().equals("")  & WebUtil.isnull(getDatoEdicion().getTipo_servicio(), "").trim().equals("E")){
                this.mensaje="Ingresar Glosa";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                if(dordenserviciocliente.getHora_reqConvert()!=null)
                    dordenserviciocliente.setHora_req(WebUtil.convertTimeDecimal(dordenserviciocliente.getHora_reqConvert()));
                int pos=lstdordenserviciocliente.indexOf(dordenserviciocliente);
                if(pos==-1){
                    Dordenserviciocliente obj_p=null;
                    for(int x=0;x<num_repetir_detalle;x++){
                        obj_p = new  Dordenserviciocliente();
                        obj_p.setIdempresa(dordenserviciocliente.getIdempresa());
                        obj_p.setIdordenservicio(dordenserviciocliente.getIdordenservicio());
                        obj_p.setItem(agregarItemDordenservicio());
                        obj_p.setIdvehiculo(dordenserviciocliente.getIdvehiculo());
                        obj_p.setPlaca_cliente(dordenserviciocliente.getPlaca_cliente());
                        obj_p.setHora_req(dordenserviciocliente.getHora_req());
                        obj_p.setFecha_fin_servicio(dordenserviciocliente.getFecha_fin_servicio());
                        obj_p.setIdreferencia(dordenserviciocliente.getIdreferencia());
                        obj_p.setItemreferencia(dordenserviciocliente.getItemreferencia());
                        obj_p.setIdservicio(dordenserviciocliente.getIdservicio());
                        obj_p.setConductor_cliente(dordenserviciocliente.getConductor_cliente());
                        obj_p.setBrevete(dordenserviciocliente.getBrevete());
                        obj_p.setIdruta_viaje(dordenserviciocliente.getIdruta_viaje());
                        obj_p.setRuta_viaje(dordenserviciocliente.getRuta_viaje());
                        obj_p.setHora_rc(dordenserviciocliente.getHora_rc());
                        obj_p.setGlosa(dordenserviciocliente.getGlosa());
                        obj_p.setCodoperaciones(dordenserviciocliente.getCodoperaciones());
                        obj_p.setIdruta_ec(dordenserviciocliente.getIdruta_ec());
                        obj_p.setVehiculo(dordenserviciocliente.getVehiculo());
                        obj_p.setHora_reqConvert(dordenserviciocliente.getHora_reqConvert());
                        obj_p.setDescripcion(dordenserviciocliente.getDescripcion());
                        obj_p.setRuta_ec(dordenserviciocliente.getRuta_ec());
                        lstdordenserviciocliente.add(obj_p);
                        /****************************** Rutas _ servicio ***************************/
                        if(!WebUtil.isnull(dordenserviciocliente.getIdruta_viaje(), "").equals("")){
                            Ruta_servicios rt = new Ruta_servicios();
                            rt.setIdempresa(user.getIDEMPRESA());
                            rt.setIdordenservicio(dordenserviciocliente.getIdordenservicio());
                            rt.setItem(obj_p.getItem());
                            rt.setItemruta(agregarItemRuta_servicios());
                            rt.setIdruta(obj_p.getIdruta_viaje());
                            rt.setRuta(obj_p.getRuta_viaje());
                            listRutasTotales.add(rt);
                            listRuta_servicios = cargarRuta_servicios();   
                        }
                        /*CREAR CARGOS APARTIR DE LA ESTRUCTURA*/
                        List<Estructura_costos_mano_obra> lstmo = estructura_costos_mano_obraDao.listarPorEmpresaWebXproducto(user.getIDEMPRESA(), 
                                obj_p.getIdreferencia(),obj_p.getIdservicio(),obj_p.getItemreferencia());
                        if(lstmo.isEmpty()){
                            this.mensaje="No existe estructura - mano - obrea";
                            WebUtil.error(mensaje);
                            RequestContext.getCurrentInstance().update("datos:growl");
                        }else{
                            Personal_servicio per_ser = null;
                            for(int i=0; i<lstmo.size();i++){
                                listPersonal_Servicio = cargarPersonal_servicio(obj_p);
                                Estructura_costos_mano_obra obj = lstmo.get(i);
                                per_ser = new Personal_servicio();
                                per_ser.setIdempresa(obj.getIdempresa());
                                per_ser.setIdordenservicio(getDatoEdicion().getIdordenservicio());
                                per_ser.setIdcargo(obj.getIdcargo());
                                per_ser.setCargo(obj.getCargo());
                                per_ser.setItem(obj_p.getItem());
                                per_ser.setItem2(agregarItemPersonal_servicio());
                                per_ser.setFechaoperacion(new Date());
                                per_ser.setNrocontenedor(getDatoEdicion().getNrocontenedor());
                                per_ser.setNroprecinto(getDatoEdicion().getNroprecinto());
                                per_ser.setNro_oservicio(getDatoEdicion().getNro_oservicio());
                                per_ser.setPlaca_cliente(obj_p.getPlaca_cliente());
                                per_ser.setConductor_cliente(obj_p.getConductor_cliente());
                                per_ser.setBrevete_cliente(obj_p.getBrevete());
                                listPersonalservicio_total.add(per_ser);
                            }
                            setSelectPersonal_servicio(per_ser);
                        }
                    }
                    setSelectDordenserviciocliente(obj_p);
                }
                else
                    lstdordenserviciocliente.set(pos, dordenserviciocliente);
//                setSelectDordenserviciocliente(lstdordenserviciocliente.get(0));
                setBotonEditarDOrdenservicio(false);
                setBotonNuevoRuta_servicios(false);
                /*** CONFIGURACIONES ****/
                configuracion_motivo_detalle(getDatoEdicion().getIdmotivo());
                listPersonal_Servicio = cargarPersonal_servicio(dordenserviciocliente);
                listRuta_servicios = cargarRuta_servicios();
                RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
                RequestContext.getCurrentInstance().update("datos:tabs:listPersonal_Servicio");
                RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
                RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').hide()");
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoDordenserviciocliente() {
        if(getDatoEdicion().getIddocumento()==null){
            this.mensaje="Documento no asignado";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getSerie()==null){
            this.mensaje="Serie no asignada";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getNumero()==null){
            this.mensaje="Número no asignado";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getIdmotivo()==null){
            this.mensaje="Seleccionar Motivo";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getIdclieprov() == null){
            this.mensaje="Seleccionar Cliente";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getIdoperario()==null){
            this.mensaje="Seleccionar Supervisor";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getDatoEdicion().getIdoperario2()==null){
            this.mensaje="Seleccionar Operario";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        else{
            setDordenserviciocliente(new Dordenserviciocliente());
            getDordenserviciocliente().setIdempresa(user.getIDEMPRESA());
            getDordenserviciocliente().setItem(agregarItemDordenservicio());
            getDordenserviciocliente().setHora_rc(0.0f);
            lstHoras = new ArrayList<>();
            lstComboRutas = new ArrayList<>();
            fnum_repetir = false;
            num_repetir_detalle = 1;
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').show()"); 
        }
        
    }
    public void editarDordenserviciocliente() {
        try {
            setDordenserviciocliente(selectDordenserviciocliente);
            fnum_repetir = true;
            num_repetir_detalle = 1;
            /* OBTENER DATOS DE BASE*/
            lstComboRutas = rutasDao.listarPorEmpresa_estructura_costos_producto(getDatoEdicion().getIdempresa(),
                    getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones());
            lstHoras = estructura_costos_productoDao.listarNhoras(user.getIDEMPRESA(), getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones(),
                    getDordenserviciocliente().getIdruta_ec());
            if(lstHoras.isEmpty()){
                mensaje = "No existe Estructura_Producto -> Horas , para el servicio seleccionado";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                /*OBTENER ESTRUCTURA_COSTOS_PRODUCTO -> ANALIZAR */
                List<Estructura_costos_producto> lstEscos_codoperaciones =estructura_costos_productoDao.listarCodOperaciones(getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getIdclieprov(),getDordenserviciocliente().getCodoperaciones(),
                        getDordenserviciocliente().getHora_rc(),getDordenserviciocliente().getIdruta_ec());
                if(lstEscos_codoperaciones.isEmpty()){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()==0){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else if(lstEscos_codoperaciones.size()>1){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    mensaje = "Hay mas de una estructura que cumple con las condiciones";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    Estructura_costos_producto selectEscospro = lstEscos_codoperaciones.get(0);
                    selectEstructura_costos_producto = selectEscospro;
                }
            }
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').show()");
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarDordenserviciocliente() {
        try {
            if(selectDordenserviciocliente!=null){
                eliminarPersonal_Rutas_servicio();
                
                RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
                RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
                RequestContext.getCurrentInstance().update("datos:tabs");
            }else{
                WebUtil.MensajeAdvertencia("Seleccionar detalle dordenserviciocliente");
                RequestContext.getCurrentInstance().update("datos:growl");
            }
//            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            WebUtil.MensajeAdvertencia(ex.getMessage());
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean verificarPersonalServicio_tareo(List<Personal_servicio> lstp){
        String msj="";
        String msj2="";
        boolean t=true;
        try {
            for(Personal_servicio ps:lstp){
                msj =(new Det_tareowebDao()).verificacionPersonalServicio_det_tareoweb(ps.getIdempresa(),ps.getIdordenservicio(),
                        ps.getItem(),ps.getItem2(), ps.getIdcargo());
                if(!msj.trim().equals("")){
                    msj2+=msj.trim()+"\n";
                }
            }
            if(!msj2.trim().equals("")){
                mostrarLog_txt("************* TAREO EXISTENE *************"+"\n"+msj2.trim());
                t=false;
            }
        } catch (NisiraORMException ex) {
            t=false;
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            t=false;
        }
        return t;
    }
    public void eliminarPersonal_Rutas_servicio(){
        if(selectDordenserviciocliente!=null){
            /*ELIMINAR PERSONAL_SERVICIO*/
            List<Personal_servicio> lst_persona_servicio_delet = new ArrayList<>();
            for(int i = 0; i<listPersonalservicio_total.size();i++){
                Personal_servicio ps = listPersonalservicio_total.get(i);
                if(selectDordenserviciocliente.getIdempresa().trim().equals(ps.getIdempresa().trim()) &&
                    //selectDordenserviciocliente.getIdordenservicio().trim().equals(ps.getIdordenservicio().trim()) &&
                    selectDordenserviciocliente.getItem().trim().equals(ps.getItem().trim())){
                    lst_persona_servicio_delet.add(ps);
//                    listPersonalservicio_total.remove(ps);
                }
            }
            boolean validate = verificarPersonalServicio_tareo(lst_persona_servicio_delet);
            if(validate){
                if(!lst_persona_servicio_delet.isEmpty()){
                    listPersonalservicio_total.removeAll(lst_persona_servicio_delet); 
                    /*ELIMINAR DPERSONAL_SERVICIO_CLIENTE*/
                    List<Dpersonal_servicio> lst_dpersona_servicio_delet = new ArrayList<>();
                    for(int i=0;i<listDpersonalservicio_total.size();i++){
                        Dpersonal_servicio dps = listDpersonalservicio_total.get(i);
                        if(selectDordenserviciocliente.getIdempresa().trim().equals(dps.getIdempresa().trim()) &&
                            selectDordenserviciocliente.getItem().trim().equals(dps.getItem_dordenservicio().trim())    
                        ){
                            lst_dpersona_servicio_delet.add(dps);
        //                    listDpersonalservicio_total.remove(dps);
                        }
                    }
                    if(!lst_dpersona_servicio_delet.isEmpty()){
                        listDpersonalservicio_total.removeAll(lst_dpersona_servicio_delet);
                    }
                    /*ELIMINAR RUTAS_SERVICIO*/
                    List<Ruta_servicios> lst_rutas_servicios_delet = new ArrayList<>();
                    for(int i = 0; i<listRutasTotales.size();i++){
                        Ruta_servicios rs = listRutasTotales.get(i);
                        if(selectDordenserviciocliente.getIdempresa().trim().equals(rs.getIdempresa().trim()) &&
        //                    selectDordenserviciocliente.getIdordenservicio().trim().equals(rs.getIdordenservicio().trim()) &&
                            selectDordenserviciocliente.getItem().trim().equals(rs.getItem().trim())){
                            lst_rutas_servicios_delet.add(rs);
        //                    listRutasTotales.remove(i);
                        }
                    }
                    if(!lst_rutas_servicios_delet.isEmpty()){
                        listRutasTotales.removeAll(lst_rutas_servicios_delet);
                    }
                }
                /*generico*/
                listPersonal_Servicio = new ArrayList<>();
                listRuta_servicios = new ArrayList<>();
                listDpersonal_Servicio = new ArrayList<>();
                lstdordenserviciocliente.remove(selectDordenserviciocliente);
            }
        }
    }
    public void verCntConsumidor() {
        RequestContext.getCurrentInstance().openDialog("cntConsumidor", modalOptions, null);
    }
    public void valorConsumidor(SelectEvent event) {
        this.selectConsumidor = (Consumidor) event.getObject();
        getPersonal_servicio().setIdvehiculo(selectConsumidor.getIdconsumidor());
        getPersonal_servicio().setVehiculo(selectConsumidor.getDescripcion());
    }
    public List<Personal_servicio> cargarPersonal_servicio(Dordenserviciocliente select) throws NisiraORMException{
        List<Personal_servicio> temp = new ArrayList<>();
        if(!listPersonalservicio_total.isEmpty()){
            if(select!=null){
                for(Personal_servicio ob :listPersonalservicio_total){
                    if(ob.getIdempresa().trim().equalsIgnoreCase(select.getIdempresa().trim()) &&
//                        ob.getIdordenservicio().trim().equalsIgnoreCase(selectDordenserviciocliente.getIdordenservicio().trim()) &&
                        ob.getItem().trim().equals(select.getItem().trim())){
                        temp.add(ob);
                    }
                }
            }
        }
        return temp;
    }
    public List<Dpersonal_servicio> cargarDpersonal_servicio() throws NisiraORMException{
        List<Dpersonal_servicio> temp = new ArrayList<>();
        if(!listDpersonalservicio_total.isEmpty()){
            if(selectPersonal_servicio!=null){
                for(Dpersonal_servicio ob :listDpersonalservicio_total){
                    if(ob.getIdempresa().trim().equalsIgnoreCase(selectPersonal_servicio.getIdempresa().trim()) &&
//                        ob.getIdordenservicio().trim().equalsIgnoreCase(selectPersonal_servicio.getIdordenservicio().trim()) &&
                        ob.getItem_dordenservicio().trim().equals(selectPersonal_servicio.getItem().trim()) &&
                        ob.getItem2().trim().equals(selectPersonal_servicio.getItem2().trim())){
                        temp.add(ob);
                    }
                }
            }
        }
        return temp;
    }
    public List<Ruta_servicios> cargarRuta_servicios() throws NisiraORMException{
        List<Ruta_servicios> temp = new ArrayList<>();
        if(!listRutasTotales.isEmpty()){
            if(selectDordenserviciocliente!=null){
                for(Ruta_servicios ob :listRutasTotales){
                    if(ob.getIdempresa().trim().equalsIgnoreCase(selectDordenserviciocliente.getIdempresa().trim()) &&
//                        ob.getIdordenservicio().trim().equalsIgnoreCase(selectDordenserviciocliente.getIdordenservicio().trim()) &&
                        ob.getItem().trim().equals(selectDordenserviciocliente.getItem().trim())){
                        temp.add(ob);
                    }
                }
            }
        }
        return temp;
    }
    /***************** DETALLE CODIGO OPERACIONES ********************/
    public void verCntCodoperaciones_pss(){
        if(getDatoEdicion().getTipo_servicio().trim().equals("E")){
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            List<String> values = new ArrayList<String>();
//            if(getDatoEdicion().getTipo_servicio().trim().equals("E"))
                values.add("ESPECIAL");
//            else if(getDatoEdicion().getTipo_servicio().trim().equals("F"))
//                values.add("FIJO");
            params.put("tipo", values);
            RequestContext.getCurrentInstance().openDialog("cntCodoperaciones_pss", modalParamsOptions, params);
        }else if(getDatoEdicion().getTipo_servicio().trim().equals("F")){
            verCntProducto();
        }
    }
    public void valorCodoperaciones_pss(SelectEvent event) {
        try {
            if(getDatoEdicion().getTipo_servicio().trim().equals("E")){
                this.setSelectCodoperaciones_pss((Codoperaciones_pss) event.getObject());
                getDordenserviciocliente().setCodoperaciones(selectCodoperaciones_pss.getIdcodoperaciones());
                getDordenserviciocliente().setDescripcion(selectCodoperaciones_pss.getDescripcion());
                /*LISTAR RUTAS*/
                lstComboRutas = rutasDao.listarPorEmpresa_estructura_costos_producto(getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones());
                if(!lstComboRutas.isEmpty()){
                    getDordenserviciocliente().setIdruta_ec(lstComboRutas.get(0).getIdruta());
                }
                /*VERIFICAR ESTRUCTURA CON HORAS PARA SERVICIO*/
                lstHoras = estructura_costos_productoDao.listarNhoras(user.getIDEMPRESA(), getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones(),
                        getDordenserviciocliente().getIdruta_ec());
                /*VERIFICAR ESTRUCTURA CON HORAS PARA SERVICIO*/
                if(lstHoras.isEmpty()){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    mensaje = "No existe Estructura_Producto -> Horas , para el servicio seleccionado";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    getDordenserviciocliente().setHora_rc(lstHoras.get(0));
                    /*OBTENER ESTRUCTURA_COSTOS_PRODUCTO -> ANALIZAR */
                    List<Estructura_costos_producto> lstEscos_codoperaciones =estructura_costos_productoDao.listarCodOperaciones(getDatoEdicion().getIdempresa(),
                            getDatoEdicion().getIdclieprov(),getDordenserviciocliente().getCodoperaciones(),
                            getDordenserviciocliente().getHora_rc(),getDordenserviciocliente().getIdruta_ec());
                    if(lstEscos_codoperaciones.isEmpty()){
                        getDordenserviciocliente().setIdreferencia(null);
                        getDordenserviciocliente().setItemreferencia(null);
                        mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                        lstComboRutas = new ArrayList<>();
                        lstHoras = new ArrayList<>();
                        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente:ruta_ec");
                        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente:nhoras");
                        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente:idreferenciacot");
                        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente:itemreferencia");
                        WebUtil.error(mensaje);
                        RequestContext.getCurrentInstance().update("datos:growl");
                    }else if(lstEscos_codoperaciones.size()==0){
                        getDordenserviciocliente().setIdreferencia(null);
                        getDordenserviciocliente().setItemreferencia(null);
                        mensaje = "No existe Estructura para este servicio\n Verificar parámetros";
                        WebUtil.error(mensaje);
                        RequestContext.getCurrentInstance().update("datos:growl");
                    }else if(lstEscos_codoperaciones.size()>1){
                        getDordenserviciocliente().setIdreferencia(null);
                        getDordenserviciocliente().setItemreferencia(null);
                        mensaje = "Hay mas de una estructura que cumple con las condiciones";
                        WebUtil.error(mensaje);
                        RequestContext.getCurrentInstance().update("datos:growl");
                    }else{
                        Estructura_costos_producto selectEscospro = lstEscos_codoperaciones.get(0);
                        selectEstructura_costos_producto = selectEscospro;
                        getDordenserviciocliente().setIdreferencia(selectEscospro.getCodigo());
                        getDordenserviciocliente().setItemreferencia(selectEscospro.getItem());
                        getDordenserviciocliente().setIdservicio(selectEscospro.getIdproducto());
                    }
                }
            }else if(getDatoEdicion().getTipo_servicio().trim().equals("F")){
                this.selectEstructura_costos_producto = (Estructura_costos_producto) event.getObject();
                getDordenserviciocliente().setCodoperaciones(selectEstructura_costos_producto.getCodoperativo());
                getDordenserviciocliente().setDescripcion(selectEstructura_costos_producto.getDescripcion());
                getDordenserviciocliente().setIdreferencia(selectEstructura_costos_producto.getCodigo());
                getDordenserviciocliente().setItemreferencia(selectEstructura_costos_producto.getItem());
                getDordenserviciocliente().setIdservicio(selectEstructura_costos_producto.getIdproducto());
//                getDordenserviciocliente().setHora_rc(selectEstructura_costos_producto.getNhoras());
//                getDordenserviciocliente().setIdruta_ec(selectEstructura_costos_producto.getIdruta());
                
                lstComboRutas = rutasDao.listarPorEmpresa_estructura_costos_producto(getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones());
                if(!lstComboRutas.isEmpty()){
                    getDordenserviciocliente().setIdruta_ec(selectEstructura_costos_producto.getIdruta());
                }else{
                   getDordenserviciocliente().setIdruta_ec(selectEstructura_costos_producto.getIdruta()); 
                }
                /*VERIFICAR ESTRUCTURA CON HORAS PARA SERVICIO*/
                lstHoras = estructura_costos_productoDao.listarNhoras(user.getIDEMPRESA(), getDatoEdicion().getIdclieprov(), getDordenserviciocliente().getCodoperaciones(),
                        getDordenserviciocliente().getIdruta_ec());
                if(lstHoras.isEmpty()){
                    getDordenserviciocliente().setIdreferencia(null);
                    getDordenserviciocliente().setItemreferencia(null);
                    getDordenserviciocliente().setHora_rc(selectEstructura_costos_producto.getNhoras());
                    mensaje = "No existe Estructura_Producto -> Horas , para el servicio seleccionado";
                    WebUtil.error(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    getDordenserviciocliente().setHora_rc(selectEstructura_costos_producto.getNhoras());
                }
            }
        } catch (NisiraORMException ex) {
            mensaje = "No existe Estructura_Producto -> Horas , para el servicio seleccionado";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /***************** DETALLE PERSONA SERVICIO *********************/
    public void verCntProducto() {
        /*PERMITE INGRESAR PERSONAL*/
//        if(getDatoEdicion().getIdmotivo().trim().equalsIgnoreCase("FIP")){
        if(getDatoEdicion().getIdclieprov()!=null){
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            List<String> values = new ArrayList<String>();
            values.add(getDatoEdicion().getIdclieprov()+","+"FIJO");
            params.put("codigo_estructura", values);
            RequestContext.getCurrentInstance().openDialog("cntEstructura_Costos_Producto_Servicio", modalParamsOptions, params);
        }else{
            mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void valorProducto(SelectEvent event) {
        if(getDatoEdicion().getIdmotivo().trim().equalsIgnoreCase("FIP")){
            selectEstructura_costos_producto = (Estructura_costos_producto) event.getObject();
            getDordenserviciocliente().setDescripcion(selectEstructura_costos_producto.getDescripcion());
            /*OBTENER AL VALIDAR DATOS*/
            getDordenserviciocliente().setIdservicio(selectEstructura_costos_producto.getIdproducto());
            getDordenserviciocliente().setIdreferencia(selectEstructura_costos_producto.getCodigo());
            getDordenserviciocliente().setItemreferencia(selectEstructura_costos_producto.getItem());
        }else{
            this.setSelectProducto((Producto) event.getObject());
            getDordenserviciocliente().setIdservicio(getSelectProducto().getIdproducto());
            getDordenserviciocliente().setDescripcion(getSelectProducto().getDescripcion()); 
        }
        return;
    }
    public void grabarPersonal_Servicion(){
        try {
            int pos=-1;
            if(type_personalservicio==1){/*NUEVO*/
                Personal_servicio temp;
                for(int i=0;i<this.num_repetir;i++){
                    temp = new Personal_servicio();
                    temp.setIdempresa(personal_servicio.getIdempresa());
                    temp.setIdordenservicio(personal_servicio.getIdordenservicio());
                    temp.setItem(personal_servicio.getItem());
                    temp.setItem2(agregarItemPersonal_servicio());
                    temp.setIdcargo(personal_servicio.getIdcargo());
                    temp.setCargo(personal_servicio.getCargo());
                    temp.setChecklist(personal_servicio.getChecklist());
                    temp.setIdpersonal(personal_servicio.getIdpersonal());
                    temp.setDni(personal_servicio.getDni());
                    temp.setNombres(personal_servicio.getNombres());
                    temp.setIdvehiculo(personal_servicio.getIdvehiculo());
                    temp.setVehiculo(personal_servicio.getVehiculo());
                    temp.setIdbasedatos(personal_servicio.getIdbasedatos());
                    temp.setFechaoperacion(personal_servicio.getFechaoperacion());
                    listPersonalservicio_total.add(temp);
                    listPersonal_Servicio = cargarPersonal_servicio(selectDordenserviciocliente);
                }
            }else if(type_personalservicio==2){/*EDITAR*/
                if(getSelectPersonal_servicio()!=null){
                    pos=listPersonalservicio_total.indexOf(getSelectPersonal_servicio());
                    listPersonalservicio_total.set(pos, personal_servicio);
                }
            }
            listPersonal_Servicio = cargarPersonal_servicio(selectDordenserviciocliente);
            RequestContext.getCurrentInstance().update("datos:tabs");
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addPersonal_servicio() {
        /*AGREGAR DETALLE PERSONA_SERVICIO*/
        listPersonalservicio_total = new ArrayList<>();
        Personal_servicio detaobj;
        for(Estructura_costos_mano_obra_cotizacionventas detaDca : getListEstructura_costos_mano_obra_cotizacionventas()){
            detaobj = new Personal_servicio();
            detaobj.setIdbasedatos(detaDca.getIdbasedatos());
            detaobj.setIdempresa(detaDca.getIdempresa());
            detaobj.setIdordenservicio(getDatoEdicion().getIdordenservicio());
            detaobj.setIdcargo(detaDca.getIdcargo());
            detaobj.setCargo(detaDca.getCargo());
            /*DETALLE ORDEN SERVICIO*/
            Dordenserviciocliente osc =getLocalDordenserviciocliente(detaDca.getCodigo(),detaDca.getItemrango(),detaDca.getIdproducto());
            if(osc!=null)
                detaobj.setItem(osc.getItem()==null?"":osc.getItem());//-> relacion DORDENSERVICIOCLIENTE
            else
                detaobj.setItem("");
            //detaobj.setItem(getSelectDordenserviciocliente().getItem()==null?"":getSelectDordenserviciocliente().getItem());//-> relacion DORDENSERVICIOCLIENTE
            detaobj.setItem2(agregarItemPersonal_servicio_total());
            detaobj.setFechaoperacion(new Date());
            listPersonalservicio_total.add(detaobj);
        }
    }
    public Dordenserviciocliente getLocalDordenserviciocliente(String idreferencia,String itemreferencia,String idproducto){/*itemreferencia -> idproducto*/
        Dordenserviciocliente result = null;
        if(!idreferencia.isEmpty()&& !itemreferencia.isEmpty() && !idproducto.isEmpty()){
            for(Dordenserviciocliente obj : getLstdordenserviciocliente()){
                if(obj.getIdreferencia().trim().equalsIgnoreCase(idreferencia.trim()) &&
                    obj.getItemreferencia().trim().equalsIgnoreCase(itemreferencia.trim()) &&
                    obj.getIdservicio().trim().equalsIgnoreCase(idproducto.trim())){
                    result=obj;
                    break;
                }
            }
        }
        return result;
    }
    public void nuevoPersonal_servicio() {
        if(getSelectDordenserviciocliente()==null){
            this.mensaje="Seleccionar Detalle Servicio";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            setPersonal_servicio(new Personal_servicio());
            getPersonal_servicio().setIdempresa(user.getIDEMPRESA());
            getPersonal_servicio().setIdordenservicio(getSelectDordenserviciocliente().getIdordenservicio());
            getPersonal_servicio().setItem(getSelectDordenserviciocliente().getItem());
            getPersonal_servicio().setItem2(agregarItemPersonal_servicio());
            getPersonal_servicio().setFechaoperacion(new Date());
            this.num_repetir =1;
            type_personalservicio = 1;
            setFnum_repetir(false);
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_personal_servicio').show()");
        }
    }
    public void editarPersonal_servicio() {
        this.num_repetir =1;
        type_personalservicio = 2;
        if(!getListPersonal_Servicio().isEmpty()){
            setPersonal_servicio(selectPersonal_servicio);
//            try {
//                
//            } catch (NisiraORMException ex) {
//                Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
//            }
            setFnum_repetir(true);
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio.listDpersonal_Servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_personal_servicio').show()");
        }
    }
    public void eliminarPersonal_servicio() {
        try {
            List<Personal_servicio> ls = new ArrayList<>();
            ls.add(selectPersonal_servicio);
            boolean validate = verificarPersonalServicio_tareo(ls);
            if(validate){
                eliminarPersonal_servicio_total();
                listPersonalservicio_total.remove(selectPersonal_servicio);
                listPersonal_Servicio = cargarPersonal_servicio(selectDordenserviciocliente);
                listDpersonal_Servicio = cargarDpersonal_servicio();
    //            listPersonal_Servicio.remove(selectPersonal_servicio);
                RequestContext.getCurrentInstance().update("datos:tabs:listPersonal_Servicio");
                RequestContext.getCurrentInstance().update("datos:tabs:listDpersonal_Servicio");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarPersonal_servicio_total(){
        List<Dpersonal_servicio> lst_dpersona_servicio_delet = new ArrayList<>();
        if(selectPersonal_servicio!=null){
            for(int i = 0 ; i<listDpersonalservicio_total.size();i++){
                Dpersonal_servicio dps = listDpersonalservicio_total.get(i);
                if(selectPersonal_servicio.getIdempresa().trim().equals(dps.getIdempresa().trim()) &&
                  //selectPersonal_servicio.getIdordenservicio().trim().equals(dps.getIdordenservicio().trim()) &&
                  selectPersonal_servicio.getItem().trim().equals(dps.getItem_dordenservicio()) &&
                  selectPersonal_servicio.getItem2().trim().equals(dps.getItem2())
                  ){
                    lst_dpersona_servicio_delet.add(dps);
                    
                }
            }
            if(!lst_dpersona_servicio_delet.isEmpty())
                listDpersonalservicio_total.removeAll(lst_dpersona_servicio_delet);
        }
    }
    public void valorOperario(SelectEvent event) {
        this.setSelectClieprovPersonal((Clieprov) event.getObject());
        getDatoEdicion().setIdoperario(this.getSelectClieprovPersonal().getIdclieprov());
        getDatoEdicion().setOperario(this.getSelectClieprovPersonal().getRazonsocial());
    }
    public void valorOperario2(SelectEvent event) {
        this.setSelectClieprovPersonal((Clieprov) event.getObject());
        getDatoEdicion().setIdoperario2(this.getSelectClieprovPersonal().getIdclieprov());
        getDatoEdicion().setOperario2(this.getSelectClieprovPersonal().getRazonsocial());
    }
    public void verCntClieprovPersonal() {
        String lst_string=null;
        if(!listPersonal_Servicio.isEmpty()){
            Set<String> st = new LinkedHashSet<String>();
            for(Personal_servicio ps :listPersonalservicio_total){
                if(ps.getIdpersonal()!=null){
                    st.add(ps.getIdpersonal());
                }
            }
            if(!st.isEmpty())
                lst_string=WebUtil.objectGson(st);
        }
        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add(lst_string==null?"":lst_string);
        params.put("lst_personal",values);
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalParams", modalParamsOptions, params);
        //RequestContext.getCurrentInstance().openDialog("cntClieprovPersonal", modalOptions, null);
    }
    public void verCntClieprovPersonalS() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalS", modalOptions, null);
    }
    public void verCntClieprovPersonalSupervisor() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalSupervisor", modalOptions, null);
    }
    public void verCntClieprovPersonalOperador() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalOperador", modalOptions, null);
    }
    public void valorClieprovPersonal(SelectEvent event) {
        this.setSelectClieprovPersonal((Clieprov) event.getObject());
        this.getPersonal_servicio().setIdpersonal(this.getSelectClieprovPersonal().getIdclieprov());
        this.getPersonal_servicio().setDni(this.getSelectClieprovPersonal().getDni());
        this.getPersonal_servicio().setNombres(this.getSelectClieprovPersonal().getRazonsocial());
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalParamsOptions, null);
    }
    public void valorCargos_personal(SelectEvent event) {
        Cargos_personal cargo = (Cargos_personal) event.getObject();
        this.getPersonal_servicio().setIdcargo(cargo.getIdcargo());
        this.getPersonal_servicio().setCargo(cargo.getDescripcion());
    }
    /***************** DETALLE DPERSONA SERVICIO *********************/
    public void grabarDPersonal_Servicion(){
        try {
         /*VALIDACION DE TIME A DECIMAL*/
            if(dpersonal_servicio.getFhora_req()!=null)
                dpersonal_servicio.setHora_req(WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_req()));
            else
                dpersonal_servicio.setHora_req(0.0f);
            if(dpersonal_servicio.getFhora_inicio_serv()!=null)
                dpersonal_servicio.setHora_inicio_serv(WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_inicio_serv()));
            else
                dpersonal_servicio.setHora_inicio_serv(0.0f);
            if(dpersonal_servicio.getFhora_fin_serv()!=null)
                dpersonal_servicio.setHora_fin_serv(WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_fin_serv()));
            else
                dpersonal_servicio.setHora_fin_serv(0.0f);
            if(dpersonal_servicio.getFhora_llegada()!=null)
                dpersonal_servicio.setHora_llegada(WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_llegada()));
            else
                dpersonal_servicio.setHora_llegada(0.0f);
            if(dpersonal_servicio.getFhora_liberacion()!=null)
                dpersonal_servicio.setHora_liberacion(WebUtil.convertTimeDecimal(dpersonal_servicio.getFhora_liberacion()));
            else
                dpersonal_servicio.setHora_liberacion(0.0f);
            /***** APLICAR GRABAR*****/
            int pos=-1;
            if(getSelectDPersonal_servicio()!=null){
                pos=listDpersonalservicio_total.indexOf(getSelectDPersonal_servicio());
//                pos=listDpersonal_Servicio.indexOf(getSelectDPersonal_servicio());
            }
            if(pos==-1){
                listDpersonalservicio_total.add(dpersonal_servicio);
//                listDpersonal_Servicio.add(dpersonal_servicio);
            }
            else{
                listDpersonalservicio_total.set(pos, dpersonal_servicio);
//                listDpersonal_Servicio.set(pos, dpersonal_servicio);
            }
            listDpersonal_Servicio = cargarDpersonal_servicio();
//            RequestContext.getCurrentInstance().update("datos:tabs:listDPersonal_Servicio");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').hide()");
            RequestContext.getCurrentInstance().update("datos:tabs");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void nuevoDPersonal_servicio() {
        if(getSelectPersonal_servicio()==null){
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, "Seleccionar Personal");
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getSelectPersonal_servicio().getIdpersonal()==null){
            this.mensaje="Definir Operario";
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, "Seleccionar Personal");
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(getSelectPersonal_servicio().getIdcargo()==null){
            this.mensaje="Definir Cargo";
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, "Seleccionar Cargo");
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            setDpersonal_servicio(new Dpersonal_servicio());
            getDpersonal_servicio().setIdempresa(user.getIDEMPRESA());
            Dordenserviciocliente osc =getLocalDordenservicioclienteXpersonal(getPersonal_servicio().getIdordenservicio(),getPersonal_servicio().getItem());
            getDpersonal_servicio().setIdordenservicio(getSelectPersonal_servicio().getIdordenservicio());
            getDpersonal_servicio().setItem_dordenservicio(getSelectPersonal_servicio().getItem());
            getDpersonal_servicio().setItem2(getSelectPersonal_servicio().getItem2());
            getDpersonal_servicio().setItem(agregarItemDPersonal_servicio());
            getDpersonal_servicio().setFhora_req(osc.getHora_reqConvert());
            getDpersonal_servicio().setHora_req(osc.getHora_req());
            getDpersonal_servicio().setIdcargo(getSelectPersonal_servicio().getIdcargo());
            getDpersonal_servicio().setCargo(getSelectPersonal_servicio().getCargo());
            getDpersonal_servicio().setFecharegistro(new Date());
            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').show()");
        }
    }
    public Dordenserviciocliente getLocalDordenservicioclienteXpersonal(String idorden,String item_orden){
        Dordenserviciocliente result = null;
        if(!item_orden.isEmpty()){
            for(Dordenserviciocliente obj : getLstdordenserviciocliente()){
                if(obj.getItem().trim().equalsIgnoreCase(item_orden)){
                    result=obj;
                    break;
                }
//        if(!idorden.isEmpty()&& !item_orden.isEmpty()){
//                if(obj.getIdordenservicio().trim().equalsIgnoreCase(idorden) &&
//                    obj.getItem().trim().equalsIgnoreCase(item_orden)){
//                    result=obj;
//                    break;
//                }
//        }

            }
        }
        return result;
    }
    public void editarDPersonal_servicio() {
        setDpersonal_servicio(selectDPersonal_servicio);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').show()");
    }
    public void eliminarDPersonal_servicio() {
        try {
            listDpersonalservicio_total.remove(selectDPersonal_servicio);
//            listDpersonal_Servicio.remove(selectDPersonal_servicio);
            listDpersonal_Servicio = cargarDpersonal_servicio();
            RequestContext.getCurrentInstance().update("datos:tabs:listDpersonal_Servicio");
//            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio:listDpersonal_Servicio");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /***************** DETALLE RUTA *********************/
    public void grabarRuta_servicio(){
        try {
            int pos=-1;
            pos=listRutasTotales.indexOf(getRuta_servicios());
            if(pos==-1)
                listRutasTotales.add(ruta_servicios);
            else
                listRutasTotales.set(pos, ruta_servicios);
            listRuta_servicios = cargarRuta_servicios();
            RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
            //tabView.setActiveIndex(indexTab);
            RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoRuta_servicios() {
        if(getSelectDordenserviciocliente()==null){
            this.mensaje="Seleccionar Detalle Servicio";
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            this.ruta_servicios = new Ruta_servicios();
            this.ruta_servicios.setIdempresa(user.getIDEMPRESA());
            this.ruta_servicios.setIdordenservicio(getSelectDordenserviciocliente().getIdordenservicio());
            this.ruta_servicios.setItem(getSelectDordenserviciocliente().getItem());
            this.ruta_servicios.setItemruta(agregarItemRuta_servicios());
            this.ruta_servicios.setGlosa("");
            RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_ruta_servicios').show()");
        }
    }
    public void editarRuta_servicios() {
        setRuta_servicios(selectRuta_servicios);
        RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_ruta_servicios').show()");
    }
    public void eliminarRuta_servicios() {
        try {
            listRutasTotales.remove(selectRuta_servicios);
            listRuta_servicios = cargarRuta_servicios();
//            listRuta_servicios.remove(selectRuta_servicios);
            RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void viewRuta() {
        if(!listRuta_servicios.isEmpty()){
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            List<String> values = new ArrayList<String>();
            List<Geopoint> listGeopoint = new ArrayList<>();
            int item = 1;Geopoint object;
            for(Ruta_servicios obj :listRuta_servicios){
                object = new Geopoint();
                object.setIdgeopoint(item++);
                object.setDescripcion(obj.getGlosa());
                object.setLatitud(obj.getLatitud());
                object.setLongitud(obj.getLongitud());
                listGeopoint.add(object);
            }
            String json=WebUtil.objectGson(listGeopoint);
            values.add(json);
            params.put("jsonGeopoint", values);
//            params.put("longitud", longitud);
//            params.put("glosa", glosa);
            RequestContext.getCurrentInstance().openDialog("cnt_directions", modalGoogleMapOptions, params);
        }
    }
    public void verCntRuta() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }
    public void verCntRutaMantenedor() {
        this.newRutas = new Rutas();
        this.newRutas.setIdempresa(user.getIDEMPRESA());
        this.newRutas.setEstado(1);
        RequestContext.getCurrentInstance().update("datos:rutas_mantenedor");
        RequestContext.getCurrentInstance().execute("PF('rutas_mantenedor').show()");
        //RequestContext.getCurrentInstance().openDialog("cntMantenedorRutas", modalOptions, null);
    }
    public void valorRuta(SelectEvent event) {
        this.setSelectRutas((Rutas) event.getObject());
        this.getRuta_servicios().setIdruta(this.selectRutas.getIdruta());
        this.getRuta_servicios().setRuta(this.selectRutas.getDescripcion());
    }
    public void valorRuta_detalle(SelectEvent event) {
        Rutas rs = (Rutas) event.getObject();
        this.getDordenserviciocliente().setIdruta_viaje(rs.getIdruta());
        this.getDordenserviciocliente().setRuta_viaje(rs.getDescripcion());
    }
    public void openGMap() {
        RequestContext.getCurrentInstance().openDialog("cnt_geocode", modalGoogleMapOptions, null);
    }
    public void valorGMap(SelectEvent event) {
        this.setSelectGmap((Gmap) event.getObject());
        this.getRuta_servicios().setLatitud(getSelectGmap().getLatitud());
        this.getRuta_servicios().setLongitud(getSelectGmap().getLongitud());
        RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios:latitud");
        RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios:longitud");
    }
    public void verCntUbigeoOrigen() {
        RequestContext.getCurrentInstance().openDialog("cntUbigeo", modalOptions, null);
    }

    public void valorUbigeoOrigen(SelectEvent event) {
        Ubigeo ob = (Ubigeo) event.getObject();
        getNewRutas().setOrigen(ob.getIdubigeo());
        getNewRutas().setOrigendesc(ob.getDescripcion());

    }

    public void verCntUbigeoDestino() {
        RequestContext.getCurrentInstance().openDialog("cntUbigeo", modalOptions, null);
    }

    public void valorUbigeoDestino(SelectEvent event) {
        Ubigeo ob = (Ubigeo) event.getObject();
        getNewRutas().setDestino(ob.getIdubigeo());
        getNewRutas().setDestinodesc(ob.getDescripcion());
    }
    public boolean validarEdicion_newruta() throws NisiraORMException {
        if (getNewRutas().getDescripcion() == null || getNewRutas().getDescripcion().equalsIgnoreCase("")) {
            WebUtil.MensajeAdvertencia("Ingrese Descripción de Ruta nueva");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        ArrayList<Rutas> lst_ru = (new RutasDao()).filtroPorEmpresaDescripcionWeb(user.getIDEMPRESA(),getNewRutas().getDescripcion());
        if(!lst_ru.isEmpty()){
            WebUtil.MensajeAdvertencia("Existe ruta con la misma descripción");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        return true;
    }
    public void grabarRutaNew() {
        try {
            if (validarEdicion_newruta()) {
                mensaje = (new RutasDao()).grabar(1, getNewRutas());
                if (mensaje != null) {
                    if (mensaje.trim().length() == 6) {
                        getNewRutas().setIdruta(mensaje.trim());
                    }
                }
                setMensaje(WebUtil.exitoRegistrar("Ruta ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                RequestContext.getCurrentInstance().execute("PF('rutas_mantenedor').hide()");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        ;
    }
    /***************** GENERADOR ID *********************/    
    public String agregarItemDordenservicio(){
        int dato = 1;
        int may=-999999999;
        for(Dordenserviciocliente obj:getLstdordenserviciocliente()){
            dato = Integer.parseInt(obj.getItem());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemPersonal_servicio(){
        int dato = 1;
        int may=-999999999;
        for(Personal_servicio obj:getListPersonal_Servicio()){
            dato = Integer.parseInt(obj.getItem2());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemPersonal_servicio_total(){
        int dato = 1;
        int may=-999999999;
        for(Personal_servicio obj:getListPersonalservicio_total()){
            dato = Integer.parseInt(obj.getItem2());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemDPersonal_servicio(){
        int dato = 1;
        int may=-999999999;
        for(Dpersonal_servicio obj:getListDpersonal_Servicio()){
            dato = Integer.parseInt(obj.getItem());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemRuta_servicios(){
        int dato = 1;
        int may=-999999999;
        for(Ruta_servicios obj:getListRuta_servicios()){
            dato = Integer.parseInt(obj.getItemruta());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public boolean esDetValida() {
        if (dordenserviciocliente.getItem().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Item del Detalle");
            return false;
        }
//        if (newAlmacen.getDIRECCION().equalsIgnoreCase("")) {
//            WebUtil.MensajeError("Ingrese Direccion de la Almacen");
//            return false;
//        }
//        if (newAlmacen.getNOMBRE_CORTO().equalsIgnoreCase("")) {
//            WebUtil.MensajeError("Ingrese Nombre Corto de la Almacen");
//            return false;
//        }
//        if (newAlmacen.getIDTIPOALMACEN() == 0) {
//            WebUtil.MensajeError("Ingrese Tipo Almacen");
//            return false;
//        }
        return true;
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 2);
        else
            return "";
    }
    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaprogramaciont() {
        return fechaprogramaciont;
    }

    public void setFechaprogramaciont(Date fechaprogramaciont) {
        this.fechaprogramaciont = fechaprogramaciont;
    }

    public Date getFechaejecuciont() {
        return fechaejecuciont;
    }

    public void setFechaejecuciont(Date fechaejecuciont) {
        this.fechaejecuciont = fechaejecuciont;
    }

    public Date getFechafinalizaciont() {
        return fechafinalizaciont;
    }

    public void setFechafinalizaciont(Date fechafinalizaciont) {
        this.fechafinalizaciont = fechafinalizaciont;
    }

    public List<Dordenserviciocliente> getLstdprogtlleg() {
        return getLstdordenserviciocliente();
    }

    public void setLstdprogtlleg(List<Dordenserviciocliente> lstdordenserviciocliente) {
        this.setLstdordenserviciocliente(lstdordenserviciocliente);
    }

    /**
     * @return the listClieprov
     */
    public List<Clieprov> getListClieprov() {
        return listClieprov;
    }

    /**
     * @param listClieprov the listClieprov to set
     */
    public void setListClieprov(List<Clieprov> listClieprov) {
        this.listClieprov = listClieprov;
    }

    /**
     * @return the listDocumentos
     */
    public List<Documentos> getListDocumentos() {
        return listDocumentos;
    }

    /**
     * @param listDocumentos the listDocumentos to set
     */
    public void setListDocumentos(List<Documentos> listDocumentos) {
        this.listDocumentos = listDocumentos;
    }

    /**
     * @return the listNumemisor
     */
    public List<Numemisor> getListNumemisor() {
        return listNumemisor;
    }

    /**
     * @param listNumemisor the listNumemisor to set
     */
    public void setListNumemisor(List<Numemisor> listNumemisor) {
        this.listNumemisor = listNumemisor;
    }

    /**
     * @return the lstdordenserviciocliente
     */
    public List<Dordenserviciocliente> getLstdordenserviciocliente() {
        return lstdordenserviciocliente;
    }

    /**
     * @param lstdordenserviciocliente the lstdordenserviciocliente to set
     */
    public void setLstdordenserviciocliente(List<Dordenserviciocliente> lstdordenserviciocliente) {
        this.lstdordenserviciocliente = lstdordenserviciocliente;
    }

    /**
     * @return the ordenservicioclienteDao
     */
    public OrdenservicioclienteDao getOrdenservicioclienteDao() {
        return ordenservicioclienteDao;
    }

    /**
     * @param ordenservicioclienteDao the ordenservicioclienteDao to set
     */
    public void setOrdenservicioclienteDao(OrdenservicioclienteDao ordenservicioclienteDao) {
        this.ordenservicioclienteDao = ordenservicioclienteDao;
    }

    /**
     * @return the docDao
     */
    public DocumentosDao getDocDao() {
        return docDao;
    }

    /**
     * @param docDao the docDao to set
     */
    public void setDocDao(DocumentosDao docDao) {
        this.docDao = docDao;
    }

    /**
     * @return the numemisorDao
     */
    public NumemisorDao getNumemisorDao() {
        return numemisorDao;
    }

    /**
     * @param numemisorDao the numemisorDao to set
     */
    public void setNumemisorDao(NumemisorDao numemisorDao) {
        this.numemisorDao = numemisorDao;
    }

    /**
     * @return the clieprovDao
     */
    public ClieprovDao getClieprovDao() {
        return clieprovDao;
    }

    /**
     * @param clieprovDao the clieprovDao to set
     */
    public void setClieprovDao(ClieprovDao clieprovDao) {
        this.clieprovDao = clieprovDao;
    }

    /**
     * @return the listEstado
     */
    public List<Estados> getListEstado() {
        return listEstado;
    }

    /**
     * @param listEstado the listEstado to set
     */
    public void setListEstado(List<Estados> listEstado) {
        this.listEstado = listEstado;
    }

    /**
     * @return the selectClieprov
     */
    public Clieprov getSelectClieprov() {
        return selectClieprov;
    }

    /**
     * @param selectClieprov the selectClieprov to set
     */
    public void setSelectClieprov(Clieprov selectClieprov) {
        this.selectClieprov = selectClieprov;
    }

    /**
     * @return the selecEstados
     */
    public Estados getSelecEstados() {
        return selecEstados;
    }

    /**
     * @param selecEstados the selecEstados to set
     */
    public void setSelecEstados(Estados selecEstados) {
        this.selecEstados = selecEstados;
    }

    /**
     * @return the dordenserviciocliente
     */
    public Dordenserviciocliente getDordenserviciocliente() {
        return dordenserviciocliente;
    }

    /**
     * @param dordenserviciocliente the dordenserviciocliente to set
     */
    public void setDordenserviciocliente(Dordenserviciocliente dordenserviciocliente) {
        this.dordenserviciocliente = dordenserviciocliente;
    }

    /**
     * @return the selectDordenserviciocliente
     */
    public Dordenserviciocliente getSelectDordenserviciocliente() {
        return selectDordenserviciocliente;
    }

    /**
     * @param selectDordenserviciocliente the selectDordenserviciocliente to set
     */
    public void setSelectDordenserviciocliente(Dordenserviciocliente selectDordenserviciocliente) {
        this.selectDordenserviciocliente = selectDordenserviciocliente;
    }

    /**
     * @return the selectConsumidor
     */
    public Consumidor getSelectConsumidor() {
        return selectConsumidor;
    }

    /**
     * @param selectConsumidor the selectConsumidor to set
     */
    public void setSelectConsumidor(Consumidor selectConsumidor) {
        this.selectConsumidor = selectConsumidor;
    }

    /**
     * @return the dordenservicioclienteDao
     */
    public DordenservicioclienteDao getDordenservicioclienteDao() {
        return dordenservicioclienteDao;
    }

    /**
     * @param dordenservicioclienteDao the dordenservicioclienteDao to set
     */
    public void setDordenservicioclienteDao(DordenservicioclienteDao dordenservicioclienteDao) {
        this.dordenservicioclienteDao = dordenservicioclienteDao;
    }

    /**
     * @return the estadosDao
     */
    public EstadosDao getEstadosDao() {
        return estadosDao;
    }

    /**
     * @param estadosDao the estadosDao to set
     */
    public void setEstadosDao(EstadosDao estadosDao) {
        this.estadosDao = estadosDao;
    }

    /**
     * @return the selectCotizacionventas
     */
    public Cotizacionventas getSelectCotizacionventas() {
        return selectCotizacionventas;
    }

    /**
     * @param selectCotizacionventas the selectCotizacionventas to set
     */
    public void setSelectCotizacionventas(Cotizacionventas selectCotizacionventas) {
        this.selectCotizacionventas = selectCotizacionventas;
    }

    /**
     * @return the listCotizacionventas
     */
    public List<Cotizacionventas> getListCotizacionventas() {
        return listCotizacionventas;
    }

    /**
     * @param listCotizacionventas the listCotizacionventas to set
     */
    public void setListCotizacionventas(List<Cotizacionventas> listCotizacionventas) {
        this.listCotizacionventas = listCotizacionventas;
    }

    /**
     * @return the listDcotizacionventas
     */
    public List<Dcotizacionventas> getListDcotizacionventas() {
        return listDcotizacionventas;
    }

    /**
     * @param listDcotizacionventas the listDcotizacionventas to set
     */
    public void setListDcotizacionventas(List<Dcotizacionventas> listDcotizacionventas) {
        this.listDcotizacionventas = listDcotizacionventas;
    }

    /**
     * @return the selectListDcotizacionventas
     */
    public List<Dcotizacionventas> getSelectListDcotizacionventas() {
        return selectListDcotizacionventas;
    }

    /**
     * @param selectListDcotizacionventas the selectListDcotizacionventas to set
     */
    public void setSelectListDcotizacionventas(List<Dcotizacionventas> selectListDcotizacionventas) {
        this.selectListDcotizacionventas = selectListDcotizacionventas;
    }

    /**
     * @return the cotizacionventasDao
     */
    public CotizacionventasDao getCotizacionventasDao() {
        return cotizacionventasDao;
    }

    /**
     * @param cotizacionventasDao the cotizacionventasDao to set
     */
    public void setCotizacionventasDao(CotizacionventasDao cotizacionventasDao) {
        this.cotizacionventasDao = cotizacionventasDao;
    }

    /**
     * @return the selectListCotizacionventas
     */
    public List<Cotizacionventas> getSelectListCotizacionventas() {
        return selectListCotizacionventas;
    }

    /**
     * @param selectListCotizacionventas the selectListCotizacionventas to set
     */
    public void setSelectListCotizacionventas(List<Cotizacionventas> selectListCotizacionventas) {
        this.selectListCotizacionventas = selectListCotizacionventas;
    }

    /**
     * @return the listDocreferencia
     */
    public List<Docreferencia> getListDocreferencia() {
        return listDocreferencia;
    }

    /**
     * @param listDocreferencia the listDocreferencia to set
     */
    public void setListDocreferencia(List<Docreferencia> listDocreferencia) {
        this.listDocreferencia = listDocreferencia;
    }

    /**
     * @return the docreferenciaDao
     */
    public DocreferenciaDao getDocreferenciaDao() {
        return docreferenciaDao;
    }

    /**
     * @param docreferenciaDao the docreferenciaDao to set
     */
    public void setDocreferenciaDao(DocreferenciaDao docreferenciaDao) {
        this.docreferenciaDao = docreferenciaDao;
    }

    /**
     * @return the selectDocreferencia
     */
    public Docreferencia getSelectDocreferencia() {
        return selectDocreferencia;
    }

    /**
     * @param selectDocreferencia the selectDocreferencia to set
     */
    public void setSelectDocreferencia(Docreferencia selectDocreferencia) {
        this.selectDocreferencia = selectDocreferencia;
    }

    /**
     * @return the botonEditarDOrdenservicio
     */
    public boolean isBotonEditarDOrdenservicio() {
        return botonEditarDOrdenservicio;
    }

    /**
     * @param botonEditarDOrdenservicio the botonEditarDOrdenservicio to set
     */
    public void setBotonEditarDOrdenservicio(boolean botonEditarDOrdenservicio) {
        this.botonEditarDOrdenservicio = botonEditarDOrdenservicio;
    }

    /**
     * @return the botonEliminarDOrdenservicio
     */
    public boolean isBotonEliminarDOrdenservicio() {
        return botonEliminarDOrdenservicio;
    }

    /**
     * @param botonEliminarDOrdenservicio the botonEliminarDOrdenservicio to set
     */
    public void setBotonEliminarDOrdenservicio(boolean botonEliminarDOrdenservicio) {
        this.botonEliminarDOrdenservicio = botonEliminarDOrdenservicio;
    }

    /**
     * @return the personal_servicioDao
     */
    public Personal_servicioDao getPersonal_servicioDao() {
        return personal_servicioDao;
    }

    /**
     * @param personal_servicioDao the personal_servicioDao to set
     */
    public void setPersonal_servicioDao(Personal_servicioDao personal_servicioDao) {
        this.personal_servicioDao = personal_servicioDao;
    }

    /**
     * @return the listPersonal_Servicio
     */
    public List<Personal_servicio> getListPersonal_Servicio() {
        return listPersonal_Servicio;
    }

    /**
     * @param listPersonal_Servicio the listPersonal_Servicio to set
     */
    public void setListPersonal_Servicio(List<Personal_servicio> listPersonal_Servicio) {
        this.listPersonal_Servicio = listPersonal_Servicio;
    }

    /**
     * @return the selectPersonal_servicio
     */
    public Personal_servicio getSelectPersonal_servicio() {
        return selectPersonal_servicio;
    }

    /**
     * @param selectPersonal_servicio the selectPersonal_servicio to set
     */
    public void setSelectPersonal_servicio(Personal_servicio selectPersonal_servicio) {
        this.selectPersonal_servicio = selectPersonal_servicio;
    }

    /**
     * @return the botonNuevoPersonal_servicio
     */
    public boolean isBotonNuevoPersonal_servicio() {
        return botonNuevoPersonal_servicio;
    }

    /**
     * @param botonNuevoPersonal_servicio the botonNuevoPersonal_servicio to set
     */
    public void setBotonNuevoPersonal_servicio(boolean botonNuevoPersonal_servicio) {
        this.botonNuevoPersonal_servicio = botonNuevoPersonal_servicio;
    }

    /**
     * @return the botonEditarPersonal_servicio
     */
    public boolean isBotonEditarPersonal_servicio() {
        return botonEditarPersonal_servicio;
    }

    /**
     * @param botonEditarPersonal_servicio the botonEditarPersonal_servicio to set
     */
    public void setBotonEditarPersonal_servicio(boolean botonEditarPersonal_servicio) {
        this.botonEditarPersonal_servicio = botonEditarPersonal_servicio;
    }

    /**
     * @return the botonEliminarPersonal_servicio
     */
    public boolean isBotonEliminarPersonal_servicio() {
        return botonEliminarPersonal_servicio;
    }

    /**
     * @param botonEliminarPersonal_servicio the botonEliminarPersonal_servicio to set
     */
    public void setBotonEliminarPersonal_servicio(boolean botonEliminarPersonal_servicio) {
        this.botonEliminarPersonal_servicio = botonEliminarPersonal_servicio;
    }

    /**
     * @return the personal_servicio
     */
    public Personal_servicio getPersonal_servicio() {
        return personal_servicio;
    }

    /**
     * @param personal_servicio the personal_servicio to set
     */
    public void setPersonal_servicio(Personal_servicio personal_servicio) {
        this.personal_servicio = personal_servicio;
    }

    /**
     * @return the selectClieprovPersonal
     */
    public Clieprov getSelectClieprovPersonal() {
        return selectClieprovPersonal;
    }

    /**
     * @param selectClieprovPersonal the selectClieprovPersonal to set
     */
    public void setSelectClieprovPersonal(Clieprov selectClieprovPersonal) {
        this.selectClieprovPersonal = selectClieprovPersonal;
    }

    /**
     * @return the listRuta_servicios
     */
    public List<Ruta_servicios> getListRuta_servicios() {
        return listRuta_servicios;
    }

    /**
     * @param listRuta_servicios the listRuta_servicios to set
     */
    public void setListRuta_servicios(List<Ruta_servicios> listRuta_servicios) {
        this.listRuta_servicios = listRuta_servicios;
    }

    /**
     * @return the ruta_serviciosDao
     */
    public Ruta_serviciosDao getRuta_serviciosDao() {
        return ruta_serviciosDao;
    }

    /**
     * @param ruta_serviciosDao the ruta_serviciosDao to set
     */
    public void setRuta_serviciosDao(Ruta_serviciosDao ruta_serviciosDao) {
        this.ruta_serviciosDao = ruta_serviciosDao;
    }

    /**
     * @return the selectRuta_servicios
     */
    public Ruta_servicios getSelectRuta_servicios() {
        return selectRuta_servicios;
    }

    /**
     * @param selectRuta_servicios the selectRuta_servicios to set
     */
    public void setSelectRuta_servicios(Ruta_servicios selectRuta_servicios) {
        this.selectRuta_servicios = selectRuta_servicios;
    }

    /**
     * @return the botonNuevoRuta_servicios
     */
    public boolean isBotonNuevoRuta_servicios() {
        return botonNuevoRuta_servicios;
    }

    /**
     * @param botonNuevoRuta_servicios the botonNuevoRuta_servicios to set
     */
    public void setBotonNuevoRuta_servicios(boolean botonNuevoRuta_servicios) {
        this.botonNuevoRuta_servicios = botonNuevoRuta_servicios;
    }

    /**
     * @return the botonEditarRuta_servicios
     */
    public boolean isBotonEditarRuta_servicios() {
        return botonEditarRuta_servicios;
    }

    /**
     * @param botonEditarRuta_servicios the botonEditarRuta_servicios to set
     */
    public void setBotonEditarRuta_servicios(boolean botonEditarRuta_servicios) {
        this.botonEditarRuta_servicios = botonEditarRuta_servicios;
    }

    /**
     * @return the botonEliminarRuta_servicios
     */
    public boolean isBotonEliminarRuta_servicios() {
        return botonEliminarRuta_servicios;
    }

    /**
     * @param botonEliminarRuta_servicios the botonEliminarRuta_servicios to set
     */
    public void setBotonEliminarRuta_servicios(boolean botonEliminarRuta_servicios) {
        this.botonEliminarRuta_servicios = botonEliminarRuta_servicios;
    }

    /**
     * @return the ruta_servicios
     */
    public Ruta_servicios getRuta_servicios() {
        return ruta_servicios;
    }

    /**
     * @param ruta_servicios the ruta_servicios to set
     */
    public void setRuta_servicios(Ruta_servicios ruta_servicios) {
        this.ruta_servicios = ruta_servicios;
    }

    /**
     * @return the selectRutas
     */
    public Rutas getSelectRutas() {
        return selectRutas;
    }

    /**
     * @param selectRutas the selectRutas to set
     */
    public void setSelectRutas(Rutas selectRutas) {
        this.selectRutas = selectRutas;
    }

    /**
     * @return the selectGmap
     */
    public Gmap getSelectGmap() {
        return selectGmap;
    }

    /**
     * @param selectGmap the selectGmap to set
     */
    public void setSelectGmap(Gmap selectGmap) {
        this.selectGmap = selectGmap;
    }

    /**
     * @return the dpersonal_servicio
     */
    public Dpersonal_servicio getDpersonal_servicio() {
        return dpersonal_servicio;
    }

    /**
     * @param dpersonal_servicio the dpersonal_servicio to set
     */
    public void setDpersonal_servicio(Dpersonal_servicio dpersonal_servicio) {
        this.dpersonal_servicio = dpersonal_servicio;
    }

    /**
     * @return the listDpersonal_Servicio
     */
    public List<Dpersonal_servicio> getListDpersonal_Servicio() {
        return listDpersonal_Servicio;
    }

    /**
     * @param listDpersonal_Servicio the listDpersonal_Servicio to set
     */
    public void setListDpersonal_Servicio(List<Dpersonal_servicio> listDpersonal_Servicio) {
        this.listDpersonal_Servicio = listDpersonal_Servicio;
    }

    /**
     * @return the selectDPersonal_servicio
     */
    public Dpersonal_servicio getSelectDPersonal_servicio() {
        return selectDPersonal_servicio;
    }

    /**
     * @param selectDPersonal_servicio the selectDPersonal_servicio to set
     */
    public void setSelectDPersonal_servicio(Dpersonal_servicio selectDPersonal_servicio) {
        this.selectDPersonal_servicio = selectDPersonal_servicio;
    }

    /**
     * @return the botonNuevoDPersonal_servicio
     */
    public boolean isBotonNuevoDPersonal_servicio() {
        return botonNuevoDPersonal_servicio;
    }

    /**
     * @param botonNuevoDPersonal_servicio the botonNuevoDPersonal_servicio to set
     */
    public void setBotonNuevoDPersonal_servicio(boolean botonNuevoDPersonal_servicio) {
        this.botonNuevoDPersonal_servicio = botonNuevoDPersonal_servicio;
    }

    /**
     * @return the botonEditarDPersonal_servicio
     */
    public boolean isBotonEditarDPersonal_servicio() {
        return botonEditarDPersonal_servicio;
    }

    /**
     * @param botonEditarDPersonal_servicio the botonEditarDPersonal_servicio to set
     */
    public void setBotonEditarDPersonal_servicio(boolean botonEditarDPersonal_servicio) {
        this.botonEditarDPersonal_servicio = botonEditarDPersonal_servicio;
    }

    /**
     * @return the botonEliminarDPersonal_servicio
     */
    public boolean isBotonEliminarDPersonal_servicio() {
        return botonEliminarDPersonal_servicio;
    }

    /**
     * @param botonEliminarDPersonal_servicio the botonEliminarDPersonal_servicio to set
     */
    public void setBotonEliminarDPersonal_servicio(boolean botonEliminarDPersonal_servicio) {
        this.botonEliminarDPersonal_servicio = botonEliminarDPersonal_servicio;
    }

    /**
     * @return the listDcotizacionventas_actividades
     */
    public List<Dcotizacionventas_actividades> getListDcotizacionventas_actividades() {
        return listDcotizacionventas_actividades;
    }

    /**
     * @param listDcotizacionventas_actividades the listDcotizacionventas_actividades to set
     */
    public void setListDcotizacionventas_actividades(List<Dcotizacionventas_actividades> listDcotizacionventas_actividades) {
        this.listDcotizacionventas_actividades = listDcotizacionventas_actividades;
    }

    /**
     * @return the dpersonal_servicioDao
     */
    public Dpersonal_servicioDao getDpersonal_servicioDao() {
        return dpersonal_servicioDao;
    }

    /**
     * @param dpersonal_servicioDao the dpersonal_servicioDao to set
     */
    public void setDpersonal_servicioDao(Dpersonal_servicioDao dpersonal_servicioDao) {
        this.dpersonal_servicioDao = dpersonal_servicioDao;
    }

    /**
     * @return the dcotizacionventas_actividadesdao
     */
    public Dcotizacionventas_actividadesDao getDcotizacionventas_actividadesdao() {
        return dcotizacionventas_actividadesdao;
    }

    /**
     * @param dcotizacionventas_actividadesdao the dcotizacionventas_actividadesdao to set
     */
    public void setDcotizacionventas_actividadesdao(Dcotizacionventas_actividadesDao dcotizacionventas_actividadesdao) {
        this.dcotizacionventas_actividadesdao = dcotizacionventas_actividadesdao;
    }

    /**
     * @return the dcotizacionventasDao
     */
    public DcotizacionventasDao getDcotizacionventasDao() {
        return dcotizacionventasDao;
    }

    /**
     * @param dcotizacionventasDao the dcotizacionventasDao to set
     */
    public void setDcotizacionventasDao(DcotizacionventasDao dcotizacionventasDao) {
        this.dcotizacionventasDao = dcotizacionventasDao;
    }

    /**
     * @return the selectListOrdenserviciocliente
     */
    public List<Ordenserviciocliente> getSelectListOrdenserviciocliente() {
        return selectListOrdenserviciocliente;
    }

    /**
     * @param selectListOrdenserviciocliente the selectListOrdenserviciocliente to set
     */
    public void setSelectListOrdenserviciocliente(List<Ordenserviciocliente> selectListOrdenserviciocliente) {
        this.selectListOrdenserviciocliente = selectListOrdenserviciocliente;
    }
    /**
     * @return the motivosproduccionDao
     */
    public MotivosproduccionDao getMotivosproduccionDao() {
        return motivosproduccionDao;
    }

    /**
     * @param motivosproduccionDao the motivosproduccionDao to set
     */
    public void setMotivosproduccionDao(MotivosproduccionDao motivosproduccionDao) {
        this.motivosproduccionDao = motivosproduccionDao;
    }

    /**
     * @return the listMotivoproduccion
     */
    public List<Motivosproduccion> getListMotivoproduccion() {
        return listMotivoproduccion;
    }

    /**
     * @param listMotivoproduccion the listMotivoproduccion to set
     */
    public void setListMotivoproduccion(List<Motivosproduccion> listMotivoproduccion) {
        this.listMotivoproduccion = listMotivoproduccion;
    }

    /**
     * @return the botonNuevoDOrdenservicio
     */
    public boolean isBotonNuevoDOrdenservicio() {
        return botonNuevoDOrdenservicio;
    }

    /**
     * @param botonNuevoDOrdenservicio the botonNuevoDOrdenservicio to set
     */
    public void setBotonNuevoDOrdenservicio(boolean botonNuevoDOrdenservicio) {
        this.botonNuevoDOrdenservicio = botonNuevoDOrdenservicio;
    }

    /**
     * @return the fclieprov
     */
    public boolean isFclieprov() {
        return fclieprov;
    }

    /**
     * @param fclieprov the fclieprov to set
     */
    public void setFclieprov(boolean fclieprov) {
        this.fclieprov = fclieprov;
    }

    /**
     * @return the fdocreferencia
     */
    public boolean isFdocreferencia() {
        return fdocreferencia;
    }

    /**
     * @param fdocreferencia the fdocreferencia to set
     */
    public void setFdocreferencia(boolean fdocreferencia) {
        this.fdocreferencia = fdocreferencia;
    }

    /**
     * @return the ftabdetalleordenservicio
     */
    public boolean isFtabdetalleordenservicio() {
        return ftabdetalleordenservicio;
    }

    /**
     * @param ftabdetalleordenservicio the ftabdetalleordenservicio to set
     */
    public void setFtabdetalleordenservicio(boolean ftabdetalleordenservicio) {
        this.ftabdetalleordenservicio = ftabdetalleordenservicio;
    }

    /**
     * @return the ftabpersonalservicio
     */
    public boolean isFtabpersonalservicio() {
        return ftabpersonalservicio;
    }

    /**
     * @param ftabpersonalservicio the ftabpersonalservicio to set
     */
    public void setFtabpersonalservicio(boolean ftabpersonalservicio) {
        this.ftabpersonalservicio = ftabpersonalservicio;
    }

    /**
     * @return the ftabrutas
     */
    public boolean isFtabrutas() {
        return ftabrutas;
    }

    /**
     * @param ftabrutas the ftabrutas to set
     */
    public void setFtabrutas(boolean ftabrutas) {
        this.ftabrutas = ftabrutas;
    }
    /**
     * @return the selectProducto
     */
    public Producto getSelectProducto() {
        return selectProducto;
    }

    /**
     * @param selectProducto the selectProducto to set
     */
    public void setSelectProducto(Producto selectProducto) {
        this.selectProducto = selectProducto;
    }
    
    /**
     * @return the fproducto
     */
    public boolean isFproducto() {
        return fproducto;
    }

    /**
     * @param fproducto the fproducto to set
     */
    public void setFproducto(boolean fproducto) {
        this.fproducto = fproducto;
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the listEstructura_costos_mano_obra_cotizacionventas
     */
    public List<Estructura_costos_mano_obra_cotizacionventas> getListEstructura_costos_mano_obra_cotizacionventas() {
        return listEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @param listEstructura_costos_mano_obra_cotizacionventas the listEstructura_costos_mano_obra_cotizacionventas to set
     */
    public void setListEstructura_costos_mano_obra_cotizacionventas(List<Estructura_costos_mano_obra_cotizacionventas> listEstructura_costos_mano_obra_cotizacionventas) {
        this.listEstructura_costos_mano_obra_cotizacionventas = listEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @return the estructura_costos_mano_obra_cotizacionventasDao
     */
    public Estructura_costos_mano_obra_cotizacionventasDao getEstructura_costos_mano_obra_cotizacionventasDao() {
        return estructura_costos_mano_obra_cotizacionventasDao;
    }

    /**
     * @param estructura_costos_mano_obra_cotizacionventasDao the estructura_costos_mano_obra_cotizacionventasDao to set
     */
    public void setEstructura_costos_mano_obra_cotizacionventasDao(Estructura_costos_mano_obra_cotizacionventasDao estructura_costos_mano_obra_cotizacionventasDao) {
        this.estructura_costos_mano_obra_cotizacionventasDao = estructura_costos_mano_obra_cotizacionventasDao;
    }

    /**
     * @return the idestadoCot
     */
    public String getIdestadoCot() {
        return idestadoCot;
    }

    /**
     * @param idestadoCot the idestadoCot to set
     */
    public void setIdestadoCot(String idestadoCot) {
        this.idestadoCot = idestadoCot;
    }

    /**
     * @return the listPersonalservicio_total
     */
    public List<Personal_servicio> getListPersonalservicio_total() {
        return listPersonalservicio_total;
    }

    /**
     * @param listPersonalservicio_total the listPersonalservicio_total to set
     */
    public void setListPersonalservicio_total(List<Personal_servicio> listPersonalservicio_total) {
        this.listPersonalservicio_total = listPersonalservicio_total;
    }

    /**
     * @return the listDpersonalservicio_total
     */
    public List<Dpersonal_servicio> getListDpersonalservicio_total() {
        return listDpersonalservicio_total;
    }

    /**
     * @param listDpersonalservicio_total the listDpersonalservicio_total to set
     */
    public void setListDpersonalservicio_total(List<Dpersonal_servicio> listDpersonalservicio_total) {
        this.listDpersonalservicio_total = listDpersonalservicio_total;
    }

    /**
     * @return the listRutas
     */
    public List<Ruta_servicios> getListRutasTotales() {
        return listRutasTotales;
    }

    /**
     * @param listRutas the listRutas to set
     */
    public void setListRutasTotales(List<Ruta_servicios> listRutasTotales) {
        this.listRutasTotales = listRutasTotales;
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the num_repetir
     */
    public int getNum_repetir() {
        return num_repetir;
    }

    /**
     * @param num_repetir the num_repetir to set
     */
    public void setNum_repetir(int num_repetir) {
        this.num_repetir = num_repetir;
    }

    /**
     * @return the listCargo_personal
     */
    public List<Cargos_personal> getListCargo_personal() {
        return listCargo_personal;
    }

    /**
     * @param listCargo_personal the listCargo_personal to set
     */
    public void setListCargo_personal(List<Cargos_personal> listCargo_personal) {
        this.listCargo_personal = listCargo_personal;
    }

    /**
     * @return the cargos_personalDao
     */
    public Cargos_personalDao getCargos_personalDao() {
        return cargos_personalDao;
    }

    /**
     * @param cargos_personalDao the cargos_personalDao to set
     */
    public void setCargos_personalDao(Cargos_personalDao cargos_personalDao) {
        this.cargos_personalDao = cargos_personalDao;
    }

    /**
     * @return the selectCargos_personal
     */
    public Cargos_personal getSelectCargos_personal() {
        return selectCargos_personal;
    }

    /**
     * @param selectCargos_personal the selectCargos_personal to set
     */
    public void setSelectCargos_personal(Cargos_personal selectCargos_personal) {
        this.selectCargos_personal = selectCargos_personal;
    }

    /**
     * @return the ftipo_servicio
     */
    public boolean isFtipo_servicio() {
        return ftipo_servicio;
    }

    /**
     * @param ftipo_servicio the ftipo_servicio to set
     */
    public void setFtipo_servicio(boolean ftipo_servicio) {
        this.ftipo_servicio = ftipo_servicio;
    }

    /**
     * @return the fmotivo_rc
     */
    public boolean isFmotivo_rc() {
        return fmotivo_rc;
    }

    /**
     * @param fmotivo_rc the fmotivo_rc to set
     */
    public void setFmotivo_rc(boolean fmotivo_rc) {
        this.fmotivo_rc = fmotivo_rc;
    }

    /**
     * @return the fnum_repetir
     */
    public boolean isFnum_repetir() {
        return fnum_repetir;
    }

    /**
     * @param fnum_repetir the fnum_repetir to set
     */
    public void setFnum_repetir(boolean fnum_repetir) {
        this.fnum_repetir = fnum_repetir;
    }

    /**
     * @return the selectCodoperaciones_pss
     */
    public Codoperaciones_pss getSelectCodoperaciones_pss() {
        return selectCodoperaciones_pss;
    }

    /**
     * @param selectCodoperaciones_pss the selectCodoperaciones_pss to set
     */
    public void setSelectCodoperaciones_pss(Codoperaciones_pss selectCodoperaciones_pss) {
        this.selectCodoperaciones_pss = selectCodoperaciones_pss;
    }

    /**
     * @return the lstHoras
     */
    public List<Float> getLstHoras() {
        return lstHoras;
    }

    /**
     * @param lstHoras the lstHoras to set
     */
    public void setLstHoras(List<Float> lstHoras) {
        this.lstHoras = lstHoras;
    }

    /**
     * @return the lstComboRutas
     */
    public List<Rutas> getLstComboRutas() {
        return lstComboRutas;
    }

    /**
     * @param lstComboRutas the lstComboRutas to set
     */
    public void setLstComboRutas(List<Rutas> lstComboRutas) {
        this.lstComboRutas = lstComboRutas;
    }

    /**
     * @return the estructura_costos_productoDao
     */
    public Estructura_costos_productoDao getEstructura_costos_productoDao() {
        return estructura_costos_productoDao;
    }

    /**
     * @param estructura_costos_productoDao the estructura_costos_productoDao to set
     */
    public void setEstructura_costos_productoDao(Estructura_costos_productoDao estructura_costos_productoDao) {
        this.estructura_costos_productoDao = estructura_costos_productoDao;
    }

    /**
     * @return the rutasDao
     */
    public RutasDao getRutasDao() {
        return rutasDao;
    }

    /**
     * @param rutasDao the rutasDao to set
     */
    public void setRutasDao(RutasDao rutasDao) {
        this.rutasDao = rutasDao;
    }

    /**
     * @return the estructura_costos_mano_obraDao
     */
    public Estructura_costos_mano_obraDao getEstructura_costos_mano_obraDao() {
        return estructura_costos_mano_obraDao;
    }

    /**
     * @param estructura_costos_mano_obraDao the estructura_costos_mano_obraDao to set
     */
    public void setEstructura_costos_mano_obraDao(Estructura_costos_mano_obraDao estructura_costos_mano_obraDao) {
        this.estructura_costos_mano_obraDao = estructura_costos_mano_obraDao;
    }

    /**
     * @return the num_repetir_detalle
     */
    public int getNum_repetir_detalle() {
        return num_repetir_detalle;
    }

    /**
     * @param num_repetir_detalle the num_repetir_detalle to set
     */
    public void setNum_repetir_detalle(int num_repetir_detalle) {
        this.num_repetir_detalle = num_repetir_detalle;
    }

    /**
     * @return the listAmbito_pago
     */
    public List<Ambito_pago> getListAmbito_pago() {
        return listAmbito_pago;
    }

    /**
     * @param listAmbito_pago the listAmbito_pago to set
     */
    public void setListAmbito_pago(List<Ambito_pago> listAmbito_pago) {
        this.listAmbito_pago = listAmbito_pago;
    }

    /**
     * @return the ambito_pagodao
     */
    public Ambito_pagoDao getAmbito_pagodao() {
        return ambito_pagodao;
    }

    /**
     * @param ambito_pagodao the ambito_pagodao to set
     */
    public void setAmbito_pagodao(Ambito_pagoDao ambito_pagodao) {
        this.ambito_pagodao = ambito_pagodao;
    }

    /**
     * @return the log_consola
     */
    public String getLog_consola() {
        return log_consola;
    }

    /**
     * @param log_consola the log_consola to set
     */
    public void setLog_consola(String log_consola) {
        this.log_consola = log_consola;
    }

    /**
     * @return the listDet_tareo_verificacion
     */
    public List<Det_tareoweb> getListDet_tareo_verificacion() {
        return listDet_tareo_verificacion;
    }

    /**
     * @param listDet_tareo_verificacion the listDet_tareo_verificacion to set
     */
    public void setListDet_tareo_verificacion(List<Det_tareoweb> listDet_tareo_verificacion) {
        this.listDet_tareo_verificacion = listDet_tareo_verificacion;
    }

    /**
     * @return the cabercerDet_tareoweb
     */
    public Det_tareoweb getCabercerDet_tareoweb() {
        return cabercerDet_tareoweb;
    }

    /**
     * @param cabercerDet_tareoweb the cabercerDet_tareoweb to set
     */
    public void setCabercerDet_tareoweb(Det_tareoweb cabercerDet_tareoweb) {
        this.cabercerDet_tareoweb = cabercerDet_tareoweb;
    }

    /**
     * @return the newRutas
     */
    public Rutas getNewRutas() {
        return newRutas;
    }

    /**
     * @param newRutas the newRutas to set
     */
    public void setNewRutas(Rutas newRutas) {
        this.newRutas = newRutas;
    }

}