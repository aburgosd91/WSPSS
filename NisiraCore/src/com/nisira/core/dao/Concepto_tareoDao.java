package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Concepto_tareo;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Concepto_tareoDao extends BaseDao<Concepto_tareo> {
	public Concepto_tareoDao() {
		super(Concepto_tareo.class);
	}
	public Concepto_tareoDao(boolean usaCnBase) throws NisiraORMException {
		super(Concepto_tareo.class, usaCnBase);
	}

	public Concepto_tareo getPorClavePrimaria(String IDEMPRESA, String IDCONCEPTOTAREO) throws NisiraORMException {
		List<Concepto_tareo> l = listar("t0.IDEMPRESA = ? and t0.IDCONCEPTOTAREO = ? ", IDEMPRESA, IDCONCEPTOTAREO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Concepto_tareo> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Concepto_tareo> lista = new ArrayList<Concepto_tareo>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONCEPTO_TAREO_TMPSS",idempresa);
            while (rs.next()) {
                Concepto_tareo concepto_tareo = new Concepto_tareo();
                concepto_tareo.setIdempresa(rs.getString("IDEMPRESA").trim());
                concepto_tareo.setIdconceptotareo(rs.getString("IDCONCEPTOTAREO")!=null?rs.getString("IDCONCEPTOTAREO").trim():"");
                concepto_tareo.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                concepto_tareo.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                concepto_tareo.setPor_defecto(rs.getFloat("POR_DEFECTO"));
                concepto_tareo.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                concepto_tareo.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(concepto_tareo); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}