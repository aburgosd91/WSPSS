/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.Clave;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.Constantes;

/**
 *
 * @author Antenor
 */
public class UsuarioBusiness extends BaseBusiness<Usuario>{
    private UsuarioDao usuarioDao = new UsuarioDao();
    
    public UsuarioBusiness(){
//        super.setBaseDao(usuarioDao);
    }
    
    @Override
    public Usuario actualizar(Usuario e) throws Exception {
//        e.setPASSWORD(Clave.Encriptar(e.getPASSWORD()));
//        e.setESTADO(Constantes.HABILITADO);
        return super.actualizar(e);
    }
    
//    public Usuario validarInicioSesion(String idusuario, String password) throws Exception {
//        return usuarioDao.validarInicioSesion(idusuario, password);
//    }
//    
//    public String insertarMonitor(String idusuario, String idsesion) throws Exception {
//        return usuarioDao.insertarMonitor(idusuario, idsesion);
//    }
//    
//    public String eliminarMonitor(String idsesion) throws Exception {
//       
//        return usuarioDao.eliminarMonitor(idsesion);
//    }
}
