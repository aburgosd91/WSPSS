package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias("ESTRUCTURA_COSTOS_MANO_OBRA")
@Tabla(nombre = "ESTRUCTURA_COSTOS_MANO_OBRA")
public class Estructura_costos_mano_obra  implements Serializable{
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
    @XStreamAlias("IDCARGO")
    @ClavePrimaria
    @Columna
    private String idcargo;
    @XStreamAlias("ITEM")
    @ClavePrimaria
    @Columna
    private String item;
    @XStreamAlias("ESTADO")
    @Columna
    private Float estado;
    @XStreamAlias("IDPRODUCTO")
    @Columna
    private String idproducto;
    @XStreamAlias("COSTO")
    @Columna
    private Float costo;
    @XStreamAlias("ITEMRANGO")
    @ClavePrimaria
    @Columna
    private String itemrango;
    private String cargo;


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

    public void setItem(String item) {
            this.item = item;
    }

    public String getItem() {
            return this.item;
    }

    public void setEstado(Float estado) {
            this.estado = estado;
    }

    public Float getEstado() {
            return this.estado;
    }



    /* Sets & Gets FK*/

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
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the idproducto
     */
    public String getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * @return the costo
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * @return the itemrango
     */
    public String getItemrango() {
        return itemrango;
    }

    /**
     * @param itemrango the itemrango to set
     */
    public void setItemrango(String itemrango) {
        this.itemrango = itemrango;
    }
}