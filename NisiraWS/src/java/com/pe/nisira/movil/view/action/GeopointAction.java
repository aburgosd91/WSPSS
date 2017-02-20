/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.GeopointDao;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "geopointAction")
@SessionScoped
public class GeopointAction extends AbstactListAction<Geopoint> implements Serializable {
    /* NOTAS:
     0-> Visualizar
     1-> Nuevo
     2-> Modificar
     */
    private String mensaje;
    private GeopointDao geopointDao;
    private UsuarioBean user;
    private boolean estado;
    private MapModel geoModel;
    private MapModel revGeoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    private String centerRevGeoMap = "41.850033, -87.6500523";
    private int nuevod;
    private Gmap selectGmap;
    public GeopointAction() {
        mensaje = "";
        geopointDao = new GeopointDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado=true;
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
        actualiza_ventana("wMnt_geopoint");
    }
    
    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(getGeopointDao().listarPorEmpresaWeb());
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        setGeopointDao(new GeopointDao());
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
        actualiza_ventana("wMnt_geopoint");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Geopoint());
            getDatoEdicion().setEstado(1);
            nuevod = 1;
            estado=true;
            RequestContext.getCurrentInstance().update("datos:dlGuardarGeopoint");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarGeopoint').show()");

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    @Override
    public void doNuevo() throws IOException {
        setLadd(1);
        nuevo();        
    }
    @Override
    public void grabar() {
        try {
            if (getDatoEdicion().getDescripcion().equals("")) {
                this.setMensaje("Ingrese Descripción");
            } else if (getDatoEdicion().getLatitud().isEmpty()) {
                this.setMensaje("Ingrese Latitud");
            }else if (getDatoEdicion().getLongitud().isEmpty()) {
                this.setMensaje("Ingrese Longitud");
            } else {
                if (nuevod == 1) {//Nuevo
                    if(estado)
                        getDatoEdicion().setEstado(1);
                    else
                        getDatoEdicion().setEstado(0);
                    mensaje = getGeopointDao().grabar(nuevod,getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Geopoint " + mensaje+ " registrado con éxito.");
                    }
                    estado=true;
                } else if (nuevod == 2) {//Modificar
                    if(estado)
                        getDatoEdicion().setEstado(1);
                    else
                        getDatoEdicion().setEstado(0);
                    mensaje = getGeopointDao().grabar(nuevod,getDatoEdicion());
                    if (!mensaje.equals("")) {
                        WebUtil.info("Geopoint " + mensaje + " actualizado con éxito.");
                    }
                }
                RequestContext.getCurrentInstance().execute("PF('dlGuardarGeopoint').hide()");
            }
            buscarTodo();
//            RequestContext.getCurrentInstance().update("datos");
//            RequestContext.getCurrentInstance().update("datos:tbl");
            return;
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.MensajeError(mensaje);
            return;
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                mensaje = getGeopointDao().grabar(2,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
                mensaje = getGeopointDao().grabar(2,getDatoEdicion());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(GeopointAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            setLadd(2);
            nuevod = 2;
            setDatoEdicion(getDatoSeleccionado());
            if(getDatoEdicion().getEstado()==1)
                estado=true;
            else
                estado=false;
            RequestContext.getCurrentInstance().update("datos:dlGuardarGeopoint");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarGeopoint').show()");
            setDatoEdicion(getDatoSeleccionado());

        }
    }
    public void openGMap() {
        RequestContext.getCurrentInstance().openDialog("cnt_geocode", modalGoogleMapOptions, null);
    }
    public void valorGMap(SelectEvent event) {
        this.selectGmap = (Gmap) event.getObject();
        getDatoEdicion().setLatitud(selectGmap.getLatitud());
        getDatoEdicion().setLongitud(selectGmap.getLongitud());
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNuevod() {
        return nuevod;
    }

    public void setNuevod(int nuevod) {
        this.nuevod = nuevod;
    }

    /**
     * @return the geopointDao
     */
    public GeopointDao getGeopointDao() {
        return geopointDao;
    }

    /**
     * @param geopointDao the geopointDao to set
     */
    public void setGeopointDao(GeopointDao geopointDao) {
        this.geopointDao = geopointDao;
    }

    /**
     * @return the geoModel
     */
    public MapModel getGeoModel() {
        return geoModel;
    }

    /**
     * @param geoModel the geoModel to set
     */
    public void setGeoModel(MapModel geoModel) {
        this.geoModel = geoModel;
    }

    /**
     * @return the revGeoModel
     */
    public MapModel getRevGeoModel() {
        return revGeoModel;
    }

    /**
     * @param revGeoModel the revGeoModel to set
     */
    public void setRevGeoModel(MapModel revGeoModel) {
        this.revGeoModel = revGeoModel;
    }

    /**
     * @return the centerGeoMap
     */
    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    /**
     * @param centerGeoMap the centerGeoMap to set
     */
    public void setCenterGeoMap(String centerGeoMap) {
        this.centerGeoMap = centerGeoMap;
    }

    /**
     * @return the centerRevGeoMap
     */
    public String getCenterRevGeoMap() {
        return centerRevGeoMap;
    }

    /**
     * @param centerRevGeoMap the centerRevGeoMap to set
     */
    public void setCenterRevGeoMap(String centerRevGeoMap) {
        this.centerRevGeoMap = centerRevGeoMap;
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

}
