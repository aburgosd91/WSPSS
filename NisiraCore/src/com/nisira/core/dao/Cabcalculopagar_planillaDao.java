package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Cabcalculopagar_planilla;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Detcalculopagar_planilla;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cabcalculopagar_planillaDao extends BaseDao<Cabcalculopagar_planilla> {
	public Cabcalculopagar_planillaDao() {
		super(Cabcalculopagar_planilla.class);
	}
	public Cabcalculopagar_planillaDao(boolean usaCnBase) throws NisiraORMException {
		super(Cabcalculopagar_planilla.class, usaCnBase);
	}

	public Cabcalculopagar_planilla getPorClavePrimaria(String IDEMPRESA, String IDCABCALCULOPAGAR_PLANILLA) throws NisiraORMException {
		List<Cabcalculopagar_planilla> l = listar("t0.IDEMPRESA = ? and t0.IDCABCALCULOPAGAR_PLANILLA = ? ", IDEMPRESA, IDCABCALCULOPAGAR_PLANILLA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public ArrayList<Cabcalculopagar_planilla> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException,Exception {
            ArrayList<Cabcalculopagar_planilla> lista = new ArrayList<Cabcalculopagar_planilla>();
            String periodo_="";    
            ResultSet rs = null;
            rs = execProcedure("GETCABCALCULOPAGAR_PLANILLA_TMPSS",idempresa,fechainicio,fechafin);
            while (rs.next()) {
                Cabcalculopagar_planilla cabcalculopagar = new Cabcalculopagar_planilla();
                cabcalculopagar.setIdempresa(rs.getString("IDEMPRESA").trim());
                cabcalculopagar.setIdcabcalculopagar_planilla(rs.getString("IDCABCALCULOPAGAR_PLANILLA")!=null?rs.getString("IDCABCALCULOPAGAR_PLANILLA").trim():"");
                cabcalculopagar.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                cabcalculopagar.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                cabcalculopagar.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                cabcalculopagar.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                cabcalculopagar.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                cabcalculopagar.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                cabcalculopagar.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                periodo_ =cabcalculopagar.getPeriodo()==null?"":cabcalculopagar.getPeriodo();
                if(periodo_.length()>0)
                    cabcalculopagar.setMes(CoreUtil.strMonths[Integer.parseInt(periodo_.substring(4,5))]);
                cabcalculopagar.setFecha(rs.getDate("FECHA"));
                cabcalculopagar.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                cabcalculopagar.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                cabcalculopagar.setAlmacen(rs.getString("ALMACEN")!=null?rs.getString("ALMACEN").trim():"");
                cabcalculopagar.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                cabcalculopagar.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                cabcalculopagar.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                cabcalculopagar.setUsuario(rs.getString("USUARIO")!=null?rs.getString("USUARIO").trim():"");
                cabcalculopagar.setFinicio(rs.getDate("FINICIO"));
                cabcalculopagar.setFfin(rs.getDate("FFIN"));
                cabcalculopagar.setTipo(rs.getString("TIPO")!=null?rs.getString("TIPO").trim():"");
                lista.add(cabcalculopagar); 
            }
            return lista;
        }
        public ArrayList<Cabcalculopagar_planilla> listarPorEmpresaWebFiltroAprobado(String idempresa) throws NisiraORMException,Exception {
            ArrayList<Cabcalculopagar_planilla> lista = new ArrayList<Cabcalculopagar_planilla>();
            String periodo_="";    
            ResultSet rs = null;
            rs = execProcedure("GETCABCALCULOPAGAR_PLANILLA_APROBADO_TMPSS",idempresa);
            while (rs.next()) {
                Cabcalculopagar_planilla cabcalculopagar = new Cabcalculopagar_planilla();
                cabcalculopagar.setIdempresa(rs.getString("IDEMPRESA").trim());
                cabcalculopagar.setIdcabcalculopagar_planilla(rs.getString("IDCABCALCULOPAGAR_PLANILLA")!=null?rs.getString("IDCABCALCULOPAGAR_PLANILLA").trim():"");
                cabcalculopagar.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                cabcalculopagar.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                cabcalculopagar.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                cabcalculopagar.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                cabcalculopagar.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                cabcalculopagar.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                cabcalculopagar.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                periodo_ =cabcalculopagar.getPeriodo()==null?"":cabcalculopagar.getPeriodo();
                if(periodo_.length()>0)
                    cabcalculopagar.setMes(CoreUtil.strMonths[Integer.parseInt(periodo_.substring(4,5))]);
                cabcalculopagar.setFecha(rs.getDate("FECHA"));
                cabcalculopagar.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                cabcalculopagar.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                cabcalculopagar.setAlmacen(rs.getString("ALMACEN")!=null?rs.getString("ALMACEN").trim():"");
                cabcalculopagar.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                cabcalculopagar.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                cabcalculopagar.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                cabcalculopagar.setUsuario(rs.getString("USUARIO")!=null?rs.getString("USUARIO").trim():"");
                cabcalculopagar.setFinicio(rs.getDate("FINICIO"));
                cabcalculopagar.setFfin(rs.getDate("FFIN"));
                cabcalculopagar.setTipo(rs.getString("TIPO")!=null?rs.getString("TIPO").trim():"");
                lista.add(cabcalculopagar); 
            }
            return lista;
        }
        public String grabar(int tipo,Cabcalculopagar_planilla ob,List<Detcalculopagar_planilla> listDetcalculopagar,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Cabcalculopagar_planilla.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES DORDENSERVICIOCLIENTE **********************/
            String xmlDet_tareoweb = "";
            xStream = new XStream();
            xStream.processAnnotations(Detcalculopagar_planilla.class);
            xmlDet_tareoweb = xml + xStream.toXML(listDetcalculopagar);
            
            ResultSet rs = null;
            rs = execProcedure("SP_CABCALCULOPAGAR_PLANILLA_GRABAR",
                    tipo,
                    ob.getIdempresa(),ob.getIdcabcalculopagar_planilla(),
                    ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                    xmlNot,
                    xmlDet_tareoweb,
                    idusuario
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
        public String aprobarCalculoPagar_Planilla(Cabcalculopagar_planilla ob,String idusuario) throws Exception {
            String mensaje="";
            ResultSet rs = null;
            rs = execProcedure("SP_CABCALCULOPAGAR_PLANILLO_UPDATE_ESTADO",
                2,
                ob.getIdempresa(),
                ob.getIdcabcalculopagar_planilla(),
                idusuario
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
    public String anular(String idempresa,String codigo,String idusuario) throws Exception {
        String mensaje="";
        /********* ESTRUCTURA COSTOS ***********/
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_CABCALCULOPAGAR_PLANILLA_ANULAR",idempresa,codigo,idusuario
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
    public String eliminar(String idempresa,String codigo,String idusuario) throws Exception {
        String mensaje="";
        /********* ESTRUCTURA COSTOS ***********/
        try {
            ResultSet rs = null;
            rs = execProcedure("SP_CABCALCULOPAGAR_PLANILLA_ELIMINAR",idempresa,codigo,idusuario
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
}