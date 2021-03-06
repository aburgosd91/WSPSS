/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Estructura_tareo_clieprovDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Destructura_tareo_clieprov;
import com.nisira.core.entity.Estructura_tareo_clieprov;
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
@ManagedBean(name = "estructuraTareoClieprovAction")
@SessionScoped
public class EstructuraTareoClieprovAction extends AbstactListAction<Estructura_tareo_clieprov> implements Serializable {

    private List<Destructura_tareo_clieprov> lstDestTar;
    private Destructura_tareo_clieprov slctDesTar;
    private Destructura_tareo_clieprov newtDesTar;
    private Estructura_tareo_clieprovDao EstTarDao;
    private UsuarioBean user;
    private String mensaje;
    private boolean editDet;
    private int vpagar;
    private int vfacturar;
    public EstructuraTareoClieprovAction() {
        lstDestTar = new ArrayList<Destructura_tareo_clieprov>();
        slctDesTar = new Destructura_tareo_clieprov();
        newtDesTar = new Destructura_tareo_clieprov();
        EstTarDao = new Estructura_tareo_clieprovDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        editDet = false;
        actualiza_ventana("wMnt_EstructuraTareoClieprov");
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarTodo() {
        try {
            getIniciar();
            setListaDatos(EstTarDao.listEstructuraTare(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void findDetaller() {
        try {
            newtDesTar.setBEFecha(true);
            if (getDatoEdicion().getIdclieprov() != null) {
                lstDestTar = EstTarDao.listDEstructuraTare(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdclieprov());
            }
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstDestTar = new ArrayList<Destructura_tareo_clieprov>();
        slctDesTar = new Destructura_tareo_clieprov();
        newtDesTar = new Destructura_tareo_clieprov();
        EstTarDao = new Estructura_tareo_clieprovDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        editDet = false;
        actualiza_ventana("wMnt_EstructuraTareoClieprov");
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Estructura_tareo_clieprov());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        lstDestTar = new ArrayList<Destructura_tareo_clieprov>();
        getDatoEdicion().setBEstado(true);
        newtDesTar.setBEFecha(true);
    }

    @Override
    public void grabar() {
        try {
            if (validarCab()) {

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
                EstTarDao.delEstruc(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdclieprov(), 1);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                EstTarDao.delEstruc(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdclieprov(), 2);
            }
            lista_accion_filtro("wLst_EstructuraTareoClieprov");
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

    public void verCntRuta() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }

    public void valorRuta(SelectEvent event) {
        Rutas slcRutas = ((Rutas) event.getObject());
        newtDesTar.setIdruta(slcRutas.getIdruta());
        newtDesTar.setRuta(slcRutas.getDescripcion());
    }

    public void verCntclearRuta() {
        newtDesTar.setIdruta(null);
        newtDesTar.setRuta(null);
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
        if (newtDesTar.getHoraH() == null) {
            setMensaje("Falta Llenar Hora");
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
        if (getDatoEdicion().getIdclieprov() != null) {
            newtDesTar = new Destructura_tareo_clieprov();
            newtDesTar.setBEFecha(true);
            newtDesTar.setInipagar(0.0f);
            newtDesTar.setFinpagar(0.0f);
            newtDesTar.setInifactura(0.0f);
            newtDesTar.setFinfactura(0.0f);
            RequestContext.getCurrentInstance().update("datos:detEstrDialog");
            RequestContext.getCurrentInstance().execute("PF('detEstrDialog').show()");
            editDet = false;
        } else {
            this.mensaje = "Seleccionar Cliente";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    public void ediitDetEstruc() throws CloneNotSupportedException {
        if (slctDesTar != null) {
            newtDesTar =(Destructura_tareo_clieprov) slctDesTar.clone();
            editDet = true;
            vpagar = 0;
            vfacturar = 0;
            if(newtDesTar.getInipagar().floatValue()==1.0f)
                vpagar =1;
            else if(newtDesTar.getFinpagar().floatValue()==1.0f)
                vpagar =2;
            if(newtDesTar.getInifactura().floatValue()==1.0f)
                vfacturar =1;
            else if(newtDesTar.getFinfactura().floatValue()==1.0f)
                vfacturar =2;
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
            newtDesTar.setIdclieprov(getDatoEdicion().getIdclieprov());
            newtDesTar.setHora(WebUtil.convertTimeDecimal(newtDesTar.getHoraH()));
            if(vpagar == 0){
                newtDesTar.setInipagar(0.0f);
                newtDesTar.setFinpagar(0.0f);
            }else if(vpagar == 1){
                newtDesTar.setInipagar(1.0f);
            }else if(vpagar == 2){
                newtDesTar.setFinpagar(1.0f);
            }
            if(vfacturar == 0){
                newtDesTar.setInifactura(0.0f);
                newtDesTar.setFinfactura(0.0f);
            }else if(vfacturar == 1){
                newtDesTar.setInifactura(1.0f);
            }else if(vfacturar == 2){
                newtDesTar.setFinfactura(1.0f);
            }
            if (!editDet) {
                lstDestTar.add(newtDesTar);
            }
            else
                lstDestTar.set(pos, newtDesTar);
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
            editDet = false;
            setMensaje("Registro se elimino correctamente!");
        } else {
            setMensaje("Seleccione un detalle");
        }
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:lstDetEstruClie");
        RequestContext.getCurrentInstance().update("datos:growl");
    }
    
    public void reestructurarIndex(){
        Destructura_tareo_clieprov destr;
        for(int i=0;i<lstDestTar.size();i++){
            destr = lstDestTar.get(i);
            destr.setItem(WebUtil.cerosIzquierda(i+1, 3));
            lstDestTar.set(i, destr);
        }
    }
            
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }

    public void valorClieprov(SelectEvent event) {
        Clieprov cliente = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(cliente.getIdclieprov());
        getDatoEdicion().setRazon_social(cliente.getRazonsocial());
    }

    public List<Destructura_tareo_clieprov> getLstDestTar() {
        return lstDestTar;
    }

    public void setLstDestTar(List<Destructura_tareo_clieprov> lstDestTar) {
        this.lstDestTar = lstDestTar;
    }

    public Destructura_tareo_clieprov getSlctDesTar() {
        return slctDesTar;
    }

    public void setSlctDesTar(Destructura_tareo_clieprov slctDesTar) {
        this.slctDesTar = slctDesTar;
    }

    public Destructura_tareo_clieprov getNewtDesTar() {
        return newtDesTar;
    }

    public void setNewtDesTar(Destructura_tareo_clieprov newtDesTar) {
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

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
