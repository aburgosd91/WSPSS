package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("PRIVILEGIO_GLOBAL_PSS")
@Tabla(nombre = "PRIVILEGIO_GLOBAL_PSS")
public class Privilegio_global_pss implements Serializable{
        @XStreamAlias("IDEMPRESA")
	@Columna
	private String idempresa;
        @XStreamAlias("IDUSUARIO")
	@Columna
	private String idusuario;
        @XStreamAlias("VISTA")
	@Columna
	private String vista;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        private String usuario;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public String getVista() {
		return this.vista;
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
     * @return the fechacreacion
     */
    public Date getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

}