package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "PRIVILEGIOUSUARIOALMACEN")
@XStreamAlias("PRIVILEGIOUSUARIOALMACEN")

public class Privilegiousuarioalmacen implements Serializable {
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
	@SerializedName("idusuario") 
	@XStreamAlias("idusuario") 
	private String idusuario = "" ;
	@Columna
	@SerializedName("idsucursal") 
	@XStreamAlias("idsucursal") 
	private String idsucursal = "" ;
	@Columna
	@SerializedName("idalmacen") 
	@XStreamAlias("idalmacen") 
	private String idalmacen = "" ;
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

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}