package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("WTIPOSERVICIO")
@Tabla(nombre = "WTIPOSERVICIO")
public class Wtiposervicio implements Serializable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDTIPOSERVICIO")
	@ClavePrimaria
	@Columna
	private String idtiposervicio;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("DESCRIPCION_CORTA")
	@Columna
	private String descripcion_corta;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdtiposervicio(String idtiposervicio) {
		this.idtiposervicio = idtiposervicio;
	}

	public String getIdtiposervicio() {
		return this.idtiposervicio;
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



	/* Sets & Gets FK*/

}