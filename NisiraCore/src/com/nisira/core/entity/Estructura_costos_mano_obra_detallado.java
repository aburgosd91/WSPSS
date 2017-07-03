package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias("ESTRUCTURA_COSTOS_MANO_OBRA_DETALLADO")
@Tabla(nombre = "ESTRUCTURA_COSTOS_MANO_OBRA_DETALLADO")
public class Estructura_costos_mano_obra_detallado implements Serializable{
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("CODIGO")
	@ClavePrimaria
	@Columna
	private String codigo;
        @XStreamAlias("IDCARGO")
	@ClavePrimaria
	@Columna
	private String idcargo;
        @XStreamAlias("ITEMRANGO")
	@ClavePrimaria
	@Columna
	private String itemrango;
        @XStreamAlias("ITEM_ECM")
	@ClavePrimaria
	@Columna
	private String item_ecm;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("HORAI")
	@Columna
	private Float horai;
        @XStreamAlias("HORAF")
	@Columna
	private Float horaf;
        @XStreamAlias("COSTO")
	@Columna
	private Float costo;
        @XStreamAlias("NHORAS")
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
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="CODIGO",campoRelacionado="CODIGO"), @RelacionTabla(campo="IDCARGO",campoRelacionado="IDCARGO"), @RelacionTabla(campo="ITEMRANGO",campoRelacionado="ITEMRANGO"), @RelacionTabla(campo="ITEM_ECM",campoRelacionado="ITEM_ECM"), @RelacionTabla(campo="ITEM",campoRelacionado="ITEM")})
	private Estructura_costos_mano_obra_detallado estructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado;
        private String Shorai;
        private String Shoraf;
        private String cargo;

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

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setItemrango(String itemrango) {
		this.itemrango = itemrango;
	}

	public String getItemrango() {
		return this.itemrango;
	}

	public void setItem_ecm(String item_ecm) {
		this.item_ecm = item_ecm;
	}

	public String getItem_ecm() {
		return this.item_ecm;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setHorai(Float horai) {
		this.horai = horai;
	}

	public Float getHorai() {
		return this.horai;
	}

	public void setHoraf(Float horaf) {
		this.horaf = horaf;
	}

	public Float getHoraf() {
		return this.horaf;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Float getCosto() {
		return this.costo;
	}



	/* Sets & Gets FK*/
	public void setEstructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado(Estructura_costos_mano_obra_detallado estructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado) {
		this.estructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado = estructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado;
	}

	public Estructura_costos_mano_obra_detallado getEstructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado() {
		return this.estructura_costos_mano_obra_detallado_fk_estructura_costos_mano_obra_detallado_estructura_costos_mano_obra_detallado;
	}

    /**
     * @return the Shorai
     */
    public String getShorai() {
        return Shorai;
    }

    /**
     * @param Shorai the Shorai to set
     */
    public void setShorai(String Shorai) {
        this.Shorai = Shorai;
    }

    /**
     * @return the Shoraf
     */
    public String getShoraf() {
        return Shoraf;
    }

    /**
     * @param Shoraf the Shoraf to set
     */
    public void setShoraf(String Shoraf) {
        this.Shoraf = Shoraf;
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

    /**
     * @return the nhoras
     */
    public Float getNhoras() {
        return nhoras;
    }

    /**
     * @param nhoras the nhoras to set
     */
    public void setNhoras(Float nhoras) {
        this.nhoras = nhoras;
    }

    /**
     * @return the codoperativo
     */
    public String getCodoperativo() {
        return codoperativo;
    }

    /**
     * @param codoperativo the codoperativo to set
     */
    public void setCodoperativo(String codoperativo) {
        this.codoperativo = codoperativo;
    }

    /**
     * @return the idruta
     */
    public String getIdruta() {
        return idruta;
    }

    /**
     * @param idruta the idruta to set
     */
    public void setIdruta(String idruta) {
        this.idruta = idruta;
    }


}