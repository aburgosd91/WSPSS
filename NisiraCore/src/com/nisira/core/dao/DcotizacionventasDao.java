package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DcotizacionventasDao extends BaseDao<Dcotizacionventas> {
	public DcotizacionventasDao() {
		super(Dcotizacionventas.class);
	}
	public DcotizacionventasDao(boolean usaCnBase) throws NisiraORMException {
		super(Dcotizacionventas.class, usaCnBase);
	}
        /*APP WEB*/
        public List<Dcotizacionventas> getListDCotizacionWeb(String idempresa,String idcotizacionventas) throws NisiraORMException {
            List<Dcotizacionventas> listDcotizacionventas=new ArrayList<Dcotizacionventas>();
            Dcotizacionventas dcotizacionventas=null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("OBJTABLAS_RETURNDETALLECOTIZACIONES_WEB",idempresa,idcotizacionventas);
            while (rs.next()) {
                dcotizacionventas = new Dcotizacionventas();
                dcotizacionventas.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                dcotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                dcotizacionventas.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dcotizacionventas.setIdcompra(rs.getString("IDCOMPRA")!=null?rs.getString("IDCOMPRA").trim():"");
                dcotizacionventas.setItemcotizacion(rs.getString("ITEMCOTIZACION")!=null?rs.getString("ITEMCOTIZACION").trim():"");
                dcotizacionventas.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                dcotizacionventas.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas.setProducto(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
                dcotizacionventas.setCantidad(rs.getFloat("CANTIDAD"));
                dcotizacionventas.setPrecio(rs.getFloat("PRECIO"));
                dcotizacionventas.setDescuento(rs.getFloat("DESCUENTO"));
                dcotizacionventas.setImporte(rs.getFloat("IMPORTE"));
                dcotizacionventas.setEs_afecto(rs.getFloat("ES_AFECTO"));
                dcotizacionventas.setPorcentajedscto1(rs.getFloat("PORCENTAJEDSCTO1"));
                dcotizacionventas.setPorcentajedscto2(rs.getFloat("PORCENTAJEDSCTO2"));
                dcotizacionventas.setPorcentajedscto3(rs.getFloat("PORCENTAJEDSCTO3"));
                dcotizacionventas.setImpuesto_i(rs.getFloat("IMPUESTO_I"));
                dcotizacionventas.setImpuesto(rs.getFloat("IMPUESTO"));
                dcotizacionventas.setImportedscto1(rs.getFloat("IMPORTEDSCTO1"));
                dcotizacionventas.setImportedscto2(rs.getFloat("IMPORTEDSCTO2"));
                dcotizacionventas.setImportedscto3(rs.getFloat("IMPORTEDSCTO3"));
                dcotizacionventas.setSubtotalsindscto(rs.getFloat("SUBTOTALSINDSCTO"));
                dcotizacionventas.setSubtotalcondscto(rs.getFloat("SUBTOTALCONDSCTO"));
                dcotizacionventas.setObservaciones(rs.getString("OBSERVACIONES")!=null?rs.getString("OBSERVACIONES").trim():"");
                dcotizacionventas.setNhoras(rs.getString("NHORAS")!=null?rs.getString("NHORAS").trim():"");
                dcotizacionventas.setImporte_isc(rs.getFloat("IMPORTE_ISC"));
                dcotizacionventas.setCodoperativo(rs.getString("CODOPERATIVO")!=null?rs.getString("CODOPERATIVO").trim():"");
                dcotizacionventas.setRuta_op(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                dcotizacionventas.setIdruta_op(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                dcotizacionventas.setNhoras_op(rs.getFloat("NHORAS_OP"));
                
                listDcotizacionventas.add(dcotizacionventas);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return listDcotizacionventas;
        }
        public List<Dcotizacionventas> getListDCotizacionWeb_ordenservicio(String idempresa,String idcotizacionventas) throws NisiraORMException {
            List<Dcotizacionventas> listDcotizacionventas=new ArrayList<Dcotizacionventas>();
            Dcotizacionventas dcotizacionventas=null;
        try
        {
            ResultSet rs = null;
            rs = execProcedure("OBJTABLAS_RETURNDETALLECOTIZACIONES_ORDENSERVICIO_WEB",idempresa,idcotizacionventas);
            while (rs.next()) {
                dcotizacionventas = new Dcotizacionventas();
                dcotizacionventas.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                dcotizacionventas.setIdcotizacionv(rs.getString("IDCOTIZACIONV")!=null?rs.getString("IDCOTIZACIONV").trim():"");
                dcotizacionventas.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dcotizacionventas.setIdproducto(rs.getString("IDPRODUCTO")!=null?rs.getString("IDPRODUCTO").trim():"");
                dcotizacionventas.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas.setProducto(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                dcotizacionventas.setIdmedida(rs.getString("IDMEDIDA")!=null?rs.getString("IDMEDIDA").trim():"");
                dcotizacionventas.setCantidad(rs.getFloat("CANTIDAD"));
                dcotizacionventas.setPrecio(rs.getFloat("PRECIO"));
                dcotizacionventas.setDescuento(rs.getFloat("DESCUENTO"));
                dcotizacionventas.setImporte(rs.getFloat("IMPORTE"));
                dcotizacionventas.setEs_afecto(rs.getFloat("ES_AFECTO"));
                dcotizacionventas.setPorcentajedscto1(rs.getFloat("PORCENTAJEDSCTO1"));
                dcotizacionventas.setPorcentajedscto2(rs.getFloat("PORCENTAJEDSCTO2"));
                dcotizacionventas.setPorcentajedscto3(rs.getFloat("PORCENTAJEDSCTO3"));
                dcotizacionventas.setImpuesto_i(rs.getFloat("IMPUESTO_I"));
                dcotizacionventas.setImpuesto(rs.getFloat("IMPUESTO"));
                dcotizacionventas.setImportedscto1(rs.getFloat("IMPORTEDSCTO1"));
                dcotizacionventas.setImportedscto2(rs.getFloat("IMPORTEDSCTO2"));
                dcotizacionventas.setImportedscto3(rs.getFloat("IMPORTEDSCTO3"));
                dcotizacionventas.setSubtotalsindscto(rs.getFloat("SUBTOTALSINDSCTO"));
                dcotizacionventas.setSubtotalcondscto(rs.getFloat("SUBTOTALCONDSCTO"));
                dcotizacionventas.setObservaciones(rs.getString("OBSERVACIONES")!=null?rs.getString("OBSERVACIONES").trim():"");
                dcotizacionventas.setNhoras(rs.getString("NHORAS")!=null?rs.getString("NHORAS").trim():"");
                dcotizacionventas.setImporte_isc(rs.getFloat("IMPORTE_ISC"));
                listDcotizacionventas.add(dcotizacionventas);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return listDcotizacionventas;
        }
}