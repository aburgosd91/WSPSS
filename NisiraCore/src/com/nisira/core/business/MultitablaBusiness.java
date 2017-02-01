/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.business;

import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.entity.Multitabla;
import java.util.List;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
public class MultitablaBusiness extends BaseBusiness<Multitabla>{
    private MultitablaDao multitabladao = new  MultitablaDao();
    public MultitablaBusiness(){
        super.setBaseDao(multitabladao);
    }
    public List<Multitabla> getRecordTabla(String empresa) throws Exception{
        return multitabladao.findTabla(empresa);
    }
    public List<Multitabla> getRecordTablaDetalle(String empresa,String dep) throws Exception{
        return multitabladao.findDetalleTabla(empresa, dep);
    }
    public String addMultitabla(Multitabla m) throws Exception{
        return multitabladao.addMultitabla(m);
    }
    public String addXmlMultitabla(String idempresa,int dep_id,String xml) throws Exception{
        return multitabladao.addXmlMultitabla(idempresa,dep_id,xml);
    }
    public String editMultitabla(Multitabla m) throws Exception{
        return multitabladao.editMultitabla(m);
    }
    public String deleteMultitabla(Multitabla m) throws Exception{
        return multitabladao.deleteMultitabla(m);
    }
    /*********CONSULTAS OTRAS TABLAS********/
    public List<Multitabla> getRecordTipoAlmacen(String empresa) throws Exception{
        return multitabladao.findTipoAlmacen(empresa);
    }
    public List<Multitabla> getRecordParametroGeneracionCodigo(String empresa) throws Exception{
        return multitabladao.findParametroGeneracionCodigo(empresa);
    }
    public List<Multitabla> getRecordParametroRegla(String empresa) throws Exception{
        return multitabladao.findParametroRegla(empresa);
    }
    public List<Multitabla> getRecordDistribucionNivel(String empresa) throws Exception{
        return multitabladao.findDistribucionNivel(empresa);
    }
    public List<Multitabla> getRecordTipoEtiqueta(String empresa) throws Exception{
        return multitabladao.findTipoEtiqueta(empresa);
    }
}
