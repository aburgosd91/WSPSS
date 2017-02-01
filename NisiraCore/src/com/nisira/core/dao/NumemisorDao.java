package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NumemisorDao extends BaseDao<Numemisor> {
	public NumemisorDao() {
		super(Numemisor.class);
	}
	public NumemisorDao(boolean usaCnBase) throws NisiraORMException {
		super(Numemisor.class, usaCnBase);
	}

	public Numemisor getPorClavePrimaria(String IDEMPRESA, String IDEMISOR, String IDDOCUMENTO, String SERIE) throws NisiraORMException {
		List<Numemisor> l = listar("t0.IDEMPRESA = ? and t0.IDEMISOR = ? and t0.IDDOCUMENTO = ? and t0.SERIE = ? ", IDEMPRESA, IDEMISOR, IDDOCUMENTO, SERIE);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        // APP SERVICE
        public ArrayList<Numemisor> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Numemisor> lista = new ArrayList<Numemisor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETNUMEMISOR_TMPSS",idempresa);
            while (rs.next()) {
                Numemisor numemisor = new Numemisor();
                numemisor.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                numemisor.setIdempresa(rs.getString("IDEMPRESA").trim());
                numemisor.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                numemisor.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                numemisor.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                numemisor.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
//                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                numemisor.setEstado(rs.getFloat("ESTADO"));
                numemisor.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(numemisor);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        // APP WEB
        public ArrayList<Numemisor> listarPorDocWeb(String idempresa,String iddocumento) throws NisiraORMException {
            ArrayList<Numemisor> lista = new ArrayList<Numemisor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETNUMEMISOR_TMPSS",idempresa,iddocumento);
            while (rs.next()) {
                Numemisor numemisor = new Numemisor();
                numemisor.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                numemisor.setIdempresa(rs.getString("IDEMPRESA").trim());
                numemisor.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                numemisor.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                numemisor.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
//                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                numemisor.setEstado(rs.getFloat("ESTADO"));
                numemisor.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(numemisor);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}