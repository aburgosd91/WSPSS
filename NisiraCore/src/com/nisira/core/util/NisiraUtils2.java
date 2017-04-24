package com.nisira.core.util;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class NisiraUtils2 {
	
	public static BigDecimal getBigDecimalValue(Object o) {
		
		if (o == null) {
			return BigDecimal.ZERO;
		}
		
		try {
			if (o instanceof String) {
				return new BigDecimal((String) o);
			}
			if (o instanceof Float || o instanceof Double) {
				return new BigDecimal(String.valueOf(o));
			}
			
			return new BigDecimal(String.valueOf(o));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BigDecimal.ZERO;
	}
	
	public static Float getFloatValue(Object o) {
		Float resultado = 0F;

		try {
			if (o instanceof String) {
				if ((isNull((String) o, "").isEmpty())) {
					resultado = 0F;
				} else {
					resultado = Float.parseFloat((String) o);
				}
			} else {
				resultado = (Float) o;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return resultado;
	}

	public static Double getDoubleValue(Object o) {

		String prefix = "###,###,###,###,##0.00000000000000";
		DecimalFormatSymbols decimalSymbols = new DecimalFormatSymbols();

		decimalSymbols.setDecimalSeparator('.');
		decimalSymbols.setGroupingSeparator(',');
		DecimalFormat decimalFormat = new DecimalFormat(prefix, decimalSymbols);
		
		Double resultado = 0.0;

		try {
			if (o instanceof String) {
				if ((isNull((String) o, "").isEmpty())) {
					resultado = 0.0;
				} else {
					
//					String valor = decimalFormat.format((String) o);
					resultado =  Double.parseDouble(((String) o).replace(",", ""));//(Double) decimalFormat.parse(valor); // ;
				}
			} else {
				resultado = (Double) o;
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return resultado;
	}

	public static Integer getIntegerValue(Object o) {
		Integer resultado = 0;

		try {
			if (o instanceof String) {
				if ((isNull((String) o, "").isEmpty())) {
					resultado = 0;
				} else {
					resultado = Integer.parseInt((String) o);
				}
			} else {
				resultado = (Integer) o;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return resultado;
	}

	public static BigDecimal getBigDecimal(Float o) {
		String val = String.valueOf(o);
		return new BigDecimal(val);
	}

	public static BigDecimal getBigDecimal(Double o) {
		String val = String.valueOf(o);
		return new BigDecimal(val);
	}

	public static Boolean isNull(Boolean in, Boolean result) {
		if (in == null) {
			return result;
		} else {
			return in;
		}
	}

	public static Double isNull(Double in, Double result) {
		if (in == null) {
			return result;
		} else {
			return in;
		}
	}

	public static boolean isNullOrEmpty(String in) {
		if (in == null) {
			return true;
		} else {
			return in.isEmpty();
		}
	}

	public static String isNull(String in, String result) {
		if (in == null) {
			return result;
		} else {
			return in;
		}
	}

	public static Integer isNull(Integer in, Integer result) {
		if (in == null) {
			return result;
		} else {
			return in;
		}
	}

	public static Float isNull(Float in, Float result) {
		if (in == null) {
			return result;
		} else {
			return in;
		}
	}

	// public static Date getHoraInicial(Date fecha) {
	// if (fecha == null)
	// return null;
	//
	// Calendar c = Calendar.getInstance();
	// c.setTime(fecha);
	//
	// c.set(Calendar.HOUR_OF_DAY, 0);
	// c.set(Calendar.MINUTE, 0);
	// c.set(Calendar.SECOND, 0);
	// c.set(Calendar.MILLISECOND, 0);
	//
	// return c.getTime();
	// }
	//
	// public static Date getHoraFinal(Date fecha) {
	// if (fecha == null)
	// return null;
	//
	// Calendar c = Calendar.getInstance();
	// c.setTime(fecha);
	//
	// c.set(Calendar.HOUR_OF_DAY, 23);
	// c.set(Calendar.MINUTE, 59);
	// c.set(Calendar.SECOND, 59);
	// c.set(Calendar.MILLISECOND, 997);
	//
	// return c.getTime();
	// }

	public static String getXMLString(Document document, String encoding) {
		StringWriter writer = new StringWriter();
		Source source = new DOMSource(document);
		StreamResult result = new StreamResult(writer);
		Transformer transformer;
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		// transformerFactory.setAttribute("indent-number", 4);
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
			transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		Charset utf8charset = Charset.forName("UTF-8");
		Charset iso88591charset = Charset.forName("ISO-8859-1");

		ByteBuffer inputBuffer = ByteBuffer.wrap(writer.toString().getBytes());
		CharBuffer data = utf8charset.decode(inputBuffer);

		ByteBuffer outputBuffer = iso88591charset.encode(data);
		byte[] outputData = outputBuffer.array();
		return new String(outputData, iso88591charset);
	}

}
