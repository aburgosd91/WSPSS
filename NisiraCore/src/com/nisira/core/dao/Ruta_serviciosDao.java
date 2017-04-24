package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ruta_serviciosDao extends BaseDao<Ruta_servicios> {
	public Ruta_serviciosDao() {
		super(Ruta_servicios.class);
	}
	public Ruta_serviciosDao(boolean usaCnBase) throws NisiraORMException {
		super(Ruta_servicios.class, usaCnBase);
	}

	public Ruta_servicios getPorClavePrimaria(String IDEMPRESA, String IDORDENSERVICIO, String ITEM, String ITEMRUTA) throws NisiraORMException {
		List<Ruta_servicios> l = listar("t0.IDEMPRESA = ? and t0.IDORDENSERVICIO = ? and t0.ITEM = ? and t0.ITEMRUTA = ? ", IDEMPRESA, IDORDENSERVICIO, ITEM, ITEMRUTA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Ruta_servicios> listarPorOrdenServicioClienteWeb(String idempresa,String idordenservicio,String item) throws NisiraORMException {
            ArrayList<Ruta_servicios> lista = new ArrayList<Ruta_servicios>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETRUTA_SERVICIOS_TMPSS",idempresa,idordenservicio,item);
            while (rs.next()) {
                Ruta_servicios ruta_servicios = new Ruta_servicios();
                ruta_servicios.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ruta_servicios.setIdempresa(rs.getString("IDEMPRESA").trim());
                ruta_servicios.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                ruta_servicios.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                ruta_servicios.setItemruta(rs.getString("ITEMRUTA")!=null?rs.getString("ITEMRUTA").trim():"");
                ruta_servicios.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                ruta_servicios.setLatitud(rs.getString("LATITUD")!=null?rs.getString("LATITUD").trim():"");
                ruta_servicios.setLongitud(rs.getString("LONGITUD")!=null?rs.getString("LONGITUD").trim():"");
                ruta_servicios.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ruta_servicios.setFechacreacion(rs.getDate("FECHACREACION"));
                ruta_servicios.setRuta(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                lista.add(ruta_servicios); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Ruta_servicios> listarPorOrdenServicioClienteWeb_Total(String idempresa,String idordenservicio) throws NisiraORMException {
            ArrayList<Ruta_servicios> lista = new ArrayList<Ruta_servicios>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETRUTA_SERVICIOS_TOTAL_TMPSS",idempresa,idordenservicio);
            while (rs.next()) {
                Ruta_servicios ruta_servicios = new Ruta_servicios();
                ruta_servicios.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ruta_servicios.setIdempresa(rs.getString("IDEMPRESA").trim());
                ruta_servicios.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                ruta_servicios.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                ruta_servicios.setItemruta(rs.getString("ITEMRUTA")!=null?rs.getString("ITEMRUTA").trim():"");
                ruta_servicios.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                ruta_servicios.setLatitud(rs.getString("LATITUD")!=null?rs.getString("LATITUD").trim():"");
                ruta_servicios.setLongitud(rs.getString("LONGITUD")!=null?rs.getString("LONGITUD").trim():"");
                ruta_servicios.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ruta_servicios.setFechacreacion(rs.getDate("FECHACREACION"));
                ruta_servicios.setRuta(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                lista.add(ruta_servicios); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}