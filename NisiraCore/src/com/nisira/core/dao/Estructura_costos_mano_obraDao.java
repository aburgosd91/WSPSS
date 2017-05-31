package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_mano_obra;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_mano_obraDao extends BaseDao<Estructura_costos_mano_obra> {
	public Estructura_costos_mano_obraDao() {
		super(Estructura_costos_mano_obra.class);
	}
	public Estructura_costos_mano_obraDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_mano_obra.class, usaCnBase);
	}

	public Estructura_costos_mano_obra getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDCARGO, String ITEM) throws NisiraORMException {
		List<Estructura_costos_mano_obra> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDCARGO = ? and t0.ITEM = ? ", IDEMPRESA, CODIGO, IDCARGO, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_mano_obra> listarPorEmpresaWeb(String idempresa,String codigo) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra> lista = new ArrayList<Estructura_costos_mano_obra>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_TMPSS",idempresa,codigo);
                while (rs.next()) {
                    Estructura_costos_mano_obra estructura_costos_mano_obra = new Estructura_costos_mano_obra();
                    estructura_costos_mano_obra.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    estructura_costos_mano_obra.setCosto(rs.getFloat("COSTO"));
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        /*APP WEB*/
        public ArrayList<Estructura_costos_mano_obra> listarPorEmpresaWebXproducto(String idempresa,String codigo,String idproducto,String itemrango) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra> lista = new ArrayList<Estructura_costos_mano_obra>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_TMPSS",idempresa,codigo,idproducto,itemrango);
                while (rs.next()) {
                    Estructura_costos_mano_obra estructura_costos_mano_obra = new Estructura_costos_mano_obra();
                    estructura_costos_mano_obra.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setCosto(rs.getFloat("COSTO"));
                    estructura_costos_mano_obra.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}