/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "moduloEdtAction")
@ViewScoped
public class moduloEdtAction implements Serializable {

    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private String[] nodoS = new String[7];
    private String tipo_arbol;
    private List<String[]> lista_tg30wbmodulo;
    private List<String> catalogoXHTML;

    public moduloEdtAction() throws Exception {
        nodoSeleccionado = new DefaultTreeNode();
        this.lista_tg30wbmodulo = new ArrayList<String[]>();
        lista_tg30wbmodulo.clear();
    }

    public void llenarArbol() throws Exception {
        nodoS = new String[7];
        patriarca = new DefaultTreeNode("Patriarca", null);
        List<String[]> listaContenidos = new menuDao().buscar_tg30wbmodulo_all2();
        List<String[]> listaPadres = new ArrayList<String[]>();
        for (String[] cont : listaContenidos) {
                listaPadres.add(cont);
        }
        for (String[] pad : listaPadres) {
            TreeNode padre = new DefaultTreeNode(pad, patriarca);
        }
    }


    public void grabar_tg30wbmodulo() throws Exception {
        if (nodoS[0] == null || nodoS[0].isEmpty()) {
            WebUtil.MensajeAlerta("Item registrado.");
        } else {
            WebUtil.MensajeAlerta("Item actualizado.");
        }
        new menuDao().grabar_tg30wbmodulo(nodoS);

    }
    public void nuevo_contenido_pagina_productos() throws Exception {

        nodoS = new String[7];
//        if (tipo_arbol.equalsIgnoreCase("MENU")) {
//            nodoS[2] = "MENU_GENERAL";      
//        } else if (tipo_arbol.equalsIgnoreCase("DESCRIPCION")) {
//            nodoS[2] = "DESCRIPCION";
//        } 
//        else     
//        {
//            nodoS[2] = "CONT_TAG_TITULO";
//        }
        nodoS[3] = "1";
    }


     public void borrar_contenido_pagina_productos() throws Exception {
        // idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu

         if (nodoS == null)
         {
             WebUtil.MensajeError("Seleccione contenido");
         }else{
             new menuDao().borrar_contenido_mdoulo(nodoS);
         }
     

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

    public List<String[]> getLista_tg30wbmodulo() {
        return lista_tg30wbmodulo;
    }

    public void setLista_tg30wbmodulo(List<String[]> lista_tg30wbmodulo) {
        this.lista_tg30wbmodulo = lista_tg30wbmodulo;
    }
    
    
}
