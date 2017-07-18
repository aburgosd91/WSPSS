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
    @XStreamAlias("ITEM")
    private String item;
    @XStreamAlias("VALOR")
    private String valor;
    @XStreamAlias("ESFECHA")
    private Float esfecha;
    @XStreamAlias("HEADER")
    private String header;
    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the esfecha
     */
    public Float getEsfecha() {
        return esfecha;
    }

    /**
     * @param esfecha the esfecha to set
     */
    public void setEsfecha(Float esfecha) {
        this.esfecha = esfecha;
    }

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }
    
}
