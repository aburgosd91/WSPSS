package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "DPEDIDOMOVIL")
@XStreamAlias("DPEDIDOMOVIL")

public class Dpedidomovil implements Serializable {
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
	@SerializedName("idpedido") 
	@XStreamAlias("idpedido") 
	private String idpedido = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("item") 
	@XStreamAlias("item") 
	private Integer item;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("idsucursal") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("descsucursal") 
	@XStreamAlias("descsucursal") 
	private String descsucursal = "" ;
	@Columna
	@SerializedName("idalmacen") 
	@XStreamAlias("idalmacen") 
	private String idalmacen = "" ;
	@Columna
	@SerializedName("descalmacen") 
	@XStreamAlias("descalmacen") 
	private String descalmacen = "" ;
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
	@SerializedName("cantidad") 
	@XStreamAlias("cantidad") 
	private Double cantidad = 0.00 ;
	@Columna
	@SerializedName("precio") 
	@XStreamAlias("precio") 
	private Double precio = 0.00 ;
	@Columna
	@SerializedName("importe") 
	@XStreamAlias("importe") 
	private Double importe = 0.00 ;



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

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getIdpedido() {
		return this.idpedido;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getItem() {
		return this.item;
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

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getImporte() {
		return this.importe;
	}



	/* Sets & Gets FK*/

}