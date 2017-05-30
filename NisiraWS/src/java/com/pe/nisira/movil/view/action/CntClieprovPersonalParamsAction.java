/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.entity.Clieprov;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.util.ArrayList;
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
@ManagedBean(name = "cntClieprovPersonalParamsAction")
@ViewScoped
public class CntClieprovPersonalParamsAction {
    private List<Clieprov> datos;
    /*PAREMTROS*/
    private String lst_personal;
    @PostConstruct
    public void init() {}
    public void cargarDatos(){
        ClieprovDao rd= new ClieprovDao();
        try {
            UsuarioBean u =(UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            List<Clieprov> local = rd.listarPorEmpresaOperadorWeb(u.getIDEMPRESA());
            setDatos(no_repeat_list(local));
        } catch (Exception ex) {
            Logger.getLogger(CntClieprovPersonalParamsAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Clieprov> no_repeat_list(List<Clieprov> lc) throws ClassNotFoundException{
        List<Clieprov> dt = new ArrayList<>();
        if(lst_personal!=null){
            if(!lst_personal.trim().equals("")){
                List<String> lst_id = (List<String>)WebUtil.string_List_Gson(lst_personal);                    
                if(!lc.isEmpty()){
                    for(String idpersonal : lst_id){
                        for(Clieprov c :lc){
                            if(c.getIdclieprov().trim().equals(idpersonal.trim())){
                                lc.remove(c);
                                break;
                            }
                        }
                    }
                    dt=lc;
                }else
                    dt=lc;
            }else
                dt=lc;
        }else
            dt=lc;
        
        return dt;
    }
    public void selectFromDialog(Clieprov t) {
        RequestContext.getCurrentInstance().closeDialog(t);
    }

    public List<Clieprov> getDatos() {
        return datos;
    }

    public void setDatos(List<Clieprov> datos) {
        this.datos = datos;
    }

    /**
     * @return the lst_personal
     */
    public String getLst_personal() {
        return lst_personal;
    }

    /**
     * @param lst_personal the lst_personal to set
     */
    public void setLst_personal(String lst_personal) {
        this.lst_personal = lst_personal;
    }
}
