/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Area_concepto_cuentaDao;
import com.nisira.core.dao.AreasDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Area_concepto_cuenta;
import com.nisira.core.entity.Area_concepto_cuenta;
import com.nisira.core.entity.Areas;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Rutas;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
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
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author alejndro zamora
 */
@ManagedBean(name = "areasAction")
@SessionScoped
public class AreasAction extends AbstactListAction<Areas> implements Serializable {

    private List<Area_concepto_cuenta> lstDestTar;
    private Area_concepto_cuenta slctDesTar;
    private Area_concepto_cuenta newtDesTar;
    private AreasDao EstTarDao;
    private UsuarioBean user;
    private String mensaje;
    private boolean editDet;
    private boolean idestado;
    private int vpagar;
    private int vfacturar;
    public AreasAction() {
        lstDestTar = new ArrayList<Area_concepto_cuenta>();
        slctDesTar = new Area_concepto_cuenta();
        newtDesTar = new Area_concepto_cuenta();
        EstTarDao = new AreasDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        editDet = false;
        idestado = true;
        actualiza_ventana("wMnt_Areas");
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(EstTarDao.listAreas(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void findDetaller() {
        try {
            if (getDatoEdicion().getIdarea()!= null) {
                idestado = getDatoEdicion().getEstado()==1.0f?true:false;
                lstDestTar = EstTarDao.listArea_concepto_cuenta(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdarea());
                reestructurarIndex();
            }
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstDestTar = new ArrayList<Area_concepto_cuenta>();
        slctDesTar = new Area_concepto_cuenta();
        newtDesTar = new Area_concepto_cuenta();
        EstTarDao = new AreasDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        setEditDet(false);
        idestado = true;
        actualiza_ventana("wMnt_Areas");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Areas());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        lstDestTar = new ArrayList<Area_concepto_cuenta>();
        getDatoEdicion().setEstado(1.0f);
        idestado = true;
    }

    @Override
    public void grabar() {
        try {
            if (validarCab()) {
                getDatoEdicion().setEstado(idestado?1.0f:0.0f);
                setMensaje(EstTarDao.grabar(getDatoEdicion(), lstDestTar));
                if (mensaje == null) {
                    setMensaje("No se Realizo el Ingresao");
                }
                setMensaje(WebUtil.exitoRegistrar("Estructua de Tareo del Cliente: ", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
            }
            RequestContext.getCurrentInstance().update("datos:growl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                EstTarDao.delAreas(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdarea(), 1);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                EstTarDao.delAreas(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdarea(), 2);
            }
            lista_accion_filtro("wLst_Areas");
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aprobar() {
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

    public void verCntConcepto_cuenta() {
        RequestContext.getCurrentInstance().openDialog("cntConcepto_cuenta", modalOptions, null);
    }

    public void valorConcepto_cuenta(SelectEvent event) {
        Concepto_cuenta slcConcepto_cuenta = ((Concepto_cuenta) event.getObject());
        newtDesTar.setIdconcepto(slcConcepto_cuenta.getIdconcepto());
        newtDesTar.setConcepto(slcConcepto_cuenta.getDescripcion());
        newtDesTar.setDescripcion(slcConcepto_cuenta.getDescripcion());
        newtDesTar.setIdcuenta(slcConcepto_cuenta.getIdcuenta());
    }

    public void verCntclearConcepto_cuenta() {
        newtDesTar.setIdconcepto(null);
        newtDesTar.setConcepto(null);
        newtDesTar.setIdcuenta(null);
        newtDesTar.setDescripcion(null);
    }

    public boolean validarCab() {
        if (lstDestTar.isEmpty()) {
            setMensaje("Debe Llena el Detalle");
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (getDatoEdicion().getDescripcion() == null || getDatoEdicion().getDescripcion().equalsIgnoreCase("")) {
            setMensaje("Falta Llenar Descripcion");
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        return true;
    }

    public boolean validadDetalle() {
        if (newtDesTar.getIdconcepto()== null) {
            setMensaje("Falta Llenar Concepto");
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (newtDesTar.getDescripcion() == null || newtDesTar.getDescripcion().equalsIgnoreCase("")) {
            setMensaje("Falta Llenar Descripcion");
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        return true;
    }

    public void openDialog() {
        if (getDatoEdicion().getDescripcion()!= null) {
            newtDesTar = new Area_concepto_cuenta();
            newtDesTar.setIdempresa(getDatoEdicion().getIdempresa());
            newtDesTar.setIdarea(getDatoEdicion().getIdarea());
            newtDesTar.setDescripcion("");
            newtDesTar.setIdconcepto("");
            newtDesTar.setIdcuenta("");
            RequestContext.getCurrentInstance().update("datos:detEstrDialog");
            RequestContext.getCurrentInstance().execute("PF('detEstrDialog').show()");
            setEditDet(false);
        } else {
            this.mensaje = "Ingresar Descripción";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    public void ediitDetEstruc() throws CloneNotSupportedException {
        if (slctDesTar != null) {
            newtDesTar =(Area_concepto_cuenta) slctDesTar.clone();
            setEditDet(true);
            RequestContext.getCurrentInstance().update("datos:detEstrDialog");
            RequestContext.getCurrentInstance().execute("PF('detEstrDialog').show()");
        } else {
            setMensaje("Seleccione un detalle");
            WebUtil.MensajeAdvertencia(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }

    }
    public void addDetEstruc() {
        if (validadDetalle()) {
            int pos = -1;
            if(!lstDestTar.isEmpty())
                pos=lstDestTar.indexOf(slctDesTar);
            newtDesTar.setIdempresa(getDatoEdicion().getIdempresa());
            newtDesTar.setIdarea(getDatoEdicion().getIdarea());
            if (!isEditDet()) {
                boolean idExists = lstDestTar.stream()
                    .anyMatch(t -> (t.getIdconcepto().equals(newtDesTar.getIdconcepto())));
                if(idExists){
                    setMensaje("Concepto: "+newtDesTar.getConcepto()+" - Cuenta: "+newtDesTar.getIdcuenta()+
                            ", se encuentra registrado.");
                    WebUtil.MensajeAdvertencia(getMensaje());            
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    lstDestTar.add(newtDesTar);
                }
            }
            else{
                lstDestTar.set(pos, newtDesTar);
            }
            reestructurarIndex();
            RequestContext.getCurrentInstance().update("datos:lstDetEstruClie");
            RequestContext.getCurrentInstance().execute("PF('detEstrDialog').hide()");
        }
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void dellDetEstruc() {
        if (slctDesTar != null) {
            lstDestTar.remove(slctDesTar);
            reestructurarIndex();
            setEditDet(false);
            setMensaje("Registro se elimino correctamente!");
        } else {
            setMensaje("Seleccione un detalle");
        }
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:lstDetEstruClie");
        RequestContext.getCurrentInstance().update("datos:growl");
    }
    
    public void reestructurarIndex(){
        Area_concepto_cuenta destr;
        for(int i=0;i<lstDestTar.size();i++){
            destr = lstDestTar.get(i);
            destr.setItem(WebUtil.cerosIzquierda(i+1, 3));
            lstDestTar.set(i, destr);
        }
    }
    public List<Area_concepto_cuenta> getLstDestTar() {
        return lstDestTar;
    }

    public void setLstDestTar(List<Area_concepto_cuenta> lstDestTar) {
        this.lstDestTar = lstDestTar;
    }

    public Area_concepto_cuenta getSlctDesTar() {
        return slctDesTar;
    }

    public void setSlctDesTar(Area_concepto_cuenta slctDesTar) {
        this.slctDesTar = slctDesTar;
    }

    public Area_concepto_cuenta getNewtDesTar() {
        return newtDesTar;
    }

    public void setNewtDesTar(Area_concepto_cuenta newtDesTar) {
        this.newtDesTar = newtDesTar;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the vpagar
     */
    public int getVpagar() {
        return vpagar;
    }

    /**
     * @param vpagar the vpagar to set
     */
    public void setVpagar(int vpagar) {
        this.vpagar = vpagar;
    }

    /**
     * @return the vfacturar
     */
    public int getVfacturar() {
        return vfacturar;
    }

    /**
     * @param vfacturar the vfacturar to set
     */
    public void setVfacturar(int vfacturar) {
        this.vfacturar = vfacturar;
    }

    /**
     * @return the idestado
     */
    public boolean isIdestado() {
        return idestado;
    }

    /**
     * @param idestado the idestado to set
     */
    public void setIdestado(boolean idestado) {
        this.idestado = idestado;
    }

    /**
     * @return the editDet
     */
    public boolean isEditDet() {
        return editDet;
    }

    /**
     * @param editDet the editDet to set
     */
    public void setEditDet(boolean editDet) {
        this.editDet = editDet;
    }

}
