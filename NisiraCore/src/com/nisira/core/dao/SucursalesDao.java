package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Sucursales;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalesDao extends BaseDao<Sucursales> {
	public SucursalesDao() {
		super(Sucursales.class);
	}
	public SucursalesDao(boolean usaCnBase) throws NisiraORMException {
		super(Sucursales.class, usaCnBase);
	}

	public Sucursales getPorClavePrimaria(String IDEMPRESA, String IDSUCURSAL) throws NisiraORMException {
		List<Sucursales> l = listar("t0.IDEMPRESA = ? and t0.IDSUCURSAL = ? ", IDEMPRESA, IDSUCURSAL);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public List<Sucursales> listarPorEmpresaService( String idempresa) throws NisiraORMException, SQLException {
            List<Sucursales> listSucursales = new ArrayList<>();
            ResultSet rs = null;
            rs = execProcedure("GETSUCURSALES_TMPSS",idempresa);
            while (rs.next()) {
                Sucursales sucursales = new Sucursales();
                sucursales.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                sucursales.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                sucursales.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                sucursales.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                sucursales.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                sucursales.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                sucursales.setFechacreacion(rs.getDate("FECHACREACION"));  
                listSucursales.add(sucursales);
            }
            return listSucursales;
        }
        /*APP WEB*/
        public Sucursales getPorEmpresaSucursal( String idempresa,String idsucursal) throws NisiraORMException, SQLException {
            Sucursales sucursales= null;
            ResultSet rs = null;
            rs = execProcedure("GETSUCURSALES_TMPSS",idempresa,idsucursal);
            while (rs.next()) {
                sucursales = new Sucursales();
                sucursales.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                sucursales.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                sucursales.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                sucursales.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                sucursales.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                sucursales.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                sucursales.setFechacreacion(rs.getDate("FECHACREACION"));  
            }
            return sucursales;
        }
        public List<Sucursales> getPorEmpresa( String idempresa) throws NisiraORMException, SQLException {
            List<Sucursales> listSucursal = new ArrayList<>();
            Sucursales sucursales= null;
            ResultSet rs = null;
            rs = execProcedure("GETSUCURSALES_TMPSS",idempresa);
            while (rs.next()) {
                sucursales = new Sucursales();
                sucursales.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                sucursales.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                sucursales.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                sucursales.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                sucursales.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                sucursales.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                sucursales.setFechacreacion(rs.getDate("FECHACREACION"));
                listSucursal.add(sucursales);
            }
            return listSucursal;
        }
}