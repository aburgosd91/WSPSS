package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.Dprogramacion_actividad;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Dprogramacion_actividadDao extends BaseDao<Dprogramacion_actividad> {
	public Dprogramacion_actividadDao() {
		super(Dprogramacion_actividad.class);
	}
	public Dprogramacion_actividadDao(boolean usaCnBase) throws NisiraORMException {
		super(Dprogramacion_actividad.class, usaCnBase);
	}

	public Dprogramacion_actividad getPorClavePrimaria(Integer idprogramacion, Integer idactividad) throws NisiraORMException {
		List<Dprogramacion_actividad> l = listar("t0.idprogramacion = ? and t0.idactividad = ? ", idprogramacion, idactividad);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}