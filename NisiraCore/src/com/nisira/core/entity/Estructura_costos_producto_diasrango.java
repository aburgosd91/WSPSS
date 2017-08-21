package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.Date;
@XStreamAlias("ESTRUCTURA_COSTOS_PRODUCTO_DIASRANGO")
@Tabla(nombre = "ESTRUCTURA_COSTOS_PRODUCTO_DIASRANGO")
public class Estructura_costos_producto_diasrango {
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("CODIGO")
	@ClavePrimaria
	@Columna
	private String codigo;
        @XStreamAlias("IDPRODUCTO")
	@ClavePrimaria
	@Columna
	private String idproducto;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("NHORAS")
	@ClavePrimaria
	@Columna
	private Float nhoras;
        @XStreamAlias("CODOPERATIVO")
	@ClavePrimaria
	@Columna
	private String codoperativo;
        @XStreamAlias("IDRUTA")
	@ClavePrimaria
	@Columna
	private String idruta;
        @XStreamAlias("IDDIA")
	@ClavePrimaria
	@Columna
	private String iddia;
        @XStreamAlias("FECHACREACION")
	@Columna
	private Date fechacreacion;
        @XStreamAlias("DIA")
        private String dia;
        @XStreamAlias("SELECCION")
        private boolean seleccion;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public String getIdproducto() {
		return this.idproducto;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setNhoras(Float nhoras) {
		this.nhoras = nhoras;
	}

	public Float getNhoras() {
		return this.nhoras;
	}

	public void setCodoperativo(String codoperativo) {
		this.codoperativo = codoperativo;
	}

	public String getCodoperativo() {
		return this.codoperativo;
	}

	public void setIdruta(String idruta) {
		this.idruta = idruta;
	}

	public String getIdruta() {
		return this.idruta;
	}

	public void setIddia(String iddia) {
		this.iddia = iddia;
	}

	public String getIddia() {
		return this.iddia;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}



	/* Sets & Gets FK*/

    /**
     * @return the seleccion
     */
    public boolean isSeleccion() {
        return seleccion;
    }

    /**
     * @param seleccion the seleccion to set
     */
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

}