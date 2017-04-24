package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "VENDEDOR")
public class Vendedor implements Serializable{
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idvendedor;
	@Columna
	private String idsucursal;
	@Columna
	private String idusuario;
	@Columna
	private String nombre_corto;
	@Columna
	private String descripcion;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idpersonal;
	@Columna
	private String cargo;
	@Columna
	private String telefono1;
	@Columna
	private String telefono2;
	@Columna
	private String email;
	@Columna
	private String idfuerza_ventas;
	@Columna
	private String tipo_precio;
	@Columna
	private String codigo_alt;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
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

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setIdfuerza_ventas(String idfuerza_ventas) {
		this.idfuerza_ventas = idfuerza_ventas;
	}

	public String getIdfuerza_ventas() {
		return this.idfuerza_ventas;
	}

	public void setTipo_precio(String tipo_precio) {
		this.tipo_precio = tipo_precio;
	}

	public String getTipo_precio() {
		return this.tipo_precio;
	}

	public void setCodigo_alt(String codigo_alt) {
		this.codigo_alt = codigo_alt;
	}

	public String getCodigo_alt() {
		return this.codigo_alt;
	}



	/* Sets & Gets FK*/

}