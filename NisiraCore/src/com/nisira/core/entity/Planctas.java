package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "PLANCTAS")
public class Planctas {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idcuenta;
	@Columna
	private String estructura;
	@Columna
	private Float es_ctacte;
	@Columna
	private String descripcion;
	@Columna
	private Float es_monetaria;
	@Columna
	private Float es_titulo;
	@Columna
	private String cta_abono1;
	@Columna
	private String cta_abono2;
	@Columna
	private String cta_cargo1;
	@Columna
	private String cta_cargo2;
	@Columna
	private String cta_ganancia;
	@Columna
	private String cta_perdida;
	@Columna
	private String tipo_cuenta;
	@Columna
	private Float pide_ccosto;
	@Columna
	private Float pide_codigo;
	@Columna
	private Float ajustarxtc;
	@Columna
	private String tipo_ajuste;
	@Columna
	private String tipo_cambio;
	@Columna
	private String idmoneda;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String naturaleza;
	@Columna
	private Integer es_ingreso;
	@Columna
	private String codigo_sap;
	@Columna
	private String idinciso;
	@Columna
	private String es_costo;
	@Columna
	private String idcuentaeqv;
	@Columna
	private String descreqv;
	@Columna
	private Float pide_dm;
	@Columna
	private String idcuenta_sunat;
	@Columna
	private String idclasegasto;
	@Columna
	private String idperiodogasto;

	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setEstructura(String estructura) {
		this.estructura = estructura;
	}

	public String getEstructura() {
		return this.estructura;
	}

	public void setEs_ctacte(Float es_ctacte) {
		this.es_ctacte = es_ctacte;
	}

	public Float getEs_ctacte() {
		return this.es_ctacte;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setEs_monetaria(Float es_monetaria) {
		this.es_monetaria = es_monetaria;
	}

	public Float getEs_monetaria() {
		return this.es_monetaria;
	}

	public void setEs_titulo(Float es_titulo) {
		this.es_titulo = es_titulo;
	}

	public Float getEs_titulo() {
		return this.es_titulo;
	}

	public void setCta_abono1(String cta_abono1) {
		this.cta_abono1 = cta_abono1;
	}

	public String getCta_abono1() {
		return this.cta_abono1;
	}

	public void setCta_abono2(String cta_abono2) {
		this.cta_abono2 = cta_abono2;
	}

	public String getCta_abono2() {
		return this.cta_abono2;
	}

	public void setCta_cargo1(String cta_cargo1) {
		this.cta_cargo1 = cta_cargo1;
	}

	public String getCta_cargo1() {
		return this.cta_cargo1;
	}

	public void setCta_cargo2(String cta_cargo2) {
		this.cta_cargo2 = cta_cargo2;
	}

	public String getCta_cargo2() {
		return this.cta_cargo2;
	}

	public void setCta_ganancia(String cta_ganancia) {
		this.cta_ganancia = cta_ganancia;
	}

	public String getCta_ganancia() {
		return this.cta_ganancia;
	}

	public void setCta_perdida(String cta_perdida) {
		this.cta_perdida = cta_perdida;
	}

	public String getCta_perdida() {
		return this.cta_perdida;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public String getTipo_cuenta() {
		return this.tipo_cuenta;
	}

	public void setPide_ccosto(Float pide_ccosto) {
		this.pide_ccosto = pide_ccosto;
	}

	public Float getPide_ccosto() {
		return this.pide_ccosto;
	}

	public void setPide_codigo(Float pide_codigo) {
		this.pide_codigo = pide_codigo;
	}

	public Float getPide_codigo() {
		return this.pide_codigo;
	}

	public void setAjustarxtc(Float ajustarxtc) {
		this.ajustarxtc = ajustarxtc;
	}

	public Float getAjustarxtc() {
		return this.ajustarxtc;
	}

	public void setTipo_ajuste(String tipo_ajuste) {
		this.tipo_ajuste = tipo_ajuste;
	}

	public String getTipo_ajuste() {
		return this.tipo_ajuste;
	}

	public void setTipo_cambio(String tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public String getTipo_cambio() {
		return this.tipo_cambio;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
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

	public void setNaturaleza(String naturaleza) {
		this.naturaleza = naturaleza;
	}

	public String getNaturaleza() {
		return this.naturaleza;
	}

	public void setEs_ingreso(Integer es_ingreso) {
		this.es_ingreso = es_ingreso;
	}

	public Integer getEs_ingreso() {
		return this.es_ingreso;
	}

	public void setCodigo_sap(String codigo_sap) {
		this.codigo_sap = codigo_sap;
	}

	public String getCodigo_sap() {
		return this.codigo_sap;
	}

	public void setIdinciso(String idinciso) {
		this.idinciso = idinciso;
	}

	public String getIdinciso() {
		return this.idinciso;
	}

	public void setEs_costo(String es_costo) {
		this.es_costo = es_costo;
	}

	public String getEs_costo() {
		return this.es_costo;
	}

	public void setIdcuentaeqv(String idcuentaeqv) {
		this.idcuentaeqv = idcuentaeqv;
	}

	public String getIdcuentaeqv() {
		return this.idcuentaeqv;
	}

	public void setDescreqv(String descreqv) {
		this.descreqv = descreqv;
	}

	public String getDescreqv() {
		return this.descreqv;
	}

	public void setPide_dm(Float pide_dm) {
		this.pide_dm = pide_dm;
	}

	public Float getPide_dm() {
		return this.pide_dm;
	}

	public void setIdcuenta_sunat(String idcuenta_sunat) {
		this.idcuenta_sunat = idcuenta_sunat;
	}

	public String getIdcuenta_sunat() {
		return this.idcuenta_sunat;
	}

	public void setIdclasegasto(String idclasegasto) {
		this.idclasegasto = idclasegasto;
	}

	public String getIdclasegasto() {
		return this.idclasegasto;
	}

	public void setIdperiodogasto(String idperiodogasto) {
		this.idperiodogasto = idperiodogasto;
	}

	public String getIdperiodogasto() {
		return this.idperiodogasto;
	}



	/* Sets & Gets FK*/

}