package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dformatoreporteweb;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class DformatoreportewebDao extends BaseDao<Dformatoreporteweb> {
	public DformatoreportewebDao() {
		super(Dformatoreporteweb.class);
	}
	public DformatoreportewebDao(boolean usaCnBase) throws NisiraORMException {
		super(Dformatoreporteweb.class, usaCnBase);
	}

	public Dformatoreporteweb getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV, String ITEM, String ITEM2) throws NisiraORMException {
		List<Dformatoreporteweb> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? and t0.ITEM = ? and t0.ITEM2 = ? ", IDEMPRESA, IDCLIEPROV, ITEM, ITEM2);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}