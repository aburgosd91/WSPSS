package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import java.sql.ResultSet;
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
                    lista.add(cotizacionventas); 
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }public ArrayList<Cotizacionventas> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException {
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

}