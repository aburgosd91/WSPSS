package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "TIPODETRACCION")
public class Tipodetraccion {
	@ClavePrimaria
	@Columna
	private String idtipodetra;
	@Columna
	private String descripcion;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private Float estado;
	@Columna
	private String codigo_sunat;
	@Columna
	private Float tasa;
	@Columna
	private Float es_transporte;
	@Columna
	private String nombre_corto;



	/* Sets & Gets */
	public void setIdtipodetra(String idtipodetra) {
		this.idtipodetra = idtipodetra;
	}

	public String getIdtipodetra() {
		return this.idtipodetra;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public String getCodigo_sunat() {
		return this.codigo_sunat;
	}

	public void setTasa(Float tasa) {
		this.tasa = tasa;
	}

	public Float getTasa() {
		return this.tasa;
	}

	public void setEs_transporte(Float es_transporte) {
		this.es_transporte = es_transporte;
	}

	public Float getEs_transporte() {
		return this.es_transporte;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}



	/* Sets & Gets FK*/

}