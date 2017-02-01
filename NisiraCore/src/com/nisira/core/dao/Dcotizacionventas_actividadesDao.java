package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dcotizacionventas_actividadesDao extends BaseDao<Dcotizacionventas_actividades> {
	public Dcotizacionventas_actividadesDao() {
		super(Dcotizacionventas_actividades.class);
	}
	public Dcotizacionventas_actividadesDao(boolean usaCnBase) throws NisiraORMException {
		super(Dcotizacionventas_actividades.class, usaCnBase);
	}

	public Dcotizacionventas_actividades getPorClavePrimaria(String idempresa, String idcotizacionv, String itemc) throws NisiraORMException {
		List<Dcotizacionventas_actividades> l = listar("t0.idempresa = ? and t0.idcotizacionv = ? and t0.itemc = ? ", idempresa, idcotizacionv, itemc);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public ArrayList<Dcotizacionventas_actividades> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Dcotizacionventas_actividades> lista = new ArrayList<Dcotizacionventas_actividades>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDCOTIZACIONVENTAS_ACTIVIDADES_TMPSS",idempresa);
            while (rs.next()) {
                Dcotizacionventas_actividades dcotizacionventas_actividades = new Dcotizacionventas_actividades();
                dcotizacionventas_actividades.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                dcotizacionventas_actividades.setIdempresa(rs.getString("IDEMPRESA").trim());
                dcotizacionventas_actividades.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                dcotizacionventas_actividades.setItemc(rs.getString("ITEMC")!=null?rs.getString("ITEMC").trim():"");
                dcotizacionventas_actividades.setItemref(rs.getString("ITEMREF")!=null?rs.getString("ITEMREF").trim():"");
                dcotizacionventas_actividades.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                dcotizacionventas_actividades.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas_actividades.setCantidad(rs.getFloat("CANTIDAD"));
                dcotizacionventas_actividades.setCosto(rs.getFloat("COSTO"));
                dcotizacionventas_actividades.setTotal(rs.getFloat("TOTAL"));
                dcotizacionventas_actividades.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                lista.add(dcotizacionventas_actividades); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Dcotizacionventas_actividades> listarPorEmpresaServiceCotizacionVenta(String idempresa,String idcotizacionv) throws NisiraORMException {
            ArrayList<Dcotizacionventas_actividades> lista = new ArrayList<Dcotizacionventas_actividades>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDCOTIZACIONVENTAS_ACTIVIDADES_TMPSS",idempresa,idcotizacionv);
            while (rs.next()) {
                Dcotizacionventas_actividades dcotizacionventas_actividades = new Dcotizacionventas_actividades();
                dcotizacionventas_actividades.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                dcotizacionventas_actividades.setIdempresa(rs.getString("IDEMPRESA").trim());
                dcotizacionventas_actividades.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                dcotizacionventas_actividades.setItemc(rs.getString("ITEMC")!=null?rs.getString("ITEMC").trim():"");
                dcotizacionventas_actividades.setItemref(rs.getString("ITEMREF")!=null?rs.getString("ITEMREF").trim():"");
                dcotizacionventas_actividades.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                dcotizacionventas_actividades.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas_actividades.setCantidad(rs.getFloat("CANTIDAD"));
                dcotizacionventas_actividades.setCosto(rs.getFloat("COSTO"));
                dcotizacionventas_actividades.setTotal(rs.getFloat("TOTAL"));
                dcotizacionventas_actividades.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                lista.add(dcotizacionventas_actividades); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}