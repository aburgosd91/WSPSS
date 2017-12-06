package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estados;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstadosDao extends BaseDao<Estados> {
	public EstadosDao() {
		super(Estados.class);
	}
	public EstadosDao(boolean usaCnBase) throws NisiraORMException {
		super(Estados.class, usaCnBase);
	}

	public Estados getPorClavePrimaria(String IDESTADO) throws NisiraORMException {
		List<Estados> l = listar("t0.IDESTADO = ? ", IDESTADO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Estados> listarPorEmpresaWeb(String idempresa,String formulario) throws NisiraORMException {
            ArrayList<Estados> lista = new ArrayList<Estados>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETESTADO_TMPSS",idempresa,"",formulario);
            while (rs.next()) {
                Estados estados = new Estados();
                estados.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                estados.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                estados.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                estados.setOrden(rs.getFloat("ORDEN"));
                estados.setVerflujo(rs.getFloat("VERFLUJO"));
                estados.setAccion(rs.getString("ACCION")!=null?rs.getString("ACCION").trim():"");
                estados.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                estados.setFechacreacion(rs.getDate("FECHACREACION"));
                estados.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                lista.add(estados);     
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public boolean validar_modificacion_documento (String idempresa,String formulario,String idestado) throws NisiraORMException {
            boolean tv= false;
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTADO_DOCUMENTO_MODIFICAR_TMPSS",idempresa,formulario,idestado);
                while (rs.next()) {
                    tv = rs.getBoolean("EDITABLE");  
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return tv;
        }
}