/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;
import com.nisira.core.BaseDao;
import com.nisira.core.entity.Configsmtp;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aburgos
 */
public class ConfigsmtpDao extends BaseDao<Configsmtp> {
	public ConfigsmtpDao() {
		super(Configsmtp.class);
	}
	public ConfigsmtpDao(boolean usaCnBase) throws NisiraORMException {
		super(Configsmtp.class, usaCnBase);
	}

	public Configsmtp getPorClavePrimaria(String id) throws NisiraORMException {
		List<Configsmtp> l = listar("t0.id = ? ", id);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Configsmtp> listarPorEmpresaWeb() throws NisiraORMException {
            ArrayList<Configsmtp> lista = new ArrayList<Configsmtp>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GET_CONFIGSMTP_TMPSS");
            while (rs.next()) {
                Configsmtp configsmtp = new Configsmtp();
                configsmtp.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                configsmtp.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                configsmtp.setIdconfig(rs.getString("IDCONFIG")!=null?rs.getString("IDCONFIG").trim():"");
                configsmtp.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                configsmtp.setMail_smtp_host(rs.getString("MAIL_SMTP_HOST")!=null?rs.getString("MAIL_SMTP_HOST").trim():"");
                configsmtp.setMail_smtp_starttls_enable(rs.getString("MAIL_SMTP_STARTTLS_ENABLE")!=null?rs.getString("MAIL_SMTP_STARTTLS_ENABLE").trim():"");
                configsmtp.setMail_smtp_port(rs.getString("MAIL_SMTP_PORT")!=null?rs.getString("MAIL_SMTP_PORT").trim():"");
                configsmtp.setMail_smtp_mail_sender(rs.getString("MAIL_SMTP_MAIL_SENDER")!=null?rs.getString("MAIL_SMTP_MAIL_SENDER").trim():"");
                configsmtp.setMail_smtp_user(rs.getString("MAIL_SMTP_USER")!=null?rs.getString("MAIL_SMTP_USER").trim():"");
                configsmtp.setMail_smtp_auth(rs.getString("MAIL_SMTP_AUTH")!=null?rs.getString("MAIL_SMTP_AUTH").trim():"");
                configsmtp.setMail_smtp_password(rs.getString("MAIL_SMTP_PASSWORD")!=null?rs.getString("MAIL_SMTP_PASSWORD").trim():"");
                configsmtp.setAsunto(rs.getString("ASUNTO")!=null?rs.getString("ASUNTO").trim():"");
                configsmtp.setMensaje(rs.getString("MENSAJE")!=null?rs.getString("MENSAJE").trim():"");
                configsmtp.setCC(rs.getString("CC")!=null?rs.getString("CC").trim():"");
                configsmtp.setEstado(rs.getFloat("ESTADO"));
                lista.add(configsmtp);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
}
