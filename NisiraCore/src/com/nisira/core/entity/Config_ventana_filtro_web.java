package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("CONFIG_VENTANA_FILTRO_WEB")
@Tabla(nombre = "CONFIG_VENTANA_FILTRO_WEB")
public class Config_ventana_filtro_web {
        @XStreamAlias("ID")
	@ClavePrimaria
	@Columna
	private Integer id;
        @XStreamAlias("TABLA")
	@Columna
	private String tabla;
        @XStreamAlias("VENTANA")
	@Columna
	private String ventana;
        @XStreamAlias("DESCRIPCION")
        @Columna
	private String descripcion;
        @XStreamAlias("ALCANCE")
	@Columna
	private String alcance;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;

	/* Sets & Gets */
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getAlcance() {
		return this.alcance;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}