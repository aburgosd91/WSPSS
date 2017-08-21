package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.Date;

@XStreamAlias("DESTRUCTURA_TAREO_CLIEPROV")
@Tabla(nombre = "DESTRUCTURA_TAREO_CLIEPROV")
public class Destructura_tareo_clieprov implements Serializable,Cloneable{
	@ClavePrimaria
	@Columna
        @XStreamAlias("IDEMPRESA")
	private String idempresa;
	@ClavePrimaria
	@Columna
        @XStreamAlias("IDCLIEPROV")
	private String idclieprov;
	@ClavePrimaria
	@Columna
        @XStreamAlias("ITEM")
	private String item;
	@Columna
        @XStreamAlias("DESCRIPCION")
	private String descripcion;
	@Columna
        @XStreamAlias("HORA")
	private Float hora;
	@Columna
        @XStreamAlias("IDRUTA")
	private String idruta;
        @Columna
        @XStreamAlias("ESFECHA")
	private Float esfecha;
        @XStreamOmitField
        private String cliente;
        @XStreamOmitField
        private String ruta;
        @XStreamOmitField
        private Date horaH;
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

        public Float getEsfecha() {
            return esfecha;
        }

        public void setEsfecha(Float esfecha) {
            this.esfecha = esfecha;
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

    public Date getHoraH() {
        return horaH;
    }

    public void setHoraH(Date horaH) {
        this.horaH = horaH;
    }
    public boolean isBEFecha() {
        return this.getEsfecha()== 1;
    }

    public void setBEFecha(boolean band) {
        this.setEsfecha((band) ?  1f :  0f);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }    
}
