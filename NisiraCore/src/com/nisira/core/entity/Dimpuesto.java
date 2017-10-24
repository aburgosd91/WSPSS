package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;

@Tabla(nombre = "DIMPUESTO")
public class Dimpuesto {
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idimpuesto;
	@ClavePrimaria
	@Columna
	private Date fecha_imp;
	@Columna
	private Float valor;
        @Columna
	private Integer resta_base;
        
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDIMPUESTO",campoRelacionado="IDIMPUESTO")})
	private Impuesto impuesto_fk_dimpuesto_impuesto;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdimpuesto(String idimpuesto) {
		this.idimpuesto = idimpuesto;
	}

	public String getIdimpuesto() {
		return this.idimpuesto;
	}

	public void setFecha_imp(Date fecha_imp) {
		this.fecha_imp = fecha_imp;
	}

	public Date getFecha_imp() {
		return this.fecha_imp;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getValor() {
		return this.valor;
	}



	/* Sets & Gets FK*/
	public void setImpuesto_fk_dimpuesto_impuesto(Impuesto impuesto_fk_dimpuesto_impuesto) {
		this.impuesto_fk_dimpuesto_impuesto = impuesto_fk_dimpuesto_impuesto;
	}

	public Impuesto getImpuesto_fk_dimpuesto_impuesto() {
		return this.impuesto_fk_dimpuesto_impuesto;
	}

    /**
     * @return the resta_base
     */
    public Integer getResta_base() {
        return resta_base;
    }

    /**
     * @param resta_base the resta_base to set
     */
    public void setResta_base(Integer resta_base) {
        this.resta_base = resta_base;
    }


}