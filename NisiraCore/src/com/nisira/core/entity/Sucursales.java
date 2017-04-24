package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("SUCURSALES")
@Tabla(nombre = "SUCURSALES")
public class Sucursales implements Serializable{
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDSUCURSAL")
	@ClavePrimaria
	@Columna
	private String idsucursal;
        @XStreamAlias("DISTRIBUIR")
	@Columna
	private Float distribuir;
        @XStreamAlias("E_MAIL")
	@Columna
	private String e_mail;
        @XStreamAlias("DIRECCION")
	@Columna
	private String direccion;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("IDTIPOESTABLECIMIENTO")
	@Columna
	private String idtipoestablecimiento;
        @XStreamAlias("CODESTABLECIMIENTO")
	@Columna
	private String codestablecimiento;
        @XStreamAlias("DOMICILIOFISCAL")
	@Columna
	private Float domiciliofiscal;
        @XStreamAlias("IDCONDICIONESTABLECIMIENTO")
	@Columna
	private String idcondicionestablecimiento;
        @XStreamAlias("IDVIA")
	@Columna
	private String idvia;
        @XStreamAlias("NUMERO")
	@Columna
	private Float numero;
        @XStreamAlias("INTERIOR")
	@Columna
	private Float interior;
        @XStreamAlias("IDZONA")
	@Columna
	private String idzona;
        @XStreamAlias("NOMBREZONA")
	@Columna
	private String nombrezona;
        @XStreamAlias("REFERENCIA")
	@Columna
	private String referencia;
        @XStreamAlias("IDUBIGEO")
	@Columna
	private String idubigeo;
        @XStreamAlias("ESPLANTA")
	@Columna
	private Float esplanta;
        @XStreamAlias("FCE")
	@Columna
	private String fce;
        @XStreamAlias("FDA")
	@Columna
	private String fda;
        @XStreamAlias("CODIGO_RTPS")
	@Columna
	private String codigo_rtps;
        @XStreamAlias("TASA")
	@Columna
	private Float tasa;
        @XStreamAlias("PLANTCODE")
	@Columna
	private String plantcode;
        @XStreamAlias("IDCONTROL")
	@Columna
	private String idcontrol;
        @XStreamAlias("ESPRODUCCIONPROPIA")
	@Columna
	private Float esproduccionpropia;
        @XStreamAlias("ESCENTRORIESGO")
	@Columna
	private Float escentroriesgo;
        @XStreamAlias("CTACTEMN")
	@Columna
	private String ctactemn;
        @XStreamAlias("CTACTEME")
	@Columna
	private String ctacteme;
        @XStreamAlias("CODALTERNO")
	@Columna
	private String codalterno;
        @XStreamAlias("CC_CPF")
	@Columna
	private String cc_cpf;
        @XStreamAlias("DEPARTAMENTO")
	@Columna
	private String departamento;
        @XStreamAlias("DISTRITO")
	@Columna
	private String distrito;
        @XStreamAlias("PROVINCIA")
	@Columna
	private String provincia;
        @XStreamAlias("CODIGO_MTC")
	@Columna
	private String codigo_mtc;
        @XStreamAlias("ESDESPACHO")
	@Columna
	private Float esdespacho;
        @XStreamAlias("GENERA_REQINTERNO")
	@Columna
	private Float genera_reqinterno;
        @XStreamAlias("IDCLIEPROV_DESTINO")
	@Columna
	private String idclieprov_destino;
        @XStreamAlias("IDRESPONSABLE")
	@Columna
	private String idresponsable;
        @XStreamAlias("IDSUCURSAL_SPRING")
	@Columna
	private String idsucursal_spring;
        @XStreamAlias("ES_FUNDO")
	@Columna
	private Float es_fundo;
        @XStreamAlias("NOMBRE_CORTO")
	@Columna
	private String nombre_corto;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setDistribuir(Float distribuir) {
		this.distribuir = distribuir;
	}

