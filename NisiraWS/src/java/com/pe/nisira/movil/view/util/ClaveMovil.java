/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import static com.pe.nisira.movil.view.util.Encryption.decrypt;
import static com.pe.nisira.movil.view.util.Encryption.encrypt;
import java.util.HashMap;

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class ClaveMovil {
    static HashMap rowDE;
    static HashMap rowED;
    static HashMap rowDE_ASCII;
    static HashMap rowED_ASCII;
    public static void init(){
        rowDE = new HashMap();
        rowED = new HashMap();

        String original;String encryptado;
        try{
            original = "A";encryptado = "|";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "B";encryptado = "?";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "C";encryptado = "!";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "D";encryptado = "#";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "E";encryptado = "$";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "F";encryptado = "%";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "G";encryptado = "&";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "H";encryptado = "/";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "I";encryptado = "(";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "J";encryptado = ")";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "K";encryptado = "=";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "L";encryptado = "?";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "M";encryptado = "¿";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "N";encryptado = "<";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "O";encryptado = "}";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "P";encryptado = "~";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "Q";encryptado = "Ç";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "R";encryptado = "ü";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "S";encryptado = "é";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "T";encryptado = "â";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "U";encryptado = "ä";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "V";encryptado = "à";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "W";encryptado = "å";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "X";encryptado = "ç";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "Y";encryptado = "ê";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "Z";encryptado = "ë";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "a";encryptado = "è";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "b";encryptado = "ï";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "c";encryptado = "î";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "d";encryptado = "ì";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "e";encryptado = "Ä";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "f";encryptado = "Å";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "r";encryptado = "É";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "g";encryptado = "æ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "i";encryptado = "Æ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "h";encryptado = "ô";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "k";encryptado = "ö";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "l";encryptado = "ò";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "m";encryptado = "ÿ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "n";encryptado = "Ö";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "o";encryptado = "Ü";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "p";encryptado = "ø";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "q";encryptado = "£";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "s";encryptado = "×";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "t";encryptado = "ƒ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "u";encryptado = "á";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "v";encryptado = "í";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "w";encryptado = "ó";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "x";encryptado = "ú";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "y";encryptado = "ñ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "z";encryptado = "Ñ";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "1";encryptado = "ª";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "2";encryptado = "¿";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "3";encryptado = "®";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "4";encryptado = "¦";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "5";encryptado = "Á";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "6";encryptado = "Â";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "7";encryptado = "À";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "8";encryptado = "©";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "9";encryptado = "¦";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = "0";encryptado = "ã";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = " ";encryptado = "Ã";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
            original = ".";encryptado = ".";rowDE.put(new String(original.getBytes("UTF-8"), "ISO-8859-15"),new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"));rowED.put(new String(encryptado.getBytes("UTF-8"), "ISO-8859-15"),new String(original.getBytes("UTF-8"), "ISO-8859-15"));
        }catch (Exception ex){
            String mensaje = ex.toString();
            mensaje.toString();
        }
    }

    public static String Encriptar(String cadena) {
        init();
        char[] charPassword = cadena.toCharArray();
        String encriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            Character caracter = charPassword[i];
            String caracter_encryptado = rowDE.get(caracter.toString()).toString();
            //String caracter_encryptado = rowDE.get(caracter).toString();
            //encriptado = encriptado + caracter_encryptado;
            try {
                caracter_encryptado = new String(caracter_encryptado.getBytes("ISO-8859-15"),"UTF-8");
                encriptado = encriptado + caracter_encryptado;
            }catch (Exception ex){
                String error = ex.toString();
                error.toString();
            }

        }
        return encriptado;
    }

    public static String Desencriptar(String cadena){
        init();
        char[] charPassword = cadena.toCharArray();
        String desencriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            desencriptado = desencriptado + rowED.get(charPassword[i]);
        }
        return desencriptado;
    }
    
    /*ANTEREOR*/
    static final String cadenaOriginal = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefrgihklmnopqstuvwxyz1234567890 .";
    static final String cadenaEncriptado = "|°!#$%&/()=?¿<}~ÇüéâäàåçêëèïîìÄÅÉæÆôöòÿÖÜø£×ƒáíóúñÑª¿®¦ÁÂÀ©¦ãÃ.";
    
    static final char[] charOriginal = cadenaOriginal.toCharArray();
