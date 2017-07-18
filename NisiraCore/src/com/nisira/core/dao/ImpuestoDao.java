package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Impuesto;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dimpuesto;
import java.sql.ResultSet;
import java.util.List;

public class ImpuestoDao extends BaseDao<Impuesto> {

    public ImpuestoDao() {
        super(Impuesto.class);
    }

    public ImpuestoDao(boolean usaCnBase) throws NisiraORMException {
        super(Impuesto.class, usaCnBase);
    }

    public Impuesto getPorClavePrimaria(String IDEMPRESA, String IDIMPUESTO) throws NisiraORMException {
        List<Impuesto> l = listar("t0.IDEMPRESA = ? and t0.IDIMPUESTO = ? ", IDEMPRESA, IDIMPUESTO);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }

    public Float getImpuesto(String idempresa, String idimpuesto) {
        Float result = 0f;
        try {
            ResultSet rs = null;
            rs = execProcedure("GETIMPUESTO", idempresa,idimpuesto);
            while (rs.next()) {
                result = rs.getFloat("VALOR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
