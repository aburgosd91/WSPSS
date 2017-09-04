/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
@XStreamAlias("REGCLIENTEJURIDICO")
public class ClienteJuridico {
    @XStreamAlias("IDDOCIDENTIDAD")
    private String IDDOCIDENTIDAD;
    @XStreamAlias("RAZON_SOCIAL")
    private String RAZON_SOCIAL;
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
    @XStreamAlias("OBJETOSOCIAL")
    private String OBJETOSOCIAL;
    @XStreamAlias("REGPODERES")
    private String REGPODERES;
    @XStreamAlias("PUBLICDATA")
    private int PUBLICDATA;
    /*DATOS SUNAT*/
    @XStreamAlias("TIPOPERSONA")
    private int TIPOPERSONA;
    @XStreamAlias("DDEPARTAMENTO")
    private String DDEPARTAMENTO;
    @XStreamAlias("DPROVINCIA")
    private String DPROVINCIA;
    @XStreamAlias("DDISTRITO")
    private String DDISTRITO;
    @XStreamAlias("IDDOCIDENTIDAD_SUNAT")
    private String IDDOCIDENTIDAD_SUNAT;
    @XStreamAlias("DNI")
    private String DNI;
    @XStreamAlias("NOMBRE_COMERCIAL")
    private String NOMBRE_COMERCIAL;
    @XStreamAlias("CIIU")
    private String CIIU;
    @XStreamAlias("ESTADO_SUNAT")
    private String ESTADO_SUNAT;
    @XStreamAlias("CONDICION_SUNAT")
    private String CONDICION_SUNAT;
    
    @XStreamAlias("APELLIDOPATERNO")
    private String APELLIDOPATERNO;
    @XStreamAlias("APELLIDOMATERNO")
    private String APELLIDOMATERNO;
    @XStreamAlias("NOMBRES")
    private String NOMBRES;
    public ClienteJuridico() {
    }

    public String getIDDOCIDENTIDAD() {
        return IDDOCIDENTIDAD;
    }

    public void setIDDOCIDENTIDAD(String IDDOCIDENTIDAD) {
        this.IDDOCIDENTIDAD = IDDOCIDENTIDAD;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
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

    public String getOBJETOSOCIAL() {
        return OBJETOSOCIAL;
    }

    public void setOBJETOSOCIAL(String OBJETOSOCIAL) {
        this.OBJETOSOCIAL = OBJETOSOCIAL;
    }

    public String getREGPODERES() {
        return REGPODERES;
    }

    public void setREGPODERES(String REGPODERES) {
        this.REGPODERES = REGPODERES;
    }

    public int getPUBLICDATA() {
        return PUBLICDATA;
    }

    public void setPUBLICDATA(int PUBLICDATA) {
        this.PUBLICDATA = PUBLICDATA;
    }

    /**
     * @return the TIPOPERSONA
     */
    public int getTIPOPERSONA() {
        return TIPOPERSONA;
    }

    /**
     * @param TIPOPERSONA the TIPOPERSONA to set
     */
    public void setTIPOPERSONA(int TIPOPERSONA) {
        this.TIPOPERSONA = TIPOPERSONA;
    }

    /**
     * @return the DDEPARTAMENTO
     */
    public String getDDEPARTAMENTO() {
        return DDEPARTAMENTO;
    }

    /**
     * @param DDEPARTAMENTO the DDEPARTAMENTO to set
     */
    public void setDDEPARTAMENTO(String DDEPARTAMENTO) {
        this.DDEPARTAMENTO = DDEPARTAMENTO;
    }

    /**
     * @return the DPROVINCIA
     */
    public String getDPROVINCIA() {
        return DPROVINCIA;
    }

    /**
     * @param DPROVINCIA the DPROVINCIA to set
     */
    public void setDPROVINCIA(String DPROVINCIA) {
        this.DPROVINCIA = DPROVINCIA;
    }

    /**
     * @return the DDISTRITO
     */
    public String getDDISTRITO() {
        return DDISTRITO;
    }

    /**
     * @param DDISTRITO the DDISTRITO to set
     */
    public void setDDISTRITO(String DDISTRITO) {
        this.DDISTRITO = DDISTRITO;
    }

    /**
     * @return the IDDOCIDENTIDAD_SUNAT
     */
    public String getIDDOCIDENTIDAD_SUNAT() {
        return IDDOCIDENTIDAD_SUNAT;
    }

    /**
     * @param IDDOCIDENTIDAD_SUNAT the IDDOCIDENTIDAD_SUNAT to set
     */
    public void setIDDOCIDENTIDAD_SUNAT(String IDDOCIDENTIDAD_SUNAT) {
        this.IDDOCIDENTIDAD_SUNAT = IDDOCIDENTIDAD_SUNAT;
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
     * @return the NOMBRE_COMERCIAL
     */
    public String getNOMBRE_COMERCIAL() {
        return NOMBRE_COMERCIAL;
    }

    /**
     * @param NOMBRE_COMERCIAL the NOMBRE_COMERCIAL to set
     */
    public void setNOMBRE_COMERCIAL(String NOMBRE_COMERCIAL) {
        this.NOMBRE_COMERCIAL = NOMBRE_COMERCIAL;
    }

    /**
     * @return the CIIU
     */
    public String getCIIU() {
        return CIIU;
    }

    /**
     * @param CIIU the CIIU to set
     */
    public void setCIIU(String CIIU) {
        this.CIIU = CIIU;
    }

    /**
     * @return the ESTADO_SUNAT
     */
    public String getESTADO_SUNAT() {
        return ESTADO_SUNAT;
    }

    /**
     * @param ESTADO_SUNAT the ESTADO_SUNAT to set
     */
    public void setESTADO_SUNAT(String ESTADO_SUNAT) {
        this.ESTADO_SUNAT = ESTADO_SUNAT;
    }

    /**
     * @return the CONDICION_SUNAT
     */
    public String getCONDICION_SUNAT() {
        return CONDICION_SUNAT;
    }

    /**
     * @param CONDICION_SUNAT the CONDICION_SUNAT to set
     */
    public void setCONDICION_SUNAT(String CONDICION_SUNAT) {
        this.CONDICION_SUNAT = CONDICION_SUNAT;
    }

    /**
     * @return the APELLIDOPATERNO
     */
    public String getAPELLIDOPATERNO() {
        return APELLIDOPATERNO;
    }

    /**
     * @param APELLIDOPATERNO the APELLIDOPATERNO to set
     */
    public void setAPELLIDOPATERNO(String APELLIDOPATERNO) {
        this.APELLIDOPATERNO = APELLIDOPATERNO;
    }

    /**
     * @return the APELLIDOMATERNO
     */
    public String getAPELLIDOMATERNO() {
        return APELLIDOMATERNO;
    }

    /**
     * @param APELLIDOMATERNO the APELLIDOMATERNO to set
     */
    public void setAPELLIDOMATERNO(String APELLIDOMATERNO) {
        this.APELLIDOMATERNO = APELLIDOMATERNO;
    }

    /**
     * @return the NOMBRES
     */
    public String getNOMBRES() {
        return NOMBRES;
    }

    /**
     * @param NOMBRES the NOMBRES to set
     */
    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

}
