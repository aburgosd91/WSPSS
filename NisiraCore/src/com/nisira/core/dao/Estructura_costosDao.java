package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Estructura_costos;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Destructura_costos_recursos;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.entity.Estructura_costos_mano_obra;
import com.nisira.core.entity.Estructura_costos_mano_obra_detallado;
import com.nisira.core.entity.Estructura_costos_producto;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estructura_costosDao extends BaseDao<Estructura_costos> {
	public Estructura_costosDao() {
		super(Estructura_costos.class);
	}
	public Estructura_costosDao(boolean usaCnBase) throws NisiraORMException {
		super(Estructura_costos.class, usaCnBase);
	}

	public Estructura_costos getPorClavePrimaria(String IDEMPRESA, String CODIGO) throws NisiraORMException {
		List<Estructura_costos> l = listar("t0.IDEMPRESA = ? and t0.CODIGO = ? ", IDEMPRESA, CODIGO);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP WEB*/
        public ArrayList<Estructura_costos> listarPorEmpresaWeb(String idempresa) throws NisiraORMException {
            ArrayList<Estructura_costos> lista = new ArrayList<Estructura_costos>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_TMPSS",idempresa);
                while (rs.next()) {
                    Estructura_costos estructura_costos_clieprov = new Estructura_costos();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_clieprov.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    estructura_costos_clieprov.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_clieprov.setFechacreacion(rs.getDate("FECHACREACION"));
                    estructura_costos_clieprov.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setCliente(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                    estructura_costos_clieprov.setExcluir(rs.getFloat("EXCLUIR"));
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos> listarPorEmpresaWebXcodigo(String idempresa,String codigo) throws NisiraORMException {
            ArrayList<Estructura_costos> lista = new ArrayList<Estructura_costos>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_TMPSS",idempresa,codigo);
                while (rs.next()) {
                    Estructura_costos estructura_costos_clieprov = new Estructura_costos();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_clieprov.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    estructura_costos_clieprov.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_clieprov.setFechacreacion(rs.getDate("FECHACREACION"));
                    estructura_costos_clieprov.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setCliente(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public ArrayList<Estructura_costos> listarPorEmpresaWebXidclieprov(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Estructura_costos> lista = new ArrayList<Estructura_costos>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_COTIZACIONVENTAS_TMPSS",idempresa,idclieprov);
                while (rs.next()) {
                    Estructura_costos estructura_costos_clieprov = new Estructura_costos();
                    estructura_costos_clieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                    estructura_costos_clieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                    estructura_costos_clieprov.setCodigo(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    estructura_costos_clieprov.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    estructura_costos_clieprov.setNombre_corto(rs.getString("NOMBRE_CORTO")!=null?rs.getString("NOMBRE_CORTO").trim():"");
                    estructura_costos_clieprov.setEstado(rs.getFloat("ESTADO"));
                    estructura_costos_clieprov.setFechacreacion(rs.getDate("FECHACREACION"));
                    estructura_costos_clieprov.setMoneda(rs.getString("MONEDA")!=null?rs.getString("MONEDA").trim():"");
                    estructura_costos_clieprov.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                    estructura_costos_clieprov.setCliente(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                    lista.add(estructura_costos_clieprov);                             
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        public String grabar(int tipo,String idempresa,String codigo,
                Estructura_costos estructura_costos,
                List<Estructura_costos_clieprov> listEstructura_costos_clieprov,
                List<Estructura_costos_producto> listEstructura_costos_producto,
                List<Destructura_costos_recursos> listDestructura_costos_recursos,
                List<Estructura_costos_mano_obra> listEstructura_costos_mano_obra,
                List<Estructura_costos_mano_obra_detallado> listEstructura_costos_mano_obra_detallado,
                String idusuario) throws Exception {
            String mensaje="";
            /********* ESTRUCTURA COSTOS ***********/
            String xmlNot = "";
            String xml = "<?xml version='1.0' encoding='ISO-8859-1' ?>";
            XStream xStream = new XStream();
            xStream.processAnnotations(Estructura_costos.class);
            xmlNot = xml + xStream.toXML(estructura_costos);
            /********* ESTRUCTURA COSTOS CLIEPROV***********/
            String xmlEstructura_costo_clieprov = "";
            xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_clieprov.class);
            xmlEstructura_costo_clieprov = xml + xStream.toXML(listEstructura_costos_clieprov);
            /********* ESTRUCTURA COSTOS PRODUCTO***********/
            String xmlEstructura_costo_producto = "";
            xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_producto.class);
            xmlEstructura_costo_producto = xml + xStream.toXML(listEstructura_costos_producto);
            /********* DESTRUCTURA COSTOS PRODUCTO RECURSO***********/
            String xmlDestructura_costo_recurso = "";
            xStream = new XStream();
            xStream.processAnnotations(Destructura_costos_recursos.class);
            xmlDestructura_costo_recurso = xml + xStream.toXML(listDestructura_costos_recursos);
            /********* ESTRUCTURA COSTOS PRODUCTO MANO OBRA***********/
            String xmlEstructura_costo_mano_obra = "";
            xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_mano_obra.class);
            xmlEstructura_costo_mano_obra = xml + xStream.toXML(listEstructura_costos_mano_obra);
            /********* ESTRUCTURA COSTOS PRODUCTO MANO OBRA DETALLADO***********/
            String xmlEstructura_costo_mano_obra_detallado = "";
            xStream = new XStream();
            xStream.processAnnotations(Estructura_costos_mano_obra_detallado.class);
            xmlEstructura_costo_mano_obra_detallado = xml + xStream.toXML(listEstructura_costos_mano_obra_detallado);
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ESTRUCTURA_COSTOS_GRABAR",tipo,idempresa,codigo,
                        xmlNot,xmlEstructura_costo_clieprov,xmlEstructura_costo_producto,
                        xmlDestructura_costo_recurso,xmlEstructura_costo_mano_obra,
                        xmlEstructura_costo_mano_obra_detallado,idusuario
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
        public String anular(String idempresa,String codigo,String idusuario) throws Exception {
            String mensaje="";
            /********* ESTRUCTURA COSTOS ***********/
            try {
                ResultSet rs = null;
                rs = execProcedure("SP_ESTRUCTURA_COSTOS_ANULAR",idempresa,codigo,idusuario
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
                rs = execProcedure("SP_ESTRUCTURA_COSTOS_ELIMINAR",idempresa,codigo,idusuario
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
        public List<List<Object>> export_xls(String idempresa) throws Exception {
            List<List<Object>> lst = new ArrayList<>();
            List<Object> objRow;
            /********* ESTRUCTURA COSTOS ***********/
            try {
                ResultSet rs = null;
                rs = execProcedure("GETESTRUCTURA_COSTOS_EXPORT_TMPSS",idempresa);
                while (rs.next()) {
                    objRow = new  ArrayList<>();
                    objRow.add(rs.getString("CODIGO")!=null?rs.getString("CODIGO").trim():"");
                    objRow.add(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                    objRow.add(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                    objRow.add(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                    objRow.add(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                    objRow.add(rs.getFloat("NHORAS"));
                    objRow.add(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                    objRow.add(rs.getString("AD1")!=null?rs.getString("AD1").trim():"");
                    objRow.add(rs.getString("AD2")!=null?rs.getString("AD2").trim():"");
                    lst.add(objRow);
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lst;
        }
}