package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entityservices.*;import java.sql.ResultSet;
public class ProductoDao extends BaseDao<Producto> {
	public ProductoDao() {
		super(Producto.class);
	}
	public ProductoDao(boolean usaCnBase) throws NisiraORMException {
		super(Producto.class, usaCnBase);
	}

        /*-Inicio-*/
        /************ SERVICIO **************/
        public ArrayList<Producto> listarPorEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Producto> lista = new ArrayList<Producto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_TMPSS",idempresa);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdbasedatos(rs.getString("IDBASEDATOS"));
                producto.setIdempresa(rs.getString("IDEMPRESA"));
                producto.setIdproducto(rs.getString("IDPRODUCTO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setIdmedida(rs.getString("IDMEDIDA"));
                producto.setIdgrupo(rs.getString("IDGRUPO"));
                producto.setIdsubgrupo(rs.getString("IDSUBGRUPO"));
                producto.setEstado(rs.getDouble("ESTADO"));
                
                lista.add(producto);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /************ APP WEB **************/
        public ArrayList<Producto> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Producto> lista = new ArrayList<Producto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRODUCTOS_TMPSS",idempresa);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdbasedatos(rs.getString("IDBASEDATOS"));
                producto.setIdempresa(rs.getString("IDEMPRESA"));
                producto.setIdproducto(rs.getString("IDPRODUCTO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setIdmedida(rs.getString("IDMEDIDA"));
                producto.setIdgrupo(rs.getString("IDGRUPO"));
                producto.setIdsubgrupo(rs.getString("IDSUBGRUPO"));
                producto.setEstado(rs.getDouble("ESTADO"));
                
                lista.add(producto);                             
                
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
	/*-Fin-*/
}