package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Operaciones;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OperacionesDao extends BaseDao<Operaciones> {
	public OperacionesDao() {
		super(Operaciones.class);
	}
	public OperacionesDao(boolean usaCnBase) throws NisiraORMException {
		super(Operaciones.class, usaCnBase);
	}

	public Operaciones getPorClavePrimaria(String IDOPERACION) throws NisiraORMException {
		List<Operaciones> l = listar("t0.IDOPERACION = ? ", IDOPERACION);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Operaciones> lstOperacionesEmpresa() throws NisiraORMException {
            ArrayList<Operaciones> lista = new ArrayList<Operaciones>();
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_GEOPERACIONES");
            while (rs.next()) {
                Operaciones am = new Operaciones();
                am.setIdoperacion(rs.getString("IDOPERACION").trim());
                am.setDescripcion(rs.getString("DESCRIPCION").trim());
                am.setIdsubdiario(rs.getString("IDSUBDIARIO").trim());
                am.setEstado(rs.getFloat("ESTADO"));
                lista.add(am);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}