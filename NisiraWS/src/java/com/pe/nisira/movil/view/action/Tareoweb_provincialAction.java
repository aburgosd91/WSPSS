/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.NisiraORMException;
import com.nisira.core.dao.AlmacenesDao;
import com.nisira.core.dao.CabtareowebDao;
import com.nisira.core.dao.ClieprovDao;
import com.nisira.core.dao.Concepto_tareoDao;
import com.nisira.core.dao.ConsumidorDao;
import com.nisira.core.dao.Destructura_tareo_clieprovDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.DocumentosDao;
import com.nisira.core.dao.EmisorDao;
import com.nisira.core.dao.EstadosDao;
import com.nisira.core.dao.NumemisorDao;
import com.nisira.core.dao.Personal_servicioDao;
import com.nisira.core.dao.SucursalesDao;
import com.nisira.core.dao.Det_tareowebDao;
import com.nisira.core.dao.Tipo_asistenciaDao;
import com.nisira.core.dao.Turno_trabajoDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Almacen;
import com.nisira.core.entity.Almacenes;
import com.nisira.core.entity.Cabtareoweb;
import com.nisira.core.entity.Cargos_personal;
import com.nisira.core.entity.Clieprov;
import com.nisira.core.entity.Concepto_tareo;
import com.nisira.core.entity.Consumidor;
import com.nisira.core.entity.Destructura_tareo_clieprov;
import com.nisira.core.entity.Det_tareoweb;
import com.nisira.core.entity.Documentos;
import com.nisira.core.entity.Estados;
import com.nisira.core.entity.Numemisor;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.Personal_servicio;
import com.nisira.core.entity.Det_tareoweb;
import com.nisira.core.entity.Programacion;
import com.nisira.core.entity.Rutas;
import com.nisira.core.entity.Tipo_asistencia;
import com.nisira.core.entity.Turno_trabajo;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalOptions;
import static com.pe.nisira.movil.view.action.AbstactListAction.modalParamsOptions;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.ComboEspecial;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Alex Johel Burgos Dionicio
 */
