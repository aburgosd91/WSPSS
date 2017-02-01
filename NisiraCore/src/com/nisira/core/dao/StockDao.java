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
public class StockDao extends BaseDao<Stock> {
	public StockDao() {
		super(Stock.class);
	}
	public StockDao(boolean usaCnBase) throws NisiraORMException {
		super(Stock.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Stock> listarPorEmpresa(String idempresa,String idusuario) throws NisiraORMException {
            ArrayList<Stock> lista = new ArrayList<Stock>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETSTOCK_TMPEDIDO",idempresa,"",idusuario);
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setIdbasedatos(rs.getString("IDBASEDATOS"));
                stock.setIdempresa(rs.getString("IDEMPRESA"));
                stock.setIdsucursal(rs.getString("IDSUCURSAL"));
                stock.setDescsucursal(rs.getString("DESCSUCURSAL"));
                stock.setIdalmacen(rs.getString("IDALMACEN"));
                stock.setDescalmacen(rs.getString("DESCALMACEN"));
                stock.setIdproducto(rs.getString("IDPRODUCTO"));
                stock.setDescproducto(rs.getString("DESCPRODUCTO"));
                stock.setIdmedida(rs.getString("IDMEDIDA"));
                stock.setFecha(rs.getDate("FECHA"));

                stock.setStock(rs.getDouble("STOCK"));
                stock.setStockcomprometido(rs.getDouble("STOCKCOMPROMETIDO"));
                stock.setStockdisponible(rs.getDouble("STOCKDISPONIBLE"));
                
                lista.add(stock);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        public ArrayList<Stock> listarPorEmpresaPorProducto(String idempresa,String idproducto,String idusuario) throws NisiraORMException {
            ArrayList<Stock> lista = new ArrayList<Stock>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETSTOCK_TMPEDIDO",idempresa,idproducto,idusuario);
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setIdbasedatos(rs.getString("IDBASEDATOS"));
                stock.setIdempresa(rs.getString("IDEMPRESA"));
                stock.setIdsucursal(rs.getString("IDSUCURSAL"));
                stock.setDescsucursal(rs.getString("DESCSUCURSAL"));
                stock.setIdalmacen(rs.getString("IDALMACEN"));
                stock.setDescalmacen(rs.getString("DESCALMACEN"));
                stock.setIdproducto(rs.getString("IDPRODUCTO"));
                stock.setDescproducto(rs.getString("DESCPRODUCTO"));
                stock.setIdmedida(rs.getString("IDMEDIDA"));
                stock.setFecha(rs.getDate("FECHA"));
                
                stock.setStock(rs.getDouble("STOCK"));
                stock.setStockcomprometido(rs.getDouble("STOCKCOMPROMETIDO"));
                stock.setStockdisponible(rs.getDouble("STOCKDISPONIBLE"));
                
                lista.add(stock);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
	/*-Fin-*/
}