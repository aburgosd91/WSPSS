/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Ubigeo;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "cntMantenedor_rutaAction")
@ViewScoped
public class CntMantenedor_rutaAction {
    private String mensaje;
    private RutasDao rutaDao;
    private UsuarioBean user;
    private boolean estado;
    private List<Rutas> datos;
    private Rutas selectRutas;
    private Rutas datoEdicion;
    private int ladd;/*(0)listar / (1)nuevo / (2)editar / (3)eliminar / (4)anular */
    @PostConstruct
    public void init() {}
    public void cargarDatos(){
        datoEdicion = new Rutas();
        rutaDao = new RutasDao();
        try {
            user = (UsuarioBean)WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            datos = rutaDao.listarPorEmpresaWeb(user.getIDEMPRESA());
        } catch (Exception ex) {
            Logger.getLogger(CntMantenedor_rutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectFromDialog(Consumidor t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }
    public void nuevo() {
        try {
            setDatoEdicion(new Rutas());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setEstado(1);
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getDescripcion() == null || getDatoEdicion().getDescripcion().equalsIgnoreCase("")) {
            WebUtil.MensajeAdvertencia("Ingrese Descripción");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        Optional<Rutas> desct = datos.stream().filter(x -> x.getDescripcion().equalsIgnoreCase(getDatoEdicion().getDescripcion())).findFirst();
        if(desct.isPresent() && getDatoEdicion().getIdruta() == null){
            WebUtil.MensajeAdvertencia("La Ruta Ya existe");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
//        if(getDatoEdicion().getOrigen() == null){
//            return false;
//        }
//        if(getDatoEdicion().getDestino() == null){
//            return false;
//        }
//        if(getDatoEdicion().getDestino().equalsIgnoreCase(getDatoEdicion().getOrigen())){
//            return false;
//        }
        return true;
    }

    public void verCntUbigeoOrigen() {
        RequestContext.getCurrentInstance().openDialog("cntUbigeo", modalOptions, null);
    }

    public void valorUbigeoOrigen(SelectEvent event) {
        Ubigeo ob = (Ubigeo) event.getObject();
        getDatoEdicion().setOrigen(ob.getIdubigeo());
        getDatoEdicion().setOrigendesc(ob.getDescripcion());

    }

    public void verCntUbigeoDestino() {
        RequestContext.getCurrentInstance().openDialog("cntUbigeo", modalOptions, null);
    }

    public void valorUbigeoDestino(SelectEvent event) {
        Ubigeo ob = (Ubigeo) event.getObject();
        getDatoEdicion().setDestino(ob.getIdubigeo());
        getDatoEdicion().setDestinodesc(ob.getDescripcion());
    }
    public void newrutas() throws CloneNotSupportedException {
        ladd = 1;
        datoEdicion = new Rutas();
        datoEdicion.setIdempresa(user.getIDEMPRESA());
        datoEdicion.setDescripcion("");
        datoEdicion.setDestino("");
        datoEdicion.setOrigen("");
        datoEdicion.setEstado(1);
        estado = true;
        RequestContext.getCurrentInstance().update("datos:rutas_mantenedor");
        RequestContext.getCurrentInstance().execute("PF('rutas_mantenedor').show()");
        
    }
    public void editrutas(){
        if (selectRutas != null) {
            ladd = 2;
            datoEdicion = new Rutas();
            datoEdicion.setIdempresa(selectRutas.getIdempresa());
            datoEdicion.setIdruta(selectRutas.getIdruta());
            datoEdicion.setDescripcion(selectRutas.getDescripcion());
            datoEdicion.setOrigen(selectRutas.getOrigen());
            datoEdicion.setOrigendesc(selectRutas.getOrigendesc());
            datoEdicion.setDestino(selectRutas.getDestino());
            datoEdicion.setDestinodesc(selectRutas.getDestinodesc());
            datoEdicion.setEstado(selectRutas.getEstado());
            datoEdicion.setFechacreacion(selectRutas.getFechacreacion());
            estado = selectRutas.getEstado()==1?true:false;
            RequestContext.getCurrentInstance().update("datos:rutas_mantenedor");
            RequestContext.getCurrentInstance().execute("PF('rutas_mantenedor').show()");
        } else {
            setMensaje("Seleccione un detalle");
            WebUtil.MensajeAdvertencia(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    public void delrutas() {
        if (selectRutas != null) {
            ladd = 3;
            datoEdicion = new Rutas();
            datoEdicion.setIdempresa(selectRutas.getIdempresa());
            datoEdicion.setIdruta(selectRutas.getIdruta());
            datoEdicion.setDescripcion(selectRutas.getDescripcion());
            datoEdicion.setOrigen(selectRutas.getOrigen());
            datoEdicion.setOrigendesc(selectRutas.getOrigendesc());
            datoEdicion.setDestino(selectRutas.getDestino());
            datoEdicion.setDestinodesc(selectRutas.getDestinodesc());
            datoEdicion.setEstado(selectRutas.getEstado());
            eliminar() ;
            RequestContext.getCurrentInstance().update("datos:listRutaMant");
        } else {
            setMensaje("Seleccione un detalle");
            WebUtil.MensajeAdvertencia(getMensaje());            
            RequestContext.getCurrentInstance().update("datos:growl");
        }

    }
    public void grabar() {
        try {
            if (validarEdicion()) {
                if (getLadd() == 1) {
                    mensaje = rutaDao.grabar(1, getDatoEdicion());
                    if (mensaje != null) {
                        if (mensaje.trim().length() == 6) {
                            getDatoEdicion().setIdruta(mensaje.trim());
                        }
                    }
                } else if (getLadd() == 2) {
                    getDatoEdicion().setEstado(estado ? 1 : 0);
                    mensaje = rutaDao.grabar(2, getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Ruta ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().execute("PF('rutas_mantenedor').close()");
                RequestContext.getCurrentInstance().update("datos:growl");
                RequestContext.getCurrentInstance().update("datos");
//                buscarTodo();
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        ;
    }
    public void eliminar() {
        try {
            if (ladd == 4) {
                getDatoEdicion().setEstado(0);
                rutaDao.grabar(3, getDatoEdicion());
            }
            if (ladd == 3) {
                getDatoEdicion().setEstado(2);
                rutaDao.grabar(4, getDatoEdicion());
            }
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Rutas> getDatos() {
        return datos;
    }

    public void setDatos(List<Rutas> datos) {
        this.datos = datos;
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
     * @return the rutaDao
     */
    public RutasDao getRutaDao() {
        return rutaDao;
    }

    /**
     * @param rutaDao the rutaDao to set
     */
    public void setRutaDao(RutasDao rutaDao) {
        this.rutaDao = rutaDao;
    }

    /**
     * @return the user
     */
    public UsuarioBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the datoEdicion
     */
    public Rutas getDatoEdicion() {
        return datoEdicion;
    }

    /**
     * @param datoEdicion the datoEdicion to set
     */
    public void setDatoEdicion(Rutas datoEdicion) {
        this.datoEdicion = datoEdicion;
    }

    /**
     * @return the ladd
     */
    public int getLadd() {
        return ladd;
    }

    /**
     * @param ladd the ladd to set
     */
    public void setLadd(int ladd) {
        this.ladd = ladd;
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
}
