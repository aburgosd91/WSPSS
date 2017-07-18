package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;

@Tabla(nombre = "DESTRUCTURA_TAREO_CLIEPROV")
public class Destructura_tareo_clieprov {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idclieprov;
	@ClavePrimaria
	@Columna
	private String item;
	@Columna
	private String descripcion;
	@Columna
	private Float hora;
	@Columna
	private String idruta;
        @Columna
	private Float esfecha;
        
        private String cliente;
        private String ruta;
	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setHora(Float hora) {
		this.hora = hora;
	}

	public Float getHora() {
		return this.hora;
	}

	public void setIdruta(String idruta) {
		this.idruta = idruta;
	}

	public String getIdruta() {
		return this.idruta;
	}



	/* Sets & Gets FK*/

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
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the esfecha
     */
    public Float getEsfecha() {
        return esfecha;
    }

    /**
     * @param esfecha the esfecha to set
     */
    public void setEsfecha(Float esfecha) {
        this.esfecha = esfecha;
    }

}