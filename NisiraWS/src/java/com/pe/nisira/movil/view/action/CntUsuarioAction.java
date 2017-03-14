/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Usuario;
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
 * @author azamora
 */
@ManagedBean(name = "cntUsuarioAction")
@ViewScoped
public class CntUsuarioAction {
    private List<Usuario> datos;
    @PostConstruct
    public void init() {
        UsuarioDao rd= new UsuarioDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.getUsuarioXappmovil(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Usuario t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Usuario> getDatos() {
        return datos;
    }

    public void setDatos(List<Usuario> datos) {
        this.datos = datos;
    }
}
