package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Wtiposervicio;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WtiposervicioDao extends BaseDao<Wtiposervicio> {
	public WtiposervicioDao() {
		super(Wtiposervicio.class);
	}
	public WtiposervicioDao(boolean usaCnBase) throws NisiraORMException {
		super(Wtiposervicio.class, usaCnBase);
	}

	public Wtiposervicio getPorClavePrimaria(String IDEMPRESA, String IDTIPOSERVICIO) throws NisiraORMException {
		List<Wtiposervicio> l = listar("t0.IDEMPRESA = ? and t0.IDTIPOSERVICIO = ? ", IDEMPRESA, IDTIPOSERVICIO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Wtiposervicio> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Wtiposervicio> lista = new ArrayList<Wtiposervicio>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETWTIPOSERVICIO_TMPSS",idempresa);
            while (rs.next()) {
                Wtiposervicio wtiposervicio = new Wtiposervicio();
                wtiposervicio.setIdempresa(rs.getString("IDEMPRESA").trim());
                wtiposervicio.setIdtiposervicio(rs.getString("IDTIPOSERVICIO").trim());
                wtiposervicio.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                wtiposervicio.setDescripcion_corta(rs.getString("DESCRIPCION_CORTA")!=null?rs.getString("DESCRIPCION_CORTA").trim():"");
                wtiposervicio.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(wtiposervicio);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        /*nuevo / editar*/
        public String grabar(int tipo,Wtiposervicio obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Wtiposervicio.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_WTIPOSERVICIO_GRABAR",tipo,obj.getIdempresa(),obj.getIdtiposervicio(),xmlNot);
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
        public String anular_eliminar(int tipo,Wtiposervicio obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Wtiposervicio.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_WTIPOSERVICIO_GRABAR",tipo,obj.getIdempresa(),obj.getIdtiposervicio());
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