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
public class BasedatosDao extends BaseDao<Basedatos> {
	public BasedatosDao() {
		super(Basedatos.class);
	}
	public BasedatosDao(boolean usaCnBase) throws NisiraORMException {
		super(Basedatos.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Basedatos> listarEmpresaUsuariosPorBaseDatos(String XmlBaseDatos) throws NisiraORMException {
            ArrayList<Basedatos> lista = new ArrayList<Basedatos>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GET_EMPRESASUSUARIOS_POR_DB_TMPEDIDO",XmlBaseDatos);
            while (rs.next()) {
               /*
                Basedatos empresa = new Basedatos();
                empresa.setIdbasedatos(rs.getString("IDBASEDATOS"));
                empresa.setIdempresa(rs.getString("IDEMPRESA"));
                empresa.setRazonsocial(rs.getString("RAZONSOCIAL"));
                empresa.setRuc(rs.getString("RUC"));
                empresa.setEstado(rs.getDouble("ESTADO"));
                
                lista.add(empresa);                             
                */
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
	/*-Fin-*/
}