package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("ORDENSERVICIOCLIENTE")
@Tabla(nombre = "ORDENSERVICIOCLIENTE")
public class Ordenserviciocliente {
        @XStreamAlias("IDBASEDATOS")
        private String idbasedatos;
	@Columna
        @XStreamAlias("IDEMPRESA")
	private String idempresa;
	@Columna
        @XStreamAlias("IDORDENSERVICIO")
	private String idordenservicio;
	@Columna
        @XStreamAlias("IDDOCUMENTO")
	private String iddocumento;
	@Columna
        @XStreamAlias("SERIE")
	private String serie;
	@Columna
        @XStreamAlias("NUMERO")
	private String numero;
	@Columna
        @XStreamAlias("NROMANUAL")
	private String nromanual;
	@Columna
        @XStreamAlias("IDCLIEPROV")
	private String idclieprov;
	@Columna
        @XStreamAlias("FECHA")
	private Date fecha;
	@Columna
        @XStreamAlias("TIPO_SERVICIO")
	private String tipo_servicio;
	@Columna
        @XStreamAlias("AMBITO_SERVICIO")
	private String ambito_servicio;
	@Columna
        @XStreamAlias("IDESTADO")
	private String idestado;
	@Columna
        @XStreamAlias("SINCRONIZA")
	private String sincroniza;
	@Columna
        @XStreamAlias("FECHACREACION")
	private Date fechacreacion;
	@Columna
        @XStreamAlias("NROCONTENEDOR")
	private String nrocontenedor;
	@Columna
        @XStreamAlias("NROPRECINTO")
	private String nroprecinto;
	@Columna
        @XStreamAlias("NRO_OSERVICIO")
	private String nro_oservicio;
        private String idcotizacionv;
        private String razonsocial;

	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
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

	public void setNromanual(String nromanual) {
		this.nromanual = nromanual;
	}

	public String getNromanual() {
		return this.nromanual;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public String getTipo_servicio() {
		return this.tipo_servicio;
	}

	public void setAmbito_servicio(String ambito_servicio) {
		this.ambito_servicio = ambito_servicio;
	}

	public String getAmbito_servicio() {
		return this.ambito_servicio;
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

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setNrocontenedor(String nrocontenedor) {
		this.nrocontenedor = nrocontenedor;
	}

	public String getNrocontenedor() {
		return this.nrocontenedor;
	}

	public void setNroprecinto(String nroprecinto) {
		this.nroprecinto = nroprecinto;
	}

	public String getNroprecinto() {
		return this.nroprecinto;
	}

	public void setNro_oservicio(String nro_oservicio) {
		this.nro_oservicio = nro_oservicio;
	}

	public String getNro_oservicio() {
		return this.nro_oservicio;
	}



	/* Sets & Gets FK*/

    /**
     * @return the idcotizacionv
     */
    public String getIdcotizacionv() {
        return idcotizacionv;
    }

    /**
     * @param idcotizacionv the idcotizacionv to set
     */
    public void setIdcotizacionv(String idcotizacionv) {
        this.idcotizacionv = idcotizacionv;
    }

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

}