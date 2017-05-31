package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
@XStreamAlias("ESTRUCTURA_COSTOS_PRODUCTO")
@Tabla(nombre = "ESTRUCTURA_COSTOS_PRODUCTO")
public class Estructura_costos_producto  implements Serializable{
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
        @XStreamAlias("IDPRODUCTO")
	@ClavePrimaria
	@Columna
	private String idproducto;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("ITEM")
	@Columna
	private String item;
        @XStreamAlias("AJUSTE")
	@Columna
	private Float ajuste;
        @XStreamAlias("NHORAS")
	@Columna
	private Float nhoras;
        @XStreamAlias("CODOPERATIVO")
	@Columna
	private String codoperativo;
        @XStreamAlias("IDRUTA")
	@Columna
	private String idruta;
        private String descripcion_ruta;
        private String producto; 
        private String idmedida;
        private int numerador;
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

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
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
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the idmedida
     */
    public String getIdmedida() {
        return idmedida;
    }

    /**
     * @param idmedida the idmedida to set
     */
    public void setIdmedida(String idmedida) {
        this.idmedida = idmedida;
    }

    /**
     * @return the numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * @param numerador the numerador to set
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * @return the ajuste
     */
    public Float getAjuste() {
        return ajuste;
    }

    /**
     * @param ajuste the ajuste to set
     */
    public void setAjuste(Float ajuste) {
        this.ajuste = ajuste;
    }

    /**
     * @return the nhoras
     */
    public Float getNhoras() {
        return nhoras;
    }

    /**
     * @param nhoras the nhoras to set
     */
    public void setNhoras(Float nhoras) {
        this.nhoras = nhoras;
    }

    /**
     * @return the codoperativo
     */
    public String getCodoperativo() {
        return codoperativo;
    }

    /**
     * @param codoperativo the codoperativo to set
     */
    public void setCodoperativo(String codoperativo) {
        this.codoperativo = codoperativo;
    }

    /**
     * @return the idruta
     */
    public String getIdruta() {
        return idruta;
    }

    /**
     * @param idruta the idruta to set
     */
    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }

    /**
     * @return the descripcion_ruta
     */
    public String getDescripcion_ruta() {
        return descripcion_ruta;
    }

    /**
     * @param descripcion_ruta the descripcion_ruta to set
     */
    public void setDescripcion_ruta(String descripcion_ruta) {
        this.descripcion_ruta = descripcion_ruta;
    }

}