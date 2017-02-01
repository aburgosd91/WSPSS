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
            if(vista.indexOf("http")!=-1){
                try {
                    /*SINCRONIZACION POR URL*/
                    Map<String,String> params = context.getExternalContext().getRequestParameterMap();
                    String usuario=Encryption.decrypt(params.get("usuario")!=null?params.get("usuario"):"");
                    String pass=(params.get("password")!=null?params.get("password"):"");
                    List<Usuario> lst= (new UsuarioDao()).listar("IDUSUARIO = ? AND PASSWORD=? AND ESTADO=1", usuario,pass); 
                    Usuario user=null;
                    if(lst!=null)
                        user=lst.get(0);
                    if(user==null)
                        sendRedirect(context, "index.xhtml");
                } catch (Exception ex) {
                    Logger.getLogger(SeguridadViewHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if (session == null || session.getAttribute(Constantes.SESION_USUARIO) == null) {
                    sendRedirect(context, "index.xhtml");
                }  else {
                    session.setMaxInactiveInterval(10 * 60000);
                    if(!vista.equalsIgnoreCase("index") || !vista.equalsIgnoreCase("sistema/CerrarSesion") || !vista.equalsIgnoreCase("sistema/Expulsado") || !vista.equalsIgnoreCase("indexm")){
    //                    Boolean monitorvalidado  =ValidarMonitor();
    //                    monitorvalidado = true;
    //                    if(monitorvalidado){
    //                        System.out.println("EN EL SEGURIDAD HEANDER " +ValidarMonitor());
    //                    }else{
    //                    session.invalidate();
    //                    System.out.println("EN EL SEGURIDAD HEANDER negativo " +ValidarMonitor());
    //                    sendRedirect(context, "sistema/Expulsado.xhtml");
    //                    }
                    }
                    if (vista.equalsIgnoreCase("sistema/CerrarSesion")) {
                        session.invalidate();
                        sendRedirect(context, "index.xhtml");

                    }
                }
            }
            
        }
        
    }

    public boolean ValidarMonitor(){
        boolean validar=false;
        try {
//            validar = new UsuarioDao().validarMonitor(Constantes.getIDSESION());
        } catch (Exception ex) {
            log.error(ex, ex);
        }
        return validar;
    }
    
    private void sendRedirect(FacesContext context, String ruta) {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            context.responseComplete();
            log.info(context.getExternalContext().getRequestContextPath() + "/faces/" + ruta);
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "/faces/" + ruta);
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }
    
}
