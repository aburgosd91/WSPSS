package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "TIPOREGIMEN")
public class Tiporegimen {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idregimen;
	@Columna
	private String descripcion;
	@Columna
	private Float estado;
	@Columna
	private Date fechacreacion;
	@Columna
	private String sincroniza;
	@Columna
	private Float es_afecto;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdregimen(String idregimen) {
		this.idregimen = idregimen;
	}

	public String getIdregimen() {
		return this.idregimen;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setEs_afecto(Float es_afecto) {
		this.es_afecto = es_afecto;
	}

	public Float getEs_afecto() {
		return this.es_afecto;
	}



	/* Sets & Gets FK*/

}