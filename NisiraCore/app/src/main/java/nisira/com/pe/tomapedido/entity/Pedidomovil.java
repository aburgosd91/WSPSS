package nisira.com.pe.tomapedido.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;

@Tabla(nombre = "PEDIDOMOVIL")
@XStreamAlias("PEDIDOMOVIL")

public class Pedidomovil {
	@ClavePrimaria
	@Columna
	@SerializedName("idbasedatos") 
	@XStreamAlias("idbasedatos") 
	private String idbasedatos = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idempresa") 
	@XStreamAlias("idempresa") 
	private String idempresa = "" ;
	@ClavePrimaria
	@Columna
	@SerializedName("idpedido") 
	@XStreamAlias("idpedido") 
	private String idpedido = "" ;
	@Columna
	@SerializedName("fecha") 
	@XStreamAlias("fecha") 
	private Date fecha;
	@Columna
	@SerializedName("hora") 
	@XStreamAlias("hora") 
	private String hora = "" ;
	@Columna
	@SerializedName("idvendedor") 
	@XStreamAlias("idvendedor") 
	private String idvendedor = "" ;
	@Columna
	@SerializedName("descvendedor") 
	@XStreamAlias("descvendedor") 
	private String descvendedor = "" ;
	@Columna
	@SerializedName("idclieprov") 
	@XStreamAlias("idclieprov") 
	private String idclieprov = "" ;
	@Columna
	@SerializedName("descclieprov") 
	@XStreamAlias("descclieprov") 
	private String descclieprov = "" ;
	@Columna
	@SerializedName("serie") 
	@XStreamAlias("serie") 
	private String serie = "" ;
	@Columna
	@SerializedName("numero") 
	@XStreamAlias("numero") 
	private String numero = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("estado") 
	private String estado = "" ;



	/* Sets & Gets */
	public void setIdbasedatos(String idbasedatos) {
		this.idbasedatos = idbasedatos;
	}

	public String getIdbasedatos() {
		return this.idbasedatos;
	}

	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getIdpedido() {
		return this.idpedido;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHora() {
		return this.hora;
	}

	public void setIdvendedor(String idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getIdvendedor() {
		return this.idvendedor;
	}

	public void setDescvendedor(String descvendedor) {
		this.descvendedor = descvendedor;
	}

	public String getDescvendedor() {
		return this.descvendedor;
	}

	public void setIdclieprov(String idclieprov) {
		this.idclieprov = idclieprov;
	}

	public String getIdclieprov() {
		return this.idclieprov;
	}

	public void setDescclieprov(String descclieprov) {
		this.descclieprov = descclieprov;
	}

	public String getDescclieprov() {
		return this.descclieprov;
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

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}