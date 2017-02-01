package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("DOCUMENTOS")
@Tabla(nombre = "DOCUMENTOS")
public class Documentos {
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDDOCUMENTO")
	@ClavePrimaria
	@Columna
	private String iddocumento;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("CODIGO_SUNAT")
	@Columna
	private String codigo_sunat;
        @XStreamAlias("ES_HONORARIOS")
	@Columna
	private Float es_honorarios;
        @XStreamAlias("ES_IMPORTACION")
	@Columna
	private Float es_importacion;
        @XStreamAlias("INCLUIR_CRONOGRAMA")
	@Columna
	private Float incluir_cronograma;
        @XStreamAlias("PIDE_REFERENCIA")
	@Columna
	private Float pide_referencia;
        @XStreamAlias("REGISTRAR_EN")
	@Columna
	private String registrar_en;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("FACTOR")
	@Columna
	private Float factor;
        @XStreamAlias("INCLUIR_IGV")
	@Columna
	private Float incluir_igv;
        @XStreamAlias("MOSTRAR_EN")
	@Columna
	private String mostrar_en;
        @XStreamAlias("RETENER_IGV")
	@Columna
	private Float retener_igv;
        @XStreamAlias("ES_4TA5TA")
	@Columna
	private Float es_4ta5ta;
        @XStreamAlias("NUM_GRANDE")
	@Columna
	private Float num_grande;
        @XStreamAlias("ES_RRHH")
	@Columna
	private Float es_rrhh;
        @XStreamAlias("RETENER_ODOC")
	@Columna
	private Float retener_odoc;
        @XStreamAlias("SOLO_IMPUESTO")
	@Columna
	private Float solo_impuesto;
        @XStreamAlias("SIN_IGV")
	@Columna
	private Float sin_igv;
        @XStreamAlias("PIDE_DOCCOMPRA")
	@Columna
	private Float pide_doccompra;
        @XStreamAlias("IDREGISTRO_SUNAT")
	@Columna
	private String idregistro_sunat;
        @XStreamAlias("PARA_DECLARACION")
	@Columna
	private Float para_declaracion;
        @XStreamAlias("ES_LEASING")
	@Columna
	private Float es_leasing;
        @XStreamAlias("ES_NODOMICILIADO")
	@Columna
	private Float es_nodomiciliado;
        @XStreamAlias("ES_NOEMITIDO")
	@Columna
	private Float es_noemitido;
        @XStreamAlias("ES_ELECTRONICO")
	@Columna
	private Float es_electronico;
        @XStreamAlias("INICIAL_DOCELECTRONICO")
	@Columna
	private String inicial_docelectronico;
        @XStreamAlias("INCLUIR_DOCAN_COMPRA_LE")
	@Columna
	private Float incluir_docan_compra_le;
        @XStreamAlias("IDTIPOTITULO_SUNAT")
	@Columna
	private String idtipotitulo_sunat;
        @XStreamAlias("ES_DIETA")
	@Columna
	private Float es_dieta;
        @XStreamAlias("PARA_PPAGO")
	@Columna
	private Float para_ppago;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setCodigo_sunat(String codigo_sunat) {
		this.codigo_sunat = codigo_sunat;
	}

	public String getCodigo_sunat() {
		return this.codigo_sunat;
	}

	public void setEs_honorarios(Float es_honorarios) {
		this.es_honorarios = es_honorarios;
	}

	public Float getEs_honorarios() {
		return this.es_honorarios;
	}

	public void setEs_importacion(Float es_importacion) {
		this.es_importacion = es_importacion;
	}

	public Float getEs_importacion() {
		return this.es_importacion;
	}

	public void setIncluir_cronograma(Float incluir_cronograma) {
		this.incluir_cronograma = incluir_cronograma;
	}

	public Float getIncluir_cronograma() {
		return this.incluir_cronograma;
	}

	public void setPide_referencia(Float pide_referencia) {
		this.pide_referencia = pide_referencia;
	}

	public Float getPide_referencia() {
		return this.pide_referencia;
	}

	public void setRegistrar_en(String registrar_en) {
		this.registrar_en = registrar_en;
	}

