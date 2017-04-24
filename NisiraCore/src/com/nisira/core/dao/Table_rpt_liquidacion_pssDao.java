package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Table_rpt_liquidacion_pss;
import com.nisira.core.NisiraORMException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Table_rpt_liquidacion_pssDao extends BaseDao<Table_rpt_liquidacion_pss> {
	public Table_rpt_liquidacion_pssDao() {
		super(Table_rpt_liquidacion_pss.class);
	}
	public Table_rpt_liquidacion_pssDao(boolean usaCnBase) throws NisiraORMException {
		super(Table_rpt_liquidacion_pss.class, usaCnBase);
	}
        public ArrayList<Table_rpt_liquidacion_pss> listarPorEmpresaWebFiltroFecha(String idempresa,String fechainicio,String fechafin) throws NisiraORMException,Exception {
            ArrayList<Table_rpt_liquidacion_pss> lista = new ArrayList<Table_rpt_liquidacion_pss>();

            ResultSet rs = null;
            rs = execProcedure("RPT_LIQUIDACION_TMPSS",idempresa,fechainicio,fechafin);
            while (rs.next()) {
                Table_rpt_liquidacion_pss table_rpt_liquidacion_pss = new Table_rpt_liquidacion_pss();
                table_rpt_liquidacion_pss.setCampo1(rs.getString("ID")!=null?rs.getString("ID").trim():"");
                table_rpt_liquidacion_pss.setCampo2(rs.getString("ITEM")!=null?rs.getString("ITEM").trim():"");
                table_rpt_liquidacion_pss.setCampo3(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                table_rpt_liquidacion_pss.setCampo4(rs.getString("FECHA")!=null?rs.getString("FECHA").trim():"");
                table_rpt_liquidacion_pss.setCampo5(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                table_rpt_liquidacion_pss.setCampo6(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                table_rpt_liquidacion_pss.setCampo7(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                table_rpt_liquidacion_pss.setCampo8(rs.getString("CLIENTE")!=null?rs.getString("CLIENTE").trim():"");
                table_rpt_liquidacion_pss.setCampo9(rs.getString("VALOR")!=null?rs.getString("VALOR").trim():"");
                table_rpt_liquidacion_pss.setCampo10(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                table_rpt_liquidacion_pss.setCampo11(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                table_rpt_liquidacion_pss.setCampo12(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                table_rpt_liquidacion_pss.setCampo13(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                table_rpt_liquidacion_pss.setCampo14(rs.getString("IDRUTA")!=null?rs.getString("IDRUTA").trim():"");
                table_rpt_liquidacion_pss.setCampo15(rs.getString("RUTA")!=null?rs.getString("RUTA").trim():"");
                table_rpt_liquidacion_pss.setCampo16(rs.getString("ORIGEN_DESTINO")!=null?rs.getString("ORIGEN_DESTINO").trim():"");
                table_rpt_liquidacion_pss.setCampo17(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                table_rpt_liquidacion_pss.setCampo18(rs.getString("HORA_INICIO")!=null?rs.getString("HORA_INICIO").trim():"");
                table_rpt_liquidacion_pss.setCampo19(rs.getString("HORA_FIN")!=null?rs.getString("HORA_FIN").trim():"");
                table_rpt_liquidacion_pss.setCampo20(rs.getString("CALCULO")!=null?rs.getString("CALCULO").trim():"");
                table_rpt_liquidacion_pss.setCampo21(rs.getString("HORASXFACTURAR")!=null?rs.getString("HORASXFACTURAR").trim():"");
                lista.add(table_rpt_liquidacion_pss); 
            }
            return lista;
        }
}