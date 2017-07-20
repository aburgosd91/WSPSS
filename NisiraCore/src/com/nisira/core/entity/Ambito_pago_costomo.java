package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;

@XStreamAlias("AMBITO_PAGO_COSTOMO")
@Tabla(nombre = "AMBITO_PAGO_COSTOMO")
public class Ambito_pago_costomo implements Serializable, Cloneable {

    @ClavePrimaria
    @Columna
    @XStreamAlias("idempresa")
    private String idempresa;
    @ClavePrimaria
    @Columna
    @XStreamAlias("codigo")
    private String codigo;
    @ClavePrimaria
    @Columna
    @XStreamAlias("idcargo")
    private String idcargo;
    @Columna
    @XStreamAlias("costo_bono")
    private Float costo_bono;
    @ClavePrimaria
    @Columna
    @XStreamAlias("idruta")
    private String idruta;

    @XStreamOmitField
    private String cargo;
    @XStreamOmitField
    private String ruta;
    @XStreamOmitField
    private String origen;
    @XStreamOmitField
    private String destino;

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

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getIdcargo() {
        return this.idcargo;
    }

    public void setCosto_bono(Float costo_bono) {
        this.costo_bono = costo_bono;
    }

    public Float getCosto_bono() {
        return this.costo_bono;
    }

    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }

    public String getIdruta() {
        return this.idruta;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    /* Sets & Gets FK*/
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
