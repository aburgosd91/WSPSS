/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Multitabla;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "clieprovAction")
@SessionScoped
public class ClieProvAction extends AbstactListAction<Clieprov> implements Serializable {

    private String mensaje;
    private ClieprovDao daoClieprov;
    private List<Clieprov> filtroClieprov;
    private boolean botonEditar;
    private boolean botonEliminar;
    public UsuarioBean user;

    public ClieProvAction() {
        mensaje = "";
        daoClieprov = new ClieprovDao();
        filtroClieprov = new ArrayList<Clieprov>();
        botonEditar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_ClieProv");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(daoClieprov.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(ClieProvAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        daoClieprov = new ClieprovDao();
        botonEditar = false;
        botonEliminar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        filtroClieprov = new ArrayList<Clieprov>();
        actualiza_ventana("wMnt_Zona");
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
            Logger.getLogger(ClieProvAction.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClieProvAction.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the filtroClieprov
     */
    public List<Clieprov> getFiltroClieprov() {
        return filtroClieprov;
    }

    /**
     * @param filtroClieprov the filtroClieprov to set
     */
    public void setFiltroClieprov(List<Clieprov> filtroClieprov) {
        this.filtroClieprov = filtroClieprov;
    }

    @Override
    public String buscarFiltro() {
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


}
