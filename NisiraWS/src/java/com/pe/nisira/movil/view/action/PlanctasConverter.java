/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.PlanctasDao;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Planctas;
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
@FacesConverter("planctasConverter")
public class PlanctasConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                List<Planctas> lst = (new PlanctasDao()).listarPorEmpresa(Constantes.IDEMPRESAGENERAL,value.trim());
                Planctas service = lst.isEmpty()?null:lst.get(0);
                return service;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversión Error", "Not a valid personal."));
            } catch (NisiraORMException ex) {
                Logger.getLogger(PlanctasConverter.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Planctas) object).getIdcuenta());
        }
        else {
            return null;
        }
    }
    
}
