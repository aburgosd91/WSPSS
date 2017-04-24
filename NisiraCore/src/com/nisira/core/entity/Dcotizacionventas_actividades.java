package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;

@Tabla(nombre = "DCOTIZACIONVENTAS_ACTIVIDADES")
public class Dcotizacionventas_actividades implements Serializable{
        private String idbasedatos;
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idcotizacionv;
	@ClavePrimaria
	@Columna
	private String itemc;
	@Columna
	private String itemref;
	@Columna
	private String idcargo;
	@Columna
	private String descripcion;
	@Columna
	private Float cantidad;
	@Columna
	private Float costo;
	@Columna
	private Float total;
        private String cargo;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcotizacionv(String idcotizacionv) {
		this.idcotizacionv = idcotizacionv;
	}

	public String getIdcotizacionv() {
		return this.idcotizacionv;
	}

	public void setItemc(String itemc) {
		this.itemc = itemc;
	}

	public String getItemc() {
		return this.itemc;
	}

	public void setItemref(String itemref) {
		this.itemref = itemref;
	}

	public String getItemref() {
		return this.itemref;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Float getCosto() {
		return this.costo;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getTotal() {
		return this.total;
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