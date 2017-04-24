package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "tipo_asistencia")
public class Tipo_asistencia {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idtipoasistencia;
	@Columna
	private String descripcion;
	@Columna
	private String nombre_corto;
	@Columna
	private Float exige_glosa;
	@Columna
	private Float estado;
	@Columna
	private String color;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdtipoasistencia(String idtipoasistencia) {
		this.idtipoasistencia = idtipoasistencia;
	}

	public String getIdtipoasistencia() {
		return this.idtipoasistencia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setExige_glosa(Float exige_glosa) {
		this.exige_glosa = exige_glosa;
	}

	public Float getExige_glosa() {
		return this.exige_glosa;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}



	/* Sets & Gets FK*/

}