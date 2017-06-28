package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;

@Tabla(nombre = "ambito_pago_RUTAS")
@XStreamAlias("ambito_pago_RUTAS")
public class Ambito_pago_rutas implements Serializable {

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
    @XStreamAlias("item")
    private String item;
    @Columna
    @XStreamAlias("idruta")
    private String idruta;
    @XStreamOmitField
    private String descripcion;
    @XStreamOmitField
    private String origen;
    @XStreamOmitField
    private String destino;
    @CampoRelacionado({
        @RelacionTabla(campo = "idempresa", campoRelacionado = "idempresa")
        , @RelacionTabla(campo = "codigo", campoRelacionado = "codigo")})
    @XStreamOmitField
    private Ambito_pago ambito_pago_fk_ambito_pago_rutas;


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

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }

    public String getIdruta() {
        return this.idruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public void setAmbito_pago_fk_ambito_pago_rutas(Ambito_pago ambito_pago_fk_ambito_pago_rutas) {
        this.ambito_pago_fk_ambito_pago_rutas = ambito_pago_fk_ambito_pago_rutas;
    }

    public Ambito_pago getAmbito_pago_fk_ambito_pago_rutas() {
        return this.ambito_pago_fk_ambito_pago_rutas;
    }

}
