/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;


import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.Table_rpt_liquidacion_pssDao;

import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Table_rpt_liquidacion_pss;

import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "table_rpt_liquidacion_pssAction")
@SessionScoped
public class Table_rpt_liquidacion_pssAction extends AbstactListAction<Table_rpt_liquidacion_pss> {

    /*********************************LISTAS*******************************************/
    private List<Table_rpt_liquidacion_pss> selectListTable_rpt_liquidacion_pss;
    /*************************************DAO***************************************/
    private Table_rpt_liquidacion_pssDao table_rpt_liquidacion_pssDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String numero;
    private String mensaje;
   
    public Table_rpt_liquidacion_pssAction() {
        selectListTable_rpt_liquidacion_pss = new ArrayList<Table_rpt_liquidacion_pss>();
        table_rpt_liquidacion_pssDao = new Table_rpt_liquidacion_pssDao();
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        numero = "";
        mensaje = "";
        actualiza_ventana("wMnt_Table_rpt_liquidacion_pss");
    }

    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Table_rpt_liquidacion_pssAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        actualiza_ventana("wMnt_Ordenserviciocliente_cerrado");
        return "";
    }

    @Override
    public void nuevo() {
    }

    @Override
    public void grabar() {
       
    }

    @Override
    public void eliminar() {
        
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(table_rpt_liquidacion_pssDao.listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }
    @Override
    public void cerrar() {
        try {
            if(!selectListTable_rpt_liquidacion_pss.isEmpty()){
//                this.mensaje = getOrdenservicioclienteDao().cierreMasivo(1,getSelectListOrdenserviciocliente());
                setMensaje(WebUtil.exitoRegistrar("Orden Servicio ", mensaje));
                WebUtil.info(getMensaje());
//                setSelectListOrdenserviciocliente(new ArrayList<>());
                buscarFiltro(2);
            }else{
                this.mensaje = "Seleccionar Documento";
                WebUtil.MensajeError(this.mensaje);
            }
        } catch (Exception ex) {
            Logger.getLogger(Table_rpt_liquidacion_pssAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.MensajeError(ex.getMessage());
        }
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    @Override
    public String buscarFiltro(int tipo){
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(table_rpt_liquidacion_pssDao.listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Table_rpt_liquidacion_pss");
        return "";
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the selectListTable_rpt_liquidacion_pss
     */
    public List<Table_rpt_liquidacion_pss> getSelectListTable_rpt_liquidacion_pss() {
        return selectListTable_rpt_liquidacion_pss;
    }

    /**
     * @param selectListTable_rpt_liquidacion_pss the selectListTable_rpt_liquidacion_pss to set
     */
    public void setSelectListTable_rpt_liquidacion_pss(List<Table_rpt_liquidacion_pss> selectListTable_rpt_liquidacion_pss) {
        this.selectListTable_rpt_liquidacion_pss = selectListTable_rpt_liquidacion_pss;
    }

    /**
     * @return the table_rpt_liquidacion_pssDao
     */
    public Table_rpt_liquidacion_pssDao getTable_rpt_liquidacion_pssDao() {
        return table_rpt_liquidacion_pssDao;
    }

    /**
     * @param table_rpt_liquidacion_pssDao the table_rpt_liquidacion_pssDao to set
     */
    public void setTable_rpt_liquidacion_pssDao(Table_rpt_liquidacion_pssDao table_rpt_liquidacion_pssDao) {
        this.table_rpt_liquidacion_pssDao = table_rpt_liquidacion_pssDao;
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}