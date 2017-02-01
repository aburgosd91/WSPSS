package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Personal_servicioDao extends BaseDao<Personal_servicio> {
	public Personal_servicioDao() {
		super(Personal_servicio.class);
	}
	public Personal_servicioDao(boolean usaCnBase) throws NisiraORMException {
		super(Personal_servicio.class, usaCnBase);
	}
        /*APP SERVICE*/
        public ArrayList<Personal_servicio> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Personal_servicio> lista = new ArrayList<Personal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPERSONAL_SERVICIO_TMPSS",idempresa);
            while (rs.next()) {
                Personal_servicio personal_servicio = new Personal_servicio();
                personal_servicio.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                personal_servicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                personal_servicio.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                personal_servicio.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                personal_servicio.setItem2(rs.getString("ITEM2")!=null?rs.getString("ITEM2").trim():"");
                personal_servicio.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                personal_servicio.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                personal_servicio.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                personal_servicio.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                personal_servicio.setFechaoperacion(rs.getDate("FECHAOPERACION"));
                personal_servicio.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                lista.add(personal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Personal_servicio> listarPorOrdenServicioClienteWeb(String idempresa,String idordenservicio,String item) throws NisiraORMException {
            ArrayList<Personal_servicio> lista = new ArrayList<Personal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPERSONAL_SERVICIO_TMPSS",idempresa,idordenservicio,item);
            while (rs.next()) {
                Personal_servicio personal_servicio = new Personal_servicio();
                personal_servicio.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                personal_servicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                personal_servicio.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                personal_servicio.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                personal_servicio.setItem2(rs.getString("ITEM2")!=null?rs.getString("ITEM2").trim():"");
                personal_servicio.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                personal_servicio.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                personal_servicio.setNombres(rs.getString("NOMBRES")!=null?rs.getString("NOMBRES").trim():"");
                personal_servicio.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                personal_servicio.setFechaoperacion(rs.getDate("FECHAOPERACION"));
                personal_servicio.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                lista.add(personal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }

}