/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@XStreamAlias("MULTITABLA")
public class Multitabla {
    @XStreamAlias("cTABLA_ID")
    private String TABLA_ID;
    @XStreamAlias("cVALOR")
    private String VALOR;
    @XStreamAlias("cDEPID")
    private String DEP_ID;
    @XStreamAlias("cDESCRIPCION")
    private String DESCRIPCION;
    @XStreamAlias("cABREV")
    private String ABREV;
    @XStreamAlias("cESTADO")
    private Boolean ESTADO;
    @XStreamAlias("cIDEMPRESA")
    private int EMPRESA;
    private String Palias;
    /**
     * @return the TABLA_ID
     */
    public String getTABLA_ID() {
        return TABLA_ID;
    }

    /**
     * @param TABLA_ID the TABLA_ID to set
     */
    public void setTABLA_ID(String TABLA_ID) {
        this.TABLA_ID = TABLA_ID;
    }

    /**
     * @return the VALOR
     */
    public String getVALOR() {
        return VALOR;
    }

    /**
     * @param VALOR the VALOR to set
     */
    public void setVALOR(String VALOR) {
        this.VALOR = VALOR;
    }

    /**
     * @return the DEP_ID
     */
    public String getDEP_ID() {
        return DEP_ID;
    }

    /**
     * @param DEP_ID the DEP_ID to set
     */
    public void setDEP_ID(String DEP_ID) {
        this.DEP_ID = DEP_ID;
    }

    /**
     * @return the ABREV
     */
    public String getABREV() {
        return ABREV;
    }

    /**
     * @param ABREV the ABREV to set
     */
    public void setABREV(String ABREV) {
        this.ABREV = ABREV;
    }

    /**
     * @return the ESTADO
     */
    public Boolean getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(Boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the EMPRESA
     */
    public int getEMPRESA() {
        return EMPRESA;
    }

    /**
     * @param EMPRESA the EMPRESA to set
     */
    public void setEMPRESA(int EMPRESA) {
        this.EMPRESA = EMPRESA;
    }

    /**
     * @return the DESCRIPCION
     */
    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    /**
     * @param DESCRIPCION the DESCRIPCION to set
     */
    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getPalias() {
        return Palias;
    }

    public void setPalias(String Palias) {
        this.Palias = Palias;
    }
    
}
