/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.UsuarioBusiness;
import com.nisira.core.entity.Usuario;

/**
 *
 * @author Antenor
 */
public class UsuarioService extends BaseService<Usuario> {
    private UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

    public UsuarioService() {
        super.setBaseBusiness(usuarioBusiness);
    }

//    public Usuario validarInicioSesion(String idusuario, String password) throws Exception {
//        return usuarioBusiness.validarInicioSesion(idusuario, password);
//    }
//    
//    public String insertarMonitor(String idusuario, String idsesion) throws Exception {
//        return usuarioBusiness.insertarMonitor(idusuario, idsesion);
//    }
//    
//    public String eliminarMonitor(String idsesion) throws Exception {
//         
//        return usuarioBusiness.eliminarMonitor(idsesion);
//       
//    }
}
