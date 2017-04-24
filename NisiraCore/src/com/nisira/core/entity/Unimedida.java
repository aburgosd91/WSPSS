package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "UNIMEDIDA")
public class Unimedida implements Serializable{
        private String idbasedatos;	
        @ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idmedida;
	@Columna
	private String descripcion;
	@Columna
	private String nombre_corto;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String codigo_sunat;
	@Columna
	private Float unidviaje;
	@Columna
	private Float unidtarifa;
	@Columna
	private String idregistro_sunat;
	@Columna
	private String tiempo;
	@Columna
	private Float unidtiempo;
	@Columna
	private String codigo_aduana;
	@Columna
	private Float redondeo_drawback;
	@Columna
	private String tipo_redondeo;
	@Columna
	private Float decimal_redondeo;
	@Columna
	private Integer compania;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
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

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public String getCodigo_sunat() {
		return this.codigo_sunat;
	}

	public void setUnidviaje(Float unidviaje) {
		this.unidviaje = unidviaje;
	}

	public Float getUnidviaje() {
		return this.unidviaje;
	}

	public void setUnidtarifa(Float unidtarifa) {
		this.unidtarifa = unidtarifa;
	}

	public Float getUnidtarifa() {
		return this.unidtarifa;
	}

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getTiempo() {
		return this.tiempo;
	}

	public void setUnidtiempo(Float unidtiempo) {
		this.unidtiempo = unidtiempo;
	}

	public Float getUnidtiempo() {
		return this.unidtiempo;
	}

	public void setCodigo_aduana(String codigo_aduana) {
		this.codigo_aduana = codigo_aduana;
	}

	public String getCodigo_aduana() {
		return this.codigo_aduana;
	}

	public void setRedondeo_drawback(Float redondeo_drawback) {
		this.redondeo_drawback = redondeo_drawback;
	}

	public Float getRedondeo_drawback() {
		return this.redondeo_drawback;
	}

	public void setTipo_redondeo(String tipo_redondeo) {
		this.tipo_redondeo = tipo_redondeo;
	}

	public String getTipo_redondeo() {
		return this.tipo_redondeo;
	}

	public void setDecimal_redondeo(Float decimal_redondeo) {
		this.decimal_redondeo = decimal_redondeo;
	}

	public Float getDecimal_redondeo() {
		return this.decimal_redondeo;
	}

	public void setCompania(Integer compania) {
		this.compania = compania;
	}

	public Integer getCompania() {
		return this.compania;
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