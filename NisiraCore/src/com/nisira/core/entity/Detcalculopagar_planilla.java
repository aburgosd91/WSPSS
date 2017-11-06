package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.List;
@XStreamAlias("DETCALCULOPAGAR_PLANILLA")
@Tabla(nombre = "DETCALCULOPAGAR_PLANILLA")
public class Detcalculopagar_planilla {
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDCABCALCULOPAGAR_PLANILLA")
	@ClavePrimaria
	@Columna
	private String idcabcalculopagar_planilla;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private Integer item;
        @XStreamAlias("IDCLIEPROV")
	@Columna
	private String idclieprov;
        @XStreamAlias("RAZON_SOCIAL")
	@Columna
	private String razon_social;
        @XStreamAlias("IDCLIENTE")
	@Columna
	private String idcliente;
        @XStreamAlias("ORDENREGISTRO")
	@Columna
	private Integer ordenregistro;
        @XStreamAlias("TCOSTO")
	@Columna
	private Float tcosto;
        @XStreamAlias("RUTASERVICIO")
	@Columna
	private String rutaservicio;
        @XStreamAlias("DIDORDENSERVICIO")
	@Columna
	private String didordenservicio;
        @XStreamAlias("DCLIENTE")
	@Columna
	private String dcliente;
        @XStreamAlias("DIDDOCUMENTO")
	@Columna
	private String diddocumento;
        @XStreamAlias("DSERIE")
	@Columna
	private String dserie;
        @XStreamAlias("DNUMERO")
	@Columna
	private String dnumero;
        @XStreamAlias("IDAMBITO_SERVICIO")
	@Columna
	private String idambito_servicio;
        @XStreamAlias("AMBITO_SERVICIO")
	@Columna
	private String ambito_servicio;
        @XStreamAlias("DFECHA_OSC")
	@Columna
	private Date dfecha_osc;
        @XStreamAlias("DFECHAREGISTRO")
	@Columna
	private Date dfecharegistro;
        @XStreamAlias("DFECHAFINREGISTRO")
	@Columna
	private Date dfechafinregistro;
        @XStreamAlias("DHI")
	@Columna
	private Float dhi;
        @XStreamAlias("DHF")
	@Columna
	private Float dhf;
        @XStreamAlias("DHS")
	@Columna
	private Float dhs;
        @XStreamAlias("DHBASE")
	@Columna
	private Float dhbase;
        @XStreamAlias("DHADICIONAL")
	@Columna
	private Float dhadicional;
        @XStreamAlias("DCOSTO_RH")
	@Columna
	private Float dcosto_rh;
        @XStreamAlias("DHCOSTO_ADICIONAL")
	@Columna
	private Float dhcosto_adicional;
        @XStreamAlias("DCOSTO_BONO")
	@Columna
	private Float dcosto_bono;
        @XStreamAlias("DIDCARGO")
	@Columna
	private String didcargo;
        @XStreamAlias("DCODIGO_EC")
	@Columna
	private String dcodigo_ec;
        @XStreamAlias("DITEMRANGO_EC")
	@Columna
	private String ditemrango_ec;
        @XStreamAlias("DCODOPERACIONES_EC")
	@Columna
	private String dcodoperaciones_ec;
        @XStreamAlias("DNHORAS_EC")
	@Columna
	private Float dnhoras_ec;
        @XStreamAlias("DIDRUTA_EC")
	@Columna
	private String didruta_ec;
        @XStreamAlias("DIDRUTA")
	@Columna
	private String didruta;
        @XStreamAlias("DHORA_REQ")
	@Columna
	private Float dhora_req;
        @XStreamAlias("DHORA_LLEGADA")
	@Columna
	private Float dhora_llegada;
        @XStreamAlias("DHORA_INICIO_SERV")
	@Columna
	private Float dhora_inicio_serv;
        @XStreamAlias("DHORA_FIN_SERV")
	@Columna
	private Float dhora_fin_serv;
        @XStreamAlias("DHORA_LIBERACION")
	@Columna
	private Float dhora_liberacion;
        @XStreamAlias("DCHECKLIST")
	@Columna
	private String dchecklist;
        @XStreamAlias("DIDVEHICULO")
	@Columna
	private String didvehiculo;
        @XStreamAlias("DNROCONTENEDOR")
	@Columna
	private String dnrocontenedor;
        @XStreamAlias("DNROPRECINTO")
	@Columna
	private String dnroprecinto;
        @XStreamAlias("DNRO_OSERVICIO")
	@Columna
	private String dnro_oservicio;
        @XStreamAlias("DPLACA_CLIENTE")
	@Columna
	private String dplaca_cliente;
        @XStreamAlias("DCONDUCTOR_CLIENTE")
	@Columna
	private String dconductor_cliente;
        @XStreamAlias("DBREVETE_CLIENTE")
	@Columna
	private String dbrevete_cliente;
        @XStreamAlias("ESPLANILLA")
	@Columna
	private Integer esplanilla;
        @XStreamAlias("NSERVICIOS_DIA")
	@Columna
	private Integer nservicios_dia;
        @XStreamAlias("TIENE_SUSPENSION")
	@Columna
	private Integer tiene_suspension;
        @XStreamAlias("USUARIO_SOL")
	@Columna
	private String usuario_sol;
        @XStreamAlias("CLAVE_SOL")
	@Columna
	private String clave_sol;
        @XStreamAlias("ORIGENCALLAO")
        @Columna
        private int origencallao;
        @XStreamAlias("COSTOM")
	@Columna
	private Float costom;
        @XStreamAlias("GLOSA")
	@Columna
	private String glosa;
        @XStreamAlias("TOTAL")
	@Columna
	private Float total;
        /*DATOS ADICIONALES - CALCULO*/
        @XStreamOmitField
        private String dhi_s;
        @XStreamOmitField
        private String dhf_s;
        @XStreamOmitField
        private String dhs_s;
        @XStreamOmitField
        private String dhbase_s;
        @XStreamOmitField
        private String dhadicional_s;
        @XStreamOmitField
        private String cargo;
        /*DATOS ADICIONALES - TAREO*/
        @XStreamOmitField
        private String shora_req;
        @XStreamOmitField
        private String shora_llegada;
        @XStreamOmitField
        private String shora_inicio_serv;
        @XStreamOmitField
        private String shora_fin_serv;
        @XStreamOmitField
        private String shora_liberacion;
        
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCABCALCULOPAGAR_PLANILLA",campoRelacionado="IDCABCALCULOPAGAR_PLANILLA")})
	private Cabcalculopagar_planilla cabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcabcalculopagar_planilla(String idcabcalculopagar_planilla) {
		this.idcabcalculopagar_planilla = idcabcalculopagar_planilla;
	}

