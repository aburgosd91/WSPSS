package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "MONEDAS")
public class Monedas implements Serializable{
        private String idbasedatos = "" ;
	@ClavePrimaria
	@Columna
	private String idmoneda;
	@Columna
	private String nombre_corto;
	@Columna
	private String descripcion;
	@Columna
	private String tipo_moneda;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idregistro_sunat;
	@Columna
	private String descripcion_ingles;
	@Columna
	private String tipo_busqueda;
	@Columna
	private String descripcion2;
	@Columna
	private String idbusqueda;
	@Columna
	private Float difdias;
	@Columna
	private Float orden_ajuste;



	/* Sets & Gets */
	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
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

	public void setTipo_moneda(String tipo_moneda) {
		this.tipo_moneda = tipo_moneda;
	}

	public String getTipo_moneda() {
		return this.tipo_moneda;
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

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setDescripcion_ingles(String descripcion_ingles) {
		this.descripcion_ingles = descripcion_ingles;
	}

	public String getDescripcion_ingles() {
		return this.descripcion_ingles;
	}

	public void setTipo_busqueda(String tipo_busqueda) {
		this.tipo_busqueda = tipo_busqueda;
	}

	public String getTipo_busqueda() {
		return this.tipo_busqueda;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setIdbusqueda(String idbusqueda) {
		this.idbusqueda = idbusqueda;
	}

	public String getIdbusqueda() {
		return this.idbusqueda;
	}

	public void setDifdias(Float difdias) {
		this.difdias = difdias;
	}

	public Float getDifdias() {
		return this.difdias;
	}

	public void setOrden_ajuste(Float orden_ajuste) {
		this.orden_ajuste = orden_ajuste;
	}

	public Float getOrden_ajuste() {
		return this.orden_ajuste;
	}



	/* Sets & Gets FK*/

    /**
     * @return the idbasedatos
     */
    public String getIdbasedatos() {
        return idbasedatos;
    }

    /**
     * @param idbasedatos the idbasedatos to set
     */
    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

}