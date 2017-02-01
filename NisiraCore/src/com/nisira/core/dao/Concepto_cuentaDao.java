package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Concepto_cuentaDao extends BaseDao<Concepto_cuenta> {
	public Concepto_cuentaDao() {
		super(Concepto_cuenta.class);
	}
	public Concepto_cuentaDao(boolean usaCnBase) throws NisiraORMException {
		super(Concepto_cuenta.class, usaCnBase);
	}

	public Concepto_cuenta getPorClavePrimaria(String idEmpresa, String idconcepto) throws NisiraORMException {
		List<Concepto_cuenta> l = listar("t0.idEmpresa = ? and t0.idconcepto = ? ", idEmpresa, idconcepto);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*APP SERVICE*/
        public ArrayList<Concepto_cuenta> listarPorEmpresaService(String idconcepto) throws NisiraORMException {
            ArrayList<Concepto_cuenta> lista = new ArrayList<Concepto_cuenta>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONCEPTO_CUENTA_TMPSS",idconcepto);
            while (rs.next()) {
                Concepto_cuenta concepto_cuenta = new Concepto_cuenta();
                concepto_cuenta.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                concepto_cuenta.setIdempresa(rs.getString("IDEMPRESA").trim());
                concepto_cuenta.setIdconcepto(rs.getString("IDCONCEPTO")!=null?rs.getString("IDCONCEPTO").trim():"");
                concepto_cuenta.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                concepto_cuenta.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                concepto_cuenta.setRegistrar_en(rs.getString("REGISTRAR_EN")!=null?rs.getString("REGISTRAR_EN").trim():"");
                concepto_cuenta.setEstado(rs.getFloat("ESTADO"));
                concepto_cuenta.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                concepto_cuenta.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(concepto_cuenta); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        /*APP WEB*/
        public ArrayList<Concepto_cuenta> listarPorEmpresaWeb(String idconcepto) throws NisiraORMException {
            ArrayList<Concepto_cuenta> lista = new ArrayList<Concepto_cuenta>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONCEPTO_CUENTA_TMPSS",idconcepto);
            while (rs.next()) {
                Concepto_cuenta concepto_cuenta = new Concepto_cuenta();
                concepto_cuenta.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                concepto_cuenta.setIdempresa(rs.getString("IDEMPRESA").trim());
                concepto_cuenta.setIdconcepto(rs.getString("IDCONCEPTO")!=null?rs.getString("IDCONCEPTO").trim():"");
                concepto_cuenta.setIdcuenta(rs.getString("IDCUENTA")!=null?rs.getString("IDCUENTA").trim():"");
                concepto_cuenta.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                concepto_cuenta.setRegistrar_en(rs.getString("REGISTRAR_EN")!=null?rs.getString("REGISTRAR_EN").trim():"");
                concepto_cuenta.setEstado(rs.getFloat("ESTADO"));
                concepto_cuenta.setSincroniza(rs.getString("SINCRONIZA")!=null?rs.getString("SINCRONIZA").trim():"");
                concepto_cuenta.setFechacreacion(rs.getDate("FECHACREACION"));
                lista.add(concepto_cuenta); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
}