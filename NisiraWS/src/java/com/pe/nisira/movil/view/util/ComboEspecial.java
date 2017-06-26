/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import java.io.Serializable;

/**
 *
 * @author aburgos
 */
public class ComboEspecial implements Comparable<ComboEspecial>,Serializable{
    private String id;
    private String descripcion;
    public ComboEspecial(String id,String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ComboEspecial [id=" + id + ", descripcion=" + descripcion
                + "]";
    } 
    @Override
    public int compareTo(ComboEspecial o) {
        if(id.contentEquals(o.getId()) && descripcion.contentEquals(o.getDescripcion()))  
            return 0 ; 
        return 1;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
