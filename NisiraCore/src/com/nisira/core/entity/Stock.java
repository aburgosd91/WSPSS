package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "STOCK")
@XStreamAlias("STOCK")

public class Stock implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idbasedatos") 
	@XStreamAlias("idbasedatos") 
	private String idbasedatos = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("idempresa") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idalmacen") 
	@XStreamAlias("idalmacen") 
	private String idalmacen = "" ;
	@Columna
	@SerializedName("descalmacen") 
	@XStreamAlias("descalmacen") 
	private String descalmacen = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("idsucursal") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("descsucursal") 
	@XStreamAlias("descsucursal") 
	private String descsucursal = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idproducto") 
	@XStreamAlias("idproducto") 
	private String idproducto = "" ;
	@Columna
	@SerializedName("descproducto") 
	@XStreamAlias("descproducto") 
	private String descproducto = "" ;
	@Columna
	@SerializedName("idmedida") 
	@XStreamAlias("idmedida") 
	private String idmedida = "" ;
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("fecha") 
	private Date fecha;
	@Columna
	@SerializedName("stock") 
	@XStreamAlias("stock") 
	private Double stock = 0.00 ;
	@Columna
	@SerializedName("stockcomprometido") 
	@XStreamAlias("stockcomprometido") 
	private Double stockcomprometido = 0.00 ;
	@Columna
	@SerializedName("stockdisponible") 
	@XStreamAlias("stockdisponible") 
	private Double stockdisponible = 0.00 ;



	/* Sets & Gets */
	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setDescalmacen(String descalmacen) {
		this.descalmacen = descalmacen;
	}

	public String getDescalmacen() {
		return this.descalmacen;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setDescsucursal(String descsucursal) {
		this.descsucursal = descsucursal;
	}

	public String getDescsucursal() {
		return this.descsucursal;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setDescproducto(String descproducto) {
		this.descproducto = descproducto;
	}

	public String getDescproducto() {
		return this.descproducto;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public Double getStock() {
		return this.stock;
	}

	public void setStockcomprometido(Double stockcomprometido) {
		this.stockcomprometido = stockcomprometido;
	}

	public Double getStockcomprometido() {
		return this.stockcomprometido;
	}

	public void setStockdisponible(Double stockdisponible) {
		this.stockdisponible = stockdisponible;
	}

	public Double getStockdisponible() {
		return this.stockdisponible;
	}



	/* Sets & Gets FK*/

}