/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.VendedorDao;
import com.nisira.core.dao.VendedorDao;
import com.nisira.core.entity.Vendedor;
import com.nisira.core.entity.Vendedor;
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
@ManagedBean(name = "cntVendedorAction")
@ViewScoped
public class CntVendedorAction {
    private List<Vendedor> datos;
    @PostConstruct
    public void init() {
        VendedorDao rd= new VendedorDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntVendedorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Vendedor t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Vendedor> getDatos() {
        return datos;
    }

    public void setDatos(List<Vendedor> datos) {
        this.datos = datos;
    }
}
