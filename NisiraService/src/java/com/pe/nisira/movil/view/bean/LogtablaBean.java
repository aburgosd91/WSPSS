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
public class LogtablaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idempresa;
    private String idlog;
    private String item;
    private String tabla;
    private String idcampo;
    private String campoclave;
    private String idtabla;
    private String evento;
    private String valoranterior;
    private String valoractual;
    private String idusuario;
    private String maquina;
    private String fechacreacion;
    private String ventana;

    public LogtablaBean() {
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdlog() {
        return idlog;
    }

    public void setIdlog(String idlog) {
        this.idlog = idlog;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getIdcampo() {
        return idcampo;
    }

    public void setIdcampo(String idcampo) {
        this.idcampo = idcampo;
    }

    public String getCampoclave() {
        return campoclave;
    }

    public void setCampoclave(String campoclave) {
        this.campoclave = campoclave;
    }

    public String getIdtabla() {
        return idtabla;
    }

    public void setIdtabla(String idtabla) {
        this.idtabla = idtabla;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getValoranterior() {
        return valoranterior;
    }

    public void setValoranterior(String valoranterior) {
        this.valoranterior = valoranterior;
    }

    public String getValoractual() {
        return valoractual;
    }

    public void setValoractual(String valoractual) {
        this.valoractual = valoractual;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getVentana() {
        return ventana;
    }

    public void setVentana(String ventana) {
        this.ventana = ventana;
    }
    
    
}
