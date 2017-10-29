package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tipogasto;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipogastoDao extends BaseDao<Tipogasto> {
	public TipogastoDao() {
		super(Tipogasto.class);
	}
	public TipogastoDao(boolean usaCnBase) throws NisiraORMException {
		super(Tipogasto.class, usaCnBase);
	}

	public Tipogasto getPorClavePrimaria(String idempresa, String idtipogasto) throws NisiraORMException {
		List<Tipogasto> l = listar("t0.idempresa = ? and t0.idtipogasto = ? ", idempresa, idtipogasto);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Tipogasto> listarPorEmpresa_Tipogasto(String idempresa) throws NisiraORMException {
            ArrayList<Tipogasto> lista = new ArrayList<Tipogasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETTIPOGASTO_TMPSS",idempresa);
            while (rs.next()) {
                Tipogasto tipogasto = new Tipogasto();
                tipogasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                tipogasto.setIdtipogasto(rs.getString("IDTIPOGASTO")!=null?rs.getString("IDTIPOGASTO").trim():"");
                tipogasto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                tipogasto.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                tipogasto.setFechacreacion(rs.getDate("FECHACREACION"));
                tipogasto.setEstado(rs.getFloat("ESTADO"));
                lista.add(tipogasto);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public ArrayList<Tipogasto> listarPorEmpresa_Tipogasto_filtro(String idempresa,String idtipogasto) throws NisiraORMException {
            ArrayList<Tipogasto> lista = new ArrayList<Tipogasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETTIPOGASTO_FILTRO_TMPSS",idempresa,idtipogasto);
            while (rs.next()) {
                Tipogasto tipogasto = new Tipogasto();
                tipogasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                tipogasto.setIdtipogasto(rs.getString("IDTIPOGASTO")!=null?rs.getString("IDTIPOGASTO").trim():"");
                tipogasto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                tipogasto.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                tipogasto.setFechacreacion(rs.getDate("FECHACREACION"));
                tipogasto.setEstado(rs.getFloat("ESTADO"));
                lista.add(tipogasto);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
}