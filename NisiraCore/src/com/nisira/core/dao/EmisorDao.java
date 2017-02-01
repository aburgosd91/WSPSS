package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Emisor;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmisorDao extends BaseDao<Emisor> {
	public EmisorDao() {
		super(Emisor.class);
	}
	public EmisorDao(boolean usaCnBase) throws NisiraORMException {
		super(Emisor.class, usaCnBase);
	}

	public Emisor getPorClavePrimaria(String IDEMPRESA, String IDEMISOR) throws NisiraORMException {
		List<Emisor> l = listar("t0.IDEMPRESA = ? and t0.IDEMISOR = ? ", IDEMPRESA, IDEMISOR);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public Emisor getPorClavePrimariaWeb(String IDEMPRESA, String IDEMISOR) throws NisiraORMException {
            Emisor emisor = null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETEMISOR_TMPSS",IDEMPRESA,IDEMISOR);
            while (rs.next()) {
                emisor = new Emisor();
                emisor.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                emisor.setIdempresa(rs.getString("IDEMPRESA").trim());
                emisor.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                emisor.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                emisor.setEstado(rs.getFloat("ESTADO"));                         
                emisor.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                emisor.setFechacreacion(rs.getDate("FECHACREACION"));  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return emisor;
        }
}