package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.Date;
import java.util.ArrayList;

@Tabla(nombre = "PEDIDOMOVIL")
@XStreamAlias("PEDIDOMOVIL")

public class Pedidomovil implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idbasedatos") 
	@XStreamAlias("idbasedatos") 
	private String idbasedatos = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("idempresa") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idpedido") 
	@XStreamAlias("idpedido") 
	private String idpedido = "" ;
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("fecha") 
	private Date fecha;
	@Columna
	@SerializedName("hora") 
	@XStreamAlias("hora") 
	private String hora = "" ;
	@Columna
	@SerializedName("idvendedor") 
	@XStreamAlias("idvendedor") 
	private String idvendedor = "" ;
	@Columna
	@SerializedName("descvendedor") 
	@XStreamAlias("descvendedor") 
	private String descvendedor = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("idclieprov") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("descclieprov") 
	@XStreamAlias("descclieprov") 
	private String descclieprov = "" ;
	@Columna
	@SerializedName("idformapago") 
	@XStreamAlias("idformapago") 
	private String idformapago = "" ;
	@Columna
	@SerializedName("descformapago") 
	@XStreamAlias("descformapago") 
	private String descformapago = "" ;
	@Columna
	@SerializedName("idmoneda") 
	@XStreamAlias("idmoneda") 
	private String idmoneda = "" ;
	@Columna
	@SerializedName("descmoneda") 
	@XStreamAlias("descmoneda") 
	private String descmoneda = "" ;
	@Columna
	@SerializedName("tcambio") 
	@XStreamAlias("tcambio") 
	private Double tcambio = 0.00 ;
	@Columna
	@SerializedName("iddocumento") 
	@XStreamAlias("iddocumento") 
	private String iddocumento = "" ;
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("serie") 
	private String serie = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("numero") 
	private String numero = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("estado") 
	private String estado = "" ;



	/* Sets & Gets */
	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getIdpedido() {
		return this.idpedido;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHora() {
		return this.hora;
	}

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setDescvendedor(String descvendedor) {
		this.descvendedor = descvendedor;
	}

	public String getDescvendedor() {
		return this.descvendedor;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setDescclieprov(String descclieprov) {
		this.descclieprov = descclieprov;
	}

	public String getDescclieprov() {
		return this.descclieprov;
	}

	public void setIdformapago(String idformapago) {
		this.idformapago = idformapago;
	}

	public String getIdformapago() {
		return this.idformapago;
	}

	public void setDescformapago(String descformapago) {
		this.descformapago = descformapago;
	}

	public String getDescformapago() {
		return this.descformapago;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setDescmoneda(String descmoneda) {
		this.descmoneda = descmoneda;
	}

	public String getDescmoneda() {
		return this.descmoneda;
	}

	public void setTcambio(Double tcambio) {
		this.tcambio = tcambio;
	}

	public Double getTcambio() {
		return this.tcambio;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}