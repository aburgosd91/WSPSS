package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Destructura_costos_recursos;
import com.nisira.core.entity.Destructura_costos_recursos_cotizacionventas;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.util.CoreUtil;
import com.nisira.core.util.ReportConfig;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CotizacionventasDao extends BaseDao<Cotizacionventas> {
	public CotizacionventasDao() {
		super(Cotizacionventas.class);
	}
	public CotizacionventasDao(boolean usaCnBase) throws NisiraORMException {
		super(Cotizacionventas.class, usaCnBase);
	}

	public Cotizacionventas getPorClavePrimaria(String IDEMPRESA, String IDCOTIZACIONV) throws NisiraORMException {
		List<Cotizacionventas> l = listar("t0.IDEMPRESA = ? and t0.IDCOTIZACIONV = ? ", IDEMPRESA, IDCOTIZACIONV);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Cotizacionventas> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Cotizacionventas> lista = new ArrayList<Cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETCOTIZACION_TMPSS",idempresa);
                while (rs.next()) {
                    Cotizacionventas cotizacionventas = new Cotizacionventas();
                    cotizacionventas.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    cotizacionventas.setIdempresa(rs.getString("IDEMPRESA").trim());
                    cotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV").trim());
                    cotizacionventas.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    cotizacionventas.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    cotizacionventas.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    cotizacionventas.setFecha(rs.getDate("FECHA"));
                    cotizacionventas.setFechavigencia(rs.getDate("FECHAVIGENCIA"));
                    cotizacionventas.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                    cotizacionventas.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                    cotizacionventas.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    cotizacionventas.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    cotizacionventas.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                    cotizacionventas.setIdvendedor(rs.getString("IDVENDEDOR")!=null?rs.getString("IDVENDEDOR").trim():"");
                    cotizacionventas.setContacto(rs.getString("CONTACTO")!=null?rs.getString("CONTACTO").trim():"");
                    cotizacionventas.setLugar_entrega(rs.getString("LUGAR_ENTREGA")!=null?rs.getString("LUGAR_ENTREGA").trim():"");
                    cotizacionventas.setIdproyecto(rs.getString("IDPROYECTO")!=null?rs.getString("IDPROYECTO").trim():"");
                    cotizacionventas.setMultivendedores(rs.getFloat("MULTIVENDEDORES"));
                    cotizacionventas.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                    cotizacionventas.setIdembalaje(rs.getString("IDEMBALAJE")!=null?rs.getString("IDEMBALAJE").trim():"");
                    cotizacionventas.setComision(rs.getFloat("COMISION"));
                    cotizacionventas.setPlazoentrega(rs.getString("PLAZOENTREGA")!=null?rs.getString("PLAZOENTREGA").trim():"");
                    cotizacionventas.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                    cotizacionventas.setConfirmastock(rs.getFloat("CONFIRMASTOCK"));
                    cotizacionventas.setTcmoneda(rs.getFloat("TCMONEDA"));
                    cotizacionventas.setEs_proyecto(rs.getFloat("ES_PROYECTO"));
                    cotizacionventas.setIdunidadnegocio(rs.getString("IDUNIDADNEGOCIO")!=null?rs.getString("IDUNIDADNEGOCIO").trim():"");
                    cotizacionventas.setIdsubunidadnegocio(rs.getString("IDSUBUNIDADNEGOCIO")!=null?rs.getString("IDSUBUNIDADNEGOCIO").trim():"");
                    cotizacionventas.setArea_ha(rs.getFloat("AREA_HA"));
                    cotizacionventas.setRedondeo(rs.getFloat("REDONDEO"));
                    cotizacionventas.setIdflete(rs.getString("IDFLETE")!=null?rs.getString("IDFLETE").trim():"");
                    cotizacionventas.setIdpuertoorigen(rs.getString("IDPUERTOORIGEN")!=null?rs.getString("IDPUERTOORIGEN").trim():"");
                    cotizacionventas.setIdpuertodestino(rs.getString("IDPUERTODESTINO")!=null?rs.getString("IDPUERTODESTINO").trim():"");
                    cotizacionventas.setIdtipoprecio(rs.getString("IDTIPOPRECIO")!=null?rs.getString("IDTIPOPRECIO").trim():"");
                    cotizacionventas.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                    cotizacionventas.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                    cotizacionventas.setColor_estado(rs.getString("COLOR_ESTADO")!=null?rs.getString("COLOR_ESTADO").trim():"");
                    lista.add(cotizacionventas); 
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Cotizacionventas> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException {
            ArrayList<Cotizacionventas> lista = new ArrayList<Cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETCOTIZACION_TMPSS",idempresa,fechainicio,fechafin);
                while (rs.next()) {
                    Cotizacionventas cotizacionventas = new Cotizacionventas();
                    cotizacionventas.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    cotizacionventas.setIdempresa(rs.getString("IDEMPRESA").trim());
                    cotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV").trim());
                    cotizacionventas.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                    cotizacionventas.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                    cotizacionventas.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                    cotizacionventas.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                    cotizacionventas.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    cotizacionventas.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    cotizacionventas.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    cotizacionventas.setFecha(rs.getDate("FECHA"));
                    cotizacionventas.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    cotizacionventas.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                    cotizacionventas.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                    cotizacionventas.setFechavigencia(rs.getDate("FECHAVIGENCIA"));
                    cotizacionventas.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    cotizacionventas.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                    cotizacionventas.setIdvendedor(rs.getString("IDVENDEDOR")!=null?rs.getString("IDVENDEDOR").trim():"");
                    cotizacionventas.setContacto(rs.getString("CONTACTO")!=null?rs.getString("CONTACTO").trim():"");
                    cotizacionventas.setLugar_entrega(rs.getString("LUGAR_ENTREGA")!=null?rs.getString("LUGAR_ENTREGA").trim():"");
                    cotizacionventas.setIdproyecto(rs.getString("IDPROYECTO")!=null?rs.getString("IDPROYECTO").trim():"");                    
                    cotizacionventas.setTcmoneda(rs.getFloat("TCMONEDA"));
                    cotizacionventas.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                    cotizacionventas.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                    cotizacionventas.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                    
                    cotizacionventas.setSubtotalsindscto(rs.getFloat("SUBTOTALSINDSCTO"));
                    cotizacionventas.setDescuento(rs.getFloat("DESCUENTO"));
                    cotizacionventas.setImpuesto(rs.getFloat("IMPUESTO"));
                    cotizacionventas.setImporte(rs.getFloat("IMPORTE"));
                    cotizacionventas.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                    cotizacionventas.setFormapago(rs.getString("FORMAPAGO")!=null?rs.getString("FORMAPAGO").trim():"");
                    if(cotizacionventas.getPeriodo()!=null)
                        cotizacionventas.setMes(CoreUtil.strMonths[Integer.parseInt(cotizacionventas.getPeriodo().substring(4))-1]);
                    cotizacionventas.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                    cotizacionventas.setItem_contacto(rs.getString("ITEM_CONTACTO")!=null?rs.getString("ITEM_CONTACTO").trim():"");
                    cotizacionventas.setContacto_email(rs.getString("CONTACTO_EMAIL")!=null?rs.getString("CONTACTO_EMAIL").trim():"");
                    cotizacionventas.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                    cotizacionventas.setColor_estado(rs.getString("COLOR_ESTADO")!=null?rs.getString("COLOR_ESTADO").trim():"");
                    cotizacionventas.setVendedor(rs.getString("VENDEDOR")!=null?rs.getString("VENDEDOR").trim():"");
                    cotizacionventas.setTipo_servicio(rs.getString("TIPO_SERVICIO")!=null?rs.getString("TIPO_SERVICIO").trim():"");
                    lista.add(cotizacionventas); 
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Cotizacionventas> listarPorEmpresaWebFiltroFechaXordenserviciocliente(String idempresa,String fechainicio,String fechafin) throws NisiraORMException {
            ArrayList<Cotizacionventas> lista = new ArrayList<Cotizacionventas>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETCOTIZACION_ORDENSERVICIO_TMPSS",idempresa,fechainicio,fechafin);
                while (rs.next()) {
                    Cotizacionventas cotizacionventas = new Cotizacionventas();
                    cotizacionventas.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    cotizacionventas.setIdempresa(rs.getString("IDEMPRESA").trim());
                    cotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV").trim());
                    cotizacionventas.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                    cotizacionventas.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                    cotizacionventas.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                    cotizacionventas.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                    cotizacionventas.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    cotizacionventas.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    cotizacionventas.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    cotizacionventas.setFecha(rs.getDate("FECHA"));
                    cotizacionventas.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    cotizacionventas.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                    cotizacionventas.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                    cotizacionventas.setFechavigencia(rs.getDate("FECHAVIGENCIA"));
                    cotizacionventas.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    cotizacionventas.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                    cotizacionventas.setIdvendedor(rs.getString("IDVENDEDOR")!=null?rs.getString("IDVENDEDOR").trim():"");
                    cotizacionventas.setContacto(rs.getString("CONTACTO")!=null?rs.getString("CONTACTO").trim():"");
                    cotizacionventas.setLugar_entrega(rs.getString("LUGAR_ENTREGA")!=null?rs.getString("LUGAR_ENTREGA").trim():"");
                    cotizacionventas.setIdproyecto(rs.getString("IDPROYECTO")!=null?rs.getString("IDPROYECTO").trim():"");                    
                    cotizacionventas.setTcmoneda(rs.getFloat("TCMONEDA"));
                    cotizacionventas.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                    cotizacionventas.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                    cotizacionventas.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                    
                    cotizacionventas.setSubtotalsindscto(rs.getFloat("SUBTOTALSINDSCTO"));
                    cotizacionventas.setDescuento(rs.getFloat("DESCUENTO"));
                    cotizacionventas.setImpuesto(rs.getFloat("IMPUESTO"));
                    cotizacionventas.setImporte(rs.getFloat("IMPORTE"));
                    cotizacionventas.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                    cotizacionventas.setFormapago(rs.getString("FORMAPAGO")!=null?rs.getString("FORMAPAGO").trim():"");
                    if(cotizacionventas.getPeriodo()!=null)
                        cotizacionventas.setMes(CoreUtil.strMonths[Integer.parseInt(cotizacionventas.getPeriodo().substring(4))-1]);
                    cotizacionventas.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                    cotizacionventas.setItem_contacto(rs.getString("ITEM_CONTACTO")!=null?rs.getString("ITEM_CONTACTO").trim():"");
                    cotizacionventas.setContacto_email(rs.getString("CONTACTO_EMAIL")!=null?rs.getString("CONTACTO_EMAIL").trim():"");
                    lista.add(cotizacionventas); 
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public Cotizacionventas getCotizacionWeb(String idempresa,String idcotizacionventas) throws NisiraORMException {
            Cotizacionventas cotizacionventas = new Cotizacionventas();
            List<Dcotizacionventas> listDcotizacionventas=new ArrayList<Dcotizacionventas>();
            Dcotizacionventas dcotizacionventas=null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("OBJTABLAS_RETURNCOTIZACIONES_WEB",idempresa,"",idcotizacionventas);
            int i=0;
            
            while (rs.next()) {
                if(i==0){
                    cotizacionventas.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    cotizacionventas.setIdempresa(rs.getString("IDEMPRESA").trim());
                    cotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV").trim());
                    cotizacionventas.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                    cotizacionventas.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                    cotizacionventas.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                    cotizacionventas.setFecha(rs.getDate("FECHA"));
                    cotizacionventas.setFechavigencia(rs.getDate("FECHAVIGENCIA"));
                    cotizacionventas.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                    cotizacionventas.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                    cotizacionventas.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    cotizacionventas.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                    cotizacionventas.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                    cotizacionventas.setIdvendedor(rs.getString("IDVENDEDOR")!=null?rs.getString("IDVENDEDOR").trim():"");
                    cotizacionventas.setContacto(rs.getString("CONTACTO")!=null?rs.getString("CONTACTO").trim():"");
                    cotizacionventas.setLugar_entrega(rs.getString("LUGAR_ENTREGA")!=null?rs.getString("LUGAR_ENTREGA").trim():"");
                    cotizacionventas.setIdproyecto(rs.getString("IDPROYECTO")!=null?rs.getString("IDPROYECTO").trim():"");
                    cotizacionventas.setMultivendedores(rs.getFloat("MULTIVENDEDORES"));
                    cotizacionventas.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                    cotizacionventas.setIdembalaje(rs.getString("IDEMBALAJE")!=null?rs.getString("IDEMBALAJE").trim():"");
                    cotizacionventas.setComision(rs.getFloat("COMISION"));
                    cotizacionventas.setPlazoentrega(rs.getString("PLAZOENTREGA")!=null?rs.getString("PLAZOENTREGA").trim():"");
                    cotizacionventas.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                    cotizacionventas.setConfirmastock(rs.getFloat("CONFIRMASTOCK"));
                    cotizacionventas.setTcmoneda(rs.getFloat("TCMONEDA"));
                    cotizacionventas.setEs_proyecto(rs.getFloat("ES_PROYECTO"));
                    cotizacionventas.setIdunidadnegocio(rs.getString("IDUNIDADNEGOCIO")!=null?rs.getString("IDUNIDADNEGOCIO").trim():"");
                    cotizacionventas.setIdsubunidadnegocio(rs.getString("IDSUBUNIDADNEGOCIO")!=null?rs.getString("IDSUBUNIDADNEGOCIO").trim():"");
                    cotizacionventas.setArea_ha(rs.getFloat("AREA_HA"));
                    cotizacionventas.setRedondeo(rs.getFloat("REDONDEO"));
                    cotizacionventas.setIdflete(rs.getString("IDFLETE")!=null?rs.getString("IDFLETE").trim():"");
                    cotizacionventas.setIdpuertoorigen(rs.getString("IDPUERTOORIGEN")!=null?rs.getString("IDPUERTOORIGEN").trim():"");
                    cotizacionventas.setIdpuertodestino(rs.getString("IDPUERTODESTINO")!=null?rs.getString("IDPUERTODESTINO").trim():"");
                    cotizacionventas.setIdtipoprecio(rs.getString("IDTIPOPRECIO")!=null?rs.getString("IDTIPOPRECIO").trim():"");
                    cotizacionventas.setIdtiposervicio(rs.getString("IDTIPOSERVICIO")!=null?rs.getString("IDTIPOSERVICIO").trim():"");
                    i++;
                }
                dcotizacionventas = new Dcotizacionventas();
                dcotizacionventas.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                dcotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                dcotizacionventas.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dcotizacionventas.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                dcotizacionventas.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
                dcotizacionventas.setCantidad(rs.getFloat("CANTIDAD"));
                dcotizacionventas.setPrecio(rs.getFloat("PRECIO"));
                dcotizacionventas.setPorcentajedscto1(rs.getFloat("PORCENTAJEDSCTO1"));
                dcotizacionventas.setPorcentajedscto2(rs.getFloat("PORCENTAJEDSCTO2"));
                dcotizacionventas.setPorcentajedscto3(rs.getFloat("PORCENTAJEDSCTO3"));
                dcotizacionventas.setEs_afecto(rs.getFloat("ES_AFECTO"));
                dcotizacionventas.setImpuesto_i(rs.getFloat("IMPUESTO_I"));
                dcotizacionventas.setImpuesto(rs.getFloat("IMPUESTO"));
                dcotizacionventas.setIdestadoproducto(rs.getString("IDESTADOPRODUCTO")!=null?rs.getString("IDESTADOPRODUCTO").trim():"");
                dcotizacionventas.setObservaciones(rs.getString("OBSERVACIONES")!=null?rs.getString("OBSERVACIONES").trim():"");
                dcotizacionventas.setAnniofabricacion(rs.getString("ANNIOFABRICACION")!=null?rs.getString("ANNIOFABRICACION").trim():"");
                dcotizacionventas.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                dcotizacionventas.setItemref(rs.getString("ITEMREF")!=null?rs.getString("ITEMREF").trim():"");
                dcotizacionventas.setTablaref(rs.getString("TABLAREF")!=null?rs.getString("TABLAREF").trim():"");
                dcotizacionventas.setDocumentoref(rs.getString("DOCUMENTOREF")!=null?rs.getString("DOCUMENTOREF").trim():"");
                dcotizacionventas.setParafecha(rs.getDate("PARAFECHA"));
                dcotizacionventas.setDias(rs.getFloat("DIAS"));
                dcotizacionventas.setIdserie(rs.getString("IDSERIE")!=null?rs.getString("IDSERIE").trim():"");
                dcotizacionventas.setIdcolor(rs.getString("IDCOLOR")!=null?rs.getString("IDCOLOR").trim():"");
                dcotizacionventas.setDescuento(rs.getFloat("DESCUENTO"));
                dcotizacionventas.setImporte(rs.getFloat("IMPORTE"));
//                dcotizacionventas.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
//                dcotizacionventas.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                listDcotizacionventas.add(dcotizacionventas);
            }
            cotizacionventas.setListDcotizacionventas(listDcotizacionventas);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return cotizacionventas;
        }
        public String grabar(int tipo,Cotizacionventas ob,List<Dcotizacionventas> listDorden,String idusuario,
                List<Destructura_costos_recursos_cotizacionventas> listDestructura_costos_recursos_cotizacionventas, 
                List<Estructura_costos_mano_obra_cotizacionventas> listEstructura_costos_mano_obra_cotizacionventas) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Cotizacionventas.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES COTIZACIONVENTAS **********************/
            String xmlDcotizacionventas = "";
            xStream = new XStream();
            xStream.processAnnotations(Dcotizacionventas.class);
            xmlDcotizacionventas = xml + xStream.toXML(listDorden);
            /******************* DETALLES DESTRUCTURA_COSTOS_RECURSOS_COTIZACIONVENTAS **********************/
            String xmlDestructura_costos_recursos_cotizacionventas = "";
            xStream = new XStream();
            xStream.processAnnotations(Destructura_costos_recursos_cotizacionventas.class);
            xmlDestructura_costos_recursos_cotizacionventas = xml + xStream.toXML(listDestructura_costos_recursos_cotizacionventas);
            /******************* DETALLES ESTRUCTURA_COSTOS_MANO_OBRA_COTIZACIONVENTAS **********************/
            String xmlEstructura_costos_mano_obra_cotizacionventas = "";
            xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_mano_obra_cotizacionventas.class);
            xmlEstructura_costos_mano_obra_cotizacionventas = xml + xStream.toXML(listEstructura_costos_mano_obra_cotizacionventas);
            /*************************************************************************/
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_COTIZACIONVENTA_GRABAR",
                        tipo,
                        ob.getIdempresa(),ob.getIdcotizacionv(),
                        ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                        xmlNot,
                        xmlDcotizacionventas,idusuario,xmlDestructura_costos_recursos_cotizacionventas,
                        xmlEstructura_costos_mano_obra_cotizacionventas
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
        public String anular(Cotizacionventas ob,String idusuario) throws Exception {
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_COTIZACIONVENTA_ANULAR",
                        ob.getIdempresa(),ob.getIdcotizacionv(),idusuario,ob.getIdestado()
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
        public String envioCorreo (Cotizacionventas ob,String idusuario,String email_usuario,String asunto,
                String file) throws Exception{
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_SEND_EMAIL_PSS",
                        ob.getIdempresa(),/*@IDEMPRESA*/
                        ob.getRazon_social(),/*@RAZON_SOCIAL*/
                        email_usuario,/*@DE*/
                        idusuario,/*@USR_NOMBRES*/
                        email_usuario,/*@PARA*/
                        "",/*@PERFIL*/
                        ob.getContacto_email(),/*@EMAIL*/
                        "",/*@CC*/
                        asunto,/*@ASUNTO*/
                        file,/*@ADJUNTO*/
                        "",/*@TITULO*/
                        "",/*@OBSERVACION*/
                        ""/*@NRO_MENSAJE*/
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
        public NSRResultSet getConsultaRepote(String IDEMPRESA, String IDCOTIZACIONV) throws NisiraORMException{
            ResultSet rs = null;
            rs = execProcedure("GETCOTIZACION_REPORTE_TMPSS",IDEMPRESA,IDCOTIZACIONV);
            return ReportConfig.getNSRResultSet(rs);
        }
}