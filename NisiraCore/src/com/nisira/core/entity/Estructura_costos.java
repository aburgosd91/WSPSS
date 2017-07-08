package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("ESTRUCTURA_COSTOS")
@Tabla(nombre = "ESTRUCTURA_COSTOS")
public class Estructura_costos implements Serializable{
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("CODIGO")
	@ClavePrimaria
	@Columna
	private String codigo;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("NOMBRE_CORTO")
	@Columna
	private String nombre_corto;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("IDMONEDA")
	@Columna
	private String idmoneda;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("EXCLUIR")
	@Columna
	private Float excluir;
        private String moneda;
        private String idclieprov;
        private String cliente;
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

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}
	/* Sets & Gets FK*/

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the idclieprov
     */
    public String getIdclieprov() {
        return idclieprov;
    }

    /**
     * @param idclieprov the idclieprov to set
     */
    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the excluir
     */
    public Float getExcluir() {
        return excluir;
    }

    /**
     * @param excluir the excluir to set
     */
    public void setExcluir(Float excluir) {
        this.excluir = excluir;
    }

}