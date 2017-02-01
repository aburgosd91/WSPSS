package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DordenservicioclienteDao extends BaseDao<Dordenserviciocliente> {
	public DordenservicioclienteDao() {
		super(Dordenserviciocliente.class);
	}
	public DordenservicioclienteDao(boolean usaCnBase) throws NisiraORMException {
		super(Dordenserviciocliente.class, usaCnBase);
	}
        /*APP SERVICE*/
        public ArrayList<Dordenserviciocliente> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Dordenserviciocliente> lista = new ArrayList<Dordenserviciocliente>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDORDENSERVICIOCLIENTE_TMPSS",idempresa);
            while (rs.next()) {
                Dordenserviciocliente dordenserviciocliente = new Dordenserviciocliente();
                dordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA").trim());
                dordenserviciocliente.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                dordenserviciocliente.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dordenserviciocliente.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                dordenserviciocliente.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                dordenserviciocliente.setHora_req(rs.getFloat("HORA_REQ"));
                if(dordenserviciocliente.getHora_req()!=0.0f)
                    dordenserviciocliente.setHora_reqConvert(CoreUtil.convertDecimalTime(dordenserviciocliente.getHora_req()));
                dordenserviciocliente.setFecha_fin_servicio(rs.getDate("FECHA_FIN_SERVICIO"));
                dordenserviciocliente.setFechacreacion(rs.getDate("FECHACREACION"));
                dordenserviciocliente.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Dordenserviciocliente> listarPorEmpresaWeb(String idempresa,String idorigenserviciocliente) throws NisiraORMException {
            ArrayList<Dordenserviciocliente> lista = new ArrayList<Dordenserviciocliente>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDORDENSERVICIOCLIENTE_TMPSS",idempresa,idorigenserviciocliente);
            while (rs.next()) {
                Dordenserviciocliente dordenserviciocliente = new Dordenserviciocliente();
                dordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA").trim());
                dordenserviciocliente.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                dordenserviciocliente.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dordenserviciocliente.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                dordenserviciocliente.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                dordenserviciocliente.setHora_req(rs.getFloat("HORA_REQ"));
                if(dordenserviciocliente.getHora_req()!=0.0f)
                    dordenserviciocliente.setHora_reqConvert(CoreUtil.convertDecimalTime(dordenserviciocliente.getHora_req()));
                dordenserviciocliente.setFecha_fin_servicio(rs.getDate("FECHA_FIN_SERVICIO"));
                dordenserviciocliente.setFechacreacion(rs.getDate("FECHACREACION"));
                dordenserviciocliente.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}