@ManagedBean(name = "tareoweb_provincialAction")
@SessionScoped
public class Tareoweb_provincialAction extends AbstactListAction<Cabtareoweb> {
    /* 
        0-> Visualizar
        1-> Nuevo
        2-> Modificar
    */
    /* CONTROLLER */
    private UsuarioBean user;
    private String iddocumento_local;
    private String serie_local;
    private String numero_local;
    private String iddocumento_add;
    private String serie_add;
    private String numero_add;
    private String dni_local;
    private boolean btn_asignar_personal;
    private int num_repetir;
    private String numero;
    private Date fgeneracion;
    private String glosa_local;
    private String periodoBase;
    private String periodoDisenio;
    private String mesNumeroDisenio;
    private String mesNombreDisenio;
    private String selectComboEspecial_idordenservicio;
    private String selectComboEspecialDetalle_idordenservicio;
    private String cellEdit;
    /* ARRAYLIST */
    private List<DataTableColumn> dataTableColumns;
    private List<String> lstDias;
    private List<Det_tareoweb> listDet_tareoweb;
    private List<Det_tareoweb> listDet_tareoweb_original;
    private List<Clieprov> listPersonal;
    private List<Consumidor> listConsumidor;
    private List<Personal_servicio> listPersonal_servicio;
    private List<Estados> listEstado;
    private List<Almacenes> listAlmacenes;
    private List<Documentos> listDocumentos;
    private List<Numemisor> listNumemisor;
    private ArrayList<String> lista_solution;
    private List<Turno_trabajo> listTurno_trabajo;
    private List<Programacion> listProgramacion;
    private List<Tipo_asistencia> listTipo_asistencia;
    private List<ComboEspecial> listComboEspecial;
    private List<ComboEspecial> listComboEspecialDetalle;
    private List<Concepto_tareo> listConcepto_tareo;
    private List<Destructura_tareo_clieprov> listDestructura_tareo_clieprov;
    /* DAO */
    private ConsumidorDao consumidorDao;
    private Det_tareowebDao tareoWebDao;
    private ClieprovDao clieprovDao;
    private DocumentosDao docDao;
    private NumemisorDao numemisorDao;
    private EstadosDao estadosDao;
    private SucursalesDao sucursalesDao;
    private AlmacenesDao alamcenesDao;
    private EmisorDao emisorDao;
    private CabtareowebDao cabtareowebDao;
    private Det_tareowebDao det_tareowebDao;
    private Turno_trabajoDao turno_trabajoDao;
    private Tipo_asistenciaDao tipo_asistenciaDao;
    private UsuarioDao usuariodao;
    private Concepto_tareoDao concepto_tareoDao; 
    private Destructura_tareo_clieprovDao destructura_tareo_clieprovDao;
    /* ENTITY */
    private Det_tareoweb tareoWeb;
    private Det_tareoweb selectDet_tareoweb;
    private Clieprov selectPersonal;
    private Personal_servicio selectPersonal_servicio;
    private Clieprov selectClieprovPersonal;
    private Consumidor selectConsumidor;
    private ComboEspecial selectComboEspecial;
    private Cargos_personal selectCargo_personal;
    private Clieprov selectClieprov; 
    private Rutas selectRutas;
    /******************************************************/
    private boolean activarBotones;
    private String mensaje;
    private int posSelect_det_tareoweb;
    private String log_consola;
    public Tareoweb_provincialAction(){
        try {
            /* CONTROLLER */
            user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
            btn_asignar_personal = true;
            activarBotones = true;
            num_repetir = 1;
            numero = "";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            periodoBase = dateFormat.format(new Date())+WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            periodoDisenio = dateFormat.format(new Date());
            mesNumeroDisenio = WebUtil.idGeneradoDos((new Date()).getMonth()+1);
            mesNombreDisenio = WebUtil.strMonths[(new Date()).getMonth()];
            /* ARRAYLIST */
            dataTableColumns = new ArrayList<>();
            listAlmacenes = new ArrayList<>();
            listDet_tareoweb = new ArrayList<>();
            listPersonal = new ArrayList<>();
            listPersonal_servicio = new ArrayList<>();
            listConsumidor = new ArrayList<>();
            listDet_tareoweb = new ArrayList<>();
            listEstado = new ArrayList<>();
            lista_solution  = new ArrayList<>();
            listTurno_trabajo  = new ArrayList<>();
            listProgramacion  = new ArrayList<>();
            lstDias  = new ArrayList<>();
            listTipo_asistencia  = new ArrayList<>();
            listComboEspecial  = new ArrayList<>();
            listConcepto_tareo  = new ArrayList<>();
            listDestructura_tareo_clieprov   = new ArrayList<>();
            /* DAO */
            tareoWebDao = new Det_tareowebDao();
            clieprovDao = new ClieprovDao();
            consumidorDao = new ConsumidorDao();
            cabtareowebDao = new CabtareowebDao();
            det_tareowebDao = new Det_tareowebDao();
            docDao = new DocumentosDao();
            numemisorDao = new NumemisorDao();
            estadosDao = new EstadosDao();
            alamcenesDao = new AlmacenesDao();
            sucursalesDao = new SucursalesDao();
            emisorDao = new EmisorDao();
            turno_trabajoDao = new Turno_trabajoDao();
            tipo_asistenciaDao = new Tipo_asistenciaDao();
            usuariodao = new UsuarioDao();
            concepto_tareoDao = new Concepto_tareoDao();
            destructura_tareo_clieprovDao = new  Destructura_tareo_clieprovDao();
            /* ENTITY */
            tareoWeb = new Det_tareoweb();
            selectPersonal = new Clieprov();
            selectConsumidor = new Consumidor();
            selectComboEspecial = new ComboEspecial("","");
            /********************************** CONFIGURACIÓN - SERVIDOR ********************************/
            glosa_local = "";
            lista_solution=CoreUtil.valoresBase();
            listDocumentos=docDao.getCabtareoweb(user.getIDEMPRESA());
            listNumemisor=numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), listDocumentos.get(0).getIddocumento());
            numero=listNumemisor.get(0).getNumero();
            listEstado = estadosDao.listarPorEmpresaWeb(user.getIDEMPRESA(),null);
            listAlmacenes = alamcenesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.getIDSUCURSALGENERAL());
            listTurno_trabajo = turno_trabajoDao.getPorTurno_trabajo();
            listTipo_asistencia = tipo_asistenciaDao.getPorTipo_asistencia(user.getIDEMPRESA());
            listConcepto_tareo = concepto_tareoDao.listarPorEmpresaWeb(user.getIDEMPRESA());
            /**********************************  **************************************/
            actualiza_ventana("wMnt_Tareoweb_provincial");
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarComboEspecial(){
        if(listDet_tareoweb != null){
            ComboEspecial cbe;
            listComboEspecial = new ArrayList<>();
            String descripcion;
            for(Det_tareoweb wb : listDet_tareoweb){
                descripcion = wb.getIddocumento()+"-"+wb.getSerie()+"-"+wb.getNumero()+" ("+wb.getRuc()+")"+wb.getRazon();
                cbe = new ComboEspecial(wb.getIdordenservicio(), descripcion);
                listComboEspecial.add(cbe);
            }
            /*QUITAR DUPLICADOS*/
            Set<ComboEspecial> hs = new TreeSet<ComboEspecial>();
            hs.addAll(listComboEspecial);
            listComboEspecial.clear();
            listComboEspecial.addAll(hs);
        }
    }
    public void cargarComboEspecialDetalle(){
        if(listDet_tareoweb != null){
            if(selectComboEspecial!=null){
                ComboEspecial cbe;
                setListComboEspecialDetalle(new ArrayList<>());
                String descripcion;
                for(Det_tareoweb wb : listDet_tareoweb){
                    if(selectComboEspecial.getId().trim().equalsIgnoreCase(wb.getIdordenservicio())){
                        descripcion = wb.getServicio();
                        cbe = new ComboEspecial(wb.getIdreferencia()+","+wb.getItemreferencia()+","+wb.getIdruta_ec()+","+wb.getHora_rc(), descripcion);
                        getListComboEspecialDetalle().add(cbe);
                    }
                }
                /*QUITAR DUPLICADOS*/
                Set<ComboEspecial> hs = new TreeSet<ComboEspecial>();
                hs.addAll(getListComboEspecialDetalle());
                getListComboEspecialDetalle().clear();
                getListComboEspecialDetalle().addAll(hs);
                RequestContext.getCurrentInstance().update("datos:dlgAddItemTareo:");
            }
        }
    }
    public void postProcessXLS(Object document) {
        String nameSheet = "FIJO("+WebUtil.fechaDMY(getDatoEdicion().getFecha(),6)+")" ;
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
    public String formatHeader(String header){
        if(header != null){
            switch(header){
                case "Doc."     :header="DOC";break;
                case "Serie"    :header="SERIE";break;
                case "Número"   :header="NÚMERO";break;
                case "Cliente"  :header="CLIENTE";break;
                case "Cargo"    :header="TIPO DE SERVICIO";break;
                case "Personal" :header="PERSONAL PSS ASIGNADO";break;
            }
        }
        return header;
    }
    public String return_encrypt_programacion(Det_tareoweb obj) throws ClassNotFoundException, ParseException{
        String encrypt = null;
        List<Object[]> lstTareo = obj.getTareo();
        listProgramacion = new ArrayList<>();
        Programacion op ;
        for(Object[] objs : lstTareo){
            op = new Programacion();
            op.setHeader(objs[0]==null?"":objs[0].toString());
            op.setValor(objs[1]==null?"":objs[1].toString());
            op.setItem(objs[4]==null?"":objs[4].toString());
            op.setEsfecha(Boolean.valueOf(objs[3].toString())?1.0f:0.0f);
            listProgramacion.add(op);
        }
        if(!listProgramacion.isEmpty()){
            encrypt = WebUtil.objectXml("com.nisira.core.entity.Programacion", listProgramacion);
        }
        return encrypt;
    }
    public void getFillTareoweb(){
        try{
            if(getLadd()==1){/*NUEVO*/
                getDatoEdicion().setIdtipoasistencia("ASN");
//                listDet_tareoweb = tareoWebDao.listarPorEmpresaWeb_new_provincial(user.getIDEMPRESA(), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5),getDatoEdicion().getIdresponsable(),user.getIDUSUARIO());
//                listDet_tareoweb_original = new ArrayList<>();
//                listDet_tareoweb_original.addAll(listDet_tareoweb);
//                generarCalendario();
            }else if(getLadd()==2){/*EDITAR*/
                listDet_tareoweb = tareoWebDao.listarPorEmpresaWeb_update_provincial(getDatoEdicion().getIdempresa(),getDatoEdicion().getIdcabtareoweb(),WebUtil.fechaDMY(getDatoEdicion().getFecha(),5), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5),getDatoEdicion().getIdresponsable(),user.getIDUSUARIO());
                cargarPersonalVehiculo();
                generarEstructuraBase();
            }
        }catch(Exception ex){
            this.mensaje=ex.getMessage();
            WebUtil.error(mensaje);
            System.out.println(mensaje);
        }
//        RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
        RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
    }
    public void cargarPersonalVehiculo(){
        try{
            if(!listDet_tareoweb.isEmpty()){
                Det_tareoweb temp;
                Clieprov c;
                Consumidor co;
                for(int i=0;i<listDet_tareoweb.size();i++){
                    temp = listDet_tareoweb.get(i);
                    if(temp.getIdpersonal()!=null){
                        c = clieprovDao.getEmpresa_Idclieprov(user.getIDEMPRESA(), temp.getIdpersonal());
                        temp.setSelectPersonal(c);
                    }
                    if(temp.getIdvehiculo()!=null){
                        co = consumidorDao.getEmpresa_Idconsumidor(user.getIDEMPRESA(), temp.getIdvehiculo());
                        temp.setSelectConsumidor(co);
                    }
                    listDet_tareoweb.set(i, temp);
                }
            }
        } catch (NisiraORMException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void cargarClieprovPersonal(){
        try {
            listPersonal = (new ClieprovDao()).listarPorEmpresaOperadorWeb(user.getIDEMPRESA());
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarConsumidor(){
        try {
            listConsumidor = (new ConsumidorDao()).listarPorEmpresaWeb(user.getIDEMPRESA());
        } catch (NisiraORMException ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Clieprov> completePersonal(String query) {
        cargarClieprovPersonal();
        List<Clieprov> filteredPersonal = new ArrayList<Clieprov>(); 
        for (int i = 0; i < listPersonal.size(); i++) {
            Clieprov skin = listPersonal.get(i);
            if(skin.getDni().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getRazonsocial().trim().toLowerCase().contains(query.trim().toLowerCase())){
                filteredPersonal.add(skin);
            }
        }
        return filteredPersonal;
    }
    public List<Consumidor> completeConsumidor(String query) {
        cargarConsumidor();
        List<Consumidor> filteredConsumidor = new ArrayList<Consumidor>(); 
        for (int i = 0; i < listConsumidor.size(); i++) {
            Consumidor skin = listConsumidor.get(i);
            if(skin.getIdconsumidor().trim().toLowerCase().contains(query.trim().toLowerCase()) || 
                    skin.getDescripcion().trim().toLowerCase().contains(query.trim().toLowerCase())) {
                filteredConsumidor.add(skin);
            }
        }
        return filteredConsumidor;
    }
    /************************* EVENT *********************/
    public void oncDocChange() throws Exception {
        listNumemisor = numemisorDao.listarPorDocWeb(user.getIDEMPRESA(), getDatoEdicion().getIddocumento());
        numero = null;
        if (!listNumemisor.isEmpty()) {
            int i = 0;
            for (Numemisor n : listNumemisor) {
                if (n.getIddocumento().equalsIgnoreCase(getDatoEdicion().getIddocumento())) {
                    i = Integer.parseInt(n.getNumero());
                }
            }
            numero = WebUtil.cerosIzquierda(i, 7);
        }

    }
    public void onCellEdit(CellEditEvent event) {
        try {
                Object newValue = event.getNewValue();
                Det_tareoweb entity =(Det_tareoweb)((DataTable)event.getComponent()).getRowData();
                int pos = entity.getItem();
//                int pos = listDet_tareoweb.indexOf(entity);
//                int pos = event.getRowIndex();
                if(event.getColumn().getHeaderText()!=null){
                    String colHead = event.getColumn().getHeaderText().trim();
                    switch(colHead){
                        case "Personal":
                        if(newValue==null){
                            entity.setIdpersonal("");
                            entity.setDni("");
                            entity.setPersonal("");  
                        }else{
                           Clieprov ob = (Clieprov)newValue;
                            entity.setIdpersonal(ob.getIdclieprov());
                            entity.setDni(ob.getDni());
                            entity.setPersonal(ob.getRazonsocial()); 
                        }
                        break;
                    case "Placa PSS":
                        if(newValue==null){
                            entity.setIdvehiculo("");
                            entity.setVehiculo("");
                        }else{
                            Consumidor oc = (Consumidor)newValue;
                            entity.setIdvehiculo(oc.getIdconsumidor());
                            entity.setVehiculo(oc.getDescripcion());
                        }
                        break;
                    case "Hora Llegada":
                        /*VALIDAR FORMATO DE TIME*/
                        if(WebUtil.validateTime(newValue.toString())){
                            entity.setFhora_llegada(WebUtil.convertStringTime(newValue.toString()));
                        }else{
                            entity.setShora_llegada("00:00");
                        }
                        break;
                    case "Hora Inicio":
                        /*VALIDAR FORMATO DE TIME*/
                        if(WebUtil.validateTime(newValue.toString())){
                            /*ASIGNARLE VALOR*/
                            entity.setFhora_inicio(WebUtil.convertStringTime(newValue.toString()));
                            entity.setShora_inicio(newValue.toString());
                            /*VALIDACIONES
                                No debe ser menor que hora de llegada
                            */
//                            if(WebUtil.compareToDate(entity.getFhora_llegada(),entity.getFhora_inicio())>0 &&
//                                    WebUtil.compareToDate(entity.getFhora_llegada(),entity.getFhora_inicio())!=-2){
//                                entity.setFhora_inicio(entity.getFhora_llegada());
//                                entity.setShora_inicio(entity.getShora_llegada());
//                            }
                        }else{
                            entity.setShora_inicio("00:00");  
//                            if(entity.getFhora_llegada() != null){
//                                entity.setShora_inicio(entity.getShora_llegada());
//                                entity.setFhora_inicio(entity.getFhora_llegada());
//                            }else{
//                              entity.setShora_inicio("00:00");  
//                            }
                        }
                        break;
                    case "Hora Fin":
                        /*VALIDAR FORMATO DE TIME*/
                        if(WebUtil.validateTime(newValue.toString())){
                            entity.setFhora_fin(WebUtil.convertStringTime(newValue.toString()));
                            entity.setShora_fin(newValue.toString());
                            if(!newValue.toString().trim().equals("00:00")){
//                                if(WebUtil.compareToDate(entity.getFhora_inicio(),entity.getFhora_fin())>0 &&
//                                    WebUtil.compareToDate(entity.getFhora_inicio(),entity.getFhora_fin())!=-2){
//                                    entity.setFhora_fin(entity.getFhora_inicio());
//                                    entity.setShora_fin(entity.getShora_inicio());
//    //                                entity.setFhora_fin(WebUtil.convertStringTime(newValue.toString()));
//                                    entity.setShora_liberacion(newValue.toString());
//                                    entity.setFhora_liberacion(entity.getFhora_fin()); 
//                                }else{
                                   entity.setFhora_fin(WebUtil.convertStringTime(newValue.toString()));
                                   entity.setShora_liberacion(newValue.toString());
                                   entity.setFhora_liberacion(entity.getFhora_fin()); 
//                                }
                            }
                        }else{
                            entity.setShora_fin("00:00");
                        }
                        break;
                    case "Hora Liberación":
                        /*VALIDAR FORMATO DE TIME*/
                        if(WebUtil.validateTime(newValue.toString())){
                            entity.setFhora_fin(WebUtil.convertStringTime(newValue.toString()));
                            entity.setShora_fin(newValue.toString());
                            if(entity.getFhora_fin()!=null){
                                entity.setFhora_liberacion(entity.getFhora_fin());
                                entity.setShora_liberacion(entity.getShora_fin());
                            }else{
                                if(WebUtil.compareToDate(entity.getFhora_inicio(),entity.getFhora_liberacion())>0 &&
                                    WebUtil.compareToDate(entity.getFhora_inicio(),entity.getFhora_liberacion())!=-2){
                                    entity.setFhora_liberacion(entity.getFhora_inicio());
                                    entity.setShora_liberacion(entity.getShora_inicio());
                                }
                            }
                        }else{
                            entity.setShora_liberacion("00:00");
                        }
                        break;
                    case "T.Asistencia":
                        Tipo_asistencia ob2 = buscarTipoAsistencia(newValue.toString());
                        entity.setCodasistencia(ob2.getIdtipoasistencia());
                        entity.setAsistencia(ob2.getNombre_corto());
                        entity.setExige_glosa(ob2.getExige_glosa()==1?true:false);
                        entity.setColor(ob2.getColor());
                        break;
                    }
                }
        //        Det_tareoweb entity = ((Det_tareoweb)event.getObject());
        //        int pos = listDet_tareoweb.indexOf(entity);
                /*VALIDACION DE TIME A DECIMAL*/
                if(entity.getFhora_req()!=null)
                    entity.setHora_req(WebUtil.convertTimeDecimal(entity.getFhora_req()));
                else
                    entity.setHora_req(0.0f);
                if(entity.getFhora_inicio()!=null)
                    entity.setHora_inicio_serv(WebUtil.convertTimeDecimal(entity.getFhora_inicio()));
                else
                    entity.setHora_inicio_serv(0.0f);
                if(entity.getFhora_fin()!=null)
                    entity.setHora_fin_serv(WebUtil.convertTimeDecimal(entity.getFhora_fin()));
                else
                    entity.setHora_fin_serv(0.0f);
                if(entity.getFhora_llegada()!=null)
                    entity.setHora_llegada(WebUtil.convertTimeDecimal(entity.getFhora_llegada()));
                else
                    entity.setHora_llegada(0.0f);
                if(entity.getFhora_liberacion()!=null)
                    entity.setHora_liberacion(WebUtil.convertTimeDecimal(entity.getFhora_liberacion()));
                else
                    entity.setHora_liberacion(0.0f);
                if(replazarCampo(entity,pos)){
                   grabar_local(); 
                } 
//                listDet_tareoweb.set(pos, entity);
//                grabar_local();                
            } catch (ParseException ex) {
                Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public boolean replazarCampo(Det_tareoweb ob,int item){
        boolean flag = false;
        for(int i=0;i<listDet_tareoweb.size();i++){
            Det_tareoweb dw = listDet_tareoweb.get(i);
            if(dw.getItem() == item){
                listDet_tareoweb.set(i, dw);
                flag = true;
                break;
            }
        }
        return flag;
    }
    public void onCellCancel(RowEditEvent event) {
        Det_tareoweb entity = ((Det_tareoweb)event.getObject());
//        RequestContext.getCurrentInstance().update("datos");
//        RequestContext.getCurrentInstance().update("datos:tabs");
//        tabView.setActiveIndex(indexTab);
    }
    public void onRefresh(){
        try {
            if(getDatoEdicion().getIdcabtareoweb()==null){
                if(selectClieprov == null){
                    WebUtil.MensajeAdvertencia("Seleccione Cliente");
                    RequestContext.getCurrentInstance().update("datos:growl");
                }else{
                    listDet_tareoweb = tareoWebDao.listarPorEmpresaWeb_new_provincial(user.getIDEMPRESA(), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5), WebUtil.fechaDMY(getDatoEdicion().getFecha(),5),getDatoEdicion().getIdresponsable(),user.getIDUSUARIO(),getDatoEdicion().getIdclieprov());
                    listDestructura_tareo_clieprov = destructura_tareo_clieprovDao.listarPorEmpresaWebXCotizacion(user.getIDEMPRESA(), getDatoEdicion().getIdclieprov(),getDatoEdicion().getIdruta());
                    generarEstructuraBase();
                }
            }
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        } catch (ClassNotFoundException | NisiraORMException | SQLException ex) {
            this.mensaje = ex.getMessage();
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(TareowebAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onCargaPersonalServicio() throws NisiraORMException {
        if(!this.iddocumento_local.isEmpty() && !this.serie_local.isEmpty() && !this.numero_local.isEmpty()){
            Det_tareoweb select = findPersonal_servicio(this.iddocumento_local,this.serie_local,this.numero_local);
            listPersonal_servicio = (new Personal_servicioDao()).listarPorOrdenServicioClienteWeb_Total(user.getIDEMPRESA(),
                    select.getIdordenservicio());
        }
        RequestContext.getCurrentInstance().update("datos:listPersonal_Servicio");
    }
    public void onRowSelectPersonal_Servicio(SelectEvent event) throws IOException {
        if(getSelectPersonal_servicio()!=null)
            setBtn_asignar_personal(false);
        /*CARGAR DATOS DPERSONAL_SERVICIO*/
        RequestContext.getCurrentInstance().update("datos:listPersonal_servicio");
    }
    public void verCntCargos_personal() {
        RequestContext.getCurrentInstance().openDialog("cntCargosPersonal", modalParamsOptions, null);
    }
    public void valorCargos_personal(SelectEvent event) {
        selectCargo_personal = (Cargos_personal) event.getObject();
    }
    /**************************METHOD***********************/
    public Tipo_asistencia buscarTipoAsistencia(String idtipoasistencia){
        Tipo_asistencia rsp=null;
        for(Tipo_asistencia ob : listTipo_asistencia){
            if(ob.getIdtipoasistencia().trim().equalsIgnoreCase(idtipoasistencia)){
                rsp = ob;
                break;
            }
        }
        return rsp;
    }
    public void verCntClieprovPersonalS() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalS", modalOptions, null);
    }
    public void verCntClieprovPersonalSupervisorOperador() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonalSupervisorOperador", modalOptions, null);
    }
    public void valorClieprovPersonalS(SelectEvent event) {
        Clieprov responsable = (Clieprov) event.getObject();
        getDatoEdicion().setIdresponsable(responsable.getIdclieprov());
        getDatoEdicion().setResponsable(responsable.getRazonsocial());
    }
    public void verCntClieprovPersonal() {
        RequestContext.getCurrentInstance().openDialog("cntClieprovPersonal", modalOptions, null);
    }
    public void valorClieprovPersonal(SelectEvent event) {
        selectClieprovPersonal = (Clieprov) event.getObject();
    }
    public Det_tareoweb findPersonal_servicio(String iddocumento,String serie,String numero){
        Det_tareoweb ob = null;
        for(Det_tareoweb obj : listDet_tareoweb){
            if(obj.getIddocumento().trim().equalsIgnoreCase(iddocumento.trim())
                    && obj.getSerie().trim().equalsIgnoreCase(serie.trim()) &&
                    obj.getNumero().trim().equalsIgnoreCase(numero.trim())){
                ob = obj;break;
            }
        }
        return ob;
    }
    public void openDialogAsignacionPersonal(){
        this.iddocumento_local="";
        this.serie_local="";
        this.numero_local="";
        this.btn_asignar_personal = true;
        listPersonal_servicio = new ArrayList<>();
        selectClieprovPersonal = new Clieprov();
        RequestContext.getCurrentInstance().update("datos:id_dlgasignar_personal");
        RequestContext.getCurrentInstance().execute("PF('dlgasignar_personal').show()");
    }
    public void openDialogAddItemTareo(){
        selectCargo_personal = new Cargos_personal();
        cargarComboEspecial();
        this.num_repetir = 1;
        if(!listComboEspecial.isEmpty()){
            selectComboEspecial=listComboEspecial.get(0);
            cargarComboEspecialDetalle();
        }
        RequestContext.getCurrentInstance().update("datos:dlgAddItemTareo");
        RequestContext.getCurrentInstance().execute("PF('dlgAddItemTareo').show()");
    }
    public void asignacionPersonal_servicio(){
        if(selectClieprovPersonal!=null){
            int pos = listPersonal_servicio.indexOf(selectPersonal_servicio);
            Personal_servicio temp = selectPersonal_servicio;
            temp.setIdpersonal(selectClieprovPersonal.getIdclieprov());
            temp.setDni(selectClieprovPersonal.getDni());
            temp.setNombres(selectClieprovPersonal.getRazonsocial());
            listPersonal_servicio.set(pos, temp);
            RequestContext.getCurrentInstance().update("datos:listPersonal_servicio");
        }else{
            this.mensaje="Seleccionar Personal";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void grabarAsignacionPersonal_servicio(){
        if(this.iddocumento_local==null){
            this.mensaje="Ingresar ID documento";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(this.serie_local==null){
            this.mensaje="Ingresar serie";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(this.numero_local==null){
            this.mensaje="Ingresar número";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(listPersonal_servicio.isEmpty()){
            this.mensaje="No existe Dato de Personal-Servicio";
            WebUtil.error(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            for(Personal_servicio per : listPersonal_servicio){
                actualizarPersonal_servicio_tareoweb(this.iddocumento_local,this.serie_local,this.numero_local,per);
            }
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
            RequestContext.getCurrentInstance().execute("PF('dlgasignar_personal').hide()");
        }
    }
    public void actualizarPersonal_servicio_tareoweb(String iddocumento,String serie,String numero,Personal_servicio ob){
        for(int i=0;i<listDet_tareoweb.size();i++){
            Det_tareoweb tw = listDet_tareoweb.get(i);
            if(tw.getIddocumento().trim().equalsIgnoreCase(iddocumento.trim()) &&
               tw.getSerie().trim().equalsIgnoreCase(serie.trim()) &&
               tw.getNumero().trim().equalsIgnoreCase(numero.trim()) &&
               tw.getItem_dordenservicio().trim().equalsIgnoreCase(ob.getItem()) &&
               tw.getItem2_personalservicio().trim().equalsIgnoreCase(ob.getItem2())
              ){
                tw.setIdpersonal(ob.getIdpersonal());
                tw.setDni(ob.getDni());
                tw.setPersonal(ob.getNombres());
                listDet_tareoweb.set(i, tw);
                break;
            }
        }
    }
    public void AddItemTareo(){
        List<Det_tareoweb> lst_in = new ArrayList<>();
        List<Det_tareoweb> lst_ex = new ArrayList<>();
        List<Det_tareoweb> lst_total = new ArrayList<>();
//        try {
            if(this.selectComboEspecial_idordenservicio==null){
                this.mensaje="Seleccionar Documento/Cliente";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(this.selectCargo_personal==null){
                this.mensaje="Seleccionar Cargo";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else if(this.num_repetir<=0){
                this.mensaje="Cantidad mayor a 0";
                WebUtil.error(mensaje);
                RequestContext.getCurrentInstance().update("datos:growl");
            }else{
                Det_tareoweb rept = null;
                selectComboEspecial = findComboEspecial(selectComboEspecial_idordenservicio);
                for(int i=0;i<listDet_tareoweb.size();i++){
                    Det_tareoweb tw = listDet_tareoweb.get(i);
                    if(selectComboEspecial.getId().trim().equalsIgnoreCase(tw.getIdordenservicio())){
                        lst_in.add(tw);
                    }else{
                        lst_ex.add(tw);
                    }
                }
                /***** TEMPORAL *****/
                if(!lst_in.isEmpty()){
                    Det_tareoweb xrept;
                    rept = lst_in.get(0);
                    for(int i=0;i<num_repetir;i++){
                        xrept = new Det_tareoweb();
                        xrept.setIdempresa(rept.getIdempresa());
                        xrept.setIdordenservicio(rept.getIdordenservicio());
                        xrept.setIddocumento(rept.getIddocumento());
                        xrept.setSerie(rept.getSerie());
                        xrept.setNumero(rept.getNumero());
                        xrept.setRuc(rept.getRuc());
                        xrept.setRazon(rept.getRazon());
    //                    xrept.setIdpersonal(rept.getIdpersonal());
    //                    xrept.setDni(rept.getDni());
    //                    xrept.setPersonal(rept.getPersonal());
                        xrept.setChecklist(rept.getChecklist());
                        xrept.setFhora_req(rept.getFhora_req());
                        xrept.setShora_req(rept.getShora_req());
                        xrept.setIdcargo(selectCargo_personal.getIdcargo());
                        xrept.setCargo(selectCargo_personal.getDescripcion());
                        xrept.setItem_dordenservicio(rept.getItem_dordenservicio());
                        xrept.setItem2_personalservicio(rept.getItem2_personalservicio());
                        xrept.setItem_dpersonalservicio(agregarItemDet_tareoweb(lst_in));
                        xrept.setHora_rc(rept.getHora_rc());
                        xrept.setFhora_fin(rept.getFhora_fin());
                        xrept.setHora_fin_serv(rept.getHora_fin_serv());
                        xrept.setShora_fin(rept.getShora_fin());
                        if(!listTipo_asistencia.isEmpty()){
                            xrept.setCodasistencia(listTipo_asistencia.get(0).getIdtipoasistencia());
                            xrept.setAsistencia(listTipo_asistencia.get(0).getNombre_corto());
                            xrept.setExige_glosa(listTipo_asistencia.get(0).getExige_glosa()==1?true:false);
                            xrept.setColor(listTipo_asistencia.get(0).getColor());
                        }
                        xrept.setIdservicio(rept.getIdservicio());
                        xrept.setServicio(rept.getServicio());
                        xrept.setShora_llegada("00:00");
                        xrept.setShora_inicio("00:00");
                        xrept.setShora_fin("00:00");
                        xrept.setShora_liberacion("00:00");
                        
                        xrept.setFecharegistro(rept.getFecharegistro());
                        xrept.setFechafinregistro(rept.getFechafinregistro());
                        
                        xrept.setIdreferencia(rept.getIdreferencia());
                        xrept.setItemreferencia(rept.getItemreferencia());
                        xrept.setIdruta_ec(rept.getIdruta_ec());
                        xrept.setHora_rc(rept.getHora_rc());
                        xrept.setFecha_osc(rept.getFecha_osc());
                        xrept.setCodoperaciones(rept.getCodoperaciones());
                        xrept.setRutaservicios(rept.getRutaservicios());
                        lst_in.add(xrept);
                    }
                }
                /* ****** RECONSTRUCCIÓN TOTAL ****** */
                if(rept!=null){
                    int id = rept.getItem();
                    int item_total = lst_in.size()+lst_ex.size();
                    Det_tareoweb obj = null;
                    if(id==1){
                        lst_total.addAll(lst_in);
                        lst_total.addAll(lst_ex);
                    }else{
                        int count_lst_in=lst_in.size();
                        int count_lst_ex=lst_ex.size();
                        int ini_lst_in=0;
                        int ini_lst_ex=0;
                        for(int i=0;i<item_total;i++){
                            if(id == i){
                                lst_total.addAll(lst_in);
                                i+=count_lst_in;
                            }else{
                                if(count_lst_ex>ini_lst_ex){
                                    obj = lst_ex.get(ini_lst_ex);
                                    lst_total.add(obj);
                                    ini_lst_ex++;  
                                }
                            }
                        }
                    }
                    /* ****** RECONSTRUCCIÓN ÍNDICES ****** */
                    Det_tareoweb tw = null;
                    for(int i=0;i<lst_total.size();i++){
                        tw = lst_total.get(i);
                        tw.setItem(i+1);
                        lst_total.set(i, tw);
                    }
                }     
            }
            if(!lst_total.isEmpty()){
                    listDet_tareoweb=lst_total;
//                    generarEstructuraBase();
                    RequestContext.getCurrentInstance().execute("PF('dlgAddItemTareo').hide()");

            }
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public ComboEspecial findComboEspecial(String idordenservicio){
        ComboEspecial tresp = null;
        for(ComboEspecial ob : listComboEspecial){
            if(ob.getId().trim().equalsIgnoreCase(idordenservicio)){
                tresp = ob;break;
            }
        }
        return tresp;
    }
    public void openDialogAsistencia(){
        if(selectDet_tareoweb!=null){
            this.glosa_local = selectDet_tareoweb.getGlosa();
            posSelect_det_tareoweb  = posicionListDet_tareoweb(selectDet_tareoweb.getItem());
            RequestContext.getCurrentInstance().update("datos:id_dlgDetalleAsistencia");
            RequestContext.getCurrentInstance().execute("PF('dlgDetalleAsistencia').show()");
        }
    }
    public void AddGlosaDet_tareoweb(){
        if(selectDet_tareoweb!=null){
            if(this.glosa_local!=null)
                selectDet_tareoweb.setGlosa(glosa_local);
            listDet_tareoweb.set(posSelect_det_tareoweb, selectDet_tareoweb);
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
            RequestContext.getCurrentInstance().execute("PF('dlgDetalleAsistencia').hide()");
        }
    }
    public String agregarItemDet_tareoweb(List<Det_tareoweb> lst){
        int dato = 1;
        int may=-999999999;
        for(Det_tareoweb obj:lst){
            if(!obj.getItem_dpersonalservicio().isEmpty()){
                dato = Integer.parseInt(obj.getItem_dpersonalservicio());
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
    public int posicionListDet_tareoweb(int item){
        int pos = -1;
        int count = 0;
        for(Det_tareoweb ob : listDet_tareoweb){
            if(ob.getItem()==item){
                pos = count;
                break;
            }else
                count++;
        }
        return pos;
    }
    public void deleteDettareo_web(){
        Det_tareoweb sl = selectDet_tareoweb;
        if(sl!=null){
            listDet_tareoweb.remove(sl);
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        }
    }
    /************POP UP************/
    public void verCntClieprov() {
        RequestContext.getCurrentInstance().openDialog("cntClieprov", modalOptions, null);
    }
    public void valorClieprov(SelectEvent event) {
        this.selectClieprov = (Clieprov) event.getObject();
        this.getDatoEdicion().setIdclieprov(selectClieprov.getIdclieprov());
        this.getDatoEdicion().setCliente(selectClieprov.getRazonsocial());
    }
    public void verCntRuta() {
        RequestContext.getCurrentInstance().openDialog("cntRutas", modalOptions, null);
    }
    public void valorRuta(SelectEvent event) {
        this.setSelectRutas((Rutas) event.getObject());
        this.getDatoEdicion().setIdruta(this.getSelectRutas().getIdruta());
        this.getDatoEdicion().setRuta(this.getSelectRutas().getDescripcion());
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
            setListaDatos(getCabtareowebDao().listarPorEmpresaWebFiltroFecha_provincial(user.getIDEMPRESA(),f_ini,f_fin,user.getIDUSUARIO()));
            RequestContext.getCurrentInstance().update("datos:tbl");
        } catch (Exception e) {
            mensaje = WebUtil.mensajeError();
            WebUtil.error(mensaje);
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        if(tipo == 2)
            lista_accion_filtro("wLst_Tareoweb_provincial");
        return "";
    }

    @Override
    public void buscarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIniciar() {
        btn_asignar_personal = true;
        activarBotones = true;
        num_repetir = 1;
        /* ARRAYLIST */
        listDet_tareoweb = new ArrayList<>();
        listPersonal = new ArrayList<>();
        listPersonal_servicio = new ArrayList<>();
        listDet_tareoweb = new ArrayList<>();
        /* DAO */
        tareoWebDao = new Det_tareowebDao();
        clieprovDao = new ClieprovDao();
        
        cabtareowebDao = new CabtareowebDao();
        det_tareowebDao = new Det_tareowebDao();
        /* ENTITY */
        tareoWeb = new Det_tareoweb();
        selectPersonal = new Clieprov();
        /********************  ******************/
        actualiza_ventana("wMnt_Tareoweb_provincial");
        return "";
    }

    @Override
    public void nuevo() {
        try {
            getIniciar();
            setDatoEdicion(new Cabtareoweb());
            getDatoEdicion().setIdempresa(user.getIDEMPRESA());
            getDatoEdicion().setFecha(new Date());
            fgeneracion = getDatoEdicion().getFecha();
            getDatoEdicion().setIdsucursal(Constantes.getIDSUCURSALGENERAL());
            getDatoEdicion().setPeriodo(periodoDisenio);
            getDatoEdicion().setMes(mesNombreDisenio);
            getDatoEdicion().setNumero(numero);
            getDatoEdicion().setIdemisor(lista_solution.get(5));
            getDatoEdicion().setIdusuario(user.getIDUSUARIO());
            getDatoEdicion().setUsuario(user.getNombres());
            getDatoEdicion().setFinicio(new Date());
            getDatoEdicion().setFfin(new Date());
            getDatoEdicion().setIdestado("PE");
            getDatoEdicion().setIdresponsable(user.getIDUSUARIO());
            Clieprov us = usuariodao.getUsuarioCliente(user.getIDUSUARIO());
            if(us!=null){
                getDatoEdicion().setIdresponsable(us.getIdclieprov());
                getDatoEdicion().setResponsable(us.getRazonsocial());
            }
            String emisor= emisorDao.getPorClavePrimariaWeb(user.getIDEMPRESA(), getDatoEdicion().getIdemisor()).getDescripcion();
            getDatoEdicion().setEmisor(emisor);
            String sucursal = sucursalesDao.getPorEmpresaSucursal(user.getIDEMPRESA(),Constantes.IDSUCURSALGENERAL).getDescripcion();
            getDatoEdicion().setSucursal(sucursal);
            if(!listAlmacenes.isEmpty())
                getDatoEdicion().setIdalmacen(listAlmacenes.get(0).getIdalmacen());
            RequestContext.getCurrentInstance().update("datos");
        } catch (NisiraORMException |SQLException ex) {
            setMensaje(ex.getMessage());
            WebUtil.MensajeError(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean esVistaValida() {
        if (getDatoEdicion().getIdresponsable() == null){
            WebUtil.MensajeAdvertencia("Seleccione Responsable");
            return false;
        }
        else if(getListDet_tareoweb().size() == 0) {
            WebUtil.MensajeAdvertencia("Ingrese Detalle Tareo");
            return false;
        }
        return true;
    }
    @Override
    public void grabar() {
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                groupProgramation();
                if(getDatoEdicion().getIdcabtareoweb()==null){
                    mensaje=getCabtareowebDao().grabar_provincial(1, getDatoEdicion(), 
                            getListDet_tareoweb());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15)
                            getDatoEdicion().setIdcabtareoweb(mensaje.trim());
                }
                else
                    mensaje=getCabtareowebDao().grabar_provincial(2, getDatoEdicion(),getListDet_tareoweb());
                setMensaje(WebUtil.exitoRegistrar("Tareo Web Fijo", mensaje));
                WebUtil.info(getMensaje());
                setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            setMensaje(ex.getMessage() + "\n" + ex.getLocalizedMessage());
            Logger.getLogger(OrdenservicioclienteAction.class.getName()).log(Level.SEVERE, null, ex);
            WebUtil.fatal(mensaje);
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }
    public void grabar_local(){
        try {
            if (esVistaValida()) {
                /*DATOS INICIALES*/
                groupProgramation();
                if(getDatoEdicion().getIdcabtareoweb()==null){
                    mensaje=getCabtareowebDao().grabar_provincial(1, getDatoEdicion(), 
                            getListDet_tareoweb());
                    if(mensaje!=null)
                        if(mensaje.trim().length()==15){
                            getDatoEdicion().setIdcabtareoweb(mensaje.trim());
                            setLadd(2);
                        }
                }else{
                    mensaje=getCabtareowebDao().grabar_provincial(2, getDatoEdicion(),getListDet_tareoweb());
                }
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
                mensaje=getCabtareowebDao().anular(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabtareoweb(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoAnular("Tareo Fijo ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                buscarFiltro(2);
            }
            if (getOpc_anular_eliminar().equalsIgnoreCase("ELIMINAR")) {
                mensaje=getCabtareowebDao().eliminar(getDatoEdicion().getIdempresa(), getDatoEdicion().getIdcabtareoweb(), user.getIDUSUARIO());
                setMensaje(WebUtil.exitoEliminar("Tareo Fijo ", mensaje));
                WebUtil.info(getMensaje());
                RequestContext.getCurrentInstance().update("datos:growl");
                buscarFiltro(2);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje=ex.getMessage();
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
        }
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
        try {
            if(getDatoEdicion().getIdcabtareoweb()==null){
                this.mensaje = "Documento no registrado";
                WebUtil.MensajeAdvertencia(this.mensaje );
            }
//            else if(getDatoEdicion().getIdestado().equalsIgnoreCase("AP")){
//                this.mensaje = "Documento se encuentra aprobado";
//                WebUtil.MensajeAdvertencia(this.mensaje );
//            }
            else if(verificar_aprobacion()){
                mensaje=getCabtareowebDao().aprobarTareo_fijo(getDatoEdicion(),user.getIDUSUARIO());
                if(mensaje!=null)
                    if(mensaje.trim().length()==15)
                        getDatoEdicion().setIdcabtareoweb(mensaje.trim());
                WebUtil.info("Se aprobó el documento :"+getDatoEdicion().getIddocumento()+"-"+
                        getDatoEdicion().getSerie()+"-"+getDatoEdicion().getNumero()+" ("+getMensaje()+")");
                setLvalidate(true);
                RequestContext.getCurrentInstance().update("datos");
            }
        } catch (Exception ex) {
            Logger.getLogger(Tareoweb_provincialAction.class.getName()).log(Level.SEVERE, null, ex);
            setMensaje(ex.getMessage());
            WebUtil.error(getMensaje());
            RequestContext.getCurrentInstance().update("datos:growl");
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
    public boolean verificar_aprobacion() throws IOException{
        boolean flag = true;
        String validacion ="";
        String httpcontenido="";
        for(int i=0;i<listDet_tareoweb.size();i++){
            Det_tareoweb obj = listDet_tareoweb.get(i);
            validacion ="";
            if(obj.getIdpersonal()==null){
                validacion+="\n\t<Personal> no asignado";
            }else if(obj.getIdpersonal().trim().equals("")){
                validacion+="\n\t<Personal> no asignado";  
            }
            if(obj.getHora_inicio_serv()==0.0f)
                validacion+="\n\tHora Inicio <00:00> no asignado";
            if(obj.getHora_fin_serv()==0.0f)
                validacion+="\n\tHora Fin <00:00> no asignado";
            if(obj.getFecharegistro()==null)
                validacion+="\n\tFecha Inicio no asignada";
            if(obj.getFechafinregistro()==null)
                validacion+="\n\tFecha Fin no asignada";
            if(!validacion.equals("")){
                flag = false;
                this.mensaje="Servicio N°:"+obj.getItem()+" - "+obj.getIddocumento()+"-"+obj.getSerie()+"-"+obj.getNumero()+" ("+obj.getFecha_osc()+")"+" "+obj.getRazon()+"-"+obj.getRuc()+validacion;
                httpcontenido+="\n"+this.mensaje;
            }
        }
        setLog_consola(null);
        if(!httpcontenido.trim().equals("")){
            httpcontenido="*****************DETALLE OBSERVADO*******************"+httpcontenido;
            mostrarLog_txt(httpcontenido);
        }
        return flag;
    }
    public String fechaDMY(Date fecha){
        if(fecha!=null)
            return WebUtil.fechaDMY(fecha, 7);
        else
            return "";
    }
    public void generarCampos(){
        if(listDestructura_tareo_clieprov.isEmpty()){
            WebUtil.MensajeError("No existe estructura de tareo");
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            Object [] pack;
            for(int i=0;i<listDet_tareoweb.size();i++){
                listDet_tareoweb.get(i).setTareo(new ArrayList<>());
                for(Destructura_tareo_clieprov dtc : listDestructura_tareo_clieprov){
                    pack = new Object[4];
                    pack[0] = dtc.getDescripcion();/*Header*/
                    pack[1] = "";/*datos*/
                    pack[2] = dtc.getHora();
                    pack[3] = dtc.getEsfecha()==1.0?false:true;
                    pack[4] = dtc.getItem();
                    listDet_tareoweb.get(i).getTareo().add(pack);
                }
            }
        }
    }
    public void groupProgramation(){
        try {
            if(!getListDet_tareoweb().isEmpty()){
                /*ACTUALIZAR HORAS*/
                int pos =0;
                for(Det_tareoweb obj :getListDet_tareoweb()){
                    obj.setEncrypt_programacion(return_encrypt_programacion(obj));
                    getListDet_tareoweb().set(pos, obj);
                    pos++;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generarEstructuraBase() throws ClassNotFoundException{
        if(getDatoEdicion().getIdclieprov()==null){
            this.mensaje = "Ingresar Cliente";
            WebUtil.MensajeAdvertencia(this.mensaje );
            RequestContext.getCurrentInstance().update("datos:growl");
        }else if(listDestructura_tareo_clieprov.isEmpty()){
            this.mensaje = "No existe estructura de tareo";
            WebUtil.MensajeAdvertencia(this.mensaje );
            RequestContext.getCurrentInstance().update("datos:growl");
        }else{
            /*******************************************************************************************************/
            /*REEGENERAR DE BASE DE DATOS*/
            List<Programacion> temp = null;
            Object[] obj1=null;
            for(int x = 0;x<listDet_tareoweb.size();x++){
                Det_tareoweb xc = listDet_tareoweb.get(x);
                xc.setTareo(new ArrayList<>());
                if(xc.getEncrypt_programacion()!=null){
                    if(!xc.getEncrypt_programacion().isEmpty()){
                        temp = (List<Programacion>)WebUtil.stringObject("com.nisira.core.entity.Programacion", xc.getEncrypt_programacion());
                        if(!temp.isEmpty()){
                            for(Programacion pr : temp){
                                obj1 = new Object[4];
                                obj1[0] = pr.getHeader();/*Header*/
                                obj1[1] = pr.getValor();/*datos*/
                                obj1[2] = 0.0;
                                obj1[3] = pr.getEsfecha()==1.0?false:true;
                                obj1[4] = pr.getItem();
                                xc.getTareo().add(obj1);
                            }
                        }else{
                            for(Destructura_tareo_clieprov dtc : listDestructura_tareo_clieprov){
                                obj1 = new Object[4];
                                obj1[0] = dtc.getDescripcion();/*Header*/
                                obj1[1] = "";/*datos*/
                                obj1[2] = dtc.getHora();
                                obj1[3] = dtc.getEsfecha()==1.0?false:true;
                                obj1[4] = dtc.getItem();
                                xc.getTareo().add(obj1);
                            }
                        }
                    }   
                }else{
                    for(Destructura_tareo_clieprov dtc : listDestructura_tareo_clieprov){
                        obj1 = new Object[4];
                        obj1[0] = dtc.getDescripcion();/*Header*/
                        obj1[1] = "";/*datos*/
                        obj1[2] = dtc.getHora();
                        obj1[3] = dtc.getEsfecha()==1.0?false:true;
                        obj1[4] = dtc.getItem();
                        xc.getTareo().add(obj1);
                    }
                }   
                listDet_tareoweb.set(x, xc);
            }
//            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
        }
    }
    /**
     * @return the user
     */
    public UsuarioBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    /**
     * @return the listDet_tareoweb
     */
    public List<Det_tareoweb> getListDet_tareoweb() {
        return listDet_tareoweb;
    }

    /**
     * @param listDet_tareoweb the listDet_tareoweb to set
     */
    public void setListDet_tareoweb(List<Det_tareoweb> listDet_tareoweb) {
        this.listDet_tareoweb = listDet_tareoweb;
    }

    /**
     * @return the tareoWebDao
     */
    public Det_tareowebDao getDet_tareowebDao() {
        return tareoWebDao;
    }

    /**
     * @param tareoWebDao the tareoWebDao to set
     */
    public void setDet_tareowebDao(Det_tareowebDao tareoWebDao) {
        this.tareoWebDao = tareoWebDao;
    }

    /**
     * @return the tareoWeb
     */
    public Det_tareoweb getDet_tareoweb() {
        return tareoWeb;
    }

    /**
     * @param tareoWeb the tareoWeb to set
     */
    public void setDet_tareoweb(Det_tareoweb tareoWeb) {
        this.tareoWeb = tareoWeb;
    }

    /**
     * @return the selectDet_tareoweb
     */
    public Det_tareoweb getSelectDet_tareoweb() {
        return selectDet_tareoweb;
    }

    /**
     * @param selectDet_tareoweb the selectDet_tareoweb to set
     */
    public void setSelectDet_tareoweb(Det_tareoweb selectDet_tareoweb) {
        this.selectDet_tareoweb = selectDet_tareoweb;
    }

    /**
     * @return the activarBotones
     */
    public boolean isActivarBotones() {
        return activarBotones;
    }

    /**
     * @param activarBotones the activarBotones to set
     */
    public void setActivarBotones(boolean activarBotones) {
        this.activarBotones = activarBotones;
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
     * @return the listPersonal
     */
    public List<Clieprov> getListPersonal() {
        return listPersonal;
    }

    /**
     * @param listPersonal the listPersonal to set
     */
    public void setListPersonal(List<Clieprov> listPersonal) {
        this.listPersonal = listPersonal;
    }

    /**
     * @return the selectPersonal
     */
    public Clieprov getSelectPersonal() {
        return selectPersonal;
    }

    /**
     * @param selectPersonal the selectPersonal to set
     */
    public void setSelectPersonal(Clieprov selectPersonal) {
        this.selectPersonal = selectPersonal;
    }

    /**
     * @return the serie_local
     */
    public String getSerie_local() {
        return serie_local;
    }

    /**
     * @param serie_local the serie_local to set
     */
    public void setSerie_local(String serie_local) {
        this.serie_local = serie_local;
    }

    /**
     * @return the numero_local
     */
    public String getNumero_local() {
        return numero_local;
    }

    /**
     * @param numero_local the numero_local to set
     */
    public void setNumero_local(String numero_local) {
        this.numero_local = numero_local;
    }

    /**
     * @return the iddocumento_local
     */
    public String getIddocumento_local() {
        return iddocumento_local;
    }

    /**
     * @param iddocumento_local the iddocumento_local to set
     */
    public void setIddocumento_local(String iddocumento_local) {
        this.iddocumento_local = iddocumento_local;
    }

    /**
     * @return the btn_asignar_personal
     */
    public boolean isBtn_asignar_personal() {
        return btn_asignar_personal;
    }

    /**
     * @param btn_asignar_personal the btn_asignar_personal to set
     */
    public void setBtn_asignar_personal(boolean btn_asignar_personal) {
        this.btn_asignar_personal = btn_asignar_personal;
    }

    /**
     * @return the selectPersonal_servicio
     */
    public Personal_servicio getSelectPersonal_servicio() {
        return selectPersonal_servicio;
    }

    /**
     * @param selectPersonal_servicio the selectPersonal_servicio to set
     */
    public void setSelectPersonal_servicio(Personal_servicio selectPersonal_servicio) {
        this.selectPersonal_servicio = selectPersonal_servicio;
    }

    /**
     * @return the listPersonal_servicio
     */
    public List<Personal_servicio> getListPersonal_servicio() {
        return listPersonal_servicio;
    }

    /**
     * @param listPersonal_servicio the listPersonal_servicio to set
     */
    public void setListPersonal_servicio(List<Personal_servicio> listPersonal_servicio) {
        this.listPersonal_servicio = listPersonal_servicio;
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
     * @return the dni_local
     */
    public String getDni_local() {
        return dni_local;
    }

    /**
     * @param dni_local the dni_local to set
     */
    public void setDni_local(String dni_local) {
        this.dni_local = dni_local;
    }

    /**
     * @return the num_repetir
     */
    public int getNum_repetir() {
        return num_repetir;
    }

    /**
     * @param num_repetir the num_repetir to set
     */
    public void setNum_repetir(int num_repetir) {
        this.num_repetir = num_repetir;
    }

    /**
     * @return the iddocumento_add
     */
    public String getIddocumento_add() {
        return iddocumento_add;
    }

    /**
     * @param iddocumento_add the iddocumento_add to set
     */
    public void setIddocumento_add(String iddocumento_add) {
        this.iddocumento_add = iddocumento_add;
    }

    /**
     * @return the serie_add
     */
    public String getSerie_add() {
        return serie_add;
    }

    /**
     * @param serie_add the serie_add to set
     */
    public void setSerie_add(String serie_add) {
        this.serie_add = serie_add;
    }

    /**
     * @return the numero_add
     */
    public String getNumero_add() {
        return numero_add;
    }

    /**
     * @param numero_add the numero_add to set
     */
    public void setNumero_add(String numero_add) {
        this.numero_add = numero_add;
    }

    /**
     * @return the cabtareowebDao
     */
    public CabtareowebDao getCabtareowebDao() {
        return cabtareowebDao;
    }

    /**
     * @param cabtareowebDao the cabtareowebDao to set
     */
    public void setCabtareowebDao(CabtareowebDao cabtareowebDao) {
        this.cabtareowebDao = cabtareowebDao;
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
     * @return the listAlmacen
     */
    public List<Almacenes> getListAlmacenes() {
        return listAlmacenes;
    }

    /**
     * @param listAlmacen the listAlmacen to set
     */
    public void setListAlmacenes(List<Almacenes> listAlmacenes) {
        this.listAlmacenes = listAlmacenes;
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
     * @return the fgeneracion
     */
    public Date getFgeneracion() {
        return fgeneracion;
    }

    /**
     * @param fgeneracion the fgeneracion to set
     */
    public void setFgeneracion(Date fgeneracion) {
        this.fgeneracion = fgeneracion;
    }

    /**
     * @return the consumidorDao
     */
    public ConsumidorDao getConsumidorDao() {
        return consumidorDao;
    }

    /**
     * @param consumidorDao the consumidorDao to set
     */
    public void setConsumidorDao(ConsumidorDao consumidorDao) {
        this.consumidorDao = consumidorDao;
    }

    /**
     * @return the tareoWebDao
     */
    public Det_tareowebDao getTareoWebDao() {
        return tareoWebDao;
    }

    /**
     * @param tareoWebDao the tareoWebDao to set
     */
    public void setTareoWebDao(Det_tareowebDao tareoWebDao) {
        this.tareoWebDao = tareoWebDao;
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
     * @return the listTurno_trabajo
     */
    public List<Turno_trabajo> getListTurno_trabajo() {
        return listTurno_trabajo;
    }

    /**
     * @param listTurno_trabajo the listTurno_trabajo to set
     */
    public void setListTurno_trabajo(List<Turno_trabajo> listTurno_trabajo) {
        this.listTurno_trabajo = listTurno_trabajo;
    }

    /**
     * @return the turno_trabajoDao
     */
    public Turno_trabajoDao getTurno_trabajoDao() {
        return turno_trabajoDao;
    }

    /**
     * @param turno_trabajoDao the turno_trabajoDao to set
     */
    public void setTurno_trabajoDao(Turno_trabajoDao turno_trabajoDao) {
        this.turno_trabajoDao = turno_trabajoDao;
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
     * @return the lstDias
     */
    public List<String> getLstDias() {
        return lstDias;
    }

    /**
     * @param lstDias the lstDias to set
     */
    public void setLstDias(List<String> lstDias) {
        this.lstDias = lstDias;
    }

    /**
     * @return the listTipo_asistencia
     */
    public List<Tipo_asistencia> getListTipo_asistencia() {
        return listTipo_asistencia;
    }

    /**
     * @param listTipo_asistencia the listTipo_asistencia to set
     */
    public void setListTipo_asistencia(List<Tipo_asistencia> listTipo_asistencia) {
        this.listTipo_asistencia = listTipo_asistencia;
    }

    /**
     * @return the listComboEspecial
     */
    public List<ComboEspecial> getListComboEspecial() {
        return listComboEspecial;
    }

    /**
     * @param listComboEspecial the listComboEspecial to set
     */
    public void setListComboEspecial(List<ComboEspecial> listComboEspecial) {
        this.listComboEspecial = listComboEspecial;
    }

    /**
     * @return the selectComboEspecial_idordenservicio
     */
    public String getSelectComboEspecial_idordenservicio() {
        return selectComboEspecial_idordenservicio;
    }

    /**
     * @param selectComboEspecial_idordenservicio the selectComboEspecial_idordenservicio to set
     */
    public void setSelectComboEspecial_idordenservicio(String selectComboEspecial_idordenservicio) {
        this.selectComboEspecial_idordenservicio = selectComboEspecial_idordenservicio;
    }

    /**
     * @return the tipo_asistenciaDao
     */
    public Tipo_asistenciaDao getTipo_asistenciaDao() {
        return tipo_asistenciaDao;
    }

    /**
     * @param tipo_asistenciaDao the tipo_asistenciaDao to set
     */
    public void setTipo_asistenciaDao(Tipo_asistenciaDao tipo_asistenciaDao) {
        this.tipo_asistenciaDao = tipo_asistenciaDao;
    }

    /**
     * @return the selectComboEspecial
     */
    public ComboEspecial getSelectComboEspecial() {
        return selectComboEspecial;
    }

    /**
     * @param selectComboEspecial the selectComboEspecial to set
     */
    public void setSelectComboEspecial(ComboEspecial selectComboEspecial) {
        this.selectComboEspecial = selectComboEspecial;
    }

    /**
     * @return the selectCargo_personal
     */
    public Cargos_personal getSelectCargo_personal() {
        return selectCargo_personal;
    }

    /**
     * @param selectCargo_personal the selectCargo_personal to set
     */
    public void setSelectCargo_personal(Cargos_personal selectCargo_personal) {
        this.selectCargo_personal = selectCargo_personal;
    }

    /**
     * @return the glosa_local
     */
    public String getGlosa_local() {
        return glosa_local;
    }

    /**
     * @param glosa_local the glosa_local to set
     */
    public void setGlosa_local(String glosa_local) {
        this.glosa_local = glosa_local;
    }

    /**
     * @return the posSelect_det_tareoweb
     */
    public int getPosSelect_det_tareoweb() {
        return posSelect_det_tareoweb;
    }

    /**
     * @param posSelect_det_tareoweb the posSelect_det_tareoweb to set
     */
    public void setPosSelect_det_tareoweb(int posSelect_det_tareoweb) {
        this.posSelect_det_tareoweb = posSelect_det_tareoweb;
    }

    /**
     * @return the selectComboEspecialDetalle_idordenservicio
     */
    public String getSelectComboEspecialDetalle_idordenservicio() {
        return selectComboEspecialDetalle_idordenservicio;
    }

    /**
     * @param selectComboEspecialDetalle_idordenservicio the selectComboEspecialDetalle_idordenservicio to set
     */
    public void setSelectComboEspecialDetalle_idordenservicio(String selectComboEspecialDetalle_idordenservicio) {
        this.selectComboEspecialDetalle_idordenservicio = selectComboEspecialDetalle_idordenservicio;
    }

    /**
     * @return the listComboEspecialDetalle
     */
    public List<ComboEspecial> getListComboEspecialDetalle() {
        return listComboEspecialDetalle;
    }

    /**
     * @param listComboEspecialDetalle the listComboEspecialDetalle to set
     */
    public void setListComboEspecialDetalle(List<ComboEspecial> listComboEspecialDetalle) {
        this.listComboEspecialDetalle = listComboEspecialDetalle;
    }

    /**
     * @return the listDet_tareoweb_original
     */
    public List<Det_tareoweb> getListDet_tareoweb_original() {
        return listDet_tareoweb_original;
    }

    /**
     * @param listDet_tareoweb_original the listDet_tareoweb_original to set
     */
    public void setListDet_tareoweb_original(List<Det_tareoweb> listDet_tareoweb_original) {
        this.listDet_tareoweb_original = listDet_tareoweb_original;
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
     * @return the listDestructura_tareo_clieprov
     */
    public List<Destructura_tareo_clieprov> getListDestructura_tareo_clieprov() {
        return listDestructura_tareo_clieprov;
    }

    /**
     * @param listDestructura_tareo_clieprov the listDestructura_tareo_clieprov to set
     */
    public void setListDestructura_tareo_clieprov(List<Destructura_tareo_clieprov> listDestructura_tareo_clieprov) {
        this.listDestructura_tareo_clieprov = listDestructura_tareo_clieprov;
    }

    /**
     * @return the destructura_tareo_clieprovDao
     */
    public Destructura_tareo_clieprovDao getDestructura_tareo_clieprovDao() {
        return destructura_tareo_clieprovDao;
    }

    /**
     * @param destructura_tareo_clieprovDao the destructura_tareo_clieprovDao to set
     */
    public void setDestructura_tareo_clieprovDao(Destructura_tareo_clieprovDao destructura_tareo_clieprovDao) {
        this.destructura_tareo_clieprovDao = destructura_tareo_clieprovDao;
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
    
}

//    public void generarCalendario(){
//        if(getDatoEdicion().getFinicio()==null){
//            this.mensaje = "Ingresar Fecha Inicio";
//            WebUtil.MensajeAdvertencia(this.mensaje );
//            RequestContext.getCurrentInstance().update("datos:growl");
//        }else if(getDatoEdicion().getFfin()==null){
//            this.mensaje = "Ingresar Fecha Fin";
//            WebUtil.MensajeAdvertencia(this.mensaje );
//            RequestContext.getCurrentInstance().update("datos:growl");
//        }else{
//            int i = 1;
//            String nameDay ="";
//            String header ="";
//            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY");
//            SimpleDateFormat ft_day_moth = new SimpleDateFormat("dd/MM");
//            Calendar inicio = WebUtil.convertDateCalendar(getDatoEdicion().getFinicio());
//            Calendar fin = WebUtil.convertDateCalendar(getDatoEdicion().getFfin());
//            dataTableColumns = new ArrayList<>();
//            while (inicio.before(fin) || inicio.equals(fin)) {
//                //nameDay = WebUtil.convertDayOfSpanish(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(WebUtil.convertCalendarDate(inicio)).trim());
//                //header = nameDay + " " + ft_day_moth.format(WebUtil.convertCalendarDate(inicio));
//                header = ft_day_moth.format(WebUtil.convertCalendarDate(inicio))+"\nHora Inicio";
//                dataTableColumns.add(new DataTableColumn(header,String.valueOf(i),WebUtil.convertCalendarDate(inicio),"i"));
//                
//                header = ft_day_moth.format(WebUtil.convertCalendarDate(inicio))+"\nHora Fin";
//                dataTableColumns.add(new DataTableColumn(header,String.valueOf(i),WebUtil.convertCalendarDate(inicio),"f"));
//                
//                inicio.add(Calendar.DATE, 1);
//            }
//            int row = listDet_tareoweb.size();
//            Object [] ob_dias;
//            for(int x = 0; x < row ; x++){
//                Det_tareoweb det = listDet_tareoweb.get(x);
//                det.setTareo(new ArrayList<>());
//                for(int y=0;y<dataTableColumns.size(); y++){
//                    DataTableColumn col = dataTableColumns.get(y);
//                    ob_dias = new Object[7];
//                    ob_dias[0] = col.getAdicional2().trim().equals("i")?(det.getShora_req()==null?"00:00":det.getShora_req()):(det.getShora_fin()==null?"00:00":det.getShora_fin());// "00:00";
//                    ob_dias[1] = col.getAdicional2();// "i"/"f";
//                    ob_dias[2] = det.getItem();
//                    ob_dias[3] = WebUtil.fechaDMY(col.getAdicional1(),2);
//                    ob_dias[4] = col.getHeader(); //ob_dias[3]+"\nHora Inicio";
//                    ob_dias[5] = col.getAdicional1();
//                    ob_dias[6] = 0.0f;
//                    det.getTareo().add(ob_dias);
//                }
//                listDet_tareoweb.set(x, det);
//            }
////            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
//            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
//        }
//    }
//    public void groupProgramation(){
//        try {
//            if(!getListDet_tareoweb().isEmpty()){
//                /*ACTUALIZAR HORAS*/
//                int pos =0;
//                for(Det_tareoweb obj :getListDet_tareoweb()){
//                    obj.setEncrypt_programacion(return_encrypt_programacion(obj));
//                    getListDet_tareoweb().set(pos, obj);
//                    pos++;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(Tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void generarEstructuraBase() throws ClassNotFoundException{
//        if(getDatoEdicion().getFinicio()==null){
//            this.mensaje = "Ingresar Fecha Inicio";
//            WebUtil.MensajeAdvertencia(this.mensaje );
//            RequestContext.getCurrentInstance().update("datos:growl");
//        }else if(getDatoEdicion().getFfin()==null){
//            this.mensaje = "Ingresar Fecha Fin";
//            WebUtil.MensajeAdvertencia(this.mensaje );
//            RequestContext.getCurrentInstance().update("datos:growl");
//        }else{
//            int i = 1;
//            String nameDay ="";
//            String header ="";
//            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-YYYY");
//            SimpleDateFormat ft_day_moth = new SimpleDateFormat("dd/MM");
//            Calendar inicio = WebUtil.convertDateCalendar(getDatoEdicion().getFinicio());
//            Calendar fin = WebUtil.convertDateCalendar(getDatoEdicion().getFfin());
//            dataTableColumns = new ArrayList<>();
//            while (inicio.before(fin) || inicio.equals(fin)) {
//                header = ft_day_moth.format(WebUtil.convertCalendarDate(inicio))+"\nHora Inicio";
//                dataTableColumns.add(new DataTableColumn(header,String.valueOf(i),WebUtil.convertCalendarDate(inicio),"i"));
//                
//                header = ft_day_moth.format(WebUtil.convertCalendarDate(inicio))+"\nHora Fin";
//                dataTableColumns.add(new DataTableColumn(header,String.valueOf(i),WebUtil.convertCalendarDate(inicio),"f"));
//                
//                inicio.add(Calendar.DATE, 1);
//            }
//            /*******************************************************************************************************/
//            /*REEGENERAR DE BASE DE DATOS*/
//            List<Programacion> temp = null;
//            Object [] ob_dias;
//            String fecha1,fecha2;
//            DataTableColumn dc=null;
//            Programacion pr=null;
//            boolean flag =false;
//            for(int x = 0;x<listDet_tareoweb.size();x++){
//                Det_tareoweb xc = listDet_tareoweb.get(x);
//                xc.setTareo(new ArrayList<>());
//                if(xc.getEncrypt_programacion()!=null){
//                    if(!xc.getEncrypt_programacion().isEmpty()){
//                        temp = (List<Programacion>)WebUtil.stringObject("com.nisira.core.entity.Programacion", xc.getEncrypt_programacion());
//                        for(int y=0;y<dataTableColumns.size();y++){
//                            dc = dataTableColumns.get(y);
//                            flag =false;
//                            /*ALGORITMO DE BUSQUEDA*/
//                            for(int xp =0 ;xp < temp.size(); xp++){
//                                pr = temp.get(xp);
//                                fecha1 = WebUtil.fechaDMY(dc.getAdicional1(), 5);
//                                fecha2 = WebUtil.fechaDMY(pr.getFecha(), 5);
//                                if(fecha1.equalsIgnoreCase(fecha2)){
//                                    flag=true;
//                                    break;
//                                }
//                            }
//                            /*LLENADO DE DATOS*/
//                            if(flag){
//                                ob_dias = new Object[7];
//                                ob_dias[0] = dc.getAdicional2().equalsIgnoreCase("i")?pr.getHinicio():pr.getHfin();
//                                ob_dias[1] = dc.getAdicional2();
//                                ob_dias[2] = xc.getItem(); /*posición array*/
//                                ob_dias[3] = WebUtil.fechaDMY(pr.getFecha(),2);
//                                ob_dias[4] = ob_dias[3]+"\n"+(dc.getAdicional2().equalsIgnoreCase("i")?"Hora Inicio":"Hora Fin");
//                                ob_dias[5] = pr.getFecha();
//                                ob_dias[6] = pr.getValor();
//                                xc.getTareo().add(ob_dias);
//                            }else{
//                                ob_dias = new Object[7];
//                                ob_dias[0] = "00:00";
//                                ob_dias[1] = dc.getAdicional2();
//                                ob_dias[2] = xc.getItem();
//                                ob_dias[3] = WebUtil.fechaDMY(dc.getAdicional1(),2);
//                                ob_dias[4] = ob_dias[3]+"\n"+(dc.getAdicional2().equalsIgnoreCase("i")?"Hora Inicio":"Hora Fin");
//                                ob_dias[5] = dc.getAdicional1();
//                                ob_dias[6] = 0.0f;
//                                xc.getTareo().add(ob_dias);
//                            }
//                        }
//                    }else{
//                        for(int y=0;y<dataTableColumns.size(); y++){
//                            ob_dias = new Object[7];
//                            ob_dias[0] = "00:00";
//                            ob_dias[1] = "i";
//                            ob_dias[2] = xc.getItem(); /*posición array*/
//                            ob_dias[3] = WebUtil.fechaDMY(dataTableColumns.get(y).getAdicional1(),2);
//                            ob_dias[4] = ob_dias[3]+"\nHora Inicio";
//                            ob_dias[5] = dataTableColumns.get(y).getAdicional1();
//                            ob_dias[6] = 0.0f;
//                            xc.getTareo().add(ob_dias);
//
//                            ob_dias = new Object[7];
//                            ob_dias[0] = "00:00";
//                            ob_dias[1] = "f";
//                            ob_dias[2] = xc.getItem(); /*posición array*/
//                            ob_dias[3] = WebUtil.fechaDMY(dataTableColumns.get(y).getAdicional1(),2);
//                            ob_dias[4] = ob_dias[3]+"\nHora Fin";
//                            ob_dias[5] = dataTableColumns.get(y).getAdicional1();
//                            ob_dias[6] = 0.0f;
//                            xc.getTareo().add(ob_dias);
//                        }
//                    }   
//                }else{
//                    for(int y=0;y<dataTableColumns.size(); y++){
//                        ob_dias = new Object[7];
//                        ob_dias[0] = "00:00";
//                        ob_dias[1] = "i";
//                        ob_dias[2] = xc.getItem(); /*posición array*/
//                        ob_dias[3] = WebUtil.fechaDMY(dataTableColumns.get(y).getAdicional1(),2);
//                        ob_dias[4] = ob_dias[3]+"\nHora Inicio";
//                        ob_dias[5] = dataTableColumns.get(y).getAdicional1();
//                        ob_dias[6] = 0.0f;
//                        xc.getTareo().add(ob_dias);
//
//                        ob_dias = new Object[7];
//                        ob_dias[0] = "00:00";
//                        ob_dias[1] = "f";
//                        ob_dias[2] = xc.getItem(); /*posición array*/
//                        ob_dias[3] = WebUtil.fechaDMY(dataTableColumns.get(y).getAdicional1(),2);
//                        ob_dias[4] = ob_dias[3]+"\nHora Fin";
//                        ob_dias[5] = dataTableColumns.get(y).getAdicional1();
//                        ob_dias[6] = 0.0f;
//                        xc.getTareo().add(ob_dias);
//                    }
//                }   
//                listDet_tareoweb.set(x, xc);
//            }
////            RequestContext.getCurrentInstance().execute("synchronizeRowsHeight();");
//            RequestContext.getCurrentInstance().update("datos:listDet_tareoweb");
//        }
//    }