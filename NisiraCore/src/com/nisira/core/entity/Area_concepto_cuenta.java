package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
@XStreamAlias("AREA_CONCEPTO_CUENTA")
@Tabla(nombre = "AREA_CONCEPTO_CUENTA")
public class Area_concepto_cuenta implements Serializable,Cloneable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDAREA")
	@ClavePrimaria
	@Columna
	private String idarea;
        @XStreamAlias("IDCONCEPTO")
	@ClavePrimaria
	@Columna
	private String idconcepto;
        @XStreamAlias("DESCRIPCION")
	@Columna
	private String descripcion;
        private String area;
        private String concepto;
        private String idcuenta;
        private String item;
	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdarea(String idarea) {
		this.idarea = idarea;
	}

	public String getIdarea() {
		return this.idarea;
	}

	public void setIdconcepto(String idconcepto) {
		this.idconcepto = idconcepto;
	}

	public String getIdconcepto() {
		return this.idconcepto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}



	/* Sets & Gets FK*/

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the idcuenta
     */
    public String getIdcuenta() {
        return idcuenta;
    }

    /**
     * @param idcuenta the idcuenta to set
     */
    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    } 

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }
}