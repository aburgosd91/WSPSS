/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.dao;

import com.nisira.framework.core.dao.EntityDao;
import com.nisira.core.entity.Privilegios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PrivilegiosDao extends EntityDao<Privilegios> {

    @Override
    public Privilegios find(Privilegios e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List<Privilegios> findAll(Object e) throws Exception {
        
        List<Privilegios> lista = new ArrayList<Privilegios>();
       
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL [nspPrivilegiosall_S](?)}");
            cl.setString(1, e.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
              
                Privilegios col = new Privilegios();
                col.setIdempresa(rs.getString("idempresa"));
                col.setIdusuario(rs.getString("idusuario"));
                col.setFormulario(rs.getString("formulario"));
                col.setItem(rs.getString("item"));
                col.setIdarea(rs.getString("idarea"));
                col.setAcu_mex(rs.getDouble("acu_mex"));
                col.setAcu_mof(rs.getDouble("acu_mof"));
                col.setImp_mof(rs.getDouble("imp_mof"));
                col.setImp_mex(rs.getDouble("imp_mex"));
                col.setT_periodo(rs.getString("t_periodo"));
                col.setConsulta(rs.getDouble("Consulta"));
                col.setV1(rs.getDouble("v1"));
                col.setV2(rs.getDouble("v2"));
                col.setV3(rs.getDouble("v3"));
                col.setAprueba(rs.getDouble("aprueba"));
                col.setRechaza(rs.getDouble("rechaza"));
                col.setIdmoneda(rs.getString("idmoneda"));
                col.setPresupuesta(rs.getDouble("presupuesta"));
                col.setAprueba_smf(rs.getDouble("aprueba_smf"));
                col.setImp_min_mex(rs.getDouble("imp_min_mex"));
                col.setImp_min_mof(rs.getDouble("imp_min_mof"));
                lista.add(col);
                
            }
        } finally {

            cerrar(cn, cl, rs);
        }
        return lista;
    }

    @Override
    public List<Privilegios> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Privilegios> buscar(String usuario, String orden) throws Exception {
        
        List<Privilegios> lista = new ArrayList<Privilegios>();
       
        try {
            cn = obtenerConexion();
            cl = cn.prepareCall("{CALL [nspPrivilegios_S](?,?)}");
            cl.setString(1, usuario.toString());
            cl.setString(2, orden.toString());
            rs = cl.executeQuery();
            while (rs.next()) {
              
                Privilegios col = new Privilegios();
                col.setIdempresa(rs.getString("idempresa"));
                col.setIdusuario(rs.getString("idusuario"));
                col.setFormulario(rs.getString("formulario"));
                col.setItem(rs.getString("item"));
                col.setIdarea(rs.getString("idarea"));
                col.setAcu_mex(rs.getDouble("acu_mex"));
                col.setAcu_mof(rs.getDouble("acu_mof"));
                col.setImp_mof(rs.getDouble("imp_mof"));
                col.setImp_mex(rs.getDouble("imp_mex"));
                col.setT_periodo(rs.getString("t_periodo"));
                col.setConsulta(rs.getDouble("Consulta"));
                col.setV1(rs.getDouble("v1"));
                col.setV2(rs.getDouble("v2"));
                col.setV3(rs.getDouble("v3"));
                col.setAprueba(rs.getDouble("aprueba"));
                col.setRechaza(rs.getDouble("rechaza"));
                col.setIdmoneda(rs.getString("idmoneda"));
                col.setPresupuesta(rs.getDouble("presupuesta"));
                col.setAprueba_smf(rs.getDouble("aprueba_smf"));
                col.setImp_min_mex(rs.getDouble("imp_min_mex"));
                col.setImp_min_mof(rs.getDouble("imp_min_mof"));
                lista.add(col);
                
            }
        } finally {

            cerrar(cn, cl, rs);
        }
        return lista;
    }
}
