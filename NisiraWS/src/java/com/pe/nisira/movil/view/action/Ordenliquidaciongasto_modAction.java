/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.EConexion;
import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_cuentaDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.CotizacionventasDao;
import com.nisira.core.dao.DestinoadquisicionDao;
import com.nisira.core.dao.DocreferenciaDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.ImpuestoDao;
import com.nisira.core.dao.MonedasDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.Ruta_serviciosDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.TcambioDao;
import com.nisira.core.dao.TipogastoDao;
import com.nisira.core.dao.TipomovimientoDao;
import com.nisira.core.dao.TiporegimenDao;
import com.nisira.core.entity.Areas;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_cuenta;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Cotizacionventas;
import com.nisira.core.entity.Dcotizacionventas;
import com.nisira.core.entity.Destinoadquisicion;
import com.nisira.core.entity.Dimpuesto;
import com.nisira.core.entity.Docreferencia;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Dordenserviciocliente;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Geopoint;
import com.nisira.core.entity.Gmap;
import com.nisira.core.entity.Monedas;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Ruta;
import com.nisira.core.entity.Ruta_servicios;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tcambio;
import com.nisira.core.entity.Tipogasto;
import com.nisira.core.entity.Tipomovimiento;
import com.nisira.core.entity.Tiporegimen;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalGoogleMapOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
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
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DataFormat;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author aburgos
 */
