/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import com.nisira.core.util.CoreUtil;
import com.nisira.utils.CantLetras;
import com.nisira.utils.NisiraStringUtils;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

/**
 *
 * @author aburgos
 */
public class UtilScriplet extends JRDefaultScriptlet {
    public static void main(String[] args) {
//		EConexion e = new EConexion();
//		e.BASEDATOS = "MASTEREDOC";
//		e.CLAVE = "amadeus2010";
//		e.INSTANCIA = "nisira";
//		e.USUARIO = "sa";
//		e.SERVIDOR = "192.168.0.29";
//		e.TIPO = "MSSQL";
//
//		CoreUtil.conexiones.put("default", e);
//
//		System.out.println(descripcionMoneda("PEN", "1"));
//		UtilScriplet u = new UtilScriplet();
//		System.out.println(u.decimalFormat(new BigDecimal("765680.99"), 2));
		UtilScriplet u = new UtilScriplet();
		System.out.println(u.getLetras(101101));
	}

	public Integer primerDiaMes(String mes, String anno) throws JRScriptletException {
		          Calendar cal = new GregorianCalendar();
		cal.set(Integer.parseInt(anno), Integer.parseInt(mes) - 1, 1);
		int num = cal.get(Calendar.DAY_OF_WEEK);
		return num;
	}

	public Integer numeroDiaMes(String mes, String anno) throws JRScriptletException {
		Calendar cal = new GregorianCalendar();
		cal.set(Integer.parseInt(anno), Integer.parseInt(mes) - 1, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		int num = cal.get(Calendar.DAY_OF_MONTH);
		return num;
	}

	public String getLetras(Object value) {
		if (value == null)
			return null;
		return CantLetras.convertNumberToLetter(String.valueOf(value), "");
	}

//	public String getLetrasI(Object value) {
//		if (value == null)
//			return null;
//
//                BigDecimal numero = new BigDecimal(String.valueOf(value));
//
//		BigDecimal entera = new BigDecimal(numero.intValue());
//
//		return EnglishNumberToWords.convert(numero.intValue()).toUpperCase() + " AND "
//				+ NisiraStringUtils.padl(numero.subtract(entera).multiply(new BigDecimal("100.0")).intValue(), 2, '0')
//				+ "/100";
//	}

	public String getNumeroSerieDoc(Object numero) {
		return NisiraStringUtils.padl((int) numero, 7, '0');
	}

	public String formatDate(Date fecha, String formato) {
		return new SimpleDateFormat(formato).format(fecha);
	}

//	public static String descripcionMoneda(String idmonedasunat, String i) {
//		MonedaDao monedaDao = new MonedaDao();
//		String simbolo = "";
//		String descripcion = "";
//		Moneda moneda = null;
//		try {
//			moneda = monedaDao.getPorIdMonedaSunat(idmonedasunat);
//		} catch (NisiraORMException e) {
//
//		}
//
//		if (moneda == null) {
//			simbolo = idmonedasunat;
//			descripcion = idmonedasunat;
//		} else {
//			simbolo = moneda.getSimbolo();
//			descripcion = moneda.getDescripcion();
//		}
//		if (i.equals("0")) {
//			return simbolo;
//		} else
//			return descripcion;
//	}

	public static BigDecimal getBigDecimalValue(Float valor) {
		if (valor == null) {
			return BigDecimal.ZERO;
		}
		return new BigDecimal(String.valueOf(valor));
	}
	
	public static BigDecimal getBigDecimalValue(Double valor) {
		if (valor == null) {
			return BigDecimal.ZERO;
		}
		return new BigDecimal(String.valueOf(valor));
	}

	public static String decimalFormat(char sMiles, char sDecimales, Object numero, int decimales) {
		if (numero == null)
			return NisiraStringUtils.decimalFormat(sMiles, sDecimales, BigDecimal.ZERO, decimales);
		return NisiraStringUtils.decimalFormat(sMiles, sDecimales, numero, decimales);
	}

	public static String decimalFormat(Object numero, int decimales) {
		if (numero == null)
			return NisiraStringUtils.decimalFormat(',', '.', BigDecimal.ZERO, decimales);
		return NisiraStringUtils.decimalFormat(',', '.', numero, decimales);
	}
	
	public static Boolean iguales(String s1, String s2) {
		s1 = CoreUtil.isNull(s1,"");
		s2 = CoreUtil.isNull(s2,"");
		return s1.equalsIgnoreCase(s2);
		
	}

}
