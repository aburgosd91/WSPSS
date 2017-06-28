/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.listener;

import com.nisira.core.EConexion;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Usuario;
import com.nisira.core.util.Encryption;
import com.pe.nisira.movil.view.util.Constantes;
import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ViewHandler;
import javax.faces.application.ViewHandlerWrapper;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antenor
 */
public class SeguridadViewHandler extends ViewHandlerWrapper {
    private ViewHandler parent;

    public SeguridadViewHandler(ViewHandler parent) {
        this.parent = parent;
    }

    @Override
    public ViewHandler getWrapped() {
        return parent;
    }

    //En este metodo es donde podemos validar acceso a los menus de opciones
    @Override
    public UIViewRoot createView(FacesContext context, String viewId) {
        log.info(":::::::::::::::::: CREANDO LA VISTA ::::::::::::::::::");
        this.validaVista(context, viewId);
        return super.createView(context, viewId);
    }

    private void validaVista(FacesContext context, String viewId) {
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        
        String vista = viewId.substring(1, viewId.lastIndexOf("."));
        log.info("Vista: " + vista);
        if (!vista.equalsIgnoreCase("index") && !vista.equalsIgnoreCase("sistema/Expulsado")&& !vista.equalsIgnoreCase("indexm")) {
            if (session == null || session.getAttribute(Constantes.SESION_USUARIO) == null) {
                sendRedirect(context, "index.xhtml");
            }  else {
                session.setMaxInactiveInterval(60 * 60000);/*1 hora activo -> 60 * 60000(1min) */
                if (vista.equalsIgnoreCase("sistema/CerrarSesion")) {
                    session.invalidate();
                    sendRedirect(context, "index.xhtml");
                }
            }
        }
    }

    private void sendRedirect(FacesContext context, String ruta) {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            context.responseComplete();
            log.info(context.getExternalContext().getRequestContextPath() + "/" + ruta);
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "/" + ruta);
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }
    
}
