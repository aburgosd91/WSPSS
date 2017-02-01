/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TcambioDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tcambio;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "ordenliquidaciongastoAction")
@SessionScoped
public class OrdenliquidaciongastoAction extends AbstactListAction<Ordenliquidaciongasto> {
    private boolean botonEditarDOrdenliquidaciongasto;
    private boolean botonEliminarDOrdenliquidaciongasto;
    /*********************************LISTAS*******************************************/
    private List<Clieprov> listClieprov;
    private List<Documentos> listDocumentos;
    private List<Numemisor> listNumemisor;
    private List<Dordenliquidaciongasto> lstdordenliquidaciongasto;
    private List<Estados> listEstado;
    /*************************************DAO***************************************/
    private OrdenliquidaciongastoDao ordenliquidaciongastoDao;
    private DordenliquidaciongastoDao dordenliquidaciongastoDao;
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private ClieprovDao clieprovDao;
    private EstadosDao estadosDao;
    private EmisorDao emisorDao;
    private TcambioDao tcambioDao;
    private MonedasDao monedasDao;
    private SucursalesDao sucursalesDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    private Consumidor selectConsumidor;
    private Dordenliquidaciongasto dordenliquidaciongasto;
    private Dordenliquidaciongasto selectDordenliquidaciongasto;
    private Clieprov selectClieprovPersonal;
    private Concepto_cuenta selectConcepto_cuenta;
    private Destinoadquisicion selectDestinoadquisicion;
    private ArrayList<String> lista_solution;
    public OrdenliquidaciongastoAction() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        dordenliquidaciongasto = new Dordenliquidaciongasto();
        /*********************************LISTAS*******************************************/
        lstdordenliquidaciongasto = new ArrayList<Dordenliquidaciongasto>();
        listDocumentos = new ArrayList<Documentos>();
        listNumemisor = new ArrayList<Numemisor>();
        listEstado = new ArrayList<Estados>();
        listClieprov = new ArrayList<Clieprov>();
        /*********************************DAO*******************************************/
        ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
        docDao = new DocumentosDao();
        numemisorDao = new NumemisorDao();
        clieprovDao = new ClieprovDao();
        dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
        emisorDao= new EmisorDao();
        tcambioDao=new TcambioDao();
        monedasDao=new MonedasDao();
        sucursalesDao=new SucursalesDao();
        /**********************************CONTROLADOR********************************/
        botonEditarDOrdenliquidaciongasto=true;
        botonEliminarDOrdenliquidaciongasto=true;
        actualiza_ventana("wMnt_Ordenliquidaciongasto");
    }
    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(getOrdenliquidaciongastoDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************LISTAS*******************************************/
        setLstdordenliquidaciongasto(new ArrayList<Dordenliquidaciongasto>());
        setListDocumentos(new ArrayList<Documentos>());
        setListNumemisor(new ArrayList<Numemisor>());
        setListEstado(new ArrayList<Estados>());
        setListClieprov(new ArrayList<Clieprov>());
        /*********************************DAO*******************************************/
        setOrdenliquidaciongastoDao(new OrdenliquidaciongastoDao());
        setDocDao(new DocumentosDao());
        setNumemisorDao(new NumemisorDao());
        setClieprovDao(new ClieprovDao());
        setEstadosDao(new EstadosDao());
        sucursalesDao = new SucursalesDao();
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        /**********************************CONTROLADOR********************************/
        botonEditarDOrdenliquidaciongasto=true;
        botonEliminarDOrdenliquidaciongasto=true;
        /**********************************CONFIGURACION********************************/
        lista_solution=CoreUtil.valoresBase();
        actualiza_ventana("wMnt_Ordenliquidaciongasto");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Ordenliquidaciongasto());
        getDatoEdicion().setFecha(new Date());
        getDatoEdicion().setFecharegistro(new Date());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setIdemisor(lista_solution.get(5));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        getDatoEdicion().setPeriodo(dateFormat.format(new Date()));
        getDatoEdicion().setMes(WebUtil.strMonths[(new Date()).getMonth()]);
        getDatoEdicion().setIdsucursal(Constantes.IDSUCURSALGENERAL);
        getDatoEdicion().setVventa(0.0f);
        getDatoEdicion().setImpuesto(0.0f);
        getDatoEdicion().setImporte(0.0f);
        try {
            /*CONSULTAS A BD*/
            String sucursal = sucursalesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
            getDatoEdicion().setSucursal(sucursal);
            String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
            getDatoEdicion().setEmisor(emisor);
            List<Monedas> listMoneda = monedasDao.getListMonedasWeb();
            if(!listMoneda.isEmpty()){
                Monedas monedas = listMoneda.get(0);
                getDatoEdicion().setIdmoneda(monedas.getIdmoneda());
                getDatoEdicion().setMoneda(monedas.getDescripcion());
            }
            Tcambio tcambio=tcambioDao.getPorFecha(getDatoEdicion().getFecha());
            if(tcambio!=null)getDatoEdicion().setTcambio(tcambio.getT_compra());
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean esVistaValida() {
        if (getDatoEdicion().getIdclieprov().isEmpty() & getDatoEdicion().getRazonsocial().isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Cliente");
            return false;
        }
        if (getLstdordenliquidaciongasto().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle de servicio");
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
                if(getLadd()==1)
                    mensaje=getOrdenliquidaciongastoDao().grabar(1, getDatoEdicion(), getLstdordenliquidaciongasto());
                else
                    mensaje=getOrdenliquidaciongastoDao().grabar(2, getDatoEdicion(), getLstdordenliquidaciongasto());
                setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos");
                //RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
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
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setIdestado("AN");
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setIdestado("CR");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findetalle() throws Exception {
        try{
            listDocumentos=docDao.getOrdenServicio(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),listDocumentos.get(0).getIddocumento());
            lstdordenliquidaciongasto = dordenliquidaciongastoDao.listarPorOrdenliquidaciongastoWeb(user.getIDEMPRESA(),getDatoEdicion().getIdorden());
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }catch(Exception ex){
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
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

    /*** responsable ***/
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonal", modalOptions, null);
    }
    /*** detalle ***/
    public void verCntClieprovDetalle() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void verCntConcepto_cuenta() {
        RequestContext.getCurrentInstance().openDialog("cntConcepto_cuenta", modalOptions, null);
    }
    public void verCntDestinoadquisicion() {
        RequestContext.getCurrentInstance().openDialog("cntDestinoadquisicion", modalOptions, null);
    }
    
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazonsocial(selectClieprov.getRazonsocial());
    }
    public void valorClieprovDetalle(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDordenliquidaciongasto().setIdclieprov(selectClieprov.getIdclieprov());
        getDordenliquidaciongasto().setRazonsocial(selectClieprov.getRazonsocial());
        getDordenliquidaciongasto().setDocumento(selectClieprov.getRuc());
    }
    public void valorConcepto_cuenta(SelectEvent event) {
        this.selectConcepto_cuenta = (Concepto_cuenta) event.getObject();
        getDordenliquidaciongasto().setIdconcepto(selectConcepto_cuenta.getIdconcepto());
        getDordenliquidaciongasto().setConceptocuenta(selectConcepto_cuenta.getDescripcion());
    }
    public void valorDestinoadquisicion(SelectEvent event) {
        this.selectDestinoadquisicion = (Destinoadquisicion) event.getObject();
        getDordenliquidaciongasto().setIddestino(selectDestinoadquisicion.getIddestino());
        getDordenliquidaciongasto().setDestinoadquisicion(selectDestinoadquisicion.getDescripcion());
    }
    public void grabarDordenliquidaciongasto(){
        int pos=lstdordenliquidaciongasto.indexOf(dordenliquidaciongasto);
        if(pos==-1)
            lstdordenliquidaciongasto.add(dordenliquidaciongasto);
        else 
            lstdordenliquidaciongasto.set(pos, dordenliquidaciongasto);
        RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').hide()");
    }
    public void nuevoDordenliquidaciongasto() {
        setDordenliquidaciongasto(new Dordenliquidaciongasto());
        getDordenliquidaciongasto().setIdempresa(user.getIDEMPRESA());
        getDordenliquidaciongasto().setIdorden(getDatoEdicion().getIdorden());
        getDordenliquidaciongasto().setItem(agregarItemDordenservicio());
        getDordenliquidaciongasto().setAfecto(0.0f);
        getDordenliquidaciongasto().setInafecto(0.0f);
        getDordenliquidaciongasto().setPimpuesto(0.0f);
        getDordenliquidaciongasto().setImpuesto(0.0f);
        getDordenliquidaciongasto().setImporte(0.0f);
        getDordenliquidaciongasto().setFecha(getDatoEdicion().getFecharegistro());
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').show()");
    }
    public void editarDordenliquidaciongasto() {
        setDordenliquidaciongasto(selectDordenliquidaciongasto);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').show()");
    }
    public void eliminarDordenliquidaciongasto() {
        try {
            lstdordenliquidaciongasto.remove(selectDordenliquidaciongasto);
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addDetalle(){
        try {
            lstdordenliquidaciongasto.add(getDordenliquidaciongasto());
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').hide()");
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String agregarItemDordenservicio(){
        int dato = 1;
        int may=-999999999;
        for(Dordenliquidaciongasto obj:getLstdordenliquidaciongasto()){
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
        setBotonEditarDOrdenliquidaciongasto(false);
        setBotonEliminarDOrdenliquidaciongasto(false);
        RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
    }

    public boolean esDetValida() {
        if (dordenliquidaciongasto.getItem().equalsIgnoreCase("")) {
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

    public List<Dordenliquidaciongasto> getLstdprogtlleg() {
        return getLstdordenliquidaciongasto();
    }

    public void setLstdprogtlleg(List<Dordenliquidaciongasto> lstdordenliquidaciongasto) {
        this.setLstdordenliquidaciongasto(lstdordenliquidaciongasto);
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
     * @return the lstdordenliquidaciongasto
     */
    public List<Dordenliquidaciongasto> getLstdordenliquidaciongasto() {
        return lstdordenliquidaciongasto;
    }

    /**
     * @param lstdordenliquidaciongasto the lstdordenliquidaciongasto to set
     */
    public void setLstdordenliquidaciongasto(List<Dordenliquidaciongasto> lstdordenliquidaciongasto) {
        this.lstdordenliquidaciongasto = lstdordenliquidaciongasto;
    }

    /**
     * @return the ordenliquidaciongastoDao
     */
    public OrdenliquidaciongastoDao getOrdenliquidaciongastoDao() {
        return ordenliquidaciongastoDao;
    }

    /**
     * @param ordenliquidaciongastoDao the ordenliquidaciongastoDao to set
     */
    public void setOrdenliquidaciongastoDao(OrdenliquidaciongastoDao ordenliquidaciongastoDao) {
        this.ordenliquidaciongastoDao = ordenliquidaciongastoDao;
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
     * @return the dordenliquidaciongasto
     */
    public Dordenliquidaciongasto getDordenliquidaciongasto() {
        return dordenliquidaciongasto;
    }

    /**
     * @param dordenliquidaciongasto the dordenliquidaciongasto to set
     */
    public void setDordenliquidaciongasto(Dordenliquidaciongasto dordenliquidaciongasto) {
        this.dordenliquidaciongasto = dordenliquidaciongasto;
    }

    /**
     * @return the selectDordenliquidaciongasto
     */
    public Dordenliquidaciongasto getSelectDordenliquidaciongasto() {
        return selectDordenliquidaciongasto;
    }

    /**
     * @param selectDordenliquidaciongasto the selectDordenliquidaciongasto to set
     */
    public void setSelectDordenliquidaciongasto(Dordenliquidaciongasto selectDordenliquidaciongasto) {
        this.selectDordenliquidaciongasto = selectDordenliquidaciongasto;
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
     * @return the dordenliquidaciongastoDao
     */
    public DordenliquidaciongastoDao getDordenliquidaciongastoDao() {
        return dordenliquidaciongastoDao;
    }

    /**
     * @param dordenliquidaciongastoDao the dordenliquidaciongastoDao to set
     */
    public void setDordenliquidaciongastoDao(DordenliquidaciongastoDao dordenliquidaciongastoDao) {
        this.dordenliquidaciongastoDao = dordenliquidaciongastoDao;
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
     * @return the botonEditarDOrdenliquidaciongasto
     */
    public boolean isBotonEditarDOrdenliquidaciongasto() {
        return botonEditarDOrdenliquidaciongasto;
    }

    /**
     * @param botonEditarDOrdenliquidaciongasto the botonEditarDOrdenliquidaciongasto to set
     */
    public void setBotonEditarDOrdenliquidaciongasto(boolean botonEditarDOrdenliquidaciongasto) {
        this.botonEditarDOrdenliquidaciongasto = botonEditarDOrdenliquidaciongasto;
    }

    /**
     * @return the botonEliminarDOrdenliquidaciongasto
     */
    public boolean isBotonEliminarDOrdenliquidaciongasto() {
        return botonEliminarDOrdenliquidaciongasto;
    }

    /**
     * @param botonEliminarDOrdenliquidaciongasto the botonEliminarDOrdenliquidaciongasto to set
     */
    public void setBotonEliminarDOrdenliquidaciongasto(boolean botonEliminarDOrdenliquidaciongasto) {
        this.botonEliminarDOrdenliquidaciongasto = botonEliminarDOrdenliquidaciongasto;
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
     * @return the selectConcepto_cuenta
     */
    public Concepto_cuenta getSelectConcepto_cuenta() {
        return selectConcepto_cuenta;
    }

    /**
     * @param selectConcepto_cuenta the selectConcepto_cuenta to set
     */
    public void setSelectConcepto_cuenta(Concepto_cuenta selectConcepto_cuenta) {
        this.selectConcepto_cuenta = selectConcepto_cuenta;
    }

    /**
     * @return the selectDestinoadquisicion
     */
    public Destinoadquisicion getSelectDestinoadquisicion() {
        return selectDestinoadquisicion;
    }

    /**
     * @param selectDestinoadquisicion the selectDestinoadquisicion to set
     */
    public void setSelectDestinoadquisicion(Destinoadquisicion selectDestinoadquisicion) {
        this.selectDestinoadquisicion = selectDestinoadquisicion;
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

}