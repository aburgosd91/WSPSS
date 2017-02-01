package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entityservices.*;import java.sql.ResultSet;
public class VendedorDao extends BaseDao<Vendedor> {
	public VendedorDao() {
		super(Vendedor.class);
	}
	public VendedorDao(boolean usaCnBase) throws NisiraORMException {
		super(Vendedor.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Vendedor> listarPorEmpresa(String idempresa) throws NisiraORMException {
            ArrayList<Vendedor> lista = new ArrayList<Vendedor>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETVENDEDORES_TMPEDIDO",idempresa);
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setIdbasedatos(rs.getString("IDBASEDATOS"));
                vendedor.setIdempresa(rs.getString("IDEMPRESA"));
                vendedor.setIdvendedor(rs.getString("IDVENDEDOR"));
                vendedor.setDescripcion(rs.getString("DESCRIPCION"));
                vendedor.setNombrecorto(rs.getString("NOMBRECORTO"));
                vendedor.setIdusuario(rs.getString("IDUSUARIO"));
                vendedor.setEstado(rs.getDouble("ESTADO"));
                
                lista.add(vendedor);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
	/*-Fin-*/
}