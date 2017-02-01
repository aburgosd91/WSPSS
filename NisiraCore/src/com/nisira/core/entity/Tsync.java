package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "TSYNC")
@XStreamAlias("TSYNC")

public class Tsync implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("tabla") 
	@XStreamAlias("tabla") 
	private String tabla = "" ;
	@Columna
	@SerializedName("tiposync") 
	@XStreamAlias("tiposync") 
	private String tiposync = "" ;
	@Columna
	@SerializedName("syncanteslogueo") 
	@XStreamAlias("syncanteslogueo") 
	private Double syncanteslogueo = 0.00 ;
	@Columna
	@SerializedName("formasync") 
	@XStreamAlias("formasync") 
	private String formasync = "" ;



	/* Sets & Gets */
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTiposync(String tiposync) {
		this.tiposync = tiposync;
	}

	public String getTiposync() {
		return this.tiposync;
	}

	public void setSyncanteslogueo(Double syncanteslogueo) {
		this.syncanteslogueo = syncanteslogueo;
	}

	public Double getSyncanteslogueo() {
		return this.syncanteslogueo;
	}

	public void setFormasync(String formasync) {
		this.formasync = formasync;
	}

	public String getFormasync() {
		return this.formasync;
	}



	/* Sets & Gets FK*/

}