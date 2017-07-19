package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "AMBITO_PAGO_COSTOMO")
public class Ambito_pago_costomo {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String codigo;
	@ClavePrimaria
	@Columna
	private String idcargo;
	@Columna
	private Float costo_bono;
	@ClavePrimaria
	@Columna
	private String idruta;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setCosto_bono(Float costo_bono) {
		this.costo_bono = costo_bono;
	}

	public Float getCosto_bono() {
		return this.costo_bono;
	}

	public void setIdruta(String idruta) {
		this.idruta = idruta;
	}

	public String getIdruta() {
		return this.idruta;
	}



	/* Sets & Gets FK*/

}