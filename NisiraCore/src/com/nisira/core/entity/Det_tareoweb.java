package com.nisira.core.entity;

import com.google.gson.annotations.SerializedName;
import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.util.Date;
import com.nisira.annotation.RelacionTabla;
import com.nisira.annotation.CampoRelacionado;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.List;

@Tabla(nombre = "DET_TAREOWEB")
@XStreamAlias("DET_TAREOWEB")
public class Det_tareoweb implements Serializable {
        private int item;
        @SerializedName("idempresa") 
	@XStreamAlias("IDEMPRESA") 
	@ClavePrimaria
	@Columna
	private String idempresa;
        @SerializedName("idcabtareoweb") 
	@XStreamAlias("IDCABTAREOWEB") 
	@ClavePrimaria
	@Columna
	private String idcabtareoweb;
        @SerializedName("idordenservicio") 
	@XStreamAlias("IDORDENSERVICIO") 
	@ClavePrimaria
	@Columna
	private String idordenservicio;
        @SerializedName("iddocumento") 
	@XStreamAlias("IDDOCUMENTO") 
	@ClavePrimaria
	@Columna
	private String iddocumento;
        @SerializedName("serie") 
	@XStreamAlias("SERIE") 
	@ClavePrimaria
	@Columna
	private String serie;
        @SerializedName("numero") 
	@XStreamAlias("NUMERO") 
	@ClavePrimaria
	@Columna
	private String numero;
        @SerializedName("ruc") 
	@XStreamAlias("RUC") 
	@ClavePrimaria
	@Columna
	private String ruc;
        @SerializedName("razon") 
	@XStreamAlias("RAZON") 
	@Columna
	private String razon;
        @SerializedName("idcargo") 
	@XStreamAlias("IDCARGO") 
	@ClavePrimaria
	@Columna
	private String idcargo;
        @SerializedName("idpersonal") 
	@XStreamAlias("IDPERSONAL") 
	@ClavePrimaria
	@Columna
	private String idpersonal;
        @SerializedName("item_dordenservicio") 
	@XStreamAlias("ITEM_DORDENSERVICIO") 
	@ClavePrimaria
	@Columna
	private String item_dordenservicio;
        @SerializedName("item2_personalservicio") 
	@XStreamAlias("ITEM2_PERSONALSERVICIO") 
	@ClavePrimaria
	@Columna
	private String item2_personalservicio;
        @SerializedName("item_dpersonalservicio") 
	@XStreamAlias("ITEM_DPERSONALSERVICIO") 
	@ClavePrimaria
	@Columna
	private String item_dpersonalservicio;
        @SerializedName("hora_req") 
	@XStreamAlias("HORA_REQ") 
	@Columna
	private Float hora_req;
        @SerializedName("hora_llegada") 
	@XStreamAlias("HORA_LLEGADA") 
	@Columna
	private Float hora_llegada;
        @SerializedName("hora_inicio_serv") 
	@XStreamAlias("HORA_INICIO_SERV") 
	@Columna
	private Float hora_inicio_serv;
        @SerializedName("hora_fin_serv") 
	@XStreamAlias("HORA_FIN_SERV") 
	@Columna
	private Float hora_fin_serv;
        @SerializedName("hora_liberacion") 
	@XStreamAlias("HORA_LIBERACION") 
	@Columna
	private Float hora_liberacion;
	@XStreamAlias("FECHAREGISTRO") 
	@Columna
	private Date fecharegistro; 
	@XStreamAlias("FECHAFINREGISTRO") 
	@Columna
	private Date fechafinregistro;
        
	@CampoRelacionado({@RelacionTabla(campo="IDEMPRESA",campoRelacionado="IDEMPRESA"), @RelacionTabla(campo="IDCABTAREOWEB",campoRelacionado="IDCABTAREOWEB")})
	private Cabtareoweb cabtareoweb_fk_det_tareoweb_cabtareoweb;
        
