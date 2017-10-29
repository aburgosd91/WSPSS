package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tipomovimiento;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipomovimientoDao extends BaseDao<Tipomovimiento> {
	public TipomovimientoDao() {
		super(Tipomovimiento.class);
	}
	public TipomovimientoDao(boolean usaCnBase) throws NisiraORMException {
		super(Tipomovimiento.class, usaCnBase);
	}

	public Tipomovimiento getPorClavePrimaria(String idempresa, String idtipomov) throws NisiraORMException {
		List<Tipomovimiento> l = listar("t0.idempresa = ? and t0.idtipomov = ? ", idempresa, idtipomov);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Tipomovimiento> listarPorEmpresa_Tipomovimiento(String idempresa) throws NisiraORMException {
            ArrayList<Tipomovimiento> lista = new ArrayList<Tipomovimiento>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("SP_TIPOMOVIMIENTO_TMPSS",idempresa);
            while (rs.next()) {
                Tipomovimiento tipogasto = new Tipomovimiento();
                tipogasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                tipogasto.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                tipogasto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
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