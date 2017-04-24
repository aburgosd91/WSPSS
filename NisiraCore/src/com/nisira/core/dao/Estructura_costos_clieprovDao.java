package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_clieprovDao extends BaseDao<Estructura_costos_clieprov> {
	public Estructura_costos_clieprovDao() {
		super(Estructura_costos_clieprov.class);
	}
	public Estructura_costos_clieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_clieprov.class, usaCnBase);
	}

	public Estructura_costos_clieprov getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDCLIEPROV) throws NisiraORMException {
		List<Estructura_costos_clieprov> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDCLIEPROV = ? ", IDEMPRESA, CODIGO, IDCLIEPROV);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_clieprov> listarPorEmpresaWebXclieprov(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Estructura_costos_clieprov> lista = new ArrayList<Estructura_costos_clieprov>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_CLIEPROV_TMPSS",idempresa,idclieprov);
                while (rs.next()) {
                    Estructura_costos_clieprov estructura_costos_clieprov = new Estructura_costos_clieprov();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    estructura_costos_clieprov.setEstructuracostos(rs.getString("ESTRUCTURACOSTOS")!=null?rs.getString("ESTRUCTURACOSTOS").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_clieprov> listarPorEmpresaWebXcodigo(String idempresa,String codigo) throws NisiraORMException {
            ArrayList<Estructura_costos_clieprov> lista = new ArrayList<Estructura_costos_clieprov>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_CLIEPROV_TMPSS",idempresa,null,codigo);
                while (rs.next()) {
                    Estructura_costos_clieprov estructura_costos_clieprov = new Estructura_costos_clieprov();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    estructura_costos_clieprov.setEstructuracostos(rs.getString("ESTRUCTURACOSTOS")!=null?rs.getString("ESTRUCTURACOSTOS").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_clieprov> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Estructura_costos_clieprov> lista = new ArrayList<Estructura_costos_clieprov>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_CLIEPROV_TMPSS",idempresa);
                while (rs.next()) {
                    Estructura_costos_clieprov estructura_costos_clieprov = new Estructura_costos_clieprov();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    estructura_costos_clieprov.setEstructuracostos(rs.getString("ESTRUCTURACOSTOS")!=null?rs.getString("ESTRUCTURACOSTOS").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}