package com.nisira.dao;

import com.nisira.core.BaseDao;
import com.nisira.entidad.Ddprogramacion_fichas;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Ddprogramacion_fichasDao extends BaseDao<Ddprogramacion_fichas> {
	public Ddprogramacion_fichasDao() {
		super(Ddprogramacion_fichas.class);
	}
	public Ddprogramacion_fichasDao(boolean usaCnBase) throws NisiraORMException {
		super(Ddprogramacion_fichas.class, usaCnBase);
	}

	public Ddprogramacion_fichas getPorClavePrimaria(Integer idprogramacion, Integer item, Integer idactividad) throws NisiraORMException {
		List<Ddprogramacion_fichas> l = listar("t0.idprogramacion = ? and t0.item = ? and t0.idactividad = ? ", idprogramacion, item, idactividad);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}