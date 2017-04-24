package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("DOCREFERENCIA")
@Tabla(nombre = "DOCREFERENCIA")
public class Docreferencia implements Serializable {
        private String idbasedatos;
	@Columna
        @XStreamAlias("IDEMPRESA")
	private String idempresa;
	@Columna
	@XStreamAlias("IDORIGEN")
        private String idorigen;
	@Columna
        @XStreamAlias("TABLA")
	private String tabla;
	@Columna
        @XStreamAlias("IDREFERENCIA")
	private String idreferencia;
	@Columna
        @XStreamAlias("IDDOCUMENTO")
	private String iddocumento;
	@Columna
        @XStreamAlias("SERIE")
	private String serie;
	@Columna
        @XStreamAlias("NUMERO")
	private String numero;
	@Columna
        @XStreamAlias("FECHA")
	private Date fecha;
	@Columna
        @XStreamAlias("EXONERADO")
	private Float exonerado;
	@Columna
        @XStreamAlias("ARCHIVAR")
	private Float archivar;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorigen(String idorigen) {
		this.idorigen = idorigen;
	}

	public String getIdorigen() {
		return this.idorigen;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setIdreferencia(String idreferencia) {
		this.idreferencia = idreferencia;
	}

	public String getIdreferencia() {
		return this.idreferencia;
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

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setExonerado(Float exonerado) {
		this.exonerado = exonerado;
	}

	public Float getExonerado() {
		return this.exonerado;
	}

	public void setArchivar(Float archivar) {
		this.archivar = archivar;
	}

	public Float getArchivar() {
		return this.archivar;
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