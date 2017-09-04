/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.Regcliente_cuenta_deposito;
import com.nisira.framework.core.dao.EntityDao;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class Regcliente_cuenta_depositoDao extends EntityDao<Regcliente_cuenta_deposito>{

    @Override
    public Regcliente_cuenta_deposito find(Regcliente_cuenta_deposito e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Regcliente_cuenta_deposito> findAll(Object e) throws Exception {
        ArrayList<Regcliente_cuenta_deposito> l = new ArrayList<Regcliente_cuenta_deposito>();
        try {
            String sql = "GETREGCLIENTE_CUENTA_DEPOSITO_TMPSS";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?)}");
            cl.setObject(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
                Regcliente_cuenta_deposito di = new Regcliente_cuenta_deposito();
                di.setIDREGISTRO(rs.getString("IDREGISTRO")!=null?rs.getString("IDREGISTRO").trim():"");
                di.setBANCO(rs.getString("BANCO")!=null?rs.getString("BANCO").trim():"");
                di.setCUENTA(rs.getString("CUENTA")!=null?rs.getString("CUENTA").trim():"");
                di.setCODINTERBANCARIO(rs.getString("CODINTERBANCARIO")!=null?rs.getString("CODINTERBANCARIO").trim():"");
                di.setITEM(rs.getInt("ITEM"));
                l.add(di);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    @Override
    public List<Regcliente_cuenta_deposito> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
