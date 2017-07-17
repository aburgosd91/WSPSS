package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Destructura_tareo_clieprov;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Destructura_tareo_clieprovDao extends BaseDao<Destructura_tareo_clieprov> {
	public Destructura_tareo_clieprovDao() {
		super(Destructura_tareo_clieprov.class);
	}
	public Destructura_tareo_clieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Destructura_tareo_clieprov.class, usaCnBase);
	}

	public Destructura_tareo_clieprov getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV, String ITEM) throws NisiraORMException {
		List<Destructura_tareo_clieprov> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? and t0.ITEM = ? ", IDEMPRESA, IDCLIEPROV, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}