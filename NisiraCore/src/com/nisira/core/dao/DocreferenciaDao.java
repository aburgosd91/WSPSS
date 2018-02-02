package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DocreferenciaDao extends BaseDao<Docreferencia> {
	public DocreferenciaDao() {
		super(Docreferencia.class);
	}
	public DocreferenciaDao(boolean usaCnBase) throws NisiraORMException {
		super(Docreferencia.class, usaCnBase);
	}
        /*APP WEB*/
        public ArrayList<Docreferencia> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Docreferencia> lista = new ArrayList<Docreferencia>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCREFERENCIA_TMPSS",idempresa);
                while (rs.next()) {
                    Docreferencia docreferencia = new Docreferencia();
                    docreferencia.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    docreferencia.setIdempresa(rs.getString("IDEMPRESA").trim());
                    docreferencia.setIdorigen(rs.getString("IDORIGEN").trim());
                    docreferencia.setTabla(rs.getString("TABLA")!=null?rs.getString("TABLA").trim():"");
                    docreferencia.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                    docreferencia.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    docreferencia.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    docreferencia.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    docreferencia.setFecha(rs.getDate("FECHA"));
                    lista.add(docreferencia);                             

                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Docreferencia> getOrdenServicioWeb(String idempresa,String idordigenservicio) throws NisiraORMException {
            ArrayList<Docreferencia> lista = new ArrayList<Docreferencia>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCREFERENCIA_TMPSS",idempresa,idordigenservicio);
                while (rs.next()) {
                    Docreferencia docreferencia = new Docreferencia();
                    docreferencia.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    docreferencia.setIdempresa(rs.getString("IDEMPRESA").trim());
                    docreferencia.setIdorigen(rs.getString("IDORIGEN").trim());
                    docreferencia.setTabla(rs.getString("TABLA")!=null?rs.getString("TABLA").trim():"");
                    docreferencia.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                    docreferencia.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    docreferencia.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    docreferencia.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    docreferencia.setFecha(rs.getDate("FECHA"));
                    lista.add(docreferencia);                             

                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Docreferencia> getDoreferencia_tabla_origenWeb(String idempresa,String idorigen,String tabla) throws NisiraORMException {
            ArrayList<Docreferencia> lista = new ArrayList<Docreferencia>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCREFERENCIA_TABLA_TMPSS",idempresa,idorigen,tabla);
                while (rs.next()) {
                    Docreferencia docreferencia = new Docreferencia();
                    docreferencia.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    docreferencia.setIdempresa(rs.getString("IDEMPRESA").trim());
                    docreferencia.setIdorigen(rs.getString("IDORIGEN").trim());
                    docreferencia.setTabla(rs.getString("TABLA")!=null?rs.getString("TABLA").trim():"");
                    docreferencia.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                    docreferencia.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    docreferencia.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    docreferencia.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    docreferencia.setFecha(rs.getDate("FECHA"));
                    lista.add(docreferencia);                             

                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}