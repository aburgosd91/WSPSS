package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("FORMA_PAGO")
@Tabla(nombre = "FORMA_PAGO")
public class Forma_pago  implements Serializable{
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
	@XStreamAlias("IDEMPRESA")
        @ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDFPAGO")
	@ClavePrimaria
	@Columna
	private String idfpago;
        @XStreamAlias("DIAS_CREDITO")
	@Columna
	private Float dias_credito;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("USATARJETA")
	@Columna
	private Float usatarjeta;
        @XStreamAlias("USACHEQUE")
	@Columna
	private Float usacheque;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("CONTADO")
	@Columna
	private Float contado;
        @XStreamAlias("DESCRIPCIONSU")
	@Columna
	private String descripcionsu;
        @XStreamAlias("ES_DISTRIBUCIONV")
	@Columna
	private Float es_distribucionv;
        @XStreamAlias("NO_EXIGEDEPOSITO")
	@Columna
	private Float no_exigedeposito;
        @XStreamAlias("DESCRIPCION_INGLES")
	@Columna
	private String descripcion_ingles;
        @XStreamAlias("TIPOPAGO_COMEDOR")
	@Columna
	private String tipopago_comedor;
        @XStreamAlias("USA_CONTROLCOMEDOR")
	@Columna
	private Float usa_controlcomedor;
        @XStreamAlias("CODIGO_ALT")
	@Columna
	private String codigo_alt;

	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdfpago(String idfpago) {
		this.idfpago = idfpago;
	}

	public String getIdfpago() {
		return this.idfpago;
	}

	public void setDias_credito(Float dias_credito) {
		this.dias_credito = dias_credito;
	}

	public Float getDias_credito() {
		return this.dias_credito;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setUsatarjeta(Float usatarjeta) {
		this.usatarjeta = usatarjeta;
	}

	public Float getUsatarjeta() {
		return this.usatarjeta;
	}

	public void setUsacheque(Float usacheque) {
		this.usacheque = usacheque;
	}

	public Float getUsacheque() {
		return this.usacheque;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setContado(Float contado) {
		this.contado = contado;
	}

	public Float getContado() {
		return this.contado;
	}

	public void setDescripcionsu(String descripcionsu) {
		this.descripcionsu = descripcionsu;
	}

	public String getDescripcionsu() {
		return this.descripcionsu;
	}

	public void setEs_distribucionv(Float es_distribucionv) {
		this.es_distribucionv = es_distribucionv;
	}

	public Float getEs_distribucionv() {
		return this.es_distribucionv;
	}

	public void setNo_exigedeposito(Float no_exigedeposito) {
		this.no_exigedeposito = no_exigedeposito;
	}

	public Float getNo_exigedeposito() {
		return this.no_exigedeposito;
	}

	public void setDescripcion_ingles(String descripcion_ingles) {
		this.descripcion_ingles = descripcion_ingles;
	}

	public String getDescripcion_ingles() {
		return this.descripcion_ingles;
	}

	public void setTipopago_comedor(String tipopago_comedor) {
		this.tipopago_comedor = tipopago_comedor;
	}

	public String getTipopago_comedor() {
		return this.tipopago_comedor;
	}

	public void setUsa_controlcomedor(Float usa_controlcomedor) {
		this.usa_controlcomedor = usa_controlcomedor;
	}

	public Float getUsa_controlcomedor() {
		return this.usa_controlcomedor;
	}

	public void setCodigo_alt(String codigo_alt) {
		this.codigo_alt = codigo_alt;
	}

	public String getCodigo_alt() {
		return this.codigo_alt;
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