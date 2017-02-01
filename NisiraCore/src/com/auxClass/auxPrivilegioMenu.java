/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auxClass;

/**
 *
 * @author azamora
 */
public class auxPrivilegioMenu {
    private boolean elegido;
    private String idcontenido;
    private String idempresa;
    private int nuevo;
    private int editar;    
    private int eliminar;
    private int anular;    
    private int grabar;

    public auxPrivilegioMenu() {
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public String getIdcontenido() {
        return idcontenido;
    }

    public void setIdcontenido(String idcontenido) {
        this.idcontenido = idcontenido;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public int getNuevo() {
        return nuevo;
    }

    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }

    public int getEditar() {
        return editar;
    }

    public void setEditar(int editar) {
        this.editar = editar;
    }

    public int getEliminar() {
        return eliminar;
    }

    public void setEliminar(int eliminar) {
        this.eliminar = eliminar;
    }

    public int getAnular() {
        return anular;
    }

    public void setAnular(int anular) {
        this.anular = anular;
    }

    public int getGrabar() {
        return grabar;
    }

    public void setGrabar(int grabar) {
        this.grabar = grabar;
    }
    
}
