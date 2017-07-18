package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "IMPUESTO")
public class Impuesto {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idimpuesto;
	@Columna
	private String descripcion;
	@Columna
	private String desc_corta;
	@Columna
	private Float con_destino;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private Float resta_base;
	@Columna
	private Integer porcentual;
	@Columna
	private Float orden;
	@Columna
	private Float aplicaianterior;
	@Columna
	private Float para_seguro;
	@Columna
	private Float es_snp;
	@Columna
	private String tipoimpuesto;
	@Columna
	private String cod_sunat;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdimpuesto(String idimpuesto) {
		this.idimpuesto = idimpuesto;
	}

	public String getIdimpuesto() {
		return this.idimpuesto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDesc_corta(String desc_corta) {
		this.desc_corta = desc_corta;
	}

	public String getDesc_corta() {
		return this.desc_corta;
	}

	public void setCon_destino(Float con_destino) {
		this.con_destino = con_destino;
	}

	public Float getCon_destino() {
		return this.con_destino;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
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

	public void setResta_base(Float resta_base) {
		this.resta_base = resta_base;
	}

	public Float getResta_base() {
		return this.resta_base;
	}

	public void setPorcentual(Integer porcentual) {
		this.porcentual = porcentual;
	}

	public Integer getPorcentual() {
		return this.porcentual;
	}

	public void setOrden(Float orden) {
		this.orden = orden;
	}

	public Float getOrden() {
		return this.orden;
	}

	public void setAplicaianterior(Float aplicaianterior) {
		this.aplicaianterior = aplicaianterior;
	}

	public Float getAplicaianterior() {
		return this.aplicaianterior;
	}

	public void setPara_seguro(Float para_seguro) {
		this.para_seguro = para_seguro;
	}

	public Float getPara_seguro() {
		return this.para_seguro;
	}

	public void setEs_snp(Float es_snp) {
		this.es_snp = es_snp;
	}

	public Float getEs_snp() {
		return this.es_snp;
	}

	public void setTipoimpuesto(String tipoimpuesto) {
		this.tipoimpuesto = tipoimpuesto;
	}

	public String getTipoimpuesto() {
		return this.tipoimpuesto;
	}

	public void setCod_sunat(String cod_sunat) {
		this.cod_sunat = cod_sunat;
	}

	public String getCod_sunat() {
		return this.cod_sunat;
	}



	/* Sets & Gets FK*/

}