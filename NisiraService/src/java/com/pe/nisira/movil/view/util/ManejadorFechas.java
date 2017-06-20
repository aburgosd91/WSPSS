/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Antenor
 */
public class ManejadorFechas {
    //Metodo usado para obtener la fecha actual
    //@return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"
    public static String getHoraMinActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }
    
     public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("HH");
        return formateador.format(ahora);
    }
     public static String getAnioActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
        return formateador.format(ahora);
    }
     public static String getMesActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("MM");
        return formateador.format(ahora);
    }
     
      public static String getMesActualsinCero() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("MM");
        return String.valueOf(Integer.parseInt(formateador.format(ahora)));
    }
     
    
     public static String getMinutoActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("mm");
       
        
       // System.out.println("minuu  "+formateador.format(ahora));
        Integer h = Integer.parseInt(formateador.format(ahora));
        return String.valueOf(h);
        
        
        
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }
    
    public static Date sumarFechasDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }
    
    public static Date sumarFechasDiasLaborales(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        int d=dias;
        for(int i=0;i<d+1;i++){
            if(getDiadeSemana(sumarFechasDias(fch, i))==7){
            d=d+2;
          }
        }
        cal.add(Calendar.DATE, d);
        return new java.sql.Date(cal.getTimeInMillis());
       }
    

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias
    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
    
    public static int diasLaboralesFechas(Date fechaInicial, Date fechaFinal) {

        Integer x = diferenciasDeFechas(fechaInicial, fechaFinal);
        Integer DiasL=x;
        for (int i=0;i<x+1;i++){
        
           if(getDiadeSemana(sumarFechasDias(fechaInicial, i))==7 || getDiadeSemana(sumarFechasDias(fechaInicial, i))==1){
               DiasL=DiasL-1;
           }
        }
        return DiasL;
    }
    
    

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public static int getDiadeSemana(Date d){
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	return cal.get(Calendar.DAY_OF_WEEK);		
    }
    //VAZLL
    public static String getFechaActualFormateada(String formato) {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat(formato);
        return formateador.format(ahora);
    }
    
    public static String getHoraMinActualFormateada(String formato) {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat(formato);
        return formateador.format(ahora);
    }
    
    public static String getNombreMesActual() {
         String m = getMesActual();
         int mes = 0;
         mes = Integer.parseInt(m);
         String nombremes = "";
         switch (mes){
            case 1: nombremes="Enero"; break;
            case 2: nombremes="Febrero";break;
            case 3: nombremes="Marzo";break;
            case 4: nombremes="Abril";break;
            case 5: nombremes="Mayo";break;
            case 6: nombremes="Junio";break;
            case 7: nombremes="Julio";break;        
            case 8: nombremes="Agosto";break;  
            case 9: nombremes="Setiembre";break;  
            case 10: nombremes="Octubre";break;  
            case 11: nombremes="Noviembre";break;  
            case 12: nombremes="Diciembre";break;  
                            
        }  
         return nombremes;                         
    }
    
    public static String getDiaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd");
        return formateador.format(ahora);
    }
       
    public static String getDiaDeLaSemana(Date d){        
        int dia=0;
        String dias="";
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	dia=cal.get(Calendar.DAY_OF_WEEK);		
        switch (dia){
            case 1: dias="Domingo"; break;
            case 2: dias="Lunes";break;
            case 3: dias="Martes";break;
            case 4: dias="Miercoles";break;
            case 5: dias="Jueves";break;
            case 6: dias="Viernes";break;
            case 7: dias="Sabado";break;        
        }                
        return dias;
    }
//--VAZLLL
    public static String getHoraMinSegundos(Date ahora) {        
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }
    
     public static String getHora(Date ahora) {        
        SimpleDateFormat formateador = new SimpleDateFormat("HH");
        return formateador.format(ahora);
    }
     public static String getAnio(Date ahora) {        
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
        return formateador.format(ahora);
    }
     public static String getMes(Date ahora) {        
        SimpleDateFormat formateador = new SimpleDateFormat("MM");
        return formateador.format(ahora);
    }
     
      public static String getMessinCero(Date ahora) {
        
        SimpleDateFormat formateador = new SimpleDateFormat("MM");
        return String.valueOf(Integer.parseInt(formateador.format(ahora)));
    }
     
    
     public static String getMinuto(Date ahora ) {        
        SimpleDateFormat formateador = new SimpleDateFormat("mm");       
        
       // System.out.println("minuu  "+formateador.format(ahora));
        Integer h = Integer.parseInt(formateador.format(ahora));
        return String.valueOf(h);                        
    }
    public static String getDia(Date ahora) {        
        SimpleDateFormat formateador = new SimpleDateFormat("dd");
        return formateador.format(ahora);
    }
    public static String getNombreMes(Date d) {
         String m = getMes(d);
         int mes = 0;
         mes = Integer.parseInt(m);
         String nombremes = "";
         switch (mes){
            case 1: nombremes="Enero"; break;
            case 2: nombremes="Febrero";break;
            case 3: nombremes="Marzo";break;
            case 4: nombremes="Abril";break;
            case 5: nombremes="Mayo";break;
            case 6: nombremes="Junio";break;
            case 7: nombremes="Julio";break;        
            case 8: nombremes="Agosto";break;  
            case 9: nombremes="Setiembre";break;  
            case 10: nombremes="Octubre";break;  
            case 11: nombremes="Noviembre";break;  
            case 12: nombremes="Diciembre";break;  
                            
        }  
         return nombremes;                         
    }
    public static String getFechaFormateada(Date ahora,String formato) {        
        SimpleDateFormat formateador = new SimpleDateFormat(formato);
        return formateador.format(ahora);
    }
    public static String getFechaHoraFormato(String datetime){        
//        datetime=datetime.replaceAll("\\s*$","");
        String formato="";
        String cadena="";
        for(int i=0;i<datetime.length();i++){
            if(datetime.charAt(i)=='/'){
                if(cadena.length()<2){
                    cadena="0"+cadena;
                }
                formato+=cadena+"-";
                cadena="";
            }
            else{
               cadena+=String.valueOf(datetime.charAt(i)); 
            }
        }
        formato+=cadena;
        return formato;
    }
}
