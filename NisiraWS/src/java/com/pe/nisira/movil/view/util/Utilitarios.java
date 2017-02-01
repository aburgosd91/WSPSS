/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class Utilitarios {
    private final static int RND_MAX_SIZE = 1048576;

    public static String newID(String prefix) {
            Random rnd = new Random(new Date().getTime());

            String newID = prefix + rnd.nextInt(RND_MAX_SIZE);

            return newID;
    }

    public static void addToZipFile(String ruta, String fileName, ZipOutputStream zos)
                    throws FileNotFoundException, IOException {

            //File file = new File(fileName);
            FileInputStream fis = new FileInputStream(ruta);
            ZipEntry zipEntry = new ZipEntry(fileName);

            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                    zos.write(bytes, 0, length);
            }

            zos.closeEntry();
            fis.close();
    }

    public static void escribirArchivo(String ruta, String contenido, String codificacion)
                    throws IOException {
//		Charset iso88591charset = Charset.forName(codificacion);
//		FileWriter w = null;
//
//		w = new FileWriter(ruta);
//		String value = new String (contenido.getBytes(iso88591charset), codificacion);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(ruta), codificacion));

            PrintWriter wr = new PrintWriter(bw);

            wr.append(contenido);

            wr.close();

            bw.close();
    }

    public static void escribirArchivo(String ruta, String contenido)
                    throws IOException {
            FileWriter w = null;

            w = new FileWriter(ruta);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);

            wr.append(contenido);

            wr.close();

            bw.close();
    }

    public static String FileToBase64(File file) throws IOException {
            FileInputStream fis;

            fis = new FileInputStream(file);

            byte[] buff = new byte[(int) file.length()];
            fis.read(buff);
            String base64 = new sun.misc.BASE64Encoder().encode(buff);

            fis.close();
            return base64;
    }

    public static String FilePathToBase64(String pathFile) throws IOException {
            byte[]  archivoBytes = Files.readAllBytes(new File(pathFile).toPath());
            String base64 = new sun.misc.BASE64Encoder().encode(archivoBytes);

            return base64;
    }

    public static String FilePath_textoContenido(String pathFile) throws IOException {
            byte[]  archivoBytes = Files.readAllBytes(new File(pathFile).toPath()); 
            String str = new String(archivoBytes, StandardCharsets.UTF_8);

            return str;
    }

}
