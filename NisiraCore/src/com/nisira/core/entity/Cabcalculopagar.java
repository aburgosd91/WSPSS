package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("CABCALCULOPAGAR")
@Tabla(nombre = "CABCALCULOPAGAR")
public class Cabcalculopagar implements Serializable {
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCABCALCULOPAGAR")
	@ClavePrimaria
	@Columna
	private String idcabcalculopagar;
        @XStreamAlias("IDEMISOR")
	@Columna
	private String idemisor;
        @XStreamAlias("IDSUCURSAL")
	@Columna
	private String idsucursal;
        @XStreamAlias("IDALMACEN")
	@Columna
	private String idalmacen;
        @XStreamAlias("IDDOCUMENTO")
	@Columna
	private String iddocumento;
        @XStreamAlias("SERIE")
	@Columna
	private String serie;
        @XStreamAlias("NUMERO")
	@Columna
	private String numero;
        @XStreamAlias("PERIODO")
	@Columna
	private String periodo;
        @XStreamAlias("FECHA")
	@Columna
	private Date fecha;
        @XStreamAlias("IDESTADO")
	@Columna
	private String idestado;
        @XStreamAlias("FINICIO")
	@Columna
	private Date finicio;
        @XStreamAlias("FFIN")
	@Columna
	private Date ffin;
        @XStreamAlias("IDUSUARIO")
	@Columna
	private String idusuario;
        @XStreamAlias("TIPO")
	@Columna
	private String tipo;
        private String usuario;
        private String emisor;
        private String sucursal;
        private String almacen;
        private String estado;
        private String mes;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcabcalculopagar(String idcabcalculopagar) {
		this.idcabcalculopagar = idcabcalculopagar;
	}

	public String getIdcabcalculopagar() {
		return this.idcabcalculopagar;
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

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}

	public String getIdestado() {
		return this.idestado;
	}

	public void setFinicio(Date finicio) {
		this.finicio = finicio;
	}

	public Date getFinicio() {
		return this.finicio;
	}

	public void setFfin(Date ffin) {
		this.ffin = ffin;
	}

	public Date getFfin() {
		return this.ffin;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}



	/* Sets & Gets FK*/

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the almacen
     */
    public String getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
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

}