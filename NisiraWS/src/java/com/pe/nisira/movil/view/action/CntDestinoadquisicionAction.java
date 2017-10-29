/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.entity.Destinoadquisicion;
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
@ManagedBean(name = "cntDestinoadquisicionAction")
@ViewScoped
public class CntDestinoadquisicionAction {
    private List<Destinoadquisicion> datos;
    @PostConstruct
    public void init() {
        DestinoadquisicionDao rd= new DestinoadquisicionDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb());
        } catch (Exception ex) {
            Logger.getLogger(CntDestinoadquisicionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Destinoadquisicion t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Destinoadquisicion> getDatos() {
        return datos;
    }

    public void setDatos(List<Destinoadquisicion> datos) {
        this.datos = datos;
    }
}
