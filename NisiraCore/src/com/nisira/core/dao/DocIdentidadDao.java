/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.core.entity.DocIdentidad;
import com.nisira.framework.core.dao.EntityDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejndro zamora
 */
public class DocIdentidadDao extends EntityDao<DocIdentidad> {

    @Override
    public DocIdentidad find(DocIdentidad e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DocIdentidad> findAll(Object e) throws Exception {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DocIdentidad> findAll() throws Exception {
        ArrayList<DocIdentidad> l = new ArrayList<DocIdentidad>();
        try {
            String sql = "GETTABLES_RETURNDOCIDENTIDAD";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                DocIdentidad di = new DocIdentidad();
                di.setIddocidentidad(rs.getString("IDDOCIDENTIDAD"));
                di.setDescripcion(rs.getString("DESCRIPCION"));
                l.add(di);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrar(cn, cl, rs);
        }

        return l;
    }

    public List<Object[]> lstDepartamentos() throws Exception {
        List<Object[]> lst = new ArrayList<Object[]>();
        String sql = "select * from DEPARTAMENTO";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        // pr.setString(1, e.toString());
        rs = pr.executeQuery();
        while (rs.next()) {
            Object[] r = new Object[2];
            r[0] = rs.getString("IDDEPARTAMENTO");
            r[1] = rs.getString("DESCRIPCION");
            lst.add(r);
        }
        return lst;
    }
    public Object[] lstDepartamentos(String filtro) throws Exception {
        Object[] r = null;
        String sql = "select * from DEPARTAMENTO where '"+filtro.trim()+"' like '%'+DESCRIPCION+'%'";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        // pr.setString(1, e.toString());
        rs = pr.executeQuery();
        while (rs.next()) {
            r = new Object[2];
            r[0] = rs.getString("IDDEPARTAMENTO");
            r[1] = rs.getString("DESCRIPCION");
        }
        return r;
    }

    public List<Object[]> lstProvincia(Object e) throws Exception {
        List<Object[]> lst = new ArrayList<Object[]>();
        String sql = "select * from PROVINCIAS where IDDEPARTAMENTO = ?";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        pr.setString(1, e.toString());
        rs = pr.executeQuery();
        while (rs.next()) {
            Object[] r = new Object[2];
            r[0] = rs.getString("IDPROVINCIA");
            r[1] = rs.getString("DESCRIPCION");
            lst.add(r);
        }
        return lst;
    }
    
    public List<Object[]> lstCiudad(Object e1,Object e2) throws Exception {
        List<Object[]> lst = new ArrayList<Object[]>();
        String sql = "select * from UBIGEO where IDDEPARTAMENTO = ? AND IDPROVINCIA = ?";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        pr.setString(1, e1.toString());
        pr.setString(2, e2.toString());
        rs = pr.executeQuery();
        while (rs.next()) {
            Object[] r = new Object[2];
            r[0] = rs.getString("IDUBIGEO").substring(rs.getString("IDUBIGEO").length()-2, rs.getString("IDUBIGEO").length());
            r[1] = rs.getString("DESCRIPCION");
            lst.add(r);
        }
        return lst;
    }
    public List<Object[]> lstCiudad(Object e) throws Exception {
        List<Object[]> lst = new ArrayList<Object[]>();
        String sql = "select * from UBIGEO where IDUBIGEO like ?";
        cn = obtenerConexionJTDS();
        pr = cn.prepareStatement(sql);
        pr.setString(1, e.toString()+ "%");
        rs = pr.executeQuery();
        while (rs.next()) {
            Object[] r = new Object[2];
            r[0] = rs.getString("IDUBIGEO");
            r[1] = rs.getString("DESCRIPCION");
            lst.add(r);
        }
        return lst;
    }
}
