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
public class Atendido implements Cloneable{
    private int item;
    private int atendido;
    private Date fechaAten;
    private Date fechaRepo;

    public Atendido() {
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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
    public Atendido clone() throws CloneNotSupportedException {
        return (Atendido) super.clone();
    }
    
}
