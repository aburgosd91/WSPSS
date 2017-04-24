package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                personal_servicio.setFechafin(rs.getDate("FECHAFIN"));
                personal_servicio.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                personal_servicio.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                lista.add(personal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public String syncro_movil_object(Personal_servicio ob,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Personal_servicio.class);
            xmlNot = xml + xStream.toXML(ob);
            
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_PERSONAL_SERVICIO_SYNCRO",
                        1,ob.getIdempresa(),ob.getIdordenservicio(),
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
        public String syncro_movil_list(List<Personal_servicio> lst,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Personal_servicio.class);
            xmlNot = xml + xStream.toXML(lst);
            Personal_servicio ob=lst.get(0);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_PERSONAL_SERVICIO_SYNCRO",
                        2,ob.getIdempresa(),ob.getIdordenservicio(),
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
        /*APP WEB*/
        public ArrayList<Personal_servicio> listarPorOrdenServicioClienteWeb(String idempresa,String idordenservicio,String item) throws NisiraORMException {
            ArrayList<Personal_servicio> lista = new ArrayList<Personal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPERSONAL_SERVICIO_TMPSS",idempresa,idordenservicio,item,1);
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
                personal_servicio.setFechafin(rs.getDate("FECHAFIN"));
                lista.add(personal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Personal_servicio> listarPorOrdenServicioClienteWeb_Total(String idempresa,String idordenservicio) throws NisiraORMException {
            ArrayList<Personal_servicio> lista = new ArrayList<Personal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPERSONAL_SERVICIO_TOTAL_TMPSS",idempresa,idordenservicio);
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
                personal_servicio.setFechafin(rs.getDate("FECHAFIN"));
                personal_servicio.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                personal_servicio.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                personal_servicio.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                lista.add(personal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }

}