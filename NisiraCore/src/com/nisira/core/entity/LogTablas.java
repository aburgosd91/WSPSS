/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aburgos
 */
@XStreamAlias("LOGTABLAS")
public class LogTablas implements Serializable{
    @ClavePrimaria
    @Columna
    private String idempresa;
    @ClavePrimaria
    @Columna
    private String idlog;
    @ClavePrimaria
    @Columna
    private String item;
    @Columna
    private String tabla;
    @Columna
    private String idcampo;
    @Columna
    private String campoclave;
    @Columna
    private String idtabla;
    @Columna
    private String evento;
    @Columna
    private String valoranterior;
    @Columna
    private String valoractual;
    @Columna
    private String idusuario;
    @Columna
    private String maquina;
    @Columna
    private Date fechacreacion;
    @Columna        
    private String ventana;
    /*** LOG ADICIONALES ***/
    private String hora; 
    private Integer num;
    private String cid;/*cid*/
    private String ciddoc;
    private String cserie;
    private String cnumero;
    private String cusuario;
    private String cproceso;
    /*LOG DETALLE*/
    @XStreamAlias("IDDOC")
    private String iddoc;
    @XStreamAlias("ITEMS")
    private String items;
    @XStreamAlias("CAMPO")
    private String campo;
    @XStreamAlias("VALOR_OLD")
    private String valor_old;
    @XStreamAlias("VALOR_NEW")
    private String valor_new;
    /**
     * @return the iddoc
     */
    public String getIddoc() {
        return iddoc;
    }

    /**
     * @param iddoc the iddoc to set
     */
    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    /**
     * @return the items
     */
    public String getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * @return the campo
     */
    public String getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(String campo) {
        this.campo = campo;
    }

    /**
     * @return the valor_old
     */
    public String getValor_old() {
        return valor_old;
    }

    /**
     * @param valor_old the valor_old to set
     */
    public void setValor_old(String valor_old) {
        this.valor_old = valor_old;
    }

    /**
     * @return the valor_new
     */
    public String getValor_new() {
        return valor_new;
    }

    /**
     * @param valor_new the valor_new to set
     */
    public void setValor_new(String valor_new) {
        this.valor_new = valor_new;
    }
    
	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdlog(String idlog) {
		this.idlog = idlog;
	}

	public String getIdlog() {
		return this.idlog;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setIdcampo(String idcampo) {
		this.idcampo = idcampo;
	}

	public String getIdcampo() {
		return this.idcampo;
	}

	public void setCampoclave(String campoclave) {
		this.campoclave = campoclave;
	}

	public String getCampoclave() {
		return this.campoclave;
	}

	public void setIdtabla(String idtabla) {
		this.idtabla = idtabla;
	}

	public String getIdtabla() {
		return this.idtabla;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setValoranterior(String valoranterior) {
		this.valoranterior = valoranterior;
	}

	public String getValoranterior() {
		return this.valoranterior;
	}

	public void setValoractual(String valoractual) {
		this.valoractual = valoractual;
	}

	public String getValoractual() {
		return this.valoractual;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getMaquina() {
		return this.maquina;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setVentana(String ventana) {
		this.ventana = ventana;
	}

	public String getVentana() {
		return this.ventana;
	}

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the ciddoc
     */
    public String getCiddoc() {
        return ciddoc;
    }

    /**
     * @param ciddoc the ciddoc to set
     */
    public void setCiddoc(String ciddoc) {
        this.ciddoc = ciddoc;
    }

    /**
     * @return the cserie
     */
    public String getCserie() {
        return cserie;
    }

    /**
     * @param cserie the cserie to set
     */
    public void setCserie(String cserie) {
        this.cserie = cserie;
    }

    /**
     * @return the cnumero
     */
    public String getCnumero() {
        return cnumero;
    }

    /**
     * @param cnumero the cnumero to set
     */
    public void setCnumero(String cnumero) {
        this.cnumero = cnumero;
    }

    /**
     * @return the cusuario
     */
    public String getCusuario() {
        return cusuario;
    }

    /**
     * @param cusuario the cusuario to set
     */
    public void setCusuario(String cusuario) {
        this.cusuario = cusuario;
    }

    /**
     * @return the num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return the cproceso
     */
    public String getCproceso() {
        return cproceso;
    }

    /**
     * @param cproceso the cproceso to set
     */
    public void setCproceso(String cproceso) {
        this.cproceso = cproceso;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
}
