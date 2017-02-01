/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.util.Constantes;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *         
 */
public class Conexion {
    protected Connection cn = null;
    protected PreparedStatement pr = null;
    protected CallableStatement cl = null;
    protected ResultSet rs = null;
    //protected String[] valoresBD=CoreUtil.valoresBase();
    protected ArrayList<String> valoresBD=CoreUtil.valoresBase();
    /*
    String servidor_name = "172.168.1.194";
    String inst_servidor = "";
    
    String user_servidor = "sa";    
    String pass_servidor = "amadeus2010";
    */
    protected Connection obtenerConexionEspecial() throws Exception {
        // System.out.println("conexionEspecial BD en USO " + ConstantesBD.getBDCONECCION());
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        //   System.out.println("conexion BD en USO " + ConstantesBD.getBDCONECCION());
        // VER    return (DriverManager.getConnection("jdbc:jtds:sqlserver://"+valoresBD[0]+"/"+ConstantesBD.getBDCONECCION()+";user="+valoresBD[1]+";password="+valoresBD[2]+";"));
        if (valoresBD.get(1).equalsIgnoreCase("--")) {
            return (DriverManager.getConnection("jdbc:jtds:sqlserver://" + valoresBD.get(0) + ":1433/" + ConstantesBD.getBDCONECCION() + ";user=" + valoresBD.get(2) + ";password=" + valoresBD.get(3) + ";"));
        } else {
            String url = "jdbc:jtds:sqlserver://"+valoresBD.get(0)+";instance="+valoresBD.get(1)+";DatabaseName="+ ConstantesBD.getBDCONECCION();
            //  return (DriverManager.getConnection("jdbc:jtds:sqlserver://" + valoresBD[0] + ";instance="+valoresBD[5]+" ;DatabaseName= " + ConstantesBD.getBDCONECCION() + "; user=" + valoresBD[1] + ";password=" + valoresBD[2] + ";"));
            return (DriverManager.getConnection(url, valoresBD.get(2), valoresBD.get(3)));
        }   
    }
     protected Connection obtenerConexionJTDS() throws Exception {
        String servidor_name = valoresBD.get(0);
        String inst_servidor = valoresBD.get(1);
        String user_servidor = valoresBD.get(2);
        String pass_servidor_encryptada = valoresBD.get(3);
        String pass_servidor = Clave.Desencriptar(pass_servidor_encryptada);
        String db_servidor = valoresBD.get(4);//ConstantesBD.getBDCONECCION();

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
//        String cadena="jdbc:jtds:sqlserver://"+servidor_name+":1433/"+db_servidor+";user="+user_servidor+";password="+pass_servidor+";";
        String url = "jdbc:jtds:sqlserver://"+servidor_name+";instance="+inst_servidor+";DatabaseName="+ db_servidor+";user="+user_servidor+";password="+pass_servidor+";";
        return (DriverManager.getConnection(url));
//        return (DriverManager.getConnection("jdbc:jtds:sqlserver://"+servidor_name+";instance="+inst_servidor+";databaseName="+db_servidor+";", user_servidor, pass_servidor));
     }
     
     protected Connection obtenerConexionJTDS(String idbasedatos) throws Exception {
        String servidor_name = valoresBD.get(0);
        String inst_servidor = valoresBD.get(1);
        String user_servidor = valoresBD.get(2);
        String pass_servidor_encryptada = valoresBD.get(3);
        String pass_servidor = Clave.Desencriptar(pass_servidor_encryptada);

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        return (DriverManager.getConnection("jdbc:jtds:sqlserver://"+servidor_name+";instance="+inst_servidor+";databaseName="+idbasedatos+";", user_servidor, pass_servidor));
    }


     protected Connection obtenerConexion() throws Exception {
        String servidor_name = valoresBD.get(0);
        String inst_servidor = valoresBD.get(1);
        String user_servidor = valoresBD.get(2);
        String pass_servidor_encryptada = valoresBD.get(3);
        String pass_servidor = Clave.Desencriptar(pass_servidor_encryptada);
        String db_servidor = ConstantesBD.getBDCONECCION();
        
        System.out.println("servidor_name: "+servidor_name);
        System.out.println("db_servidor: "+db_servidor);
        System.out.println("user_servidor: "+user_servidor);
        System.out.println("pass_servidor_encryptada: "+pass_servidor_encryptada);
        System.out.println("pass_servidor: "+pass_servidor);

        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return (DriverManager.getConnection("jdbc:sqlserver://"+inst_servidor+";databaseName="+db_servidor+";", user_servidor, pass_servidor));
    }

  
    protected void cerrar(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    protected void cerrar(Connection connection, PreparedStatement preparedStatement) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        if (preparedStatement != null) {
            preparedStatement.close();
            preparedStatement = null;
        }
    }

    protected void cerrar(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        if (preparedStatement != null) {
            preparedStatement.close();
            preparedStatement = null;
        }
        if (resultSet != null) {
            resultSet.close();
            resultSet = null;
        }
    }

    protected void cerrar(Connection connection, CallableStatement callableStatement) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        if (callableStatement != null) {
            callableStatement.close();
            callableStatement = null;
        }

    }

    protected void cerrar(Connection connection, CallableStatement callableStatement, ResultSet resultSet) throws Exception {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        if (callableStatement != null) {
            callableStatement.close();
            callableStatement = null;
        }
        if (resultSet != null) {
            resultSet.close();
            resultSet = null;
        }
    }

    protected void cerrar(ResultSet resultSet) throws Exception {
        if (resultSet != null) {
            resultSet.close();
            resultSet = null;
        }
    }

    protected void cerrar(PreparedStatement preparedStatement) throws Exception {
        if (preparedStatement != null) {
            preparedStatement.close();
            preparedStatement = null;
        }
    }

    protected void cerrar(CallableStatement callableStatement) throws Exception {
        if (callableStatement != null) {
            callableStatement.close();
            callableStatement = null;
        }
    }

    protected void rollback(Connection cn) {
        try {
            cn.rollback();
        } catch (Exception e) {
        }
    }
   

}
