/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.AreasDao;
import com.nisira.core.entity.Areas;
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
@ManagedBean(name = "cntAreaAction")
@ViewScoped
public class CntAreaAction {
    private List<Areas> datos;
    @PostConstruct
    public void init() {
        AreasDao rd= new AreasDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.lstAreasEmpresa(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntAreaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Areas t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Areas> getDatos() {
        return datos;
    }

    public void setDatos(List<Areas> datos) {
        this.datos = datos;
    }
}
