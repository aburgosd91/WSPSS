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
import com.nisira.core.entity.Ambito_pago_rutas;
import com.nisira.core.entity.Rutas;
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
    private Ambito_pago_rutas slcAmbPagRuta;
    private Rutas slcRutas;
    private UsuarioBean user;
    private boolean estado;

    public AmbitoPagoAction() {
        mensaje = "";
        ambitopagoDao = new Ambito_pagoDao();
        lstRutas = new ArrayList<Rutas>();
        lstambpagRuta = new ArrayList<Ambito_pago_rutas>();
        slcAmbPagRuta = new Ambito_pago_rutas();
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
        slcRutas = new Rutas();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        estado = false;
        actualiza_ventana("wMnt_Ambito_Pago");
        return "";
    }

    public void findDetalle() {
        try {
            lstRutas = (new RutasDao()).listarPorEmpresaWeb(user.getIDEMPRESA());
            if (getDatoEdicion().getCodigo() != null) {
                lstambpagRuta = ambitopagoDao.detAmbitoPagos(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo());
            }
        } catch (NisiraORMException ex) {
            this.setMensaje(ex.toString());
        }
    }

    public void addAmbitoPagoRuta() {
        Ambito_pago_rutas amb = new Ambito_pago_rutas();
        amb.setIdempresa(getDatoEdicion().getIdempresa());
        amb.setIdruta(slcRutas.getIdruta());
        amb.setDescripcion(slcRutas.getDescripcion());
        amb.setItem(WebUtil.cerosIzquierda(String.valueOf(lstambpagRuta.size() + 1), 3));
        lstambpagRuta.add(amb);
        RequestContext.getCurrentInstance().update("datos:lstAmbPagoRuta");
        RequestContext.getCurrentInstance().execute("PF('rutasdialog').hide()");
    }

    public void dellAmbitoPagoRuta() {
        if (slcAmbPagRuta != null) {
            lstambpagRuta.remove(slcAmbPagRuta);
        } else {
            setMensaje("Seleccione un detalle");
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    @Override
    public void nuevo() {
        lstambpagRuta = new ArrayList<Ambito_pago_rutas>();
        setDatoEdicion(new Ambito_pago());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
    }

    public boolean validar() {
        if (lstambpagRuta.isEmpty()) {
            return false;
        }
        if (getDatoEdicion().getDescripcion() == null) {
            return false;
        }
        if (getDatoEdicion().getNombre_corto() == null) {
            return false;
        }
        if (getDatoEdicion().getCosto_por_hora() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validar()) {
                setMensaje(ambitopagoDao.grabar(getDatoEdicion(), lstambpagRuta));
                WebUtil.info(getMensaje());
                setLvalidate(true);
            }

        } catch (Exception ex) {
            this.setMensaje(ex.toString());
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

}
