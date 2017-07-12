/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.entity.RptFijos;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.DataTableColumn;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
@ManagedBean(name = "rpt_tareoweb_fijoAction")
@SessionScoped
public class Rpt_tareoweb_fijoAction extends AbstactListAction<Ordenserviciocliente> {

    /**
     * ***********************************ArrayList**************************************
     */
    private List<DataTableColumn> dataTableColumns;
    /**
     * ***********************************DAO**************************************
     */
    private OrdenservicioclienteDao ordenservicioclienteDao;
    /**
     * ***********************************ENTITY**************************************
     */
    private UsuarioBean user;
    private String mensaje;
    private Object[] selectRpt;
    private List<RptFijos> lrtp;
    /**
     * *********************************** CONTROLES
     * ****************************************
     */
    private NSRResultSet rpt_result;

    public Rpt_tareoweb_fijoAction() {
        /**
         * *******************************ENTITY******************************************
         */
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        mensaje = "";
        /**
         * *******************************LISTAS******************************************
         */
        dataTableColumns = new ArrayList<>();
        lrtp = new ArrayList<RptFijos>();
        /**
         * *******************************DAO******************************************
         */
        ordenservicioclienteDao = new OrdenservicioclienteDao();
        /**
         * ********************************CONTROLADOR*******************************
         */
        /**
         * ******************************** CONFIGURACIÓN - SERVIDOR
         * *******************************
         */
        actualiza_ventana("wMnt_Ordenserviciocliente");
    }

