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
@ManagedBean(name = "cntCargospersonalAction")
@ViewScoped
public class CntCargosPersonalAction {
    private List<Cargos_personal> datos;
    private Cargos_personal selectCargos_personal;
    @PostConstruct
    public void init() {
        Cargos_personalDao rd= new Cargos_personalDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntCargosPersonalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectFromDialog(Cargos_personal cargos) {
        RequestContext.getCurrentInstance().closeDialog(cargos);
    }

    public List<Cargos_personal> getDatos() {
        return datos;
    }

    public void setDatos(List<Cargos_personal> datos) {
        this.datos = datos;
    }

    /**
     * @return the selectCargos_personal
     */
    public Cargos_personal getSelectCargos_personal() {
        return selectCargos_personal;
    }

    /**
     * @param selectCargos_personal the selectCargos_personal to set
     */
    public void setSelectCargos_personal(Cargos_personal selectCargos_personal) {
        this.selectCargos_personal = selectCargos_personal;
    }
}
