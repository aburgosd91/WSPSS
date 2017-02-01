/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.entity.Empresa;
import com.nisira.core.entity.Privilegios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antenor
 */
public class EmpresaBusiness extends BaseBusiness<Empresa>{
    private EmpresaDao Empresadao  = new  EmpresaDao();

    public EmpresaBusiness() {
//        super.setBaseDao(Empresadao);
    }
    
//    public ArrayList<Empresa> findByBaseDatos(String idbasedatos) throws Exception {
//         return Empresadao.findByBaseDatos(idbasedatos);
//    }
   
}
