package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Turno_trabajo;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Turno_trabajoDao extends BaseDao<Turno_trabajo> {
	public Turno_trabajoDao() {
		super(Turno_trabajo.class);
	}
	public Turno_trabajoDao(boolean usaCnBase) throws NisiraORMException {
		super(Turno_trabajo.class, usaCnBase);
	}

	public Turno_trabajo getPorClavePrimaria(String IDTURNOTRABAJO) throws NisiraORMException {
		List<Turno_trabajo> l = listar("t0.IDTURNOTRABAJO = ? ", IDTURNOTRABAJO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Turno_trabajo> getPorTurno_trabajo() throws NisiraORMException, SQLException{
            List<Turno_trabajo> listTurno_trabajo = new ArrayList<>();
            Turno_trabajo turno_trabajo= null;
            ResultSet rs = null;
            rs = execProcedure("GETTURNO_TRABAJO_TMPSS");
            while (rs.next()) {
                turno_trabajo = new Turno_trabajo();
                turno_trabajo.setIdturnotrabajo(rs.getString("IDTURNOTRABAJO")!=null?rs.getString("IDTURNOTRABAJO").trim():"");
                turno_trabajo.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                turno_trabajo.setDesde(rs.getFloat("DESDE"));
                turno_trabajo.setHasta(rs.getFloat("HASTA"));
                turno_trabajo.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                turno_trabajo.setFechacreacion(rs.getDate("FECHACREACION"));
                listTurno_trabajo.add(turno_trabajo);
            }
            return listTurno_trabajo;
        }
}