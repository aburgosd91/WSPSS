package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ambito_pago_costomo;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class Ambito_pago_costomoDao extends BaseDao<Ambito_pago_costomo> {
	public Ambito_pago_costomoDao() {
		super(Ambito_pago_costomo.class);
	}
	public Ambito_pago_costomoDao(boolean usaCnBase) throws NisiraORMException {
		super(Ambito_pago_costomo.class, usaCnBase);
	}

	public Ambito_pago_costomo getPorClavePrimaria(String idempresa, String codigo, String idcargo, String idruta) throws NisiraORMException {
		List<Ambito_pago_costomo> l = listar("t0.idempresa = ? and t0.codigo = ? and t0.idcargo = ? and t0.idruta = ? ", idempresa, codigo, idcargo, idruta);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}