/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.entity.Consumidor;
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
@ManagedBean(name = "cntConsumidorAction")
@ViewScoped
public class CntConsumidorAction {
    private List<Consumidor> datos;
    @PostConstruct
    public void init() {
        ConsumidorDao rd= new ConsumidorDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntConsumidorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Consumidor t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Consumidor> getDatos() {
        return datos;
    }

    public void setDatos(List<Consumidor> datos) {
        this.datos = datos;
    }
}
