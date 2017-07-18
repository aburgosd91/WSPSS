package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("ESTRUCTURA_TAREO_CLIEPROV")
@Tabla(nombre = "ESTRUCTURA_TAREO_CLIEPROV")
public class Estructura_tareo_clieprov {

    @ClavePrimaria
    @Columna
    @XStreamAlias("IDEMPRESA")
    private String idempresa;
    @ClavePrimaria
    @Columna
    @XStreamAlias("IDCLIEPROV")
    private String idclieprov;
    @Columna
    @XStreamAlias("DESCRIPCION")
    private String descripcion;
    @Columna
    @XStreamAlias("ACTIVO")
    private Float activo;
    
    @XStreamOmitField
    private String razon_social;
    /* Sets & Gets */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdempresa() {
        return this.idempresa;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getIdclieprov() {
        return this.idclieprov;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setActivo(Float activo) {
        this.activo = activo;
    }

    public Float getActivo() {
        return this.activo;
    }

    public boolean isBEstado() {
        return this.getActivo() == 1;
    }

    public void setBEstado(boolean band) {
        this.setActivo((band) ?  1f :  0f);
    }


    /* Sets & Gets FK*/

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
}
