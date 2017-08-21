/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.Codoperaciones_pssDao;
import com.nisira.core.entity.Codoperaciones_pss;
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
@ManagedBean(name = "cntCodoperaciones_pssAction")
@ViewScoped
public class CntCodoperaciones_pssAction {
    private List<Codoperaciones_pss> datos;
    /*PAREMTROS*/
    private String tipo;
    @PostConstruct
    public void init() {}
    public void cargarDatos(){
        Codoperaciones_pssDao rd= new Codoperaciones_pssDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb_Activo(tipo));
        } catch (Exception ex) {
            Logger.getLogger(CntCodoperaciones_pssAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectFromDialog(Codoperaciones_pss t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Codoperaciones_pss> getDatos() {
        return datos;
    }

    public void setDatos(List<Codoperaciones_pss> datos) {
        this.datos = datos;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
