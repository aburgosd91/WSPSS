package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("CARGOS_PERSONAL")
@Tabla(nombre = "CARGOS_PERSONAL")
public class Cargos_personal {
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCARGO")
	@ClavePrimaria
	@Columna
	private String idcargo;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("IDACTIVIDAD")
	@Columna
	private String idactividad;
        @XStreamAlias("IDLABOR")
	@Columna
	private String idlabor;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("CODALTERNO")
	@Columna
	private String codalterno;
        @XStreamAlias("ES_GUARDIAN")
	@Columna
	private Integer es_guardian;
        @XStreamAlias("ES_PERS_AEREO")
	@Columna
	private Float es_pers_aereo;
        @XStreamAlias("CARGO_PESQUERA")
	@Columna
	private String cargo_pesquera;
        @XStreamAlias("PRODUCCION_PESQUERA")
	@Columna
	private Float produccion_pesquera;
        @XStreamAlias("TIPO_TRABAJO")
	@Columna
	private String tipo_trabajo;
        @XStreamAlias("IDAREA")
	@Columna
	private String idarea;
        @XStreamAlias("ES_JEFEDEAREA")
	@Columna
	private Float es_jefedearea;
        @XStreamAlias("USA_SUBSECTOR")
	@Columna
	private Float usa_subsector;
        @XStreamAlias("TIPO_CARGO")
	@Columna
	private Float tipo_cargo;



	/* Sets & Gets */
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

	public void setIdactividad(String idactividad) {
		this.idactividad = idactividad;
	}

	public String getIdactividad() {
		return this.idactividad;
	}

	public void setIdlabor(String idlabor) {
		this.idlabor = idlabor;
	}

	public String getIdlabor() {
		return this.idlabor;
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

	public void setCodalterno(String codalterno) {
		this.codalterno = codalterno;
	}

	public String getCodalterno() {
		return this.codalterno;
	}

	public void setEs_guardian(Integer es_guardian) {
		this.es_guardian = es_guardian;
	}

	public Integer getEs_guardian() {
		return this.es_guardian;
	}

	public void setEs_pers_aereo(Float es_pers_aereo) {
		this.es_pers_aereo = es_pers_aereo;
	}

	public Float getEs_pers_aereo() {
		return this.es_pers_aereo;
	}

	public void setCargo_pesquera(String cargo_pesquera) {
		this.cargo_pesquera = cargo_pesquera;
	}

	public String getCargo_pesquera() {
		return this.cargo_pesquera;
	}

	public void setProduccion_pesquera(Float produccion_pesquera) {
		this.produccion_pesquera = produccion_pesquera;
	}

	public Float getProduccion_pesquera() {
		return this.produccion_pesquera;
	}

	public void setTipo_trabajo(String tipo_trabajo) {
		this.tipo_trabajo = tipo_trabajo;
	}

	public String getTipo_trabajo() {
		return this.tipo_trabajo;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setEs_jefedearea(Float es_jefedearea) {
		this.es_jefedearea = es_jefedearea;
	}

	public Float getEs_jefedearea() {
		return this.es_jefedearea;
	}

	public void setUsa_subsector(Float usa_subsector) {
		this.usa_subsector = usa_subsector;
	}

	public Float getUsa_subsector() {
		return this.usa_subsector;
	}

	public void setTipo_cargo(Float tipo_cargo) {
		this.tipo_cargo = tipo_cargo;
	}

	public Float getTipo_cargo() {
		return this.tipo_cargo;
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