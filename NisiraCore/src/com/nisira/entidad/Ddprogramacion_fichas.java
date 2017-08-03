package com.nisira.entidad;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DDPROGRAMACION_FICHAS")
public class Ddprogramacion_fichas {
	@ClavePrimaria
	@Columna
	private Integer idprogramacion;
	@ClavePrimaria
	@Columna
	private Integer item;
	@ClavePrimaria
	@Columna
	private Integer idactividad;
	@Columna
	private Integer idestado;
	@Columna
	private String observaciones;



	/* Sets & Gets */
	public void setIdprogramacion(Integer idprogramacion) {
		this.idprogramacion = idprogramacion;
	}

	public Integer getIdprogramacion() {
		return this.idprogramacion;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}

	public Integer getIdactividad() {
		return this.idactividad;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	public Integer getIdestado() {
		return this.idestado;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}



	/* Sets & Gets FK*/

}