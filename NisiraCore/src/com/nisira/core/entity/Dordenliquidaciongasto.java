package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("DORDENLIQUIDACIONGASTO")
@Tabla(nombre = "DORDENLIQUIDACIONGASTO")
public class Dordenliquidaciongasto implements Serializable,Cloneable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDORDEN")
	@ClavePrimaria
	@Columna
	private String idorden;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("GLOSA")
	@Columna
	private String glosa;
        @XStreamAlias("IDCONCEPTO")
	@Columna
	private String idconcepto;
        @XStreamAlias("IDCUENTA")
	@Columna
	private String idcuenta;
        @XStreamAlias("IDCCOSTO")
	@Columna
	private String idccosto;
        @XStreamAlias("IDTIPOMOV")
	@Columna
	private String idtipomov;
        @XStreamAlias("IDCLIEPROV")
	@Columna
	private String idclieprov;
        @XStreamAlias("IDDOCUMENTO")
	@Columna
	private String iddocumento;
        @XStreamAlias("SERIE")
	@Columna
	private String serie;
        @XStreamAlias("NUMERO")
	@Columna
	private String numero;
        @XStreamAlias("FECHA")
	@Columna
	private Date fecha;
        @XStreamAlias("IDDESTINO")
	@Columna
	private String iddestino;
        @XStreamAlias("IDMONEDA")
	@Columna
	private String idmoneda;
        @XStreamAlias("TCMONEDA")
	@Columna
	private Float tcmoneda;
        @XStreamAlias("TCAMBIO")
	@Columna
	private Float tcambio;
        @XStreamAlias("IDREGIMEN")
	@Columna
	private String idregimen;
        @XStreamAlias("AFECTO")
	@Columna
	private Float afecto;
        @XStreamAlias("INAFECTO")
	@Columna
	private Float inafecto;
        @XStreamAlias("PIMPUESTO")
	@Columna
	private Float pimpuesto;
        @XStreamAlias("IMPUESTO")
	@Columna
	private Float impuesto;
        @XStreamAlias("IMPORTE")
	@Columna
	private Float importe;
        @XStreamAlias("OTROS")
	@Columna
	private Float otros;
        @XStreamAlias("IDCONSUMIDOR")
	@Columna
	private String idconsumidor;
        @XStreamAlias("NUMERO_RCOMPRAS")
	@Columna
	private String numero_rcompras;
        @XStreamAlias("IDMEDIDA")
	@Columna
	private String idmedida;
        @XStreamAlias("IDPRODUCTO")
	@Columna
	private String idproducto;
        @XStreamAlias("ITEMALMACEN")
	@Columna
	private String itemalmacen;
        @XStreamAlias("PRODUCTO")
	@Columna
	private String producto;
        @XStreamAlias("VENTANA")
	@Columna
	private String ventana;
        @XStreamAlias("CANTIDAD")
	@Columna
	private Float cantidad;
        @XStreamAlias("IDSIEMBRA")
	@Columna
	private String idsiembra;
        @XStreamAlias("IDCAMPANA")
	@Columna
	private String idcampana;
        @XStreamAlias("IDORDENPRODUCCION")
	@Columna
	private String idordenproduccion;
        @XStreamAlias("IDLOTEPRODUCCION")
	@Columna
	private String idloteproduccion;
        @XStreamOmitField
        private String documento;/*proveedor*/
        @XStreamOmitField
        private String razonsocial/*razon social*/;
        @XStreamOmitField
        private String conceptocuenta;
        @XStreamOmitField
        private String destinoadquisicion;
        @XStreamOmitField
        private String concepto;
        @XStreamOmitField
        private String consumidor;
        /*componentes de autocompletado*/
        @XStreamOmitField
        private Clieprov selectProveedor;
        @XStreamOmitField
        private Tipogasto SelectTipogasto;
        @XStreamOmitField
        private Documentos selectDocumentos;
        @XStreamOmitField
        private Consumidor selectConsumidor;
        @XStreamOmitField
        private Concepto_cuenta selectConcepto_cuenta;
        @XStreamOmitField
        private Destinoadquisicion selectDestinoadquisicion;
        @XStreamOmitField
        private boolean habilitar_baseimponible;
        @XStreamOmitField
        private boolean habilitar_inafecto;
	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdorden(String idorden) {
		this.idorden = idorden;
	}

	public String getIdorden() {
		return this.idorden;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setIdconcepto(String idconcepto) {
		this.idconcepto = idconcepto;
	}

	public String getIdconcepto() {
		return this.idconcepto;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdccosto(String idccosto) {
		this.idccosto = idccosto;
	}

	public String getIdccosto() {
		return this.idccosto;
	}

	public void setIdtipomov(String idtipomov) {
		this.idtipomov = idtipomov;
	}

	public String getIdtipomov() {
		return this.idtipomov;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
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

	public void setIddestino(String iddestino) {
		this.iddestino = iddestino;
	}

	public String getIddestino() {
		return this.iddestino;
	}

	public void setIdmoneda(String idmoneda) {
		this.idmoneda = idmoneda;
	}

	public String getIdmoneda() {
		return this.idmoneda;
	}

	public void setTcmoneda(Float tcmoneda) {
		this.tcmoneda = tcmoneda;
	}

	public Float getTcmoneda() {
		return this.tcmoneda;
	}

	public void setTcambio(Float tcambio) {
		this.tcambio = tcambio;
	}

	public Float getTcambio() {
		return this.tcambio;
	}

	public void setIdregimen(String idregimen) {
		this.idregimen = idregimen;
	}

	public String getIdregimen() {
		return this.idregimen;
	}

	public void setAfecto(Float afecto) {
		this.afecto = afecto;
	}

	public Float getAfecto() {
		return this.afecto;
	}

	public void setInafecto(Float inafecto) {
		this.inafecto = inafecto;
	}

	public Float getInafecto() {
		return this.inafecto;
	}

	public void setPimpuesto(Float pimpuesto) {
		this.pimpuesto = pimpuesto;
	}

	public Float getPimpuesto() {
		return this.pimpuesto;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getImporte() {
		return this.importe;
	}

	public void setOtros(Float otros) {
		this.otros = otros;
	}

	public Float getOtros() {
		return this.otros;
	}

	public void setIdconsumidor(String idconsumidor) {
		this.idconsumidor = idconsumidor;
	}

	public String getIdconsumidor() {
		return this.idconsumidor;
	}

	public void setNumero_rcompras(String numero_rcompras) {
		this.numero_rcompras = numero_rcompras;
	}

	public String getNumero_rcompras() {
		return this.numero_rcompras;
	}

	public void setIdmedida(String idmedida) {
		this.idmedida = idmedida;
	}

	public String getIdmedida() {
		return this.idmedida;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setItemalmacen(String itemalmacen) {
		this.itemalmacen = itemalmacen;
	}

	public String getItemalmacen() {
		return this.itemalmacen;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public void setIdsiembra(String idsiembra) {
		this.idsiembra = idsiembra;
	}

	public String getIdsiembra() {
		return this.idsiembra;
	}

	public void setIdcampana(String idcampana) {
		this.idcampana = idcampana;
	}

	public String getIdcampana() {
		return this.idcampana;
	}

	public void setIdordenproduccion(String idordenproduccion) {
		this.idordenproduccion = idordenproduccion;
	}

	public String getIdordenproduccion() {
		return this.idordenproduccion;
	}

	public void setIdloteproduccion(String idloteproduccion) {
		this.idloteproduccion = idloteproduccion;
	}

	public String getIdloteproduccion() {
		return this.idloteproduccion;
	}



	/* Sets & Gets FK*/

    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the razonsocial
     */
    public String getRazonsocial() {
        return razonsocial;
    }

    /**
     * @param razonsocial the razonsocial to set
     */
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    /**
     * @return the conceptocuenta
     */
    public String getConceptocuenta() {
        return conceptocuenta;
    }

    /**
     * @param conceptocuenta the conceptocuenta to set
     */
    public void setConceptocuenta(String conceptocuenta) {
        this.conceptocuenta = conceptocuenta;
    }

    /**
     * @return the destinoadquisicion
     */
    public String getDestinoadquisicion() {
        return destinoadquisicion;
    }

    /**
     * @param destinoadquisicion the destinoadquisicion to set
     */
    public void setDestinoadquisicion(String destinoadquisicion) {
        this.destinoadquisicion = destinoadquisicion;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the selectProveedor
     */
    public Clieprov getSelectProveedor() {
        return selectProveedor;
    }

    /**
     * @param selectProveedor the selectProveedor to set
     */
    public void setSelectProveedor(Clieprov selectProveedor) {
        this.selectProveedor = selectProveedor;
    }

    /**
     * @return the SelectTipogasto
     */
    public Tipogasto getSelectTipogasto() {
        return SelectTipogasto;
    }

    /**
     * @param SelectTipogasto the SelectTipogasto to set
     */
    public void setSelectTipogasto(Tipogasto SelectTipogasto) {
        this.SelectTipogasto = SelectTipogasto;
    }

    /**
     * @return the selectDocumentos
     */
    public Documentos getSelectDocumentos() {
        return selectDocumentos;
    }

    /**
     * @param selectDocumentos the selectDocumentos to set
     */
    public void setSelectDocumentos(Documentos selectDocumentos) {
        this.selectDocumentos = selectDocumentos;
    }

    /**
     * @return the selectConsumidor
     */
    public Consumidor getSelectConsumidor() {
        return selectConsumidor;
    }

    /**
     * @param selectConsumidor the selectConsumidor to set
     */
    public void setSelectConsumidor(Consumidor selectConsumidor) {
        this.selectConsumidor = selectConsumidor;
    }

    /**
     * @return the consumidor
     */
    public String getConsumidor() {
        return consumidor;
    }

    /**
     * @param consumidor the consumidor to set
     */
    public void setConsumidor(String consumidor) {
        this.consumidor = consumidor;
    }

    /**
     * @return the selectDestinoadquisicion
     */
    public Destinoadquisicion getSelectDestinoadquisicion() {
        return selectDestinoadquisicion;
    }

    /**
     * @param selectDestinoadquisicion the selectDestinoadquisicion to set
     */
    public void setSelectDestinoadquisicion(Destinoadquisicion selectDestinoadquisicion) {
        this.selectDestinoadquisicion = selectDestinoadquisicion;
    }

    /**
     * @return the habilitar_baseimponible
     */
    public boolean isHabilitar_baseimponible() {
        return habilitar_baseimponible;
    }

    /**
     * @param habilitar_baseimponible the habilitar_baseimponible to set
     */
    public void setHabilitar_baseimponible(boolean habilitar_baseimponible) {
        this.habilitar_baseimponible = habilitar_baseimponible;
    }

    /**
     * @return the habilitar_inafecto
     */
    public boolean isHabilitar_inafecto() {
        return habilitar_inafecto;
    }

    /**
     * @param habilitar_inafecto the habilitar_inafecto to set
     */
    public void setHabilitar_inafecto(boolean habilitar_inafecto) {
        this.habilitar_inafecto = habilitar_inafecto;
    }

    /**
     * @return the selectConcepto_cuenta
     */
    public Concepto_cuenta getSelectConcepto_cuenta() {
        return selectConcepto_cuenta;
    }

    /**
     * @param selectConcepto_cuenta the selectConcepto_cuenta to set
     */
    public void setSelectConcepto_cuenta(Concepto_cuenta selectConcepto_cuenta) {
        this.selectConcepto_cuenta = selectConcepto_cuenta;
    }
    
}