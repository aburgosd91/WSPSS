/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConfigsmtpDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Destructura_costos_recursosDao;
import com.nisira.core.dao.Destructura_costos_recursos_cotizacionventasDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costosDao;
import com.nisira.core.dao.Estructura_costos_clieprovDao;
import com.nisira.core.dao.Estructura_costos_mano_obraDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.ProductoDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TcambioDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Configsmtp;
import com.nisira.core.entity.Contactosclieprov;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Destructura_costos_recursos;
import com.nisira.core.entity.Destructura_costos_recursos_cotizacionventas;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Estructura_costos;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.entity.Estructura_costos_mano_obra;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.entity.Forma_pago;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.entity.Sucursales;
import com.nisira.core.entity.Tcambio;
import com.nisira.core.entity.Vendedor;
import com.nisira.core.entity.Wtiposervicio;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.EnviarDocumentos;
import com.pe.nisira.movil.view.util.ManejadorFechas;
import com.pe.nisira.movil.view.util.NSRDataSource;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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
@ManagedBean(name = "cotizacionventasAction")
@SessionScoped
public class CotizacionesAction extends AbstactListAction<Cotizacionventas> {
    
    /*********************************LISTAS*******************************************/
    private List<String> lstTipoRecurso;
    private List<Es_PorcentajeCombo> lstEs_porcentaje;
    private List<Sucursales> listSucursales;
    private List<Almacenes> listAlmacenes;
    private List<Clieprov> listClieprov;
    private List<Documentos> listDocumentos;
    private List<Numemisor> listNumemisor;
    private List<Dcotizacionventas> lstdcotizacionventas;
    private List<Multitabla> listMultitabla;
    private List<Estados> listEstado;
    private ArrayList<String> lista_solution;
    private List<Monedas> listMoneda;
    private List<Wtiposervicio> listWtiposervicio;
    private List<Estructura_costos_clieprov> listEstructura_costos_clieprov;
    private List<Estructura_costos> listEstructura_costos;
    private List<Destructura_costos_recursos> listDestructura_costos_recursos;
    private List<Estructura_costos_mano_obra> listEstructura_costos_mano_obra;
    private List<Destructura_costos_recursos_cotizacionventas> listDestructura_costos_recursos_cotizacionventas;
    private List<Estructura_costos_mano_obra_cotizacionventas> listEstructura_costos_mano_obra_cotizacionventas;
    
    private List<Destructura_costos_recursos_cotizacionventas> listTotalDestructura_costos_recursos_cotizacionventas;
    private List<Estructura_costos_mano_obra_cotizacionventas> listTotalEstructura_costos_mano_obra_cotizacionventas;
    
    private List<Destructura_costos_recursos> listTotalDestructura_costos_recursos;
    private List<Estructura_costos_mano_obra> listTotalEstructura_costos_mano_obra;
    /*************************************DAO***************************************/
    private CotizacionventasDao cotizacionventasDao;
    private DcotizacionventasDao dcotizacionventasDao;
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private ClieprovDao clieprovDao;
    private EstadosDao estadosDao;
    private EmisorDao emisorDao;
    private TcambioDao tcambioDao;
    private MonedasDao monedasDao;
    private SucursalesDao sucursalesDao;
    private AlmacenesDao alamcenesDao;
    private ProductoDao productoDao;
    private WtiposervicioDao wtiposervicioDao; 
    private Estructura_costos_clieprovDao estructura_costos_clieprovDao;
    private Estructura_costosDao estructura_costosDao;
    private Destructura_costos_recursosDao destructura_costos_recursosDao;
    private Estructura_costos_mano_obraDao estructura_costos_mano_obraDao;
    private Destructura_costos_recursos_cotizacionventasDao destructura_costos_recursos_cotizacionventasDao;
    private Estructura_costos_mano_obra_cotizacionventasDao estructura_costos_mano_obra_cotizacionventasDao;
    /*************************************ENTITY***************************************/
    private Dcotizacionventas dcotizacionventas;
    private Dcotizacionventas selectdcotizacionventas; 
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    private Vendedor selectVendedor;
    private Contactosclieprov selectContactosClieprov;
    private Producto selectProducto;
    private Estructura_costos_producto selectEstructura_costos_producto;
    private Forma_pago selectForma_pago;
    private Sucursales selectSucursales;
    private Almacen selectAlmacen;
    private Estructura_costos_clieprov selectEstructura_costos_clieprov;
    private Estructura_costos selectEstructura_costos;
    private Destructura_costos_recursos selectDestructura_costos_recursos;
    private Estructura_costos_mano_obra selectEstructura_costos_mano_obra;
    private Destructura_costos_recursos_cotizacionventas selectDestructura_costos_recursos_cotizacionventas;
    private Estructura_costos_mano_obra_cotizacionventas selectEstructura_costos_mano_obra_cotizacionventas;
    private Destructura_costos_recursos_cotizacionventas destructura_costos_recursos_cotizacionventas;
    private Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra_cotizacionventas;
    private Cotizacionventas selectCotizacionventas_local; 
    /**********************************CONTROLADOR********************************/
    private boolean caculate_hora;
    private boolean botonEditarDcotizacionventas;
    private boolean botonEliminarDcotizacionventas;

    private boolean botonNuevoDestructura_costos_recurso;
    private boolean botonEditarDestructura_costos_recurso;
    private boolean botonEliminarDestructura_costos_recurso;
    
    private boolean botonNuevoEstructura_costos_mano_obra;
    private boolean botonEditarEstructura_costos_mano_obra;
    private boolean botonEliminarEstructura_costos_mano_obra;
    
    private String periodoBase;
    private String periodoDisenio;
    private String mesNumeroDisenio;
    private String mesNombreDisenio;
    private Date fecha_ini;//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
    private Date fecha_fin;//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
    private int indexTab;
    private TabView tabView; 
    private Float subtotal_ecosto;
    private Float go_ecosto;
    private Float ga_ecosto;
    private Float u_ecosto;
    private Float total_ecosto;
    private Float ajuste_ecosto;
    private String filename;
    public CotizacionesAction() {
        /*****************CONFIGURACION****************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        /**********************************CONTROLADOR********************************/
        lstTipoRecurso = new ArrayList<>();
        lstTipoRecurso.add("CO");
        lstTipoRecurso.add("MO");
        lstEs_porcentaje = new ArrayList<>();
        lstEs_porcentaje.add(new Es_PorcentajeCombo(0,"No Porcentaje"));
        lstEs_porcentaje.add(new Es_PorcentajeCombo(1,"Porcentaje"));
        caculate_hora = false;
        botonEditarDcotizacionventas=true;
        botonEliminarDcotizacionventas=true;
        
        botonNuevoDestructura_costos_recurso=true;
        botonEditarDestructura_costos_recurso=true;
        botonEliminarDestructura_costos_recurso=true;

        botonNuevoEstructura_costos_mano_obra=true;
        botonEditarEstructura_costos_mano_obra=true;
        botonEliminarEstructura_costos_mano_obra=true;
        /********************DAO*******************/
        cotizacionventasDao = new CotizacionventasDao();
        dcotizacionventasDao = new DcotizacionventasDao();
        estadosDao = new EstadosDao();
        docDao = new DocumentosDao();
        numemisorDao = new NumemisorDao();
        clieprovDao = new ClieprovDao();
        emisorDao= new EmisorDao();
        tcambioDao=new TcambioDao();
        monedasDao=new MonedasDao();
        sucursalesDao=new SucursalesDao();
        productoDao = new ProductoDao();
        alamcenesDao = new AlmacenesDao();
        wtiposervicioDao = new WtiposervicioDao();
        estructura_costos_clieprovDao = new Estructura_costos_clieprovDao();
        estructura_costosDao = new Estructura_costosDao();
        destructura_costos_recursosDao = new Destructura_costos_recursosDao();
        estructura_costos_mano_obraDao = new Estructura_costos_mano_obraDao();
        destructura_costos_recursos_cotizacionventasDao = new Destructura_costos_recursos_cotizacionventasDao();
        estructura_costos_mano_obra_cotizacionventasDao = new Estructura_costos_mano_obra_cotizacionventasDao();
        selectCotizacionventas_local = new Cotizacionventas();
        /********************ENTITY****************/
        setDcotizacionventas(new Dcotizacionventas());
        destructura_costos_recursos_cotizacionventas= new Destructura_costos_recursos_cotizacionventas();
        estructura_costos_mano_obra_cotizacionventas = new Estructura_costos_mano_obra_cotizacionventas();
        /********************ARRAY****************/
        lstdcotizacionventas = new ArrayList<Dcotizacionventas>();
        listDocumentos = new ArrayList<Documentos>();
        listNumemisor = new ArrayList<Numemisor>();
        listEstado = new ArrayList<Estados>();
        listClieprov = new ArrayList<Clieprov>();
        listMultitabla = new ArrayList<Multitabla>();
        listMoneda = new ArrayList<>();
        listWtiposervicio = new ArrayList<>();
        listEstructura_costos_clieprov = new ArrayList<>();
        listEstructura_costos = new ArrayList<>();
        listDestructura_costos_recursos = new ArrayList<>();
        listEstructura_costos_mano_obra = new ArrayList<>();
        
        listDestructura_costos_recursos_cotizacionventas = new ArrayList<>();
        listEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
        
        listDestructura_costos_recursos_cotizacionventas= new ArrayList<>();
        listEstructura_costos_mano_obra_cotizacionventas= new ArrayList<>();
        
        listTotalDestructura_costos_recursos_cotizacionventas=new ArrayList<>();
        listTotalEstructura_costos_mano_obra_cotizacionventas=new ArrayList<>();
        
        listTotalDestructura_costos_recursos=new ArrayList<>();
        listTotalEstructura_costos_mano_obra=new ArrayList<>();
        /***********************************************/
        fecha_ini = new Date();
        fecha_fin = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        periodoBase=dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
        periodoDisenio=dateFormat.format(new Date());
        mesNumeroDisenio=WebUtil.idGeneradoDos((new Date()).getMonth()+1);
        mesNombreDisenio=WebUtil.strMonths[(new Date()).getMonth()];
        subtotal_ecosto = 0.0f;
        go_ecosto = 0.0f;
        ga_ecosto = 0.0f;
        u_ecosto = 0.0f;
        total_ecosto = 0.0f;
        ajuste_ecosto = 0.0f;
        try {
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listWtiposervicio = wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA());
        } catch (NisiraORMException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiza_ventana("wMnt_Cotizacionventas");
    }

