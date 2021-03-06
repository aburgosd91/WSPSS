package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenliquidaciongastoDao extends BaseDao<Ordenliquidaciongasto> {
	public OrdenliquidaciongastoDao() {
		super(Ordenliquidaciongasto.class);
	}
	public OrdenliquidaciongastoDao(boolean usaCnBase) throws NisiraORMException {
		super(Ordenliquidaciongasto.class, usaCnBase);
	}

	public Ordenliquidaciongasto getPorClavePrimaria(String idEmpresa, String idorden) throws NisiraORMException {
		List<Ordenliquidaciongasto> l = listar("t0.idEmpresa = ? and t0.idorden = ? ", idEmpresa, idorden);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        public String method_web_returnid() throws NisiraORMException, SQLException{
            String mensaje="";
            ResultSet rs = null;
            rs = execProcedure("WEB_RETURNID_TMPSS");
            while (rs.next()) {
                mensaje = rs.getString("ID");
                break;
            }
            return mensaje;
        }
        /*APP SERVICE*/
        public ArrayList<Ordenliquidaciongasto> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Ordenliquidaciongasto> lista = new ArrayList<Ordenliquidaciongasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETORDENLIQUIDACIONGASTO_TMPSS",idempresa);
            while (rs.next()) {
                Ordenliquidaciongasto ordenliquidaciongasto = new Ordenliquidaciongasto();
                ordenliquidaciongasto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ordenliquidaciongasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                ordenliquidaciongasto.setIdorden(rs.getString("IDORDEN")!=null?rs.getString("IDORDEN").trim():"");
                ordenliquidaciongasto.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                ordenliquidaciongasto.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                ordenliquidaciongasto.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                ordenliquidaciongasto.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                ordenliquidaciongasto.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                ordenliquidaciongasto.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                ordenliquidaciongasto.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                ordenliquidaciongasto.setFecha(rs.getDate("FECHA"));
                ordenliquidaciongasto.setTcambio(rs.getFloat("TCAMBIO"));
                ordenliquidaciongasto.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                ordenliquidaciongasto.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                ordenliquidaciongasto.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                ordenliquidaciongasto.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                ordenliquidaciongasto.setTcmoneda(rs.getFloat("TCMONEDA"));
                ordenliquidaciongasto.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                ordenliquidaciongasto.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                ordenliquidaciongasto.setIdarea(rs.getString("IDAREA")!=null?rs.getString("IDAREA").trim():"");
                ordenliquidaciongasto.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenliquidaciongasto.setVventa(rs.getFloat("VVENTA"));
                ordenliquidaciongasto.setInafecto(rs.getFloat("INAFECTO"));
                ordenliquidaciongasto.setOtros(rs.getFloat("OTROS"));
                ordenliquidaciongasto.setImpuesto(rs.getFloat("IMPUESTO"));
                ordenliquidaciongasto.setPimpuesto(rs.getFloat("PIMPUESTO"));
                ordenliquidaciongasto.setDescuento(rs.getFloat("DESCUENTO"));
                ordenliquidaciongasto.setPdescuento(rs.getFloat("PDESCUENTO"));
                ordenliquidaciongasto.setDescuentodoc(rs.getFloat("DESCUENTODOC"));
                ordenliquidaciongasto.setRedondeo(rs.getFloat("REDONDEO"));
                ordenliquidaciongasto.setImporte(rs.getFloat("IMPORTE"));
                ordenliquidaciongasto.setImportemof(rs.getFloat("IMPORTEMOF"));
                ordenliquidaciongasto.setImportemex(rs.getFloat("IMPORTEMEX"));
                ordenliquidaciongasto.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setIgv(rs.getFloat("IGV"));
                ordenliquidaciongasto.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                ordenliquidaciongasto.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                ordenliquidaciongasto.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                lista.add(ordenliquidaciongasto); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Ordenliquidaciongasto> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Ordenliquidaciongasto> lista = new ArrayList<Ordenliquidaciongasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETORDENLIQUIDACIONGASTO_TMPSS",idempresa);
            while (rs.next()) {
                Ordenliquidaciongasto ordenliquidaciongasto = new Ordenliquidaciongasto();
                ordenliquidaciongasto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ordenliquidaciongasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                ordenliquidaciongasto.setIdorden(rs.getString("IDORDEN")!=null?rs.getString("IDORDEN").trim():"");
                ordenliquidaciongasto.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                ordenliquidaciongasto.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                ordenliquidaciongasto.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                ordenliquidaciongasto.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                ordenliquidaciongasto.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                ordenliquidaciongasto.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                ordenliquidaciongasto.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                ordenliquidaciongasto.setFecha(rs.getDate("FECHA"));
                ordenliquidaciongasto.setTcambio(rs.getFloat("TCAMBIO"));
                ordenliquidaciongasto.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                ordenliquidaciongasto.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                ordenliquidaciongasto.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                ordenliquidaciongasto.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                ordenliquidaciongasto.setTcmoneda(rs.getFloat("TCMONEDA"));
                ordenliquidaciongasto.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                ordenliquidaciongasto.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                ordenliquidaciongasto.setIdarea(rs.getString("IDAREA")!=null?rs.getString("IDAREA").trim():"");
                ordenliquidaciongasto.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenliquidaciongasto.setVventa(rs.getFloat("VVENTA"));
                ordenliquidaciongasto.setInafecto(rs.getFloat("INAFECTO"));
                ordenliquidaciongasto.setOtros(rs.getFloat("OTROS"));
                ordenliquidaciongasto.setImpuesto(rs.getFloat("IMPUESTO"));
                ordenliquidaciongasto.setPimpuesto(rs.getFloat("PIMPUESTO"));
                ordenliquidaciongasto.setDescuento(rs.getFloat("DESCUENTO"));
                ordenliquidaciongasto.setPdescuento(rs.getFloat("PDESCUENTO"));
                ordenliquidaciongasto.setDescuentodoc(rs.getFloat("DESCUENTODOC"));
                ordenliquidaciongasto.setRedondeo(rs.getFloat("REDONDEO"));
                ordenliquidaciongasto.setImporte(rs.getFloat("IMPORTE"));
                ordenliquidaciongasto.setImportemof(rs.getFloat("IMPORTEMOF"));
                ordenliquidaciongasto.setImportemex(rs.getFloat("IMPORTEMEX"));
                ordenliquidaciongasto.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setIgv(rs.getFloat("IGV"));
                ordenliquidaciongasto.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                ordenliquidaciongasto.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                ordenliquidaciongasto.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                lista.add(ordenliquidaciongasto); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        public ArrayList<Ordenliquidaciongasto> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException {
            ArrayList<Ordenliquidaciongasto> lista = new ArrayList<Ordenliquidaciongasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETORDENLIQUIDACIONGASTO_TMPSS",idempresa,fechainicio,fechafin);
            while (rs.next()) {
                Ordenliquidaciongasto ordenliquidaciongasto = new Ordenliquidaciongasto();
                ordenliquidaciongasto.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                ordenliquidaciongasto.setIdempresa(rs.getString("IDEMPRESA").trim());
                ordenliquidaciongasto.setIdorden(rs.getString("IDORDEN")!=null?rs.getString("IDORDEN").trim():"");
                ordenliquidaciongasto.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                ordenliquidaciongasto.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                ordenliquidaciongasto.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                ordenliquidaciongasto.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                ordenliquidaciongasto.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                ordenliquidaciongasto.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                ordenliquidaciongasto.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                ordenliquidaciongasto.setFecha(rs.getDate("FECHA"));
                ordenliquidaciongasto.setTcambio(rs.getFloat("TCAMBIO"));
                ordenliquidaciongasto.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                ordenliquidaciongasto.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                ordenliquidaciongasto.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                ordenliquidaciongasto.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                ordenliquidaciongasto.setTcmoneda(rs.getFloat("TCMONEDA"));
                ordenliquidaciongasto.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                ordenliquidaciongasto.setIdfpago(rs.getString("IDFPAGO")!=null?rs.getString("IDFPAGO").trim():"");
                ordenliquidaciongasto.setIdarea(rs.getString("IDAREA")!=null?rs.getString("IDAREA").trim():"");
                ordenliquidaciongasto.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                ordenliquidaciongasto.setVventa(rs.getFloat("VVENTA"));
                ordenliquidaciongasto.setInafecto(rs.getFloat("INAFECTO"));
                ordenliquidaciongasto.setOtros(rs.getFloat("OTROS"));
                ordenliquidaciongasto.setImpuesto(rs.getFloat("IMPUESTO"));
                ordenliquidaciongasto.setPimpuesto(rs.getFloat("PIMPUESTO"));
                ordenliquidaciongasto.setDescuento(rs.getFloat("DESCUENTO"));
                ordenliquidaciongasto.setPdescuento(rs.getFloat("PDESCUENTO"));
                ordenliquidaciongasto.setDescuentodoc(rs.getFloat("DESCUENTODOC"));
                ordenliquidaciongasto.setRedondeo(rs.getFloat("REDONDEO"));
                ordenliquidaciongasto.setImporte(rs.getFloat("IMPORTE"));
                ordenliquidaciongasto.setImportemof(rs.getFloat("IMPORTEMOF"));
                ordenliquidaciongasto.setImportemex(rs.getFloat("IMPORTEMEX"));
                ordenliquidaciongasto.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setIgv(rs.getFloat("IGV"));
                ordenliquidaciongasto.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                ordenliquidaciongasto.setFechacreacion(rs.getDate("FECHACREACION"));
                ordenliquidaciongasto.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                ordenliquidaciongasto.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                ordenliquidaciongasto.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                ordenliquidaciongasto.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                ordenliquidaciongasto.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                ordenliquidaciongasto.setArea(rs.getString("AREA")!=null?rs.getString("AREA").trim():"");
                ordenliquidaciongasto.setEntregado(rs.getFloat("ENTREGADO"));
                ordenliquidaciongasto.setRendido(rs.getFloat("RENDIDO"));
                ordenliquidaciongasto.setDevolver(rs.getFloat("DEVOLVER"));
                ordenliquidaciongasto.setReembolsar(rs.getFloat("REEMBOLSAR"));
                lista.add(ordenliquidaciongasto); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        
        public String grabar(int tipo,Ordenliquidaciongasto ob,List<Dordenliquidaciongasto> listDorden,String usuario) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Ordenliquidaciongasto.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES ORDENLIQUIDACIONGASTO **********************/
            String xmlDOrdenliquidaciongasto = "";
            xStream = new XStream();
            xStream.processAnnotations(Dordenliquidaciongasto.class);
            xmlDOrdenliquidaciongasto = xml + xStream.toXML(listDorden);
            
            /*************************************************************************/
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENLIQUIDACIONGASTO_GRABAR",
                        tipo,
                        ob.getIdempresa(),ob.getIdorden(),
                        ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                        xmlNot,
                        xmlDOrdenliquidaciongasto,
                        usuario
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
        
        public String syncro_movil_list(String idempresa,List<Ordenliquidaciongasto> lst1,List<Dordenliquidaciongasto> lst2,String idusuario) throws Exception {
                String mensaje="";
                String xmlNot = "";
                String xmlNot2 = "";
                String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
                XStream xStream = new XStream();

                xStream.processAnnotations(Ordenliquidaciongasto.class);
                xmlNot = xml + xStream.toXML(lst1);
                xStream = new XStream();
                xStream.processAnnotations(Dordenliquidaciongasto.class);
                xmlNot2 = xml + xStream.toXML(lst2);

                try {
                    ResultSet rs = null;
                    rs = execProcedure("SP_ORDENLIQUIDACIONGASTO_SYNCRO",
                            idempresa,"",xmlNot,xmlNot2,idusuario
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
        public String anular(Ordenliquidaciongasto ob,String idusuario) throws Exception {
            String mensaje="";
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ORDENLIQUIDACIONGASTO_ANULAR",
                        ob.getIdempresa(),ob.getIdorden(),idusuario,ob.getIdestado()
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
        public String aprobarOrdenliquidaciongasto(Ordenliquidaciongasto ob,
                String idusuario) throws Exception {
            String mensaje="";            
            ResultSet rs = null;
            rs = execProcedure("SP_ORDENLIQUIDACIONGASTO_APROBACION_TMPSS",
                    ob.getIdempresa(),ob.getIdorden(),idusuario
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
}






















































      