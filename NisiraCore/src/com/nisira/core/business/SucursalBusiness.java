/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Sucursal;

/**
 *
 * @author Alex Johel Burgos Dionicio
 * 
 */
public class SucursalBusiness extends BaseBusiness<Sucursal>{
    private SucursalDao sucursaldao = new  SucursalDao();
    public SucursalBusiness(){
//        super.setBaseDao(sucursaldao);
    }
//    public List<Sucursal> getRecordSucursalEmpresa(String empresa) throws Exception{
//        return sucursaldao.findAll(empresa);
//    }
//    public List<Sucursal> getRecordSucursalEmpresaActivo(String empresa) throws Exception{
//        return sucursaldao.findAllActivo(empresa);
//    }
//    public String addSucursal(Sucursal sucursal) throws Exception{
//        return sucursaldao.addSucursal(sucursal);
//    }
//    public String editSucursal(Sucursal sucursal) throws Exception{
//        return sucursaldao.editSucursal(sucursal);
//    }
//    public String deleteSucursal(Sucursal sucursal) throws Exception{
//        return sucursaldao.deleteSucursal(sucursal);
//    }
//    public List<Sucursal> findByFiltro(String empresa,String filtro) throws Exception{
//        return sucursaldao.findByFiltro(empresa,filtro);
//    }
}
