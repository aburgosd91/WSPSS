package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;

@XStreamAlias("PRODUCTOS")
@Tabla(nombre = "PRODUCTOS")
public class Productos {
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos = "" ;
        @XStreamAlias("IDEMPRESA")
	@Columna
	private String idempresa;
        @XStreamAlias("IDPRODUCTO")
	@Columna
	private String idproducto;
        @XStreamAlias("ARANCELES")
	@Columna
	private String aranceles;
        @XStreamAlias("EN_MAQUINA")
	@Columna
	private Float en_maquina;
        @XStreamAlias("ES_DESCARTE")
	@Columna
	private Float es_descarte;
        @XStreamAlias("ES_TERMINADO")
	@Columna
	private Float es_terminado;
        @XStreamAlias("IDTERMINADO")
	@Columna
	private String idterminado;
        @XStreamAlias("IDSUBGRUPO")
	@Columna
	private String idsubgrupo;
        @XStreamAlias("IDGRUPO")
	@Columna
	private String idgrupo;
        @XStreamAlias("IDALGORITMO")
	@Columna
	private String idalgoritmo;
        @XStreamAlias("PARA_EXPORTACION")
	@Columna
	private Float para_exportacion;
        @XStreamAlias("PARA_VENTA")
	@Columna
	private Float para_venta;
        @XStreamAlias("PARA_CONSERVA")
	@Columna
	private Float para_conserva;
        @XStreamAlias("PIDE_LOTE")
	@Columna
	private Float pide_lote;
        @XStreamAlias("PIDE_SERIE")
	@Columna
	private Float pide_serie;
        @XStreamAlias("ES_AFECTO")
	@Columna
	private Float es_afecto;
        @XStreamAlias("TIEMPOREPOSICION")
	@Columna
	private Float tiemporeposicion;
        @XStreamAlias("CARACTERISTICAS")
	@Columna
	private String caracteristicas;
        @XStreamAlias("ES_COMPUESTO")
	@Columna
	private Float es_compuesto;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        @XStreamAlias("DESCRIPCION1")
	@Columna
	private String descripcion1;
        @XStreamAlias("ES_EXONERADO")
	@Columna
	private Float es_exonerado;
        @XStreamAlias("FOTO")
	@Columna
	private String foto;
        @XStreamAlias("IDMEDIDA")
	@Columna
	private String idmedida;
        @XStreamAlias("PESO")
	@Columna
	private Float peso;
        @XStreamAlias("REGIMEN_AGRARIO")
	@Columna
	private Float regimen_agrario;
        @XStreamAlias("VOLUMEN")
	@Columna
	private Float volumen;
        @XStreamAlias("LONGITUD")
	@Columna
	private String longitud;
        @XStreamAlias("TIPO_PUNTA")
	@Columna
	private String tipo_punta;
        @XStreamAlias("DIAMETRO")
	@Columna
	private String diametro;
        @XStreamAlias("ES_APROVECHABLE")
	@Columna
	private Float es_aprovechable;
        @XStreamAlias("NOMBRE_COMERCIAL")
	@Columna
	private String nombre_comercial;
        @XStreamAlias("IDMARCA")
	@Columna
	private String idmarca;
        @XStreamAlias("IDPARTIDA")
	@Columna
	private String idpartida;
        @XStreamAlias("IDCOLOR")
	@Columna
	private String idcolor;
        @XStreamAlias("IDINSUMO")
	@Columna
	private String idinsumo;
        @XStreamAlias("PIDE_ESTADO")
	@Columna
	private Float pide_estado;
        @XStreamAlias("IDPRODUCTO2")
	@Columna
	private String idproducto2;
        @XStreamAlias("ESTADO")
	@Columna
	private Float estado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("REVISADO")
	@Columna
	private Float revisado;
        @XStreamAlias("IDMODELO")
	@Columna
	private String idmodelo;
        @XStreamAlias("GENERA_SERIE")
	@Columna
	private Float genera_serie;
        @XStreamAlias("ES_SERVICIO")
	@Columna
	private Float es_servicio;
        @XStreamAlias("HORAS_STD")
	@Columna
	private Float horas_std;
        @XStreamAlias("IDDESCUENTO")
	@Columna
	private String iddescuento;
        @XStreamAlias("FACTORREPOSICION")
	@Columna
	private Float factorreposicion;
        @XStreamAlias("IDUBICACION")
	@Columna
	private String idubicacion;
        @XStreamAlias("ES_NEUMATICO")
	@Columna
	private Float es_neumatico;
        @XStreamAlias("PROF_COCADA")
	@Columna
	private Float prof_cocada;
        @XStreamAlias("PRES_MONTAJE")
	@Columna
	private Float pres_montaje;
        @XStreamAlias("IDTIPOPRODUCTO")
	@Columna
	private String idtipoproducto;
        @XStreamAlias("ES_TERCERO")
	@Columna
	private Float es_tercero;
        @XStreamAlias("ES_KIT")
	@Columna
	private Float es_kit;
        @XStreamAlias("ES_MERMA")
	@Columna
	private Float es_merma;
        @XStreamAlias("ES_ENSAMBLADO")
	@Columna
	private Float es_ensamblado;
        @XStreamAlias("CODIGOSAP")
	@Columna
	private String codigosap;
        @XStreamAlias("ES_GANADO")
	@Columna
	private Float es_ganado;
        @XStreamAlias("ES_PPROCESO")
	@Columna
	private Float es_pproceso;
        @XStreamAlias("ES_MATPRIMA")
	@Columna
	private Float es_matprima;
        @XStreamAlias("ES_CONGELADO")
	@Columna
	private Float es_congelado;
        @XStreamAlias("ES_FRESCO")
	@Columna
	private Float es_fresco;
        @XStreamAlias("IDTALLA")
	@Columna
	private String idtalla;
        @XStreamAlias("UGG")
	@Columna
	private Float ugg;
        @XStreamAlias("IDCCOSTO_GANADO")
	@Columna
	private String idccosto_ganado;
        @XStreamAlias("IDCLASECCOSTO")
	@Columna
	private String idclaseccosto;
        @XStreamAlias("ES_ACTIVO")
	@Columna
	private Float es_activo;
        @XStreamAlias("IDTIPOACTIVO")
	@Columna
	private String idtipoactivo;
        @XStreamAlias("IDCCOSTO_ACTIVO")
	@Columna
	private String idccosto_activo;
        @XStreamAlias("IDCTA_ACTIVO")
	@Columna
	private String idcta_activo;
        @XStreamAlias("IDCTA_DEPREC")
	@Columna
	private String idcta_deprec;
	@Columna
	private Float es_detraccion;
	@Columna
	private String idtipodetra;
	@Columna
	private Float es_drawback;
	@Columna
	private String idnomenclatura;
	@Columna
	private Float para_fresco;
	@Columna
	private String idcultivo;
	@Columna
	private String idvariedad;
	@Columna
	private Float es_inddrawback;
	@Columna
	private Float pesoneto;
	@Columna
	private Float tipo_isc;
	@Columna
	private Float valor_isc;
	@Columna
	private Float equiv_isc;
	@Columna
	private Float kg_cajas;
	@Columna
	private Float pide_lote_ccosto;
	@Columna
	private String idmedida2;
	@Columna
	private Float exige_u2;
	@Columna
	private Float factor_u2;
	@Columna
	private Float porcen_merma;
	@Columna
	private Float afecto_percepcion;
	@Columna
	private String idcondicion;
	@Columna
	private Integer uac;
	@Columna
	private Float um2_formula;
	@Columna
	private String tipo_proceso;
	@Columna
	private String idtiporet;
	@Columna
	private Float afecto_retencion;
	@Columna
	private String tipoproducto;
	@Columna
	private String tipo_proceso_origen;
	@Columna
	private String idproducto_equiv;
	@Columna
	private Float cestandar_mof;
	@Columna
	private Float cestandar_mex;
	@Columna
	private Float factorcosto;
	@Columna
	private Float es_vehiculo;
	@Columna
	private String retiqueta;
	@Columna
	private String rtecnica;
	@Columna
	private String rseguridad;
	@Columna
	private String rcalidad;
	@Columna
	private Float etiqueta;
	@Columna
	private Float tecnica;
	@Columna
	private Float seguridad;
	@Columna
	private Float calidad;
	@Columna
	private Float prohibido;
	@Columna
	private String descripcion2;
	@Columna
	private Float peso_tara;
	@Columna
	private Float es_herramienta;
	@Columna
	private Float regla_ot;
	@Columna
	private Float importado_externo;
	@Columna
	private String idtipocatalogo;
	@Columna
	private Float es_conversion_glp;
	@Columna
	private Float no_declara_le;
	@Columna
	private Float para_declaracion;
	@Columna
	private String idpresentacion;
	@Columna
	private Integer undxphl;
	@Columna
	private String largo;
	@Columna
	private String calibremm;
	@Columna
	private Integer porcent_peso_permitido;
	@Columna
	private Float es_generico;
	@Columna
	private String cod_equivalente;
	@Columna
	private Float factorce;
	@Columna
	private String cod_gtin;
	@Columna
	private String idccosto_pt;
	@Columna
	private String idgrupo2;
	@Columna
	private Float es_accesorio;
	@Columna
	private Integer valoriza_resultado;
	@Columna
	private String idcatalogo_unico;
	@Columna
	private String idproducto_spring;
	@Columna
	private Float es_produccion_cc;
	@Columna
	private String idconsumidor;
	@Columna
	private Float es_hojafresca;
	@Columna
	private Float es_plantafresca;
	@Columna
	private String partnumber;
	@Columna
	private String idproducto_agritask;
	@Columna
	private Float mas_ccosto;
	@Columna
	private String idnombrecomercial;
	@Columna
	private String idcuenta_ptr;
	@Columna
	private String idcuenta_vpt;
	@Columna
	private String idcuenta_cic;
	@Columna
	private String ventana;
	@Columna
	private Float pide_informe_activo;
	@Columna
	private Float por_isc;
	@Columna
	private String idconsumidor_o;
	@Columna
	private String idclieprov;
	@Columna
	private Float es_pesada;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setAranceles(String aranceles) {
		this.aranceles = aranceles;
	}

