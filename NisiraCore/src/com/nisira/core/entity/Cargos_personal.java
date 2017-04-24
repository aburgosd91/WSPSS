package com.nisira.core.entity;

import com.google.gson.annotations.SerializedName;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias("CARGOS_PERSONAL")
public class Cargos_personal implements Serializable {
        @SerializedName("idbasedatos")
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @SerializedName("idempresa")
        @XStreamAlias("IDEMPRESA")
	private String idempresa;
        @SerializedName("idcargo")
        @XStreamAlias("IDCARGO")
	private String idcargo;
        @SerializedName("descripcion")
        @XStreamAlias("DESCRIPCION")
	private String descripcion;
        private Float es_chofer;
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

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

    /**
     * @return the es_chofer
     */
    public Float getEs_chofer() {
        return es_chofer;
    }

    /**
     * @param es_chofer the es_chofer to set
     */
    public void setEs_chofer(Float es_chofer) {
        this.es_chofer = es_chofer;
    }

}