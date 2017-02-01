/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.entity.Cargos_personal;
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
@ManagedBean(name = "cntCargos_personalAction")
@ViewScoped
public class CntCargos_personalAction {
    private List<Cargos_personal> datos;
    @PostConstruct
    public void init() {
        Cargos_personalDao rd= new Cargos_personalDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntCargos_personalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Cargos_personal t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Cargos_personal> getDatos() {
        return datos;
    }

    public void setDatos(List<Cargos_personal> datos) {
        this.datos = datos;
    }
}
