package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "MONEDA")
@XStreamAlias("MONEDA")

public class Moneda implements Serializable {
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
	@SerializedName("idmoneda") 
	@XStreamAlias("idmoneda") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("descmoneda") 
	@XStreamAlias("descmoneda") 
	private String descmoneda = "" ;
	@Columna
	@SerializedName("tipomoneda") 
	@XStreamAlias("tipomoneda") 
	private String tipomoneda = "" ;
	@Columna
	@SerializedName("nombrecorto") 
	@XStreamAlias("nombrecorto") 
	private String nombrecorto = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("estado") 
	private Double estado = 0.00 ;



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

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setDescmoneda(String descmoneda) {
		this.descmoneda = descmoneda;
	}

	public String getDescmoneda() {
		return this.descmoneda;
	}

	public void setTipomoneda(String tipomoneda) {
		this.tipomoneda = tipomoneda;
	}

	public String getTipomoneda() {
		return this.tipomoneda;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getNombrecorto() {
		return this.nombrecorto;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}