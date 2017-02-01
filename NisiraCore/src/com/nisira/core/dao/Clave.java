/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import java.util.HashMap;

/**
 *
 * @author Antenor
 */
public class Clave {
    //usuario
//    static final String cadenaOriginal = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefrgihklmnopqstuvwxyz1234567890 .";
//    static final String cadenaEncriptado = "|°!#$%&/()=?¿<}~ÇüéâäàåçêëèïîìÄÅÉæÆôöòÿÖÜø£×ƒáíóúñÑª¿®,ÁÂÀ©¦ãÃ.";
//    static final String cadenaOriginal = "ABCDEFGHIJKLLLMNOPQRSTUVWXYZabcdefrgihklllmnopqrstuvwxyz1234567890 .";
//    static final String cadenaEncriptado = "|°!#$%&/()=?¡'¿<}~ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑª¿®¦ÁÂÀ©¦ãÃ.";
    
    static final String cadenaOriginal = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefrgihklmnopqstuvwxyz1234567890 .j";
    static final String cadenaEncriptado = "|°!#$%&/()=?¿<}~ÇüéâäàåçêëèïîìÄÅÉæÆôöòÿÖÜø£×ƒáíóúñÑª¿®¦ÁÂÀ©¦ãÃ.j";
    
    
    static final char[] charOriginal = cadenaOriginal.toCharArray();
    static final char[] charEncriptado = cadenaEncriptado.toCharArray();
    static final int numcaracteres = charOriginal.length;
    static HashMap rowDE;
    static HashMap rowED;


    public static void init(){
        rowDE = new HashMap();
        rowED = new HashMap();
        for(int i = 0;i<numcaracteres;i++)
        {
            rowDE.put(charOriginal[i],charEncriptado[i]);
            rowED.put(charEncriptado[i],charOriginal[i]);
        }
    }

    public static String Encriptar(String cadena){
        init();
        char[] charPassword = cadena.toCharArray();
        String encriptado = "";
        for(int i = 0;i<charPassword.length;i++)
        {
            encriptado = encriptado + rowDE.get(charPassword[i]);
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
    
    public static char[] especiales() {
		char[] especiales = new char[33];
		String a;

		a = "€";
		especiales[0] = a.charAt(0);
		
		especiales[1] = (char) 129;
		a = "‚";
		especiales[2] = a.charAt(0);
		a = "ƒ";
		especiales[3] = a.charAt(0);
		a = "„";
		especiales[4] = a.charAt(0);
		a = "…";
		especiales[5] = a.charAt(0);
		a = "†";
		especiales[6] = a.charAt(0);
		a = "‡";
		especiales[7] = a.charAt(0);
		a = "ˆ";
		especiales[8] = a.charAt(0);
		a = "‰";
		especiales[9] = a.charAt(0);
		a = "Š";
		especiales[10] = a.charAt(0);
		a = "‹";
		especiales[11] = a.charAt(0);
		a = "Œ";
		especiales[12] = a.charAt(0);
		especiales[13] = (char) 141;
		a = "Ž";
		especiales[14] = a.charAt(0);
		especiales[15] = (char) 143;
		especiales[16] = (char) 144;
		a = "‘";
		especiales[17] = a.charAt(0);
		a = "’";
		especiales[18] = a.charAt(0);
		a = "“";
		especiales[19] = a.charAt(0);
		a = "”";
		especiales[20] = a.charAt(0);
		a = "•";
		especiales[21] = a.charAt(0);
		a = "–";
		especiales[22] = a.charAt(0);
		a = "—";
		especiales[23] = a.charAt(0);
		a = "˜";
		especiales[24] = a.charAt(0);
		a = "™";
		especiales[25] = a.charAt(0);
		a = "š";
		especiales[26] = a.charAt(0);
		a = "›";
		especiales[27] = a.charAt(0);
		a = "œ";
		especiales[28] = a.charAt(0);
		especiales[29] = (char) 157;
		a = "ž";
		especiales[30] = a.charAt(0);
		a = "Ÿ";
		especiales[31] = a.charAt(0);
		especiales[32] = (char) 160;
                

		return especiales;
	}

	public static String desencripta_licencia(String textoenc) {
		String clave = ")&H%$V1#@^+=?/><:MN*-";
		//System.out.println(clave);
		String texto = "";
		int c = 0;

		for (int j = 0; j < textoenc.length(); j++) {
			char c1 = textoenc.charAt(j);
			char c2 = clave.charAt(c);
                        
			char[] especiales = especiales();
			int ind = -1;
			for (int x = 0; x < especiales.length; x++) {
				if (especiales[x] == c1) {
					ind = x;
					break;
				}
			}
			
			int v1_ = (ind==-1)?(int) c1:ind+128;

			int v1 = 256 + (int) v1_ - (int) c2;
			int letra = v1 % 256;
			c++;
			if (c >= clave.length() - 1)
				c = 0;

			texto = texto + (char) letra;
                        //System.out.print(c1);
                        //System.out.print(c2);
                        //System.out.print(texto);
//                        System.out.println(c1 + " " + c2 + " ------> " + texto);
                        
		}

		return texto;
	}


}
