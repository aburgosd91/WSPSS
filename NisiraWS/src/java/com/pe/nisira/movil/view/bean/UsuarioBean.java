/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Antenor
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {
    
    @NotNull
    //@Size(min = 1, max= 15 )
    private String IDEMPRESA;
    private String IDUSUARIO;
    @NotNull
    //@Size(min = 1, max= 15 )
    private String PASSWORD;
    private int ESTADO;
    private String FECHAREGISTRO;
    private String EMAIL;
    private String IDPERSONA;
    private String CODIGOINTERNO;
    //campos auxiliares modulo cambiar password;
    private String OLDPASSWORD;
    private String PASSWORD1;
    private String PASSWORD2;
    private List<String[]> access;
    private String TIPOSINCRO;
    private String h;
    private String w;
    private int time;
    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getFECHAREGISTRO() {
        return FECHAREGISTRO;
    }

    public void setFECHAREGISTRO(String FECHAREGISTRO) {
        this.FECHAREGISTRO = FECHAREGISTRO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getIDPERSONA() {
        return IDPERSONA;
    }

    public void setIDPERSONA(String IDPERSONA) {
        this.IDPERSONA = IDPERSONA;
    }

    public String getCODIGOINTERNO() {
        return CODIGOINTERNO;
    }

    public void setCODIGOINTERNO(String CODIGOINTERNO) {
        this.CODIGOINTERNO = CODIGOINTERNO;
    }

    public String getOLDPASSWORD() {
        return OLDPASSWORD;
    }

    public void setOLDPASSWORD(String OLDPASSWORD) {
        this.OLDPASSWORD = OLDPASSWORD;
    }

    public String getPASSWORD1() {
        return PASSWORD1;
    }

    public void setPASSWORD1(String PASSWORD1) {
        this.PASSWORD1 = PASSWORD1;
    }

    public String getPASSWORD2() {
        return PASSWORD2;
    }

    public void setPASSWORD2(String PASSWORD2) {
        this.PASSWORD2 = PASSWORD2;
    }

    public String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public void setIDEMPRESA(String IDEMPRESA) {
        this.IDEMPRESA = IDEMPRESA;
    }

    public List<String[]> getAccess() {
        return access;
    }

    public void setAccess(List<String[]> access) {
        this.access = access;
    }

    public String getTIPOSINCRO() {
        return TIPOSINCRO;
    }

    public void setTIPOSINCRO(String TIPOSINCRO) {
        this.TIPOSINCRO = TIPOSINCRO;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
