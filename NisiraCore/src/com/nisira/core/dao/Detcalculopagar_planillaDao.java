package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Detcalculopagar_planilla;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Detcalculopagar_planillaDao extends BaseDao<Detcalculopagar_planilla> {
	public Detcalculopagar_planillaDao() {
		super(Detcalculopagar_planilla.class);
	}
	public Detcalculopagar_planillaDao(boolean usaCnBase) throws NisiraORMException {
		super(Detcalculopagar_planilla.class, usaCnBase);
	}

	public Detcalculopagar_planilla getPorClavePrimaria(String IDEMPRESA, String IDCABCALCULOPAGAR_PLANILLA, Integer ITEM) throws NisiraORMException {
		List<Detcalculopagar_planilla> l = listar("t0.IDEMPRESA = ? and t0.IDCABCALCULOPAGAR_PLANILLA = ? and t0.ITEM = ? ", IDEMPRESA, IDCABCALCULOPAGAR_PLANILLA, ITEM);
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}
        /*FORMATO DETALLADO*/
        public ArrayList<Detcalculopagar_planilla> listar_facturacion_detalladoFiltroFecha(String idempresa,String fechainicio,String fechafin,String idtiposervicio) throws NisiraORMException,Exception {
            ArrayList<Detcalculopagar_planilla> lista = new ArrayList<Detcalculopagar_planilla>();

            ResultSet rs = null;
            rs = execProcedure("RPT_ORDENSERVICIOCLIENTE_FACTURACION_TMPSS",idempresa,fechainicio,fechafin,idtiposervicio);
            while (rs.next()) {
                Detcalculopagar_planilla detcalculopagar = new Detcalculopagar_planilla();
                detcalculopagar.setItem(rs.getInt("ITEM"));
                detcalculopagar.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                detcalculopagar.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                detcalculopagar.setIdcliente(rs.getString("IDCLIENTE")!=null?rs.getString("IDCLIENTE").trim():"");
                detcalculopagar.setOrdenregistro(rs.getInt("ORDENREGISTRO"));
                detcalculopagar.setTcosto(rs.getFloat("TCOSTO"));
                detcalculopagar.setTotal(rs.getFloat("TCOSTO"));
                detcalculopagar.setCostom(0.00f);
                detcalculopagar.setDidordenservicio(rs.getString("DIDORDENSERVICIO")!=null?rs.getString("DIDORDENSERVICIO").trim():"");
                detcalculopagar.setDcliente(rs.getString("DCLIENTE")!=null?rs.getString("DCLIENTE").trim():"");
                detcalculopagar.setDiddocumento(rs.getString("DIDDOCUMENTO")!=null?rs.getString("DIDDOCUMENTO").trim():"");
                detcalculopagar.setDserie(rs.getString("DSERIE")!=null?rs.getString("DSERIE").trim():"");
                detcalculopagar.setDnumero(rs.getString("DNUMERO")!=null?rs.getString("DNUMERO").trim():"");
                detcalculopagar.setAmbito_servicio(rs.getString("DAMBITO_SERVICIO_DES")!=null?rs.getString("DAMBITO_SERVICIO_DES").trim():"");
                detcalculopagar.setIdambito_servicio(rs.getString("DAMBITO_SERVICIO")!=null?rs.getString("DAMBITO_SERVICIO").trim():"");
                detcalculopagar.setDfecha_osc(rs.getDate("DFECHA_OSC"));
                detcalculopagar.setDfecharegistro(rs.getDate("DFECHAREGISTRO"));
                detcalculopagar.setDfechafinregistro(rs.getDate("DFECHAFINREGISTRO"));
                /*HORAS*/
                if(rs.getObject("DHI")!=null){
                    detcalculopagar.setDhi(((BigDecimal)rs.getObject("DHI")).floatValue());
                    detcalculopagar.setDhi_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhi()));
                }else{
                    detcalculopagar.setDhi(null);
                    detcalculopagar.setDhi_s("");
                }
                if(rs.getObject("DHF")!=null){
                    detcalculopagar.setDhf(((BigDecimal)rs.getObject("DHF")).floatValue());
                    detcalculopagar.setDhf_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhf()));
                }else{
                    detcalculopagar.setDhf(null);
                    detcalculopagar.setDhf_s("");
                }
                if(rs.getObject("DHS")!=null){
                    detcalculopagar.setDhs(rs.getFloat("DHS"));
                    detcalculopagar.setDhs_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhs()));
                }else{
                    detcalculopagar.setDhs(null);
                    detcalculopagar.setDhs_s("");
                }
                if(rs.getObject("DHBASE")!=null){
                    detcalculopagar.setDhbase(rs.getFloat("DHBASE"));
                    detcalculopagar.setDhbase_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhbase()));
                }else{
                    detcalculopagar.setDhbase(null);
                    detcalculopagar.setDhbase_s("");
                }
                if(rs.getObject("DHADICIONAL")!=null){
                    detcalculopagar.setDhadicional(rs.getFloat("DHADICIONAL"));
                    detcalculopagar.setDhadicional_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhadicional()));
                }else{
                    detcalculopagar.setDhadicional(null);
                    detcalculopagar.setDhadicional_s("");
                }
                /****** DATO TAREO ****/
                if(rs.getObject("DHORA_REQ")!=null){
                    detcalculopagar.setDhora_req(((BigDecimal)rs.getObject("DHORA_REQ")).floatValue());
                    detcalculopagar.setShora_req(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_req()));
                }else{
                    detcalculopagar.setDhora_req(null);
                    detcalculopagar.setShora_req("");
                }
                if(rs.getObject("DHORA_LLEGADA")!=null){
                    detcalculopagar.setDhora_llegada(((BigDecimal)rs.getObject("DHORA_LLEGADA")).floatValue());
                    detcalculopagar.setShora_llegada(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_llegada()));
                }else{
                    detcalculopagar.setDhora_llegada(null);
                    detcalculopagar.setShora_llegada("");
                }
                if(rs.getObject("DHORA_INICIO_SERV")!=null){
                    detcalculopagar.setDhora_inicio_serv(((BigDecimal)rs.getObject("DHORA_INICIO_SERV")).floatValue());
                    detcalculopagar.setShora_inicio_serv(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_inicio_serv()));
                }else{
                    detcalculopagar.setDhora_inicio_serv(null);
                    detcalculopagar.setShora_inicio_serv("");
                }
                if(rs.getObject("DHORA_FIN_SERV")!=null){
                    detcalculopagar.setDhora_fin_serv(((BigDecimal)rs.getObject("DHORA_FIN_SERV")).floatValue());
                    detcalculopagar.setShora_fin_serv(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_fin_serv()));
                }else{
                    detcalculopagar.setDhora_fin_serv(null);
                    detcalculopagar.setShora_fin_serv("");
                }
                if(rs.getObject("DHORA_LIBERACION")!=null){
                    detcalculopagar.setDhora_liberacion(((BigDecimal)rs.getObject("DHORA_LIBERACION")).floatValue());
                    detcalculopagar.setShora_liberacion(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_liberacion()));
                }else{
                    detcalculopagar.setDhora_liberacion(null);
                    detcalculopagar.setShora_liberacion("");
                }
                detcalculopagar.setDchecklist(rs.getString("DCHECKLIST")!=null?rs.getString("DCHECKLIST").trim():"");
                detcalculopagar.setDidvehiculo(rs.getString("DIDVEHICULO")!=null?rs.getString("DIDVEHICULO").trim():"");
                detcalculopagar.setDnrocontenedor(rs.getString("DNROCONTENEDOR")!=null?rs.getString("DNROCONTENEDOR").trim():"");
                detcalculopagar.setDnroprecinto(rs.getString("DNROPRECINTO")!=null?rs.getString("DNROPRECINTO").trim():"");
                detcalculopagar.setDnro_oservicio(rs.getString("DNRO_OSERVICIO")!=null?rs.getString("DNRO_OSERVICIO").trim():"");
                detcalculopagar.setDplaca_cliente(rs.getString("DPLACA_CLIENTE")!=null?rs.getString("DPLACA_CLIENTE").trim():"");
                detcalculopagar.setDconductor_cliente(rs.getString("DCONDUCTOR_CLIENTE")!=null?rs.getString("DCONDUCTOR_CLIENTE").trim():"");
                detcalculopagar.setDbrevete_cliente(rs.getString("DBREVETE_CLIENTE")!=null?rs.getString("DBREVETE_CLIENTE").trim():"");
                
                detcalculopagar.setDcosto_rh(rs.getFloat("DCOSTO_RH"));
                detcalculopagar.setDhcosto_adicional(rs.getFloat("DHCOSTO_ADICIONAL"));
                detcalculopagar.setDcosto_bono(rs.getFloat("DCOSTO_BONO"));
                detcalculopagar.setDidcargo(rs.getString("DIDCARGO")!=null?rs.getString("DIDCARGO").trim():"");
                detcalculopagar.setDcodigo_ec(rs.getString("DCODIGO_EC")!=null?rs.getString("DCODIGO_EC").trim():"");
                detcalculopagar.setDitemrango_ec(rs.getString("DITEMRANGO_EC")!=null?rs.getString("DITEMRANGO_EC").trim():"");
                detcalculopagar.setDcodoperaciones_ec(rs.getString("DCODOPERACIONES_EC")!=null?rs.getString("DCODOPERACIONES_EC").trim():"");
                detcalculopagar.setDnhoras_ec(rs.getFloat("DNHORAS_EC"));
                detcalculopagar.setDidruta_ec(rs.getString("DIDRUTA_EC")!=null?rs.getString("DIDRUTA_EC").trim():"");
                detcalculopagar.setDidruta(rs.getString("DIDRUTA")!=null?rs.getString("DIDRUTA").trim():"");
                detcalculopagar.setCargo(rs.getString("DCARGO")!=null?rs.getString("DCARGO").trim():"");
                detcalculopagar.setRutaservicio(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                detcalculopagar.setEsplanilla(rs.getInt("ESPLANILLA"));
                detcalculopagar.setOrigencallao(rs.getInt("ORIGENCALLAO"));
                detcalculopagar.setNservicios_dia(rs.getInt("NSERVICIOS_DIA"));
                detcalculopagar.setTiene_suspension(rs.getInt("TIENE_SUSPENSION"));
                detcalculopagar.setUsuario_sol(rs.getString("USUARIO_SOL")!=null?rs.getString("USUARIO_SOL").trim():"");
                detcalculopagar.setClave_sol(rs.getString("CLAVE_SOL")!=null?rs.getString("CLAVE_SOL").trim():"");
                lista.add(detcalculopagar); 
            }
            return lista;
        }
        public ArrayList<Detcalculopagar_planilla> listar_detallado(String idempresa,String idcabcalculopagar_planilla) throws NisiraORMException,Exception {
            ArrayList<Detcalculopagar_planilla> lista = new ArrayList<Detcalculopagar_planilla>();
            ResultSet rs = null;
            rs = execProcedure("GETDETCALCULOPAGAR_PLANILLA_TMPSS",idempresa,idcabcalculopagar_planilla);
            while (rs.next()) {
                Detcalculopagar_planilla detcalculopagar = new Detcalculopagar_planilla();
                detcalculopagar.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                detcalculopagar.setIdcabcalculopagar_planilla(rs.getString("IDCABCALCULOPAGAR_PLANILLA")!=null?rs.getString("IDCABCALCULOPAGAR_PLANILLA").trim():"");
                detcalculopagar.setItem(rs.getInt("ITEM"));
                detcalculopagar.setIdclieprov(rs.getString("IDCLIEPROV")!=null?rs.getString("IDCLIEPROV").trim():"");
                detcalculopagar.setRazon_social(rs.getString("RAZON_SOCIAL")!=null?rs.getString("RAZON_SOCIAL").trim():"");
                detcalculopagar.setIdcliente(rs.getString("IDCLIENTE")!=null?rs.getString("IDCLIENTE").trim():"");
                detcalculopagar.setOrdenregistro(rs.getInt("ORDENREGISTRO"));
                detcalculopagar.setTcosto(rs.getFloat("TCOSTO"));
                detcalculopagar.setTotal(rs.getFloat("TOTAL"));
                detcalculopagar.setCostom(rs.getFloat("COSTOM"));
                detcalculopagar.setDidordenservicio(rs.getString("DIDORDENSERVICIO")!=null?rs.getString("DIDORDENSERVICIO").trim():"");
                detcalculopagar.setDcliente(rs.getString("DCLIENTE")!=null?rs.getString("DCLIENTE").trim():"");
                detcalculopagar.setDiddocumento(rs.getString("DIDDOCUMENTO")!=null?rs.getString("DIDDOCUMENTO").trim():"");
                detcalculopagar.setDserie(rs.getString("DSERIE")!=null?rs.getString("DSERIE").trim():"");
                detcalculopagar.setDnumero(rs.getString("DNUMERO")!=null?rs.getString("DNUMERO").trim():"");
                detcalculopagar.setAmbito_servicio(rs.getString("AMBITO_SERVICIO")!=null?rs.getString("AMBITO_SERVICIO").trim():"");
                detcalculopagar.setIdambito_servicio(rs.getString("IDAMBITO_SERVICIO")!=null?rs.getString("IDAMBITO_SERVICIO").trim():"");
                detcalculopagar.setDfecha_osc(rs.getDate("DFECHA_OSC"));
                detcalculopagar.setDfecharegistro(rs.getDate("DFECHAREGISTRO"));
                detcalculopagar.setDfechafinregistro(rs.getDate("DFECHAFINREGISTRO"));
                /*HORAS*/
                if(rs.getObject("DHI")!=null){
                    detcalculopagar.setDhi(((BigDecimal)rs.getObject("DHI")).floatValue());
                    detcalculopagar.setDhi_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhi()));
                }else{
                    detcalculopagar.setDhi(null);
                    detcalculopagar.setDhi_s("");
                }
                if(rs.getObject("DHF")!=null){
                    detcalculopagar.setDhf(((BigDecimal)rs.getObject("DHF")).floatValue());
                    detcalculopagar.setDhf_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhf()));
                }else{
                    detcalculopagar.setDhf(null);
                    detcalculopagar.setDhf_s("");
                }
                if(rs.getObject("DHS")!=null){
                    detcalculopagar.setDhs(rs.getFloat("DHS"));
                    detcalculopagar.setDhs_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhs()));
                }else{
                    detcalculopagar.setDhs(null);
                    detcalculopagar.setDhs_s("");
                }
                if(rs.getObject("DHBASE")!=null){
                    detcalculopagar.setDhbase(rs.getFloat("DHBASE"));
                    detcalculopagar.setDhbase_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhbase()));
                }else{
                    detcalculopagar.setDhbase(null);
                    detcalculopagar.setDhbase_s("");
                }
                if(rs.getObject("DHADICIONAL")!=null){
                    detcalculopagar.setDhadicional(rs.getFloat("DHADICIONAL"));
                    detcalculopagar.setDhadicional_s(CoreUtil.convertTimeFloatString(detcalculopagar.getDhadicional()));
                }else{
                    detcalculopagar.setDhadicional(null);
                    detcalculopagar.setDhadicional_s("");
                }
                /****** DATO TAREO ****/
                if(rs.getObject("DHORA_REQ")!=null){
                    detcalculopagar.setDhora_req(((BigDecimal)rs.getObject("DHORA_REQ")).floatValue());
                    detcalculopagar.setShora_req(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_req()));
                }else{
                    detcalculopagar.setDhora_req(null);
                    detcalculopagar.setShora_req("");
                }
                if(rs.getObject("DHORA_LLEGADA")!=null){
                    detcalculopagar.setDhora_llegada(((BigDecimal)rs.getObject("DHORA_LLEGADA")).floatValue());
                    detcalculopagar.setShora_llegada(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_llegada()));
                }else{
                    detcalculopagar.setDhora_llegada(null);
                    detcalculopagar.setShora_llegada("");
                }
                if(rs.getObject("DHORA_INICIO_SERV")!=null){
                    detcalculopagar.setDhora_inicio_serv(((BigDecimal)rs.getObject("DHORA_INICIO_SERV")).floatValue());
                    detcalculopagar.setShora_inicio_serv(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_inicio_serv()));
                }else{
                    detcalculopagar.setDhora_inicio_serv(null);
                    detcalculopagar.setShora_inicio_serv("");
                }
                if(rs.getObject("DHORA_FIN_SERV")!=null){
                    detcalculopagar.setDhora_fin_serv(((BigDecimal)rs.getObject("DHORA_FIN_SERV")).floatValue());
                    detcalculopagar.setShora_fin_serv(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_fin_serv()));
                }else{
                    detcalculopagar.setDhora_fin_serv(null);
                    detcalculopagar.setShora_fin_serv("");
                }
                if(rs.getObject("DHORA_LIBERACION")!=null){
                    detcalculopagar.setDhora_liberacion(((BigDecimal)rs.getObject("DHORA_LIBERACION")).floatValue());
                    detcalculopagar.setShora_liberacion(CoreUtil.convertTimeFloatString(detcalculopagar.getDhora_liberacion()));
                }else{
                    detcalculopagar.setDhora_liberacion(null);
                    detcalculopagar.setShora_liberacion("");
                }
                detcalculopagar.setDchecklist(rs.getString("DCHECKLIST")!=null?rs.getString("DCHECKLIST").trim():"");
                detcalculopagar.setDidvehiculo(rs.getString("DIDVEHICULO")!=null?rs.getString("DIDVEHICULO").trim():"");
                detcalculopagar.setDnrocontenedor(rs.getString("DNROCONTENEDOR")!=null?rs.getString("DNROCONTENEDOR").trim():"");
                detcalculopagar.setDnroprecinto(rs.getString("DNROPRECINTO")!=null?rs.getString("DNROPRECINTO").trim():"");
                detcalculopagar.setDnro_oservicio(rs.getString("DNRO_OSERVICIO")!=null?rs.getString("DNRO_OSERVICIO").trim():"");
                detcalculopagar.setDplaca_cliente(rs.getString("DPLACA_CLIENTE")!=null?rs.getString("DPLACA_CLIENTE").trim():"");
                detcalculopagar.setDconductor_cliente(rs.getString("DCONDUCTOR_CLIENTE")!=null?rs.getString("DCONDUCTOR_CLIENTE").trim():"");
                detcalculopagar.setDbrevete_cliente(rs.getString("DBREVETE_CLIENTE")!=null?rs.getString("DBREVETE_CLIENTE").trim():"");
                
                detcalculopagar.setDcosto_rh(rs.getFloat("DCOSTO_RH"));
                detcalculopagar.setDhcosto_adicional(rs.getFloat("DHCOSTO_ADICIONAL"));
                detcalculopagar.setDcosto_bono(rs.getFloat("DCOSTO_BONO"));
                detcalculopagar.setDidcargo(rs.getString("DIDCARGO")!=null?rs.getString("DIDCARGO").trim():"");
                detcalculopagar.setDcodigo_ec(rs.getString("DCODIGO_EC")!=null?rs.getString("DCODIGO_EC").trim():"");
                detcalculopagar.setDitemrango_ec(rs.getString("DITEMRANGO_EC")!=null?rs.getString("DITEMRANGO_EC").trim():"");
                detcalculopagar.setDcodoperaciones_ec(rs.getString("DCODOPERACIONES_EC")!=null?rs.getString("DCODOPERACIONES_EC").trim():"");
                detcalculopagar.setDnhoras_ec(rs.getFloat("DNHORAS_EC"));
                detcalculopagar.setDidruta_ec(rs.getString("DIDRUTA_EC")!=null?rs.getString("DIDRUTA_EC").trim():"");
                detcalculopagar.setDidruta(rs.getString("DIDRUTA")!=null?rs.getString("DIDRUTA").trim():"");
                detcalculopagar.setCargo(rs.getString("DCARGO")!=null?rs.getString("DCARGO").trim():"");
                detcalculopagar.setRutaservicio(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                detcalculopagar.setEsplanilla(rs.getInt("ESPLANILLA"));
                detcalculopagar.setTiene_suspension(rs.getInt("TIENE_SUSPENSION"));
                detcalculopagar.setUsuario_sol(rs.getString("USUARIO_SOL")!=null?rs.getString("USUARIO_SOL").trim():"");
                detcalculopagar.setClave_sol(rs.getString("CLAVE_SOL")!=null?rs.getString("CLAVE_SOL").trim():"");
                detcalculopagar.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                lista.add(detcalculopagar); 
            }
            return lista;
        }
}