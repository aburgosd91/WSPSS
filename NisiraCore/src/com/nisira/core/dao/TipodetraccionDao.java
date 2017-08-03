package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tipodetraccion;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipodetraccionDao extends BaseDao<Tipodetraccion> {
	public TipodetraccionDao() {
		super(Tipodetraccion.class);
	}
	public TipodetraccionDao(boolean usaCnBase) throws NisiraORMException {
		super(Tipodetraccion.class, usaCnBase);
	}

	public Tipodetraccion getPorClavePrimaria(String idtipodetra) throws NisiraORMException {
		List<Tipodetraccion> l = listar("t0.idtipodetra = ? ", idtipodetra);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Tipodetraccion> listarTotal() throws NisiraORMException {
            ArrayList<Tipodetraccion> lista = new ArrayList<Tipodetraccion>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETTIPODETRACCION_TMPSS");
                while (rs.next()) {
                    Tipodetraccion tipodetraccion = new Tipodetraccion();
                    tipodetraccion.setIdtipodetra(rs.getString("IDTIPODETRA")!=null?rs.getString("IDTIPODETRA").trim():"");
                    tipodetraccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    tipodetraccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    tipodetraccion.setFechacreacion(rs.getDate("FECHACREACION"));
                    tipodetraccion.setTasa(rs.getFloat("TASA"));
                    tipodetraccion.setEstado(rs.getFloat("ESTADO"));
                    lista.add(tipodetraccion);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Tipodetraccion> getTipodetraccion(String idtipodetraccion) throws NisiraORMException {
            ArrayList<Tipodetraccion> lista = new ArrayList<Tipodetraccion>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETTIPODETRACCION_TMPSS",idtipodetraccion);
                while (rs.next()) {
                    Tipodetraccion tipodetraccion = new Tipodetraccion();
                    tipodetraccion.setIdtipodetra(rs.getString("IDTIPODETRA")!=null?rs.getString("IDTIPODETRA").trim():"");
                    tipodetraccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    tipodetraccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    tipodetraccion.setFechacreacion(rs.getDate("FECHACREACION"));
                    tipodetraccion.setTasa(rs.getFloat("TASA"));
                    tipodetraccion.setEstado(rs.getFloat("ESTADO"));
                    lista.add(tipodetraccion);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public Tipodetraccion getTipodetraccion_idtipodetraccion(String idtipodetraccion) throws NisiraORMException {
            Tipodetraccion tipodetraccion=null ;
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETTIPODETRACCION_TMPSS",idtipodetraccion);
                while (rs.next()) {
                    tipodetraccion = new Tipodetraccion();
                    tipodetraccion.setIdtipodetra(rs.getString("IDTIPODETRA")!=null?rs.getString("IDTIPODETRA").trim():"");
                    tipodetraccion.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    tipodetraccion.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    tipodetraccion.setFechacreacion(rs.getDate("FECHACREACION"));
                    tipodetraccion.setTasa(rs.getFloat("TASA"));
                    tipodetraccion.setEstado(rs.getFloat("ESTADO"));                            
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return tipodetraccion;
        }
}