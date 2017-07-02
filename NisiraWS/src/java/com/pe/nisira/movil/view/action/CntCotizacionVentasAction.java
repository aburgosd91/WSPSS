/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.entity.Cotizacionventas;
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
@ManagedBean(name = "cntCotizacionVentasAction")
@ViewScoped
public class CntCotizacionVentasAction {
    private List<Cotizacionventas> datos;
    public static String idtiposervicio;
    @PostConstruct
    public void init() {
        CotizacionventasDao rd= new CotizacionventasDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorTipoServicio(u.getIDEMPRESA(),idtiposervicio));
        } catch (Exception ex) {
            Logger.getLogger(CntClieprovAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Cotizacionventas t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Cotizacionventas> getDatos() {
        return datos;
    }

    public void setDatos(List<Cotizacionventas> datos) {
        this.datos = datos;
    }
}
