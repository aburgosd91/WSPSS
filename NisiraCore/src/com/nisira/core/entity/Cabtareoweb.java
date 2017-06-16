package com.nisira.core.entity;

import com.google.gson.annotations.SerializedName;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "CABTAREOWEB")
@XStreamAlias("CABTAREOWEB")
public class Cabtareoweb  implements Serializable {

        @SerializedName("idbasedatos") 
	@XStreamAlias("IDBASEDATOS") 
	private String idbasedatos = "" ;
        @SerializedName("IDEMPRESA") 
	@XStreamAlias("IDEMPRESA") 
	@ClavePrimaria
	@Columna
	private String idempresa;
        @SerializedName("IDCABTAREOWEB") 
	@XStreamAlias("IDCABTAREOWEB")
	@ClavePrimaria
	@Columna
	private String idcabtareoweb;
        @SerializedName("IDEMISOR") 
	@XStreamAlias("IDEMISOR")
	@Columna
	private String idemisor;
        @SerializedName("IDSUCURSAL") 
	@XStreamAlias("IDSUCURSAL")
	@Columna
	private String idsucursal;
        @SerializedName("IDALMACEN") 
	@XStreamAlias("IDALMACEN")
	@Columna
	private String idalmacen;
        @SerializedName("IDDOCUMENTO") 
	@XStreamAlias("IDDOCUMENTO")
	@Columna
	private String iddocumento;
        @SerializedName("SERIE") 
	@XStreamAlias("SERIE")
	@Columna
	private String serie;
        @SerializedName("NUMERO") 
	@XStreamAlias("NUMERO")
	@Columna
	private String numero;
        @SerializedName("PERIODO") 
	@XStreamAlias("PERIODO")
	@Columna
	private String periodo;
        @SerializedName("FECHA") 
	@XStreamAlias("FECHA")
	@Columna
	private Date fecha;
        @SerializedName("IDESTADO") 
	@XStreamAlias("IDESTADO")
	@Columna
	private String idestado;
        @SerializedName("IDRESPONSABLE") 
	@XStreamAlias("IDRESPONSABLE")
	@Columna
	private String idresponsable;
        @SerializedName("IDTURNOTRABAJO") 
	@XStreamAlias("IDTURNOTRABAJO")
	@Columna
	private String idturnotrabajo;
        @SerializedName("IDTURNOTRABAJO") 
	@XStreamAlias("TITPOTAREO")
	@Columna
	private String titpotareo;
        @SerializedName("FINICIO") 
	@XStreamAlias("FINICIO")
	@Columna
	private Date finicio;
        @SerializedName("FFIN") 
	@XStreamAlias("FFIN")
	@Columna
	private Date ffin;
        @SerializedName("IDTIPOASISTENCIA") 
	@XStreamAlias("IDTIPOASISTENCIA")
	@Columna
	private String idtipoasistencia;
        @SerializedName("IDUSUARIO") 
	@XStreamAlias("IDUSUARIO")
	@Columna
	private String idusuario;
        private String usuario;
        private String turnotrabajo;
        private String emisor;
        private String sucursal;
        private String almacen;
        private String responsable;
        private String estado;
        private String mes;
	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcabtareoweb(String idcabtareoweb) {
		this.idcabtareoweb = idcabtareoweb;
	}

	public String getIdcabtareoweb() {
		return this.idcabtareoweb;
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

	public void setIdresponsable(String idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getIdresponsable() {
		return this.idresponsable;
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
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
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

    /**
     * @return the idturnotrabajo
     */
    public String getIdturnotrabajo() {
        return idturnotrabajo;
    }

    /**
     * @param idturnotrabajo the idturnotrabajo to set
     */
    public void setIdturnotrabajo(String idturnotrabajo) {
        this.idturnotrabajo = idturnotrabajo;
    }

    /**
     * @return the turnotrabajo
     */
    public String getTurnotrabajo() {
        return turnotrabajo;
    }

    /**
     * @param turnotrabajo the turnotrabajo to set
     */
    public void setTurnotrabajo(String turnotrabajo) {
        this.turnotrabajo = turnotrabajo;
    }

    /**
     * @return the titpotareo
     */
    public String getTitpotareo() {
        return titpotareo;
    }

    /**
     * @param titpotareo the titpotareo to set
     */
    public void setTitpotareo(String titpotareo) {
        this.titpotareo = titpotareo;
    }

    /**
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * @param finicio the finicio to set
     */
    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    /**
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * @param ffin the ffin to set
     */
    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    /**
     * @return the idtipoasistencia
     */
    public String getIdtipoasistencia() {
        return idtipoasistencia;
    }

    /**
     * @param idtipoasistencia the idtipoasistencia to set
     */
    public void setIdtipoasistencia(String idtipoasistencia) {
        this.idtipoasistencia = idtipoasistencia;
    }

    /**
     * @return the idusuario
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

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
}