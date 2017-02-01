package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("RUTA")
@Tabla(nombre = "RUTA")
public class Ruta {
        private String idbasedatos;
        @XStreamAlias("IDRUTA")
	@ClavePrimaria
	@Columna
	private Integer idruta;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("NRORUTA")
	@Columna
	private String nroruta;
        @XStreamAlias("DENOMINACIONRUTA")
	@Columna
	private String denominacionruta;
        @XStreamAlias("IDTIPORUTA")
	@Columna
	private Integer idtiporuta;
        @XStreamAlias("IDTERMINALORIGEN")
	@Columna
	private Integer idterminalorigen;
        @XStreamAlias("IDTERMINALDESTINO")
	@Columna
	private Integer idterminaldestino;
        @XStreamAlias("DISTANCIA")
	@Columna
	private Float distancia;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("IDPRODUCTO")
	@Columna
	private String idproducto;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("ESTADO")
	@Columna
	private int estado;
        @XStreamAlias("MAXPASAJERO")
	@Columna
	private Float maxpasajero;
        @XStreamAlias("CICLOVUELO")
	@Columna
	private Integer ciclovuelo;
        @XStreamAlias("RUTAMULTIPLE")
	@Columna
	private Integer rutamultiple;
        @XStreamAlias("IDTIPOVENTA")
	@Columna
	private String idtipoventa;
        private String rutaorigen;
        private String rutadestino;

	/* Sets & Gets */
	public void setIdruta(Integer idruta) {
		this.idruta = idruta;
	}

	public Integer getIdruta() {
		return this.idruta;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setNroruta(String nroruta) {
		this.nroruta = nroruta;
	}

	public String getNroruta() {
		return this.nroruta;
	}

	public void setDenominacionruta(String denominacionruta) {
		this.denominacionruta = denominacionruta;
	}

	public String getDenominacionruta() {
		return this.denominacionruta;
	}

	public void setIdtiporuta(Integer idtiporuta) {
		this.idtiporuta = idtiporuta;
	}

	public Integer getIdtiporuta() {
		return this.idtiporuta;
	}

	public void setIdterminalorigen(Integer idterminalorigen) {
		this.idterminalorigen = idterminalorigen;
	}

	public Integer getIdterminalorigen() {
		return this.idterminalorigen;
	}

	public void setIdterminaldestino(Integer idterminaldestino) {
		this.idterminaldestino = idterminaldestino;
	}

	public Integer getIdterminaldestino() {
		return this.idterminaldestino;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	public Float getDistancia() {
		return this.distancia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setMaxpasajero(Float maxpasajero) {
		this.maxpasajero = maxpasajero;
	}

	public Float getMaxpasajero() {
		return this.maxpasajero;
	}

	public void setCiclovuelo(Integer ciclovuelo) {
		this.ciclovuelo = ciclovuelo;
	}

	public Integer getCiclovuelo() {
		return this.ciclovuelo;
	}

	public void setRutamultiple(Integer rutamultiple) {
		this.rutamultiple = rutamultiple;
	}

	public Integer getRutamultiple() {
		return this.rutamultiple;
	}

	public void setIdtipoventa(String idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public String getIdtipoventa() {
		return this.idtipoventa;
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

    /**
     * @return the rutaorigen
     */
    public String getRutaorigen() {
        return rutaorigen;
    }

    /**
     * @param rutaorigen the rutaorigen to set
     */
    public void setRutaorigen(String rutaorigen) {
        this.rutaorigen = rutaorigen;
    }

    /**
     * @return the rutadestino
     */
    public String getRutadestino() {
        return rutadestino;
    }

    /**
     * @param rutadestino the rutadestino to set
     */
    public void setRutadestino(String rutadestino) {
        this.rutadestino = rutadestino;
    }

}