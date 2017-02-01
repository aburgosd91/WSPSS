package nisira.com.pe.tomapedido.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@Tabla(nombre = "PARAMETRO")
@XStreamAlias("PARAMETRO")

public class Parametro {
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
	@SerializedName("idparametro") 
	@XStreamAlias("idparametro") 
	private String idparametro = "" ;
	@Columna
	@SerializedName("descripcion") 
	@XStreamAlias("descripcion") 
	private String descripcion = "" ;
	@Columna
	@SerializedName("tipoparametro") 
	@XStreamAlias("tipoparametro") 
	private String tipoparametro = "" ;
	@Columna
	@SerializedName("valor") 
	@XStreamAlias("valor") 
	private String valor = "" ;
	@Columna
	@SerializedName("valorxdefecto") 
	@XStreamAlias("valorxdefecto") 
	private String valorxdefecto = "" ;
	@Columna
	@SerializedName("estado") 
	@XStreamAlias("estado") 
	private Double estado = 0.00 ;



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

	public void setIdparametro(String idparametro) {
		this.idparametro = idparametro;
	}

	public String getIdparametro() {
		return this.idparametro;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setTipoparametro(String tipoparametro) {
		this.tipoparametro = tipoparametro;
	}

	public String getTipoparametro() {
		return this.tipoparametro;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValorxdefecto(String valorxdefecto) {
		this.valorxdefecto = valorxdefecto;
	}

	public String getValorxdefecto() {
		return this.valorxdefecto;
	}

	public void setEstado(Double estado) {
		this.estado = estado;
	}

	public Double getEstado() {
		return this.estado;
	}



	/* Sets & Gets FK*/

}