	public String getIdcabcalculopagar_planilla() {
		return this.idcabcalculopagar_planilla;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRazon_social() {
		return this.razon_social;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdcliente() {
		return this.idcliente;
	}

	public void setOrdenregistro(Integer ordenregistro) {
		this.ordenregistro = ordenregistro;
	}

	public Integer getOrdenregistro() {
		return this.ordenregistro;
	}

	public void setTcosto(Float tcosto) {
		this.tcosto = tcosto;
	}

	public Float getTcosto() {
		return this.tcosto;
	}

	public void setRutaservicio(String rutaservicio) {
		this.rutaservicio = rutaservicio;
	}

	public String getRutaservicio() {
		return this.rutaservicio;
	}

	public void setDidordenservicio(String didordenservicio) {
		this.didordenservicio = didordenservicio;
	}

	public String getDidordenservicio() {
		return this.didordenservicio;
	}

	public void setDcliente(String dcliente) {
		this.dcliente = dcliente;
	}

	public String getDcliente() {
		return this.dcliente;
	}

	public void setDiddocumento(String diddocumento) {
		this.diddocumento = diddocumento;
	}

	public String getDiddocumento() {
		return this.diddocumento;
	}

	public void setDserie(String dserie) {
		this.dserie = dserie;
	}

	public String getDserie() {
		return this.dserie;
	}

	public void setDnumero(String dnumero) {
		this.dnumero = dnumero;
	}

	public String getDnumero() {
		return this.dnumero;
	}

	public void setIdambito_servicio(String idambito_servicio) {
		this.idambito_servicio = idambito_servicio;
	}

	public String getIdambito_servicio() {
		return this.idambito_servicio;
	}

	public void setAmbito_servicio(String ambito_servicio) {
		this.ambito_servicio = ambito_servicio;
	}

	public String getAmbito_servicio() {
		return this.ambito_servicio;
	}

	public void setDfecha_osc(Date dfecha_osc) {
		this.dfecha_osc = dfecha_osc;
	}

	public Date getDfecha_osc() {
		return this.dfecha_osc;
	}

	public void setDfecharegistro(Date dfecharegistro) {
		this.dfecharegistro = dfecharegistro;
	}

	public Date getDfecharegistro() {
		return this.dfecharegistro;
	}

	public void setDfechafinregistro(Date dfechafinregistro) {
		this.dfechafinregistro = dfechafinregistro;
	}

	public Date getDfechafinregistro() {
		return this.dfechafinregistro;
	}

	public void setDhi(Float dhi) {
		this.dhi = dhi;
	}

	public Float getDhi() {
		return this.dhi;
	}

	public void setDhf(Float dhf) {
		this.dhf = dhf;
	}

	public Float getDhf() {
		return this.dhf;
	}

	public void setDhs(Float dhs) {
		this.dhs = dhs;
	}

	public Float getDhs() {
		return this.dhs;
	}

	public void setDhbase(Float dhbase) {
		this.dhbase = dhbase;
	}

	public Float getDhbase() {
		return this.dhbase;
	}

	public void setDhadicional(Float dhadicional) {
		this.dhadicional = dhadicional;
	}

	public Float getDhadicional() {
		return this.dhadicional;
	}

	public void setDcosto_rh(Float dcosto_rh) {
		this.dcosto_rh = dcosto_rh;
	}

	public Float getDcosto_rh() {
		return this.dcosto_rh;
	}

	public void setDhcosto_adicional(Float dhcosto_adicional) {
		this.dhcosto_adicional = dhcosto_adicional;
	}

	public Float getDhcosto_adicional() {
		return this.dhcosto_adicional;
	}

	public void setDcosto_bono(Float dcosto_bono) {
		this.dcosto_bono = dcosto_bono;
	}

	public Float getDcosto_bono() {
		return this.dcosto_bono;
	}

	public void setDidcargo(String didcargo) {
		this.didcargo = didcargo;
	}

	public String getDidcargo() {
		return this.didcargo;
	}

	public void setDcodigo_ec(String dcodigo_ec) {
		this.dcodigo_ec = dcodigo_ec;
	}

	public String getDcodigo_ec() {
		return this.dcodigo_ec;
	}

	public void setDitemrango_ec(String ditemrango_ec) {
		this.ditemrango_ec = ditemrango_ec;
	}

	public String getDitemrango_ec() {
		return this.ditemrango_ec;
	}

	public void setDcodoperaciones_ec(String dcodoperaciones_ec) {
		this.dcodoperaciones_ec = dcodoperaciones_ec;
	}

	public String getDcodoperaciones_ec() {
		return this.dcodoperaciones_ec;
	}

	public void setDnhoras_ec(Float dnhoras_ec) {
		this.dnhoras_ec = dnhoras_ec;
	}

	public Float getDnhoras_ec() {
		return this.dnhoras_ec;
	}

	public void setDidruta_ec(String didruta_ec) {
		this.didruta_ec = didruta_ec;
	}

	public String getDidruta_ec() {
		return this.didruta_ec;
	}

	public void setDidruta(String didruta) {
		this.didruta = didruta;
	}

	public String getDidruta() {
		return this.didruta;
	}

	public void setDhora_req(Float dhora_req) {
		this.dhora_req = dhora_req;
	}

	public Float getDhora_req() {
		return this.dhora_req;
	}

	public void setDhora_llegada(Float dhora_llegada) {
		this.dhora_llegada = dhora_llegada;
	}

	public Float getDhora_llegada() {
		return this.dhora_llegada;
	}

	public void setDhora_inicio_serv(Float dhora_inicio_serv) {
		this.dhora_inicio_serv = dhora_inicio_serv;
	}

	public Float getDhora_inicio_serv() {
		return this.dhora_inicio_serv;
	}

	public void setDhora_fin_serv(Float dhora_fin_serv) {
		this.dhora_fin_serv = dhora_fin_serv;
	}

	public Float getDhora_fin_serv() {
		return this.dhora_fin_serv;
	}

	public void setDhora_liberacion(Float dhora_liberacion) {
		this.dhora_liberacion = dhora_liberacion;
	}

	public Float getDhora_liberacion() {
		return this.dhora_liberacion;
	}

	public void setDchecklist(String dchecklist) {
		this.dchecklist = dchecklist;
	}

	public String getDchecklist() {
		return this.dchecklist;
	}

	public void setDidvehiculo(String didvehiculo) {
		this.didvehiculo = didvehiculo;
	}

	public String getDidvehiculo() {
		return this.didvehiculo;
	}

	public void setDnrocontenedor(String dnrocontenedor) {
		this.dnrocontenedor = dnrocontenedor;
	}

	public String getDnrocontenedor() {
		return this.dnrocontenedor;
	}

	public void setDnroprecinto(String dnroprecinto) {
		this.dnroprecinto = dnroprecinto;
	}

	public String getDnroprecinto() {
		return this.dnroprecinto;
	}

	public void setDnro_oservicio(String dnro_oservicio) {
		this.dnro_oservicio = dnro_oservicio;
	}

	public String getDnro_oservicio() {
		return this.dnro_oservicio;
	}

	public void setDplaca_cliente(String dplaca_cliente) {
		this.dplaca_cliente = dplaca_cliente;
	}

	public String getDplaca_cliente() {
		return this.dplaca_cliente;
	}

	public void setDconductor_cliente(String dconductor_cliente) {
		this.dconductor_cliente = dconductor_cliente;
	}

	public String getDconductor_cliente() {
		return this.dconductor_cliente;
	}

	public void setDbrevete_cliente(String dbrevete_cliente) {
		this.dbrevete_cliente = dbrevete_cliente;
	}

	public String getDbrevete_cliente() {
		return this.dbrevete_cliente;
	}

	public void setEsplanilla(Integer esplanilla) {
		this.esplanilla = esplanilla;
	}

	public Integer getEsplanilla() {
		return this.esplanilla;
	}

	public void setNservicios_dia(Integer nservicios_dia) {
		this.nservicios_dia = nservicios_dia;
	}

	public Integer getNservicios_dia() {
		return this.nservicios_dia;
	}

	public void setTiene_suspension(Integer tiene_suspension) {
		this.tiene_suspension = tiene_suspension;
	}

	public Integer getTiene_suspension() {
		return this.tiene_suspension;
	}

	public void setUsuario_sol(String usuario_sol) {
		this.usuario_sol = usuario_sol;
	}

	public String getUsuario_sol() {
		return this.usuario_sol;
	}

	public void setClave_sol(String clave_sol) {
		this.clave_sol = clave_sol;
	}

	public String getClave_sol() {
		return this.clave_sol;
	}



	/* Sets & Gets FK*/
	public void setCabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla(Cabcalculopagar_planilla cabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla) {
		this.cabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla = cabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla;
	}

	public Cabcalculopagar_planilla getCabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla() {
		return this.cabcalculopagar_planilla_fk_detcalculopagar_planilla_cabcalculopagar_planilla;
	}

    /**
     * @return the dhi_s
     */
    public String getDhi_s() {
        return dhi_s;
    }

    /**
     * @param dhi_s the dhi_s to set
     */
    public void setDhi_s(String dhi_s) {
        this.dhi_s = dhi_s;
    }

    /**
     * @return the dhf_s
     */
    public String getDhf_s() {
        return dhf_s;
    }

    /**
     * @param dhf_s the dhf_s to set
     */
    public void setDhf_s(String dhf_s) {
        this.dhf_s = dhf_s;
    }

    /**
     * @return the dhs_s
     */
    public String getDhs_s() {
        return dhs_s;
    }

    /**
     * @param dhs_s the dhs_s to set
     */
    public void setDhs_s(String dhs_s) {
        this.dhs_s = dhs_s;
    }

    /**
     * @return the dhbase_s
     */
    public String getDhbase_s() {
        return dhbase_s;
    }

    /**
     * @param dhbase_s the dhbase_s to set
     */
    public void setDhbase_s(String dhbase_s) {
        this.dhbase_s = dhbase_s;
    }

    /**
     * @return the dhadicional_s
     */
    public String getDhadicional_s() {
        return dhadicional_s;
    }

    /**
     * @param dhadicional_s the dhadicional_s to set
     */
    public void setDhadicional_s(String dhadicional_s) {
        this.dhadicional_s = dhadicional_s;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the shora_req
     */
    public String getShora_req() {
        return shora_req;
    }

    /**
     * @param shora_req the shora_req to set
     */
    public void setShora_req(String shora_req) {
        this.shora_req = shora_req;
    }

    /**
     * @return the shora_llegada
     */
    public String getShora_llegada() {
        return shora_llegada;
    }

    /**
     * @param shora_llegada the shora_llegada to set
     */
    public void setShora_llegada(String shora_llegada) {
        this.shora_llegada = shora_llegada;
    }

    /**
     * @return the shora_inicio_serv
     */
    public String getShora_inicio_serv() {
        return shora_inicio_serv;
    }

    /**
     * @param shora_inicio_serv the shora_inicio_serv to set
     */
    public void setShora_inicio_serv(String shora_inicio_serv) {
        this.shora_inicio_serv = shora_inicio_serv;
    }

    /**
     * @return the shora_fin_serv
     */
    public String getShora_fin_serv() {
        return shora_fin_serv;
    }

    /**
     * @param shora_fin_serv the shora_fin_serv to set
     */
    public void setShora_fin_serv(String shora_fin_serv) {
        this.shora_fin_serv = shora_fin_serv;
    }

    /**
     * @return the shora_liberacion
     */
    public String getShora_liberacion() {
        return shora_liberacion;
    }

    /**
     * @param shora_liberacion the shora_liberacion to set
     */
    public void setShora_liberacion(String shora_liberacion) {
        this.shora_liberacion = shora_liberacion;
    }

    /**
     * @return the origencallao
     */
    public int getOrigencallao() {
        return origencallao;
    }

    /**
     * @param origencallao the origencallao to set
     */
    public void setOrigencallao(int origencallao) {
        this.origencallao = origencallao;
    }

    /**
     * @return the costom
     */
    public Float getCostom() {
        return costom;
    }

    /**
     * @param costom the costom to set
     */
    public void setCostom(Float costom) {
        this.costom = costom;
    }

    /**
     * @return the glosa
     */
    public String getGlosa() {
        return glosa;
    }

    /**
     * @param glosa the glosa to set
     */
    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    /**
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Float total) {
        this.total = total;
    }


}