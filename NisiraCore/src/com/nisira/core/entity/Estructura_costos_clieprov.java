package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
@XStreamAlias("ESTRUCTURA_COSTOS_CLIEPROV")
@Tabla(nombre = "ESTRUCTURA_COSTOS_CLIEPROV")
public class Estructura_costos_clieprov  implements Serializable{
    @XStreamAlias("IDBASEDATOS")
    private String idbasedatos;
    @XStreamAlias("IDEMPRESA")
    @ClavePrimaria
    @Columna
    private String idempresa;
    @XStreamAlias("CODIGO")
    @ClavePrimaria
    @Columna
    private String codigo;
    @XStreamAlias("IDCLIEPROV")
    @ClavePrimaria
    @Columna
    private String idclieprov;
    @XStreamAlias("ESTADO")
    @Columna
    private Float estado;
    @Columna
    @XStreamAlias("COSTOH_FIJO")
    private Float costoh_fijo;
    private String razon_social;
    private String estructuracostos;

    /* Sets & Gets */
    public void setIdempresa(String idempresa) {
            this.idempresa = idempresa;
    }

    public String getIdempresa() {
            return this.idempresa;
    }

    public void setCodigo(String codigo) {
            this.codigo = codigo;
    }

    public String getCodigo() {
            return this.codigo;
    }

    public void setIdclieprov(String idclieprov) {
            this.idclieprov = idclieprov;
    }

    public String getIdclieprov() {
            return this.idclieprov;
    }

    public void setEstado(Float estado) {
            this.estado = estado;
    }

    public Float getEstado() {
            return this.estado;
    }


        /**
     * @return the idbasedatos
     */
    public String getIdbasedatos() {
        return idbasedatos;
    }

    /**
     * @param idbasedatos the idbasedatos to set
     */
    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }
	/* Sets & Gets FK*/
    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the estructuracostos
     */
    public String getEstructuracostos() {
        return estructuracostos;
    }

    /**
     * @param estructuracostos the estructuracostos to set
     */
    public void setEstructuracostos(String estructuracostos) {
        this.estructuracostos = estructuracostos;
    }

    /**
     * @return the costoh_fijo
     */
    public Float getCostoh_fijo() {
        return costoh_fijo;
    }

    /**
     * @param costoh_fijo the costoh_fijo to set
     */
    public void setCostoh_fijo(Float costoh_fijo) {
        this.costoh_fijo = costoh_fijo;
    }
}