/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.util;

/**
 *
 * @author jpretel
 */
public class ColumnModel {
    private String header;
    private int width;
    private int orden;

    public ColumnModel(String header, int width, int orden) {
        this.header = header;
        this.width = width;
        this.orden = orden;
    }
    
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
