/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author alejndro zamora
 */
@XStreamAlias("REGCLIENTE_CUENTA_DEPOSITO")
public class Regcliente_cuenta_deposito {
    @XStreamAlias("IDREGISTRO")
    private String IDREGISTRO;
    @XStreamAlias("ITEM")
    private int ITEM;
    @XStreamAlias("BANCO")
    private String BANCO;
    @XStreamAlias("CUENTA")
    private String CUENTA;
    @XStreamAlias("CODINTERBANCARIO")
    private String CODINTERBANCARIO;
    
    public Regcliente_cuenta_deposito() {
    }

    /**
     * @return the BANCO
     */
    public String getBANCO() {
        return BANCO;
    }

    /**
     * @param BANCO the BANCO to set
     */
    public void setBANCO(String BANCO) {
        this.BANCO = BANCO;
    }

    /**
     * @return the CUENTA
     */
    public String getCUENTA() {
        return CUENTA;
    }

    /**
     * @param CUENTA the CUENTA to set
     */
    public void setCUENTA(String CUENTA) {
        this.CUENTA = CUENTA;
    }

    /**
     * @return the CODINTERBANCARIO
     */
    public String getCODINTERBANCARIO() {
        return CODINTERBANCARIO;
    }

    /**
     * @param CODINTERBANCARIO the CODINTERBANCARIO to set
     */
    public void setCODINTERBANCARIO(String CODINTERBANCARIO) {
        this.CODINTERBANCARIO = CODINTERBANCARIO;
    }

    /**
     * @return the IDREGISTRO
     */
    public String getIDREGISTRO() {
        return IDREGISTRO;
    }

    /**
     * @param IDREGISTRO the IDREGISTRO to set
     */
    public void setIDREGISTRO(String IDREGISTRO) {
        this.IDREGISTRO = IDREGISTRO;
    }

    /**
     * @return the ITEM
     */
    public int getITEM() {
        return ITEM;
    }

    /**
     * @param ITEM the ITEM to set
     */
    public void setITEM(int ITEM) {
        this.ITEM = ITEM;
    }
}
