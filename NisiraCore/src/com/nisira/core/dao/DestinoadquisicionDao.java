package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoadquisicionDao extends BaseDao<Destinoadquisicion> {
	public DestinoadquisicionDao() {
		super(Destinoadquisicion.class);
	}
	public DestinoadquisicionDao(boolean usaCnBase) throws NisiraORMException {
		super(Destinoadquisicion.class, usaCnBase);
	}

	public Destinoadquisicion getPorClavePrimaria(String iddestino) throws NisiraORMException {
		List<Destinoadquisicion> l = listar("t0.iddestino = ? ", iddestino);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public ArrayList<Destinoadquisicion> listarPorEmpresaService() throws NisiraORMException {
            ArrayList<Destinoadquisicion> lista = new ArrayList<Destinoadquisicion>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDESTINOADQUISICION_TMPSS");
            while (rs.next()) {
                Destinoadquisicion destino = new Destinoadquisicion();
                destino.setIdbasedatos(rs.getString("IDBASEDATOS")!=null?rs.getString("IDBASEDATOS").trim():"");;
                destino.setIddestino(rs.getString("IDDESTINO")!=null?rs.getString("IDDESTINO").trim():"");
                destino.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                destino.setEstado(rs.getFloat("ESTADO"));
                destino.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                destino.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(destino); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Destinoadquisicion> listarPorEmpresaWeb() throws NisiraORMException {
            ArrayList<Destinoadquisicion> lista = new ArrayList<Destinoadquisicion>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDESTINOADQUISICION_TMPSS");
            while (rs.next()) {
                Destinoadquisicion destino = new Destinoadquisicion();
                destino.setIdbasedatos(rs.getString("IDBASEDATOS")!=null?rs.getString("IDBASEDATOS").trim():"");;
                destino.setIddestino(rs.getString("IDDESTINO")!=null?rs.getString("IDDESTINO").trim():"");
                destino.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                destino.setEstado(rs.getFloat("ESTADO"));
                destino.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                destino.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(destino); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Destinoadquisicion> listarPorEmpresa_FiltroWeb(String iddestino) throws NisiraORMException {
            ArrayList<Destinoadquisicion> lista = new ArrayList<Destinoadquisicion>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDESTINOADQUISICION_FILTRO_TMPSS",iddestino);
            while (rs.next()) {
                Destinoadquisicion destino = new Destinoadquisicion();
                destino.setIdbasedatos(rs.getString("IDBASEDATOS")!=null?rs.getString("IDBASEDATOS").trim():"");;
                destino.setIddestino(rs.getString("IDDESTINO")!=null?rs.getString("IDDESTINO").trim():"");
                destino.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                destino.setEstado(rs.getFloat("ESTADO"));
                destino.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                destino.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(destino); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}