package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dlogtablas_operaciones;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Config_ventana_filtro_web;
import com.nisira.core.entity.Usuario;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dlogtablas_operacionesDao extends BaseDao<Dlogtablas_operaciones> {
	public Dlogtablas_operacionesDao() {
		super(Dlogtablas_operaciones.class);
	}
	public Dlogtablas_operacionesDao(boolean usaCnBase) throws NisiraORMException {
		super(Dlogtablas_operaciones.class, usaCnBase);
	}

	public Dlogtablas_operaciones getPorClavePrimaria(String IDEMPRESA, String IDLOG, String ITEM) throws NisiraORMException {
		List<Dlogtablas_operaciones> l = listar("t0.IDEMPRESA = ? and t0.IDLOG = ? and t0.ITEM = ? ", IDEMPRESA, IDLOG, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public List<Dlogtablas_operaciones> lstDlogtablas_operaciones(String idempresa,List<Usuario> lstusuario,List<Config_ventana_filtro_web> lstConfig_ventana_filtro_web,
            String desde,String hasta,int tipo,String iddocumento,String serie,String numero) throws NisiraORMException {
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            
            XStream xStream = new XStream();
            xStream.processAnnotations(Usuario.class);
            xmlNot = xml + xStream.toXML(lstusuario);
            
            String xmlConfig_ventana_filtro_web = "";
            xStream = new XStream();
            xStream.processAnnotations(Config_ventana_filtro_web.class);
            xmlConfig_ventana_filtro_web= xml + xStream.toXML(lstConfig_ventana_filtro_web);
            
            ArrayList<Dlogtablas_operaciones> lista = new ArrayList<Dlogtablas_operaciones>();
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_LOG_TABLAS_DETALLE",
                        idempresa,
                        xmlNot,
                        xmlConfig_ventana_filtro_web,
                        desde,
                        hasta,
                        tipo,
                        iddocumento,
                        serie,
                        numero
                        );
                while (rs.next()){
                    Dlogtablas_operaciones am = new Dlogtablas_operaciones();
                    am.setIdlog(rs.getString("IDLOG")!=null?rs.getString("IDLOG").trim():"");
                    am.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                    am.setTabla(rs.getString("TABLA")!=null?rs.getString("TABLA").trim():"");
                    am.setIdcampo(rs.getString("IDCAMPO")!=null?rs.getString("IDCAMPO").trim():"");
                    am.setCampoclave(rs.getString("CAMPOCLAVE")!=null?rs.getString("CAMPOCLAVE").trim():"");
                    am.setIdtabla(rs.getString("IDTABLA")!=null?rs.getString("IDTABLA").trim():"");
                    am.setEvento(rs.getString("EVENTO")!=null?rs.getString("EVENTO").trim():"");
                    am.setValoranterior(rs.getString("VALORANTERIOR")!=null?rs.getString("VALORANTERIOR").trim():"");
                    am.setValoractual(rs.getString("VALORACTUAL")!=null?rs.getString("VALORACTUAL").trim():"");
                    am.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                    am.setMaquina(rs.getString("MAQUINA")!=null?rs.getString("MAQUINA").trim():"");
                    am.setVentana(rs.getString("VENTANA")!=null?rs.getString("VENTANA").trim():"");
                    am.setNum(rs.getInt("NUM"));
                    am.setFechacreacion(rs.getDate("FECHACREACION"));
                    am.setHora(rs.getString("HORA")!=null?rs.getString("HORA").trim():"");
                    am.setCid(rs.getString("CID")!=null?rs.getString("CID").trim():"");
                    am.setCiddoc(rs.getString("CIDDOC")!=null?rs.getString("CIDDOC").trim():"");
                    am.setCserie(rs.getString("CSERIE")!=null?rs.getString("CSERIE").trim():"");
                    am.setCnumero(rs.getString("CNUMERO")!=null?rs.getString("CNUMERO").trim():"");
                    am.setCusuario(rs.getString("CUSUARIO")!=null?rs.getString("CUSUARIO").trim():"");
                    am.setCproceso(rs.getString("CPROCESO")!=null?rs.getString("CPROCESO").trim():"");
                    lista.add(am);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
}