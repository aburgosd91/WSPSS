package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
@XStreamAlias("DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS")
@Tabla(nombre = "DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS")
public class Destructura_costos_recursos_cotizacionventas  implements Serializable{
        private String idbasedatos; 
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("CODIGO")
	@ClavePrimaria
	@Columna
	private String codigo;
        @XStreamAlias("IDCOTIZACIONV")
	@ClavePrimaria
	@Columna
	private String idcotizacionv;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("TIPO_RECURSO")
	@Columna
	private String tipo_recurso;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("CANTIDAD")
	@Columna
	private Float cantidad;
        @XStreamAlias("COSTO")
	@Columna
	private Float costo;
        @XStreamAlias("IDPRODUCTO")
	@Columna
	private String idproducto;
        @XStreamAlias("ES_PORCENTAJE")
	@Columna
	private Float es_porcentaje;
        @XStreamAlias("IDMEDIDA")
	@Columna
	private String idmedida;
        @XStreamAlias("IDPRODUCTO_EC")
	@Columna
	private String idproducto_ec;
        @XStreamAlias("ITEMRANGO")
        @Columna
        private String itemrango;
        private Float porcentaje;
        private Float subtotal;
        private Float pu;

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

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setTipo_recurso(String tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
	}

	public String getTipo_recurso() {
		return this.tipo_recurso;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Float getCosto() {
		return this.costo;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setEs_porcentaje(Float es_porcentaje) {
		this.es_porcentaje = es_porcentaje;
	}

	public Float getEs_porcentaje() {
		return this.es_porcentaje;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setIdproducto_ec(String idproducto_ec) {
		this.idproducto_ec = idproducto_ec;
	}

	public String getIdproducto_ec() {
		return this.idproducto_ec;
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
     * @return the porcentaje
     */
    public Float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the subtotal
     */
    public Float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the pu
     */
    public Float getPu() {
        return pu;
    }

    /**
     * @param pu the pu to set
     */
    public void setPu(Float pu) {
        this.pu = pu;
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