	public String getRegistrar_en() {
		return this.registrar_en;
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

	public void setFactor(Float factor) {
		this.factor = factor;
	}

	public Float getFactor() {
		return this.factor;
	}

	public void setIncluir_igv(Float incluir_igv) {
		this.incluir_igv = incluir_igv;
	}

	public Float getIncluir_igv() {
		return this.incluir_igv;
	}

	public void setMostrar_en(String mostrar_en) {
		this.mostrar_en = mostrar_en;
	}

	public String getMostrar_en() {
		return this.mostrar_en;
	}

	public void setRetener_igv(Float retener_igv) {
		this.retener_igv = retener_igv;
	}

	public Float getRetener_igv() {
		return this.retener_igv;
	}

	public void setEs_4ta5ta(Float es_4ta5ta) {
		this.es_4ta5ta = es_4ta5ta;
	}

	public Float getEs_4ta5ta() {
		return this.es_4ta5ta;
	}

	public void setNum_grande(Float num_grande) {
		this.num_grande = num_grande;
	}

	public Float getNum_grande() {
		return this.num_grande;
	}

	public void setEs_rrhh(Float es_rrhh) {
		this.es_rrhh = es_rrhh;
	}

	public Float getEs_rrhh() {
		return this.es_rrhh;
	}

	public void setRetener_odoc(Float retener_odoc) {
		this.retener_odoc = retener_odoc;
	}

	public Float getRetener_odoc() {
		return this.retener_odoc;
	}

	public void setSolo_impuesto(Float solo_impuesto) {
		this.solo_impuesto = solo_impuesto;
	}

	public Float getSolo_impuesto() {
		return this.solo_impuesto;
	}

	public void setSin_igv(Float sin_igv) {
		this.sin_igv = sin_igv;
	}

	public Float getSin_igv() {
		return this.sin_igv;
	}

	public void setPide_doccompra(Float pide_doccompra) {
		this.pide_doccompra = pide_doccompra;
	}

	public Float getPide_doccompra() {
		return this.pide_doccompra;
	}

	public void setIdregistro_sunat(String idregistro_sunat) {
		this.idregistro_sunat = idregistro_sunat;
	}

	public String getIdregistro_sunat() {
		return this.idregistro_sunat;
	}

	public void setPara_declaracion(Float para_declaracion) {
		this.para_declaracion = para_declaracion;
	}

	public Float getPara_declaracion() {
		return this.para_declaracion;
	}

	public void setEs_leasing(Float es_leasing) {
		this.es_leasing = es_leasing;
	}

	public Float getEs_leasing() {
		return this.es_leasing;
	}

	public void setEs_nodomiciliado(Float es_nodomiciliado) {
		this.es_nodomiciliado = es_nodomiciliado;
	}

	public Float getEs_nodomiciliado() {
		return this.es_nodomiciliado;
	}

	public void setEs_noemitido(Float es_noemitido) {
		this.es_noemitido = es_noemitido;
	}

	public Float getEs_noemitido() {
		return this.es_noemitido;
	}

	public void setEs_electronico(Float es_electronico) {
		this.es_electronico = es_electronico;
	}

	public Float getEs_electronico() {
		return this.es_electronico;
	}

	public void setInicial_docelectronico(String inicial_docelectronico) {
		this.inicial_docelectronico = inicial_docelectronico;
	}

	public String getInicial_docelectronico() {
		return this.inicial_docelectronico;
	}

	public void setIncluir_docan_compra_le(Float incluir_docan_compra_le) {
		this.incluir_docan_compra_le = incluir_docan_compra_le;
	}

	public Float getIncluir_docan_compra_le() {
		return this.incluir_docan_compra_le;
	}

	public void setIdtipotitulo_sunat(String idtipotitulo_sunat) {
		this.idtipotitulo_sunat = idtipotitulo_sunat;
	}

	public String getIdtipotitulo_sunat() {
		return this.idtipotitulo_sunat;
	}

	public void setEs_dieta(Float es_dieta) {
		this.es_dieta = es_dieta;
	}

	public Float getEs_dieta() {
		return this.es_dieta;
	}

	public void setPara_ppago(Float para_ppago) {
		this.para_ppago = para_ppago;
	}

	public Float getPara_ppago() {
		return this.para_ppago;
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