/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.util;
/**
 *
 * @author Victor Zavala.
 */
public class ConstantesBD {
    public static final String BDPRINCIPAL="CHAPI";
//    public static final String BDPRINCIPAL="AGRICOLACHAPI";
//    public static final String BDPRINCIPAL="FILMPACK";
    public static String BDCONECCION;
    public static String IDEMPRESA;
    public static String TIPOSINCRO;
    public static String getIDEMPRESA() {
        return IDEMPRESA;
    }

    public static void setIDEMPRESA(String IDEMPRESA) {
        ConstantesBD.IDEMPRESA = IDEMPRESA;
    }
    

    public static String getBDCONECCION() {
        return BDCONECCION;
    }

    public static void setBDCONECCION(String BDCONECCION) {
        ConstantesBD.BDCONECCION = BDCONECCION;
    }

    public static String getTIPOSINCRO() {
        return TIPOSINCRO;
    }

    public static void setTIPOSINCRO(String aTIPOSINCRO) {
        TIPOSINCRO = aTIPOSINCRO;
    }
    
}
