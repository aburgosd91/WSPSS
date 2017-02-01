package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Documentos;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocumentosDao extends BaseDao<Documentos> {
	public DocumentosDao() {
		super(Documentos.class);
	}
	public DocumentosDao(boolean usaCnBase) throws NisiraORMException {
		super(Documentos.class, usaCnBase);
	}

	public Documentos getPorClavePrimaria(String IDEMPRESA, String IDDOCUMENTO) throws NisiraORMException {
		List<Documentos> l = listar("t0.IDEMPRESA = ? and t0.IDDOCUMENTO = ? ", IDEMPRESA, IDDOCUMENTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Documentos> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Documentos> lista = new ArrayList<Documentos>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCUMENTOS_TMPSS",idempresa);
                while (rs.next()) {
                    Documentos documentos = new Documentos();
                    documentos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    documentos.setIdempresa(rs.getString("IDEMPRESA").trim());
                    documentos.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                    documentos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    documentos.setCodigo_sunat(rs.getString("CODIGO_SUNAT")!=null?rs.getString("CODIGO_SUNAT").trim():"");
    //                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                    documentos.setEstado(rs.getFloat("ESTADO"));
                    lista.add(documentos);      
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Documentos> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Documentos> lista = new ArrayList<Documentos>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCUMENTOS_TMPSS",idempresa);
                while (rs.next()) {
                    Documentos documentos = new Documentos();
                    documentos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    documentos.setIdempresa(rs.getString("IDEMPRESA").trim());
                    documentos.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                    documentos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    documentos.setCodigo_sunat(rs.getString("CODIGO_SUNAT")!=null?rs.getString("CODIGO_SUNAT").trim():"");
    //                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                    documentos.setEstado(rs.getFloat("ESTADO"));
                    lista.add(documentos);      
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Documentos> getOrdenServicio(String idempresa) throws NisiraORMException {
            ArrayList<Documentos> lista = new ArrayList<Documentos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDOCUMENTOS_ORDENSERVICIO",idempresa);
            while (rs.next()) {
                Documentos documentos = new Documentos();
                documentos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                documentos.setIdempresa(rs.getString("IDEMPRESA").trim());
                documentos.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                documentos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                documentos.setCodigo_sunat(rs.getString("CODIGO_SUNAT")!=null?rs.getString("CODIGO_SUNAT").trim():"");
//                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                documentos.setEstado(rs.getFloat("ESTADO"));
                lista.add(documentos);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
       
        }
        public ArrayList<Documentos> getOrdenLiquidacionGasto(String idempresa) throws NisiraORMException {
            ArrayList<Documentos> lista = new ArrayList<Documentos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDOCUMENTOS_ORDENLIQUIDACIONGASTO",idempresa);
            while (rs.next()) {
                Documentos documentos = new Documentos();
                documentos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                documentos.setIdempresa(rs.getString("IDEMPRESA").trim());
                documentos.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                documentos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                documentos.setCodigo_sunat(rs.getString("CODIGO_SUNAT")!=null?rs.getString("CODIGO_SUNAT").trim():"");
//                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                documentos.setEstado(rs.getFloat("ESTADO"));
                lista.add(documentos);      
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
       
        }
}