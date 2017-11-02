/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alejndro zamora
 */
public class RptFijos {
    
    private String TAREO;
    private String FECHA_TAREO;
    private String RUC;
    private String EMPRESA;
    private String PUESTO;
    private String CARGO;	
    private String DNI;
    private String PERSONAL;
    private String H_INICIO;
    private String H_FIN;
    private String HORAS;
    private String FINICIO;
    private String FFIN;
    private String ASISTENCIA;
    private String OBSERVACION;
    private String CODIGOOP;
    private String DOC_SERVICIO;
    private String SERIE_SERVICIO;
    private String NUMERO_SERVICIO;
    private String DOC_FECH_CREACION;
    private String SERVICIO;
    private String AMBITO;
    private String SEDE;
    private String CODIGO_EC;
    private String ITEM_EC;
    private String CODOPERACIONES_EC;
    private String HORA_RC;
    private String IDRUTA_EC;
    private Date finiD;
    private Date ffinD;
    private int fila;
    public RptFijos() {
    }

    /**
     * @return the TAREO
     */
    public String getTAREO() {
        return TAREO;
    }

    /**
     * @param TAREO the TAREO to set
     */
    public void setTAREO(String TAREO) {
        this.TAREO = TAREO;
    }

    /**
     * @return the FECHA_TAREO
     */
    public String getFECHA_TAREO() {
        return FECHA_TAREO;
    }

    /**
     * @param FECHA_TAREO the FECHA_TAREO to set
     */
    public void setFECHA_TAREO(String FECHA_TAREO) {
        this.FECHA_TAREO = FECHA_TAREO;
    }

    /**
     * @return the RUC
     */
    public String getRUC() {
        return RUC;
    }

    /**
     * @param RUC the RUC to set
     */
    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    /**
     * @return the EMPRESA
     */
    public String getEMPRESA() {
        return EMPRESA;
    }

    /**
     * @param EMPRESA the EMPRESA to set
     */
    public void setEMPRESA(String EMPRESA) {
        this.EMPRESA = EMPRESA;
    }

    /**
     * @return the PUESTO
     */
    public String getPUESTO() {
        return PUESTO;
    }

    /**
     * @param PUESTO the PUESTO to set
     */
    public void setPUESTO(String PUESTO) {
        this.PUESTO = PUESTO;
    }

    /**
     * @return the CARGO
     */
    public String getCARGO() {
        return CARGO;
    }

    /**
     * @param CARGO the CARGO to set
     */
    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * @return the PERSONAL
     */
    public String getPERSONAL() {
        return PERSONAL;
    }

    /**
     * @param PERSONAL the PERSONAL to set
     */
    public void setPERSONAL(String PERSONAL) {
        this.PERSONAL = PERSONAL;
    }

    /**
     * @return the H_INICIO
     */
    public String getH_INICIO() {
        return H_INICIO;
    }

    /**
     * @param H_INICIO the H_INICIO to set
     */
    public void setH_INICIO(String H_INICIO) {
        this.H_INICIO = H_INICIO;
    }

    /**
     * @return the H_FIN
     */
    public String getH_FIN() {
        return H_FIN;
    }

    /**
     * @param H_FIN the H_FIN to set
     */
    public void setH_FIN(String H_FIN) {
        this.H_FIN = H_FIN;
    }

    /**
     * @return the HORAS
     */
    public String getHORAS() {
        return HORAS;
    }

    /**
     * @param HORAS the HORAS to set
     */
    public void setHORAS(String HORAS) {
        this.HORAS = HORAS;
    }

    /**
     * @return the FINICIO
     */
    public String getFINICIO() {
        return FINICIO;
    }

    /**
     * @param FINICIO the FINICIO to set
     */
    public void setFINICIO(String FINICIO) {
        this.FINICIO = FINICIO;
    }

    /**
     * @return the FFIN
     */
    public String getFFIN() {
        return FFIN;
    }

    /**
     * @param FFIN the FFIN to set
     */
    public void setFFIN(String FFIN) {
        this.FFIN = FFIN;
    }

    /**
     * @return the ASISTENCIA
     */
    public String getASISTENCIA() {
        return ASISTENCIA;
    }

    /**
     * @param ASISTENCIA the ASISTENCIA to set
     */
    public void setASISTENCIA(String ASISTENCIA) {
        this.ASISTENCIA = ASISTENCIA;
    }

    /**
     * @return the OBSERVACION
     */
    public String getOBSERVACION() {
        return OBSERVACION;
    }

    /**
     * @param OBSERVACION the OBSERVACION to set
     */
    public void setOBSERVACION(String OBSERVACION) {
        this.OBSERVACION = OBSERVACION;
    }

    /**
     * @return the CODIGOOP
     */
    public String getCODIGOOP() {
        return CODIGOOP;
    }

