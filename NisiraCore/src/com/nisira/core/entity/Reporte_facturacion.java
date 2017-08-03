package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XStreamAlias("REPORTE_FACTURACION")
@Tabla(nombre = "REPORTE_FACTURACION")
public class Reporte_facturacion  implements Serializable {
        @XStreamAlias("IDCLIEPROV")
        private String idclieprov;
        @XStreamAlias("RAZON_SOCIAL")
	@ClavePrimaria
	@Columna
	private String razon_social;
        @XStreamAlias("IDDOCUMENTO")
	@ClavePrimaria
	@Columna
	private String iddocumento;
        @XStreamAlias("SERIE")
	@Columna
	private String serie;
        @XStreamAlias("NUMERO")
	@Columna
	private String numero;
        @XStreamAlias("FECHA")
	@Columna
	private Date fecha;
        @XStreamAlias("FECHA_OPERACION")
	@Columna
	private Date fecha_operacion;
        @XStreamAlias("VENCIMIENTO")
	@Columna
	private Date vencimiento;
        @XStreamAlias("IDMONEDA")
	@Columna
	private String idmoneda;
        @XStreamAlias("IDCUENTA")
	@Columna
	private String idcuenta;
        @XStreamAlias("IDCCOSTO")
	@Columna
	private String idccosto;
        @XStreamAlias("CONCEPTO")
	@Columna
	private String concepto;
        @XStreamAlias("IDCLIENTE")
	@Columna
	private String idcliente;
        @XStreamAlias("IDREGIMEN")
	@Columna
	private String idregimen;
        @XStreamAlias("AFECTO")
	@Columna
	private Float afecto;
        @XStreamAlias("INAFECTO")
	@Columna
	private Float inafecto;
        @XStreamAlias("IDIMPUESTO")
	@Columna
	private String idimpuesto;
        @XStreamAlias("IMPUESTO")
	@Columna
	private Float impuesto;
        @XStreamAlias("TOTAL")
	@Columna
	private Float total;
        @XStreamAlias("ORDENREGISTRO")
	@Columna
	private Integer ordenregistro;
        @XStreamAlias("ESDETRACCION")
	@Columna
	private Float esdetraccion;
        @XStreamAlias("TIPODETRACCION")
	@Columna
	private String tipodetraccion;
        @XStreamAlias("TASADETRACCION")
	@Columna
	private Float tasadetraccion;
        @XStreamAlias("TCOSTO")
	@Columna
	private Float tcosto;
        
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
        @XStreamAlias("DAMBITO_SERVICIO")
	@Columna
	private String dambito_servicio;
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
        
        private Integer item;
        private String cuenta;
        private String tipodetraccion_descripcion;
        private Planctas selectCuenta;
        private Consumidor selectConsumidor;
        private Tipodetraccion selectTipodetraccion;
        private Documentos selectDocumentos;
        private List<Numemisor> lstNumemisor;
        /*DATOS ADICIONALES*/
        private String dhi_s;
        private String dhf_s;
        private String dhbase_s;
        private String dhadicional_s;
    /**
     * @return the idclieprov
     */
    public String getIdclieprov() {
        return idclieprov;
    }

