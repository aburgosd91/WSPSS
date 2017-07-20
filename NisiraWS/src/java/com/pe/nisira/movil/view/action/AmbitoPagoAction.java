/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Ambito_pagoDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.entity.Ambito_pago;
import com.nisira.core.entity.Ambito_pago_costomo;
import com.nisira.core.entity.Ambito_pago_rutas;
import com.nisira.core.entity.Cargos_personal;
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
@ManagedBean(name = "ambitoPagoAction")
@SessionScoped
public class AmbitoPagoAction extends AbstactListAction<Ambito_pago> implements Serializable {

    private String mensaje;
    private Ambito_pagoDao ambitopagoDao;
    private List<Rutas> lstRutas;
    private List<Ambito_pago_rutas> lstambpagRuta;
    private List<Ambito_pago_costomo> lstampagcost;
    private Ambito_pago_costomo slcampagcost;
    private Ambito_pago_costomo workampagcost;
    private Ambito_pago_rutas slcAmbPagRuta;

    private Rutas slcRutas;
    private UsuarioBean user;
    private boolean estado;
    private boolean vvisible;

    public AmbitoPagoAction() {
        mensaje = "";
        ambitopagoDao = new Ambito_pagoDao();
        lstRutas = new ArrayList<Rutas>();
        lstambpagRuta = new ArrayList<Ambito_pago_rutas>();
        slcAmbPagRuta = new Ambito_pago_rutas();
        lstampagcost = new ArrayList<Ambito_pago_costomo>();
        slcampagcost = new Ambito_pago_costomo();
        workampagcost = new Ambito_pago_costomo();
        slcRutas = new Rutas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        actualiza_ventana("wMnt_Ambito_Pago");
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(ambitopagoDao.lstAmbitoEmpresa(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        ambitopagoDao = new Ambito_pagoDao();
        lstRutas = new ArrayList<Rutas>();
        lstambpagRuta = new ArrayList<Ambito_pago_rutas>();
        lstampagcost = new ArrayList<Ambito_pago_costomo>();
        slcampagcost = new Ambito_pago_costomo();
        workampagcost = new Ambito_pago_costomo();
        slcRutas = new Rutas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        actualiza_ventana("wMnt_Ambito_Pago");
        return "";
    }

    public void findDetalle() {
        try {
            lstRutas = (new RutasDao()).listarPorEmpresaWeb(user.getIDEMPRESA());
            if (getDatoEdicion().getCodigo() != null) {/*EDIT*/
                lstambpagRuta = ambitopagoDao.detAmbitoPagos(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo());
                lstampagcost = ambitopagoDao.detAmbitoPagosCosto(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo());
                vvisible = getDatoEdicion().getVisible() == 1.0f ? true : false;
            } else {/*NEW*/
                vvisible = true;
            }
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    public boolean validarDetalle() {
        if (!lstambpagRuta.isEmpty()) {
            for (Ambito_pago_rutas r : lstambpagRuta) {
                if (r.getIdruta().equalsIgnoreCase(slcRutas.getIdruta())) {
                    setMensaje("Ruta ya Ingresada");
                    WebUtil.MensajeAdvertencia(getMensaje());
                    return false;
                }
            }
        }
        return true;
    }

    public void verCntRutas() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }

    public void valorRutas(SelectEvent event) {
        Rutas ruta = (Rutas) event.getObject();
        workampagcost.setIdruta(ruta.getIdruta());
        workampagcost.setRuta(ruta.getDescripcion());
        workampagcost.setOrigen(ruta.getOrigendesc());
        workampagcost.setDestino(ruta.getDestinodesc());
    }

    public void verCntCargosPersonal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalOptions, null);
    }

    public void valorCargosPersonal(SelectEvent event) {
        Cargos_personal cargo = (Cargos_personal) event.getObject();
        workampagcost.setIdcargo(cargo.getIdcargo());
        workampagcost.setCargo(cargo.getDescripcion());
    }

    public void addAmbitoPagoCosto() {
        if (workampagcost.getIdcargo() != null) {
            if (workampagcost.getIdruta() != null) {
                workampagcost.setIdempresa(getDatoEdicion().getIdempresa());
                lstampagcost.add(workampagcost);
                RequestContext.getCurrentInstance().update("datos:lstAmbPagoCost");
                RequestContext.getCurrentInstance().execute("PF('costosdialog').hide()");
            } else {
                setMensaje("Seleccione La Ruta");
                WebUtil.MensajeAdvertencia(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
            }
        } else {
            setMensaje("Seleccione el Cargo");
            WebUtil.MensajeAdvertencia(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        workampagcost = new Ambito_pago_costomo();
    }

    public void editAmbitoPagoCosto() throws CloneNotSupportedException {
        if (slcampagcost != null) {
            workampagcost = (Ambito_pago_costomo) slcampagcost.clone();
            RequestContext.getCurrentInstance().execute("PF('costosdialog').show()");
            RequestContext.getCurrentInstance().update("datos:costosdialog");
        } else {
            setMensaje("Seleccione un detalle");
            WebUtil.MensajeAdvertencia(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }

    }

    public void delAmbitoPagoCosto() {
        if (slcampagcost != null) {
            lstampagcost.remove(slcampagcost);
            RequestContext.getCurrentInstance().update("datos:lstAmbPagoCost");
        } else {
            setMensaje("Seleccione un detalle");
            WebUtil.MensajeAdvertencia(getMensaje());            
            RequestContext.getCurrentInstance().update("datos:growl");
        }

    }

    public void addAmbitoPagoRuta() {
        if (validarDetalle()) {
            Ambito_pago_rutas amb = new Ambito_pago_rutas();
            amb.setIdempresa(getDatoEdicion().getIdempresa());
            amb.setIdruta(slcRutas.getIdruta());
            amb.setDescripcion(slcRutas.getDescripcion());
            amb.setOrigen(slcRutas.getOrigendesc());
            amb.setDestino(slcRutas.getDestinodesc());
            amb.setItem(WebUtil.cerosIzquierda(String.valueOf(lstambpagRuta.size() + 1), 3));
            lstambpagRuta.add(amb);
        }
        RequestContext.getCurrentInstance().update("datos:lstAmbPagoRuta");
        RequestContext.getCurrentInstance().execute("PF('rutasdialog').hide()");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public void dellAmbitoPagoRuta() {
        if (slcAmbPagRuta != null) {
            lstambpagRuta.remove(slcAmbPagRuta);
            int i = 1;
            for (Ambito_pago_rutas ap : lstambpagRuta) {
                ap.setItem(WebUtil.cerosIzquierda(String.valueOf(i), 3));
                i++;
            }
        } else {
            setMensaje("Seleccione un detalle");
        }
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:lstAmbPagoRuta");
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    @Override
    public void nuevo() {
        lstambpagRuta = new ArrayList<Ambito_pago_rutas>();
        vvisible = true;
        setDatoEdicion(new Ambito_pago());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setCosto_adicional(0.00f);
        getDatoEdicion().setCosto_por_hora(0.00f);
    }

    public boolean validar() {
        if (getDatoEdicion().getDescripcion().equalsIgnoreCase("")) {
            setMensaje("Falta Llenar Descripcion");
            return false;
        }
        if (getDatoEdicion().getCosto_por_hora() == 0.0f) {
            setMensaje("Falta Llenar Costo por Hora");
            return false;
        }
        if (lstambpagRuta.isEmpty()) {
            setMensaje("Falta Llenar Rutas");
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            getDatoEdicion().setVisible(vvisible ? 1.0f : 0.0f);
            if (validar()) {
                setMensaje(ambitopagoDao.grabar(getDatoEdicion(), lstambpagRuta,lstampagcost));
                if (mensaje != null) {
                    if (mensaje.trim().length() == 6) {
                        getDatoEdicion().setCodigo(mensaje.trim());
                    }
                }
                setMensaje(WebUtil.exitoRegistrar("Ambito de Pago ", mensaje));
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

            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                ambitopagoDao.delAmbitopago(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo());
            }
            lista_accion_filtro("wLst_Ambito_Pago");
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Rutas> getLstRutas() {
        return lstRutas;
    }

    public void setLstRutas(List<Rutas> lstRutas) {
        this.lstRutas = lstRutas;
    }

    public List<Ambito_pago_rutas> getLstambpagRuta() {
        return lstambpagRuta;
    }

    public Ambito_pago_rutas getSlcAmbPagRuta() {
        return slcAmbPagRuta;
    }

    public void setSlcAmbPagRuta(Ambito_pago_rutas slcAmbPagRuta) {
        this.slcAmbPagRuta = slcAmbPagRuta;
    }

    public void setLstambpagRuta(List<Ambito_pago_rutas> lstambpagRuta) {
        this.lstambpagRuta = lstambpagRuta;
    }

    public Rutas getSlcRutas() {
        return slcRutas;
    }

    public void setSlcRutas(Rutas slcRutas) {
        this.slcRutas = slcRutas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the vvisible
     */
    public boolean isVvisible() {
        return vvisible;
    }

    /**
     * @param vvisible the vvisible to set
     */
    public void setVvisible(boolean vvisible) {
        this.vvisible = vvisible;
    }

    public List<Ambito_pago_costomo> getLstampagcost() {
        return lstampagcost;
    }

    public void setLstampagcost(List<Ambito_pago_costomo> lstampagcost) {
        this.lstampagcost = lstampagcost;
    }

    public Ambito_pago_costomo getSlcampagcost() {
        return slcampagcost;
    }

    public void setSlcampagcost(Ambito_pago_costomo slcampagcost) {
        this.slcampagcost = slcampagcost;
    }

    public Ambito_pago_costomo getWorkampagcost() {
        return workampagcost;
    }

    public void setWorkampagcost(Ambito_pago_costomo workampagcost) {
        this.workampagcost = workampagcost;
    }

}
