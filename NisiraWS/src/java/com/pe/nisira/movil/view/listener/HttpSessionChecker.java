/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.listener;

import com.nisira.core.service.UsuarioService;
import com.pe.nisira.movil.view.util.Constantes;
import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Antenor
 */
@WebListener
public class HttpSessionChecker implements HttpSessionListener {

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.printf("Session ID %s created at %s%n", event.getSession().getId(), new Date());
        System.out.println(event.getSession().getId());
        Constantes.setIDSESION(event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
            System.out.printf("Session ID %s destroyed at %s%n", event.getSession().getId(), new Date());
            System.out.println("en el http " + Constantes.getIDSESION());
            eliminar();
            System.out.println("en el http " + Constantes.getIDSESION());

    }

    public String eliminar() {
        try {
            System.out.println("en el eliminar ");
            System.out.println("en el eliminar" + Constantes.getIDSESION());
        //    usuarioService.eliminarMonitor(Constantes.getIDSESION());
        } catch (Exception ex) {
//            log.error(ex, ex);
        }
        return "";
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
