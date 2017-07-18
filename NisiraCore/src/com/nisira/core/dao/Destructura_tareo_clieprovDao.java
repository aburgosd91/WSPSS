package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Destructura_tareo_clieprov;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Destructura_tareo_clieprovDao extends BaseDao<Destructura_tareo_clieprov> {
	public Destructura_tareo_clieprovDao() {
		super(Destructura_tareo_clieprov.class);
	}
	public Destructura_tareo_clieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Destructura_tareo_clieprov.class, usaCnBase);
	}

	public Destructura_tareo_clieprov getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV, String ITEM) throws NisiraORMException {
		List<Destructura_tareo_clieprov> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? and t0.ITEM = ? ", IDEMPRESA, IDCLIEPROV, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Destructura_tareo_clieprov> listarPorEmpresaWebXCotizacion(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Destructura_tareo_clieprov> lista = new ArrayList<Destructura_tareo_clieprov>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDESTRUCTURA_TAREO_CLIEPROV_TMPSS",idempresa,idclieprov);
                while (rs.next()) {
                    Destructura_tareo_clieprov estructura_costos_clieprov = new Destructura_tareo_clieprov();
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_clieprov.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_clieprov.setHora(rs.getFloat("HORA"));
                    estructura_costos_clieprov.setEsfecha(rs.getFloat("ESFECHA"));
                    estructura_costos_clieprov.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    estructura_costos_clieprov.setCliente(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                    estructura_costos_clieprov.setRuta(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}