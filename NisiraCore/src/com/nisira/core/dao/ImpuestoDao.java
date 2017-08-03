package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Impuesto;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dimpuesto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImpuestoDao extends BaseDao<Impuesto> {

    public ImpuestoDao() {
        super(Impuesto.class);
    }

    public ImpuestoDao(boolean usaCnBase) throws NisiraORMException {
        super(Impuesto.class, usaCnBase);
    }

    public Impuesto getPorClavePrimaria(String IDEMPRESA, String IDIMPUESTO) throws NisiraORMException {
        List<Impuesto> l = listar("t0.IDEMPRESA = ? and t0.IDIMPUESTO = ? ", IDEMPRESA, IDIMPUESTO);
        if (l.isEmpty()) {
            return null;
        } else {
            return l.get(0);
        }
    }
    
    public ArrayList<Impuesto> listarPorEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Impuesto> lista = new ArrayList<Impuesto>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETIMPUESTO_TMPSS",idempresa);
            while (rs.next()) {
                Impuesto impuesto = new Impuesto();
                impuesto.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                impuesto.setIdimpuesto(rs.getString("IDIMPUESTO")!=null?rs.getString("IDIMPUESTO").trim():"");
                impuesto.setDescripcion(rs.getString("DESCRIPCION")!=null?rs.getString("DESCRIPCION").trim():"");
                impuesto.setDesc_corta(rs.getString("DESC_CORTA")!=null?rs.getString("DESC_CORTA").trim():"");
                impuesto.setFechacreacion(rs.getDate("FECHACREACION"));
                impuesto.setEstado(rs.getFloat("ESTADO"));
                lista.add(impuesto);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
    
    public Float getImpuesto(String idempresa, String idimpuesto) {
        Float result = 0f;
        try {
            ResultSet rs = null;
            rs = execProcedure("GETIMPUESTO", idempresa,idimpuesto);
            while (rs.next()) {
                result = rs.getFloat("VALOR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