    /**
     * @param CODIGOOP the CODIGOOP to set
     */
    public void setCODIGOOP(String CODIGOOP) {
        this.CODIGOOP = CODIGOOP;
    }

    /**
     * @return the DOC_SERVICIO
     */
    public String getDOC_SERVICIO() {
        return DOC_SERVICIO;
    }

    /**
     * @param DOC_SERVICIO the DOC_SERVICIO to set
     */
    public void setDOC_SERVICIO(String DOC_SERVICIO) {
        this.DOC_SERVICIO = DOC_SERVICIO;
    }

    /**
     * @return the SERIE_SERVICIO
     */
    public String getSERIE_SERVICIO() {
        return SERIE_SERVICIO;
    }

    /**
     * @param SERIE_SERVICIO the SERIE_SERVICIO to set
     */
    public void setSERIE_SERVICIO(String SERIE_SERVICIO) {
        this.SERIE_SERVICIO = SERIE_SERVICIO;
    }

    /**
     * @return the NUMERO_SERVICIO
     */
    public String getNUMERO_SERVICIO() {
        return NUMERO_SERVICIO;
    }

    /**
     * @param NUMERO_SERVICIO the NUMERO_SERVICIO to set
     */
    public void setNUMERO_SERVICIO(String NUMERO_SERVICIO) {
        this.NUMERO_SERVICIO = NUMERO_SERVICIO;
    }

    /**
     * @return the DOC_FECH_CREACION
     */
    public String getDOC_FECH_CREACION() {
        return DOC_FECH_CREACION;
    }

    /**
     * @param DOC_FECH_CREACION the DOC_FECH_CREACION to set
     */
    public void setDOC_FECH_CREACION(String DOC_FECH_CREACION) {
        this.DOC_FECH_CREACION = DOC_FECH_CREACION;
    }

    /**
     * @return the SERVICIO
     */
    public String getSERVICIO() {
        return SERVICIO;
    }

    /**
     * @param SERVICIO the SERVICIO to set
     */
    public void setSERVICIO(String SERVICIO) {
        this.SERVICIO = SERVICIO;
    }

    /**
     * @return the AMBITO
     */
    public String getAMBITO() {
        return AMBITO;
    }

    /**
     * @param AMBITO the AMBITO to set
     */
    public void setAMBITO(String AMBITO) {
        this.AMBITO = AMBITO;
    }

    /**
     * @return the SEDE
     */
    public String getSEDE() {
        return SEDE;
    }

    /**
     * @param SEDE the SEDE to set
     */
    public void setSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    /**
     * @return the CODIGO_EC
     */
    public String getCODIGO_EC() {
        return CODIGO_EC;
    }

    /**
     * @param CODIGO_EC the CODIGO_EC to set
     */
    public void setCODIGO_EC(String CODIGO_EC) {
        this.CODIGO_EC = CODIGO_EC;
    }

    /**
     * @return the ITEM_EC
     */
    public String getITEM_EC() {
        return ITEM_EC;
    }

    /**
     * @param ITEM_EC the ITEM_EC to set
     */
    public void setITEM_EC(String ITEM_EC) {
        this.ITEM_EC = ITEM_EC;
    }

    /**
     * @return the CODOPERACIONES_EC
     */
    public String getCODOPERACIONES_EC() {
        return CODOPERACIONES_EC;
    }

    /**
     * @param CODOPERACIONES_EC the CODOPERACIONES_EC to set
     */
    public void setCODOPERACIONES_EC(String CODOPERACIONES_EC) {
        this.CODOPERACIONES_EC = CODOPERACIONES_EC;
    }

    /**
     * @return the HORA_RC
     */
    public String getHORA_RC() {
        return HORA_RC;
    }

    /**
     * @param HORA_RC the HORA_RC to set
     */
    public void setHORA_RC(String HORA_RC) {
        this.HORA_RC = HORA_RC;
    }

    /**
     * @return the IDRUTA_EC
     */
    public String getIDRUTA_EC() {
        return IDRUTA_EC;
    }

    /**
     * @param IDRUTA_EC the IDRUTA_EC to set
     */
    public void setIDRUTA_EC(String IDRUTA_EC) {
        this.IDRUTA_EC = IDRUTA_EC;
    }

    /**
     * @return the finiD
     */
    public Date getFiniD() {
        return finiD;
    }

    /**
     * @param finiD the finiD to set
     */
    public void setFiniD(Date finiD) {
        this.finiD = finiD;
    }

    /**
     * @return the ffinD
     */
    public Date getFfinD() {
        return ffinD;
    }

    /**
     * @param ffinD the ffinD to set
     */
    public void setFfinD(Date ffinD) {
        this.ffinD = ffinD;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }
}
