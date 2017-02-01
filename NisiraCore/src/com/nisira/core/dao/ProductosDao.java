package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Productos;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductosDao extends BaseDao<Productos> {
	public ProductosDao() throws NisiraORMException  {
		super(Productos.class);
	}
	public ProductosDao(boolean usaCnBase) throws NisiraORMException {
		super(Productos.class, usaCnBase);
	}
        /*APP SERVICE*/
        public ArrayList<Productos> listarPorEmpresaService(String idempresa){
            ArrayList<Productos> lista = new ArrayList<Productos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_TMPSS",idempresa);
            while (rs.next()) {
                Productos productos = new Productos();
                productos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                productos.setIdempresa(rs.getString("IDEMPRESA").trim());
                productos.setIdproducto(rs.getString("IDPRODUCTO").trim());
                productos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                productos.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
//                productos.setRazonsocial(rs.getString("RAZONSOCIAL"));
                productos.setEstado(rs.getFloat("ESTADO"));
                lista.add(productos);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP MOVIL*/
        public ArrayList<Productos> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Productos> lista = new ArrayList<Productos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_TMPSS",idempresa);
            while (rs.next()) {
                Productos productos = new Productos();
                productos.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                productos.setIdempresa(rs.getString("IDEMPRESA").trim());
                productos.setIdproducto(rs.getString("IDPRODUCTO").trim());
                productos.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                productos.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
//                productos.setRazonsocial(rs.getString("RAZONSOCIAL"));
                productos.setEstado(rs.getFloat("ESTADO"));
                lista.add(productos);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}