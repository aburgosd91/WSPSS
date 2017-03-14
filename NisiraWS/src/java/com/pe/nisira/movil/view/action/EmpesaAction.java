/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.entity.Empresa;
import com.nisira.core.util.ConstantesBD;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;

/**
 *
 * @author azamora
 */
@ManagedBean(name = "empresaAction")
@SessionScoped
public class EmpesaAction extends AbstactListAction<Empresa> implements Serializable {

    private EmpresaDao empresadao;
    private String mensaje;

    public EmpesaAction() {
        empresadao = new EmpresaDao();
        mensaje = "";
    }

    @Override
    public void buscarTodo() {
        actualiza_ventana("wMnt_Empresas");
        try {
//            setListaDatos(empresadao.findByEmpresasMovil(ConstantesBD.getBDCONECCION()));
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public String getIniciar() {
        empresadao = new EmpresaDao();
        mensaje = "";
        return "";
    }

    @Override
    public void nuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void grabar() {
        try {
//            empresadao.updateEmpres(getDatoEdicion());
        } catch (Exception ex) {
            this.setMensaje(ex.toString());
        }
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar() {
        setLadd(1);
        setDatoEdicion(getDatoSeleccionado());
        RequestContext.getCurrentInstance().update("datos:empresaEdt");
        RequestContext.getCurrentInstance().execute("PF('empresaEdt').show()");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
