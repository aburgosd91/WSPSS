/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author alejndro zamora
 */
@XStreamAlias("LIBROQUEJAS")
public class LibroQuejas {
    @XStreamAlias("idempresa")
    private String idempresa;
    @XStreamAlias("idlibqueja")
    private String idlibqueja;
    @XStreamAlias("iddocumento")
    private String iddocumento;
    @XStreamAlias("serie")
    private String serie;	
    @XStreamAlias("numero")
    private String numero;	
    @XStreamAlias("idmotivoreclamo")
    private String idmotivoreclamo;
    @XStreamAlias("idtipopersona")
    private String idtipopersona;
    @XStreamAlias("iddocidentidad")
    private String iddocidentidad;
    @XStreamOmitField
    private String docidentidad;
    @XStreamAlias("idclieprov")
    private String idclieprov;
    @XStreamOmitField
    private String nrodocidentidad;
    @XStreamAlias("idreclamo")
    private String idreclamo;
    @XStreamOmitField
    private String reclamo;
    @XStreamAlias("iddocumentoRef")
    private String iddocumentoRef;
    @XStreamAlias("serieRef")
    private String serieRef;
    @XStreamAlias("numeroRef")
    private String numeroRef;
    @XStreamAlias("Glosa")
    private String glosa;
    @XStreamOmitField
    private String idestado;
    public LibroQuejas() {
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdlibqueja() {
        return idlibqueja;
    }

    public void setIdlibqueja(String idlibqueja) {
        this.idlibqueja = idlibqueja;
    }

    public String getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIdmotivoreclamo() {
        return idmotivoreclamo;
    }

    public void setIdmotivoreclamo(String idmotivoreclamo) {
        this.idmotivoreclamo = idmotivoreclamo;
    }

    public String getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(String idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public String getIddocidentidad() {
        return iddocidentidad;
    }

    public void setIddocidentidad(String iddocidentidad) {
        this.iddocidentidad = iddocidentidad;
    }

    public String getDocidentidad() {
        return docidentidad;
    }

    public void setDocidentidad(String docidentidad) {
        this.docidentidad = docidentidad;
    }

    public String getIdclieprov() {
        return idclieprov;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getNrodocidentidad() {
        return nrodocidentidad;
    }

    public void setNrodocidentidad(String nrodocidentidad) {
        this.nrodocidentidad = nrodocidentidad;
    }

    public String getIdreclamo() {
        return idreclamo;
    }

    public void setIdreclamo(String idreclamo) {
        this.idreclamo = idreclamo;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public String getIddocumentoRef() {
        return iddocumentoRef;
    }

    public void setIddocumentoRef(String iddocumentoRef) {
        this.iddocumentoRef = iddocumentoRef;
    }

    public String getSerieRef() {
        return serieRef;
    }

    public void setSerieRef(String serieRef) {
        this.serieRef = serieRef;
    }

    public String getNumeroRef() {
        return numeroRef;
    }

    public void setNumeroRef(String numeroRef) {
        this.numeroRef = numeroRef;
    }

    

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getIdestado() {
        return idestado;
    }

    public void setIdestado(String idestado) {
        this.idestado = idestado;
    }
					

}
