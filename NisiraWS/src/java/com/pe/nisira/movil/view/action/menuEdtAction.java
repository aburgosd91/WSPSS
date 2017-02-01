package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.util.Constantes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import com.pe.nisira.movil.view.util.menuDao;
import com.pe.nisira.movil.view.util.WebUtil;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author jcuzco
 */
@ManagedBean(name = "menuEdtAction")
@ViewScoped
public class menuEdtAction implements Serializable {

    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private String[] nodoS = new String[19];
    private String tipo_arbol;
    private List<String[]> lista_tg30wbmodulo;
    private List<String> catalogoXHTML;
    public menuEdtAction() throws Exception {
        nodoSeleccionado = new DefaultTreeNode();
        this.lista_tg30wbmodulo = new ArrayList<String[]>();
        lista_tg30wbmodulo.clear();
        lista_tg30wbmodulo = new menuDao().buscar_tg30wbmodulo_all();
    }
    public void llenarCatalogo() throws Exception{
        List<String> lista=new ArrayList<String>();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        lista.add((String) servletContext.getRealPath("sistema"));
        catalogoXHTML=Constantes.catalagoXHTML(lista);
    }
    
    public void llenarArbol() throws Exception {
        nodoS = new String[19];
        if (tipo_arbol == null) {
            tipo_arbol = "0000";
        }
        patriarca = new DefaultTreeNode("Patriarca", null);
        List<String[]> listaContenidos = new menuDao().buscar_tg30wbmenu_edt(tipo_arbol);
        List<String[]> listaPadres = new ArrayList<String[]>();
        for (String[] cont : listaContenidos) {
            if (cont[1] == null) {
                listaPadres.add(cont);
            }
        }
        for (String[] pad : listaPadres) {
            TreeNode padre = new DefaultTreeNode(pad, patriarca);
            List<String[]> listahijos = buscarhijos(pad, listaContenidos);
            llenarramas(listahijos, padre, listaContenidos);
        }
    }

    public void llenarramas(List<String[]> hijos, TreeNode padre, List<String[]> listaContenidos) {
        for (String[] e : hijos) {
            TreeNode hijo = new DefaultTreeNode(e, padre);
            List<String[]> listahijos = buscarhijos(e, listaContenidos);
            if (listahijos.size() > 0) {
                llenarramas(listahijos, hijo, listaContenidos);
            }
        }
    }
    public List<String[]> buscarhijos(String[] padre, List<String[]> listaContenidos) {
        List<String[]> lista = new ArrayList<String[]>();
        for (String[] cont : listaContenidos) {
            if (cont[1] != null) {
                if (cont[1].equalsIgnoreCase(padre[0])) {
                    lista.add(cont);
                }
            }
        }
        return lista;
    }

    public void nuevo_contenido_pagina_productos() throws Exception {

        nodoS = new String[19];
         nodoS[2] = tipo_arbol;
//        if (tipo_arbol.equalsIgnoreCase("MENU")) {
//            nodoS[2] = "MENU_GENERAL";      
//        } else if (tipo_arbol.equalsIgnoreCase("DESCRIPCION")) {
//            nodoS[2] = "DESCRIPCION";
//        } 
//        else     
//        {
//            nodoS[2] = "CONT_TAG_TITULO";
//        }
        nodoS[9] = "1";
        nodoS[10] = "1";
    }

    public void nuevo_Secundario_contenido_pagina_productos() throws Exception {
        // idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu

        String jerarquia = nodoS[0];
        String tipo = tipo_arbol ;
//        if (tipo_arbol.equalsIgnoreCase("MENU")) {
//            tipo = "MENU_GENERAL";
//        } else if (tipo_arbol.equalsIgnoreCase("DESCRIPCION")) {
//            tipo = "DESCRIPCION";
//        
//        }else  
//        {
//            tipo = nodoS[2].equalsIgnoreCase("CONT_TAG_TITULO") ? "CONT_TAG_TAG" : "CONT_TAG_PANEL";
//
//        }
        
        
        String pagina = nodoS[6];
        
        nodoS = new String[19];
        nodoS[1] = jerarquia;
        nodoS[2] = tipo;
        nodoS[6] = pagina;
        nodoS[9] = "1";
        nodoS[10] = "1";
    }
    
     public void borrar_contenido_pagina_productos() throws Exception {
        // idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu

         if (nodoS == null)
         {
             WebUtil.MensajeError("Seleccione contenido");
         }else{
             new menuDao().borrar_contenido_pagina_productos(nodoS);
         }
     

    }
    
    
    public String return_descripcion(String id) throws Exception{
        String dsc = null;
        List<String[]> listaContenidos = new menuDao().buscar_tg30wbmenu_edt(tipo_arbol);
        for (String[] s: listaContenidos)
        {
            if (s[0].equalsIgnoreCase(id))
                dsc=s[3];
        }
       return dsc;
    }

    public void grabar_tg30wbmenu() throws Exception {
        if(nodoS[0]== null || nodoS[0].isEmpty())
        {
              WebUtil.MensajeAlerta("Item registrado.");
        }else{
              WebUtil.MensajeAlerta("Item actualizado.");
        }
        new menuDao().grabar_tg30wbmenu(nodoS);
        
    }

    public void onNodeSelect(NodeSelectEvent event) {
        nodoS = (String[]) event.getTreeNode().getData();
    }

    public TreeNode getPatriarca() {
        return patriarca;
    }

    public void setPatriarca(TreeNode patriarca) {
        this.patriarca = patriarca;
    }

    public TreeNode getNodoSeleccionado() {
        return nodoSeleccionado;
    }

    public void setNodoSeleccionado(TreeNode nodoSeleccionado) {
        this.nodoSeleccionado = nodoSeleccionado;
    }

    public String[] getNodoS() {
        return nodoS;
    }

    public void setNodoS(String[] nodoS) {
        this.nodoS = nodoS;
    }

    public String getTipo_arbol() {
        return tipo_arbol;
    }

    public void setTipo_arbol(String tipo_arbol) {
        this.tipo_arbol = tipo_arbol;
    }

    public List<String[]> getLista_tg30wbmodulo() {
        return lista_tg30wbmodulo;
    }

    public void setLista_tg30wbmodulo(List<String[]> lista_tg30wbmodulo) {
        this.lista_tg30wbmodulo = lista_tg30wbmodulo;
    }

    /**
     * @return the catalogoXHTML
     */
    public List<String> getCatalogoXHTML() {
        return catalogoXHTML;
    }

    /**
     * @param catalogoXHTML the catalogoXHTML to set
     */
    public void setCatalogoXHTML(List<String> catalogoXHTML) {
        this.catalogoXHTML = catalogoXHTML;
    }
    
    
}
