package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Date;
@XStreamAlias("PERSONAL_SERVICIO")
@Tabla(nombre = "PERSONAL_SERVICIO")
public class Personal_servicio implements Serializable{
        private String idbasedatos;
        @XStreamAlias("IDEMPRESA")
	@ClavePrimaria
	@Columna
	private String idempresa;
        @XStreamAlias("IDORDENSERVICIO")
	@ClavePrimaria
	@Columna
	private String idordenservicio;
        @XStreamAlias("ITEM")
	@ClavePrimaria
	@Columna
	private String item;
        @XStreamAlias("ITEM2")
	@ClavePrimaria
	@Columna
	private String item2;
        @XStreamAlias("IDPERSONAL")
	@Columna
	private String idpersonal;
        @XStreamAlias("DNI")
	@Columna
	private String dni;
        @XStreamAlias("NOMBRES")
	@Columna
	private String nombres;
        @XStreamAlias("FECHAOPERACION")
	@Columna
	private Date fechaoperacion;
        @XStreamAlias("IDCARGO")
	@Columna
	private String idcargo;
        @XStreamAlias("FECHAFIN")
	@Columna
	private Date fechafin;
        @XStreamAlias("CHECKLIST")
	@Columna
	private String checklist;
        @XStreamAlias("IDVEHICULO")
	@Columna
	private String idvehiculo;
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
        @XStreamAlias("DESCRIPCION_VEHICULO")
        private String descripcion_vehiculo;
        @Columna
        @XStreamAlias("DESCRIPCION_CARGO")
        private String descripcion_cargo;  
        private String vehiculo;
        private String cargo;


	/* Sets & Gets */
	public void setIdempresa(String idempresa) {
		this.idempresa = idempresa;
	}

	public String getIdempresa() {
		return this.idempresa;
	}

	public void setIdordenservicio(String idordenservicio) {
		this.idordenservicio = idordenservicio;
	}

	public String getIdordenservicio() {
		return this.idordenservicio;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem2() {
		return this.item2;
	}

	public void setIdpersonal(String idpersonal) {
		this.idpersonal = idpersonal;
	}

	public String getIdpersonal() {
		return this.idpersonal;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setFechaoperacion(Date fechaoperacion) {
		this.fechaoperacion = fechaoperacion;
	}

	public Date getFechaoperacion() {
		return this.fechaoperacion;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getIdcargo() {
		return this.idcargo;
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
     * @return the fechafin
     */
    public Date getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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

    public String getDescripcion_vehiculo() {
        return descripcion_vehiculo;
    }

    public void setDescripcion_vehiculo(String descripcion_vehiculo) {
        this.descripcion_vehiculo = descripcion_vehiculo;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }
    
}