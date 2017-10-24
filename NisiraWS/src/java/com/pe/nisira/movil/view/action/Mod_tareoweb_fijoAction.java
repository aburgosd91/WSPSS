/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.CabtareowebDao;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_tareoDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
import com.nisira.core.dao.Estructura_costos_producto_diasrangoDao;
import com.nisira.core.dao.ImpuestoDao;
import com.nisira.core.dao.MonedaDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.MotivosproduccionDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.PlanctasDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.Tipo_asistenciaDao;
import com.nisira.core.dao.TipodetraccionDao;
import com.nisira.core.dao.TiporegimenDao;
import com.nisira.core.dao.Turno_trabajoDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Cabtareoweb;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_tareo;
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
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Estructura_costos_producto_diasrango;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Impuesto;
import com.nisira.core.entity.LogTablas;
import com.nisira.core.entity.Moneda;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Planctas;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Programacion;
import com.nisira.core.entity.Reporte_facturacion;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tipo_asistencia;
import com.nisira.core.entity.Tipodetraccion;
import com.nisira.core.entity.Tiporegimen;
import com.nisira.core.entity.Turno_trabajo;
import com.nisira.core.entity.Wtiposervicio;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.ComboEspecial;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.helpers.HSSFRowShifter;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DataFormat;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "mod_tareoweb_fijoAction")
@SessionScoped
public class Mod_tareoweb_fijoAction extends AbstactListAction<Cabtareoweb> {
    private String selectComboEspecial_idordenservicio;
    private String selectComboEspecialDetalle_idordenservicio;
    /*************************************ArrayList***************************************/
    private List<Documentos> listDocumentos;
    private List<Det_tareoweb> listDet_tareoweb;
    private List<Turno_trabajo> listTurno_trabajo;
    private List<Programacion> listProgramacion;
    private List<Tipo_asistencia> listTipo_asistencia;
    private List<Estados> listEstado;
    private List<Almacenes> listAlmacenes;
    private List<Numemisor> listNumemisor;
    private List<Concepto_tareo> listConcepto_tareo;
    private ArrayList<String> lista_solution;
    private List<Personal_servicio> listPersonal_servicio;
    private List<ComboEspecial> listComboEspecial;
    private List<ComboEspecial> listComboEspecialDetalle;
    private List<Clieprov> listPersonal;
    private List<Estructura_costos_producto_diasrango> listEstructura_costos_producto_diasrango;
    private List<LogTablas> listLogtablas;
    /*************************************DAO***************************************/
    private DocumentosDao documentoDao;
    private Det_tareowebDao det_tareoweb_verificationDao; 
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private EstadosDao estadosDao;
    private SucursalesDao sucursalesDao;
    private AlmacenesDao alamcenesDao;
    private EmisorDao emisorDao;
    private CabtareowebDao cabtareowebDao;
    private Det_tareowebDao det_tareowebDao;
    private Turno_trabajoDao turno_trabajoDao;
    private Tipo_asistenciaDao tipo_asistenciaDao;
    private UsuarioDao usuariodao;
    private Concepto_tareoDao concepto_tareoDao; 
    private Det_tareowebDao tareoWebDao;
    private ConsumidorDao consumidorDao;
    private ClieprovDao clieprovDao;
    private Estructura_costos_producto_diasrangoDao estructura_costos_producto_diasrangoDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String mensaje;
    private Det_tareoweb cabercerDet_tareoweb;
    private Det_tareoweb selectDet_tareoweb;
    private String iddocumento_local;
    private String serie_local;
    private String numero_local;
    private String numero;
    private String periodoBase;
    private String periodoDisenio;
    private String mesNumeroDisenio;
    private String mesNombreDisenio;
    private Clieprov selectClieprovPersonal;
    private Personal_servicio selectPersonal_servicio;
    private boolean btn_asignar_personal;
    private ComboEspecial selectComboEspecial;
    private Cargos_personal selectCargo_personal;
    private int num_repetir;
    private String glosa_local;
    private int posSelect_det_tareoweb;
    private String log_consola;
    /************************************* CONTROLES *****************************************/
    private String type_formato_rpt;
    private Float scosto;
    private Date filtroFecha;
    private Date finicio;
    private Date ffin;
    private Date restricDate;
    private String numdia;
    private LogTablas log;
    public Mod_tareoweb_fijoAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            mensaje = "";
            filtroFecha = new Date();
            finicio=WebUtil.getDateIni();
            ffin=new Date();
            numdia = generarDiaid(filtroFecha);
            btn_asignar_personal = true;
            num_repetir = 1;
            /********************************* LISTAS *******************************************/
            listDocumentos =  new ArrayList<>();
            lista_solution  = new ArrayList<>();
            listAlmacenes = new ArrayList<>();
            listDet_tareoweb = new ArrayList<>();
            listEstado = new ArrayList<>();
            lista_solution  = new ArrayList<>();
            listTurno_trabajo  = new ArrayList<>();
            listProgramacion  = new ArrayList<>();
            listTipo_asistencia  = new ArrayList<>();
            listConcepto_tareo  = new ArrayList<>();
            listLogtablas = new ArrayList<>(); 
            /********************************* DAO **********************************************/
            documentoDao = new DocumentosDao();
            det_tareoweb_verificationDao = new Det_tareowebDao();
            tareoWebDao = new Det_tareowebDao();
            cabtareowebDao = new CabtareowebDao();
            det_tareowebDao = new Det_tareowebDao();
            docDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            estadosDao = new EstadosDao();
            alamcenesDao = new AlmacenesDao();
            sucursalesDao = new SucursalesDao();
            emisorDao = new EmisorDao();
            turno_trabajoDao = new Turno_trabajoDao();
            tipo_asistenciaDao = new Tipo_asistenciaDao();
            usuariodao = new UsuarioDao();
            concepto_tareoDao = new Concepto_tareoDao();
            clieprovDao = new ClieprovDao();
            consumidorDao = new ConsumidorDao();
            estructura_costos_producto_diasrangoDao = new Estructura_costos_producto_diasrangoDao();
            /**********************************CONTROLADOR*************************************/
            listDocumentos = documentoDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            periodoBase = dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            periodoDisenio = dateFormat.format(new Date());
            mesNumeroDisenio = WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            mesNombreDisenio = WebUtil.strMonths[(new Date()).getMonth()];
            
            /********************************** CONFIGURACIÓN - SERVIDOR ***********************/
            