	public String getAranceles() {
		return this.aranceles;
	}

	public void setEn_maquina(Float en_maquina) {
		this.en_maquina = en_maquina;
	}

	public Float getEn_maquina() {
		return this.en_maquina;
	}

	public void setEs_descarte(Float es_descarte) {
		this.es_descarte = es_descarte;
	}

	public Float getEs_descarte() {
		return this.es_descarte;
	}

	public void setEs_terminado(Float es_terminado) {
		this.es_terminado = es_terminado;
	}

	public Float getEs_terminado() {
		return this.es_terminado;
	}

	public void setIdterminado(String idterminado) {
		this.idterminado = idterminado;
	}

	public String getIdterminado() {
		return this.idterminado;
	}

	public void setIdsubgrupo(String idsubgrupo) {
		this.idsubgrupo = idsubgrupo;
	}

	public String getIdsubgrupo() {
		return this.idsubgrupo;
	}

	public void setIdgrupo(String idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getIdgrupo() {
		return this.idgrupo;
	}

	public void setIdalgoritmo(String idalgoritmo) {
		this.idalgoritmo = idalgoritmo;
	}

	public String getIdalgoritmo() {
		return this.idalgoritmo;
	}

	public void setPara_exportacion(Float para_exportacion) {
		this.para_exportacion = para_exportacion;
	}

	public Float getPara_exportacion() {
		return this.para_exportacion;
	}

	public void setPara_venta(Float para_venta) {
		this.para_venta = para_venta;
	}

	public Float getPara_venta() {
		return this.para_venta;
	}

	public void setPara_conserva(Float para_conserva) {
		this.para_conserva = para_conserva;
	}

	public Float getPara_conserva() {
		return this.para_conserva;
	}

	public void setPide_lote(Float pide_lote) {
		this.pide_lote = pide_lote;
	}

	public Float getPide_lote() {
		return this.pide_lote;
	}

	public void setPide_serie(Float pide_serie) {
		this.pide_serie = pide_serie;
	}

	public Float getPide_serie() {
		return this.pide_serie;
	}

	public void setEs_afecto(Float es_afecto) {
		this.es_afecto = es_afecto;
	}

	public Float getEs_afecto() {
		return this.es_afecto;
	}

	public void setTiemporeposicion(Float tiemporeposicion) {
		this.tiemporeposicion = tiemporeposicion;
	}

	public Float getTiemporeposicion() {
		return this.tiemporeposicion;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCaracteristicas() {
		return this.caracteristicas;
	}

	public void setEs_compuesto(Float es_compuesto) {
		this.es_compuesto = es_compuesto;
	}

	public Float getEs_compuesto() {
		return this.es_compuesto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setEs_exonerado(Float es_exonerado) {
		this.es_exonerado = es_exonerado;
	}

	public Float getEs_exonerado() {
		return this.es_exonerado;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getPeso() {
		return this.peso;
	}

	public void setRegimen_agrario(Float regimen_agrario) {
		this.regimen_agrario = regimen_agrario;
	}

	public Float getRegimen_agrario() {
		return this.regimen_agrario;
	}

	public void setVolumen(Float volumen) {
		this.volumen = volumen;
	}

	public Float getVolumen() {
		return this.volumen;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setTipo_punta(String tipo_punta) {
		this.tipo_punta = tipo_punta;
	}

	public String getTipo_punta() {
		return this.tipo_punta;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getDiametro() {
		return this.diametro;
	}

	public void setEs_aprovechable(Float es_aprovechable) {
		this.es_aprovechable = es_aprovechable;
	}

	public Float getEs_aprovechable() {
		return this.es_aprovechable;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getNombre_comercial() {
		return this.nombre_comercial;
	}

	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}

	public String getIdmarca() {
		return this.idmarca;
	}

	public void setIdpartida(String idpartida) {
		this.idpartida = idpartida;
	}

	public String getIdpartida() {
		return this.idpartida;
	}

	public void setIdcolor(String idcolor) {
		this.idcolor = idcolor;
	}

	public String getIdcolor() {
		return this.idcolor;
	}

	public void setIdinsumo(String idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getIdinsumo() {
		return this.idinsumo;
	}

	public void setPide_estado(Float pide_estado) {
		this.pide_estado = pide_estado;
	}

	public Float getPide_estado() {
		return this.pide_estado;
	}

	public void setIdproducto2(String idproducto2) {
		this.idproducto2 = idproducto2;
	}

	public String getIdproducto2() {
		return this.idproducto2;
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

	public void setRevisado(Float revisado) {
		this.revisado = revisado;
	}

	public Float getRevisado() {
		return this.revisado;
	}

	public void setIdmodelo(String idmodelo) {
		this.idmodelo = idmodelo;
	}

	public String getIdmodelo() {
		return this.idmodelo;
	}

	public void setGenera_serie(Float genera_serie) {
		this.genera_serie = genera_serie;
	}

	public Float getGenera_serie() {
		return this.genera_serie;
	}

	public void setEs_servicio(Float es_servicio) {
		this.es_servicio = es_servicio;
	}

	public Float getEs_servicio() {
		return this.es_servicio;
	}

	public void setHoras_std(Float horas_std) {
		this.horas_std = horas_std;
	}

	public Float getHoras_std() {
		return this.horas_std;
	}

	public void setIddescuento(String iddescuento) {
		this.iddescuento = iddescuento;
	}

	public String getIddescuento() {
		return this.iddescuento;
	}

	public void setFactorreposicion(Float factorreposicion) {
		this.factorreposicion = factorreposicion;
	}

	public Float getFactorreposicion() {
		return this.factorreposicion;
	}

	public void setIdubicacion(String idubicacion) {
		this.idubicacion = idubicacion;
	}

	public String getIdubicacion() {
		return this.idubicacion;
	}

	public void setEs_neumatico(Float es_neumatico) {
		this.es_neumatico = es_neumatico;
	}

	public Float getEs_neumatico() {
		return this.es_neumatico;
	}

	public void setProf_cocada(Float prof_cocada) {
		this.prof_cocada = prof_cocada;
	}

	public Float getProf_cocada() {
		return this.prof_cocada;
	}

	public void setPres_montaje(Float pres_montaje) {
		this.pres_montaje = pres_montaje;
	}

	public Float getPres_montaje() {
		return this.pres_montaje;
	}

	public void setIdtipoproducto(String idtipoproducto) {
		this.idtipoproducto = idtipoproducto;
	}

	public String getIdtipoproducto() {
		return this.idtipoproducto;
	}

	public void setEs_tercero(Float es_tercero) {
		this.es_tercero = es_tercero;
	}

	public Float getEs_tercero() {
		return this.es_tercero;
	}

	public void setEs_kit(Float es_kit) {
		this.es_kit = es_kit;
	}

	public Float getEs_kit() {
		return this.es_kit;
	}

	public void setEs_merma(Float es_merma) {
		this.es_merma = es_merma;
	}

	public Float getEs_merma() {
		return this.es_merma;
	}

	public void setEs_ensamblado(Float es_ensamblado) {
		this.es_ensamblado = es_ensamblado;
	}

	public Float getEs_ensamblado() {
		return this.es_ensamblado;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setEs_ganado(Float es_ganado) {
		this.es_ganado = es_ganado;
	}

	public Float getEs_ganado() {
		return this.es_ganado;
	}

	public void setEs_pproceso(Float es_pproceso) {
		this.es_pproceso = es_pproceso;
	}

	public Float getEs_pproceso() {
		return this.es_pproceso;
	}

	public void setEs_matprima(Float es_matprima) {
		this.es_matprima = es_matprima;
	}

	public Float getEs_matprima() {
		return this.es_matprima;
	}

	public void setEs_congelado(Float es_congelado) {
		this.es_congelado = es_congelado;
	}

	public Float getEs_congelado() {
		return this.es_congelado;
	}

	public void setEs_fresco(Float es_fresco) {
		this.es_fresco = es_fresco;
	}

	public Float getEs_fresco() {
		return this.es_fresco;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}

	public String getIdtalla() {
		return this.idtalla;
	}

	public void setUgg(Float ugg) {
		this.ugg = ugg;
	}

	public Float getUgg() {
		return this.ugg;
	}

	public void setIdccosto_ganado(String idccosto_ganado) {
		this.idccosto_ganado = idccosto_ganado;
	}

	public String getIdccosto_ganado() {
		return this.idccosto_ganado;
	}

	public void setIdclaseccosto(String idclaseccosto) {
		this.idclaseccosto = idclaseccosto;
	}

	public String getIdclaseccosto() {
		return this.idclaseccosto;
	}

	public void setEs_activo(Float es_activo) {
		this.es_activo = es_activo;
	}

	public Float getEs_activo() {
		return this.es_activo;
	}

	public void setIdtipoactivo(String idtipoactivo) {
		this.idtipoactivo = idtipoactivo;
	}

	public String getIdtipoactivo() {
		return this.idtipoactivo;
	}

	public void setIdccosto_activo(String idccosto_activo) {
		this.idccosto_activo = idccosto_activo;
	}

	public String getIdccosto_activo() {
		return this.idccosto_activo;
	}

	public void setIdcta_activo(String idcta_activo) {
		this.idcta_activo = idcta_activo;
	}

	public String getIdcta_activo() {
		return this.idcta_activo;
	}

	public void setIdcta_deprec(String idcta_deprec) {
		this.idcta_deprec = idcta_deprec;
	}

	public String getIdcta_deprec() {
		return this.idcta_deprec;
	}

	public void setEs_detraccion(Float es_detraccion) {
		this.es_detraccion = es_detraccion;
	}

	public Float getEs_detraccion() {
		return this.es_detraccion;
	}

	public void setIdtipodetra(String idtipodetra) {
		this.idtipodetra = idtipodetra;
	}

	public String getIdtipodetra() {
		return this.idtipodetra;
	}

	public void setEs_drawback(Float es_drawback) {
		this.es_drawback = es_drawback;
	}

	public Float getEs_drawback() {
		return this.es_drawback;
	}

	public void setIdnomenclatura(String idnomenclatura) {
		this.idnomenclatura = idnomenclatura;
	}

	public String getIdnomenclatura() {
		return this.idnomenclatura;
	}

	public void setPara_fresco(Float para_fresco) {
		this.para_fresco = para_fresco;
	}

	public Float getPara_fresco() {
		return this.para_fresco;
	}

	public void setIdcultivo(String idcultivo) {
		this.idcultivo = idcultivo;
	}

	public String getIdcultivo() {
		return this.idcultivo;
	}

	public void setIdvariedad(String idvariedad) {
		this.idvariedad = idvariedad;
	}

	public String getIdvariedad() {
		return this.idvariedad;
	}

	public void setEs_inddrawback(Float es_inddrawback) {
		this.es_inddrawback = es_inddrawback;
	}

	public Float getEs_inddrawback() {
		return this.es_inddrawback;
	}

	public void setPesoneto(Float pesoneto) {
		this.pesoneto = pesoneto;
	}

	public Float getPesoneto() {
		return this.pesoneto;
	}

	public void setTipo_isc(Float tipo_isc) {
		this.tipo_isc = tipo_isc;
	}

	public Float getTipo_isc() {
		return this.tipo_isc;
	}

	public void setValor_isc(Float valor_isc) {
		this.valor_isc = valor_isc;
	}

	public Float getValor_isc() {
		return this.valor_isc;
	}

	public void setEquiv_isc(Float equiv_isc) {
		this.equiv_isc = equiv_isc;
	}

	public Float getEquiv_isc() {
		return this.equiv_isc;
	}

	public void setKg_cajas(Float kg_cajas) {
		this.kg_cajas = kg_cajas;
	}

	public Float getKg_cajas() {
		return this.kg_cajas;
	}

	public void setPide_lote_ccosto(Float pide_lote_ccosto) {
		this.pide_lote_ccosto = pide_lote_ccosto;
	}

	public Float getPide_lote_ccosto() {
		return this.pide_lote_ccosto;
	}

	public void setIdmedida2(String idmedida2) {
		this.idmedida2 = idmedida2;
	}

	public String getIdmedida2() {
		return this.idmedida2;
	}

	public void setExige_u2(Float exige_u2) {
		this.exige_u2 = exige_u2;
	}

	public Float getExige_u2() {
		return this.exige_u2;
	}

	public void setFactor_u2(Float factor_u2) {
		this.factor_u2 = factor_u2;
	}

	public Float getFactor_u2() {
		return this.factor_u2;
	}

	public void setPorcen_merma(Float porcen_merma) {
		this.porcen_merma = porcen_merma;
	}

	public Float getPorcen_merma() {
		return this.porcen_merma;
	}

	public void setAfecto_percepcion(Float afecto_percepcion) {
		this.afecto_percepcion = afecto_percepcion;
	}

	public Float getAfecto_percepcion() {
		return this.afecto_percepcion;
	}

	public void setIdcondicion(String idcondicion) {
		this.idcondicion = idcondicion;
	}

	public String getIdcondicion() {
		return this.idcondicion;
	}

	public void setUac(Integer uac) {
		this.uac = uac;
	}

	public Integer getUac() {
		return this.uac;
	}

	public void setUm2_formula(Float um2_formula) {
		this.um2_formula = um2_formula;
	}

	public Float getUm2_formula() {
		return this.um2_formula;
	}

	public void setTipo_proceso(String tipo_proceso) {
		this.tipo_proceso = tipo_proceso;
	}

	public String getTipo_proceso() {
		return this.tipo_proceso;
	}

	public void setIdtiporet(String idtiporet) {
		this.idtiporet = idtiporet;
	}

	public String getIdtiporet() {
		return this.idtiporet;
	}

	public void setAfecto_retencion(Float afecto_retencion) {
		this.afecto_retencion = afecto_retencion;
	}

	public Float getAfecto_retencion() {
		return this.afecto_retencion;
	}

	public void setTipoproducto(String tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public String getTipoproducto() {
		return this.tipoproducto;
	}

	public void setTipo_proceso_origen(String tipo_proceso_origen) {
		this.tipo_proceso_origen = tipo_proceso_origen;
	}

	public String getTipo_proceso_origen() {
		return this.tipo_proceso_origen;
	}

	public void setIdproducto_equiv(String idproducto_equiv) {
		this.idproducto_equiv = idproducto_equiv;
	}

	public String getIdproducto_equiv() {
		return this.idproducto_equiv;
	}

	public void setCestandar_mof(Float cestandar_mof) {
		this.cestandar_mof = cestandar_mof;
	}

	public Float getCestandar_mof() {
		return this.cestandar_mof;
	}

	public void setCestandar_mex(Float cestandar_mex) {
		this.cestandar_mex = cestandar_mex;
	}

	public Float getCestandar_mex() {
		return this.cestandar_mex;
	}

	public void setFactorcosto(Float factorcosto) {
		this.factorcosto = factorcosto;
	}

	public Float getFactorcosto() {
		return this.factorcosto;
	}

	public void setEs_vehiculo(Float es_vehiculo) {
		this.es_vehiculo = es_vehiculo;
	}

	public Float getEs_vehiculo() {
		return this.es_vehiculo;
	}

	public void setRetiqueta(String retiqueta) {
		this.retiqueta = retiqueta;
	}

	public String getRetiqueta() {
		return this.retiqueta;
	}

	public void setRtecnica(String rtecnica) {
		this.rtecnica = rtecnica;
	}

	public String getRtecnica() {
		return this.rtecnica;
	}

	public void setRseguridad(String rseguridad) {
		this.rseguridad = rseguridad;
	}

	public String getRseguridad() {
		return this.rseguridad;
	}

	public void setRcalidad(String rcalidad) {
		this.rcalidad = rcalidad;
	}

	public String getRcalidad() {
		return this.rcalidad;
	}

	public void setEtiqueta(Float etiqueta) {
		this.etiqueta = etiqueta;
	}

	public Float getEtiqueta() {
		return this.etiqueta;
	}

	public void setTecnica(Float tecnica) {
		this.tecnica = tecnica;
	}

	public Float getTecnica() {
		return this.tecnica;
	}

	public void setSeguridad(Float seguridad) {
		this.seguridad = seguridad;
	}

	public Float getSeguridad() {
		return this.seguridad;
	}

	public void setCalidad(Float calidad) {
		this.calidad = calidad;
	}

	public Float getCalidad() {
		return this.calidad;
	}

	public void setProhibido(Float prohibido) {
		this.prohibido = prohibido;
	}

	public Float getProhibido() {
		return this.prohibido;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

	public String getDescripcion2() {
		return this.descripcion2;
	}

	public void setPeso_tara(Float peso_tara) {
		this.peso_tara = peso_tara;
	}

	public Float getPeso_tara() {
		return this.peso_tara;
	}

	public void setEs_herramienta(Float es_herramienta) {
		this.es_herramienta = es_herramienta;
	}

	public Float getEs_herramienta() {
		return this.es_herramienta;
	}

	public void setRegla_ot(Float regla_ot) {
		this.regla_ot = regla_ot;
	}

	public Float getRegla_ot() {
		return this.regla_ot;
	}

	public void setImportado_externo(Float importado_externo) {
		this.importado_externo = importado_externo;
	}

	public Float getImportado_externo() {
		return this.importado_externo;
	}

	public void setIdtipocatalogo(String idtipocatalogo) {
		this.idtipocatalogo = idtipocatalogo;
	}

	public String getIdtipocatalogo() {
		return this.idtipocatalogo;
	}

	public void setEs_conversion_glp(Float es_conversion_glp) {
		this.es_conversion_glp = es_conversion_glp;
	}

	public Float getEs_conversion_glp() {
		return this.es_conversion_glp;
	}

	public void setNo_declara_le(Float no_declara_le) {
		this.no_declara_le = no_declara_le;
	}

	public Float getNo_declara_le() {
		return this.no_declara_le;
	}

	public void setPara_declaracion(Float para_declaracion) {
		this.para_declaracion = para_declaracion;
	}

	public Float getPara_declaracion() {
		return this.para_declaracion;
	}

	public void setIdpresentacion(String idpresentacion) {
		this.idpresentacion = idpresentacion;
	}

	public String getIdpresentacion() {
		return this.idpresentacion;
	}

	public void setUndxphl(Integer undxphl) {
		this.undxphl = undxphl;
	}

	public Integer getUndxphl() {
		return this.undxphl;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getLargo() {
		return this.largo;
	}

	public void setCalibremm(String calibremm) {
		this.calibremm = calibremm;
	}

	public String getCalibremm() {
		return this.calibremm;
	}

	public void setPorcent_peso_permitido(Integer porcent_peso_permitido) {
		this.porcent_peso_permitido = porcent_peso_permitido;
	}

	public Integer getPorcent_peso_permitido() {
		return this.porcent_peso_permitido;
	}

	public void setEs_generico(Float es_generico) {
		this.es_generico = es_generico;
	}

	public Float getEs_generico() {
		return this.es_generico;
	}

	public void setCod_equivalente(String cod_equivalente) {
		this.cod_equivalente = cod_equivalente;
	}

	public String getCod_equivalente() {
		return this.cod_equivalente;
	}

	public void setFactorce(Float factorce) {
		this.factorce = factorce;
	}

	public Float getFactorce() {
		return this.factorce;
	}

	public void setCod_gtin(String cod_gtin) {
		this.cod_gtin = cod_gtin;
	}

	public String getCod_gtin() {
		return this.cod_gtin;
	}

	public void setIdccosto_pt(String idccosto_pt) {
		this.idccosto_pt = idccosto_pt;
	}

	public String getIdccosto_pt() {
		return this.idccosto_pt;
	}

	public void setIdgrupo2(String idgrupo2) {
		this.idgrupo2 = idgrupo2;
	}

	public String getIdgrupo2() {
		return this.idgrupo2;
	}

	public void setEs_accesorio(Float es_accesorio) {
		this.es_accesorio = es_accesorio;
	}

	public Float getEs_accesorio() {
		return this.es_accesorio;
	}

	public void setValoriza_resultado(Integer valoriza_resultado) {
		this.valoriza_resultado = valoriza_resultado;
	}

	public Integer getValoriza_resultado() {
		return this.valoriza_resultado;
	}

	public void setIdcatalogo_unico(String idcatalogo_unico) {
		this.idcatalogo_unico = idcatalogo_unico;
	}

	public String getIdcatalogo_unico() {
		return this.idcatalogo_unico;
	}

	public void setIdproducto_spring(String idproducto_spring) {
		this.idproducto_spring = idproducto_spring;
	}

	public String getIdproducto_spring() {
		return this.idproducto_spring;
	}

	public void setEs_produccion_cc(Float es_produccion_cc) {
		this.es_produccion_cc = es_produccion_cc;
	}

	public Float getEs_produccion_cc() {
		return this.es_produccion_cc;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setEs_hojafresca(Float es_hojafresca) {
		this.es_hojafresca = es_hojafresca;
	}

	public Float getEs_hojafresca() {
		return this.es_hojafresca;
	}

	public void setEs_plantafresca(Float es_plantafresca) {
		this.es_plantafresca = es_plantafresca;
	}

	public Float getEs_plantafresca() {
		return this.es_plantafresca;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getPartnumber() {
		return this.partnumber;
	}

	public void setIdproducto_agritask(String idproducto_agritask) {
		this.idproducto_agritask = idproducto_agritask;
	}

	public String getIdproducto_agritask() {
		return this.idproducto_agritask;
	}

	public void setMas_ccosto(Float mas_ccosto) {
		this.mas_ccosto = mas_ccosto;
	}

	public Float getMas_ccosto() {
		return this.mas_ccosto;
	}

	public void setIdnombrecomercial(String idnombrecomercial) {
		this.idnombrecomercial = idnombrecomercial;
	}

	public String getIdnombrecomercial() {
		return this.idnombrecomercial;
	}

	public void setIdcuenta_ptr(String idcuenta_ptr) {
		this.idcuenta_ptr = idcuenta_ptr;
	}

	public String getIdcuenta_ptr() {
		return this.idcuenta_ptr;
	}

	public void setIdcuenta_vpt(String idcuenta_vpt) {
		this.idcuenta_vpt = idcuenta_vpt;
	}

	public String getIdcuenta_vpt() {
		return this.idcuenta_vpt;
	}

	public void setIdcuenta_cic(String idcuenta_cic) {
		this.idcuenta_cic = idcuenta_cic;
	}

	public String getIdcuenta_cic() {
		return this.idcuenta_cic;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setPide_informe_activo(Float pide_informe_activo) {
		this.pide_informe_activo = pide_informe_activo;
	}

	public Float getPide_informe_activo() {
		return this.pide_informe_activo;
	}

	public void setPor_isc(Float por_isc) {
		this.por_isc = por_isc;
	}

	public Float getPor_isc() {
		return this.por_isc;
	}

	public void setIdconsumidor_o(String idconsumidor_o) {
		this.idconsumidor_o = idconsumidor_o;
	}

	public String getIdconsumidor_o() {
		return this.idconsumidor_o;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setEs_pesada(Float es_pesada) {
		this.es_pesada = es_pesada;
	}

	public Float getEs_pesada() {
		return this.es_pesada;
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