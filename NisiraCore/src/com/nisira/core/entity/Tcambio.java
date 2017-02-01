package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;

@Tabla(nombre = "TCAMBIO")
public class Tcambio {
        private String idbasedatos;
	@Columna
	private Date fecha;
	@Columna
	private String periodo;
	@Columna
	private Float b_compra;
	@Columna
	private Float b_venta;
	@Columna
	private Float p_compra;
	@Columna
	private Float p_venta;
	@Columna
	private Float t_compra;
	@Columna
	private Float t_venta;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private Float e_compra;
	@Columna
	private Float e_venta;



	/* Sets & Gets */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setB_compra(Float b_compra) {
		this.b_compra = b_compra;
	}

	public Float getB_compra() {
		return this.b_compra;
	}

	public void setB_venta(Float b_venta) {
		this.b_venta = b_venta;
	}

	public Float getB_venta() {
		return this.b_venta;
	}

	public void setP_compra(Float p_compra) {
		this.p_compra = p_compra;
	}

	public Float getP_compra() {
		return this.p_compra;
	}

	public void setP_venta(Float p_venta) {
		this.p_venta = p_venta;
	}

	public Float getP_venta() {
		return this.p_venta;
	}

	public void setT_compra(Float t_compra) {
		this.t_compra = t_compra;
	}

	public Float getT_compra() {
		return this.t_compra;
	}

	public void setT_venta(Float t_venta) {
		this.t_venta = t_venta;
	}

	public Float getT_venta() {
		return this.t_venta;
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

	public void setE_compra(Float e_compra) {
		this.e_compra = e_compra;
	}

	public Float getE_compra() {
		return this.e_compra;
	}

	public void setE_venta(Float e_venta) {
		this.e_venta = e_venta;
	}

	public Float getE_venta() {
		return this.e_venta;
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

}