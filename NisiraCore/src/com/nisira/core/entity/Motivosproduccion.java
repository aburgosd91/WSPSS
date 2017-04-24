package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "MOTIVOSPRODUCCION")
public class Motivosproduccion implements Serializable{
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idmotivo;
	@Columna
	private String descripcion;
	@Columna
	private String nombre_corto;
	@Columna
	private Float exige_occ;
	@Columna
	private Float insumos_occ;
	@Columna
	private Float genera_ingreso;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idmotsalida;
	@Columna
	private Integer ipidecotizacion;
	@Columna
	private Integer ipidesolicitud;
	@Columna
	private Float es_preventivo;
	@Columna
	private Float exige_reqi;
	@Columna
	private Float no_exige_eqp;
	@Columna
	private Float no_exige_opm;
	@Columna
	private String iddocumento_s;
	@Columna
	private String idmotivo_s;
	@Columna
	private String idsucursal_s;
	@Columna
	private String idalmacen_s;
	@Columna
	private String iddocumento_i;
	@Columna
	private String idmotivo_i;
	@Columna
	private String idsucursal_i;
	@Columna
	private String idalmacen_i;
	@Columna
	private Float almacen_auto;
	@Columna
	private String serie_i;
	@Columna
	private String serie_s;
	@Columna
	private Float sucursal_cc;
	@Columna
	private String idconsumidor;
	@Columna
	private String iddocumento_op;
	@Columna
	private Integer dias;
	@Columna
	private String iddocumento;
	@Columna
	private String serie;
	@Columna
	private Float es_predictivo;
	@Columna
	private String idmotivoreqinterno;
	@Columna
	private Float es_cotizacion;
	@Columna
	private Float es_requerimiento;
	@Columna
	private Float es_ingpersonal;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdmotivo(String idmotivo) {
		this.idmotivo = idmotivo;
	}

	public String getIdmotivo() {
		return this.idmotivo;
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

	public void setExige_occ(Float exige_occ) {
		this.exige_occ = exige_occ;
	}

	public Float getExige_occ() {
		return this.exige_occ;
	}

	public void setInsumos_occ(Float insumos_occ) {
		this.insumos_occ = insumos_occ;
	}

	public Float getInsumos_occ() {
		return this.insumos_occ;
	}

	public void setGenera_ingreso(Float genera_ingreso) {
		this.genera_ingreso = genera_ingreso;
	}

	public Float getGenera_ingreso() {
		return this.genera_ingreso;
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

	public void setIdmotsalida(String idmotsalida) {
		this.idmotsalida = idmotsalida;
	}

	public String getIdmotsalida() {
		return this.idmotsalida;
	}

	public void setIpidecotizacion(Integer ipidecotizacion) {
		this.ipidecotizacion = ipidecotizacion;
	}

	public Integer getIpidecotizacion() {
		return this.ipidecotizacion;
	}

	public void setIpidesolicitud(Integer ipidesolicitud) {
		this.ipidesolicitud = ipidesolicitud;
	}

	public Integer getIpidesolicitud() {
		return this.ipidesolicitud;
	}

	public void setEs_preventivo(Float es_preventivo) {
		this.es_preventivo = es_preventivo;
	}

	public Float getEs_preventivo() {
		return this.es_preventivo;
	}

	public void setExige_reqi(Float exige_reqi) {
		this.exige_reqi = exige_reqi;
	}

	public Float getExige_reqi() {
		return this.exige_reqi;
	}

	public void setNo_exige_eqp(Float no_exige_eqp) {
		this.no_exige_eqp = no_exige_eqp;
	}

	public Float getNo_exige_eqp() {
		return this.no_exige_eqp;
	}

	public void setNo_exige_opm(Float no_exige_opm) {
		this.no_exige_opm = no_exige_opm;
	}

	public Float getNo_exige_opm() {
		return this.no_exige_opm;
	}

	public void setIddocumento_s(String iddocumento_s) {
		this.iddocumento_s = iddocumento_s;
	}

	public String getIddocumento_s() {
		return this.iddocumento_s;
	}

	public void setIdmotivo_s(String idmotivo_s) {
		this.idmotivo_s = idmotivo_s;
	}

	public String getIdmotivo_s() {
		return this.idmotivo_s;
	}

	public void setIdsucursal_s(String idsucursal_s) {
		this.idsucursal_s = idsucursal_s;
	}

	public String getIdsucursal_s() {
		return this.idsucursal_s;
	}

	public void setIdalmacen_s(String idalmacen_s) {
		this.idalmacen_s = idalmacen_s;
	}

	public String getIdalmacen_s() {
		return this.idalmacen_s;
	}

	public void setIddocumento_i(String iddocumento_i) {
		this.iddocumento_i = iddocumento_i;
	}

	public String getIddocumento_i() {
		return this.iddocumento_i;
	}

	public void setIdmotivo_i(String idmotivo_i) {
		this.idmotivo_i = idmotivo_i;
	}

	public String getIdmotivo_i() {
		return this.idmotivo_i;
	}

	public void setIdsucursal_i(String idsucursal_i) {
		this.idsucursal_i = idsucursal_i;
	}

	public String getIdsucursal_i() {
		return this.idsucursal_i;
	}

	public void setIdalmacen_i(String idalmacen_i) {
		this.idalmacen_i = idalmacen_i;
	}

	public String getIdalmacen_i() {
		return this.idalmacen_i;
	}

	public void setAlmacen_auto(Float almacen_auto) {
		this.almacen_auto = almacen_auto;
	}

	public Float getAlmacen_auto() {
		return this.almacen_auto;
	}

	public void setSerie_i(String serie_i) {
		this.serie_i = serie_i;
	}

	public String getSerie_i() {
		return this.serie_i;
	}

	public void setSerie_s(String serie_s) {
		this.serie_s = serie_s;
	}

	public String getSerie_s() {
		return this.serie_s;
	}

	public void setSucursal_cc(Float sucursal_cc) {
		this.sucursal_cc = sucursal_cc;
	}

	public Float getSucursal_cc() {
		return this.sucursal_cc;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setIddocumento_op(String iddocumento_op) {
		this.iddocumento_op = iddocumento_op;
	}

	public String getIddocumento_op() {
		return this.iddocumento_op;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getDias() {
		return this.dias;
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

	public void setEs_predictivo(Float es_predictivo) {
		this.es_predictivo = es_predictivo;
	}

	public Float getEs_predictivo() {
		return this.es_predictivo;
	}

	public void setIdmotivoreqinterno(String idmotivoreqinterno) {
		this.idmotivoreqinterno = idmotivoreqinterno;
	}

	public String getIdmotivoreqinterno() {
		return this.idmotivoreqinterno;
	}

	public void setEs_cotizacion(Float es_cotizacion) {
		this.es_cotizacion = es_cotizacion;
	}

	public Float getEs_cotizacion() {
		return this.es_cotizacion;
	}

	public void setEs_requerimiento(Float es_requerimiento) {
		this.es_requerimiento = es_requerimiento;
	}

	public Float getEs_requerimiento() {
		return this.es_requerimiento;
	}

	public void setEs_ingpersonal(Float es_ingpersonal) {
		this.es_ingpersonal = es_ingpersonal;
	}

	public Float getEs_ingpersonal() {
		return this.es_ingpersonal;
	}



	/* Sets & Gets FK*/

}