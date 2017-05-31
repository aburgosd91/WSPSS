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
public class UsuarioDao extends BaseDao<Usuario> {
	public UsuarioDao() {
		super(Usuario.class);
	}
	public UsuarioDao(boolean usaCnBase) throws NisiraORMException {
		super(Usuario.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Usuario> listar(String idempresa) throws NisiraORMException {
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("GETUSUARIOS_TMPEDIDO");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdbasedatos(rs.getString("IDBASEDATOS"));
                usuario.setIdempresa(rs.getString("IDEMPRESA"));
                usuario.setIdusuario(rs.getString("IDUSUARIO"));
                usuario.setPassword(rs.getString("PASSWORD"));

                lista.add(usuario);                             

            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }
        public Usuario getSesionUsuarioMovil(String idempresa,String idusuario,String pass) throws NisiraORMException {
            Usuario usuario=null;
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETUSUARIO_APPMOVIL_TMPSS",idusuario,pass);
                while (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdbasedatos(rs.getString("IDBASEDATOS"));
                    usuario.setIdempresa(idempresa);
                    usuario.setIdusuario(rs.getString("IDUSUARIO"));
                    usuario.setUsr_nombres(rs.getString("USR_NOMBRES"));
                    usuario.setIdclieprov(rs.getString("IDCLIEPROV"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    usuario.setEmail(rs.getString("EMAIL"));
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return usuario;
        }
	/*-Fin-*/
        /*APPWEB*/
        public Usuario getSesionUsuario(String idempresa,String idusuario,String pass) throws NisiraORMException {
            Usuario usuario=null;
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETUSUARIO_TMPSS",idusuario,pass);
                while (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdbasedatos(rs.getString("IDBASEDATOS"));
                    usuario.setIdempresa(idempresa);
                    usuario.setIdusuario(rs.getString("IDUSUARIO"));
                    usuario.setUsr_nombres(rs.getString("USR_NOMBRES"));
                    usuario.setIdclieprov(rs.getString("IDCLIEPROV"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    usuario.setIdcodigogeneral(rs.getString("IDCODIGOGENERAL"));
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return usuario;
        }
        public List<Usuario> getUsuarioXappmovil(String idempresa) throws NisiraORMException {
            Usuario usuario=null;
            List<Usuario> lst = new ArrayList<>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETUSUARIO_MOVIL_TMPSS",idempresa);
                while (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdbasedatos(rs.getString("IDBASEDATOS"));
                    usuario.setIdempresa(idempresa);
                    usuario.setIdusuario(rs.getString("IDUSUARIO"));
                    usuario.setUsr_nombres(rs.getString("USR_NOMBRES"));
                    usuario.setIdclieprov(rs.getString("IDCLIEPROV"));
                    usuario.setPassword(rs.getString("PASSWORD"));
                    lst.add(usuario);
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lst;
        }
}