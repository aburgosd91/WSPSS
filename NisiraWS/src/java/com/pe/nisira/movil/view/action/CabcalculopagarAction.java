/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.CabcalculopagarDao;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.DetcalculopagarDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
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
import com.nisira.core.dao.TipodetraccionDao;
import com.nisira.core.dao.TiporegimenDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Cabcalculopagar;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
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
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Impuesto;
import com.nisira.core.entity.Moneda;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Planctas;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Detcalculopagar;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tipodetraccion;
import com.nisira.core.entity.Tiporegimen;
import com.nisira.core.entity.Wtiposervicio;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
@ManagedBean(name = "cabcalculopagarAction")
@SessionScoped
public class CabcalculopagarAction extends AbstactListAction<Cabcalculopagar> {
    /*************************************ArrayList***************************************/
    private List<Detcalculopagar> listDetcalculopagar;
    private List<Wtiposervicio> listWtiposervicio;
    private WtiposervicioDao wtiposervicioDao;
    private List<Monedas> listMoneda;
    private List<Planctas> listPlanctas;
    private List<Consumidor> listConsumidor;
    private List<Tiporegimen> listTiporegimen;
    private List<Impuesto> listImpuesto;
    private List<Tipodetraccion> listTipodetraccion;
    private List<Documentos> listDocumentos;
    private List<Documentos> listDocumentos_cab;
    private List<Det_tareoweb> listDet_tareo_verificacion;
    private List<Detcalculopagar> listDetcalculopagarTotal;
    private List<Detcalculopagar> listDetcalculopagar_verification;
    private List<Detcalculopagar> listDetcalculopagarPersonal;
    private List<Numemisor> listNumemisor;
    private List<Almacenes> listAlmacenes;
    private List<Estados> listEstado;
    /*************************************DAO***************************************/
    private CabcalculopagarDao cabcalculopagarDao;
    private DetcalculopagarDao detcalculopagarDao;
    private OrdenservicioclienteDao ordenservicioclienteDao;
    private MonedasDao monedaDao;
    private TiporegimenDao tiporegimenDao;
    private ImpuestoDao impuestoDao; 
    private TipodetraccionDao tipodetraccionDao;
    private PlanctasDao planctasDao; 
    private DocumentosDao documentoDao;
    private NumemisorDao numemisorDao; 
    private ConsumidorDao consumidorDao;
    private Det_tareowebDao det_tareoweb_verificationDao; 
    private EmisorDao emisorDao;
    private SucursalesDao sucursalDao;
    private AlmacenesDao alamcenesDao;
    private EstadosDao estadosDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String mensaje;
    private String idtiposervicio;
    private Detcalculopagar selectDetcalculopagar; 
    private Detcalculopagar selectDetcalculopagar_detalle; 
    private Det_tareoweb cabercerDet_tareoweb;
    /************************************* CONTROLES *****************************************/
    private static final String renta4="003";
    private boolean habilitar_numerico;
    private ArrayList<String> lista_solution;
    private String type_formato_rpt;
    private Float scosto;
    private String log_consola;
    public CabcalculopagarAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            mensaje = "";
            /*********************************LISTAS*******************************************/
            listDetcalculopagar = new ArrayList<>();
            listWtiposervicio = new ArrayList<>();
            listPlanctas = new ArrayList<>();
            listTiporegimen =  new ArrayList<>();
            listImpuesto =  new ArrayList<>();
            listTipodetraccion =  new ArrayList<>();
            listDocumentos =  new ArrayList<>();
            listConsumidor =  new ArrayList<>();
            listEstado = new ArrayList<>();
            /*********************************DAO**********************************************/
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            wtiposervicioDao = new WtiposervicioDao();
            monedaDao = new MonedasDao();
            impuestoDao = new ImpuestoDao();
            tiporegimenDao = new TiporegimenDao();
            tipodetraccionDao = new TipodetraccionDao();
            planctasDao = new PlanctasDao();
            documentoDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            consumidorDao = new ConsumidorDao();
            det_tareoweb_verificationDao = new Det_tareowebDao();
            cabcalculopagarDao = new CabcalculopagarDao();
            detcalculopagarDao = new DetcalculopagarDao();
            emisorDao = new EmisorDao();
            sucursalDao = new SucursalesDao();
            alamcenesDao = new AlmacenesDao();
            estadosDao = new EstadosDao();
            /**********************************CONTROLADOR*************************************/
            habilitar_numerico=true;
            log_consola = "";
            lista_solution=CoreUtil.valoresBase();
            listWtiposervicio = wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listMoneda = monedaDao.getListMonedasWeb();
            listTiporegimen = tiporegimenDao.listarPorEmpresa(user.getIDEMPRESA());
            listImpuesto = impuestoDao.listarPorEmpresa(user.getIDEMPRESA());
            listTipodetraccion = tipodetraccionDao.listarTotal();
            listDocumentos = documentoDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listDocumentos_cab = documentoDao.getCabcalculopagar(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos_cab.get(0).getIddocumento());
            listConsumidor = consumidorDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            /********************************** CONFIGURACIÓN - SERVIDOR ***********************/
            idtiposervicio = "ESPECIAL";
            actualiza_ventana("wMnt_Cabcalculopagar");
        }catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(CabcalculopagarAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        Detcalculopagar entity =(Detcalculopagar)((DataTable)event.getComponent()).getRowData();
        int pos = entity.getItem();
        if(event.getColumn().getHeaderText()!=null){
            String colHead = event.getColumn().getHeaderText().trim();
            switch(colHead){
                case "Fecha":
                    if(newValue!=null){
                        Date fecha = (Date)(newValue);
                        entity.setFecha(fecha);
                    };break;
                case "Fecha Operación":
                    if(newValue!=null){
                        Date fecha = (Date)(newValue);
                        entity.setFechaoperacion(fecha);
                    };break;
                case "Vencimiento":
                    if(newValue!=null){
                        Date fecha = (Date)(newValue);
                        entity.setVencimiento(fecha);
                    };break;
                case "Idcuenta":
                    if(newValue==null){
                        entity.setIdcuenta("");
                        entity.setCuenta("");
                    }else{
                        Planctas ob = (Planctas)newValue;
                        entity.setIdcuenta(ob.getIdcuenta());
                        entity.setCuenta(ob.getDescripcion());
                    };break;
                case "tipo de detracción":
                    if(newValue==null){
                        entity.setIdtipodetra("");
                        entity.setTipodetraccion_descripcion("");
                        entity.setTasa(0.0f);
                    }else{
                        Tipodetraccion ob = (Tipodetraccion)newValue;
                        entity.setIdtipodetra(ob.getIdtipodetra());
                        entity.setTipodetraccion_descripcion(ob.getDescripcion());
                        entity.setTasa(ob.getTasa());
                    };break;
                case "Doc.":
                    if(newValue==null){
                        entity.setIddocumento("");
                    }else{
                        Documentos ob = (Documentos)newValue;
                        entity.setIddocumento(ob.getIddocumento());
                    };break;
                case "Serie":
                    if(newValue==null){
                        entity.setSerie("0000");
                    }else{
                        String serie = newValue.toString();
                        entity.setSerie(WebUtil.cerosIzquierdaString(serie, 4));
                    }
                    ;break;
                case "Número":
                    if(newValue==null){
                        entity.setNumero("0000000");
                    }else{
                        String numero = newValue.toString();
                        entity.setNumero(WebUtil.cerosIzquierda(numero, 7));
                    }
                    ;break;
                case "Idccosto":
                    if(newValue==null){
                        entity.setNumero("");
                    }else{
                        Consumidor ob = (Consumidor)newValue;
                        entity.setIdccosto(ob.getIdccosto());
                        entity.setConcepto(ob.getDescripcion());
                    }
                    ;break;
                case "Idregimen":
                    if(newValue==null){
                        entity.setIdregimen("");
                    }else{
                        if(newValue.toString().trim().equals("01")){
                            entity.setAfecto(entity.getTcosto());
                            entity.setInafecto(0.0f);
                        }else if(newValue.toString().trim().equals("02")){
                            
                        }else if(newValue.toString().trim().equals("03")){
                            entity.setAfecto(0.0f);
                            entity.setInafecto(entity.getTcosto());
                        }
                    }
                    ;break;
                case "Idimpuesto":
                    if(newValue==null){
                        entity.setIdimpuesto("000");
                        entity.setImpuesto(0.0f);
                    }else{
                        Float[] valores = impuestoDao.getImpuesto(user.getIDEMPRESA(), newValue.toString());
                        Float imp = valores[1];
                        entity.setResta_base(valores[0].intValue());
                        Float imp_dec =  imp/100;
                        entity.setIdimpuesto(newValue.toString());
                        if(entity.getIdregimen().trim().equals("01")){
                            entity.setImpuesto(entity.getAfecto()*imp_dec);
                        }else if(entity.getIdregimen().trim().equals("03")){
                            entity.setImpuesto(entity.getInafecto()*imp_dec);
                        }
                    }
                    ;break;
            }
            /*CALCULO DE TOTAL*/
            entity.setTotal(entity.getAfecto()+entity.getInafecto()+(entity.getImpuesto()* (entity.getResta_base()==1?-1:1)));
            if(replazarCampo(entity,pos)){
                /************************ REPLICAR DETALLADOS *************************/
                for(int j = 0;j<listDetcalculopagarTotal.size();j++){
                    Detcalculopagar dtw_detallado=listDetcalculopagarTotal.get(j);
                    if(entity.getIdclieprov().trim().equals(dtw_detallado.getIdclieprov())){
                        dtw_detallado.setIddocumento(entity.getIddocumento());
                        dtw_detallado.setSerie(entity.getSerie());
                        dtw_detallado.setNumero(entity.getNumero());
                        dtw_detallado.setFecha(entity.getFecha());
                        dtw_detallado.setFechaoperacion(entity.getFechaoperacion());
                        dtw_detallado.setVencimiento(entity.getVencimiento());
                        dtw_detallado.setIdmoneda(entity.getIdmoneda());
                        dtw_detallado.setIdcuenta(entity.getIdcuenta());
                        dtw_detallado.setCuenta(entity.getCuenta());
                        dtw_detallado.setSelectCuenta(entity.getSelectCuenta());
                        dtw_detallado.setIdccosto(entity.getIdccosto());
                        dtw_detallado.setSelectConsumidor(entity.getSelectConsumidor());
                        dtw_detallado.setConcepto(entity.getConcepto());
                        dtw_detallado.setIdregimen(entity.getIdregimen());
                        dtw_detallado.setIdimpuesto(entity.getIdimpuesto());
                        dtw_detallado.setIdtipodetra(entity.getIdtipodetra());
                        dtw_detallado.setTipodetraccion_descripcion(entity.getTipodetraccion_descripcion());
                        dtw_detallado.setSelectTipodetraccion(entity.getSelectTipodetraccion());
                        dtw_detallado.setTasa(entity.getTasa());
                        /*CALCULAR IMPORTES*/
                        Float[] array = impuestoDao.getImpuesto(user.getIDEMPRESA(), entity.getIdimpuesto());
                        Float imp = array[1];
                        dtw_detallado.setResta_base(array[0].intValue());
                        Float imp_dec =  imp/100;
                        if(dtw_detallado.getIdregimen().trim().equals("01")){
                            dtw_detallado.setAfecto(dtw_detallado.getTcosto());
                            dtw_detallado.setInafecto(0.0f);
                            dtw_detallado.setImpuesto(dtw_detallado.getAfecto()*imp_dec);
                        }else if(dtw_detallado.getIdregimen().trim().equals("03")){
                            dtw_detallado.setInafecto(entity.getTcosto());
                            dtw_detallado.setAfecto(0.0f);
                            dtw_detallado.setImpuesto(entity.getInafecto()*imp_dec);
                        }
                        dtw_detallado.setTotal(dtw_detallado.getAfecto()+dtw_detallado.getInafecto()+(dtw_detallado.getImpuesto()*(dtw_detallado.getResta_base()==1?-1:1)));
                    } 
                    listDetcalculopagarTotal.set(j, dtw_detallado);
                }
                grabar_local();
            }
        }  
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public boolean replazarCampo(Detcalculopagar ob,int item){
        boolean flag = false;
        for(int i=0;i<listDetcalculopagar.size();i++){
            Detcalculopagar dw = listDetcalculopagar.get(i);
            if(dw.getItem() == item){
                listDetcalculopagar.set(i, dw);
                flag = true;
                break;
            }
        }
        return flag;
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(CabcalculopagarAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        listDetcalculopagar = new ArrayList<>();
        
        setMensaje("");
        actualiza_ventana("wMnt_Cabcalculopagar");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Cabcalculopagar());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setIdemisor(mensaje);
            getDatoEdicion().setFecha(new Date());
            getDatoEdicion().setFinicio(new Date());
            getDatoEdicion().setFfin(new Date());
            getDatoEdicion().setIdsucursal(Constantes.getIDSUCURSALGENERAL());
            getDatoEdicion().setPeriodo(WebUtil.fechaDMY(new Date(),9));
            getDatoEdicion().setMes(WebUtil.strMonths[(new Date()).getMonth()]);
            getDatoEdicion().setIddocumento(getListDocumentos().get(0).getIddocumento());
            getDatoEdicion().setSerie(getListNumemisor().get(0).getSerie());
            getDatoEdicion().setNumero(getListNumemisor().get(0).getNumero());
            getDatoEdicion().setIdemisor(lista_solution.get(5));
            getDatoEdicion().setIdusuario(user.getIDUSUARIO());
            getDatoEdicion().setUsuario(user.getNombres());
            getDatoEdicion().setIdestado("PE");
            getDatoEdicion().setTipo("ESPECIAL");
            
            String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
            getDatoEdicion().setEmisor(emisor);
            getDatoEdicion().setPeriodo(WebUtil.fechaDMY(getDatoEdicion().getFecha(), 9));
            getDatoEdicion().setMes(WebUtil.strMonths[Integer.parseInt(WebUtil.fechaDMY(getDatoEdicion().getFecha(),10))-1]);
            String sucursal = sucursalDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
            getDatoEdicion().setSucursal(sucursal);
            if(!listAlmacenes.isEmpty())
                getDatoEdicion().setIdalmacen(getListAlmacenes().get(0).getIdalmacen());
            listDetcalculopagarTotal = new ArrayList<>();
            listDetcalculopagar = new ArrayList<>();
            RequestContext.getCurrentInstance().update("datos");
        } catch (NisiraORMException ex) {
            Logger.getLogger(CabcalculopagarAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CabcalculopagarAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                if(getDatoEdicion().getIdcabcalculopagar()==null){
                    mensaje=getCabcalculopagarDao().grabar(1, getDatoEdicion(), 
                            getListDetcalculopagarTotal(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabcalculopagar(mensaje.trim());
                }
                else
                    mensaje=getCabcalculopagarDao().grabar(2, getDatoEdicion(),getListDetcalculopagarTotal(),user.getIDUSUARIO());
                setMensaje(WebUtil.exitoRegistrar("Cálculo x Pagar - "+getDatoEdicion().getTipo(), mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
//                setLvalidate(true);
//                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void grabar_local() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                if(getDatoEdicion().getIdcabcalculopagar()==null){
                    mensaje=getCabcalculopagarDao().grabar(1, getDatoEdicion(), 
                            getListDetcalculopagarTotal(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabcalculopagar(mensaje.trim());
                }
                else
                    mensaje=getCabcalculopagarDao().grabar(2, getDatoEdicion(),getListDetcalculopagarTotal(),user.getIDUSUARIO());
                setMensaje(WebUtil.exitoRegistrar("Generación Cálculo por pagar", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(false);
//                setLvalidate(true);
//                RequestContext.getCurrentInstance().update("datos");
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
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                mensaje=getCabcalculopagarDao().anular(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabcalculopagar(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoAnular("Cálculo por Pagar", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                buscarFiltro(2);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                mensaje=getCabcalculopagarDao().eliminar(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabcalculopagar(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoEliminar("Cálculo por Pagar", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                buscarFiltro(2);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje=ex.getMessage();
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    
    @Override
    public void aprobar() {
        try {
            if(getDatoEdicion().getIdcabcalculopagar()==null){
                this.mensaje = "Documento no registrado";
                WebUtil.MensajeAdvertencia(this.mensaje );
                RequestContext.getCurrentInstance().update("datos:growl");
            }
//            else if(!getDatoEdicion().getIdestado().trim().equals("PE")){
//                this.mensaje = "Documento se encuentra en estado <"+getDatoEdicion().getEstado()+">";
//                WebUtil.MensajeAdvertencia(this.mensaje );
//                RequestContext.getCurrentInstance().update("datos:growl");
//            }
            else if(verificar_aprobacion()){
                mensaje=getCabcalculopagarDao().aprobarCalculoPagar(getDatoEdicion(),listDetcalculopagar_verification,user.getIDUSUARIO());
                if(mensaje!=null)
                    if(mensaje.trim().length()==15)
                        getDatoEdicion().setIdcabcalculopagar(mensaje.trim());
                WebUtil.info("Se aprobó el documento :"+getDatoEdicion().getIddocumento()+"-"+
                        getDatoEdicion().getSerie()+"-"+getDatoEdicion().getNumero()+" ("+getMensaje()+")");
                setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
            setMensaje(ex.getMessage());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
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
    public boolean verificar_aprobacion() throws IOException{
        boolean flag = true;
        String validacion ="";
        String httpcontenido="";
        setListDetcalculopagar_verification(new ArrayList<>());
        for(int i=0;i<listDetcalculopagarTotal.size();i++){
            Detcalculopagar obj = listDetcalculopagarTotal.get(i);
            validacion ="";
            if(obj.getIdclieprov()==null){
                validacion+="\n\t<Personal> no asignado";
            }else if(obj.getIdclieprov().trim().equals("")){
                validacion+="\n\t<Personal> no asignado";  
            }
            if(obj.getIddocumento()==null){
                validacion+="\n\t<Documento> no asignado";
            }else if(obj.getIddocumento().trim().equals("")){
                validacion+="\n\t<Documento> no asignado";  
            }
            if(obj.getSerie()==null){
                validacion+="\n\t<Serie> no asignado";
            }else if(obj.getSerie().trim().equals("")){
                validacion+="\n\t<Serie> no asignado";  
            }
            if(obj.getNumero()==null){
                validacion+="\n\t<Número> no asignado";
            }else if(obj.getNumero().trim().equals("")){
                validacion+="\n\t<Número> no asignado";  
            }
            if(obj.getFecha()==null)
                validacion+="\n\tFecha no asignado";
            if(obj.getFechaoperacion()==null)
                validacion+="\n\tFecha Operación no asignado";
            if(obj.getVencimiento()==null)
                validacion+="\n\tVencimiento no asignado";
            if(obj.getNumero()==null){
                validacion+="\n\t<Número> no asignado";
            }else if(obj.getNumero().trim().equals("")){
                validacion+="\n\t<Número> no asignado";  
            }
            if(obj.getIdcuenta()==null){
                validacion+="\n\t<Cuenta> no asignado";
            }else if(obj.getIdcuenta().trim().equals("")){
                validacion+="\n\t<Cuenta> no asignado";  
            }
            if(obj.getIdccosto()==null){
                validacion+="\n\t<Centro Costo> no asignado";
            }else if(obj.getIdccosto().trim().equals("")){
                validacion+="\n\t<Centro Costo> no asignado";  
            }
            if(!validacion.equals("")){
                flag = false;
                this.mensaje="\nFila N°:"+obj.getItem()+" - "+obj.getIdclieprov()+"-"+obj.getRazon_social()+" "+obj.getIddocumento()+"-"+obj.getSerie()+"-"+obj.getNumero()+" ("+obj.getFecha()+")" + validacion;
                httpcontenido+="\n"+this.mensaje;
            }else{
                listDetcalculopagar_verification.add(obj);
            }
        }
        log_consola = null;
        if(!httpcontenido.trim().equals("")){
            httpcontenido="*****************DETALLE OBSERVADO*******************"+httpcontenido;
            mostrarLog_txt(httpcontenido);
        }
        return flag;
    }
    public boolean esVistaValida() {
        if(getListDetcalculopagar().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        return true;
    }
    public List<Planctas> completePlanctas(String query) {
        cargarPlanctas(query);
        return listPlanctas;
    }
    public void cargarCuentasDetraccionDocumentos(){
        try{
            if(!listDetcalculopagar.isEmpty()){
                Detcalculopagar temp;
                Documentos doc ;
                Planctas pac ;
                Tipodetraccion tdet;
                List<Tipodetraccion> lstde;
                for(int i=0;i<listDetcalculopagar.size();i++){
                    temp = listDetcalculopagar.get(i);
                    if(temp.getIdcuenta()!=null){
                        if(!temp.getIdcuenta().trim().equals("")){
                            pac =  planctasDao.getPlanctas_idcuenta(user.getIDEMPRESA(), temp.getIdcuenta());
                            temp.setSelectCuenta(pac);
                        }
                    }
                    if(temp.getTipodetraccion_descripcion()!=null){
                        if(!temp.getTipodetraccion_descripcion().trim().equals("")){
                            tdet = tipodetraccionDao.getTipodetraccion_idtipodetraccion(temp.getIdtipodetra());
                            temp.setTipodetraccion_descripcion(tdet.getDescripcion());
                            temp.setIdtipodetra(tdet.getIdtipodetra());
                            temp.setTasa(tdet.getTasa());
                            temp.setSelectTipodetraccion(tdet);
                        }
                    }
                    if(temp.getIddocumento()!=null){
                        if(!temp.getIddocumento().trim().equals("")){
                            doc = documentoDao.getIddocumento(user.getIDEMPRESA(),temp.getIddocumento());
                            temp.setSelectDocumentos(doc);
                        }
                    }
                    listDetcalculopagar.set(i, temp);
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarPlanctas(String query){
        try {
            listPlanctas = (new PlanctasDao()).listarPorEmpresa(user.getIDEMPRESA(),query);
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Tipodetraccion> completeTipodetraccion(String query) {
        List<Tipodetraccion> filteredTipodetraccion = new ArrayList<Tipodetraccion>(); 
        for (int i = 0; i < listTipodetraccion.size(); i++) {
            Tipodetraccion skin = listTipodetraccion.get(i);
            if(skin.getIdtipodetra().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getNombre_corto().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredTipodetraccion.add(skin);
            }
        }
        return filteredTipodetraccion;
    }
    public List<Documentos> completeDocumentos(String query) {
        List<Documentos> filteredDocumentos = new ArrayList<Documentos>(); 
        for (int i = 0; i < getListDocumentos().size(); i++) {
            Documentos skin = getListDocumentos().get(i);
            if(skin.getIddocumento().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getCodigo_sunat().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredDocumentos.add(skin);
            }
        }
        return filteredDocumentos;
    }
    public List<Consumidor> completeConsumidor(String query) {
        List<Consumidor> filteredConsumidor= new ArrayList<Consumidor>(); 
        for (int i = 0; i < getListConsumidor().size(); i++) {
            Consumidor skin = getListConsumidor().get(i);
            if(skin.getIdconsumidor().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredConsumidor.add(skin);
            }
        }
        return filteredConsumidor;
    }
    public void onRefresh(){
        cargarDatosGenerales_detalle();
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public void getFindetalleCalculo(){
        try {
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDatoEdicion().getFinicio());
            String f_fin = f.format(getDatoEdicion().getFfin());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            listDetcalculopagarTotal = getDetcalculopagarDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,getDatoEdicion().getTipo());
            if(listDetcalculopagarTotal.isEmpty()){
                setMensaje("No se muestran registros");
                WebUtil.info(getMensaje());
                //setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos:growl");
           } else{
                listDetcalculopagar = new ArrayList<>();
                /***************************************CÁLCULO DE SUMATORIA *******************************************/
                Map<String, Data> group_calcultate = listDetcalculopagarTotal.stream().collect(
                    groupingBy(Detcalculopagar::getIdclieprov, 
                        collectingAndThen(summarizingDouble(Detcalculopagar::getTcosto), 
                            dss -> new Data((float)dss.getAverage(),(float)dss.getSum()))
                    )
                );
                /********************************************************************************/
                group_calcultate.forEach((idclieprov,dato)->{
                    Detcalculopagar result1 = listDetcalculopagarTotal.stream()                          
                    .filter(x -> idclieprov.trim().equals(x.getIdclieprov()))                            
                    .findAny()                                                          
                    .orElse(null);
                    /**/
                    Detcalculopagar newObj = new Detcalculopagar();
    //                newObj.setItem(listDetcalculopagar.size()+1);
                    newObj.setIdclieprov(result1.getIdclieprov());
                    newObj.setRazon_social(result1.getRazon_social());
                    newObj.setIddocumento(result1.getIddocumento());
                    newObj.setSerie(result1.getSerie());
                    newObj.setNumero(result1.getNumero());
                    newObj.setFecha(result1.getFecha());
                    newObj.setFechaoperacion(result1.getFechaoperacion());
                    newObj.setVencimiento(result1.getVencimiento());
                    newObj.setIdmoneda(result1.getIdmoneda());
                    newObj.setIdcuenta(result1.getIdcuenta());
                    newObj.setCuenta(result1.getCuenta());
                    newObj.setIdccosto(result1.getIdccosto());
                    newObj.setConcepto(result1.getConcepto());
                    newObj.setIdcliente(result1.getIdcliente());
                    newObj.setIdregimen(result1.getIdregimen());
                    newObj.setTcosto(dato.sum);
                    newObj.setIdimpuesto(result1.getIdimpuesto());
                    newObj.setEsdetraccion(result1.getEsdetraccion());
                    newObj.setIdtipodetra(result1.getIdtipodetra());
                    newObj.setTipodetraccion_descripcion(result1.getTipodetraccion_descripcion());
                    newObj.setTasa(result1.getTasa());
                    newObj.setEsplanilla(result1.getEsplanilla());
                    newObj.setTiene_suspension(result1.getTiene_suspension());
                    newObj.setUsuario_sol(result1.getUsuario_sol());
                    newObj.setClave_sol(result1.getClave_sol());
                    /**** Calcular ****/
                    if(newObj.getIdregimen().toString().trim().equals("01")){
                        newObj.setAfecto(newObj.getTcosto());
                        newObj.setInafecto(0.0f);
                    }else if(newObj.getIdregimen().toString().trim().equals("02")){

                    }else if(newObj.getIdregimen().toString().trim().equals("03")){
                        newObj.setAfecto(0.0f);
                        newObj.setInafecto(newObj.getTcosto());
                    }
                    if(newObj.getIdimpuesto()==null){
                        newObj.setIdimpuesto("000");
                        newObj.setImpuesto(0.0f);
                    }else{
                        Float[] object = impuestoDao.getImpuesto(user.getIDEMPRESA(), newObj.getIdimpuesto().toString()); 
                        newObj.setResta_base(object[0].intValue());
                        Float imp = object[1];
                        Float imp_dec =  imp/100;
                        newObj.setPimpuesto(imp_dec);
                        newObj.setIdimpuesto(newObj.getIdimpuesto().toString());
                        if(newObj.getIdregimen().trim().equals("01")){
                            newObj.setImpuesto(newObj.getAfecto()*newObj.getPimpuesto());
                        }else if(newObj.getIdregimen().trim().equals("03")){
                            newObj.setImpuesto(newObj.getInafecto()*newObj.getPimpuesto());
                        }
                    }
                    newObj.setTotal(newObj.getAfecto()+newObj.getInafecto()+(newObj.getImpuesto()*(newObj.getResta_base()==1?-1:1)));
                    listDetcalculopagar.add(newObj);
                });
                /*ORDER BY*/
                Collections.sort(listDetcalculopagar, new Comparator<Detcalculopagar>(){
                    public int compare(Detcalculopagar p1, Detcalculopagar p2){
                      return p1.getRazon_social().compareTo(p2.getRazon_social());
                    }
                });
                int cnum =0;
                for(int i=1;i<=listDetcalculopagar.size();i++){
                    listDetcalculopagar.get(cnum).setItem(i);
                    cnum++;
                }
                /*Evaluar Total >1500.00 , aplicar renta de 4ta*/
                Detcalculopagar dt;
                for(int i=0;i<listDetcalculopagar.size();i++){
                    dt = listDetcalculopagar.get(i);
                    if(dt.getTotal().floatValue()>1500.0f && dt.getTiene_suspension()==0){
                        dt.setIdimpuesto(renta4);
                        Float[] object = impuestoDao.getImpuesto(user.getIDEMPRESA(), dt.getIdimpuesto().toString()); 
                        dt.setResta_base(object[0].intValue());
                        Float imp = object[1];
                        Float imp_dec =  imp/100;
                        dt.setPimpuesto(imp_dec);
                        dt.setIdimpuesto(dt.getIdimpuesto().toString());
                        if(dt.getIdregimen().trim().equals("01")){
                            dt.setImpuesto(dt.getAfecto()*dt.getPimpuesto());
                        }else if(dt.getIdregimen().trim().equals("03")){
                            dt.setImpuesto(dt.getInafecto()*dt.getPimpuesto());
                        }
                        dt.setTotal(dt.getAfecto()+dt.getInafecto()+(dt.getImpuesto()*(dt.getResta_base()==1?-1:1)));
                        listDetcalculopagar.set(i, dt);
                        /************** Recalcular *************/
                        for(int j=0;j<listDetcalculopagarTotal.size();j++){
                            if(listDetcalculopagarTotal.get(j).getIdclieprov().trim().equals(dt.getIdclieprov().trim())){
                                listDetcalculopagarTotal.get(j).setIddocumento(dt.getIddocumento());
                                listDetcalculopagarTotal.get(j).setSerie(dt.getSerie());
                                listDetcalculopagarTotal.get(j).setIdmoneda(dt.getIdmoneda());
                                listDetcalculopagarTotal.get(j).setIdcuenta(dt.getIdcuenta());
                                listDetcalculopagarTotal.get(j).setCuenta(dt.getCuenta());
                                listDetcalculopagarTotal.get(j).setIdccosto(dt.getIdccosto());
                                listDetcalculopagarTotal.get(j).setConcepto(dt.getConcepto());
                                listDetcalculopagarTotal.get(j).setIdregimen(dt.getIdregimen());
                                listDetcalculopagarTotal.get(j).setIdimpuesto(dt.getIdimpuesto());
                                listDetcalculopagarTotal.get(j).setIdtipodetra(dt.getIdtipodetra());
                                listDetcalculopagarTotal.get(j).setTipodetraccion_descripcion(dt.getTipodetraccion_descripcion());
                                listDetcalculopagarTotal.get(j).setTasa(dt.getTasa());
                                /**** Calcular ****/
                                if(listDetcalculopagarTotal.get(j).getIdregimen().toString().trim().equals("01")){
                                    listDetcalculopagarTotal.get(j).setAfecto(listDetcalculopagarTotal.get(i).getTcosto());
                                    listDetcalculopagarTotal.get(j).setInafecto(0.0f);
                                }else if(listDetcalculopagarTotal.get(j).getIdregimen().toString().trim().equals("02")){

                                }else if(listDetcalculopagarTotal.get(j).getIdregimen().toString().trim().equals("03")){
                                    listDetcalculopagarTotal.get(j).setAfecto(0.0f);
                                    listDetcalculopagarTotal.get(j).setInafecto(listDetcalculopagarTotal.get(j).getTcosto());
                                }
                                if(listDetcalculopagarTotal.get(j).getIdimpuesto()==null){
                                    listDetcalculopagarTotal.get(j).setIdimpuesto("000");
                                    listDetcalculopagarTotal.get(j).setImpuesto(0.0f);
                                }else{
                                    listDetcalculopagarTotal.get(j).setResta_base(dt.getResta_base());
                                    listDetcalculopagarTotal.get(j).setIdimpuesto(listDetcalculopagarTotal.get(j).getIdimpuesto().toString());
                                    if(listDetcalculopagarTotal.get(j).getIdregimen().trim().equals("01")){
                                        listDetcalculopagarTotal.get(j).setImpuesto(listDetcalculopagarTotal.get(j).getAfecto()*dt.getPimpuesto());
                                    }else if(listDetcalculopagarTotal.get(j).getIdregimen().trim().equals("03")){
                                        listDetcalculopagarTotal.get(j).setImpuesto(listDetcalculopagarTotal.get(j).getInafecto()*dt.getPimpuesto());
                                    }
                                }
                                listDetcalculopagarTotal.get(j).setTotal(listDetcalculopagarTotal.get(j).getAfecto()+listDetcalculopagarTotal.get(j).getInafecto()+
                                        (listDetcalculopagarTotal.get(j).getImpuesto()*(listDetcalculopagarTotal.get(j).getResta_base()==1?-1:1)));
                            }
                        }
                    }
                }
            }
            cargarCuentasDetraccionDocumentos();
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(CabcalculopagarAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findetalle() throws Exception {
        try{
            if(getLadd()==1){/*NUEVO*/
                getFindetalleCalculo();
            }else if(getLadd()==2){/*EDITAR*/
                listDetcalculopagarTotal = detcalculopagarDao.listar_detallado(user.getIDEMPRESA(), getDatoEdicion().getIdcabcalculopagar());
                /***************************************CÁLCULO DE SUMATORIA *******************************************/
                Map<String, Data> group_calcultate = listDetcalculopagarTotal.stream().collect(
                    groupingBy(Detcalculopagar::getIdclieprov, 
                        collectingAndThen(summarizingDouble(Detcalculopagar::getTcosto), 
                            dss -> new Data((float)dss.getAverage(),(float)dss.getSum()))
                    )
                );
                /********************************************************************************/
                group_calcultate.forEach((idclieprov,dato)->{
                    Detcalculopagar result1 = listDetcalculopagarTotal.stream()                          
                    .filter(x -> idclieprov.trim().equals(x.getIdclieprov()))                            
                    .findAny()                                                          
                    .orElse(null);
                    /**/
                    Detcalculopagar newObj = new Detcalculopagar();
    //                newObj.setItem(listDetcalculopagar.size()+1);
                    newObj.setIdclieprov(result1.getIdclieprov());
                    newObj.setRazon_social(result1.getRazon_social());
                    newObj.setIddocumento(result1.getIddocumento());
                    newObj.setSerie(result1.getSerie());
                    newObj.setNumero(result1.getNumero());
                    newObj.setFecha(result1.getFecha());
                    newObj.setFechaoperacion(result1.getFechaoperacion());
                    newObj.setVencimiento(result1.getVencimiento());
                    newObj.setIdmoneda(result1.getIdmoneda());
                    newObj.setIdcuenta(result1.getIdcuenta());
                    newObj.setCuenta(result1.getCuenta());
                    newObj.setIdccosto(result1.getIdccosto());
                    newObj.setConcepto(result1.getConcepto());
                    newObj.setIdcliente(result1.getIdcliente());
                    newObj.setIdregimen(result1.getIdregimen());
                    newObj.setTcosto(dato.sum);
                    newObj.setIdimpuesto(result1.getIdimpuesto());
                    newObj.setEsdetraccion(result1.getEsdetraccion());
                    newObj.setIdtipodetra(result1.getIdtipodetra());
                    newObj.setTipodetraccion_descripcion(result1.getTipodetraccion_descripcion());
                    newObj.setTasa(result1.getTasa());
                    newObj.setEsplanilla(result1.getEsplanilla());
                    newObj.setTiene_suspension(result1.getTiene_suspension());
                    newObj.setUsuario_sol(result1.getUsuario_sol());
                    newObj.setClave_sol(result1.getClave_sol());
                    /**** Calcular ****/
                    if(newObj.getIdregimen().toString().trim().equals("01")){
                        newObj.setAfecto(newObj.getTcosto());
                        newObj.setInafecto(0.0f);
                    }else if(newObj.getIdregimen().toString().trim().equals("02")){

                    }else if(newObj.getIdregimen().toString().trim().equals("03")){
                        newObj.setAfecto(0.0f);
                        newObj.setInafecto(newObj.getTcosto());
                    }
                    if(newObj.getIdimpuesto()==null){
                        newObj.setIdimpuesto("000");
                        newObj.setImpuesto(0.0f);
                    }else{
                        Float[] object = impuestoDao.getImpuesto(user.getIDEMPRESA(), newObj.getIdimpuesto().toString()); 
                        newObj.setResta_base(object[0].intValue());
                        Float imp = object[1];
                        Float imp_dec =  imp/100;
                        newObj.setIdimpuesto(newObj.getIdimpuesto().toString());
                        if(newObj.getIdregimen().trim().equals("01")){
                            newObj.setImpuesto(newObj.getAfecto()*imp_dec);
                        }else if(newObj.getIdregimen().trim().equals("03")){
                            newObj.setImpuesto(newObj.getInafecto()*imp_dec);
                        }
                    }
                    newObj.setTotal(newObj.getAfecto()+newObj.getInafecto()+(newObj.getImpuesto()*(newObj.getResta_base()==1?-1:1)));
                    listDetcalculopagar.add(newObj);
                });
                /*ORDER BY*/
                Collections.sort(listDetcalculopagar, new Comparator<Detcalculopagar>(){
                    public int compare(Detcalculopagar p1, Detcalculopagar p2){
                      return p1.getRazon_social().compareTo(p2.getRazon_social());
                    }
                });
                int cnum =0;
                for(int i=1;i<=listDetcalculopagar.size();i++){
                    listDetcalculopagar.get(cnum).setItem(i);
                    cnum++;
                }
                cargarCuentasDetraccionDocumentos();
            }
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        }catch(Exception ex){
            this.mensaje=ex.getMessage();
            WebUtil.error(mensaje);
        }
        //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
    }
    public void cargarDetalle(){
        /***************************************CÁLCULO DE SUMATORIA *******************************************/
        if(!listDetcalculopagarTotal.isEmpty()){
            Map<String, Data> group_calcultate = listDetcalculopagarTotal.stream().collect(
                groupingBy(Detcalculopagar::getIdclieprov, 
                collectingAndThen(summarizingDouble(Detcalculopagar::getTcosto), 
                    dss -> new Data((float)dss.getAverage(),(float)dss.getSum()))
                )
            );
            /********************************************************************************/
            group_calcultate.forEach((idclieprov,dato)->{
                Detcalculopagar result1 = listDetcalculopagarTotal.stream()                          
                .filter(x -> idclieprov.trim().equals(x.getIdclieprov()))                            
                .findAny()                                                          
                .orElse(null);
                /**/
                Detcalculopagar newObj = new Detcalculopagar();
    //                newObj.setItem(listDetcalculopagar.size()+1);
                newObj.setIdclieprov(result1.getIdclieprov());
                newObj.setRazon_social(result1.getRazon_social());
                newObj.setIddocumento(result1.getIddocumento());
                newObj.setSerie(result1.getSerie());
                newObj.setNumero(result1.getNumero());
                newObj.setFecha(result1.getFecha());
                newObj.setFechaoperacion(result1.getFechaoperacion());
                newObj.setVencimiento(result1.getVencimiento());
                newObj.setIdmoneda(result1.getIdmoneda());
                newObj.setIdcuenta(result1.getIdcuenta());
                newObj.setCuenta(result1.getCuenta());
                newObj.setIdccosto(result1.getIdccosto());
                newObj.setConcepto(result1.getConcepto());
                newObj.setIdcliente(result1.getIdcliente());
                newObj.setIdregimen(result1.getIdregimen());
                newObj.setTcosto(dato.sum);
                newObj.setIdimpuesto(result1.getIdimpuesto());
                newObj.setEsdetraccion(result1.getEsdetraccion());
                newObj.setIdtipodetra(result1.getIdtipodetra());
                newObj.setTipodetraccion_descripcion(result1.getTipodetraccion_descripcion());
                newObj.setTasa(result1.getTasa());
                newObj.setEsplanilla(result1.getEsplanilla());
                newObj.setTiene_suspension(result1.getTiene_suspension());
                newObj.setUsuario_sol(result1.getUsuario_sol());
                newObj.setClave_sol(result1.getClave_sol());
                /**** Calcular ****/
                if(newObj.getIdregimen().toString().trim().equals("01")){
                    newObj.setAfecto(newObj.getTcosto());
                    newObj.setInafecto(0.0f);
                }else if(newObj.getIdregimen().toString().trim().equals("02")){

                }else if(newObj.getIdregimen().toString().trim().equals("03")){
                    newObj.setAfecto(0.0f);
                    newObj.setInafecto(newObj.getTcosto());
                }
                if(newObj.getIdimpuesto()==null){
                    newObj.setIdimpuesto("000");
                    newObj.setImpuesto(0.0f);
                }else{
                    Float[] object = impuestoDao.getImpuesto(user.getIDEMPRESA(), newObj.getIdimpuesto().toString()); 
                    newObj.setResta_base(object[0].intValue());
                    Float imp = object[1];
                    Float imp_dec =  imp/100;
                    newObj.setIdimpuesto(newObj.getIdimpuesto().toString());
                    if(newObj.getIdregimen().trim().equals("01")){
                        newObj.setImpuesto(newObj.getAfecto()*imp_dec);
                    }else if(newObj.getIdregimen().trim().equals("03")){
                        newObj.setImpuesto(newObj.getInafecto()*imp_dec);
                    }
                }
                newObj.setTotal(newObj.getAfecto()+newObj.getInafecto()+(newObj.getImpuesto()*(newObj.getResta_base()==1?-1:1)));
                listDetcalculopagar.add(newObj);
            });
            /*ORDER BY*/
            Collections.sort(listDetcalculopagar, new Comparator<Detcalculopagar>(){
                public int compare(Detcalculopagar p1, Detcalculopagar p2){
                  return p1.getRazon_social().compareTo(p2.getRazon_social());
                }
            });
            int cnum =0;
            for(int i=1;i<=listDetcalculopagar.size();i++){
                listDetcalculopagar.get(cnum).setItem(i);
                cnum++;
            }
            cargarCuentasDetraccionDocumentos();
        }
    }
    class Data {
        float average;
        float sum;

        public Data(float average, float sum) {
            this.average = average;
            this.sum = sum;
        }

        // Getter and setter
    }
    public void buscar_filtrofecha() {
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            listDetcalculopagarTotal = getDetcalculopagarDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
//            listDetcalculopagar = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
            findetalle();
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
        if(selectDetcalculopagar!=null){
            Date fecha;
            /************************ REPLICAR TOTALES *************************/
            for(int i=0;i<listDetcalculopagar.size();i++){
                Detcalculopagar dtw = listDetcalculopagar.get(i);
                if(WebUtil.isnull(dtw.getIddocumento(), "").trim().equals("")){
                    dtw.setIddocumento(selectDetcalculopagar.getIddocumento());
                    dtw.setSelectDocumentos(selectDetcalculopagar.getSelectDocumentos());
                }
                if(WebUtil.isnull(dtw.getSerie(), "").trim().equals("")){
                    dtw.setSerie(selectDetcalculopagar.getSerie());
                }
                if(dtw.getFecha()==null){
                    fecha = new Date(selectDetcalculopagar.getFecha().getTime());
                    dtw.setFecha(fecha);
                }
                if(dtw.getFechaoperacion()==null){
                    fecha = new Date(selectDetcalculopagar.getFechaoperacion().getTime());
                    dtw.setFechaoperacion(fecha);
                }
                if(dtw.getVencimiento()==null){
                    fecha = new Date(selectDetcalculopagar.getVencimiento().getTime());
                    dtw.setVencimiento(fecha);
                }
                dtw.setIdmoneda(selectDetcalculopagar.getIdmoneda());
                if(WebUtil.isnull(dtw.getIdcuenta(), "").trim().equals("")){
                    dtw.setIdcuenta(selectDetcalculopagar.getIdcuenta());
                    dtw.setCuenta(selectDetcalculopagar.getCuenta());
                    dtw.setSelectCuenta(selectDetcalculopagar.getSelectCuenta());
                }
                if(WebUtil.isnull(dtw.getIdccosto(), "").trim().equals("")){
                    dtw.setIdccosto(selectDetcalculopagar.getIdccosto());
                    dtw.setSelectConsumidor(selectDetcalculopagar.getSelectConsumidor());
                    dtw.setConcepto(selectDetcalculopagar.getConcepto());
                }
                dtw.setIdregimen(selectDetcalculopagar.getIdregimen());
                if(WebUtil.isnull(dtw.getIdimpuesto(), "000").trim().equals("000")){
                    dtw.setIdimpuesto(selectDetcalculopagar.getIdimpuesto());
                }
                dtw.setEsdetraccion(selectDetcalculopagar.getEsdetraccion());
                dtw.setIdtipodetra(selectDetcalculopagar.getIdtipodetra());
                dtw.setTipodetraccion_descripcion(selectDetcalculopagar.getTipodetraccion_descripcion());
                dtw.setSelectTipodetraccion(selectDetcalculopagar.getSelectTipodetraccion());
                dtw.setTasa(selectDetcalculopagar.getTasa());
                /*CALCULAR IMPORTES*/
                Float[] array = impuestoDao.getImpuesto(user.getIDEMPRESA(), dtw.getIdimpuesto());
                Float imp = array[1];
                dtw.setResta_base(array[0].intValue());
                Float imp_dec =  imp/100;
                if(dtw.getIdregimen().trim().equals("01")){
                    dtw.setAfecto(dtw.getTcosto());
                    dtw.setInafecto(0.0f);
                    dtw.setImpuesto(dtw.getAfecto()*imp_dec);
                }else if(dtw.getIdregimen().trim().equals("03")){
                    dtw.setInafecto(dtw.getTcosto());
                    dtw.setAfecto(0.0f);
                    dtw.setImpuesto(dtw.getInafecto()*imp_dec);
                }
                dtw.setTotal(dtw.getAfecto()+dtw.getInafecto()+(dtw.getImpuesto()*(dtw.getResta_base()==1?-1:1)));
                listDetcalculopagar.set(i, dtw);
                /************************ REPLICAR DETALLADOS *************************/
                for(int j = 0;j<listDetcalculopagarTotal.size();j++){
                    Detcalculopagar dtw_detallado=listDetcalculopagarTotal.get(j);
                    if(dtw.getIdclieprov().trim().equals(dtw_detallado.getIdclieprov())){
                        dtw_detallado.setIddocumento(dtw.getIddocumento());
                        dtw_detallado.setSerie(dtw.getSerie());
                        dtw_detallado.setFecha(dtw.getFecha());
                        dtw_detallado.setFechaoperacion(dtw.getFechaoperacion());
                        dtw_detallado.setVencimiento(dtw.getVencimiento());
                        dtw_detallado.setIdmoneda(dtw.getIdmoneda());
                        dtw_detallado.setIdcuenta(dtw.getIdcuenta());
                        dtw_detallado.setCuenta(dtw.getCuenta());
                        dtw_detallado.setSelectCuenta(dtw.getSelectCuenta());
                        dtw_detallado.setIdccosto(dtw.getIdccosto());
                        dtw_detallado.setSelectConsumidor(dtw.getSelectConsumidor());
                        dtw_detallado.setConcepto(dtw.getConcepto());
                        dtw_detallado.setIdregimen(dtw.getIdregimen());
                        dtw_detallado.setIdimpuesto(dtw.getIdimpuesto());
                        dtw_detallado.setIdtipodetra(dtw.getIdtipodetra());
                        dtw_detallado.setTipodetraccion_descripcion(dtw.getTipodetraccion_descripcion());
                        dtw_detallado.setSelectTipodetraccion(dtw.getSelectTipodetraccion());
                        dtw_detallado.setTasa(dtw.getTasa());
                        dtw_detallado.setEsdetraccion(dtw.getEsdetraccion());
                        if(dtw_detallado.getIdregimen().trim().equals("01")){
                            dtw_detallado.setAfecto(dtw_detallado.getTcosto());
                            dtw_detallado.setInafecto(0.0f);
                            dtw_detallado.setImpuesto(dtw_detallado.getAfecto()*imp_dec);
                        }else if(dtw_detallado.getIdregimen().trim().equals("03")){
                            dtw_detallado.setInafecto(dtw_detallado.getTcosto());
                            dtw_detallado.setAfecto(0.0f);
                            dtw_detallado.setImpuesto(dtw_detallado.getInafecto()*imp_dec);
                        }
                        dtw_detallado.setTotal(dtw_detallado.getAfecto()+dtw_detallado.getInafecto()+(dtw_detallado.getImpuesto()*(dtw_detallado.getResta_base()==1?-1:1)));
                    } 
                    listDetcalculopagarTotal.set(j, dtw_detallado);
                }
            }
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:tbl");
        }
    }
    public UsuarioBean getUser() {
        return user;
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
            setListaDatos(getCabcalculopagarDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
//            listDetcalculopagarTotal = getDetcalculopagarDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
//            findetalle();
//            cargarCuentasDetraccionDocumentos();
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        if(tipo == 2)
            lista_accion_filtro("wLst_Cabcalculopagar");
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
        /*Actulizar datos de resumen al detalle*/
        cargarDatosGenerales_detalle();
        
        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,"RESUMEN "+this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
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
        
        HSSFCellStyle estiloFila_date = objWB.createCellStyle();
        estiloFila_date.setWrapText(true);
        estiloFila_date.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila_date.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setFont(fuente);
        estiloFila_date.setDataFormat(format.getFormat("dd/mm/yyyy"));
        int col = 23;
        int row = listDetcalculopagar.size();
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
                case 22:celda.setCellValue("ESPLANILLA");break;
            }
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).getRow(i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdclieprov());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getRazon_social());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIddocumento());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getSerie());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getNumero());
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getFecha(), 7));
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getFechaoperacion(), 7));
            
            celda = fila.createCell((short)7);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getVencimiento(),7));
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdmoneda());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdcuenta());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdccosto());
            
            celda = fila.createCell((short)11);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getConcepto());
            
            celda = fila.createCell((short)12);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdcliente());
            
            celda = fila.createCell((short)13);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdregimen());
            
            celda = fila.createCell((short)14);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(listDetcalculopagar.get(i).getAfecto()).doubleValue());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getInafecto());
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdimpuesto());
            
            celda = fila.createCell((short)17);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getImpuesto());
            
            celda = fila.createCell((short)18);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTotal());
            
            
            celda = fila.createCell((short)19);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(Float.parseFloat(listDetcalculopagar.get(i).getEsdetraccion().toString()));
            
            celda = fila.createCell((short)20);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getTipodetraccion_descripcion());
            
            celda = fila.createCell((short)21);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTasa());
            
            celda = fila.createCell((short)22);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getEsplanilla());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
        /*CREAR OTRA HOJA DETALLADO NISIRA*/
        HSSFSheet sheet1 = objWB.createSheet("NISIRA "+this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        fila_cabecera = sheet1.createRow((short)0);
        col = 24;
        row = listDetcalculopagarTotal.size();
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
                case 19:celda.setCellValue("ORDEN REGISTRO");break;
                case 20:celda.setCellValue("TIENE DETRACCION");break;
                case 21:celda.setCellValue("TIPO DE DETRACCIÓN");break;
                case 22:celda.setCellValue("TASA DE DETRACCIÓN");break;
                case 23:celda.setCellValue("ESPLANILLA");break;
            }
        }
        for(int i=0;i<row;i++){
            fila = sheet1.createRow(i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdclieprov());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getRazon_social());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIddocumento());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getSerie());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getNumero());
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getFecha(), 7));
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getFechaoperacion(), 7));
            
            celda = fila.createCell((short)7);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getVencimiento(),7));
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdmoneda());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdcuenta());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdccosto());
            
            celda = fila.createCell((short)11);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getConcepto());
            
            celda = fila.createCell((short)12);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdcliente());
            
            celda = fila.createCell((short)13);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdregimen());
            
            celda = fila.createCell((short)14);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(listDetcalculopagarTotal.get(i).getAfecto()).doubleValue());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getInafecto());
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdimpuesto());
            
            celda = fila.createCell((short)17);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getImpuesto());
            
            celda = fila.createCell((short)18);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTotal());
            
            celda = fila.createCell((short)19);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getOrdenregistro());
            
            celda = fila.createCell((short)20);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(Float.parseFloat(listDetcalculopagarTotal.get(i).getEsdetraccion().toString()));
            
            celda = fila.createCell((short)21);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTipodetraccion_descripcion());
            
            celda = fila.createCell((short)22);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTasa());
            
            celda = fila.createCell((short)23);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getEsplanilla());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(1).autoSizeColumn((short) as);
        }
        
        /*CREAR OTRA HOJA DETALLADO NISIRA*/
        HSSFSheet sheet2 = objWB.createSheet("DETALLADO "+this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        fila_cabecera = sheet2.createRow((short)0);
        col = 60;
        row = listDetcalculopagarTotal.size();
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
                case 19:celda.setCellValue("ORDEN REGISTRO");break;
                case 20:celda.setCellValue("TIENE DETRACCION");break;
                case 21:celda.setCellValue("TIPO DE DETRACCIÓN");break;
                case 22:celda.setCellValue("TASA DE DETRACCIÓN");break;
                case 23:celda.setCellValue("ESPLANILLA");break;
                /*AGREGAR CAMPOS ADICIONALES*/
                case 24:celda.setCellValue("DOC SER");break;
                case 25:celda.setCellValue("SERIE SER");break;
                case 26:celda.setCellValue("NUMERO SER");break;
                case 27:celda.setCellValue("FECHA SER");break;
                case 28:celda.setCellValue("RUC");break;
                case 29:celda.setCellValue("CLIENTE");break;
                case 30:celda.setCellValue("CARGO");break;
                case 31:celda.setCellValue("CODOPERACION");break;
                case 32:celda.setCellValue("RUTA SERV");break;
                case 33:celda.setCellValue("FECHA INICIO");break;
                case 34:celda.setCellValue("HORA INICIO");break;
                case 35:celda.setCellValue("HORA FIN");break;
                case 36:celda.setCellValue("FECHA FIN");break;
                case 37:celda.setCellValue("HORAS SERVICIO");break;
                case 38:celda.setCellValue("HORAS E.C");break;
                case 39:celda.setCellValue("HORAS ADICIONAL");break;
                case 40:celda.setCellValue("COSTO RxH");break;
                case 41:celda.setCellValue("COSTO H.ADICIONAL");break;
                case 42:celda.setCellValue("COSTO BONO");break;
                /*AGREGAR CAMPOS ADICIONALES - TAREO*/
                case 43:celda.setCellValue("T.HORA REQ.");break;
                case 44:celda.setCellValue("T.HORA LLEGADA");break;
                case 45:celda.setCellValue("T.HORA INICIO");break;
                case 46:celda.setCellValue("T.HORA FIN");break;
                case 47:celda.setCellValue("T.HORA LIBERACION");break;
                
                case 48:celda.setCellValue("IDAMBITO");break;
                case 49:celda.setCellValue("AMBITO_SERVICIO");break;
                case 50:celda.setCellValue("CHECKLIST");break;
                case 51:celda.setCellValue("PLACA PSS");break;
                case 52:celda.setCellValue("NROCONTENEDOR");break;
                case 53:celda.setCellValue("NROPRECINTO");break;
                case 54:celda.setCellValue("NRO_OSERVICIO");break;
                case 55:celda.setCellValue("PLACA_CLIENTE");break;
                case 56:celda.setCellValue("CONDUCTOR_CLIENTE");break;
                case 57:celda.setCellValue("BREVETE_CLIENTE");break;
                case 58:celda.setCellValue("#SERVICIOS_DIA");break;
                case 59:celda.setCellValue("ORIGENCALLAO");break;
            }
        }
        for(int i=0;i<row;i++){
            fila = sheet2.createRow(i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdclieprov());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getRazon_social());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIddocumento());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getSerie());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getNumero());
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getFecha(), 7));
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getFechaoperacion(), 7));
            
            celda = fila.createCell((short)7);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getVencimiento(),7));
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdmoneda());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdcuenta());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdccosto());
            
            celda = fila.createCell((short)11);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getConcepto());
            
            celda = fila.createCell((short)12);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdcliente());
            
            celda = fila.createCell((short)13);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdregimen());
            
            celda = fila.createCell((short)14);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(listDetcalculopagarTotal.get(i).getAfecto()).doubleValue());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getInafecto());
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdimpuesto());
            
            celda = fila.createCell((short)17);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getImpuesto());
            
            celda = fila.createCell((short)18);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTotal());
            
            celda = fila.createCell((short)19);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getOrdenregistro());
            
            celda = fila.createCell((short)20);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(Float.parseFloat(listDetcalculopagarTotal.get(i).getEsdetraccion().toString()));
            
            celda = fila.createCell((short)21);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTipodetraccion_descripcion());
            
            celda = fila.createCell((short)22);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getTasa());
            
            celda = fila.createCell((short)23);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getEsplanilla());
            
            /*AGREGAR CAMPOS ADICIONALES*/
            celda = fila.createCell((short)24);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDiddocumento());
            
            celda = fila.createCell((short)25);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDserie());
            
            celda = fila.createCell((short)26);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDnumero());
            
            celda = fila.createCell((short)27);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getDfecha_osc(), 7));
            
            celda = fila.createCell((short)28);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdcliente());
            
            celda = fila.createCell((short)29);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDcliente());
            
            celda = fila.createCell((short)30);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDidcargo()+" "+listDetcalculopagarTotal.get(i).getCargo());
        
            celda = fila.createCell((short)31);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDcodoperaciones_ec());
            
            celda = fila.createCell((short)32);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getRutaservicio());
            
            celda = fila.createCell((short)33);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getDfecharegistro(), 7));
            
            celda = fila.createCell((short)34);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhi_s());
            
            celda = fila.createCell((short)35);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhf_s());
            
            celda = fila.createCell((short)36);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagarTotal.get(i).getDfechafinregistro(), 7));
            
            celda = fila.createCell((short)37);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhs_s());
            
            celda = fila.createCell((short)38);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhbase());
            
            celda = fila.createCell((short)39);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhadicional());
            
            celda = fila.createCell((short)40);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDcosto_rh());
            
            celda = fila.createCell((short)41);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDhcosto_adicional());
            
            celda = fila.createCell((short)42);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDcosto_bono());
            
            /************************** HORAS TAREO ***************************/
            celda = fila.createCell((short)43);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getShora_req());
            
            celda = fila.createCell((short)44);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getShora_llegada());
            
            celda = fila.createCell((short)45);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getShora_inicio_serv());
            
            celda = fila.createCell((short)46);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getShora_fin_serv());
            
            celda = fila.createCell((short)47);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getShora_liberacion());
            
            celda = fila.createCell((short)48);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getIdambito_servicio());
            
            celda = fila.createCell((short)49);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getAmbito_servicio());
            
            celda = fila.createCell((short)50);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDchecklist());
            
            celda = fila.createCell((short)51);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDidvehiculo());
            
            celda = fila.createCell((short)52);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDnrocontenedor());
            
            celda = fila.createCell((short)53);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDnroprecinto());
            
            celda = fila.createCell((short)54);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDnro_oservicio());
            
            celda = fila.createCell((short)55);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDplaca_cliente());
            
            celda = fila.createCell((short)56);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDconductor_cliente());
            
            celda = fila.createCell((short)57);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getDbrevete_cliente());
            
            celda = fila.createCell((short)58);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getNservicios_dia()==null?0:listDetcalculopagarTotal.get(i).getNservicios_dia());
            
            celda = fila.createCell((short)59);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagarTotal.get(i).getOrigencallao());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(2).autoSizeColumn((short) as);
        }
    }
    public void cargarDatosGenerales_detalle(){
        if(!listDetcalculopagar.isEmpty()){
            for(Detcalculopagar cb:listDetcalculopagar){
                for(int i=0;i<listDetcalculopagarTotal.size();i++){
                    if(listDetcalculopagarTotal.get(i).getIdclieprov().trim().equals(cb.getIdclieprov().trim())){
                        listDetcalculopagarTotal.get(i).setIddocumento(cb.getIddocumento());
                        listDetcalculopagarTotal.get(i).setSerie(cb.getSerie());
                        listDetcalculopagarTotal.get(i).setIdmoneda(cb.getIdmoneda());
                        listDetcalculopagarTotal.get(i).setIdcuenta(cb.getIdcuenta());
                        listDetcalculopagarTotal.get(i).setCuenta(cb.getCuenta());
                        listDetcalculopagarTotal.get(i).setIdccosto(cb.getIdccosto());
                        listDetcalculopagarTotal.get(i).setConcepto(cb.getConcepto());
                        listDetcalculopagarTotal.get(i).setIdregimen(cb.getIdregimen());
                        listDetcalculopagarTotal.get(i).setIdimpuesto(cb.getIdimpuesto());
                        listDetcalculopagarTotal.get(i).setIdtipodetra(cb.getIdtipodetra());
                        listDetcalculopagarTotal.get(i).setTipodetraccion_descripcion(cb.getTipodetraccion_descripcion());
                        listDetcalculopagarTotal.get(i).setTasa(cb.getTasa());
                        /**** Calcular ****/
                        if(listDetcalculopagarTotal.get(i).getIdregimen().toString().trim().equals("01")){
                            listDetcalculopagarTotal.get(i).setAfecto(listDetcalculopagarTotal.get(i).getTcosto());
                            listDetcalculopagarTotal.get(i).setInafecto(0.0f);
                        }else if(listDetcalculopagarTotal.get(i).getIdregimen().toString().trim().equals("02")){

                        }else if(listDetcalculopagarTotal.get(i).getIdregimen().toString().trim().equals("03")){
                            listDetcalculopagarTotal.get(i).setAfecto(0.0f);
                            listDetcalculopagarTotal.get(i).setInafecto(listDetcalculopagarTotal.get(i).getTcosto());
                        }
                        if(listDetcalculopagarTotal.get(i).getIdimpuesto()==null){
                            listDetcalculopagarTotal.get(i).setIdimpuesto("000");
                            listDetcalculopagarTotal.get(i).setImpuesto(0.0f);
                        }else{
                            listDetcalculopagarTotal.get(i).setResta_base(cb.getResta_base());
                            listDetcalculopagarTotal.get(i).setIdimpuesto(listDetcalculopagarTotal.get(i).getIdimpuesto().toString());
                            if(listDetcalculopagarTotal.get(i).getIdregimen().trim().equals("01")){
                                listDetcalculopagarTotal.get(i).setImpuesto(listDetcalculopagarTotal.get(i).getAfecto()*cb.getPimpuesto());
                            }else if(listDetcalculopagarTotal.get(i).getIdregimen().trim().equals("03")){
                                listDetcalculopagarTotal.get(i).setImpuesto(listDetcalculopagarTotal.get(i).getInafecto()*cb.getPimpuesto());
                            }
                        }
                        listDetcalculopagarTotal.get(i).setTotal(listDetcalculopagarTotal.get(i).getAfecto()+listDetcalculopagarTotal.get(i).getInafecto()+
                                (listDetcalculopagarTotal.get(i).getImpuesto()*(listDetcalculopagarTotal.get(i).getResta_base()==1?-1:1)));
                    }
                    
                }
            }
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
    public void visualizar_calculo() {
        try {
            if(selectDetcalculopagar==null){
                this.mensaje="Seleccionar registro";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                listDetcalculopagarPersonal = new ArrayList<>();
                this.scosto = 0.0f;
                for(Detcalculopagar obj:listDetcalculopagarTotal){
                    if(obj.getIdclieprov().trim().equals(selectDetcalculopagar.getIdclieprov())){
                        this.scosto+=obj.getTcosto();
                        listDetcalculopagarPersonal.add(obj);
                    }
                }
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog");
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:tsubtotal");
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:listDet_tareo_verificacion"); 
                RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').show()");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void detalleTareoCalculo() {
        try {
            if(selectDetcalculopagar_detalle==null){
                this.mensaje="Seleccionar Detalle Cálculo";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                RequestContext.getCurrentInstance().update("datos:detalleTareoCalculoDialog");
                RequestContext.getCurrentInstance().execute("PF('detalleTareoCalculoDialog').show()");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void visualizar_tareo() {
        try {
            if(selectDetcalculopagar==null){
                this.mensaje="Seleccionar registro";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                listDet_tareo_verificacion = det_tareoweb_verificationDao.getVisualizar_tareo_ordenservicio(user.getIDEMPRESA(), selectDetcalculopagar.getDidordenservicio());
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
     * @return the listWtiposervicio
     */
    public List<Wtiposervicio> getListWtiposervicio() {
        return listWtiposervicio;
    }

    /**
     * @param listWtiposervicio the listWtiposervicio to set
     */
    public void setListWtiposervicio(List<Wtiposervicio> listWtiposervicio) {
        this.listWtiposervicio = listWtiposervicio;
    }

    /**
     * @return the idtiposervicio
     */
    public String getIdtiposervicio() {
        return idtiposervicio;
    }

    /**
     * @param idtiposervicio the idtiposervicio to set
     */
    public void setIdtiposervicio(String idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
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
     * @return the listDetcalculopagar
     */
    public List<Detcalculopagar> getListDetcalculopagar() {
        return listDetcalculopagar;
    }

    /**
     * @param listDetcalculopagar the listDetcalculopagar to set
     */
    public void setListDetcalculopagar(List<Detcalculopagar> listDetcalculopagar) {
        this.listDetcalculopagar = listDetcalculopagar;
    }

    /**
     * @return the selectDetcalculopagar
     */
    public Detcalculopagar getSelectDetcalculopagar() {
        return selectDetcalculopagar;
    }

    /**
     * @param selectDetcalculopagar the selectDetcalculopagar to set
     */
    public void setSelectDetcalculopagar(Detcalculopagar selectDetcalculopagar) {
        this.selectDetcalculopagar = selectDetcalculopagar;
    }

    /**
     * @return the listMoneda
     */
    public List<Monedas> getListMoneda() {
        return listMoneda;
    }

    /**
     * @param listMoneda the listMoneda to set
     */
    public void setListMoneda(List<Monedas> listMoneda) {
        this.listMoneda = listMoneda;
    }

    /**
     * @return the listPlanctas
     */
    public List<Planctas> getListPlanctas() {
        return listPlanctas;
    }

    /**
     * @param listPlanctas the listPlanctas to set
     */
    public void setListPlanctas(List<Planctas> listPlanctas) {
        this.listPlanctas = listPlanctas;
    }

    /**
     * @return the listTiporegimen
     */
    public List<Tiporegimen> getListTiporegimen() {
        return listTiporegimen;
    }

    /**
     * @param listTiporegimen the listTiporegimen to set
     */
    public void setListTiporegimen(List<Tiporegimen> listTiporegimen) {
        this.listTiporegimen = listTiporegimen;
    }

    /**
     * @return the listImpuesto
     */
    public List<Impuesto> getListImpuesto() {
        return listImpuesto;
    }

    /**
     * @param listImpuesto the listImpuesto to set
     */
    public void setListImpuesto(List<Impuesto> listImpuesto) {
        this.listImpuesto = listImpuesto;
    }

    /**
     * @return the listTipodetraccion
     */
    public List<Tipodetraccion> getListTipodetraccion() {
        return listTipodetraccion;
    }

    /**
     * @param listTipodetraccion the listTipodetraccion to set
     */
    public void setListTipodetraccion(List<Tipodetraccion> listTipodetraccion) {
        this.listTipodetraccion = listTipodetraccion;
    }

    /**
     * @return the tipodetraccionDao
     */
    public TipodetraccionDao getTipodetraccionDao() {
        return tipodetraccionDao;
    }

    /**
     * @param tipodetraccionDao the tipodetraccionDao to set
     */
    public void setTipodetraccionDao(TipodetraccionDao tipodetraccionDao) {
        this.tipodetraccionDao = tipodetraccionDao;
    }

    /**
     * @return the planctasDao
     */
    public PlanctasDao getPlanctasDao() {
        return planctasDao;
    }

    /**
     * @param planctasDao the planctasDao to set
     */
    public void setPlanctasDao(PlanctasDao planctasDao) {
        this.planctasDao = planctasDao;
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
     * @return the listConsumidor
     */
    public List<Consumidor> getListConsumidor() {
        return listConsumidor;
    }

    /**
     * @param listConsumidor the listConsumidor to set
     */
    public void setListConsumidor(List<Consumidor> listConsumidor) {
        this.listConsumidor = listConsumidor;
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
     * @return the listDetcalculopagarTotal
     */
    public List<Detcalculopagar> getListDetcalculopagarTotal() {
        return listDetcalculopagarTotal;
    }

    /**
     * @param listDetcalculopagarTotal the listDetcalculopagarTotal to set
     */
    public void setListDetcalculopagarTotal(List<Detcalculopagar> listDetcalculopagarTotal) {
        this.listDetcalculopagarTotal = listDetcalculopagarTotal;
    }

    /**
     * @return the listDetcalculopagarPersonal
     */
    public List<Detcalculopagar> getListDetcalculopagarPersonal() {
        return listDetcalculopagarPersonal;
    }

    /**
     * @param listDetcalculopagarPersonal the listDetcalculopagarPersonal to set
     */
    public void setListDetcalculopagarPersonal(List<Detcalculopagar> listDetcalculopagarPersonal) {
        this.listDetcalculopagarPersonal = listDetcalculopagarPersonal;
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
     * @return the selectDetcalculopagar_detalle
     */
    public Detcalculopagar getSelectDetcalculopagar_detalle() {
        return selectDetcalculopagar_detalle;
    }

    /**
     * @param selectDetcalculopagar_detalle the selectDetcalculopagar_detalle to set
     */
    public void setSelectDetcalculopagar_detalle(Detcalculopagar selectDetcalculopagar_detalle) {
        this.selectDetcalculopagar_detalle = selectDetcalculopagar_detalle;
    }

    /**
     * @return the detcalculopagarDao
     */
    public DetcalculopagarDao getDetcalculopagarDao() {
        return detcalculopagarDao;
    }

    /**
     * @param detcalculopagarDao the detcalculopagarDao to set
     */
    public void setDetcalculopagarDao(DetcalculopagarDao detcalculopagarDao) {
        this.detcalculopagarDao = detcalculopagarDao;
    }

    /**
     * @return the cabcalculopagarDao
     */
    public CabcalculopagarDao getCabcalculopagarDao() {
        return cabcalculopagarDao;
    }

    /**
     * @param cabcalculopagarDao the cabcalculopagarDao to set
     */
    public void setCabcalculopagarDao(CabcalculopagarDao cabcalculopagarDao) {
        this.cabcalculopagarDao = cabcalculopagarDao;
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
     * @return the listAlmacenes
     */
    public List<Almacenes> getListAlmacenes() {
        return listAlmacenes;
    }

    /**
     * @param listAlmacenes the listAlmacenes to set
     */
    public void setListAlmacenes(List<Almacenes> listAlmacenes) {
        this.listAlmacenes = listAlmacenes;
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
     * @return the listDocumentos_cab
     */
    public List<Documentos> getListDocumentos_cab() {
        return listDocumentos_cab;
    }

    /**
     * @param listDocumentos_cab the listDocumentos_cab to set
     */
    public void setListDocumentos_cab(List<Documentos> listDocumentos_cab) {
        this.listDocumentos_cab = listDocumentos_cab;
    }

    /**
     * @return the listDetcalculopagar_verification
     */
    public List<Detcalculopagar> getListDetcalculopagar_verification() {
        return listDetcalculopagar_verification;
    }

    /**
     * @param listDetcalculopagar_verification the listDetcalculopagar_verification to set
     */
    public void setListDetcalculopagar_verification(List<Detcalculopagar> listDetcalculopagar_verification) {
        this.listDetcalculopagar_verification = listDetcalculopagar_verification;
    }

    /**
     * @return the habilitar_numerico
     */
    public boolean getHabilitar_numerico() {
        return habilitar_numerico;
    }

    /**
     * @param habilitar_numerico the habilitar_numerico to set
     */
    public void setHabilitar_numerico(boolean habilitar_numerico) {
        this.habilitar_numerico = habilitar_numerico;
    }

}
