package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Codoperaciones_pss;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Codoperaciones_pssDao extends BaseDao<Codoperaciones_pss> {
	public Codoperaciones_pssDao() {
		super(Codoperaciones_pss.class);
	}
	public Codoperaciones_pssDao(boolean usaCnBase) throws NisiraORMException {
		super(Codoperaciones_pss.class, usaCnBase);
	}

	public Codoperaciones_pss getPorClavePrimaria(String IDCODOPERACIONES) throws NisiraORMException {
		List<Codoperaciones_pss> l = listar("t0.IDCODOPERACIONES = ? ", IDCODOPERACIONES);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Codoperaciones_pss> listarPorEmpresaWeb_Activo() throws NisiraORMException {
            ArrayList<Codoperaciones_pss> lista = new ArrayList<Codoperaciones_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCODOPERACIONES_PSS_ACTIVO_TMPSS");
            while (rs.next()) {
                Codoperaciones_pss codoperaciones_pss = new Codoperaciones_pss();
                codoperaciones_pss.setIdcodoperaciones(rs.getString("IDCODOPERACIONES").trim());
                codoperaciones_pss.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                codoperaciones_pss.setDescripcion_corta(rs.getString("DESCRIPCION_CORTA")!=null?rs.getString("DESCRIPCION_CORTA").trim():"");
                codoperaciones_pss.setFechacreacion(rs.getDate("FECHACREACION"));
                codoperaciones_pss.setEstado(rs.getFloat("ESTADO"));
                lista.add(codoperaciones_pss);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public ArrayList<Codoperaciones_pss> listarPorEmpresaWeb() throws NisiraORMException {
            ArrayList<Codoperaciones_pss> lista = new ArrayList<Codoperaciones_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCODOPERACIONES_PSS_TMPSS");
            while (rs.next()) {
                Codoperaciones_pss codoperaciones_pss = new Codoperaciones_pss();
                codoperaciones_pss.setIdcodoperaciones(rs.getString("IDCODOPERACIONES").trim());
                codoperaciones_pss.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                codoperaciones_pss.setDescripcion_corta(rs.getString("DESCRIPCION_CORTA")!=null?rs.getString("DESCRIPCION_CORTA").trim():"");
                codoperaciones_pss.setFechacreacion(rs.getDate("FECHACREACION"));
                codoperaciones_pss.setEstado(rs.getFloat("ESTADO"));
                lista.add(codoperaciones_pss);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        public ArrayList<Codoperaciones_pss> listarPorEmpresaService() throws NisiraORMException {
            ArrayList<Codoperaciones_pss> lista = new ArrayList<Codoperaciones_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCODOPERACIONES_TMPSS");
            while (rs.next()) {
                Codoperaciones_pss codoperaciones_pss = new Codoperaciones_pss();
                codoperaciones_pss.setIdcodoperaciones(rs.getString("IDCODOPERACIONES").trim());
                codoperaciones_pss.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                codoperaciones_pss.setDescripcion_corta(rs.getString("DESCRIPCION_CORTA")!=null?rs.getString("DESCRIPCION_CORTA").trim():"");
                codoperaciones_pss.setFechacreacion(rs.getDate("FECHACREACION"));
                codoperaciones_pss.setEstado(rs.getFloat("ESTADO"));
                lista.add(codoperaciones_pss);  
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        /*nuevo / editar*/
        public String grabar(int tipo,Codoperaciones_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Codoperaciones_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_CODOPERACIOONES_PSS_GRABAR",tipo,obj.getIdcodoperaciones(),xmlNot);
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
        public String anular_eliminar(int tipo,Codoperaciones_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Codoperaciones_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_CODOPERACIOONES_PSS_GRABAR",tipo,obj.getIdcodoperaciones());
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