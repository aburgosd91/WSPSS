package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("CONSUMIDOR")
@Tabla(nombre = "CONSUMIDOR")
public class Consumidor {
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCONSUMIDOR")
	@ClavePrimaria
	@Columna
	private String idconsumidor;
        @XStreamAlias("TIPO")
	@Columna
	private String tipo;
        @XStreamAlias("JERARQUIA")
	@Columna
	private String jerarquia;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("IDCCOSTO")
	@Columna
	private String idccosto;
        @XStreamAlias("FECHA_INGRESO")
	@Columna
	private Date fecha_ingreso;
        @XStreamAlias("FECHA_BAJA")
	@Columna
	private Date fecha_baja;
        @XStreamAlias("IDSUCURSAL")
	@Columna
	private String idsucursal;
        @XStreamAlias("AREA")
	@Columna
	private Float area;
        @XStreamAlias("IDTENERGIA")
	@Columna
	private String idtenergia;
        @XStreamAlias("CAUDAL")
	@Columna
	private Float caudal;
        @XStreamAlias("IDPERTENECE")
	@Columna
	private String idpertenece;
        @XStreamAlias("TIPOCALCULO")
	@Columna
	private String tipocalculo;
        @XStreamAlias("COSTO_MOF")
	@Columna
	private Float costo_mof;
        @XStreamAlias("COSTO_MEX")
	@Columna
	private Float costo_mex;
        @XStreamAlias("TIPOMAQUINA")
	@Columna
	private String tipomaquina;
        @XStreamAlias("IDPRODUCTO")
	@Columna
	private String idproducto;
        @XStreamAlias("PLANIFICADO")
	@Columna
	private Float planificado;
        @XStreamAlias("PRODUCIDO")
	@Columna
	private Float producido;
        @XStreamAlias("GRUPO")
	@Columna
	private String grupo;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("ESCARGA")
	@Columna
	private Float escarga;
        @XStreamAlias("MARCA")
	@Columna
	private String marca;
        @XStreamAlias("PLACA")
	@Columna
	private String placa;
        @XStreamAlias("REGMTC")
	@Columna
	private String regmtc;
        @XStreamAlias("NROEJES")
	@Columna
	private Float nroejes;
        @XStreamAlias("CARGAUTIL")
	@Columna
	private Float cargautil;
        @XStreamAlias("TIPOVEHICULO")
	@Columna
	private String tipovehiculo;
        @XStreamAlias("ANIO")
	@Columna
	private Float anio;
        @XStreamAlias("KMINICIAL")
	@Columna
	private Float kminicial;
        @XStreamAlias("IDCONTROLADOR")
	@Columna
	private String idcontrolador;
        @XStreamAlias("NRO_VALVULA")
	@Columna
	private String nro_valvula;
        @XStreamAlias("IDSERIE")
	@Columna
	private String idserie;
        @XStreamAlias("KILOMETROS")
	@Columna
	private Float kilometros;
        @XStreamAlias("IDNIVELCONSUMIDOR")
	@Columna
	private String idnivelconsumidor;
        @XStreamAlias("DESCRIPCIONCORTA")
	@Columna
	private String descripcioncorta;
        @XStreamAlias("CODIGO_CONTROL")
	@Columna
	private String codigo_control;
        @XStreamAlias("ES_TITULO")
	@Columna
	private Float es_titulo;
        @XStreamAlias("GASTOXACTIVIDAD")
	@Columna
	private Float gastoxactividad;
        @XStreamAlias("FINAL_")
	@Columna
	private Float final_;
        @XStreamAlias("CUENTA_ABONO")
	@Columna
	private String cuenta_abono;
        @XStreamAlias("CUENTA_CARGO")
	@Columna
	private String cuenta_cargo;
        @XStreamAlias("CUENTA_DESTINO")
	@Columna
	private String cuenta_destino;
        @XStreamAlias("IDACTIVIDAD")
	@Columna
	private Float idactividad;
        @XStreamAlias("IDSIEMBRA")
	@Columna
	private Float idsiembra;
        @XStreamAlias("IDCAMPANA")
	@Columna
	private Float idcampana;
        @XStreamAlias("IDORDENPRODUCCION")
	@Columna
	private Float idordenproduccion;
        @XStreamAlias("IDLOTEPRODUCCION")
	@Columna
	private Float idloteproduccion;
        @XStreamAlias("CREACC")
	@Columna
	private Float creacc;
        @XStreamAlias("ES_PRODUCCION")
	@Columna
	private Float es_produccion;
        @XStreamAlias("CODIGO_LOTIZAR")
	@Columna
	private String codigo_lotizar;
        @XStreamAlias("VVENTA_MOF")
	@Columna
	private Float vventa_mof;
        @XStreamAlias("VVENTA_MEX")
	@Columna
	private Float vventa_mex;
        @XStreamAlias("IDUNIDADNEGOCIO")
	@Columna
	private String idunidadnegocio;
        @XStreamAlias("IDCLASECCOSTO")
	@Columna
	private String idclaseccosto;
        @XStreamAlias("IDCUENTAC_PT")
	@Columna
	private String idcuentac_pt;
        @XStreamAlias("IDCUENTAA_PT")
	@Columna
	private String idcuentaa_pt;
        @XStreamAlias("IDCUENTAC_PP")
	@Columna
	private String idcuentac_pp;
        @XStreamAlias("IDCUENTAA_PP")
	@Columna
	private String idcuentaa_pp;
        @XStreamAlias("TIPO_COSTEO")
	@Columna
	private Float tipo_costeo;
        @XStreamAlias("IDFUNCION")
	@Columna
	private String idfuncion;
        @XStreamAlias("IDMOTIVO_REVAL")
	@Columna
	private String idmotivo_reval;
        @XStreamAlias("IDSUCURSAL_REVAL")
	@Columna
	private String idsucursal_reval;
        @XStreamAlias("IDALMACEN_REVAL")
	@Columna
	private String idalmacen_reval;
        @XStreamAlias("IDDOCUMENTO_REVAL")
	@Columna
	private String iddocumento_reval;
        @XStreamAlias("IDFACTORDISTRIBUCION")
	@Columna
	private String idfactordistribucion;
        @XStreamAlias("COSTOHA_MEX")
	@Columna
	private Float costoha_mex;
        @XStreamAlias("COSTOHA_MOF")
	@Columna
	private Float costoha_mof;
        @XStreamAlias("DISTR_COSTOFINAL")
	@Columna
	private Float distr_costofinal;
        @XStreamAlias("ESXPERIODO")
	@Columna
	private Float esxperiodo;
        @XStreamAlias("NOMBRE_REGISTRO")
	@Columna
	private String nombre_registro;
        @XStreamAlias("NRO_REGISTRO")
	@Columna
	private String nro_registro;
        @XStreamAlias("TIPO_COSTO")
	@Columna
	private String tipo_costo;
        @XStreamAlias("IDPARTEPRODUCCION")
	@Columna
	private Float idparteproduccion;
        @XStreamAlias("ALGORITMOPRECIO")
	@Columna
	private Float algoritmoprecio;
        @XStreamAlias("IDPROVLOTE")
	@Columna
	private String idprovlote;
        @XStreamAlias("IDMEDIDA")
	@Columna
	private String idmedida;
        @XStreamAlias("DESCARGA")
	@Columna
	private Float descarga;
        @XStreamAlias("ESVEHTERCERO")
	@Columna
	private Float esvehtercero;
        @XStreamAlias("GENERA_VIAJET")
	@Columna
	private Float genera_viajet;
        @XStreamAlias("GENERA_REMTRANSPORTISTA")
	@Columna
	private Float genera_remtransportista;
        @XStreamAlias("IDVIAJET")
	@Columna
	private String idviajet;
        @XStreamAlias("IDREMTRANSPORTISTA")
	@Columna
	private String idremtransportista;
        @XStreamAlias("NRV_ASIGNACION")
	@Columna
	private Float nrv_asignacion;
        @XStreamAlias("GROWERCODE")
	@Columna
	private String growercode;
        @XStreamAlias("VER_TRANSFORMACION")
	@Columna
	private Float ver_transformacion;
        @XStreamAlias("IDCUENTA_CP")
	@Columna
	private String idcuenta_cp;
        @XStreamAlias("CAPACIDAD")
	@Columna
	private Float capacidad;
        @XStreamAlias("IDALMACEN")
	@Columna
	private String idalmacen;
        @XStreamAlias("IDFUENTEAGUA")
	@Columna
	private String idfuenteagua;
        @XStreamAlias("IDCLIEPROV_VEHTERCERO")
	@Columna
	private String idclieprov_vehtercero;
        @XStreamAlias("ES_SERVICIO")
	@Columna
	private Float es_servicio;
        @XStreamAlias("IDCUENTADIV9")
	@Columna
	private String idcuentadiv9;
        @XStreamAlias("ESALQUILADO")
	@Columna
	private Float esalquilado;
        @XStreamAlias("NO_PARTICIPADISTRIBUCION")
	@Columna
	private Float no_participadistribucion;
        @XStreamAlias("ES_MANTENIMIENTO")
	@Columna
	private Float es_mantenimiento;
        @XStreamAlias("IDGRUPO_MAQ")
	@Columna
	private String idgrupo_maq;
        @XStreamAlias("DISTRIBUCION_DWH")
	@Columna
	private Float distribucion_dwh;
        @XStreamAlias("NOMBRE_CORTO")
	@Columna
	private String nombre_corto;
        @XStreamAlias("IDSUBSECTORCONSUMIDOR")
	@Columna
	private String idsubsectorconsumidor;
        @XStreamAlias("ES_COSECHA")
	@Columna
	private Float es_cosecha;
        @XStreamAlias("CAPACIDAD_TANQUE")
	@Columna
	private Float capacidad_tanque;
        @XStreamAlias("IDBASEDATOS")
	@Columna
	private String idbasedatos;
        @XStreamAlias("IDACTIVO")
	@Columna
	private String idactivo;
        @XStreamAlias("IDINGRESOSALIDAACTIVO")
	@Columna
	private String idingresosalidaactivo;
        @XStreamAlias("IDCTAACTIVO")
	@Columna
	private String idctaactivo;
        @XStreamAlias("ES_REPROCESO")
	@Columna
	private Float es_reproceso;
        @XStreamAlias("ES_REEMPAQUE")
	@Columna
	private Float es_reempaque;
        @XStreamAlias("ES_AVICOLA")
	@Columna
	private Float es_avicola;
        @XStreamAlias("TIPO_PRESUPUESTO")
	@Columna
	private String tipo_presupuesto;
        @XStreamAlias("ES_EMPAQUE")
	@Columna
	private Float es_empaque;
        @XStreamAlias("IDCONSUMIDOR_SPRING")
	@Columna
	private String idconsumidor_spring;
        @XStreamAlias("ES_LOTE_CAMPO")
	@Columna
	private Float es_lote_campo;
        @XStreamAlias("ES_SECADO")
	@Columna
	private Float es_secado;
        @XStreamAlias("CERTIFICADO")
	@Columna
	private Float certificado;
        @XStreamAlias("TIPO_PRECIO_FUENTE")
	@Columna
	private Integer tipo_precio_fuente;
        @XStreamAlias("CODIGO_PARCELA")
	@Columna
	private String codigo_parcela;
        @XStreamAlias("COSTOKM_MOF")
	@Columna
	private Float costokm_mof;
        @XStreamAlias("COSTOKM_MEX")
	@Columna
	private Float costokm_mex;
        @XStreamAlias("COSTODIA_MOF")
	@Columna
	private Float costodia_mof;
        @XStreamAlias("COSTODIA_MEX")
	@Columna
	private Float costodia_mex;
        @XStreamAlias("IDLINEA_AVICOLA")
	@Columna
	private String idlinea_avicola;
        @XStreamAlias("PERMANENCIA")
	@Columna
	private Integer permanencia;
        @XStreamAlias("DIAS_GENPRESUP")
	@Columna
	private Integer dias_genpresup;
        @XStreamAlias("IDMEDIDA_MAQ")
	@Columna
	private String idmedida_maq;
        @XStreamAlias("CAPACIDAD_MAQ")
	@Columna
	private Float capacidad_maq;
        @XStreamAlias("VVENTA_UM_MOF")
	@Columna
	private Float vventa_um_mof;
        @XStreamAlias("VVENTA_UM_MEX")
	@Columna
	private Float vventa_um_mex;
        @XStreamAlias("TIPO_REGISTRO_PARTE")
	@Columna
	private String tipo_registro_parte;
        @XStreamAlias("VER_DIGITACION")
	@Columna
	private Float ver_digitacion;
        @XStreamAlias("ES_LOTE_VIVERO")
	@Columna
	private Float es_lote_vivero;
        @XStreamAlias("FN_DISTR_VAR1_M2")
	@Columna
	private Float fn_distr_var1_m2;
      

	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}

	public String getJerarquia() {
		return this.jerarquia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_ingreso() {
		return this.fecha_ingreso;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public Date getFecha_baja() {
		return this.fecha_baja;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Float getArea() {
		return this.area;
	}

	public void setIdtenergia(String idtenergia) {
		this.idtenergia = idtenergia;
	}

	public String getIdtenergia() {
		return this.idtenergia;
	}

	public void setCaudal(Float caudal) {
		this.caudal = caudal;
	}

	public Float getCaudal() {
		return this.caudal;
	}

	public void setIdpertenece(String idpertenece) {
		this.idpertenece = idpertenece;
	}

	public String getIdpertenece() {
		return this.idpertenece;
	}

	public void setTipocalculo(String tipocalculo) {
		this.tipocalculo = tipocalculo;
	}

	public String getTipocalculo() {
		return this.tipocalculo;
	}

	public void setCosto_mof(Float costo_mof) {
		this.costo_mof = costo_mof;
	}

	public Float getCosto_mof() {
		return this.costo_mof;
	}

	public void setCosto_mex(Float costo_mex) {
		this.costo_mex = costo_mex;
	}

	public Float getCosto_mex() {
		return this.costo_mex;
	}

	public void setTipomaquina(String tipomaquina) {
		this.tipomaquina = tipomaquina;
	}

	public String getTipomaquina() {
		return this.tipomaquina;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setPlanificado(Float planificado) {
		this.planificado = planificado;
	}

	public Float getPlanificado() {
		return this.planificado;
	}

	public void setProducido(Float producido) {
		this.producido = producido;
	}

	public Float getProducido() {
		return this.producido;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getGrupo() {
		return this.grupo;
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

	public void setEscarga(Float escarga) {
		this.escarga = escarga;
	}

	public Float getEscarga() {
		return this.escarga;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setRegmtc(String regmtc) {
		this.regmtc = regmtc;
	}

	public String getRegmtc() {
		return this.regmtc;
	}

	public void setNroejes(Float nroejes) {
		this.nroejes = nroejes;
	}

	public Float getNroejes() {
		return this.nroejes;
	}

	public void setCargautil(Float cargautil) {
		this.cargautil = cargautil;
	}

	public Float getCargautil() {
		return this.cargautil;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public String getTipovehiculo() {
		return this.tipovehiculo;
	}

	public void setAnio(Float anio) {
		this.anio = anio;
	}

	public Float getAnio() {
		return this.anio;
	}

	public void setKminicial(Float kminicial) {
		this.kminicial = kminicial;
	}

	public Float getKminicial() {
		return this.kminicial;
	}

	public void setIdcontrolador(String idcontrolador) {
		this.idcontrolador = idcontrolador;
	}

	public String getIdcontrolador() {
		return this.idcontrolador;
	}

	public void setNro_valvula(String nro_valvula) {
		this.nro_valvula = nro_valvula;
	}

	public String getNro_valvula() {
		return this.nro_valvula;
	}

	public void setIdserie(String idserie) {
		this.idserie = idserie;
	}

	public String getIdserie() {
		return this.idserie;
	}

	public void setKilometros(Float kilometros) {
		this.kilometros = kilometros;
	}

	public Float getKilometros() {
		return this.kilometros;
	}

	public void setIdnivelconsumidor(String idnivelconsumidor) {
		this.idnivelconsumidor = idnivelconsumidor;
	}

	public String getIdnivelconsumidor() {
		return this.idnivelconsumidor;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}

	public String getDescripcioncorta() {
		return this.descripcioncorta;
	}

	public void setCodigo_control(String codigo_control) {
		this.codigo_control = codigo_control;
	}

	public String getCodigo_control() {
		return this.codigo_control;
	}

	public void setEs_titulo(Float es_titulo) {
		this.es_titulo = es_titulo;
	}

	public Float getEs_titulo() {
		return this.es_titulo;
	}

	public void setGastoxactividad(Float gastoxactividad) {
		this.gastoxactividad = gastoxactividad;
	}

	public Float getGastoxactividad() {
		return this.gastoxactividad;
	}

	public void setFinal(Float final_) {
		this.final_ = final_;
	}

	public Float getFinal() {
		return this.final_;
	}

	public void setCuenta_abono(String cuenta_abono) {
		this.cuenta_abono = cuenta_abono;
	}

	public String getCuenta_abono() {
		return this.cuenta_abono;
	}

	public void setCuenta_cargo(String cuenta_cargo) {
		this.cuenta_cargo = cuenta_cargo;
	}

	public String getCuenta_cargo() {
		return this.cuenta_cargo;
	}

	public void setCuenta_destino(String cuenta_destino) {
		this.cuenta_destino = cuenta_destino;
	}

	public String getCuenta_destino() {
		return this.cuenta_destino;
	}

	public void setIdactividad(Float idactividad) {
		this.idactividad = idactividad;
	}

	public Float getIdactividad() {
		return this.idactividad;
	}

	public void setIdsiembra(Float idsiembra) {
		this.idsiembra = idsiembra;
	}

	public Float getIdsiembra() {
		return this.idsiembra;
	}

	public void setIdcampana(Float idcampana) {
		this.idcampana = idcampana;
	}

	public Float getIdcampana() {
		return this.idcampana;
	}

	public void setIdordenproduccion(Float idordenproduccion) {
		this.idordenproduccion = idordenproduccion;
	}

	public Float getIdordenproduccion() {
		return this.idordenproduccion;
	}

	public void setIdloteproduccion(Float idloteproduccion) {
		this.idloteproduccion = idloteproduccion;
	}

	public Float getIdloteproduccion() {
		return this.idloteproduccion;
	}

	public void setCreacc(Float creacc) {
		this.creacc = creacc;
	}

	public Float getCreacc() {
		return this.creacc;
	}

	public void setEs_produccion(Float es_produccion) {
		this.es_produccion = es_produccion;
	}

	public Float getEs_produccion() {
		return this.es_produccion;
	}

	public void setCodigo_lotizar(String codigo_lotizar) {
		this.codigo_lotizar = codigo_lotizar;
	}

	public String getCodigo_lotizar() {
		return this.codigo_lotizar;
	}

	public void setVventa_mof(Float vventa_mof) {
		this.vventa_mof = vventa_mof;
	}

	public Float getVventa_mof() {
		return this.vventa_mof;
	}

	public void setVventa_mex(Float vventa_mex) {
		this.vventa_mex = vventa_mex;
	}

	public Float getVventa_mex() {
		return this.vventa_mex;
	}

	public void setIdunidadnegocio(String idunidadnegocio) {
		this.idunidadnegocio = idunidadnegocio;
	}

	public String getIdunidadnegocio() {
		return this.idunidadnegocio;
	}

	public void setIdclaseccosto(String idclaseccosto) {
		this.idclaseccosto = idclaseccosto;
	}

	public String getIdclaseccosto() {
		return this.idclaseccosto;
	}

	public void setIdcuentac_pt(String idcuentac_pt) {
		this.idcuentac_pt = idcuentac_pt;
	}

	public String getIdcuentac_pt() {
		return this.idcuentac_pt;
	}

	public void setIdcuentaa_pt(String idcuentaa_pt) {
		this.idcuentaa_pt = idcuentaa_pt;
	}

	public String getIdcuentaa_pt() {
		return this.idcuentaa_pt;
	}

	public void setIdcuentac_pp(String idcuentac_pp) {
		this.idcuentac_pp = idcuentac_pp;
	}

	public String getIdcuentac_pp() {
		return this.idcuentac_pp;
	}

	public void setIdcuentaa_pp(String idcuentaa_pp) {
		this.idcuentaa_pp = idcuentaa_pp;
	}

	public String getIdcuentaa_pp() {
		return this.idcuentaa_pp;
	}

	public void setTipo_costeo(Float tipo_costeo) {
		this.tipo_costeo = tipo_costeo;
	}

	public Float getTipo_costeo() {
		return this.tipo_costeo;
	}

	public void setIdfuncion(String idfuncion) {
		this.idfuncion = idfuncion;
	}

	public String getIdfuncion() {
		return this.idfuncion;
	}

	public void setIdmotivo_reval(String idmotivo_reval) {
		this.idmotivo_reval = idmotivo_reval;
	}

	public String getIdmotivo_reval() {
		return this.idmotivo_reval;
	}

	public void setIdsucursal_reval(String idsucursal_reval) {
		this.idsucursal_reval = idsucursal_reval;
	}

	public String getIdsucursal_reval() {
		return this.idsucursal_reval;
	}

	public void setIdalmacen_reval(String idalmacen_reval) {
		this.idalmacen_reval = idalmacen_reval;
	}

	public String getIdalmacen_reval() {
		return this.idalmacen_reval;
	}

	public void setIddocumento_reval(String iddocumento_reval) {
		this.iddocumento_reval = iddocumento_reval;
	}

	public String getIddocumento_reval() {
		return this.iddocumento_reval;
	}

	public void setIdfactordistribucion(String idfactordistribucion) {
		this.idfactordistribucion = idfactordistribucion;
	}

	public String getIdfactordistribucion() {
		return this.idfactordistribucion;
	}

	public void setCostoha_mex(Float costoha_mex) {
		this.costoha_mex = costoha_mex;
	}

	public Float getCostoha_mex() {
		return this.costoha_mex;
	}

	public void setCostoha_mof(Float costoha_mof) {
		this.costoha_mof = costoha_mof;
	}

	public Float getCostoha_mof() {
		return this.costoha_mof;
	}

	public void setDistr_costofinal(Float distr_costofinal) {
		this.distr_costofinal = distr_costofinal;
	}

	public Float getDistr_costofinal() {
		return this.distr_costofinal;
	}

	public void setEsxperiodo(Float esxperiodo) {
		this.esxperiodo = esxperiodo;
	}

	public Float getEsxperiodo() {
		return this.esxperiodo;
	}

	public void setNombre_registro(String nombre_registro) {
		this.nombre_registro = nombre_registro;
	}

	public String getNombre_registro() {
		return this.nombre_registro;
	}

	public void setNro_registro(String nro_registro) {
		this.nro_registro = nro_registro;
	}

	public String getNro_registro() {
		return this.nro_registro;
	}

	public void setTipo_costo(String tipo_costo) {
		this.tipo_costo = tipo_costo;
	}

	public String getTipo_costo() {
		return this.tipo_costo;
	}

	public void setIdparteproduccion(Float idparteproduccion) {
		this.idparteproduccion = idparteproduccion;
	}

	public Float getIdparteproduccion() {
		return this.idparteproduccion;
	}

	public void setAlgoritmoprecio(Float algoritmoprecio) {
		this.algoritmoprecio = algoritmoprecio;
	}

	public Float getAlgoritmoprecio() {
		return this.algoritmoprecio;
	}

	public void setIdprovlote(String idprovlote) {
		this.idprovlote = idprovlote;
	}

	public String getIdprovlote() {
		return this.idprovlote;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setDescarga(Float descarga) {
		this.descarga = descarga;
	}

	public Float getDescarga() {
		return this.descarga;
	}

	public void setEsvehtercero(Float esvehtercero) {
		this.esvehtercero = esvehtercero;
	}

	public Float getEsvehtercero() {
		return this.esvehtercero;
	}

	public void setGenera_viajet(Float genera_viajet) {
		this.genera_viajet = genera_viajet;
	}

	public Float getGenera_viajet() {
		return this.genera_viajet;
	}

	public void setGenera_remtransportista(Float genera_remtransportista) {
		this.genera_remtransportista = genera_remtransportista;
	}

	public Float getGenera_remtransportista() {
		return this.genera_remtransportista;
	}

	public void setIdviajet(String idviajet) {
		this.idviajet = idviajet;
	}

	public String getIdviajet() {
		return this.idviajet;
	}

	public void setIdremtransportista(String idremtransportista) {
		this.idremtransportista = idremtransportista;
	}

	public String getIdremtransportista() {
		return this.idremtransportista;
	}

	public void setNrv_asignacion(Float nrv_asignacion) {
		this.nrv_asignacion = nrv_asignacion;
	}

	public Float getNrv_asignacion() {
		return this.nrv_asignacion;
	}

	public void setGrowercode(String growercode) {
		this.growercode = growercode;
	}

	public String getGrowercode() {
		return this.growercode;
	}

	public void setVer_transformacion(Float ver_transformacion) {
		this.ver_transformacion = ver_transformacion;
	}

	public Float getVer_transformacion() {
		return this.ver_transformacion;
	}

	public void setIdcuenta_cp(String idcuenta_cp) {
		this.idcuenta_cp = idcuenta_cp;
	}

	public String getIdcuenta_cp() {
		return this.idcuenta_cp;
	}

	public void setCapacidad(Float capacidad) {
		this.capacidad = capacidad;
	}

	public Float getCapacidad() {
		return this.capacidad;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setIdfuenteagua(String idfuenteagua) {
		this.idfuenteagua = idfuenteagua;
	}

	public String getIdfuenteagua() {
		return this.idfuenteagua;
	}

	public void setIdclieprov_vehtercero(String idclieprov_vehtercero) {
		this.idclieprov_vehtercero = idclieprov_vehtercero;
	}

	public String getIdclieprov_vehtercero() {
		return this.idclieprov_vehtercero;
	}

	public void setEs_servicio(Float es_servicio) {
		this.es_servicio = es_servicio;
	}

	public Float getEs_servicio() {
		return this.es_servicio;
	}

	public void setIdcuentadiv9(String idcuentadiv9) {
		this.idcuentadiv9 = idcuentadiv9;
	}

	public String getIdcuentadiv9() {
		return this.idcuentadiv9;
	}

	public void setEsalquilado(Float esalquilado) {
		this.esalquilado = esalquilado;
	}

	public Float getEsalquilado() {
		return this.esalquilado;
	}

	public void setNo_participadistribucion(Float no_participadistribucion) {
		this.no_participadistribucion = no_participadistribucion;
	}

	public Float getNo_participadistribucion() {
		return this.no_participadistribucion;
	}

	public void setEs_mantenimiento(Float es_mantenimiento) {
		this.es_mantenimiento = es_mantenimiento;
	}

	public Float getEs_mantenimiento() {
		return this.es_mantenimiento;
	}

	public void setIdgrupo_maq(String idgrupo_maq) {
		this.idgrupo_maq = idgrupo_maq;
	}

	public String getIdgrupo_maq() {
		return this.idgrupo_maq;
	}

	public void setDistribucion_dwh(Float distribucion_dwh) {
		this.distribucion_dwh = distribucion_dwh;
	}

	public Float getDistribucion_dwh() {
		return this.distribucion_dwh;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setIdsubsectorconsumidor(String idsubsectorconsumidor) {
		this.idsubsectorconsumidor = idsubsectorconsumidor;
	}

	public String getIdsubsectorconsumidor() {
		return this.idsubsectorconsumidor;
	}

	public void setEs_cosecha(Float es_cosecha) {
		this.es_cosecha = es_cosecha;
	}

	public Float getEs_cosecha() {
		return this.es_cosecha;
	}

	public void setCapacidad_tanque(Float capacidad_tanque) {
		this.capacidad_tanque = capacidad_tanque;
	}

	public Float getCapacidad_tanque() {
		return this.capacidad_tanque;
	}

	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

	public void setIdactivo(String idactivo) {
		this.idactivo = idactivo;
	}

	public String getIdactivo() {
		return this.idactivo;
	}

	public void setIdingresosalidaactivo(String idingresosalidaactivo) {
		this.idingresosalidaactivo = idingresosalidaactivo;
	}

	public String getIdingresosalidaactivo() {
		return this.idingresosalidaactivo;
	}

	public void setIdctaactivo(String idctaactivo) {
		this.idctaactivo = idctaactivo;
	}

	public String getIdctaactivo() {
		return this.idctaactivo;
	}

	public void setEs_reproceso(Float es_reproceso) {
		this.es_reproceso = es_reproceso;
	}

	public Float getEs_reproceso() {
		return this.es_reproceso;
	}

	public void setEs_reempaque(Float es_reempaque) {
		this.es_reempaque = es_reempaque;
	}

	public Float getEs_reempaque() {
		return this.es_reempaque;
	}

	public void setEs_avicola(Float es_avicola) {
		this.es_avicola = es_avicola;
	}

	public Float getEs_avicola() {
		return this.es_avicola;
	}

	public void setTipo_presupuesto(String tipo_presupuesto) {
		this.tipo_presupuesto = tipo_presupuesto;
	}

	public String getTipo_presupuesto() {
		return this.tipo_presupuesto;
	}

	public void setEs_empaque(Float es_empaque) {
		this.es_empaque = es_empaque;
	}

	public Float getEs_empaque() {
		return this.es_empaque;
	}

	public void setIdconsumidor_spring(String idconsumidor_spring) {
		this.idconsumidor_spring = idconsumidor_spring;
	}

	public String getIdconsumidor_spring() {
		return this.idconsumidor_spring;
	}

	public void setEs_lote_campo(Float es_lote_campo) {
		this.es_lote_campo = es_lote_campo;
	}

	public Float getEs_lote_campo() {
		return this.es_lote_campo;
	}

	public void setEs_secado(Float es_secado) {
		this.es_secado = es_secado;
	}

	public Float getEs_secado() {
		return this.es_secado;
	}

	public void setCertificado(Float certificado) {
		this.certificado = certificado;
	}

	public Float getCertificado() {
		return this.certificado;
	}

	public void setTipo_precio_fuente(Integer tipo_precio_fuente) {
		this.tipo_precio_fuente = tipo_precio_fuente;
	}

	public Integer getTipo_precio_fuente() {
		return this.tipo_precio_fuente;
	}

	public void setCodigo_parcela(String codigo_parcela) {
		this.codigo_parcela = codigo_parcela;
	}

	public String getCodigo_parcela() {
		return this.codigo_parcela;
	}

	public void setCostokm_mof(Float costokm_mof) {
		this.costokm_mof = costokm_mof;
	}

	public Float getCostokm_mof() {
		return this.costokm_mof;
	}

	public void setCostokm_mex(Float costokm_mex) {
		this.costokm_mex = costokm_mex;
	}

	public Float getCostokm_mex() {
		return this.costokm_mex;
	}

	public void setCostodia_mof(Float costodia_mof) {
		this.costodia_mof = costodia_mof;
	}

	public Float getCostodia_mof() {
		return this.costodia_mof;
	}

	public void setCostodia_mex(Float costodia_mex) {
		this.costodia_mex = costodia_mex;
	}

	public Float getCostodia_mex() {
		return this.costodia_mex;
	}

	public void setIdlinea_avicola(String idlinea_avicola) {
		this.idlinea_avicola = idlinea_avicola;
	}

	public String getIdlinea_avicola() {
		return this.idlinea_avicola;
	}

	public void setPermanencia(Integer permanencia) {
		this.permanencia = permanencia;
	}

	public Integer getPermanencia() {
		return this.permanencia;
	}

	public void setDias_genpresup(Integer dias_genpresup) {
		this.dias_genpresup = dias_genpresup;
	}

	public Integer getDias_genpresup() {
		return this.dias_genpresup;
	}

	public void setIdmedida_maq(String idmedida_maq) {
		this.idmedida_maq = idmedida_maq;
	}

	public String getIdmedida_maq() {
		return this.idmedida_maq;
	}

	public void setCapacidad_maq(Float capacidad_maq) {
		this.capacidad_maq = capacidad_maq;
	}

	public Float getCapacidad_maq() {
		return this.capacidad_maq;
	}

	public void setVventa_um_mof(Float vventa_um_mof) {
		this.vventa_um_mof = vventa_um_mof;
	}

	public Float getVventa_um_mof() {
		return this.vventa_um_mof;
	}

	public void setVventa_um_mex(Float vventa_um_mex) {
		this.vventa_um_mex = vventa_um_mex;
	}

	public Float getVventa_um_mex() {
		return this.vventa_um_mex;
	}

	public void setTipo_registro_parte(String tipo_registro_parte) {
		this.tipo_registro_parte = tipo_registro_parte;
	}

	public String getTipo_registro_parte() {
		return this.tipo_registro_parte;
	}

	public void setVer_digitacion(Float ver_digitacion) {
		this.ver_digitacion = ver_digitacion;
	}

	public Float getVer_digitacion() {
		return this.ver_digitacion;
	}

	public void setEs_lote_vivero(Float es_lote_vivero) {
		this.es_lote_vivero = es_lote_vivero;
	}

	public Float getEs_lote_vivero() {
		return this.es_lote_vivero;
	}

	public void setFn_distr_var1_m2(Float fn_distr_var1_m2) {
		this.fn_distr_var1_m2 = fn_distr_var1_m2;
	}

	public Float getFn_distr_var1_m2() {
		return this.fn_distr_var1_m2;
	}



	/* Sets & Gets FK*/

}