package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "CLIEPROV")
@XStreamAlias("CLIEPROV")
public class Clieprov implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("idbasedatos") 
	@XStreamAlias("IDBASEDATOS") 
	private String idbasedatos = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("IDCLIEPROV") 
	private String idclieprov = "" ;
        @Columna
	@SerializedName("tipo_clieprov") 
	@XStreamAlias("TIPO_CLIEPROV") 
	private String tipo_clieprov = "" ;
        @Columna
	@SerializedName("tipopersona") 
	@XStreamAlias("TIPOPERSONA") 
	private String tipopersona = "" ;
        @Columna
	@SerializedName("apellidopaterno") 
	@XStreamAlias("APELLIDOPATERNO") 
	private String apellidopaterno = "" ;
        @Columna
	@SerializedName("apellidomaterno") 
	@XStreamAlias("APELLIDOMATERNO") 
	private String apellidomaterno = "" ;
        @Columna
	@SerializedName("nombres") 
	@XStreamAlias("NOMBRES") 
	private String nombres = "" ;
        @Columna
	@SerializedName("dni") 
	@XStreamAlias("DNI") 
	private String dni = "" ;
        @Columna
	@SerializedName("ruc") 
	@XStreamAlias("RUC") 
	private String ruc = "" ;
	@Columna
	@SerializedName("razonsocial") 
	@XStreamAlias("RAZONSOCIAL") 
	private String razonsocial = "" ;
        @Columna
	@SerializedName("direccion") 
	@XStreamAlias("DIRECCION") 
	private String direccion = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("ESTADO") 
	private Double estado = 0.00 ;



	/* Sets & Gets */
	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

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

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

    /**
     * @return the tipo_clieprov
     */
    public String getTipo_clieprov() {
        return tipo_clieprov;
    }

    /**
     * @param tipo_clieprov the tipo_clieprov to set
     */
    public void setTipo_clieprov(String tipo_clieprov) {
        this.tipo_clieprov = tipo_clieprov;
    }

    /**
     * @return the tipopersona
     */
    public String getTipopersona() {
        return tipopersona;
    }

    /**
     * @param tipopersona the tipopersona to set
     */
    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    /**
     * @return the apellidopaterno
     */
    public String getApellidopaterno() {
        return apellidopaterno;
    }

    /**
     * @param apellidopaterno the apellidopaterno to set
     */
    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    /**
     * @return the apellidomaterno
     */
    public String getApellidomaterno() {
        return apellidomaterno;
    }

    /**
     * @param apellidomaterno the apellidomaterno to set
     */
    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}