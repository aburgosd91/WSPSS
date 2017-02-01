/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.entity.Concepto_cuenta;
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
@ManagedBean(name = "cntConcepto_cuentaAction")
@ViewScoped
public class CntConceptocuentaAction {
    private List<Concepto_cuenta> datos;
    @PostConstruct
    public void init() {
        Concepto_cuentaDao rd= new Concepto_cuentaDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntConceptocuentaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Concepto_cuenta t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Concepto_cuenta> getDatos() {
        return datos;
    }

    public void setDatos(List<Concepto_cuenta> datos) {
        this.datos = datos;
    }
}
