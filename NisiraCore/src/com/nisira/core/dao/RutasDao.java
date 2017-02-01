package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Rutas;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Rutas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RutasDao extends BaseDao<Rutas> {
	public RutasDao() {
		super(Rutas.class);
	}
	public RutasDao(boolean usaCnBase) throws NisiraORMException {
		super(Rutas.class, usaCnBase);
	}

	public Rutas getPorClavePrimaria(String IDEMPRESA, String IDRUTA) throws NisiraORMException {
		List<Rutas> l = listar("t0.IDEMPRESA = ? and t0.IDRUTA = ? ", IDEMPRESA, IDRUTA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Rutas> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Rutas> lista = new ArrayList<Rutas>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETRUTAS_TMPSS",idempresa);
            while (rs.next()) {
                Rutas ruta = new Rutas();
                ruta.setIdempresa(rs.getString("IDEMPRESA").trim());
                ruta.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                ruta.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                ruta.setKilometros(rs.getFloat("KILOMETROS"));
                ruta.setPeaje(rs.getString("PEAJE")!=null?rs.getString("PEAJE").trim():"");
                ruta.setFechacreacion(rs.getDate("FECHACREACION"));
                ruta.setEstado(rs.getInt("ESTADO"));
                ruta.setOrigen(rs.getString("ORIGEN")!=null?rs.getString("ORIGEN").trim():"");
                ruta.setDestino(rs.getString("DESTINO")!=null?rs.getString("DESTINO").trim():"");
                lista.add(ruta);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        /*APP WEB*/
        public ArrayList<Rutas> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Rutas> lista = new ArrayList<Rutas>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETRUTAS_TMPSS",idempresa);
            while (rs.next()) {
                Rutas ruta = new Rutas();
                ruta.setIdempresa(rs.getString("IDEMPRESA").trim());
                ruta.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                ruta.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                ruta.setKilometros(rs.getFloat("KILOMETROS"));
                ruta.setPeaje(rs.getString("PEAJE")!=null?rs.getString("PEAJE").trim():"");
                ruta.setFechacreacion(rs.getDate("FECHACREACION"));
                ruta.setEstado(rs.getInt("ESTADO"));
                ruta.setOrigen(rs.getString("ORIGEN")!=null?rs.getString("ORIGEN").trim():"");
                ruta.setDestino(rs.getString("DESTINO")!=null?rs.getString("DESTINO").trim():"");
                lista.add(ruta);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
}