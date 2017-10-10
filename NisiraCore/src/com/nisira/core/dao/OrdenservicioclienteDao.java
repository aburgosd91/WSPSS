package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Reporte_facturacion;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.util.CoreUtil;
import com.nisira.core.util.ReportConfig;
import com.thoughtworks.xstream.XStream;
import java.math.BigDecimal;
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
        public ArrayList<Ordenserviciocliente> listarPorEmpresaService(String idempresa) throws NisiraORMException,Exception {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();
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
                ordenserviciocliente.setIdmotivo(rs.getString("IDMOTIVO")!=null?rs.getString("IDMOTIVO").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenserviciocliente.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                ordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenserviciocliente.setIdoperario(rs.getString("IDOPERARIO")!=null?rs.getString("IDOPERARIO").trim():"");
                ordenserviciocliente.setIdoperario2(rs.getString("IDOPERARIO2")!=null?rs.getString("IDOPERARIO2").trim():"");
                ordenserviciocliente.setOperario(rs.getString("OPERARIO")!=null?rs.getString("OPERARIO").trim():"");
                ordenserviciocliente.setOperario2(rs.getString("OPERARIO2")!=null?rs.getString("OPERARIO2").trim():"");
                lista.add(ordenserviciocliente); 
            }
            return lista;
        }
        public String syncro_movil_object(Ordenserviciocliente ob,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(ob);
            
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENSERVICIOCLIENTE_SYNCRO",
                        1,ob.getIdempresa(),ob.getIdordenservicio(),ob.getIdcotizacionv(),
                        ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
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
        public String syncro_movil_list(List<Ordenserviciocliente> lst,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(lst);
            Ordenserviciocliente ob=lst.get(0);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENSERVICIOCLIENTE_SYNCRO",
                        2,ob.getIdempresa(),ob.getIdordenservicio(),ob.getIdcotizacionv(),
                        ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
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
        public ArrayList<Ordenserviciocliente> listarPorEmpresaWeb(String idempresa) throws NisiraORMException,Exception {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();
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
                ordenserviciocliente.setIdmotivo(rs.getString("IDMOTIVO")!=null?rs.getString("IDMOTIVO").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenserviciocliente.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                ordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenserviciocliente.setIdoperario(rs.getString("IDOPERARIO")!=null?rs.getString("IDOPERARIO").trim():"");
                ordenserviciocliente.setOperario(rs.getString("OPERARIO")!=null?rs.getString("OPERARIO").trim():"");
                ordenserviciocliente.setOperario2(rs.getString("OPERARIO2")!=null?rs.getString("OPERARIO2").trim():"");
                lista.add(ordenserviciocliente); 
            }
            return lista;
        }
        public String grabar(int tipo,Ordenserviciocliente ob,List<Dordenserviciocliente> listDorden,List<Personal_servicio> listPersonal_servicio,
                    List<Docreferencia> listDocreferencia,List<Ruta_servicios> listRuta_servicios,
                    List<Dpersonal_servicio> listDpersonal_servicio,String estado,String idusuario) throws Exception {
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
                    xmlDPersonal_servicio,
                    estado,idusuario
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
        
        public ArrayList<Ordenserviciocliente> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException,Exception {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();

            ResultSet rs = null;
            rs = execProcedure("GETORDENSERVICIOCLIENTE_TMPSS",idempresa,fechainicio,fechafin);
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
                ordenserviciocliente.setIdmotivo(rs.getString("IDMOTIVO")!=null?rs.getString("IDMOTIVO").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenserviciocliente.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                ordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenserviciocliente.setIdoperario(rs.getString("IDOPERARIO")!=null?rs.getString("IDOPERARIO").trim():"");
                ordenserviciocliente.setIdoperario2(rs.getString("IDOPERARIO2")!=null?rs.getString("IDOPERARIO2").trim():"");
                ordenserviciocliente.setOperario(rs.getString("OPERARIO")!=null?rs.getString("OPERARIO").trim():"");
                ordenserviciocliente.setOperario2(rs.getString("OPERARIO2")!=null?rs.getString("OPERARIO2").trim():"");
                ordenserviciocliente.setContacto(rs.getString("CONTACTO")!=null?rs.getString("CONTACTO").trim():"");
                ordenserviciocliente.setIdtareo(rs.getString("IDTAREO")!=null?rs.getString("IDTAREO").trim():"");
                ordenserviciocliente.setSerietareo(rs.getString("SERIETAREO")!=null?rs.getString("SERIETAREO").trim():"");
                ordenserviciocliente.setFechacierre(rs.getDate("FECHACIERRE"));
                lista.add(ordenserviciocliente); 
            }
            return lista;
        }
        
        public String cierreMasivo(int tipo,List<Ordenserviciocliente> listOrdenservicio,String idusuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ordenserviciocliente.class);
            xmlNot = xml + xStream.toXML(listOrdenservicio);
            ResultSet rs = null;
            rs = execProcedure("SP_ORDENSERVICIOCLIENTE_UPDATE_ESTADO",
                    tipo,
                    xmlNot,
                    idusuario
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }
            return mensaje;
        }
    /*FORMATO DETALLADO*/
        public ArrayList<Reporte_facturacion> listar_facturacion_detalladoFiltroFecha(String idempresa,String fechainicio,String fechafin,String idtiposervicio) throws NisiraORMException,Exception {
            ArrayList<Reporte_facturacion> lista = new ArrayList<Reporte_facturacion>();

            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_FACTURACION_TMPSS",idempresa,fechainicio,fechafin,idtiposervicio);
            while (rs.next()) {
                Reporte_facturacion reporte_facturacion = new Reporte_facturacion();
                reporte_facturacion.setItem(rs.getInt("ITEM"));
                reporte_facturacion.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                reporte_facturacion.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                reporte_facturacion.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                reporte_facturacion.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                reporte_facturacion.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                reporte_facturacion.setFecha(rs.getDate("FECHA"));
                reporte_facturacion.setFecha_operacion(rs.getDate("FECHA_OPERACION"));
                reporte_facturacion.setVencimiento(rs.getDate("VENCIMIENTO"));
                reporte_facturacion.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                reporte_facturacion.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                reporte_facturacion.setIdccosto(rs.getString("IDCCOSTO")!=null?rs.getString("IDCCOSTO").trim():"");
                reporte_facturacion.setConcepto(rs.getString("CONCEPTO")!=null?rs.getString("CONCEPTO").trim():"");
                reporte_facturacion.setIdcliente(rs.getString("IDCLIENTE")!=null?rs.getString("IDCLIENTE").trim():"");
                reporte_facturacion.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                reporte_facturacion.setAfecto(rs.getFloat("AFECTO"));
                reporte_facturacion.setInafecto(rs.getFloat("INAFECTO"));
                reporte_facturacion.setIdimpuesto(rs.getString("IDIMPUESTO")!=null?rs.getString("IDIMPUESTO").trim():"");
                reporte_facturacion.setImpuesto(rs.getFloat("IMPUESTO"));
                reporte_facturacion.setTotal(rs.getFloat("TOTAL"));
                reporte_facturacion.setOrdenregistro(rs.getInt("ORDENREGISTRO"));
                reporte_facturacion.setEsdetraccion(rs.getFloat("ESDETRACCION"));
                reporte_facturacion.setTipodetraccion(rs.getString("TIPODETRACCION")!=null?rs.getString("TIPODETRACCION").trim():"");
                reporte_facturacion.setTasadetraccion(rs.getFloat("TASADETRACCION"));
                reporte_facturacion.setTcosto(rs.getFloat("TCOSTO"));
                
                reporte_facturacion.setDidordenservicio(rs.getString("DIDORDENSERVICIO")!=null?rs.getString("DIDORDENSERVICIO").trim():"");
                reporte_facturacion.setDcliente(rs.getString("DCLIENTE")!=null?rs.getString("DCLIENTE").trim():"");
                reporte_facturacion.setDiddocumento(rs.getString("DIDDOCUMENTO")!=null?rs.getString("DIDDOCUMENTO").trim():"");
                reporte_facturacion.setDserie(rs.getString("DSERIE")!=null?rs.getString("DSERIE").trim():"");
                reporte_facturacion.setDnumero(rs.getString("DNUMERO")!=null?rs.getString("DNUMERO").trim():"");
                reporte_facturacion.setDambito_servicio(rs.getString("DAMBITO_SERVICIO")!=null?rs.getString("DAMBITO_SERVICIO").trim():"");
                reporte_facturacion.setDfecha_osc(rs.getDate("DFECHA_OSC"));
                reporte_facturacion.setDfecharegistro(rs.getDate("DFECHAREGISTRO"));
                reporte_facturacion.setDfechafinregistro(rs.getDate("DFECHAFINREGISTRO"));
                /*HORAS*/
                if(rs.getObject("DHI")!=null){
                    reporte_facturacion.setDhi(((BigDecimal)rs.getObject("DHI")).floatValue());
                    reporte_facturacion.setDhi_s(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhi()));
                }else{
                    reporte_facturacion.setDhi(null);
                    reporte_facturacion.setDhi_s("");
                }
                if(rs.getObject("DHF")!=null){
                    reporte_facturacion.setDhf(((BigDecimal)rs.getObject("DHF")).floatValue());
                    reporte_facturacion.setDhf_s(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhf()));
                }else{
                    reporte_facturacion.setDhf(null);
                    reporte_facturacion.setDhf_s("");
                }
                if(rs.getObject("DHS")!=null){
                    reporte_facturacion.setDhs(rs.getFloat("DHS"));
                    reporte_facturacion.setDhs_s(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhs()));
                }else{
                    reporte_facturacion.setDhs(null);
                    reporte_facturacion.setDhs_s("");
                }
                if(rs.getObject("DHBASE")!=null){
                    reporte_facturacion.setDhbase(rs.getFloat("DHBASE"));
                    reporte_facturacion.setDhbase_s(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhbase()));
                }else{
                    reporte_facturacion.setDhbase(null);
                    reporte_facturacion.setDhbase_s("");
                }
                if(rs.getObject("DHADICIONAL")!=null){
                    reporte_facturacion.setDhadicional(rs.getFloat("DHADICIONAL"));
                    reporte_facturacion.setDhadicional_s(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhadicional()));
                }else{
                    reporte_facturacion.setDhadicional(null);
                    reporte_facturacion.setDhadicional_s("");
                }
                /****** DATO TAREO ****/
                if(rs.getObject("DHORA_REQ")!=null){
                    reporte_facturacion.setDhora_req(((BigDecimal)rs.getObject("DHORA_REQ")).floatValue());
                    reporte_facturacion.setShora_req(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhora_req()));
                }else{
                    reporte_facturacion.setDhora_req(null);
                    reporte_facturacion.setShora_req("");
                }
                if(rs.getObject("DHORA_LLEGADA")!=null){
                    reporte_facturacion.setDhora_llegada(((BigDecimal)rs.getObject("DHORA_LLEGADA")).floatValue());
                    reporte_facturacion.setShora_llegada(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhora_llegada()));
                }else{
                    reporte_facturacion.setDhora_llegada(null);
                    reporte_facturacion.setShora_llegada("");
                }
                if(rs.getObject("DHORA_INICIO_SERV")!=null){
                    reporte_facturacion.setDhora_inicio_serv(((BigDecimal)rs.getObject("DHORA_INICIO_SERV")).floatValue());
                    reporte_facturacion.setShora_inicio_serv(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhora_inicio_serv()));
                }else{
                    reporte_facturacion.setDhora_inicio_serv(null);
                    reporte_facturacion.setShora_inicio_serv("");
                }
                if(rs.getObject("DHORA_FIN_SERV")!=null){
                    reporte_facturacion.setDhora_fin_serv(((BigDecimal)rs.getObject("DHORA_FIN_SERV")).floatValue());
                    reporte_facturacion.setShora_fin_serv(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhora_fin_serv()));
                }else{
                    reporte_facturacion.setDhora_fin_serv(null);
                    reporte_facturacion.setShora_fin_serv("");
                }
                if(rs.getObject("DHORA_LIBERACION")!=null){
                    reporte_facturacion.setDhora_liberacion(((BigDecimal)rs.getObject("DHORA_LIBERACION")).floatValue());
                    reporte_facturacion.setShora_liberacion(CoreUtil.convertTimeFloatString(reporte_facturacion.getDhora_liberacion()));
                }else{
                    reporte_facturacion.setDhora_liberacion(null);
                    reporte_facturacion.setShora_liberacion("");
                }
                reporte_facturacion.setDchecklist(rs.getString("DCHECKLIST")!=null?rs.getString("DCHECKLIST").trim():"");
                reporte_facturacion.setDidvehiculo(rs.getString("DIDVEHICULO")!=null?rs.getString("DIDVEHICULO").trim():"");
                reporte_facturacion.setDnrocontenedor(rs.getString("DNROCONTENEDOR")!=null?rs.getString("DNROCONTENEDOR").trim():"");
                reporte_facturacion.setDnroprecinto(rs.getString("DNROPRECINTO")!=null?rs.getString("DNROPRECINTO").trim():"");
                reporte_facturacion.setDnro_oservicio(rs.getString("DNRO_OSERVICIO")!=null?rs.getString("DNRO_OSERVICIO").trim():"");
                reporte_facturacion.setDplaca_cliente(rs.getString("DPLACA_CLIENTE")!=null?rs.getString("DPLACA_CLIENTE").trim():"");
                reporte_facturacion.setDconductor_cliente(rs.getString("DCONDUCTOR_CLIENTE")!=null?rs.getString("DCONDUCTOR_CLIENTE").trim():"");
                reporte_facturacion.setDbrevete_cliente(rs.getString("DBREVETE_CLIENTE")!=null?rs.getString("DBREVETE_CLIENTE").trim():"");
                
                reporte_facturacion.setDcosto_rh(rs.getFloat("DCOSTO_RH"));
                reporte_facturacion.setDhcosto_adicional(rs.getFloat("DHCOSTO_ADICIONAL"));
                reporte_facturacion.setDcosto_bono(rs.getFloat("DCOSTO_BONO"));
                reporte_facturacion.setDidcargo(rs.getString("DIDCARGO")!=null?rs.getString("DIDCARGO").trim():"");
                reporte_facturacion.setDcodigo_ec(rs.getString("DCODIGO_EC")!=null?rs.getString("DCODIGO_EC").trim():"");
                reporte_facturacion.setDitemrango_ec(rs.getString("DITEMRANGO_EC")!=null?rs.getString("DITEMRANGO_EC").trim():"");
                reporte_facturacion.setDcodoperaciones_ec(rs.getString("DCODOPERACIONES_EC")!=null?rs.getString("DCODOPERACIONES_EC").trim():"");
                reporte_facturacion.setDnhoras_ec(rs.getFloat("DNHORAS_EC"));
                reporte_facturacion.setDidruta_ec(rs.getString("DIDRUTA_EC")!=null?rs.getString("DIDRUTA_EC").trim():"");
                reporte_facturacion.setDidruta(rs.getString("DIDRUTA")!=null?rs.getString("DIDRUTA").trim():"");
                reporte_facturacion.setCargo(rs.getString("DCARGO")!=null?rs.getString("DCARGO").trim():"");
                reporte_facturacion.setRutaservicio(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                reporte_facturacion.setEsplanilla(rs.getInt("ESPLANILLA"));
                lista.add(reporte_facturacion); 
            }
            return lista;
        }
        public NSRResultSet getConsultaRepote(String idempresa,String fechainicio,String fechafin,String cliente,String supervisor) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_TMPSS",idempresa,fechainicio,fechafin,cliente,supervisor);
            return ReportConfig.getNSRResultSet(rs);
        }
        public NSRResultSet getConsultaRepote_fijo(String idempresa,String fechainicio,String fechafin) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_FIJO_TMPSS",idempresa,fechainicio,fechafin);
            return ReportConfig.getNSRResultSet(rs);
        }
        public NSRResultSet getConsultaRepote_personal_ocupado(String idempresa) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("GET_REPORTE_PERSONAL_OCUPADO_TMPSS",idempresa);
            return ReportConfig.getNSRResultSet(rs);
        }
        public NSRResultSet getConsultaRepote_facturacion(String idempresa,String fechainicio,String fechafin,String idtiposervicio) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_FACTURACION_TMPSS",idempresa,fechainicio,fechafin,idtiposervicio);
            return ReportConfig.getNSRResultSet(rs);
        }
        public NSRResultSet getConsultaRepote_facturacion_detallado(String idempresa,String fechainicio,String fechafin,String idtiposervicio) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_FACTURACION_DETALLADO_TMPSS",idempresa,fechainicio,fechafin,idtiposervicio);
            return ReportConfig.getNSRResultSet(rs);
        }
        public String anular(Ordenserviciocliente ob,String idusuario) throws Exception {
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENSERVICIOCLIENTE_ANULAR",
                        ob.getIdempresa(),ob.getIdordenservicio(),idusuario,ob.getIdestado()
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
       
      
        public ArrayList<Ordenserviciocliente> listarOrdenServicioPendiente(String idusuario) throws NisiraORMException,Exception {
            ArrayList<Ordenserviciocliente> lista = new ArrayList<Ordenserviciocliente>();
            ResultSet rs = null;
            rs = execProcedure("SP_PSS_GET_ORDENSERVICIOCLIENTE_PENDIENTE",idusuario);
            while (rs.next()) {
                Ordenserviciocliente ordenserviciocliente = new Ordenserviciocliente();                
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
                ordenserviciocliente.setIdmotivo(rs.getString("IDMOTIVO")!=null?rs.getString("IDMOTIVO").trim():"");
                ordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenserviciocliente.setIdoperario(rs.getString("IDOPERARIO")!=null?rs.getString("IDOPERARIO").trim():"");
                ordenserviciocliente.setIdoperario2(rs.getString("IDOPERARIO2")!=null?rs.getString("IDOPERARIO2").trim():"");                
                ordenserviciocliente.setOperario2(rs.getString("contacto")!=null?rs.getString("contacto").trim():"");
                ordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenserviciocliente.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                ordenserviciocliente.setOperario(rs.getString("OPERARIO")!=null?rs.getString("OPERARIO").trim():"");
                ordenserviciocliente.setOperario2(rs.getString("OPERARIO2")!=null?rs.getString("OPERARIO2").trim():"");
                lista.add(ordenserviciocliente); 
            }
            return lista;
        }        
        public String eliminarRegistroTareo(Ordenserviciocliente ob,String idusuario) throws Exception {
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENSERVICIOCLIENTE_DROP_TAREO",
                        ob.getIdempresa(),ob.getIdordenservicio(),idusuario,ob.getIdestado()
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