package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Privilegio_global_pss;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Privilegio_global_pssDao extends BaseDao<Privilegio_global_pss> {
	public Privilegio_global_pssDao() {
		super(Privilegio_global_pss.class);
	}
	public Privilegio_global_pssDao(boolean usaCnBase) throws NisiraORMException {
		super(Privilegio_global_pss.class, usaCnBase);
	}
        public ArrayList<Privilegio_global_pss> listarPorUsuario(String idusuario) throws NisiraORMException {
            ArrayList<Privilegio_global_pss> lista = new ArrayList<Privilegio_global_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETPRIVILEGIO_GLOBAL_TMPSS",idusuario);
            while (rs.next()) {
                Privilegio_global_pss privilegio = new Privilegio_global_pss();
                privilegio.setIdempresa(rs.getString("IDEMPRESA")==null?"":rs.getString("IDEMPRESA"));
                privilegio.setIdusuario(rs.getString("IDUSUARIO")==null?"":rs.getString("IDUSUARIO"));
                privilegio.setVista(rs.getString("VISTA")==null?"":rs.getString("VISTA"));
                privilegio.setFechacreacion(rs.getDate("FECHACREACION"));
                privilegio.setUsuario(rs.getString("USUARIO")==null?"":rs.getString("USUARIO"));
                lista.add(privilegio);                             
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*nuevo / editar*/
        public String grabar(int tipo,Privilegio_global_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Privilegio_global_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_PRIVILEGIO_GLOBAL_PSS_GRABAR",tipo,obj.getIdempresa(),obj.getIdusuario(),xmlNot);
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
        public String anular_eliminar(int tipo,Privilegio_global_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Privilegio_global_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_PRIVILEGIO_GLOBAL_PSS_GRABAR",tipo,obj.getIdempresa(),obj.getIdusuario());
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
}