/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.listener;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Antenor
 */
public class Conexion {
    protected Connection cn = null;
    protected PreparedStatement pr = null;
    protected CallableStatement cl = null;
    protected ResultSet rs = null;

    protected Connection obtenerConexion() throws Exception {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       return (DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AGRICOLACHAPI;", "sa", "amadeus2010"));

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