    /**
     * @param idclieprov the idclieprov to set
     */
    public void setIdclieprov(String idclieprov) {
        this.idclieprov = idclieprov;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the fecha_operacion
     */
    public Date getFecha_operacion() {
        return fecha_operacion;
    }

    /**
     * @param fecha_operacion the fecha_operacion to set
     */
    public void setFecha_operacion(Date fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    /**
     * @return the vencimiento
     */
    public Date getVencimiento() {
        return vencimiento;
    }

    /**
     * @param vencimiento the vencimiento to set
     */
    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    /**
     * @return the idmoneda
     */
    public String getIdmoneda() {
        return idmoneda;
    }

    /**
     * @param idmoneda the idmoneda to set
     */
    public void setIdmoneda(String idmoneda) {
        this.idmoneda = idmoneda;
    }

    /**
     * @return the idcuenta
     */
    public String getIdcuenta() {
        return idcuenta;
    }

    /**
     * @param idcuenta the idcuenta to set
     */
    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    /**
     * @return the idccosto
     */
    public String getIdccosto() {
        return idccosto;
    }

    /**
     * @param idccosto the idccosto to set
     */
    public void setIdccosto(String idccosto) {
        this.idccosto = idccosto;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the idcliente
     */
    public String getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idregimen
     */
    public String getIdregimen() {
        return idregimen;
    }

    /**
     * @param idregimen the idregimen to set
     */
    public void setIdregimen(String idregimen) {
        this.idregimen = idregimen;
    }

    /**
     * @return the afecto
     */
    public Float getAfecto() {
        return afecto;
    }

    /**
     * @param afecto the afecto to set
     */
    public void setAfecto(Float afecto) {
        this.afecto = afecto;
    }

    /**
     * @return the inafecto
     */
    public Float getInafecto() {
        return inafecto;
    }

    /**
     * @param inafecto the inafecto to set
     */
    public void setInafecto(Float inafecto) {
        this.inafecto = inafecto;
    }

    /**
     * @return the idimpuesto
     */
    public String getIdimpuesto() {
        return idimpuesto;
    }

    /**
     * @param idimpuesto the idimpuesto to set
     */
    public void setIdimpuesto(String idimpuesto) {
        this.idimpuesto = idimpuesto;
    }

    /**
     * @return the impuesto
     */
    public Float getImpuesto() {
        return impuesto;
    }

    /**
     * @param impuesto the impuesto to set
     */
    public void setImpuesto(Float impuesto) {
        this.impuesto = impuesto;
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

    /**
     * @return the ordenregistro
     */
    public Integer getOrdenregistro() {
        return ordenregistro;
    }

    /**
     * @param ordenregistro the ordenregistro to set
     */
    public void setOrdenregistro(Integer ordenregistro) {
        this.ordenregistro = ordenregistro;
    }

    /**
     * @return the esdetraccion
     */
    public Float getEsdetraccion() {
        return esdetraccion;
    }

    /**
     * @param esdetraccion the esdetraccion to set
     */
    public void setEsdetraccion(Float esdetraccion) {
        this.esdetraccion = esdetraccion;
    }

    /**
     * @return the tipodetraccion
     */
    public String getTipodetraccion() {
        return tipodetraccion;
    }

    /**
     * @param tipodetraccion the tipodetraccion to set
     */
    public void setTipodetraccion(String tipodetraccion) {
        this.tipodetraccion = tipodetraccion;
    }

    /**
     * @return the tasadetraccion
     */
    public Float getTasadetraccion() {
        return tasadetraccion;
    }

    /**
     * @param tasadetraccion the tasadetraccion to set
     */
    public void setTasadetraccion(Float tasadetraccion) {
        this.tasadetraccion = tasadetraccion;
    }

    /**
     * @return the item
     */
    public Integer getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Integer item) {
        this.item = item;
    }

    /**
     * @return the selectCuenta
     */
    public Planctas getSelectCuenta() {
        return selectCuenta;
    }

    /**
     * @param selectCuenta the selectCuenta to set
     */
    public void setSelectCuenta(Planctas selectCuenta) {
        this.selectCuenta = selectCuenta;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the selectTipodetraccion
     */
    public Tipodetraccion getSelectTipodetraccion() {
        return selectTipodetraccion;
    }

    /**
     * @param selectTipodetraccion the selectTipodetraccion to set
     */
    public void setSelectTipodetraccion(Tipodetraccion selectTipodetraccion) {
        this.selectTipodetraccion = selectTipodetraccion;
    }

    /**
     * @return the tipodetraccion_descripcion
     */
    public String getTipodetraccion_descripcion() {
        return tipodetraccion_descripcion;
    }

    /**
     * @param tipodetraccion_descripcion the tipodetraccion_descripcion to set
     */
    public void setTipodetraccion_descripcion(String tipodetraccion_descripcion) {
        this.tipodetraccion_descripcion = tipodetraccion_descripcion;
    }

    /**
     * @return the tcosto
     */
    public Float getTcosto() {
        return tcosto;
    }

    /**
     * @param tcosto the tcosto to set
     */
    public void setTcosto(Float tcosto) {
        this.tcosto = tcosto;
    }

    /**
     * @return the selectDocumentos
     */
    public Documentos getSelectDocumentos() {
        return selectDocumentos;
    }

    /**
     * @param selectDocumentos the selectDocumentos to set
     */
    public void setSelectDocumentos(Documentos selectDocumentos) {
        this.selectDocumentos = selectDocumentos;
    }

    /**
     * @return the lstNumemisor
     */
    public List<Numemisor> getLstNumemisor() {
        return lstNumemisor;
    }

    /**
     * @param lstNumemisor the lstNumemisor to set
     */
    public void setLstNumemisor(List<Numemisor> lstNumemisor) {
        this.lstNumemisor = lstNumemisor;
    }

    /**
     * @return the didordenservicio
     */
    public String getDidordenservicio() {
        return didordenservicio;
    }

    /**
     * @param didordenservicio the didordenservicio to set
     */
    public void setDidordenservicio(String didordenservicio) {
        this.didordenservicio = didordenservicio;
    }

    /**
     * @return the dcliente
     */
    public String getDcliente() {
        return dcliente;
    }

    /**
     * @param dcliente the dcliente to set
     */
    public void setDcliente(String dcliente) {
        this.dcliente = dcliente;
    }

    /**
     * @return the dserie
     */
    public String getDserie() {
        return dserie;
    }

    /**
     * @param dserie the dserie to set
     */
    public void setDserie(String dserie) {
        this.dserie = dserie;
    }

    /**
     * @return the dnumero
     */
    public String getDnumero() {
        return dnumero;
    }

    /**
     * @param dnumero the dnumero to set
     */
    public void setDnumero(String dnumero) {
        this.dnumero = dnumero;
    }

    /**
     * @return the dambito_servicio
     */
    public String getDambito_servicio() {
        return dambito_servicio;
    }

    /**
     * @param dambito_servicio the dambito_servicio to set
     */
    public void setDambito_servicio(String dambito_servicio) {
        this.dambito_servicio = dambito_servicio;
    }

    /**
     * @return the dfecha_osc
     */
    public Date getDfecha_osc() {
        return dfecha_osc;
    }

    /**
     * @param dfecha_osc the dfecha_osc to set
     */
    public void setDfecha_osc(Date dfecha_osc) {
        this.dfecha_osc = dfecha_osc;
    }

    /**
     * @return the dfecharegistro
     */
    public Date getDfecharegistro() {
        return dfecharegistro;
    }

    /**
     * @param dfecharegistro the dfecharegistro to set
     */
    public void setDfecharegistro(Date dfecharegistro) {
        this.dfecharegistro = dfecharegistro;
    }

    /**
     * @return the dfechafinregistro
     */
    public Date getDfechafinregistro() {
        return dfechafinregistro;
    }

    /**
     * @param dfechafinregistro the dfechafinregistro to set
     */
    public void setDfechafinregistro(Date dfechafinregistro) {
        this.dfechafinregistro = dfechafinregistro;
    }

    /**
     * @return the dhi
     */
    public Float getDhi() {
        return dhi;
    }

    /**
     * @param dhi the dhi to set
     */
    public void setDhi(Float dhi) {
        this.dhi = dhi;
    }

    /**
     * @return the dhf
     */
    public Float getDhf() {
        return dhf;
    }

    /**
     * @param dhf the dhf to set
     */
    public void setDhf(Float dhf) {
        this.dhf = dhf;
    }

    /**
     * @return the dhs
     */
    public Float getDhs() {
        return dhs;
    }

    /**
     * @param dhs the dhs to set
     */
    public void setDhs(Float dhs) {
        this.dhs = dhs;
    }

    /**
     * @return the dhbase
     */
    public Float getDhbase() {
        return dhbase;
    }

    /**
     * @param dhbase the dhbase to set
     */
    public void setDhbase(Float dhbase) {
        this.dhbase = dhbase;
    }

    /**
     * @return the dhadicional
     */
    public Float getDhadicional() {
        return dhadicional;
    }

    /**
     * @param dhadicional the dhadicional to set
     */
    public void setDhadicional(Float dhadicional) {
        this.dhadicional = dhadicional;
    }

    /**
     * @return the dcosto_rh
     */
    public Float getDcosto_rh() {
        return dcosto_rh;
    }

    /**
     * @param dcosto_rh the dcosto_rh to set
     */
    public void setDcosto_rh(Float dcosto_rh) {
        this.dcosto_rh = dcosto_rh;
    }

    /**
     * @return the dhcosto_adicional
     */
    public Float getDhcosto_adicional() {
        return dhcosto_adicional;
    }

    /**
     * @param dhcosto_adicional the dhcosto_adicional to set
     */
    public void setDhcosto_adicional(Float dhcosto_adicional) {
        this.dhcosto_adicional = dhcosto_adicional;
    }

    /**
     * @return the dcosto_bono
     */
    public Float getDcosto_bono() {
        return dcosto_bono;
    }

    /**
     * @param dcosto_bono the dcosto_bono to set
     */
    public void setDcosto_bono(Float dcosto_bono) {
        this.dcosto_bono = dcosto_bono;
    }

    /**
     * @return the didcargo
     */
    public String getDidcargo() {
        return didcargo;
    }

    /**
     * @param didcargo the didcargo to set
     */
    public void setDidcargo(String didcargo) {
        this.didcargo = didcargo;
    }

    /**
     * @return the dcodigo_ec
     */
    public String getDcodigo_ec() {
        return dcodigo_ec;
    }

    /**
     * @param dcodigo_ec the dcodigo_ec to set
     */
    public void setDcodigo_ec(String dcodigo_ec) {
        this.dcodigo_ec = dcodigo_ec;
    }

    /**
     * @return the ditemrango_ec
     */
    public String getDitemrango_ec() {
        return ditemrango_ec;
    }

    /**
     * @param ditemrango_ec the ditemrango_ec to set
     */
    public void setDitemrango_ec(String ditemrango_ec) {
        this.ditemrango_ec = ditemrango_ec;
    }

    /**
     * @return the dcodoperaciones_ec
     */
    public String getDcodoperaciones_ec() {
        return dcodoperaciones_ec;
    }

    /**
     * @return the dnhoras_ec
     */
    public Float getDnhoras_ec() {
        return dnhoras_ec;
    }

    /**
     * @param dnhoras_ec the dnhoras_ec to set
     */
    public void setDnhoras_ec(Float dnhoras_ec) {
        this.dnhoras_ec = dnhoras_ec;
    }

    /**
     * @return the didruta_ec
     */
    public String getDidruta_ec() {
        return didruta_ec;
    }

    /**
     * @param didruta_ec the didruta_ec to set
     */
    public void setDidruta_ec(String didruta_ec) {
        this.didruta_ec = didruta_ec;
    }

    /**
     * @return the didruta
     */
    public String getDidruta() {
        return didruta;
    }

    /**
     * @param didruta the didruta to set
     */
    public void setDidruta(String didruta) {
        this.didruta = didruta;
    }

    /**
     * @return the diddocumento
     */
    public String getDiddocumento() {
        return diddocumento;
    }

    /**
     * @param diddocumento the diddocumento to set
     */
    public void setDiddocumento(String diddocumento) {
        this.diddocumento = diddocumento;
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
}