package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "UBIGEO")
public class Ubigeo implements Serializable{
	@ClavePrimaria
	@Columna
	private String idubigeo;
	@Columna
	private String descripcion;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idprovincia;
	@Columna
	private String iddepartamento;
	@Columna
	private String reniec;



	/* Sets & Gets */
	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
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

	public void setIdprovincia(String idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getIdprovincia() {
		return this.idprovincia;
	}

	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getIddepartamento() {
		return this.iddepartamento;
	}

	public void setReniec(String reniec) {
		this.reniec = reniec;
	}

	public String getReniec() {
		return this.reniec;
	}



	/* Sets & Gets FK*/

}