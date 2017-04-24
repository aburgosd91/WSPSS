package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Forma_pago;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Forma_pagoDao extends BaseDao<Forma_pago> {
	public Forma_pagoDao() {
		super(Forma_pago.class);
	}
	public Forma_pagoDao(boolean usaCnBase) throws NisiraORMException {
		super(Forma_pago.class, usaCnBase);
	}

	public Forma_pago getPorClavePrimaria(String IDEMPRESA, String IDFPAGO) throws NisiraORMException {
		List<Forma_pago> l = listar("t0.IDEMPRESA = ? and t0.IDFPAGO = ? ", IDEMPRESA, IDFPAGO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Forma_pago> listarPorEmpresaWeb(String idfpago) throws NisiraORMException {
            ArrayList<Forma_pago> lista = new ArrayList<Forma_pago>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONCEPTO_FORMA_PAGO_TMPSS",idfpago);
            while (rs.next()) {
                Forma_pago forma_pago = new Forma_pago();
                forma_pago.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                forma_pago.setIdempresa(rs.getString("IDEMPRESA").trim());
                forma_pago.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                forma_pago.setDias_credito(rs.getFloat("DIAS_CREDITO"));
                forma_pago.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                forma_pago.setEstado(rs.getFloat("ESTADO"));
                forma_pago.setContado(rs.getFloat("CONTADO"));
                forma_pago.setDescripcionsu(rs.getString("DESCRIPCIONSU")!=null?rs.getString("DESCRIPCIONSU").trim():"");
                forma_pago.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                forma_pago.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(forma_pago); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}