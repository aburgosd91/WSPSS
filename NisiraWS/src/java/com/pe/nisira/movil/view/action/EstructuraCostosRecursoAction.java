/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Destructura_costos_recursosDao;
import com.nisira.core.dao.Estructura_costos_clieprovDao;
import com.nisira.core.dao.Estructura_costos_productoDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Destructura_costos_recursos;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.entity.Estructura_costos_producto;
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
@ManagedBean(name = "estructuracostosrecursoAction")
@SessionScoped
public class EstructuraCostosRecursoAction extends AbstactListAction<Estructura_costos_clieprov> implements Serializable {
    /*CONTROLES*/
    private String mensaje;
    /*DAO*/
    private Estructura_costos_clieprovDao estructura_costos_clieprovDao;
    private Estructura_costos_productoDao estructura_costos_productoDao;
    private Destructura_costos_recursosDao destructura_costos_recursosDao;
    /*ARRAY*/
    private List<Estructura_costos_producto> listEstructura_costos_producto;
    private List<Destructura_costos_recursos> listDestructura_costos_recursos;
    /*ENTITY*/
    private Estructura_costos_producto selectEstructura_costos_producto;
    private Destructura_costos_recursos selectDestructura_costos_recursos;
    private boolean botonEditar;
    private boolean botonEliminar;
    public UsuarioBean user;
    private Float subtotal_ecosto;
    private Float go_ecosto;
    private Float ga_ecosto;
    private Float u_ecosto;
    private Float total_ecosto;
    public EstructuraCostosRecursoAction() {
        /*CONTROLES*/
        mensaje = "";
        botonEditar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        /*DAO*/
        estructura_costos_clieprovDao = new Estructura_costos_clieprovDao();
        estructura_costos_productoDao = new Estructura_costos_productoDao();
        destructura_costos_recursosDao = new Destructura_costos_recursosDao();
        /*ARRAY*/
        listEstructura_costos_producto = new ArrayList<>();
        listDestructura_costos_recursos = new ArrayList<>();
        
        subtotal_ecosto = 0.0f;
        go_ecosto = 0.0f;
        ga_ecosto = 0.0f;
        u_ecosto = 0.0f;
        total_ecosto = 0.0f;
        actualiza_ventana("wMnt_EstructuraCostosRecurso");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(getEstructura_costos_clieprovDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        botonEditar = false;
        botonEliminar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
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
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String buscarFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void findetalle() throws Exception {
        try{
            if(getLadd()==2){/*EDITAR*/
                setListEstructura_costos_producto(estructura_costos_productoDao.listarPorEmpresaWebXcodigo(user.getIDEMPRESA(), getDatoEdicion().getCodigo()));
                /* CONSULTAR ESTRUCTURA COSTOS PRODUCTO*/
                if(listEstructura_costos_producto.isEmpty()){
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_PRODUCTO>";
                    WebUtil.error(mensaje);
                }
            }
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
        }catch(Exception ex){
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*********** EVENTOS **********/
    public void onRowSelectEstructura_costos_producto(SelectEvent event) throws IOException {
        try {
            listDestructura_costos_recursos=destructura_costos_recursosDao.listarPorEmpresaWebXProducto(getSelectEstructura_costos_producto().getIdempresa(),
                    getSelectEstructura_costos_producto().getCodigo(), getSelectEstructura_costos_producto().getIdproducto());
            /* CONSULTAR ESTRUCTURA COSTOS PRODUCTO*/
            if(listDestructura_costos_recursos.isEmpty()){
                mensaje = "No existe registro <ESTRUCTURA_COSTOS_RECURSOS>";
                WebUtil.error(mensaje);
            }
            RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
        } catch (NisiraORMException ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onRowSelectDestructura_costos_recursos(SelectEvent event) throws IOException {

        RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
    }
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
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
     * @return the estructura_costos_clieprovDao
     */
    public Estructura_costos_clieprovDao getEstructura_costos_clieprovDao() {
        return estructura_costos_clieprovDao;
    }

    /**
     * @param estructura_costos_clieprovDao the estructura_costos_clieprovDao to set
     */
    public void setEstructura_costos_clieprovDao(Estructura_costos_clieprovDao estructura_costos_clieprovDao) {
        this.estructura_costos_clieprovDao = estructura_costos_clieprovDao;
    }

    /**
     * @return the estructura_costos_productoDao
     */
    public Estructura_costos_productoDao getEstructura_costos_productoDao() {
        return estructura_costos_productoDao;
    }

    /**
     * @param estructura_costos_productoDao the estructura_costos_productoDao to set
     */
    public void setEstructura_costos_productoDao(Estructura_costos_productoDao estructura_costos_productoDao) {
        this.estructura_costos_productoDao = estructura_costos_productoDao;
    }

    /**
     * @return the destructura_costos_recursosDao
     */
    public Destructura_costos_recursosDao getDestructura_costos_recursosDao() {
        return destructura_costos_recursosDao;
    }

    /**
     * @param destructura_costos_recursosDao the destructura_costos_recursosDao to set
     */
    public void setDestructura_costos_recursosDao(Destructura_costos_recursosDao destructura_costos_recursosDao) {
        this.destructura_costos_recursosDao = destructura_costos_recursosDao;
    }

    /**
     * @return the listEstructura_costos_producto
     */
    public List<Estructura_costos_producto> getListEstructura_costos_producto() {
        return listEstructura_costos_producto;
    }

    /**
     * @param listEstructura_costos_producto the listEstructura_costos_producto to set
     */
    public void setListEstructura_costos_producto(List<Estructura_costos_producto> listEstructura_costos_producto) {
        this.listEstructura_costos_producto = listEstructura_costos_producto;
    }

    /**
     * @return the listDestructura_costos_recursos
     */
    public List<Destructura_costos_recursos> getListDestructura_costos_recursos() {
        return listDestructura_costos_recursos;
    }

    /**
     * @param listDestructura_costos_recursos the listDestructura_costos_recursos to set
     */
    public void setListDestructura_costos_recursos(List<Destructura_costos_recursos> listDestructura_costos_recursos) {
        this.listDestructura_costos_recursos = listDestructura_costos_recursos;
    }

    /**
     * @return the selectEstructura_costos_producto
     */
    public Estructura_costos_producto getSelectEstructura_costos_producto() {
        return selectEstructura_costos_producto;
    }

    /**
     * @param selectEstructura_costos_producto the selectEstructura_costos_producto to set
     */
    public void setSelectEstructura_costos_producto(Estructura_costos_producto selectEstructura_costos_producto) {
        this.selectEstructura_costos_producto = selectEstructura_costos_producto;
    }

    /**
     * @return the selectDestructura_costos_recursos
     */
    public Destructura_costos_recursos getSelectDestructura_costos_recursos() {
        return selectDestructura_costos_recursos;
    }

    /**
     * @param selectDestructura_costos_recursos the selectDestructura_costos_recursos to set
     */
    public void setSelectDestructura_costos_recursos(Destructura_costos_recursos selectDestructura_costos_recursos) {
        this.selectDestructura_costos_recursos = selectDestructura_costos_recursos;
    }

    /**
     * @return the subtotal_ecosto
     */
    public Float getSubtotal_ecosto() {
        return subtotal_ecosto;
    }

    /**
     * @param subtotal_ecosto the subtotal_ecosto to set
     */
    public void setSubtotal_ecosto(Float subtotal_ecosto) {
        this.subtotal_ecosto = subtotal_ecosto;
    }

    /**
     * @return the go_ecosto
     */
    public Float getGo_ecosto() {
        return go_ecosto;
    }

    /**
     * @param go_ecosto the go_ecosto to set
     */
    public void setGo_ecosto(Float go_ecosto) {
        this.go_ecosto = go_ecosto;
    }

    /**
     * @return the ga_ecosto
     */
    public Float getGa_ecosto() {
        return ga_ecosto;
    }

    /**
     * @param ga_ecosto the ga_ecosto to set
     */
    public void setGa_ecosto(Float ga_ecosto) {
        this.ga_ecosto = ga_ecosto;
    }

    /**
     * @return the u_ecosto
     */
    public Float getU_ecosto() {
        return u_ecosto;
    }

    /**
     * @param u_ecosto the u_ecosto to set
     */
    public void setU_ecosto(Float u_ecosto) {
        this.u_ecosto = u_ecosto;
    }

    /**
     * @return the total_ecosto
     */
    public Float getTotal_ecosto() {
        return total_ecosto;
    }

    /**
     * @param total_ecosto the total_ecosto to set
     */
    public void setTotal_ecosto(Float total_ecosto) {
        this.total_ecosto = total_ecosto;
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


}
