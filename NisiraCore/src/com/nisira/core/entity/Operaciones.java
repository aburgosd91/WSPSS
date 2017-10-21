package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "OPERACIONES")
public class Operaciones {
	@ClavePrimaria
	@Columna
	private String idoperacion;
	@Columna
	private String descripcion;
	@Columna
	private String modulo;
	@Columna
	private String tipo;
	@Columna
	private String origen;
	@Columna
	private String idsubdiario;
	@Columna
	private String tcambio;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private Float en_regcompra;
	@Columna
	private Float con_cheque;
	@Columna
	private String idtipooperacion;



	/* Sets & Gets */
	public void setIdoperacion(String idoperacion) {
		this.idoperacion = idoperacion;
	}

	public String getIdoperacion() {
		return this.idoperacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setIdsubdiario(String idsubdiario) {
		this.idsubdiario = idsubdiario;
	}

	public String getIdsubdiario() {
		return this.idsubdiario;
	}

	public void setTcambio(String tcambio) {
		this.tcambio = tcambio;
	}

	public String getTcambio() {
		return this.tcambio;
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

	public void setEn_regcompra(Float en_regcompra) {
		this.en_regcompra = en_regcompra;
	}

	public Float getEn_regcompra() {
		return this.en_regcompra;
	}

	public void setCon_cheque(Float con_cheque) {
		this.con_cheque = con_cheque;
	}

	public Float getCon_cheque() {
		return this.con_cheque;
	}

	public void setIdtipooperacion(String idtipooperacion) {
		this.idtipooperacion = idtipooperacion;
	}

	public String getIdtipooperacion() {
		return this.idtipooperacion;
	}



	/* Sets & Gets FK*/

}