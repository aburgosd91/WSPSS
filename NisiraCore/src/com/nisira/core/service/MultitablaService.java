/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.MultitablaBusiness;
import com.nisira.core.entity.Multitabla;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class MultitablaService extends BaseService<Multitabla>{
    private MultitablaBusiness multitablaBusiness = new MultitablaBusiness();
    public MultitablaService(){
        super.setBaseBusiness(multitablaBusiness);
    }
    public List<Multitabla> getRecordTabla(String empresa) throws Exception{
        return multitablaBusiness.getRecordTabla(empresa);
    }
    public List<Multitabla> getRecordTablaDetalle(String empresa,String dep) throws Exception{
        return multitablaBusiness.getRecordTablaDetalle(empresa,dep);
    }
    public String addMultitabla(Multitabla m) throws Exception{
        return multitablaBusiness.addMultitabla(m);
    }
    public String addXmlMultitabla(String idempresa,int dep_id,String xml) throws Exception{
        return multitablaBusiness.addXmlMultitabla(idempresa,dep_id,xml);
    }
    public String editMultitabla(Multitabla m) throws Exception{
        return multitablaBusiness.editMultitabla(m);
    }
    public String deleteMultitabla(Multitabla m) throws Exception{
        return multitablaBusiness.deleteMultitabla(m);
    }
    public List<Multitabla> getRecordTipoAlmacen(String empresa) throws Exception{
        return multitablaBusiness.getRecordTipoAlmacen(empresa);
    }
    public List<Multitabla> getRecordParametroGeneracionCodigo(String empresa) throws Exception{
        return multitablaBusiness.getRecordParametroGeneracionCodigo(empresa);
    }
    public List<Multitabla> getRecordParametroRegla(String empresa) throws Exception{
        return multitablaBusiness.getRecordParametroRegla(empresa);
    }
    public List<Multitabla> getRecordDistribucionNivel(String empresa) throws Exception{
        return multitablaBusiness.getRecordDistribucionNivel(empresa);
    }
    public List<Multitabla> getRecordTipoEtiqueta(String empresa) throws Exception{
        return multitablaBusiness.getRecordTipoEtiqueta(empresa);
    }
}
