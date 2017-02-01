package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import java.util.List;

@Tabla(nombre = "COTIZACIONVENTAS")
public class Cotizacionventas {
        private String idbasedatos;
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idcotizacionv;
	@Columna
	private String idemisor;
	@Columna
	private String idsucursal;
	@Columna
	private String idalmacen;
	@Columna
	private String iddocumento;
	@Columna
	private String periodo;
	@Columna
	private String serie;
	@Columna
	private String numero;
	@Columna
	private Date fecha;
	@Columna
	private String idclieprov;
	@Columna
	private String idproyecto;
	@Columna
	private Float tcambio;
	@Columna
	private String idmoneda;
	@Columna
	private String glosa;
	@Columna
	private String idestado;
	@Columna
	private String idestadoold;
	@Columna
	private Float vventa;
	@Columna
	private Float impuesto;
	@Columna
	private Float impuesto_i;
	@Columna
	private Float importe;
	@Columna
	private Date fechacreacion;
	@Columna
	private String sincroniza;
	@Columna
	private String contacto;
	@Columna
	private String lugar_entrega;
	@Columna
	private String solicitado;
	@Columna
	private Float tcmoneda;
	@Columna
	private Float subtotalsindscto;
	@Columna
	private Float descuento;
	@Columna
	private Float subtotalcondscto;
	@Columna
	private Date fechavigencia;
	@Columna
	private Float duracionvigencia;
	@Columna
	private Float confirmastock;
	@Columna
	private Date fechavisita;
	@Columna
	private String idfpago;
	@Columna
	private String plazoentrega;
	@Columna
	private String ventana;
	@Columna
	private String idvendedor;
	@Columna
	private Float comision;
	@Columna
	private String idembalaje;
	@Columna
	private String garantia;
	@Columna
	private String idprevaloriza;
	@Columna
	private String referencia;
	@Columna
	private Float multivendedores;
	@Columna
	private Float pesobruto;
	@Columna
	private Float pesotara;
	@Columna
	private Float pesoneto;
	@Columna
	private String idtipocontenedor;
	@Columna
	private String nrocontenedor;
	@Columna
	private String ciudadorigen;
	@Columna
	private String ciudaddestino;
	@Columna
	private Date fechaembarque;
	@Columna
	private Date fechaarribo;
	@Columna
	private String idpuertoorigen;
	@Columna
	private String idpuertodestino;
	@Columna
	private String puertociudadori;
	@Columna
	private String puertociudaddes;
	@Columna
	private String idubigeo;
	@Columna
	private String container;
	@Columna
	private String idtipoprecio;
	@Columna
	private String idflete;
	@Columna
	private Float exonerado;
	@Columna
	private Float es_proyecto;
	@Columna
	private String smfcred;
	@Columna
	private String smfvenc;
	@Columna
	private String idunidadnegocio;
	@Columna
	private String idsubunidadnegocio;
	@Columna
	private Float area_ha;
	@Columna
	private Float redondeo;
	@Columna
	private Float fleteusd;
	@Columna
	private String idagentecarga;
	@Columna
	private String idcondventa;
	@Columna
	private String idlineaaerea;
	@Columna
	private String nro_forma_pago;
	@Columna
	private String nro_manual;
	@Columna
	private String idclieprov_destino;
	@Columna
	private Integer prioridad;
	@Columna
	private String nrobuckin;
	@Columna
	private String contenedor;
	@Columna
	private Float peso_real;
	@Columna
	private String nro_viaje;
	@Columna
	private String nombre_nave;
	@Columna
	private String iddocumento_pf;
	@Columna
	private String serie_pf;
	@Columna
	private String numero_pf;
	@Columna
	private Date fecha_pf;
	@Columna
	private String glosa_l;
	@Columna
	private String awb;
	@Columna
	private String idcultivo;
	@Columna
	private String idvariedad;
	@Columna
	private String idestadobanco;
	@Columna
	private Integer idtg30campaniaveh;
	@Columna
	private String idbanco;
	@Columna
	private String ofrecio_seguro;
	@Columna
	private Float copropietario;
	@Columna
	private String idtipocredito;
	@Columna
	private String cuota;
	@Columna
	private Float vventapublico_conigv;
	@Columna
	private Float importedscto1_conigv;
	@Columna
	private Float importedscto2_conigv;
	@Columna
	private Float importedscto3_conigv;
	@Columna
	private Float accesorios_conigv;
	@Columna
	private String idcopropietario;
	@Columna
	private String idtg10tipocotizacion;
	@Columna
	private Integer idtg30cotvent_web;
	@Columna
	private Float cuotainicial;
	@Columna
	private String idctacte;
        private String razon_social;
        private List<Dcotizacionventas> listDcotizacionventas;

	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setIdproyecto(String idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getIdproyecto() {
		return this.idproyecto;
	}

	public void setTcambio(Float tcambio) {
		this.tcambio = tcambio;
	}

	public Float getTcambio() {
		return this.tcambio;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setIdestadoold(String idestadoold) {
		this.idestadoold = idestadoold;
	}

	public String getIdestadoold() {
		return this.idestadoold;
	}

	public void setVventa(Float vventa) {
		this.vventa = vventa;
	}

	public Float getVventa() {
		return this.vventa;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto_i(Float impuesto_i) {
		this.impuesto_i = impuesto_i;
	}

	public Float getImpuesto_i() {
		return this.impuesto_i;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getImporte() {
		return this.importe;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContacto() {
		return this.contacto;
	}

	public void setLugar_entrega(String lugar_entrega) {
		this.lugar_entrega = lugar_entrega;
	}

	public String getLugar_entrega() {
		return this.lugar_entrega;
	}

	public void setSolicitado(String solicitado) {
		this.solicitado = solicitado;
	}

	public String getSolicitado() {
		return this.solicitado;
	}

	public void setTcmoneda(Float tcmoneda) {
		this.tcmoneda = tcmoneda;
	}

	public Float getTcmoneda() {
		return this.tcmoneda;
	}

	public void setSubtotalsindscto(Float subtotalsindscto) {
		this.subtotalsindscto = subtotalsindscto;
	}

	public Float getSubtotalsindscto() {
		return this.subtotalsindscto;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getDescuento() {
		return this.descuento;
	}

	public void setSubtotalcondscto(Float subtotalcondscto) {
		this.subtotalcondscto = subtotalcondscto;
	}

	public Float getSubtotalcondscto() {
		return this.subtotalcondscto;
	}

	public void setFechavigencia(Date fechavigencia) {
		this.fechavigencia = fechavigencia;
	}

	public Date getFechavigencia() {
		return this.fechavigencia;
	}

	public void setDuracionvigencia(Float duracionvigencia) {
		this.duracionvigencia = duracionvigencia;
	}

	public Float getDuracionvigencia() {
		return this.duracionvigencia;
	}

	public void setConfirmastock(Float confirmastock) {
		this.confirmastock = confirmastock;
	}

	public Float getConfirmastock() {
		return this.confirmastock;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public Date getFechavisita() {
		return this.fechavisita;
	}

	public void setIdfpago(String idfpago) {
		this.idfpago = idfpago;
	}

	public String getIdfpago() {
		return this.idfpago;
	}

	public void setPlazoentrega(String plazoentrega) {
		this.plazoentrega = plazoentrega;
	}

	public String getPlazoentrega() {
		return this.plazoentrega;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setComision(Float comision) {
		this.comision = comision;
	}

	public Float getComision() {
		return this.comision;
	}

	public void setIdembalaje(String idembalaje) {
		this.idembalaje = idembalaje;
	}

	public String getIdembalaje() {
		return this.idembalaje;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getGarantia() {
		return this.garantia;
	}

	public void setIdprevaloriza(String idprevaloriza) {
		this.idprevaloriza = idprevaloriza;
	}

	public String getIdprevaloriza() {
		return this.idprevaloriza;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setMultivendedores(Float multivendedores) {
		this.multivendedores = multivendedores;
	}

	public Float getMultivendedores() {
		return this.multivendedores;
	}

	public void setPesobruto(Float pesobruto) {
		this.pesobruto = pesobruto;
	}

	public Float getPesobruto() {
		return this.pesobruto;
	}

	public void setPesotara(Float pesotara) {
		this.pesotara = pesotara;
	}

	public Float getPesotara() {
		return this.pesotara;
	}

	public void setPesoneto(Float pesoneto) {
		this.pesoneto = pesoneto;
	}

	public Float getPesoneto() {
		return this.pesoneto;
	}

	public void setIdtipocontenedor(String idtipocontenedor) {
		this.idtipocontenedor = idtipocontenedor;
	}

	public String getIdtipocontenedor() {
		return this.idtipocontenedor;
	}

	public void setNrocontenedor(String nrocontenedor) {
		this.nrocontenedor = nrocontenedor;
	}

	public String getNrocontenedor() {
		return this.nrocontenedor;
	}

	public void setCiudadorigen(String ciudadorigen) {
		this.ciudadorigen = ciudadorigen;
	}

	public String getCiudadorigen() {
		return this.ciudadorigen;
	}

	public void setCiudaddestino(String ciudaddestino) {
		this.ciudaddestino = ciudaddestino;
	}

	public String getCiudaddestino() {
		return this.ciudaddestino;
	}

	public void setFechaembarque(Date fechaembarque) {
		this.fechaembarque = fechaembarque;
	}

	public Date getFechaembarque() {
		return this.fechaembarque;
	}

	public void setFechaarribo(Date fechaarribo) {
		this.fechaarribo = fechaarribo;
	}

	public Date getFechaarribo() {
		return this.fechaarribo;
	}

	public void setIdpuertoorigen(String idpuertoorigen) {
		this.idpuertoorigen = idpuertoorigen;
	}

	public String getIdpuertoorigen() {
		return this.idpuertoorigen;
	}

	public void setIdpuertodestino(String idpuertodestino) {
		this.idpuertodestino = idpuertodestino;
	}

	public String getIdpuertodestino() {
		return this.idpuertodestino;
	}

	public void setPuertociudadori(String puertociudadori) {
		this.puertociudadori = puertociudadori;
	}

	public String getPuertociudadori() {
		return this.puertociudadori;
	}

	public void setPuertociudaddes(String puertociudaddes) {
		this.puertociudaddes = puertociudaddes;
	}

	public String getPuertociudaddes() {
		return this.puertociudaddes;
	}

	public void setIdubigeo(String idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getIdubigeo() {
		return this.idubigeo;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getContainer() {
		return this.container;
	}

	public void setIdtipoprecio(String idtipoprecio) {
		this.idtipoprecio = idtipoprecio;
	}

	public String getIdtipoprecio() {
		return this.idtipoprecio;
	}

	public void setIdflete(String idflete) {
		this.idflete = idflete;
	}

	public String getIdflete() {
		return this.idflete;
	}

	public void setExonerado(Float exonerado) {
		this.exonerado = exonerado;
	}

	public Float getExonerado() {
		return this.exonerado;
	}

	public void setEs_proyecto(Float es_proyecto) {
		this.es_proyecto = es_proyecto;
	}

	public Float getEs_proyecto() {
		return this.es_proyecto;
	}

	public void setSmfcred(String smfcred) {
		this.smfcred = smfcred;
	}

	public String getSmfcred() {
		return this.smfcred;
	}

	public void setSmfvenc(String smfvenc) {
		this.smfvenc = smfvenc;
	}

	public String getSmfvenc() {
		return this.smfvenc;
	}

	public void setIdunidadnegocio(String idunidadnegocio) {
		this.idunidadnegocio = idunidadnegocio;
	}

	public String getIdunidadnegocio() {
		return this.idunidadnegocio;
	}

	public void setIdsubunidadnegocio(String idsubunidadnegocio) {
		this.idsubunidadnegocio = idsubunidadnegocio;
	}

	public String getIdsubunidadnegocio() {
		return this.idsubunidadnegocio;
	}

	public void setArea_ha(Float area_ha) {
		this.area_ha = area_ha;
	}

	public Float getArea_ha() {
		return this.area_ha;
	}

	public void setRedondeo(Float redondeo) {
		this.redondeo = redondeo;
	}

	public Float getRedondeo() {
		return this.redondeo;
	}

	public void setFleteusd(Float fleteusd) {
		this.fleteusd = fleteusd;
	}

	public Float getFleteusd() {
		return this.fleteusd;
	}

	public void setIdagentecarga(String idagentecarga) {
		this.idagentecarga = idagentecarga;
	}

	public String getIdagentecarga() {
		return this.idagentecarga;
	}

	public void setIdcondventa(String idcondventa) {
		this.idcondventa = idcondventa;
	}

	public String getIdcondventa() {
		return this.idcondventa;
	}

	public void setIdlineaaerea(String idlineaaerea) {
		this.idlineaaerea = idlineaaerea;
	}

	public String getIdlineaaerea() {
		return this.idlineaaerea;
	}

	public void setNro_forma_pago(String nro_forma_pago) {
		this.nro_forma_pago = nro_forma_pago;
	}

	public String getNro_forma_pago() {
		return this.nro_forma_pago;
	}

	public void setNro_manual(String nro_manual) {
		this.nro_manual = nro_manual;
	}

	public String getNro_manual() {
		return this.nro_manual;
	}

	public void setIdclieprov_destino(String idclieprov_destino) {
		this.idclieprov_destino = idclieprov_destino;
	}

	public String getIdclieprov_destino() {
		return this.idclieprov_destino;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setNrobuckin(String nrobuckin) {
		this.nrobuckin = nrobuckin;
	}

	public String getNrobuckin() {
		return this.nrobuckin;
	}

	public void setContenedor(String contenedor) {
		this.contenedor = contenedor;
	}

	public String getContenedor() {
		return this.contenedor;
	}

	public void setPeso_real(Float peso_real) {
		this.peso_real = peso_real;
	}

	public Float getPeso_real() {
		return this.peso_real;
	}

	public void setNro_viaje(String nro_viaje) {
		this.nro_viaje = nro_viaje;
	}

	public String getNro_viaje() {
		return this.nro_viaje;
	}

	public void setNombre_nave(String nombre_nave) {
		this.nombre_nave = nombre_nave;
	}

	public String getNombre_nave() {
		return this.nombre_nave;
	}

	public void setIddocumento_pf(String iddocumento_pf) {
		this.iddocumento_pf = iddocumento_pf;
	}

	public String getIddocumento_pf() {
		return this.iddocumento_pf;
	}

	public void setSerie_pf(String serie_pf) {
		this.serie_pf = serie_pf;
	}

	public String getSerie_pf() {
		return this.serie_pf;
	}

	public void setNumero_pf(String numero_pf) {
		this.numero_pf = numero_pf;
	}

	public String getNumero_pf() {
		return this.numero_pf;
	}

	public void setFecha_pf(Date fecha_pf) {
		this.fecha_pf = fecha_pf;
	}

	public Date getFecha_pf() {
		return this.fecha_pf;
	}

	public void setGlosa_l(String glosa_l) {
		this.glosa_l = glosa_l;
	}

	public String getGlosa_l() {
		return this.glosa_l;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public String getAwb() {
		return this.awb;
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

	public void setIdestadobanco(String idestadobanco) {
		this.idestadobanco = idestadobanco;
	}

	public String getIdestadobanco() {
		return this.idestadobanco;
	}

	public void setIdtg30campaniaveh(Integer idtg30campaniaveh) {
		this.idtg30campaniaveh = idtg30campaniaveh;
	}

	public Integer getIdtg30campaniaveh() {
		return this.idtg30campaniaveh;
	}

	public void setIdbanco(String idbanco) {
		this.idbanco = idbanco;
	}

	public String getIdbanco() {
		return this.idbanco;
	}

	public void setOfrecio_seguro(String ofrecio_seguro) {
		this.ofrecio_seguro = ofrecio_seguro;
	}

	public String getOfrecio_seguro() {
		return this.ofrecio_seguro;
	}

	public void setCopropietario(Float copropietario) {
		this.copropietario = copropietario;
	}

	public Float getCopropietario() {
		return this.copropietario;
	}

	public void setIdtipocredito(String idtipocredito) {
		this.idtipocredito = idtipocredito;
	}

	public String getIdtipocredito() {
		return this.idtipocredito;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getCuota() {
		return this.cuota;
	}

	public void setVventapublico_conigv(Float vventapublico_conigv) {
		this.vventapublico_conigv = vventapublico_conigv;
	}

	public Float getVventapublico_conigv() {
		return this.vventapublico_conigv;
	}

	public void setImportedscto1_conigv(Float importedscto1_conigv) {
		this.importedscto1_conigv = importedscto1_conigv;
	}

	public Float getImportedscto1_conigv() {
		return this.importedscto1_conigv;
	}

	public void setImportedscto2_conigv(Float importedscto2_conigv) {
		this.importedscto2_conigv = importedscto2_conigv;
	}

	public Float getImportedscto2_conigv() {
		return this.importedscto2_conigv;
	}

	public void setImportedscto3_conigv(Float importedscto3_conigv) {
		this.importedscto3_conigv = importedscto3_conigv;
	}

	public Float getImportedscto3_conigv() {
		return this.importedscto3_conigv;
	}

	public void setAccesorios_conigv(Float accesorios_conigv) {
		this.accesorios_conigv = accesorios_conigv;
	}

	public Float getAccesorios_conigv() {
		return this.accesorios_conigv;
	}

	public void setIdcopropietario(String idcopropietario) {
		this.idcopropietario = idcopropietario;
	}

	public String getIdcopropietario() {
		return this.idcopropietario;
	}

	public void setIdtg10tipocotizacion(String idtg10tipocotizacion) {
		this.idtg10tipocotizacion = idtg10tipocotizacion;
	}

	public String getIdtg10tipocotizacion() {
		return this.idtg10tipocotizacion;
	}

	public void setIdtg30cotvent_web(Integer idtg30cotvent_web) {
		this.idtg30cotvent_web = idtg30cotvent_web;
	}

	public Integer getIdtg30cotvent_web() {
		return this.idtg30cotvent_web;
	}

	public void setCuotainicial(Float cuotainicial) {
		this.cuotainicial = cuotainicial;
	}

	public Float getCuotainicial() {
		return this.cuotainicial;
	}

	public void setIdctacte(String idctacte) {
		this.idctacte = idctacte;
	}

	public String getIdctacte() {
		return this.idctacte;
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

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the listDcotizacionventas
     */
    public List<Dcotizacionventas> getListDcotizacionventas() {
        return listDcotizacionventas;
    }

    /**
     * @param listDcotizacionventas the listDcotizacionventas to set
     */
    public void setListDcotizacionventas(List<Dcotizacionventas> listDcotizacionventas) {
        this.listDcotizacionventas = listDcotizacionventas;
    }

}