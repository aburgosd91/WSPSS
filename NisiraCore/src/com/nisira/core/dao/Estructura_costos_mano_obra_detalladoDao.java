package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos_mano_obra_detallado;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costos_mano_obra_detalladoDao extends BaseDao<Estructura_costos_mano_obra_detallado> {
	public Estructura_costos_mano_obra_detalladoDao() {
		super(Estructura_costos_mano_obra_detallado.class);
	}
	public Estructura_costos_mano_obra_detalladoDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos_mano_obra_detallado.class, usaCnBase);
	}

	public Estructura_costos_mano_obra_detallado getPorClavePrimaria(String IDEMPRESA, String CODIGO, String IDCARGO, String ITEMRANGO, String ITEM_ECM, String ITEM) throws NisiraORMException {
		List<Estructura_costos_mano_obra_detallado> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? and t0.IDCARGO = ? and t0.ITEMRANGO = ? and t0.ITEM_ECM = ? and t0.ITEM = ? ", IDEMPRESA, CODIGO, IDCARGO, ITEMRANGO, ITEM_ECM, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos_mano_obra_detallado> listarPorEmpresaWeb(String idempresa,String codigo) throws NisiraORMException {
            ArrayList<Estructura_costos_mano_obra_detallado> lista = new ArrayList<Estructura_costos_mano_obra_detallado>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_MANO_OBRA_DETALLADO_TMPSS",idempresa,codigo);
                while (rs.next()) {
                    Estructura_costos_mano_obra_detallado estructura_costos_mano_obra = new Estructura_costos_mano_obra_detallado();
                    estructura_costos_mano_obra.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_mano_obra.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_mano_obra.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                    estructura_costos_mano_obra.setItem_ecm(rs.getString("ITEM_ECM")!=null?rs.getString("ITEM_ECM").trim():"");
                    estructura_costos_mano_obra.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    estructura_costos_mano_obra.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                    estructura_costos_mano_obra.setItemrango(rs.getString("ITEMRANGO")!=null?rs.getString("ITEMRANGO").trim():"");
                    estructura_costos_mano_obra.setCosto(rs.getFloat("COSTO"));
                    estructura_costos_mano_obra.setHorai(rs.getFloat("HORAI"));
                    estructura_costos_mano_obra.setNhoras(rs.getFloat("NHORAS"));
                    estructura_costos_mano_obra.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    estructura_costos_mano_obra.setIdruta(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                    if(estructura_costos_mano_obra.getHorai()!=0.0f){
                        estructura_costos_mano_obra.setShorai(CoreUtil.convertTimeString(CoreUtil.convertDecimalTime(estructura_costos_mano_obra.getHorai())));
                    }else{
                        estructura_costos_mano_obra.setShorai("00:00");
                    }
                    estructura_costos_mano_obra.setHoraf(rs.getFloat("HORAF"));
                    if(estructura_costos_mano_obra.getHoraf()!=0.0f){
                        estructura_costos_mano_obra.setShoraf(CoreUtil.convertTimeString(CoreUtil.convertDecimalTime(estructura_costos_mano_obra.getHoraf())));
                    }else{
                        estructura_costos_mano_obra.setShoraf("00:00");
                    }
                    lista.add(estructura_costos_mano_obra);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}