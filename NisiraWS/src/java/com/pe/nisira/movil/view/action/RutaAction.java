/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.RutaDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Ubigeo;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "rutaAction")
@SessionScoped
public class RutaAction extends AbstactListAction<Rutas> implements Serializable {

    private String mensaje;
    private RutasDao rutaDao;
    private UsuarioBean user;
    private boolean estado;

    public RutaAction() {
        mensaje = "";
        rutaDao = new RutasDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
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
        rutaDao = new RutasDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Ruta");
        return "";
    }

    @Override
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
        if (WebUtil.isnull(getDatoEdicion().getDescripcion(), "").equals("")) {
            WebUtil.MensajeAdvertencia("Ingrese Descripción");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if(WebUtil.isnull(getDatoEdicion().getOrigen(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingresar Punto Origen");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        if(WebUtil.isnull(getDatoEdicion().getDestino(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingresar Punto Destino");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        Optional<Rutas> desct = getListaDatos().stream().filter(x -> x.getDescripcion().equalsIgnoreCase(getDatoEdicion().getDescripcion())).findFirst();
        if(desct.isPresent() && getDatoEdicion().getIdruta() == null){
            WebUtil.MensajeAdvertencia("La Ruta Ya existe");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
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

    @Override
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
                setLvalidate(true);
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

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                rutaDao.grabar(3, getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
                rutaDao.grabar(4, getDatoEdicion());
            }
            lista_accion_filtro("wLst_Ruta");
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void findDetalle() {
        if (getDatoEdicion() != null) {
            estado = getDatoEdicion().getEstado() == 0.0 ? false : true;
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
