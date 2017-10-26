/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Config_ventana_filtro_webDao;
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
import com.nisira.core.dao.Dlogtablas_operacionesDao;
import com.nisira.core.dao.MotivosproduccionDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Config_ventana_filtro_web;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.entity.Dlogtablas_operaciones;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Dlogtablas_operaciones;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Usuario;
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
@ManagedBean(name = "rpt_dlogtablas_operacionesAction")
@SessionScoped
public class Rpt_dlogtablas_operacionesAction extends AbstactListAction<Dlogtablas_operaciones> {
    /*************************************ArrayList***************************************/
    private List<Config_ventana_filtro_web> listVentana;
    private List<Dlogtablas_operaciones> listDlogtablas_operaciones;
    private List<Documentos> listDocumentos;
    private List<Usuario> listUsuario;
    private List<DataTableColumn> dataTableColumns;
    private List<String[]> detalles;
    /*************************************DAO***************************************/
    private Dlogtablas_operacionesDao logTablasDao;
    private OrdenservicioclienteDao ordenservicioclienteDao;
    private Config_ventana_filtro_webDao config_ventana_filtro_webDao;
    private Dlogtablas_operaciones dlogtablas_operacionesDao;
    private UsuarioDao usuarioDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String slc_usuario;
    private String slc_config_ventana_filtro_web;
    private String mensaje;
    private String biddocumento;
    private String bserie;
    private String bnumero;
    private Object[] selectRpt;
    /************************************* CONTROLES *****************************************/
    public Rpt_dlogtablas_operacionesAction() {
        try{
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            mensaje = "";
            slc_usuario="";
            biddocumento = "";
            bserie ="";
            bnumero ="";
            /*********************************LISTAS*******************************************/
            listVentana = new ArrayList<>();
            listDlogtablas_operaciones = new ArrayList<>();
            dataTableColumns = new ArrayList<>();
            detalles = new ArrayList<>();
            /*********************************DAO*******************************************/
            config_ventana_filtro_webDao = new Config_ventana_filtro_webDao();
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            usuarioDao = new UsuarioDao();
            logTablasDao = new Dlogtablas_operacionesDao();
            /**********************************CONTROLADOR********************************/
            /********************************** CONFIGURACIÓN - SERVIDOR ********************************/
            listVentana = config_ventana_filtro_webDao.lstConfig_ventana_filtro_web();
            listUsuario = usuarioDao.getUsuarioActivos(user.getIDEMPRESA());
            slc_usuario ="";
            slc_config_ventana_filtro_web ="0";
            actualiza_ventana("wMnt_Rpt_dlogtablas_operaciones");
        }catch(NisiraORMException ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Rpt_dlogtablas_operacionesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        setMensaje("");
        /**********************************CONTROLADOR********************************/
        /**********************************CONFIGURACIÓN - SERVIDOR********************************/
        actualiza_ventana("wMnt_Rpt_dlogtablas_operaciones");
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
            List<Usuario> lstusuarioLocal=new ArrayList<>();
            List<Config_ventana_filtro_web> lstconfig_ventana_filtro_webLocal=new ArrayList<>();
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            if(!WebUtil.isnull(this.slc_usuario, "").equals("")){
                Usuario us =getSearchUsuario(slc_usuario);
                lstusuarioLocal.add(us);
            }else{
                lstusuarioLocal.addAll(listUsuario);
            }
            if(!WebUtil.isnull(this.slc_usuario, "").equals("")){
                Usuario us =getSearchUsuario(slc_usuario);
                lstusuarioLocal.add(us);
            }else{
                lstusuarioLocal.addAll(listUsuario);
            }
            if(!WebUtil.isnull(this.slc_config_ventana_filtro_web, "").equals("")){
                Config_ventana_filtro_web vent =getSearchConfig_ventana_filtro_web(slc_config_ventana_filtro_web);
                lstconfig_ventana_filtro_webLocal.add(vent);
            }else{
                lstconfig_ventana_filtro_webLocal.addAll(listVentana);
            }
            setListaDatos(logTablasDao.lstDlogtablas_operaciones(user.getIDEMPRESA(), lstusuarioLocal, lstconfig_ventana_filtro_webLocal,
                    f_ini, f_fin,1, biddocumento, bserie, bnumero));
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }
    public Usuario getSearchUsuario(String idusuario){
        Usuario uss = null;
        for(Usuario us : listUsuario){
            if(us.getIdusuario().trim().equals(idusuario)){
                uss = us;
                break;
            }
        }
        return uss;
    }
    public Config_ventana_filtro_web getSearchConfig_ventana_filtro_web(String config_ventana_filtro_web){
        Config_ventana_filtro_web cvfw = null;
        for(Config_ventana_filtro_web cvfw1 : listVentana){
            if(cvfw1.getId().toString().equals(config_ventana_filtro_web)){
                cvfw = cvfw1;
                break;
            }
        }
        return cvfw;
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
            List<Usuario> lstusuarioLocal=new ArrayList<>();
            List<Config_ventana_filtro_web> lstconfig_ventana_filtro_webLocal=new ArrayList<>();
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            if(!WebUtil.isnull(this.slc_usuario, "").equals("")){
                Usuario us =getSearchUsuario(slc_usuario);
                lstusuarioLocal.add(us);
            }else{
                lstusuarioLocal.addAll(listUsuario);
            }
            if(!WebUtil.isnull(this.slc_config_ventana_filtro_web, "0").equals("0")){
                Config_ventana_filtro_web vent =getSearchConfig_ventana_filtro_web(slc_config_ventana_filtro_web);
                lstconfig_ventana_filtro_webLocal.add(vent);
            }else{
                lstconfig_ventana_filtro_webLocal.addAll(listVentana);
            }
            setListaDatos(logTablasDao.lstDlogtablas_operaciones(user.getIDEMPRESA(), lstusuarioLocal, lstconfig_ventana_filtro_webLocal,
                    f_ini, f_fin,1, biddocumento, bserie, bnumero));
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
//        if(tipo == 2)
//            lista_accion_filtro("wLst_Rpt_dlogtablas_operaciones");
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
        //objWB.setSheetName(0,"REPORTE_ESPECIAL_ "+WebUtil.fechaDMY(new Date(),1));

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

//        int col = rpt_result.columnCount();
//        int row = rpt_result.getData().size();
//        HSSFCell celda;
//        for(int i=0 ;i<col;i++){
//            celda = fila_cabecera.createCell((short)i);
//            celda.setCellStyle(estiloCelda);
//            celda.setCellValue(rpt_result.getName()[i]);
//        }
//        HSSFRow fila;
//        for(int i=0;i<row;i++){
//            fila = objWB.getSheetAt(0).getRow(i+1);
//            for(int j=0;j<col;j++){
//                celda = fila.createCell((short)j);
//                celda.setCellStyle(estiloFila);
//                celda.setCellValue( rpt_result.getData().get(i)[j]==null?"":rpt_result.getData().get(i)[j].toString());
//            }
//        }
//        for (int as = 0; as < col; as++) {
//            objWB.getSheetAt(0).autoSizeColumn((short) as);
//        }
    }
    
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 2);
        else
            return "";
    }
    public String horaHmS(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 11);
        else
            return "";
    }
    public void visualizar_detallado() {
        try {
            if(getDatoSeleccionado()==null){
                this.mensaje="Seleccionar Registro";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                String variable = "-";
                String name[]  =  getDatoSeleccionado().getIdcampo().replace("+", "-").split(variable,-1);
                String value_new[] =  getDatoSeleccionado().getValoractual().replace("+", "-").split(variable,-1);
                String value_old[] =  getDatoSeleccionado().getValoranterior().replace("+", "-").split(variable,-1);
                String datos[];
                setDetalles(new ArrayList<>());
                for(int i=0;i<name.length;i++){
                    datos = new String[3];
                    datos[0] = name[i];
                    datos[1] = value_new[i]; 
                    datos[2] = value_old[i];
                    getDetalles().add(datos);
                }
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog");
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:detalles"); 
                RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').show()");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * @return the listVentana
     */
    public List<Config_ventana_filtro_web> getListVentana() {
        return listVentana;
    }

    /**
     * @param listVentana the listVentana to set
     */
    public void setListVentana(List<Config_ventana_filtro_web> listVentana) {
        this.listVentana = listVentana;
    }

    /**
     * @return the config_ventana_filtro_webDao
     */
    public Config_ventana_filtro_webDao getConfig_ventana_filtro_webDao() {
        return config_ventana_filtro_webDao;
    }

    /**
     * @param config_ventana_filtro_webDao the config_ventana_filtro_webDao to set
     */
    public void setConfig_ventana_filtro_webDao(Config_ventana_filtro_webDao config_ventana_filtro_webDao) {
        this.config_ventana_filtro_webDao = config_ventana_filtro_webDao;
    }

    /**
     * @return the listDlogtablas_operaciones
     */
    public List<Dlogtablas_operaciones> getListDlogtablas_operaciones() {
        return listDlogtablas_operaciones;
    }

    /**
     * @param listDlogtablas_operaciones the listDlogtablas_operaciones to set
     */
    public void setListDlogtablas_operaciones(List<Dlogtablas_operaciones> listDlogtablas_operaciones) {
        this.listDlogtablas_operaciones = listDlogtablas_operaciones;
    }

    /**
     * @return the listDocumentos
     */
    public List<Documentos> getListDocumentos() {
        return listDocumentos;
    }

    /**
     * @param listDocumentos the listDocumentos to set
     */
    public void setListDocumentos(List<Documentos> listDocumentos) {
        this.listDocumentos = listDocumentos;
    }

    /**
     * @return the listUsuario
     */
    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    /**
     * @param listUsuario the listUsuario to set
     */
    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    /**
     * @return the slc_usuario
     */
    public String getSlc_usuario() {
        return slc_usuario;
    }

    /**
     * @param slc_usuario the slc_usuario to set
     */
    public void setSlc_usuario(String slc_usuario) {
        this.slc_usuario = slc_usuario;
    }

    /**
     * @return the usuarioDao
     */
    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    /**
     * @return the bserie
     */
    public String getBserie() {
        return bserie;
    }

    /**
     * @param bserie the bserie to set
     */
    public void setBserie(String bserie) {
        this.bserie = bserie;
    }

    /**
     * @return the bnumero
     */
    public String getBnumero() {
        return bnumero;
    }

    /**
     * @param bnumero the bnumero to set
     */
    public void setBnumero(String bnumero) {
        this.bnumero = bnumero;
    }

    /**
     * @return the dlogtablas_operacionesDao
     */
    public Dlogtablas_operaciones getDlogtablas_operacionesDao() {
        return dlogtablas_operacionesDao;
    }

    /**
     * @param dlogtablas_operacionesDao the dlogtablas_operacionesDao to set
     */
    public void setDlogtablas_operacionesDao(Dlogtablas_operaciones dlogtablas_operacionesDao) {
        this.dlogtablas_operacionesDao = dlogtablas_operacionesDao;
    }

    /**
     * @return the slc_config_ventana_filtro_web
     */
    public String getSlc_config_ventana_filtro_web() {
        return slc_config_ventana_filtro_web;
    }

    /**
     * @param slc_config_ventana_filtro_web the slc_config_ventana_filtro_web to set
     */
    public void setSlc_config_ventana_filtro_web(String slc_config_ventana_filtro_web) {
        this.slc_config_ventana_filtro_web = slc_config_ventana_filtro_web;
    }

    /**
     * @return the biddocumento
     */
    public String getBiddocumento() {
        return biddocumento;
    }

    /**
     * @param biddocumento the biddocumento to set
     */
    public void setBiddocumento(String biddocumento) {
        this.biddocumento = biddocumento;
    }

    /**
     * @return the detalles
     */
    public List<String[]> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(List<String[]> detalles) {
        this.detalles = detalles;
    }
}