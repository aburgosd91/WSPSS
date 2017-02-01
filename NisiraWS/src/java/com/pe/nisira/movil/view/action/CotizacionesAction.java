/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TcambioDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.util.ConstantesBD;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.ManejadorFechas;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.math.BigInteger;
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
    private List<Sucursal> listSucursal;
    private List<Almacen> listAlmacen;
    private List<Clieprov> listClieprov;
    private List<Documentos> listDocumentos;
    private List<Numemisor> listNumemisor;
    private List<Dcotizacionventas> lstdcotizacionventas;
    private List<Multitabla> listMultitabla;
    private List<Estados> listEstado;
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
    /*************************************ENTITY***************************************/
    private Dcotizacionventas dcotizacionventas;
    private Dcotizacionventas selectdcotizacionventas; 
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    /**********************************CONTROLADOR********************************/
    private boolean botonEditarDcotizacionventas;
    private boolean botonEliminarDcotizacionventas;    
    
    private Date fecha_ini = new Date();//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
    private Date fecha_fin = new Date();//ManejadorFechas.getFechaActualFormateada("ddMMyyyy");
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
        
        docDao = new DocumentosDao();
        numemisorDao = new NumemisorDao();
        clieprovDao = new ClieprovDao();
        emisorDao= new EmisorDao();
        tcambioDao=new TcambioDao();
        monedasDao=new MonedasDao();
        sucursalesDao=new SucursalesDao();
        /********************ENTITY****************/
        
        /********************ARRAY****************/
        lstdcotizacionventas = new ArrayList<Dcotizacionventas>();
        listDocumentos = new ArrayList<Documentos>();
        listNumemisor = new ArrayList<Numemisor>();
        listEstado = new ArrayList<Estados>();
        listClieprov = new ArrayList<Clieprov>();
        listMultitabla = new ArrayList<Multitabla>();
        buscar_filtrofecha();
        actualiza_ventana("wMnt_Cotizacionventas");
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            //setListaDatos(getCotizacionventasDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        setCotizacionventasDao(new CotizacionventasDao());
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        setLstdcotizacionventas(new ArrayList<Dcotizacionventas>());
        listMultitabla = new ArrayList<Multitabla>();
        actualiza_ventana("wMnt_Cotizacionventas");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Cotizacionventas());
//        getDatoEdicion().setIdempresa(Integer.parseInt(user.getIDEMPRESA()));
//        getDatoEdicion().setIdsucursal(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
//        getDatoEdicion().setEstado(1);
//        getDatoEdicion().setTipotarea(0);
//        getDatoEdicion().setUsrcreacion(user.getIDUSUARIO());

    }

    @Override
    public void grabar() {
        try {
//            if (esVistaValida()) {
//                getDatoEdicion().setFechaprogramacion(new Timestamp(fechaprogramaciont.getTime()));
//                getDatoEdicion().setFechaejecucion(new Timestamp(fechaejecuciont.getTime()));
//                if (fechafinalizaciont != null) {
//                    getDatoEdicion().setFechafinalizacion(new Timestamp(fechafinalizaciont.getTime()));
//                }
//                getDatoEdicion().setNumero(numero);
//                getDatoEdicion().setIDMONTACARGA(Integer.valueOf(mo.getIDMONTACARGA()));
//
//                /*REESTRUCTURACION*/
//                String i = "";
////                String i = cotizacionventasDao.grabar(getDatoEdicion());/*CABECERA*/
//                int in = 1;
//                for (DZonaAccesorio dz : lstzonaAcc) {
//                    DprogramacionTareaPartida dp = new DprogramacionTareaPartida();
//                    if (dz.isAsignado()) {
//                        dp.setIdempresa(dz.getIDEMPRESA());
//                        dp.setIdsucursal(dz.getIDSUCURSAL());
//                        dp.setIdprogramaciontarea(i);
//                        dp.setItem(in);
//                        dp.setIdproceso(getDatoEdicion().getIdproceso());
//                        dp.setIdzona(dz.getIDZONA());
//                        dp.setIdalmacen(null);
//                        dp.setIdaccesorio(dz.getIDACCESORIO());
//                        dp.setIdpaleta(null);
//                        dp.setIdubicacion(null);
//                        lstdprogtpart.add(dp);
//                        in++;
//                    }
//                }
//                if (lstdprogtpart.isEmpty()) {
//                    WebUtil.MensajeAdvertencia("Seleccione Programaciones de llenado");
//                } else {
//                    /*NUEVO GUARDAR TOTAL*/
//                    i = cotizacionventasDao.grabar(getDatoEdicion(), lstdprogtpart, slcdprogtlleg);
//                    getDatoEdicion().setIdprogramaciontarea(i);
//                    setMensaje(WebUtil.exitoRegistrar("Programación Tarea Recepeción Materia Prima ", i));
//                    WebUtil.info(getMensaje());
//                    notificacionEnvio(i, String.valueOf(getDatoEdicion().getIDMONTACARGA()));
//                }
//            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
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
            listDocumentos=docDao.getOrdenServicio(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),listDocumentos.get(0).getIddocumento());
            lstdcotizacionventas = dcotizacionventasDao.getListDCotizacionWeb(user.getIDEMPRESA(),getDatoEdicion().getIdcondventa());
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
    public String agregarItemDordenservicio(){
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
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonal", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazon_social(selectClieprov.getRazonsocial());
    }
    public void nuevoDcotizacionventas() {
        setDcotizacionventas(new Dcotizacionventas());
        getDcotizacionventas().setIdempresa(user.getIDEMPRESA());
        getDcotizacionventas().setIdcotizacionv(getDatoEdicion().getIdcotizacionv());
        getDcotizacionventas().setItem(agregarItemDordenservicio());
        getDcotizacionventas().setImpuesto(0.0f);
        getDcotizacionventas().setImporte(0.0f);
        getDcotizacionventas().setFechacreacion(getDatoEdicion().getFecha());
        RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
    }
    public void editarDcotizacionventas() {
        setDcotizacionventas(selectdcotizacionventas);
        RequestContext.getCurrentInstance().update("datos:dlgnew_dcotizacionventas");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_dcotizacionventas').show()");
    }
    public void eliminarDcotizacionventas() {
        try {
            lstdcotizacionventas.remove(selectdcotizacionventas);
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getFecha_ini());
            String f_fin = f.format(getFecha_fin());
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
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
            //   filtrar();
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
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
    public List<Sucursal> getListSucursal() {
        return listSucursal;
    }

    /**
     * @param listSucursal the listSucursal to set
     */
    public void setListSucursal(List<Sucursal> listSucursal) {
        this.listSucursal = listSucursal;
    }

    /**
     * @return the listAlmacen
     */
    public List<Almacen> getListAlmacen() {
        return listAlmacen;
    }

    /**
     * @param listAlmacen the listAlmacen to set
     */
    public void setListAlmacen(List<Almacen> listAlmacen) {
        this.listAlmacen = listAlmacen;
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

}