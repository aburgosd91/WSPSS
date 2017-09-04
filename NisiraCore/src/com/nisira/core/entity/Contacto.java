/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author alejndro zamora
 */
@XStreamAlias("REGCLIENTECONTACTO")
public class Contacto {
    @XStreamAlias("IDREGISTRO")
    private String IDREGISTRO;
    @XStreamAlias("APELLIDOMATERNO")
    private String APELLIDOMATERNO;
    @XStreamAlias("APELLIDOPATERNO")
    private String APELLIDOPATERNO;
    @XStreamAlias("NOMBRES")
    private String NOMBRES;
    @XStreamAlias("CORREO")
    private String CORREO;
    @XStreamAlias("TELFCEL")
    private String TELFCEL;
    @XStreamAlias("DEPARTAMENTO")
    private String DEPARTAMENTO;
    @XStreamAlias("PROVINCIA")
    private String PROVINCIA;
    @XStreamAlias("DISTRITO")
    private String DISTRITO;
    @XStreamAlias("DIRECCION")
    private String DIRECCION;
    @XStreamAlias("DIRTELFFIJO")
    private String DIRTELFFIJO;
    @XStreamAlias("DIRTELFCEL")
    private String DIRTELFCEL;
    @XStreamAlias("IDCONT")
    private int IDCONT;
    @XStreamAlias("IDTIPO")
    private int IDTIPO;
    @XStreamAlias("DCODIGOPOSTAL")
    private String DCODIGOPOSTAL;
    @XStreamAlias("NRODOCUMENTO")
    private String NRODOCUMENTO;
    private String departamento_descripcion;
    private String provincia_descripcion;
    private String distrito_descripcio;
    
    public Contacto() {
    }

    public String getIDREGISTRO() {
        return IDREGISTRO;
    }

    public void setIDREGISTRO(String IDREGISTRO) {
        this.IDREGISTRO = IDREGISTRO;
    }

    public int getIDCONT() {
        return IDCONT;
    }

    public void setIDCONT(int IDCONT) {
        this.IDCONT = IDCONT;
    }

    public int getIDTIPO() {
        return IDTIPO;
    }

    public void setIDTIPO(int IDTIPO) {
        this.IDTIPO = IDTIPO;
    }

    public String getAPELLIDOMATERNO() {
        return APELLIDOMATERNO;
    }

    public void setAPELLIDOMATERNO(String APELLIDOMATERNO) {
        this.APELLIDOMATERNO = APELLIDOMATERNO;
    }

    public String getAPELLIDOPATERNO() {
        return APELLIDOPATERNO;
    }

    public void setAPELLIDOPATERNO(String APELLIDOPATERNO) {
        this.APELLIDOPATERNO = APELLIDOPATERNO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getTELFCEL() {
        return TELFCEL;
    }

    public void setTELFCEL(String TELFCEL) {
        this.TELFCEL = TELFCEL;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getPROVINCIA() {
        return PROVINCIA;
    }

    public void setPROVINCIA(String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getDIRTELFFIJO() {
        return DIRTELFFIJO;
    }

    public void setDIRTELFFIJO(String DIRTELFFIJO) {
        this.DIRTELFFIJO = DIRTELFFIJO;
    }

    public String getDIRTELFCEL() {
        return DIRTELFCEL;
    }

    public void setDIRTELFCEL(String DIRTELFCEL) {
        this.DIRTELFCEL = DIRTELFCEL;
    }

    /**
     * @return the DCODIGOPOSTAL
     */
    public String getDCODIGOPOSTAL() {
        return DCODIGOPOSTAL;
    }

    /**
     * @param DCODIGOPOSTAL the DCODIGOPOSTAL to set
     */
    public void setDCODIGOPOSTAL(String DCODIGOPOSTAL) {
        this.DCODIGOPOSTAL = DCODIGOPOSTAL;
    }

    /**
     * @return the departamento_descripcion
     */
    public String getDepartamento_descripcion() {
        return departamento_descripcion;
    }

    /**
     * @param departamento_descripcion the departamento_descripcion to set
     */
    public void setDepartamento_descripcion(String departamento_descripcion) {
        this.departamento_descripcion = departamento_descripcion;
    }

    /**
     * @return the provincia_descripcion
     */
    public String getProvincia_descripcion() {
        return provincia_descripcion;
    }

    /**
     * @param provincia_descripcion the provincia_descripcion to set
     */
    public void setProvincia_descripcion(String provincia_descripcion) {
        this.provincia_descripcion = provincia_descripcion;
    }

    /**
     * @return the distrito_descripcio
     */
    public String getDistrito_descripcio() {
        return distrito_descripcio;
    }

    /**
     * @param distrito_descripcio the distrito_descripcio to set
     */
    public void setDistrito_descripcio(String distrito_descripcio) {
        this.distrito_descripcio = distrito_descripcio;
    }

    /**
     * @return the NRODOCUMENTO
     */
    public String getNRODOCUMENTO() {
        return NRODOCUMENTO;
    }

    /**
     * @param NRODOCUMENTO the NRODOCUMENTO to set
     */
    public void setNRODOCUMENTO(String NRODOCUMENTO) {
        this.NRODOCUMENTO = NRODOCUMENTO;
    }
}