            listDocumentos=docDao.getCabtareoweb(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listTurno_trabajo = turno_trabajoDao.getPorTurno_trabajo();
            listTipo_asistencia = tipo_asistenciaDao.getPorTipo_asistencia(user.getIDEMPRESA());
            listConcepto_tareo = concepto_tareoDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            lista_solution=CoreUtil.valoresBase();
        }catch (Exception ex) {
            Logger.getLogger(Mod_tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiza_ventana("wMnt_Tareoweb");
    }
    public void actionBotonFiltro(){
        try {
            if(filtroFecha!=null){
                /* VERIFICAR CABECERA TAREO CREADO */
                numdia = generarDiaid(filtroFecha);
                SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
                String f_filtro = f.format(filtroFecha);
                f_filtro = f_filtro.replace("-", "");
                List<Cabtareoweb> ls =cabtareowebDao.listarPorEmpresaWebFiltroFecha_Fijo(user.getIDEMPRESA(),f_filtro,f_filtro,user.getIDUSUARIO());
                if(ls.isEmpty()){
                    /*CREAR DOCUMENTO DE TAREO*/
                    setDatoEdicion(new Cabtareoweb());
                    getDatoEdicion().setIdempresa(user.getIDEMPRESA());
                    getDatoEdicion().setFecha(filtroFecha);
                    getDatoEdicion().setIdsucursal(Constantes.getIDSUCURSALGENERAL());
                    getDatoEdicion().setPeriodo(periodoDisenio);
                    getDatoEdicion().setMes(mesNombreDisenio);
                    getDatoEdicion().setNumero(numero);
                    getDatoEdicion().setIdemisor(lista_solution.get(5));
                    getDatoEdicion().setIdusuario(user.getIDUSUARIO());
                    getDatoEdicion().setUsuario(user.getNombres());
                    getDatoEdicion().setFinicio(filtroFecha);
                    getDatoEdicion().setFfin(filtroFecha);
                    getDatoEdicion().setIdestado("PE");
                    getDatoEdicion().setIdresponsable(user.getIDUSUARIO());
                    Clieprov us = usuariodao.getUsuarioCliente(user.getIDUSUARIO());
                    if(us!=null){
                        getDatoEdicion().setIdresponsable(us.getIdclieprov());
                        getDatoEdicion().setResponsable(us.getRazonsocial());
                    }
                    String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
                    getDatoEdicion().setEmisor(emisor);
                    String sucursal = sucursalesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
                    getDatoEdicion().setSucursal(sucursal);
                    if(!listAlmacenes.isEmpty())
                        getDatoEdicion().setIdalmacen(listAlmacenes.get(0).getIdalmacen());
                    if(!listNumemisor.isEmpty()){
                        getDatoEdicion().setIddocumento(listNumemisor.get(0).getIddocumento());
                        getDatoEdicion().setSerie(listNumemisor.get(0).getSerie());
                    }
                    /*CREAR EL DETALLE TAREO*/
                    getDatoEdicion().setIdtipoasistencia("ASN");
                    listDet_tareoweb = new ArrayList<>();
                    List<Det_tareoweb> lsql =  tareoWebDao.listarPorEmpresaWeb_new_fijo_actualizado(user.getIDEMPRESA(), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5),getDatoEdicion().getIdresponsable(),user.getIDUSUARIO());
                    if(!lsql.isEmpty())
                        listDet_tareoweb.addAll(lsql);
//                    RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
                }else{
                    if(ls.size()>1){
                        setMensaje("Existe mas de un documento");
                        WebUtil.error(getMensaje());
                        RequestContext.getCurrentInstance().update("datos:growl");
                        listDet_tareoweb = new ArrayList<>();
                    }else{
                        /*ACTUALIZAR DOCUMENTO DE TAREO*/
                        setDatoEdicion(ls.get(0));
                        listDet_tareoweb = new ArrayList<>();
                        List<Det_tareoweb> lsql = tareoWebDao.listarPorEmpresaWeb_update_fijo_actualizado(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdcabtareoweb(),WebUtil.fechaDMY(getDatoEdicion().getFecha(),5), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5),getDatoEdicion().getIdresponsable(),user.getIDUSUARIO());  
                        if(!lsql.isEmpty()){
                            listDet_tareoweb.addAll(lsql);
                            cargarPersonalVehiculo();
                        }else{
                            setMensaje("No se pudo cargar documentos");
                            listDet_tareoweb = new ArrayList<>();
                            WebUtil.error(getMensaje());
                            RequestContext.getCurrentInstance().update("datos:growl");
                        }
                    }
                }
            }else{
                setMensaje("Ingresar Fecha");
                listDet_tareoweb = new ArrayList<>();
                WebUtil.error(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage());
            WebUtil.error(getMensaje());
            listDet_tareoweb = new ArrayList<>();
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Mod_tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista_accion_filtro("wLst_Mod_tareoweb_fijo");
    }
    public void cargarPersonalVehiculo(){
        try{
            if(!listDet_tareoweb.isEmpty()){
                Det_tareoweb temp;
                Clieprov c;
                Consumidor co;
                for(int i=0;i<getListDet_tareoweb().size();i++){
                    temp = getListDet_tareoweb().get(i);
                    if(temp.getIdpersonal()!=null){
                        c = clieprovDao.getEmpresa_Idclieprov(user.getIDEMPRESA(), temp.getIdpersonal());
                        temp.setSelectPersonal(c);
                    }
                    if(temp.getIdvehiculo()!=null){
                        co = consumidorDao.getEmpresa_Idconsumidor(user.getIDEMPRESA(), temp.getIdvehiculo());
                        temp.setSelectConsumidor(co);
                    }
                    getListDet_tareoweb().set(i, temp);
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Clieprov> completePersonal(String query) {
        cargarClieprovPersonal();
        List<Clieprov> filteredPersonal = new ArrayList<Clieprov>(); 
        for (int i = 0; i < listPersonal.size(); i++) {
            Clieprov skin = listPersonal.get(i);
            if(skin.getDni().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getRazonsocial().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredPersonal.add(skin);
            }
        }
        return filteredPersonal;
    }
    public void cargarClieprovPersonal(){
        try {
            listPersonal = (new ClieprovDao()).listarPorEmpresaOperadorWeb(user.getIDEMPRESA());
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCellEdit(CellEditEvent event) {
        try {
            log = null;
            Object newValue = event.getNewValue();
            Object oldValue = event.getOldValue();
            Det_tareoweb entity =(Det_tareoweb)((DataTable)event.getComponent()).getRowData();
            int pos = entity.getItem();
//                int pos = listDet_tareoweb.indexOf(entity);
//                int pos = event.getRowIndex();
            if(event.getColumn().getHeaderText()!=null){
                String colHead = event.getColumn().getHeaderText().trim();
                switch(colHead){
                    case "Personal":
                    if(newValue==null){
                        entity.setIdpersonal("");
                        entity.setDni("");
                        entity.setPersonal("");
                        Clieprov ob_old = (oldValue!=null?(Clieprov)oldValue:null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Personal");
                        log.setValor_new(WebUtil.isnull("",""));
                        log.setValor_old(WebUtil.isnull(ob_old==null?"":ob_old.getIdclieprov()+"_"+ob_old.getRazonsocial(),""));
                    }else{
                        Clieprov ob = (Clieprov)newValue;
                        entity.setIdpersonal(ob.getIdclieprov());
                        entity.setDni(ob.getDni());
                        entity.setPersonal(ob.getRazonsocial());
                        Clieprov ob_old = (oldValue!=null?(Clieprov)oldValue:null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Personal");
                        log.setValor_new(WebUtil.isnull(ob==null?"":ob.getIdclieprov()+"_"+ob.getRazonsocial(),""));
                        log.setValor_old(WebUtil.isnull(ob_old==null?"":ob_old.getIdclieprov()+"_"+ob_old.getRazonsocial(),""));
                    }
                    break;
                case "Placa PSS":
                    if(newValue==null){
                        entity.setIdvehiculo("");
                        entity.setVehiculo("");
                        Consumidor ob_old = (oldValue!=null?(Consumidor)oldValue:null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Placa PSS");
                        log.setValor_new(WebUtil.isnull("",""));
                        log.setValor_old(WebUtil.isnull(ob_old==null?"":ob_old.getIdconsumidor(),""));
                    }else{
                        Consumidor oc = (Consumidor)newValue;
                        entity.setIdvehiculo(oc.getIdconsumidor());
                        entity.setVehiculo(oc.getDescripcion());
                        Consumidor ob_old = (oldValue!=null?(Consumidor)oldValue:null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Placa PSS");
                        log.setValor_new(WebUtil.isnull(oc==null?"":oc.getIdconsumidor(),""));
                        log.setValor_old(WebUtil.isnull(ob_old==null?"":ob_old.getIdconsumidor(),""));
                    }
                    break;
                case "Hora Llegada":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        entity.setHora_llegada(WebUtil.convertStringTimeFloat(newValue.toString()));
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Llegada");
                        log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }else{
                        entity.setShora_llegada("");
                        entity.setHora_llegada(null);
                        /****************************************************************************/
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Llegada");
                        log.setValor_new("");
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }
                    break;
                case "Hora Inicio":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        /*ASIGNARLE VALOR*/
                        entity.setHora_inicio_serv(WebUtil.convertStringTimeFloat(newValue.toString()));
                        entity.setShora_inicio(newValue.toString());
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Inicio");
                        log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }else{
                        entity.setShora_inicio("");
                        entity.setHora_inicio_serv(null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Inicio");
                        log.setValor_new("");
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }
                    break;
                case "Hora Fin":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        entity.setHora_fin_serv(WebUtil.convertStringTimeFloat(newValue.toString()));
                        entity.setShora_fin(newValue.toString());
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Fin");
                        log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }else{
                        entity.setShora_fin("");
                        entity.setHora_fin_serv(null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Fin");
                        log.setValor_new("");
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }
                    break;
                case "Hora Liberación":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        entity.setHora_liberacion(WebUtil.convertStringTimeFloat(newValue.toString()));
                        entity.setShora_liberacion(newValue.toString());
                        if(entity.getHora_fin_serv()!=null){
                            entity.setHora_liberacion(entity.getHora_fin_serv());
                            entity.setShora_liberacion(entity.getShora_fin());
                        }else{
                            if(entity.getHora_inicio_serv()!=null && entity.getHora_liberacion()!=null){
                                if(entity.getHora_inicio_serv()>entity.getHora_liberacion()){
                                    entity.setHora_liberacion(entity.getHora_inicio_serv());
                                    entity.setShora_liberacion(entity.getShora_inicio());
                                }
                            }
                        }
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Liberación");
                        log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }else{
                        entity.setShora_liberacion("");
                        entity.setHora_liberacion(null);
                        log = new LogTablas();
                        log.setIddoc(entity.getIdcabtareoweb());
                        log.setItems(
                                WebUtil.isnull(entity.getIdordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dordenservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem2_personalservicio(), "")+"_"+
                                WebUtil.isnull(entity.getItem_dpersonalservicio(), ""));
                        log.setCampo("Hora Liberación");
                        log.setValor_new("");
                        log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                    }
                    break;
                case "T.Asistencia":
                    Tipo_asistencia ob2 = buscarTipoAsistencia(newValue.toString());
                    entity.setCodasistencia(ob2.getIdtipoasistencia());
                    entity.setAsistencia(ob2.getNombre_corto());
                    entity.setExige_glosa(ob2.getExige_glosa()==1?true:false);
                    entity.setColor(ob2.getColor());
                    break;
                }
            }
            if(replazarCampo(entity,pos)){
               if(log!=null)
                   listLogtablas.add(log);
               grabar_local(); 
            }              
        } catch (Exception ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean replazarCampo(Det_tareoweb ob,int item){
        boolean flag = false;
        for(int i=0;i<getListDet_tareoweb().size();i++){
            Det_tareoweb dw = getListDet_tareoweb().get(i);
            if(dw.getItem() == item){
                getListDet_tareoweb().set(i, dw);
                flag = true;
                break;
            }
        }
        return flag;
    }
    public Tipo_asistencia buscarTipoAsistencia(String idtipoasistencia){
        Tipo_asistencia rsp=null;
        for(Tipo_asistencia ob : getListTipo_asistencia()){
            if(ob.getIdtipoasistencia().trim().equalsIgnoreCase(idtipoasistencia)){
                rsp = ob;
                break;
            }
        }
        return rsp;
    }
    public void grabar_local(){
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
//                groupProgramation();
                if(getDatoEdicion().getIdcabtareoweb()==null){
                    mensaje=cabtareowebDao.grabar_fijo(1, getDatoEdicion(), getListDet_tareoweb(),user.getIDUSUARIO(),listLogtablas);
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15){
                            getDatoEdicion().setIdcabtareoweb(mensaje.trim());
                            setLadd(2);
                        }else{
                           WebUtil.fatal(mensaje);
                           RequestContext.getCurrentInstance().update("datos:growl"); 
                        }
                }else{
                    mensaje=cabtareowebDao.grabar_fijo(2, getDatoEdicion(), getListDet_tareoweb(),user.getIDUSUARIO(),listLogtablas);
                }
//                setMensaje(WebUtil.exitoRegistrar("Tareo Web", mensaje));
//                WebUtil.info(getMensaje());
                setLvalidate(false);
//                setLvalidate(true);
//                RequestContext.getCurrentInstance().update("datos");
                listLogtablas = new ArrayList<>();
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public boolean esVistaValida() {
//        if (getDatoEdicion().getIdresponsable() == null){
//            WebUtil.MensajeAdvertencia("Seleccione Responsable");
//            return false;
//        }
//        else 
        if(getListDet_tareoweb().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle Tareo");
            return false;
        }
        return true;
    }
    public void postProcessXLS(Object document) {
        String nameSheet = "FIJO("+WebUtil.fechaDMY(getDatoEdicion().getFecha(),6)+")" ;
        HSSFWorkbook wb = (HSSFWorkbook) document;
        wb.setSheetName(0,nameSheet);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        /*************************STYLE HEADER****************************/
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFFont font = wb.createFont();//Create font
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        cellStyle.setAlignment(cellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setFillForegroundColor(HSSFColor.BLACK.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setWrapText(true);
        /*****************************************************/
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
            cell.setCellStyle(cellStyle);
            String celdaHeader = cell.getStringCellValue();
            cell.setCellValue(celdaHeader.toUpperCase());
        }
    }
    public Det_tareoweb findPersonal_servicio(String iddocumento,String serie,String numero){
        Det_tareoweb ob = null;
        for(Det_tareoweb obj : listDet_tareoweb){
            if(obj.getIddocumento().trim().equalsIgnoreCase(iddocumento.trim())
                    && obj.getSerie().trim().equalsIgnoreCase(serie.trim()) &&
                    obj.getNumero().trim().equalsIgnoreCase(numero.trim())){
                ob = obj;break;
            }
        }
        return ob;
    }
    public void openDialogAsignacionPersonal(){
        this.iddocumento_local="";
        this.serie_local="";
        this.numero_local="";
        this.btn_asignar_personal = true;
        listPersonal_servicio = new ArrayList<>();
        selectClieprovPersonal = new Clieprov();
        RequestContext.getCurrentInstance().update("datos:id_dlgasignar_personal");
        RequestContext.getCurrentInstance().execute("PF('dlgasignar_personal').show()");
    }
    public void openDialogAddItemTareo(){
        setSelectCargo_personal(new Cargos_personal());
        cargarComboEspecial();
        this.setNum_repetir(1);
        if(!listComboEspecial.isEmpty()){
            selectComboEspecial=listComboEspecial.get(0);
            cargarComboEspecialDetalle();
        }
        RequestContext.getCurrentInstance().update("datos:dlgAddItemTareo");
        RequestContext.getCurrentInstance().execute("PF('dlgAddItemTareo').show()");
    }
    public void openDialogRecalcular(){
        finicio=WebUtil.getDateIni();
        ffin=new Date();
        RequestContext.getCurrentInstance().update("datos:dlgRecalcular");
        RequestContext.getCurrentInstance().execute("PF('dlgRecalcular').show()");
    }
    public void procesarCalculo(){
        try {
            if(finicio == null) {
                WebUtil.MensajeAdvertencia("Ingrese Fecha Desde");
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(ffin == null){
                WebUtil.MensajeAdvertencia("Ingrese Fecha Hasta");
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(finicio.after(ffin)){
                WebUtil.MensajeAdvertencia("Rango de fechas incorrecto");
                RequestContext.getCurrentInstance().update("datos:growl");
            }
            else{
                /*DATOS INICIALES*/
                SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
                String f_ini = f.format(finicio);
                String f_fin = f.format(ffin);
                f_ini = f_ini.replace("-", "");
                f_fin = f_fin.replace("-", "");
                mensaje=cabtareowebDao.recalcularProcesos(user.getIDEMPRESA(),f_ini,f_fin,user.getIDUSUARIO());
                if(mensaje!=null){
                    WebUtil.MensajeAlerta("Cálculo exitoso");
                    RequestContext.getCurrentInstance().update("datos:growl");
                    RequestContext.getCurrentInstance().execute("PF('dlgRecalcular').hide()");
                }
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void asignacionPersonal_servicio(){
        if(selectClieprovPersonal!=null){
            int pos = listPersonal_servicio.indexOf(selectPersonal_servicio);
            Personal_servicio temp = selectPersonal_servicio;
            temp.setIdpersonal(selectClieprovPersonal.getIdclieprov());
            temp.setDni(selectClieprovPersonal.getDni());
            temp.setNombres(selectClieprovPersonal.getRazonsocial());
            listPersonal_servicio.set(pos, temp);
            RequestContext.getCurrentInstance().update("datos:listPersonal_servicio");
        }else{
            this.mensaje="Seleccionar Personal";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void grabarAsignacionPersonal_servicio(){
        if(this.iddocumento_local==null){
            this.mensaje="Ingresar ID documento";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(this.serie_local==null){
            this.mensaje="Ingresar serie";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(this.numero_local==null){
            this.mensaje="Ingresar número";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(listPersonal_servicio.isEmpty()){
            this.mensaje="No existe Dato de Personal-Servicio";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            for(Personal_servicio per : listPersonal_servicio){
                actualizarPersonal_servicio_tareoweb(this.iddocumento_local,this.serie_local,this.numero_local,per);
            }
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
            RequestContext.getCurrentInstance().execute("PF('dlgasignar_personal').hide()");
        }
    }
    public void actualizarPersonal_servicio_tareoweb(String iddocumento,String serie,String numero,Personal_servicio ob){
        for(int i=0;i<listDet_tareoweb.size();i++){
            Det_tareoweb tw = listDet_tareoweb.get(i);
            if(tw.getIddocumento().trim().equalsIgnoreCase(iddocumento.trim()) &&
               tw.getSerie().trim().equalsIgnoreCase(serie.trim()) &&
               tw.getNumero().trim().equalsIgnoreCase(numero.trim()) &&
               tw.getItem_dordenservicio().trim().equalsIgnoreCase(ob.getItem()) &&
               tw.getItem2_personalservicio().trim().equalsIgnoreCase(ob.getItem2())
              ){
                tw.setIdpersonal(ob.getIdpersonal());
                tw.setDni(ob.getDni());
                tw.setPersonal(ob.getNombres());
                listDet_tareoweb.set(i, tw);
                break;
            }
        }
    }
    public void AddItemTareo(){
        List<Det_tareoweb> lst_in = new ArrayList<>();
        List<Det_tareoweb> lst_ex = new ArrayList<>();
        List<Det_tareoweb> lst_total = new ArrayList<>();
//        try {
            if(this.selectComboEspecial_idordenservicio==null){
                this.mensaje="Seleccionar Documento/Cliente";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(this.getSelectCargo_personal()==null){
                this.mensaje="Seleccionar Cargo";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(this.getNum_repetir()<=0){
                this.mensaje="Cantidad mayor a 0";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                Det_tareoweb rept = null;
                selectComboEspecial = findComboEspecial(selectComboEspecial_idordenservicio);
                for(int i=0;i<listDet_tareoweb.size();i++){
                    Det_tareoweb tw = listDet_tareoweb.get(i);
                    if(selectComboEspecial.getId().trim().equalsIgnoreCase(tw.getIdordenservicio())){
                        lst_in.add(tw);
                    }else{
                        lst_ex.add(tw);
                    }
                }
                /***** TEMPORAL *****/
                if(!lst_in.isEmpty()){
                    Det_tareoweb xrept;
                    rept = lst_in.get(0);
                    for(int i=0;i<getNum_repetir();i++){
                        xrept = new Det_tareoweb();
                        xrept.setIdempresa(rept.getIdempresa());
                        xrept.setIdordenservicio(rept.getIdordenservicio());
                        xrept.setIddocumento(rept.getIddocumento());
                        xrept.setSerie(rept.getSerie());
                        xrept.setNumero(rept.getNumero());
                        xrept.setRuc(rept.getRuc());
                        xrept.setRazon(rept.getRazon());
    //                    xrept.setIdpersonal(rept.getIdpersonal());
    //                    xrept.setDni(rept.getDni());
    //                    xrept.setPersonal(rept.getPersonal());
                        xrept.setChecklist(rept.getChecklist());
                        xrept.setFhora_req(rept.getFhora_req());
                        xrept.setShora_req(rept.getShora_req());
                        xrept.setIdcargo(getSelectCargo_personal().getIdcargo());
                        xrept.setCargo(getSelectCargo_personal().getDescripcion());
                        xrept.setItem_dordenservicio(rept.getItem_dordenservicio());
                        xrept.setItem2_personalservicio(rept.getItem2_personalservicio());
                        xrept.setItem_dpersonalservicio(agregarItemDet_tareoweb(lst_in));
                        xrept.setHora_rc(rept.getHora_rc());
                        xrept.setFhora_fin(rept.getFhora_fin());
                        xrept.setHora_fin_serv(rept.getHora_fin_serv());
                        xrept.setShora_fin(rept.getShora_fin());
                        if(!listTipo_asistencia.isEmpty()){
                            xrept.setCodasistencia(getListTipo_asistencia().get(0).getIdtipoasistencia());
                            xrept.setAsistencia(getListTipo_asistencia().get(0).getNombre_corto());
                            xrept.setExige_glosa(getListTipo_asistencia().get(0).getExige_glosa()==1?true:false);
                            xrept.setColor(getListTipo_asistencia().get(0).getColor());
                        }
                        xrept.setIdservicio(rept.getIdservicio());
                        xrept.setServicio(rept.getServicio());
                        xrept.setShora_llegada(rept.getShora_llegada());
                        xrept.setShora_inicio(rept.getShora_inicio());
                        xrept.setShora_fin(rept.getShora_fin());
                        xrept.setShora_liberacion(rept.getShora_liberacion());
                        
                        xrept.setFecharegistro(rept.getFecharegistro());
                        xrept.setFechafinregistro(rept.getFechafinregistro());
                        
                        xrept.setIdreferencia(rept.getIdreferencia());
                        xrept.setItemreferencia(rept.getItemreferencia());
                        xrept.setIdruta_ec(rept.getIdruta_ec());
                        xrept.setHora_rc(rept.getHora_rc());
                        xrept.setFecha_osc(rept.getFecha_osc());
                        xrept.setCodoperaciones(rept.getCodoperaciones());
                        xrept.setRutaservicios(rept.getRutaservicios());
                        lst_in.add(xrept);
                    }
                }
                /* ****** RECONSTRUCCIÓN TOTAL ****** */
                if(rept!=null){
                    int id = rept.getItem();
                    int item_total = lst_in.size()+lst_ex.size();
                    Det_tareoweb obj = null;
                    if(id==1){
                        lst_total.addAll(lst_in);
                        lst_total.addAll(lst_ex);
                    }else{
                        int count_lst_in=lst_in.size();
                        int count_lst_ex=lst_ex.size();
                        int ini_lst_in=0;
                        int ini_lst_ex=0;
                        for(int i=0;i<item_total;i++){
                            if(id == i){
                                lst_total.addAll(lst_in);
                                i+=count_lst_in;
                            }else{
                                if(count_lst_ex>ini_lst_ex){
                                    obj = lst_ex.get(ini_lst_ex);
                                    lst_total.add(obj);
                                    ini_lst_ex++;  
                                }
                            }
                        }
                    }
                    /* ****** RECONSTRUCCIÓN ÍNDICES ****** */
                    Det_tareoweb tw = null;
                    for(int i=0;i<lst_total.size();i++){
                        tw = lst_total.get(i);
                        tw.setItem(i+1);
                        lst_total.set(i, tw);
                    }
                }     
            }
            if(!lst_total.isEmpty()){
                    listDet_tareoweb=lst_total;
//                    generarEstructuraBase();
                    RequestContext.getCurrentInstance().execute("PF('dlgAddItemTareo').hide()");

            }
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public ComboEspecial findComboEspecial(String idordenservicio){
        ComboEspecial tresp = null;
        for(ComboEspecial ob : listComboEspecial){
            if(ob.getId().trim().equalsIgnoreCase(idordenservicio)){
                tresp = ob;break;
            }
        }
        return tresp;
    }
    public void openDialogAsistencia(){
        if(selectDet_tareoweb!=null){
            this.setGlosa_local(selectDet_tareoweb.getGlosa());
            posSelect_det_tareoweb  = posicionListDet_tareoweb(selectDet_tareoweb.getItem());
            RequestContext.getCurrentInstance().update("datos:id_dlgDetalleAsistencia");
            RequestContext.getCurrentInstance().execute("PF('dlgDetalleAsistencia').show()");
        }
    }
    public void AddGlosaDet_tareoweb(){
        if(selectDet_tareoweb!=null){
            if(this.getGlosa_local()!=null)
                selectDet_tareoweb.setGlosa(getGlosa_local());
            listDet_tareoweb.set(posSelect_det_tareoweb, selectDet_tareoweb);
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
            RequestContext.getCurrentInstance().execute("PF('dlgDetalleAsistencia').hide()");
        }
    }
    public String agregarItemDet_tareoweb(List<Det_tareoweb> lst){
        int dato = 1;
        int may=-999999999;
        for(Det_tareoweb obj:lst){
            if(!obj.getItem_dpersonalservicio().isEmpty()){
                dato = Integer.parseInt(obj.getItem_dpersonalservicio());
                if(dato>may)
                    may=dato;
            }
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public int posicionListDet_tareoweb(int item){
        int pos = -1;
        int count = 0;
        for(Det_tareoweb ob : listDet_tareoweb){
            if(ob.getItem()==item){
                pos = count;
                break;
            }else
                count++;
        }
        return pos;
    }
    public void deleteDettareo_web(){
        Det_tareoweb sl = selectDet_tareoweb;
        if(sl!=null){
            listDet_tareoweb.remove(sl);
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        }
    }
    public void deleteDettareo_web_servicio(){
        Det_tareoweb sl = selectDet_tareoweb;
        List<Det_tareoweb> lst_temp_delete = new ArrayList<>();
        if(sl!=null){
            for(Det_tareoweb o : listDet_tareoweb){
                if(sl.getIdordenservicio().trim().equals(o.getIdordenservicio().trim())){
                    lst_temp_delete.add(o);
                }
            }
            listDet_tareoweb.removeAll(lst_temp_delete);
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        }
    }
    public void cargarComboEspecial(){
        if(listDet_tareoweb != null){
            ComboEspecial cbe;
            listComboEspecial = new ArrayList<>();
            String descripcion;
            for(Det_tareoweb wb : listDet_tareoweb){
                descripcion = wb.getIddocumento()+"-"+wb.getSerie()+"-"+wb.getNumero()+" ("+wb.getRuc()+")"+wb.getRazon();
                cbe = new ComboEspecial(wb.getIdordenservicio(), descripcion);
                listComboEspecial.add(cbe);
            }
            /*QUITAR DUPLICADOS*/
            Set<ComboEspecial> hs = new TreeSet<ComboEspecial>();
            hs.addAll(listComboEspecial);
            listComboEspecial.clear();
            listComboEspecial.addAll(hs);
        }
    }
    public void cargarComboEspecialDetalle(){
        if(listDet_tareoweb != null){
            if(selectComboEspecial!=null){
                ComboEspecial cbe;
                setListComboEspecialDetalle(new ArrayList<>());
                String descripcion;
                for(Det_tareoweb wb : listDet_tareoweb){
                    if(selectComboEspecial.getId().trim().equalsIgnoreCase(wb.getIdordenservicio())){
                        descripcion = wb.getServicio();
                        cbe = new ComboEspecial(wb.getIdreferencia()+","+wb.getItemreferencia()+","+wb.getIdruta_ec()+","+wb.getHora_rc(), descripcion);
                        getListComboEspecialDetalle().add(cbe);
                    }
                }
                /*QUITAR DUPLICADOS*/
                Set<ComboEspecial> hs = new TreeSet<ComboEspecial>();
                hs.addAll(getListComboEspecialDetalle());
                getListComboEspecialDetalle().clear();
                getListComboEspecialDetalle().addAll(hs);
                RequestContext.getCurrentInstance().update("datos:dlgAddItemTareo:");
            }
        }
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalParamsOptions, null);
    }
    public void valorCargos_personal(SelectEvent event) {
        selectCargo_personal = (Cargos_personal) event.getObject();
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Mod_tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
            
        return "";
    }

    @Override
    public void nuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
//                groupProgramation();
                if(getDatoEdicion().getIdcabtareoweb()==null){
                    mensaje=cabtareowebDao.grabar_fijo(1, getDatoEdicion(), 
                            getListDet_tareoweb(),user.getIDUSUARIO(),listLogtablas);
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabtareoweb(mensaje.trim());
                }
                else
                    mensaje=cabtareowebDao.grabar_fijo(2, getDatoEdicion(),getListDet_tareoweb(),user.getIDUSUARIO(),listLogtablas);
                setMensaje(WebUtil.exitoRegistrar("Tareo Web Fijo", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
                listLogtablas = new ArrayList<>();
                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Documentos> completeDocumentos(String query) {
        List<Documentos> filteredDocumentos = new ArrayList<Documentos>(); 
        for (int i = 0; i < listDocumentos.size(); i++) {
            Documentos skin = listDocumentos.get(i);
            if(skin.getIddocumento().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getCodigo_sunat().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredDocumentos.add(skin);
            }
        }
        return filteredDocumentos;
    }
    public void onRefresh(){
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public void findetalle() throws Exception {
         
    }

    public void buscar_filtrofecha() {
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
//            listReporte_facturacion = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tab");
        return;
    }
    public void onTiposervicio(){
        
    }
    public void replicarItem(){
        //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public UsuarioBean getUser() {
        return user;
    }
    public void onRowSelectPersonal_Servicio(SelectEvent event) throws IOException {
        if(getSelectPersonal_servicio()!=null)
            setBtn_asignar_personal(false);
        /*CARGAR DATOS DPERSONAL_SERVICIO*/
        RequestContext.getCurrentInstance().update("datos:listPersonal_servicio");
    }
    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    @Override
    public String buscarFiltro(int tipo){
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            //listReporte_facturacionTotal = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        if(tipo == 2)
            lista_accion_filtro("wLst_Rpt_tareoweb_facturacion_formato");
        return "";
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
    public void downFormatExcelEspecial(Object document) {
        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,"FORMATO_ "+WebUtil.fechaDMY(new Date(),1));
        HSSFRow fila_cabecera = objWB.getSheetAt(0).getRow(0);

        HSSFFont fuente = objWB.createFont();
        fuente.setFontHeightInPoints((short) 8);
        fuente.setFontName("Calibre LIght");
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFCellStyle estiloCelda = objWB.createCellStyle();
        estiloCelda.setWrapText(true);
        estiloCelda.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setFont(fuente);
        estiloCelda.setWrapText(true);
        estiloCelda.setFillForegroundColor((short) 22);
        estiloCelda.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//Filas           
        HSSFFont fuenteFilas = objWB.createFont();
        fuenteFilas.setFontHeightInPoints((short) 8);
        fuenteFilas.setFontName("Calibre LIght");

        HSSFCellStyle estiloFila = objWB.createCellStyle();
        estiloFila.setWrapText(true);
        estiloFila.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setFont(fuente);
        
        DataFormat format = objWB.createDataFormat();
        HSSFCellStyle estiloFila_numeric = objWB.createCellStyle();
        estiloFila_numeric.setWrapText(true);
        estiloFila_numeric.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila_numeric.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setFont(fuente);
        estiloFila_numeric.setDataFormat(format.getFormat("0.00"));
        int col = 22;
        int row = 0;//listReporte_facturacion.size();
        HSSFCell celda;
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("IDCLIEPROV");break;
                case 1:celda.setCellValue("RAZON SOCIAL");break;
                case 2:celda.setCellValue("IDDOCUMENTO");break;
                case 3:celda.setCellValue("SERIE");break;
                case 4:celda.setCellValue("NUMERO");break;
                case 5:celda.setCellValue("FECHA");break;
                case 6:celda.setCellValue("FECHA OPERACION");break;
                case 7:celda.setCellValue("VENCIMIENTO");break;
                case 8:celda.setCellValue("IDMONEDA");break;
                case 9:celda.setCellValue("IDCUENTA");break;
                case 10:celda.setCellValue("IDCCOSTO");break;
                case 11:celda.setCellValue("CONCEPTO");break;
                case 12:celda.setCellValue("IDCLIENTE");break;
                case 13:celda.setCellValue("IDREGIMEN");break;
                case 14:celda.setCellValue("AFECTO");break;
                case 15:celda.setCellValue("INAFECTO");break;
                case 16:celda.setCellValue("IDIMPUESTO");break;
                case 17:celda.setCellValue("IMPUESTO");break;
                case 18:celda.setCellValue("TOTAL");break;
                case 19:celda.setCellValue("TIENE DETRACCION");break;
                case 20:celda.setCellValue("TIPO DE DETRACCIÓN");break;
                case 21:celda.setCellValue("TASA DE DETRACCIÓN");break;
            }
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).getRow(i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            //celda.setCellValue(listReporte_facturacion.get(i).getIdclieprov());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            //celda.setCellValue(listReporte_facturacion.get(i).getInafecto());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
    }
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 2);
        else
            return "";
    }
    
    public String formatObjectMask(int col){
        String mask="";
        switch(col){
            case 0:;break;
            case 1:;break;
            case 2:;break;
            case 3:mask="";break;
        }
        return mask;
    }
    public boolean formatObjectDissable(int col){
        boolean t=false;
        switch(col){
            case 0:t=true;break;
            case 1:t=true;break;
            case 2:t=true;break;
            default : t=false;
        }
        return t;
    }
    public static String generarDiaid(Date fecha){
        Calendar c = WebUtil.convertDateCalendar(fecha);
        int ndia = c.get(Calendar.DAY_OF_WEEK)==1?7:c.get(Calendar.DAY_OF_WEEK)-1;
        // EEE gives short day names, EEEE would be full length.
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEEEEEEEEE", Locale.US); 
        String asWeek = "("+WebUtil.idGeneradoDos(ndia)+")"+WebUtil.convertDayOfSpanish(dateFormat.format(fecha));
        return asWeek;
    }
    /****************************** ESTRUCTURA COSTOS PRODUCTO DIAS X RANGO******************************/
    public void onFormularioEstructuraCostosProductoDiasRango(){
        try {
            if(selectDet_tareoweb!=null){
                setListEstructura_costos_producto_diasrango(estructura_costos_producto_diasrangoDao.listarPorEmpresaWeb(selectDet_tareoweb.getIdempresa(),
                        selectDet_tareoweb.getIdreferencia(), selectDet_tareoweb.getIdservicio(), selectDet_tareoweb.getItemreferencia(),
                        selectDet_tareoweb.getHora_rc(), selectDet_tareoweb.getCodoperaciones(), selectDet_tareoweb.getIdruta_ec()));
                RequestContext.getCurrentInstance().update("datos:dlgEstructura_costos_producto_diasrango");
                RequestContext.getCurrentInstance().execute("PF('dlgEstructura_costos_producto_diasrango').show()");
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
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
     * @return the type_formato_rpt
     */
    public String getType_formato_rpt() {
        return type_formato_rpt;
    }

    /**
     * @param type_formato_rpt the type_formato_rpt to set
     */
    public void setType_formato_rpt(String type_formato_rpt) {
        this.type_formato_rpt = type_formato_rpt;
    }

    /**
     * @return the documentoDao
     */
    public DocumentosDao getDocumentoDao() {
        return documentoDao;
    }

    /**
     * @param documentoDao the documentoDao to set
     */
    public void setDocumentoDao(DocumentosDao documentoDao) {
        this.documentoDao = documentoDao;
    }

    /**
     * @return the det_tareoweb_verificationDao
     */
    public Det_tareowebDao getDet_tareoweb_verificationDao() {
        return det_tareoweb_verificationDao;
    }

    /**
     * @param det_tareoweb_verificationDao the det_tareoweb_verificationDao to set
     */
    public void setDet_tareoweb_verificationDao(Det_tareowebDao det_tareoweb_verificationDao) {
        this.det_tareoweb_verificationDao = det_tareoweb_verificationDao;
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
     * @return the listDet_tareoweb
     */
    public List<Det_tareoweb> getListDet_tareo_verificacion() {
        return getListDet_tareoweb();
    }

    /**
     * @param listDet_tareoweb the listDet_tareoweb to set
     */
    public void setListDet_tareo_verificacion(List<Det_tareoweb> listDet_tareoweb) {
        this.setListDet_tareoweb(listDet_tareoweb);
    }

    /**
     * @return the scosto
     */
    public Float getScosto() {
        return scosto;
    }

    /**
     * @param scosto the scosto to set
     */
    public void setScosto(Float scosto) {
        this.scosto = scosto;
    }

    /**
     * @return the filtroFecha
     */
    public Date getFiltroFecha() {
        return filtroFecha;
    }

    /**
     * @param filtroFecha the filtroFecha to set
     */
    public void setFiltroFecha(Date filtroFecha) {
        this.filtroFecha = filtroFecha;
    }

    /**
     * @return the listDet_tareoweb
     */
    public List<Det_tareoweb> getListDet_tareoweb() {
        return listDet_tareoweb;
    }

    /**
     * @param listDet_tareoweb the listDet_tareoweb to set
     */
    public void setListDet_tareoweb(List<Det_tareoweb> listDet_tareoweb) {
        this.listDet_tareoweb = listDet_tareoweb;
    }

    /**
     * @return the selectDet_tareoweb
     */
    public Det_tareoweb getSelectDet_tareoweb() {
        return selectDet_tareoweb;
    }

    /**
     * @param selectDet_tareoweb the selectDet_tareoweb to set
     */
    public void setSelectDet_tareoweb(Det_tareoweb selectDet_tareoweb) {
        this.selectDet_tareoweb = selectDet_tareoweb;
    }

    /**
     * @return the iddocumento_local
     */
    public String getIddocumento_local() {
        return iddocumento_local;
    }

    /**
     * @param iddocumento_local the iddocumento_local to set
     */
    public void setIddocumento_local(String iddocumento_local) {
        this.iddocumento_local = iddocumento_local;
    }

    /**
     * @return the serie_local
     */
    public String getSerie_local() {
        return serie_local;
    }

    /**
     * @param serie_local the serie_local to set
     */
    public void setSerie_local(String serie_local) {
        this.serie_local = serie_local;
    }

    /**
     * @return the numero_local
     */
    public String getNumero_local() {
        return numero_local;
    }

    /**
     * @param numero_local the numero_local to set
     */
    public void setNumero_local(String numero_local) {
        this.numero_local = numero_local;
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
     * @return the listPersonal_servicio
     */
    public List<Personal_servicio> getListPersonal_servicio() {
        return listPersonal_servicio;
    }

    /**
     * @param listPersonal_servicio the listPersonal_servicio to set
     */
    public void setListPersonal_servicio(List<Personal_servicio> listPersonal_servicio) {
        this.listPersonal_servicio = listPersonal_servicio;
    }

    /**
     * @return the btn_asignar_personal
     */
    public boolean isBtn_asignar_personal() {
        return btn_asignar_personal;
    }

    /**
     * @param btn_asignar_personal the btn_asignar_personal to set
     */
    public void setBtn_asignar_personal(boolean btn_asignar_personal) {
        this.btn_asignar_personal = btn_asignar_personal;
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
     * @return the listComboEspecial
     */
    public List<ComboEspecial> getListComboEspecial() {
        return listComboEspecial;
    }

    /**
     * @param listComboEspecial the listComboEspecial to set
     */
    public void setListComboEspecial(List<ComboEspecial> listComboEspecial) {
        this.listComboEspecial = listComboEspecial;
    }

    /**
     * @return the listComboEspecialDetalle
     */
    public List<ComboEspecial> getListComboEspecialDetalle() {
        return listComboEspecialDetalle;
    }

    /**
     * @param listComboEspecialDetalle the listComboEspecialDetalle to set
     */
    public void setListComboEspecialDetalle(List<ComboEspecial> listComboEspecialDetalle) {
        this.listComboEspecialDetalle = listComboEspecialDetalle;
    }

    /**
     * @return the selectComboEspecial_idordenservicio
     */
    public String getSelectComboEspecial_idordenservicio() {
        return selectComboEspecial_idordenservicio;
    }

    /**
     * @param selectComboEspecial_idordenservicio the selectComboEspecial_idordenservicio to set
     */
    public void setSelectComboEspecial_idordenservicio(String selectComboEspecial_idordenservicio) {
        this.selectComboEspecial_idordenservicio = selectComboEspecial_idordenservicio;
    }

    /**
     * @return the selectComboEspecialDetalle_idordenservicio
     */
    public String getSelectComboEspecialDetalle_idordenservicio() {
        return selectComboEspecialDetalle_idordenservicio;
    }

    /**
     * @param selectComboEspecialDetalle_idordenservicio the selectComboEspecialDetalle_idordenservicio to set
     */
    public void setSelectComboEspecialDetalle_idordenservicio(String selectComboEspecialDetalle_idordenservicio) {
        this.selectComboEspecialDetalle_idordenservicio = selectComboEspecialDetalle_idordenservicio;
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
     * @return the selectCargo_personal
     */
    public Cargos_personal getSelectCargo_personal() {
        return selectCargo_personal;
    }

    /**
     * @param selectCargo_personal the selectCargo_personal to set
     */
    public void setSelectCargo_personal(Cargos_personal selectCargo_personal) {
        this.selectCargo_personal = selectCargo_personal;
    }

    /**
     * @return the glosa_local
     */
    public String getGlosa_local() {
        return glosa_local;
    }

    /**
     * @param glosa_local the glosa_local to set
     */
    public void setGlosa_local(String glosa_local) {
        this.glosa_local = glosa_local;
    }

    /**
     * @return the listTipo_asistencia
     */
    public List<Tipo_asistencia> getListTipo_asistencia() {
        return listTipo_asistencia;
    }

    /**
     * @param listTipo_asistencia the listTipo_asistencia to set
     */
    public void setListTipo_asistencia(List<Tipo_asistencia> listTipo_asistencia) {
        this.listTipo_asistencia = listTipo_asistencia;
    }

    /**
     * @return the numdia
     */
    public String getNumdia() {
        return numdia;
    }

    /**
     * @param numdia the numdia to set
     */
    public void setNumdia(String numdia) {
        this.numdia = numdia;
    }

    /**
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * @param finicio the finicio to set
     */
    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    /**
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * @param ffin the ffin to set
     */
    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    /**
     * @return the listEstructura_costos_producto_diasrango
     */
    public List<Estructura_costos_producto_diasrango> getListEstructura_costos_producto_diasrango() {
        return listEstructura_costos_producto_diasrango;
    }

    /**
     * @param listEstructura_costos_producto_diasrango the listEstructura_costos_producto_diasrango to set
     */
    public void setListEstructura_costos_producto_diasrango(List<Estructura_costos_producto_diasrango> listEstructura_costos_producto_diasrango) {
        this.listEstructura_costos_producto_diasrango = listEstructura_costos_producto_diasrango;
    }

}