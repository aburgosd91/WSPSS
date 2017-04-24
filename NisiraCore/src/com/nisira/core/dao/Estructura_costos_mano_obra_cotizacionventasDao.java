package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dordenserviciocliente;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_mano_obra_cotizacionventasDao extends BaseDao<Estructura_costos_mano_obra_cotizacionventas> {
	public Estructura_costos_mano_obra_cotizacionventasDao() {
		super(Estructura_costos_mano_obra_cotizacionventas.class);
	}
	public Estructura_costos_mano_obra_cotizacionventasDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_mano_obra_cotizacionventas.class, usaCnBase);
	}

	public Estructura_costos_mano_obra_cotizacionventas getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDCOTIZACIONV, String IDCARGO, String IDPRODUCTO) throws NisiraORMException {
		List<Estructura_costos_mano_obra_cotizacionventas> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDCOTIZACIONV = ? and t0.IDCARGO = ? and t0.IDPRODUCTO = ? ", IDEMPRESA, CODIGO, IDCOTIZACIONV, IDCARGO, IDPRODUCTO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_mano_obra_cotizacionventas> listarPorEmpresaWeb(String idempresa,String codigo) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra_cotizacionventas> lista = new ArrayList<Estructura_costos_mano_obra_cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTA_TMPSS",idempresa,codigo);
                while (rs.next()) {
                    Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra = new Estructura_costos_mano_obra_cotizacionventas();
                    estructura_costos_mano_obra.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        /*APP WEB*/
        public ArrayList<Estructura_costos_mano_obra_cotizacionventas> listarPorEmpresaWebXproducto(String idempresa,String idcotizacionv) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra_cotizacionventas> lista = new ArrayList<Estructura_costos_mano_obra_cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTA_TMPSS",idempresa,idcotizacionv);
                while (rs.next()) {
                    Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra = new Estructura_costos_mano_obra_cotizacionventas();
                    estructura_costos_mano_obra.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_mano_obra.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setCosto(rs.getFloat("COSTO"));
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos_mano_obra_cotizacionventas> listarPorEmpresaWebXcotizacion(String idempresa,
                String idcotizacionv,List<Dordenserviciocliente> listDordenserviciocliente) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra_cotizacionventas> lista = new ArrayList<Estructura_costos_mano_obra_cotizacionventas>();
            try
            {
                ResultSet rs = null;
                String xmlNot = "";
                String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream = new XStream();
                xStream.processAnnotations(Dordenserviciocliente.class);
                xmlNot = xml + xStream.toXML(listDordenserviciocliente);
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTA_ORDENSERVICIOCLIENTE_TMPSS",idempresa,
                        idcotizacionv,xmlNot);
                while (rs.next()) {
                    Estructura_costos_mano_obra_cotizacionventas estructura_costos_mano_obra = new Estructura_costos_mano_obra_cotizacionventas();
                    estructura_costos_mano_obra.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_mano_obra.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setCosto(rs.getFloat("COSTO"));
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}