/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import static com.nisira.utils.NisiraUtils.isNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Configsmtp;
import com.nisira.utils.NisiraStringUtils;
import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;

/**
 *
 * @author aburgos
 */
public class EnviarDocumentos {
    private SignaturePolicyService service;

    public EnviarDocumentos() throws MalformedURLException {
        
    }

    public static void enviarcorreo(String correo, File file, 
//            String nombre, 
//            String url,
            String serie_numero,String razon_social,String name_document)
                    throws Exception {

        Configsmtp cfg = Constantes.configsmtp;

        if (cfg == null) {
                throw new Exception("No existe configuración de correo electrónico");
        }

            String serienum = serie_numero;
            String doc = "Documento Cotización: " + serienum;
            String html = isNull(Constantes.configsmtp.getMensaje(), "").trim();

            html = html.replace("$$CLIENTE$$", razon_social);
            html = html.replace("$$DOCCLIENTE$$", serienum);
            html = html.replace("$$DOCUMENTO$$", serienum);
//            html = html.replace("$$EMPRESA$$", nombre);
//            html = html.replace("$$URL$$", url);

            EmailSenderService senderService = new EmailSenderService();

            senderService.sendEmail(correo, doc, html, name_document, file);

            System.out.println("Done");

    }
    public static void enviarcorreoMemo(String correo, File file,String serie_numero,String razon_social,String name_document)
                    throws Exception {

        Configsmtp cfg = Constantes.configsmtp;

        if (cfg == null) {
                throw new Exception("No existe configuración de correo electrónico");
        }

            String serienum = serie_numero;
            String doc = "Memorandum de Instalacion de la Cotizacion: " + serienum;
            String html = isNull(Constantes.configsmtp.getMensaje(), "").trim();

            html = html.replace("$$CLIENTE$$", razon_social);
            html = html.replace("$$DOCCLIENTE$$", serienum);
            html = html.replace("$$DOCUMENTO$$", serienum);
//            html = html.replace("$$EMPRESA$$", nombre);
//            html = html.replace("$$URL$$", url);

            EmailSenderService senderService = new EmailSenderService();

            senderService.sendEmail(correo, doc, html, name_document, file);

            System.out.println("Done");

    }
}
