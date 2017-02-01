package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Ruta_servicios;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdenservicioclienteDao extends BaseDao<Ordenserviciocliente> {
	public OrdenservicioclienteDao() {
		super(Ordenserviciocliente.class);
	}
	public OrdenservicioclienteDao(boolean usaCnBase) throws NisiraORMException {
		super(Ordenserviciocliente.class, usaCnBase);
	}
        /*WEB SERVICE*/
        public ArrayList<Ordenserviciocliente> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETORDENSERVICIOCLIENTE_TMPSS",idempresa);
            while (rs.next()) {
                Ordenserviciocliente ordenserviciocliente = new Ordenserviciocliente();
                ordenserviciocliente.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA").trim());
                ordenserviciocliente.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                ordenserviciocliente.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                ordenserviciocliente.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                ordenserviciocliente.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                ordenserviciocliente.setNromanual(rs.getString("NROMANUAL")!=null?rs.getString("NROMANUAL").trim():"");
                ordenserviciocliente.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                ordenserviciocliente.setFecha(rs.getDate("FECHA"));
                ordenserviciocliente.setTipo_servicio(rs.getString("TIPO_SERVICIO")!=null?rs.getString("TIPO_SERVICIO").trim():"");
                ordenserviciocliente.setAmbito_servicio(rs.getString("AMBITO_SERVICIO")!=null?rs.getString("AMBITO_SERVICIO").trim():"");
                ordenserviciocliente.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                ordenserviciocliente.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenserviciocliente.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenserviciocliente.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                ordenserviciocliente.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                ordenserviciocliente.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                lista.add(ordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Ordenserviciocliente> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETORDENSERVICIOCLIENTE_TMPSS",idempresa);
            while (rs.next()) {
                Ordenserviciocliente ordenserviciocliente = new Ordenserviciocliente();
                ordenserviciocliente.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA").trim());
                ordenserviciocliente.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                ordenserviciocliente.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                ordenserviciocliente.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                ordenserviciocliente.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                ordenserviciocliente.setNromanual(rs.getString("NROMANUAL")!=null?rs.getString("NROMANUAL").trim():"");
                ordenserviciocliente.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                ordenserviciocliente.setFecha(rs.getDate("FECHA"));
                ordenserviciocliente.setTipo_servicio(rs.getString("TIPO_SERVICIO")!=null?rs.getString("TIPO_SERVICIO").trim():"");
                ordenserviciocliente.setAmbito_servicio(rs.getString("AMBITO_SERVICIO")!=null?rs.getString("AMBITO_SERVICIO").trim():"");
                ordenserviciocliente.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                ordenserviciocliente.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenserviciocliente.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenserviciocliente.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                ordenserviciocliente.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                ordenserviciocliente.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                lista.add(ordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public String grabar(int tipo,Ordenserviciocliente ob,List<Dordenserviciocliente> listDorden,List<Personal_servicio> listPersonal_servicio,
                    List<Docreferencia> listDocreferencia,List<Ruta_servicios> listRuta_servicios,
                    List<Dpersonal_servicio> listDpersonal_servicio) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES DORDENSERVICIOCLIENTE **********************/
            String xmlDOrdenserviciocliente = "";
            xStream = new XStream();
            xStream.processAnnotations(Dordenserviciocliente.class);
            xmlDOrdenserviciocliente = xml + xStream.toXML(listDorden);
            /******************* DETALLES PERSONAL_SERVICIO **********************/
            String xmlPersonal_servicio = "";
            xStream = new XStream();
            xStream.processAnnotations(Personal_servicio.class);
            xmlPersonal_servicio = xml + xStream.toXML(listPersonal_servicio);
            /******************* DETALLES DOCREFERENCIA **********************/
            String xmlDocreferencia = "";
            xStream = new XStream();
            xStream.processAnnotations(Docreferencia.class);
            xmlDocreferencia = xml + xStream.toXML(listDocreferencia);
            /******************* DETALLES RUTAS SERVICIOS **********************/
            String xmlRuta_servicios = "";
            xStream = new XStream();
            xStream.processAnnotations(Ruta_servicios.class);
            xmlRuta_servicios = xml + xStream.toXML(listRuta_servicios);
            /******************* DETALLES RUTAS SERVICIOS **********************/
            String xmlDPersonal_servicio = "";
            xStream = new XStream();
            xStream.processAnnotations(Dpersonal_servicio.class);
            xmlDPersonal_servicio = xml + xStream.toXML(listDpersonal_servicio);
            /*************************************************************************/
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENSERVICIOCLIENTE_GRABAR",
                        tipo,
                        ob.getIdempresa(),ob.getIdordenservicio(),ob.getIdcotizacionv(),
                        ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                        xmlNot,
                        xmlDOrdenserviciocliente,
                        xmlPersonal_servicio,
                        xmlDocreferencia,
                        xmlRuta_servicios,
                        xmlDPersonal_servicio
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