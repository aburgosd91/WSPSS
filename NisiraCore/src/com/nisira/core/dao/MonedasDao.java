package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Monedas;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonedasDao extends BaseDao<Monedas> {
	public MonedasDao() {
		super(Monedas.class);
	}
	public MonedasDao(boolean usaCnBase) throws NisiraORMException {
		super(Monedas.class, usaCnBase);
	}

	public Monedas getPorClavePrimaria(String IDMONEDA) throws NisiraORMException {
		List<Monedas> l = listar("t0.IDMONEDA = ? ", IDMONEDA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public List<Monedas> getListMonedasWeb() throws NisiraORMException {
            List<Monedas> listmoneda= new ArrayList<>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETMONEDAS_TMPSS");
            while (rs.next()) {
                Monedas moneda = new Monedas();
                moneda.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                moneda.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                moneda.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                moneda.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                moneda.setEstado(rs.getFloat("ESTADO"));                         
                moneda.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                moneda.setFechacreacion(rs.getDate("FECHACREACION"));  
                listmoneda.add(moneda);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return listmoneda;
        }
}