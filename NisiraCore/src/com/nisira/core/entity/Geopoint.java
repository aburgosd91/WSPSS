package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "GEOPOINT")
public class Geopoint {
        private String idbasedatos;
	@ClavePrimaria
	@Columna
	private Integer idgeopoint;
	@Columna
	private String descripcion;
	@Columna
	private String latitud;
	@Columna
	private String longitud;
	@Columna
	private String idclieprov;
	@Columna
	private Date fechacreacion;
	@Columna
	private Integer estado;



	/* Sets & Gets */
	public void setIdgeopoint(Integer idgeopoint) {
		this.idgeopoint = idgeopoint;
	}

	public Integer getIdgeopoint() {
		return this.idgeopoint;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstado() {
		return this.estado;
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