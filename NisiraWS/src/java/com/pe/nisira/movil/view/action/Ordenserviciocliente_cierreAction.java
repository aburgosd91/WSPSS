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
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "ordenserviciocliente_cierreAction")
@SessionScoped
public class Ordenserviciocliente_cierreAction extends AbstactListAction<Ordenserviciocliente> {

    /*********************************LISTAS*******************************************/
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
    public Ordenserviciocliente_cierreAction() {
        selectListOrdenserviciocliente = new ArrayList<Ordenserviciocliente>();
        ordenservicioclienteDao = new OrdenservicioclienteDao();
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
        actualiza_ventana("wMnt_Ordenserviciocliente_cerrado");
    }

    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Ordenserviciocliente_cierreAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        actualiza_ventana("wMnt_Ordenserviciocliente_cerrado");
        return "";
    }

    @Override
    public void nuevo() {
    }

    @Override
    public void grabar() {
       
    }

    @Override
    public void eliminar() {
        
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            lista_accion_filtro("wLst_Ordenserviciocliente_cerrado");
        return "";
    }

    @Override
    public void cerrar() {
        try {
            if(!selectListOrdenserviciocliente.isEmpty()){
                this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,getSelectListOrdenserviciocliente());
                setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                WebUtil.info(getMensaje());
                setSelectListOrdenserviciocliente(new ArrayList<>());
                buscarFiltro(2);
            }else{
                this.mensaje = "Seleccionar Documento";
                WebUtil.MensajeError(this.mensaje);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ordenserviciocliente_cierreAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.MensajeError(ex.getMessage());
        }
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

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}