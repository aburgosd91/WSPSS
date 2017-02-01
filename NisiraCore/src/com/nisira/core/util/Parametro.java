/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.util;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public class Parametro {

    private String nombreClase;
    private String nombreCampo;
    private String tipoDatoCampo;

    public Parametro() {
    }

    public Parametro(String nombreClase, String nombreCampo, String tipoDatoCampo) {
        this.nombreClase = nombreClase;
        this.nombreCampo = nombreCampo;
        this.tipoDatoCampo = tipoDatoCampo;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getTipoDatoCampo() {
        return tipoDatoCampo;
    }

    public void setTipoDatoCampo(String tipoDatoCampo) {
        this.tipoDatoCampo = tipoDatoCampo;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
    
    
}
