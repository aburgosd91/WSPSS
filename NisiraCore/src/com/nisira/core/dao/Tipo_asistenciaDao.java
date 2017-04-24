package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tipo_asistencia;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tipo_asistenciaDao extends BaseDao<Tipo_asistencia> {
	public Tipo_asistenciaDao() {
		super(Tipo_asistencia.class);
	}
	public Tipo_asistenciaDao(boolean usaCnBase) throws NisiraORMException {
		super(Tipo_asistencia.class, usaCnBase);
	}

	public Tipo_asistencia getPorClavePrimaria(String idempresa, String idtipoasistencia) throws NisiraORMException {
		List<Tipo_asistencia> l = listar("t0.idempresa = ? and t0.idtipoasistencia = ? ", idempresa, idtipoasistencia);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Tipo_asistencia> getPorTipo_asistencia(String idempresa) throws NisiraORMException, SQLException{
            List<Tipo_asistencia> listTipo_asistencia = new ArrayList<>();
            Tipo_asistencia tipo_asistencia= null;
            ResultSet rs = null;
            rs = execProcedure("GETTIPO_ASISTENCIA_TMPSS",idempresa);
            while (rs.next()) {
                tipo_asistencia = new Tipo_asistencia();
                tipo_asistencia.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tipo_asistencia.setIdtipoasistencia(rs.getString("IDTIPOASISTENCIA")!=null?rs.getString("IDTIPOASISTENCIA").trim():"");
                tipo_asistencia.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                tipo_asistencia.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                tipo_asistencia.setExige_glosa(rs.getFloat("EXIGE_GLOSA"));
                tipo_asistencia.setEstado(rs.getFloat("ESTADO"));
                tipo_asistencia.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                listTipo_asistencia.add(tipo_asistencia);
            }
            return listTipo_asistencia;
        }
}