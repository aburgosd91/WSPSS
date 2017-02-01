/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.PrivilegiosBusiness;
import com.nisira.core.entity.Privilegios;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PrivilegiosService extends BaseService<Privilegios>{
    private PrivilegiosBusiness privilegiosBusiness = new PrivilegiosBusiness();
     
     public PrivilegiosService() {
        super.setBaseBusiness(privilegiosBusiness);
    }
     public List<Privilegios> buscar(String usuario, String formulario) throws Exception {
         return privilegiosBusiness.buscar(usuario,formulario);
     }
     
}
