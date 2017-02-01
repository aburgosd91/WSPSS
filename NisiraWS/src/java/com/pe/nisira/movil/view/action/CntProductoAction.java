/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ProductoDao;
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
@ManagedBean(name = "cntProductoAction")
@ViewScoped
public class CntProductoAction {
    private List<Producto> datos;
    @PostConstruct
    public void init() {
        ProductoDao rd= new ProductoDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntProductoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Producto t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Producto> getDatos() {
        return datos;
    }

    public void setDatos(List<Producto> datos) {
        this.datos = datos;
    }
}
