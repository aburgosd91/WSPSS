/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.Cargos_personalDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DcotizacionventasDao;
import com.nisira.core.dao.Dcotizacionventas_actividadesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenservicioclienteDao;
import com.nisira.core.dao.Dpersonal_servicioDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.Estructura_costos_mano_obra_cotizacionventasDao;
import com.nisira.core.dao.ImpuestoDao;
import com.nisira.core.dao.MonedaDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.MotivosproduccionDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.PlanctasDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.TipodetraccionDao;
import com.nisira.core.dao.TiporegimenDao;
import com.nisira.core.dao.WtiposervicioDao;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Dcotizacionventas_actividades;
import com.nisira.core.entity.Det_tareoweb;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dpersonal_servicio;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Estructura_costos_mano_obra_cotizacionventas;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Impuesto;
import com.nisira.core.entity.Moneda;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Motivosproduccion;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Planctas;
import com.nisira.core.entity.Producto;
import com.nisira.core.entity.Reporte_facturacion;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tipodetraccion;
import com.nisira.core.entity.Tiporegimen;
import com.nisira.core.entity.Wtiposervicio;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormat;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "rpt_tareoweb_facturacion_formatoAction")
@SessionScoped
public class Rpt_tareoweb_facturacion_formatoAction extends AbstactListAction<Ordenserviciocliente> {
    /*************************************ArrayList***************************************/
    private List<Reporte_facturacion> listReporte_facturacion;
    private List<Wtiposervicio> listWtiposervicio;
    private WtiposervicioDao wtiposervicioDao;
    private List<Monedas> listMoneda;
    private List<Planctas> listPlanctas;
    private List<Consumidor> listConsumidor;
    private List<Tiporegimen> listTiporegimen;
    private List<Impuesto> listImpuesto;
    private List<Tipodetraccion> listTipodetraccion;
    private List<Documentos> listDocumentos;
    private List<Det_tareoweb> listDet_tareo_verificacion;
    private List<Reporte_facturacion> listReporte_facturacionTotal;
    private List<Reporte_facturacion> listReporte_facturacionPersonal;
    /*************************************DAO***************************************/
    private OrdenservicioclienteDao ordenservicioclienteDao;
    private MonedasDao monedaDao;
    private TiporegimenDao tiporegimenDao;
    private ImpuestoDao impuestoDao; 
    private TipodetraccionDao tipodetraccionDao;
    private PlanctasDao planctasDao; 
    private DocumentosDao documentoDao;
    private NumemisorDao numemisorDao; 
    private ConsumidorDao consumidorDao;
    private Det_tareowebDao det_tareoweb_verificationDao; 
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String mensaje;
    private String idtiposervicio;
    private Reporte_facturacion selectReporte_facturacion; 
    private Reporte_facturacion selectReporte_facturacion_detalle; 
    private Det_tareoweb cabercerDet_tareoweb;
    /************************************* CONTROLES *****************************************/
    private String type_formato_rpt;
    private Float scosto;
    public Rpt_tareoweb_facturacion_formatoAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            mensaje = "";
            /*********************************LISTAS*******************************************/
            listReporte_facturacion = new ArrayList<>();
            listWtiposervicio = new ArrayList<>();
            listPlanctas = new ArrayList<>();
            listTiporegimen =  new ArrayList<>();
            listImpuesto =  new ArrayList<>();
            listTipodetraccion =  new ArrayList<>();
            listDocumentos =  new ArrayList<>();
            listConsumidor =  new ArrayList<>();
            /*********************************DAO**********************************************/
            ordenservicioclienteDao = new OrdenservicioclienteDao();
            wtiposervicioDao = new WtiposervicioDao();
            monedaDao = new MonedasDao();
            impuestoDao = new ImpuestoDao();
            tiporegimenDao = new TiporegimenDao();
            tipodetraccionDao = new TipodetraccionDao();
            planctasDao = new PlanctasDao();
            documentoDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            consumidorDao = new ConsumidorDao();
            det_tareoweb_verificationDao = new Det_tareowebDao();
            /**********************************CONTROLADOR*************************************/
            listWtiposervicio = wtiposervicioDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listMoneda = monedaDao.getListMonedasWeb();
            listTiporegimen = tiporegimenDao.listarPorEmpresa(user.getIDEMPRESA());
            listImpuesto = impuestoDao.listarPorEmpresa(user.getIDEMPRESA());
            listTipodetraccion = tipodetraccionDao.listarTotal();
            listDocumentos = documentoDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listConsumidor = consumidorDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            /********************************** CONFIGURACIÓN - SERVIDOR ***********************/
            idtiposervicio = "ESPECIAL";
        }catch (Exception ex) {
            Logger.getLogger(Rpt_ordenserviciocliente_formatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualiza_ventana("wMnt_Rpt_tareoweb_facturacion_formato");
    }
    public void onCellEdit(CellEditEvent event) {
        Object newValue = event.getNewValue();
        Reporte_facturacion entity =(Reporte_facturacion)((DataTable)event.getComponent()).getRowData();
        int pos = entity.getItem();
        if(event.getColumn().getHeaderText()!=null){
            String colHead = event.getColumn().getHeaderText().trim();
            switch(colHead){
                case "Idcuenta":
                    if(newValue==null){
                        entity.setIdcuenta("");
                        entity.setCuenta("");
                    }else{
                        Planctas ob = (Planctas)newValue;
                        entity.setIdcuenta(ob.getIdcuenta());
                        entity.setCuenta(ob.getDescripcion());
                    };break;
                case "tipo de detracción":
                    if(newValue==null){
                        entity.setTipodetraccion("");
                        entity.setTipodetraccion_descripcion("");
                    }else{
                        Tipodetraccion ob = (Tipodetraccion)newValue;
                        entity.setTipodetraccion(ob.getIdtipodetra());
                        entity.setTipodetraccion_descripcion(ob.getDescripcion());
                        entity.setTasadetraccion(ob.getTasa());
                    };break;
                case "Doc.":
                    if(newValue==null){
                        entity.setIddocumento("");
                    }else{
                        Documentos ob = (Documentos)newValue;
                        entity.setIddocumento(ob.getIddocumento());
                    };break;
                case "Serie":
                    if(newValue==null){
                        entity.setSerie("0000");
                    }else{
                        String serie = newValue.toString();
                        entity.setSerie(WebUtil.cerosIzquierdaString(serie, 4));
                    }
                    ;break;
                case "Número":
                    if(newValue==null){
                        entity.setNumero("0000000");
                    }else{
                        String numero = newValue.toString();
                        entity.setNumero(WebUtil.cerosIzquierda(numero, 7));
                    }
                    ;break;
                case "Idccosto":
                    if(newValue==null){
                        entity.setNumero("");
                    }else{
                        Consumidor ob = (Consumidor)newValue;
                        entity.setIdccosto(ob.getIdccosto());
                        entity.setConcepto(ob.getDescripcion());
                    }
                    ;break;
                case "Idregimen":
                    if(newValue==null){
                        entity.setIdregimen("");
                    }else{
                        if(newValue.toString().trim().equals("01")){
                            entity.setAfecto(entity.getTcosto());
                            entity.setInafecto(0.0f);
                        }else if(newValue.toString().trim().equals("02")){
                            
                        }else if(newValue.toString().trim().equals("03")){
                            entity.setAfecto(0.0f);
                            entity.setInafecto(entity.getTcosto());
                        }
                    }
                    ;break;
                case "Idimpuesto":
                    if(newValue==null){
                        entity.setIdimpuesto("000");
                        entity.setImpuesto(0.0f);
                    }else{
                        Float[] valores = impuestoDao.getImpuesto(user.getIDEMPRESA(), newValue.toString());
                        Float imp = valores[1];
                        entity.setResta_base(valores[0].intValue());
                        Float imp_dec =  imp/100;
                        entity.setIdimpuesto(newValue.toString());
                        if(entity.getIdregimen().trim().equals("01")){
                            entity.setImpuesto(entity.getAfecto()*imp_dec);
                        }else if(entity.getIdregimen().trim().equals("03")){
                            entity.setImpuesto(entity.getInafecto()*imp_dec);
                        }
                    }
                    ;break;
            }
            /*CALCULO DE TOTAL*/
            entity.setTotal(entity.getAfecto()+entity.getInafecto()+(entity.getImpuesto()* (entity.getResta_base()==1?-1:1)));
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Rpt_ordenserviciocliente_formatoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        setMensaje("");
        /**********************************CONTROLADOR********************************/
        /**********************************CONFIGURACIÓN - SERVIDOR********************************/
        actualiza_ventana("wMnt_Rpt_tareoweb_facturacion_formato");
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
    public List<Planctas> completePlanctas(String query) {
        cargarPlanctas(query);
        return listPlanctas;
    }
    public void cargarCuentasDetraccionDocumentos(){
        try{
            if(!listReporte_facturacion.isEmpty()){
                Reporte_facturacion temp;
                Documentos doc ;
                Planctas pac ;
                Tipodetraccion tdet;
                List<Tipodetraccion> lstde;
                for(int i=0;i<listReporte_facturacion.size();i++){
                    temp = listReporte_facturacion.get(i);
                    if(temp.getIdcuenta()!=null){
                        if(!temp.getIdcuenta().trim().equals("")){
                            pac =  planctasDao.getPlanctas_idcuenta(user.getIDEMPRESA(), temp.getIdcuenta());
                            temp.setSelectCuenta(pac);
                        }
                    }
                    if(temp.getTipodetraccion()!=null){
                        if(!temp.getTipodetraccion().trim().equals("")){
                            tdet = tipodetraccionDao.getTipodetraccion_idtipodetraccion(temp.getTipodetraccion());
                            temp.setTipodetraccion_descripcion(tdet.getDescripcion());
                            temp.setTipodetraccion(tdet.getIdtipodetra());
                            temp.setTasadetraccion(tdet.getTasa());
                            temp.setSelectTipodetraccion(tdet);
                        }
                    }
                    if(temp.getIddocumento()!=null){
                        if(!temp.getIddocumento().trim().equals("")){
                            doc = documentoDao.getIddocumento(user.getIDEMPRESA(),temp.getIddocumento());
                            temp.setSelectDocumentos(doc);
                        }
                    }
                    listReporte_facturacion.set(i, temp);
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarPlanctas(String query){
        try {
            listPlanctas = (new PlanctasDao()).listarPorEmpresa(user.getIDEMPRESA(),query);
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Tipodetraccion> completeTipodetraccion(String query) {
        List<Tipodetraccion> filteredTipodetraccion = new ArrayList<Tipodetraccion>(); 
        for (int i = 0; i < listTipodetraccion.size(); i++) {
            Tipodetraccion skin = listTipodetraccion.get(i);
            if(skin.getIdtipodetra().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getNombre_corto().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredTipodetraccion.add(skin);
            }
        }
        return filteredTipodetraccion;
    }
    public List<Documentos> completeDocumentos(String query) {
        List<Documentos> filteredDocumentos = new ArrayList<Documentos>(); 
        for (int i = 0; i < listDocumentos.size(); i++) {
            Documentos skin = listDocumentos.get(i);
            if(skin.getIddocumento().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getCodigo_sunat().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredDocumentos.add(skin);
            }
        }
        return filteredDocumentos;
    }
    public List<Consumidor> completeConsumidor(String query) {
        List<Consumidor> filteredConsumidor= new ArrayList<Consumidor>(); 
        for (int i = 0; i < getListConsumidor().size(); i++) {
            Consumidor skin = getListConsumidor().get(i);
            if(skin.getIdconsumidor().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredConsumidor.add(skin);
            }
        }
        return filteredConsumidor;
    }
    public void onRefresh(){
        cargarDatosGenerales_detalle();
        RequestContext.getCurrentInstance().update("datos:tbl");
    }
    public void findetalle() throws Exception {
       if(listReporte_facturacionTotal.isEmpty()){
            setMensaje("No se muestran registros");
            WebUtil.info(getMensaje());
            setLvalidate(true);
            RequestContext.getCurrentInstance().update("datos");
       } else{
            listReporte_facturacion = new ArrayList<>();
            /***************************************CÁLCULO DE SUMATORIA *******************************************/
            Map<String, Data> group_calcultate = listReporte_facturacionTotal.stream().collect(
                groupingBy(Reporte_facturacion::getIdclieprov, 
                    collectingAndThen(summarizingDouble(Reporte_facturacion::getTcosto), 
                        dss -> new Data((float)dss.getAverage(),(float)dss.getSum()))
                )
            );
            
            /********************************************************************************/
            group_calcultate.forEach((idclieprov,dato)->{
                Reporte_facturacion result1 = listReporte_facturacionTotal.stream()                          
                .filter(x -> idclieprov.trim().equals(x.getIdclieprov()))                            
                .findAny()                                                          
                .orElse(null);
                /**/
                Reporte_facturacion newObj = new Reporte_facturacion();
//                newObj.setItem(listReporte_facturacion.size()+1);
                newObj.setIdclieprov(result1.getIdclieprov());
                newObj.setRazon_social(result1.getRazon_social());
                newObj.setIddocumento(result1.getIddocumento());
                newObj.setSerie(result1.getSerie());
                newObj.setNumero(result1.getNumero());
                newObj.setFecha(result1.getFecha());
                newObj.setFecha_operacion(result1.getFecha_operacion());
                newObj.setVencimiento(result1.getVencimiento());
                newObj.setIdmoneda(result1.getIdmoneda());
                newObj.setIdcuenta(result1.getIdcuenta());
                newObj.setCuenta(result1.getCuenta());
                newObj.setIdccosto(result1.getIdccosto());
                newObj.setConcepto(result1.getConcepto());
                newObj.setIdcliente(result1.getIdcliente());
                newObj.setIdregimen(result1.getIdregimen());
                newObj.setTcosto(dato.sum);
                newObj.setIdimpuesto(result1.getIdimpuesto());
                newObj.setEsdetraccion(result1.getEsdetraccion());
                newObj.setTipodetraccion(result1.getTipodetraccion());
                newObj.setTipodetraccion_descripcion(result1.getTipodetraccion_descripcion());
                newObj.setTasadetraccion(result1.getTasadetraccion());
                newObj.setEsplanilla(result1.getEsplanilla());
                /**** Calcular ****/
                if(newObj.getIdregimen().toString().trim().equals("01")){
                    newObj.setAfecto(newObj.getTcosto());
                    newObj.setInafecto(0.0f);
                }else if(newObj.getIdregimen().toString().trim().equals("02")){

                }else if(newObj.getIdregimen().toString().trim().equals("03")){
                    newObj.setAfecto(0.0f);
                    newObj.setInafecto(newObj.getTcosto());
                }
                if(newObj.getIdimpuesto()==null){
                    newObj.setIdimpuesto("000");
                    newObj.setImpuesto(0.0f);
                }else{
                    Float[] object = impuestoDao.getImpuesto(user.getIDEMPRESA(), newObj.getIdimpuesto().toString()); 
                    newObj.setResta_base(object[0].intValue());
                    Float imp = object[1];
                    Float imp_dec =  imp/100;
                    newObj.setIdimpuesto(newObj.getIdimpuesto().toString());
                    if(newObj.getIdregimen().trim().equals("01")){
                        newObj.setImpuesto(newObj.getAfecto()*imp_dec);
                    }else if(newObj.getIdregimen().trim().equals("03")){
                        newObj.setImpuesto(newObj.getInafecto()*imp_dec);
                    }
                }
                newObj.setTotal(newObj.getAfecto()+newObj.getInafecto()+(newObj.getImpuesto()*(newObj.getResta_base()==1?-1:1)));
                listReporte_facturacion.add(newObj);
            });
            
            /*ORDER BY*/
            Collections.sort(listReporte_facturacion, new Comparator<Reporte_facturacion>(){
                public int compare(Reporte_facturacion p1, Reporte_facturacion p2){
                  return p1.getRazon_social().compareTo(p2.getRazon_social());
                }
              });
            int cnum =0;
            for(int i=1;i<=listReporte_facturacion.size();i++){
                listReporte_facturacion.get(cnum).setItem(i);
                cnum++;
            }
            /*
            
            listReporte_facturacion = new ArrayList<>();
            for(Reporte_facturacion rpf :listReporte_facturacionTotal){
               
           }*/
       }
        
    }
    class Data {
        float average;
        float sum;

        public Data(float average, float sum) {
            this.average = average;
            this.sum = sum;
        }

        // Getter and setter
    }
    public void buscar_filtrofecha() {
        try {
            this.setMensaje("");
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            listReporte_facturacionTotal = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
//            listReporte_facturacion = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
//            findetalle();
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
    public void replicarItem(){
        if(selectReporte_facturacion!=null){
            for(int i=0;i<listReporte_facturacion.size();i++){
                Reporte_facturacion dtw = listReporte_facturacion.get(i);
                dtw.setIddocumento(selectReporte_facturacion.getIddocumento());
                dtw.setSelectDocumentos(selectReporte_facturacion.getSelectDocumentos());
                dtw.setSerie(selectReporte_facturacion.getSerie());
                dtw.setIdmoneda(selectReporte_facturacion.getIdmoneda());
                dtw.setIdcuenta(selectReporte_facturacion.getIdcuenta());
                dtw.setCuenta(selectReporte_facturacion.getCuenta());
                dtw.setSelectCuenta(selectReporte_facturacion.getSelectCuenta());
                dtw.setIdccosto(selectReporte_facturacion.getIdccosto());
                dtw.setSelectConsumidor(selectReporte_facturacion.getSelectConsumidor());
                dtw.setConcepto(selectReporte_facturacion.getConcepto());
                dtw.setIdregimen(selectReporte_facturacion.getIdregimen());
                dtw.setIdimpuesto(selectReporte_facturacion.getIdimpuesto());
                dtw.setTipodetraccion(selectReporte_facturacion.getTipodetraccion());
                dtw.setTipodetraccion_descripcion(selectReporte_facturacion.getTipodetraccion_descripcion());
                dtw.setSelectTipodetraccion(selectReporte_facturacion.getSelectTipodetraccion());
                dtw.setTasadetraccion(selectReporte_facturacion.getTasadetraccion());
                /*CALCULAR IMPORTES*/
                Float[] array = impuestoDao.getImpuesto(user.getIDEMPRESA(), dtw.getIdimpuesto());
                Float imp = array[1];
                dtw.setResta_base(array[0].intValue());
                Float imp_dec =  imp/100;
                if(dtw.getIdregimen().trim().equals("01")){
                    dtw.setAfecto(dtw.getTcosto());
                    dtw.setInafecto(0.0f);
                    dtw.setImpuesto(dtw.getAfecto()*imp_dec);
                }else if(dtw.getIdregimen().trim().equals("03")){
                    dtw.setInafecto(dtw.getTcosto());
                    dtw.setAfecto(0.0f);
                    dtw.setImpuesto(dtw.getInafecto()*imp_dec);
                }
                dtw.setTotal(dtw.getAfecto()+dtw.getInafecto()+(dtw.getImpuesto()*(dtw.getResta_base()==1?-1:1)));
                listReporte_facturacion.set(i, dtw);
            }
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:tbl");
        }
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
            listReporte_facturacionTotal = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
            findetalle();
            //listReporte_facturacion = getOrdenservicioclienteDao().listar_facturacion_detalladoFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin,idtiposervicio);
            //setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            cargarCuentasDetraccionDocumentos();
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
        if(tipo == 2)
            lista_accion_filtro("wLst_Rpt_tareoweb_facturacion_formato");
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
        /*Actulizar datos de resumen al detalle*/
        cargarDatosGenerales_detalle();
        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        HSSFRow fila_cabecera = objWB.getSheetAt(0).createRow(0);

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
        
        DataFormat format = objWB.createDataFormat();
        HSSFCellStyle estiloFila_numeric = objWB.createCellStyle();
        estiloFila_numeric.setWrapText(true);
        estiloFila_numeric.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila_numeric.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_numeric.setFont(fuente);
        estiloFila_numeric.setDataFormat(format.getFormat("0.00"));
        
        HSSFCellStyle estiloFila_date = objWB.createCellStyle();
        estiloFila_date.setWrapText(true);
        estiloFila_date.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        estiloFila_date.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloFila_date.setFont(fuente);
        estiloFila_date.setDataFormat(format.getFormat("dd/mm/yyyy"));
        int col = 23;
        int row = listReporte_facturacionTotal.size();
        HSSFCell celda;
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("DNI");break;
                case 1:celda.setCellValue("DOC");break;
                case 2:celda.setCellValue("SERIE");break;
                case 3:celda.setCellValue("NUMERO");break;
                case 4:celda.setCellValue("FECHA");break;
                case 5:celda.setCellValue("VNRORUC");break;
                case 6:celda.setCellValue("VRAZSOC");break;
                case 7:celda.setCellValue("AMBITO");break;
                case 8:celda.setCellValue("RUTA");break;
                case 9:celda.setCellValue("IDENT.");break;
                case 10:celda.setCellValue("DATOS");break;
                case 11:celda.setCellValue("IDCARGO");break;
                case 12:celda.setCellValue("CARGO");break;
                case 13:celda.setCellValue("VEHPOL");break;
                case 14:celda.setCellValue("INIASI");break;
                case 15:celda.setCellValue("FINASI");break;
                case 16:celda.setCellValue("HORASASI");break;
                case 17:celda.setCellValue("HORA_EC");break;
                case 18:celda.setCellValue("H.ADICIONAL");break;
                case 19:celda.setCellValue("COSTO R.H");break;
                case 20:celda.setCellValue("COSTO H.AD");break;
                case 21:celda.setCellValue("COSTO BONO");break;
                case 22:celda.setCellValue("COSTO_TOTAL");break;
            }
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).createRow((short)i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDni());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDiddocumento());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDserie());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDnumero());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfecha_osc(), 7));
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getIdcliente());
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcliente());
            
            celda = fila.createCell((short)7);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDambito_servicio());
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getRutaservicio());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getIdclieprov());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getRazon_social());
            
            celda = fila.createCell((short)11);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDidcargo());
            
            celda = fila.createCell((short)12);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getCargo());
            
            celda = fila.createCell((short)13);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDidvehiculo());
            
            celda = fila.createCell((short)14);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfecharegistro(), 7));
            
            celda = fila.createCell((short)15);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfechafinregistro(), 7));
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhs_s());
            
            celda = fila.createCell((short)17);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhbase());
            
            celda = fila.createCell((short)18);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhadicional());
            
            celda = fila.createCell((short)19);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcosto_rh());
            
            celda = fila.createCell((short)20);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhcosto_adicional());
            
            celda = fila.createCell((short)21);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcosto_bono());
            
            celda = fila.createCell((short)22);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getTcosto());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
        /*CREAR OTRA HOJA DETALLADO NISIRA*/
        HSSFSheet sheet2 = objWB.createSheet("DETALLADO "+this.idtiposervicio+" "+WebUtil.fechaDMY(getDesde(),8)+" "+WebUtil.fechaDMY(getHasta(),8));
        fila_cabecera = sheet2.createRow((short)0);
        col = 42;
        row = listReporte_facturacionTotal.size();
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("DNI");break;
                case 1:celda.setCellValue("DOC.IDEN.");break;
                case 2:celda.setCellValue("DATO");break;
                case 3:celda.setCellValue("IDDOCUMENTO");break;
                case 4:celda.setCellValue("SERIE");break;
                case 5:celda.setCellValue("NUMERO");break;
                case 6:celda.setCellValue("FECHA SER");break;
                case 7:celda.setCellValue("AMBITO");break;
                /*AGREGAR CAMPOS ADICIONALES*/
                case 8:celda.setCellValue("RUC");break;
                case 9:celda.setCellValue("CLIENTE");break;
                case 10:celda.setCellValue("CARGO");break;
                case 11:celda.setCellValue("CODOPERACION");break;
                case 12:celda.setCellValue("RUTA SERV");break;
                case 13:celda.setCellValue("FECHA INICIO");break;
                case 14:celda.setCellValue("HORA INICIO");break;
                case 15:celda.setCellValue("HORA FIN");break;
                case 16:celda.setCellValue("FECHA FIN");break;
                case 17:celda.setCellValue("HORAS SERVICIO");break;
                case 18:celda.setCellValue("HORAS E.C");break;
                case 19:celda.setCellValue("HORAS ADICIONAL");break;
                case 20:celda.setCellValue("COSTO RxH");break;
                case 21:celda.setCellValue("COSTO H.ADICIONAL");break;
                case 22:celda.setCellValue("COSTO BONO");break;
                case 23:celda.setCellValue("TOTAL");break;
                case 24:celda.setCellValue("ESPLANILLA");break;
                /*AGREGAR CAMPOS ADICIONALES - TAREO*/
                case 25:celda.setCellValue("T.HORA REQ.");break;
                case 26:celda.setCellValue("T.HORA LLEGADA");break;
                case 27:celda.setCellValue("T.HORA INICIO");break;
                case 28:celda.setCellValue("T.HORA FIN");break;
                case 29:celda.setCellValue("T.HORA LIBERACION");break;
                case 30:celda.setCellValue("IDAMBITO");break;
                case 31:celda.setCellValue("AMBITO_SERVICIO");break;
                case 32:celda.setCellValue("CHECKLIST");break;
                case 33:celda.setCellValue("PLACA PSS");break;
                case 34:celda.setCellValue("NROCONTENEDOR");break;
                case 35:celda.setCellValue("NROPRECINTO");break;
                case 36:celda.setCellValue("NRO_OSERVICIO");break;
                case 37:celda.setCellValue("PLACA_CLIENTE");break;
                case 38:celda.setCellValue("CONDUCTOR_CLIENTE");break;
                case 39:celda.setCellValue("BREVETE_CLIENTE");break;
                case 40:celda.setCellValue("#SERVICIOS_DIA");break;
                case 41:celda.setCellValue("ORIGENCALLAO");break;
            }
        }
        int id=0;
        for(int i=0;i<row;i++){
            fila = sheet2.createRow(i+1);
            id=0;
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDni());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getIdclieprov());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getRazon_social());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDiddocumento());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDserie());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDnumero());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfecha_osc(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDambito_servicio());
             
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getIdcliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDidcargo()+" "+listReporte_facturacionTotal.get(i).getCargo());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcodoperaciones_ec());
            
            /*AGREGAR CAMPOS ADICIONALES*/
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getRutaservicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfecharegistro(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhi_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhf_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(listReporte_facturacionTotal.get(i).getDfechafinregistro(), 7));
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhs_s());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhbase());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhadicional());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcosto_rh());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDhcosto_adicional());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDcosto_bono());
            
            celda = fila.createCell((short)id++);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getTotal());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getEsplanilla());
            /************************** HORAS TAREO ***************************/
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getShora_req());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getShora_llegada());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getShora_inicio_serv());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getShora_fin_serv());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getShora_liberacion());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getIdambito_servicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getAmbito_servicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDchecklist());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDidvehiculo());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDnrocontenedor());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDnroprecinto());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDnro_oservicio());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDplaca_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDconductor_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getDbrevete_cliente());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getNservicios_dia()==null?0:listReporte_facturacionTotal.get(i).getNservicios_dia());
            
            celda = fila.createCell((short)id++);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(listReporte_facturacionTotal.get(i).getOrigencallao());
            
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(1).autoSizeColumn((short) as);
        }
    }
    public void cargarDatosGenerales_detalle(){
        if(!listReporte_facturacion.isEmpty()){
            for(Reporte_facturacion cb:listReporte_facturacion){
                for(int i=0;i<listReporte_facturacionTotal.size();i++){
                    if(listReporte_facturacionTotal.get(i).getIdclieprov().trim().equals(cb.getIdclieprov().trim())){
                        listReporte_facturacionTotal.get(i).setIddocumento(cb.getIddocumento());
                        listReporte_facturacionTotal.get(i).setSerie(cb.getSerie());
                        listReporte_facturacionTotal.get(i).setIdmoneda(cb.getIdmoneda());
                        listReporte_facturacionTotal.get(i).setIdcuenta(cb.getIdcuenta());
                        listReporte_facturacionTotal.get(i).setCuenta(cb.getCuenta());
                        listReporte_facturacionTotal.get(i).setIdccosto(cb.getIdccosto());
                        listReporte_facturacionTotal.get(i).setConcepto(cb.getConcepto());
                        listReporte_facturacionTotal.get(i).setIdregimen(cb.getIdregimen());
                        listReporte_facturacionTotal.get(i).setIdimpuesto(cb.getIdimpuesto());
                        listReporte_facturacionTotal.get(i).setTipodetraccion(cb.getTipodetraccion());
                        listReporte_facturacionTotal.get(i).setTipodetraccion_descripcion(cb.getTipodetraccion_descripcion());
                        listReporte_facturacionTotal.get(i).setTasadetraccion(cb.getTasadetraccion());
                        /**** Calcular ****/
                        if(listReporte_facturacionTotal.get(i).getIdregimen().toString().trim().equals("01")){
                            listReporte_facturacionTotal.get(i).setAfecto(listReporte_facturacionTotal.get(i).getTcosto());
                            listReporte_facturacionTotal.get(i).setInafecto(0.0f);
                        }else if(listReporte_facturacionTotal.get(i).getIdregimen().toString().trim().equals("02")){

                        }else if(listReporte_facturacionTotal.get(i).getIdregimen().toString().trim().equals("03")){
                            listReporte_facturacionTotal.get(i).setAfecto(0.0f);
                            listReporte_facturacionTotal.get(i).setInafecto(listReporte_facturacionTotal.get(i).getTcosto());
                        }
                        if(listReporte_facturacionTotal.get(i).getIdimpuesto()==null){
                            listReporte_facturacionTotal.get(i).setIdimpuesto("000");
                            listReporte_facturacionTotal.get(i).setImpuesto(0.0f);
                        }else{
                            Float[] array = impuestoDao.getImpuesto(user.getIDEMPRESA(), listReporte_facturacionTotal.get(i).getIdimpuesto().toString());
                            Float imp = array[1];
                            Float imp_dec =  imp/100;
                            listReporte_facturacionTotal.get(i).setResta_base(array[0].intValue());
                            listReporte_facturacionTotal.get(i).setIdimpuesto(listReporte_facturacionTotal.get(i).getIdimpuesto().toString());
                            if(listReporte_facturacionTotal.get(i).getIdregimen().trim().equals("01")){
                                listReporte_facturacionTotal.get(i).setImpuesto(listReporte_facturacionTotal.get(i).getAfecto()*imp_dec);
                            }else if(listReporte_facturacionTotal.get(i).getIdregimen().trim().equals("03")){
                                listReporte_facturacionTotal.get(i).setImpuesto(listReporte_facturacionTotal.get(i).getInafecto()*imp_dec);
                            }
                        }
                        listReporte_facturacionTotal.get(i).setTotal(listReporte_facturacionTotal.get(i).getAfecto()+listReporte_facturacionTotal.get(i).getInafecto()+
                                (listReporte_facturacionTotal.get(i).getImpuesto()*(listReporte_facturacionTotal.get(i).getResta_base()==1?-1:1)));
                    }
                    
                }
            }
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
    public void visualizar_calculo() {
        try {
            if(selectReporte_facturacion==null){
                this.mensaje="Seleccionar registro";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                listReporte_facturacionPersonal = new ArrayList<>();
                this.scosto = 0.0f;
                for(Reporte_facturacion obj:listReporte_facturacionTotal){
                    if(obj.getIdclieprov().trim().equals(selectReporte_facturacion.getIdclieprov())){
                        this.scosto+=obj.getTcosto();
                        listReporte_facturacionPersonal.add(obj);
                    }
                }
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog");
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:tsubtotal");
                RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:listDet_tareo_verificacion"); 
                RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').show()");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void detalleTareoCalculo() {
        try {
            if(selectReporte_facturacion_detalle==null){
                this.mensaje="Seleccionar Detalle Cálculo";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                RequestContext.getCurrentInstance().update("datos:detalleTareoCalculoDialog");
                RequestContext.getCurrentInstance().execute("PF('detalleTareoCalculoDialog').show()");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void visualizar_tareo() {
        try {
            if(selectReporte_facturacion==null){
                this.mensaje="Seleccionar registro";
                WebUtil.MensajeError(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                listDet_tareo_verificacion = det_tareoweb_verificationDao.getVisualizar_tareo_ordenservicio(user.getIDEMPRESA(), selectReporte_facturacion.getDidordenservicio());
                if(listDet_tareo_verificacion.isEmpty()){
                    this.mensaje="No existe tareo vinculado";
                    WebUtil.MensajeError(mensaje);
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    cabercerDet_tareoweb = listDet_tareo_verificacion.get(0);
                    RequestContext.getCurrentInstance().update("datos:detalleTareoDialog");
                    RequestContext.getCurrentInstance().update("datos:detalleTareoDialog:listDet_tareo_verificacion"); 
                    RequestContext.getCurrentInstance().execute("PF('detalleTareoDialog').show()");
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
     * @return the listReporte_facturacion
     */
    public List<Reporte_facturacion> getListReporte_facturacion() {
        return listReporte_facturacion;
    }

    /**
     * @param listReporte_facturacion the listReporte_facturacion to set
     */
    public void setListReporte_facturacion(List<Reporte_facturacion> listReporte_facturacion) {
        this.listReporte_facturacion = listReporte_facturacion;
    }

    /**
     * @return the selectReporte_facturacion
     */
    public Reporte_facturacion getSelectReporte_facturacion() {
        return selectReporte_facturacion;
    }

    /**
     * @param selectReporte_facturacion the selectReporte_facturacion to set
     */
    public void setSelectReporte_facturacion(Reporte_facturacion selectReporte_facturacion) {
        this.selectReporte_facturacion = selectReporte_facturacion;
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
     * @return the listPlanctas
     */
    public List<Planctas> getListPlanctas() {
        return listPlanctas;
    }

    /**
     * @param listPlanctas the listPlanctas to set
     */
    public void setListPlanctas(List<Planctas> listPlanctas) {
        this.listPlanctas = listPlanctas;
    }

    /**
     * @return the listTiporegimen
     */
    public List<Tiporegimen> getListTiporegimen() {
        return listTiporegimen;
    }

    /**
     * @param listTiporegimen the listTiporegimen to set
     */
    public void setListTiporegimen(List<Tiporegimen> listTiporegimen) {
        this.listTiporegimen = listTiporegimen;
    }

    /**
     * @return the listImpuesto
     */
    public List<Impuesto> getListImpuesto() {
        return listImpuesto;
    }

    /**
     * @param listImpuesto the listImpuesto to set
     */
    public void setListImpuesto(List<Impuesto> listImpuesto) {
        this.listImpuesto = listImpuesto;
    }

    /**
     * @return the listTipodetraccion
     */
    public List<Tipodetraccion> getListTipodetraccion() {
        return listTipodetraccion;
    }

    /**
     * @param listTipodetraccion the listTipodetraccion to set
     */
    public void setListTipodetraccion(List<Tipodetraccion> listTipodetraccion) {
        this.listTipodetraccion = listTipodetraccion;
    }

    /**
     * @return the tipodetraccionDao
     */
    public TipodetraccionDao getTipodetraccionDao() {
        return tipodetraccionDao;
    }

    /**
     * @param tipodetraccionDao the tipodetraccionDao to set
     */
    public void setTipodetraccionDao(TipodetraccionDao tipodetraccionDao) {
        this.tipodetraccionDao = tipodetraccionDao;
    }

    /**
     * @return the planctasDao
     */
    public PlanctasDao getPlanctasDao() {
        return planctasDao;
    }

    /**
     * @param planctasDao the planctasDao to set
     */
    public void setPlanctasDao(PlanctasDao planctasDao) {
        this.planctasDao = planctasDao;
    }

    /**
     * @return the documentoDao
     */
    public DocumentosDao getDocumentoDao() {
        return documentoDao;
    }

    /**
     * @param documentoDao the documentoDao to set
     */
    public void setDocumentoDao(DocumentosDao documentoDao) {
        this.documentoDao = documentoDao;
    }

    /**
     * @return the numemisorDao
     */
    public NumemisorDao getNumemisorDao() {
        return numemisorDao;
    }

    /**
     * @param numemisorDao the numemisorDao to set
     */
    public void setNumemisorDao(NumemisorDao numemisorDao) {
        this.numemisorDao = numemisorDao;
    }

    /**
     * @return the listConsumidor
     */
    public List<Consumidor> getListConsumidor() {
        return listConsumidor;
    }

    /**
     * @param listConsumidor the listConsumidor to set
     */
    public void setListConsumidor(List<Consumidor> listConsumidor) {
        this.listConsumidor = listConsumidor;
    }

    /**
     * @return the det_tareoweb_verificationDao
     */
    public Det_tareowebDao getDet_tareoweb_verificationDao() {
        return det_tareoweb_verificationDao;
    }

    /**
     * @param det_tareoweb_verificationDao the det_tareoweb_verificationDao to set
     */
    public void setDet_tareoweb_verificationDao(Det_tareowebDao det_tareoweb_verificationDao) {
        this.det_tareoweb_verificationDao = det_tareoweb_verificationDao;
    }

    /**
     * @return the cabercerDet_tareoweb
     */
    public Det_tareoweb getCabercerDet_tareoweb() {
        return cabercerDet_tareoweb;
    }

    /**
     * @param cabercerDet_tareoweb the cabercerDet_tareoweb to set
     */
    public void setCabercerDet_tareoweb(Det_tareoweb cabercerDet_tareoweb) {
        this.cabercerDet_tareoweb = cabercerDet_tareoweb;
    }

    /**
     * @return the listDet_tareo_verificacion
     */
    public List<Det_tareoweb> getListDet_tareo_verificacion() {
        return listDet_tareo_verificacion;
    }

    /**
     * @param listDet_tareo_verificacion the listDet_tareo_verificacion to set
     */
    public void setListDet_tareo_verificacion(List<Det_tareoweb> listDet_tareo_verificacion) {
        this.listDet_tareo_verificacion = listDet_tareo_verificacion;
    }

    /**
     * @return the listReporte_facturacionTotal
     */
    public List<Reporte_facturacion> getListReporte_facturacionTotal() {
        return listReporte_facturacionTotal;
    }

    /**
     * @param listReporte_facturacionTotal the listReporte_facturacionTotal to set
     */
    public void setListReporte_facturacionTotal(List<Reporte_facturacion> listReporte_facturacionTotal) {
        this.listReporte_facturacionTotal = listReporte_facturacionTotal;
    }

    /**
     * @return the listReporte_facturacionPersonal
     */
    public List<Reporte_facturacion> getListReporte_facturacionPersonal() {
        return listReporte_facturacionPersonal;
    }

    /**
     * @param listReporte_facturacionPersonal the listReporte_facturacionPersonal to set
     */
    public void setListReporte_facturacionPersonal(List<Reporte_facturacion> listReporte_facturacionPersonal) {
        this.listReporte_facturacionPersonal = listReporte_facturacionPersonal;
    }

    /**
     * @return the scosto
     */
    public Float getScosto() {
        return scosto;
    }

    /**
     * @param scosto the scosto to set
     */
    public void setScosto(Float scosto) {
        this.scosto = scosto;
    }

    /**
     * @return the selectReporte_facturacion_detalle
     */
    public Reporte_facturacion getSelectReporte_facturacion_detalle() {
        return selectReporte_facturacion_detalle;
    }

    /**
     * @param selectReporte_facturacion_detalle the selectReporte_facturacion_detalle to set
     */
    public void setSelectReporte_facturacion_detalle(Reporte_facturacion selectReporte_facturacion_detalle) {
        this.selectReporte_facturacion_detalle = selectReporte_facturacion_detalle;
    }

}
