/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.Date;

/**
 *
 * @author alejndro zamora
 */
public class DetalleMemorandum {
    private int item;
    private String descripcion;
    private int cantidad;
    private int atendido;
    private Date fechaAten;
    private Date fechaRepo;

    public DetalleMemorandum() {
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAtendido() {
        return atendido;
    }

    public void setAtendido(int atendido) {
        this.atendido = atendido;
    }

    public Date getFechaAten() {
        return fechaAten;
    }

    public void setFechaAten(Date fechaAten) {
        this.fechaAten = fechaAten;
    }

    public Date getFechaRepo() {
        return fechaRepo;
    }

    public void setFechaRepo(Date fechaRepo) {
        this.fechaRepo = fechaRepo;
    }
    
}
