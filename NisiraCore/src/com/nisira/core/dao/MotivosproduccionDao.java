package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MotivosproduccionDao extends BaseDao<Motivosproduccion> {
	public MotivosproduccionDao() {
		super(Motivosproduccion.class);
	}
	public MotivosproduccionDao(boolean usaCnBase) throws NisiraORMException {
		super(Motivosproduccion.class, usaCnBase);
	}

	public Motivosproduccion getPorClavePrimaria(String IDEMPRESA, String IDMOTIVO) throws NisiraORMException {
		List<Motivosproduccion> l = listar("t0.IDEMPRESA = ? and t0.IDMOTIVO = ? ", IDEMPRESA, IDMOTIVO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*SERVICE WEB*/
        public ArrayList<Motivosproduccion> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Motivosproduccion> lista = new ArrayList<Motivosproduccion>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETMOTIVOSPRODUCCION_TMPSS",idempresa);
            while (rs.next()) {
                Motivosproduccion motivosproduccion = new Motivosproduccion();
                motivosproduccion.setIdempresa(rs.getString("IDEMPRESA").trim());
                motivosproduccion.setIdmotivo(rs.getString("IDMOTIVO").trim());
                motivosproduccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                motivosproduccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                motivosproduccion.setEs_cotizacion(rs.getFloat("ES_COTIZACION"));
                motivosproduccion.setEs_requerimiento(rs.getFloat("ES_REQUERIMIENTO"));
                motivosproduccion.setEs_ingpersonal(rs.getFloat("ES_INGPERSONAL"));
                lista.add(motivosproduccion);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Motivosproduccion> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Motivosproduccion> lista = new ArrayList<Motivosproduccion>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETMOTIVOSPRODUCCION_TMPSS",idempresa);
            while (rs.next()) {
                Motivosproduccion motivosproduccion = new Motivosproduccion();
                motivosproduccion.setIdempresa(rs.getString("IDEMPRESA").trim());
                motivosproduccion.setIdmotivo(rs.getString("IDMOTIVO").trim());
                motivosproduccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                motivosproduccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                motivosproduccion.setEs_cotizacion(rs.getFloat("ES_COTIZACION"));
                motivosproduccion.setEs_requerimiento(rs.getFloat("ES_REQUERIMIENTO"));
                motivosproduccion.setEs_ingpersonal(rs.getFloat("ES_INGPERSONAL"));
                lista.add(motivosproduccion);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public Motivosproduccion getPorClavePrimaria_(String idempresa,String idmotivo) throws NisiraORMException {
            Motivosproduccion motivosproduccion = null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETMOTIVOSPRODUCCION_TMPSS",idempresa,idmotivo);
            while (rs.next()) {
                motivosproduccion = new Motivosproduccion();
                motivosproduccion.setIdempresa(rs.getString("IDEMPRESA").trim());
                motivosproduccion.setIdmotivo(rs.getString("IDMOTIVO").trim());
                motivosproduccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                motivosproduccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                motivosproduccion.setEs_cotizacion(rs.getFloat("ES_COTIZACION"));
                motivosproduccion.setEs_requerimiento(rs.getFloat("ES_REQUERIMIENTO"));
                motivosproduccion.setEs_ingpersonal(rs.getFloat("ES_INGPERSONAL"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return motivosproduccion;
        }
}