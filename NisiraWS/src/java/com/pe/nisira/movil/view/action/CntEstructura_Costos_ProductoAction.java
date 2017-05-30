/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Estructura_costos_productoDao;
import com.nisira.core.dao.ProductoDao;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.entity.Producto;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "cntEstructura_Costos_ProductoAction")
@ViewScoped
public class CntEstructura_Costos_ProductoAction {
    private List<Estructura_costos_producto> datos;
    /*PAREMTROS*/
    private String codigo_estructura;
    @PostConstruct
    public void init() {}
    public void cargarDatos(){
        Estructura_costos_productoDao rd= new Estructura_costos_productoDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWebXidclieprov(u.getIDEMPRESA(),codigo_estructura));
        } catch (Exception ex) {
            Logger.getLogger(CntEstructura_Costos_ProductoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectFromDialog(Estructura_costos_producto t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Estructura_costos_producto> getDatos() {
        return datos;
    }

    public void setDatos(List<Estructura_costos_producto> datos) {
        this.datos = datos;
    }

    /**
     * @return the codigo_estructura
     */
    public String getCodigo_estructura() {
        return codigo_estructura;
    }

    /**
     * @param codigo_estructura the codigo_estructura to set
     */
    public void setCodigo_estructura(String codigo_estructura) {
        this.codigo_estructura = codigo_estructura;
    }
}
