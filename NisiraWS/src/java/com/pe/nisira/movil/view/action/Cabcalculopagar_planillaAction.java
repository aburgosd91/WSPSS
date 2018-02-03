/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.Cabcalculopagar_planillaDao;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.Detcalculopagar_planillaDao;
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
import com.nisira.core.dao.OperacionesDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.PlanctasDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TipodetraccionDao;
import com.nisira.core.dao.TiporegimenDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Cabcalculopagar_planilla;
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
import com.nisira.core.entity.Detcalculopagar_planilla;
import com.nisira.core.entity.Dimpuesto;
import com.nisira.core.entity.LogTablas;
import com.nisira.core.entity.Operaciones;
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
@ManagedBean(name = "cabcalculopagar_planillaAction")
@SessionScoped
public class Cabcalculopagar_planillaAction extends AbstactListAction<Cabcalculopagar_planilla> {
    /*************************************ArrayList***************************************/
    private List<Detcalculopagar_planilla> listDetcalculopagar;
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
    private List<Detcalculopagar_planilla> listDetcalculopagarTotal;
    private List<Detcalculopagar_planilla> listDetcalculopagar_verification;
    private List<Detcalculopagar_planilla> listDetcalculopagarPersonal;
    private List<Numemisor> listNumemisor;
    private List<Almacenes> listAlmacenes;
    private List<Estados> listEstado;
    private List<Operaciones> listOperaciones;
    private List<Dimpuesto> listDimpuesto;
    /*************************************DAO***************************************/
    private Cabcalculopagar_planillaDao cabcalculopagar_planillaDao;
    private Detcalculopagar_planillaDao detcalculopagarDao;
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
    private OperacionesDao operacionesDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String mensaje;
    private String idtiposervicio;
    private Detcalculopagar_planilla selectDetcalculopagar; 
    private Detcalculopagar_planilla selectDetcalculopagar_detalle; 
    private Det_tareoweb cabercerDet_tareoweb;
    private LogTablas log;
    /************************************* CONTROLES *****************************************/
    private static final String renta4="003";
    private boolean habilitar_numerico;
    private ArrayList<String> lista_solution;
    private String type_formato_rpt;
    private Float scosto;
    private String log_consola;
    public Cabcalculopagar_planillaAction() {
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
            listDimpuesto = new ArrayList<>();
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
            cabcalculopagar_planillaDao = new Cabcalculopagar_planillaDao();
            detcalculopagarDao = new Detcalculopagar_planillaDao();
            emisorDao = new EmisorDao();
            sucursalDao = new SucursalesDao();
            alamcenesDao = new AlmacenesDao();
            estadosDao = new EstadosDao();
            operacionesDao = new OperacionesDao();
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
            listDocumentos_cab = documentoDao.getDocumenotPlanilla(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos_cab.get(0).getIddocumento());
            listConsumidor = consumidorDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listOperaciones = operacionesDao.lstOperacionesEmpresa();
            listDimpuesto = impuestoDao.getArrayDImpuesto(user.getIDEMPRESA());
            /********************************** CONFIGURACIÓN - SERVIDOR ***********************/
            idtiposervicio = "ESPECIAL";
            actualiza_ventana("wMnt_Cabcalculopagar_planilla");
        }catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(Cabcalculopagar_planillaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCellEdit(CellEditEvent event) {
        log = null;
        Object newValue = event.getNewValue();
        Object oldValue = event.getOldValue();
        Detcalculopagar_planilla entity =(Detcalculopagar_planilla)((DataTable)event.getComponent()).getRowData();
        //                int pos = listDet_tareoweb.indexOf(entity);
        int pos = entity.getItem();
        //                int pos = event.getRowIndex();
        if(event.getColumn().getHeaderText()!=null){
            String colHead = event.getColumn().getHeaderText().trim();
            switch(colHead){
                case "H.I.C.":
                /*VALIDAR FORMATO DE TIME*/
                if(WebUtil.validateTime(newValue.toString())){
                    entity.setDhi_cs(WebUtil.convertStringTimeFloat(newValue.toString()));
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("H.I.C.");
                    log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                    log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                }else{
                    if(entity.getDhi()!= null){
                        entity.setDhi_cs(entity.getDhi());
                        entity.setDhi_s_cs(entity.getDhi_s());
                    }else{
                        entity.setDhi_s_cs("");
                        entity.setDhi_cs(null);
                    }
                    /****************************************************************************/
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("H.I.C.");
                    log.setValor_new("");
                    log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                }
                break;
                case "H.F.C.":
                /*VALIDAR FORMATO DE TIME*/
                if(WebUtil.validateTime(newValue.toString())){
                    entity.setDhf_cs(WebUtil.convertStringTimeFloat(newValue.toString()));
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("H.F.C.");
                    log.setValor_new(WebUtil.isnull(newValue==null?"":newValue.toString(),""));
                    log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                }else{
                    if(entity.getDhf()!= null){
                        entity.setDhf_cs(entity.getDhi());
                        entity.setDhf_s_cs(entity.getDhi_s());
                    }else{
                        entity.setDhf_s_cs("");
                        entity.setDhf_cs(null);
                    }
                    /****************************************************************************/
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("H.F.C.");
                    log.setValor_new("");
                    log.setValor_old(WebUtil.isnull(oldValue==null?"":oldValue.toString(),""));
                }
                break;
                case "F.F.C":
                if(newValue!=null){
                    Date fecha = new Date(((Date)newValue).getTime());
                    entity.setDfechafinregistro_cs(fecha);
                    
                    Date ob_old = (oldValue!=null?(Date)oldValue:null);
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("F.F.C");
                    log.setValor_new(WebUtil.isnull(newValue==null?"":WebUtil.fechaDMY((Date)newValue, 2),""));
                    log.setValor_old(WebUtil.isnull(ob_old==null?"":WebUtil.fechaDMY(ob_old, 2),""));
                }else{
                    if(entity.getDfechafinregistro()!=null){
                        Date fecha = new Date(entity.getDfechafinregistro().getTime());
                        entity.setDfechafinregistro_cs(fecha);
                    }
                    Date ob_old = (oldValue!=null?(Date)oldValue:null);
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("F.F.C");
                    log.setValor_new("");
                    log.setValor_old(WebUtil.isnull(ob_old==null?"":WebUtil.fechaDMY(ob_old, 2),""));
                } 
                break;
            case "F.I.C":
                if(newValue!=null){
                    Date fecha = new Date(((Date)newValue).getTime());
                    entity.setDfecharegistro_cs(fecha);
                    
                    Date ob_old = (oldValue!=null?(Date)oldValue:null);
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("F.I.C");
                    log.setValor_new(WebUtil.isnull(newValue==null?"":WebUtil.fechaDMY((Date)newValue, 2),""));
                    log.setValor_old(WebUtil.isnull(ob_old==null?"":WebUtil.fechaDMY(ob_old, 2),""));
                }else{
                    if(entity.getDfecharegistro()!=null){
                        Date fecha = new Date(entity.getDfecharegistro().getTime());
                        entity.setDfecharegistro_cs(fecha);
                    }
                    Date ob_old = (oldValue!=null?(Date)oldValue:null);
                    log = new LogTablas();
                    log.setIddoc(entity.getIdcabcalculopagar_planilla());
                    log.setItems(
                            WebUtil.isnull(entity.getDidordenservicio(), "")+"+"+
                            WebUtil.isnull(entity.getIdclieprov(), "")+"+"+
                            WebUtil.isnull(entity.getDidcargo(), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfecharegistro(),1), "")+"+"+
                            WebUtil.isnull(WebUtil.fechaDMY(entity.getDfechafinregistro(),1), "")+"+"+
                            WebUtil.isnull(entity.getDhi().toString(), "")+"+"+
                            WebUtil.isnull(entity.getDhf().toString(), "")
                    );
                    log.setCampo("F.I.C");
                    log.setValor_new("");
                    log.setValor_old(WebUtil.isnull(ob_old==null?"":WebUtil.fechaDMY(ob_old, 2),""));
                }
                break;
                case "Costo Manual":
                    if(newValue==null){
                        entity.setCostom(0.0f);
                    }else{
                        Float fv = Float.valueOf(newValue.toString());
                        entity.setCostom(fv);
                    };break;
                case "Costo RxH.C.":
                    if(newValue==null){
                        entity.setDcosto_rh_cs(entity.getDcosto_rh());
                    }else{
                        Float fv = Float.valueOf(newValue.toString());
                        entity.setDcosto_rh_cs(fv);
                    };break;
            }
            /*CALCULO DE TOTAL*/
            entity.setTotal(entity.getTcosto()+entity.getCostom());
            if(replazarCampo(entity,pos)){
                grabar_local();
            }
        }  
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public boolean replazarCampo(Detcalculopagar_planilla ob,int item){
        boolean flag = false;
        for(int i=0;i<listDetcalculopagar.size();i++){
            Detcalculopagar_planilla dw = listDetcalculopagar.get(i);
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
            Logger.getLogger(Cabcalculopagar_planillaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        listDetcalculopagar = new ArrayList<>();
        impuestoDao = new ImpuestoDao();
        listDimpuesto = impuestoDao.getArrayDImpuesto(user.getIDEMPRESA());
        setMensaje("");
        actualiza_ventana("wMnt_Cabcalculopagar_planilla");
        return "";
    }
    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Cabcalculopagar_planilla());
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
            Logger.getLogger(Cabcalculopagar_planillaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cabcalculopagar_planillaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                regenerarTotalesCruces();
                if(getDatoEdicion().getIdcabcalculopagar_planilla()==null){
                    mensaje=getCabcalculopagarDao().grabar(1, getDatoEdicion(), 
                            getListDetcalculopagar(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabcalculopagar_planilla(mensaje.trim());
                }
                else
                    mensaje=getCabcalculopagarDao().grabar(2, getDatoEdicion(),getListDetcalculopagar(),user.getIDUSUARIO());
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
                regenerarTotalesCruces();
                /*DATOS INICIALES*/
                if(getDatoEdicion().getIdcabcalculopagar_planilla()==null){
                    mensaje=getCabcalculopagarDao().grabar(1, getDatoEdicion(), 
                            getListDetcalculopagar(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabcalculopagar_planilla(mensaje.trim());
                }
                else
                    mensaje=getCabcalculopagarDao().grabar(2, getDatoEdicion(),getListDetcalculopagar(),user.getIDUSUARIO());
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
                mensaje=getCabcalculopagarDao().anular(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabcalculopagar_planilla(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoAnular("Cálculo por Pagar", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                buscarFiltro(2);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                mensaje=getCabcalculopagarDao().eliminar(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabcalculopagar_planilla(), user.getIDUSUARIO());
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
            if(getDatoEdicion().getIdcabcalculopagar_planilla()==null){
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
                mensaje=getCabcalculopagarDao().aprobarCalculoPagar_Planilla(getDatoEdicion(),user.getIDUSUARIO());
                if(mensaje!=null)
                    if(mensaje.trim().length()==15)
                        getDatoEdicion().setIdcabcalculopagar_planilla(mensaje.trim());
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
    public void regenerarTotalesCruces(){
        try{
            for(int i=0;i<listDetcalculopagar.size();i++){
                Detcalculopagar_planilla dtc = listDetcalculopagar.get(i);
                if(dtc.isFlag_cruceservicio()){
                    /*Validar Existencia de Horas - Fechas*/
                    if(dtc.getDhi_cs()!=null && dtc.getDhf_cs()!=null && dtc.getDfecharegistro_cs()!=null && dtc.getDfechafinregistro_cs()!=null){
                        if(WebUtil.fechaDMY(dtc.getDfecharegistro_cs(), 5).equalsIgnoreCase(WebUtil.fechaDMY(dtc.getDfechafinregistro_cs(), 5))){
                            dtc.setDhs_cs(dtc.getDhf_cs() - dtc.getDhi_cs());
                            dtc.setDhs_s_cs(CoreUtil.convertTimeFloatString(dtc.getDhs_cs()));
                            if(dtc.getExcluir()==1){
                                dtc.setDhadicional_cs(dtc.getDhs_cs());
                                dtc.setDhadicional_s_cs(CoreUtil.convertTimeFloatString(dtc.getDhadicional_cs()));
                                dtc.setTcosto_cs((dtc.getDcosto_rh_cs()*dtc.getDhs_cs()) + (dtc.getDhadicional_cs()*dtc.getDhcosto_adicional())+ dtc.getDcosto_bono());
                            }else{
                               dtc.setDhadicional_cs(dtc.getDhadicional());
                               dtc.setDhadicional_s_cs(dtc.getDhadicional_s()); 
                               dtc.setTcosto_cs((dtc.getDcosto_rh_cs()*dtc.getDhbase()) + (dtc.getDhadicional_cs()*dtc.getDhcosto_adicional())+ dtc.getDcosto_bono());
                            }
                        }else{
                            int dias=(int)((dtc.getDfechafinregistro_cs().getTime()-dtc.getDfecharegistro_cs().getTime())/86400000);
                            dtc.setDhs_cs(dtc.getDhf_cs()*dias*24 - dtc.getDhi_cs());
                            dtc.setDhs_s_cs(CoreUtil.convertTimeFloatString(dtc.getDhs_cs()));
                            if(dtc.getExcluir()==1){
                                dtc.setDhadicional_cs(dtc.getDhs_cs());
                                dtc.setDhadicional_s_cs(CoreUtil.convertTimeFloatString(dtc.getDhadicional_cs()));
                                dtc.setTcosto_cs((dtc.getDcosto_rh_cs()*dtc.getDhs_cs()) + (dtc.getDhadicional_cs()*dtc.getDhcosto_adicional())+ dtc.getDcosto_bono());
                            }else{
                               dtc.setDhadicional_cs(dtc.getDhadicional());
                               dtc.setDhadicional_s_cs(dtc.getDhadicional_s()); 
                               dtc.setTcosto_cs((dtc.getDcosto_rh_cs()*dtc.getDhs_cs()) + (dtc.getDhadicional_cs()*dtc.getDhcosto_adicional())+ dtc.getDcosto_bono());
                            } 
                        }
                    }
                }
            }
            RequestContext.getCurrentInstance().update("datos:tbl");
        }catch(Exception ex){
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public Dimpuesto buscarImpuesto(String idimpuesto){
        Dimpuesto obj=null;
        if(!WebUtil.isnull(idimpuesto, "").trim().equals("")){
            for(Dimpuesto imp : listDimpuesto){
                if(imp.getIdimpuesto().equals(idimpuesto)){
                    obj = imp;
                    break;
                } 
            }
        }
        if(obj == null){
            obj = new Dimpuesto();
            obj.setResta_base(0);
            obj.setValor(0.0f);
        }
        return obj;
    }
    public boolean verificar_aprobacion() throws IOException{
        boolean flag = true;
        String validacion ="";
        String httpcontenido="";
        setListDetcalculopagar_verification(new ArrayList<>());
        for(int i=0;i<listDetcalculopagar.size();i++){
            Detcalculopagar_planilla obj = listDetcalculopagar.get(i);
            validacion ="";
            if(obj.getIdclieprov()==null){
                validacion+="\n\t<Personal> no asignado";
            }else if(obj.getIdclieprov().trim().equals("")){
                validacion+="\n\t<Personal> no asignado";  
            }
            if(obj.isFlag_cruceservicio()){
                if(obj.getDhi_cs()==null)
                    validacion+="\n\tHora Inicio Cruce <vacio> no asignado";
                if(obj.getDhf_cs()==null)
                    validacion+="\n\tHora Fin Cruce <vacio> no asignado";
                if(obj.getDfecharegistro_cs()==null)
                    validacion+="\n\tFecha Registro Cruce <vacio> no asignado";
                if(obj.getDfechafinregistro_cs()==null)
                    validacion+="\n\tFecha Fin Cruce <vacio> no asignado";
            }
            if(!validacion.equals("")){
                flag = false;
                this.mensaje="\nFila N°:"+obj.getItem()+" - "+obj.getIdclieprov()+"-"+obj.getRazon_social()+" "+ validacion;
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
        regenerarTotalesCruces();
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public void getFindetalleCalculo(){
        try {
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDatoEdicion().getFinicio());
            String f_fin = f.format(getDatoEdicion().getFfin());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            listDetcalculopagar = detcalculopagarDao.listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,getDatoEdicion().getTipo());
            if(listDetcalculopagar.isEmpty()){
                setMensaje("No se muestran registros");
                WebUtil.info(getMensaje());
                //setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos:growl");
           }
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Cabcalculopagar_planillaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findetalle() throws Exception {
        try{
            if(getLadd()==1){/*NUEVO*/
                getFindetalleCalculo();
            }else if(getLadd()==2){/*EDITAR*/
                listDetcalculopagar = detcalculopagarDao.listar_detallado(user.getIDEMPRESA(), getDatoEdicion().getIdcabcalculopagar_planilla());
            }
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        }catch(Exception ex){
            this.mensaje=ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
    }
    public void cargarDetalle(){
        
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            listDetcalculopagar = detcalculopagarDao.listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
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
            setMensaje(e.getMessage());
            WebUtil.error(getMensaje());
            System.err.println(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        if(tipo == 2)
            lista_accion_filtro("wLst_Cabcalculopagar_planilla");
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
        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        HSSFRow fila_cabecera = objWB.getSheetAt(0).createRow(0);

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
        int col = 32;
        int row = listDetcalculopagar.size();
        HSSFCell celda;
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("DNI");break;
                case 1:celda.setCellValue("DOC");break;
                case 2:celda.setCellValue("SERIE");break;
                case 3:celda.setCellValue("NUMERO");break;
                case 4:celda.setCellValue("FECHA");break;
                case 5:celda.setCellValue("VNRORUC");break;
                case 6:celda.setCellValue("VRAZSOC");break;
                case 7:celda.setCellValue("AMBITO");break;
                case 8:celda.setCellValue("RUTA");break;
                case 9:celda.setCellValue("IDENT.");break;
                case 10:celda.setCellValue("DATOS");break;
                case 11:celda.setCellValue("IDCARGO");break;
                case 12:celda.setCellValue("CARGO");break;
                case 13:celda.setCellValue("VEHPOL");break;
                case 14:celda.setCellValue("INIASI");break;
                case 15:celda.setCellValue("FINASI");break;
                case 16:celda.setCellValue("HORASASI");break;
                case 17:celda.setCellValue("HORA_EC");break;
                case 18:celda.setCellValue("H.ADICIONAL");break;
                case 19:celda.setCellValue("COSTO R.H");break;
                case 20:celda.setCellValue("COSTO H.AD");break;
                case 21:celda.setCellValue("COSTO BONO");break;
                case 22:celda.setCellValue("COSTO_TOTAL");break;
                
                case 23:celda.setCellValue("ES_CRUCE");break;
                case 24:celda.setCellValue("H.I.C.");break;
                case 25:celda.setCellValue("H.F.C.");break;
                case 26:celda.setCellValue("H.S.");break;
                case 27:celda.setCellValue("F.I.C.");break;
                case 28:celda.setCellValue("F.F.C.");break;
                case 29:celda.setCellValue("H.ADICIONAL");break;
                case 30:celda.setCellValue("Costo RxH C.");break;
                case 31:celda.setCellValue("Costo Total C.");break;
            }
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).createRow((short)i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdclieprov());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDiddocumento());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDserie());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDnumero());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecha_osc(), 7));
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdcliente());
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDcliente());
            
            celda = fila.createCell((short)7);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getAmbito_servicio());
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getRutaservicio());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdclieprov());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getRazon_social());
            
            celda = fila.createCell((short)11);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDidcargo());
            
            celda = fila.createCell((short)12);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getCargo());
            
            celda = fila.createCell((short)13);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDidvehiculo());
            
            celda = fila.createCell((short)14);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecharegistro(), 7));
            
            celda = fila.createCell((short)15);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfechafinregistro(), 7));
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhs_s());
            
            celda = fila.createCell((short)17);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhbase());
            
            celda = fila.createCell((short)18);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhadicional());
            
            celda = fila.createCell((short)19);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_rh());
            
            celda = fila.createCell((short)20);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhcosto_adicional());
            
            celda = fila.createCell((short)21);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_bono());
            
            celda = fila.createCell((short)22);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTcosto());
            
            celda = fila.createCell((short)23);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getEs_cruceservicio());
            celda = fila.createCell((short)24);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhi_s_cs());
            celda = fila.createCell((short)25);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhf_s_cs());
            celda = fila.createCell((short)26);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhs_s_cs());
            
            celda = fila.createCell((short)27);
            celda.setCellStyle(estiloFila_date);
            if(listDetcalculopagar.get(i).getDfecharegistro_cs()!=null)
                celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecharegistro_cs(), 7));
            else
                celda.setCellValue("");
            
            celda = fila.createCell((short)28);
            celda.setCellStyle(estiloFila_date);
            if(listDetcalculopagar.get(i).getDfechafinregistro_cs()!=null)
                celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfechafinregistro_cs(), 7));
            else 
                celda.setCellValue("");
            celda = fila.createCell((short)29);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhadicional_cs());
            
            celda = fila.createCell((short)30);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_rh_cs());
            
            celda = fila.createCell((short)31);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTcosto_cs());
            
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
        /*CREAR OTRA HOJA DETALLADO NISIRA*/
        HSSFSheet sheet2 = objWB.createSheet("DETALLADO "+this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        fila_cabecera = sheet2.createRow((short)0);
        col = 51;
        row = listDetcalculopagar.size();
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("DNI");break;
                case 1:celda.setCellValue("DOC.IDEN.");break;
                case 2:celda.setCellValue("DATO");break;
                case 3:celda.setCellValue("IDDOCUMENTO");break;
                case 4:celda.setCellValue("SERIE");break;
                case 5:celda.setCellValue("NUMERO");break;
                case 6:celda.setCellValue("FECHA SER");break;
                case 7:celda.setCellValue("AMBITO");break;
                /*AGREGAR CAMPOS ADICIONALES*/
                case 8:celda.setCellValue("RUC");break;
                case 9:celda.setCellValue("CLIENTE");break;
                case 10:celda.setCellValue("CARGO");break;
                case 11:celda.setCellValue("CODOPERACION");break;
                case 12:celda.setCellValue("RUTA SERV");break;
                case 13:celda.setCellValue("FECHA INICIO");break;
                case 14:celda.setCellValue("HORA INICIO");break;
                case 15:celda.setCellValue("HORA FIN");break;
                case 16:celda.setCellValue("FECHA FIN");break;
                case 17:celda.setCellValue("HORAS SERVICIO");break;
                case 18:celda.setCellValue("HORAS E.C");break;
                case 19:celda.setCellValue("HORAS ADICIONAL");break;
                case 20:celda.setCellValue("COSTO RxH");break;
                case 21:celda.setCellValue("COSTO H.ADICIONAL");break;
                case 22:celda.setCellValue("COSTO BONO");break;
                case 23:celda.setCellValue("TOTAL");break;
                case 24:celda.setCellValue("ESPLANILLA");break;
                /*AGREGAR CAMPOS ADICIONALES - TAREO*/
                case 25:celda.setCellValue("T.HORA REQ.");break;
                case 26:celda.setCellValue("T.HORA LLEGADA");break;
                case 27:celda.setCellValue("T.HORA INICIO");break;
                case 28:celda.setCellValue("T.HORA FIN");break;
                case 29:celda.setCellValue("T.HORA LIBERACION");break;
                case 30:celda.setCellValue("IDAMBITO");break;
                case 31:celda.setCellValue("AMBITO_SERVICIO");break;
                case 32:celda.setCellValue("CHECKLIST");break;
                case 33:celda.setCellValue("PLACA PSS");break;
                case 34:celda.setCellValue("NROCONTENEDOR");break;
                case 35:celda.setCellValue("NROPRECINTO");break;
                case 36:celda.setCellValue("NRO_OSERVICIO");break;
                case 37:celda.setCellValue("PLACA_CLIENTE");break;
                case 38:celda.setCellValue("CONDUCTOR_CLIENTE");break;
                case 39:celda.setCellValue("BREVETE_CLIENTE");break;
                case 40:celda.setCellValue("#SERVICIOS_DIA");break;
                case 41:celda.setCellValue("ORIGENCALLAO");break;
                
                case 42:celda.setCellValue("ES_CRUCE");break;
                case 43:celda.setCellValue("H.I.C.");break;
                case 44:celda.setCellValue("H.F.C.");break;
                case 45:celda.setCellValue("H.S.");break;
                case 46:celda.setCellValue("F.I.C.");break;
                case 47:celda.setCellValue("F.F.C.");break;
                case 48:celda.setCellValue("H.ADICIONAL");break;
                case 49:celda.setCellValue("Costo RxH C.");break;
                case 50:celda.setCellValue("Costo Total C.");break;
            }
        }
        int id=0;
        for(int i=0;i<row;i++){
            fila = sheet2.createRow(i+1);
            id=0;
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdclieprov());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdclieprov());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getRazon_social());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDiddocumento());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDserie());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDnumero());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecha_osc(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getAmbito_servicio());
             
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdcliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDcliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDidcargo()+" "+listDetcalculopagar.get(i).getCargo());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDcodoperaciones_ec());
            
            /*AGREGAR CAMPOS ADICIONALES*/
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getRutaservicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecharegistro(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhi_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhf_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfechafinregistro(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhs_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhbase());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhadicional());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_rh());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhcosto_adicional());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_bono());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTcosto());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getEsplanilla());
            /************************** HORAS TAREO ***************************/
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getShora_req());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getShora_llegada());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getShora_inicio_serv());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getShora_fin_serv());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getShora_liberacion());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getIdambito_servicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getAmbito_servicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDchecklist());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDidvehiculo());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDnrocontenedor());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDnroprecinto());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDnro_oservicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDplaca_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDconductor_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDbrevete_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getNservicios_dia()==null?0:listDetcalculopagar.get(i).getNservicios_dia());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getOrigencallao());
            
            /***********************************************************************************/
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getEs_cruceservicio());
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhi_s_cs());
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhf_s_cs());
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listDetcalculopagar.get(i).getDhs_s_cs());
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            if(listDetcalculopagar.get(i).getDfecharegistro_cs() != null)
                celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfecharegistro_cs(), 7));
            else
                celda.setCellValue("");
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            if(listDetcalculopagar.get(i).getDfechafinregistro_cs() != null)
                celda.setCellValue(WebUtil.fechaDMY(listDetcalculopagar.get(i).getDfechafinregistro_cs(), 7));
            else
                celda.setCellValue("");
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDhadicional_cs());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getDcosto_rh_cs());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listDetcalculopagar.get(i).getTcosto_cs());
            
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(1).autoSizeColumn((short) as);
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
                for(Detcalculopagar_planilla obj:listDetcalculopagar){
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
    public List<Detcalculopagar_planilla> getListDetcalculopagar() {
        return listDetcalculopagar;
    }

    /**
     * @param listDetcalculopagar the listDetcalculopagar to set
     */
    public void setListDetcalculopagar(List<Detcalculopagar_planilla> listDetcalculopagar) {
        this.listDetcalculopagar = listDetcalculopagar;
    }

    /**
     * @return the selectDetcalculopagar
     */
    public Detcalculopagar_planilla getSelectDetcalculopagar() {
        return selectDetcalculopagar;
    }

    /**
     * @param selectDetcalculopagar the selectDetcalculopagar to set
     */
    public void setSelectDetcalculopagar(Detcalculopagar_planilla selectDetcalculopagar) {
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
    public List<Detcalculopagar_planilla> getListDetcalculopagarTotal() {
        return listDetcalculopagarTotal;
    }

    /**
     * @param listDetcalculopagarTotal the listDetcalculopagarTotal to set
     */
    public void setListDetcalculopagarTotal(List<Detcalculopagar_planilla> listDetcalculopagarTotal) {
        this.listDetcalculopagarTotal = listDetcalculopagarTotal;
    }

    /**
     * @return the listDetcalculopagarPersonal
     */
    public List<Detcalculopagar_planilla> getListDetcalculopagarPersonal() {
        return listDetcalculopagarPersonal;
    }

    /**
     * @param listDetcalculopagarPersonal the listDetcalculopagarPersonal to set
     */
    public void setListDetcalculopagarPersonal(List<Detcalculopagar_planilla> listDetcalculopagarPersonal) {
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
    public Detcalculopagar_planilla getSelectDetcalculopagar_detalle() {
        return selectDetcalculopagar_detalle;
    }

    /**
     * @param selectDetcalculopagar_detalle the selectDetcalculopagar_detalle to set
     */
    public void setSelectDetcalculopagar_detalle(Detcalculopagar_planilla selectDetcalculopagar_detalle) {
        this.selectDetcalculopagar_detalle = selectDetcalculopagar_detalle;
    }

    /**
     * @return the cabcalculopagar_planillaDao
     */
    public Cabcalculopagar_planillaDao getCabcalculopagarDao() {
        return cabcalculopagar_planillaDao;
    }

    /**
     * @param cabcalculopagar_planillaDao the cabcalculopagar_planillaDao to set
     */
    public void setCabcalculopagarDao(Cabcalculopagar_planillaDao cabcalculopagar_planillaDao) {
        this.cabcalculopagar_planillaDao = cabcalculopagar_planillaDao;
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
    public List<Detcalculopagar_planilla> getListDetcalculopagar_verification() {
        return listDetcalculopagar_verification;
    }

    /**
     * @param listDetcalculopagar_verification the listDetcalculopagar_verification to set
     */
    public void setListDetcalculopagar_verification(List<Detcalculopagar_planilla> listDetcalculopagar_verification) {
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

    /**
     * @return the listOperaciones
     */
    public List<Operaciones> getListOperaciones() {
        return listOperaciones;
    }

    /**
     * @param listOperaciones the listOperaciones to set
     */
    public void setListOperaciones(List<Operaciones> listOperaciones) {
        this.listOperaciones = listOperaciones;
    }

    /**
     * @return the operacionesDao
     */
    public OperacionesDao getOperacionesDao() {
        return operacionesDao;
    }

    /**
     * @param operacionesDao the operacionesDao to set
     */
    public void setOperacionesDao(OperacionesDao operacionesDao) {
        this.operacionesDao = operacionesDao;
    }

    /**
     * @return the listDimpuesto
     */
    public List<Dimpuesto> getListDimpuesto() {
        return listDimpuesto;
    }

    /**
     * @param listDimpuesto the listDimpuesto to set
     */
    public void setListDimpuesto(List<Dimpuesto> listDimpuesto) {
        this.listDimpuesto = listDimpuesto;
    }

}
