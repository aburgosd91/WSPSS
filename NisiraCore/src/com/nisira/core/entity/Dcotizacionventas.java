package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "DCOTIZACIONVENTAS")
public class Dcotizacionventas {
	@Columna
	private String idempresa;
	@Columna
	private String idcotizacionv;
	@Columna
	private String item;
	@Columna
	private String idcompra;
	@Columna
	private String itemcotizacion;
	@Columna
	private String idproducto;
	@Columna
	private String descripcion;
	@Columna
	private String idmedida;
	@Columna
	private Float cantidad;
	@Columna
	private Float precio;
	@Columna
	private Float descuento;
	@Columna
	private Float importe;
	@Columna
	private Float es_afecto;
	@Columna
	private Float porcentajedscto1;
	@Columna
	private Float porcentajedscto2;
	@Columna
	private Float porcentajedscto3;
	@Columna
	private Float impuesto_i;
	@Columna
	private Float impuesto;
	@Columna
	private Float importedscto1;
	@Columna
	private Float importedscto2;
	@Columna
	private Float importedscto3;
	@Columna
	private Float subtotalsindscto;
	@Columna
	private Float subtotalcondscto;
	@Columna
	private String idestadoproducto;
	@Columna
	private Float descuento_total;
	@Columna
	private String destino;
	@Columna
	private String idestado;
	@Columna
	private String idestadoold;
	@Columna
	private String observaciones;
	@Columna
	private String anniofabricacion;
	@Columna
	private String clase;
	@Columna
	private String carroceria;
	@Columna
	private String transmision;
	@Columna
	private String tipomotor;
	@Columna
	private String combustible;
	@Columna
	private String idreferencia;
	@Columna
	private String itemref;
	@Columna
	private String tablaref;
	@Columna
	private String documentoref;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idconsumidor;
	@Columna
	private String idplantillacv;
	@Columna
	private Date parafecha;
	@Columna
	private Float dias;
	@Columna
	private String idserie;
	@Columna
	private String idcolor;
	@Columna
	private String idsucursal;
	@Columna
	private String idalmacen;
	@Columna
	private String calibremm;
	@Columna
	private Float factorce;
	@Columna
	private String idinsumo;
	@Columna
	private String idpresentacion;
	@Columna
	private String idtalla;
	@Columna
	private String largo;
	@Columna
	private Float total_ce;
	@Columna
	private Integer undxphl;
	@Columna
	private Float descuento_i;
	@Columna
	private Float importe_isc;
	@Columna
	private Float accesorios_conigv;
	@Columna
	private Float importedscto1_conigv;
	@Columna
	private Float importedscto2_conigv;
	@Columna
	private Float importedscto3_conigv;
	@Columna
	private Float importedscto_importador_real;
	@Columna
	private Float importedscto_maxpermitido;
	@Columna
	private Float vventapublico_conigv;
	@Columna
	private String anniomodelo;
	@Columna
	private Integer idtg20versionveh;
	@Columna
	private Float importeaccesorios;
        private String producto;


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

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setIdcompra(String idcompra) {
		this.idcompra = idcompra;
	}

	public String getIdcompra() {
		return this.idcompra;
	}

	public void setItemcotizacion(String itemcotizacion) {
		this.itemcotizacion = itemcotizacion;
	}

