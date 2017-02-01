package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "IDORDENLIQUIDACIONGASTO")
public class Idordenliquidaciongasto {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idorden;
	@ClavePrimaria
	@Columna
	private String item;
	@ClavePrimaria
	@Columna
	private String idimpuesto;
	@ClavePrimaria
	@Columna
	private String subitem;
	@Columna
	private Float valor;
	@Columna
	private Float baseimponible;
	@Columna
	private Float impuesto;
	@Columna
	private String idcuenta;
	@Columna
	private String idccosto;
	@Columna
	private Float orden;
	@Columna
	private Float porcentual;
	@Columna
	private Float aplicaianterior;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorden(String idorden) {
		this.idorden = idorden;
	}

	public String getIdorden() {
		return this.idorden;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setIdimpuesto(String idimpuesto) {
		this.idimpuesto = idimpuesto;
	}

	public String getIdimpuesto() {
		return this.idimpuesto;
	}

	public void setSubitem(String subitem) {
		this.subitem = subitem;
	}

	public String getSubitem() {
		return this.subitem;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getValor() {
		return this.valor;
	}

	public void setBaseimponible(Float baseimponible) {
		this.baseimponible = baseimponible;
	}

	public Float getBaseimponible() {
		return this.baseimponible;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setOrden(Float orden) {
		this.orden = orden;
	}

	public Float getOrden() {
		return this.orden;
	}

	public void setPorcentual(Float porcentual) {
		this.porcentual = porcentual;
	}

	public Float getPorcentual() {
		return this.porcentual;
	}

	public void setAplicaianterior(Float aplicaianterior) {
		this.aplicaianterior = aplicaianterior;
	}

	public Float getAplicaianterior() {
		return this.aplicaianterior;
	}



	/* Sets & Gets FK*/

}