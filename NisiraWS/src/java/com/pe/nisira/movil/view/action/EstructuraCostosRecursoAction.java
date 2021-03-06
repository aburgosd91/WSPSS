/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Destructura_costos_recursosDao;
import com.nisira.core.dao.Estructura_costosDao;
import com.nisira.core.dao.Estructura_costos_clieprovDao;
import com.nisira.core.dao.Estructura_costos_mano_obraDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_detalladoDao;
import com.nisira.core.dao.Estructura_costos_productoDao;
import com.nisira.core.dao.Estructura_costos_producto_diasrangoDao;
import com.nisira.core.dao.MonedaDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.SucursalDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Sucursal;
import com.nisira.core.dao.MultitablaDao;
import com.nisira.core.dao.ProductosDao;
import com.nisira.core.dao.UnimedidaDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Destructura_costos_recursos;
import com.nisira.core.entity.Estructura_costos;
import com.nisira.core.entity.Estructura_costos_clieprov;
import com.nisira.core.entity.Estructura_costos_mano_obra;
import com.nisira.core.entity.Estructura_costos_mano_obra_detallado;
import com.nisira.core.entity.Estructura_costos_producto;
import com.nisira.core.entity.Estructura_costos_producto_diasrango;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Multitabla;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Productos;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Unimedida;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "estructuracostosrecursoAction")
@SessionScoped
public class EstructuraCostosRecursoAction extends AbstactListAction<Estructura_costos> implements Serializable {

    /*CONTROLES*/
    private Float costo_mano_obra;
    private String mensaje;
    private boolean vestado;
    private boolean vexcluir;
    private boolean botonEditarEstructura_costos_clieprov;
    private boolean botonEliminarEstructura_costos_clieprov;
    private boolean botonEditarEstructura_costos_producto;
    private boolean botonEliminarEstructura_costos_producto;
    private boolean botonNuevoDestructura_costos_recurso;
    private boolean botonEditarDestructura_costos_recurso;
    private boolean botonEliminarDestructura_costos_recurso;
    private boolean botonNuevoEstructura_costos_mano_obra;
    private boolean botonEditarEstructura_costos_mano_obra;
    private boolean botonEliminarEstructura_costos_mano_obra;
    
    private boolean botonNuevoEstructura_costos_mano_obra_detalle;
    private boolean botonEliminarEstructura_costos_mano_obra_detalle;
    /*DAO*/
    private Estructura_costosDao estructura_costosDao; 
    private Estructura_costos_clieprovDao estructura_costos_clieprovDao;
    private Estructura_costos_productoDao estructura_costos_productoDao;
    private Destructura_costos_recursosDao destructura_costos_recursosDao;
    private Estructura_costos_mano_obraDao estructura_costos_mano_obraDao;
    private Estructura_costos_mano_obra_detalladoDao estructura_costos_mano_obra_detalladoDao;
    private Estructura_costos_producto_diasrangoDao estructura_costos_producto_diasrangoDao;
    /*ARRAY*/
    private List<String> lstTipoRecurso;
    private List<Es_PorcentajeCombo> lstEs_porcentaje;
    private List<Estructura_costos_clieprov> listEstructura_costos_clieprov;
    private List<Estructura_costos_producto> listEstructura_costos_producto;
    private List<Estructura_costos_producto> listEstructura_costos_producto_copy;
    private List<Estructura_costos_producto> selectlistEstructura_costos_producto_copy;
    private List<Destructura_costos_recursos> listDestructura_costos_recursos;
    private List<Estructura_costos_mano_obra> listEstructura_costos_mano_obra;
    private List<Destructura_costos_recursos> listTotalDestructura_costos_recursos;
    private List<Estructura_costos_mano_obra> listTotalEstructura_costos_mano_obra;
    private List<Unimedida> listUnimedida;
    private List<Monedas> listMoneda;
    private List<Estructura_costos_mano_obra_detallado> listTotalEstructura_costos_mano_obra_detallado;
    private List<Estructura_costos_mano_obra_detallado> listEstructura_costos_mano_obra_detallado;
    private List<Estructura_costos_producto_diasrango> listEstructura_costos_producto_diasrango;
    private List<Estructura_costos_producto_diasrango> listTotalEstructura_costos_producto_diasrango;
    private List<Productos> listProductos;
    /***************** ENTITY ****************/
    private Estructura_costos_mano_obra estructura_costos_mano_obra; 
    private Estructura_costos_mano_obra_detallado estructura_costos_mano_obra_detallado; 
    private Estructura_costos_clieprov estructura_costos_clieprov;
    private Estructura_costos_producto estructura_costos_producto;
    private Destructura_costos_recursos destructura_costos_recursos;
    private Rutas selectRutas;
    private Clieprov selectClieprov_copy;
    private Estructura_costos_mano_obra_detallado selectEstructura_costos_mano_obra_detallado; 
    /*********************************************/
    private Estructura_costos_clieprov selectEstructura_costos_clieprov;
    private Estructura_costos_producto selectEstructura_costos_producto;
    private Destructura_costos_recursos selectDestructura_costos_recursos;
    private Estructura_costos_mano_obra selecteEstructura_costos_mano_obra; 
    private boolean botonEditar;
    private boolean botonEliminar;
    public UsuarioBean user;
    private Float subtotal_ecosto;
    private Float go_ecosto;
    private Float ga_ecosto;
    private Float u_ecosto;
    private Float ajuste_ecosto;
    private Float total_ecosto;
    private int indexTab;
    private TabView tabView; 
    private String log_consola;
    public EstructuraCostosRecursoAction() {
        /*CONTROLES*/
        lstTipoRecurso = new ArrayList<>();
        lstTipoRecurso.add("CO");
        lstTipoRecurso.add("MO");
        lstEs_porcentaje = new ArrayList<>();
        lstEs_porcentaje.add(new Es_PorcentajeCombo(0,"No Porcentaje"));
        lstEs_porcentaje.add(new Es_PorcentajeCombo(1,"Porcentaje"));
        mensaje = "";
        botonEditar = false;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        botonEditarEstructura_costos_clieprov = true;
        botonEliminarEstructura_costos_clieprov = true;
        botonEditarEstructura_costos_producto = true;
        botonEliminarEstructura_costos_producto = true;

        botonNuevoDestructura_costos_recurso = true;
        botonEditarDestructura_costos_recurso = true;
        botonEliminarDestructura_costos_recurso = true;
        
        botonNuevoEstructura_costos_mano_obra = true;
        botonEditarEstructura_costos_mano_obra = true;
        botonEliminarEstructura_costos_mano_obra = true;
        
        botonNuevoEstructura_costos_mano_obra_detalle = true;
        botonEliminarEstructura_costos_mano_obra_detalle = true;
        /*DAO*/
        estructura_costosDao = new Estructura_costosDao();
        estructura_costos_clieprovDao = new Estructura_costos_clieprovDao();
        estructura_costos_productoDao = new Estructura_costos_productoDao();
        destructura_costos_recursosDao = new Destructura_costos_recursosDao();
        estructura_costos_mano_obraDao = new Estructura_costos_mano_obraDao();
        estructura_costos_mano_obra_detalladoDao = new Estructura_costos_mano_obra_detalladoDao();
        estructura_costos_producto_diasrangoDao = new Estructura_costos_producto_diasrangoDao();
        /*ARRAY*/
        listEstructura_costos_clieprov = new ArrayList<>();
        listEstructura_costos_producto = new ArrayList<>();
        listDestructura_costos_recursos = new ArrayList<>();
        listTotalDestructura_costos_recursos = new ArrayList<>();
        listTotalEstructura_costos_mano_obra = new ArrayList<>();
        listUnimedida = new ArrayList<>();
        listMoneda = new ArrayList<>();
        listEstructura_costos_mano_obra_detallado= new ArrayList<>();
        listTotalEstructura_costos_mano_obra_detallado= new ArrayList<>();
        listEstructura_costos_producto_diasrango= new ArrayList<>();
        /*ENTITY*/
        selectEstructura_costos_clieprov = new Estructura_costos_clieprov();
        selectEstructura_costos_producto = new Estructura_costos_producto();
        selectDestructura_costos_recursos = new Destructura_costos_recursos();
        
        estructura_costos_clieprov = new Estructura_costos_clieprov();
        estructura_costos_producto = new Estructura_costos_producto();
        destructura_costos_recursos = new Destructura_costos_recursos();
        
        subtotal_ecosto = 0.0f;
        go_ecosto = 0.0f;
        ga_ecosto = 0.0f;
        u_ecosto = 0.0f;
        total_ecosto = 0.0f;
        ajuste_ecosto = 0.0f;
        costo_mano_obra = 0.0f;
        log_consola ="";
        actualiza_ventana("wMnt_EstructuraCostosRecurso");
    }

