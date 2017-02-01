package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;

@XStreamAlias("NUMEMISOR")
@Tabla(nombre = "NUMEMISOR")
public class Numemisor {
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDEMISOR")
	@ClavePrimaria
	@Columna
	private String idemisor;
        @XStreamAlias("IDDOCUMENTO")
	@ClavePrimaria
	@Columna
	private String iddocumento;
        @XStreamAlias("SERIE")
	@ClavePrimaria
	@Columna
	private String serie;
        @XStreamAlias("NUMERO")
	@Columna
	private String numero;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("ES_IMPORTACION")
	@Columna
	private Float es_importacion;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("NLINEAS")
	@Columna
	private Float nlineas;
        @XStreamAlias("OBSERVACION")
	@Columna
	private String observacion;
        @XStreamAlias("IDTIPOVENTA")
	@Columna
	private String idtipoventa;
        @XStreamAlias("PARADECLARACION_CE")
	@Columna
	private Float paradeclaracion_ce;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
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

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setEs_importacion(Float es_importacion) {
		this.es_importacion = es_importacion;
	}

	public Float getEs_importacion() {
		return this.es_importacion;
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

	public void setNlineas(Float nlineas) {
		this.nlineas = nlineas;
	}

	public Float getNlineas() {
		return this.nlineas;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setIdtipoventa(String idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public String getIdtipoventa() {
		return this.idtipoventa;
	}

	public void setParadeclaracion_ce(Float paradeclaracion_ce) {
		this.paradeclaracion_ce = paradeclaracion_ce;
	}

	public Float getParadeclaracion_ce() {
		return this.paradeclaracion_ce;
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