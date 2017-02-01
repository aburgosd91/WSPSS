package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "ESTADOS")
public class Estados {
        private String idbasedatos;
	@ClavePrimaria
	@Columna
	private String idestado;
	@Columna
	private String descripcion;
	@Columna
	private Float orden;
	@Columna
	private Float verflujo;
	@Columna
	private String accion;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String color;



	/* Sets & Gets */
	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setOrden(Float orden) {
		this.orden = orden;
	}

	public Float getOrden() {
		return this.orden;
	}

	public void setVerflujo(Float verflujo) {
		this.verflujo = verflujo;
	}

	public Float getVerflujo() {
		return this.verflujo;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getAccion() {
		return this.accion;
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

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
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