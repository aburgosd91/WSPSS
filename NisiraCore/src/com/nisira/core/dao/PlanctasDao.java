package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Planctas;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanctasDao extends BaseDao<Planctas> {
	public PlanctasDao() {
		super(Planctas.class);
	}
	public PlanctasDao(boolean usaCnBase) throws NisiraORMException {
		super(Planctas.class, usaCnBase);
	}

	public Planctas getPorClavePrimaria(String IDEMPRESA, String IDCUENTA) throws NisiraORMException {
		List<Planctas> l = listar("t0.IDEMPRESA = ? and t0.IDCUENTA = ? ", IDEMPRESA, IDCUENTA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Planctas> listarPorEmpresa(String idempresa,String idcuenta) throws NisiraORMException {
            ArrayList<Planctas> lista = new ArrayList<Planctas>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPLANCTAS_TMPSS",idempresa,idcuenta);
            while (rs.next()) {
                Planctas planctas = new Planctas();
                planctas.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                planctas.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                planctas.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                planctas.setEstado(rs.getFloat("ESTADO"));
                lista.add(planctas);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public Planctas getPlanctas_idcuenta(String idempresa,String idcuenta) throws NisiraORMException {
            Planctas planctas =null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPLANCTAS_TMPSS",idempresa,idcuenta);
            while (rs.next()) {
                planctas = new Planctas();
                planctas.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                planctas.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                planctas.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                planctas.setEstado(rs.getFloat("ESTADO"));                            
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return planctas;
        }
}