package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Tcambio;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class TcambioDao extends BaseDao<Tcambio> {
	public TcambioDao() {
		super(Tcambio.class);
	}
	public TcambioDao(boolean usaCnBase) throws NisiraORMException {
		super(Tcambio.class, usaCnBase);
	}

        public Tcambio getPorFecha( Date fecha) throws NisiraORMException {
            Tcambio tcambio= null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETTTCAMBIO_TMPSS",fecha);
            while (rs.next()) {
                tcambio = new Tcambio();
                tcambio.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                tcambio.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                tcambio.setB_compra(rs.getFloat("B_COMPRA"));
                tcambio.setB_venta(rs.getFloat("B_VENTA"));
                tcambio.setP_compra(rs.getFloat("P_COMPRA"));
                tcambio.setP_venta(rs.getFloat("P_VENTA"));
                tcambio.setT_compra(rs.getFloat("T_COMPRA"));
                tcambio.setT_venta(rs.getFloat("T_VENTA"));
                tcambio.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                tcambio.setFechacreacion(rs.getDate("FECHACREACION"));  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return tcambio;
        }

}
