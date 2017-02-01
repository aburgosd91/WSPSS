package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("DORDENSERVICIOCLIENTE")
@Tabla(nombre = "DORDENSERVICIOCLIENTE")
public class Dordenserviciocliente {
	@Columna
        @XStreamAlias("IDEMPRESA")
	private String idempresa;
	@Columna
	@XStreamAlias("IDORDENSERVICIO")
        private String idordenservicio;
	@Columna
        @XStreamAlias("ITEM")
	private String item;
	@Columna
        @XStreamAlias("IDVEHICULO")
	private String idvehiculo;
	@Columna
        @XStreamAlias("PLACA_CLIENTE")
	private String placa_cliente;
	@Columna
        @XStreamAlias("HORA_REQ")
	private Float hora_req;
	@Columna
        @XStreamAlias("FECHA_FIN_SERVICIO")
	private Date fecha_fin_servicio;
	@Columna
        @XStreamAlias("FECHACREACION")
	private Date fechacreacion;
        @Columna
        @XStreamAlias("IDREFERENCIA")
	private String idreferencia;
	@Columna
        @XStreamAlias("ITEMREFERENCIA")
	private String itemreferencia;
        private String vehiculo;
        private Date hora_reqConvert;

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

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdvehiculo() {
		return this.idvehiculo;
	}

	public void setPlaca_cliente(String placa_cliente) {
		this.placa_cliente = placa_cliente;
	}

	public String getPlaca_cliente() {
		return this.placa_cliente;
	}

	public void setHora_req(Float hora_req) {
		this.hora_req = hora_req;
	}

	public Float getHora_req() {
		return this.hora_req;
	}

	public void setFecha_fin_servicio(Date fecha_fin_servicio) {
		this.fecha_fin_servicio = fecha_fin_servicio;
	}

	public Date getFecha_fin_servicio() {
		return this.fecha_fin_servicio;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}



	/* Sets & Gets FK*/

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the hora_reqConvert
     */
    public Date getHora_reqConvert() {
        return hora_reqConvert;
    }

    /**
     * @param hora_reqConvert the hora_reqConvert to set
     */
    public void setHora_reqConvert(Date hora_reqConvert) {
        this.hora_reqConvert = hora_reqConvert;
    }

    /**
     * @return the idreferencia
     */
    public String getIdreferencia() {
        return idreferencia;
    }

    /**
     * @param idreferencia the idreferencia to set
     */
    public void setIdreferencia(String idreferencia) {
        this.idreferencia = idreferencia;
    }

    /**
     * @return the itemreferencia
     */
    public String getItemreferencia() {
        return itemreferencia;
    }

    /**
     * @param itemreferencia the itemreferencia to set
     */
    public void setItemreferencia(String itemreferencia) {
        this.itemreferencia = itemreferencia;
    }

}