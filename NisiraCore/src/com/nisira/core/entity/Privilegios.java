/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import java.util.List;

/**
 *
 * @author Antenor
 */
public class Privilegios {
    private static final long serialVersionUID = 1L;
    private String idempresa;
    private String idusuario;
    private String formulario;
    private String item;
    private String idarea;
    private double acu_mex;
    private double acu_mof;
    private double imp_mof;
    private double imp_mex;
    private String t_periodo;
    private double consulta;
    private double v1;
    private double v2;
    private double v3;
    private double aprueba;
    private double rechaza;
    private String idmoneda;
    private double presupuesta;
    private double aprueba_smf;
    private double imp_min_mex;
    private double imp_min_mof;
    private List<Privilegios> listaPrivilegios;

    public Privilegios() {
    }

    public Privilegios(String idarea) {
        this.idarea = idarea;
    }

    public Privilegios(String idempresa, String idusuario, String formulario, String item, String idarea, double acu_mex, double acu_mof, double imp_mof, double imp_mex, String t_periodo, double consulta, double v1, double v2, double v3, double aprueba, double rechaza, String idmoneda, double presupuesta, double aprueba_smf, double imp_min_mex, double imp_min_mof, List<Privilegios> listaPrivilegios) {
        this.idempresa = idempresa;
        this.idusuario = idusuario;
        this.formulario = formulario;
        this.item = item;
        this.idarea = idarea;
        this.acu_mex = acu_mex;
        this.acu_mof = acu_mof;
        this.imp_mof = imp_mof;
        this.imp_mex = imp_mex;
        this.t_periodo = t_periodo;
        this.consulta = consulta;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.aprueba = aprueba;
        this.rechaza = rechaza;
        this.idmoneda = idmoneda;
        this.presupuesta = presupuesta;
        this.aprueba_smf = aprueba_smf;
        this.imp_min_mex = imp_min_mex;
        this.imp_min_mof = imp_min_mof;
        this.listaPrivilegios = listaPrivilegios;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdarea() {
        return idarea;
    }

    public void setIdarea(String idarea) {
        this.idarea = idarea;
    }

    public double getAcu_mex() {
        return acu_mex;
    }

    public void setAcu_mex(double acu_mex) {
        this.acu_mex = acu_mex;
    }

    public double getAcu_mof() {
        return acu_mof;
    }

    public void setAcu_mof(double acu_mof) {
        this.acu_mof = acu_mof;
    }

    public double getImp_mof() {
        return imp_mof;
    }

    public void setImp_mof(double imp_mof) {
        this.imp_mof = imp_mof;
    }

    public double getImp_mex() {
        return imp_mex;
    }

    public void setImp_mex(double imp_mex) {
        this.imp_mex = imp_mex;
    }

    public String getT_periodo() {
        return t_periodo;
    }

    public void setT_periodo(String t_periodo) {
        this.t_periodo = t_periodo;
    }

    public double getConsulta() {
        return consulta;
    }

    public void setConsulta(double consulta) {
        this.consulta = consulta;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public double getV3() {
        return v3;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public double getAprueba() {
        return aprueba;
    }

    public void setAprueba(double aprueba) {
        this.aprueba = aprueba;
    }

    public double getRechaza() {
        return rechaza;
    }

    public void setRechaza(double rechaza) {
        this.rechaza = rechaza;
    }

    public String getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    public double getPresupuesta() {
        return presupuesta;
    }

    public void setPresupuesta(double presupuesta) {
        this.presupuesta = presupuesta;
    }

    public double getAprueba_smf() {
        return aprueba_smf;
    }

    public void setAprueba_smf(double aprueba_smf) {
        this.aprueba_smf = aprueba_smf;
    }

    public double getImp_min_mex() {
        return imp_min_mex;
    }

    public void setImp_min_mex(double imp_min_mex) {
        this.imp_min_mex = imp_min_mex;
    }

    public double getImp_min_mof() {
        return imp_min_mof;
    }

    public void setImp_min_mof(double imp_min_mof) {
        this.imp_min_mof = imp_min_mof;
    }

    public List<Privilegios> getListaPrivilegios() {
        return listaPrivilegios;
    }

    public void setListaPrivilegios(List<Privilegios> listaPrivilegios) {
        this.listaPrivilegios = listaPrivilegios;
    }
    
    
}
