package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "ESTRUCTURA_TAREO_CLIEPROV")
public class Estructura_tareo_clieprov {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idclieprov;
	@Columna
	private String descripcion;
	@Columna
	private Float activo;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setActivo(Float activo) {
		this.activo = activo;
	}

	public Float getActivo() {
		return this.activo;
	}



	/* Sets & Gets FK*/

}