        @XStreamAlias("FHORA_REQ")
        @Columna
        private Date  fhora_req;
        @XStreamAlias("FHORA_LLEGADA")
        @Columna
        private Date  fhora_llegada;
        @XStreamAlias("FHORA_INICIO")
        @Columna
        private Date  fhora_inicio;
        @XStreamAlias("FHORA_FIN")
        @Columna
        private Date  fhora_fin;
        @XStreamAlias("FHORA_LIBERACION")
        @Columna
        private Date  fhora_liberacion;
        @XStreamAlias("IDVEHICULO")
        @Columna
        private String idvehiculo;
        @XStreamAlias("CHECKLIST")
        @Columna
        private String checklist;
        @XStreamAlias("ENCRYPT_PROGRAMACION")
        @Columna
        private String encrypt_programacion;
        @XStreamAlias("CODASISTENCIA")
        @Columna
        private String codasistencia;
        @XStreamAlias("GLOSA")
        @Columna
        private String glosa;
        @XStreamAlias("HORA_RC")
        @Columna
        private Float hora_rc;
        @Columna
        @XStreamAlias("NROCONTENEDOR")
	private String nrocontenedor;
	@Columna
        @XStreamAlias("NROPRECINTO")
	private String nroprecinto;
	@Columna
        @XStreamAlias("NRO_OSERVICIO")
	private String nro_oservicio;
        @Columna
        @XStreamAlias("PLACA_CLIENTE")
	private String placa_cliente;
        @Columna
        @XStreamAlias("CONDUCTOR_CLIENTE")
	private String conductor_cliente;
        @Columna
        @XStreamAlias("BREVETE_CLIENTE")
	private String brevete_cliente;
        @Columna
        @XStreamAlias("IDRUTA_EC")
        private String idruta_ec;
        @Columna
        @XStreamAlias("IDREFERENCIA")
        private String idreferencia;
        @Columna
        @XStreamAlias("ITEMREFERENCIA")
        private String itemreferencia;
        @Columna
        @XStreamAlias("IDCONCEPTOTAREO")
        private String idconceptotareo;
        private String conceptotareo;
        private Date fecha_osc;
        private String vehiculo;
        private String cargo;
        private String dni;
        private String personal;
        private String idservicio;
        private String servicio;
        private boolean habilitado;
        private String Shora_req;
        private String Shora_llegada;
        private String Shora_inicio;
        private String Shora_fin;
	private String Shora_liberacion;
        private String conductor_rpt;
        private String precinto_rpt;
        private String placa_cliente_rpt;
        private String asistencia;
        private boolean exige_glosa;
        private String color;
        private List<Object[]> tareo;
        private String codoperaciones;
        private String rutaservicios;
        
        /*adicional*/
        @XStreamOmitField
        private Clieprov selectPersonal;
        @XStreamOmitField
        private Consumidor selectConsumidor;
        private String ciddocumento;
        private String cserie;
        private String cnumero;
        private Date cfecha;
        private String cidresponsable;
        private String cresponsable;
        private String cidusuario;
        private String cusuario;
        private String cidestado;
        private String cestado;
        /* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdcabtareoweb(String idcabtareoweb) {
		this.idcabtareoweb = idcabtareoweb;
	}

	public String getIdcabtareoweb() {
		return this.idcabtareoweb;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
	}

	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getIddocumento() {
		return this.iddocumento;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getRazon() {
		return this.razon;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setItem_dordenservicio(String item_dordenservicio) {
		this.item_dordenservicio = item_dordenservicio;
	}

	public String getItem_dordenservicio() {
		return this.item_dordenservicio;
	}

	public void setItem2_personalservicio(String item2_personalservicio) {
		this.item2_personalservicio = item2_personalservicio;
	}

	public String getItem2_personalservicio() {
		return this.item2_personalservicio;
	}

	public void setItem_dpersonalservicio(String item_dpersonalservicio) {
		this.item_dpersonalservicio = item_dpersonalservicio;
	}

	public String getItem_dpersonalservicio() {
		return this.item_dpersonalservicio;
	}

	public void setHora_req(Float hora_req) {
		this.hora_req = hora_req;
	}

	public Float getHora_req() {
		return this.hora_req;
	}

	public void setHora_llegada(Float hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public Float getHora_llegada() {
		return this.hora_llegada;
	}

	public void setHora_inicio_serv(Float hora_inicio_serv) {
		this.hora_inicio_serv = hora_inicio_serv;
	}

	public Float getHora_inicio_serv() {
		return this.hora_inicio_serv;
	}

	public void setHora_fin_serv(Float hora_fin_serv) {
		this.hora_fin_serv = hora_fin_serv;
	}

	public Float getHora_fin_serv() {
		return this.hora_fin_serv;
	}

	public void setHora_liberacion(Float hora_liberacion) {
		this.hora_liberacion = hora_liberacion;
	}

	public Float getHora_liberacion() {
		return this.hora_liberacion;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Date getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFechafinregistro(Date fechafinregistro) {
		this.fechafinregistro = fechafinregistro;
	}

	public Date getFechafinregistro() {
		return this.fechafinregistro;
	}



	/* Sets & Gets FK*/
	public void setCabtareoweb_fk_det_tareoweb_cabtareoweb(Cabtareoweb cabtareoweb_fk_det_tareoweb_cabtareoweb) {
		this.cabtareoweb_fk_det_tareoweb_cabtareoweb = cabtareoweb_fk_det_tareoweb_cabtareoweb;
	}

