package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.Det_tareoweb;
import com.nisira.core.NisiraORMException;
import com.nisira.core.util.CoreUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Det_tareowebDao extends BaseDao<Det_tareoweb> {
	public Det_tareowebDao() {
		super(Det_tareoweb.class);
	}
	public Det_tareowebDao(boolean usaCnBase) throws NisiraORMException {
		super(Det_tareoweb.class, usaCnBase);
	}

	public Det_tareoweb getPorClavePrimaria(String IDEMPRESA, String IDCABTAREOWEB, String IDORDENSERVICIO, String IDDOCUMENTO, String SERIE, String NUMERO, String RUC, String IDCARGO, String IDPERSONAL, String ITEM_DORDENSERVICIO, String ITEM2_PERSONALSERVICIO, String ITEM_DPERSONALSERVICIO) throws NisiraORMException {
            List<Det_tareoweb> l = listar("t0.IDEMPRESA = ? and t0.IDCABTAREOWEB = ? and t0.IDORDENSERVICIO = ? and t0.IDDOCUMENTO = ? and t0.SERIE = ? and t0.NUMERO = ? and t0.RUC = ? and t0.IDCARGO = ? and t0.IDPERSONAL = ? and t0.ITEM_DORDENSERVICIO = ? and t0.ITEM2_PERSONALSERVICIO = ? and t0.ITEM_DPERSONALSERVICIO = ? ", IDEMPRESA, IDCABTAREOWEB, IDORDENSERVICIO, IDDOCUMENTO, SERIE, NUMERO, RUC, IDCARGO, IDPERSONAL, ITEM_DORDENSERVICIO, ITEM2_PERSONALSERVICIO, ITEM_DPERSONALSERVICIO);
            if (l.isEmpty()) {
                return null;
            } else {
                return l.get(0);
            }
	}
        /*APP WEB*/
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_new(String idempresa,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();
            ResultSet rs = null;
            rs = execProcedure("SP_TAREO_WEB_ORDENSERVICIOCLIENTE_TMPSS",idempresa,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                
                tareoweb.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                tareoweb.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                tareoweb.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                tareoweb.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                tareoweb.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                tareoweb.setBrevete_cliente(rs.getString("BREVETE_CLIENTE")!=null?rs.getString("BREVETE_CLIENTE").trim():"");
                tareoweb.setCodoperaciones(rs.getString("CODOPERACIONES")!=null?rs.getString("CODOPERACIONES").trim():"");
                tareoweb.setRutaservicios(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                tareoweb.setIdruta_ec(rs.getString("IDRUTA_EC")!=null?rs.getString("IDRUTA_EC").trim():"");
                tareoweb.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                tareoweb.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                tareoweb.setIdconceptotareo(rs.getString("IDCONCEPTOTAREO")!=null?rs.getString("IDCONCEPTOTAREO").trim():"");
                tareoweb.setConceptotareo(rs.getString("CONCEPTOTAREO")!=null?rs.getString("CONCEPTOTAREO").trim():"");
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }else{
                    tareoweb.setShora_req("00:00");
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }else{
                    tareoweb.setShora_llegada("00:00");
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }else{
                    tareoweb.setShora_inicio("00:00");
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }else{
                    tareoweb.setShora_fin("00:00");
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }else{
                    tareoweb.setShora_liberacion("00:00");
                }
                tareoweb.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                
                lista.add(tareoweb); 
            }

        return lista;
        }
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_update(String idempresa,String idcabtareoweb,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();

            ResultSet rs = null;
            rs = execProcedure("GETDET_TAREOWEB_TMPSS",idempresa,idcabtareoweb,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                tareoweb.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                tareoweb.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                tareoweb.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                tareoweb.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                tareoweb.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                tareoweb.setBrevete_cliente(rs.getString("BREVETE_CLIENTE")!=null?rs.getString("BREVETE_CLIENTE").trim():"");
                tareoweb.setCodoperaciones(rs.getString("CODOPERACIONES")!=null?rs.getString("CODOPERACIONES").trim():"");
                tareoweb.setRutaservicios(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                tareoweb.setIdruta_ec(rs.getString("IDRUTA_EC")!=null?rs.getString("IDRUTA_EC").trim():"");
                tareoweb.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                tareoweb.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                tareoweb.setIdconceptotareo(rs.getString("IDCONCEPTOTAREO")!=null?rs.getString("IDCONCEPTOTAREO").trim():"");
                tareoweb.setConceptotareo(rs.getString("CONCEPTOTAREO")!=null?rs.getString("CONCEPTOTAREO").trim():"");
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }else{
                    tareoweb.setShora_llegada("00:00");
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }else{
                    tareoweb.setShora_inicio("00:00");
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }else{
                    tareoweb.setShora_fin("00:00");
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }else{
                    tareoweb.setShora_liberacion("00:00");
                }
                tareoweb.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                lista.add(tareoweb); 
            }

        return lista;
        }
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_new_fijo(String idempresa,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();
            ResultSet rs = null;
            rs = execProcedure("SP_TAREO_WEB_ORDENSERVICIOCLIENTE_FIJO_TMPSS",idempresa,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setTareo(new ArrayList<>());
                lista.add(tareoweb); 
            }

        return lista;
        }
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_update_fijo(String idempresa,String idcabtareoweb,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();

            ResultSet rs = null;
            rs = execProcedure("GETDET_TAREOWEB_FIJO_TMPSS",idempresa,idcabtareoweb,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }
                tareoweb.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                tareoweb.setEncrypt_programacion(rs.getString("ENCRYPT_PROGRAMACION")!=null?rs.getString("ENCRYPT_PROGRAMACION").trim():"");
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setTareo(new ArrayList<>());
                lista.add(tareoweb); 
            }

        return lista;
        }
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_new_provincial(String idempresa,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();
            ResultSet rs = null;
            rs = execProcedure("SP_TAREO_WEB_ORDENSERVICIOCLIENTE_PROVINCIAL_TMPSS",idempresa,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                
                tareoweb.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                tareoweb.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                tareoweb.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                tareoweb.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                tareoweb.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                tareoweb.setBrevete_cliente(rs.getString("BREVETE_CLIENTE")!=null?rs.getString("BREVETE_CLIENTE").trim():"");
                tareoweb.setCodoperaciones(rs.getString("CODOPERACIONES")!=null?rs.getString("CODOPERACIONES").trim():"");
                tareoweb.setRutaservicios(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                tareoweb.setIdruta_ec(rs.getString("IDRUTA_EC")!=null?rs.getString("IDRUTA_EC").trim():"");
                tareoweb.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                tareoweb.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                tareoweb.setIdconceptotareo(rs.getString("IDCONCEPTOTAREO")!=null?rs.getString("IDCONCEPTOTAREO").trim():"");
                tareoweb.setConceptotareo(rs.getString("CONCEPTOTAREO")!=null?rs.getString("CONCEPTOTAREO").trim():"");
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }else{
                    tareoweb.setShora_req("00:00");
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }else{
                    tareoweb.setShora_llegada("00:00");
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }else{
                    tareoweb.setShora_inicio("00:00");
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }else{
                    tareoweb.setShora_fin("00:00");
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }else{
                    tareoweb.setShora_liberacion("00:00");
                }
                tareoweb.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                
                lista.add(tareoweb); 
            }

        return lista;
        }
        public ArrayList<Det_tareoweb> listarPorEmpresaWeb_update_provincial(String idempresa,String idcabtareoweb,String desde, String hasta,String idresponsable,String idusuario) throws NisiraORMException, SQLException {
            ArrayList<Det_tareoweb> lista = new ArrayList<Det_tareoweb>();
            ResultSet rs = null;
            rs = execProcedure("GETDET_TAREOWEB_TMPSS",idempresa,idcabtareoweb,desde,hasta,idresponsable,idusuario);
            while (rs.next()) {
                Det_tareoweb tareoweb = new Det_tareoweb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdcabtareoweb(rs.getString("IDCABTAREOWEB")!=null?rs.getString("IDCABTAREOWEB").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setFecha_osc(rs.getDate("FECHA_OSC"));
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setIdservicio(rs.getString("IDSERVICIO")!=null?rs.getString("IDSERVICIO").trim():"");
                tareoweb.setServicio(rs.getString("SERVICIO")!=null?rs.getString("SERVICIO").trim():"");
                tareoweb.setHabilitado(rs.getBoolean("HABILITADO"));
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_dordenservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setIdvehiculo(rs.getString("IDVEHICULO")!=null?rs.getString("IDVEHICULO").trim():"");
                tareoweb.setVehiculo(rs.getString("VEHICULO")!=null?rs.getString("VEHICULO").trim():"");
                tareoweb.setChecklist(rs.getString("CHECKLIST")!=null?rs.getString("CHECKLIST").trim():"");
                tareoweb.setNrocontenedor(rs.getString("NROCONTENEDOR")!=null?rs.getString("NROCONTENEDOR").trim():"");
                tareoweb.setNroprecinto(rs.getString("NROPRECINTO")!=null?rs.getString("NROPRECINTO").trim():"");
                tareoweb.setNro_oservicio(rs.getString("NRO_OSERVICIO")!=null?rs.getString("NRO_OSERVICIO").trim():"");
                tareoweb.setPlaca_cliente(rs.getString("PLACA_CLIENTE")!=null?rs.getString("PLACA_CLIENTE").trim():"");
                tareoweb.setConductor_cliente(rs.getString("CONDUCTOR_CLIENTE")!=null?rs.getString("CONDUCTOR_CLIENTE").trim():"");
                tareoweb.setBrevete_cliente(rs.getString("BREVETE_CLIENTE")!=null?rs.getString("BREVETE_CLIENTE").trim():"");
                tareoweb.setCodoperaciones(rs.getString("CODOPERACIONES")!=null?rs.getString("CODOPERACIONES").trim():"");
                tareoweb.setRutaservicios(rs.getString("RUTASERVICIOS")!=null?rs.getString("RUTASERVICIOS").trim():"");
                tareoweb.setIdruta_ec(rs.getString("IDRUTA_EC")!=null?rs.getString("IDRUTA_EC").trim():"");
                tareoweb.setIdreferencia(rs.getString("IDREFERENCIA")!=null?rs.getString("IDREFERENCIA").trim():"");
                tareoweb.setItemreferencia(rs.getString("ITEMREFERENCIA")!=null?rs.getString("ITEMREFERENCIA").trim():"");
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                tareoweb.setHora_rc(rs.getFloat("HORA_RC"));
                tareoweb.setIdconceptotareo(rs.getString("IDCONCEPTOTAREO")!=null?rs.getString("IDCONCEPTOTAREO").trim():"");
                tareoweb.setConceptotareo(rs.getString("CONCEPTOTAREO")!=null?rs.getString("CONCEPTOTAREO").trim():"");
                
                if(tareoweb.getHora_req()!=0.0f){
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                    tareoweb.setShora_req(CoreUtil.convertTimeString(tareoweb.getFhora_req()));
                }
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f){
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                    tareoweb.setShora_llegada(CoreUtil.convertTimeString(tareoweb.getFhora_llegada()));
                }else{
                    tareoweb.setShora_llegada("00:00");
                }
                tareoweb.setHora_inicio_serv(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio_serv()!=0.0f){
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio_serv()));
                    tareoweb.setShora_inicio(CoreUtil.convertTimeString(tareoweb.getFhora_inicio()));
                }else{
                    tareoweb.setShora_inicio("00:00");
                }
                tareoweb.setHora_fin_serv(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin_serv()!=0.0f){
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin_serv()));
                    tareoweb.setShora_fin(CoreUtil.convertTimeString(tareoweb.getFhora_fin()));
                }else{
                    tareoweb.setShora_fin("00:00");
                }
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f){
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                    tareoweb.setShora_liberacion(CoreUtil.convertTimeString(tareoweb.getFhora_liberacion()));
                }else{
                    tareoweb.setShora_liberacion("00:00");
                }
                tareoweb.setFecharegistro(rs.getDate("FECHAREGISTRO"));
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                tareoweb.setCodasistencia(rs.getString("CODASISTENCIA")!=null?rs.getString("CODASISTENCIA").trim():"");
                tareoweb.setGlosa(rs.getString("GLOSA")!=null?rs.getString("GLOSA").trim():"");
                tareoweb.setAsistencia(rs.getString("ASISTENCIA")!=null?rs.getString("ASISTENCIA").trim():"");
                
                tareoweb.setExige_glosa(rs.getBoolean("EXIGE_GLOSA"));
                tareoweb.setColor(rs.getString("COLOR")!=null?rs.getString("COLOR").trim():"");
                
                tareoweb.setConductor_rpt(rs.getString("CONDUCTOR_RPT")!=null?rs.getString("CONDUCTOR_RPT").trim():"");
                tareoweb.setPrecinto_rpt(rs.getString("PRECINTO_RPT")!=null?rs.getString("PRECINTO_RPT").trim():"");
                tareoweb.setPlaca_cliente_rpt(rs.getString("PLACA_CLIENTE_RPT")!=null?rs.getString("PLACA_CLIENTE_RPT").trim():"");
                lista.add(tareoweb); 
            }

        return lista;
        }
}