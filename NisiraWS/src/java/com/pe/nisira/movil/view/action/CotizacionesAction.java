/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.ProductoDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TcambioDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Forma_pago;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.entity.Sucursales;
import com.nisira.core.entity.Tcambio;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.ManejadorFechas;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "cotizacionventasAction")
@SessionScoped
public class CotizacionesAction extends AbstactListAction<Cotizacionventas> {
    /*********************************LISTAS*******************************************/
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
    /*************************************ENTITY***************************************/
    private Dcotizacionventas dcotizacionventas;
    private Dcotizacionventas selectdcotizacionventas; 
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    private Producto selectProducto;
    private Forma_pago selectForma_pago;
    private Sucursales selectSucursales;
    private Almacen selectAlmacen;
    /**********************************CONTROLADOR********************************/
    private boolean botonEditarDcotizacionventas;
    private boolean botonEliminarDcotizacionventas;    
    private String periodoBase;
    private String periodoDisenio;
    private String mesNumeroDisenio;
    private String mesNombreDisenio;
    private Date fecha_ini;//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
    private Date fecha_fin;//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
    public CotizacionesAction() {
        /*****************CONFIGURACION****************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        /**********************************CONTROLADOR********************************/
        botonEditarDcotizacionventas=true;
        botonEliminarDcotizacionventas=true;
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
        /********************ENTITY****************/
        setDcotizacionventas(new Dcotizacionventas());
        /********************ARRAY****************/
        lstdcotizacionventas = new ArrayList<Dcotizacionventas>();
        listDocumentos = new ArrayList<Documentos>();
        listNumemisor = new ArrayList<Numemisor>();
        listEstado = new ArrayList<Estados>();
        listClieprov = new ArrayList<Clieprov>();
        listMultitabla = new ArrayList<Multitabla>();
        listMoneda = new ArrayList<>();        
        /***********************************************/
        fecha_ini = new Date();
        fecha_fin = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        periodoBase=dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
        periodoDisenio=dateFormat.format(new Date());
        mesNumeroDisenio=WebUtil.idGeneradoDos((new Date()).getMonth()+1);
        mesNombreDisenio=WebUtil.strMonths[(new Date()).getMonth()];
        try {
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
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
            /*********************************DAO*******************************************/
            setLstdcotizacionventas(new ArrayList<Dcotizacionventas>());
            setDocDao(new DocumentosDao());
            setNumemisorDao(new NumemisorDao());
            setClieprovDao(new ClieprovDao());
            setEstadosDao(new EstadosDao());
            sucursalesDao = new SucursalesDao();
            /**********************************CONFIGURACION********************************/
            lista_solution=CoreUtil.valoresBase();
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listMoneda = monedasDao.getListMonedasWeb();
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
        if (getDatoEdicion().getIdclieprov().isEmpty() & getDatoEdicion().getRazon_social().isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Cliente");
            return false;
        }
        if (getLstdcotizacionventas().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle de cotización");
            return false;
        }
        return true;
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                getDatoEdicion().setNumero(numero);
                getDatoEdicion().setPeriodo(periodoBase);
                if(getLadd()==1){
                    mensaje=getCotizacionventasDao().grabar(1, getDatoEdicion(), getLstdcotizacionventas(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcotizacionv(mensaje.trim());
                }
                else{
                    mensaje=getCotizacionventasDao().grabar(2, getDatoEdicion(), getLstdcotizacionventas(),user.getIDUSUARIO());
                }
                setMensaje(WebUtil.exitoRegistrar("Cotización Venta ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos");
                //RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }
    @Override
    public void eliminar() {
        try {
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                getDatoEdicion().setEstado(0);
//            }
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
//                getDatoEdicion().setEstado(2);
//            }
            /*Cambiado - 23-08-2016*/
        } catch (Exception ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findetalle() throws Exception {
        try{
            if(getLadd()==2){/*EDITAR*/
                periodoBase=getDatoEdicion().getPeriodo();
                periodoDisenio=getDatoEdicion().getPeriodo().substring(0, 4);
                mesNumeroDisenio=getDatoEdicion().getPeriodo().substring(4);
                mesNombreDisenio=WebUtil.strMonths[Integer.parseInt(getDatoEdicion().getPeriodo().substring(4))-1];
                getDatoEdicion().setPeriodo(periodoDisenio);
                getDatoEdicion().setMes(mesNombreDisenio);
            }
            listDocumentos=docDao.getCotizacionVenta(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),"edt_cotizacionventa");
            lstdcotizacionventas = dcotizacionventasDao.getListDCotizacionWeb(user.getIDEMPRESA(),getDatoEdicion().getIdcotizacionv());
            listMoneda = monedasDao.getListMonedasWeb();
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
        }catch(Exception ex){
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
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
    public void onRowSelectDordenservicio(SelectEvent event) throws IOException {
        setBotonEditarDcotizacionventas(false);
        setBotonEliminarDcotizacionventas(false);
        RequestContext.getCurrentInstance().update("datos:lstdcotizacionventas");
    }
    /*** responsable ***/
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazon_social(selectClieprov.getRazonsocial());
    }
    public void verCntProducto() {
        RequestContext.getCurrentInstance().openDialog("cntProducto", modalOptions, null);
    }
    public void valorProducto(SelectEvent event) {
        try {
            this.setSelectProducto((Producto) event.getObject());
            getDcotizacionventas().setIdproducto(selectProducto.getIdproducto());
            getDcotizacionventas().setProducto(selectProducto.getDescripcion());
            getDcotizacionventas().setDescripcion(selectProducto.getDescripcion());
            getDcotizacionventas().setIdmedida(selectProducto.getIdmedida());
            /************ CONSULTAR PRECIOS ,IGV  ****************/
            ArrayList<Double> arrayDouble = new ArrayList<>();
//                    productoDao.precioVenta(user.getIDEMPRESA(), getDatoEdicion().getIdsucursal(), getDcotizacionventas().getIdproducto(),
//                    getDatoEdicion().getIdmoneda(),WebUtil.SimpleDateFormatN1(getDatoEdicion().getFecha()));
            ArrayList<Object> arrayObject = productoDao.returnImpuestoxproducto(user.getIDEMPRESA(), 
                    getDcotizacionventas().getIdproducto(),WebUtil.SimpleDateFormatN1(getDatoEdicion().getFecha()));
            /******************************************************/
            if(!arrayDouble.isEmpty()){
                getDcotizacionventas().setPrecio(arrayDouble.get(0).floatValue());
            }else{
                getDcotizacionventas().setPrecio(0.0f);
            }
            if(!arrayObject.isEmpty()){
                getDcotizacionventas().setImpuesto_i(((Double)arrayObject.get(2)).floatValue());
            }else{
                getDcotizacionventas().setImpuesto_i(0.0f);
            }
            /********* CÁLCULOS *********/
            getDcotizacionventas().setImpuesto((getDcotizacionventas().getImpuesto_i()/100)*getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad());
            getDcotizacionventas().setImporte((getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad())-
                    getDcotizacionventas().getDescuento()+getDcotizacionventas().getImpuesto());
            
        } catch (NisiraORMException ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return;
    }
    public void nuevoDcotizacionventas() {
        setDcotizacionventas(new Dcotizacionventas());
        getDcotizacionventas().setIdempresa(user.getIDEMPRESA());
        getDcotizacionventas().setIdcotizacionv(getDatoEdicion().getIdcotizacionv());
        getDcotizacionventas().setItem(agregarItemDcotizacionventa());
        getDcotizacionventas().setPrecio(0.0f);
        getDcotizacionventas().setCantidad(1.0f);
        getDcotizacionventas().setDescuento(0.0f);
        getDcotizacionventas().setImpuesto(0.0f);
        getDcotizacionventas().setImporte(0.0f);
        getDcotizacionventas().setFechacreacion(getDatoEdicion().getFecha());
        getDcotizacionventas().setObservaciones("");
        RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
    }
    public void editarDcotizacionventas() {
        setDcotizacionventas(selectdcotizacionventas);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
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
            lstdcotizacionventas.remove(selectdcotizacionventas);
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarDcotizacionventa(){
        int pos=lstdcotizacionventas.indexOf(dcotizacionventas);
        /***********CALCULOS*************/
        getDcotizacionventas().setImpuesto((getDcotizacionventas().getImpuesto_i()/100)*getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad());
        getDcotizacionventas().setImporte((getDcotizacionventas().getPrecio()*getDcotizacionventas().getCantidad())-
                getDcotizacionventas().getDescuento()+getDcotizacionventas().getImpuesto());
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
            subtotalsindscto +=obj.getCantidad()*obj.getPrecio();
            descuento+=obj.getDescuento();
            impuesto+=obj.getImpuesto();
            importe+=(obj.getCantidad()*obj.getPrecio())-obj.getDescuento()+obj.getImpuesto();
        }
        getDatoEdicion().setSubtotalsindscto(subtotalsindscto.floatValue());
        getDatoEdicion().setDescuento(descuento.floatValue());
        getDatoEdicion().setImpuesto(impuesto.floatValue());
        getDatoEdicion().setImporte(importe.floatValue());
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
//            if (f_ini.length() == 8 && f_fin.length() == 8) {
//                f_ini = f_ini.substring(4) + f_ini.substring(2, 4) + f_ini.substring(0, 2);
//                f_fin = f_fin.substring(4) + f_fin.substring(2, 4) + f_fin.substring(0, 2);
//            } else {
//                f_ini = "";
//                f_fin = "";
//            }
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
    public String buscarFiltro(){
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
//            if (f_ini.length() == 8 && f_fin.length() == 8) {
//                f_ini = f_ini.substring(4) + f_ini.substring(2, 4) + f_ini.substring(0, 2);
//                f_fin = f_fin.substring(4) + f_fin.substring(2, 4) + f_fin.substring(0, 2);
//            } else {
//                f_ini = "";
//                f_fin = "";
//            }
            setListaDatos(getCotizacionventasDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            //   filtrar();
            RequestContext.getCurrentInstance().update("datos:tbl");
//            RequestContext.getCurrentInstance().execute("javascript:location.reload()");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
//        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tbl");
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
}