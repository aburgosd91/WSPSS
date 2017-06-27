package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("CONCEPTO_TAREO")
@Tabla(nombre = "CONCEPTO_TAREO")
public class Concepto_tareo implements Serializable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCONCEPTOTAREO")
	@ClavePrimaria
	@Columna
	private String idconceptotareo;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("NOMBRE_CORTO")
	@Columna
	private String nombre_corto;
        @XStreamAlias("POR_DEFECTO")
	@Columna
	private Float por_defecto;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdconceptotareo(String idconceptotareo) {
		this.idconceptotareo = idconceptotareo;
	}

	public String getIdconceptotareo() {
		return this.idconceptotareo;
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

	public void setPor_defecto(Float por_defecto) {
		this.por_defecto = por_defecto;
	}

	public Float getPor_defecto() {
		return this.por_defecto;
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



	/* Sets & Gets FK*/

}