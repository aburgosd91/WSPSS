package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@Tabla(nombre = "ambito_pago")
@XStreamAlias("ambito_pago")
public class Ambito_pago implements Serializable{
	@ClavePrimaria
	@Columna
        @XStreamAlias("idempresa")
	private String idempresa;
	@ClavePrimaria
	@Columna
        @XStreamAlias("codigo")
	private String codigo;
	@Columna
        @XStreamAlias("descripcion")
	private String descripcion;
	@Columna
        @XStreamAlias("nombre_corto")
	private String nombre_corto;
	@Columna
        @XStreamAlias("costo_por_hora")
	private Float costo_por_hora;
	@Columna
        @XStreamAlias("costo_adicional")
	private Float costo_adicional;



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

	public void setCosto_por_hora(Float costo_por_hora) {
		this.costo_por_hora = costo_por_hora;
	}

	public Float getCosto_por_hora() {
		return this.costo_por_hora;
	}

	public void setCosto_adicional(Float costo_adicional) {
		this.costo_adicional = costo_adicional;
	}

	public Float getCosto_adicional() {
		return this.costo_adicional;
	}



	/* Sets & Gets FK*/

}