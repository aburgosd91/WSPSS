package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Areas;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreasDao extends BaseDao<Areas> {
	public AreasDao() {
		super(Areas.class);
	}
	public AreasDao(boolean usaCnBase) throws NisiraORMException {
		super(Areas.class, usaCnBase);
	}

	public Areas getPorClavePrimaria(String IDEMPRESA, String IDAREA) throws NisiraORMException {
		List<Areas> l = listar("t0.IDEMPRESA = ? and t0.IDAREA = ? ", IDEMPRESA, IDAREA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Areas> lstAreasEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Areas> lista = new ArrayList<Areas>();
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_GETAREAS", idempresa);
            while (rs.next()) {
                Areas am = new Areas();
                am.setIdempresa(rs.getString("idempresa").trim());
                am.setIdarea(rs.getString("idarea").trim());
                am.setDescripcion(rs.getString("descripcion").trim());
                am.setEstado(rs.getFloat("estado"));
                lista.add(am);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}