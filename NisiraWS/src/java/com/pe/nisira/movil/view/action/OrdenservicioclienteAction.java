/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
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
@ManagedBean(name = "ordenservicioclienteAction")
@SessionScoped
public class OrdenservicioclienteAction extends AbstactListAction<Ordenserviciocliente> {
    private boolean botonEditarDOrdenservicio;
    private boolean botonEliminarDOrdenservicio;
    private boolean botonNuevoPersonal_servicio;
    private boolean botonEditarPersonal_servicio;
    private boolean botonEliminarPersonal_servicio;
    
    private boolean botonNuevoDPersonal_servicio;
    private boolean botonEditarDPersonal_servicio;
    private boolean botonEliminarDPersonal_servicio;
    
    private boolean botonNuevoRuta_servicios;
    private boolean botonEditarRuta_servicios;
    private boolean botonEliminarRuta_servicios;
    /*********************************LISTAS*******************************************/
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
    /*************************************DAO***************************************/
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
    public OrdenservicioclienteAction() {
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
        /**********************************CONTROLADOR********************************/
        botonEditarDOrdenservicio=true;
        botonEliminarDOrdenservicio=true;
        botonNuevoRuta_servicios=true;
        botonEditarRuta_servicios=true;
        botonEliminarRuta_servicios=true;
        botonNuevoPersonal_servicio=true;
        botonEditarPersonal_servicio=true;
        botonEliminarPersonal_servicio=true;
        
        botonNuevoDPersonal_servicio=true;
        botonEditarDPersonal_servicio=true;
        botonEliminarDPersonal_servicio=true;
        actualiza_ventana("wMnt_Ordenserviciocliente");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
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
        botonEditarDOrdenservicio=true;
        botonEliminarDOrdenservicio=true;
        botonNuevoPersonal_servicio=true;
        botonEditarPersonal_servicio=true;
        botonEliminarPersonal_servicio=true;
        actualiza_ventana("wMnt_Ordenserviciocliente");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Ordenserviciocliente());
        getDatoEdicion().setFecha(new Date());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
    }
    public boolean esVistaValida() {
        if (getDatoEdicion().getIdclieprov().isEmpty() & getDatoEdicion().getRazonsocial().isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Cliente");
            return false;
        }
        if (getListDocreferencia().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Documento referencia");
            return false;
        }
        if (getLstdordenserviciocliente().size() == 0) {
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
                    mensaje=getOrdenservicioclienteDao().grabar(1, getDatoEdicion(), getLstdordenserviciocliente(),getListPersonal_Servicio(),getListDocreferencia(),getListRuta_servicios(),getListDpersonal_Servicio());
                else
                    mensaje=getOrdenservicioclienteDao().grabar(2, getDatoEdicion(), getLstdordenserviciocliente(),getListPersonal_Servicio(),getListDocreferencia(),getListRuta_servicios(),getListDpersonal_Servicio());
                setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                WebUtil.info(getMensaje());
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCheckCotizacionventa(){
        try{
            setSelectListDcotizacionventas(new ArrayList<>());
            listDcotizacionventas = getDcotizacionventasDao().getListDCotizacionWeb(user.getIDEMPRESA(),getSelectCotizacionventas().getIdcotizacionv());
            setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
            getSelectCotizacionventas().setListDcotizacionventas(listDcotizacionventas);
//            RequestContext.getCurrentInstance().update("datos:dlgnew_cotizacionventas");
            RequestContext.getCurrentInstance().update("datos:dlgnew_cotizacionventas:dcotizacionventas");
//            RequestContext.getCurrentInstance().update("datos3:informacion:listDAcciones");
        }catch(Exception ex){
            this.setMensaje(ex.toString());
        }
    }
    public void findetalle() throws Exception {
        try{
            listDocumentos=docDao.getOrdenServicio(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),listDocumentos.get(0).getIddocumento());
            listDocreferencia = docreferenciaDao.getOrdenServicioWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
            lstdordenserviciocliente = dordenservicioclienteDao.listarPorEmpresaWeb(user.getIDEMPRESA(),getDatoEdicion().getIdordenservicio());
            if(lstdordenserviciocliente.size()>0){
                listPersonal_Servicio=personal_servicioDao.listarPorOrdenServicioClienteWeb(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio(),lstdordenserviciocliente.get(0).getItem());
                listRuta_servicios=ruta_serviciosDao.listarPorOrdenServicioClienteWeb(user.getIDEMPRESA(), lstdordenserviciocliente.get(0).getIdordenservicio(),lstdordenserviciocliente.get(0).getItem());
                listDpersonal_Servicio = dpersonal_servicioDao.listarPorOrdenServicio_PersonalDetalleWeb(user.getIDEMPRESA(),lstdordenserviciocliente.get(0).getIdordenservicio(),
                        lstdordenserviciocliente.get(0).getItem(),listPersonal_Servicio.get(0).getItem2());
            }
            /**************************** RESET SELECTION ********************/
            setSelectDordenserviciocliente(new Dordenserviciocliente());
            setSelectRuta_servicios(new Ruta_servicios());
            setSelectPersonal_servicio(new Personal_servicio());
            setSelectDPersonal_servicio(new Dpersonal_servicio());
            setSelectDocreferencia(new Docreferencia());
            /********************************************************************************************/
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
            RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        }catch(Exception ex){
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
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
    public void verCntDocReferencia() {
        try {
            setListCotizacionventas(getCotizacionventasDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
            if(getListCotizacionventas()!=null){
                if(getListCotizacionventas().size()>0){
                    setSelectCotizacionventas(getListCotizacionventas().get(0));
                    listDcotizacionventas = getDcotizacionventasDao().getListDCotizacionWeb(user.getIDEMPRESA(),getSelectCotizacionventas().getIdcotizacionv());
                    getSelectCotizacionventas().setListDcotizacionventas(listDcotizacionventas);
                    /*LISTAR DCOTIZACIONVENTAS_ACTIVIDADES*/
                    setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
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
    public void verCntClieprovPersonal() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonal", modalOptions, null);
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargos_personal", modalOptions, null);
    }
    public void verCntRuta() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }
    public void valorRuta(SelectEvent event) {
        this.setSelectRutas((Rutas) event.getObject());
        this.getRuta_servicios().setIdruta(this.selectRutas.getIdruta());
        this.getRuta_servicios().setRuta(this.selectRutas.getDescripcion());
    }
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazonsocial(selectClieprov.getRazonsocial());
    }
    public void valorClieprovPersonal(SelectEvent event) {
        this.setSelectClieprovPersonal((Clieprov) event.getObject());
        this.getPersonal_servicio().setIdpersonal(this.getSelectClieprovPersonal().getIdclieprov());
        this.getPersonal_servicio().setDni(this.getSelectClieprovPersonal().getDni());
        this.getPersonal_servicio().setNombres(this.getSelectClieprovPersonal().getRazonsocial());
    }
    public void valorCargos_personal(SelectEvent event) {
        Cargos_personal cargo = (Cargos_personal) event.getObject();
        this.getPersonal_servicio().setIdcargo(cargo.getIdcargo());
        this.getPersonal_servicio().setCargo(cargo.getDescripcion());
    }
    public void verCntConsumidor() {
        RequestContext.getCurrentInstance().openDialog("cntConsumidor", modalOptions, null);
    }
    public void valorConsumidor(SelectEvent event) {
        this.selectConsumidor = (Consumidor) event.getObject();
        getDordenserviciocliente().setIdvehiculo(selectConsumidor.getIdconsumidor());
        getDordenserviciocliente().setVehiculo(selectConsumidor.getDescripcion());
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
    public void grabarDordenserviciocliente(){
        dordenserviciocliente.setHora_req(WebUtil.convertTimeDecimal(dordenserviciocliente.getHora_reqConvert()));
        int pos=lstdordenserviciocliente.indexOf(dordenserviciocliente);
        if(pos==-1)
            lstdordenserviciocliente.add(dordenserviciocliente);
        else
            lstdordenserviciocliente.set(pos, dordenserviciocliente);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
        RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').hide()");
    }
    public void nuevoDordenserviciocliente() {
        setDordenserviciocliente(new Dordenserviciocliente());
        getDordenserviciocliente().setIdempresa(user.getIDEMPRESA());
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').show()");
    }
    public void editarDordenserviciocliente() {
        setDordenserviciocliente(selectDordenserviciocliente);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dordenserviciocliente");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').show()");
    }
    public void eliminarDordenserviciocliente() {
        try {
            lstdordenserviciocliente.remove(selectDordenserviciocliente);
            RequestContext.getCurrentInstance().update("datos:tbl");
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
    public void addDetalle(){
        try {
            /****** INICIALIZAR *******/
            lstdordenserviciocliente = new ArrayList<>();
            Dordenserviciocliente obj;
            
            /*AGREGAR DETALLE DORDENSERVICIOCLIENTE*/
            for(Dcotizacionventas deta:getSelectListDcotizacionventas()){
                obj = new Dordenserviciocliente();
                obj.setIdempresa(deta.getIdempresa());
                obj.setIdordenservicio(getDatoEdicion().getIdordenservicio());
                obj.setItem(agregarItemDordenservicio());
                obj.setIdreferencia(deta.getIdcotizacionv());
                obj.setItemreferencia(deta.getItem());
                lstdordenserviciocliente.add(obj);
                setSelectDordenserviciocliente(obj);
            }
            if(getSelectDordenserviciocliente()!=null)
                onSelectDordenservicio();
            RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoRuta_servicios() {
        this.ruta_servicios = new Ruta_servicios();
        this.ruta_servicios.setIdempresa(user.getIDEMPRESA());
        this.ruta_servicios.setIdordenservicio(getSelectDordenserviciocliente().getIdordenservicio());
        this.ruta_servicios.setItem(getSelectDordenserviciocliente().getItem());
        this.ruta_servicios.setItemruta(agregarItemRuta_servicios());
        this.ruta_servicios.setGlosa("");
        RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_ruta_servicios').show()");
    }
    public void editarRuta_servicios() {
        setRuta_servicios(selectRuta_servicios);
        RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_ruta_servicios').show()");
    }
    public void eliminarRuta_servicios() {
        try {
            listRuta_servicios.remove(selectRuta_servicios);
            RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addPersonal_servicio() {
        /*AGREGAR DETALLE PERSONA_SERVICIO*/
        listPersonal_Servicio = new ArrayList<>();
        Personal_servicio detaobj;
        for(Dcotizacionventas_actividades detaDca : getListDcotizacionventas_actividades()){
            int i = (int)((float)detaDca.getCantidad());
            while(i!=0){
                detaobj = new Personal_servicio();
                detaobj.setIdbasedatos(detaDca.getIdbasedatos());
                detaobj.setIdempresa(detaDca.getIdempresa());
                detaobj.setIdordenservicio(getDatoEdicion().getIdordenservicio());
                detaobj.setIdcargo(detaDca.getIdempresa());
                detaobj.setCargo(detaDca.getCargo());
                detaobj.setItem(getSelectDordenserviciocliente().getItem()==null?"":getSelectDordenserviciocliente().getItem());//-> relacion DORDENSERVICIOCLIENTE
                detaobj.setItem2(agregarItemPersonal_servicio());
                detaobj.setFechaoperacion(new Date());
                listPersonal_Servicio.add(detaobj);
                i--;
            }
        }
        RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
    }
    public void editarPersonal_servicio() {
        if(!getListPersonal_Servicio().isEmpty()){
            setPersonal_servicio(selectPersonal_servicio);
            try {
                /*CARGAR DATOS DPERSONAL_SERVICIO*/
                setListDpersonal_Servicio(getDpersonal_servicioDao().listarPorOrdenServicio_PersonalDetalleWeb(selectPersonal_servicio.getIdempresa(),
                        selectPersonal_servicio.getIdordenservicio(), selectPersonal_servicio.getItem(),
                        selectPersonal_servicio.getItem2()));
            } catch (NisiraORMException ex) {
                Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_personal_servicio').show()");
        }
    }
    public void eliminarPersonal_servicio() {
        try {
            listPersonal_Servicio.remove(selectPersonal_servicio);
            RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoDPersonal_servicio() {
        if(getPersonal_servicio().getIdcargo()==null){
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, "Seleccionar Cargo");
        }else if(getPersonal_servicio().getIdpersonal()==null){
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, "Seleccionar Personal");
        }else{
            setDpersonal_servicio(new Dpersonal_servicio());
            getDpersonal_servicio().setIdempresa(user.getIDEMPRESA());
            if(getSelectPersonal_servicio()==null){/*NUEVO - PERSONAL - SERVICIO*/
                getDpersonal_servicio().setIdordenservicio(getSelectDordenserviciocliente().getIdordenservicio());
                getDpersonal_servicio().setItem_dordenservicio(getSelectDordenserviciocliente().getItem());
                getDpersonal_servicio().setItem(agregarItemDPersonal_servicio());
                getDpersonal_servicio().setFhora_req(getSelectDordenserviciocliente().getHora_reqConvert());
                getDpersonal_servicio().setHora_req(getSelectDordenserviciocliente().getHora_req());
                getDpersonal_servicio().setIdcargo(getPersonal_servicio().getIdcargo());
                getDpersonal_servicio().setCargo(getPersonal_servicio().getCargo());
            }else{/*EDITAR - PERSONAL - SERVICIO*/
                getDpersonal_servicio().setIdordenservicio(getSelectPersonal_servicio().getIdordenservicio());
                getDpersonal_servicio().setItem_dordenservicio(getSelectPersonal_servicio().getItem());
                getDpersonal_servicio().setItem2(getSelectPersonal_servicio().getItem2());
                getDpersonal_servicio().setItem(agregarItemDPersonal_servicio());
                getDpersonal_servicio().setIdcargo(getSelectPersonal_servicio().getIdcargo());
                getDpersonal_servicio().setCargo(getSelectPersonal_servicio().getCargo());
                /******************* OBTENER DE DETALLE ORDEN SERVICIO *******************/
                if(getSelectPersonal_servicio().getIdordenservicio()!=null && getSelectPersonal_servicio().getItem()!=null){
                    Dordenserviciocliente o = null;
                    if(lstdordenserviciocliente.size()>0){
                        for(Dordenserviciocliente obj :lstdordenserviciocliente){
                            if(obj.getIdordenservicio().equals(getSelectPersonal_servicio().getIdordenservicio()) &&
                                   obj.getItem().equals(getSelectPersonal_servicio().getItem())){
                                o=obj;break;
                            }
                        } 
                    }
                    if(o!=null){
                        getDpersonal_servicio().setFhora_req(o.getHora_reqConvert());
                        getDpersonal_servicio().setHora_req(o.getHora_req()); 
                    } 
                }
            }
            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').show()");
        }
        
    }
    public void editarDPersonal_servicio() {
        setDpersonal_servicio(selectDPersonal_servicio);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').show()");
    }
    public void eliminarDPersonal_servicio() {
        try {
            listDpersonal_Servicio.remove(selectDPersonal_servicio);
            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio:listDpersonal_Servicio");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarPersonal_Servicion(){
        try {
            int pos=-1;
            if(getSelectPersonal_servicio()!=null){
                pos=listPersonal_Servicio.indexOf(getSelectPersonal_servicio());
            }
            if(pos==-1){
                listPersonal_Servicio.add(personal_servicio);
            }
            else{
                lstdordenserviciocliente.set(pos, dordenserviciocliente);
            }
            RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            int pos=-1;
            if(getSelectDPersonal_servicio()!=null){
                pos=listDpersonal_Servicio.indexOf(getSelectDPersonal_servicio());
            }
            if(pos==-1){
                listDpersonal_Servicio.add(dpersonal_servicio);
            }
            else{
                listDpersonal_Servicio.set(pos, dpersonal_servicio);
            }
//            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dpersonal_servicio");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dpersonal_servicio').hide()");
            RequestContext.getCurrentInstance().update("datos:dlgnew_personal_servicio:listDPersonal_Servicio");
//            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenserviciocliente').hide()");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void grabarRuta_servicio(){
        try {
            int pos=-1;
            if(getSelectRuta_servicios()!=null){
                pos=listRuta_servicios.indexOf(getSelectRuta_servicios());
            }
            if(pos==-1){
                listRuta_servicios.add(ruta_servicios);
            }
            else{
                listRuta_servicios.set(pos, ruta_servicios);
            }
            RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
            RequestContext.getCurrentInstance().update("datos:dlgnew_ruta_servicios");
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
    public void onRowSelectDordenservicio(SelectEvent event) throws IOException {
        onSelectDordenservicio();
    }
    public void onSelectDordenservicio(){
        setBotonEditarDOrdenservicio(false);
        setBotonEliminarDOrdenservicio(false);
        setBotonNuevoPersonal_servicio(false);
        setBotonNuevoRuta_servicios(false);
        RequestContext.getCurrentInstance().update("datos:lstdordenserviciocliente");
        RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
        RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
    }
    public void onRowSelectRuta_Servicios(SelectEvent event) throws IOException {
        setBotonEditarRuta_servicios(false);
        setBotonEliminarRuta_servicios(false);
        RequestContext.getCurrentInstance().update("datos:listRuta_servicios");
    }
    public void onRowSelectPersonal_Servicio(SelectEvent event) throws IOException {
        setBotonEditarPersonal_servicio(false);
        setBotonEliminarPersonal_servicio(false);
        RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
    }
    public void onRowSelectDPersonal_Servicio(SelectEvent event) throws IOException {
        setBotonEditarDPersonal_servicio(false);
        setBotonEliminarDPersonal_servicio(false);
        RequestContext.getCurrentInstance().update("datos:listDpersonal_Servicio");
    }
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
            getListDocreferencia().add(obj);
            RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_cotizacionventas').hide()");
            /*CREAR DETALLE PERSONAL_SERVICIO*/
            setListDcotizacionventas_actividades(getDcotizacionventas_actividadesdao().listarPorEmpresaServiceCotizacionVenta(getSelectCotizacionventas().getIdempresa(), getSelectCotizacionventas().getIdcotizacionv()));
            /*CREAR DETALLE ORDEN SERVICIO */
            addDetalle();
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onRowCancelDocreferencia(RowEditEvent event) {
        Docreferencia obj =(Docreferencia)event.getObject();
        getListDocreferencia().remove(obj);
        RequestContext.getCurrentInstance().update("datos:tabledocreferencia");
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

}