/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class FilaBean implements Serializable{
    private String idempresa;
    private String idcamara;
    private String idfila;
    private String descripcion;
    private ArrayList<ColumnaBean> listacolumnas;
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdfila() {
        return idfila;
    }

    public void setIdfila(String idfila) {
        this.idfila = idfila;
    }

    public String getIdcamara() {
        return idcamara;
    }

    public void setIdcamara(String idcamara) {
        this.idcamara = idcamara;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public ArrayList<ColumnaBean> getListacolumnas() {
        return listacolumnas;
    }

    public void setListacolumnas(ArrayList<ColumnaBean> listacolumnas) {
        this.listacolumnas = listacolumnas;
    }

    
}
