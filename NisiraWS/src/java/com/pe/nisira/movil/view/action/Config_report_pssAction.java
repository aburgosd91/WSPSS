/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.RutaDao;
import com.nisira.core.dao.Config_report_pssDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Config_report_pss;
import com.nisira.core.entity.Wtiposervicio;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@ManagedBean(name = "config_report_pssAction")
@SessionScoped
public class Config_report_pssAction extends AbstactListAction<Config_report_pss> implements Serializable {

    private String mensaje;
    private Config_report_pssDao config_report_pssDao;
    private WtiposervicioDao wtiposervicioDao; 
    private UsuarioBean user;
    private boolean estado;
    private List<Wtiposervicio> lstWtiposervicio;
    public Config_report_pssAction() {
        mensaje = "";
        lstWtiposervicio = new ArrayList<>();
        config_report_pssDao = new Config_report_pssDao();
        wtiposervicioDao = new WtiposervicioDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        actualiza_ventana("wMnt_Config_report_pss");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(config_report_pssDao.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public String getIniciar() {
        mensaje = "";
        config_report_pssDao = new Config_report_pssDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Config_report_pss");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Config_report_pss());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setEstado(1);
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getDato1()== null) {
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validarEdicion()) {
                if(getLadd()==1){
                    mensaje = config_report_pssDao.grabar(1,getDatoEdicion());
                    if(mensaje!=null)
                        if(mensaje.trim()!=null)
                            getDatoEdicion().setIdconfig_report(mensaje.trim());
                }
                else if(getLadd()==2){
                    getDatoEdicion().setEstado(estado?1:0);
                    mensaje = config_report_pssDao.grabar(2,getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Ruta ", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
//                buscarTodo();
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenliquidaciongastoAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0);
                config_report_pssDao.grabar(3,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setEstado(2);
                config_report_pssDao.grabar(4,getDatoEdicion());
            }
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            Logger.getLogger(Config_report_pssAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void findDetalle(){
        try {
            if(getDatoEdicion()!=null){
                estado = getDatoEdicion().getEstado()==0?false:true;
            }
            setLstWtiposervicio(wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA()));
        } catch (NisiraORMException ex) {
            Logger.getLogger(Config_report_pssAction.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the lstWtiposervicio
     */
    public List<Wtiposervicio> getLstWtiposervicio() {
        return lstWtiposervicio;
    }

    /**
     * @param lstWtiposervicio the lstWtiposervicio to set
     */
    public void setLstWtiposervicio(List<Wtiposervicio> lstWtiposervicio) {
        this.lstWtiposervicio = lstWtiposervicio;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
