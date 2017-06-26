package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Cabtareoweb;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Det_tareoweb;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CabtareowebDao extends BaseDao<Cabtareoweb> {
    public CabtareowebDao() {
            super(Cabtareoweb.class);
    }
    public CabtareowebDao(boolean usaCnBase) throws NisiraORMException {
            super(Cabtareoweb.class, usaCnBase);
    }

    public Cabtareoweb getPorClavePrimaria(String IDEMPRESA, String IDCABTAREOWEB) throws NisiraORMException {
            List<Cabtareoweb> l = listar("t0.IDEMPRESA = ? and t0.IDCABTAREOWEB = ? ", IDEMPRESA, IDCABTAREOWEB);
            if (l.isEmpty()) {
                    return null;
            } else {
                    return l.get(0);
            }
    }
    public ArrayList<Cabtareoweb> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin,String dni) throws NisiraORMException,Exception {
            ArrayList<Cabtareoweb> lista = new ArrayList<Cabtareoweb>();

            ResultSet rs = null;
            rs = execProcedure("GETCABTAREOWEB_TMPSS",idempresa,fechainicio,fechafin,dni);
            while (rs.next()) {
                Cabtareoweb cabtareoweb = new Cabtareoweb();
                cabtareoweb.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                cabtareoweb.setIdempresa(rs.getString("IDEMPRESA").trim());
                cabtareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                cabtareoweb.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
                cabtareoweb.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
                cabtareoweb.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
                cabtareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                cabtareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                cabtareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                cabtareoweb.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
                cabtareoweb.setFecha(rs.getDate("FECHA"));
                cabtareoweb.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
                cabtareoweb.setIdresponsable(rs.getString("IDRESPONSABLE")!=null?rs.getString("IDRESPONSABLE").trim():"");
                cabtareoweb.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
                cabtareoweb.setAlmacen(rs.getString("ALMACEN")!=null?rs.getString("ALMACEN").trim():"");
                cabtareoweb.setResponsable(rs.getString("RESPONSABLE")!=null?rs.getString("RESPONSABLE").trim():"");
                cabtareoweb.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
                cabtareoweb.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
                cabtareoweb.setIdturnotrabajo(rs.getString("IDTURNOTRABAJO")!=null?rs.getString("IDTURNOTRABAJO").trim():"");
                cabtareoweb.setIdtipoasistencia(rs.getString("IDTIPOASISTENCIA")!=null?rs.getString("IDTIPOASISTENCIA").trim():"");
                cabtareoweb.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
                cabtareoweb.setUsuario(rs.getString("USUARIO")!=null?rs.getString("USUARIO").trim():"");
                lista.add(cabtareoweb); 
            }
            return lista;
        }

    public ArrayList<Cabtareoweb> listarPorEmpresaWebFiltroFecha_Fijo(String idempresa,String fechainicio,String fechafin,String idusuario) throws NisiraORMException,Exception {
        ArrayList<Cabtareoweb> lista = new ArrayList<Cabtareoweb>();

        ResultSet rs = null;
        rs = execProcedure("GETCABTAREOWEB_FIJO_TMPSS",idempresa,fechainicio,fechafin,idusuario);
        while (rs.next()) {
            Cabtareoweb cabtareoweb = new Cabtareoweb();
            cabtareoweb.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
            cabtareoweb.setIdempresa(rs.getString("IDEMPRESA").trim());
            cabtareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
            cabtareoweb.setIdemisor(rs.getString("IDEMISOR")!=null?rs.getString("IDEMISOR").trim():"");
            cabtareoweb.setIdsucursal(rs.getString("IDSUCURSAL")!=null?rs.getString("IDSUCURSAL").trim():"");
            cabtareoweb.setIdalmacen(rs.getString("IDALMACEN")!=null?rs.getString("IDALMACEN").trim():"");
            cabtareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
            cabtareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
            cabtareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
            cabtareoweb.setPeriodo(rs.getString("PERIODO")!=null?rs.getString("PERIODO").trim():"");
            cabtareoweb.setFecha(rs.getDate("FECHA"));
            cabtareoweb.setIdestado(rs.getString("IDESTADO")!=null?rs.getString("IDESTADO").trim():"");
            cabtareoweb.setIdresponsable(rs.getString("IDRESPONSABLE")!=null?rs.getString("IDRESPONSABLE").trim():"");
            cabtareoweb.setSucursal(rs.getString("SUCURSAL")!=null?rs.getString("SUCURSAL").trim():"");
            cabtareoweb.setAlmacen(rs.getString("ALMACEN")!=null?rs.getString("ALMACEN").trim():"");
            cabtareoweb.setResponsable(rs.getString("RESPONSABLE")!=null?rs.getString("RESPONSABLE").trim():"");
            cabtareoweb.setEstado(rs.getString("ESTADO")!=null?rs.getString("ESTADO").trim():"");
            cabtareoweb.setEmisor(rs.getString("EMISOR")!=null?rs.getString("EMISOR").trim():"");
            cabtareoweb.setIdturnotrabajo(rs.getString("IDTURNOTRABAJO")!=null?rs.getString("IDTURNOTRABAJO").trim():"");
            cabtareoweb.setFinicio(rs.getDate("FINICIO"));
            cabtareoweb.setFfin(rs.getDate("FFIN"));
            cabtareoweb.setIdtipoasistencia(rs.getString("IDTIPOASISTENCIA")!=null?rs.getString("IDTIPOASISTENCIA").trim():"");
            cabtareoweb.setIdusuario(rs.getString("IDUSUARIO")!=null?rs.getString("IDUSUARIO").trim():"");
            cabtareoweb.setUsuario(rs.getString("USUARIO")!=null?rs.getString("USUARIO").trim():"");
            lista.add(cabtareoweb); 
        }
        return lista;
    }
    public String grabar(int tipo,Cabtareoweb ob,List<Det_tareoweb> listDet_tareoweb) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Cabtareoweb.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES DORDENSERVICIOCLIENTE **********************/
            String xmlDet_tareoweb = "";
            xStream = new XStream();
            xStream.processAnnotations(Det_tareoweb.class);
            xmlDet_tareoweb = xml + xStream.toXML(listDet_tareoweb);
            
            ResultSet rs = null;
            rs = execProcedure("SP_TAREOWEB_GRABAR",
                    tipo,
                    ob.getIdempresa(),ob.getIdcabtareoweb(),
                    ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                    xmlNot,
                    xmlDet_tareoweb
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
    public String grabar_fijo(int tipo,Cabtareoweb ob,List<Det_tareoweb> listDet_tareoweb) throws Exception {
            String mensaje="";
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Cabtareoweb.class);
            xmlNot = xml + xStream.toXML(ob);
            /******************* DETALLES DORDENSERVICIOCLIENTE **********************/
            String xmlDet_tareoweb = "";
            xStream = new XStream();
            xStream.processAnnotations(Det_tareoweb.class);
            xmlDet_tareoweb = xml + xStream.toXML(listDet_tareoweb);
            
            ResultSet rs = null;
            rs = execProcedure("SP_TAREOWEB_FIJO_GRABAR",
                    tipo,
                    ob.getIdempresa(),ob.getIdcabtareoweb(),
                    ob.getIddocumento(),ob.getSerie(),ob.getNumero(),
                    xmlNot,
                    xmlDet_tareoweb
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
    public String aprobarTareo(Cabtareoweb ob,List<Det_tareoweb> listDet_tareoweb) throws Exception {
            String mensaje="";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            String xmlDet_tareoweb = "";
            XStream xStream = new XStream();
            xStream.processAnnotations(Det_tareoweb.class);
            xmlDet_tareoweb = xml + xStream.toXML(listDet_tareoweb);
            
            ResultSet rs = null;
            rs = execProcedure("SP_ORDENSERVICIOCLIENTE_TAREOWEB",
                    ob.getIdempresa(),ob.getIdcabtareoweb(),xmlDet_tareoweb
            );
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
                break;
            }

        return mensaje;
    }
    public String aprobarTareo_fijo(Cabtareoweb ob) throws Exception {
            String mensaje="";
            ResultSet rs = null;
            rs = execProcedure("SP_ORDENSERVICIOCLIENTE_TAREOWEB_FIJO",
                    ob.getIdempresa(),ob.getIdcabtareoweb()
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
                rs = execProcedure("SP_TAREO_ANULAR",idempresa,codigo,idusuario
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
            rs = execProcedure("SP_TAREO_ELIMINAR",idempresa,codigo,idusuario
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