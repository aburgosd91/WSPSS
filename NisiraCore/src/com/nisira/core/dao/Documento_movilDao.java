package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Documento_movil;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Documento_movilDao extends BaseDao<Documento_movil> {
	public Documento_movilDao() {
		super(Documento_movil.class);
	}
	public Documento_movilDao(boolean usaCnBase) throws NisiraORMException {
		super(Documento_movil.class, usaCnBase);
	}

	public Documento_movil getPorClavePrimaria(String IDEMPRESA, String IDDOCUMENTO) throws NisiraORMException {
		List<Documento_movil> l = listar("t0.IDEMPRESA = ? and t0.IDDOCUMENTO = ? ", IDEMPRESA, IDDOCUMENTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
          public ArrayList<Documento_movil> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Documento_movil> lista = new ArrayList<Documento_movil>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDOCUMENTO_MOVIL_TMPSS",idempresa);
                while (rs.next()) {
                    Documento_movil documento_movil = new Documento_movil();
                    documento_movil.setIdempresa(rs.getString("IDEMPRESA").trim());
                    documento_movil.setIddocumento(rs.getString("IDDOCUMENTO").trim());
                    documento_movil.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    //documentos.setCodigo_sunat(rs.getString("CODIGO_SUNAT")!=null?rs.getString("CODIGO_SUNAT").trim():"");
    //                clieprov.setRazonsocial(rs.getString("RAZONSOCIAL"));
                    documento_movil.setEstado(rs.getFloat("ESTADO"));
                    lista.add(documento_movil);      
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
          public String grabar(int tipo,Documento_movil ob)throws Exception {
            String mensaje="";
            ResultSet rs = null;
            rs = execProcedure("GETDOCUMENTO_MOVIL_GRABAR",
                    tipo,
                    ob.getIdempresa(),ob.getIddocumento(),
                    ob.getEstado()
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
            return mensaje;
        }
}