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
@XStreamAlias("REGCLIENTEREPRESENTANTES")
public class Representante {
    @XStreamAlias("IDREGISTRO")
    private String IDREGISTRO;
    @XStreamAlias("APELLIDOMATERNO")
    private String APELLIDOMATERNO;
    @XStreamAlias("APELLIDOPATERNO")
    private String APELLIDOPATERNO;
    @XStreamAlias("NOMBRES")
    private String NOMBRES;
    @XStreamAlias("NRODOCUMENTO")
    private String NRODOCUMENTO;
    @XStreamAlias("CARGO")
    private String CARGO;
    @XStreamAlias("CORREO")
    private String CORREO;
    @XStreamAlias("IDREP")
    private int IDREP;
    private int item;
    public Representante() {
    }

    public String getIDREGISTRO() {
        return IDREGISTRO;
    }

    public int getIDREP() {
        return IDREP;
    }

    public void setIDREP(int IDREP) {
        this.IDREP = IDREP;
    }

    public void setIDREGISTRO(String IDREGISTRO) {
        this.IDREGISTRO = IDREGISTRO;
    }

    public String getAPELLIDOMATERNO() {
        return APELLIDOMATERNO;
    }

    public void setAPELLIDOMATERNO(String APELLIDOMATERNO) {
        this.APELLIDOMATERNO = APELLIDOMATERNO;
    }

    public String getAPELLIDOPATERNO() {
        return APELLIDOPATERNO;
    }

    public void setAPELLIDOPATERNO(String APELLIDOPATERNO) {
        this.APELLIDOPATERNO = APELLIDOPATERNO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getNRODOCUMENTO() {
        return NRODOCUMENTO;
    }

    public void setNRODOCUMENTO(String NRODOCUMENTO) {
        this.NRODOCUMENTO = NRODOCUMENTO;
    }

    public String getCARGO() {
        return CARGO;
    }

    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }
    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }
}
