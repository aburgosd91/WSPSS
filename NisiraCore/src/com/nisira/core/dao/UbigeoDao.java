package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ubigeo;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UbigeoDao extends BaseDao<Ubigeo> {
	public UbigeoDao() {
		super(Ubigeo.class);
	}
	public UbigeoDao(boolean usaCnBase) throws NisiraORMException {
		super(Ubigeo.class, usaCnBase);
	}

	public Ubigeo getPorClavePrimaria(String IDUBIGEO) throws NisiraORMException {
		List<Ubigeo> l = listar("t0.IDUBIGEO = ? ", IDUBIGEO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Ubigeo> listarTodo() throws NisiraORMException {
            ArrayList<Ubigeo> lista = new ArrayList<Ubigeo>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETUBIGEO");
            while (rs.next()) {
                Ubigeo ubi = new Ubigeo();
                ubi.setIdubigeo(rs.getString("IDUBIGEO"));
                ubi.setDescripcion(rs.getString("DESCRIPCION"));
                ubi.setIdprovincia(rs.getString("IDPROVINCIA"));
                ubi.setIddepartamento(rs.getString("IDDEPARTAMENTO"));
                lista.add(ubi);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}