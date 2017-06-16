/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Documentos;
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
@ManagedBean(name = "cntDocumentoCodigosunatAction")
@ViewScoped
public class CntDocumentoCodigosunatAction {
    private List<Documentos> datos;
    @PostConstruct
    public void init() {
        DocumentosDao rd= new DocumentosDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            setDatos(rd.listarPorEmpresaWeb_codigosunat(u.getIDEMPRESA()));
        } catch (Exception ex) {
            Logger.getLogger(CntDocumentoCodigosunatAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void selectFromDialog(Documentos t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Documentos> getDatos() {
        return datos;
    }

    public void setDatos(List<Documentos> datos) {
        this.datos = datos;
    }
}
