package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import java.io.Serializable;
import java.util.Date;

@Tabla(nombre = "ALMACENES")
public class Almacenes implements Serializable{
        private String idbasedatos;
	@ClavePrimaria
	@Columna
	private String idempresa;
	@ClavePrimaria
	@Columna
	private String idsucursal;
	@ClavePrimaria
	@Columna
	private String idalmacen;
	@Columna
	private String direccion;
	@Columna
	private String descripcion;
	@Columna
	private String idresponsable;
	@Columna
	private String modulo;
	@Columna
	private Float esproduccion;
	@Columna
	private Float esfertilizacion;
	@Columna
	private Float capacidad;
	@Columna
	private Float vol_agua;
	@Columna
	private String direccion_numero;
	@Columna
	private String direccion_interior;
	@Columna
	private String direccion_zona;
	@Columna
	private String departamento;
	@Columna
	private String provincia;
	@Columna
	private String distrito;
	@Columna
	private Float seveenreportes;
	@Columna
	private String idtanque;
	@Columna
	private Float estado;
	@Columna
	private String sincroniza;
	@Columna
	private Date fechacreacion;
	@Columna
	private String idriego;
	@Columna
	private String idtipoestablecimiento;
	@Columna
	private Float esventa;
	@Columna
	private Float esdistribucionv;
	@Columna
	private String idoperacioni;
	@Columna
	private String idoperacions;
	@Columna
	private String idoperacionr;
	@Columna
	private String via;
	@Columna
	private String dscvia;
	@Columna
	private String idtipoalmacen;
	@Columna
	private Float es_taller;
	@Columna
	private String idalmacen_spring;
	@Columna
	private Float latitud;
	@Columna
	private Float longitud;
	@Columna
	private String nombre_corto;
	@Columna
	private Float para_mrp;
	@Columna
	private String link_taller;
	@Columna
	private String codigo_equiv;
	@Columna
	private Float controlar_ubicaciones;



	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdsucursal(String idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdalmacen(String idalmacen) {
		this.idalmacen = idalmacen;
	}

	public String getIdalmacen() {
		return this.idalmacen;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setIdresponsable(String idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getIdresponsable() {
		return this.idresponsable;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setEsproduccion(Float esproduccion) {
		this.esproduccion = esproduccion;
	}

	public Float getEsproduccion() {
		return this.esproduccion;
	}

	public void setEsfertilizacion(Float esfertilizacion) {
		this.esfertilizacion = esfertilizacion;
	}

	public Float getEsfertilizacion() {
		return this.esfertilizacion;
	}

	public void setCapacidad(Float capacidad) {
		this.capacidad = capacidad;
	}

	public Float getCapacidad() {
		return this.capacidad;
	}

	public void setVol_agua(Float vol_agua) {
		this.vol_agua = vol_agua;
	}

	public Float getVol_agua() {
		return this.vol_agua;
	}

	public void setDireccion_numero(String direccion_numero) {
		this.direccion_numero = direccion_numero;
	}

	public String getDireccion_numero() {
		return this.direccion_numero;
	}

	public void setDireccion_interior(String direccion_interior) {
		this.direccion_interior = direccion_interior;
	}

	public String getDireccion_interior() {
		return this.direccion_interior;
	}

	public void setDireccion_zona(String direccion_zona) {
		this.direccion_zona = direccion_zona;
	}

	public String getDireccion_zona() {
		return this.direccion_zona;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setSeveenreportes(Float seveenreportes) {
		this.seveenreportes = seveenreportes;
	}

	public Float getSeveenreportes() {
		return this.seveenreportes;
	}

	public void setIdtanque(String idtanque) {
		this.idtanque = idtanque;
	}

	public String getIdtanque() {
		return this.idtanque;
	}

	public void setEstado(Float estado) {
		this.estado = estado;
	}

	public Float getEstado() {
		return this.estado;
	}

	public void setSincroniza(String sincroniza) {
		this.sincroniza = sincroniza;
	}

	public String getSincroniza() {
		return this.sincroniza;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setIdriego(String idriego) {
		this.idriego = idriego;
	}

	public String getIdriego() {
		return this.idriego;
	}

	public void setIdtipoestablecimiento(String idtipoestablecimiento) {
		this.idtipoestablecimiento = idtipoestablecimiento;
	}

	public String getIdtipoestablecimiento() {
		return this.idtipoestablecimiento;
	}

	public void setEsventa(Float esventa) {
		this.esventa = esventa;
	}

	public Float getEsventa() {
		return this.esventa;
	}

	public void setEsdistribucionv(Float esdistribucionv) {
		this.esdistribucionv = esdistribucionv;
	}

	public Float getEsdistribucionv() {
		return this.esdistribucionv;
	}

	public void setIdoperacioni(String idoperacioni) {
		this.idoperacioni = idoperacioni;
	}

	public String getIdoperacioni() {
		return this.idoperacioni;
	}

	public void setIdoperacions(String idoperacions) {
		this.idoperacions = idoperacions;
	}

	public String getIdoperacions() {
		return this.idoperacions;
	}

	public void setIdoperacionr(String idoperacionr) {
		this.idoperacionr = idoperacionr;
	}

	public String getIdoperacionr() {
		return this.idoperacionr;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getVia() {
		return this.via;
	}

	public void setDscvia(String dscvia) {
		this.dscvia = dscvia;
	}

	public String getDscvia() {
		return this.dscvia;
	}

	public void setIdtipoalmacen(String idtipoalmacen) {
		this.idtipoalmacen = idtipoalmacen;
	}

	public String getIdtipoalmacen() {
		return this.idtipoalmacen;
	}

	public void setEs_taller(Float es_taller) {
		this.es_taller = es_taller;
	}

	public Float getEs_taller() {
		return this.es_taller;
	}

	public void setIdalmacen_spring(String idalmacen_spring) {
		this.idalmacen_spring = idalmacen_spring;
	}

	public String getIdalmacen_spring() {
		return this.idalmacen_spring;
	}

	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}

	public Float getLatitud() {
		return this.latitud;
	}

	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}

	public Float getLongitud() {
		return this.longitud;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public String getNombre_corto() {
		return this.nombre_corto;
	}

	public void setPara_mrp(Float para_mrp) {
		this.para_mrp = para_mrp;
	}

	public Float getPara_mrp() {
		return this.para_mrp;
	}

	public void setLink_taller(String link_taller) {
		this.link_taller = link_taller;
	}

	public String getLink_taller() {
		return this.link_taller;
	}

	public void setCodigo_equiv(String codigo_equiv) {
		this.codigo_equiv = codigo_equiv;
	}

	public String getCodigo_equiv() {
		return this.codigo_equiv;
	}

	public void setControlar_ubicaciones(Float controlar_ubicaciones) {
		this.controlar_ubicaciones = controlar_ubicaciones;
	}

	public Float getControlar_ubicaciones() {
		return this.controlar_ubicaciones;
	}



	/* Sets & Gets FK*/

    /**
     * @return the idbasedatos
     */
    public String getIdbasedatos() {
        return idbasedatos;
    }

    /**
     * @param idbasedatos the idbasedatos to set
     */
    public void setIdbasedatos(String idbasedatos) {
        this.idbasedatos = idbasedatos;
    }

}