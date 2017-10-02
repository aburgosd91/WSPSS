package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("DORDENSERVICIOCLIENTE")
@Tabla(nombre = "DORDENSERVICIOCLIENTE")
public class Dordenserviciocliente implements Serializable{
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
        @Columna
        @XStreamAlias("IDSERVICIO")
	private String idservicio;
        @Columna
        @XStreamAlias("CONDUCTOR_CLIENTE")
	private String conductor_cliente;
        @Columna
        @XStreamAlias("HORA_RC")
        private Float hora_rc;
        @Columna
        @XStreamAlias("GLOSA")
        private String glosa;
        @Columna
        @XStreamAlias("CODOPERACIONES")
        private String codoperaciones;
        @Columna
        @XStreamAlias("IDRUTA_EC")
        private String idruta_ec;
        @Columna
        @XStreamAlias("BREVETE")
        private String brevete;
        @Columna
        @XStreamAlias("IDRUTA_VIAJE")
        private String idruta_viaje;
        @Columna
        @XStreamAlias("DESCRIPCION_VEHICULO")
        private String descripcion_vehiculo;
        @Columna
        @XStreamAlias("DESCRIPCION_SERVICIO")
        private String descripcion_servicio;
        
        private String vehiculo;
        private Date hora_reqConvert;
        private String descripcion;
        private String ruta_ec;
        private String ruta_viaje;
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

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idservicio
     */
    public String getIdservicio() {
        return idservicio;
    }

    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    /**
     * @return the conductor_cliente
     */
    public String getConductor_cliente() {
        return conductor_cliente;
    }

    /**
     * @param conductor_cliente the conductor_cliente to set
     */
    public void setConductor_cliente(String conductor_cliente) {
        this.conductor_cliente = conductor_cliente;
    }

    /**
     * @return the hora_rc
     */
    public Float getHora_rc() {
        return hora_rc;
    }

    /**
     * @param hora_rc the hora_rc to set
     */
    public void setHora_rc(Float hora_rc) {
        this.hora_rc = hora_rc;
    }

    /**
     * @return the glosa
     */
    public String getGlosa() {
        return glosa;
    }

    /**
     * @param glosa the glosa to set
     */
    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    /**
     * @return the codoperaciones
     */
    public String getCodoperaciones() {
        return codoperaciones;
    }

    /**
     * @param codoperaciones the codoperaciones to set
     */
    public void setCodoperaciones(String codoperaciones) {
        this.codoperaciones = codoperaciones;
    }

    /**
     * @return the idruta_ec
     */
    public String getIdruta_ec() {
        return idruta_ec;
    }

    /**
     * @param idruta_ec the idruta_ec to set
     */
    public void setIdruta_ec(String idruta_ec) {
        this.idruta_ec = idruta_ec;
    }

    /**
     * @return the ruta_ec
     */
    public String getRuta_ec() {
        return ruta_ec;
    }

    /**
     * @param ruta_ec the ruta_ec to set
     */
    public void setRuta_ec(String ruta_ec) {
        this.ruta_ec = ruta_ec;
    }

    /**
     * @return the brevete
     */
    public String getBrevete() {
        return brevete;
    }

    /**
     * @param brevete the brevete to set
     */
    public void setBrevete(String brevete) {
        this.brevete = brevete;
    }

    /**
     * @return the idruta_viaje
     */
    public String getIdruta_viaje() {
        return idruta_viaje;
    }

    /**
     * @param idruta_viaje the idruta_viaje to set
     */
    public void setIdruta_viaje(String idruta_viaje) {
        this.idruta_viaje = idruta_viaje;
    }

    /**
     * @return the ruta_viaje
     */
    public String getRuta_viaje() {
        return ruta_viaje;
    }

    /**
     * @param ruta_viaje the ruta_viaje to set
     */
    public void setRuta_viaje(String ruta_viaje) {
        this.ruta_viaje = ruta_viaje;
    }

    public String getDescripcion_vehiculo() {
        return descripcion_vehiculo;
    }

    public void setDescripcion_vehiculo(String descripcion_vehiculo) {
        this.descripcion_vehiculo = descripcion_vehiculo;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

}