/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.pe.nisira.movil.view.util.menuDao;
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
@ManagedBean(name = "privilegioEdtModAction")
@ViewScoped
public class PrivilegioEdtModAction {

    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private Object[] nodoS = new Object[5];
    private String tipo_arbol;
    private List<Object[]> lista_seleccion;

    public PrivilegioEdtModAction() throws Exception {
        nodoSeleccionado = new DefaultTreeNode();
        this.lista_seleccion = new ArrayList<Object[]>();
        lista_seleccion.clear();
    }

    public void llenarArbol() throws Exception {

        nodoS = new Object[5];

        patriarca = new DefaultTreeNode("Patriarca", null);
        List<String[]> listaContenidos = new menuDao().buscar_wbprivilegio_usuario();
        List<String[]> listaPadres = new ArrayList<String[]>();
        for (String[] cont : listaContenidos) {
            //if (cont[1] == null) {
            listaPadres.add(cont);
            // }
        }

        for (String[] pad : listaPadres) {
            TreeNode padre = new DefaultTreeNode(pad, patriarca);
        //    List<String[]> listahijos = buscarhijos(pad, listaContenidos);
            //   llenarramas(listahijos, padre, listaContenidos);
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

    public void buscar_wbprivilegio_modulo(String idusuario) throws Exception {
        lista_seleccion.clear();
        UsuarioBean u = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lista_seleccion = new menuDao().buscar_wbprivilegio_modulo(idusuario,u.getIDEMPRESA());
    }

    public void grabar_tg30wbmenu() throws Exception {

        new menuDao().grabar_web_usuario_modulo(nodoS[0].toString(), lista_seleccion);
        WebUtil.MensajeAlerta("Registros actualizados");
    }

    public void onNodeSelect(NodeSelectEvent event) throws Exception {
        nodoS = (Object[]) event.getTreeNode().getData();
        buscar_wbprivilegio_modulo(nodoS[0].toString());

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

    public Object[] getNodoS() {
        return nodoS;
    }

    public void setNodoS(Object[] nodoS) {
        this.nodoS = nodoS;
    }

    public List<Object[]> getLista_seleccion() {
        return lista_seleccion;
    }

    public void setLista_seleccion(List<Object[]> lista_seleccion) {
        this.lista_seleccion = lista_seleccion;
    }
    
}
