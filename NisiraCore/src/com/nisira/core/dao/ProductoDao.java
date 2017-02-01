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
            rs = execProcedure("GETPRODUCTOS_TMPEDIDO",idempresa);
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
            rs = execProcedure("GETPRODUCTOS_TMPEDIDO",idempresa);
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
	/*-Fin-*/
}