    @Override
    public void buscarTodo() {
        try {
            setListaDatos(getEstructura_costosDao().listarPorEmpresaWeb(user.getIDEMPRESA()));
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        try {
            mensaje = "";
            botonEditar = false;
            botonEliminar = false;
            /****** COTIZACIÓN DATOS ******/
            botonEditarEstructura_costos_clieprov = true;
            botonEliminarEstructura_costos_clieprov = true;
            botonEditarEstructura_costos_producto = true;
            botonEliminarEstructura_costos_producto = true;
            
            botonNuevoDestructura_costos_recurso = true;
            botonEditarDestructura_costos_recurso = true;
            botonEliminarDestructura_costos_recurso = true;
            
            botonNuevoEstructura_costos_mano_obra = true;
            botonEditarEstructura_costos_mano_obra = true;
            botonEliminarEstructura_costos_mano_obra = true;
            /*ARRAY*/
            listEstructura_costos_clieprov = new ArrayList<>();
            listEstructura_costos_producto = new ArrayList<>();
            listDestructura_costos_recursos = new ArrayList<>();
            /*ENTITY*/
            selectEstructura_costos_clieprov = new Estructura_costos_clieprov();
            selectEstructura_costos_producto = new Estructura_costos_producto();
            selectDestructura_costos_recursos = new Destructura_costos_recursos();
            
            estructura_costos_clieprov = new Estructura_costos_clieprov();
            estructura_costos_producto = new Estructura_costos_producto();
            destructura_costos_recursos = new Destructura_costos_recursos();
            
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            listMoneda = (new MonedasDao()).getListMonedasWeb();
            actualiza_ventana("wMnt_EstructuraCostosRecurso");
            
        } catch (NisiraORMException ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void nuevo() {
        setDatoEdicion(new Estructura_costos());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setEstado(1.0f);
        /*RESET*/
        setSelectEstructura_costos_clieprov(new Estructura_costos_clieprov());
        setSelectEstructura_costos_producto(new Estructura_costos_producto());
        setSelectDestructura_costos_recursos(new Destructura_costos_recursos());
        
        setListEstructura_costos_clieprov(new ArrayList<>());
        setListEstructura_costos_producto(new ArrayList<>());
        setListDestructura_costos_recursos(new ArrayList<>());
        setListEstructura_costos_mano_obra(new ArrayList<>());
        
        if(!listMoneda.isEmpty()){
            Monedas monedas = listMoneda.get(0);
            getDatoEdicion().setIdmoneda(monedas.getIdmoneda());
            getDatoEdicion().setMoneda(monedas.getDescripcion());
        }
    }
    
    @Override
    public void grabar() {
        try {
            getDatoEdicion().setEstado(vestado?1.0f:0.0f);
            getDatoEdicion().setExcluir(vexcluir?1.0f:0.0f);
            if(getLadd()==1){
                mensaje=getEstructura_costosDao().grabar(1, 
                        getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getCodigo(),
                        getDatoEdicion(), 
                        getListEstructura_costos_clieprov(),
                        getListEstructura_costos_producto(),
                        getListTotalDestructura_costos_recursos(),
                        getListTotalEstructura_costos_mano_obra(),
                        getListTotalEstructura_costos_mano_obra_detallado(),
                        user.getIDUSUARIO());
                if(mensaje!=null)
                        getDatoEdicion().setCodigo(mensaje.trim());
            }
            else
                mensaje=getEstructura_costosDao().grabar(2, 
                        getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getCodigo(),
                        getDatoEdicion(), 
                        getListEstructura_costos_clieprov(),
                        getListEstructura_costos_producto(),
                        getListTotalDestructura_costos_recursos(),
                        getListTotalEstructura_costos_mano_obra(),
                        getListTotalEstructura_costos_mano_obra_detallado(),
                        user.getIDUSUARIO());
            setMensaje(WebUtil.exitoRegistrar("Estructura Costo ", mensaje));
            WebUtil.info(getMensaje());
            setLvalidate(true);
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
    }

    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                mensaje=getEstructura_costosDao().anular(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoAnular("Estructura Costo ", mensaje));
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                mensaje=getEstructura_costosDao().eliminar(getDatoEdicion().getIdempresa(), getDatoEdicion().getCodigo(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoEliminar("Estructura Costo ", mensaje));
            }
            WebUtil.info(getMensaje());
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String buscarFiltro(int tipo) {
        return "";
    }

    @Override
    public void cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void aprobar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void downFormatExcelEspecial(Object document){
        try {
            List<List<Object>> lst = estructura_costosDao.export_xls(user.getIDEMPRESA());
            if(!lst.isEmpty()){
                HSSFWorkbook objWB = (HSSFWorkbook) document;
                HSSFRow fila_cabecera_ = objWB.getSheetAt(0).getRow(0);

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
                estiloFila.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
                estiloFila.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
                estiloFila.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
                estiloFila.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
                estiloFila.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
                estiloFila.setFont(fuente);

//                HSSFWorkbook objWB = new HSSFWorkbook();
                HSSFSheet sheet1 = objWB.createSheet("DETALLADO_ESTRUCTURA_COSTOS");
                HSSFRow fila_cabecera = sheet1.createRow((short)0);
                
                // Creamos la celda, aplicamos el estilo y definimos
                // el tipo de dato que contendrá la celda
                HSSFCell celda;
                int tcol = lst.get(0).size();
                for(int i=0 ;i<tcol;i++){
                    celda = fila_cabecera.createCell((short)i);
                    celda.setCellStyle(estiloCelda);
                    switch(i){
                        case 0:celda.setCellValue("CÓDIGO");break;
                        case 1:celda.setCellValue("RUC");break;
                        case 2:celda.setCellValue("CLIENTE");break;
                        case 3:celda.setCellValue("DESCRIPCIÓN");break;
                        case 4:celda.setCellValue("CODOPERATIVO");break;
                        case 5:celda.setCellValue("NHORAS");break;
                        case 6:celda.setCellValue("RUTA");break;
                        case 7:celda.setCellValue("AD1");break;
                        case 8:celda.setCellValue("AD2");break;
                    }
                }
                /*ESTRUCTURA PERSONALIZADA*/
                for(int row=0;row<lst.size();row++){
                    List<Object> lst_col = lst.get(row);
                    fila_cabecera = sheet1.createRow((short)row+1);
                    for(int col=0 ; col<tcol;col++){
                        celda = fila_cabecera.createCell((short)col);
                        celda.setCellStyle(estiloFila);
                        celda.setCellValue(lst_col.get(col).toString());
                    }
                }
                for (int as = 0; as < tcol; as++) {
                    sheet1.autoSizeColumn((short) as);
                }
//                wb = objWB;
            }else{
               this.mensaje="No existe registros";
               WebUtil.info(getMensaje());
               RequestContext.getCurrentInstance().update("datos:growl");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje=ex.getMessage();
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void findetalle() throws Exception {
        try{
            /*RESET*/
            selectEstructura_costos_producto=null;
            selectEstructura_costos_clieprov=null;
            selecteEstructura_costos_mano_obra=null;
            selectDestructura_costos_recursos=null;
            
            listTotalDestructura_costos_recursos = new ArrayList<>();
            listTotalEstructura_costos_mano_obra = new ArrayList<>();
            listDestructura_costos_recursos = new ArrayList<>();
            listEstructura_costos_mano_obra = new ArrayList<>();
            
            subtotal_ecosto = 0.0f;
            go_ecosto = 0.0f;
            ga_ecosto = 0.0f;
            u_ecosto = 0.0f;
            total_ecosto = 0.0f;
            ajuste_ecosto = 0.0f;
            if(getLadd()==2){/*EDITAR*/
                vestado = getDatoEdicion().getEstado() == 1.0?true:false;
                vexcluir = getDatoEdicion().getExcluir()== 1.0?true:false;
                setListEstructura_costos_clieprov(estructura_costos_clieprovDao.listarPorEmpresaWebXcodigo(user.getIDEMPRESA(), getDatoEdicion().getCodigo()));
                setListEstructura_costos_producto(estructura_costos_productoDao.listarPorEmpresaWebXcodigo(user.getIDEMPRESA(), getDatoEdicion().getCodigo()));
                if(!getListEstructura_costos_clieprov().isEmpty()){
                    setSelectEstructura_costos_clieprov(getListEstructura_costos_clieprov().get(0));
                    setBotonEditarEstructura_costos_clieprov(false);
                    setBotonEliminarEstructura_costos_clieprov(false);
                }else{
                    setBotonEditarEstructura_costos_clieprov(true);
                    setBotonEliminarEstructura_costos_clieprov(true);
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_CLIEPROV>";
                    WebUtil.error(mensaje);
                }
                if(!getListEstructura_costos_producto().isEmpty()){
                    setSelectEstructura_costos_producto(getListEstructura_costos_producto().get(0));
                    setBotonEditarEstructura_costos_producto(false);
                    setBotonEliminarEstructura_costos_producto(false);
                    setBotonNuevoDestructura_costos_recurso(false);
                    this.ajuste_ecosto=getSelectEstructura_costos_producto().getAjuste();
                }else{
                    setListEstructura_costos_producto(new ArrayList<>());
                    setListDestructura_costos_recursos(new ArrayList<>());
                    setBotonEditarEstructura_costos_producto(true);
                    setBotonEliminarEstructura_costos_producto(true);
                    setBotonNuevoDestructura_costos_recurso(true);
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_PRODUCTO>";
                    WebUtil.error(mensaje);
                }
                /*DESTRUCTURA_COSTOS_RECURSOS->GLOBAL*/
                listTotalDestructura_costos_recursos=destructura_costos_recursosDao.listarPorEmpresaWeb(getSelectEstructura_costos_producto().getIdempresa(),
                        getSelectEstructura_costos_producto().getCodigo());
                /*ESTRUCTURA_COSTOS_MANO_OBRA->GLOBAL*/
                listTotalEstructura_costos_mano_obra=estructura_costos_mano_obraDao.listarPorEmpresaWeb(getSelectEstructura_costos_producto().getIdempresa(),
                        getSelectEstructura_costos_producto().getCodigo());
                listTotalEstructura_costos_mano_obra_detallado=estructura_costos_mano_obra_detalladoDao.listarPorEmpresaWeb(getSelectEstructura_costos_producto().getIdempresa(),
                        getSelectEstructura_costos_producto().getCodigo());
                if(getListTotalDestructura_costos_recursos().isEmpty()){
                    mensaje = "No existe registro <DESTRUCTURA_COSTOS_RECURSO>";
                    WebUtil.error(mensaje);
                }
                else
                    cargarProductos();
                if(getListTotalEstructura_costos_mano_obra().isEmpty()){
                    mensaje = "No existe registro <ESTRUCTURA_COSTOS_MANO_OBRA>";
                    WebUtil.error(mensaje);
                }
                
                if(getSelectEstructura_costos_producto()!=null){
                    listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
                    listEstructura_costos_mano_obra = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action();
                    calculosTotales_estructuracostos_local();
                }
            }else if(getLadd()==1){/*NUEVO*/
                vestado = true;
                vexcluir = false;
                listEstructura_costos_clieprov = new ArrayList<>();
                listEstructura_costos_producto = new ArrayList<>();
                listDestructura_costos_recursos = new ArrayList<>();
                listEstructura_costos_mano_obra = new ArrayList<>();
                listTotalDestructura_costos_recursos = new ArrayList<>();
                listTotalEstructura_costos_mano_obra = new ArrayList<>();
            }
            listUnimedida = (new UnimedidaDao()).listarPorEmpresaWeb(user.getIDEMPRESA());
            listMoneda = (new MonedasDao()).getListMonedasWeb();
            
        }catch(Exception ex){
            Logger.getLogger(CotizacionesAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje=ex.getMessage();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos");
        RequestContext.getCurrentInstance().update("datos:tabs");
    }
    public void cargarProductos(){
        try{
            if(!listTotalDestructura_costos_recursos.isEmpty()){
                Destructura_costos_recursos temp;
                Productos pr;
                for(int i=0;i<listTotalDestructura_costos_recursos.size();i++){
                    temp = listTotalDestructura_costos_recursos.get(i);
                    if(!WebUtil.isnull(temp.getIdproducto(), "").equals("")){
                        List<Productos> lstPro =(new ProductosDao()).listarPorEmpresaWebxIdproducto(user.getIDEMPRESA(), temp.getIdproducto());
                        if(lstPro.isEmpty())
                            temp.setSelectProductos(null);
                        else
                            temp.setSelectProductos(lstPro.get(0));
                    }
                    listTotalDestructura_costos_recursos.set(i, temp);
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cargarProductosBase(){
        try {
            listProductos = (new ProductosDao()).listarPorEmpresaEstructuraWeb(user.getIDEMPRESA());
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Productos> completeProductos(String query) {
        cargarProductosBase();
        List<Productos> filteredProductos = new ArrayList<Productos>(); 
        for (int i = 0; i < listProductos.size(); i++) {
            Productos skin = listProductos.get(i);
            if((skin.getIdproducto()).trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())) {
                filteredProductos.add(skin);
            }
        }
        return filteredProductos;
    }
    public List<Destructura_costos_recursos> listarPorEmpresaWebXProducto_Destructura_costos_recursos_action(){
        List<Destructura_costos_recursos> temp = new ArrayList<>();
        if(getSelectEstructura_costos_producto()!=null){
            for(Destructura_costos_recursos ob:listTotalDestructura_costos_recursos){
                if(ob.getItemrango().trim().equalsIgnoreCase(getSelectEstructura_costos_producto().getItem().trim()) &&
                        ob.getIdproducto_ec().trim().equalsIgnoreCase(getSelectEstructura_costos_producto().getIdproducto().trim())){
                    temp.add(ob);
                }
            }
            return temp;
        }else{
            return null;
        }
    }
    public List<Estructura_costos_mano_obra> listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action(){
        List<Estructura_costos_mano_obra> temp = new ArrayList<>();
        if(getSelectEstructura_costos_producto()!=null){
            for(Estructura_costos_mano_obra ob:listTotalEstructura_costos_mano_obra){
                if(ob.getItemrango().trim().equalsIgnoreCase(getSelectEstructura_costos_producto().getItem().trim()) &&
                        ob.getIdproducto().trim().equalsIgnoreCase(getSelectEstructura_costos_producto().getIdproducto().trim())){
                    temp.add(ob);
                }
            }
            return temp;
        }else{
            return null;
        }
    }
    public List<Estructura_costos_mano_obra_detallado> listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_detallado_action(){
        List<Estructura_costos_mano_obra_detallado> temp = new ArrayList<>();
        if(getSelecteEstructura_costos_mano_obra()!=null){
            for(Estructura_costos_mano_obra_detallado ob:listTotalEstructura_costos_mano_obra_detallado){
                if(ob.getItem_ecm().trim().equals(getSelecteEstructura_costos_mano_obra().getItem()) &&
                        ob.getIdcargo().trim().equals(getSelecteEstructura_costos_mano_obra().getIdcargo()) &&
                        ob.getItemrango().trim().equals(getSelecteEstructura_costos_mano_obra().getItemrango()) &&
                        ob.getNhoras().floatValue() == getSelectEstructura_costos_producto().getNhoras().floatValue() &&
                        (ob.getCodoperativo()==null?"":ob.getCodoperativo()).trim().equals((getSelectEstructura_costos_producto().getCodoperativo()==null?"":getSelectEstructura_costos_producto().getCodoperativo()).trim()) &&
                        (ob.getIdruta()==null?"":ob.getIdruta()).trim().equals((getSelectEstructura_costos_producto().getIdruta()==null?"":getSelectEstructura_costos_producto().getIdruta()).trim())
                   ){
                    temp.add(ob); 
                }
            }
            return temp;
        }else{
            return null;
        }
    }
    public void replaceDestructura_costos_recursos_action(Destructura_costos_recursos ob_ant,Destructura_costos_recursos ob_des){
        int pos = listTotalDestructura_costos_recursos.indexOf(ob_ant);
        if(pos!=-1)
            listTotalDestructura_costos_recursos.set(pos, ob_des);
    }
    /************************CONFIGURACION**********************/
    public void onSPTabChange(TabChangeEvent event) 
    {   
        tabView = (TabView) event.getComponent();
        indexTab = tabView.getActiveIndex();
//        tabView.setActiveIndex(0);
    }
    /*********** VALIDACIÓN **********/
    public boolean existeCliente(String idclieprov) throws Exception{
        boolean response=false;
        for(Estructura_costos_clieprov obj : getListEstructura_costos_clieprov() ){
            if(obj.getIdclieprov().trim().equalsIgnoreCase(idclieprov.trim())){
                response=true;
                break;
            }
        }
        return response;
    }
    public boolean existeServicio(String idproducto){
        boolean response=false;
        for(Estructura_costos_producto obj : getListEstructura_costos_producto()){
            if(obj.getIdproducto().trim().equalsIgnoreCase(idproducto.trim())){
                response=true;
                break;
            }
        }
        return response;
    }
    public boolean existeCargo(String idcargo){
        boolean response=false;
        for(Estructura_costos_mano_obra obj : getListEstructura_costos_mano_obra()){
            if(obj.getIdcargo().trim().equalsIgnoreCase(idcargo.trim())){
                response=true;
                break;
            }
        }
        return response;
    }
    /*********** EVENTOS **********/
    public void onRowSelectEstructura_costos_clieprov(SelectEvent event) throws IOException {
        setBotonEditarEstructura_costos_clieprov(false);
        setBotonEliminarEstructura_costos_clieprov(false);
        RequestContext.getCurrentInstance().update("datos:listEstructura_costos_clieprov");
    }
    public void onRowSelectEstructura_costos_producto(SelectEvent event) throws IOException {
        try {
            setBotonEditarEstructura_costos_producto(false);
            setBotonEliminarEstructura_costos_producto(false);
            setBotonNuevoDestructura_costos_recurso(false);
            this.ajuste_ecosto=getSelectEstructura_costos_producto().getAjuste();
            listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
            listEstructura_costos_mano_obra = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action();
            /* CONSULTAR ESTRUCTURA COSTOS PRODUCTO*/
            if(listDestructura_costos_recursos.isEmpty()){
                mensaje = "No existe registro <ESTRUCTURA_COSTOS_RECURSOS>";
                WebUtil.error(mensaje);
            }
            if(getListEstructura_costos_mano_obra().isEmpty()){
                mensaje = "No existe registro <ESTRUCTURA_COSTOS_MANO_OBRA>";
                WebUtil.error(mensaje);
            }
            calculosTotales_estructuracostos_local();
            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
            RequestContext.getCurrentInstance().update("datos:tabs");
//            tabView.setActiveIndex(indexTab);
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onRowSelectDestructura_costos_recursos(SelectEvent event) throws IOException {
        setBotonNuevoDestructura_costos_recurso(false);
        setBotonEliminarDestructura_costos_recurso(false);
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos");
//        RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
    }
    public void onRowSelectEstructura_costos_mano_obra(SelectEvent event) throws IOException {
        setBotonEditarEstructura_costos_mano_obra(false);
        setBotonEliminarEstructura_costos_mano_obra(false);
        if(listDestructura_costos_recursos.isEmpty()){
            mensaje = "No existe registro <ESTRUCTURA_COSTOS_RECURSOS>";
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra");
        tabView.setActiveIndex(indexTab);
    }
    public void onRowSelectEstructura_costos_mano_obra_detalle(SelectEvent event) throws IOException {
        setBotonEliminarEstructura_costos_mano_obra_detalle(false);
        RequestContext.getCurrentInstance().update("datos:dlgEstructura_costos_mano_obra_detallado:listEstructura_costos_mano_obra_detallado");
    }
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        Destructura_costos_recursos entity =(Destructura_costos_recursos)((DataTable)event.getComponent()).getRowData();
        int itemRow = event.getRowIndex();
        if(event.getColumn().getHeaderText()!=null){
            String colHead = event.getColumn().getHeaderText().trim();
            switch(colHead){
                case "idProducto":
                    if(newValue==null){
                        entity.setIdproducto("");
                        entity.setIdproducto_descripcion("");
                    }else{
                        Productos ob = (Productos)newValue;
                        entity.setIdproducto(ob.getIdproducto());
                        entity.setIdproducto_descripcion(ob.getDescripcion());
                        entity.setSelectProductos(ob);
                    };break;
            }
        }
        Object oldValue = event.getOldValue();
        /*OBJETO ANTES DE*/
        Destructura_costos_recursos ob_ant = getListDestructura_costos_recursos().get(itemRow);
        getListDestructura_costos_recursos().set(itemRow, entity);
        calculosTotales_estructuracostos_local();
        replaceDestructura_costos_recursos_action(ob_ant, entity);
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos");
        RequestContext.getCurrentInstance().update("datos:tabs:subtotal_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:go_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:ga_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:u_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:total_ecosto");
    }
    public void calculosTotales_estructuracostos_local()    {
        
        BigDecimal total_ec=new BigDecimal(0.0d);
        BigDecimal subtotal_ec=new BigDecimal(0.0d);
        BigDecimal go_ec=new BigDecimal(0.0d);
        BigDecimal ga_ec=new BigDecimal(0.0d);
        BigDecimal u_ec=new BigDecimal(0.0d);
        BigDecimal total_porcentaje=new BigDecimal(0.0d);
        int item=0;
        if(!getListDestructura_costos_recursos().isEmpty()){
            /*CÁLCULO SUBTOTAL*/
            for(Destructura_costos_recursos o :getListDestructura_costos_recursos()){
                if(o.getEs_porcentaje()==0.0f){
                    subtotal_ec=subtotal_ec.add((new BigDecimal(o.getCosto())));
//                    subtotal_ec+=o.getCosto();
                }
            }
            /*CÁLCULO PORCENTAJE*/
            BigDecimal cien = new BigDecimal(100);
            BigDecimal o_getcantidad= new BigDecimal(0);
            for(Destructura_costos_recursos o :getListDestructura_costos_recursos()){
                o_getcantidad= new BigDecimal(o.getCantidad());
                if(o.getEs_porcentaje()==1.0f){
                    switch(o.getDescripcion().trim().toUpperCase()){
                        case "GO":
//                            go_ec+=((o.getCantidad()/100)*subtotal_ec);
                            go_ec=go_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
                            break;
                        case "GA":
//                            ga_ec+=((o.getCantidad()/100)*subtotal_ec);
                            ga_ec=ga_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
                            break;
                        case "U":
//                            u_ec+=((o.getCantidad()/100)*subtotal_ec);
                            u_ec=u_ec.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
                            break;
                    }
//                    total_porcentaje+=(o.getCantidad()/100)*subtotal_ec;
                    total_porcentaje = total_porcentaje.add((o_getcantidad.divide(cien)).multiply(subtotal_ec).setScale(2, RoundingMode.HALF_EVEN));
                }
            }
        }
//        total_ec = subtotal_ec + total_porcentaje;
        total_ec=total_ec.add(subtotal_ec.add(total_porcentaje));
        /*RESULTADOS*/
        this.setSubtotal_ecosto(subtotal_ec.floatValue());
        this.setGo_ecosto(go_ec.floatValue());
        this.setGa_ecosto(ga_ec.floatValue());
        this.setU_ecosto(u_ec.floatValue());
        if(this.getAjuste_ecosto()==null)
            this.ajuste_ecosto = 0.0f;
        this.total_ecosto = total_ec.floatValue()+this.getAjuste_ecosto();
        if(getSelectEstructura_costos_producto()!=null){
            getSelectEstructura_costos_producto().setAjuste(this.getAjuste_ecosto());
        }
    }
    public void calculosTotales_estructuracostos(){
        BigDecimal subtotal_ec=new BigDecimal(0.0d);
        BigDecimal go_ec=new BigDecimal(0.0d);
        BigDecimal ga_ec=new BigDecimal(0.0d);
        BigDecimal u_ec=new BigDecimal(0.0d);
        BigDecimal total_ec=new BigDecimal(0.0d);
        int item=0;
        if(!getListDestructura_costos_recursos().isEmpty()){
//            subtotal_ec=getListDestructura_costos_recursos().get(0).getSubtotal();
//            total_ec=getListDestructura_costos_recursos().get(0).getPu();
            subtotal_ec=new BigDecimal(getListDestructura_costos_recursos().get(0).getSubtotal());
            total_ec=new BigDecimal(getListDestructura_costos_recursos().get(0).getPu());
            for(Destructura_costos_recursos ob : getListDestructura_costos_recursos()){
                if(ob.getEs_porcentaje()==1.0f){
                    switch(item){
                        case 0:go_ec=new BigDecimal(ob.getPorcentaje()).setScale(2, RoundingMode.HALF_EVEN);break;
                        case 1:ga_ec=new BigDecimal(ob.getPorcentaje()).setScale(2, RoundingMode.HALF_EVEN);break;
                        case 2:u_ec=new BigDecimal(ob.getPorcentaje()).setScale(2, RoundingMode.HALF_EVEN);break;
                    }
                    item++;
                }
            }
        }
        /*RESULTADOS*/
        this.setSubtotal_ecosto(subtotal_ec.floatValue());
        this.setGo_ecosto(go_ec.floatValue());
        this.setGa_ecosto(ga_ec.floatValue());
        this.setU_ecosto(u_ec.floatValue());
        this.total_ecosto = new BigDecimal(getSubtotal_ecosto()+getGo_ecosto()+getGa_ecosto()+getU_ecosto()+this.getAjuste_ecosto()).setScale(2, RoundingMode.HALF_EVEN).floatValue();
//        this.total_ecosto = getSubtotal_ecosto()+getGo_ecosto()+getGa_ecosto()+getU_ecosto();
    }
    public List<Unimedida> completeText(String query) { /*BUSCAR IDMEDIDA / DESCRIPCION /NOMBRE_CORTO */
        List<Unimedida> filtro = new ArrayList<Unimedida>();
        for(Unimedida obj:listUnimedida) {
            if(obj.getIdmedida().contains(query) || obj.getDescripcion().contains(query)|| obj.getNombre_corto().contains(query)){
                filtro.add(obj);
            }
        }
        return filtro;
    }
    public void onItemSelect(SelectEvent event) {
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
    public void onFormularioEstructuraCostosRecursosDetalle(){
        if(getSelecteEstructura_costos_mano_obra()!=null){
            listEstructura_costos_mano_obra_detallado= listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_detallado_action();
            selectEstructura_costos_mano_obra_detallado = new Estructura_costos_mano_obra_detallado();
            setBotonEliminarEstructura_costos_mano_obra_detalle(true);
            RequestContext.getCurrentInstance().update("datos:dlgEstructura_costos_mano_obra_detallado");
            RequestContext.getCurrentInstance().execute("PF('dlgEstructura_costos_mano_obra_detallado').show()");
        }
    }
    public void grabar_estructura_costos_diasrango() {
        try {
            mensaje=getEstructura_costos_producto_diasrangoDao().grabar( 
                        getDatoEdicion().getIdempresa(),
                        getDatoEdicion().getCodigo(),
                        listEstructura_costos_producto_diasrango,
                        user.getIDUSUARIO());
            RequestContext.getCurrentInstance().execute("PF('dlgEstructura_costos_producto_diasrango').hide()");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    /****************************** ESTRUCTURA COSTOS PRODUCTO DIAS X RANGO******************************/
    public void onFormularioEstructuraCostosProductoDiasRango(){
        try {
            if(getEstructura_costos_producto()!=null){
                listEstructura_costos_producto_diasrango = estructura_costos_producto_diasrangoDao.listarPorEmpresaWeb(getEstructura_costos_producto().getIdempresa(),
                        getEstructura_costos_producto().getCodigo(), getEstructura_costos_producto().getIdproducto(), getEstructura_costos_producto().getItem(),
                        getEstructura_costos_producto().getNhoras(), getEstructura_costos_producto().getCodoperativo(), getEstructura_costos_producto().getIdruta());
                RequestContext.getCurrentInstance().update("datos:dlgEstructura_costos_producto_diasrango");
                RequestContext.getCurrentInstance().execute("PF('dlgEstructura_costos_producto_diasrango').show()");
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    /************COPIAR ESTRUCTURA COSTOS DE OTRO CLIENTE**************/
    public void openDialogCopyEstructura(){
        selectClieprov_copy = new Clieprov();
        listEstructura_costos_producto_copy = new ArrayList<>();
        selectlistEstructura_costos_producto_copy = new ArrayList<>();
        RequestContext.getCurrentInstance().update("datos:dlgnew_copy_estructura_costos");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_copy_estructura_costos').show()");
    }
    public void valorClieprov_copy(SelectEvent event) {
        selectClieprov_copy = (Clieprov) event.getObject();
    }
    public void cargarEstructuraCostos(){
        if(selectClieprov_copy==null){
            mensaje = "Seleccionar Cliente";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            try {
                listEstructura_costos_producto_copy = estructura_costos_productoDao.listarPorEmpresaWebXcodigoXidclieprov(user.getIDEMPRESA(), selectClieprov_copy.getIdclieprov());
                selectlistEstructura_costos_producto_copy = new ArrayList<>();
                RequestContext.getCurrentInstance().update("datos:dlgnew_copy_estructura_costos:listEstructura_costos_producto_copy");
            } catch (NisiraORMException ex) {
                mensaje = ex.getMessage();
                Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }
        }
    }
    public void asignacionEstucturaCostosCopy(){
        try {
            if(selectlistEstructura_costos_producto_copy.isEmpty()){
                mensaje = "Seleccionar Estructuras";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                /*AGREGAR CAMPOS ADICIONALES , CUANDO EXISTA ESTRUCTURA*/
                List<Estructura_costos_producto> tempEstructura_costos_producto = new ArrayList<>();
                if(!listEstructura_costos_producto.isEmpty()){
                    for(int i=0;i<selectlistEstructura_costos_producto_copy.size();i++){
                        Estructura_costos_producto ecp = new Estructura_costos_producto();
                        ecp.setIdempresa(selectlistEstructura_costos_producto_copy.get(i).getIdempresa());
                        ecp.setCodigo(getDatoEdicion().getCodigo());
                        ecp.setDescripcion(selectlistEstructura_costos_producto_copy.get(i).getDescripcion());
                        ecp.setCodoperativo(selectlistEstructura_costos_producto_copy.get(i).getCodoperativo());
                        ecp.setNhoras(selectlistEstructura_costos_producto_copy.get(i).getNhoras());
                        //ecp.setIdruta(selectlistEstructura_costos_producto_copy.get(i).getIdruta());
                        ecp.setIdproducto(selectlistEstructura_costos_producto_copy.get(i).getIdproducto());
                        ecp.setProducto(selectlistEstructura_costos_producto_copy.get(i).getProducto());
                        ecp.setItem(agregarItemEstructuraCostosProducto(ecp));
                        tempEstructura_costos_producto.add(ecp); 
                    }
                    listEstructura_costos_producto.addAll(tempEstructura_costos_producto);
                    recalcularNumeroProducto();
                    selectEstructura_costos_producto = tempEstructura_costos_producto.get(0);
                    for(int i=0;i<selectlistEstructura_costos_producto_copy.size();i++){
                        Estructura_costos_producto obj = selectlistEstructura_costos_producto_copy.get(i);
                        Estructura_costos_producto obj_original = tempEstructura_costos_producto.get(i);
                        List<Destructura_costos_recursos> lstDestructura_costos_recursos = destructura_costos_recursosDao.listarPorEmpresaWebXProducto(obj.getIdempresa(), obj.getCodigo(),
                                obj.getIdproducto(), obj.getItem());
                        if(!lstDestructura_costos_recursos.isEmpty()){
                            for(int x1=0;x1<lstDestructura_costos_recursos.size();x1++){
                                Destructura_costos_recursos decr = lstDestructura_costos_recursos.get(x1);
                                decr.setCodigo(getDatoEdicion().getCodigo());
                                decr.setItemrango(obj_original.getItem());
                                listTotalDestructura_costos_recursos.add(decr);
                            }
                            //listTotalDestructura_costos_recursos.addAll(lstDestructura_costos_recursos);
                        }
                        List<Estructura_costos_mano_obra> lstEstructura_costos_mano_obra = estructura_costos_mano_obraDao.listarPorEmpresaWebXproducto(obj.getIdempresa(), obj.getCodigo(), 
                                obj.getIdproducto(), obj.getItem());
                        if(!lstEstructura_costos_mano_obra.isEmpty()){
                            for(int x1=0;x1<lstEstructura_costos_mano_obra.size();x1++){
                                Estructura_costos_mano_obra decmo = lstEstructura_costos_mano_obra.get(x1);
                                decmo.setCodigo(getDatoEdicion().getCodigo());
                                decmo.setItemrango(obj_original.getItem());
                                listTotalEstructura_costos_mano_obra.add(decmo);
                            }
                            //listTotalEstructura_costos_mano_obra.addAll(lstEstructura_costos_mano_obra);
                        }
                    }
                }else{
                    listEstructura_costos_producto = selectlistEstructura_costos_producto_copy;
                    selectEstructura_costos_producto = listEstructura_costos_producto.get(0);
                    listTotalDestructura_costos_recursos = new ArrayList<>();
                    listTotalEstructura_costos_mano_obra = new ArrayList<>();
                    for(int i=0;i<selectlistEstructura_costos_producto_copy.size();i++){
                        Estructura_costos_producto obj = selectlistEstructura_costos_producto_copy.get(i);
                        List<Destructura_costos_recursos> lstDestructura_costos_recursos = destructura_costos_recursosDao.listarPorEmpresaWebXProducto(obj.getIdempresa(), obj.getCodigo(),
                                obj.getIdproducto(), obj.getItem());
                        if(!lstDestructura_costos_recursos.isEmpty())
                            listTotalDestructura_costos_recursos.addAll(lstDestructura_costos_recursos);
                        List<Estructura_costos_mano_obra> lstEstructura_costos_mano_obra = estructura_costos_mano_obraDao.listarPorEmpresaWebXproducto(obj.getIdempresa(), obj.getCodigo(), 
                                obj.getIdproducto(), obj.getItem());
                        if(!lstEstructura_costos_mano_obra.isEmpty())
                            listTotalEstructura_costos_mano_obra.addAll(lstEstructura_costos_mano_obra);
                    }
                }
                if(getSelectEstructura_costos_producto()!=null){
                    listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
                    listEstructura_costos_mano_obra = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action();
                    calculosTotales_estructuracostos_local();
                }
                RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
                RequestContext.getCurrentInstance().update("datos:dlgnew_copy_estructura_costos");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_copy_estructura_costos').hide()");
                RequestContext.getCurrentInstance().update("datos:tabs");
                RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        
    }
    /************MANTENIMIENTO - CLIEPROV**************/
    public void nuevoEstructuraCostosClieprov() {
        setEstructura_costos_clieprov(new Estructura_costos_clieprov());
        getEstructura_costos_clieprov().setIdempresa(user.getIDEMPRESA());
        getEstructura_costos_clieprov().setCodigo(getDatoEdicion().getCodigo());
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_clieprov");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_clieprov').show()");
    }
    public void editarEstructuraCostosClieprov() {
        setEstructura_costos_clieprov(selectEstructura_costos_clieprov);
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_clieprov");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_clieprov').show()");
    }
    public void eliminarEstructuraCostosClieprov() {
        try {
            listEstructura_costos_clieprov.remove(selectEstructura_costos_clieprov);
            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_clieprov");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void grabarEstructuraCostosClieprov(){
        try {
            if(estructura_costos_clieprov.getIdclieprov().isEmpty()){
                mensaje = "Seleccionar Cliente";
                WebUtil.error(mensaje);
            }else{
                int pos=listEstructura_costos_clieprov.indexOf(estructura_costos_clieprov);
                if(pos==-1){
                    if(existeCliente(estructura_costos_clieprov.getIdclieprov())){
                        mensaje = "Cliente repetido";
                        WebUtil.error(mensaje);
                    }else{
                        listEstructura_costos_clieprov.add(estructura_costos_clieprov);
                    }
                }
                else
                    listEstructura_costos_clieprov.set(pos, estructura_costos_clieprov);
                RequestContext.getCurrentInstance().update("datos:listEstructura_costos_clieprov");
                RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_clieprov");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_clieprov').hide()");
            }
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        Clieprov ob = (Clieprov) event.getObject();
        getEstructura_costos_clieprov().setIdclieprov(ob.getIdclieprov());
        getEstructura_costos_clieprov().setRazon_social(ob.getRazonsocial());
    }
    /************MANTENIMIENTO - PRODUCTO**************/
    public void nuevoEstructuraCostosProducto() {
        setEstructura_costos_producto(new Estructura_costos_producto());
        getEstructura_costos_producto().setIdempresa(user.getIDEMPRESA());
        getEstructura_costos_producto().setCodigo(getDatoEdicion().getCodigo());
        getEstructura_costos_producto().setNhoras(0.0f);
        //getEstructura_costos_producto().setItem(agregarItemEstructuraCostosProducto());
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_producto");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_producto').show()");
    }
    public void editarEstructuraCostosProducto() {
        setEstructura_costos_producto(selectEstructura_costos_producto);
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_producto");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_producto').show()");
    }
    public void eliminarEstructuraCostosProducto() {
        try {
            eliminarEstructuraCostosProducto_Recursos_mano_obra_detalle();
            listEstructura_costos_producto.remove(selectEstructura_costos_producto);
            listDestructura_costos_recursos = new ArrayList<>();
            listEstructura_costos_mano_obra = new ArrayList<>();
            setSelectEstructura_costos_producto(new Estructura_costos_producto());
            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
            RequestContext.getCurrentInstance().update("datos:tabs");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarEstructuraCostosProducto_Recursos_mano_obra_detalle(){
        if(selectEstructura_costos_producto!=null){
            List<Destructura_costos_recursos> lst_Destructura_costos_recursos_delete = new ArrayList<>();
            for(Destructura_costos_recursos decr : listTotalDestructura_costos_recursos){
                if(selectEstructura_costos_producto.getIdempresa().trim().equals(decr.getIdempresa()) &&
                        selectEstructura_costos_producto.getItem().trim().equals(decr.getItemrango()) &&
                        selectEstructura_costos_producto.getIdproducto().trim().equals(decr.getIdproducto_ec())){
                    lst_Destructura_costos_recursos_delete.add(decr);
                }
            }
            if(!lst_Destructura_costos_recursos_delete.isEmpty())
                listTotalDestructura_costos_recursos.removeAll(lst_Destructura_costos_recursos_delete);
            List<Estructura_costos_mano_obra> lst_Estructura_costos_mano_obra_delete = new ArrayList<>();
            for(Estructura_costos_mano_obra ecmo :listTotalEstructura_costos_mano_obra){
                if(selectEstructura_costos_producto.getIdempresa().trim().equals(ecmo.getIdempresa()) &&
                        selectEstructura_costos_producto.getItem().trim().equals(ecmo.getItemrango()) &&
                        selectEstructura_costos_producto.getIdproducto().trim().equals(ecmo.getIdproducto())){
                    lst_Estructura_costos_mano_obra_delete.add(ecmo);
                }
            }
            if(!lst_Estructura_costos_mano_obra_delete.isEmpty()){
                listTotalEstructura_costos_mano_obra.removeAll(lst_Estructura_costos_mano_obra_delete);
            }
            List<Estructura_costos_mano_obra_detallado> lst_Estructura_costos_mano_obra_detallado_delete = new ArrayList();
            for(Estructura_costos_mano_obra_detallado ecmod:listTotalEstructura_costos_mano_obra_detallado){
                if(selectEstructura_costos_producto.getIdempresa().trim().equals(ecmod.getIdempresa()) &&
                        selectEstructura_costos_producto.getItem().trim().equals(ecmod.getItemrango()) &&
                        selectEstructura_costos_producto.getCodoperativo().trim().equals(ecmod.getCodoperativo()) &&
                        selectEstructura_costos_producto.getNhoras().floatValue() == ecmod.getNhoras().floatValue() && 
                        selectEstructura_costos_producto.getIdruta().trim().equals(ecmod.getIdruta().trim())
                  ){
                    lst_Estructura_costos_mano_obra_detallado_delete.add(ecmod);
                }
            }
            if(!lst_Estructura_costos_mano_obra_detallado_delete.isEmpty())
                listTotalEstructura_costos_mano_obra_detallado.removeAll(lst_Estructura_costos_mano_obra_detallado_delete);
        }
    }
    public void grabarEstructuraCostosProducto(){
        if(estructura_costos_producto.getIdproducto().isEmpty()){
            mensaje = "Seleccionar Servicio";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        else if(estructura_costos_producto.getCodoperativo().isEmpty()){
            mensaje = "Ingresar codigo operativo";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        else{
            int pos=listEstructura_costos_producto.indexOf(estructura_costos_producto);
            if(pos==-1){
                /* GENERAR ITEM -> ESTRUCTURA COSTOS PRODUCTO*/
                String item=agregarItemEstructuraCostosProducto(estructura_costos_producto);
                estructura_costos_producto.setItem(item);
                listEstructura_costos_producto.add(estructura_costos_producto);
            }
            else
                listEstructura_costos_producto.set(pos, estructura_costos_producto);
            recalcularNumeroProducto();
            RequestContext.getCurrentInstance().update("datos:listEstructura_costos_producto");
            RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_producto");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_producto').hide()");
        }
        
    }
    public void verCntProducto() {
        RequestContext.getCurrentInstance().openDialog("cntProducto", modalOptions, null);
    }
    public void valorProducto(SelectEvent event) {
        Producto pro = (Producto) event.getObject();
        getEstructura_costos_producto().setIdproducto(pro.getIdproducto());
        getEstructura_costos_producto().setProducto(pro.getDescripcion());
        return;
    }
    public void recalcularNumeroProducto(){
        int num=1;
        if(!listEstructura_costos_producto.isEmpty()){
            for(Estructura_costos_producto ob :listEstructura_costos_producto){
                ob.setNumerador(num);
                num++;
            }
        }
    }
    /************MANTENIMIENTO - DESTRUCTURA - COSTOS - RECURSO **************/
    public void actualizarDestructuraCostosRecurso() {
        listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
        calculosTotales_estructuracostos_local();
        RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos");
        RequestContext.getCurrentInstance().update("datos:tabs:subtotal_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:go_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:ga_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:u_ecosto");
        RequestContext.getCurrentInstance().update("datos:tabs:total_ecosto");
    }
    public void agregarDestructuraCostosRecurso() {
        if(getSelectEstructura_costos_producto()!=null){
            setDestructura_costos_recursos(new Destructura_costos_recursos());
            getDestructura_costos_recursos().setIdempresa(user.getIDEMPRESA());
            getDestructura_costos_recursos().setCodigo(getDatoEdicion().getCodigo());
            getDestructura_costos_recursos().setItem(agregarItemDestructuraCostosRecurso());
            getDestructura_costos_recursos().setEs_porcentaje(0.0f);
            getDestructura_costos_recursos().setCantidad(1.0f);
            getDestructura_costos_recursos().setCosto(0.0f);
            getDestructura_costos_recursos().setIdproducto_ec(getSelectEstructura_costos_producto().getIdproducto());
            getDestructura_costos_recursos().setTipo_recurso("CO");
            getDestructura_costos_recursos().setItemrango(getSelectEstructura_costos_producto().getItem());
            /*cambio a total*/
            getListTotalDestructura_costos_recursos().add(destructura_costos_recursos);
            listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
//            getListDestructura_costos_recursos().add(destructura_costos_recursos);
            RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos");
//            tabView.setActiveIndex(indexTab);
//            RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
        }else{
            mensaje = "Seleccionar Estructura - Costos - Producto";
            WebUtil.error(mensaje);
        }
    }
    public void eliminarDestructuraCostosRecurso() {
        try {
            listTotalDestructura_costos_recursos.remove(selectDestructura_costos_recursos);
            listDestructura_costos_recursos = listarPorEmpresaWebXProducto_Destructura_costos_recursos_action();
            resetIndices_DestructuraCostosRecurso();
            calculosTotales_estructuracostos_local();
            RequestContext.getCurrentInstance().update("datos:tabs:listDestructura_costos_recursos");
            RequestContext.getCurrentInstance().update("datos:subtotal_ecosto");
            RequestContext.getCurrentInstance().update("datos:go_ecosto");
            RequestContext.getCurrentInstance().update("datos:ga_ecosto");
            RequestContext.getCurrentInstance().update("datos:u_ecosto");
            RequestContext.getCurrentInstance().update("datos:total_ecosto");
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /************MANTENIMIENTO - ESTRUCTURA COSTOS MANO OBRA**************/
    public void nuevoEstructuraCostosManoObra() {
        if(getSelectEstructura_costos_producto()!=null){
            setEstructura_costos_mano_obra(new Estructura_costos_mano_obra());
            getEstructura_costos_mano_obra().setIdempresa(user.getIDEMPRESA());
            getEstructura_costos_mano_obra().setCodigo(getDatoEdicion().getCodigo());
            getEstructura_costos_mano_obra().setItem(agregarItemEstructuraCostosManoObra());
            getEstructura_costos_mano_obra().setItemrango(getSelectEstructura_costos_producto().getItem());
            getEstructura_costos_mano_obra().setIdproducto(getSelectEstructura_costos_producto().getIdproducto());
            getEstructura_costos_mano_obra().setCosto(0.00f);
            costo_mano_obra = 0.0f;
            RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').show()");
        }else{
            mensaje = "Seleccionar Estructura - Costos - Producto";
            WebUtil.error(mensaje);
        }
        
    }
    public void editarEstructuraCostosManoObra() {
        costo_mano_obra = selecteEstructura_costos_mano_obra.getCosto();
        estructura_costos_mano_obra=selecteEstructura_costos_mano_obra;
        RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
        RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').show()");
    }
    public void eliminarEstructuraCostosManoObra() {
        try {
            eliminarEstructuraCostos_mano_obra_detalle();
            listTotalEstructura_costos_mano_obra.remove(selecteEstructura_costos_mano_obra);
            listEstructura_costos_mano_obra = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action();
            RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra");
//            tabView.setActiveIndex(indexTab);
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarEstructuraCostos_mano_obra_detalle(){
        if(selecteEstructura_costos_mano_obra !=null && selectEstructura_costos_producto!=null){
            List<Estructura_costos_mano_obra_detallado> lst_Estructura_costos_mano_obra_detallado_delete = new ArrayList();
            for(Estructura_costos_mano_obra_detallado ecmod:listTotalEstructura_costos_mano_obra_detallado){
                if(selecteEstructura_costos_mano_obra.getIdempresa().trim().equals(ecmod.getIdempresa()) &&
                        selecteEstructura_costos_mano_obra.getItemrango().trim().equals(ecmod.getItemrango()) &&
                        selecteEstructura_costos_mano_obra.getItem().equals(ecmod.getItem())&&
                        selectEstructura_costos_producto.getCodoperativo().trim().equals(ecmod.getCodoperativo()) &&
                        selectEstructura_costos_producto.getNhoras().floatValue() == ecmod.getNhoras().floatValue() && 
                        selectEstructura_costos_producto.getIdruta().trim().equals(ecmod.getIdruta().trim())
                  ){
                    lst_Estructura_costos_mano_obra_detallado_delete.add(ecmod);
                }
            }
            if(!lst_Estructura_costos_mano_obra_detallado_delete.isEmpty())
                listTotalEstructura_costos_mano_obra_detallado.removeAll(lst_Estructura_costos_mano_obra_detallado_delete);
        }
    }
    public void grabarEstructuraCostosManoObra(){
        if(estructura_costos_mano_obra.getIdcargo().isEmpty()){
            mensaje = "Seleccionar Cargo";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos");
        }
        else{
            estructura_costos_mano_obra.setCosto(this.costo_mano_obra);
            int pos=listTotalEstructura_costos_mano_obra.indexOf(estructura_costos_mano_obra);
            if(pos==-1)
                listTotalEstructura_costos_mano_obra.add(estructura_costos_mano_obra);
            else 
                listTotalEstructura_costos_mano_obra.set(pos, estructura_costos_mano_obra);
            listEstructura_costos_mano_obra = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_action();
            RequestContext.getCurrentInstance().update("datos:tabs:listEstructura_costos_mano_obra");
            RequestContext.getCurrentInstance().update("datos:dlgnew_estructura_costos_mano_obra");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_estructura_costos_mano_obra').hide()");
        }
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalOptions, null);
    }
    public void valorCargos_personal(SelectEvent event) {
        Cargos_personal cargo = (Cargos_personal) event.getObject();
        this.getEstructura_costos_mano_obra().setIdcargo(cargo.getIdcargo());
        this.getEstructura_costos_mano_obra().setCargo(cargo.getDescripcion());
        return;
    }
    /************MANTENIMIENTO - ESTRUCTURA COSTOS MANO OBRA _ DETALLADO**************/
    public void onCellEdit_Mano_Obra(CellEditEvent event) {
        try {
            Object newValue = event.getNewValue();
            Estructura_costos_mano_obra_detallado entity =(Estructura_costos_mano_obra_detallado)((DataTable)event.getComponent()).getRowData();
            int pos = listEstructura_costos_mano_obra_detallado.indexOf(entity);
            String colHead = event.getColumn().getHeaderText().trim();
            switch(colHead){
                case "Hora Inicio":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        /*ASIGNARLE VALOR*/
                        //Date fhorai = WebUtil.convertStringTime(newValue.toString());
                        entity.setShorai(newValue.toString());
                    }else{
                        entity.setShorai("00:00");
                    }
                    break;
                case "Hora Fin":
                    /*VALIDAR FORMATO DE TIME*/
                    if(WebUtil.validateTime(newValue.toString())){
                        Date fhoraf = WebUtil.convertStringTime(newValue.toString());
                        entity.setShoraf(newValue.toString());
                        if(!newValue.toString().trim().equals("00:00")){
                            Date fhorai = WebUtil.convertStringTime(entity.getShorai());
                            if(WebUtil.compareToDate(fhorai,fhoraf)>0 &&
                                WebUtil.compareToDate(fhorai,fhoraf)!=-2){
                                entity.setShoraf(entity.getShorai());
                            }else{
                                entity.setShoraf(newValue.toString());
                            }
                        }
                    }else{
                        entity.setShoraf("00:00");
                    }
                    break;
            }
            if(entity.getShorai()!=null){
                Date fhorai = WebUtil.convertStringTime(entity.getShorai());
                entity.setHorai(WebUtil.convertTimeDecimal(fhorai));
            }
            else
                entity.setHoraf(0.0f);
            if(entity.getShoraf()!=null){
                Date fhoraf = WebUtil.convertStringTime(entity.getShoraf());
                entity.setHoraf(WebUtil.convertTimeDecimal(fhoraf));
            }
            else
                entity.setHoraf(0.0f);
        }catch(ParseException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void agregarEstructuraCostosManoObra_detallado() {
        if(getSelecteEstructura_costos_mano_obra()!=null){
            setEstructura_costos_mano_obra_detallado(new Estructura_costos_mano_obra_detallado());
            getEstructura_costos_mano_obra_detallado().setIdempresa(getSelecteEstructura_costos_mano_obra().getIdempresa());
            getEstructura_costos_mano_obra_detallado().setCodigo(getSelecteEstructura_costos_mano_obra().getCodigo());
            getEstructura_costos_mano_obra_detallado().setItemrango(getSelecteEstructura_costos_mano_obra().getItemrango());
            getEstructura_costos_mano_obra_detallado().setItem_ecm(getSelecteEstructura_costos_mano_obra().getItem());
            getEstructura_costos_mano_obra_detallado().setItem(agregarItemEstructuraCostosManoObra_detallado());
            getEstructura_costos_mano_obra_detallado().setCosto(0.0f);
            getEstructura_costos_mano_obra_detallado().setShorai("00:00");
            getEstructura_costos_mano_obra_detallado().setShoraf("00:00");
            getEstructura_costos_mano_obra_detallado().setHorai(0.0f);
            getEstructura_costos_mano_obra_detallado().setHoraf(0.0f);
            getEstructura_costos_mano_obra_detallado().setIdcargo(getSelecteEstructura_costos_mano_obra().getIdcargo());
            getEstructura_costos_mano_obra_detallado().setNhoras(getSelectEstructura_costos_producto().getNhoras());
            getEstructura_costos_mano_obra_detallado().setCodoperativo(getSelectEstructura_costos_producto().getCodoperativo());
            getEstructura_costos_mano_obra_detallado().setIdruta(getSelectEstructura_costos_producto().getIdruta());
            listTotalEstructura_costos_mano_obra_detallado.add(getEstructura_costos_mano_obra_detallado());
            listEstructura_costos_mano_obra_detallado= listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_detallado_action();
//            RequestContext.getCurrentInstance().update("datos:dlgEstructura_costos_mano_obra_detallado");
        }else{
            mensaje = "Seleccionar Estructura - Costos - Mano - Obra";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void eliminarEstructuraCostosManoObra_detallado(){
        if(getSelectEstructura_costos_mano_obra_detallado()!=null){
            listTotalEstructura_costos_mano_obra_detallado.remove(getSelectEstructura_costos_mano_obra_detallado());
            listEstructura_costos_mano_obra_detallado= listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_detallado_action();
        }else{
            mensaje = "Seleccionar Detalle de Rango";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void replicarEstructuraCostosManoObra_detallado(){
        if(getSelecteEstructura_costos_mano_obra()!=null){
            List<Estructura_costos_mano_obra_detallado> lst = listarPorEmpresaWebXProducto_Estructura_costos_mano_obra_detallado_action();
            Estructura_costos_mano_obra_detallado ecmd;
            if(!lst.isEmpty()){
                List<Estructura_costos_mano_obra> lst_temp = new ArrayList<>();
                List<Estructura_costos_mano_obra_detallado> lst_temp_det = new ArrayList<>();
                lst_temp.addAll(listEstructura_costos_mano_obra);
                /**QUITAR ESTRUCTURA COSTOS MANO OBRA SELECCIONADO***/
                lst_temp.remove(getSelecteEstructura_costos_mano_obra());
                for(Estructura_costos_mano_obra ob :lst_temp){
                    for(Estructura_costos_mano_obra_detallado x : lst){
                        ecmd = new Estructura_costos_mano_obra_detallado();
                        ecmd.setIdempresa(x.getIdempresa());
                        ecmd.setCodigo(x.getCodigo());
                        ecmd.setItemrango(ob.getItemrango());
                        ecmd.setItem_ecm(ob.getItem());
                        ecmd.setItem(x.getItem());
                        ecmd.setHorai(x.getHorai());
                        ecmd.setHoraf(x.getHoraf());
                        ecmd.setCosto(x.getCosto());
                        ecmd.setIdcargo(ob.getIdcargo());
                        ecmd.setCargo(ob.getCargo());
                        ecmd.setShorai(x.getShorai());
                        ecmd.setShoraf(x.getShoraf());
                        ecmd.setNhoras(x.getNhoras());
                        ecmd.setCodoperativo(x.getCodoperativo());
                        ecmd.setIdruta(x.getIdruta());
                        lst_temp_det.add(ecmd);
                    }
                }
                /* LIMPIAR ESTRUCTURA_COSTOS_MANO_OBRA_DETALLADO POR ESTRUCTURA_COSTOS_MANO_OBRA*/
                List<Estructura_costos_mano_obra_detallado> lst_temp_detallado= new ArrayList<>();
                boolean tfalg;
                for(Estructura_costos_mano_obra_detallado dt:lst_temp_det){
                    tfalg = true;
                    for(int i=0;i<listTotalEstructura_costos_mano_obra_detallado.size();i++){
                        Estructura_costos_mano_obra_detallado risk = listTotalEstructura_costos_mano_obra_detallado.get(i);
                        if(dt.getIdempresa().trim().equals(risk.getIdempresa().trim()) &&
                            dt.getIdcargo().trim().equals(risk.getIdcargo()) &&
                            dt.getItemrango().trim().equals(risk.getItemrango()) &&
                            dt.getItem_ecm().trim().equals(risk.getItem_ecm()) &&
                            dt.getItem().trim().equals(risk.getItem().trim()) &&
                            dt.getNhoras() == risk.getNhoras() &&
                            (dt.getCodoperativo()==null?"":dt.getCodoperativo()).trim().equals((risk.getCodoperativo()==null?"":risk.getCodoperativo()).trim()) &&
                            (dt.getIdruta()==null?"":dt.getIdruta()).trim().equals((risk.getIdruta()==null?"":risk.getIdruta()).trim())
                            ){
                            listTotalEstructura_costos_mano_obra_detallado.set(i, dt);
                            tfalg = false;
                            break;
                        }
                    }
                    if(tfalg)
                        listTotalEstructura_costos_mano_obra_detallado.add(dt);
                }
                
                listTotalEstructura_costos_mano_obra_detallado.addAll(lst_temp_detallado);
            }else{
                mensaje = "Estructura_costo_mano_obra no tiene rango definido";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }
        }
    }
    /***************** GENERADOR ID *********************/
    public String agregarItemEstructuraCostosProducto(Estructura_costos_producto t){
            int dato = 1;
            int may=-999999999;
            for(Estructura_costos_producto obj:getListEstructura_costos_producto()){
                if(obj.getIdempresa().trim().equalsIgnoreCase(t.getIdempresa().trim()) &&
                      obj.getIdproducto().trim().equalsIgnoreCase(t.getIdproducto().trim())){
                    dato = Integer.parseInt(obj.getItem());
                if(dato>may)
                    may=dato;
                }
            }
            if(may==-999999999)
                may=1;
            else
                may++;
            return WebUtil.idGeneradoTres(may);
        }    
    public String agregarItemDestructuraCostosRecurso(){
        int dato = 1;
        int may=-999999999;
        for(Destructura_costos_recursos obj:getListDestructura_costos_recursos()){
            dato = Integer.parseInt(obj.getItem());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemEstructuraCostosManoObra(){
        int dato = 1;
        int may=-999999999;
        for(Estructura_costos_mano_obra obj:getListEstructura_costos_mano_obra()){
            dato = Integer.parseInt(obj.getItem());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    public String agregarItemEstructuraCostosManoObra_detallado(){
        int dato = 1;
        int may=-999999999;
        for(Estructura_costos_mano_obra_detallado obj:getListEstructura_costos_mano_obra_detallado()){
            dato = Integer.parseInt(obj.getItem());
            if(dato>may)
                may=dato;
        }
        if(may==-999999999)
            may=1;
        else
            may++;
        
        return WebUtil.idGeneradoTres(may);
    }
    /*********************************************************************/
    public void verCntRuta() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }
    public void valorRuta(SelectEvent event) {
        this.setSelectRutas((Rutas) event.getObject());
        this.estructura_costos_producto.setIdruta(selectRutas.getIdruta());
        this.estructura_costos_producto.setDescripcion_ruta(selectRutas.getDescripcion());
    }
    public void verCntclearRuta(){
        this.estructura_costos_producto.setIdruta("");
        this.estructura_costos_producto.setDescripcion_ruta("");
    }
    /***************** RECALCULAR INDICES*********************/ 
    public void resetIndices_DestructuraCostosRecurso(){
        List<Destructura_costos_recursos> temp = new ArrayList<>();
        /**** INSERTAR NO PORCENTAJE******/
        for(int i=0 ; i<getListDestructura_costos_recursos().size();i++){
            Destructura_costos_recursos ob =getListDestructura_costos_recursos().get(i);
            if(ob.getEs_porcentaje()==0.0f){
                ob.setItem(WebUtil.idGeneradoTres(i+1));
                temp.add(ob);
            }
        }
        /**** INSERTAR PORCENTAJE******/
        int es_porcentaje=temp.size();
        for(int i=0 ; i<getListDestructura_costos_recursos().size();i++){
            Destructura_costos_recursos ob =getListDestructura_costos_recursos().get(i);
            if(ob.getEs_porcentaje()==1.0f){
                ob.setItem(WebUtil.idGeneradoTres(es_porcentaje+1));
                temp.add(ob);
                es_porcentaje++;
            }
        }
        listDestructura_costos_recursos=temp;
        RequestContext.getCurrentInstance().update("datos:listDestructura_costos_recursos");
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
     * @return the estructura_costos_clieprovDao
     */
    public Estructura_costos_clieprovDao getEstructura_costos_clieprovDao() {
        return estructura_costos_clieprovDao;
    }

    /**
     * @param estructura_costos_clieprovDao the estructura_costos_clieprovDao to set
     */
    public void setEstructura_costos_clieprovDao(Estructura_costos_clieprovDao estructura_costos_clieprovDao) {
        this.estructura_costos_clieprovDao = estructura_costos_clieprovDao;
    }

    /**
     * @return the estructura_costos_productoDao
     */
    public Estructura_costos_productoDao getEstructura_costos_productoDao() {
        return estructura_costos_productoDao;
    }

    /**
     * @param estructura_costos_productoDao the estructura_costos_productoDao to set
     */
    public void setEstructura_costos_productoDao(Estructura_costos_productoDao estructura_costos_productoDao) {
        this.estructura_costos_productoDao = estructura_costos_productoDao;
    }

    /**
     * @return the destructura_costos_recursosDao
     */
    public Destructura_costos_recursosDao getDestructura_costos_recursosDao() {
        return destructura_costos_recursosDao;
    }

    /**
     * @param destructura_costos_recursosDao the destructura_costos_recursosDao to set
     */
    public void setDestructura_costos_recursosDao(Destructura_costos_recursosDao destructura_costos_recursosDao) {
        this.destructura_costos_recursosDao = destructura_costos_recursosDao;
    }

    /**
     * @return the listEstructura_costos_producto
     */
    public List<Estructura_costos_producto> getListEstructura_costos_producto() {
        return listEstructura_costos_producto;
    }

    /**
     * @param listEstructura_costos_producto the listEstructura_costos_producto to set
     */
    public void setListEstructura_costos_producto(List<Estructura_costos_producto> listEstructura_costos_producto) {
        this.listEstructura_costos_producto = listEstructura_costos_producto;
    }

    /**
     * @return the listDestructura_costos_recursos
     */
    public List<Destructura_costos_recursos> getListDestructura_costos_recursos() {
        return listDestructura_costos_recursos;
    }

    /**
     * @param listDestructura_costos_recursos the listDestructura_costos_recursos to set
     */
    public void setListDestructura_costos_recursos(List<Destructura_costos_recursos> listDestructura_costos_recursos) {
        this.listDestructura_costos_recursos = listDestructura_costos_recursos;
    }

    /**
     * @return the selectEstructura_costos_producto
     */
    public Estructura_costos_producto getSelectEstructura_costos_producto() {
        return selectEstructura_costos_producto;
    }

    /**
     * @param selectEstructura_costos_producto the selectEstructura_costos_producto to set
     */
    public void setSelectEstructura_costos_producto(Estructura_costos_producto selectEstructura_costos_producto) {
        this.selectEstructura_costos_producto = selectEstructura_costos_producto;
    }

    /**
     * @return the selectDestructura_costos_recursos
     */
    public Destructura_costos_recursos getSelectDestructura_costos_recursos() {
        return selectDestructura_costos_recursos;
    }

    /**
     * @param selectDestructura_costos_recursos the selectDestructura_costos_recursos to set
     */
    public void setSelectDestructura_costos_recursos(Destructura_costos_recursos selectDestructura_costos_recursos) {
        this.selectDestructura_costos_recursos = selectDestructura_costos_recursos;
    }

    /**
     * @return the subtotal_ecosto
     */
    public Float getSubtotal_ecosto() {
        return subtotal_ecosto;
    }

    /**
     * @param subtotal_ecosto the subtotal_ecosto to set
     */
    public void setSubtotal_ecosto(Float subtotal_ecosto) {
        this.subtotal_ecosto = subtotal_ecosto;
    }

    /**
     * @return the go_ecosto
     */
    public Float getGo_ecosto() {
        return go_ecosto;
    }

    /**
     * @param go_ecosto the go_ecosto to set
     */
    public void setGo_ecosto(Float go_ecosto) {
        this.go_ecosto = go_ecosto;
    }

    /**
     * @return the ga_ecosto
     */
    public Float getGa_ecosto() {
        return ga_ecosto;
    }

    /**
     * @param ga_ecosto the ga_ecosto to set
     */
    public void setGa_ecosto(Float ga_ecosto) {
        this.ga_ecosto = ga_ecosto;
    }

    /**
     * @return the u_ecosto
     */
    public Float getU_ecosto() {
        return u_ecosto;
    }

    /**
     * @param u_ecosto the u_ecosto to set
     */
    public void setU_ecosto(Float u_ecosto) {
        this.u_ecosto = u_ecosto;
    }

    /**
     * @return the total_ecosto
     */
    public Float getTotal_ecosto() {
        return total_ecosto;
    }

    /**
     * @param total_ecosto the total_ecosto to set
     */
    public void setTotal_ecosto(Float total_ecosto) {
        this.total_ecosto = total_ecosto;
    }

    @Override
    public JRDataSource getDataSourceReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * @return the listEstructura_costos_clieprov
     */
    public List<Estructura_costos_clieprov> getListEstructura_costos_clieprov() {
        return listEstructura_costos_clieprov;
    }

    /**
     * @param listEstructura_costos_clieprov the listEstructura_costos_clieprov to set
     */
    public void setListEstructura_costos_clieprov(List<Estructura_costos_clieprov> listEstructura_costos_clieprov) {
        this.listEstructura_costos_clieprov = listEstructura_costos_clieprov;
    }

    /**
     * @return the selectEstructura_costos_clieprov
     */
    public Estructura_costos_clieprov getSelectEstructura_costos_clieprov() {
        return selectEstructura_costos_clieprov;
    }

    /**
     * @param selectEstructura_costos_clieprov the selectEstructura_costos_clieprov to set
     */
    public void setSelectEstructura_costos_clieprov(Estructura_costos_clieprov selectEstructura_costos_clieprov) {
        this.selectEstructura_costos_clieprov = selectEstructura_costos_clieprov;
    }

    /**
     * @return the estructura_costosDao
     */
    public Estructura_costosDao getEstructura_costosDao() {
        return estructura_costosDao;
    }

    /**
     * @param estructura_costosDao the estructura_costosDao to set
     */
    public void setEstructura_costosDao(Estructura_costosDao estructura_costosDao) {
        this.estructura_costosDao = estructura_costosDao;
    }

    /**
     * @return the estructura_costos_clieprov
     */
    public Estructura_costos_clieprov getEstructura_costos_clieprov() {
        return estructura_costos_clieprov;
    }

    /**
     * @param estructura_costos_clieprov the estructura_costos_clieprov to set
     */
    public void setEstructura_costos_clieprov(Estructura_costos_clieprov estructura_costos_clieprov) {
        this.estructura_costos_clieprov = estructura_costos_clieprov;
    }

    /**
     * @return the estructura_costos_producto
     */
    public Estructura_costos_producto getEstructura_costos_producto() {
        return estructura_costos_producto;
    }

    /**
     * @param estructura_costos_producto the estructura_costos_producto to set
     */
    public void setEstructura_costos_producto(Estructura_costos_producto estructura_costos_producto) {
        this.estructura_costos_producto = estructura_costos_producto;
    }

    /**
     * @return the destructura_costos_recursos
     */
    public Destructura_costos_recursos getDestructura_costos_recursos() {
        return destructura_costos_recursos;
    }

    /**
     * @param destructura_costos_recursos the destructura_costos_recursos to set
     */
    public void setDestructura_costos_recursos(Destructura_costos_recursos destructura_costos_recursos) {
        this.destructura_costos_recursos = destructura_costos_recursos;
    }

    /**
     * @return the botonEditarEstructura_costos_clieprov
     */
    public boolean isBotonEditarEstructura_costos_clieprov() {
        return botonEditarEstructura_costos_clieprov;
    }

    /**
     * @param botonEditarEstructura_costos_clieprov the botonEditarEstructura_costos_clieprov to set
     */
    public void setBotonEditarEstructura_costos_clieprov(boolean botonEditarEstructura_costos_clieprov) {
        this.botonEditarEstructura_costos_clieprov = botonEditarEstructura_costos_clieprov;
    }

    /**
     * @return the botonEliminarEstructura_costos_clieprov
     */
    public boolean isBotonEliminarEstructura_costos_clieprov() {
        return botonEliminarEstructura_costos_clieprov;
    }

    /**
     * @param botonEliminarEstructura_costos_clieprov the botonEliminarEstructura_costos_clieprov to set
     */
    public void setBotonEliminarEstructura_costos_clieprov(boolean botonEliminarEstructura_costos_clieprov) {
        this.botonEliminarEstructura_costos_clieprov = botonEliminarEstructura_costos_clieprov;
    }

    /**
     * @return the botonEditarEstructura_costos_producto
     */
    public boolean isBotonEditarEstructura_costos_producto() {
        return botonEditarEstructura_costos_producto;
    }

    /**
     * @param botonEditarEstructura_costos_producto the botonEditarEstructura_costos_producto to set
     */
    public void setBotonEditarEstructura_costos_producto(boolean botonEditarEstructura_costos_producto) {
        this.botonEditarEstructura_costos_producto = botonEditarEstructura_costos_producto;
    }

    /**
     * @return the botonEliminarEstructura_costos_producto
     */
    public boolean isBotonEliminarEstructura_costos_producto() {
        return botonEliminarEstructura_costos_producto;
    }

    /**
     * @param botonEliminarEstructura_costos_producto the botonEliminarEstructura_costos_producto to set
     */
    public void setBotonEliminarEstructura_costos_producto(boolean botonEliminarEstructura_costos_producto) {
        this.botonEliminarEstructura_costos_producto = botonEliminarEstructura_costos_producto;
    }

    /**
     * @return the botonNuevoDestructura_costos_recurso
     */
    public boolean isBotonNuevoDestructura_costos_recurso() {
        return botonNuevoDestructura_costos_recurso;
    }

    /**
     * @param botonNuevoDestructura_costos_recurso the botonNuevoDestructura_costos_recurso to set
     */
    public void setBotonNuevoDestructura_costos_recurso(boolean botonNuevoDestructura_costos_recurso) {
        this.botonNuevoDestructura_costos_recurso = botonNuevoDestructura_costos_recurso;
    }

    /**
     * @return the botonEditarDestructura_costos_recurso
     */
    public boolean isBotonEditarDestructura_costos_recurso() {
        return botonEditarDestructura_costos_recurso;
    }

    /**
     * @param botonEditarDestructura_costos_recurso the botonEditarDestructura_costos_recurso to set
     */
    public void setBotonEditarDestructura_costos_recurso(boolean botonEditarDestructura_costos_recurso) {
        this.botonEditarDestructura_costos_recurso = botonEditarDestructura_costos_recurso;
    }

    /**
     * @return the botonEliminarDestructura_costos_recurso
     */
    public boolean isBotonEliminarDestructura_costos_recurso() {
        return botonEliminarDestructura_costos_recurso;
    }

    /**
     * @param botonEliminarDestructura_costos_recurso the botonEliminarDestructura_costos_recurso to set
     */
    public void setBotonEliminarDestructura_costos_recurso(boolean botonEliminarDestructura_costos_recurso) {
        this.botonEliminarDestructura_costos_recurso = botonEliminarDestructura_costos_recurso;
    }

    /**
     * @return the lstTipoRecurso
     */
    public List<String> getLstTipoRecurso() {
        return lstTipoRecurso;
    }

    /**
     * @param lstTipoRecurso the lstTipoRecurso to set
     */
    public void setLstTipoRecurso(List<String> lstTipoRecurso) {
        this.lstTipoRecurso = lstTipoRecurso;
    }

    /**
     * @return the lstEs_porcentaje
     */
    public List<Es_PorcentajeCombo> getLstEs_porcentaje() {
        return lstEs_porcentaje;
    }

    /**
     * @param lstEs_porcentaje the lstEs_porcentaje to set
     */
    public void setLstEs_porcentaje(List<Es_PorcentajeCombo> lstEs_porcentaje) {
        this.lstEs_porcentaje = lstEs_porcentaje;
    }

    /**
     * @return the listMoneda
     */
    public List<Monedas> getListMoneda() {
        return listMoneda;
    }

    /**
     * @param listMoneda the listMoneda to set
     */
    public void setListMoneda(List<Monedas> listMoneda) {
        this.listMoneda = listMoneda;
    }

    /**
     * @return the listEstructura_costos_mano_obra
     */
    public List<Estructura_costos_mano_obra> getListEstructura_costos_mano_obra() {
        return listEstructura_costos_mano_obra;
    }

    /**
     * @param listEstructura_costos_mano_obra the listEstructura_costos_mano_obra to set
     */
    public void setListEstructura_costos_mano_obra(List<Estructura_costos_mano_obra> listEstructura_costos_mano_obra) {
        this.listEstructura_costos_mano_obra = listEstructura_costos_mano_obra;
    }

    /**
     * @return the estructura_costos_mano_obraDao
     */
    public Estructura_costos_mano_obraDao getEstructura_costos_mano_obraDao() {
        return estructura_costos_mano_obraDao;
    }

    /**
     * @param estructura_costos_mano_obraDao the estructura_costos_mano_obraDao to set
     */
    public void setEstructura_costos_mano_obraDao(Estructura_costos_mano_obraDao estructura_costos_mano_obraDao) {
        this.estructura_costos_mano_obraDao = estructura_costos_mano_obraDao;
    }

    /**
     * @return the estructura_costos_mano_obra
     */
    public Estructura_costos_mano_obra getEstructura_costos_mano_obra() {
        return estructura_costos_mano_obra;
    }

    /**
     * @param estructura_costos_mano_obra the estructura_costos_mano_obra to set
     */
    public void setEstructura_costos_mano_obra(Estructura_costos_mano_obra estructura_costos_mano_obra) {
        this.estructura_costos_mano_obra = estructura_costos_mano_obra;
    }

    /**
     * @return the selecteEstructura_costos_mano_obra
     */
    public Estructura_costos_mano_obra getSelecteEstructura_costos_mano_obra() {
        return selecteEstructura_costos_mano_obra;
    }

    /**
     * @param selecteEstructura_costos_mano_obra the selecteEstructura_costos_mano_obra to set
     */
    public void setSelecteEstructura_costos_mano_obra(Estructura_costos_mano_obra selecteEstructura_costos_mano_obra) {
        this.selecteEstructura_costos_mano_obra = selecteEstructura_costos_mano_obra;
    }

    /**
     * @return the botonNuevoEstructura_costos_mano_obra
     */
    public boolean isBotonNuevoEstructura_costos_mano_obra() {
        return botonNuevoEstructura_costos_mano_obra;
    }

    /**
     * @param botonNuevoEstructura_costos_mano_obra the botonNuevoEstructura_costos_mano_obra to set
     */
    public void setBotonNuevoEstructura_costos_mano_obra(boolean botonNuevoEstructura_costos_mano_obra) {
        this.botonNuevoEstructura_costos_mano_obra = botonNuevoEstructura_costos_mano_obra;
    }

    /**
     * @return the botonEditarEstructura_costos_mano_obra
     */
    public boolean isBotonEditarEstructura_costos_mano_obra() {
        return botonEditarEstructura_costos_mano_obra;
    }

    /**
     * @param botonEditarEstructura_costos_mano_obra the botonEditarEstructura_costos_mano_obra to set
     */
    public void setBotonEditarEstructura_costos_mano_obra(boolean botonEditarEstructura_costos_mano_obra) {
        this.botonEditarEstructura_costos_mano_obra = botonEditarEstructura_costos_mano_obra;
    }

    /**
     * @return the botonEliminarEstructura_costos_mano_obra
     */
    public boolean isBotonEliminarEstructura_costos_mano_obra() {
        return botonEliminarEstructura_costos_mano_obra;
    }

    /**
     * @param botonEliminarEstructura_costos_mano_obra the botonEliminarEstructura_costos_mano_obra to set
     */
    public void setBotonEliminarEstructura_costos_mano_obra(boolean botonEliminarEstructura_costos_mano_obra) {
        this.botonEliminarEstructura_costos_mano_obra = botonEliminarEstructura_costos_mano_obra;
    }

    /**
     * @return the listTotalDestructura_costos_recursos
     */
    public List<Destructura_costos_recursos> getListTotalDestructura_costos_recursos() {
        return listTotalDestructura_costos_recursos;
    }

    /**
     * @param listTotalDestructura_costos_recursos the listTotalDestructura_costos_recursos to set
     */
    public void setListTotalDestructura_costos_recursos(List<Destructura_costos_recursos> listTotalDestructura_costos_recursos) {
        this.listTotalDestructura_costos_recursos = listTotalDestructura_costos_recursos;
    }

    /**
     * @return the listTotalEstructura_costos_mano_obra
     */
    public List<Estructura_costos_mano_obra> getListTotalEstructura_costos_mano_obra() {
        return listTotalEstructura_costos_mano_obra;
    }

    /**
     * @param listTotalEstructura_costos_mano_obra the listTotalEstructura_costos_mano_obra to set
     */
    public void setListTotalEstructura_costos_mano_obra(List<Estructura_costos_mano_obra> listTotalEstructura_costos_mano_obra) {
        this.listTotalEstructura_costos_mano_obra = listTotalEstructura_costos_mano_obra;
    }

    /**
     * @return the listUnimedida
     */
    public List<Unimedida> getListUnimedida() {
        return listUnimedida;
    }

    /**
     * @param listUnimedida the listUnimedida to set
     */
    public void setListUnimedida(List<Unimedida> listUnimedida) {
        this.listUnimedida = listUnimedida;
    }

    /**
     * @return the ajuste_ecosto
     */
    public Float getAjuste_ecosto() {
        return ajuste_ecosto;
    }

    /**
     * @param ajuste_ecosto the ajuste_ecosto to set
     */
    public void setAjuste_ecosto(Float ajuste_ecosto) {
        this.ajuste_ecosto = ajuste_ecosto;
    }

    @Override
    public JRDataSource getDataSourceReport_lst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the costo_mano_obra
     */
    public Float getCosto_mano_obra() {
        return costo_mano_obra;
    }

    /**
     * @param costo_mano_obra the costo_mano_obra to set
     */
    public void setCosto_mano_obra(Float costo_mano_obra) {
        this.costo_mano_obra = costo_mano_obra;
    }

    /**
     * @return the selectRutas
     */
    public Rutas getSelectRutas() {
        return selectRutas;
    }

    /**
     * @param selectRutas the selectRutas to set
     */
    public void setSelectRutas(Rutas selectRutas) {
        this.selectRutas = selectRutas;
    }

    /**
     * @return the selectClieprov_copy
     */
    public Clieprov getSelectClieprov_copy() {
        return selectClieprov_copy;
    }

    /**
     * @param selectClieprov_copy the selectClieprov_copy to set
     */
    public void setSelectClieprov_copy(Clieprov selectClieprov_copy) {
        this.selectClieprov_copy = selectClieprov_copy;
    }

    /**
     * @return the listEstructura_costos_producto_copy
     */
    public List<Estructura_costos_producto> getListEstructura_costos_producto_copy() {
        return listEstructura_costos_producto_copy;
    }

    /**
     * @param listEstructura_costos_producto_copy the listEstructura_costos_producto_copy to set
     */
    public void setListEstructura_costos_producto_copy(List<Estructura_costos_producto> listEstructura_costos_producto_copy) {
        this.listEstructura_costos_producto_copy = listEstructura_costos_producto_copy;
    }

    /**
     * @return the selectlistEstructura_costos_producto_copy
     */
    public List<Estructura_costos_producto> getSelectlistEstructura_costos_producto_copy() {
        return selectlistEstructura_costos_producto_copy;
    }

    /**
     * @param selectlistEstructura_costos_producto_copy the selectlistEstructura_costos_producto_copy to set
     */
    public void setSelectlistEstructura_costos_producto_copy(List<Estructura_costos_producto> selectlistEstructura_costos_producto_copy) {
        this.selectlistEstructura_costos_producto_copy = selectlistEstructura_costos_producto_copy;
    }

    /**
     * @return the estructura_costos_mano_obra_detalladoDao
     */
    public Estructura_costos_mano_obra_detalladoDao getEstructura_costos_mano_obra_detalladoDao() {
        return estructura_costos_mano_obra_detalladoDao;
    }

    /**
     * @param estructura_costos_mano_obra_detalladoDao the estructura_costos_mano_obra_detalladoDao to set
     */
    public void setEstructura_costos_mano_obra_detalladoDao(Estructura_costos_mano_obra_detalladoDao estructura_costos_mano_obra_detalladoDao) {
        this.estructura_costos_mano_obra_detalladoDao = estructura_costos_mano_obra_detalladoDao;
    }

    /**
     * @return the listTotalEstructura_costos_mano_obra_detallado
     */
    public List<Estructura_costos_mano_obra_detallado> getListTotalEstructura_costos_mano_obra_detallado() {
        return listTotalEstructura_costos_mano_obra_detallado;
    }

    /**
     * @param listTotalEstructura_costos_mano_obra_detallado the listTotalEstructura_costos_mano_obra_detallado to set
     */
    public void setListTotalEstructura_costos_mano_obra_detallado(List<Estructura_costos_mano_obra_detallado> listTotalEstructura_costos_mano_obra_detallado) {
        this.listTotalEstructura_costos_mano_obra_detallado = listTotalEstructura_costos_mano_obra_detallado;
    }

    /**
     * @return the listEstructura_costos_mano_obra_detallado
     */
    public List<Estructura_costos_mano_obra_detallado> getListEstructura_costos_mano_obra_detallado() {
        return listEstructura_costos_mano_obra_detallado;
    }

    /**
     * @param listEstructura_costos_mano_obra_detallado the listEstructura_costos_mano_obra_detallado to set
     */
    public void setListEstructura_costos_mano_obra_detallado(List<Estructura_costos_mano_obra_detallado> listEstructura_costos_mano_obra_detallado) {
        this.listEstructura_costos_mano_obra_detallado = listEstructura_costos_mano_obra_detallado;
    }

    /**
     * @return the estructura_costos_mano_obra_detallado
     */
    public Estructura_costos_mano_obra_detallado getEstructura_costos_mano_obra_detallado() {
        return estructura_costos_mano_obra_detallado;
    }

    /**
     * @param estructura_costos_mano_obra_detallado the estructura_costos_mano_obra_detallado to set
     */
    public void setEstructura_costos_mano_obra_detallado(Estructura_costos_mano_obra_detallado estructura_costos_mano_obra_detallado) {
        this.estructura_costos_mano_obra_detallado = estructura_costos_mano_obra_detallado;
    }

    /**
     * @return the selectEstructura_costos_mano_obra_detallado
     */
    public Estructura_costos_mano_obra_detallado getSelectEstructura_costos_mano_obra_detallado() {
        return selectEstructura_costos_mano_obra_detallado;
    }

    /**
     * @param selectEstructura_costos_mano_obra_detallado the selectEstructura_costos_mano_obra_detallado to set
     */
    public void setSelectEstructura_costos_mano_obra_detallado(Estructura_costos_mano_obra_detallado selectEstructura_costos_mano_obra_detallado) {
        this.selectEstructura_costos_mano_obra_detallado = selectEstructura_costos_mano_obra_detallado;
    }

    /**
     * @return the botonNuevoEstructura_costos_mano_obra_detalle
     */
    public boolean isBotonNuevoEstructura_costos_mano_obra_detalle() {
        return botonNuevoEstructura_costos_mano_obra_detalle;
    }

    /**
     * @param botonNuevoEstructura_costos_mano_obra_detalle the botonNuevoEstructura_costos_mano_obra_detalle to set
     */
    public void setBotonNuevoEstructura_costos_mano_obra_detalle(boolean botonNuevoEstructura_costos_mano_obra_detalle) {
        this.botonNuevoEstructura_costos_mano_obra_detalle = botonNuevoEstructura_costos_mano_obra_detalle;
    }

    /**
     * @return the botonEliminarEstructura_costos_mano_obra_detalle
     */
    public boolean isBotonEliminarEstructura_costos_mano_obra_detalle() {
        return botonEliminarEstructura_costos_mano_obra_detalle;
    }

    /**
     * @param botonEliminarEstructura_costos_mano_obra_detalle the botonEliminarEstructura_costos_mano_obra_detalle to set
     */
    public void setBotonEliminarEstructura_costos_mano_obra_detalle(boolean botonEliminarEstructura_costos_mano_obra_detalle) {
        this.botonEliminarEstructura_costos_mano_obra_detalle = botonEliminarEstructura_costos_mano_obra_detalle;
    }

    /**
     * @return the vestado
     */
    public boolean isVestado() {
        return vestado;
    }

    /**
     * @param vestado the vestado to set
     */
    public void setVestado(boolean vestado) {
        this.vestado = vestado;
    }

    /**
     * @return the vexcluir
     */
    public boolean isVexcluir() {
        return vexcluir;
    }

    /**
     * @param vexcluir the vexcluir to set
     */
    public void setVexcluir(boolean vexcluir) {
        this.vexcluir = vexcluir;
    }

    /**
     * @return the estructura_costos_producto_diasrangoDao
     */
    public Estructura_costos_producto_diasrangoDao getEstructura_costos_producto_diasrangoDao() {
        return estructura_costos_producto_diasrangoDao;
    }

    /**
     * @param estructura_costos_producto_diasrangoDao the estructura_costos_producto_diasrangoDao to set
     */
    public void setEstructura_costos_producto_diasrangoDao(Estructura_costos_producto_diasrangoDao estructura_costos_producto_diasrangoDao) {
        this.estructura_costos_producto_diasrangoDao = estructura_costos_producto_diasrangoDao;
    }

    /**
     * @return the listEstructura_costos_producto_diasrango
     */
    public List<Estructura_costos_producto_diasrango> getListEstructura_costos_producto_diasrango() {
        return listEstructura_costos_producto_diasrango;
    }

    /**
     * @param listEstructura_costos_producto_diasrango the listEstructura_costos_producto_diasrango to set
     */
    public void setListEstructura_costos_producto_diasrango(List<Estructura_costos_producto_diasrango> listEstructura_costos_producto_diasrango) {
        this.listEstructura_costos_producto_diasrango = listEstructura_costos_producto_diasrango;
    }

    /**
     * @return the listTotalEstructura_costos_producto_diasrango
     */
    public List<Estructura_costos_producto_diasrango> getListTotalEstructura_costos_producto_diasrango() {
        return listTotalEstructura_costos_producto_diasrango;
    }

    /**
     * @param listTotalEstructura_costos_producto_diasrango the listTotalEstructura_costos_producto_diasrango to set
     */
    public void setListTotalEstructura_costos_producto_diasrango(List<Estructura_costos_producto_diasrango> listTotalEstructura_costos_producto_diasrango) {
        this.listTotalEstructura_costos_producto_diasrango = listTotalEstructura_costos_producto_diasrango;
    }

    /**
     * @return the listProductos
     */
    public List<Productos> getListProductos() {
        return listProductos;
    }

    /**
     * @param listProductos the listProductos to set
     */
    public void setListProductos(List<Productos> listProductos) {
        this.listProductos = listProductos;
    }

    /**
     * @return the log_consola
     */
    public String getLog_consola() {
        return log_consola;
    }

    /**
     * @param log_consola the log_consola to set
     */
    public void setLog_consola(String log_consola) {
        this.log_consola = log_consola;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Es_PorcentajeCombo{
        private int id;
        private String descripcion;
        public Es_PorcentajeCombo(int key,String value){
            this.id=key;
            this.descripcion=value;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @param descripcion the descripcion to set
         */
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
