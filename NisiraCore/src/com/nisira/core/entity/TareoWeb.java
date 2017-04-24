/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aburgos
 */
@XStreamAlias("TAREOWEB")
public class TareoWeb implements Serializable {
    private int item;
    @XStreamAlias("IDEMPRESA")
    private String idempresa;
    @XStreamAlias("IDORDENSERVICIO")
    private String idordenservicio;
    @XStreamAlias("IDDOCUMENTO")
    private String iddocumento;
    @XStreamAlias("SERIE")
    private String serie;
    @XStreamAlias("NUMERO")
    private String numero;
    @XStreamAlias("RUC")
    private String ruc;
    @XStreamAlias("RAZON")
    private String razon;
    @XStreamAlias("IDPERSONAL")
    private String idpersonal;
    @XStreamAlias("DNI")
    private String dni;
    @XStreamAlias("PERSONAL")
    private String personal;
    @XStreamAlias("IDCARGO")
    private String idcargo;
    @XStreamAlias("CARGO")
    private String cargo;
    @XStreamAlias("ITEM_PERSONALSERVICIO")
    private String item_personalservicio;
    @XStreamAlias("ITEM2_PERSONALSERVICIO")
    private String item2_personalservicio;
    @XStreamAlias("ITEM_DPERSONALSERVICIO")
    private String item_dpersonalservicio;
    @XStreamAlias("FHORA_REQ")
    private Date  fhora_req;
    @XStreamAlias("FHORA_LLEGADA")
    private Date  fhora_llegada;
    @XStreamAlias("FHORA_INICIO")
    private Date  fhora_inicio;
    @XStreamAlias("FHORA_FIN")
    private Date  fhora_fin;
    @XStreamAlias("FHORA_LIBERACION")
    private Date  fhora_liberacion;
    @XStreamAlias("HORA_REQ")
    private Float hora_req;
    @XStreamAlias("HORA_LLEGADA")
    private Float hora_llegada;
    @XStreamAlias("HORA_INICIO")
    private Float hora_inicio;
    @XStreamAlias("HORA_FIN")
    private Float hora_fin;
    @XStreamAlias("HORA_LIBERACION")
    private Float hora_liberacion;
    @XStreamAlias("FECHAFINREGISTRO")
    private Date fechafinregistro;

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the ruc
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the razon
     */
    public String getRazon() {
        return razon;
    }

    /**
     * @param razon the razon to set
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the personal
     */
    public String getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(String personal) {
        this.personal = personal;
    }

    /**
     * @return the fhora_req
     */
    public Date getFhora_req() {
        return fhora_req;
    }

    /**
     * @param fhora_req the fhora_req to set
     */
    public void setFhora_req(Date fhora_req) {
        this.fhora_req = fhora_req;
    }

    /**
     * @return the fhora_llegada
     */
    public Date getFhora_llegada() {
        return fhora_llegada;
    }

    /**
     * @param fhora_llegada the fhora_llegada to set
     */
    public void setFhora_llegada(Date fhora_llegada) {
        this.fhora_llegada = fhora_llegada;
    }

    /**
     * @return the fhora_inicio
     */
    public Date getFhora_inicio() {
        return fhora_inicio;
    }

    /**
     * @param fhora_inicio the fhora_inicio to set
     */
    public void setFhora_inicio(Date fhora_inicio) {
        this.fhora_inicio = fhora_inicio;
    }

    /**
     * @return the fhora_fin
     */
    public Date getFhora_fin() {
        return fhora_fin;
    }

    /**
     * @param fhora_fin the fhora_fin to set
     */
    public void setFhora_fin(Date fhora_fin) {
        this.fhora_fin = fhora_fin;
    }

    /**
     * @return the fhora_liberacion
     */
    public Date getFhora_liberacion() {
        return fhora_liberacion;
    }

    /**
     * @param fhora_liberacion the fhora_liberacion to set
     */
    public void setFhora_liberacion(Date fhora_liberacion) {
        this.fhora_liberacion = fhora_liberacion;
    }

    /**
     * @return the hora_req
     */
    public Float getHora_req() {
        return hora_req;
    }

    /**
     * @param hora_req the hora_req to set
     */
    public void setHora_req(Float hora_req) {
        this.hora_req = hora_req;
    }

    /**
     * @return the hora_llegada
     */
    public Float getHora_llegada() {
        return hora_llegada;
    }

    /**
     * @param hora_llegada the hora_llegada to set
     */
    public void setHora_llegada(Float hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    /**
     * @return the hora_inicio
     */
    public Float getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(Float hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public Float getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(Float hora_fin) {
        this.hora_fin = hora_fin;
    }

    /**
     * @return the hora_liberacion
     */
    public Float getHora_liberacion() {
        return hora_liberacion;
    }

    /**
     * @param hora_liberacion the hora_liberacion to set
     */
    public void setHora_liberacion(Float hora_liberacion) {
        this.hora_liberacion = hora_liberacion;
    }

    /**
     * @return the idempresa
     */
    public String getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     * @return the idordenservicio
     */
    public String getIdordenservicio() {
        return idordenservicio;
    }

    /**
     * @param idordenservicio the idordenservicio to set
     */
    public void setIdordenservicio(String idordenservicio) {
        this.idordenservicio = idordenservicio;
    }

    /**
     * @return the fechafinregistro
     */
    public Date getFechafinregistro() {
        return fechafinregistro;
    }

    /**
     * @param fechafinregistro the fechafinregistro to set
     */
    public void setFechafinregistro(Date fechafinregistro) {
        this.fechafinregistro = fechafinregistro;
    }

    /**
     * @return the idcargo
     */
    public String getIdcargo() {
        return idcargo;
    }

    /**
     * @param idcargo the idcargo to set
     */
    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
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
     * @return the item_personalservicio
     */
    public String getItem_personalservicio() {
        return item_personalservicio;
    }

    /**
     * @param item_personalservicio the item_personalservicio to set
     */
    public void setItem_personalservicio(String item_personalservicio) {
        this.item_personalservicio = item_personalservicio;
    }

    /**
     * @return the item2_personalservicio
     */
    public String getItem2_personalservicio() {
        return item2_personalservicio;
    }

    /**
     * @param item2_personalservicio the item2_personalservicio to set
     */
    public void setItem2_personalservicio(String item2_personalservicio) {
        this.item2_personalservicio = item2_personalservicio;
    }

    /**
     * @return the idpersonal
     */
    public String getIdpersonal() {
        return idpersonal;
    }

    /**
     * @param idpersonal the idpersonal to set
     */
    public void setIdpersonal(String idpersonal) {
        this.idpersonal = idpersonal;
    }

    /**
     * @return the item_dpersonalservicio
     */
    public String getItem_dpersonalservicio() {
        return item_dpersonalservicio;
    }

    /**
     * @param item_dpersonalservicio the item_dpersonalservicio to set
     */
    public void setItem_dpersonalservicio(String item_dpersonalservicio) {
        this.item_dpersonalservicio = item_dpersonalservicio;
    }
}
