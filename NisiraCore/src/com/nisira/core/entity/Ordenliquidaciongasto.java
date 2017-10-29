package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("ORDENLIQUIDACIONGASTO")
@Tabla(nombre = "ORDENLIQUIDACIONGASTO")
public class Ordenliquidaciongasto  implements Serializable{
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDORDEN")
	@ClavePrimaria
	@Columna
	private String idorden;
        @XStreamAlias("IDEMISOR")
	@Columna
	private String idemisor;
        @XStreamAlias("PERIODO")
	@Columna
	private String periodo;
        @XStreamAlias("FECHAREGISTRO")
	@Columna
	private Date fecharegistro;
        @XStreamAlias("IDSUCURSAL")
	@Columna
	private String idsucursal;
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
        @XStreamAlias("TCAMBIO")
	@Columna
	private Float tcambio;
        @XStreamAlias("IDCLIEPROV")
	@Columna
	private String idclieprov;
        @XStreamAlias("DIRECCION")
	@Columna
	private String direccion;
        @XStreamAlias("RUC")
	@Columna
	private String ruc;
        @XStreamAlias("RAZONSOCIAL")
	@Columna
	private String razonsocial;
        @XStreamAlias("IDREGIMEN")
	@Columna
	private String idregimen;
        @XStreamAlias("IDMONEDA")
	@Columna
	private String idmoneda;
        @XStreamAlias("TCMONEDA")
	@Columna
	private Float tcmoneda;
        @XStreamAlias("IDTIPOMOV")
	@Columna
	private String idtipomov;
        @XStreamAlias("IDFPAGO")
	@Columna
	private String idfpago;
        @XStreamAlias("IDAREA")
	@Columna
	private String idarea;
        @XStreamAlias("GLOSA")
	@Columna
	private String glosa;
        @XStreamAlias("VVENTA")
	@Columna
	private Float vventa;
        @XStreamAlias("INAFECTO")
	@Columna
	private Float inafecto;
        @XStreamAlias("OTROS")
	@Columna
	private Float otros;
        @XStreamAlias("IMPUESTO")
	@Columna
	private Float impuesto;
        @XStreamAlias("pimpuesto")
	@Columna
	private Float pimpuesto;
        @XStreamAlias("DESCUENTO")
	@Columna
	private Float descuento;
        @XStreamAlias("PDESCUENTO")
	@Columna
	private Float pdescuento;
        @XStreamAlias("DESCUENTODOC")
	@Columna
	private Float descuentodoc;
        @XStreamAlias("redondeo")
	@Columna
	private Float redondeo;
        @XStreamAlias("IMPORTE")
	@Columna
	private Float importe;
        @XStreamAlias("IMPORTEMOF")
	@Columna
	private Float importemof;
        @XStreamAlias("IMPORTEMEX")
	@Columna
	private Float importemex;
        @XStreamAlias("IDESTADO")
	@Columna
	private String idestado;
        @XStreamAlias("SINCRONIZA")
	@Columna
	private String sincroniza;
        @XStreamAlias("IGV")
	@Columna
	private Float igv;
        @XStreamAlias("IDUSUARIO")
	@Columna
	private String idusuario;
        @XStreamAlias("VENTANA")
	@Columna
	private String ventana;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("IMPRESO")
	@Columna
	private Float impreso;
        @XStreamAlias("IDMEDIOPAGO")
	@Columna
	private String idmediopago;
        @XStreamAlias("IDCONTACTO")
	@Columna
	private String idcontacto;
        @XStreamAlias("CERTIFTRANSPORTE")
	@Columna
	private String certiftransporte;
        @XStreamAlias("CERTIFTRANSPORTE1")
	@Columna
	private String certiftransporte1;
        @XStreamAlias("IDVEHICULO")
	@Columna
	private String idvehiculo;
        @XStreamAlias("PLACA")
	@Columna
	private String placa;
        @XStreamAlias("PLACA1")
	@Columna
	private String placa1;
        @XStreamAlias("MARCA")
	@Columna
	private String marca;
        @XStreamAlias("MARCA1")
	@Columna
	private String marca1;
        @XStreamAlias("IDCHOFER")
	@Columna
	private String idchofer;
        @XStreamAlias("CHOFER")
	@Columna
	private String chofer;
        @XStreamAlias("BREVETE")
	@Columna
	private String brevete;
        @XStreamAlias("FECHATRASLADO")
	@Columna
	private Date fechatraslado;
        @XStreamAlias("RAZONSOCIAL2")
	@Columna
	private String razonsocial2;
        @XStreamAlias("GLOSA1")
	@Columna
	private String glosa1;
        @XStreamAlias("CONDICIONSUNAT")
	@Columna
	private String condicionsunat;
        @XStreamAlias("ESTADOSUNAT")
	@Columna
	private String estadosunat;
        private String estado;
        private String moneda;
        private String sucursal;
        private String emisor;
        private String mes;
        private String area;
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

	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}

	public String getIdemisor() {
		return this.idemisor;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
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

	public void setTcambio(Float tcambio) {
		this.tcambio = tcambio;
	}

	public Float getTcambio() {
		return this.tcambio;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRazonsocial() {
		return this.razonsocial;
	}

	public void setIdregimen(String idregimen) {
		this.idregimen = idregimen;
	}

	public String getIdregimen() {
		return this.idregimen;
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

	public void setIdtipomov(String idtipomov) {
		this.idtipomov = idtipomov;
	}

	public String getIdtipomov() {
		return this.idtipomov;
	}

	public void setIdfpago(String idfpago) {
		this.idfpago = idfpago;
	}

	public String getIdfpago() {
		return this.idfpago;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setVventa(Float vventa) {
		this.vventa = vventa;
	}

	public Float getVventa() {
		return this.vventa;
	}

	public void setInafecto(Float inafecto) {
		this.inafecto = inafecto;
	}

	public Float getInafecto() {
		return this.inafecto;
	}

	public void setOtros(Float otros) {
		this.otros = otros;
	}

	public Float getOtros() {
		return this.otros;
	}

	public void setImpuesto(Float impuesto) {
		this.impuesto = impuesto;
	}

	public Float getImpuesto() {
		return this.impuesto;
	}

	public void setPimpuesto(Float pimpuesto) {
		this.pimpuesto = pimpuesto;
	}

	public Float getPimpuesto() {
		return this.pimpuesto;
	}

	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}

	public Float getDescuento() {
		return this.descuento;
	}

	public void setPdescuento(Float pdescuento) {
		this.pdescuento = pdescuento;
	}

	public Float getPdescuento() {
		return this.pdescuento;
	}

	public void setDescuentodoc(Float descuentodoc) {
		this.descuentodoc = descuentodoc;
	}

	public Float getDescuentodoc() {
		return this.descuentodoc;
	}

	public void setRedondeo(Float redondeo) {
		this.redondeo = redondeo;
	}

	public Float getRedondeo() {
		return this.redondeo;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public Float getImporte() {
		return this.importe;
	}

	public void setImportemof(Float importemof) {
		this.importemof = importemof;
	}

	public Float getImportemof() {
		return this.importemof;
	}

	public void setImportemex(Float importemex) {
		this.importemex = importemex;
	}

	public Float getImportemex() {
		return this.importemex;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setIgv(Float igv) {
		this.igv = igv;
	}

	public Float getIgv() {
		return this.igv;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setImpreso(Float impreso) {
		this.impreso = impreso;
	}

	public Float getImpreso() {
		return this.impreso;
	}

	public void setIdmediopago(String idmediopago) {
		this.idmediopago = idmediopago;
	}

	public String getIdmediopago() {
		return this.idmediopago;
	}

	public void setIdcontacto(String idcontacto) {
		this.idcontacto = idcontacto;
	}

	public String getIdcontacto() {
		return this.idcontacto;
	}

	public void setCertiftransporte(String certiftransporte) {
		this.certiftransporte = certiftransporte;
	}

	public String getCertiftransporte() {
		return this.certiftransporte;
	}

	public void setCertiftransporte1(String certiftransporte1) {
		this.certiftransporte1 = certiftransporte1;
	}

	public String getCertiftransporte1() {
		return this.certiftransporte1;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca1(String placa1) {
		this.placa1 = placa1;
	}

	public String getPlaca1() {
		return this.placa1;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca1(String marca1) {
		this.marca1 = marca1;
	}

	public String getMarca1() {
		return this.marca1;
	}

	public void setIdchofer(String idchofer) {
		this.idchofer = idchofer;
	}

	public String getIdchofer() {
		return this.idchofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getChofer() {
		return this.chofer;
	}

	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}

	public String getBrevete() {
		return this.brevete;
	}

	public void setFechatraslado(Date fechatraslado) {
		this.fechatraslado = fechatraslado;
	}

	public Date getFechatraslado() {
		return this.fechatraslado;
	}

	public void setRazonsocial2(String razonsocial2) {
		this.razonsocial2 = razonsocial2;
	}

	public String getRazonsocial2() {
		return this.razonsocial2;
	}

	public void setGlosa1(String glosa1) {
		this.glosa1 = glosa1;
	}

	public String getGlosa1() {
		return this.glosa1;
	}

	public void setCondicionsunat(String condicionsunat) {
		this.condicionsunat = condicionsunat;
	}

	public String getCondicionsunat() {
		return this.condicionsunat;
	}

	public void setEstadosunat(String estadosunat) {
		this.estadosunat = estadosunat;
	}

	public String getEstadosunat() {
		return this.estadosunat;
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
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the emisor
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * @param emisor the emisor to set
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

}
