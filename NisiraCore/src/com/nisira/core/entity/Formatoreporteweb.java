package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.Date;

@XStreamAlias("FORMATOREPORTEWEB")
@Tabla(nombre = "FORMATOREPORTEWEB")
public class Formatoreporteweb implements Serializable {
    @XStreamAlias("IDEMPRESA")
    @ClavePrimaria
    @Columna
    private String idempresa;
    @XStreamAlias("IDCLIEPROV")
    @ClavePrimaria
    @Columna
    private String idclieprov;
    @XStreamAlias("ITEM")
    @ClavePrimaria
    @Columna
    private String item;
    @XStreamAlias("DESCRIPCION")
    @Columna
    private String descripcion;
    @XStreamAlias("FECHACREACION")
    @Columna
    private Date fechacreacion;
    @XStreamAlias("ESTADO")
    @Columna
    private Float estado;
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

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setEstado(Float estado) {
        this.estado = estado;
    }

    public Float getEstado() {
        return this.estado;
    }

    /* Sets & Gets FK*/

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
    public boolean isBEstado() {
        return this.getEstado()== 1f;
    }

    public void setBEstado(boolean band) {
        this.setEstado((band) ?  1f :  0f);
    }
}
