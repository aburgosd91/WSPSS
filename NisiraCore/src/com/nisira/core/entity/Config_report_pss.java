package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("CONFIG_REPORT_PSS")
@Tabla(nombre = "CONFIG_REPORT_PSS")
public class Config_report_pss implements Serializable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCONFIG_REPORT")
	@ClavePrimaria
	@Columna
	private String idconfig_report;
        @XStreamAlias("IDTIPOSERVICIO")
	@ClavePrimaria
	@Columna
	private String idtiposervicio;
        @XStreamAlias("DATO1")
	@Columna
	private String dato1;
        @XStreamAlias("DATO2")
	@Columna
	private String dato2;
        @XStreamAlias("DATO3")
	@Columna
	private String dato3;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("ESTADO")
	@Columna
	private Integer estado;
        private String tiposervicio;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdconfig_report(String idconfig_report) {
		this.idconfig_report = idconfig_report;
	}

	public String getIdconfig_report() {
		return this.idconfig_report;
	}

	public void setIdtiposervicio(String idtiposervicio) {
		this.idtiposervicio = idtiposervicio;
	}

	public String getIdtiposervicio() {
		return this.idtiposervicio;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public String getDato1() {
		return this.dato1;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

	public String getDato2() {
		return this.dato2;
	}

	public void setDato3(String dato3) {
		this.dato3 = dato3;
	}

	public String getDato3() {
		return this.dato3;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

    /**
     * @return the tiposervicio
     */
    public String getTiposervicio() {
        return tiposervicio;
    }

    /**
     * @param tiposervicio the tiposervicio to set
     */
    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

}