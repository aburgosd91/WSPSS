/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Antenor
 */
@ManagedBean(name = "mensajeBean")
@SessionScoped
public class MensajeBean implements Serializable{
    
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
