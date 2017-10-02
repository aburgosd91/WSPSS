/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Documento_movilDao;
import com.nisira.core.entity.Documento_movil;

import com.nisira.core.dao.AppmovilusuarioDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Appmovilusuario;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Usuario;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.Encryption;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.Serializable;
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
@ManagedBean(name = "mDocumento_movilAction")
@SessionScoped
public class mDocumento_movilAction extends AbstactListAction<Documento_movil> implements Serializable{
    private String mensaje;
    private Documentos selectDocumento;
    private Documento_movilDao documento_movilDao;
    private UsuarioBean user;
    public mDocumento_movilAction() {
        mensaje = "";
        documento_movilDao = new Documento_movilDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_mDocumento_movil");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(documento_movilDao.listarPorEmpresaService(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public String getIniciar() {
        mensaje = "";
        documento_movilDao = new Documento_movilDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_mDocumento_movil");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Documento_movil());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarEdicion() {
        if (getDatoEdicion().getIdempresa() == null) {
            return false;
        }
        return true;
    }

    @Override
     public void grabar() {
        try {
            if(getDatoEdicion().getIddocumento()==null){
                this.mensaje="Seleccionar Usuario";
                WebUtil.MensajeAdvertencia(this.mensaje);
            }else{
                if(getLadd()==1){
                    documento_movilDao.grabar(1, getDatoEdicion());
                }else if(getLadd()==2){
                    documento_movilDao.grabar(2, getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Documento_movil ","OK"));
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
    /*public void grabar() {
        try {
            if (validarEdicion()) {
                if(getLadd()==1){
                    mensaje = documento_movilDao.grabar(1,getDatoEdicion());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIddocumento(mensaje.trim());
                }
                else if(getLadd()==2){
                    mensaje = documento_movilDao.grabar(2,getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Documento_movil ", mensaje));
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
    } */

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                documento_movilDao.grabar(3,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                documento_movilDao.grabar(4,getDatoEdicion());
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
    
    public void verCntDocumento() {
        RequestContext.getCurrentInstance().openDialog("cntDocumentoCodigosunat", modalOptions, null);
    }

    public void valorDocumento(SelectEvent event) {
        this.setSelectDocumento((Documentos) event.getObject());        
        getDatoEdicion().setIddocumento(getSelectDocumento().getIddocumento());
        getDatoEdicion().setDescripcion(getSelectDocumento().getDescripcion());
        getDatoEdicion().setEstado(getSelectDocumento().getEstado());
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
     * @return the selectDocumento
     */
    public Documentos getSelectDocumento() {
        return selectDocumento;
    }

    /**
     * @param selectDocumento the selectUsuario to set
     */
    public void setSelectDocumento(Documentos selectDocumento) {
        this.selectDocumento = selectDocumento;
    }

}