package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("DPERSONAL_SERVICIO")
@Tabla(nombre = "DPERSONAL_SERVICIO")
public class Dpersonal_servicio {
	@XStreamAlias("IDEMPRESA")
        @ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDORDENSERVICIO")
	@ClavePrimaria
	@Columna
	private String idordenservicio;
        @XStreamAlias("ITEM_DORDENSERVICIO")
	@ClavePrimaria
	@Columna
	private String item_dordenservicio;
        @XStreamAlias("ITEM2")
	@ClavePrimaria
	@Columna
	private String item2;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("HORA_REQ")
	@Columna
	private Float hora_req;
        @XStreamAlias("HORA_LLEGADA")
	@Columna
	private Float hora_llegada;
        @XStreamAlias("HORA_INICIO_SERV")
	@Columna
	private Float hora_inicio_serv;
        @XStreamAlias("HORA_FIN_SERV")
	@Columna
	private Float hora_fin_serv;
        @XStreamAlias("HORA_LIBERACION")
	@Columna
	private Float hora_liberacion;
        @XStreamAlias("IDCARGO")
	@Columna
	private String idcargo;
        @XStreamAlias("FECHAREGISTRO")
	@Columna
	private Date fecharegistro;
        private Date fhora_req;
        private Date fhora_llegada;
        private Date fhora_inicio_serv;
        private Date fhora_fin_serv;
        private Date fhora_liberacion;
        private String cargo;
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

	public void setItem_dordenservicio(String item_dordenservicio) {
		this.item_dordenservicio = item_dordenservicio;
	}

	public String getItem_dordenservicio() {
		return this.item_dordenservicio;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setHora_req(Float hora_req) {
		this.hora_req = hora_req;
	}

	public Float getHora_req() {
		return this.hora_req;
	}

	public void setHora_llegada(Float hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public Float getHora_llegada() {
		return this.hora_llegada;
	}

	public void setHora_inicio_serv(Float hora_inicio_serv) {
		this.hora_inicio_serv = hora_inicio_serv;
	}

	public Float getHora_inicio_serv() {
		return this.hora_inicio_serv;
	}

	public void setHora_fin_serv(Float hora_fin_serv) {
		this.hora_fin_serv = hora_fin_serv;
	}

	public Float getHora_fin_serv() {
		return this.hora_fin_serv;
	}

	public void setHora_liberacion(Float hora_liberacion) {
		this.hora_liberacion = hora_liberacion;
	}

	public Float getHora_liberacion() {
		return this.hora_liberacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}



	/* Sets & Gets FK*/

    /**
     * @return the fhora_req
     */
    public Date getFhora_req() {
        return fhora_req;
    }

    /**
     * @param fhora_req the fhora_req to set
     */
    public void setFhora_req(Date fhora_req) {
        this.fhora_req = fhora_req;
    }

    /**
     * @return the fhora_llegada
     */
    public Date getFhora_llegada() {
        return fhora_llegada;
    }

    /**
     * @param fhora_llegada the fhora_llegada to set
     */
    public void setFhora_llegada(Date fhora_llegada) {
        this.fhora_llegada = fhora_llegada;
    }

    /**
     * @return the fhora_inicio_serv
     */
    public Date getFhora_inicio_serv() {
        return fhora_inicio_serv;
    }

    /**
     * @param fhora_inicio_serv the fhora_inicio_serv to set
     */
    public void setFhora_inicio_serv(Date fhora_inicio_serv) {
        this.fhora_inicio_serv = fhora_inicio_serv;
    }

    /**
     * @return the fhora_fin_serv
     */
    public Date getFhora_fin_serv() {
        return fhora_fin_serv;
    }

    /**
     * @param fhora_fin_serv the fhora_fin_serv to set
     */
    public void setFhora_fin_serv(Date fhora_fin_serv) {
        this.fhora_fin_serv = fhora_fin_serv;
    }

    /**
     * @return the fhora_liberacio
     */
    public Date getFhora_liberacion() {
        return fhora_liberacion;
    }

    /**
     * @param fhora_liberacio the fhora_liberacio to set
     */
    public void setFhora_liberacion(Date fhora_liberacion) {
        this.fhora_liberacion = fhora_liberacion;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}