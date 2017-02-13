/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.entity.Cargos_personal;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "cargos_personalAction")
@SessionScoped
public class Cargos_personalAction extends AbstactListAction<Cargos_personal> implements Serializable {

    private String mensaje;
    private Cargos_personalDao daoCargos_personal;
    private List<Cargos_personal> filtroCargos_personal;
    private boolean botonEditar;
    private boolean botonEliminar;
    public UsuarioBean user;

    public Cargos_personalAction() {
        mensaje = "";
        daoCargos_personal = new Cargos_personalDao();
        botonEditar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Cargos_personal");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(daoCargos_personal.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(Cargos_personalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        daoCargos_personal = new Cargos_personalDao();
        botonEditar = false;
        botonEliminar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Cargos_personal");
        return "";
    }

    @Override
    public void nuevo() {
//        setDatoEdicion(new Zona());        
//        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
//        getDatoEdicion().setIDSUCURSAL(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
//        eventoSucursal();
//        getDatoEdicion().setESTADO(true);
//        tablaAlmacen = new ArrayList<TablaAlmacen>();
//        listDZonaAccesorio = new ArrayList<DZonaAccesorio>();
    }
    
    @Override
    public void grabar() {
        try {
//            if (getDatoEdicion().getDESCRIPCION().equals("")) {
////                WebUtil.MensajeAlerta("Ingrese Descripción");
//                this.setMensaje("Ingrese DESCRIPCION");
//            } else {                
//                if (getDatoEdicion().getIDZONA() == 0) {
//                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
//                    daoZona.addZonaDetalle(getDatoEdicion(), tablaAlmacen, listDZonaAccesorio);
//                    WebUtil.info("Zona " + getDatoEdicion().getDESCRIPCION() + " registrado con éxito.");
//
//                } else {                    
//                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
//                    daoZona.editZonaDetalle(getDatoEdicion(), tablaAlmacen, listDZonaAccesorio);
//                    WebUtil.info("Zona " + getDatoEdicion().getDESCRIPCION() + " actualizado con éxito.");
//                }
//            }
        } catch (Exception ex) {
            Logger.getLogger(Cargos_personalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                daoZona.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 0);
//            }
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
//                daoZona.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 2);
//            }
        } catch (Exception ex) {
            Logger.getLogger(Cargos_personalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isBotonEditar() {
        return botonEditar;
    }

    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    /**
     * @return the filtroCargos_personal
     */
    public List<Cargos_personal> getFiltroCargos_personal() {
        return filtroCargos_personal;
    }

    /**
     * @param filtroCargos_personal the filtroCargos_personal to set
     */
    public void setFiltroCargos_personal(List<Cargos_personal> filtroCargos_personal) {
        this.filtroCargos_personal = filtroCargos_personal;
    }

    @Override
    public String buscarFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
