package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Config_report_pss;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Config_report_pssDao extends BaseDao<Config_report_pss> {
	public Config_report_pssDao() {
		super(Config_report_pss.class);
	}
	public Config_report_pssDao(boolean usaCnBase) throws NisiraORMException {
		super(Config_report_pss.class, usaCnBase);
	}

	public Config_report_pss getPorClavePrimaria(String IDEMPRESA, String IDCONFIG_REPORT, String IDTIPOSERVICIO) throws NisiraORMException {
		List<Config_report_pss> l = listar("t0.IDEMPRESA = ? and t0.IDCONFIG_REPORT = ? and t0.IDTIPOSERVICIO = ? ", IDEMPRESA, IDCONFIG_REPORT, IDTIPOSERVICIO);
		if (l.isEmpty()) {
                    return null;
		} else {
                    return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Config_report_pss> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Config_report_pss> lista = new ArrayList<Config_report_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONFIG_REPORT_PSS_TMPSS",idempresa);
            while (rs.next()) {
                Config_report_pss config_report_pss = new Config_report_pss();
                config_report_pss.setIdempresa(rs.getString("IDEMPRESA").trim());
                config_report_pss.setIdconfig_report(rs.getString("IDCONFIG_REPORT")!=null?rs.getString("IDCONFIG_REPORT").trim():"");
                config_report_pss.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                config_report_pss.setDato1(rs.getString("DATO1")!=null?rs.getString("DATO1").trim():"");
                config_report_pss.setDato2(rs.getString("DATO2")!=null?rs.getString("DATO2").trim():"");
                config_report_pss.setDato3(rs.getString("DATO3")!=null?rs.getString("DATO3").trim():"");
                config_report_pss.setFechacreacion(rs.getDate("FECHACREACION"));
                config_report_pss.setEstado(rs.getInt("ESTADO"));
                config_report_pss.setTiposervicio(rs.getString("TIPOSERVICIO")!=null?rs.getString("TIPOSERVICIO").trim():"");
                lista.add(config_report_pss);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        /*APP WEB*/
        public ArrayList<Config_report_pss> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Config_report_pss> lista = new ArrayList<Config_report_pss>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONFIG_REPORT_PSS_TMPSS",idempresa);
            while (rs.next()) {
                Config_report_pss config_report_pss = new Config_report_pss();
                config_report_pss.setIdempresa(rs.getString("IDEMPRESA").trim());
                config_report_pss.setIdconfig_report(rs.getString("IDCONFIG_REPORT")!=null?rs.getString("IDCONFIG_REPORT").trim():"");
                config_report_pss.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                config_report_pss.setDato1(rs.getString("DATO1")!=null?rs.getString("DATO1").trim():"");
                config_report_pss.setDato2(rs.getString("DATO2")!=null?rs.getString("DATO2").trim():"");
                config_report_pss.setDato3(rs.getString("DATO3")!=null?rs.getString("DATO3").trim():"");
                config_report_pss.setFechacreacion(rs.getDate("FECHACREACION"));
                config_report_pss.setEstado(rs.getInt("ESTADO"));
                config_report_pss.setTiposervicio(rs.getString("TIPOSERVICIO")!=null?rs.getString("TIPOSERVICIO").trim():"");
                lista.add(config_report_pss);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        /*nuevo / editar*/
        public String grabar(int tipo,Config_report_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Config_report_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_CONFIG_REPORT_PSS_GRABAR",tipo,obj.getIdempresa(),obj.getIdconfig_report(),xmlNot);
                while (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    break;
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return mensaje;
        }
        public String anular_eliminar(int tipo,Config_report_pss obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Config_report_pss.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_CONFIG_REPORT_PSS_GRABAR",tipo,obj.getIdempresa(),obj.getIdconfig_report());
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