	public Cabtareoweb getCabtareoweb_fk_det_tareoweb_cabtareoweb() {
		return this.cabtareoweb_fk_det_tareoweb_cabtareoweb;
	}

    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
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
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the personal
     */
    public String getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(String personal) {
        this.personal = personal;
    }

    /**
     * @return the fhora_req
     */
    public Date getFhora_req() {
        return fhora_req;
    }

    /**
     * @param fhora_req the fhora_req to set
     */
    public void setFhora_req(Date fhora_req) {
        this.fhora_req = fhora_req;
    }

    /**
     * @return the fhora_llegada
     */
    public Date getFhora_llegada() {
        return fhora_llegada;
    }

    /**
     * @param fhora_llegada the fhora_llegada to set
     */
    public void setFhora_llegada(Date fhora_llegada) {
        this.fhora_llegada = fhora_llegada;
    }

    /**
     * @return the fhora_inicio
     */
    public Date getFhora_inicio() {
        return fhora_inicio;
    }

    /**
     * @param fhora_inicio the fhora_inicio to set
     */
    public void setFhora_inicio(Date fhora_inicio) {
        this.fhora_inicio = fhora_inicio;
    }

    /**
     * @return the fhora_fin
     */
    public Date getFhora_fin() {
        return fhora_fin;
    }

    /**
     * @param fhora_fin the fhora_fin to set
     */
    public void setFhora_fin(Date fhora_fin) {
        this.fhora_fin = fhora_fin;
    }

    /**
     * @return the fhora_liberacion
     */
    public Date getFhora_liberacion() {
        return fhora_liberacion;
    }

    /**
     * @param fhora_liberacion the fhora_liberacion to set
     */
    public void setFhora_liberacion(Date fhora_liberacion) {
        this.fhora_liberacion = fhora_liberacion;
    }

    /**
     * @return the Shora_fin
     */
    public String getShora_fin() {
        return Shora_fin;
    }

    /**
     * @param Shora_fin the Shora_fin to set
     */
    public void setShora_fin(String Shora_fin) {
        this.Shora_fin = Shora_fin;
    }

    /**
     * @return the Shora_req
     */
    public String getShora_req() {
        return Shora_req;
    }

    /**
     * @param Shora_req the Shora_req to set
     */
    public void setShora_req(String Shora_req) {
        this.Shora_req = Shora_req;
    }

    /**
     * @return the Shora_llegada
     */
    public String getShora_llegada() {
        return Shora_llegada;
    }

    /**
     * @param Shora_llegada the Shora_llegada to set
     */
    public void setShora_llegada(String Shora_llegada) {
        this.Shora_llegada = Shora_llegada;
    }

    /**
     * @return the Shora_inicio
     */
    public String getShora_inicio() {
        return Shora_inicio;
    }

    /**
     * @param Shora_inicio the Shora_inicio to set
     */
    public void setShora_inicio(String Shora_inicio) {
        this.Shora_inicio = Shora_inicio;
    }

    /**
     * @return the Shora_liberacion
     */
    public String getShora_liberacion() {
        return Shora_liberacion;
    }

    /**
     * @param Shora_liberacion the Shora_liberacion to set
     */
    public void setShora_liberacion(String Shora_liberacion) {
        this.Shora_liberacion = Shora_liberacion;
    }

    /**
     * @return the idvehiculo
     */
    public String getIdvehiculo() {
        return idvehiculo;
    }

    /**
     * @param idvehiculo the idvehiculo to set
     */
    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    /**
     * @return the checklist
     */
    public String getChecklist() {
        return checklist;
    }

    /**
     * @param checklist the checklist to set
     */
    public void setChecklist(String checklist) {
        this.checklist = checklist;
    }

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the idservicio
     */
    public String getIdservicio() {
        return idservicio;
    }

    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    /**
     * @return the servicio
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitado to set
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     * @return the encrypt_programacion
     */
    public String getEncrypt_programacion() {
        return encrypt_programacion;
    }

    /**
     * @param encrypt_programacion the encrypt_programacion to set
     */
    public void setEncrypt_programacion(String encrypt_programacion) {
        this.encrypt_programacion = encrypt_programacion;
    }