    @Override
    public void buscarTodo() {
        try {
            buscar_filtrofecha();
        } catch (Exception ex) {
            Logger.getLogger(Rpt_tareoweb_fijoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIniciar() {
        /**
         * *******************************ENTITY******************************************
         */
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
        setMensaje("");
        /**
         * ********************************CONTROLADOR*******************************
         */
        /**
         * ********************************CONFIGURACIÓN -
         * SERVIDOR*******************************
         */
        actualiza_ventana("wMnt_Ordenserviciocliente");
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
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_fijo(user.getIDEMPRESA(), f_ini, f_fin));
            intoObject(rpt_result);

            RequestContext.getCurrentInstance().update("datos");
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        return;
    }

    public UsuarioBean getUser() {
        return user;
    }

    public void setUser(UsuarioBean user) {
        this.user = user;
    }

    @Override
    public void downFormatExcelEspecial(Object document) {
        try {
            HSSFWorkbook objWB = (HSSFWorkbook) document;
//                HSSFWorkbook objWB = new HSSFWorkbook();
//Cabezera
            HSSFSheet sheet1 = objWB.createSheet("REPORTE_FIJOS_GENERAL");
            HSSFRow fila_cabecera = sheet1.createRow((short) 0);
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
            HSSFCell celda;
            int tcol = rpt_result.getData().get(0).length;
            for (int i = 0; i < tcol; i++) {
                celda = fila_cabecera.createCell(i);
                celda.setCellStyle(estiloCelda);
                celda.setCellType(HSSFCell.CELL_TYPE_STRING);
                switch (i) {
                    case 0:celda.setCellValue("AMBITO");break;
                    case 1:celda.setCellValue("SEDE");break;
                    case 2:celda.setCellValue("IDDOCUMENTO");break;
                    case 3:celda.setCellValue("SERIE");break;
                    case 4:celda.setCellValue("NUMERO");break;
                    case 5:celda.setCellValue("EMPRESA");break;
                    case 6:celda.setCellValue("RUC");break;
                    case 7:celda.setCellValue("PUESTO");break;
                    case 8:celda.setCellValue("FECHA_SERVICIO");break;
                    case 9:celda.setCellValue("SERVICIO");break;
                    case 10:celda.setCellValue("HORA_REQ");break;
                    case 11:celda.setCellValue("HORA_FIN");break;
                    case 12:celda.setCellValue("HORAS");break;
                    case 13:celda.setCellValue("FINICIO");break;
                    case 14:celda.setCellValue("FFIN"); break;
                    case 15:celda.setCellValue("DNI");break;
                    case 16:celda.setCellValue("PERSONAL");break;
                    case 17:celda.setCellValue("CARGO");break;
                    case 18:celda.setCellValue("ASISTENCIA"); break;
                    case 19:celda.setCellValue("OBSERVACION");break;
                }
            }
            for (int row = 0; row < rpt_result.getData().size(); row++) {
                Object[] lst_col = rpt_result.getData().get(row);
                fila_cabecera = sheet1.createRow((short) row + 1);
                for (int col = 0; col < tcol; col++) {
                    celda = fila_cabecera.createCell(col);
                    celda.setCellStyle(estiloFila);
                    celda.setCellValue(lst_col[col].toString());
                }
            }
            for (int as = 0; as < tcol; as++) {
                sheet1.autoSizeColumn((short) as);
            }
            objWB.removeSheetAt(0);
            Map<String, List<RptFijos>> porDoc = lrtp.stream().collect(Collectors.groupingBy(RptFijos::getCodigoOP));
            Iterator i = porDoc.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry pair = (Map.Entry) i.next();
                HSSFSheet sheetN = objWB.createSheet(pair.getKey().toString());
                HSSFRow fila_cabeceraN = sheetN.createRow((short) 0);
                HSSFCell celdaN;
                ArrayList<RptFijos> list = (ArrayList) pair.getValue();
                Map<String, List<RptFijos>> nlist = list.stream().collect(Collectors.groupingBy(RptFijos::getDNI));
                for (int in = 0; in < 17; in++) {
                    celdaN = fila_cabeceraN.createCell(in);
                    celdaN.setCellStyle(estiloCelda);
                    celdaN.setCellType(HSSFCell.CELL_TYPE_STRING);
                    switch (in) {
                        case 0:celdaN.setCellValue("AMBITO");break;
                        case 1:celdaN.setCellValue("SEDE");break;
                        case 2:celdaN.setCellValue("IDDOCUMENTO");break;
                        case 3:celdaN.setCellValue("SERIE");break;
                        case 4:celdaN.setCellValue("NUMERO");break;
                        case 5:celdaN.setCellValue("EMPRESA");break;
                        case 6:celdaN.setCellValue("RUC");break;
                        case 7:celdaN.setCellValue("PUESTO");break;
                        case 8:celdaN.setCellValue("FECHA_SERVICIO");break;
                        case 9:celdaN.setCellValue("SERVICIO");break;
                        case 10:celdaN.setCellValue("HORA_REQ");break;
                        case 11:celdaN.setCellValue("HORA_FIN");break;
                        case 12:celdaN.setCellValue("HORAS");break;
                        case 13:celdaN.setCellValue("FECHAS");break;
                        case 14:celdaN.setCellValue("DNI");break;
                        case 15:celdaN.setCellValue("PERSONAL");break;
                        case 16:celdaN.setCellValue("CARGO");break;
                    }
                }
                int colm = 16;
                int head = 1;
                for (RptFijos rp : list) {
                    fila_cabeceraN = sheetN.getRow(0);
                    celdaN = fila_cabeceraN.createCell(colm);
                    celdaN.setCellStyle(estiloCelda);
                    celdaN.setCellType(HSSFCell.CELL_TYPE_STRING);
                    celdaN.setCellValue(head);
                    colm++;
                    head++;
                }
                Iterator nli = nlist.entrySet().iterator();
                int row = 0;
                while (nli.hasNext()) {
                    Map.Entry intp = (Map.Entry) nli.next();
                    fila_cabeceraN = sheetN.createRow(row+1);
                    ArrayList<RptFijos> tlist = (ArrayList) intp.getValue();
                    for (int in = 0; in < 17; in++) {
                    celdaN = fila_cabeceraN.createCell(in);
                    celdaN.setCellStyle(estiloFila);                   
                    switch (in) {
                        case 0:celdaN.setCellValue(tlist.get(0).getAMBITO());break;
                        case 1:celdaN.setCellValue(tlist.get(0).getSEDE());break;
                        case 2:celdaN.setCellValue(tlist.get(0).getIDDOCUMENTO());break;
                        case 3:celdaN.setCellValue(tlist.get(0).getSERIE());break;
                        case 4:celdaN.setCellValue(tlist.get(0).getNUMERO());break;
                        case 5:celdaN.setCellValue(tlist.get(0).getEMPRESA());break;
                        case 6:celdaN.setCellValue(tlist.get(0).getRUC());break;
                        case 7:celdaN.setCellValue(tlist.get(0).getPUESTO());break;
                        case 8:celdaN.setCellValue(tlist.get(0).getFECHA_SERVICIO());break;
                        case 9:celdaN.setCellValue(tlist.get(0).getSERVICIO());break;
                        case 10:celdaN.setCellValue(tlist.get(0).getHORA_REQ());break;
                        case 11:celdaN.setCellValue(tlist.get(0).getHORA_FIN());break;
                        case 12: celdaN.setCellValue(tlist.get(0).getHORAS());break;
                        case 13:celdaN.setCellValue(tlist.get(0).getFINICIO() + "-" + list.get(0).getFFIN());break;
                        case 14:celdaN.setCellValue(tlist.get(0).getDNI());break;
                        case 15:celdaN.setCellValue(tlist.get(0).getPERSONAL());break;
                        case 16:celdaN.setCellValue(tlist.get(0).getCARGO());break;
                        }                    
                    }
                    
                    int colw = 16;
                    for (RptFijos rp : tlist) {
                        celdaN = fila_cabeceraN.createCell(colw);
                        celdaN.setCellStyle(estiloFila);
                        celdaN.setCellValue(rp.getASISTENCIA());
                        colw++;
                    }
                    row++;
                }
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(EstructuraCostosRecursoAction.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje = ex.getMessage();
            RequestContext.getCurrentInstance().update("datos:growl");
        }
    }

    public void intoObject(NSRResultSet rs) {
        for (Object[] o : rs.getData()) {
            RptFijos rp = new RptFijos();
            rp.setAMBITO(String.valueOf(o[0]));
            rp.setSEDE(String.valueOf(o[1]));
            rp.setIDDOCUMENTO(String.valueOf(o[2]));
            rp.setSERIE(String.valueOf(o[3]));
            rp.setNUMERO(String.valueOf(o[4]));
            rp.setEMPRESA(String.valueOf(o[5]));
            rp.setRUC(String.valueOf(o[6]));
            rp.setPUESTO(String.valueOf(o[7]));
            rp.setFECHA_SERVICIO(String.valueOf(o[8]));
            rp.setSERVICIO(String.valueOf(o[9]));
            rp.setHORA_REQ(String.valueOf(o[10]));
            rp.setHORA_FIN(String.valueOf(o[11]));
            rp.setHORAS(String.valueOf(o[12]));
            rp.setFINICIO(String.valueOf(o[13]));
            rp.setFFIN(String.valueOf(o[14]));
            rp.setDNI(String.valueOf(o[15]));
            rp.setPERSONAL(String.valueOf(o[16]));
            rp.setCARGO(String.valueOf(o[17]));
            rp.setASISTENCIA(String.valueOf(o[18]));
            rp.setOBSERVACION(String.valueOf(o[19]));
            rp.setCodigoOP(rp.getIDDOCUMENTO() + "-" + rp.getSERIE() + "-" + rp.getNUMERO());
            lrtp.add(rp);
        }
    }

    @Override
    public String buscarFiltro(int tipo) {
        try {
            this.setMensaje("");
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String f_ini = f.format(getDesde());
            String f_fin = f.format(getHasta());
            f_ini = f_ini.replace("-", "");
            f_fin = f_fin.replace("-", "");
            setRpt_result(getOrdenservicioclienteDao().getConsultaRepote_fijo(user.getIDEMPRESA(), f_ini, f_fin));
            intoObject(rpt_result);
            //setListaDatos(getOrdenservicioclienteDao().listarPorEmpresaWebFiltroFecha(user.getIDEMPRESA(),f_ini,f_fin));
        } catch (Exception e) {
            setMensaje(WebUtil.mensajeError());
            WebUtil.error(getMensaje());
        }
        RequestContext.getCurrentInstance().update("datos:tbl");
        if (tipo == 2) {
            lista_accion_filtro("wLst_Rpt_tareoweb_fijo");
        }
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

    public String fechaDMY(Date fecha) {
        if (fecha != null) {
            return WebUtil.fechaDMY(fecha, 2);
        } else {
            return "";
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
}
