/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.RutaDao;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Ruta;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "rutaAction")
@SessionScoped
public class RutaAction extends AbstactListAction<Ruta> implements Serializable {

    private String mensaje;
    private RutaDao rutaDao;
    private UsuarioBean user;
    private Geopoint selectLugarOrigen;
    private Geopoint selectLugarDestino;
    public RutaAction() {
        mensaje = "";
        rutaDao = new RutaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Ruta");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(rutaDao.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        rutaDao = new RutaDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Ruta");
        return "";
    }

    @Override
    public void doNuevo() throws IOException {
        setLadd(1);
        nuevo();
    }

    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            setLadd(2);
            setDatoEdicion(getDatoSeleccionado());
            RequestContext.getCurrentInstance().update("datos:dlGuardarRuta");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarRuta').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Ruta());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setEstado(1);
            RequestContext.getCurrentInstance().update("datos:dlGuardarRuta");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarRuta').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getDescripcion() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validarEdicion()) {
                if(getLadd()==1){
                    mensaje = rutaDao.grabar(1,getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Ruta " + mensaje+ " registrado con éxito.");
                    }
                }
                else if(getLadd()==2){
                    mensaje = rutaDao.grabar(2,getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Ruta " + mensaje + " actualizado con éxito.");
                    }
                }
                RequestContext.getCurrentInstance().update("datos");
                RequestContext.getCurrentInstance().execute("PF('dlGuardarRuta').hide()");
//                buscarTodo();
            }
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ver() {
        setLadd(0);
        setDatoEdicion(getDatoSeleccionado());
        RequestContext.getCurrentInstance().update("datos:dlGuardarRuta");
        RequestContext.getCurrentInstance().execute("PF('dlGuardarRuta').show()");
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                rutaDao.grabar(2,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
                rutaDao.grabar(2,getDatoEdicion());
            }
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void verCntLugar() {
        RequestContext.getCurrentInstance().openDialog("cntGeopoint", modalOptions, null);
    }
    public void valorLugarOrigen(SelectEvent event) {
        this.setSelectLugarOrigen((Geopoint) event.getObject());
        getDatoEdicion().setIdterminalorigen(getSelectLugarOrigen().getIdgeopoint());
        getDatoEdicion().setRutaorigen(getSelectLugarOrigen().getDescripcion());
    }
    public void valorLugarDestino(SelectEvent event) {
        this.setSelectLugarDestino((Geopoint) event.getObject());
        getDatoEdicion().setIdterminaldestino(getSelectLugarDestino().getIdgeopoint());
        getDatoEdicion().setRutadestino(getSelectLugarDestino().getDescripcion());
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the selectLugarOrigen
     */
    public Geopoint getSelectLugarOrigen() {
        return selectLugarOrigen;
    }

    /**
     * @param selectLugarOrigen the selectLugarOrigen to set
     */
    public void setSelectLugarOrigen(Geopoint selectLugarOrigen) {
        this.selectLugarOrigen = selectLugarOrigen;
    }

    /**
     * @return the selectLugarDestino
     */
    public Geopoint getSelectLugarDestino() {
        return selectLugarDestino;
    }

    /**
     * @param selectLugarDestino the selectLugarDestino to set
     */
    public void setSelectLugarDestino(Geopoint selectLugarDestino) {
        this.selectLugarDestino = selectLugarDestino;
    }

    @Override
    public String buscarFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
