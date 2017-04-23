/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import java.util.Date;

/**
 *
 * @author jpretel
 */
public class DataTableColumn {
    private String header;
    private String property;
    private Date adicional1;
    private int adicional2;
    public DataTableColumn(String header, String property) {
        this.header = header;
        this.property = property;
    }
    
    public DataTableColumn(String header, String property, Date date) {
        this.header = header;
        this.property = property;
        this.adicional1 = date;
    }
    public DataTableColumn(String header, String property, Date date, int item) {
        this.header = header;
        this.property = property;
        this.adicional1 = date;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return the adicional1
     */
    public Date getAdicional1() {
        return adicional1;
    }

    /**
     * @param adicional1 the adicional1 to set
     */
    public void setAdicional1(Date adicional1) {
        this.adicional1 = adicional1;
    }
}
