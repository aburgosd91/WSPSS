/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aburgos
 */
@XStreamAlias("PROGRAMACION")
public class Programacion implements Serializable{
    
    @XStreamAlias("FECHA")
    private Date fecha;
    @XStreamAlias("HINICIO")
    private String hinicio;
    @XStreamAlias("HFIN")
    private String hfin;
    @XStreamAlias("VALOR")
    private Float valor;
    @XStreamAlias("HINICIO_N")
    private Float hinicio_n;
    @XStreamAlias("HFIN_N")
    private Float hfin_n;
    
    public Programacion(Date f , Float val){
        this.fecha = f;
        this.valor = val;
    }
    public Programacion(Date f , Float val, String hinicio, String hfin){
        this.fecha = f;
        this.valor = val;
        this.hinicio = hinicio;
        this.hfin = hfin;
    }
    public Programacion(Date f , Float val, String hinicio, String hfin, Float hinicio_n, Float hfin_n){
        this.fecha = f;
        this.valor = val;
        this.hinicio = hinicio;
        this.hfin = hfin;
        this.hinicio_n = hinicio_n;
        this.hfin_n = hfin_n;
    }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the hinicio
     */
    public String getHinicio() {
        return hinicio;
    }

    /**
     * @param hinicio the hinicio to set
     */
    public void setHinicio(String hinicio) {
        this.hinicio = hinicio;
    }

    /**
     * @return the hfin
     */
    public String getHfin() {
        return hfin;
    }

    /**
     * @param hfin the hfin to set
     */
    public void setHfin(String hfin) {
        this.hfin = hfin;
    }

    /**
     * @return the hinicio_n
     */
    public Float getHinicio_n() {
        return hinicio_n;
    }

    /**
     * @param hinicio_n the hinicio_n to set
     */
    public void setHinicio_n(Float hinicio_n) {
        this.hinicio_n = hinicio_n;
    }

    /**
     * @return the hfin_n
     */
    public Float getHfin_n() {
        return hfin_n;
    }

    /**
     * @param hfin_n the hfin_n to set
     */
    public void setHfin_n(Float hfin_n) {
        this.hfin_n = hfin_n;
    }
}
