/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Forma_pagoDao;
import com.nisira.core.entity.Forma_pago;
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
@ManagedBean(name = "cntForma_PagoAction")
@ViewScoped
public class CntForma_PagoAction {
    private List<Forma_pago> datos;
    @PostConstruct
    public void init() {
        Forma_pagoDao rd= new Forma_pagoDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntForma_PagoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Forma_pago t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Forma_pago> getDatos() {
        return datos;
    }

    public void setDatos(List<Forma_pago> datos) {
        this.datos = datos;
    }
}
