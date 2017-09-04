package com.pe.nisira.movil.view.bean;

import com.pe.nisira.movil.view.util.WebUtil;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ConsultaWeb {

	public static String[] ConsultaRUC(String ruc) throws Exception {
		String[] datos = new String[6];
                /*
                    - RUC [0]
                    - RAZON SOCIAL [1]
                    - DIRECCION [2]
                    - DEPARTAMENTO [3]
                    - PROVINCIA [4]
                    - DISTRITO [5]
                    - TIPO DOCUMENTO [6] -> FIJO 2
                    - NOMBRE COMERCIAL [7]
                    - ESTADO DE CONTRIBUYENTE [8]
                    - 
                */

		String captcha = "";

		Connection.Response res = Jsoup.connect("http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha")
				.data("accion", "random").method(Method.GET).execute();

		Map<String, String> cookie = res.cookies();

		captcha = res.parse().select("body").text();

		Document dRuc = Jsoup.connect("http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias")
				.data("accion", "consPorRuc").data("nroRuc", ruc).data("actReturn", "1").data("numRnd", captcha)
				.cookies(cookie).get();

		Element table = dRuc.select("TABLE[class = form-table]").first();
		Elements rows = table.select("tr");
		int i = 0;

		datos[0] = ruc;
		for (Element e : rows) {
			if (e.children().size() > 1) {
				Element td = e.child(1);
                                Element tdc = e.child(0);
				if (i == 0) {
					datos[1] = td.text().substring(14, td.text().length());
				}
				int idireccion = (datos[0].startsWith("20") ? 6 : 7);
				if (i == idireccion) {// Direccion
                                    if (td.text().length() > 7) {
                                            String direccion = td.text().trim();
                                            String[] partes = direccion.split("-");
                                            if (partes.length >= 3) {
                                                    datos[2] = "";// Direccion
                                                    for (int ii = 0; ii <= partes.length - 3; ii++) {
                                                            datos[2] = datos[2] + (datos[2].isEmpty() ? "" : "-") + partes[ii].trim();
                                                    }
                                                    datos[3] = partes[partes.length - 3].trim();// departamento
                                                    datos[4] = partes[partes.length - 2].trim();// provincia
                                                    datos[5] = partes[partes.length - 1].trim();// distrito
                                            } else {
                                                    datos[2] = td.text();// Dirección
                                                    datos[3] = "";// departamento
                                                    datos[4] = "";// provincia
                                                    datos[5] = "";// distrito
                                            }
                                            // break;
                                    }
				}
			}
			i += 1;
		}
		return datos;
	}
        public static String[] ConsultaRUC_FOX(String ruc) throws Exception {
		String[] datos = new String[16];
                /*
                    - RUC [0]
                    - RAZON SOCIAL [1]
                    - DIRECCION [2]
                    - DEPARTAMENTO [3]
                    - PROVINCIA [4]
                    - DISTRITO [5]
                    - TIPOPERSONA[6] -> FIJO 2
                    - TIPO DOCUMENTO [7] -> FIJO 2
                    - NOMBRE COMERCIAL [8]
                    - ESTADO DE CONTRIBUYENTE [9]
                    - CONDICIÓN_SUNAT [10]
                    - DNI [11]
                    - CIIU [12]
                    - APELLIDOPATERNO[13]
                    - APELLIDOMATERNO[14]
                    - NOMBRES[15]
                */

		String captcha = "";

		Connection.Response res = Jsoup.connect("http://www.sunat.gob.pe/cl-ti-itmrconsruc/captcha")
				.data("accion", "random").method(Method.GET).execute();

		Map<String, String> cookie = res.cookies();

		captcha = res.parse().select("body").text();

		Document dRuc = Jsoup.connect("http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias")
				.data("accion", "consPorRuc").data("nroRuc", ruc).data("actReturn", "1").data("numRnd", captcha)
				.cookies(cookie).get();

		Element table = dRuc.select("TABLE[class = form-table]").first();
		Elements rows = table.select("tr");
		int i = 0;
                String value="";
                String header ="";
		datos[0] = ruc;
		for (Element e : rows) {
			if (e.children().size() > 1) {
                            Element td = e.child(1);
                            Element tdc = e.child(0);
                            header =  WebUtil.isnull(tdc.text(),"").trim();
                            value =  WebUtil.isnull(td.text(),"").trim();
                            switch(header){
                                case "Número de RUC:":
                                    datos[0] = value.split("-")[0].trim();
                                    datos[1] = value.split("-")[1].trim();
                                    break;
                                case "Tipo Contribuyente:":
                                    datos[6] = datos[0].trim().startsWith("20")?"1":"2";
                                    ;break;
                                case "Tipo de Documento:":
                                    datos[7] = "01";
                                    datos[11] = (value.trim().split("-")[0]).split(" ")[1].trim();
                                    
                                    datos[13] = datos[1].trim().split(" ")[0];
                                    datos[14] = datos[1].trim().split(" ")[1];
                                    int longitud= datos[1].trim().split(" ")[0].length() + datos[1].trim().split(" ")[1].length();
                                    datos[15] = datos[1].trim().substring(longitud+2, datos[1].trim().length());
                                    ;break;
                                case "Nombre Comercial:":
                                    datos[8] = value.trim();
                                    ;break;
                                case "Estado del Contribuyente:":
                                    datos[9] = value.trim();
                                    ;break;
                                case "Condición del Contribuyente:":
                                    datos[10] = value.trim();
                                    ;break;
                                case "Dirección del Domicilio Fiscal:":
                                    if (td.text().length() > 7) {
                                            String direccion = td.text().trim();
                                            String[] partes = direccion.split("-");
                                            if (partes.length >= 3) {
                                                    datos[2] = "";// Direccion
                                                    for (int ii = 0; ii <= partes.length - 3; ii++) {
                                                        datos[2] = datos[2] + (datos[2].isEmpty() ? "" : "-") + partes[ii].trim();
                                                    }
                                                    datos[3] = partes[partes.length - 3].trim();// departamento
                                                    datos[4] = partes[partes.length - 2].trim();// provincia
                                                    datos[5] = partes[partes.length - 1].trim();// distrito
                                            } else {
                                                    datos[2] = td.text();// Dirección
                                                    datos[3] = "";// departamento
                                                    datos[4] = "";// provincia
                                                    datos[5] = "";// distrito
                                            }
                                            // break;
                                    }
                                    ;break; 
                                    case "Actividad(es) Económica(s):":
                                        datos[12] = value.trim().split("-")[1].trim();
                                    ;break;
                            }
			}
			i += 1;
		}
		return datos;
	}
	public static void main(String[] args) throws Exception {
            for (String c : ConsultaRUC_FOX("20100025915")) {
                    System.out.println(c);
            }
	}
        // Nisira 20314727500
        //10470957099
}