/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Wtiposervicio;
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

/**
 *
 * @author azamora
 */
@ManagedBean(name = "wtiposervicioAction")
@SessionScoped
public class WtiposervicioAction extends AbstactListAction<Wtiposervicio> implements Serializable {

    private String mensaje;
    private WtiposervicioDao wtiposervicioDao;
    private UsuarioBean user;
    private boolean estado;
    public WtiposervicioAction() {
        mensaje = "";
        wtiposervicioDao = new WtiposervicioDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        actualiza_ventana("wMnt_Wtiposervicio");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public String getIniciar() {
        mensaje = "";
        wtiposervicioDao = new WtiposervicioDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_Wtiposervicio");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Wtiposervicio());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
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
                    mensaje = wtiposervicioDao.grabar(1,getDatoEdicion());
                    if(mensaje!=null)
                        if(mensaje.trim()!=null)
                            getDatoEdicion().setIdtiposervicio(mensaje.trim());
                }
                else if(getLadd()==2){
                    mensaje = wtiposervicioDao.grabar(2,getDatoEdicion());
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
                wtiposervicioDao.grabar(3,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                wtiposervicioDao.grabar(4,getDatoEdicion());
            }
            lista_accion_filtro("wLst_Wtiposervicio");
        } catch (Exception ex) {
            Logger.getLogger(WtiposervicioAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void findDetalle(){
        if(getDatoEdicion()!=null){
            //estado = getDatoEdicion().getEstado()==0.0?false:true;
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

}
