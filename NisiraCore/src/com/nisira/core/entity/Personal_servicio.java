package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("PERSONAL_SERVICIO")
@Tabla(nombre = "PERSONAL_SERVICIO")
public class Personal_servicio {
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDORDENSERVICIO")
	@ClavePrimaria
	@Columna
	private String idordenservicio;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("ITEM2")
	@ClavePrimaria
	@Columna
	private String item2;
        @XStreamAlias("IDPERSONAL")
	@Columna
	private String idpersonal;
        @XStreamAlias("DNI")
	@Columna
	private String dni;
        @XStreamAlias("NOMBRES")
	@Columna
	private String nombres;
        @XStreamAlias("FECHAOPERACION")
	@Columna
	private Date fechaoperacion;
        @XStreamAlias("IDCARGO")
	@Columna
	private String idcargo;
        private String cargo;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setFechaoperacion(Date fechaoperacion) {
		this.fechaoperacion = fechaoperacion;
	}

	public Date getFechaoperacion() {
		return this.fechaoperacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
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
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}