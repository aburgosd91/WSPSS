/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import com.nisira.core.entity.Configsmtp;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.nisira.security.Encryption;
/**
 *
 * @author aburgos
 */
public class EmailSenderService {
    private final Properties properties = new Properties();

	// private String password;

    private Session session;

    private void init() {
            Configsmtp cfg = Constantes.configsmtp;
            properties.put("mail.smtp.host", cfg.getMail_smtp_host());
            properties.put("mail.smtp.starttls.enable", cfg.getMail_smtp_starttls_enable());
            properties.put("mail.smtp.port", cfg.getMail_smtp_port());
            properties.put("mail.smtp.mail.sender", cfg.getMail_smtp_mail_sender());
            properties.put("mail.smtp.user", cfg.getMail_smtp_user());
            properties.put("mail.smtp.auth", cfg.getMail_smtp_auth());
            properties.put("mail.smtp.ssl.trust",cfg.getMail_smtp_host());
//            properties.put("mail.smtp.socketFactory.port", cfg.getMail_smtp_port());
//            properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

            session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(String destinatario, String asunto,
                    String htmlmensaje, String nomadjunto, File fileadjunto) throws Exception{
        init();
        String sender = Constantes.configsmtp.getMail_smtp_mail_sender();/*remitente */
        String user = Constantes.configsmtp.getMail_smtp_user();/*remitente */
        String copy = Constantes.configsmtp.getCC();
//        String password = Encryption.decrypt(Constantes.configsmtp.getMail_smtp_password());/*remitente clave */
        String password = Constantes.configsmtp.getMail_smtp_password();/*remitente clave */
        BodyPart texto = new MimeBodyPart();
        texto.setContent(htmlmensaje, "text/html; charset=utf-8");
        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(fileadjunto.getAbsolutePath())));/*adjunto*/
        //adjunto.setFileName(nomadjunto + ".pdf");/*cambiar nombre de archivo*/
        adjunto.setFileName(nomadjunto);
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));

        String[] correos = destinatario.split(";");
        String[] correos_copy = copy.split(";");

        Address[] addresses = new Address[correos.length+correos_copy.length];
        int tc =0;
        for (int i = 0;i < correos.length; i++) {
            String correo = correos[i];
            addresses[i] = new InternetAddress(correo);
            tc++;
        }
        for(int j=0;j<correos_copy.length;j++){
            String correo_copy = correos_copy[j];
            addresses[tc] = new InternetAddress(correo_copy);
            tc++;
        }
        
        message.addRecipients(Message.RecipientType.TO, addresses);

        message.setSubject(asunto);
        message.setContent(multiParte);
        Transport t = session.getTransport("smtp");
        t.connect(user, password);

        t.sendMessage(message, message.getAllRecipients());
        t.close();

    }
    public void sendEmail(String destinatario, String asunto,
                    String htmlmensaje) throws Exception{
        init();
        String sender = Constantes.configsmtp.getMail_smtp_mail_sender();/*remitente */
        String user = Constantes.configsmtp.getMail_smtp_user();/*remitente */
        String copy = Constantes.configsmtp.getCC();
        String password = Constantes.configsmtp.getMail_smtp_password();/*remitente clave */
        
        BodyPart texto = new MimeBodyPart();
        texto.setContent(htmlmensaje, "text/html; charset=utf-8");
        
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));

        String[] correos = destinatario.split(";");
        String[] correos_copy = copy.split(";");

        Address[] addresses = new Address[correos.length+correos_copy.length];
        int tc =0;
        for (int i = 0;i < correos.length; i++) {
            String correo = correos[i];
            addresses[i] = new InternetAddress(correo);
            tc++;
        }
        for(int j=0;j<correos_copy.length;j++){
            String correo_copy = correos_copy[j];
            addresses[tc] = new InternetAddress(correo_copy);
            tc++;
        }        
        message.addRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(asunto);
        message.setContent(multiParte);
        Transport t = session.getTransport("smtp");
        t.connect(user, password);

        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
    public void sendEmailHTML(String destinatario, String asunto, String htmlmensaje) throws Exception {
            init();

            String sender = Constantes.configsmtp.getMail_smtp_mail_sender();
            String user = Constantes.configsmtp.getMail_smtp_user();

            String password = Encryption.decrypt(Constantes.configsmtp.getMail_smtp_password());

            BodyPart texto = new MimeBodyPart();
            texto.setContent(htmlmensaje, "text/html; charset=utf-8");

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

            message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(user, password);

            t.sendMessage(message, message.getAllRecipients());
            t.close();
    }
}
