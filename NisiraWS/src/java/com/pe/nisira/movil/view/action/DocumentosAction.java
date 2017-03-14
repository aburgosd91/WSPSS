/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Numemisor;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "documentosAction")
@SessionScoped
public class DocumentosAction extends AbstactListAction<Documentos> implements Serializable {

    private String mensaje;
    private DocumentosDao daoDocumentos;
    private NumemisorDao daoNumemisor;
    private List<Documentos> filtroDocumentos;
    private List<Numemisor> listNumemisor;
    private List<Numemisor> filtroNumemisor;
    private Numemisor selectNumemisor;
    private boolean botonEditar;
    private boolean botonEliminar;
    public UsuarioBean user;

    public DocumentosAction() {
        mensaje = "";
        daoDocumentos = new DocumentosDao();
        daoNumemisor = new NumemisorDao();
        listNumemisor = new ArrayList<Numemisor>();
        filtroDocumentos = new ArrayList<Documentos>();
        botonEditar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        actualiza_ventana("wMnt_ClieProv");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(daoDocumentos.listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(DocumentosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onRowSelectNumemisor(SelectEvent event) throws IOException {
        Documentos doc = ((Documentos) event.getObject());
        buscarDetalle(doc.getIddocumento());
    }
    public void buscarDetalle(String iddocumento){
        try {
            listNumemisor = daoNumemisor.listarPorDocWeb(user.getIDEMPRESA(),iddocumento);
            RequestContext.getCurrentInstance().update("datos:dlGuardarNumemisor");
            RequestContext.getCurrentInstance().execute("PF('dlGuardarNumemisor').show()");
        } catch (NisiraORMException ex) {
            Logger.getLogger(DocumentosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        mensaje = "";
        daoDocumentos = new DocumentosDao();
        botonEditar = false;
        botonEliminar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        filtroDocumentos = new ArrayList<Documentos>();
        actualiza_ventana("wMnt_Documentos");
        return "";
    }

    @Override
    public void nuevo() {
//        setDatoEdicion(new Documentos());        
//        getDatoEdicion().setIDEMPRESA(Integer.parseInt(user.getIDEMPRESA()));
//        getDatoEdicion().setIDSUCURSAL(Integer.parseInt(Constantes.getIDSUCURSALGENERAL()));
//        eventoSucursal();
//        getDatoEdicion().setESTADO(true);
//        tablaAlmacen = new ArrayList<TablaAlmacen>();
//        listDDocumentosAccesorio = new ArrayList<DDocumentosAccesorio>();
    }
    
    @Override
    public void grabar() {
        try {
//            if (getDatoEdicion().getDESCRIPCION().equals("")) {
////                WebUtil.MensajeAlerta("Ingrese Descripción");
//                this.setMensaje("Ingrese DESCRIPCION");
//            } else {                
//                if (getDatoEdicion().getIDZONA() == 0) {
//                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
//                    daoDocumentos.addDocumentosDetalle(getDatoEdicion(), tablaAlmacen, listDDocumentosAccesorio);
//                    WebUtil.info("Documentos " + getDatoEdicion().getDESCRIPCION() + " registrado con éxito.");
//
//                } else {                    
//                    getDatoEdicion().setCOLOR("#"+getDatoEdicion().getCOLOR());
//                    daoDocumentos.editDocumentosDetalle(getDatoEdicion(), tablaAlmacen, listDDocumentosAccesorio);
//                    WebUtil.info("Documentos " + getDatoEdicion().getDESCRIPCION() + " actualizado con éxito.");
//                }
//            }
        } catch (Exception ex) {
            Logger.getLogger(DocumentosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar() {
        try {
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
//                daoDocumentos.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 0);
//            }
//            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
//                daoDocumentos.anular(getDatoEdicion().getIDEMPRESA(), getDatoEdicion().getIDSUCURSAL(), getDatoEdicion().getIDZONA(), 2);
//            }
        } catch (Exception ex) {
            Logger.getLogger(DocumentosAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isBotonEditar() {
        return botonEditar;
    }

    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    public boolean isBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(boolean botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    /**
     * @return the filtroDocumentos
     */
    public List<Documentos> getFiltroDocumentos() {
        return filtroDocumentos;
    }

    /**
     * @param filtroDocumentos the filtroDocumentos to set
     */
    public void setFiltroDocumentos(List<Documentos> filtroDocumentos) {
        this.filtroDocumentos = filtroDocumentos;
    }

    /**
     * @return the daoNumemisor
     */
    public NumemisorDao getDaoNumemisor() {
        return daoNumemisor;
    }

    /**
     * @param daoNumemisor the daoNumemisor to set
     */
    public void setDaoNumemisor(NumemisorDao daoNumemisor) {
        this.daoNumemisor = daoNumemisor;
    }

    @Override
    public String buscarFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
