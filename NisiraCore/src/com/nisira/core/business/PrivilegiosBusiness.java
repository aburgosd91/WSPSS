/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.PrivilegiosDao;
import com.nisira.core.entity.Privilegios;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class PrivilegiosBusiness extends BaseBusiness<Privilegios>{
    private PrivilegiosDao privilegiosDao = new  PrivilegiosDao();

    public PrivilegiosBusiness() {
        super.setBaseDao(privilegiosDao);
    }
    
    public List<Privilegios> buscar(String usuario, String formulario) throws Exception {
         return privilegiosDao.buscar(usuario,formulario);
     }
}
