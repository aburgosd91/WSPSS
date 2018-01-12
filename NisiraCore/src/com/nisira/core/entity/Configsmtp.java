/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;

/**
 *
 * @author aburgos
 */
@Tabla(nombre = "CONFIGSMTP")
public class Configsmtp implements Serializable{
    private String idbasedatos;
    private static final long serialVersionUID = 1L;
    @ClavePrimaria
    @Columna(nombre = "IDEMPRESA")
    private String idempresa;
    @ClavePrimaria
    @Columna(nombre = "IDCONFIG")
    private String idconfig;
    @Columna(nombre = "TIPO")
    private String tipo;
    @Columna(nombre = "MAIL_SMTP_HOST")
    private String mail_smtp_host;/*SERVIDOR: SMTP.com*/
    @Columna(nombre = "MAIL_SMTP_STARTTLS_ENABLE")
    private String mail_smtp_starttls_enable;/*true/false*/
    @Columna(nombre = "MAIL_SMTP_PORT")
    private String mail_smtp_port;/*puerto*/
    @Columna(nombre = "MAIL_SMTP_MAIL_SENDER")
    private String mail_smtp_mail_sender;/*remitente correo*/
    @Columna(nombre = "MAIL_SMTP_USER")
    private String mail_smtp_user;/*remitente correo*/
    @Columna(nombre = "MAIL_SMTP_AUTH")
    private String mail_smtp_auth;/*true*/
    @Columna(nombre = "MAIL_SMTP_PASSWORD")
    private String mail_smtp_password;/*remitente*/
    @Columna(nombre = "ASUNTO")
    private String asunto;/*asunto*/
    @Columna(nombre = "MENSAJE")
    private String mensaje;/*mensaje*/
    @Columna(nombre = "CC")
    private String CC;/*mensaje*/
    @Columna(nombre = "DESCRIPCION")
    private String descripcion;/*mensaje*/
    @Columna(nombre = "ESTADO")
    private Float estado;
    /* Sets & Gets */
    public void setIdempresa(String idempresa) {
            this.idempresa = idempresa;
    }

    public String getIdempresa() {
            return this.idempresa;
    }
    public void setIdconfig(String idconfig) {
            this.idconfig = idconfig;
    }

    public String getIdconfig() {
            return this.idconfig;
    }
    public void setMail_smtp_host(String mail_smtp_host) {
            this.mail_smtp_host = mail_smtp_host;
    }

    public String getMail_smtp_host() {
            return this.mail_smtp_host;
    }

    public void setMail_smtp_starttls_enable(String mail_smtp_starttls_enable) {
            this.mail_smtp_starttls_enable = mail_smtp_starttls_enable;
    }

    public String getMail_smtp_starttls_enable() {
            return this.mail_smtp_starttls_enable;
    }

    public void setMail_smtp_port(String mail_smtp_port) {
            this.mail_smtp_port = mail_smtp_port;
    }

    public String getMail_smtp_port() {
            return this.mail_smtp_port;
    }

    public void setMail_smtp_mail_sender(String mail_smtp_mail_sender) {
            this.mail_smtp_mail_sender = mail_smtp_mail_sender;
    }

    public String getMail_smtp_mail_sender() {
            return this.mail_smtp_mail_sender;
    }

    public void setMail_smtp_user(String mail_smtp_user) {
            this.mail_smtp_user = mail_smtp_user;
    }

    public String getMail_smtp_user() {
            return this.mail_smtp_user;
    }

    public void setMail_smtp_auth(String mail_smtp_auth) {
            this.mail_smtp_auth = mail_smtp_auth;
    }

    public String getMail_smtp_auth() {
            return this.mail_smtp_auth;
    }

    public void setMail_smtp_password(String mail_smtp_password) {
            this.mail_smtp_password = mail_smtp_password;
    }

    public String getMail_smtp_password() {
            return this.mail_smtp_password;
    }

    public void setAsunto(String asunto) {
            this.asunto = asunto;
    }

    public String getAsunto() {
            return this.asunto;
    }

    public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
    }

    public String getMensaje() {
            return this.mensaje;
    }
    /* Sets & Gets FK*/
    /*-Inicio-*/
//    @Override
//    public String[] checksumCamposExpcecion() {
//            return null;
//    }
	/*-Fin-*/

    /**
     * @return the idbasedatos
     */
    public String getIdbasedatos() {
        return idbasedatos;
    }

    /**
     * @param idbasedatos the idbasedatos to set
     */
    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

    /**
     * @return the CC
     */
    public String getCC() {
        return CC;
    }

    /**
     * @param CC the CC to set
     */
    public void setCC(String CC) {
        this.CC = CC;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public Float getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Float estado) {
        this.estado = estado;
    }
}
