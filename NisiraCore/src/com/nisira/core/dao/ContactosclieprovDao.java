package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Contactosclieprov;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactosclieprovDao extends BaseDao<Contactosclieprov> {
	public ContactosclieprovDao() {
		super(Contactosclieprov.class);
	}
	public ContactosclieprovDao(boolean usaCnBase) throws NisiraORMException {
		super(Contactosclieprov.class, usaCnBase);
	}

	public Contactosclieprov getPorClavePrimaria(String IDEMPRESA, String IDCLIEPROV, String ITEM) throws NisiraORMException {
		List<Contactosclieprov> l = listar("t0.IDEMPRESA = ? and t0.IDCLIEPROV = ? and t0.ITEM = ? ", IDEMPRESA, IDCLIEPROV, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*PAGINA WEB*/
        public ArrayList<Contactosclieprov> listarPorEmpresaClienteContactoWeb(String idempresa,String idclieprov) throws NisiraORMException {
            ArrayList<Contactosclieprov> lista = new ArrayList<Contactosclieprov>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETCONTACTOSCLIEPROV_TMPSS",idempresa,idclieprov);
            while (rs.next()) {
                Contactosclieprov contactosclieprov = new Contactosclieprov();
                contactosclieprov.setIdbasedatos(rs.getString("IDBASEDATOS").trim());
                contactosclieprov.setIdempresa(rs.getString("IDEMPRESA").trim());
                contactosclieprov.setIdclieprov(rs.getString("IDCLIEPROV").trim());
                contactosclieprov.setItem(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                contactosclieprov.setNombre(rs.getString("NOMBRE")!=null?rs.getString("NOMBRE").trim():"");
                contactosclieprov.setApellidopaterno(rs.getString("APELLIDOPATERNO")!=null?rs.getString("APELLIDOPATERNO").trim():"");
                contactosclieprov.setApellidomaterno(rs.getString("APELLIDOMATERNO")!=null?rs.getString("APELLIDOMATERNO").trim():"");
                contactosclieprov.setTelefono1(rs.getString("TELEFONO1")!=null?rs.getString("TELEFONO1").trim():"");
                contactosclieprov.setTelefono1(rs.getString("TELEFONO2")!=null?rs.getString("TELEFONO2").trim():"");
                contactosclieprov.setTelefono1(rs.getString("TELEFONO3")!=null?rs.getString("TELEFONO3").trim():"");
                contactosclieprov.setEmail(rs.getString("EMAIL")!=null?rs.getString("EMAIL").trim():"");
                contactosclieprov.setPredeterminado(rs.getFloat("PREDETERMINADO"));
                contactosclieprov.setEstado(rs.getFloat("ESTADO"));
                contactosclieprov.setFechacreacion(rs.getDate("FECHACREACION"));
                contactosclieprov.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                contactosclieprov.setDireccion(rs.getString("DIRECCION")!=null?rs.getString("DIRECCION").trim():"");
                lista.add(contactosclieprov);                             
                
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            return lista;
        }
}