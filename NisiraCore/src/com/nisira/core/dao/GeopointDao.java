package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeopointDao extends BaseDao<Geopoint> {
	public GeopointDao() {
		super(Geopoint.class);
	}
	public GeopointDao(boolean usaCnBase) throws NisiraORMException {
		super(Geopoint.class, usaCnBase);
	}

	public Geopoint getPorClavePrimaria(Integer IDGEOPOINT) throws NisiraORMException {
		List<Geopoint> l = listar("t0.IDGEOPOINT = ? ", IDGEOPOINT);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Geopoint> listarPorEmpresaWeb() throws NisiraORMException {
            ArrayList<Geopoint> lista = new ArrayList<Geopoint>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETGEOPOINT_TMPSS");
            while (rs.next()) {
                Geopoint geopoint = new Geopoint();
                geopoint.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                geopoint.setIdgeopoint(rs.getInt("IDGEOPOINT"));
                geopoint.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                geopoint.setLatitud(rs.getString("LATITUD")!=null?rs.getString("LATITUD").trim():"");
                geopoint.setLongitud(rs.getString("LONGITUD")!=null?rs.getString("LONGITUD").trim():"");
                geopoint.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                geopoint.setFechacreacion(rs.getDate("FECHACREACION"));
                geopoint.setEstado(rs.getInt("ESTADO"));
                lista.add(geopoint);   
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public String grabar(int tipo,Geopoint obj)throws NisiraORMException {
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_GEOPOINT_GRABAR",
                        tipo,
                        obj.getIdgeopoint(),
                        obj.getDescripcion(),
                        obj.getLatitud(),
                        obj.getLongitud(),
                        obj.getIdclieprov(),
                        obj.getFechacreacion(),
                        obj.getEstado()
                );
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
}