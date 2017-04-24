package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dpersonal_servicioDao extends BaseDao<Dpersonal_servicio> {
	public Dpersonal_servicioDao() {
		super(Dpersonal_servicio.class);
	}
	public Dpersonal_servicioDao(boolean usaCnBase) throws NisiraORMException {
		super(Dpersonal_servicio.class, usaCnBase);
	}

	public Dpersonal_servicio getPorClavePrimaria(String IDEMPRESA, String IDORDENSERVICIO, String ITEM_DORDENSERVICIO, String ITEM2, String ITEM) throws NisiraORMException {
		List<Dpersonal_servicio> l = listar("t0.IDEMPRESA = ? and t0.IDORDENSERVICIO = ? and t0.ITEM_DORDENSERVICIO = ? and t0.ITEM2 = ? and t0.ITEM = ? ", IDEMPRESA, IDORDENSERVICIO, ITEM_DORDENSERVICIO, ITEM2, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public ArrayList<Dpersonal_servicio> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Dpersonal_servicio> lista = new ArrayList<Dpersonal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDPERSONAL_SERVICIO_TMPSS",idempresa);
            while (rs.next()) {
                Dpersonal_servicio dpersonal_servicio = new Dpersonal_servicio();
                dpersonal_servicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                dpersonal_servicio.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem2(rs.getString("ITEM2")!=null?rs.getString("ITEM2").trim():"");
                dpersonal_servicio.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dpersonal_servicio.setHora_req(rs.getFloat("HORA_REQ"));
                if(dpersonal_servicio.getHora_req()!=0.0f)
                    dpersonal_servicio.setFhora_req(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_req()));
                dpersonal_servicio.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(dpersonal_servicio.getHora_llegada()!=0.0f)
                    dpersonal_servicio.setFhora_llegada(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_llegada()));
                dpersonal_servicio.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(dpersonal_servicio.getHora_inicio_serv()!=0.0f)
                    dpersonal_servicio.setFhora_inicio_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_inicio_serv()));
                dpersonal_servicio.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(dpersonal_servicio.getHora_fin_serv()!=0.0f)
                    dpersonal_servicio.setFhora_fin_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_fin_serv()));
                dpersonal_servicio.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(dpersonal_servicio.getHora_liberacion()!=0.0f)
                    dpersonal_servicio.setFhora_liberacion(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_liberacion()));
                dpersonal_servicio.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                dpersonal_servicio.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                dpersonal_servicio.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                dpersonal_servicio.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                lista.add(dpersonal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public String syncro_movil_object(Dpersonal_servicio ob,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Dpersonal_servicio.class);
            xmlNot = xml + xStream.toXML(ob);
            
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_DPERSONAL_SERVICIO_SYNCRO",
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
        public String syncro_movil_list(List<Dpersonal_servicio> lst,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Dpersonal_servicio.class);
            xmlNot = xml + xStream.toXML(lst);
            Dpersonal_servicio ob=lst.get(0);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_DPERSONAL_SERVICIO_SYNCRO",
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
        public ArrayList<Dpersonal_servicio> listarPorOrdenServicio_PersonalDetalleWeb(String idempresa,String idordenservicio,
                String item_dordenservicio,String item2) throws NisiraORMException {
            ArrayList<Dpersonal_servicio> lista = new ArrayList<Dpersonal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDPERSONAL_SERVICIO_TMPSS",idempresa,idordenservicio,item_dordenservicio,item2,1);
            while (rs.next()) {
                Dpersonal_servicio dpersonal_servicio = new Dpersonal_servicio();
                dpersonal_servicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                dpersonal_servicio.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem2(rs.getString("ITEM2")!=null?rs.getString("ITEM2").trim():"");
                dpersonal_servicio.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dpersonal_servicio.setHora_req(rs.getFloat("HORA_REQ"));
                if(dpersonal_servicio.getHora_req()!=0.0f)
                    dpersonal_servicio.setFhora_req(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_req()));
                dpersonal_servicio.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(dpersonal_servicio.getHora_llegada()!=0.0f)
                    dpersonal_servicio.setFhora_llegada(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_llegada()));
                dpersonal_servicio.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(dpersonal_servicio.getHora_inicio_serv()!=0.0f)
                    dpersonal_servicio.setFhora_inicio_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_inicio_serv()));
                dpersonal_servicio.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(dpersonal_servicio.getHora_fin_serv()!=0.0f)
                    dpersonal_servicio.setFhora_fin_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_fin_serv()));
                dpersonal_servicio.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(dpersonal_servicio.getHora_liberacion()!=0.0f)
                    dpersonal_servicio.setFhora_liberacion(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_liberacion()));
                dpersonal_servicio.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                dpersonal_servicio.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                dpersonal_servicio.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                dpersonal_servicio.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                lista.add(dpersonal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
         public ArrayList<Dpersonal_servicio> listarPorOrdenServicio_PersonalDetalleWeb_Total(String idempresa,String idordenservicio) throws NisiraORMException {
            ArrayList<Dpersonal_servicio> lista = new ArrayList<Dpersonal_servicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDPERSONAL_SERVICIO_TOTAL_TMPSS",idempresa,idordenservicio);
            while (rs.next()) {
                Dpersonal_servicio dpersonal_servicio = new Dpersonal_servicio();
                dpersonal_servicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                dpersonal_servicio.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                dpersonal_servicio.setItem2(rs.getString("ITEM2")!=null?rs.getString("ITEM2").trim():"");
                dpersonal_servicio.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dpersonal_servicio.setHora_req(rs.getFloat("HORA_REQ"));
                if(dpersonal_servicio.getHora_req()!=0.0f)
                    dpersonal_servicio.setFhora_req(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_req()));
                dpersonal_servicio.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(dpersonal_servicio.getHora_llegada()!=0.0f)
                    dpersonal_servicio.setFhora_llegada(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_llegada()));
                dpersonal_servicio.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(dpersonal_servicio.getHora_inicio_serv()!=0.0f)
                    dpersonal_servicio.setFhora_inicio_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_inicio_serv()));
                dpersonal_servicio.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(dpersonal_servicio.getHora_fin_serv()!=0.0f)
                    dpersonal_servicio.setFhora_fin_serv(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_fin_serv()));
                dpersonal_servicio.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(dpersonal_servicio.getHora_liberacion()!=0.0f)
                    dpersonal_servicio.setFhora_liberacion(CoreUtil.convertDecimalTime(dpersonal_servicio.getHora_liberacion()));
                dpersonal_servicio.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                dpersonal_servicio.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                dpersonal_servicio.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                dpersonal_servicio.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                lista.add(dpersonal_servicio); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}