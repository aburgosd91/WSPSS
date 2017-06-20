/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

/**
 *
 * @author aburgos
 */
public class ComboEspecial implements Comparable<ComboEspecial>{
    private String idordenservicio;
        private String documento_razon;
        public ComboEspecial(String id,String descripcion){
            this.idordenservicio = id;
            this.documento_razon = descripcion;
        }

        /**
         * @return the idordenservicio
         */
        public String getIdordenservicio() {
            return idordenservicio;
        }

        /**
         * @param idordenservicio the idordenservicio to set
         */
        public void setIdordenservicio(String idordenservicio) {
            this.idordenservicio = idordenservicio;
        }

        /**
         * @return the documento_razon
         */
        public String getDocumento_razon() {
            return documento_razon;
        }

        /**
         * @param documento_razon the documento_razon to set
         */
        public void setDocumento_razon(String documento_razon) {
            this.documento_razon = documento_razon;
        }
    @Override
    public String toString() {
        return "ComboEspecial [idordenservicio=" + idordenservicio + ", documento_razon=" + documento_razon
                + "]";
    } 
    @Override
    public int compareTo(ComboEspecial o) {
        if(idordenservicio.contentEquals(o.getIdordenservicio()) && documento_razon.contentEquals(o.getDocumento_razon()))  
            return 0 ; 
        return 1;
    }
}
