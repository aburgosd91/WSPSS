package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_tareo_clieprov;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Estructura_tareo_clieprovDao extends BaseDao<Estructura_tareo_clieprov> {
	public Estructura_tareo_clieprovDao() {
		super(Estructura_tareo_clieprov.class);
	}
	public Estructura_tareo_clieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_tareo_clieprov.class, usaCnBase);
	}

	public Estructura_tareo_clieprov getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV) throws NisiraORMException {
		List<Estructura_tareo_clieprov> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? ", IDEMPRESA, IDCLIEPROV);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}