	public Float getDistribuir() {
		return this.distribuir;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
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

	public void setIdtipoestablecimiento(String idtipoestablecimiento) {
		this.idtipoestablecimiento = idtipoestablecimiento;
	}

	public String getIdtipoestablecimiento() {
		return this.idtipoestablecimiento;
	}

	public void setCodestablecimiento(String codestablecimiento) {
		this.codestablecimiento = codestablecimiento;
	}

	public String getCodestablecimiento() {
		return this.codestablecimiento;
	}

	public void setDomiciliofiscal(Float domiciliofiscal) {
		this.domiciliofiscal = domiciliofiscal;
	}

	public Float getDomiciliofiscal() {
		return this.domiciliofiscal;
	}

	public void setIdcondicionestablecimiento(String idcondicionestablecimiento) {
		this.idcondicionestablecimiento = idcondicionestablecimiento;
	}

	public String getIdcondicionestablecimiento() {
		return this.idcondicionestablecimiento;
	}

	public void setIdvia(String idvia) {
		this.idvia = idvia;
	}

	public String getIdvia() {
		return this.idvia;
	}

	public void setNumero(Float numero) {
		this.numero = numero;
	}

	public Float getNumero() {
		return this.numero;
	}

	public void setInterior(Float interior) {
		this.interior = interior;
	}

	public Float getInterior() {
		return this.interior;
	}

	public void setIdzona(String idzona) {
		this.idzona = idzona;
	}

	public String getIdzona() {
		return this.idzona;
	}

	public void setNombrezona(String nombrezona) {
		this.nombrezona = nombrezona;
	}

	public String getNombrezona() {
		return this.nombrezona;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setEsplanta(Float esplanta) {
		this.esplanta = esplanta;
	}

	public Float getEsplanta() {
		return this.esplanta;
	}

	public void setFce(String fce) {
		this.fce = fce;
	}

	public String getFce() {
		return this.fce;
	}

	public void setFda(String fda) {
		this.fda = fda;
	}

	public String getFda() {
		return this.fda;
	}

	public void setCodigo_rtps(String codigo_rtps) {
		this.codigo_rtps = codigo_rtps;
	}

	public String getCodigo_rtps() {
		return this.codigo_rtps;
	}

	public void setTasa(Float tasa) {
		this.tasa = tasa;
	}

	public Float getTasa() {
		return this.tasa;
	}

	public void setPlantcode(String plantcode) {
		this.plantcode = plantcode;
	}

	public String getPlantcode() {
		return this.plantcode;
	}

	public void setIdcontrol(String idcontrol) {
		this.idcontrol = idcontrol;
	}

	public String getIdcontrol() {
		return this.idcontrol;
	}

	public void setEsproduccionpropia(Float esproduccionpropia) {
		this.esproduccionpropia = esproduccionpropia;
	}

	public Float getEsproduccionpropia() {
		return this.esproduccionpropia;
	}

	public void setEscentroriesgo(Float escentroriesgo) {
		this.escentroriesgo = escentroriesgo;
	}

	public Float getEscentroriesgo() {
		return this.escentroriesgo;
	}

	public void setCtactemn(String ctactemn) {
		this.ctactemn = ctactemn;
	}

	public String getCtactemn() {
		return this.ctactemn;
	}

	public void setCtacteme(String ctacteme) {
		this.ctacteme = ctacteme;
	}

	public String getCtacteme() {
		return this.ctacteme;
	}

	public void setCodalterno(String codalterno) {
		this.codalterno = codalterno;
	}

	public String getCodalterno() {
		return this.codalterno;
	}

	public void setCc_cpf(String cc_cpf) {
		this.cc_cpf = cc_cpf;
	}

	public String getCc_cpf() {
		return this.cc_cpf;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setCodigo_mtc(String codigo_mtc) {
		this.codigo_mtc = codigo_mtc;
	}

	public String getCodigo_mtc() {
		return this.codigo_mtc;
	}

	public void setEsdespacho(Float esdespacho) {
		this.esdespacho = esdespacho;
	}

	public Float getEsdespacho() {
		return this.esdespacho;
	}

	public void setGenera_reqinterno(Float genera_reqinterno) {
		this.genera_reqinterno = genera_reqinterno;
	}

	public Float getGenera_reqinterno() {
		return this.genera_reqinterno;
	}

	public void setIdclieprov_destino(String idclieprov_destino) {
		this.idclieprov_destino = idclieprov_destino;
	}

	public String getIdclieprov_destino() {
		return this.idclieprov_destino;
	}

	public void setIdresponsable(String idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getIdresponsable() {
		return this.idresponsable;
	}

	public void setIdsucursal_spring(String idsucursal_spring) {
		this.idsucursal_spring = idsucursal_spring;
	}

	public String getIdsucursal_spring() {
		return this.idsucursal_spring;
	}

	public void setEs_fundo(Float es_fundo) {
		this.es_fundo = es_fundo;
	}

	public Float getEs_fundo() {
		return this.es_fundo;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
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