package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DordenliquidaciongastoDao extends BaseDao<Dordenliquidaciongasto> {
	public DordenliquidaciongastoDao() {
		super(Dordenliquidaciongasto.class);
	}
	public DordenliquidaciongastoDao(boolean usaCnBase) throws NisiraORMException {
		super(Dordenliquidaciongasto.class, usaCnBase);
	}

	public Dordenliquidaciongasto getPorClavePrimaria(String idempresa, String idorden, String item) throws NisiraORMException {
            List<Dordenliquidaciongasto> l = listar("t0.idempresa = ? and t0.idorden = ? and t0.item = ? ", idempresa, idorden, item);
            if (l.isEmpty()) {
                    return null;
            } else {
                    return l.get(0);
            }
	}
        /*APP SERVICE*/
        public ArrayList<Dordenliquidaciongasto> listarPorEmpresaService(String idempresa) throws NisiraORMException {
            ArrayList<Dordenliquidaciongasto> lista = new ArrayList<Dordenliquidaciongasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("[GETDORDENLIQUIDACIONGASTO_TMPSS]",idempresa);
            while (rs.next()) {
                Dordenliquidaciongasto dordenserviciocliente = new Dordenliquidaciongasto();
                dordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                dordenserviciocliente.setIdorden(rs.getString("IDORDEN")!=null?rs.getString("IDORDEN").trim():"");
                dordenserviciocliente.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                dordenserviciocliente.setIdconcepto(rs.getString("IDCONCEPTO")!=null?rs.getString("IDCONCEPTO").trim():"");
                dordenserviciocliente.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                dordenserviciocliente.setIdccosto(rs.getString("IDCCOSTO")!=null?rs.getString("IDCCOSTO").trim():"");
                dordenserviciocliente.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                dordenserviciocliente.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                dordenserviciocliente.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                dordenserviciocliente.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                dordenserviciocliente.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                dordenserviciocliente.setFecha(rs.getDate("FECHA"));
                dordenserviciocliente.setIddestino(rs.getString("IDDESTINO")!=null?rs.getString("IDDESTINO").trim():"");
                dordenserviciocliente.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                dordenserviciocliente.setTcmoneda(rs.getFloat("TCMONEDA"));
                dordenserviciocliente.setTcambio(rs.getFloat("TCAMBIO"));
                dordenserviciocliente.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                dordenserviciocliente.setAfecto(rs.getFloat("AFECTO"));
                dordenserviciocliente.setInafecto(rs.getFloat("INAFECTO"));
                dordenserviciocliente.setPimpuesto(rs.getFloat("PIMPUESTO"));
                dordenserviciocliente.setImpuesto(rs.getFloat("IMPUESTO"));
                dordenserviciocliente.setImporte(rs.getFloat("IMPORTE"));
                dordenserviciocliente.setOtros(rs.getFloat("OTROS"));
                dordenserviciocliente.setIdconsumidor(rs.getString("IDCONSUMIDOR")!=null?rs.getString("IDCONSUMIDOR").trim():"");
                dordenserviciocliente.setConceptocuenta(rs.getString("CONCEPTOCUENTA")!=null?rs.getString("CONCEPTOCUENTA").trim():"");
                dordenserviciocliente.setDestinoadquisicion(rs.getString("DESTINOADQUISICION")!=null?rs.getString("DESTINOADQUISICION").trim():"");
                dordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
        /*APP WEB*/
        public ArrayList<Dordenliquidaciongasto> listarPorOrdenliquidaciongastoWeb(String idempresa,String idorigen) throws NisiraORMException {
            ArrayList<Dordenliquidaciongasto> lista = new ArrayList<Dordenliquidaciongasto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("[GETDORDENLIQUIDACIONGASTO_TMPSS]",idempresa,idorigen);
            while (rs.next()) {
                Dordenliquidaciongasto dordenserviciocliente = new Dordenliquidaciongasto();
                dordenserviciocliente.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                dordenserviciocliente.setIdorden(rs.getString("IDORDEN")!=null?rs.getString("IDORDEN").trim():"");
                dordenserviciocliente.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                dordenserviciocliente.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                dordenserviciocliente.setIdconcepto(rs.getString("IDCONCEPTO")!=null?rs.getString("IDCONCEPTO").trim():"");
                dordenserviciocliente.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                dordenserviciocliente.setIdccosto(rs.getString("IDCCOSTO")!=null?rs.getString("IDCCOSTO").trim():"");
                dordenserviciocliente.setIdtipomov(rs.getString("IDTIPOMOV")!=null?rs.getString("IDTIPOMOV").trim():"");
                dordenserviciocliente.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                dordenserviciocliente.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                dordenserviciocliente.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                dordenserviciocliente.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                dordenserviciocliente.setFecha(rs.getDate("FECHA"));
                dordenserviciocliente.setIddestino(rs.getString("IDDESTINO")!=null?rs.getString("IDDESTINO").trim():"");
                dordenserviciocliente.setIdmoneda(rs.getString("IDMONEDA")!=null?rs.getString("IDMONEDA").trim():"");
                dordenserviciocliente.setTcmoneda(rs.getFloat("TCMONEDA"));
                dordenserviciocliente.setTcambio(rs.getFloat("TCAMBIO"));
                dordenserviciocliente.setIdregimen(rs.getString("IDREGIMEN")!=null?rs.getString("IDREGIMEN").trim():"");
                dordenserviciocliente.setAfecto(rs.getFloat("AFECTO"));
                dordenserviciocliente.setInafecto(rs.getFloat("INAFECTO"));
                dordenserviciocliente.setPimpuesto(rs.getFloat("PIMPUESTO"));
                dordenserviciocliente.setImpuesto(rs.getFloat("IMPUESTO"));
                dordenserviciocliente.setImporte(rs.getFloat("IMPORTE"));
                dordenserviciocliente.setOtros(rs.getFloat("OTROS"));
                dordenserviciocliente.setIdconsumidor(rs.getString("IDCONSUMIDOR")!=null?rs.getString("IDCONSUMIDOR").trim():"");
                dordenserviciocliente.setConceptocuenta(rs.getString("CONCEPTOCUENTA")!=null?rs.getString("CONCEPTOCUENTA").trim():"");
                dordenserviciocliente.setDestinoadquisicion(rs.getString("DESTINOADQUISICION")!=null?rs.getString("DESTINOADQUISICION").trim():"");
                dordenserviciocliente.setRazonsocial(rs.getString("RAZONSOCIAL")!=null?rs.getString("RAZONSOCIAL").trim():"");
                lista.add(dordenserviciocliente); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
}
