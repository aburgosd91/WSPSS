package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Vendedor;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao extends BaseDao<Vendedor> {
	public VendedorDao() {
		super(Vendedor.class);
	}
	public VendedorDao(boolean usaCnBase) throws NisiraORMException {
		super(Vendedor.class, usaCnBase);
	}

	public Vendedor getPorClavePrimaria(String IDEMPRESA, String IDVENDEDOR) throws NisiraORMException {
		List<Vendedor> l = listar("t0.IDEMPRESA = ? and t0.IDVENDEDOR = ? ", IDEMPRESA, IDVENDEDOR);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Vendedor> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETVENDEDOR_TMPSS",idempresa);
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdempresa(rs.getString("IDEMPRESA").trim());
                vendedor.setIdvendedor(rs.getString("IDVENDEDOR").trim());
                vendedor.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                vendedor.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                vendedor.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                vendedor.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                vendedor.setEstado(rs.getFloat("ESTADO"));
                vendedor.setFechacreacion(rs.getDate("FECHACREACION"));
                vendedor.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                lista.add(vendedor);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}