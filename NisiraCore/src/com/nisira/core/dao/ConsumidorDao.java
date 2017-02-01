package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Consumidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsumidorDao extends BaseDao<Consumidor> {
	public ConsumidorDao() {
		super(Consumidor.class);
	}
	public ConsumidorDao(boolean usaCnBase) throws NisiraORMException {
		super(Consumidor.class, usaCnBase);
	}

	public Consumidor getPorClavePrimaria(String IDEMPRESA, String IDCONSUMIDOR) throws NisiraORMException {
		List<Consumidor> l = listar("t0.IDEMPRESA = ? and t0.IDCONSUMIDOR = ? ", IDEMPRESA, IDCONSUMIDOR);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*SERVICE WEB*/
        public ArrayList<Consumidor> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Consumidor> lista = new ArrayList<Consumidor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONSUMIDOR_TMPSS",idempresa);
            while (rs.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                consumidor.setIdempresa(rs.getString("IDEMPRESA").trim());
                consumidor.setIdconsumidor(rs.getString("IDCONSUMIDOR").trim());
                consumidor.setTipo(rs.getString("TIPO")!=null?rs.getString("TIPO").trim():"");
                consumidor.setJerarquia(rs.getString("JERARQUIA")!=null?rs.getString("JERARQUIA").trim():"");
                consumidor.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                consumidor.setIdccosto(rs.getString("IDCCOSTO")!=null?rs.getString("IDCCOSTO").trim():"");
                consumidor.setFecha_ingreso(rs.getDate("FECHA_INGRESO"));
                consumidor.setFecha_baja(rs.getDate("FECHA_BAJA"));
                consumidor.setMarca(rs.getString("MARCA"));
                consumidor.setPlaca(rs.getString("PLACA"));
                consumidor.setTipovehiculo(rs.getString("TIPOVEHICULO"));
                consumidor.setAnio(rs.getFloat("ANIO"));
                consumidor.setEstado(rs.getFloat("ESTADO"));
                
                lista.add(consumidor);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Consumidor> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Consumidor> lista = new ArrayList<Consumidor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONSUMIDOR_TMPSS",idempresa);
            while (rs.next()) {
                Consumidor consumidor = new Consumidor();
                consumidor.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                consumidor.setIdempresa(rs.getString("IDEMPRESA").trim());
                consumidor.setIdconsumidor(rs.getString("IDCONSUMIDOR").trim());
                consumidor.setTipo(rs.getString("TIPO")!=null?rs.getString("TIPO").trim():"");
                consumidor.setJerarquia(rs.getString("JERARQUIA")!=null?rs.getString("JERARQUIA").trim():"");
                consumidor.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                consumidor.setIdccosto(rs.getString("IDCCOSTO")!=null?rs.getString("IDCCOSTO").trim():"");
                consumidor.setFecha_ingreso(rs.getDate("FECHA_INGRESO"));
                consumidor.setFecha_baja(rs.getDate("FECHA_BAJA"));
                consumidor.setMarca(rs.getString("MARCA"));
                consumidor.setPlaca(rs.getString("PLACA"));
                consumidor.setTipovehiculo(rs.getString("TIPOVEHICULO"));
                consumidor.setAnio(rs.getFloat("ANIO"));
                consumidor.setEstado(rs.getFloat("ESTADO"));
                
                lista.add(consumidor);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}