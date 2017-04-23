/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Consumidor;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
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
@FacesConverter("consumidorConverter")
public class ConsumidorConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                Consumidor service = null;
                try {
                    service = (new ConsumidorDao()).getEmpresa_Idconsumidor(Constantes.IDEMPRESAGENERAL,value.trim());
                } catch (NisiraORMException ex) {
                    Logger.getLogger(ConsumidorConverter.class.getName()).log(Level.SEVERE, null, ex);
                }
                return service;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversión Error", "Not a valid consumidor."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Consumidor) object).getIdconsumidor());
        }
        else {
            return null;
        }
    }
    
}
