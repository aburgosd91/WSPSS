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
@ManagedBean(name = "privilegioEdtMenuAction")
@ViewScoped
public class PrivilegioEdtMenuAction {
    private TreeNode patriarca;
    private TreeNode nodoSeleccionado;
    private Object[] nodoS = new Object[7];
    private String tipo_arbol;
    private String idusuario;
    private String idempresa;
    private List<String[]> lista_tg30wbmodulo;
    private List<String[]> lista_usuario;
    private List<Object[]> lista_seleccion;
    private List<String> catalogoXHTML;

    public PrivilegioEdtMenuAction() throws Exception {
        nodoSeleccionado = new DefaultTreeNode();
        this.lista_usuario = new ArrayList<String[]>();
        lista_usuario.clear();
        this.lista_seleccion = new ArrayList<Object[]>();
        lista_seleccion.clear();
        UsuarioBean u = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        this.idempresa= u.getIDEMPRESA();
        lista_usuario = new menuDao().buscar_wbprivilegio_usuario();
    }
    public void llenarModulo() throws Exception{
        this.lista_tg30wbmodulo = new ArrayList<String[]>();
        lista_tg30wbmodulo.clear();
        lista_tg30wbmodulo = new menuDao().buscar_wbmodulo_usuario(idusuario,idempresa);
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
    public void onNodeSelect(NodeSelectEvent event) throws Exception {
        nodoS = (Object[]) event.getTreeNode().getData();
        buscar_wbprivilegio_modulo(Integer.parseInt(nodoS[0].toString()));
    }
    private void buscar_wbprivilegio_modulo(int idcont) throws Exception {
        lista_seleccion.clear();
        UsuarioBean u = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        lista_seleccion = new menuDao().buscar_wbprivilegio_menu(idcont,idusuario,idempresa);
    }
    
    public void grabar_tg30wbmenu() throws Exception {

        new menuDao().grabar_web_usuario_Menu(idusuario,nodoS[0] ,lista_seleccion);
        WebUtil.MensajeAlerta("Registros actualizados");
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

    public String getTipo_arbol() {
        return tipo_arbol;
    }

    public void setTipo_arbol(String tipo_arbol) {
        this.tipo_arbol = tipo_arbol;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public List<String[]> getLista_tg30wbmodulo() {
        return lista_tg30wbmodulo;
    }

    public void setLista_tg30wbmodulo(List<String[]> lista_tg30wbmodulo) {
        this.lista_tg30wbmodulo = lista_tg30wbmodulo;
    }

    public List<String[]> getLista_usuario() {
        return lista_usuario;
    }

    public void setLista_usuario(List<String[]> lista_usuario) {
        this.lista_usuario = lista_usuario;
    }  

    public List<Object[]> getLista_seleccion() {
        return lista_seleccion;
    }

    public void setLista_seleccion(List<Object[]> lista_seleccion) {
        this.lista_seleccion = lista_seleccion;
    }
    
}
