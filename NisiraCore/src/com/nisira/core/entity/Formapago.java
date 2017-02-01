package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "FORMAPAGO")
@XStreamAlias("FORMAPAGO")

public class Formapago implements Serializable {
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
	@SerializedName("idformapago") 
	@XStreamAlias("idformapago") 
	private String idformapago = "" ;
	@Columna
	@SerializedName("descformago") 
	@XStreamAlias("descformago") 
	private String descformago = "" ;
	@Columna
	@SerializedName("contado") 
	@XStreamAlias("contado") 
	private Double contado = 0.00 ;
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

	public void setIdformapago(String idformapago) {
		this.idformapago = idformapago;
	}

	public String getIdformapago() {
		return this.idformapago;
	}

	public void setDescformago(String descformago) {
		this.descformago = descformago;
	}

	public String getDescformago() {
		return this.descformago;
	}

	public void setContado(Double contado) {
		this.contado = contado;
	}

	public Double getContado() {
		return this.contado;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}