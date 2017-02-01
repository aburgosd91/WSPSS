package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ruta;
import com.nisira.core.NisiraORMException;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RutaDao extends BaseDao<Ruta> {
	public RutaDao() {
		super(Ruta.class);
	}
	public RutaDao(boolean usaCnBase) throws NisiraORMException {
		super(Ruta.class, usaCnBase);
	}

	public Ruta getPorClavePrimaria(Integer IdRuta, String IDEMPRESA) throws NisiraORMException {
		List<Ruta> l = listar("t0.IdRuta = ? and t0.IDEMPRESA = ? ", IdRuta, IDEMPRESA);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Ruta> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Ruta> lista = new ArrayList<Ruta>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETRUTA_TMPSS",idempresa);
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ruta.setIdempresa(rs.getString("IDEMPRESA").trim());
                ruta.setIdruta(rs.getInt("IDRUTA"));
                ruta.setNroruta(rs.getString("NRORUTA")!=null?rs.getString("NRORUTA").trim():"");
                ruta.setDenominacionruta(rs.getString("DENOMINACIONRUTA")!=null?rs.getString("DENOMINACIONRUTA").trim():"");
                ruta.setIdtiporuta(rs.getInt("IDTIPORUTA"));
                ruta.setIdterminalorigen(rs.getInt("IDTERMINALORIGEN"));
                ruta.setIdterminaldestino(rs.getInt("IDTERMINALDESTINO"));
                ruta.setDistancia(rs.getFloat("DISTANCIA"));
                ruta.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                ruta.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                ruta.setFechacreacion(rs.getDate("FECHACREACION"));
                ruta.setEstado(rs.getInt("ESTADO"));
                ruta.setRutamultiple(rs.getInt("RUTAMULTIPLE"));
                ruta.setRutaorigen(rs.getString("RUTAORIGEN")!=null?rs.getString("RUTAORIGEN").trim():"");
                ruta.setRutadestino(rs.getString("RUTADESTINO")!=null?rs.getString("RUTADESTINO").trim():"");
                lista.add(ruta);        
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        public String grabar(int tipo,Ruta obj) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ruta.class);
            xmlNot = xml + xStream.toXML(obj);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_RUTA_GRABAR",tipo,obj.getIdempresa(),obj.getIdruta(),xmlNot);
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