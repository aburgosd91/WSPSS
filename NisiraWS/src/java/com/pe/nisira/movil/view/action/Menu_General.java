package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.util.menuDao;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

import org.primefaces.model.menu.*;

@ManagedBean(name = "menu_general")
@SessionScoped
public class Menu_General implements Serializable {

    private MenuModel model;
    private List<String[]> lista_tg30wbmodulo;
    private List<String[]> lista_sucursales;
    private List<String[]> lista_empresas;
    private String idclieprovEmpresa="";
    private String idmodulogeneral = "";
    private String idsucursalgeneral = "";
    private String idsucursalgeneral_dsc = "";
    private String idempresageneral = "";
    private String idUsuarioLogin = ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getIDUSUARIO().trim();
    private HttpSession session;
    /*SESSION CONTROL*/
    public void onIdle() {
        /*SESSION ACTIVA*/
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
//                                        "No activity.", "What are you doing over there?"));
    }
    public void onActive() {
        /*SESSION TERMINA*/
        RequestContext.getCurrentInstance().execute("PF('sessionTimeOutDialog').show()");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "Welcome Back", "Well, that's a long coffee break!"));
    }
    public void asignarModulo() {
        Constantes.setIDMODULOGENERAL(idmodulogeneral);
    }
     public void asignarSucursal() throws IOException {
        Constantes.setIDSUCURSALGENERAL(idsucursalgeneral);
        WebUtil.setObjetoSesion(Constantes.NEWIDSUCURSALGENERAL, idsucursalgeneral);
        
        System.out.println(WebUtil.getObjetoSesion(Constantes.NEWIDSUCURSALGENERAL).toString());
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        ctx.redirect(ctxPath + "/faces/sistema/principal.xhtml");
       
    }
     public void asignarEmpresa() throws IOException { 
        Constantes.setIDEMPRESAGENERAL(idempresageneral);
        WebUtil.setObjetoSesion(Constantes.NEWIDEMPRESAGENERAL, idempresageneral);
        
         ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
         String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
          ctx.redirect(ctxPath + "/faces/sistema/principal.xhtml");
    }
    

    public void llenarModulo() throws Exception {
        this.lista_tg30wbmodulo = new ArrayList<String[]>();
        lista_tg30wbmodulo = new menuDao().buscar_tg30wbmodulo(idUsuarioLogin.trim());
    }
    
    public void llenarSucursales() throws Exception {
        if(lista_sucursales == null){
            this.lista_sucursales = new ArrayList<String[]>();
            lista_sucursales = new menuDao().buscar_sucursal(idUsuarioLogin.trim());
            if(!lista_sucursales.isEmpty()){
               // WebUtil.setObjetoSesion(Constantes.NEWIDSUCURSALGENERAL, lista_sucursales.get(0)[0]);
               Constantes.setIDSUCURSALGENERAL(lista_sucursales.get(0)[0]);
            }
        }
        RequestContext.getCurrentInstance().update("formtema");
    }
    
    public void llenarEmpresas() throws Exception {
        if(lista_empresas == null){
            this.lista_empresas = new ArrayList<String[]>();
            lista_empresas = new menuDao().buscar_empresa(idUsuarioLogin.trim());
            if(!lista_empresas.isEmpty()){
             //   WebUtil.setObjetoSesion(Constantes.NEWIDEMPRESAGENERAL, lista_empresas.get(0)[0]);
                Constantes.setIDEMPRESAGENERAL(lista_empresas.get(0)[0]);
                idclieprovEmpresa = lista_empresas.get(0)[2];
            }
        }
    }
    
    public String idsucursal_dsc(){
        String idconstantes = Constantes.getIDSUCURSALGENERAL();     
        for(String[] s: lista_sucursales)
        {
            if(s[0].equalsIgnoreCase(Constantes.getIDSUCURSALGENERAL()))
                 return s[1];
        }
        return "";
    }

    public Menu_General() throws Exception {
        this.session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        llenarModulo();
        model = new DefaultMenuModel();
        DefaultMenuItem item_ = new DefaultMenuItem("");
        //  item_.setUrl(s[5]);
        item_.setIcon("ui-icon-home");
//        item_.setCommand(s[6]);
//        item_.setAjax(false);
        item_.setStyle("margin-left: 120px");
        model.addElement(item_);
        DefaultSubMenu item_2 = new DefaultSubMenu("Modulos");
        for(String[] sarr: lista_tg30wbmodulo){
            DefaultMenuItem sub = new DefaultMenuItem(sarr[1]);
            sub.setCommand("#{menu_general.llenarMenu('" +sarr[0]+ "')}");
            sub.setAjax(true);
            sub.setUpdate("nav:mb");
            item_2.addElement(sub);
        }
        model.addElement(item_2);
    }

    public void llenarMenu(String idmodulo) throws Exception {
        UsuarioBean u = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        Constantes.setIDMODULOGENERAL(idmodulo); //modificar
        model = new DefaultMenuModel();
        List<String[]> acc = new  ArrayList<String[]>();
        DefaultMenuItem item_ = new DefaultMenuItem("");
          item_.setUrl("principal.xhtml");
        item_.setIcon("ui-icon-home");
//        item_.setCommand(s[6]);
//        item_.setAjax(false);
        item_.setStyle("margin-left: 120px");
        model.addElement(item_);
        DefaultSubMenu item_2 = new DefaultSubMenu("Modulos");
        for(String[] sarr: lista_tg30wbmodulo){
            DefaultMenuItem sub = new DefaultMenuItem(sarr[1]);
            sub.setCommand("#{menu_general.llenarMenu('" +sarr[0]+ "')}");
            sub.setAjax(true);
            sub.setUpdate("nav:mb");
            item_2.addElement(sub);
        }
        model.addElement(item_2);
        List<String[]> submenu = new menuDao().buscar_contenido_pagina_menu("PG_CABECERA", 
                Constantes.IDMODULOGENERAL,u.getIDUSUARIO(), null);
      //  List<String[]> submenu = new menuDao().buscar_contenido_pagina_menu_prib("PG_CABECERA", 
         //       Constantes.IDMODULOGENERAL, null,null);
        for (String[] s : submenu) {
            if (s[10].equalsIgnoreCase("1")) {
                DefaultSubMenu Submenu = _submenu(s[0], s[2]);
                Submenu.setStyleClass(s[9]);
                Submenu.setIcon(s[4]);

                model.addElement(Submenu);
            } else {
                DefaultMenuItem item = new DefaultMenuItem(s[2]);
                item.setUrl(s[5]);
                item.setIcon(s[4]);
                item.setCommand(s[6]);
                item.setAjax(false);
                item.setStyleClass(s[9]);
                model.addElement(item);
            }
        }
        acc = new menuDao().buscar_contenido_pagina_acc(Constantes.IDMODULOGENERAL);
        ((UsuarioBean)WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).setAccess(acc);
    }

    public DefaultSubMenu _submenu(String idmenu, String titulo) throws Exception {
        DefaultSubMenu firstSubmenu = new DefaultSubMenu(titulo);
        UsuarioBean u = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        List<String[]> submenu = new menuDao().buscar_contenido_pagina_menu("PG_CABECERA", Constantes.IDMODULOGENERAL,u.getIDUSUARIO(), idmenu);
        //List<String[]> submenu = new menuDao().buscar_contenido_pagina_menu_prib("PG_CABECERA", Constantes.IDMODULOGENERAL, idmenu,u.getIdusuario());
        for (String[] s : submenu) {
            boolean tieneAcceso = false;
            if(s[5]==null || Constantes.ESADMINISTRADOR==true){
                tieneAcceso = true;                
            }
//            else{
//                for (Privilegio objeto : Constantes.arrayPrivilegios) {
//                    if (objeto.getVENTANA().compareToIgnoreCase(s[5].trim())==0 && 
//                            (objeto.isNUEVO() || objeto.isEDITAR() || objeto.isCAMBIO_ESTADO() || objeto.isBORRAR() || objeto.isCONSULTAR() || objeto.isIMPRIMIR_EXPORTAR())){
//                        tieneAcceso=true;  
//                        break;
//                    }
//                }
//            }
            if(s[2]!=null){
                if(s[2].equalsIgnoreCase("/-")){
                    DefaultSeparator Submenu = new DefaultSeparator();
                    firstSubmenu.addElement(Submenu);                    
                    tieneAcceso = false;
                }
            }
            
//            if (tieneAcceso){
            if (s[10].equalsIgnoreCase("1")) {
                DefaultSubMenu Submenu = _submenu(s[0], s[2]);                    
                firstSubmenu.setStyleClass(s[9]);
                Submenu.setIcon(s[4]);
                firstSubmenu.addElement(Submenu);
            } else {
                DefaultMenuItem item = new DefaultMenuItem(s[2]);
                item.setUrl(s[5]);
                item.setIcon(s[4]);
                firstSubmenu.setStyleClass(s[9]);
                firstSubmenu.addElement(item);                
            }
//            }            
        }
        return firstSubmenu;
    }
    
    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Data saved");
    }

    public void update() {
        addMessage("Data updated");
    }

    public void delete() {
        addMessage("Data deleted");
    }

    public String redirect() {
        return "home?faces-redirect=true";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<String[]> getLista_tg30wbmodulo() {
        return lista_tg30wbmodulo;
    }

    public void setLista_tg30wbmodulo(List<String[]> lista_tg30wbmodulo) {
        this.lista_tg30wbmodulo = lista_tg30wbmodulo;
    }

    public List<String[]> getLista_empresas() {
        return lista_empresas;
    }

    public void setLista_empresas(List<String[]> lista_empresas) {
        this.lista_empresas = lista_empresas;
    }

    public List<String[]> getLista_sucursales() {
        return lista_sucursales;
    }

    public void setLista_sucursales(List<String[]> lista_sucursales) {
        this.lista_sucursales = lista_sucursales;
    }

    
    public String getIdmodulogeneral() {
        return idmodulogeneral;
    }

    public void setIdmodulogeneral(String idmodulogeneral) {
        this.idmodulogeneral = idmodulogeneral;
    }

    public String getIdempresageneral() {
        return idempresageneral;
    }

    public void setIdempresageneral(String idempresageneral) {
        this.idempresageneral = idempresageneral;
    }

    public String getIdsucursalgeneral() {
        return idsucursalgeneral;
    }

    public void setIdsucursalgeneral(String idsucursalgeneral) {
        this.idsucursalgeneral = idsucursalgeneral;
    }

    public String getIdUsuarioLogin() {
        return idUsuarioLogin.trim();
    }

    public void setIdUsuarioLogin(String idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getIdsucursalgeneral_dsc() {
        return idsucursalgeneral_dsc;
    }

    public void setIdsucursalgeneral_dsc(String idsucursalgeneral_dsc) {
        this.idsucursalgeneral_dsc = idsucursalgeneral_dsc;
    }

    public String getIdclieprovEmpresa() {
        return idclieprovEmpresa;
    }

    public void setIdclieprovEmpresa(String idclieprovEmpresa) {
        this.idclieprovEmpresa = idclieprovEmpresa;
    }

    /**
     * @return the session
     */
    public HttpSession getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(HttpSession session) {
        this.session = session;
    }
    

}
