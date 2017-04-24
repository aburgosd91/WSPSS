package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.TareoWeb;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.util.CoreUtil;
import com.thoughtworks.xstream.XStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TareoWebDao extends BaseDao<TareoWeb> {
	public TareoWebDao() {
		super(TareoWeb.class);
	}
	public TareoWebDao(boolean usaCnBase) throws NisiraORMException {
		super(TareoWeb.class, usaCnBase);
	}

        /*APP WEB*/
        public ArrayList<TareoWeb> listarPorEmpresaWeb(String idempresa,String desde, String hasta) throws NisiraORMException {
            ArrayList<TareoWeb> lista = new ArrayList<TareoWeb>();
        try
        {
            ResultSet rs = null;
            rs = execProcedure("SP_TAREO_WEB_ORDENSERVICIOCLIENTE_TMPSS",idempresa,desde,hasta);
            while (rs.next()) {
                TareoWeb tareoweb = new TareoWeb();
                tareoweb.setItem(rs.getInt("ITEM"));
                tareoweb.setIdempresa(rs.getString("IDEMPRESA")!=null?rs.getString("IDEMPRESA").trim():"");
                tareoweb.setIdordenservicio(rs.getString("IDORDENSERVICIO")!=null?rs.getString("IDORDENSERVICIO").trim():"");
                tareoweb.setIddocumento(rs.getString("IDDOCUMENTO")!=null?rs.getString("IDDOCUMENTO").trim():"");
                tareoweb.setSerie(rs.getString("SERIE")!=null?rs.getString("SERIE").trim():"");
                tareoweb.setNumero(rs.getString("NUMERO")!=null?rs.getString("NUMERO").trim():"");
                tareoweb.setRuc(rs.getString("RUC")!=null?rs.getString("RUC").trim():"");
                tareoweb.setRazon(rs.getString("RAZON")!=null?rs.getString("RAZON").trim():"");
                tareoweb.setIdcargo(rs.getString("IDCARGO")!=null?rs.getString("IDCARGO").trim():"");
                tareoweb.setCargo(rs.getString("CARGO")!=null?rs.getString("CARGO").trim():"");
                tareoweb.setItem_personalservicio(rs.getString("ITEM_DORDENSERVICIO")!=null?rs.getString("ITEM_DORDENSERVICIO").trim():"");
                tareoweb.setItem2_personalservicio(rs.getString("ITEM2_PERSONALSERVICIO")!=null?rs.getString("ITEM2_PERSONALSERVICIO").trim():"");
                tareoweb.setIdpersonal(rs.getString("IDPERSONAL")!=null?rs.getString("IDPERSONAL").trim():"");
                tareoweb.setDni(rs.getString("DNI")!=null?rs.getString("DNI").trim():"");
                tareoweb.setPersonal(rs.getString("PERSONAL")!=null?rs.getString("PERSONAL").trim():"");
                tareoweb.setItem_dpersonalservicio(rs.getString("ITEM_DPERSONALSERVICIO")!=null?rs.getString("ITEM_DPERSONALSERVICIO").trim():"");
                tareoweb.setHora_req(rs.getFloat("HORA_REQ"));
                if(tareoweb.getHora_req()!=0.0f)
                    tareoweb.setFhora_req(CoreUtil.convertDecimalTime(tareoweb.getHora_req()));
                tareoweb.setHora_llegada(rs.getFloat("HORA_LLEGADA"));
                if(tareoweb.getHora_llegada()!=0.0f)
                    tareoweb.setFhora_llegada(CoreUtil.convertDecimalTime(tareoweb.getHora_llegada()));
                tareoweb.setHora_inicio(rs.getFloat("HORA_INICIO_SERV"));
                if(tareoweb.getHora_inicio()!=0.0f)
                    tareoweb.setFhora_inicio(CoreUtil.convertDecimalTime(tareoweb.getHora_inicio()));
                tareoweb.setHora_fin(rs.getFloat("HORA_FIN_SERV"));
                if(tareoweb.getHora_fin()!=0.0f)
                    tareoweb.setFhora_fin(CoreUtil.convertDecimalTime(tareoweb.getHora_fin()));
                tareoweb.setHora_liberacion(rs.getFloat("HORA_LIBERACION"));
                if(tareoweb.getHora_liberacion()!=0.0f)
                    tareoweb.setFhora_liberacion(CoreUtil.convertDecimalTime(tareoweb.getHora_liberacion()));
                
                tareoweb.setFechafinregistro(rs.getDate("FECHAFINREGISTRO"));
                lista.add(tareoweb); 
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return lista;
        }

}






















































      