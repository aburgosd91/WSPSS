/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AppmovilusuarioDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Appmovilusuario;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Usuario;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.Encryption;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
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
 * @author aburgos
 */
@ManagedBean(name = "mUsuarioAction")
@SessionScoped
public class mUsuarioAction extends AbstactListAction<Appmovilusuario>{
    /***********CONTROLS**************/
    private String mensaje;
    /***********ARRAYLIST**************/
    /***********ENTITY**************/
    private Usuario selectUsuario;
    private Clieprov selectClieprov;
    private UsuarioBean user;
    /*************DAO***************/
    private UsuarioDao usuDao;
    private AppmovilusuarioDao appmovilusuarioDao;
    public mUsuarioAction() {
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        appmovilusuarioDao = new AppmovilusuarioDao();
        this.selectUsuario = new Usuario();
        this.usuDao = new UsuarioDao();
        mensaje="";
        actualiza_ventana("wMnt_mUsuarios");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(appmovilusuarioDao.getPorEmpresa(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        this.selectUsuario = new Usuario();
        this.usuDao = new UsuarioDao();
        appmovilusuarioDao = new AppmovilusuarioDao();
        actualiza_ventana("wMnt_mUsuarios");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Appmovilusuario());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
    }

    @Override
    public void grabar() {
        try {
            if(getDatoEdicion().getIdusuario()==null){
                this.mensaje="Seleccionar Usuario";
                WebUtil.MensajeAdvertencia(this.mensaje);
            }
            if(getDatoEdicion().getIdclieprov()==null){
                this.mensaje="Seleccionar Cliente";
                WebUtil.MensajeAdvertencia(this.mensaje);
            }else{
                if(getLadd()==1){
                    appmovilusuarioDao.grabar(1, getDatoEdicion());
                }else if(getLadd()==2){
                    appmovilusuarioDao.grabar(2, getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Usuario Movil ","OK"));
                WebUtil.info(getMensaje());
                setLvalidate(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje=ex.getMessage();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    @Override
    public void eliminar() {
        if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
            try {
                if(getDatoEdicion().getIdusuario()==null){
                    this.mensaje="Seleccionar Usuario";
                    WebUtil.MensajeAdvertencia(this.mensaje);
                }
                if(getDatoEdicion().getIdclieprov()==null){
                    this.mensaje="Seleccionar Cliente";
                    WebUtil.MensajeAdvertencia(this.mensaje);
                }else{
                    appmovilusuarioDao.grabar(3, getDatoEdicion());
                    setMensaje(WebUtil.exitoRegistrar("Usuario Movil ","OK"));
                    WebUtil.info(getMensaje());
                    setLvalidate(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                this.mensaje=ex.getMessage();
                WebUtil.error(mensaje);
            }
            RequestContext.getCurrentInstance().update("datos");
        }
        if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
            try {
                if(getDatoEdicion().getIdusuario()==null){
                    this.mensaje="Seleccionar Usuario";
                    WebUtil.MensajeAdvertencia(this.mensaje);
                }
                if(getDatoEdicion().getIdclieprov()==null){
                    this.mensaje="Seleccionar Cliente";
                    WebUtil.MensajeAdvertencia(this.mensaje);
                }else{
                    appmovilusuarioDao.grabar(3, getDatoEdicion());
                    setMensaje(WebUtil.exitoRegistrar("Usuario Movil ","OK"));
                    WebUtil.info(getMensaje());
                    setLvalidate(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(mUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                this.mensaje=ex.getMessage();
                WebUtil.error(mensaje);
            }
            RequestContext.getCurrentInstance().update("datos");
        }
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void verCntUsuario() {
        RequestContext.getCurrentInstance().openDialog("cntUsuario", modalOptions, null);
    }

    public void valorUsuario(SelectEvent event) {
        this.selectUsuario = (Usuario) event.getObject();
        getDatoEdicion().setIdusuario(selectUsuario.getIdusuario());
        getDatoEdicion().setUsuario(selectUsuario.getUsr_nombres());
    }
    public void verCntClieprovAppmovil() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovAppmovil", modalOptions, null);
    }

    public void valorClieprovAppmovil(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setCliente(selectClieprov.getRazonsocial());
    }
    
    public Usuario getSlcUsu() {
        return selectUsuario;
    }

    public void setSlcUsu(Usuario selectUsuario) {
        this.selectUsuario = selectUsuario;
    }
    /**
     * @return the selectUsuario
     */
    public Usuario getSelectUsuario() {
        return selectUsuario;
    }

    /**
     * @param selectUsuario the selectUsuario to set
     */
    public void setSelectUsuario(Usuario selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    /**
     * @return the usuDao
     */
    public UsuarioDao getUsuDao() {
        return usuDao;
    }

    /**
     * @param usuDao the usuDao to set
     */
    public void setUsuDao(UsuarioDao usuDao) {
        this.usuDao = usuDao;
    }

    /**
     * @return the appmovilusuarioDao
     */
    public AppmovilusuarioDao getAppmovilusuarioDao() {
        return appmovilusuarioDao;
    }

    /**
     * @param appmovilusuarioDao the appmovilusuarioDao to set
     */
    public void setAppmovilusuarioDao(AppmovilusuarioDao appmovilusuarioDao) {
        this.appmovilusuarioDao = appmovilusuarioDao;
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
