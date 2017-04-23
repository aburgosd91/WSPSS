/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.entity.Clieprov;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
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
@FacesConverter("personalConverter")
public class PersonalConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Clieprov service = (new ClieprovDao()).getEmpresa_Idclieprov(Constantes.IDEMPRESAGENERAL,value.trim());
                return service;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversión Error", "Not a valid personal."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Clieprov) object).getIdclieprov());
        }
        else {
            return null;
        }
    }
    
}
