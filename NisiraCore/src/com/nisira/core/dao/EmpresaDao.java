package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.Consulta;
import com.nisira.core.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entityservices.*;
import java.sql.ResultSet;
public class EmpresaDao extends BaseDao<Empresa> {
	public EmpresaDao() {
		super(Empresa.class);
	}
	public EmpresaDao(boolean usaCnBase) throws NisiraORMException {
		super(Empresa.class, usaCnBase);
	}

        /*-Inicio-*/
        public ArrayList<Empresa> listar() throws NisiraORMException {
            ArrayList<Empresa> lista = new ArrayList<Empresa>();
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETEMPRESAS_TMPSS");
                while (rs.next()) {
                    Empresa empresa = new Empresa();
                    empresa.setIdbasedatos(rs.getString("IDBASEDATOS"));
                    empresa.setIdempresa(rs.getString("IDEMPRESA"));
                    empresa.setRazonsocial(rs.getString("RAZONSOCIAL"));
                    empresa.setRuc(rs.getString("RUC"));
                    empresa.setEstado(rs.getDouble("ESTADO"));

                    lista.add(empresa);                             

                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return lista;
        }
        
        public ResponseWebService3<Empresa,Usuario,Vendedor> listarPorBaseDatos(String XmlBaseDatos) throws NisiraORMException {
            ArrayList<Empresa> listaempresa = new ArrayList<Empresa>();
            ArrayList<Usuario> listausuario = new ArrayList<Usuario>();
            ArrayList<Vendedor> listavendedor = new ArrayList<Vendedor>();
            ResponseWebService3<Empresa,Usuario,Vendedor> lista_empresa_usuario_vendedor = new ResponseWebService3<Empresa,Usuario,Vendedor>(listaempresa,listausuario,listavendedor);
            try
            {
                ResultSet rs = null;
                rs = execProcedure("GETEMPRESAS_USUARIOS_DB_TMPEDIDO",XmlBaseDatos);
                while (rs.next()) {
                    String mensaje = rs.getString("MENSAJE");
                    if (mensaje.trim().equals("OK")){
                        Empresa empresa = new Empresa();
                        empresa.setIdbasedatos(rs.getString("IDBASEDATOS_EMP"));
                        empresa.setIdempresa(rs.getString("IDEMPRESA_EMP"));
                        empresa.setRazonsocial(rs.getString("RAZONSOCIAL_EMP"));
                        empresa.setRuc(rs.getString("RUC_EMP"));
                        empresa.setEstado(rs.getDouble("ESTADO_EMP"));
                        
                        Boolean existempresa = false; 
                        if(empresa.getIdempresa()!= null){
                            for(Empresa emp: listaempresa)
                            {
                                if(emp.getIdbasedatos().trim().equals(empresa.getIdbasedatos().trim()) && emp.getIdempresa().trim().equals(empresa.getIdempresa().trim())) 
                                {
                                    existempresa = true;
                                    break;
                                }
                            }

                            if(!existempresa){
                                listaempresa.add(empresa);
                            }
                        }
                                
                        Usuario usuario = new Usuario();
                        usuario.setIdbasedatos(rs.getString("IDBASEDATOS_USU"));
                        usuario.setIdempresa(rs.getString("IDEMPRESA_USU"));
                        usuario.setIdusuario(rs.getString("IDUSUARIO_USU"));
                        usuario.setPassword(rs.getString("PASSWORD_USU"));
                        
                        Boolean existeusuario = false; 
                        if(usuario.getIdusuario()!= null){
                            for(Usuario usu: listausuario){
                                if(usu.getIdbasedatos().trim().equals(usuario.getIdbasedatos().trim()) && usu.getIdempresa().trim().equals(usuario.getIdempresa().trim()) &&  usu.getIdusuario().trim().equals(usuario.getIdusuario().trim()))  {
                                    existeusuario = true;
                                    break;
                                }
                            }
                            if(!existeusuario){
                                listausuario.add(usuario);
                            }
                        }
                      
                        Vendedor vendedor = new Vendedor();
                        vendedor.setIdbasedatos(rs.getString("IDBASEDATOS_VEND"));
                        vendedor.setIdempresa(rs.getString("IDEMPRESA_VEND"));
                        vendedor.setIdvendedor(rs.getString("IDVENDEDOR_VEND"));
                        vendedor.setDescripcion(rs.getString("DESCVENDEDOR_VEND"));
                        vendedor.setNombrecorto(rs.getString("NOMBRECORTO_VEND"));
                        vendedor.setIdusuario(rs.getString("IDUSUARIO_VEND"));
                        vendedor.setEstado(rs.getDouble("ESTADO_VEND"));
                        
                        
                        Boolean existevendedor = false; 
                        if(vendedor.getIdvendedor() != null){
                            for(Vendedor vend: listavendedor){
                                if(vend.getIdbasedatos().trim().equals(vendedor.getIdbasedatos().trim()) && vend.getIdempresa().trim().equals(vendedor.getIdempresa().trim()) &&  vend.getIdvendedor().trim().equals(vendedor.getIdvendedor().trim()))  {
                                    existevendedor = true;
                                    break;
                                }
                            }

                            if(!existevendedor){
                                listavendedor.add(vendedor);
                            }
                        }
                        
                    }
                    else{
                        lista_empresa_usuario_vendedor =null;
                        break;
                    }
                }
                lista_empresa_usuario_vendedor.setLista1(listaempresa);
                lista_empresa_usuario_vendedor.setLista2(listausuario);
                lista_empresa_usuario_vendedor.setLista3(listavendedor);
                
            } catch(Exception ex) {
                String mensaje = ex.toString();
                System.out.println(mensaje);
            }
            return lista_empresa_usuario_vendedor;
        }
	/*-Fin-*/
        /*APP WEB*/
}