/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;

/**
 *
 * @author Antenor
 */
public class MenuBean implements Serializable{
    private static final long serialVersionUID=1L;
    private String estado;
    private String estadodesc;

    public MenuBean() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadodesc() {
        return estadodesc;
    }

    public void setEstadodesc(String estadodesc) {
        this.estadodesc = estadodesc;
    }
    
    
}
