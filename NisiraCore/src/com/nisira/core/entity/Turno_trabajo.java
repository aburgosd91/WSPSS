package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "TURNO_TRABAJO")
public class Turno_trabajo implements Serializable {
	@ClavePrimaria
	@Columna
	private String idturnotrabajo;
	@Columna
	private String descripcion;
	@Columna
	private Float desde;
	@Columna
	private Float hasta;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private Float mingreso;
	@Columna
	private Float msalida;
	@Columna
	private Float hrefrigerio;
	@Columna
	private Float mrefrigerio;
	@Columna
	private Float hextra;
	@Columna
	private Float mextra;
	@Columna
	private Float refhdesde;
	@Columna
	private Float refmdesde;
	@Columna
	private Float refhhasta;
	@Columna
	private Float refmhasta;
	@Columna
	private Float diasgte;
	@Columna
	private Float slsalida;
	@Columna
	private Float fds;
	@Columna
	private Float amanecida;
	@Columna
	private Float notardanza1;
	@Columna
	private Float mtolerancia;
	@Columna
	private Float hdurmax;
	@Columna
	private Float mdurmax;



	/* Sets & Gets */
	public void setIdturnotrabajo(String idturnotrabajo) {
		this.idturnotrabajo = idturnotrabajo;
	}

	public String getIdturnotrabajo() {
		return this.idturnotrabajo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDesde(Float desde) {
		this.desde = desde;
	}

	public Float getDesde() {
		return this.desde;
	}

	public void setHasta(Float hasta) {
		this.hasta = hasta;
	}

	public Float getHasta() {
		return this.hasta;
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

	public void setMingreso(Float mingreso) {
		this.mingreso = mingreso;
	}

	public Float getMingreso() {
		return this.mingreso;
	}

	public void setMsalida(Float msalida) {
		this.msalida = msalida;
	}

	public Float getMsalida() {
		return this.msalida;
	}

	public void setHrefrigerio(Float hrefrigerio) {
		this.hrefrigerio = hrefrigerio;
	}

	public Float getHrefrigerio() {
		return this.hrefrigerio;
	}

	public void setMrefrigerio(Float mrefrigerio) {
		this.mrefrigerio = mrefrigerio;
	}

	public Float getMrefrigerio() {
		return this.mrefrigerio;
	}

	public void setHextra(Float hextra) {
		this.hextra = hextra;
	}

	public Float getHextra() {
		return this.hextra;
	}

	public void setMextra(Float mextra) {
		this.mextra = mextra;
	}

	public Float getMextra() {
		return this.mextra;
	}

	public void setRefhdesde(Float refhdesde) {
		this.refhdesde = refhdesde;
	}

	public Float getRefhdesde() {
		return this.refhdesde;
	}

	public void setRefmdesde(Float refmdesde) {
		this.refmdesde = refmdesde;
	}

	public Float getRefmdesde() {
		return this.refmdesde;
	}

	public void setRefhhasta(Float refhhasta) {
		this.refhhasta = refhhasta;
	}

	public Float getRefhhasta() {
		return this.refhhasta;
	}

	public void setRefmhasta(Float refmhasta) {
		this.refmhasta = refmhasta;
	}

	public Float getRefmhasta() {
		return this.refmhasta;
	}

	public void setDiasgte(Float diasgte) {
		this.diasgte = diasgte;
	}

	public Float getDiasgte() {
		return this.diasgte;
	}

	public void setSlsalida(Float slsalida) {
		this.slsalida = slsalida;
	}

	public Float getSlsalida() {
		return this.slsalida;
	}

	public void setFds(Float fds) {
		this.fds = fds;
	}

	public Float getFds() {
		return this.fds;
	}

	public void setAmanecida(Float amanecida) {
		this.amanecida = amanecida;
	}

	public Float getAmanecida() {
		return this.amanecida;
	}

	public void setNotardanza1(Float notardanza1) {
		this.notardanza1 = notardanza1;
	}

	public Float getNotardanza1() {
		return this.notardanza1;
	}

	public void setMtolerancia(Float mtolerancia) {
		this.mtolerancia = mtolerancia;
	}

	public Float getMtolerancia() {
		return this.mtolerancia;
	}

	public void setHdurmax(Float hdurmax) {
		this.hdurmax = hdurmax;
	}

	public Float getHdurmax() {
		return this.hdurmax;
	}

	public void setMdurmax(Float mdurmax) {
		this.mdurmax = mdurmax;
	}

	public Float getMdurmax() {
		return this.mdurmax;
	}



	/* Sets & Gets FK*/

}