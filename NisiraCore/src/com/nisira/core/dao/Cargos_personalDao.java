package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cargos_personalDao extends BaseDao<Cargos_personal> {
	public Cargos_personalDao() {
		super(Cargos_personal.class);
	}
	public Cargos_personalDao(boolean usaCnBase) throws NisiraORMException {
		super(Cargos_personal.class, usaCnBase);
	}

	public Cargos_personal getPorClavePrimaria(String IDEMPRESA, String IDCARGO) throws NisiraORMException {
		List<Cargos_personal> l = listar("t0.IDEMPRESA = ? and t0.IDCARGO = ? ", IDEMPRESA, IDCARGO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public ArrayList<Cargos_personal> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Cargos_personal> lista = new ArrayList<Cargos_personal>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCARGOS_PERSONAL_TMPSS",idempresa);
            while (rs.next()) {
                Cargos_personal cargos_personal = new Cargos_personal();
                cargos_personal.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                cargos_personal.setIdempresa(rs.getString("IDEMPRESA").trim());
                cargos_personal.setIdcargo(rs.getString("IDCARGO").trim());
                cargos_personal.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                cargos_personal.setEs_chofer(rs.getFloat("ES_CHOFER"));
                lista.add(cargos_personal);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Cargos_personal> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Cargos_personal> lista = new ArrayList<Cargos_personal>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCARGOS_PERSONAL_TMPSS",idempresa);
            while (rs.next()) {
                Cargos_personal cargos_personal = new Cargos_personal();
                cargos_personal.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                cargos_personal.setIdempresa(rs.getString("IDEMPRESA").trim());
                cargos_personal.setIdcargo(rs.getString("IDCARGO").trim());
                cargos_personal.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                cargos_personal.setEs_chofer(rs.getFloat("ES_CHOFER"));
                lista.add(cargos_personal);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}