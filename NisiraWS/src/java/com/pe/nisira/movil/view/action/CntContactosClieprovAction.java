/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ContactosclieprovDao;
import com.nisira.core.entity.Contactosclieprov;
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
@ManagedBean(name = "cntContactosclieprovAction")
@ViewScoped
public class CntContactosClieprovAction {
    private List<Contactosclieprov> datos;
    /*PAREMTROS*/
    private String idcliente;
    @PostConstruct
    public void init() {}
    public void cargarDatos(){
        ContactosclieprovDao rd= new ContactosclieprovDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaClienteContactoWeb(u.getIDEMPRESA(),idcliente));
        } catch (Exception ex) {
            Logger.getLogger(CntContactosClieprovAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Contactosclieprov t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Contactosclieprov> getDatos() {
        return datos;
    }

    public void setDatos(List<Contactosclieprov> datos) {
        this.datos = datos;
    }

    /**
     * @return the idcliente
     */
    public String getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }
}
