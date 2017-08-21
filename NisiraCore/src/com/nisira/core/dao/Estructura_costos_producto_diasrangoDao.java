package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_producto_diasrango;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_producto_diasrangoDao extends BaseDao<Estructura_costos_producto_diasrango> {
	public Estructura_costos_producto_diasrangoDao() {
		super(Estructura_costos_producto_diasrango.class);
	}
	public Estructura_costos_producto_diasrangoDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_producto_diasrango.class, usaCnBase);
	}

	public Estructura_costos_producto_diasrango getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDPRODUCTO, String ITEM, Float NHORAS, String CODOPERATIVO, String IDRUTA, String IDDIA) throws NisiraORMException {
		List<Estructura_costos_producto_diasrango> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDPRODUCTO = ? and t0.ITEM = ? and t0.NHORAS = ? and t0.CODOPERATIVO = ? and t0.IDRUTA = ? and t0.IDDIA = ? ", IDEMPRESA, CODIGO, IDPRODUCTO, ITEM, NHORAS, CODOPERATIVO, IDRUTA, IDDIA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_producto_diasrango> listarPorEmpresaWeb(String idempresa,
                String idcodigo,String idproducto,String item,Float nhoras,String codoperativo,String idruta) throws NisiraORMException {
            ArrayList<Estructura_costos_producto_diasrango> lista = new ArrayList<Estructura_costos_producto_diasrango>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_PRODUCTO_DIASRANGO_TMPSS",idempresa,idcodigo,idproducto,item,nhoras,codoperativo,idruta);
                while (rs.next()) {
                    Estructura_costos_producto_diasrango estructura_costos_producto = new Estructura_costos_producto_diasrango();
                    estructura_costos_producto.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_producto.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_producto.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_producto.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_producto.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    estructura_costos_producto.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_producto.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    estructura_costos_producto.setIddia(rs.getString("IDDIA")!=null?rs.getString("IDDIA").trim():"");
                    estructura_costos_producto.setDia(rs.getString("DIA")!=null?rs.getString("DIA").trim():"");
                    estructura_costos_producto.setSeleccion(rs.getBoolean("SELECCION"));
                    lista.add(estructura_costos_producto);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public String grabar(String idempresa,String codigo,
                List<Estructura_costos_producto_diasrango> lst,
                String idusuario
            ) throws Exception {
            String mensaje="";
            /********* ESTRUCTURA COSTOS PRODUCTO RANGO HORAS***********/
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_producto_diasrango.class);
            xmlNot = xml + xStream.toXML(lst);
            
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ESTRUCTURA_COSTOS_PRODUCTO_DIASRANGO_GRABAR",idempresa,codigo,
                    xmlNot,idusuario
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