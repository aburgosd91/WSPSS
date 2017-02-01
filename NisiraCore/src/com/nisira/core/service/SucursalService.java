/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;
import com.nisira.core.business.SucursalBusiness;
import com.nisira.core.entity.Sucursal;
import java.util.List;
/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class SucursalService extends BaseService<Sucursal>{
    private SucursalBusiness SucursalBusiness = new SucursalBusiness();
    public SucursalService(){
        super.setBaseBusiness(SucursalBusiness);
    }
//    public List<Sucursal> getRecordSucursalEmpresa(String empresa) throws Exception{
//        return SucursalBusiness.getRecordSucursalEmpresa(empresa);
//    }
//    public List<Sucursal> getRecordSucursalEmpresaActivo(String empresa) throws Exception{
//        return SucursalBusiness.getRecordSucursalEmpresaActivo(empresa);
//    }
//    public String addSucursal(Sucursal sucursal) throws Exception{
//        return SucursalBusiness.addSucursal(sucursal);
//    }<
//    public String editSucursal(Sucursal sucursal) throws Exception{
//        return SucursalBusiness.editSucursal(sucursal);
//    }
//    public String deleteSucursal(Sucursal sucursal) throws Exception{
//        return SucursalBusiness.deleteSucursal(sucursal);
//    }
//    public List<Sucursal> findByFiltro(String empresa,String filtro) throws Exception{
//        return SucursalBusiness.findByFiltro(empresa,filtro);
//    }
}
