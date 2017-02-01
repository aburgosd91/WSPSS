package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "VENDEDOR")
@XStreamAlias("VENDEDOR")

public class Vendedor implements Serializable {
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
	@SerializedName("idvendedor") 
	@XStreamAlias("idvendedor") 
	private String idvendedor = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("descripcion") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("nombrecorto") 
	@XStreamAlias("nombrecorto") 
	private String nombrecorto = "" ;
	@Columna
	@SerializedName("idusuario") 
	@XStreamAlias("idusuario") 
	private String idusuario = "" ;
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

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getNombrecorto() {
		return this.nombrecorto;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}