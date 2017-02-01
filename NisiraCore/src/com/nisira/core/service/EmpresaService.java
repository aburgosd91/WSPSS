/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;


import com.nisira.core.business.EmpresaBusiness;
import com.nisira.core.entity.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class EmpresaService extends BaseService<Empresa> {

    private EmpresaBusiness Empresabusiness = new EmpresaBusiness();

    public EmpresaService() {
        super.setBaseBusiness(Empresabusiness);
    }
    
//    public ArrayList<Empresa> findByBaseDatos(String idbasedatos) throws Exception {
//         return Empresabusiness.findByBaseDatos(idbasedatos);
//    }
}
