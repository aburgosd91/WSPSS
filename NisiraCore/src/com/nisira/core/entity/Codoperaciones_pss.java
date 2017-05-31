package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("CODOPERACIONES_PSS")
@Tabla(nombre = "CODOPERACIONES_PSS")
public class Codoperaciones_pss implements Serializable{
        @XStreamAlias("IDCODOPERACIONES")
	@ClavePrimaria
	@Columna
	private String idcodoperaciones;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("DESCRIPCION_CORTA")
	@Columna
	private String descripcion_corta;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;



	/* Sets & Gets */
	public void setIdcodoperaciones(String idcodoperaciones) {
		this.idcodoperaciones = idcodoperaciones;
	}

	public String getIdcodoperaciones() {
		return this.idcodoperaciones;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion_corta(String descripcion_corta) {
		this.descripcion_corta = descripcion_corta;
	}

	public String getDescripcion_corta() {
		return this.descripcion_corta;
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



	/* Sets & Gets FK*/

}