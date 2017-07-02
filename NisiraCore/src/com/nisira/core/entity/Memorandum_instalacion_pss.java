package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "MEMORANDUM_INSTALACION_PSS")
@XStreamAlias("MEMORANDUM_INSTALACION_PSS")
public class Memorandum_instalacion_pss implements Serializable{
	@ClavePrimaria
	@Columna
        @XStreamAlias("idempresa")
	private String idemrpesa;
	@ClavePrimaria
	@Columna
        @XStreamAlias("idcotizacionv")
	private String idcotizacionv;
	@Columna
        @XStreamAlias("idordenservicio")
	private String idordenservicio;
	@Columna
        @XStreamAlias("fecha_inst")
	private Date fecha_inst;
	@Columna
        @XStreamAlias("hora_inst")
	private Float hora_inst;
	@Columna
        @XStreamAlias("duracion_contrato")
	private String duracion_contrato;
	@Columna
        @XStreamAlias("tabla_atendido")
	private String tabla_atendido;
	@Columna
        @XStreamAlias("tabla_requerimiento")
	private String tabla_requerimiento;
	@Columna
        @XStreamAlias("salario")
	private String salario;
	@Columna
        @XStreamAlias("condiciones_comerciales")
	private String condiciones_comerciales;
	@Columna
        @XStreamAlias("observaciones")
	private String observaciones;
	@Columna
        @XStreamAlias("fechacreacion")
	private Date fechacreacion;
	@Columna
        @XStreamAlias("idusuario")
	private String idusuario;



	/* Sets & Gets */
	public void setIdemrpesa(String idemrpesa) {
		this.idemrpesa = idemrpesa;
	}

	public String getIdemrpesa() {
		return this.idemrpesa;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
	}

	public void setFecha_inst(Date fecha_inst) {
		this.fecha_inst = fecha_inst;
	}

	public Date getFecha_inst() {
		return this.fecha_inst;
	}

	public void setHora_inst(Float hora_inst) {
		this.hora_inst = hora_inst;
	}

	public Float getHora_inst() {
		return this.hora_inst;
	}

	public void setDuracion_contrato(String duracion_contrato) {
		this.duracion_contrato = duracion_contrato;
	}

	public String getDuracion_contrato() {
		return this.duracion_contrato;
	}

	public void setTabla_atendido(String tabla_atendido) {
		this.tabla_atendido = tabla_atendido;
	}

	public String getTabla_atendido() {
		return this.tabla_atendido;
	}

	public void setTabla_requerimiento(String tabla_requerimiento) {
		this.tabla_requerimiento = tabla_requerimiento;
	}

	public String getTabla_requerimiento() {
		return this.tabla_requerimiento;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setCondiciones_comerciales(String condiciones_comerciales) {
		this.condiciones_comerciales = condiciones_comerciales;
	}

	public String getCondiciones_comerciales() {
		return this.condiciones_comerciales;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}



	/* Sets & Gets FK*/

}