/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.framework.core.util;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */

public class ColumnaBD {

    private String nombre;
    private String nombreColumna;
    private String tipoSQL;
    private int tamaño;
    private int precision;
    private int escala;
    private Boolean nulo;
    private Boolean clavePrimaria;
    private String tipoRetorno;
    
    /** Creates a new instance of ColumnDataBase */
    public ColumnaBD() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getTipoSQL() {
        return tipoSQL;
    }

    public void setTipoSQL(String tipoSQL) {
        this.tipoSQL = tipoSQL;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public Boolean getNulo() {
        return nulo;
    }

    public void setNulo(Boolean nulo) {
        this.nulo = nulo;
    }

    public Boolean getClavePrimaria() {
        return clavePrimaria;
    }

    public void setClavePrimaria(Boolean clavePrimaria) {
        this.clavePrimaria = clavePrimaria;
    }

    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }
    
    
    
}
