/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 * @param <T>
 */
public abstract class AbstactListAction<T> {
    private String tituloHead;
    private String lst_name;
    private String edt_name;
    private List<T> listaDatos;
    private List<T> filtroDatos;
    private T datoSeleccionado;
    private T datoEdicion;
    private int ladd;
    private String opc_anular_eliminar;
    private String pagina;
    private int aedtiar;
    private int anuevo;
    private int agrabar;
    private int aanular;
    private int aeliminar;
    /*FILTRO*/
    private Date desde;
    private Date hasta;
    /*ESTADOS*/
    /*
        (0)VISTA
        (1)NUEVO
        (2)EDICION
    */
    protected static Map<String, Object> modalOptions;
    protected static Map<String, Object> modalGoogleMapOptions;
    static {
        modalOptions = new HashMap<String, Object>();
        modalOptions.put("modal", true);
        modalOptions.put("draggable", true);
        modalOptions.put("resizable", false);
        modalOptions.put("contentHeight", 400);
        /************************************************************/
        modalGoogleMapOptions = new HashMap<String, Object>();
        modalGoogleMapOptions.put("modal", true);
        modalGoogleMapOptions.put("draggable", true);
        modalGoogleMapOptions.put("resizable", false);
        modalGoogleMapOptions.put("contentHeight", 550);
        modalGoogleMapOptions.put("includeViewParams", true);
        /*************************************************************/
    }
    public void lista_accion_filtro(String form){
        try {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            this.lst_name = form;
            ctx.redirect(ctxPath + "/faces/sistema/" + lst_name + ".xhtml");
        } catch (Exception ex) {
            Logger.getLogger(AbstactListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualiza_ventana(String form_edicion) {
        try {
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
            this.lst_name = "wLst_".concat(form_edicion.substring(5));
            this.tituloHead = (new menuDao()).buscar_Titulo(form_edicion.substring(5));
            this.edt_name = form_edicion;
            listaDatos = new ArrayList<T>();
            filtroDatos = new ArrayList<T>();
            if (!initacceso(lst_name)) {
                ctx.redirect(ctxPath + "/faces/sistema/principal.xhtml");
            }
        } catch (Exception ex) {
            Logger.getLogger(AbstactListAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pag_acceso(String form) throws IOException {
        boolean access = false;
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        for (String[] a : ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getAccess()) {
            if(a[0]!=null){
                String page = a[0].replace(".xhtml", "").trim().substring(5);
                if (page.equalsIgnoreCase(form.substring(5))) {
                    access = true;
                    this.aedtiar=Integer.parseInt(a[1]);
                    this.anuevo=Integer.parseInt(a[2]);
                    this.agrabar=Integer.parseInt(a[3]);
                    this.aanular=Integer.parseInt(a[4]);
                    this.aeliminar=Integer.parseInt(a[5]);
                    
                }
            }
        }
        if (access == true) {
            if((form.startsWith("wMnt_")|| form.startsWith("edt_"))){
                ctx.redirect(ctxPath + "/faces/sistema/" + form + ".xhtml");
            }else{
                 ctx.redirect(ctxPath + "/faces/sistema/" + lst_name + ".xhtml");
                 /************************************************/
                 doVerFiltro();
            }
        } else {
            ctx.redirect(ctxPath + "/faces/sistema/principal.xhtml");
        }

    }
    public boolean initacceso(String form) throws IOException {
        boolean access = false;
        for (String[] a : ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getAccess()) {            
            if(a[0]!=null){
                String page = a[0].replace(".xhtml", "").trim().substring(5);
                if (page.equalsIgnoreCase(form.substring(5))) {
                    access = true;
                    this.aedtiar=Integer.parseInt(a[1]);
                    this.anuevo=Integer.parseInt(a[2]);
                    this.agrabar=Integer.parseInt(a[3]);
                    this.aanular=Integer.parseInt(a[4]);
                    this.aeliminar=Integer.parseInt(a[5]);
                }
            }
        }
        /********************* FECHA ********************/
        desde=new Date();
        hasta=new Date();
        
        return access;
    }
    public void doVerFiltro() throws IOException {
        buscarFiltro();
        this.ladd = 0;
    }
    
    public void doNuevo() throws IOException {
        nuevo();
        pag_acceso(this.edt_name);
        this.ladd = 1;
    }
    public void doGrabar() {
        grabar();
        this.ladd = 0;
    }
    public boolean isEdicion() {
        return this.ladd >= 1;
    }
    public void doEditar() {
        this.ladd = 2;
    }
    public void doEditar_lista() throws IOException {
        if (this.datoSeleccionado == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            this.datoEdicion = this.datoSeleccionado;
            pag_acceso(this.edt_name);
            this.ladd = 2;
        }
    }
    public void opcionEliminarDocumento(String opcion, String pagina) {
        setOpc_anular_eliminar(opcion);
        setPagina(pagina);
        setDatoEdicion(getDatoSeleccionado());
        if (pagina.equalsIgnoreCase("LST")) {
            if (getDatoSeleccionado() == null) {
                WebUtil.MensajeAdvertencia("Debe seleccionar Registro.");
//            } else if (getDatoSeleccionado().getEstado()==0 && getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                WebUtil.MensajeAdvertencia("Registro tiene estado de ANULADO.");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogeliminar').show()");
            }
        }

        if (pagina.equalsIgnoreCase("MNT")) {
            if (getDatoEdicion()== null) {
                WebUtil.MensajeAdvertencia("No puede eliminar");
//            } else if (getDatoEdicion().getEstado()==0 && getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                WebUtil.MensajeAdvertencia("Registro tiene estado de ANULADO.");
            } else {
                RequestContext.getCurrentInstance().execute("PF('dialogeliminar').show()");
            }
        }
    }
    public void doVerLista() throws IOException {
        nuevo();
        pag_acceso(this.lst_name);
        this.ladd = 1;
    }
    public void doCancelar() {
        this.ladd = 0;
    }

    public boolean isBarraVista() {
        return this.ladd == 0;
    }
    
    public abstract String buscarFiltro();
    
    public abstract void buscarTodo();

    public abstract String getIniciar();
    
    public abstract void nuevo();
    
    public abstract void grabar();

    public abstract void eliminar();
    
    public String getLst_name() {
        return lst_name;
    }

    public void setLst_name(String lst_name) {
        this.lst_name = lst_name;
    }

    public String getEdt_name() {
        return edt_name;
    }

    public void setEdt_name(String edt_name) {
        this.edt_name = edt_name;
    }

    public List<T> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<T> listaDatos) {
        this.listaDatos = listaDatos;
        this.filtroDatos = listaDatos;
    }

    public T getDatoSeleccionado() {
        return datoSeleccionado;
    }

    public void setDatoSeleccionado(T datoSeleccionado) {
        this.datoSeleccionado = datoSeleccionado;
    }

    public T getDatoEdicion() {
        return datoEdicion;
    }

    public void setDatoEdicion(T datoEdicion) {
        this.datoEdicion = datoEdicion;
    }

    public int getLadd() {
        return ladd;
    }

    public void setLadd(int ladd) {
        this.ladd = ladd;
    }

    public int getAedtiar() {
        return aedtiar;
    }

    public void setAedtiar(int aedtiar) {
        this.aedtiar = aedtiar;
    }

    public int getAgrabar() {
        return agrabar;
    }

    public void setAgrabar(int agrabar) {
        this.agrabar = agrabar;
    }

    public int getAanular() {
        return aanular;
    }

    public void setAanular(int aanular) {
        this.aanular = aanular;
    }

    public int getAeliminar() {
        return aeliminar;
    }

    public void setAeliminar(int aeliminar) {
        this.aeliminar = aeliminar;
    }

    public String getOpc_anular_eliminar() {
        return opc_anular_eliminar;
    }

    public void setOpc_anular_eliminar(String opc_anular_eliminar) {
        this.opc_anular_eliminar = opc_anular_eliminar;
    }

    public int getAnuevo() {
        return anuevo;
    }

    public void setAnuevo(int anuevo) {
        this.anuevo = anuevo;
    }

    public String getTituloHead() {
        return tituloHead;
    }

    public void setTituloHead(String tituloHead) {
        this.tituloHead = tituloHead;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }     

    public List<T> getFiltroDatos() {
        return filtroDatos;
    }

    public void setFiltroDatos(List<T> filtroDatos) {
        this.filtroDatos = filtroDatos;
    }

    /**
     * @return the desde
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * @param desde the desde to set
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     * @return the hasta
     */
    public Date getHasta() {
        return hasta;
    }

    /**
     * @param hasta the hasta to set
     */
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }
    
}
