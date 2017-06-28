package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_productoDao extends BaseDao<Estructura_costos_producto> {
	public Estructura_costos_productoDao() {
		super(Estructura_costos_producto.class);
	}
	public Estructura_costos_productoDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_producto.class, usaCnBase);
	}

	public Estructura_costos_producto getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDPRODUCTO) throws NisiraORMException {
		List<Estructura_costos_producto> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDPRODUCTO = ? ", IDEMPRESA, CODIGO, IDPRODUCTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_producto> listarPorEmpresaWebXcodigo(String idempresa,String idcodigo) throws NisiraORMException {
            ArrayList<Estructura_costos_producto> lista = new ArrayList<Estructura_costos_producto>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_TMPSS",idempresa,idcodigo);
                while (rs.next()) {
                    Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto();
                    estructura_costos_producto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_producto.setNumerador(rs.getInt("NUMERADOR"));
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_producto.setProducto(rs.getString("PRODUCTO")!=null?rs.getString("PRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setAjuste(rs.getFloat("AJUSTE"));
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    estructura_costos_producto.setDescripcion_ruta(rs.getString("DESCRIPCION_RUTA")!=null?rs.getString("DESCRIPCION_RUTA").trim():"");
                    
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
         public ArrayList<Estructura_costos_producto> listarPorEmpresaService() throws NisiraORMException {
            ArrayList<Estructura_costos_producto> lista = new ArrayList<Estructura_costos_producto>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_TMPSS_2");
                while (rs.next()) {
                    Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto();
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_producto.setProducto(rs.getString("PRODUCTO")!=null?rs.getString("PRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setAjuste(rs.getFloat("AJUSTE"));
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                   
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_producto> listarPorEmpresaWebXidclieprov(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Estructura_costos_producto> lista = new ArrayList<Estructura_costos_producto>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_CLIEPROV_TMPSS",idempresa,idclieprov);
                while (rs.next()) {
                    Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto();
                    estructura_costos_producto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_producto.setNumerador(rs.getInt("NUMERADOR"));
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_producto.setProducto(rs.getString("PRODUCTO")!=null?rs.getString("PRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setAjuste(rs.getFloat("AJUSTE"));
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_producto> listarPorEmpresaWebXcodigoXidclieprov(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Estructura_costos_producto> lista = new ArrayList<Estructura_costos_producto>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_COPY_TMPSS",idempresa,idclieprov);
                while (rs.next()) {
                    Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto();
                    estructura_costos_producto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_producto.setNumerador(rs.getInt("NUMERADOR"));
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_producto.setProducto(rs.getString("PRODUCTO")!=null?rs.getString("PRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setAjuste(rs.getFloat("AJUSTE"));
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    estructura_costos_producto.setDescripcion_ruta(rs.getString("DESCRIPCION_RUTA")!=null?rs.getString("DESCRIPCION_RUTA").trim():"");
                    
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Float> listarNhoras(String idempresa,String idclieprov,String codoperativo,String idruta) throws NisiraORMException {
            ArrayList<Float> lista = new ArrayList<Float>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_NHORA_TMPSS",idempresa,idclieprov,codoperativo,idruta);
                Float nhoras = 0.0f;
                while (rs.next()) {
                    nhoras=rs.getFloat("NHORAS");
                    lista.add(nhoras);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_producto> listarCodOperaciones(String idempresa,String idclieprov,
                String codoperaciones,Float nhoras,String idruta) throws NisiraORMException {
            ArrayList<Estructura_costos_producto> lista = new ArrayList<Estructura_costos_producto>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_CODOPERACIONES_TMPSS",idempresa,idclieprov,codoperaciones,nhoras,idruta);
                while (rs.next()) {
                    Estructura_costos_producto estructura_costos_producto = new Estructura_costos_producto();
                    estructura_costos_producto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_producto.setNumerador(rs.getInt("NUMERADOR"));
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_producto.setProducto(rs.getString("PRODUCTO")!=null?rs.getString("PRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setAjuste(rs.getFloat("AJUSTE"));
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}