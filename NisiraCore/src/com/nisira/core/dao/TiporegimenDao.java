package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tiporegimen;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TiporegimenDao extends BaseDao<Tiporegimen> {
	public TiporegimenDao() {
		super(Tiporegimen.class);
	}
	public TiporegimenDao(boolean usaCnBase) throws NisiraORMException {
		super(Tiporegimen.class, usaCnBase);
	}

	public Tiporegimen getPorClavePrimaria(String idempresa, String idregimen) throws NisiraORMException {
		List<Tiporegimen> l = listar("t0.idempresa = ? and t0.idregimen = ? ", idempresa, idregimen);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Tiporegimen> listarPorEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Tiporegimen> lista = new ArrayList<Tiporegimen>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETTIPOREGIMEN_TMPSS",idempresa);
            while (rs.next()) {
                Tiporegimen tiporegimen = new Tiporegimen();
                tiporegimen.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tiporegimen.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                tiporegimen.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                tiporegimen.setEstado(rs.getFloat("ESTADO"));
                lista.add(tiporegimen);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}