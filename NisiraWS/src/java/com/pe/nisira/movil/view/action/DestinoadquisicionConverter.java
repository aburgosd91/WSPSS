/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.PlanctasDao;
import com.nisira.core.dao.ProductosDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Planctas;
import com.nisira.core.entity.Productos;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author aburgos
 */
@FacesConverter("destinoadquisicionConverter")
public class DestinoadquisicionConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                List<Destinoadquisicion> lst = (new DestinoadquisicionDao()).listarPorEmpresa_FiltroWeb(value.trim());
                Destinoadquisicion service = lst.isEmpty()?null:lst.get(0);
                return service;
            } catch(Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversión Error", "Not a valid clieprov."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Destinoadquisicion) object).getIddestino());
        }
        else {
            return null;
        }
    }
    
}