@ManagedBean(name = "ordenliquidaciongasto_modAction")
@SessionScoped
public class Ordenliquidaciongasto_modAction extends AbstactListAction<Ordenliquidaciongasto> {
    private boolean botonEditarDOrdenliquidaciongasto;
    private boolean botonEliminarDOrdenliquidaciongasto;
    private boolean check_igv;
    private int fdordenliquidaciongasto;
    /*********************************LISTAS*******************************************/
    private List<Clieprov> listClieprov;
    private List<Documentos> listDocumentos;
    private List<Documentos> listDocumentos_sunat;
    private List<Numemisor> listNumemisor;
    private List<Dordenliquidaciongasto> lstdordenliquidaciongasto;
    private List<Estados> listEstado;
    private List<Tipogasto> listTipoGasto;
    private List<Monedas> listMonedas;
    private List<Tipomovimiento> listTipomovimiento;
    private List<Tiporegimen> listTiporegimen;
    private List<Consumidor> listConsumidor;
    private List<Destinoadquisicion> listDestinoadquisicion;
    private List<Dimpuesto> listDimpuesto;
    private List<Dordenliquidaciongasto> listDordenliquidaciongasto_verification;
    private List<Concepto_cuenta> listConcepto_cuenta;
    /*************************************DAO***************************************/
    private OrdenliquidaciongastoDao ordenliquidaciongastoDao;
    private DordenliquidaciongastoDao dordenliquidaciongastoDao;
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private ClieprovDao clieprovDao;
    private EstadosDao estadosDao;
    private EmisorDao emisorDao;
    private TcambioDao tcambioDao;
    private MonedasDao monedasDao;
    private SucursalesDao sucursalesDao;
    private TipogastoDao  tipogastoDao;
    private TipomovimientoDao tipomovimientoDao;
    private TiporegimenDao tiporegimenDao;
    private ConsumidorDao consumidorDao;
    private DestinoadquisicionDao destinoadquisicionDao;
    private ImpuestoDao impuestoDao; 
    private Concepto_cuentaDao conceptoCuentaDao;
    /*************************************ENTITY***************************************/
    private UsuarioBean user;
    private String numero;
    private String mensaje;
    private Estados selecEstados;
    private Clieprov selectClieprov;
    private Areas selectArea;
    private Consumidor selectConsumidor;
    private Dordenliquidaciongasto dordenliquidaciongasto;
    private Dordenliquidaciongasto dordenliquidaciongasto_new;
    private Dordenliquidaciongasto selectDordenliquidaciongasto;
    private Clieprov selectClieprovPersonal;
    private Concepto_cuenta selectConcepto_cuenta;
    private Destinoadquisicion selectDestinoadquisicion;
    private ArrayList<String> lista_solution;
    /*************************************CONTROL***************************************/
    private String periodoBase;
    private String periodoDisenio;
    private String mesNumeroDisenio;
    private String mesNombreDisenio;
    private boolean habilitar_baseimponible;
    private boolean habilitar_inafecto;
    private boolean habilitar_proovedor;
    private String log_consola;
    private int num_repetir_detalle;
    private String glosa_detalle_local;
    public Ordenliquidaciongasto_modAction() {
        try {
            /*********************************ENTITY*******************************************/
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            numero = "";
            mensaje = "";
            dordenliquidaciongasto = new Dordenliquidaciongasto();
            dordenliquidaciongasto_new = new Dordenliquidaciongasto();
            /*********************************LISTAS*******************************************/
            lstdordenliquidaciongasto = new ArrayList<Dordenliquidaciongasto>();
            listDocumentos = new ArrayList<Documentos>();
            listNumemisor = new ArrayList<Numemisor>();
            listEstado = new ArrayList<Estados>();
            listClieprov = new ArrayList<Clieprov>();
            listTipoGasto = new ArrayList<>();
            listMonedas = new ArrayList<>();
            listDocumentos_sunat = new ArrayList<>();
            listTipomovimiento = new ArrayList<>();
            listTiporegimen = new ArrayList<>();
            listConsumidor = new ArrayList<>();
            /*********************************DAO*******************************************/
            ordenliquidaciongastoDao = new OrdenliquidaciongastoDao();
            docDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            clieprovDao = new ClieprovDao();
            dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
            emisorDao= new EmisorDao();
            tcambioDao=new TcambioDao();
            monedasDao=new MonedasDao();
            sucursalesDao=new SucursalesDao();
            estadosDao = new EstadosDao();
            tipogastoDao = new TipogastoDao();
            tipomovimientoDao = new TipomovimientoDao();
            tiporegimenDao = new TiporegimenDao();
            consumidorDao = new ConsumidorDao();
            destinoadquisicionDao = new DestinoadquisicionDao();
            impuestoDao = new ImpuestoDao();
            conceptoCuentaDao = new Concepto_cuentaDao();
            /**********************************CONTROLADOR********************************/
            botonEditarDOrdenliquidaciongasto=true;
            botonEliminarDOrdenliquidaciongasto=true;
            habilitar_baseimponible = false;
            habilitar_inafecto = false;
            /**********************************CONFIGURACIÓN - SERVIDOR********************************/
            listDocumentos=docDao.getOrdenLiquidacionGasto(user.getIDEMPRESA());
            listDocumentos_sunat = docDao.listarPorEmpresaWeb_codigosunat(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listMonedas = monedasDao.getListMonedasWeb();
            listTipoGasto = tipogastoDao.listarPorEmpresa_Tipogasto(user.getIDEMPRESA());
            listTipomovimiento = tipomovimientoDao.listarPorEmpresa_Tipomovimiento(user.getIDEMPRESA());
            listTiporegimen = tiporegimenDao.listarPorEmpresa(user.getIDEMPRESA());
            listConsumidor = consumidorDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            listClieprov = clieprovDao.listarClienteProveedorAP_Web(user.getIDEMPRESA());
            listDestinoadquisicion = destinoadquisicionDao.listarPorEmpresaWeb();
            listDimpuesto = impuestoDao.getDImpuesto_igv(user.getIDEMPRESA());
            listConcepto_cuenta = conceptoCuentaDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
            periodoBase=dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            periodoDisenio=dateFormat.format(new Date());
            mesNumeroDisenio=WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            mesNombreDisenio=WebUtil.strMonths[(new Date()).getMonth()];
            
            actualiza_ventana("wMnt_Ordenliquidaciongasto_mod");
        } catch (NisiraORMException ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCellEdit(CellEditEvent event) {
        try{
            Object newValue = event.getNewValue();
            Dordenliquidaciongasto entity =(Dordenliquidaciongasto)((DataTable)event.getComponent()).getRowData();
            String pos = entity.getItem();
            if(event.getColumn().getHeaderText()!=null){
                String colHead = event.getColumn().getHeaderText().trim();
                switch(colHead){
                    case "Tipo Gasto":
                        if(newValue==null){
                            entity.setIdconcepto("");
                            entity.setConcepto("");
                        }else{
                            Concepto_cuenta ob = (Concepto_cuenta)newValue;
                            entity.setIdconcepto(ob.getIdconcepto());
                            entity.setConcepto(ob.getDescripcion());
                            entity.setIdcuenta(ob.getIdcuenta());
                            entity.setSelectConcepto_cuenta(ob);
                        };break;
                    case "Proveedor":
                        if(newValue==null){
                            entity.setIdclieprov("");
                            entity.setRazonsocial("");
                        }else if(((Clieprov)newValue) == null){
                            entity.setIdclieprov(newValue.toString());
                            entity.setRazonsocial("");
                        }else{
                            Clieprov ob = (Clieprov)newValue;
                            entity.setIdclieprov(ob.getIdclieprov());
                            entity.setRazonsocial(ob.getRazonsocial());
                            entity.setSelectProveedor(ob);
                        };break;
                    case "Fecha":
                        if(newValue!=null){
                            Date fecha = (Date)(newValue);
                            entity.setFecha(fecha);
                            Tcambio tc = tcambioDao.getPorFecha(WebUtil.fechaDMY(fecha, 5));
                            if(tc!=null)
                                entity.setTcambio(tc.getT_compra());
                            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto:item_tcambio");
                            
                        };break;
                    case "TD":
                        if(newValue==null){
                            entity.setIddocumento("");
                        }else{
                            Documentos ob = (Documentos)newValue;
                            entity.setIddocumento(ob.getIddocumento());
                            entity.setSelectDocumentos(ob);
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
                    case "Régimen":
                        if(newValue==null){
                            entity.setIdregimen("");
                        }else{
                            if(newValue.toString().trim().equals("01")){
                                entity.setInafecto(0.0f);
                                Float imp_dec =  entity.getAfecto()/100;
                                entity.setImpuesto(entity.getAfecto()*imp_dec);
                                entity.setHabilitar_baseimponible(false);
                                entity.setHabilitar_inafecto(true);
                            }else if(newValue.toString().trim().equals("02")){
                                Float imp_dec =  entity.getAfecto()/100;
                                entity.setImpuesto(entity.getAfecto()*imp_dec);
                                entity.setHabilitar_baseimponible(false);
                                entity.setHabilitar_inafecto(false);
                            }else if(newValue.toString().trim().equals("03")){
                                entity.setAfecto(0.0f);
                                entity.setImpuesto(0.0f);
                                entity.setHabilitar_baseimponible(true);
                                entity.setHabilitar_inafecto(false);
                            }
                        }
                        ;break;
                    case "Base Imponible":
                        if(newValue==null){
                            entity.setAfecto(0.0f);
                        }else{
                            Float fv = Float.valueOf(newValue.toString());
                            entity.setAfecto(fv);
                            Float imp_dec =  (entity.getPimpuesto()==null?0.0f:entity.getPimpuesto())/100;
                            entity.setImpuesto(entity.getAfecto()*imp_dec);
                        };break;
                    case "Inafecto":
                        if(newValue==null){
                            entity.setInafecto(0.0f);
                        };break;
                    case "Destino":
                        if(newValue==null){
                            entity.setIddestino("");
                        }else{
                            Destinoadquisicion ob = (Destinoadquisicion)newValue;
                            entity.setIddestino(ob.getIddestino());
                            entity.setSelectDestinoadquisicion(ob);
                        };break;
                    case "Consumidor":
                        if(newValue==null){
                            entity.setIdconsumidor("");
                            entity.setConsumidor("");
                        }else{
                            Consumidor ob = (Consumidor)newValue;
                            entity.setIdconsumidor(ob.getIdconsumidor());
                            entity.setConsumidor(ob.getDescripcion());
                            entity.setSelectConsumidor(ob);
                        };break;
                }
                /*CALCULO DE TOTAL*/
                entity.setImporte(entity.getAfecto()+entity.getInafecto()+entity.getImpuesto());
                replazarCampo(entity,pos);
                actualizarTotal();
                grabar_local();
            }  
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }catch(NisiraORMException ex){
            this.mensaje = ex.getMessage();
            WebUtil.error(this.mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean replazarCampo(Dordenliquidaciongasto ob,String item){
        boolean flag = false;
        for(int i=0;i<lstdordenliquidaciongasto.size();i++){
            Dordenliquidaciongasto dw = lstdordenliquidaciongasto.get(i);
            if(dw.getItem().equals(item)){
                lstdordenliquidaciongasto.set(i, dw);
                flag = true;
                break;
            }
        }
        return flag;
    }
    public void actualizarTotal(){
        BigDecimal igv_calculado,afecto,inafecto,total = new BigDecimal(0.0f) ;
        int ipos = 1;
        for(Dordenliquidaciongasto dl : lstdordenliquidaciongasto){
            dl.setItem(WebUtil.cerosIzquierdaString(ipos++, 3));
            igv_calculado = (new BigDecimal(dl.getImpuesto())).setScale(2, RoundingMode.HALF_UP);
            afecto = (new BigDecimal(dl.getAfecto())).setScale(2, RoundingMode.HALF_UP);
            inafecto = (new BigDecimal(dl.getInafecto())).setScale(2, RoundingMode.HALF_UP);
            total = (total.add(igv_calculado).add(afecto).add(inafecto)).setScale(2, RoundingMode.HALF_UP);
        }
        getDatoEdicion().setImporte(total.floatValue());
        getDatoEdicion().setRendido(total.floatValue());
        if(getDatoEdicion().getRendido().floatValue()==getDatoEdicion().getEntregado().floatValue()){
            getDatoEdicion().setDevolver(0.0f);
            getDatoEdicion().setReembolsar(0.0f);
        }else if(getDatoEdicion().getRendido()>getDatoEdicion().getEntregado()){
            getDatoEdicion().setDevolver(0.0f);
            getDatoEdicion().setReembolsar(getDatoEdicion().getRendido()-getDatoEdicion().getEntregado());
        }else if(getDatoEdicion().getRendido()<getDatoEdicion().getEntregado()){
            getDatoEdicion().setDevolver(getDatoEdicion().getEntregado()-getDatoEdicion().getRendido());
            getDatoEdicion().setReembolsar(0.0f);
        }
        RequestContext.getCurrentInstance().update("datos:timporte");
        RequestContext.getCurrentInstance().update("datos:trendido");
        RequestContext.getCurrentInstance().update("datos:tdevolver");
        RequestContext.getCurrentInstance().update("datos:treembolsar");
        RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
    }
    public void cargarDocumentosDestinoConsumidor(){
        try{
            if(!lstdordenliquidaciongasto.isEmpty()){
                Dordenliquidaciongasto temp;
                Concepto_cuenta tg;
                Documentos doc ;
                Clieprov cl;
                Destinoadquisicion da;
                Consumidor cs;
                for(int i=0;i<lstdordenliquidaciongasto.size();i++){
                    temp = lstdordenliquidaciongasto.get(i);
                    if(temp.getIdconcepto()!=null){
                        if(!temp.getIdconcepto().trim().equals("")){
                            tg =  searchConcepto_cuenta_local(temp.getIdconcepto());
                            temp.setIdcuenta(tg.getIdcuenta());
                            temp.setConcepto(tg.getDescripcion());
                            temp.setSelectConcepto_cuenta(tg);
                        }
                    }
                    if(temp.getIdclieprov()!=null){
                        if(!temp.getIdclieprov().trim().equals("")){
                            cl = searchClieprov_local(temp.getIdclieprov());
                            if(cl!=null){
                                temp.setRazonsocial(cl.getRazonsocial());
                                temp.setSelectProveedor(cl);
                            }else{
                                temp.setRazonsocial("");
                            }
                        }
                    }
                    if(temp.getIddocumento()!=null){
                        if(!temp.getIddocumento().trim().equals("")){
                            doc = searchDocumentos_local(temp.getIddocumento());
                            temp.setSelectDocumentos(doc);
                        }
                    }
                    if(temp.getIdconsumidor()!=null){
                        if(!temp.getIdconsumidor().trim().equals("")){
                            cs = searchConsumidor_local(temp.getIdconsumidor());
                            temp.setSelectConsumidor(cs);
                        }
                    }
                    if(temp.getIddestino()!=null){
                        if(!temp.getIddestino().trim().equals("")){
                            da = searchDestinoadquisicion_local(temp.getIddestino());
                            temp.setSelectDestinoadquisicion(da);
                        }
                    }
                    lstdordenliquidaciongasto.set(i, temp);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void postProcessXLS(Object document) {
        String nameSheet = "TABLA" ;
        HSSFWorkbook wb = (HSSFWorkbook) document;
        wb.setSheetName(0,nameSheet);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        /*************************STYLE HEADER****************************/
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFFont font = wb.createFont();//Create font
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        cellStyle.setAlignment(cellStyle.ALIGN_CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setFillForegroundColor(HSSFColor.BLACK.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setWrapText(true);
        /*****************************************************/
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
            cell.setCellStyle(cellStyle);
            String celdaHeader = cell.getStringCellValue();
            cell.setCellValue(celdaHeader.toUpperCase());
        }
    }
    public Concepto_cuenta searchConcepto_cuenta_local(String idconcepto){
        Concepto_cuenta tp = null;
        if(idconcepto!=null){
            for(Concepto_cuenta ob :listConcepto_cuenta){
                if(ob.getIdconcepto().trim().equals(idconcepto.trim())){
                    tp = ob;break;
                }
            }
        }
        return tp;
    }
    public Tipogasto searchTipogasto_local(String idconcepto){
        Tipogasto tp = null;
        if(idconcepto!=null){
            for(Tipogasto ob :listTipoGasto){
                if(ob.getIdtipogasto().trim().equals(idconcepto.trim())){
                    tp = ob;break;
                }
            }
        }
        return tp;
    }
    public Documentos searchDocumentos_local(String iddocumento){
        Documentos doc = null;
        if(iddocumento!=null){
            for(Documentos ob :listDocumentos_sunat){
                if(ob.getIddocumento().trim().equals(iddocumento.trim())){
                    doc = ob;break;
                }
            }
        }
        return doc;
    }
    public Clieprov searchClieprov_local(String idclieprov){
        Clieprov cl = null;
        if(idclieprov!=null){
            for(Clieprov ob :listClieprov){
                if(ob.getIdclieprov().trim().equals(idclieprov.trim())){
                    cl = ob;break;
                }
            }
        }
        return cl;
    }
    public Consumidor searchConsumidor_local(String idconcumidor){
        Consumidor cs = null;
        if(idconcumidor!=null){
            for(Consumidor ob :listConsumidor){
                if(ob.getIdconsumidor().trim().equals(idconcumidor.trim())){
                    cs = ob;break;
                }
            }
        }
        return cs;
    }
    public Destinoadquisicion searchDestinoadquisicion_local(String iddestino){
        Destinoadquisicion da = null;
        if(iddestino!=null){
            for(Destinoadquisicion ob :listDestinoadquisicion){
                if(ob.getIddestino().trim().equals(iddestino.trim())){
                    da = ob;break;
                }
            }
        }
        return da;
    }
    public void onRefresh(){
        actualizarTotal();
        RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
    }
    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /*********************************LISTAS*******************************************/
        setLstdordenliquidaciongasto(new ArrayList<Dordenliquidaciongasto>());
        setListDocumentos(new ArrayList<Documentos>());
        setListNumemisor(new ArrayList<Numemisor>());
        setListEstado(new ArrayList<Estados>());
//        setListClieprov(new ArrayList<Clieprov>());
        /*********************************DAO*******************************************/
        setOrdenliquidaciongastoDao(new OrdenliquidaciongastoDao());
        setDocDao(new DocumentosDao());
        setNumemisorDao(new NumemisorDao());
        setClieprovDao(new ClieprovDao());
        setEstadosDao(new EstadosDao());
        sucursalesDao = new SucursalesDao();
        /*********************************ENTITY*******************************************/
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        /**********************************CONTROLADOR********************************/
        botonEditarDOrdenliquidaciongasto=true;
        botonEliminarDOrdenliquidaciongasto=true;
        /**********************************CONFIGURACION********************************/
        lista_solution=CoreUtil.valoresBase();
        actualiza_ventana("wMnt_Ordenliquidaciongasto_mod");
        return "";
    }

    @Override
    public void nuevo() {
        getIniciar();
        setDatoEdicion(new Ordenliquidaciongasto());
        getDatoEdicion().setFecha(new Date());
        getDatoEdicion().setFecharegistro(new Date());
        getDatoEdicion().setIdempresa(user.getIDEMPRESA());
        getDatoEdicion().setIdemisor(lista_solution.get(5));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        getDatoEdicion().setPeriodo(dateFormat.format(new Date()));
        getDatoEdicion().setMes(WebUtil.strMonths[(new Date()).getMonth()]);
        getDatoEdicion().setIdsucursal(Constantes.IDSUCURSALGENERAL);
        getDatoEdicion().setVventa(0.0f);
        getDatoEdicion().setImpuesto(0.0f);
        getDatoEdicion().setImporte(0.0f);
        getDatoEdicion().setNumero(numero);
        getDatoEdicion().setEntregado(0.0f);
        getDatoEdicion().setRendido(0.0f);
        getDatoEdicion().setDevolver(0.0f);
        getDatoEdicion().setReembolsar(0.0f);
        if(!WebUtil.isnull(user.getIdcodigogeneral(), "").equals(""))
            getDatoEdicion().setIdclieprov(WebUtil.cerosIzquierda(user.getIdcodigogeneral(),11));
        else
            getDatoEdicion().setIdclieprov("");
        getDatoEdicion().setRazonsocial(user.getNombres());
        getDatoEdicion().setIdestado("PE");
        try {
            /*CONSULTAS A BD*/
            String sucursal = sucursalesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
            getDatoEdicion().setSucursal(sucursal);
            String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
            getDatoEdicion().setEmisor(emisor);
            List<Monedas> listMoneda = monedasDao.getListMonedasWeb();
            if(!listMoneda.isEmpty()){
                Monedas monedas = listMoneda.get(0);
                getDatoEdicion().setIdmoneda(monedas.getIdmoneda());
                getDatoEdicion().setMoneda(monedas.getDescripcion());
            }
            Tcambio tcambio=tcambioDao.getPorFecha(WebUtil.fechaDMY(getDatoEdicion().getFecha(), 5));
            if(tcambio!=null)getDatoEdicion().setTcambio(tcambio.getT_compra());
            else getDatoEdicion().setTcambio(0.0f);
        } catch (NisiraORMException ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public boolean esVistaValida() throws NisiraORMException {
        if (getDatoEdicion().getIdclieprov().isEmpty() & getDatoEdicion().getRazonsocial().isEmpty()) {
            WebUtil.MensajeAdvertencia("Seleccione Cliente");
            return false;
        }
        if (getLstdordenliquidaciongasto().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle de servicio");
            return false;
        }
        if(!estadosDao.validar_modificacion_documento(user.getIDEMPRESA(),"", getDatoEdicion().getIdestado())){
            WebUtil.MensajeAdvertencia("El documento no tiene el Estado Indicado para ralizar el proceso");
            RequestContext.getCurrentInstance().update("datos:growl");
            return false;
        }
        return true;
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                if(getDatoEdicion().getIdorden()==null){
                    mensaje=getOrdenliquidaciongastoDao().grabar(1, getDatoEdicion(), getLstdordenliquidaciongasto(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdorden(mensaje.trim());
                }
                else
                    mensaje=getOrdenliquidaciongastoDao().grabar(2, getDatoEdicion(), getLstdordenliquidaciongasto(),user.getIDUSUARIO());
                setMensaje(WebUtil.exitoRegistrar("Orden Liquidación Gasto ", mensaje));
                setLvalidate(true);
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos");
                //RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
        }
    }
    public void grabar_local(){
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                if(getDatoEdicion().getIdorden()==null){
                    mensaje=getOrdenliquidaciongastoDao().grabar(1, getDatoEdicion(), getLstdordenliquidaciongasto(),user.getIDUSUARIO());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdorden(mensaje.trim());
                }
                else
                    mensaje=getOrdenliquidaciongastoDao().grabar(2, getDatoEdicion(), getLstdordenliquidaciongasto(),user.getIDUSUARIO());
//                setMensaje(WebUtil.exitoRegistrar("Tareo Web", mensaje));
//                WebUtil.info(getMensaje());
                setLvalidate(false);
//                setLvalidate(true);
//                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    @Override
    public void eliminar() {
        try {
            if (getOpc_anular_eliminar().equalsIgnoreCase("ANULAR")) {
                getDatoEdicion().setIdestado("AN");
                mensaje=ordenliquidaciongastoDao.anular(getDatoEdicion(),user.getIDUSUARIO());
                if(mensaje!=null){
                    setMensaje(WebUtil.exitoEliminar("Orden Liquidación Gasto", mensaje));
                    WebUtil.info(getMensaje());
                    setLvalidate(true);
                    buscarFiltro(2);
                }
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                getDatoEdicion().setIdestado("CR");
                mensaje="No existe opción eliminar";
                setMensaje(WebUtil.exitoEliminar("Orden Liquidación Gasto", mensaje));
                WebUtil.info(getMensaje());
            }
        } catch (Exception ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void aprobar() {
        try {
            if(getDatoEdicion().getIdorden()==null){
                this.mensaje = "Documento no registrado";
                WebUtil.MensajeAdvertencia(this.mensaje );
            }
//            else if(getDatoEdicion().getIdestado().equalsIgnoreCase("AP")){
//                this.mensaje = "Documento se encuentra aprobado";
//                WebUtil.MensajeAdvertencia(this.mensaje );
//            }
            else if(verificar_aprobacion()){
                mensaje=getOrdenliquidaciongastoDao().aprobarOrdenliquidaciongasto(getDatoEdicion(),user.getIDUSUARIO());
                if(mensaje!=null)
                    if(mensaje.trim().length()==15)
                        getDatoEdicion().setIdorden(mensaje.trim());
                WebUtil.info("Se aprobó el documento :"+getDatoEdicion().getIddocumento()+"-"+
                        getDatoEdicion().getSerie()+"-"+getDatoEdicion().getNumero()+" ("+getMensaje()+")");
                setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
            setMensaje(ex.getMessage());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public boolean verificar_aprobacion() throws IOException{
        boolean flag = true;
        String validacion ="";
        String httpcontenido="";
        listDordenliquidaciongasto_verification = new ArrayList<>();
        for(int i=0;i<lstdordenliquidaciongasto.size();i++){
            Dordenliquidaciongasto obj = lstdordenliquidaciongasto.get(i);
            validacion ="";
            if(obj.getIdconcepto()==null){
                validacion+="\n\t<Tipo Gasto> no asignado";
            }else if(obj.getIdconcepto().trim().equals("")){
                validacion+="\n\t<Tipo Gasto> no asignado";  
            }
            if(obj.getIdclieprov()==null){
                validacion+="\n\t<Proveedor> no asignado";
            }else if(obj.getIdclieprov().trim().equals("")){
                validacion+="\n\t<Proveedor> no asignado";  
            }else if(obj.getRazonsocial()==null){
                validacion+="\n\t<Proveedor> no registrado en el sistema";  
            }else if(obj.getRazonsocial().trim().equals("")){
                validacion+="\n\t<Proveedor> no registrado en el sistema";  
            }
            if(obj.getIdtipomov()==null){
                validacion+="\n\t<Tipo movimiento> no asignado";
            }else if(obj.getIdclieprov().trim().equals("")){
                validacion+="\n\t<Tipo movimiento> no asignado";  
            }
            if(obj.getIddocumento()==null){
                validacion+="\n\t<Documento> no asignado";
            }else if(obj.getIddocumento().trim().equals("")){
                validacion+="\n\t<Documento> no asignado";  
            }
            if(obj.getSerie()==null){
                validacion+="\n\t<Serie> no asignado";
            }else if(obj.getSerie().trim().equals("")){
                validacion+="\n\t<Serie> no asignado";  
            }
            if(obj.getNumero()==null){
                validacion+="\n\t<Número> no asignado";
            }else if(obj.getNumero().trim().equals("")){
                validacion+="\n\t<Número> no asignado";  
            }
            if(obj.getFecha()==null)
                validacion+="\n\t<Fecha> no asignado";
            if(!validacion.equals("")){
                flag = false;
                this.mensaje="Fila N°:"+obj.getItem()+validacion;
                httpcontenido+="\n"+this.mensaje;
            }else{
                listDordenliquidaciongasto_verification.add(obj);
            }
        }
        setLog_consola(null);
        if(!httpcontenido.trim().equals("")){
            httpcontenido="***************** DETALLE OBSERVADO *******************"+httpcontenido;
            mostrarLog_txt(httpcontenido);
        }
        return flag;
    }
    @Override
    public String buscarFiltro(int tipo) {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(getOrdenliquidaciongastoDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Ordenliquidaciongasto_mod");
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

        HSSFWorkbook objWB = (HSSFWorkbook) document;
        objWB.setSheetName(0,"DETALLADO");
        HSSFRow fila_cabecera = objWB.getSheetAt(0).getRow(0);
        HSSFRow fila_cabecera_formato = objWB.getSheetAt(0).getRow(0);

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
        
        int col = 18;
        int row = lstdordenliquidaciongasto.size();
        HSSFCell celda;
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("N°");break;
                case 1:celda.setCellValue("Tipo Gasto");break;
                case 2:celda.setCellValue("Proveedor");break;
                case 3:celda.setCellValue("TD");break;
                case 4:celda.setCellValue("Serie");break;
                case 5:celda.setCellValue("Número");break;
                case 6:celda.setCellValue("Fecha");break;
                case 7:celda.setCellValue("T.Cambio");break;
                case 8:celda.setCellValue("Moneda");break;
                case 9:celda.setCellValue("Consumidor");break;
                case 10:celda.setCellValue("Régimen");break;
                case 11:celda.setCellValue("Base Imponible");break;
                case 12:celda.setCellValue("Inafecto");break;
                case 13:celda.setCellValue("%Impto.");break;
                case 14:celda.setCellValue("Impuesto");break;
                case 15:celda.setCellValue("Total");break;
                case 16:celda.setCellValue("Destino");break;
                case 17:celda.setCellValue("Glosa");break;
            }
        }
        HSSFRow fila;
        for(int i=0;i<row;i++){
            fila = objWB.getSheetAt(0).getRow(i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getItem());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdconcepto()+" "+lstdordenliquidaciongasto.get(i).getConcepto());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdclieprov()+" "+lstdordenliquidaciongasto.get(i).getRazonsocial());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIddocumento());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getSerie());
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getNumero());
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(lstdordenliquidaciongasto.get(i).getFecha(), 7));
            
            celda = fila.createCell((short)7);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getTcambio()).doubleValue());
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdmoneda());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdccosto());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdregimen());
            
            celda = fila.createCell((short)11);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getAfecto()).doubleValue());
            
            celda = fila.createCell((short)12);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getInafecto()).doubleValue());
            
            celda = fila.createCell((short)13);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getPimpuesto()).doubleValue());
            
            celda = fila.createCell((short)14);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getImpuesto());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getImporte());
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIddestino());
            
            celda = fila.createCell((short)17);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getGlosa());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(0).autoSizeColumn((short) as);
        }
        /*CREAR OTRA HOJA DETALLADO NISIRA*/
        HSSFSheet sheet1 = objWB.createSheet("FORMATO");
        int ROW_CABECERA = 8;String adicionales[]=getDatosAdicionales(getDatoEdicion().getGlosa());
        fila_cabecera = sheet1.createRow((short)ROW_CABECERA);
        col = 18;
        row = lstdordenliquidaciongasto.size();
        /**********************GENERAR CABECERA********************************************/
        HSSFCell celda_cabecera;
        /*Titulo*/
        fila_cabecera_formato = sheet1.createRow((short)0);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("RENDICIÓN DE CUENTAS  /  REEMBOLSO");
        sheet1.addMergedRegion(new CellRangeAddress(0,0,0,6));
        /*#Liquidacion*/
        fila_cabecera_formato = sheet1.createRow((short)1);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue(adicionales[3]);
        sheet1.addMergedRegion(new CellRangeAddress(1,1,0,6));
        /*Fecha*/
        fila_cabecera_formato = sheet1.createRow((short)2);
        celda_cabecera = fila_cabecera_formato.createCell((short)2);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("Fecha");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)3);        
        celda_cabecera.setCellStyle(estiloFila_date);
        celda_cabecera.setCellValue(WebUtil.fechaDMY(getDatoEdicion().getFecha(), 7));
        /*Usuario - Importe Entregado*/
        fila_cabecera_formato = sheet1.createRow((short)3);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("USUARIO:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)1);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue(getDatoEdicion().getIdclieprov()+" - "+getDatoEdicion().getRazonsocial());
        
        celda_cabecera = fila_cabecera_formato.createCell((short)2);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("Importe Entregado:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)3);
        celda_cabecera.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        celda_cabecera.setCellStyle(estiloFila_numeric);
        celda_cabecera.setCellValue(getDatoEdicion().getEntregado().floatValue());

        /*LUGAR DEL SERVICIO*/
        fila_cabecera_formato = sheet1.createRow((short)4);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("LUGAR DEL SERVICIO:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)1);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue(adicionales[0]);
        
        celda_cabecera = fila_cabecera_formato.createCell((short)2);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("Importe Rendido:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)3);
        celda_cabecera.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        celda_cabecera.setCellStyle(estiloFila_numeric);
        celda_cabecera.setCellValue(getDatoEdicion().getImporte().floatValue());
        
        /*FECHA SALIDA - Saldo por Devolver a Caja*/
        fila_cabecera_formato = sheet1.createRow((short)5);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("FECHA SALIDA:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)1);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue(adicionales[1]);
        
        celda_cabecera = fila_cabecera_formato.createCell((short)2);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("Saldo por Devolver a Caja:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)3);
        celda_cabecera.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        celda_cabecera.setCellStyle(estiloFila_numeric);
        celda_cabecera.setCellValue(getDatoEdicion().getDevolver().floatValue());
        
        /*FECHA RETORNO - Saldo por Reembolsar al Usuario:*/
        fila_cabecera_formato = sheet1.createRow((short)6);
        celda_cabecera = fila_cabecera_formato.createCell((short)0);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("FECHA RETORNO:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)1);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue(adicionales[2]);
        
        celda_cabecera = fila_cabecera_formato.createCell((short)2);
        celda_cabecera.setCellStyle(estiloFila);
        celda_cabecera.setCellValue("Saldo por Reembolsar al Usuario:");
        
        celda_cabecera = fila_cabecera_formato.createCell((short)3);
        celda_cabecera.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        celda_cabecera.setCellStyle(estiloFila_numeric);
        celda_cabecera.setCellValue(getDatoEdicion().getReembolsar().floatValue());
        
        /*******************************************************************************/
        for(int i=0 ;i<col;i++){
            celda = fila_cabecera.createCell((short)i);
            celda.setCellStyle(estiloCelda);
            switch(i){
                case 0:celda.setCellValue("N°");break;
                case 1:celda.setCellValue("Tipo Gasto");break;
                case 2:celda.setCellValue("Proveedor");break;
                case 3:celda.setCellValue("TD");break;
                case 4:celda.setCellValue("Serie");break;
                case 5:celda.setCellValue("Número");break;
                case 6:celda.setCellValue("Fecha");break;
                case 7:celda.setCellValue("T.Cambio");break;
                case 8:celda.setCellValue("Moneda");break;
                case 9:celda.setCellValue("Consumidor");break;
                case 10:celda.setCellValue("Régimen");break;
                case 11:celda.setCellValue("Base Imponible");break;
                case 12:celda.setCellValue("Inafecto");break;
                case 13:celda.setCellValue("%Impto.");break;
                case 14:celda.setCellValue("Impuesto");break;
                case 15:celda.setCellValue("Total");break;
                case 16:celda.setCellValue("Destino");break;
                case 17:celda.setCellValue("Glosa");break;
            }
        }
        for(int i=0;i<row;i++){
            fila = sheet1.createRow((ROW_CABECERA)+i+1);
            
            celda = fila.createCell((short)0);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getItem());
            
            celda = fila.createCell((short)1);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdconcepto()+" "+lstdordenliquidaciongasto.get(i).getConcepto());
            
            celda = fila.createCell((short)2);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdclieprov()+" "+lstdordenliquidaciongasto.get(i).getRazonsocial());
            
            celda = fila.createCell((short)3);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIddocumento());
            
            celda = fila.createCell((short)4);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getSerie());
            
            celda = fila.createCell((short)5);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getNumero());
            
            celda = fila.createCell((short)6);
            celda.setCellStyle(estiloFila_date);
            celda.setCellValue(WebUtil.fechaDMY(lstdordenliquidaciongasto.get(i).getFecha(), 7));
            
            celda = fila.createCell((short)7);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getTcambio()).doubleValue());
            
            celda = fila.createCell((short)8);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdmoneda());
            
            celda = fila.createCell((short)9);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdccosto());
            
            celda = fila.createCell((short)10);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIdregimen());
            
            celda = fila.createCell((short)11);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getAfecto()).doubleValue());
            
            celda = fila.createCell((short)12);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getInafecto()).doubleValue());
            
            celda = fila.createCell((short)13);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(new BigDecimal(lstdordenliquidaciongasto.get(i).getPimpuesto()).doubleValue());
            
            celda = fila.createCell((short)14);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getImpuesto());
            
            celda = fila.createCell((short)15);
            celda.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda.setCellStyle(estiloFila_numeric);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getImporte());
            
            celda = fila.createCell((short)16);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getIddestino());
            
            celda = fila.createCell((short)17);
            celda.setCellStyle(estiloFila);
            celda.setCellValue(lstdordenliquidaciongasto.get(i).getGlosa());
        }
        /*AUTOAJUSTE EN LA HOJA*/
        for (int as = 0; as < col; as++) {
            objWB.getSheetAt(1).autoSizeColumn((short) as);
        }
    }
    public String[] getDatosAdicionales(String glosa){
        String caracter="$$";
        String datos[] = {"-","-","-","Nro de Rendición o Liquidación"};
        /*
            (1) LUGAR DE SERVICIO
            (2) FECHA SALIDAD
            (3) FECHA RETORNO
            (4) N° MANUAL DE RENDICIÓN
        */
        if(!WebUtil.isnull(glosa, "").equals("")){
            /*buscar si existe $$*/
            int posicion, contador = 0;
            //se busca la primera vez que aparece
            posicion = glosa.indexOf(caracter);
            while (posicion != -1) { //mientras se encuentre el caracter
                contador++;           //se cuenta
                //se sigue buscando a partir de la posición siguiente a la encontrada
                posicion = glosa.indexOf(caracter, posicion + 1);
            }
            // debe existir dos aparciciones para realizar la busqueda
            if(contador==2){
                int ini = glosa.indexOf("$$");
                int fin = glosa.lastIndexOf("$$");
                String substring= glosa.substring(ini,fin);
                if(!WebUtil.isnull(substring, "").equals("")){
                    substring = substring.replace("$$","");
                    String array[]=substring.split(",");
                    if(array!=null){
                        if(array.length>0){
                            int parte=0;
                            for(String porcion: array){
                                switch(parte){
                                    case 0:datos[0]=porcion;break;
                                    case 1:datos[1]=porcion;break;
                                    case 2:datos[2]=porcion;break;
                                    case 3:datos[3]=porcion;break;
                                }
                                parte++;
                            }
                        }
                    }
                }
            } 
        }
        return datos;        
    }
    public void buscar_filtrofecha() {
        try {
            this.mensaje = "";
            SimpleDateFormat  f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setListaDatos(getOrdenliquidaciongastoDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }
    public void findetalle() throws Exception {
        try{
            /**********************************CONFIGURACIÓN - SERVIDOR********************************/
            listDocumentos=docDao.getOrdenLiquidacionGasto(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            lstdordenliquidaciongasto = dordenliquidaciongastoDao.listarPorOrdenliquidaciongastoWeb(user.getIDEMPRESA(),getDatoEdicion().getIdorden());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
            periodoBase=dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            periodoDisenio=dateFormat.format(new Date());
            mesNumeroDisenio=WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            mesNombreDisenio=WebUtil.strMonths[(new Date()).getMonth()];
            if(getLadd()==2){/*EDITAR*/
                periodoBase=getDatoEdicion().getPeriodo();
                periodoDisenio=getDatoEdicion().getPeriodo().substring(0, 4);
                mesNumeroDisenio=getDatoEdicion().getPeriodo().substring(4);
                mesNombreDisenio=WebUtil.strMonths[Integer.parseInt(getDatoEdicion().getPeriodo().substring(4))-1];
                listConcepto_cuenta = conceptoCuentaDao.listarPorEmpresaWeb_Area(user.getIDEMPRESA(),getDatoEdicion().getIdarea());
            }
            cargarDocumentosDestinoConsumidor();
            RequestContext.getCurrentInstance().update("datos");
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }catch(Exception ex){
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /*** responsable ***/
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovProveedor", modalOptions, null);
    }
    public void verCntArea() {
        RequestContext.getCurrentInstance().openDialog("cntAreas", modalOptions, null);
    }
    /*** detalle ***/
    public void verCntClieprovDetalle() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovProveedor", modalOptions, null);
    }
    public void verCntConcepto_cuenta() {
        RequestContext.getCurrentInstance().openDialog("cntConcepto_cuenta", modalOptions, null);
    }
    public void verCntDestinoadquisicion() {
        RequestContext.getCurrentInstance().openDialog("cntDestinoadquisicion", modalOptions, null);
    }
    public void verCntDocumentoscodigosunat(){
        RequestContext.getCurrentInstance().openDialog("cntDocumentoCodigosunat", modalOptions, null);
    }
    public void valorDocumentoscodigosunat(SelectEvent event) {
        Documentos doc = (Documentos) event.getObject();
        getDordenliquidaciongasto().setIddocumento(doc.getIddocumento());
        getDordenliquidaciongasto().setDocumento(doc.getDescripcion());
        getDordenliquidaciongasto().setAfecto(0.f);
        getDordenliquidaciongasto().setInafecto(0.f);
        getDordenliquidaciongasto().setImpuesto(0.f);
        getDordenliquidaciongasto().setImporte(0.f);        
    }
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        getDatoEdicion().setRazonsocial(selectClieprov.getRazonsocial());
    }
    public void valorArea(SelectEvent event) throws NisiraORMException {
        this.selectArea = (Areas) event.getObject();
        getDatoEdicion().setIdarea(selectArea.getIdarea());
        getDatoEdicion().setArea(selectArea.getDescripcion());
        listConcepto_cuenta = conceptoCuentaDao.listarPorEmpresaWeb_Area(user.getIDEMPRESA(),getDatoEdicion().getIdarea());
    }
    public void valorClieprovDetalle(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        getDordenliquidaciongasto().setIdclieprov(selectClieprov.getIdclieprov());
        getDordenliquidaciongasto().setRazonsocial(selectClieprov.getRazonsocial());
        getDordenliquidaciongasto().setDocumento(selectClieprov.getRuc());
    }
    public void valorConcepto_cuenta(SelectEvent event) {
        this.selectConcepto_cuenta = (Concepto_cuenta) event.getObject();
        getDordenliquidaciongasto().setIdconcepto(selectConcepto_cuenta.getIdconcepto());
        getDordenliquidaciongasto().setConceptocuenta(selectConcepto_cuenta.getDescripcion());
    }
    public void valorDestinoadquisicion(SelectEvent event) {
        this.selectDestinoadquisicion = (Destinoadquisicion) event.getObject();
        getDordenliquidaciongasto().setIddestino(selectDestinoadquisicion.getIddestino());
        getDordenliquidaciongasto().setDestinoadquisicion(selectDestinoadquisicion.getDescripcion());
    }
    public boolean validarDetalle(){
        if(WebUtil.isnull(dordenliquidaciongasto.getIdclieprov(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingrese Proveedor");
            return false;
        }
        if( WebUtil.isnull(dordenliquidaciongasto.getIddocumento(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingrese Documento");
            return false;
        }
        if( WebUtil.isnull(dordenliquidaciongasto.getSerie(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingrese Serie del Documento");
            return false;
        }
        if(WebUtil.isnull(dordenliquidaciongasto.getNumero(), "").equals("")){
            WebUtil.MensajeAdvertencia("Ingrese Número del Documento");
            return false;
        }
        if(dordenliquidaciongasto.getIdregimen().equalsIgnoreCase("01")){
            if(dordenliquidaciongasto.getAfecto()== 0.0f){
                WebUtil.MensajeAdvertencia("Ingrese Valor Afecto");
                return false;
            }
        }else if(dordenliquidaciongasto.getIdregimen().equalsIgnoreCase("03")){
            if(dordenliquidaciongasto.getInafecto()==  0.0f){
                WebUtil.MensajeAdvertencia("Ingrese Valor Inafecto");
                return false;
            }
        }
        if(WebUtil.isnull(dordenliquidaciongasto.getIdconsumidor(), "").equalsIgnoreCase("")){
            WebUtil.MensajeAdvertencia("Ingrese Consumidor");
            return false;
        }
        return true;
    }
    public void grabarDordenliquidaciongasto(){
        String glosa_autogenerada="";
        if(validarDetalle()){
            Dordenliquidaciongasto dol = null;Date fecha = null;
            for(int i=0;i<num_repetir_detalle;i++){
                dol = new Dordenliquidaciongasto();
                dol.setIdempresa(dordenliquidaciongasto.getIdempresa());
                dol.setIdorden(dordenliquidaciongasto.getIdorden());
                //dol.setGlosa(dordenliquidaciongasto.getGlosa());
                //dol.setItem(agregarItemDordenliquidaciongasto());
                dol.setNumero(WebUtil.cerosIzquierdaString(Integer.parseInt(dordenliquidaciongasto.getNumero())+i,7));
                dol.setIdconcepto(dordenliquidaciongasto.getIdconcepto());
                dol.setIdcuenta(dordenliquidaciongasto.getIdcuenta());
                dol.setIdccosto(dordenliquidaciongasto.getIdccosto());
                dol.setIdtipomov(dordenliquidaciongasto.getIdtipomov());
                dol.setIdclieprov(dordenliquidaciongasto.getIdclieprov());
                dol.setIddocumento(dordenliquidaciongasto.getIddocumento());
                dol.setSerie(dordenliquidaciongasto.getSerie());
                //dol.setNumero(dordenliquidaciongasto.getNumero());
                fecha = new Date(dordenliquidaciongasto.getFecha().getTime());
                dol.setFecha(fecha);
                dol.setIddestino(dordenliquidaciongasto.getIddestino());
                dol.setIdmoneda(dordenliquidaciongasto.getIdmoneda());
                dol.setTcmoneda(dordenliquidaciongasto.getTcmoneda());
                dol.setTcambio(dordenliquidaciongasto.getTcambio());
                dol.setIdregimen(dordenliquidaciongasto.getIdregimen());
                dol.setAfecto(dordenliquidaciongasto.getAfecto());
                dol.setInafecto(dordenliquidaciongasto.getInafecto());
                dol.setPimpuesto(dordenliquidaciongasto.getPimpuesto());
                dol.setImpuesto(dordenliquidaciongasto.getImpuesto());
                dol.setImporte(dordenliquidaciongasto.getImporte());
                dol.setOtros(dordenliquidaciongasto.getOtros());
                dol.setIdconsumidor(dordenliquidaciongasto.getIdconsumidor());
                dol.setDocumento(dordenliquidaciongasto.getDocumento());
                dol.setRazonsocial(dordenliquidaciongasto.getRazonsocial());
                dol.setConceptocuenta(dordenliquidaciongasto.getConceptocuenta());
                dol.setDestinoadquisicion(dordenliquidaciongasto.getDestinoadquisicion());
                dol.setConcepto(dordenliquidaciongasto.getConcepto());
                dol.setConsumidor(dordenliquidaciongasto.getConsumidor());
                dol.setConcepto(searchConcepto_cuenta_local(dol.getIdconcepto()).getDescripcion());
                dol.setDestinoadquisicion(searchDestinoadquisicion_local(dol.getIddestino()).getDescripcion());
                /****************************** Select ********************************/
                dol.setSelectConcepto_cuenta(searchConcepto_cuenta_local(dol.getIdconcepto()));
                dol.setSelectConsumidor(searchConsumidor_local(dol.getIdconsumidor()));
                dol.setSelectProveedor(searchClieprov_local(dol.getIdclieprov()));
                dol.setSelectDocumentos(searchDocumentos_local(dol.getIddocumento()));
                dol.setSelectDestinoadquisicion(searchDestinoadquisicion_local(dol.getIddestino()));
                /********************************************************************************************/
                glosa_autogenerada = WebUtil.isnull(dol.getConcepto(), "").toUpperCase().trim()+" / "+
                            WebUtil.isnull(dol.getIdconsumidor(), "").toUpperCase().trim()+" / "+WebUtil.isnull(getGlosa_detalle_local(), "").toUpperCase().trim();
                dol.setGlosa(glosa_autogenerada.trim());
                lstdordenliquidaciongasto.add(dol); 
            }
            actualizarTotal();
//                lstdordenliquidaciongasto.forEach((ls) -> {
//                    getDatoEdicion().setImporte(getDatoEdicion().getImporte()+ls.getImporte());
//                });
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
            RequestContext.getCurrentInstance().update("datos:timporte");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').hide()");
        }else{
            RequestContext.getCurrentInstance().update("datos:growl");
        }  
            
    }
    public void addDordenliquidaciongasto() {
        try {
            setDordenliquidaciongasto(new Dordenliquidaciongasto());
            getDordenliquidaciongasto().setIdempresa(user.getIDEMPRESA());
            getDordenliquidaciongasto().setIdorden(getDatoEdicion().getIdorden());
            getDordenliquidaciongasto().setItem(agregarItemDordenservicio());
            if(listTiporegimen.isEmpty()){
                getDordenliquidaciongasto().setIdregimen("");
            }else{
                getDordenliquidaciongasto().setIdregimen(listTiporegimen.get(0).getIdregimen());
                getDordenliquidaciongasto().setHabilitar_inafecto(true);
            }
            if(listTipomovimiento.isEmpty()){
                getDordenliquidaciongasto().setIdtipomov("");
            }else{
                getDordenliquidaciongasto().setIdtipomov(listTipomovimiento.get(0).getIdtipomov());
            }
            getDordenliquidaciongasto().setAfecto(0.0f);
            getDordenliquidaciongasto().setInafecto(0.0f);
            if(listDimpuesto.isEmpty()){
                getDordenliquidaciongasto().setPimpuesto(0.0f);
            }else{
                getDordenliquidaciongasto().setPimpuesto(listDimpuesto.get(0).getValor());
            }
            getDordenliquidaciongasto().setImpuesto(0.0f);
            getDordenliquidaciongasto().setImporte(0.0f);
            getDordenliquidaciongasto().setIdmoneda(getDatoEdicion().getIdmoneda());
            lstdordenliquidaciongasto.add(getDordenliquidaciongasto());
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        } catch (Exception ex) {
            this.mensaje = ex.getMessage();
            WebUtil.error(this.mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuevoDordenliquidaciongasto() {
        try {
            num_repetir_detalle = 1;
            setGlosa_detalle_local("");
            setDordenliquidaciongasto(new Dordenliquidaciongasto());
            getDordenliquidaciongasto().setIdempresa(user.getIDEMPRESA());
            getDordenliquidaciongasto().setIdorden(getDatoEdicion().getIdorden());
            getDordenliquidaciongasto().setItem(agregarItemDordenservicio());
            if(listTiporegimen.isEmpty()){
                getDordenliquidaciongasto().setIdregimen("");
            }else{
                getDordenliquidaciongasto().setIdregimen(listTiporegimen.get(0).getIdregimen());
                getDordenliquidaciongasto().setHabilitar_inafecto(true);
            }
            if(listTipomovimiento.isEmpty()){
                getDordenliquidaciongasto().setIdtipomov("");
            }else{
                getDordenliquidaciongasto().setIdtipomov(listTipomovimiento.get(0).getIdtipomov());
            }
            getDordenliquidaciongasto().setAfecto(0.0f);
            getDordenliquidaciongasto().setInafecto(0.0f);
            if(listDimpuesto.isEmpty()){
                getDordenliquidaciongasto().setPimpuesto(0.0f);
            }else{
                getDordenliquidaciongasto().setPimpuesto(listDimpuesto.get(0).getValor());
            }
            getDordenliquidaciongasto().setImpuesto(0.0f);
            getDordenliquidaciongasto().setImporte(0.0f);
            getDordenliquidaciongasto().setIdmoneda(getDatoEdicion().getIdmoneda());
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').show()");
        } catch(Exception ex){
            this.mensaje = ex.getMessage();
            WebUtil.error(this.mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarDordenliquidaciongasto() {
        try {            
            if(selectDordenliquidaciongasto!=null){
                if(selectDordenliquidaciongasto.getIdloteproduccion()!=null)
                   if(selectDordenliquidaciongasto.getIdloteproduccion().equals("1"))
                      this.check_igv =  true;
                   else
                       this.check_igv =  false;
                else
                    this.check_igv =  false;
                fdordenliquidaciongasto = 2;
                listTipoGasto = tipogastoDao.listarPorEmpresa_Tipogasto(user.getIDEMPRESA());
                setDordenliquidaciongasto((Dordenliquidaciongasto)selectDordenliquidaciongasto.clone());
                RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto");
                RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').show()");  
            }else{
                this.mensaje = "Seleccionar Detalle";
                WebUtil.MensajeAdvertencia(this.mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");   
            }
        } catch (NisiraORMException |CloneNotSupportedException ex) {
            this.mensaje = ex.getMessage();
            WebUtil.error(this.mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarDordenliquidaciongasto() {
        try {
            if(selectDordenliquidaciongasto !=null){
                lstdordenliquidaciongasto.remove(selectDordenliquidaciongasto);
                actualizarTotal();
            }else{
                setMensaje("Seleccionar Detalle");
                WebUtil.fatal(mensaje);
            }
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        } catch (Exception ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addDetalle(){
        try {
            lstdordenliquidaciongasto.add(getDordenliquidaciongasto());
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
            RequestContext.getCurrentInstance().execute("PF('dlgnew_dordenliquidaciongasto').hide()");
        } catch (Exception ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afectoCalc(){
        Float imp_dec =  (dordenliquidaciongasto.getPimpuesto()==null?0.0f:dordenliquidaciongasto.getPimpuesto())/100;
        dordenliquidaciongasto.setImpuesto(dordenliquidaciongasto.getAfecto()*imp_dec);
        dordenliquidaciongasto.setImporte(dordenliquidaciongasto.getAfecto()+dordenliquidaciongasto.getInafecto()+dordenliquidaciongasto.getImpuesto());
    }
    public void inafectoCalc(){
        dordenliquidaciongasto.setImporte(dordenliquidaciongasto.getAfecto()+dordenliquidaciongasto.getInafecto()+dordenliquidaciongasto.getImpuesto());
    }
    public String agregarItemDordenservicio(){
        int dato = 1;
        int may=-999999999;
        for(Dordenliquidaciongasto obj:getLstdordenliquidaciongasto()){
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
    public void onRowSelectDordenservicio(SelectEvent event) throws IOException {
        setBotonEditarDOrdenliquidaciongasto(false);
        setBotonEliminarDOrdenliquidaciongasto(false);
        RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
    }
    public boolean esDetValida() {
        if (dordenliquidaciongasto.getItem().equalsIgnoreCase("")) {
            WebUtil.MensajeError("Ingrese Item del Detalle");
            return false;
        }
//        if (newAlmacen.getDIRECCION().equalsIgnoreCase("")) {
//            WebUtil.MensajeError("Ingrese Direccion de la Almacen");
//            return false;
//        }
//        if (newAlmacen.getNOMBRE_CORTO().equalsIgnoreCase("")) {
//            WebUtil.MensajeError("Ingrese Nombre Corto de la Almacen");
//            return false;
//        }
//        if (newAlmacen.getIDTIPOALMACEN() == 0) {
//            WebUtil.MensajeError("Ingrese Tipo Almacen");
//            return false;
//        }
        return true;
    }
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 7);
        else
            return "";
    }
    public List<Clieprov> completeCliente(String query) {
        List<Clieprov> filteredCliente = new ArrayList<Clieprov>(); 
        for (int i = 0; i < listClieprov.size(); i++) {
            Clieprov skin = listClieprov.get(i);
            if(skin.getIdclieprov().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                skin.getRuc().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                skin.getRazonsocial().trim().toLowerCase().contains(query.trim().toLowerCase())
               ) {
                filteredCliente.add(skin);
            }
        }
        return filteredCliente;
    }
    public List<Documentos> completeDocumentos(String query) {
        List<Documentos> filteredDocumentos = new ArrayList<Documentos>(); 
        for (int i = 0; i < listDocumentos_sunat.size(); i++) {
            Documentos skin = listDocumentos_sunat.get(i);
            if(skin.getIddocumento().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase()) ||
                    skin.getCodigo_sunat().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredDocumentos.add(skin);
            }
        }
        return filteredDocumentos;
    }
    public List<Concepto_cuenta> completeConceptoCuenta(String query) {
        List<Concepto_cuenta> filteredConcepto_cuenta= new ArrayList<Concepto_cuenta>(); 
        for (int i = 0; i < listConcepto_cuenta.size(); i++) {
            Concepto_cuenta skin = listConcepto_cuenta.get(i);
            if(skin.getIdconcepto().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())) {
                filteredConcepto_cuenta.add(skin);
            }
        }
        return filteredConcepto_cuenta;
    }
    public List<Tipogasto> completeConcepto(String query) {
        List<Tipogasto> filteredTipogasto = new ArrayList<Tipogasto>(); 
        for (int i = 0; i < listTipoGasto.size(); i++) {
            Tipogasto skin = listTipoGasto.get(i);
            if(skin.getIdtipogasto().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())) {
                filteredTipogasto.add(skin);
            }
        }
        return filteredTipogasto;
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
    public List<Destinoadquisicion> completeDestinoadquisicion(String query) {
        List<Destinoadquisicion> filteredDestinoadquisicion= new ArrayList<>(); 
        for (int i = 0; i < getListDestinoadquisicion().size(); i++) {
            Destinoadquisicion skin = getListDestinoadquisicion().get(i);
            if(skin.getIddestino().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredDestinoadquisicion.add(skin);
            }
        }
        return filteredDestinoadquisicion;
    }
    public void openDialoClienteNuevo(){
        if(selectDordenliquidaciongasto!=null){
            dordenliquidaciongasto_new = selectDordenliquidaciongasto;
            RequestContext.getCurrentInstance().update("datos:dlgClienteNuevo");
            RequestContext.getCurrentInstance().execute("PF('dlgClienteNuevo').show()");
        }
    }
    public void grabarClienteNuevo(){
        if(dordenliquidaciongasto_new!=null){
            int pos = lstdordenliquidaciongasto.indexOf(selectDordenliquidaciongasto);
            if(pos!=-1){
                lstdordenliquidaciongasto.set(pos,dordenliquidaciongasto_new);
                RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
                RequestContext.getCurrentInstance().execute("PF('dlgClienteNuevo').hide()");
            }
        }
    }
    @Override
    public void mostrarLog_txt(String contenido){
        if(contenido!=null){
            if(!contenido.trim().equals("")){
                log_consola = contenido;
                RequestContext.getCurrentInstance().update("datos:dlg_text");
                RequestContext.getCurrentInstance().execute("PF('dlg_text').show()");
            }
        }
    }
    public void onDateSelect(SelectEvent event) {   
        try {
            Date fecha = (Date)(event.getObject());
            Tcambio tc = tcambioDao.getPorFecha(WebUtil.fechaDMY(fecha, 5));
            if(tc!=null)
                getDatoEdicion().setTcambio(tc.getT_compra());
            RequestContext.getCurrentInstance().update("datos:cctipocambio");
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        } catch (NisiraORMException ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onDateSelectMasivo(SelectEvent event) {   
        try {
            Date fecha = (Date)(event.getObject());
            Tcambio tc = tcambioDao.getPorFecha(WebUtil.fechaDMY(fecha, 5));
            if(tc!=null)
                getDordenliquidaciongasto().setTcambio(tc.getT_compra());
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto:ddtipocambio");
        } catch (NisiraORMException ex) {
            Logger.getLogger(Ordenliquidaciongasto_modAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void verCntConsumidor() {
        RequestContext.getCurrentInstance().openDialog("cntConsumidor", modalOptions, null);
    }
    public void valorConsumidor(SelectEvent event) {
        Consumidor consumidor = (Consumidor) event.getObject();
        getDordenliquidaciongasto().setIdconsumidor(consumidor.getIdconsumidor());
        getDordenliquidaciongasto().setConsumidor(consumidor.getDescripcion());
    }
    public void replicarItem_dordenliquidaciongasto(){
        if(selectDordenliquidaciongasto!=null){
            for(int i=0;i<lstdordenliquidaciongasto.size();i++){
                Dordenliquidaciongasto dtw = lstdordenliquidaciongasto.get(i);
                if(
                    selectDordenliquidaciongasto.getIdconcepto().trim().equals(dtw.getIddocumento().trim()) &&
                    selectDordenliquidaciongasto.getIdclieprov().trim().equals(dtw.getIdclieprov().trim())    
                  ){
                    /******************/
                    dtw.setConcepto(selectDordenliquidaciongasto.getConcepto());
                    dtw.setSelectConcepto_cuenta(selectDordenliquidaciongasto.getSelectConcepto_cuenta());
                    dtw.setRazonsocial(selectDordenliquidaciongasto.getRazonsocial());
                    dtw.setSelectProveedor(selectDordenliquidaciongasto.getSelectProveedor());
//                    dtw.setHora_llegada(selectDet_tareoweb.getHora_llegada());
//                    dtw.setHora_inicio_serv(selectDet_tareoweb.getHora_inicio_serv());
//                    dtw.setHora_liberacion(selectDet_tareoweb.getHora_liberacion());
//                    dtw.setHora_fin_serv(selectDet_tareoweb.getHora_fin_serv());
//                    Date finicio=null;Date ffin=null;
//                    if(selectDet_tareoweb.getFecharegistro()!=null){
//                        finicio = new Date(selectDet_tareoweb.getFecharegistro().getTime());
//                    }
//                    if(selectDet_tareoweb.getFechafinregistro()!=null){
//                        ffin = new Date(selectDet_tareoweb.getFechafinregistro().getTime());
//                    }
//                    dtw.setFecharegistro(finicio);
//                    dtw.setFechafinregistro(ffin);
//                    /****************************************************************************/
//                    dtw.setBrevete_cliente(selectDet_tareoweb.getBrevete_cliente());
//                    dtw.setConductor_cliente(selectDet_tareoweb.getConductor_cliente());
//                    dtw.setPlaca_cliente(selectDet_tareoweb.getPlaca_cliente());
//                    dtw.setNro_oservicio(selectDet_tareoweb.getNro_oservicio());
//                    dtw.setNrocontenedor(selectDet_tareoweb.getNrocontenedor());
//                    dtw.setNroprecinto(selectDet_tareoweb.getNroprecinto());
//                    listDet_tareoweb.set(i, dtw);
                }
            }
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        }
    }
    public void deleteDordenliquidaciongasto_web(){
        Dordenliquidaciongasto sl = selectDordenliquidaciongasto;
        if(sl!=null){
            lstdordenliquidaciongasto.remove(sl);
            //RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }
    }
    public void deleteDordenliquidaciongasto_web_tipogasto(){
        Dordenliquidaciongasto sl = selectDordenliquidaciongasto;
        List<Dordenliquidaciongasto> lst_temp_delete = new ArrayList<>();
        if(sl!=null){
            for(Dordenliquidaciongasto o : lstdordenliquidaciongasto){
                if(sl.getIdconcepto().trim().equals(o.getIdconcepto().trim())){
                    lst_temp_delete.add(o);
                }
            }
            lstdordenliquidaciongasto.removeAll(lst_temp_delete);
            actualizarTotal();
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }
    }
    public void deleteDordenliquidaciongasto_web_proveedor(){
        Dordenliquidaciongasto sl = selectDordenliquidaciongasto;
        List<Dordenliquidaciongasto> lst_temp_delete = new ArrayList<>();
        if(sl!=null){
            for(Dordenliquidaciongasto o : lstdordenliquidaciongasto){
                if(sl.getIdclieprov().trim().equals(o.getIdclieprov().trim())){
                    lst_temp_delete.add(o);
                }
            }
            lstdordenliquidaciongasto.removeAll(lst_temp_delete);
            actualizarTotal();
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:lstdordenliquidaciongasto");
        }
    }
    public String agregarItemDordenliquidaciongasto(){
        int dato = 1;
        int may=-999999999;
        for(Dordenliquidaciongasto obj:getLstdordenliquidaciongasto()){
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
    /***************** EVENTOS *********************/
    public void onRegimen(){
        if(getDordenliquidaciongasto().getIdregimen()!=null){
            if(getDordenliquidaciongasto().getIdregimen().trim().equals("01")){
                getDordenliquidaciongasto().setInafecto(0.0f);
                Float imp_dec =  getDordenliquidaciongasto().getAfecto()/100;
                getDordenliquidaciongasto().setImpuesto(getDordenliquidaciongasto().getAfecto()*imp_dec);
                getDordenliquidaciongasto().setHabilitar_baseimponible(false);
                getDordenliquidaciongasto().setHabilitar_inafecto(true);
            }else if(getDordenliquidaciongasto().getIdregimen().trim().equals("02")){
                Float imp_dec =  getDordenliquidaciongasto().getAfecto()/100;
                getDordenliquidaciongasto().setImpuesto(getDordenliquidaciongasto().getAfecto()*imp_dec);
                getDordenliquidaciongasto().setHabilitar_baseimponible(false);
                getDordenliquidaciongasto().setHabilitar_inafecto(false);
            }else if(getDordenliquidaciongasto().getIdregimen().trim().equals("03")){
                getDordenliquidaciongasto().setAfecto(0.0f);
                getDordenliquidaciongasto().setImpuesto(0.0f);
                getDordenliquidaciongasto().setHabilitar_baseimponible(true);
                getDordenliquidaciongasto().setHabilitar_inafecto(false);
            }
            getDordenliquidaciongasto().setImporte(getDordenliquidaciongasto().getAfecto()+getDordenliquidaciongasto().getInafecto()+getDordenliquidaciongasto().getImpuesto());
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto:base");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto:inafecto");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto:impuesto");
            RequestContext.getCurrentInstance().update("datos:dlgnew_dordenliquidaciongasto:importe");
        }
        else{
            this.mensaje="Seleccionar Regimen";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
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

    public List<Dordenliquidaciongasto> getLstdprogtlleg() {
        return getLstdordenliquidaciongasto();
    }

    public void setLstdprogtlleg(List<Dordenliquidaciongasto> lstdordenliquidaciongasto) {
        this.setLstdordenliquidaciongasto(lstdordenliquidaciongasto);
    }

    /**
     * @return the listClieprov
     */
    public List<Clieprov> getListClieprov() {
        return listClieprov;
    }

    /**
     * @param listClieprov the listClieprov to set
     */
    public void setListClieprov(List<Clieprov> listClieprov) {
        this.listClieprov = listClieprov;
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
     * @return the listNumemisor
     */
    public List<Numemisor> getListNumemisor() {
        return listNumemisor;
    }

    /**
     * @param listNumemisor the listNumemisor to set
     */
    public void setListNumemisor(List<Numemisor> listNumemisor) {
        this.listNumemisor = listNumemisor;
    }

    /**
     * @return the lstdordenliquidaciongasto
     */
    public List<Dordenliquidaciongasto> getLstdordenliquidaciongasto() {
        return lstdordenliquidaciongasto;
    }

    /**
     * @param lstdordenliquidaciongasto the lstdordenliquidaciongasto to set
     */
    public void setLstdordenliquidaciongasto(List<Dordenliquidaciongasto> lstdordenliquidaciongasto) {
        this.lstdordenliquidaciongasto = lstdordenliquidaciongasto;
    }

    /**
     * @return the ordenliquidaciongastoDao
     */
    public OrdenliquidaciongastoDao getOrdenliquidaciongastoDao() {
        return ordenliquidaciongastoDao;
    }

    /**
     * @param ordenliquidaciongastoDao the ordenliquidaciongastoDao to set
     */
    public void setOrdenliquidaciongastoDao(OrdenliquidaciongastoDao ordenliquidaciongastoDao) {
        this.ordenliquidaciongastoDao = ordenliquidaciongastoDao;
    }

    /**
     * @return the docDao
     */
    public DocumentosDao getDocDao() {
        return docDao;
    }

    /**
     * @param docDao the docDao to set
     */
    public void setDocDao(DocumentosDao docDao) {
        this.docDao = docDao;
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
     * @return the clieprovDao
     */
    public ClieprovDao getClieprovDao() {
        return clieprovDao;
    }

    /**
     * @param clieprovDao the clieprovDao to set
     */
    public void setClieprovDao(ClieprovDao clieprovDao) {
        this.clieprovDao = clieprovDao;
    }

    /**
     * @return the listEstado
     */
    public List<Estados> getListEstado() {
        return listEstado;
    }

    /**
     * @param listEstado the listEstado to set
     */
    public void setListEstado(List<Estados> listEstado) {
        this.listEstado = listEstado;
    }

    /**
     * @return the selectClieprov
     */
    public Clieprov getSelectClieprov() {
        return selectClieprov;
    }

    /**
     * @param selectClieprov the selectClieprov to set
     */
    public void setSelectClieprov(Clieprov selectClieprov) {
        this.selectClieprov = selectClieprov;
    }

    /**
     * @return the selecEstados
     */
    public Estados getSelecEstados() {
        return selecEstados;
    }

    /**
     * @param selecEstados the selecEstados to set
     */
    public void setSelecEstados(Estados selecEstados) {
        this.selecEstados = selecEstados;
    }

    /**
     * @return the dordenliquidaciongasto
     */
    public Dordenliquidaciongasto getDordenliquidaciongasto() {
        return dordenliquidaciongasto;
    }

    /**
     * @param dordenliquidaciongasto the dordenliquidaciongasto to set
     */
    public void setDordenliquidaciongasto(Dordenliquidaciongasto dordenliquidaciongasto) {
        this.dordenliquidaciongasto = dordenliquidaciongasto;
    }

    /**
     * @return the selectDordenliquidaciongasto
     */
    public Dordenliquidaciongasto getSelectDordenliquidaciongasto() {
        return selectDordenliquidaciongasto;
    }

    /**
     * @param selectDordenliquidaciongasto the selectDordenliquidaciongasto to set
     */
    public void setSelectDordenliquidaciongasto(Dordenliquidaciongasto selectDordenliquidaciongasto) {
        this.selectDordenliquidaciongasto = selectDordenliquidaciongasto;
    }

    /**
     * @return the selectConsumidor
     */
    public Consumidor getSelectConsumidor() {
        return selectConsumidor;
    }

    /**
     * @param selectConsumidor the selectConsumidor to set
     */
    public void setSelectConsumidor(Consumidor selectConsumidor) {
        this.selectConsumidor = selectConsumidor;
    }

    /**
     * @return the dordenliquidaciongastoDao
     */
    public DordenliquidaciongastoDao getDordenliquidaciongastoDao() {
        return dordenliquidaciongastoDao;
    }

    /**
     * @param dordenliquidaciongastoDao the dordenliquidaciongastoDao to set
     */
    public void setDordenliquidaciongastoDao(DordenliquidaciongastoDao dordenliquidaciongastoDao) {
        this.dordenliquidaciongastoDao = dordenliquidaciongastoDao;
    }

    /**
     * @return the estadosDao
     */
    public EstadosDao getEstadosDao() {
        return estadosDao;
    }

    /**
     * @param estadosDao the estadosDao to set
     */
    public void setEstadosDao(EstadosDao estadosDao) {
        this.estadosDao = estadosDao;
    }

    /**
     * @return the botonEditarDOrdenliquidaciongasto
     */
    public boolean isBotonEditarDOrdenliquidaciongasto() {
        return botonEditarDOrdenliquidaciongasto;
    }

    /**
     * @param botonEditarDOrdenliquidaciongasto the botonEditarDOrdenliquidaciongasto to set
     */
    public void setBotonEditarDOrdenliquidaciongasto(boolean botonEditarDOrdenliquidaciongasto) {
        this.botonEditarDOrdenliquidaciongasto = botonEditarDOrdenliquidaciongasto;
    }

    /**
     * @return the botonEliminarDOrdenliquidaciongasto
     */
    public boolean isBotonEliminarDOrdenliquidaciongasto() {
        return botonEliminarDOrdenliquidaciongasto;
    }

    /**
     * @param botonEliminarDOrdenliquidaciongasto the botonEliminarDOrdenliquidaciongasto to set
     */
    public void setBotonEliminarDOrdenliquidaciongasto(boolean botonEliminarDOrdenliquidaciongasto) {
        this.botonEliminarDOrdenliquidaciongasto = botonEliminarDOrdenliquidaciongasto;
    }

    /**
     * @return the selectClieprovPersonal
     */
    public Clieprov getSelectClieprovPersonal() {
        return selectClieprovPersonal;
    }

    /**
     * @param selectClieprovPersonal the selectClieprovPersonal to set
     */
    public void setSelectClieprovPersonal(Clieprov selectClieprovPersonal) {
        this.selectClieprovPersonal = selectClieprovPersonal;
    }

    /**
     * @return the selectConcepto_cuenta
     */
    public Concepto_cuenta getSelectConcepto_cuenta() {
        return selectConcepto_cuenta;
    }

    /**
     * @param selectConcepto_cuenta the selectConcepto_cuenta to set
     */
    public void setSelectConcepto_cuenta(Concepto_cuenta selectConcepto_cuenta) {
        this.selectConcepto_cuenta = selectConcepto_cuenta;
    }

    /**
     * @return the selectDestinoadquisicion
     */
    public Destinoadquisicion getSelectDestinoadquisicion() {
        return selectDestinoadquisicion;
    }

    /**
     * @param selectDestinoadquisicion the selectDestinoadquisicion to set
     */
    public void setSelectDestinoadquisicion(Destinoadquisicion selectDestinoadquisicion) {
        this.selectDestinoadquisicion = selectDestinoadquisicion;
    }

    /**
     * @return the emisorDao
     */
    public EmisorDao getEmisorDao() {
        return emisorDao;
    }

    /**
     * @param emisorDao the emisorDao to set
     */
    public void setEmisorDao(EmisorDao emisorDao) {
        this.emisorDao = emisorDao;
    }

    /**
     * @return the tcambioDao
     */
    public TcambioDao getTcambioDao() {
        return tcambioDao;
    }

    /**
     * @param tcambioDao the tcambioDao to set
     */
    public void setTcambioDao(TcambioDao tcambioDao) {
        this.tcambioDao = tcambioDao;
    }

    /**
     * @return the monedasDao
     */
    public MonedasDao getMonedasDao() {
        return monedasDao;
    }

    /**
     * @param monedasDao the monedasDao to set
     */
    public void setMonedasDao(MonedasDao monedasDao) {
        this.monedasDao = monedasDao;
    }

    /**
     * @return the sucursalesDao
     */
    public SucursalesDao getSucursalesDao() {
        return sucursalesDao;
    }

    /**
     * @param sucursalesDao the sucursalesDao to set
     */
    public void setSucursalesDao(SucursalesDao sucursalesDao) {
        this.sucursalesDao = sucursalesDao;
    }

    /**
     * @return the periodoBase
     */
    public String getPeriodoBase() {
        return periodoBase;
    }

    /**
     * @param periodoBase the periodoBase to set
     */
    public void setPeriodoBase(String periodoBase) {
        this.periodoBase = periodoBase;
    }

    /**
     * @return the periodoDisenio
     */
    public String getPeriodoDisenio() {
        return periodoDisenio;
    }

    /**
     * @param periodoDisenio the periodoDisenio to set
     */
    public void setPeriodoDisenio(String periodoDisenio) {
        this.periodoDisenio = periodoDisenio;
    }

    /**
     * @return the mesNumeroDisenio
     */
    public String getMesNumeroDisenio() {
        return mesNumeroDisenio;
    }

    /**
     * @param mesNumeroDisenio the mesNumeroDisenio to set
     */
    public void setMesNumeroDisenio(String mesNumeroDisenio) {
        this.mesNumeroDisenio = mesNumeroDisenio;
    }

    /**
     * @return the mesNombreDisenio
     */
    public String getMesNombreDisenio() {
        return mesNombreDisenio;
    }

    /**
     * @param mesNombreDisenio the mesNombreDisenio to set
     */
    public void setMesNombreDisenio(String mesNombreDisenio) {
        this.mesNombreDisenio = mesNombreDisenio;
    }

    /**
     * @return the listTipoGasto
     */
    public List<Tipogasto> getListTipoGasto() {
        return listTipoGasto;
    }

    /**
     * @param listTipoGasto the listTipoGasto to set
     */
    public void setListTipoGasto(List<Tipogasto> listTipoGasto) {
        this.listTipoGasto = listTipoGasto;
    }

    /**
     * @return the check_igv
     */
    public boolean isCheck_igv() {
        return check_igv;
    }

    /**
     * @param check_igv the check_igv to set
     */
    public void setCheck_igv(boolean check_igv) {
        this.check_igv = check_igv;
    }

    /**
     * @return the fdordenliquidaciongasto
     */
    public int getFdordenliquidaciongasto() {
        return fdordenliquidaciongasto;
    }

    /**
     * @param fdordenliquidaciongasto the fdordenliquidaciongasto to set
     */
    public void setFdordenliquidaciongasto(int fdordenliquidaciongasto) {
        this.fdordenliquidaciongasto = fdordenliquidaciongasto;
    }

    /**
     * @return the listMonedas
     */
    public List<Monedas> getListMonedas() {
        return listMonedas;
    }

    /**
     * @param listMonedas the listMonedas to set
     */
    public void setListMonedas(List<Monedas> listMonedas) {
        this.listMonedas = listMonedas;
    }

    /**
     * @return the listTipomovimiento
     */
    public List<Tipomovimiento> getListTipomovimiento() {
        return listTipomovimiento;
    }

    /**
     * @param listTipomovimiento the listTipomovimiento to set
     */
    public void setListTipomovimiento(List<Tipomovimiento> listTipomovimiento) {
        this.listTipomovimiento = listTipomovimiento;
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
     * @return the habilitar_baseimponible
     */
    public boolean isHabilitar_baseimponible() {
        return habilitar_baseimponible;
    }

    /**
     * @param habilitar_baseimponible the habilitar_baseimponible to set
     */
    public void setHabilitar_baseimponible(boolean habilitar_baseimponible) {
        this.habilitar_baseimponible = habilitar_baseimponible;
    }

    /**
     * @return the habilitar_afecto
     */
    public boolean isHabilitar_inafecto() {
        return habilitar_inafecto;
    }

    /**
     * @param habilitar_afecto the habilitar_afecto to set
     */
    public void setHabilitar_inafecto(boolean habilitar_inafecto) {
        this.habilitar_inafecto = habilitar_inafecto;
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
     * @return the listDestinoadquisicion
     */
    public List<Destinoadquisicion> getListDestinoadquisicion() {
        return listDestinoadquisicion;
    }

    /**
     * @param listDestinoadquisicion the listDestinoadquisicion to set
     */
    public void setListDestinoadquisicion(List<Destinoadquisicion> listDestinoadquisicion) {
        this.listDestinoadquisicion = listDestinoadquisicion;
    }

    /**
     * @return the listDimpuesto
     */
    public List<Dimpuesto> getListDimpuesto() {
        return listDimpuesto;
    }

    /**
     * @param listDimpuesto the listDimpuesto to set
     */
    public void setListDimpuesto(List<Dimpuesto> listDimpuesto) {
        this.listDimpuesto = listDimpuesto;
    }

    /**
     * @return the listDordenliquidaciongasto_verification
     */
    public List<Dordenliquidaciongasto> getListDordenliquidaciongasto_verification() {
        return listDordenliquidaciongasto_verification;
    }

    /**
     * @param listDordenliquidaciongasto_verification the listDordenliquidaciongasto_verification to set
     */
    public void setListDordenliquidaciongasto_verification(List<Dordenliquidaciongasto> listDordenliquidaciongasto_verification) {
        this.listDordenliquidaciongasto_verification = listDordenliquidaciongasto_verification;
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

    /**
     * @return the dordenliquidaciongasto_new
     */
    public Dordenliquidaciongasto getDordenliquidaciongasto_new() {
        return dordenliquidaciongasto_new;
    }

    /**
     * @param dordenliquidaciongasto_new the dordenliquidaciongasto_new to set
     */
    public void setDordenliquidaciongasto_new(Dordenliquidaciongasto dordenliquidaciongasto_new) {
        this.dordenliquidaciongasto_new = dordenliquidaciongasto_new;
    }

    /**
     * @return the listConcepto_cuenta
     */
    public List<Concepto_cuenta> getListConcepto_cuenta() {
        return listConcepto_cuenta;
    }

    /**
     * @param listConcepto_cuenta the listConcepto_cuenta to set
     */
    public void setListConcepto_cuenta(List<Concepto_cuenta> listConcepto_cuenta) {
        this.listConcepto_cuenta = listConcepto_cuenta;
    }

    /**
     * @return the habilitar_proovedor
     */
    public boolean isHabilitar_proovedor() {
        return habilitar_proovedor;
    }

    /**
     * @param habilitar_proovedor the habilitar_proovedor to set
     */
    public void setHabilitar_proovedor(boolean habilitar_proovedor) {
        this.habilitar_proovedor = habilitar_proovedor;
    }

    /**
     * @return the num_repetir_detalle
     */
    public int getNum_repetir_detalle() {
        return num_repetir_detalle;
    }

    /**
     * @param num_repetir_detalle the num_repetir_detalle to set
     */
    public void setNum_repetir_detalle(int num_repetir_detalle) {
        this.num_repetir_detalle = num_repetir_detalle;
    }

    /**
     * @return the glosa_detalle_local
     */
    public String getGlosa_detalle_local() {
        return glosa_detalle_local;
    }

    /**
     * @param glosa_detalle_local the glosa_detalle_local to set
     */
    public void setGlosa_detalle_local(String glosa_detalle_local) {
        this.glosa_detalle_local = glosa_detalle_local;
    }

    @Override
    public void termino() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}