package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;

@XStreamAlias("DESTINOADQUISICION")
@Tabla(nombre = "DESTINOADQUISICION")
public class Destinoadquisicion {
        @XStreamAlias("DESTINOADQUISICION")
        private String idbasedatos;
        @XStreamAlias("IDDESTINO")
	@ClavePrimaria
	@Columna
	private String iddestino;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;



	/* Sets & Gets */
	public void setIddestino(String iddestino) {
		this.iddestino = iddestino;
	}

	public String getIddestino() {
		return this.iddestino;
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