	public String getItemcotizacion() {
		return this.itemcotizacion;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getPrecio() {
		return this.precio;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getDescuento() {
		return this.descuento;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getImporte() {
		return this.importe;
	}

	public void setEs_afecto(Float es_afecto) {
		this.es_afecto = es_afecto;
	}

	public Float getEs_afecto() {
		return this.es_afecto;
	}

	public void setPorcentajedscto1(Float porcentajedscto1) {
		this.porcentajedscto1 = porcentajedscto1;
	}

	public Float getPorcentajedscto1() {
		return this.porcentajedscto1;
	}

	public void setPorcentajedscto2(Float porcentajedscto2) {
		this.porcentajedscto2 = porcentajedscto2;
	}

	public Float getPorcentajedscto2() {
		return this.porcentajedscto2;
	}

	public void setPorcentajedscto3(Float porcentajedscto3) {
		this.porcentajedscto3 = porcentajedscto3;
	}

	public Float getPorcentajedscto3() {
		return this.porcentajedscto3;
	}

	public void setImpuesto_i(Float impuesto_i) {
		this.impuesto_i = impuesto_i;
	}

	public Float getImpuesto_i() {
		return this.impuesto_i;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImportedscto1(Float importedscto1) {
		this.importedscto1 = importedscto1;
	}

	public Float getImportedscto1() {
		return this.importedscto1;
	}

	public void setImportedscto2(Float importedscto2) {
		this.importedscto2 = importedscto2;
	}

	public Float getImportedscto2() {
		return this.importedscto2;
	}

	public void setImportedscto3(Float importedscto3) {
		this.importedscto3 = importedscto3;
	}

	public Float getImportedscto3() {
		return this.importedscto3;
	}

	public void setSubtotalsindscto(Float subtotalsindscto) {
		this.subtotalsindscto = subtotalsindscto;
	}

	public Float getSubtotalsindscto() {
		return this.subtotalsindscto;
	}

	public void setSubtotalcondscto(Float subtotalcondscto) {
		this.subtotalcondscto = subtotalcondscto;
	}

	public Float getSubtotalcondscto() {
		return this.subtotalcondscto;
	}

	public void setIdestadoproducto(String idestadoproducto) {
		this.idestadoproducto = idestadoproducto;
	}

	public String getIdestadoproducto() {
		return this.idestadoproducto;
	}

	public void setDescuento_total(Float descuento_total) {
		this.descuento_total = descuento_total;
	}

	public Float getDescuento_total() {
		return this.descuento_total;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDestino() {
		return this.destino;
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

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setAnniofabricacion(String anniofabricacion) {
		this.anniofabricacion = anniofabricacion;
	}

	public String getAnniofabricacion() {
		return this.anniofabricacion;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getClase() {
		return this.clase;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getCarroceria() {
		return this.carroceria;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTransmision() {
		return this.transmision;
	}

	public void setTipomotor(String tipomotor) {
		this.tipomotor = tipomotor;
	}

	public String getTipomotor() {
		return this.tipomotor;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setIdreferencia(String idreferencia) {
		this.idreferencia = idreferencia;
	}

	public String getIdreferencia() {
		return this.idreferencia;
	}

	public void setItemref(String itemref) {
		this.itemref = itemref;
	}

	public String getItemref() {
		return this.itemref;
	}

	public void setTablaref(String tablaref) {
		this.tablaref = tablaref;
	}

	public String getTablaref() {
		return this.tablaref;
	}

	public void setDocumentoref(String documentoref) {
		this.documentoref = documentoref;
	}

	public String getDocumentoref() {
		return this.documentoref;
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

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setIdplantillacv(String idplantillacv) {
		this.idplantillacv = idplantillacv;
	}

	public String getIdplantillacv() {
		return this.idplantillacv;
	}

	public void setParafecha(Date parafecha) {
		this.parafecha = parafecha;
	}

	public Date getParafecha() {
		return this.parafecha;
	}

	public void setDias(Float dias) {
		this.dias = dias;
	}

	public Float getDias() {
		return this.dias;
	}

	public void setIdserie(String idserie) {
		this.idserie = idserie;
	}

	public String getIdserie() {
		return this.idserie;
	}

	public void setIdcolor(String idcolor) {
		this.idcolor = idcolor;
	}

	public String getIdcolor() {
		return this.idcolor;
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

	public void setCalibremm(String calibremm) {
		this.calibremm = calibremm;
	}

	public String getCalibremm() {
		return this.calibremm;
	}

	public void setFactorce(Float factorce) {
		this.factorce = factorce;
	}

	public Float getFactorce() {
		return this.factorce;
	}

	public void setIdinsumo(String idinsumo) {
		this.idinsumo = idinsumo;
	}

	public String getIdinsumo() {
		return this.idinsumo;
	}

	public void setIdpresentacion(String idpresentacion) {
		this.idpresentacion = idpresentacion;
	}

	public String getIdpresentacion() {
		return this.idpresentacion;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}

	public String getIdtalla() {
		return this.idtalla;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

	public String getLargo() {
		return this.largo;
	}

	public void setTotal_ce(Float total_ce) {
		this.total_ce = total_ce;
	}

	public Float getTotal_ce() {
		return this.total_ce;
	}

	public void setUndxphl(Integer undxphl) {
		this.undxphl = undxphl;
	}

	public Integer getUndxphl() {
		return this.undxphl;
	}

	public void setDescuento_i(Float descuento_i) {
		this.descuento_i = descuento_i;
	}

	public Float getDescuento_i() {
		return this.descuento_i;
	}

	public void setImporte_isc(Float importe_isc) {
		this.importe_isc = importe_isc;
	}

	public Float getImporte_isc() {
		return this.importe_isc;
	}

	public void setAccesorios_conigv(Float accesorios_conigv) {
		this.accesorios_conigv = accesorios_conigv;
	}

	public Float getAccesorios_conigv() {
		return this.accesorios_conigv;
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

	public void setImportedscto_importador_real(Float importedscto_importador_real) {
		this.importedscto_importador_real = importedscto_importador_real;
	}

	public Float getImportedscto_importador_real() {
		return this.importedscto_importador_real;
	}

	public void setImportedscto_maxpermitido(Float importedscto_maxpermitido) {
		this.importedscto_maxpermitido = importedscto_maxpermitido;
	}

	public Float getImportedscto_maxpermitido() {
		return this.importedscto_maxpermitido;
	}

	public void setVventapublico_conigv(Float vventapublico_conigv) {
		this.vventapublico_conigv = vventapublico_conigv;
	}

	public Float getVventapublico_conigv() {
		return this.vventapublico_conigv;
	}

	public void setAnniomodelo(String anniomodelo) {
		this.anniomodelo = anniomodelo;
	}

	public String getAnniomodelo() {
		return this.anniomodelo;
	}

	public void setIdtg20versionveh(Integer idtg20versionveh) {
		this.idtg20versionveh = idtg20versionveh;
	}

	public Integer getIdtg20versionveh() {
		return this.idtg20versionveh;
	}

	public void setImporteaccesorios(Float importeaccesorios) {
		this.importeaccesorios = importeaccesorios;
	}

	public Float getImporteaccesorios() {
		return this.importeaccesorios;
	}



	/* Sets & Gets FK*/

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

}