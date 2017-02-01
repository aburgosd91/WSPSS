/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.RutaDao;
import com.nisira.core.dao.RutasDao;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Rutas;
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
@ManagedBean(name = "cntRutaAction")
@ViewScoped
public class CntRutaAction {
    private List<Rutas> datos;
    @PostConstruct
    public void init() {
        RutasDao rd= new RutasDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntRutaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Rutas t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Rutas> getDatos() {
        return datos;
    }

    public void setDatos(List<Rutas> datos) {
        this.datos = datos;
    }
}
