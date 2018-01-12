/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.FormatoreportewebDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Dformatoreporteweb;
import com.nisira.core.entity.Formatoreporteweb;
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
@ManagedBean(name = "formatoReporteAction")
@SessionScoped
public class FormatoReporteAction extends AbstactListAction<Formatoreporteweb> implements Serializable {

    private List<Dformatoreporteweb> lstdformareporte;
    private Dformatoreporteweb slcdformato;
    private FormatoreportewebDao frdao;
    private UsuarioBean user;
    private String mensaje;
    private List<String> col;
    private int index;

    public FormatoReporteAction() {
        lstdformareporte = new ArrayList<Dformatoreporteweb>();
        frdao = new FormatoreportewebDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        col = new ArrayList<String>();
        actualiza_ventana("wMnt_FormatoReporte");
    }

    @Override
    public String buscarFiltro(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void findDetalle() {
        if (getDatoEdicion().getItem() != null) {
            lstdformareporte = frdao.findDet(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdclieprov(), getDatoEdicion().getItem());
            for (Dformatoreporteweb df : lstdformareporte) {
                try {
                    List<String> tcol = frdao.tableColumsList(df.getTabla());
                    df.setCol(tcol);
                } catch (Exception ex) {
                    Logger.getLogger(FormatoReporteAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void buscarTodo() {
        try {
//            getIniciar();
            setListaDatos(frdao.findAll(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        lstdformareporte = new ArrayList<Dformatoreporteweb>();
        frdao = new FormatoreportewebDao();
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        col = new ArrayList<String>();
        actualiza_ventana("wMnt_FormatoReporte");
        return "";
    }

    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }

    public void valorClieprov(SelectEvent event) {
        Clieprov selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazon_social(selectClieprov.getRazonsocial());
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Formatoreporteweb());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setEstado(1f);
        lstdformareporte = new ArrayList<Dformatoreporteweb>();
    }

    public boolean validar() {
        if (getDatoEdicion().getIdclieprov() == null) {
            mensaje = "Seleccione un cliente";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (getDatoEdicion().getDescripcion() == null) {
            mensaje = "Ingresa una Descripcion";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        if (lstdformareporte.isEmpty()) {
            mensaje = "Llene el Detalle";
            WebUtil.MensajeAdvertencia(mensaje);
            return false;
        }
        return true;
    }

    @Override
    public void grabar() {
        try {
            if (validar()) {
                mensaje = frdao.grabar(getDatoEdicion(), lstdformareporte);
                setMensaje(WebUtil.exitoRegistrar("Formato de Reporte", mensaje));
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

    public void onTableSelect(int index2) {
        try {
            col = frdao.tableColumsList(lstdformareporte.get(index2).getTabla());
            lstdformareporte.get(index2).setCol(col);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar() {
      try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setEstado(0f);
                frdao.delFormatoWeb(getDatoEdicion().getIdempresa(),getDatoEdicion().getItem(),getDatoEdicion().getEstado());
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                frdao.delFormatoWeb(getDatoEdicion().getIdempresa(),getDatoEdicion().getItem(),2);
            }
            lista_accion_filtro("wLst_FormatoReporte");
        } catch (Exception ex) {
            Logger.getLogger(RutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }    }

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

    public void addDetRow() {
        if (getDatoEdicion().getIdclieprov() != null) {
            try {
                Dformatoreporteweb t = new Dformatoreporteweb();
                t.setIdempresa(getDatoEdicion().getIdempresa());
                t.setIdclieprov(getDatoEdicion().getIdclieprov());
                t.setItem2(WebUtil.cerosIzquierda(String.valueOf(lstdformareporte.size() + 1), 3));
                t.setTabla("ORDENSERVICIOCLIENTE");
                col = frdao.tableColumsList(t.getTabla());
                t.setCol(col);
                lstdformareporte.add(t);
            } catch (Exception ex) {
                Logger.getLogger(FormatoReporteAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            setMensaje("Seleccione un Cliente");
            WebUtil.MensajeAdvertencia(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    public void delDetRow() {
        if (lstdformareporte != null) {
            lstdformareporte.remove(slcdformato);
            int i = 1;
            for (Dformatoreporteweb ap : lstdformareporte) {
                ap.setItem2(WebUtil.cerosIzquierda(String.valueOf(i), 3));
                i++;
            }
        } else {
            setMensaje("Seleccione un detalle");
        }
        WebUtil.MensajeAdvertencia(getMensaje());
        RequestContext.getCurrentInstance().update("datos:growl");
    }

    public List<Dformatoreporteweb> getLstdformareporte() {
        return lstdformareporte;
    }

    public void setLstdformareporte(List<Dformatoreporteweb> lstdformareporte) {
        this.lstdformareporte = lstdformareporte;
    }

    public Dformatoreporteweb getSlcdformato() {
        return slcdformato;
    }

    public void setSlcdformato(Dformatoreporteweb slcdformato) {
        this.slcdformato = slcdformato;
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

    public List<String> getCol() {
        return col;
    }

    public void setCol(List<String> col) {
        this.col = col;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
