/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Usuario;
import com.pe.nisira.movil.view.util.Encryption;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "usuarioAction")
@SessionScoped
public class UsuarioAction extends AbstactListAction<Usuario> implements Serializable {
    private UsuarioDao usuDao;
    private boolean edic;
    public UsuarioAction() {
        usuDao =new UsuarioDao();
        actualiza_ventana("wMnt_Usuario");
    }
    
    @Override
    public void buscarTodo() {
        try {
            setListaDatos(usuDao.listar());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doNuevo() throws IOException {
        nuevo();
        pag_acceso(getEdt_name());
        setLadd(1);
        edic=true;
        
    }
    @Override
    public void doEditar() {
        setLadd(2);
        edic = false;
    }
    @Override
    public void doEditar_lista() throws IOException {
        if (getDatoSeleccionado() == null) {
            WebUtil.MensajeAdvertencia("Debe seleccionar registro a editar.");

        } else {
            setDatoEdicion(getDatoSeleccionado());
            pag_acceso(getEdt_name());
            setLadd(1);
            edic = false;
        }
    }
    @Override
    public String getIniciar() {
        usuDao =new UsuarioDao();
        actualiza_ventana("wMnt_Usuario");
        return null;
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Usuario());
        getDatoEdicion().setEstado(1);
    }

    @Override
    public void grabar() {
        try {
            String cryp = Encryption.encrypt(getDatoEdicion().getPassword());
            getDatoEdicion().setPassword(cryp);
            usuDao.insertar(getDatoEdicion());
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isEdic() {
        return edic;
    }

    public void setEdic(boolean edic) {
        this.edic = edic;
    }

    @Override
    public String buscarFiltro(int tipo) {
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
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