    /**
     * @return the conductor_rpt
     */
    public String getConductor_rpt() {
        return conductor_rpt;
    }

    /**
     * @param conductor_rpt the conductor_rpt to set
     */
    public void setConductor_rpt(String conductor_rpt) {
        this.conductor_rpt = conductor_rpt;
    }

    /**
     * @return the precinto_rpt
     */
    public String getPrecinto_rpt() {
        return precinto_rpt;
    }

    /**
     * @param precinto_rpt the precinto_rpt to set
     */
    public void setPrecinto_rpt(String precinto_rpt) {
        this.precinto_rpt = precinto_rpt;
    }

    /**
     * @return the placa_cliente_rpt
     */
    public String getPlaca_cliente_rpt() {
        return placa_cliente_rpt;
    }

    /**
     * @param placa_cliente_rpt the placa_cliente_rpt to set
     */
    public void setPlaca_cliente_rpt(String placa_cliente_rpt) {
        this.placa_cliente_rpt = placa_cliente_rpt;
    }

    /**
     * @return the codasistencia
     */
    public String getCodasistencia() {
        return codasistencia;
    }

    /**
     * @param codasistencia the codasistencia to set
     */
    public void setCodasistencia(String codasistencia) {
        this.codasistencia = codasistencia;
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
     * @return the asistencia
     */
    public String getAsistencia() {
        return asistencia;
    }

    /**
     * @param asistencia the asistencia to set
     */
    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    /**
     * @return the tareo
     */
    public List<Object[]> getTareo() {
        return tareo;
    }

    /**
     * @param tareo the tareo to set
     */
    public void setTareo(List<Object[]> tareo) {
        this.tareo = tareo;
    }
    /**
     * @return the exige_glosa
     */
    public boolean isExige_glosa() {
        return exige_glosa;
    }

    /**
     * @param exige_glosa the exige_glosa to set
     */
    public void setExige_glosa(boolean exige_glosa) {
        this.exige_glosa = exige_glosa;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
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
     * @return the fecha_osc
     */
    public Date getFecha_osc() {
        return fecha_osc;
    }

    /**
     * @param fecha_osc the fecha_osc to set
     */
    public void setFecha_osc(Date fecha_osc) {
        this.fecha_osc = fecha_osc;
    }

    /**
     * @return the hora_rc
     */
    public Float getHora_rc() {
        return hora_rc;
    }

    /**
     * @param hora_rc the hora_rc to set
     */
    public void setHora_rc(Float hora_rc) {
        this.hora_rc = hora_rc;
    }

    /**
     * @return the nrocontenedor
     */
    public String getNrocontenedor() {
        return nrocontenedor;
    }

    /**
     * @param nrocontenedor the nrocontenedor to set
     */
    public void setNrocontenedor(String nrocontenedor) {
        this.nrocontenedor = nrocontenedor;
    }

    /**
     * @return the nroprecinto
     */
    public String getNroprecinto() {
        return nroprecinto;
    }

    /**
     * @param nroprecinto the nroprecinto to set
     */
    public void setNroprecinto(String nroprecinto) {
        this.nroprecinto = nroprecinto;
    }

    /**
     * @return the nro_oservicio
     */
    public String getNro_oservicio() {
        return nro_oservicio;
    }

    /**
     * @param nro_oservicio the nro_oservicio to set
     */
    public void setNro_oservicio(String nro_oservicio) {
        this.nro_oservicio = nro_oservicio;
    }

    /**
     * @return the placa_cliente
     */
    public String getPlaca_cliente() {
        return placa_cliente;
    }

    /**
     * @param placa_cliente the placa_cliente to set
     */
    public void setPlaca_cliente(String placa_cliente) {
        this.placa_cliente = placa_cliente;
    }

    /**
     * @return the conductor_cliente
     */
    public String getConductor_cliente() {
        return conductor_cliente;
    }

    /**
     * @param conductor_cliente the conductor_cliente to set
     */
    public void setConductor_cliente(String conductor_cliente) {
        this.conductor_cliente = conductor_cliente;
    }

    /**
     * @return the brevete_cliente
     */
    public String getBrevete_cliente() {
        return brevete_cliente;
    }

    /**
     * @param brevete_cliente the brevete_cliente to set
     */
    public void setBrevete_cliente(String brevete_cliente) {
        this.brevete_cliente = brevete_cliente;
    }

    /**
     * @return the codoperaciones
     */
    public String getCodoperaciones() {
        return codoperaciones;
    }

    /**
     * @param codoperaciones the codoperaciones to set
     */
    public void setCodoperaciones(String codoperaciones) {
        this.codoperaciones = codoperaciones;
    }

    /**
     * @return the rutaservicios
     */
    public String getRutaservicios() {
        return rutaservicios;
    }

    /**
     * @param rutaservicios the rutaservicios to set
     */
    public void setRutaservicios(String rutaservicios) {
        this.rutaservicios = rutaservicios;
    }

    /**
     * @return the idruta_rc
     */
    public String getIdruta_ec() {
        return idruta_ec;
    }

    /**
     * @param idruta_rc the idruta_rc to set
     */
    public void setIdruta_ec(String idruta_ec) {
        this.idruta_ec = idruta_ec;
    }

    /**
     * @return the idreferencia
     */
    public String getIdreferencia() {
        return idreferencia;
    }

    /**
     * @param idreferencia the idreferencia to set
     */
    public void setIdreferencia(String idreferencia) {
        this.idreferencia = idreferencia;
    }

    /**
     * @return the itemreferencia
     */
    public String getItemreferencia() {
        return itemreferencia;
    }

    /**
     * @param itemreferencia the itemreferencia to set
     */
    public void setItemreferencia(String itemreferencia) {
        this.itemreferencia = itemreferencia;
    }

    /**
     * @return the idconceptotareo
     */
    public String getIdconceptotareo() {
        return idconceptotareo;
    }

    /**
     * @param idconceptotareo the idconceptotareo to set
     */
    public void setIdconceptotareo(String idconceptotareo) {
        this.idconceptotareo = idconceptotareo;
    }

    /**
     * @return the conceptotareo
     */
    public String getConceptotareo() {
        return conceptotareo;
    }

    /**
     * @param conceptotareo the conceptotareo to set
     */
    public void setConceptotareo(String conceptotareo) {
        this.conceptotareo = conceptotareo;
    }

    /**
     * @return the ciddocumento
     */
    public String getCiddocumento() {
        return ciddocumento;
    }

    /**
     * @param ciddocumento the ciddocumento to set
     */
    public void setCiddocumento(String ciddocumento) {
        this.ciddocumento = ciddocumento;
    }

    /**
     * @return the cserie
     */
    public String getCserie() {
        return cserie;
    }

    /**
     * @param cserie the cserie to set
     */
    public void setCserie(String cserie) {
        this.cserie = cserie;
    }

    /**
     * @return the cnumero
     */
    public String getCnumero() {
        return cnumero;
    }

    /**
     * @param cnumero the cnumero to set
     */
    public void setCnumero(String cnumero) {
        this.cnumero = cnumero;
    }

    /**
     * @return the cfecha
     */
    public Date getCfecha() {
        return cfecha;
    }

    /**
     * @param cfecha the cfecha to set
     */
    public void setCfecha(Date cfecha) {
        this.cfecha = cfecha;
    }

    /**
     * @return the cidresponsable
     */
    public String getCidresponsable() {
        return cidresponsable;
    }

    /**
     * @param cidresponsable the cidresponsable to set
     */
    public void setCidresponsable(String cidresponsable) {
        this.cidresponsable = cidresponsable;
    }

    /**
     * @return the cresponsable
     */
    public String getCresponsable() {
        return cresponsable;
    }

    /**
     * @param cresponsable the cresponsable to set
     */
    public void setCresponsable(String cresponsable) {
        this.cresponsable = cresponsable;
    }

    /**
     * @return the cidusuario
     */
    public String getCidusuario() {
        return cidusuario;
    }

    /**
     * @param cidusuario the cidusuario to set
     */
    public void setCidusuario(String cidusuario) {
        this.cidusuario = cidusuario;
    }

    /**
     * @return the cusuario
     */
    public String getCusuario() {
        return cusuario;
    }

    /**
     * @param cusuario the cusuario to set
     */
    public void setCusuario(String cusuario) {
        this.cusuario = cusuario;
    }

    /**
     * @return the cidestado
     */
    public String getCidestado() {
        return cidestado;
    }

    /**
     * @param cidestado the cidestado to set
     */
    public void setCidestado(String cidestado) {
        this.cidestado = cidestado;
    }

    /**
     * @return the cestado
     */
    public String getCestado() {
        return cestado;
    }

    /**
     * @param cestado the cestado to set
     */
    public void setCestado(String cestado) {
        this.cestado = cestado;
    }
}