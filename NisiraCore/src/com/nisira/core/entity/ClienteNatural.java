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
@XStreamAlias("REGCLIENTENATURAL")
public class ClienteNatural {
    @XStreamAlias("IDDOCIDENTIDAD")
    private String IDDOCIDENTIDAD;
    @XStreamAlias("APELLIDOMATERNO")
    private String APELLIDOMATERNO;
    @XStreamAlias("APELLIDOPATERNO")
    private String APELLIDOPATERNO;
    @XStreamAlias("NOMBRES")
    private String NOMBRES;
    @XStreamAlias("DEPARTAMENTO")
    private String DEPARTAMENTO;
    @XStreamAlias("PROVINCIA")
    private String PROVINCIA;
    @XStreamAlias("DISTRITO")
    private String DISTRITO;	
    @XStreamAlias("DIRECCION")
    private String DIRECCION;	
    @XStreamAlias("CODIGOPOSTAL")
    private String CODIGOPOSTAL;
    @XStreamAlias("TELFFIJO")
    private String TELFFIJO;
    @XStreamAlias("TELFCEL")
    private String TELFCEL;	
    @XStreamAlias("IDTIPOSERVICIO")
    private int IDTIPOSERVICIO;
    @XStreamAlias("TIPDOCSERVICIO")
    private String TIPDOCSERVICIO;	
    @XStreamAlias("PUBLICDATA")
    private int PUBLICDAT;
    @XStreamAlias("EMAIL")
    private String EMAIL;
    public ClienteNatural() {
    }

    public String getIDDOCIDENTIDAD() {
        return IDDOCIDENTIDAD;
    }

    public void setIDDOCIDENTIDAD(String IDDOCIDENTIDAD) {
        this.IDDOCIDENTIDAD = IDDOCIDENTIDAD;
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

    public String getCODIGOPOSTAL() {
        return CODIGOPOSTAL;
    }

    public void setCODIGOPOSTAL(String CODIGOPOSTAL) {
        this.CODIGOPOSTAL = CODIGOPOSTAL;
    }

    public String getTELFFIJO() {
        return TELFFIJO;
    }

    public void setTELFFIJO(String TELFFIJO) {
        this.TELFFIJO = TELFFIJO;
    }

    public String getTELFCEL() {
        return TELFCEL;
    }

    public void setTELFCEL(String TELFCEL) {
        this.TELFCEL = TELFCEL;
    }

    public int getIDTIPOSERVICIO() {
        return IDTIPOSERVICIO;
    }

    public void setIDTIPOSERVICIO(int IDTIPOSERVICIO) {
        this.IDTIPOSERVICIO = IDTIPOSERVICIO;
    }

    public String getTIPDOCSERVICIO() {
        return TIPDOCSERVICIO;
    }

    public void setTIPDOCSERVICIO(String TIPDOCSERVICIO) {
        this.TIPDOCSERVICIO = TIPDOCSERVICIO;
    }

    public int getPUBLICDAT() {
        return PUBLICDAT;
    }

    public void setPUBLICDAT(int PUBLICDAT) {
        this.PUBLICDAT = PUBLICDAT;
    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    
}
