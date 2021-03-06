package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Destructura_costos_recursos_cotizacionventas;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Destructura_costos_recursos_cotizacionventasDao extends BaseDao<Destructura_costos_recursos_cotizacionventas> {
	public Destructura_costos_recursos_cotizacionventasDao() {
		super(Destructura_costos_recursos_cotizacionventas.class);
	}
	public Destructura_costos_recursos_cotizacionventasDao(boolean usaCnBase) throws NisiraORMException {
		super(Destructura_costos_recursos_cotizacionventas.class, usaCnBase);
	}

	public Destructura_costos_recursos_cotizacionventas getPorClavePrimaria(String idempresa, String codigo, String idcotizacionv, String item) throws NisiraORMException {
		List<Destructura_costos_recursos_cotizacionventas> l = listar("t0.idempresa = ? and t0.codigo = ? and t0.idcotizacionv = ? and t0.item = ? ", idempresa, codigo, idcotizacionv, item);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Destructura_costos_recursos_cotizacionventas> listarPorEmpresaWebXCotizacion(String idempresa,String idcotizacionv) throws NisiraORMException {
            ArrayList<Destructura_costos_recursos_cotizacionventas> lista = new ArrayList<Destructura_costos_recursos_cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETDESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTA_TMPSS",idempresa,idcotizacionv);
                while (rs.next()) {
                    Destructura_costos_recursos_cotizacionventas estructura_costos_clieprov = new Destructura_costos_recursos_cotizacionventas();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                    estructura_costos_clieprov.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_clieprov.setTipo_recurso(rs.getString("TIPO_RECURSO")!=null?rs.getString("TIPO_RECURSO").trim():"");
                    estructura_costos_clieprov.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_clieprov.setCantidad(rs.getFloat("CANTIDAD"));
                    estructura_costos_clieprov.setCosto(rs.getFloat("COSTO"));
                    estructura_costos_clieprov.setIdproducto_ec(rs.getString("IDPRODUCTO_EC")!=null?rs.getString("IDPRODUCTO_EC").trim():"");
                    estructura_costos_clieprov.setEs_porcentaje(rs.getFloat("ES_PORCENTAJE"));
                    estructura_costos_clieprov.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
                    estructura_costos_clieprov.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    estructura_costos_clieprov.setSubtotal(rs.getFloat("SUBTOTAL"));
                    estructura_costos_clieprov.setPorcentaje(rs.getFloat("PORCENTAJE"));
                    estructura_costos_clieprov.setPu(rs.getFloat("PU"));
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public double getPrecioUnitarioXestructuracostos(String idempresa,String codigo) throws NisiraORMException {
            double pu =0.0d;
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETCALCULO_PU_TMPSS",idempresa,codigo);
                while (rs.next()) {
                    pu=rs.getDouble("PRECIO_UNITARIO");                            
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return pu;
        }
}