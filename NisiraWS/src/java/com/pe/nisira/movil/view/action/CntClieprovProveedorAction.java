/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.entity.Clieprov;
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
@ManagedBean(name = "cntClieprovProveedorAction")
@ViewScoped
public class CntClieprovProveedorAction {
    private List<Clieprov> datos;
    @PostConstruct
    public void init() {
        ClieprovDao rd= new ClieprovDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaProveedorWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntClieprovProveedorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Clieprov t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Clieprov> getDatos() {
        return datos;
    }

    public void setDatos(List<Clieprov> datos) {
        this.datos = datos;
    }
}
