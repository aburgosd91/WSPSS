/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Privilegio_global_pssDao;
import com.nisira.core.entity.Privilegio_global_pss;
import com.nisira.core.entity.Usuario;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
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
@ManagedBean(name = "privilegio_global_pssAction")
@SessionScoped
public class Privilegio_global_pssAction extends AbstactListAction<Privilegio_global_pss> implements Serializable {

    private String mensaje;
    private Usuario selectUsuario;
    private Privilegio_global_pssDao privilegio_global_pssDao;
    private UsuarioBean user;
    public Privilegio_global_pssAction() {
        mensaje = "";
        privilegio_global_pssDao = new Privilegio_global_pssDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Privilegio_global_pss");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(privilegio_global_pssDao.listarPorUsuario(null));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public String getIniciar() {
        mensaje = "";
        privilegio_global_pssDao = new Privilegio_global_pssDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Privilegio_global_pss");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Privilegio_global_pss());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getIdusuario() == null) {
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validarEdicion()) {
                if(getLadd()==1){
                    mensaje = privilegio_global_pssDao.grabar(1,getDatoEdicion());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdusuario(mensaje.trim());
                }
                else if(getLadd()==2){
                    mensaje = privilegio_global_pssDao.grabar(2,getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Privilegio_global_pss ", mensaje));
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
                privilegio_global_pssDao.grabar(3,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                privilegio_global_pssDao.grabar(4,getDatoEdicion());
            }
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            Logger.getLogger(Privilegio_global_pssAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void findDetalle(){
        if(getDatoEdicion()!=null){
        }
    }
    
    public void verCntUsuario() {
        RequestContext.getCurrentInstance().openDialog("cntUsuario", modalOptions, null);
    }

    public void valorUsuario(SelectEvent event) {
        this.setSelectUsuario((Usuario) event.getObject());
        getDatoEdicion().setIdusuario(getSelectUsuario().getIdusuario());
        getDatoEdicion().setUsuario(getSelectUsuario().getUsr_nombres());
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String buscarFiltro(int tipo) {
        return "";
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

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
