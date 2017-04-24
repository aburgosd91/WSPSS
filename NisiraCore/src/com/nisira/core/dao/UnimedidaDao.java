package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Unimedida;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnimedidaDao extends BaseDao<Unimedida> {
	public UnimedidaDao() {
		super(Unimedida.class);
	}
	public UnimedidaDao(boolean usaCnBase) throws NisiraORMException {
		super(Unimedida.class, usaCnBase);
	}

	public Unimedida getPorClavePrimaria(String IDEMPRESA, String IDMEDIDA) throws NisiraORMException {
		List<Unimedida> l = listar("t0.IDEMPRESA = ? and t0.IDMEDIDA = ? ", IDEMPRESA, IDMEDIDA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Unimedida> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Unimedida> lista = new ArrayList<Unimedida>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETUNIMEDIDA_TMPSS",idempresa);
            while (rs.next()) {
                Unimedida unimedida = new Unimedida();
                unimedida.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                unimedida.setIdempresa(rs.getString("IDEMPRESA").trim());
                unimedida.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
                unimedida.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                unimedida.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                unimedida.setEstado(rs.getFloat("ESTADO"));
                unimedida.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                unimedida.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(unimedida); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}