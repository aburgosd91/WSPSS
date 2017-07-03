/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.UbigeoDao;
import com.nisira.core.entity.Ubigeo;
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
 * @author alejndro zamora
 */
@ManagedBean(name = "cntUbigeoAction")
@ViewScoped
public class CntUbigeoAction {
    private List<Ubigeo> datos;
    @PostConstruct
    public void init() {
        UbigeoDao rd= new UbigeoDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarTodo());
        } catch (Exception ex) {
            Logger.getLogger(CntUbigeoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Ubigeo t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Ubigeo> getDatos() {
        return datos;
    }

    public void setDatos(List<Ubigeo> datos) {
        this.datos = datos;
    }
}
