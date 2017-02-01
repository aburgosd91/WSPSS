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
            rs = execProcedure("OBJTABLAS_RETURNDETALLECOTIZACIONES_WEB",idempresa,"",idcotizacionventas);
            while (rs.next()) {
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
                listDcotizacionventas.add(dcotizacionventas);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return listDcotizacionventas;
        }
}