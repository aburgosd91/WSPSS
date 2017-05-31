package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                dordenserviciocliente.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                dordenserviciocliente.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                dordenserviciocliente.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dordenserviciocliente.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                dordenserviciocliente.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public String syncro_movil_object(Dordenserviciocliente ob,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Dordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(ob);
            
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_DORDENSERVICIOCLIENTE_SYNCRO",
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
        public String syncro_movil_list(List<Dordenserviciocliente> lst,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Dordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(lst);
            Dordenserviciocliente ob=lst.get(0);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_DORDENSERVICIOCLIENTE_SYNCRO",
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
        public ArrayList<Dordenserviciocliente> listarPorEmpresaWeb(String idempresa,String idorigenserviciocliente) throws NisiraORMException {
            ArrayList<Dordenserviciocliente> lista = new ArrayList<Dordenserviciocliente>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETDORDENSERVICIOCLIENTE_TMPSS",idempresa,idorigenserviciocliente,1);
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
                dordenserviciocliente.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                dordenserviciocliente.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                dordenserviciocliente.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dordenserviciocliente.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                dordenserviciocliente.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                dordenserviciocliente.setHora_rc(rs.getFloat("HORA_RC"));
                dordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                dordenserviciocliente.setCodoperaciones(rs.getString("CODOPERACIONES")!=null?rs.getString("CODOPERACIONES").trim():"");
                dordenserviciocliente.setIdruta_ec(rs.getString("IDRUTA_EC")!=null?rs.getString("IDRUTA_EC").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}