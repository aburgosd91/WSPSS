package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Area_concepto_cuenta;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Area_concepto_cuentaDao extends BaseDao<Area_concepto_cuenta> {
	public Area_concepto_cuentaDao() {
		super(Area_concepto_cuenta.class);
	}
	public Area_concepto_cuentaDao(boolean usaCnBase) throws NisiraORMException {
		super(Area_concepto_cuenta.class, usaCnBase);
	}

	public Area_concepto_cuenta getPorClavePrimaria(String IDEMPRESA, String IDAREA, String IDCONCEPTO) throws NisiraORMException {
		List<Area_concepto_cuenta> l = listar("t0.IDEMPRESA = ? and t0.IDAREA = ? and t0.IDCONCEPTO = ? ", IDEMPRESA, IDAREA, IDCONCEPTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}