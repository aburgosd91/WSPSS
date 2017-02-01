/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;
import java.io.Serializable;
/**
 *
 * @author aburgos
 */
public class ConfigWeb implements Serializable{
    private int idempresa;
    private int idsucursal;
    private String disco;/*C:\*/
    private String path;/*\SOLUTION\WEB*/
    private String imgplant;
    /**
     * @return the idempresa
     */
    public int getIdempresa() {
        return idempresa;
    }

    /**
     * @param idempresa the idempresa to set
     */
    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    /**
     * @return the idsucursal
     */
    public int getIdsucursal() {
        return idsucursal;
    }

    /**
     * @param idsucursal the idsucursal to set
     */
    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    /**
     * @return the disco
     */
    public String getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(String disco) {
        this.disco = disco;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the imgplant
     */
    public String getImgplant() {
        return imgplant;
    }

    /**
     * @param imgplant the imgplant to set
     */
    public void setImgplant(String imgplant) {
        this.imgplant = imgplant;
    }

}
