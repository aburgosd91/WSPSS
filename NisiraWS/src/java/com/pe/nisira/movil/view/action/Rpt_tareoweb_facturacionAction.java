/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
import com.nisira.core.dao.MotivosproduccionDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Wtiposervicio;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "rpt_tareoweb_facturacionAction")
@SessionScoped
public class Rpt_tareoweb_facturacionAction extends AbstactListAction<Ordenserviciocliente> {
    /*************************************ArrayList***************************************/
    private List<DataTableColumn> dataTableColumns;
    private List<Wtiposervicio> listWtiposervicio;
    private WtiposervicioDao wtiposervicioDao;
    /*************************************DAO***************************************/
    private OrdenservicioclienteDao ordenservicioclienteDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String mensaje;
    private Object[] selectRpt;
    private Object[] selectRpt_;
    private String idtiposervicio;
    private String[] lst_type_rpt;
    /************************************* CONTROLES *****************************************/
    private NSRResultSet rpt_result;
    private NSRResultSet rpt_result_resumido;
    private NSRResultSet rpt_result_detallado;
    private String type_formato_rpt;
    public Rpt_tareoweb_facturacionAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            mensaje = "";
            /*********************************LISTAS*******************************************/
            dataTableColumns = new ArrayList<>();
            listWtiposervicio = new ArrayList<>();
            /*********************************DAO**********************************************/
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            wtiposervicioDao = new WtiposervicioDao();
            /**********************************CONTROLADOR*************************************/
            listWtiposervicio = wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            /********************************** CONFIGURACIÓN - SERVIDOR ***********************/
            idtiposervicio = "002";
            type_formato_rpt = "Formato";
            lst_type_rpt= new String[2];
            lst_type_rpt[0]="Formato";
            lst_type_rpt[1]="Detallado";
        }catch (Exception ex) {
            Logger.getLogger(Rpt_tareoweb_facturacionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiza_ventana("wMnt_Rpt_tareoweb_facturacion");
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Rpt_tareoweb_facturacionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        setMensaje("");
        /**********************************CONTROLADOR********************************/
        /**********************************CONFIGURACIÓN - SERVIDOR********************************/
        actualiza_ventana("wMnt_Rpt_tareoweb_facturacion");
        return "";
    }

    @Override
    public void nuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void grabar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void findetalle() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
 
    public void buscar_filtrofecha() {
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            if(getType_formato_rpt().trim().equals("Formato")){
                setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_facturacion(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            }else if(getType_formato_rpt().trim().equals("Detallado")){
                setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_facturacion_detallado(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            }
            setRpt_result_resumido(getOrdenservicioclienteDao().getConsultaRepote_facturacion(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            setRpt_result_detallado(getOrdenservicioclienteDao().getConsultaRepote_facturacion_detallado(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tab");
        return;
    }
    public void onTiposervicio(){
        
    }
    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }


    @Override
    public String buscarFiltro(int tipo){
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            if(getType_formato_rpt().trim().equals("Formato")){
                setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_facturacion(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            }else if(getType_formato_rpt().trim().equals("Detallado")){
                setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_facturacion_detallado(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            }
            setRpt_result_resumido(getOrdenservicioclienteDao().getConsultaRepote_facturacion(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            setRpt_result_detallado(getOrdenservicioclienteDao().getConsultaRepote_facturacion_detallado(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio));
            //setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tab");
        if(tipo == 2)
            lista_accion_filtro("wLst_Rpt_tareoweb_facturacion");
        return "";
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
    public void downFormatExcelEspecial(Object document) {
        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,"FORMATO_ "+WebUtil.fechaDMY(new Date(),1));
        HSSFRow fila_cabecera = objWB.getSheetAt(0).getRow(0);

        HSSFFont fuente = objWB.createFont();
        fuente.setFontHeightInPoints((short) 8);
        fuente.setFontName("Calibre LIght");
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFCellStyle estiloCelda = objWB.createCellStyle();
        estiloCelda.setWrapText(true);
        estiloCelda.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setFont(fuente);
        estiloCelda.setWrapText(true);
        estiloCelda.setFillForegroundColor((short) 22);
        estiloCelda.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//Filas           
        HSSFFont fuenteFilas = objWB.createFont();
        fuenteFilas.setFontHeightInPoints((short) 8);
        fuenteFilas.setFontName("Calibre LIght");

        HSSFCellStyle estiloFila = objWB.createCellStyle();
        estiloFila.setWrapText(true);
        estiloFila.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila.setFont(fuente);

        int col = rpt_result_resumido.columnCount();
        int row = rpt_result_resumido.getData().size();
        HSSFCell celda;
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            celda.setCellValue(rpt_result_resumido.getName()[i]);
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).getRow(i+1);
            for(int j=0;j<col;j++){
                celda = fila.createCell((short)j);
                celda.setCellStyle(estiloFila);
                celda.setCellValue( rpt_result_resumido.getData().get(i)[j]==null?"":rpt_result_resumido.getData().get(i)[j].toString());
            }
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
        /*CREAR OTRA HOJA RESUMIDO*/
        HSSFSheet sheet1 = objWB.createSheet("DETALLADO_ "+WebUtil.fechaDMY(new Date(),1));
        fila_cabecera = sheet1.createRow((short)0);

        col = rpt_result_detallado.columnCount();
        row = rpt_result_detallado.getData().size();
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            celda.setCellValue(rpt_result_detallado.getName()[i]);
        }
        for(int i=0;i<row;i++){
            fila = sheet1.createRow(i+1);
            for(int j=0;j<col;j++){
                celda = fila.createCell((short)j);
                celda.setCellStyle(estiloFila);
                celda.setCellValue( rpt_result_detallado.getData().get(i)[j]==null?"":rpt_result_detallado.getData().get(i)[j].toString());
            }
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(1).autoSizeColumn((short) as);
        }
    }
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 2);
        else
            return "";
    }
    
    public String formatObjectMask(int col){
        String mask="";
        switch(col){
            case 0:;break;
            case 1:;break;
            case 2:;break;
            case 3:mask="";break;
        }
        return mask;
    }
    public boolean formatObjectDissable(int col){
        boolean t=false;
        switch(col){
            case 0:t=true;break;
            case 1:t=true;break;
            case 2:t=true;break;
            default : t=false;
        }
        return t;
    }
    /**
     * @return the ordenservicioclienteDao
     */
    public OrdenservicioclienteDao getOrdenservicioclienteDao() {
        return ordenservicioclienteDao;
    }

    /**
     * @param ordenservicioclienteDao the ordenservicioclienteDao to set
     */
    public void setOrdenservicioclienteDao(OrdenservicioclienteDao ordenservicioclienteDao) {
        this.ordenservicioclienteDao = ordenservicioclienteDao;
    }

    /**
     * @return the rpt_result
     */
    public NSRResultSet getRpt_result() {
        return rpt_result;
    }

    /**
     * @param rpt_result the rpt_result to set
     */
    public void setRpt_result(NSRResultSet rpt_result) {
        this.rpt_result = rpt_result;
    }

    /**
     * @return the selectRpt
     */
    public Object[] getSelectRpt() {
        return selectRpt;
    }

    /**
     * @param selectRpt the selectRpt to set
     */
    public void setSelectRpt(Object[] selectRpt) {
        this.selectRpt = selectRpt;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the dataTableColumns
     */
    public List<DataTableColumn> getDataTableColumns() {
        return dataTableColumns;
    }

    /**
     * @param dataTableColumns the dataTableColumns to set
     */
    public void setDataTableColumns(List<DataTableColumn> dataTableColumns) {
        this.dataTableColumns = dataTableColumns;
    }

    /**
     * @return the listWtiposervicio
     */
    public List<Wtiposervicio> getListWtiposervicio() {
        return listWtiposervicio;
    }

    /**
     * @param listWtiposervicio the listWtiposervicio to set
     */
    public void setListWtiposervicio(List<Wtiposervicio> listWtiposervicio) {
        this.listWtiposervicio = listWtiposervicio;
    }

    /**
     * @return the idtiposervicio
     */
    public String getIdtiposervicio() {
        return idtiposervicio;
    }

    /**
     * @param idtiposervicio the idtiposervicio to set
     */
    public void setIdtiposervicio(String idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    /**
     * @return the rpt_result_resumido
     */
    public NSRResultSet getRpt_result_resumido() {
        return rpt_result_resumido;
    }

    /**
     * @param rpt_result_resumido the rpt_result_resumido to set
     */
    public void setRpt_result_resumido(NSRResultSet rpt_result_resumido) {
        this.rpt_result_resumido = rpt_result_resumido;
    }

    /**
     * @return the selectRpt_
     */
    public Object[] getSelectRpt_() {
        return selectRpt_;
    }

    /**
     * @param selectRpt_ the selectRpt_ to set
     */
    public void setSelectRpt_(Object[] selectRpt_) {
        this.selectRpt_ = selectRpt_;
    }

    /**
     * @return the rpt_result_detallado
     */
    public NSRResultSet getRpt_result_detallado() {
        return rpt_result_detallado;
    }

    /**
     * @param rpt_result_detallado the rpt_result_detallado to set
     */
    public void setRpt_result_detallado(NSRResultSet rpt_result_detallado) {
        this.rpt_result_detallado = rpt_result_detallado;
    }

    /**
     * @return the type_formato_rpt
     */
    public String getType_formato_rpt() {
        return type_formato_rpt;
    }

    /**
     * @param type_formato_rpt the type_formato_rpt to set
     */
    public void setType_formato_rpt(String type_formato_rpt) {
        this.type_formato_rpt = type_formato_rpt;
    }

    /**
     * @return the lst_type_rpt
     */
    public String[] getLst_type_rpt() {
        return lst_type_rpt;
    }

    /**
     * @param lst_type_rpt the lst_type_rpt to set
     */
    public void setLst_type_rpt(String[] lst_type_rpt) {
        this.lst_type_rpt = lst_type_rpt;
    }

}