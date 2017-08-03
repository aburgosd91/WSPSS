package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DPROGRAMACION_ACTIVIDAD")
public class Dprogramacion_actividad {
	@ClavePrimaria
	@Columna
	private Integer idprogramacion;
	@ClavePrimaria
	@Columna
	private Integer idactividad;
	@Columna
	private String actividad_descripcion;



	/* Sets & Gets */
	public void setIdprogramacion(Integer idprogramacion) {
		this.idprogramacion = idprogramacion;
	}

	public Integer getIdprogramacion() {
		return this.idprogramacion;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setActividad_descripcion(String actividad_descripcion) {
		this.actividad_descripcion = actividad_descripcion;
	}

	public String getActividad_descripcion() {
		return this.actividad_descripcion;
	}



	/* Sets & Gets FK*/

}