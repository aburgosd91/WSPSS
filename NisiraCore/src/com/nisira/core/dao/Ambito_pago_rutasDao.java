package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ambito_pago_rutas;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Ambito_pago_rutasDao extends BaseDao<Ambito_pago_rutas> {
	public Ambito_pago_rutasDao() {
		super(Ambito_pago_rutas.class);
	}
	public Ambito_pago_rutasDao(boolean usaCnBase) throws NisiraORMException {
		super(Ambito_pago_rutas.class, usaCnBase);
	}

	public Ambito_pago_rutas getPorClavePrimaria(String idempresa, String codigo, String ITEM) throws NisiraORMException {
		List<Ambito_pago_rutas> l = listar("t0.idempresa = ? and t0.codigo = ? and t0.ITEM = ? ", idempresa, codigo, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}