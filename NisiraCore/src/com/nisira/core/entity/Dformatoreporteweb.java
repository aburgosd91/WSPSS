package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.List;

@XStreamAlias("DFORMATOREPORTEWEB")
@Tabla(nombre = "DFORMATOREPORTEWEB")
public class Dformatoreporteweb implements Serializable {

    @XStreamAlias("IDEMPRESA")
    @ClavePrimaria
    @Columna
    private String idempresa;
    @XStreamAlias("IDCLIEPROV")
    @ClavePrimaria
    @Columna
    private String idclieprov;
    @XStreamAlias("ITEM")
    @ClavePrimaria
    @Columna
    private String item;
    @XStreamAlias("ITEM2")
    @ClavePrimaria
    @Columna
    private String item2;
    @XStreamAlias("PARAMETRO")
    @Columna
    private String parametro;
    @XStreamAlias("ORDEN")
    @Columna
    private Integer orden;
    @XStreamAlias("NIVEL")
    @Columna
    private Integer nivel;
    @XStreamAlias("ALIAS")
    @Columna
    private String alias;
    @XStreamAlias("ETIQUETA")
    @Columna
    private String etiqueta;
    @XStreamOmitField
    private String tabla;
    @XStreamOmitField
    private List<String> col;
    /* Sets & Gets */
    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public String getIdempresa() {
        return this.idempresa;
    }

    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    public String getIdclieprov() {
        return this.idclieprov;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem2() {
        return this.item2;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getParametro() {
        return this.parametro;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getOrden() {
        return this.orden;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return this.nivel;
    }

    /* Sets & Gets FK*/
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        if (etiqueta.equalsIgnoreCase("T1")) {
            alias = "ORDENSERVICIOCLIENTE";
        }
        if (etiqueta.equalsIgnoreCase("T2")) {
            alias = "DORDENSERVICIOCLIENTE";
        }
        if (etiqueta.equalsIgnoreCase("T3")) {
            alias = "PERSONAL_SERVICIO";
        }
        if (etiqueta.equalsIgnoreCase("T4")) {
            alias = "CLIEPROV";
        }
        if (etiqueta.equalsIgnoreCase("T5")) {
            alias = "RUTAS";
        }
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
        if (tabla.equalsIgnoreCase("ORDENSERVICIOCLIENTE")) {
            alias = "T1";
        }
        if (tabla.equalsIgnoreCase("DORDENSERVICIOCLIENTE")) {
            alias = "T2";
        }
        if (tabla.equalsIgnoreCase("PERSONAL_SERVICIO")) {
            alias = "T3";
        }
        if (tabla.equalsIgnoreCase("CLIEPROV")) {
            alias = "T4";
        }
        if (tabla.equalsIgnoreCase("RUTAS")) {
            alias = "T5";
        }
    }

    public List<String> getCol() {
        return col;
    }

    public void setCol(List<String> col) {
        this.col = col;
    }

}
