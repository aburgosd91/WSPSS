package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Idordenliquidaciongasto;
import com.nisira.core.NisiraORMException;
import java.util.List;

public class IdordenliquidaciongastoDao extends BaseDao<Idordenliquidaciongasto> {
	public IdordenliquidaciongastoDao() {
		super(Idordenliquidaciongasto.class);
	}
	public IdordenliquidaciongastoDao(boolean usaCnBase) throws NisiraORMException {
		super(Idordenliquidaciongasto.class, usaCnBase);
	}

	public Idordenliquidaciongasto getPorClavePrimaria(String idempresa, String idorden, String item, String idimpuesto, String subitem) throws NisiraORMException {
		List<Idordenliquidaciongasto> l = listar("t0.idempresa = ? and t0.idorden = ? and t0.item = ? and t0.idimpuesto = ? and t0.subitem = ? ", idempresa, idorden, item, idimpuesto, subitem);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
}