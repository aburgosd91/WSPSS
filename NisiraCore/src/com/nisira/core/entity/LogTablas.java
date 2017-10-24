/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author aburgos
 */
@XStreamAlias("LOGTABLAS")
public class LogTablas {
    @XStreamAlias("IDDOC")
    private String iddoc;
    @XStreamAlias("ITEMS")
    private String items;
    @XStreamAlias("CAMPO")
    private String campo;
    @XStreamAlias("VALOR_OLD")
    private String valor_old;
    @XStreamAlias("VALOR_NEW")
    private String valor_new;
    /**
     * @return the iddoc
     */
    public String getIddoc() {
        return iddoc;
    }

    /**
     * @param iddoc the iddoc to set
     */
    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    /**
     * @return the items
     */
    public String getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * @return the campo
     */
    public String getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * @return the valor_old
     */
    public String getValor_old() {
        return valor_old;
    }

    /**
     * @param valor_old the valor_old to set
     */
    public void setValor_old(String valor_old) {
        this.valor_old = valor_old;
    }

    /**
     * @return the valor_new
     */
    public String getValor_new() {
        return valor_new;
    }

    /**
     * @param valor_new the valor_new to set
     */
    public void setValor_new(String valor_new) {
        this.valor_new = valor_new;
    }
    
}
