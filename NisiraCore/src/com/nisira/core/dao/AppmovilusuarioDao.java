package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Appmovilusuario;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppmovilusuarioDao extends BaseDao<Appmovilusuario> {
	public AppmovilusuarioDao() {
		super(Appmovilusuario.class);
	}
	public AppmovilusuarioDao(boolean usaCnBase) throws NisiraORMException {
		super(Appmovilusuario.class, usaCnBase);
	}

	public Appmovilusuario getPorClavePrimaria(String IDEMPRESA, String IDAPPMOVIL, String IDUSUARIO) throws NisiraORMException {
		List<Appmovilusuario> l = listar("t0.IDEMPRESA = ? and t0.IDAPPMOVIL = ? and t0.IDUSUARIO = ? ", IDEMPRESA, IDAPPMOVIL, IDUSUARIO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public List<Appmovilusuario> getPorEmpresa( String idempresa) throws NisiraORMException, SQLException {
            List<Appmovilusuario> lst = new ArrayList<>();
            Appmovilusuario appmovilusuario= null;
            ResultSet rs = null;
            rs = execProcedure("GETAPPMOVILUSUARIO_TMPSS",idempresa);
            while (rs.next()) {
                appmovilusuario = new Appmovilusuario();
                appmovilusuario.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                appmovilusuario.setIdappmovil(rs.getString("IDAPPMOVIL")!=null?rs.getString("IDAPPMOVIL").trim():"");
                appmovilusuario.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                appmovilusuario.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                appmovilusuario.setUsuario(rs.getString("USUARIO")!=null?rs.getString("USUARIO").trim():"");
                appmovilusuario.setCliente(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                lst.add(appmovilusuario);
            }
            return lst;
        }
        
        public String grabar(int tipo,Appmovilusuario ob)throws Exception {
            String mensaje="";
            ResultSet rs = null;
            rs = execProcedure("GETAPPMOVILUSUARIO_GRABAR",
                    tipo,
                    ob.getIdempresa(),ob.getIdappmovil(),
                    ob.getIdusuario(),ob.getIdclieprov()
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
            return mensaje;
        }

}       