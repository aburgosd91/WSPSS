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
        public ArrayList<Productos> listarPorEmpresaWebxIdproducto(String idempresa,String idproducto) throws NisiraORMException {
            ArrayList<Productos> lista = new ArrayList<Productos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_ESTRUCTURAXID_TMPSS",idempresa,idproducto);
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
        public ArrayList<Productos> listarPorEmpresaEstructuraWeb(String idempresa) throws NisiraORMException {
            ArrayList<Productos> lista = new ArrayList<Productos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_ESTRUCTURA_TMPSS",idempresa);
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
        public ArrayList<Object> returnImpuestoxproducto(String idempresa, String idproducto,String fecha) throws NisiraORMException {
            ArrayList<Object> lista = new ArrayList<Object>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("OBJTABLAS_RETURNIMPUESTOXPRODUCTO",idempresa,idproducto,fecha);
            while (rs.next()) {
                lista.add(rs.getString("IDIMPUESTO"));
                lista.add(rs.getString("DESCRIPCION"));
                lista.add(rs.getDouble("VALOR"));             
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Double> precioVenta(String idempresa, String idsucursal,String idproducto,String idmoneda,String fecha) throws NisiraORMException {
            ArrayList<Double> lista = new ArrayList<Double>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("OBJTABLAS_PRECIOVENTA",idempresa,idsucursal,idproducto,idmoneda,fecha);
            while (rs.next()) {
                lista.add(rs.getDouble("PRECIO_STK"));
                lista.add(rs.getDouble("PRECIO1"));
                lista.add(rs.getDouble("PRECIO2"));
                lista.add(rs.getDouble("PRECIO3"));
                lista.add(rs.getDouble("PRECIO4"));
                lista.add(rs.getDouble("PRECIO5"));                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}