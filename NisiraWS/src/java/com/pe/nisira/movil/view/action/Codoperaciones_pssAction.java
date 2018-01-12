/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;
import com.nisira.core.dao.Codoperaciones_pssDao;
import com.nisira.core.entity.Codoperaciones_pss;
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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "codoperaciones_pssAction")
@SessionScoped
public class Codoperaciones_pssAction extends AbstactListAction<Codoperaciones_pss>  implements Serializable {

    private String mensaje;
    private Codoperaciones_pssDao codoperaciones_pssDao;
    private UsuarioBean user;
    private boolean estado;
    private boolean flag_pk;
    public Codoperaciones_pssAction() {
        mensaje = "";
        codoperaciones_pssDao = new Codoperaciones_pssDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        flag_pk = false;
        actualiza_ventana("wMnt_Codoperaciones_pss");
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(codoperaciones_pssDao.listarPorEmpresaWeb());
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }
    
    @Override
    public String getIniciar() {
        mensaje = "";
        codoperaciones_pssDao = new Codoperaciones_pssDao();
        setUser((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO));
        actualiza_ventana("wMnt_Codoperaciones_pss");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            setDatoEdicion(new Codoperaciones_pss());
            getDatoEdicion().setEstado(1.0f);
            estado = true;
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
                    mensaje = codoperaciones_pssDao.grabar(1,getDatoEdicion());
                    if(mensaje!=null)
                        if(mensaje.trim()!=null)
                            getDatoEdicion().setIdcodoperaciones(mensaje.trim());
                }
                else if(getLadd()==2){
                    getDatoEdicion().setEstado(estado?1.0f:0.0f);
                    mensaje = codoperaciones_pssDao.grabar(2,getDatoEdicion());
                }
                setMensaje(WebUtil.exitoRegistrar("Código Operaciones ", mensaje));
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
                codoperaciones_pssDao.grabar(3,getDatoEdicion());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                codoperaciones_pssDao.grabar(4,getDatoEdicion());
            }
            lista_accion_filtro("wLst_Codoperaciones_pss");
        } catch (Exception ex) {
            Logger.getLogger(Codoperaciones_pssAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void verCntWtiposervicioAction(){
        RequestContext.getCurrentInstance().openDialog("cntWtiposervicio", modalOptions, null);
    }
    public void valorCntWtiposervicio(SelectEvent event) {
        Wtiposervicio obj = ((Wtiposervicio) event.getObject());
        getDatoEdicion().setIdtiposervicio(obj.getIdtiposervicio());
        getDatoEdicion().setTiposervicio(obj.getDescripcion());
        getDatoEdicion().setTiposervicio_corto(obj.getDescripcion_corta());
    }
    public void findDetalle(){
        if(getDatoEdicion()!=null){
            estado = getDatoEdicion().getEstado()==0.0?false:true;
        }
        if(getLadd()==1){/*nuevo*/
            flag_pk=false;
        }else if(getLadd()==2){/*editar*/
            flag_pk=true;
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

    /**
     * @return the flag_pk
     */
    public boolean isFlag_pk() {
        return flag_pk;
    }

    /**
     * @param flag_pk the flag_pk to set
     */
    public void setFlag_pk(boolean flag_pk) {
        this.flag_pk = flag_pk;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