    @Override
    public void buscarTodo() {
        try {
            //getIniciar();
            //setListaDatos(getCotizacionventasDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        try {
            setCotizacionventasDao(new CotizacionventasDao());
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            numero = "";
            mensaje = "";
            listMultitabla = new ArrayList<Multitabla>();
            setDcotizacionventas(new Dcotizacionventas());
            productoDao = new ProductoDao();
            setSubtotal_ecosto((Float) 0.0f);
            setGo_ecosto((Float) 0.0f);
            setGa_ecosto((Float) 0.0f);
            setU_ecosto((Float) 0.0f);
            total_ecosto = 0.0f;
            /*********************************DAO*******************************************/
            setLstdcotizacionventas(new ArrayList<Dcotizacionventas>());
            setDocDao(new DocumentosDao());
            setNumemisorDao(new NumemisorDao());
            setClieprovDao(new ClieprovDao());
            setEstadosDao(new EstadosDao());
            sucursalesDao = new SucursalesDao();
            /*********************************ArrayList*******************************************/
            listEstructura_costos_clieprov = new ArrayList<>();
            listEstructura_costos = new ArrayList<>();
            listDestructura_costos_recursos = new ArrayList<>();
            listEstructura_costos_mano_obra = new ArrayList<>();
            listDestructura_costos_recursos_cotizacionventas = new ArrayList<>();
            listEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
            listWtiposervicio = new ArrayList<>();
            /**********************************CONFIGURACION********************************/
            lista_solution=CoreUtil.valoresBase();
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listMoneda = monedasDao.getListMonedasWeb();
            listWtiposervicio = wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            actualiza_ventana("wMnt_Cotizacionventas");
        } catch (NisiraORMException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Cotizacionventas());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setIdsucursal(Constantes.getIDSUCURSALGENERAL());
        if(!listAlmacenes.isEmpty())
            getDatoEdicion().setIdalmacen(listAlmacenes.get(0).getIdalmacen());
        getDatoEdicion().setFecha(new Date());
        getDatoEdicion().setFechavigencia(new Date());
        getDatoEdicion().setIdemisor(lista_solution.get(5));
        getDatoEdicion().setPeriodo(periodoDisenio);
        getDatoEdicion().setMes(mesNombreDisenio);
        getDatoEdicion().setSubtotalsindscto(0.0f);
        getDatoEdicion().setDescuento(0.0f);
        getDatoEdicion().setVventa(0.0f);
        getDatoEdicion().setImpuesto(0.0f);
        getDatoEdicion().setImporte(0.0f);
        try {
            /*CONSULTAS A BD*/
            String sucursal = sucursalesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
            getDatoEdicion().setSucursal(sucursal);
            String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
            getDatoEdicion().setEmisor(emisor);
            if(!listMoneda.isEmpty()){
                Monedas monedas = listMoneda.get(0);
                getDatoEdicion().setIdmoneda(monedas.getIdmoneda());
                getDatoEdicion().setMoneda(monedas.getDescripcion());
            }
            Tcambio tcambio=tcambioDao.getPorFecha(WebUtil.SimpleDateFormatN1(getDatoEdicion().getFecha()));
            getDatoEdicion().setNumero(numero);
            if(tcambio!=null)getDatoEdicion().setTcambio(tcambio.getT_compra());
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
//        getDatoEdicion().setEstado(1);
//        getDatoEdicion().setTipotarea(0);
//        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());

    }
    public boolean esVistaValida() {
        if (getDatoEdicion().getIdclieprov()==null & getDatoEdicion().getRazon_social()==null) {
            this.mensaje="Seleccionar Cliente";
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getDatoEdicion().getIdvendedor()==null) {
            this.mensaje="Seleccionar Vendedor";
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getDatoEdicion().getFormapago()==null) {
            this.mensaje="Seleccionar Forma Pago";
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if (getLstdcotizacionventas().isEmpty()) {
            this.mensaje="Ingrese Detalle de cotización";
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        return true;
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                getDatoEdicion().setPeriodo(periodoBase);
                if(getLadd()==1){
                    mensaje=getCotizacionventasDao().grabar(1, getDatoEdicion(), getLstdcotizacionventas(),
                            user.getIDUSUARIO(),getListTotalDestructura_costos_recursos_cotizacionventas(),
                            getListTotalEstructura_costos_mano_obra_cotizacionventas());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcotizacionv(mensaje.trim());
                }
                else{
                    mensaje=getCotizacionventasDao().grabar(2, getDatoEdicion(), getLstdcotizacionventas(),
                            user.getIDUSUARIO(),getListTotalDestructura_costos_recursos_cotizacionventas(),
                            getListTotalEstructura_costos_mano_obra_cotizacionventas());
                }
                setMensaje(WebUtil.exitoRegistrar("Cotización Venta ", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos");
            }else{
                setLvalidate(false);
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setIdestado("AN");
            }
            mensaje=getCotizacionventasDao().anular(getDatoEdicion(),user.getIDUSUARIO());
            if(mensaje!=null){
                setMensaje(WebUtil.exitoEliminar("Cotización Venta ", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
                buscarFiltro(2);
            }
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
//                getDatoEdicion().setEstado(2);
//            }
            /*Cambiado - 23-08-2016*/
        } catch (Exception ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void envioCorreo(){
        try {
            if(getDatoEdicion().getIdcotizacionv()!=null){
                List<Configsmtp> lstConfigsmtp=(new ConfigsmtpDao()).listarPorEmpresaWeb();
                if(!lstConfigsmtp.isEmpty()){
                    /******************** CREAR REPORTE ************************/
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext ext = context.getExternalContext();

                    setNombreReporte("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim());
                    setNombreArchivo("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim());/*JRXML*/

                    JasperPrint jasperPrint = getPrintReport();
                    HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
                    resp.setContentType("application/pdf");
                    
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    String filename = getDatoEdicion().getIddocumento()+getDatoEdicion().getSerie()+"-"+
                            getDatoEdicion().getNumero()+"_"+sm.format(getDatoEdicion().getFecha())+"_" +
                            getDatoEdicion().getRazon_social().trim()+
                            ".pdf";
                    String rutapdf=Constantes.ARCHIVO_REPORTE + File.separator +filename;
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
                    
                    Constantes.configsmtp=lstConfigsmtp.get(0);
                    /* *********    ENVIAR CORREO  ********* */
                    File file = new File(rutapdf);
                    
                    EnviarDocumentos enviarDocumentos = new EnviarDocumentos();
                    enviarDocumentos.enviarcorreo(getDatoEdicion().getContacto_email(), file, 
                            getDatoEdicion().getIddocumento()+getDatoEdicion().getSerie()+"-"+getDatoEdicion().getNumero(), 
                            getDatoEdicion().getRazon_social(),filename);
                    
                    mensaje = "Envio de mensaje exitoso";
                    WebUtil.info(mensaje);

                }else{
                    mensaje = "Envio de mensaje no configurado";
                    WebUtil.error(mensaje);
                }
            }else{
                mensaje = "Documento no creado";
                WebUtil.MensajeAdvertencia(mensaje);
            }
            
        }catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }
    public void envioCorreo_listado(){
        try {
            if(getSelectCotizacionventas_local()!=null){
                if(getSelectCotizacionventas_local().getIdcotizacionv()!=null){
                    List<Configsmtp> lstConfigsmtp=(new ConfigsmtpDao()).listarPorEmpresaWeb();
                    if(!lstConfigsmtp.isEmpty()){
                        Constantes.configsmtp=lstConfigsmtp.get(0);
                        /* *********    ENVIAR CORREO  ********* */
                        String rutapdf=Constantes.ARCHIVO_REPORTE + File.separator +filename;
                        File file = new File(rutapdf);
                        EnviarDocumentos enviarDocumentos = new EnviarDocumentos();
                        enviarDocumentos.enviarcorreo(getSelectCotizacionventas_local().getContacto_email(), file, 
                                getSelectCotizacionventas_local().getIddocumento()+getSelectCotizacionventas_local().getSerie()+"-"+getSelectCotizacionventas_local().getNumero(), 
                                getSelectCotizacionventas_local().getRazon_social(),filename);
                        mensaje = "Envio de mensaje exitoso";
                        WebUtil.info(mensaje);
                    }else{
                        mensaje = "Envio de mensaje no configurado";
                        WebUtil.error(mensaje);
                    }
                }
            }else{
                mensaje = "Documento no creado";
                WebUtil.MensajeAdvertencia(mensaje);
            }
            
        }catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }
    public void envioCorreo_open(){
        /******************** CREAR REPORTE ************************/
        try{
            if(getSelectCotizacionventas_local()!=null){
                if(getSelectCotizacionventas_local().getIdcotizacionv()!=null){
                    if(!getSelectCotizacionventas_local().isCheck_rpt_alterno()){
                        setNombreReporte("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim());
                        setNombreArchivo("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim());/*JRXML*/
                    }else{
                        setNombreReporte("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim()+"_ALTERNO");
                        setNombreArchivo("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim()+"_ALTERNO");/*JRXML*/
                    }
                    JasperPrint jasperPrint = getPrintReport_list();
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    filename = getSelectCotizacionventas_local().getIddocumento()+getSelectCotizacionventas_local().getSerie()+"-"+
                            getSelectCotizacionventas_local().getNumero()+"_"+sm.format(getSelectCotizacionventas_local().getFecha())+"_" +
                            getSelectCotizacionventas_local().getRazon_social().trim()+
                            ".pdf";
                    /*RUTA*/
                    String rutapdf=Constantes.ARCHIVO_REPORTE + File.separator +filename;
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
                    RequestContext.getCurrentInstance().execute("PF('dlg_envio').show()");
                }else{
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
    public void PDF_cotizacion() {
        try {
                if(getDatoEdicion().getIdcotizacionv()!=null){
                    FacesContext context = FacesContext.getCurrentInstance();
                    ExternalContext ext = context.getExternalContext();
                    if(!getDatoEdicion().isCheck_rpt_alterno()){
                        setNombreReporte("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim());
                        setNombreArchivo("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim());/*JRXML*/
                    }else{
                        setNombreReporte("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim()+"_ALTERNO");
                        setNombreArchivo("RPT_COTIZACION_"+getDatoEdicion().getIdtiposervicio().trim()+"_ALTERNO");/*JRXML*/
                    }
                    JasperPrint jasperPrint = getPrintReport();
                    HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
                    resp.setContentType("application/pdf");
                    
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    filename = getDatoEdicion().getIddocumento()+getDatoEdicion().getSerie()+"-"+
                            getDatoEdicion().getNumero()+"_"+sm.format(getDatoEdicion().getFecha())+"_" +
                            getDatoEdicion().getRazon_social().trim()+
                            ".pdf";
                    /*RUTA*/
                    String rutapdf=Constantes.ARCHIVO_REPORTE + File.separator +filename;
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
                    context.getApplication().getStateManager().saveView(context);
                    context.responseComplete();
//                    resp.addHeader("Content-Disposition", "inline; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // En la misma pantalla
//                    //resp.addHeader("Content-Disposition", "attachmed; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // Para que lo guardes
                    JasperExportManager.exportReportToPdfStream(jasperPrint, resp.getOutputStream());
                    
                }else{
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
    public void PDF_cotizacion_listado() {
        try {
            if(getSelectCotizacionventas_local()!=null){
                if(getSelectCotizacionventas_local().getIdcotizacionv()!=null){
                    FacesContext context = FacesContext.getCurrentInstance();
//                    ExternalContext ext = context.getExternalContext();
                    if(!getSelectCotizacionventas_local().isCheck_rpt_alterno()){
                        setNombreReporte("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim());
                        setNombreArchivo("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim());/*JRXML*/
                    }else{
                        setNombreReporte("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim()+"_ALTERNO");
                        setNombreArchivo("RPT_COTIZACION_"+getSelectCotizacionventas_local().getIdtiposervicio().trim()+"_ALTERNO");/*JRXML*/
                    }
                    JasperPrint jasperPrint = getPrintReport_list();
//                    HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
//                    resp.setContentType("application/pdf");
//                    
                    SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
                    filename = getSelectCotizacionventas_local().getIddocumento()+getSelectCotizacionventas_local().getSerie()+"-"+
                            getSelectCotizacionventas_local().getNumero()+"_"+sm.format(getSelectCotizacionventas_local().getFecha())+"_" +
                            getSelectCotizacionventas_local().getRazon_social().trim()+
                            ".pdf";
                    /*RUTA*/
                    String rutapdf=Constantes.ARCHIVO_REPORTE + File.separator +filename;
                    JasperExportManager.exportReportToPdfFile(jasperPrint, rutapdf);
//                    context.getApplication().getStateManager().saveView(context);
//                    context.responseComplete();
                    RequestContext.getCurrentInstance().execute("PF('dlg_pdf').show()");
//                    resp.addHeader("Content-Disposition", "inline; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // En la misma pantalla
//                    //resp.addHeader("Content-Disposition", "attachmed; filename=" + Constantes.ARCHIVO_REPORTE + File.separator+filename); // Para que lo guardes
//                    JasperExportManager.exportReportToPdfStream(jasperPrint, resp.getOutputStream());
                    
                }else{
                    mensaje = "Documento no creado";
                    WebUtil.MensajeAdvertencia(mensaje);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
//            this.estiloMensaje = Constantes.ESTILO_MENSAJE_ERROR;
            mensaje = WebUtil.mensajeError();
            WebUtil.MensajeError(mensaje);
        }
//        RequestContext.getCurrentInstance().update("datos");
    }
    public void findetalle() throws Exception {
        try{
            /*TOTAL*/
            listDocumentos=docDao.getCotizacionVenta(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),"edt_cotizacionventa");
            lstdcotizacionventas = dcotizacionventasDao.getListDCotizacionWeb(user.getIDEMPRESA(),getDatoEdicion().getIdcotizacionv());
            listMoneda = monedasDao.getListMonedasWeb();
            
            listTotalDestructura_costos_recursos = new ArrayList<>();
            listTotalDestructura_costos_recursos_cotizacionventas = new ArrayList<>();
            
            listTotalEstructura_costos_mano_obra = new ArrayList<>();
            listTotalEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            periodoBase=dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            periodoDisenio=dateFormat.format(new Date());
            mesNumeroDisenio=WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            mesNombreDisenio=WebUtil.strMonths[(new Date()).getMonth()];

            /*RESET TAB*/
            selectdcotizacionventas = null;
            listDestructura_costos_recursos_cotizacionventas = new ArrayList<>();
            listEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
            selectEstructura_costos = null;
            selectEstructura_costos_clieprov = null;
            selectEstructura_costos_producto = null;
            selectDestructura_costos_recursos_cotizacionventas = null;
            selectEstructura_costos_mano_obra_cotizacionventas= null;
            selectDestructura_costos_recursos = null;
            selectEstructura_costos_mano_obra= null;
            this.setSubtotal_ecosto(0.0f);
            this.setGo_ecosto(0.0f);
            this.setGa_ecosto(0.0f);
            this.setU_ecosto(0.0f);
            this.total_ecosto = (0.0f);
            this.ajuste_ecosto = (0.0f);
            caculate_hora = false;
            getDatoEdicion().setMes(mesNombreDisenio);
            if(getLadd()==2){/*EDITAR*/
                periodoBase=getDatoEdicion().getPeriodo();
                periodoDisenio=getDatoEdicion().getPeriodo().substring(0, 4);
                mesNumeroDisenio=getDatoEdicion().getPeriodo().substring(4);
                mesNombreDisenio=WebUtil.strMonths[Integer.parseInt(getDatoEdicion().getPeriodo().substring(4))-1];
                /* CONSULTAR ESTRUCTURA COSTOS CLIEPROV*/
                listEstructura_costos_clieprov  = estructura_costos_clieprovDao.listarPorEmpresaWebXclieprov(user.getIDEMPRESA(),
                        getDatoEdicion().getIdclieprov());
                if(!listEstructura_costos_clieprov.isEmpty()){
                    selectEstructura_costos_clieprov=listEstructura_costos_clieprov.get(0);
                    /*DESTRUCTURA_COSTOS_RECURSO_TOTAL*/
                    listTotalDestructura_costos_recursos_cotizacionventas=destructura_costos_recursos_cotizacionventasDao.listarPorEmpresaWebXCotizacion(user.getIDEMPRESA(),getDatoEdicion().getIdcotizacionv());
                    /*ESTRUCTURA_COSTOS_MANO_OBRA_TOTAL*/
                    listTotalEstructura_costos_mano_obra_cotizacionventas=estructura_costos_mano_obra_cotizacionventasDao.listarPorEmpresaWebXproducto(user.getIDEMPRESA(),getDatoEdicion().getIdcotizacionv());
                }else{
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
                    WebUtil.error(mensaje);
                }
            }
            if(getLadd()==1){/*** NUEVO ***/
                getDatoEdicion().setNumero(numero);
                getDatoEdicion().setSubtotalsindscto(0.0f);
                getDatoEdicion().setSubtotalcondscto(0.0f);
                getDatoEdicion().setDescuento(0.0f);
                getDatoEdicion().setImpuesto(0.0f);
                getDatoEdicion().setImporte(0.0f);
            }
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            RequestContext.getCurrentInstance().update("datos:tsubtotal");
            RequestContext.getCurrentInstance().update("datos:tdescuento");
            RequestContext.getCurrentInstance().update("datos:tigv");
            RequestContext.getCurrentInstance().update("datos:ttotal");
            RequestContext.getCurrentInstance().update("datos:tabs");
        }catch(Exception ex){
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Destructura_costos_recursos_cotizacionventas> listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action(){
        List<Destructura_costos_recursos_cotizacionventas> temp = new ArrayList<>();
        if(getSelectdcotizacionventas()!=null){
            for(Destructura_costos_recursos_cotizacionventas ob:listTotalDestructura_costos_recursos_cotizacionventas){
                if(ob.getItemrango().trim().equalsIgnoreCase(getSelectdcotizacionventas().getItemcotizacion().trim()) &&
                     ob.getIdproducto_ec().trim().equalsIgnoreCase(getSelectdcotizacionventas().getIdproducto().trim()) &&
                        ob.getCodigo().trim().equalsIgnoreCase(getSelectdcotizacionventas().getIdcompra().trim())){
                    temp.add(ob);
                }
            }
        }
        return temp;
    }
    public List<Estructura_costos_mano_obra_cotizacionventas> listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_cotizacionventas_action(){
        List<Estructura_costos_mano_obra_cotizacionventas> temp = new ArrayList<>();
        if(getSelectdcotizacionventas()!=null){
            for(Estructura_costos_mano_obra_cotizacionventas ob:listTotalEstructura_costos_mano_obra_cotizacionventas){
                if(ob.getItemrango().trim().equalsIgnoreCase(getSelectdcotizacionventas().getItemcotizacion().trim()) &&
                    ob.getIdproducto().trim().equalsIgnoreCase(getSelectdcotizacionventas().getIdproducto().trim()) &&
                        ob.getCodigo().trim().equalsIgnoreCase(getSelectdcotizacionventas().getIdcompra().trim())){
                    temp.add(ob);
                }
            }
        }
        return temp;
    }
    public void replaceDestructura_costos_recursos_cotizacionventas_action(Destructura_costos_recursos_cotizacionventas ob){
        int pos=0;
        for(Destructura_costos_recursos_cotizacionventas ot:listTotalDestructura_costos_recursos_cotizacionventas){
            if(ob.getIdempresa().trim().equalsIgnoreCase(ot.getIdempresa().trim()) &&
                ob.getCodigo().trim().equalsIgnoreCase(ot.getCodigo().trim()) &&
                ob.getItem().trim().equalsIgnoreCase(ot.getItem().trim()) &&
                ob.getIdproducto_ec().trim().equalsIgnoreCase(ot.getIdproducto_ec().trim()) &&
                ob.getItemrango().trim().equalsIgnoreCase(ot.getItemrango().trim())
              ){
                listTotalDestructura_costos_recursos_cotizacionventas.set(pos, ob);
                break;
            }else{
                pos++;
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
    public String agregarItemDcotizacionventa(){
        int dato = 1;
        int may=-999999999;
        for(Dcotizacionventas obj:getLstdcotizacionventas()){
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
    /**** EVENTO *****/
    public void onRowSelectDordenservicio() throws IOException {
        setBotonEditarDcotizacionventas(false);
        setBotonEliminarDcotizacionventas(false);
        /**** CONFIGURACION ESTRUCTURA COSTOS*****/
        if(!listEstructura_costos_clieprov.isEmpty()){
            try {
                List<Estructura_costos> lstEstructuracostos=estructura_costosDao.listarPorEmpresaWebXidclieprov(user.getIDEMPRESA(),
                    getSelectEstructura_costos_clieprov().getIdclieprov());
                if(!lstEstructuracostos.isEmpty()){
                    setBotonNuevoDestructura_costos_recurso(false);
                    setBotonNuevoEstructura_costos_mano_obra(false);
                    selectEstructura_costos = lstEstructuracostos.get(0);
                    /*** ANÁLISIS ****/
                    listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
                    listEstructura_costos_mano_obra_cotizacionventas=listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_cotizacionventas_action();
                    if(getListDestructura_costos_recursos_cotizacionventas().isEmpty()){
                        setListDestructura_costos_recursos(destructura_costos_recursosDao.listarPorEmpresaWebXProducto(selectEstructura_costos_producto.getIdempresa(), selectEstructura_costos_producto.getCodigo(),
                                getSelectdcotizacionventas().getIdproducto(),getSelectdcotizacionventas().getItemcotizacion()));
                        if(!getListDestructura_costos_recursos().isEmpty()){
                            setListDestructura_costos_recursos_cotizacionventas(new ArrayList<>());
                            Destructura_costos_recursos_cotizacionventas tmp=null;
                            for(Destructura_costos_recursos ob:getListDestructura_costos_recursos()){
                                tmp = new Destructura_costos_recursos_cotizacionventas();
                                tmp.setIdbasedatos(ob.getIdbasedatos());
                                tmp.setIdempresa(ob.getIdempresa());
                                tmp.setCodigo(ob.getCodigo());
                                tmp.setIdcotizacionv(getDatoEdicion().getIdcotizacionv());
                                tmp.setItem(ob.getItem());
                                tmp.setTipo_recurso(ob.getTipo_recurso());
                                tmp.setDescripcion(ob.getDescripcion());
                                tmp.setCantidad(ob.getCantidad());
                                tmp.setCosto(ob.getCosto());
                                tmp.setEs_porcentaje(ob.getEs_porcentaje());
                                tmp.setIdmedida(ob.getIdmedida());
                                tmp.setIdproducto_ec(ob.getIdproducto_ec());
                                tmp.setPorcentaje(ob.getPorcentaje());
                                tmp.setSubtotal(ob.getSubtotal());
                                tmp.setPu(ob.getPu());
                                tmp.setItemrango(ob.getItemrango());
                                listTotalDestructura_costos_recursos_cotizacionventas.add(tmp);
                                listTotalDestructura_costos_recursos.add(ob);
//                                getListDestructura_costos_recursos_cotizacionventas().add(tmp);
                            }
                        }else{
                            mensaje = "No existe registro <DESTRUCTURA_COSTOS_RECURSO>";
                            WebUtil.error(mensaje);
                        }
                    }
                    if(getListEstructura_costos_mano_obra_cotizacionventas().isEmpty()){
                        setListEstructura_costos_mano_obra(estructura_costos_mano_obraDao.listarPorEmpresaWebXproducto(selectEstructura_costos_producto.getIdempresa(), selectEstructura_costos_producto.getCodigo(),
                                getSelectdcotizacionventas().getIdproducto(),getSelectdcotizacionventas().getItemcotizacion()));
                        if(!getListEstructura_costos_mano_obra().isEmpty()){
                            setListEstructura_costos_mano_obra_cotizacionventas(new ArrayList<>());
                            Estructura_costos_mano_obra_cotizacionventas tmp= null;
                            for(Estructura_costos_mano_obra ob :  getListEstructura_costos_mano_obra()){
                                tmp = new Estructura_costos_mano_obra_cotizacionventas();
                                tmp.setIdbasedatos(ob.getIdbasedatos());
                                tmp.setIdempresa(ob.getIdempresa());
                                tmp.setIdcotizacionv(getDatoEdicion().getIdcotizacionv());
                                tmp.setCodigo(ob.getCodigo());
                                tmp.setIdcargo(ob.getIdcargo());
                                tmp.setItem(ob.getItem());
                                tmp.setEstado(ob.getEstado());
                                tmp.setIdproducto(ob.getIdproducto());
                                tmp.setItemrango(ob.getItemrango());
                                tmp.setCosto(ob.getCosto());
                                tmp.setCargo(ob.getCargo());
                                listTotalEstructura_costos_mano_obra_cotizacionventas.add(tmp);
                                listTotalEstructura_costos_mano_obra.add(ob);
//                                getListEstructura_costos_mano_obra_cotizacionventas().add(tmp);
                            }
                            
                        }else{
                            mensaje = "No existe registro <ESTRUCTURA_COSTOS_MANO_OBRA>";
                            WebUtil.error(mensaje);
                        }
                    }
                    listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
                    listEstructura_costos_mano_obra_cotizacionventas=listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_cotizacionventas_action();
                    this.ajuste_ecosto=getSelectdcotizacionventas().getImporte_isc();
                    calculosTotales_estructuracostos_local();
                    getSelectdcotizacionventas().setPrecio(this.total_ecosto);
                    RequestContext.getCurrentInstance().update("datos:tabs");
                    //tabView.setActiveIndex(indexTab);
                }else{
                    /*SIN ESTRUCTURA DE COSTOS*/
                }
            //RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            } catch (NisiraORMException ex) {
                Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void onRowSelectDestructura_costos_recursos(SelectEvent event) throws IOException {
        setBotonNuevoDestructura_costos_recurso(false);
        setBotonEliminarDestructura_costos_recurso(false);
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
//        RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
    }
    public void onRowSelectEstructura_costos_mano_obra(SelectEvent event) throws IOException {
        setBotonEditarEstructura_costos_mano_obra(false);
        setBotonEliminarEstructura_costos_mano_obra(false);
        setEstructura_costos_mano_obra_cotizacionventas(selectEstructura_costos_mano_obra_cotizacionventas);
        RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra_cotizacionventas");
//        tabView.setActiveIndex(indexTab);
    }
    public void onCellEdit(RowEditEvent event) {
        Destructura_costos_recursos_cotizacionventas entity = ((Destructura_costos_recursos_cotizacionventas)event.getObject());
//        int itemRow = getListDestructura_costos_recursos_cotizacionventas().indexOf(entity);
        /*FORMULA FACTOR*/
        Float factor=getFactor(entity.getIdempresa().trim(), entity.getCodigo().trim(), entity.getItem().trim(), entity.getIdproducto_ec().trim(), entity.getItemrango().trim(),entity.getDescripcion().trim());
        if(factor!=null){
            Double calculo=0.0d;
            calculo += entity.getCantidad()*factor;
            entity.setCosto(calculo.floatValue());
        }
        calculosTotales_estructuracostos_local();
        replaceDestructura_costos_recursos_cotizacionventas_action(entity);
        listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
        actualizarCostoServicio();
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
        RequestContext.getCurrentInstance().update("datos:tabs:subtotal_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:go_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:ga_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:u_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:total_ecosto");
//        RequestContext.getCurrentInstance().update("datos:tabs");
//        tabView.setActiveIndex(indexTab);
    }
    public void calculosTotales_estructuracostos_local(){
        Double subtotal_ec=0.0d;
        Double go_ec=0.0d;
        Double ga_ec=0.0d;
        Double u_ec=0.0d;
        Double total_porcentaje=0.0d;
        Double total_ec=0.0d;
        int item=0;
        if(!getListDestructura_costos_recursos_cotizacionventas().isEmpty()){
            /*CÁLCULO SUBTOTAL*/
            for(Destructura_costos_recursos_cotizacionventas o :getListDestructura_costos_recursos_cotizacionventas()){
                if(o.getEs_porcentaje()==0.0f){
                    subtotal_ec+=o.getCosto();
                }
            }
            /*CÁLCULO PORCENTAJE*/
            for(Destructura_costos_recursos_cotizacionventas o :getListDestructura_costos_recursos_cotizacionventas()){
                if(o.getEs_porcentaje()==1.0f){
                    switch(o.getDescripcion().trim().toUpperCase()){
                        case "GO":go_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                        case "GA":ga_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                        case "U":u_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                    }
                    total_porcentaje+=(o.getCantidad()/100)*subtotal_ec;
                }
            }
        }
        total_ec = subtotal_ec + total_porcentaje;
        /*RESULTADOS*/
        this.setSubtotal_ecosto(subtotal_ec.floatValue());
        this.setGo_ecosto(go_ec.floatValue());
        this.setGa_ecosto(ga_ec.floatValue());
        this.setU_ecosto(u_ec.floatValue());
        this.total_ecosto = total_ec.floatValue()+this.getAjuste_ecosto();
        if(getDcotizacionventas()!=null){
            getDcotizacionventas().setImporte_isc(this.getAjuste_ecosto());
        }
    }
    public void actualizarCostoServicio(){
        if(getSelectdcotizacionventas()!=null){
            Double subtotalsin =0.0d;
            Double subtotalcon =0.0d;
            Double impuesto=0.0d;
            Double importe=0.0d;
            int pos = lstdcotizacionventas.indexOf(getSelectdcotizacionventas());
            Dcotizacionventas item = getSelectdcotizacionventas();
            /****************** CÁLCULOS ****************/
            item.setPrecio(total_ecosto);
            subtotalsin+=item.getPrecio()*item.getCantidad();
            impuesto+=subtotalsin*(item.getImpuesto_i()/100);
            importe+=subtotalsin+impuesto-item.getDescuento();
            subtotalcon+=subtotalsin+impuesto;
            /****************** RESET  DATOS ****************/
            item.setSubtotalsindscto(subtotalsin.floatValue());
            item.setSubtotalcondscto(subtotalcon.floatValue());
            item.setImpuesto(impuesto.floatValue());
            item.setImporte(importe.floatValue());
            lstdcotizacionventas.set(pos, item);
            selectdcotizacionventas = lstdcotizacionventas.get(pos);
            calcularTotales();
            RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            RequestContext.getCurrentInstance().update("datos:tsubtotal");
            RequestContext.getCurrentInstance().update("datos:tdescuento");
            RequestContext.getCurrentInstance().update("datos:tigv");
            RequestContext.getCurrentInstance().update("datos:ttotal");
        }
    }
    public Float getFactor(String idempresa,String codigo,String item,String idproducto,String itemrango,String descripcion){
        Float factor=null;
            try{
                for(Destructura_costos_recursos ob :listDestructura_costos_recursos){
                if(ob.getIdempresa().trim().equalsIgnoreCase(idempresa) &&
                        ob.getCodigo().trim().equalsIgnoreCase(codigo) &&
                        ob.getItem().trim().equalsIgnoreCase(item) &&
                        ob.getIdproducto_ec().trim().equalsIgnoreCase(idproducto) &&
                        ob.getItemrango().trim().equalsIgnoreCase(itemrango) &&
                        ob.getDescripcion().trim().equalsIgnoreCase(descripcion)){
                    factor=0.0f;
                    factor+=ob.getCosto()/ob.getCantidad();
                    ;break;    
                }
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            factor=null;
        }
        return factor;
    }
    /************MANTENIMIENTO - DESTRUCTURA - COSTOS - RECURSO **************/
    public void actualizarDestructuraCostosRecurso() {
        listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
        calculosTotales_estructuracostos_local();
        actualizarCostoServicio();
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
        RequestContext.getCurrentInstance().update("datos:tabs:subtotal_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:go_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:ga_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:u_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:total_ecosto");
    }
    public void agregarDestructuraCostosRecurso() {
        if(getSelectdcotizacionventas()!=null){
            if(getSelectEstructura_costos()!=null){
                setDestructura_costos_recursos_cotizacionventas(new Destructura_costos_recursos_cotizacionventas());
                getDestructura_costos_recursos_cotizacionventas().setIdempresa(user.getIDEMPRESA());
                getDestructura_costos_recursos_cotizacionventas().setCodigo(getSelectEstructura_costos().getCodigo());
                getDestructura_costos_recursos_cotizacionventas().setItem(agregarItemDestructuraCostosRecurso());
                getDestructura_costos_recursos_cotizacionventas().setEs_porcentaje(0.0f);
                getDestructura_costos_recursos_cotizacionventas().setCantidad(0.0f);
                getDestructura_costos_recursos_cotizacionventas().setCosto(0.0f);
                getDestructura_costos_recursos_cotizacionventas().setIdproducto_ec(getSelectdcotizacionventas().getIdproducto());
                getDestructura_costos_recursos_cotizacionventas().setTipo_recurso("CO");
                getDestructura_costos_recursos_cotizacionventas().setItemrango(getSelectdcotizacionventas().getItemcotizacion());
                listTotalDestructura_costos_recursos_cotizacionventas.add(getDestructura_costos_recursos_cotizacionventas());
                //getListDestructura_costos_recursos_cotizacionventas().add(getDestructura_costos_recursos_cotizacionventas());
                listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
                RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
            }else{
                mensaje = "No existe estructura de costo";
                WebUtil.error(mensaje);
            }
//            tabView.setActiveIndex(indexTab);
//            RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
        }else{
            mensaje = "Seleccionar Detalle Cotización";
            WebUtil.error(mensaje);
        }
    }
    public void eliminarDestructuraCostosRecurso(RowEditEvent event) {
        try {
            Destructura_costos_recursos_cotizacionventas entity = ((Destructura_costos_recursos_cotizacionventas)event.getObject());
            listTotalDestructura_costos_recursos_cotizacionventas.remove(entity);
            listDestructura_costos_recursos_cotizacionventas=listarPorEmpresaWebXProducto_Destructura_costos_cotizacionventas_recursos_action();
            //listDestructura_costos_recursos_cotizacionventas.remove(selectDestructura_costos_recursos_cotizacionventas);
            resetIndices_DestructuraCostosRecurso();
            calculosTotales_estructuracostos_local();
            actualizarCostoServicio();
            RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
            RequestContext.getCurrentInstance().update("datos:tabs:subtotal_ecosto");
            RequestContext.getCurrentInstance().update("datos:tabs:go_ecosto");
            RequestContext.getCurrentInstance().update("datos:tabs:ga_ecosto");
            RequestContext.getCurrentInstance().update("datos:tabs:u_ecosto");
            RequestContext.getCurrentInstance().update("datos:tabs:total_ecosto");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /************MANTENIMIENTO - ESTRUCTURA COSTOS MANO OBRA**************/
    public void nuevoEstructuraCostosManoObra() {
        if(getSelectdcotizacionventas()!=null){
            if(getSelectEstructura_costos()!=null){
                setEstructura_costos_mano_obra_cotizacionventas(new Estructura_costos_mano_obra_cotizacionventas());
                getEstructura_costos_mano_obra_cotizacionventas().setIdempresa(user.getIDEMPRESA());
                getEstructura_costos_mano_obra_cotizacionventas().setCodigo(getSelectEstructura_costos().getCodigo());
                getEstructura_costos_mano_obra_cotizacionventas().setItem(agregarItemEstructuraCostosManoObra());
                getEstructura_costos_mano_obra_cotizacionventas().setItemrango(getSelectdcotizacionventas().getItemcotizacion());
                getEstructura_costos_mano_obra_cotizacionventas().setIdproducto(getSelectdcotizacionventas().getIdproducto());
                getEstructura_costos_mano_obra_cotizacionventas().setCosto(0.00f);
                RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').show()");
            }else{
                mensaje = "No existe estructura de costo";
                WebUtil.error(mensaje);
            }
        }else{
            mensaje = "Seleccionar Detalle Cotización";
            WebUtil.error(mensaje);
        }
        
    }
    public void editarEstructuraCostosManoObra() {
        setEstructura_costos_mano_obra_cotizacionventas(selectEstructura_costos_mano_obra_cotizacionventas);
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').show()");
    }
    public void eliminarEstructuraCostosManoObra() {
        try {
            listTotalEstructura_costos_mano_obra_cotizacionventas.remove(selectEstructura_costos_mano_obra_cotizacionventas);
            RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra_cotizacionventas");
            listEstructura_costos_mano_obra_cotizacionventas=listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_cotizacionventas_action();
//            tabView.setActiveIndex(indexTab);
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarEstructuraCostosManoObra(){
        if(estructura_costos_mano_obra_cotizacionventas.getIdcargo().isEmpty()){
            mensaje = "Seleccionar Cargo";
            WebUtil.error(mensaje);
        }
//        else if(existeCargo(estructura_costos_mano_obra.getIdcargo())){
//            mensaje = "Cargo repetido";
//            WebUtil.error(mensaje);
//        }
        else{
            int pos=listTotalEstructura_costos_mano_obra_cotizacionventas.indexOf(estructura_costos_mano_obra_cotizacionventas);
            if(pos==-1)
                listTotalEstructura_costos_mano_obra_cotizacionventas.add(estructura_costos_mano_obra_cotizacionventas);
            else 
                listTotalEstructura_costos_mano_obra_cotizacionventas.set(pos, estructura_costos_mano_obra_cotizacionventas);
            listEstructura_costos_mano_obra_cotizacionventas=listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_cotizacionventas_action();
            RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra_cotizacionventas");
//            tabView.setActiveIndex(indexTab);
//            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
            RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').hide()");
        }
        
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalOptions, null);
    }
    public void valorCargos_personal(SelectEvent event) {
        Cargos_personal cargo = (Cargos_personal) event.getObject();
        this.getEstructura_costos_mano_obra_cotizacionventas().setIdcargo(cargo.getIdcargo());
        this.getEstructura_costos_mano_obra_cotizacionventas().setCargo(cargo.getDescripcion());
        return;
    }
    /***************** GENERADOR ID *********************/    
    public String agregarItemDestructuraCostosRecurso(){
        int dato = 1;
        int may=-999999999;
        for(Destructura_costos_recursos_cotizacionventas obj:getListDestructura_costos_recursos_cotizacionventas()){
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
    public String agregarItemEstructuraCostosManoObra(){
        int dato = 1;
        int may=-999999999;
        for(Estructura_costos_mano_obra obj:getListEstructura_costos_mano_obra()){
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
    /***************** RECALCULAR INDICES*********************/ 
    public void resetIndices_DestructuraCostosRecurso(){
        List<Destructura_costos_recursos_cotizacionventas> temp = new ArrayList<>();
        /**** INSERTAR NO PORCENTAJE******/
        for(int i=0 ; i<getListDestructura_costos_recursos_cotizacionventas().size();i++){
            Destructura_costos_recursos_cotizacionventas ob =getListDestructura_costos_recursos_cotizacionventas().get(i);
            if(ob.getEs_porcentaje()==0.0f){
                ob.setItem(WebUtil.idGeneradoTres(i+1));
                temp.add(ob);
            }
        }
        /**** INSERTAR PORCENTAJE******/
        int es_porcentaje=temp.size();
        for(int i=0 ; i<getListDestructura_costos_recursos_cotizacionventas().size();i++){
            Destructura_costos_recursos_cotizacionventas ob =getListDestructura_costos_recursos_cotizacionventas().get(i);
            if(ob.getEs_porcentaje()==1.0f){
                ob.setItem(WebUtil.idGeneradoTres(es_porcentaje+1));
                temp.add(ob);
                es_porcentaje++;
            }
        }
        listDestructura_costos_recursos_cotizacionventas=temp;
//        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos_cotizacionventas");
    }
    /*** responsable ***/
    public void verCntVendedor() {
        RequestContext.getCurrentInstance().openDialog("cntVendedor", modalOptions, null);
    }
    public void valorVendedor(SelectEvent event) {
        this.selectVendedor = (Vendedor)  event.getObject();
        getDatoEdicion().setIdvendedor(selectVendedor.getIdvendedor());
        getDatoEdicion().setVendedor(selectVendedor.getDescripcion());
    }
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        try {
            this.selectClieprov = (Clieprov) event.getObject();
            getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
            getDatoEdicion().setRazon_social(selectClieprov.getRazonsocial());
            /* CONSULTAR ESTRUCTURA COSTOS CLIEPROV*/
            listEstructura_costos_clieprov = estructura_costos_clieprovDao.listarPorEmpresaWebXclieprov(user.getIDEMPRESA(),
                    getDatoEdicion().getIdclieprov());
            if(listEstructura_costos_clieprov.isEmpty()){
                mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
                WebUtil.error(mensaje);
            }else{
                selectEstructura_costos_clieprov=listEstructura_costos_clieprov.get(0);
            }
//            if(!listestcos_clieprov.isEmpty()){
//                selectEstructura_costos_clieprov=listestcos_clieprov.get(0);
//            }else{
//                mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
//                WebUtil.error(mensaje);
//            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void verCntContactosClieprov() {
        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        values.add(getDatoEdicion().getIdclieprov());
        params.put("idcliente",values);
        RequestContext.getCurrentInstance().openDialog("cntContactosClieprov", modalParamsOptions, params);
    }
    public void valorContactosClieprov(SelectEvent event) {
        this.selectContactosClieprov = (Contactosclieprov) event.getObject();
        getDatoEdicion().setItem_contacto(selectContactosClieprov.getItem());
        getDatoEdicion().setContacto(selectContactosClieprov.getNombre());
        getDatoEdicion().setContacto_email(selectContactosClieprov.getEmail());
    }
    public void verCntProducto_Estructura_costos() {
        if(selectEstructura_costos_clieprov!=null){
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            List<String> values = new ArrayList<String>();
            values.add(selectEstructura_costos_clieprov.getIdclieprov());
            params.put("codigo_estructura", values);
            RequestContext.getCurrentInstance().openDialog("cntEstructura_Costos_Producto", modalParamsOptions, params);
        }else{
            mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos");
        }
    }
    public void valorProducto_Estructura_costos(SelectEvent event) {
        try {
            this.setSelectEstructura_costos_producto((Estructura_costos_producto) event.getObject());
            getDcotizacionventas().setIdproducto(selectEstructura_costos_producto.getIdproducto());
            getDcotizacionventas().setProducto(selectEstructura_costos_producto.getDescripcion());
            getDcotizacionventas().setDescripcion(selectEstructura_costos_producto.getDescripcion());
            getDcotizacionventas().setIdmedida(selectEstructura_costos_producto.getIdmedida());
            getDcotizacionventas().setImporte_isc(selectEstructura_costos_producto.getAjuste());
            getDcotizacionventas().setCodoperativo(selectEstructura_costos_producto.getCodoperativo());
            /************ CONSULTAR PRECIOS ,IGV  ****************/
            ArrayList<Object> arrayObject = productoDao.returnImpuestoxproducto(user.getIDEMPRESA(), 
                    getDcotizacionventas().getIdproducto(),WebUtil.SimpleDateFormatN1(getDatoEdicion().getFecha()));
            /******************************************************/
            Double preciounitario=0.0d;
            if(selectEstructura_costos_clieprov!=null){
                if(selectEstructura_costos_producto!=null){

                    List<Destructura_costos_recursos> lst=destructura_costos_recursosDao.listarPorEmpresaWebXProducto(selectEstructura_costos_producto.getIdempresa(), selectEstructura_costos_producto.getCodigo(),
                            selectEstructura_costos_producto.getIdproducto(),selectEstructura_costos_producto.getItem());
                    if(!lst.isEmpty()){
                        Double subtotal_ec=0.0d;
                        Double go_ec=0.0d;
                        Double ga_ec=0.0d;
                        Double u_ec=0.0d;
                        Double total_porcentaje=0.0d;
                        Double total_ec=0.0d;
                        /*CÁLCULO SUBTOTAL*/
                        for(Destructura_costos_recursos o :lst){
                            if(o.getEs_porcentaje()==0.0f){
                                subtotal_ec+=o.getCosto();
                            }
                        }
                        /*CÁLCULO PORCENTAJE*/
                        for(Destructura_costos_recursos o :lst){
                            if(o.getEs_porcentaje()==1.0f){
                                switch(o.getDescripcion().trim().toUpperCase()){
                                    case "GO":go_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                                    case "GA":ga_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                                    case "U":u_ec+=((o.getCantidad()/100)*subtotal_ec);break;
                                }
                                total_porcentaje+=(o.getCantidad()/100)*subtotal_ec;
                            }
                        }
                        total_ec = subtotal_ec + total_porcentaje + selectEstructura_costos_producto.getAjuste();
                        //total_ec = subtotal_ec + total_porcentaje;
                        preciounitario = total_ec;
                    }
                    else{
                        preciounitario = 0.00d;
//                                    destructura_costos_recursosDao.getPrecioUnitarioXestructuracostos(
//                                selectEstructura_costos_clieprov.getIdempresa(), selectEstructura_costos_clieprov.getCodigo(),
//                                getDcotizacionventas().getIdproducto(),selectEstructura_costos_producto.getItem());
                    }
                }else{
                    mensaje = "Producto : Definir Estructura - Costos";
                    WebUtil.MensajeFatal(mensaje); 
                }

            }else{
                mensaje = "Clieprov : Definir Estructura - Costos";
                WebUtil.MensajeFatal(mensaje);
            }
            if(preciounitario!=0.0d){
                getDcotizacionventas().setPrecio(preciounitario.floatValue());
            }else{
                getDcotizacionventas().setPrecio(0.0f);
            }
            getDcotizacionventas().setImpuesto_i(0.0f);
//            getDcotizacionventas().setImpuesto_i(((Double)arrayObject.get(2)).floatValue());
//                if(!arrayObject.isEmpty()){
//                    getDcotizacionventas().setImpuesto_i(((Double)arrayObject.get(2)).floatValue());
//                }else{
//                    getDcotizacionventas().setImpuesto_i(0.0f);
//                }
            /********* CÁLCULOS *********/
            getDcotizacionventas().setImpuesto((getDcotizacionventas().getImpuesto_i()/100)*getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad());
            getDcotizacionventas().setImporte((getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad())-
                    getDcotizacionventas().getDescuento()+getDcotizacionventas().getImpuesto());
            
        } catch (NisiraORMException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nuevoDcotizacionventas() {
        if(getDatoEdicion().getIdclieprov()==null && getDatoEdicion().getRazon_social()==null){
            this.mensaje="Seleccionar Cliente";
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos");
        }else{
            setDcotizacionventas(new Dcotizacionventas());
            getDcotizacionventas().setIdempresa(user.getIDEMPRESA());
            getDcotizacionventas().setIdcotizacionv(getDatoEdicion().getIdcotizacionv());
            getDcotizacionventas().setItem(agregarItemDcotizacionventa());
            getDcotizacionventas().setPrecio(0.0f);
            getDcotizacionventas().setCantidad(1.0f);
            getDcotizacionventas().setDescuento(0.0f);
            getDcotizacionventas().setImpuesto(0.0f);
            getDcotizacionventas().setSubtotalsindscto(0.0f);
            getDcotizacionventas().setSubtotalcondscto(0.0f);
            getDcotizacionventas().setImporte(0.0f);
            getDcotizacionventas().setNhoras("");
            getDcotizacionventas().setFechacreacion(getDatoEdicion().getFecha());
            getDcotizacionventas().setObservaciones("");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
        }
    }
    public void editarDcotizacionventas() {
        if(getDatoEdicion().getIdclieprov()==null && getDatoEdicion().getRazon_social()==null){
            this.mensaje="Seleccionar Cliente";
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(selectdcotizacionventas==null){
            this.mensaje="Seleccionar Detalle";
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        else{
            RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            //            actualizarCostoServicio();
            selectdcotizacionventas.setPrecio(this.total_ecosto);
            setDcotizacionventas(selectdcotizacionventas);
            RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
        }
    }
    public void verCntFormaPago() {
        RequestContext.getCurrentInstance().openDialog("cntForma_pago", modalOptions, null);
    }
    public void valorFormaPago(SelectEvent event) {
        this.selectForma_pago = (Forma_pago) event.getObject();
        getDatoEdicion().setIdfpago(selectForma_pago.getIdfpago());
        getDatoEdicion().setFormapago(selectForma_pago.getDescripcion());
    }
    public void verCntAlmacenar() {
        RequestContext.getCurrentInstance().openDialog("cntAlmacenar", modalOptions, null);
    }
    public void valorAlmacenar(SelectEvent event) {
        this.selectForma_pago = (Forma_pago) event.getObject();
        getDatoEdicion().setIdfpago(selectForma_pago.getIdfpago());
        getDatoEdicion().setFormapago(selectForma_pago.getDescripcion());
    }
    public void eliminarDcotizacionventas() {
        try {
            if(selectdcotizacionventas==null){
                this.mensaje="Seleccionar Detalle";
                WebUtil.error(getMensaje());
                RequestContext.getCurrentInstance().update("datos");
            }else{
                lstdcotizacionventas.remove(selectdcotizacionventas);
                /*ELIMINAR DE DESTRUCTURA_COSTOS_RECURSO_COTIZACIONVENTAS_TOTAL*/
                
                /*ELIMINAR DE ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS_TOTAL*/
                
                /**** RESET ***/
                listDestructura_costos_recursos_cotizacionventas = new ArrayList<>();
                listEstructura_costos_mano_obra_cotizacionventas = new ArrayList<>();
                selectdcotizacionventas = null;
                selectDestructura_costos_recursos_cotizacionventas=null;
                selectEstructura_costos_mano_obra_cotizacionventas=null;

                botonNuevoDestructura_costos_recurso = true;
                botonNuevoEstructura_costos_mano_obra = true;
                botonEditarDestructura_costos_recurso = true;
                botonEditarEstructura_costos_mano_obra = true;
                botonEliminarDestructura_costos_recurso = true;
                botonEliminarEstructura_costos_mano_obra = true;
                this.setSubtotal_ecosto(0.0f);
                this.setGo_ecosto(0.0f);
                this.setGa_ecosto(0.0f);
                this.setU_ecosto(0.0f);
                this.total_ecosto = (0.0f);
                calcularTotales();
                RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
                RequestContext.getCurrentInstance().update("datos:tsubtotal");
                RequestContext.getCurrentInstance().update("datos:tdescuento");
                RequestContext.getCurrentInstance().update("datos:tigv");
                RequestContext.getCurrentInstance().update("datos:ttotal");
                RequestContext.getCurrentInstance().update("datos:tabs");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarDcotizacionventa(){
        try {
            int pos=lstdcotizacionventas.indexOf(dcotizacionventas);
            Double subtotalsindscto=0.0d;
            Double descuento=0.0d;
            Double impuesto=0.0d;
            Double importe=0.0d;
            /***********CALCULOS*************/
            subtotalsindscto += getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad();
            descuento+=getDcotizacionventas().getDescuento();
            impuesto+=subtotalsindscto*(getDcotizacionventas().getImpuesto_i()/100);
            importe+=subtotalsindscto-descuento+impuesto;
            getDcotizacionventas().setImpuesto(impuesto.floatValue());
            getDcotizacionventas().setSubtotalsindscto(subtotalsindscto.floatValue());
            getDcotizacionventas().setSubtotalcondscto(((Double)(subtotalsindscto-descuento)).floatValue());
            getDcotizacionventas().setImporte(importe.floatValue());
            if(selectEstructura_costos_producto!=null){
                dcotizacionventas.setItemcotizacion(selectEstructura_costos_producto.getItem());/*item - estructura costos*/
                dcotizacionventas.setIdcompra(selectEstructura_costos_producto.getCodigo());/*codigo - estructura costos*/
            }
            if(pos==-1)
                lstdcotizacionventas.add(dcotizacionventas);
            else
                lstdcotizacionventas.set(pos, dcotizacionventas);
            calcularTotales();
            RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
            RequestContext.getCurrentInstance().update("datos:tsubtotal");
            RequestContext.getCurrentInstance().update("datos:tdescuento");
            RequestContext.getCurrentInstance().update("datos:tigv");
            RequestContext.getCurrentInstance().update("datos:ttotal");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').hide()");
            /*SELECCIONAR POR DEFECTO EL DATO INGRESADO*/
            selectdcotizacionventas = dcotizacionventas;
            onRowSelectDordenservicio();
        } catch (IOException ex) {
            mensaje = ex.getMessage();
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calcularDetalleTotal(){
        Double subtotalsindscto=0.0d;
        Double descuento=0.0d;
        Double impuesto=0.0d;
        Double importe=0.0d;
        subtotalsindscto+=getDcotizacionventas().getCantidad()*getDcotizacionventas().getPrecio();
        descuento+=getDcotizacionventas().getDescuento();
        impuesto+=subtotalsindscto*(getDcotizacionventas().getImpuesto_i()/100);
        importe+=subtotalsindscto-descuento+impuesto;
        
        getDcotizacionventas().setImpuesto(impuesto.floatValue());
        getDcotizacionventas().setImporte(importe.floatValue());
    }
    public void calcularTotales(){
        Double subtotalsindscto=0.0d;
        Double descuento=0.0d;
        Double impuesto=0.0d;
        Double importe=0.0d;
        for(Dcotizacionventas obj : lstdcotizacionventas){
//            subtotalsindscto +=obj.getCantidad()*obj.getPrecio();
            subtotalsindscto += obj.getSubtotalsindscto();
            descuento+=obj.getDescuento();
            impuesto+=obj.getImpuesto();
//            importe+=(obj.getCantidad()*obj.getPrecio())-obj.getDescuento()+obj.getImpuesto();
            importe+=obj.getImporte();
        }
        getDatoEdicion().setSubtotalsindscto(subtotalsindscto.floatValue());
        getDatoEdicion().setDescuento(descuento.floatValue());
        getDatoEdicion().setImpuesto(impuesto.floatValue());
        getDatoEdicion().setImporte(importe.floatValue());
    }
    public void calculosTotales_estructuracostos(){
        Float subtotal_ec=0.0f;
        Float go_ec=0.0f;
        Float ga_ec=0.0f;
        Float u_ec=0.0f;
        Float total_ec=0.0f;
        int item=0;
        if(!getListDestructura_costos_recursos().isEmpty()){
            subtotal_ec=getListDestructura_costos_recursos().get(0).getSubtotal();
            total_ec=getListDestructura_costos_recursos().get(0).getPu();
            for(Destructura_costos_recursos ob : getListDestructura_costos_recursos()){
                if(ob.getEs_porcentaje()==1.0f){
                    switch(item){
                        case 0:go_ec=ob.getPorcentaje();break;
                        case 1:ga_ec=ob.getPorcentaje();break;
                        case 2:u_ec=ob.getPorcentaje();break;
                    }
                    item++;
                }
            }
        }
        /*RESULTADOS*/
        this.setSubtotal_ecosto(subtotal_ec);
        this.setGo_ecosto(go_ec);
        this.setGa_ecosto(ga_ec);
        this.setU_ecosto(u_ec);
        this.total_ecosto = getSelectdcotizacionventas().getPrecio();
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(getCotizacionventasDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
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
    /************** CONFIGURACIÓN TAB*******************/
    public void onSPTabChange(TabChangeEvent event) 
    {   
        setTabView((TabView) event.getComponent());
        setIndexTab(getTabView().getActiveIndex());
//        tabView.setActiveIndex(0);
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

    public List<Dcotizacionventas> getLstdprogtlleg() {
        return getLstdcotizacionventas();
    }

    public void setLstdprogtlleg(List<Dcotizacionventas> lstdcotizacionventas) {
        this.setLstdcotizacionventas(lstdcotizacionventas);
    }

    public List<Multitabla> getListMultitabla() {
        return listMultitabla;
    }

    public void setListMultitabla(List<Multitabla> listMultitabla) {
        this.listMultitabla = listMultitabla;
    }

    /**
     * @return the listSucursal
     */
    public List<Sucursales> getListSucursal() {
        return listSucursales;
    }

    /**
     * @param listSucursal the listSucursal to set
     */
    public void setListSucursal(List<Sucursales> listSucursal) {
        this.listSucursales = listSucursal;
    }

    /**
     * @return the listAlmacen
     */
    public List<Almacenes> getListAlmacen() {
        return listAlmacenes;
    }

    /**
     * @param listAlmacen the listAlmacen to set
     */
    public void setListAlmacenes(List<Almacenes> listAlmacenes) {
        this.listAlmacenes= listAlmacenes;
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
     * @return the lstdcotizacionventas
     */
    public List<Dcotizacionventas> getLstdcotizacionventas() {
        return lstdcotizacionventas;
    }

    /**
     * @param lstdcotizacionventas the lstdcotizacionventas to set
     */
    public void setLstdcotizacionventas(List<Dcotizacionventas> lstdcotizacionventas) {
        this.lstdcotizacionventas = lstdcotizacionventas;
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
     * @return the fecha_ini
     */
    public Date getFecha_ini() {
        return fecha_ini;
    }

    /**
     * @param fecha_ini the fecha_ini to set
     */
    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    /**
     * @return the fecha_fin
     */
    public Date getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
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
     * @return the emisorDao
     */
    public EmisorDao getEmisorDao() {
        return emisorDao;
    }

    /**
     * @param emisorDao the emisorDao to set
     */
    public void setEmisorDao(EmisorDao emisorDao) {
        this.emisorDao = emisorDao;
    }

    /**
     * @return the tcambioDao
     */
    public TcambioDao getTcambioDao() {
        return tcambioDao;
    }

    /**
     * @param tcambioDao the tcambioDao to set
     */
    public void setTcambioDao(TcambioDao tcambioDao) {
        this.tcambioDao = tcambioDao;
    }

    /**
     * @return the monedasDao
     */
    public MonedasDao getMonedasDao() {
        return monedasDao;
    }

    /**
     * @param monedasDao the monedasDao to set
     */
    public void setMonedasDao(MonedasDao monedasDao) {
        this.monedasDao = monedasDao;
    }

    /**
     * @return the sucursalesDao
     */
    public SucursalesDao getSucursalesDao() {
        return sucursalesDao;
    }

    /**
     * @param sucursalesDao the sucursalesDao to set
     */
    public void setSucursalesDao(SucursalesDao sucursalesDao) {
        this.sucursalesDao = sucursalesDao;
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
     * @return the dcotizacionventas
     */
    public Dcotizacionventas getDcotizacionventas() {
        return dcotizacionventas;
    }

    /**
     * @param dcotizacionventas the dcotizacionventas to set
     */
    public void setDcotizacionventas(Dcotizacionventas dcotizacionventas) {
        this.dcotizacionventas = dcotizacionventas;
    }

    /**
     * @return the selectdcotizacionventas
     */
    public Dcotizacionventas getSelectdcotizacionventas() {
        return selectdcotizacionventas;
    }

    /**
     * @param selectdcotizacionventas the selectdcotizacionventas to set
     */
    public void setSelectdcotizacionventas(Dcotizacionventas selectdcotizacionventas) {
        this.selectdcotizacionventas = selectdcotizacionventas;
    }

    /**
     * @return the botonEditarDcotizacionventas
     */
    public boolean isBotonEditarDcotizacionventas() {
        return botonEditarDcotizacionventas;
    }

    /**
     * @param botonEditarDcotizacionventas the botonEditarDcotizacionventas to set
     */
    public void setBotonEditarDcotizacionventas(boolean botonEditarDcotizacionventas) {
        this.botonEditarDcotizacionventas = botonEditarDcotizacionventas;
    }

    /**
     * @return the botonEliminarDcotizacionventas
     */
    public boolean isBotonEliminarDcotizacionventas() {
        return botonEliminarDcotizacionventas;
    }

    /**
     * @param botonEliminarDcotizacionventas the botonEliminarDcotizacionventas to set
     */
    public void setBotonEliminarDcotizacionventas(boolean botonEliminarDcotizacionventas) {
        this.botonEliminarDcotizacionventas = botonEliminarDcotizacionventas;
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
     * @return the selectForma_pago
     */
    public Forma_pago getSelectForma_pago() {
        return selectForma_pago;
    }

    /**
     * @param selectForma_pago the selectForma_pago to set
     */
    public void setSelectForma_pago(Forma_pago selectForma_pago) {
        this.selectForma_pago = selectForma_pago;
    }

    /**
     * @return the selectAlmacen
     */
    public Almacen getSelectAlmacen() {
        return selectAlmacen;
    }

    /**
     * @param selectAlmacen the selectAlmacen to set
     */
    public void setSelectAlmacen(Almacen selectAlmacen) {
        this.selectAlmacen = selectAlmacen;
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
            setListaDatos(getCotizacionventasDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Cotizacionventas");
        return "";
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

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the listEstructura_costos_clieprov
     */
    public List<Estructura_costos_clieprov> getListEstructura_costos_clieprov() {
        return listEstructura_costos_clieprov;
    }

    /**
     * @param listEstructura_costos_clieprov the listEstructura_costos_clieprov to set
     */
    public void setListEstructura_costos_clieprov(List<Estructura_costos_clieprov> listEstructura_costos_clieprov) {
        this.listEstructura_costos_clieprov = listEstructura_costos_clieprov;
    }

    /**
     * @return the selectEstructura_costos_clieprov
     */
    public Estructura_costos_clieprov getSelectEstructura_costos_clieprov() {
        return selectEstructura_costos_clieprov;
    }

    /**
     * @param selectEstructura_costos_clieprov the selectEstructura_costos_clieprov to set
     */
    public void setSelectEstructura_costos_clieprov(Estructura_costos_clieprov selectEstructura_costos_clieprov) {
        this.selectEstructura_costos_clieprov = selectEstructura_costos_clieprov;
    }

    /**
     * @return the selectEstructura_costos
     */
    public Estructura_costos getSelectEstructura_costos() {
        return selectEstructura_costos;
    }

    /**
     * @param selectEstructura_costos the selectEstructura_costos to set
     */
    public void setSelectEstructura_costos(Estructura_costos selectEstructura_costos) {
        this.selectEstructura_costos = selectEstructura_costos;
    }

    /**
     * @return the selectDestructura_costos_recursos
     */
    public Destructura_costos_recursos getSelectDestructura_costos_recursos() {
        return selectDestructura_costos_recursos;
    }

    /**
     * @param selectDestructura_costos_recursos the selectDestructura_costos_recursos to set
     */
    public void setSelectDestructura_costos_recursos(Destructura_costos_recursos selectDestructura_costos_recursos) {
        this.selectDestructura_costos_recursos = selectDestructura_costos_recursos;
    }

    /**
     * @return the selectEstructura_costos_mano_obra
     */
    public Estructura_costos_mano_obra getSelectEstructura_costos_mano_obra() {
        return selectEstructura_costos_mano_obra;
    }

    /**
     * @param selectEstructura_costos_mano_obra the selectEstructura_costos_mano_obra to set
     */
    public void setSelectEstructura_costos_mano_obra(Estructura_costos_mano_obra selectEstructura_costos_mano_obra) {
        this.selectEstructura_costos_mano_obra = selectEstructura_costos_mano_obra;
    }

    /**
     * @return the estructura_costos_clieprovDao
     */
    public Estructura_costos_clieprovDao getEstructura_costos_clieprovDao() {
        return estructura_costos_clieprovDao;
    }

    /**
     * @param estructura_costos_clieprovDao the estructura_costos_clieprovDao to set
     */
    public void setEstructura_costos_clieprovDao(Estructura_costos_clieprovDao estructura_costos_clieprovDao) {
        this.estructura_costos_clieprovDao = estructura_costos_clieprovDao;
    }

    /**
     * @return the estructura_costosDao
     */
    public Estructura_costosDao getEstructura_costosDao() {
        return estructura_costosDao;
    }

    /**
     * @param estructura_costosDao the estructura_costosDao to set
     */
    public void setEstructura_costosDao(Estructura_costosDao estructura_costosDao) {
        this.estructura_costosDao = estructura_costosDao;
    }

    /**
     * @return the destructura_costos_recursosDao
     */
    public Destructura_costos_recursosDao getDestructura_costos_recursosDao() {
        return destructura_costos_recursosDao;
    }

    /**
     * @param destructura_costos_recursosDao the destructura_costos_recursosDao to set
     */
    public void setDestructura_costos_recursosDao(Destructura_costos_recursosDao destructura_costos_recursosDao) {
        this.destructura_costos_recursosDao = destructura_costos_recursosDao;
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
     * @return the listEstructura_costos
     */
    public List<Estructura_costos> getListEstructura_costos() {
        return listEstructura_costos;
    }

    /**
     * @param listEstructura_costos the listEstructura_costos to set
     */
    public void setListEstructura_costos(List<Estructura_costos> listEstructura_costos) {
        this.listEstructura_costos = listEstructura_costos;
    }

    /**
     * @return the listDestructura_costos_recursos
     */
    public List<Destructura_costos_recursos> getListDestructura_costos_recursos() {
        return listDestructura_costos_recursos;
    }

    /**
     * @param listDestructura_costos_recursos the listDestructura_costos_recursos to set
     */
    public void setListDestructura_costos_recursos(List<Destructura_costos_recursos> listDestructura_costos_recursos) {
        this.listDestructura_costos_recursos = listDestructura_costos_recursos;
    }

    /**
     * @return the listEstructura_costos_mano_obra
     */
    public List<Estructura_costos_mano_obra> getListEstructura_costos_mano_obra() {
        return listEstructura_costos_mano_obra;
    }

    /**
     * @param listEstructura_costos_mano_obra the listEstructura_costos_mano_obra to set
     */
    public void setListEstructura_costos_mano_obra(List<Estructura_costos_mano_obra> listEstructura_costos_mano_obra) {
        this.listEstructura_costos_mano_obra = listEstructura_costos_mano_obra;
    }

    /**
     * @return the indexTab
     */
    public int getIndexTab() {
        return indexTab;
    }

    /**
     * @param indexTab the indexTab to set
     */
    public void setIndexTab(int indexTab) {
        this.indexTab = indexTab;
    }

    /**
     * @return the tabView
     */
    public TabView getTabView() {
        return tabView;
    }

    /**
     * @param tabView the tabView to set
     */
    public void setTabView(TabView tabView) {
        this.tabView = tabView;
    }

    /**
     * @return the subtotal_ecosto
     */
    public Float getSubtotal_ecosto() {
        return subtotal_ecosto;
    }

    /**
     * @param subtotal_ecosto the subtotal_ecosto to set
     */
    public void setSubtotal_ecosto(Float subtotal_ecosto) {
        this.subtotal_ecosto = subtotal_ecosto;
    }

    /**
     * @return the go_ecosto
     */
    public Float getGo_ecosto() {
        return go_ecosto;
    }

    /**
     * @param go_ecosto the go_ecosto to set
     */
    public void setGo_ecosto(Float go_ecosto) {
        this.go_ecosto = go_ecosto;
    }

    /**
     * @return the ga_ecosto
     */
    public Float getGa_ecosto() {
        return ga_ecosto;
    }

    /**
     * @param ga_ecosto the ga_ecosto to set
     */
    public void setGa_ecosto(Float ga_ecosto) {
        this.ga_ecosto = ga_ecosto;
    }

    /**
     * @return the u_ecosto
     */
    public Float getU_ecosto() {
        return u_ecosto;
    }

    /**
     * @param u_ecosto the u_ecosto to set
     */
    public void setU_ecosto(Float u_ecosto) {
        this.u_ecosto = u_ecosto;
    }

    /**
     * @return the total_ecosto
     */
    public Float getTotal_ecosto() {
        return total_ecosto;
    }

    /**
     * @param total_ecosto the total_ecosto to set
     */
    public void setTotal_ecosto(Float total_ecosto) {
        this.total_ecosto = total_ecosto;
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
     * @return the wtiposervicioDao
     */
    public WtiposervicioDao getWtiposervicioDao() {
        return wtiposervicioDao;
    }

    /**
     * @param wtiposervicioDao the wtiposervicioDao to set
     */
    public void setWtiposervicioDao(WtiposervicioDao wtiposervicioDao) {
        this.wtiposervicioDao = wtiposervicioDao;
    }

    /**
     * @return the selectContactosClieprov
     */
    public Contactosclieprov getSelectContactosClieprov() {
        return selectContactosClieprov;
    }

    /**
     * @param selectContactosClieprov the selectContactosClieprov to set
     */
    public void setSelectContactosClieprov(Contactosclieprov selectContactosClieprov) {
        this.selectContactosClieprov = selectContactosClieprov;
    }

    @Override
    public JRDataSource getDataSourceReport() {
        NSRResultSet rs;
        try {
            //cabecera -> ¨parametro
            rs = cotizacionventasDao.getConsultaRepote(user.getIDEMPRESA(), getDatoEdicion().getIdcotizacionv());
            return new NSRDataSource(rs);
        } catch (NisiraORMException e) {
            WebUtil.MensajeError(e.getMessage());
        }
        return null;
    }
    
    @Override
    public JRDataSource getDataSourceReport_lst() {
        NSRResultSet rs;
        try {
            //cabecera -> ¨parametro
            rs = cotizacionventasDao.getConsultaRepote(user.getIDEMPRESA(), getSelectCotizacionventas_local().getIdcotizacionv());
            return new NSRDataSource(rs);
        } catch (NisiraORMException e) {
            WebUtil.MensajeError(e.getMessage());
        }
        return null;
    }

    /**
     * @return the listDestructura_costos_recursos_cotizacionventas
     */
    public List<Destructura_costos_recursos_cotizacionventas> getListDestructura_costos_recursos_cotizacionventas() {
        return listDestructura_costos_recursos_cotizacionventas;
    }

    /**
     * @param listDestructura_costos_recursos_cotizacionventas the listDestructura_costos_recursos_cotizacionventas to set
     */
    public void setListDestructura_costos_recursos_cotizacionventas(List<Destructura_costos_recursos_cotizacionventas> listDestructura_costos_recursos_cotizacionventas) {
        this.listDestructura_costos_recursos_cotizacionventas = listDestructura_costos_recursos_cotizacionventas;
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
     * @return the destructura_costos_recursos_cotizacionventasDao
     */
    public Destructura_costos_recursos_cotizacionventasDao getDestructura_costos_recursos_cotizacionventasDao() {
        return destructura_costos_recursos_cotizacionventasDao;
    }

    /**
     * @param destructura_costos_recursos_cotizacionventasDao the destructura_costos_recursos_cotizacionventasDao to set
     */
    public void setDestructura_costos_recursos_cotizacionventasDao(Destructura_costos_recursos_cotizacionventasDao destructura_costos_recursos_cotizacionventasDao) {
        this.destructura_costos_recursos_cotizacionventasDao = destructura_costos_recursos_cotizacionventasDao;
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
     * @return the selectDestructura_costos_recursos_cotizacionventas
     */
    public Destructura_costos_recursos_cotizacionventas getSelectDestructura_costos_recursos_cotizacionventas() {
        return selectDestructura_costos_recursos_cotizacionventas;
    }

    /**
     * @param selectDestructura_costos_recursos_cotizacionventas the selectDestructura_costos_recursos_cotizacionventas to set
     */
    public void setSelectDestructura_costos_recursos_cotizacionventas(Destructura_costos_recursos_cotizacionventas selectDestructura_costos_recursos_cotizacionventas) {
        this.selectDestructura_costos_recursos_cotizacionventas = selectDestructura_costos_recursos_cotizacionventas;
    }

    /**
     * @return the selectEstructura_costos_mano_obra_cotizacionventas
     */
    public Estructura_costos_mano_obra_cotizacionventas getSelectEstructura_costos_mano_obra_cotizacionventas() {
        return selectEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @param selectEstructura_costos_mano_obra_cotizacionventas the selectEstructura_costos_mano_obra_cotizacionventas to set
     */
    public void setSelectEstructura_costos_mano_obra_cotizacionventas(Estructura_costos_mano_obra_cotizacionventas selectEstructura_costos_mano_obra_cotizacionventas) {
        this.selectEstructura_costos_mano_obra_cotizacionventas = selectEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @return the destructura_costos_recursos_cotizacionventas
     */
    public Destructura_costos_recursos_cotizacionventas getDestructura_costos_recursos_cotizacionventas() {
        return destructura_costos_recursos_cotizacionventas;
    }

    /**
     * @param destructura_costos_recursos_cotizacionventas the destructura_costos_recursos_cotizacionventas to set
     */
    public void setDestructura_costos_recursos_cotizacionventas(Destructura_costos_recursos_cotizacionventas destructura_costos_recursos_cotizacionventas) {
        this.destructura_costos_recursos_cotizacionventas = destructura_costos_recursos_cotizacionventas;
    }

    /**
     * @return the estructura_costos_mano_obra_cotizacionventas
     */
    public Estructura_costos_mano_obra_cotizacionventas getEstructura_costos_mano_obra_cotizacionventas() {
        return estructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @param estructura_costos_mano_obra_cotizacionventas the estructura_costos_mano_obra_cotizacionventas to set
     */
    public void setEstructura_costos_mano_obra_cotizacionventas(Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra_cotizacionventas) {
        this.estructura_costos_mano_obra_cotizacionventas = estructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @return the botonNuevoDestructura_costos_recurso
     */
    public boolean isBotonNuevoDestructura_costos_recurso() {
        return botonNuevoDestructura_costos_recurso;
    }

    /**
     * @param botonNuevoDestructura_costos_recurso the botonNuevoDestructura_costos_recurso to set
     */
    public void setBotonNuevoDestructura_costos_recurso(boolean botonNuevoDestructura_costos_recurso) {
        this.botonNuevoDestructura_costos_recurso = botonNuevoDestructura_costos_recurso;
    }

    /**
     * @return the botonEditarDestructura_costos_recurso
     */
    public boolean isBotonEditarDestructura_costos_recurso() {
        return botonEditarDestructura_costos_recurso;
    }

    /**
     * @param botonEditarDestructura_costos_recurso the botonEditarDestructura_costos_recurso to set
     */
    public void setBotonEditarDestructura_costos_recurso(boolean botonEditarDestructura_costos_recurso) {
        this.botonEditarDestructura_costos_recurso = botonEditarDestructura_costos_recurso;
    }

    /**
     * @return the botonEliminarDestructura_costos_recurso
     */
    public boolean isBotonEliminarDestructura_costos_recurso() {
        return botonEliminarDestructura_costos_recurso;
    }

    /**
     * @param botonEliminarDestructura_costos_recurso the botonEliminarDestructura_costos_recurso to set
     */
    public void setBotonEliminarDestructura_costos_recurso(boolean botonEliminarDestructura_costos_recurso) {
        this.botonEliminarDestructura_costos_recurso = botonEliminarDestructura_costos_recurso;
    }

    /**
     * @return the botonNuevoEstructura_costos_mano_obra
     */
    public boolean isBotonNuevoEstructura_costos_mano_obra() {
        return botonNuevoEstructura_costos_mano_obra;
    }

    /**
     * @param botonNuevoEstructura_costos_mano_obra the botonNuevoEstructura_costos_mano_obra to set
     */
    public void setBotonNuevoEstructura_costos_mano_obra(boolean botonNuevoEstructura_costos_mano_obra) {
        this.botonNuevoEstructura_costos_mano_obra = botonNuevoEstructura_costos_mano_obra;
    }

    /**
     * @return the botonEditarEstructura_costos_mano_obra
     */
    public boolean isBotonEditarEstructura_costos_mano_obra() {
        return botonEditarEstructura_costos_mano_obra;
    }

    /**
     * @param botonEditarEstructura_costos_mano_obra the botonEditarEstructura_costos_mano_obra to set
     */
    public void setBotonEditarEstructura_costos_mano_obra(boolean botonEditarEstructura_costos_mano_obra) {
        this.botonEditarEstructura_costos_mano_obra = botonEditarEstructura_costos_mano_obra;
    }

    /**
     * @return the botonEliminarEstructura_costos_mano_obra
     */
    public boolean isBotonEliminarEstructura_costos_mano_obra() {
        return botonEliminarEstructura_costos_mano_obra;
    }

    /**
     * @param botonEliminarEstructura_costos_mano_obra the botonEliminarEstructura_costos_mano_obra to set
     */
    public void setBotonEliminarEstructura_costos_mano_obra(boolean botonEliminarEstructura_costos_mano_obra) {
        this.botonEliminarEstructura_costos_mano_obra = botonEliminarEstructura_costos_mano_obra;
    }

    /**
     * @return the lstTipoRecurso
     */
    public List<String> getLstTipoRecurso() {
        return lstTipoRecurso;
    }

    /**
     * @param lstTipoRecurso the lstTipoRecurso to set
     */
    public void setLstTipoRecurso(List<String> lstTipoRecurso) {
        this.lstTipoRecurso = lstTipoRecurso;
    }

    /**
     * @return the lstEs_porcentaje
     */
    public List<Es_PorcentajeCombo> getLstEs_porcentaje() {
        return lstEs_porcentaje;
    }

    /**
     * @param lstEs_porcentaje the lstEs_porcentaje to set
     */
    public void setLstEs_porcentaje(List<Es_PorcentajeCombo> lstEs_porcentaje) {
        this.lstEs_porcentaje = lstEs_porcentaje;
    }

    /**
     * @return the periodoDisenio
     */
    public String getPeriodoDisenio() {
        return periodoDisenio;
    }

    /**
     * @param periodoDisenio the periodoDisenio to set
     */
    public void setPeriodoDisenio(String periodoDisenio) {
        this.periodoDisenio = periodoDisenio;
    }

    /**
     * @return the mesNumeroDisenio
     */
    public String getMesNumeroDisenio() {
        return mesNumeroDisenio;
    }

    /**
     * @param mesNumeroDisenio the mesNumeroDisenio to set
     */
    public void setMesNumeroDisenio(String mesNumeroDisenio) {
        this.mesNumeroDisenio = mesNumeroDisenio;
    }

    /**
     * @return the mesNombreDisenio
     */
    public String getMesNombreDisenio() {
        return mesNombreDisenio;
    }

    /**
     * @param mesNombreDisenio the mesNombreDisenio to set
     */
    public void setMesNombreDisenio(String mesNombreDisenio) {
        this.mesNombreDisenio = mesNombreDisenio;
    }

    /**
     * @return the listTotalDestructura_costos_recursos_cotizacionventas
     */
    public List<Destructura_costos_recursos_cotizacionventas> getListTotalDestructura_costos_recursos_cotizacionventas() {
        return listTotalDestructura_costos_recursos_cotizacionventas;
    }

    /**
     * @param listTotalDestructura_costos_recursos_cotizacionventas the listTotalDestructura_costos_recursos_cotizacionventas to set
     */
    public void setListTotalDestructura_costos_recursos_cotizacionventas(List<Destructura_costos_recursos_cotizacionventas> listTotalDestructura_costos_recursos_cotizacionventas) {
        this.listTotalDestructura_costos_recursos_cotizacionventas = listTotalDestructura_costos_recursos_cotizacionventas;
    }

    /**
     * @return the listTotalEstructura_costos_mano_obra_cotizacionventas
     */
    public List<Estructura_costos_mano_obra_cotizacionventas> getListTotalEstructura_costos_mano_obra_cotizacionventas() {
        return listTotalEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @param listTotalEstructura_costos_mano_obra_cotizacionventas the listTotalEstructura_costos_mano_obra_cotizacionventas to set
     */
    public void setListTotalEstructura_costos_mano_obra_cotizacionventas(List<Estructura_costos_mano_obra_cotizacionventas> listTotalEstructura_costos_mano_obra_cotizacionventas) {
        this.listTotalEstructura_costos_mano_obra_cotizacionventas = listTotalEstructura_costos_mano_obra_cotizacionventas;
    }

    /**
     * @return the caculate_hora
     */
    public boolean isCaculate_hora() {
        return caculate_hora;
    }

    /**
     * @param caculate_hora the caculate_hora to set
     */
    public void setCaculate_hora(boolean caculate_hora) {
        this.caculate_hora = caculate_hora;
    }

    /**
     * @return the selectEstructura_costos_producto
     */
    public Estructura_costos_producto getSelectEstructura_costos_producto() {
        return selectEstructura_costos_producto;
    }

    /**
     * @param selectEstructura_costos_producto the selectEstructura_costos_producto to set
     */
    public void setSelectEstructura_costos_producto(Estructura_costos_producto selectEstructura_costos_producto) {
        this.selectEstructura_costos_producto = selectEstructura_costos_producto;
    }

    /**
     * @return the ajuste_ecosto
     */
    public Float getAjuste_ecosto() {
        return ajuste_ecosto;
    }

    /**
     * @param ajuste_ecosto the ajuste_ecosto to set
     */
    public void setAjuste_ecosto(Float ajuste_ecosto) {
        this.ajuste_ecosto = ajuste_ecosto;
    }

    /**
     * @return the selectCotizacionventas_local
     */
    public Cotizacionventas getSelectCotizacionventas_local() {
        return selectCotizacionventas_local;
    }

    /**
     * @param selectCotizacionventas_local the selectCotizacionventas_local to set
     */
    public void setSelectCotizacionventas_local(Cotizacionventas selectCotizacionventas_local) {
        this.selectCotizacionventas_local = selectCotizacionventas_local;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public class Es_PorcentajeCombo{
        private int id;
        private String descripcion;
        public Es_PorcentajeCombo(int key,String value){
            this.id=key;
            this.descripcion=value;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @param descripcion the descripcion to set
         */
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}

//    public void valorProducto_Estructura_costos(SelectEvent event) {
//        try {
//            this.setSelectEstructura_costos_producto((Estructura_costos_producto) event.getObject());
//            getDcotizacionventas().setIdproducto(selectEstructura_costos_producto.getIdproducto());
//            getDcotizacionventas().setProducto(selectEstructura_costos_producto.getDescripcion());
//            getDcotizacionventas().setDescripcion(selectEstructura_costos_producto.getDescripcion());
//            getDcotizacionventas().setIdmedida(selectEstructura_costos_producto.getIdmedida());
//            getDcotizacionventas().setImporte_isc(selectEstructura_costos_producto.getAjuste());
//            /************ CONSULTAR PRECIOS ,IGV  ****************/
//            ArrayList<Object> arrayObject = productoDao.returnImpuestoxproducto(user.getIDEMPRESA(), 
//                    getDcotizacionventas().getIdproducto(),WebUtil.SimpleDateFormatN1(getDatoEdicion().getFecha()));
//            /******************************************************/
//            BigDecimal total_ec=new BigDecimal(0.0f);
//            BigDecimal subtotal_ec=new BigDecimal(0.0f);
//            BigDecimal go_ec=new BigDecimal(0.0f);
//            BigDecimal ga_ec=new BigDecimal(0.0f);
//            BigDecimal u_ec=new BigDecimal(0.0f);
//            BigDecimal total_porcentaje=new BigDecimal(0.0f);
//            if(selectEstructura_costos_clieprov!=null){
//                if(selectEstructura_costos_producto!=null){
//                    List<Destructura_costos_recursos> lst=destructura_costos_recursosDao.listarPorEmpresaWebXProducto(selectEstructura_costos_producto.getIdempresa(), selectEstructura_costos_producto.getCodigo(),
//                            selectEstructura_costos_producto.getIdproducto(),selectEstructura_costos_producto.getItem());
//                    if(!lst.isEmpty()){
//                        /*CÁLCULO SUBTOTAL*/
//                        for(Destructura_costos_recursos o :lst){
//                            if(o.getEs_porcentaje()==0.0f){
//                                subtotal_ec=subtotal_ec.add((new BigDecimal(o.getCosto())));
//                            }
//                        }
//                        /*CÁLCULO PORCENTAJE*/
//                        BigDecimal cien = new BigDecimal(100);
//                        BigDecimal o_getcantidad= new BigDecimal(0);
//                        for(Destructura_costos_recursos o :lst){
//                            if(o.getEs_porcentaje()==1.0f){
//                                switch(o.getDescripcion().trim().toUpperCase()){
//                                    case "GO":
//                                        o_getcantidad = new BigDecimal(o.getCantidad());
//                                        go_ec=go_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
//                                        break;
//                                    case "GA":
//                                        o_getcantidad = new BigDecimal(o.getCantidad());
//                                        ga_ec=ga_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
//                                        break;
//                                    case "U":
//                                        o_getcantidad = new BigDecimal(o.getCantidad());
//                                        u_ec=u_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
//                                        break;
//                                }
//                                total_porcentaje = total_porcentaje.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
//                            }
//                        }
//                        total_ec=total_ec.add(subtotal_ec.add(total_porcentaje));
//                        total_ec=total_ec.add(new BigDecimal(selectEstructura_costos_producto.getAjuste()));
//                    }
//                    else{
//                        total_ec = new BigDecimal(0.0f);
//                    }
//                }else{
//                    mensaje = "Producto : Definir Estructura - Costos";
//                    WebUtil.MensajeFatal(mensaje); 
//                }
//
//            }else{
//                mensaje = "Clieprov : Definir Estructura - Costos";
//                WebUtil.MensajeFatal(mensaje);
//            }
//            getDcotizacionventas().setPrecio(total_ec.floatValue());
//            getDcotizacionventas().setImpuesto_i(0.0f);
////            getDcotizacionventas().setImpuesto_i(((Double)arrayObject.get(2)).floatValue());
////                if(!arrayObject.isEmpty()){
////                    getDcotizacionventas().setImpuesto_i(((Double)arrayObject.get(2)).floatValue());
////                }else{
////                    getDcotizacionventas().setImpuesto_i(0.0f);
////                }
//            /********* CÁLCULOS *********/
//            BigDecimal Descuento = new BigDecimal(getDcotizacionventas().getDescuento());
//            BigDecimal Impuesto_i=new BigDecimal(getDcotizacionventas().getImpuesto_i());
//            BigDecimal Precio=new BigDecimal(getDcotizacionventas().getPrecio());
//            BigDecimal Cantidad=new BigDecimal(getDcotizacionventas().getCantidad());
//            BigDecimal Impuesto = Impuesto_i.divide(new BigDecimal(100),3, RoundingMode.CEILING);
//            Impuesto = Impuesto.multiply(Precio).multiply(Cantidad);
//            BigDecimal importe= new BigDecimal(0.0f);
//            importe = importe.add(Precio.multiply(Cantidad));
//            importe = importe.subtract(Descuento);
//            importe = importe.add(Impuesto);
//            getDcotizacionventas().setImpuesto(Impuesto.floatValue());
//            getDcotizacionventas().setImporte(importe.floatValue());
////            getDcotizacionventas().setImpuesto((getDcotizacionventas().getImpuesto_i()/100)*getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad());
////            getDcotizacionventas().setImporte((getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad())-
////                    getDcotizacionventas().getDescuento()+getDcotizacionventas().getImpuesto());
//            
//        } catch (NisiraORMException ex) {
//            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//public void calcularDetalleTotal(){
//        BigDecimal subtotalsindscto = new BigDecimal(0.0f);
//        BigDecimal descuento = new BigDecimal(getDcotizacionventas().getDescuento());
//        BigDecimal impuesto = new BigDecimal(0.0f);
//        BigDecimal importe = new BigDecimal(0.0f);
//        
//        BigDecimal Cantidad=new BigDecimal(getDcotizacionventas().getCantidad());
//        BigDecimal Precio=new BigDecimal(getDcotizacionventas().getPrecio());
//        
//        subtotalsindscto = subtotalsindscto.add(Cantidad.multiply(Precio));
//        impuesto = subtotalsindscto.multiply(new BigDecimal(getDcotizacionventas().getImpuesto_i()).divide(new BigDecimal(100), 3, RoundingMode.CEILING));
//        importe = importe.add(subtotalsindscto);
//        importe = importe.subtract(descuento);
//        importe = importe.add(impuesto);
//        
//        getDcotizacionventas().setImpuesto(impuesto.floatValue());
//        getDcotizacionventas().setImporte(importe.floatValue());
//    }