//    static final char[] charEncriptado = cadenaEncriptado.toCharArray();
    static final char[] charEncriptado={'|','°','!','#','$','%','&','/','(',')','=','?',
        '¿','<','}','~','Ç','ü','é','â','ä','à','å','ç','ê','ë','è','ï','î','ì','Ä','Å','É','æ','Æ','ô','ö','ò','ÿ','Ö','Ü','ø','£','×',
        'ƒ','á','í','ó','ú','ñ','Ñ','ª','¿','®','¦','Á','Â','À','©','¦','ã','Ã','.'};
    static final int[] cadenaOriginalASCII=cadenaAscii(cadenaOriginal);
    static final int[] cadenaEncriptadoASCII=cadenaAscii(cadenaEncriptado);
    static final int numcaracteres = charOriginal.length;
    
    public static void init_ant(){
        rowDE = new HashMap();
        rowED = new HashMap();
        for(int i = 0;i<numcaracteres;i++)
        {
            rowDE.put(charOriginal[i],charEncriptado[i]);
            rowED.put(charEncriptado[i],charOriginal[i]);
        }
    }
    public static String Encriptar_ant(String cadena){
        init_ant();
        char[] charPassword = cadena.toCharArray();
        String encriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            encriptado = encriptado + rowDE.get(charPassword[i]);
        }
        return encriptado;
    }
    public static String Desencriptar_ant(String cadena){
        init_ant();
        char[] charPassword = cadena.toCharArray();
        String desencriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            desencriptado = desencriptado + rowED.get(charPassword[i]);
        }
        return desencriptado;
    }
    public static int[] cadenaAscii(String charEncriptado){
        int logitud=charEncriptado.length();
        int cadenaEncriptadoASCII[] =new int[logitud];
        for(int i=0;i<logitud;i++){
            cadenaEncriptadoASCII[i]=(int)charEncriptado.charAt(i);
//            System.out.println(charEncriptado.charAt(i)+" <-> "+cadenaEncriptadoASCII[i]);
        }
        return cadenaEncriptadoASCII;
    }
    public static void init_ASCII(){
        rowDE_ASCII = new HashMap();
        rowED_ASCII = new HashMap();
        for(int i = 0;i<numcaracteres;i++)
        {
            rowDE_ASCII.put(charOriginal[i],cadenaEncriptadoASCII[i]);
            rowED_ASCII.put(cadenaEncriptadoASCII[i],charOriginal[i]);
        }
    }
    public static String Encriptar_ASCII(String cadena){
        init_ASCII();
        char[] charPassword = cadena.toCharArray();
        //int[] charPassword = cadenaAscii(cadena);
        String encriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            encriptado = encriptado + ((char)((int)rowDE_ASCII.get(charPassword[i])));
        }
        return encriptado;
    }

    public static String Desencriptar_ASCII(String cadena){
        init_ASCII();
//        char[] charPassword = cadena.toCharArray()
        int[] charPassword = cadenaAscii(cadena);
        String desencriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            desencriptado = desencriptado + rowED_ASCII.get(charPassword[i]);
        }
        return desencriptado;
    }
    public static void main(String[] args) {
        String cadena="~èÁÁóÜÉì¿ãªÁ";
//        String encrypt=Encriptar_ASCII(cadena);
        String desencripter=Desencriptar_ant(cadena);
//        System.out.println("encrypted string:" + encrypt);
        System.out.println("decrypted value:" + desencripter);
    }
}
