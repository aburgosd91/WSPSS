package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Config_ventana_filtro_web;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Config_ventana_filtro_webDao extends BaseDao<Config_ventana_filtro_web> {
	public Config_ventana_filtro_webDao() {
		super(Config_ventana_filtro_web.class);
	}
	public Config_ventana_filtro_webDao(boolean usaCnBase) throws NisiraORMException {
		super(Config_ventana_filtro_web.class, usaCnBase);
	}

	public Config_ventana_filtro_web getPorClavePrimaria(Integer ID) throws NisiraORMException {
		List<Config_ventana_filtro_web> l = listar("t0.ID = ? ", ID);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Config_ventana_filtro_web> lstConfig_ventana_filtro_web() throws NisiraORMException {
            ArrayList<Config_ventana_filtro_web> lista = new ArrayList<Config_ventana_filtro_web>();
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_CONFIG_VENTANA_FILTRO_WEB");
                while (rs.next()){
                    Config_ventana_filtro_web am = new Config_ventana_filtro_web();
                    am.setId(rs.getInt("ID"));
                    am.setTabla(rs.getString("TABLA"));
                    am.setVentana(rs.getString("VENTANA"));
                    am.setDescripcion(rs.getString("DESCRIPCION"));
                    am.setAlcance(rs.getString("ALCANCE"));
                    am.setEstado(rs.getFloat("ESTADO"));
                    lista.add(am);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}