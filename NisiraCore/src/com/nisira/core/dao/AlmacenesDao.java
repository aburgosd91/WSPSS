package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenesDao extends BaseDao<Almacenes> {
	public AlmacenesDao() {
		super(Almacenes.class);
	}
	public AlmacenesDao(boolean usaCnBase) throws NisiraORMException {
		super(Almacenes.class, usaCnBase);
	}

	public Almacenes getPorClavePrimaria(String IDEMPRESA, String IDSUCURSAL, String IDALMACEN) throws NisiraORMException {
		List<Almacenes> l = listar("t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? and t0.IDALMACEN = ? ", IDEMPRESA, IDSUCURSAL, IDALMACEN);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public List<Almacenes> getPorEmpresaSucursal( String idempresa,String idsucursal) throws NisiraORMException, SQLException {
            List<Almacenes> lst = new ArrayList<>();
            Almacenes almacenes= null;
            ResultSet rs = null;
            rs = execProcedure("GETALMACENES_TMPSS",idempresa,idsucursal);
            while (rs.next()) {
                almacenes = new Almacenes();
                almacenes.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                almacenes.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                almacenes.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                almacenes.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                almacenes.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                almacenes.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                almacenes.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                almacenes.setFechacreacion(rs.getDate("FECHACREACION")); 
                lst.add(almacenes);
            }
            return lst;
        }
        
}