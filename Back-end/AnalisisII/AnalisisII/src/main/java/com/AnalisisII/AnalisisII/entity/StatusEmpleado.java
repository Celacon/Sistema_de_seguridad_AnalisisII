package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status_empleado")
public class StatusEmpleado implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -520848593051412583L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idstatusempleado")
	private Integer idStatusEmpleado;
	
	@Column(name = "nombre")
	private String  nombre;
		
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idStatusEmpleado")
	private List<Empleado> listEmpleados;
	
	@OneToMany(mappedBy = "id.idStatusActual")
	private List<FlujoStatusEmpleado> listStatusActual;
	
	@OneToMany(mappedBy = "id.idStatusNuevo")
	private List<FlujoStatusEmpleado> listStatusNuevos;
	
	@OneToMany(mappedBy = "idStatusEmpleado")
	private List<PlanillaDetalle> listPlanillaDetalle;


	public Integer getIdStatusEmpleado() {
		return idStatusEmpleado;
	}

	public void setIdStatusEmpleado(Integer idStatusEmpleado) {
		this.idStatusEmpleado = idStatusEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<Empleado> getListEmpleados() {
		return listEmpleados;
	}

	public void setListEmpleados(List<Empleado> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}

	public List<FlujoStatusEmpleado> getListStatusActual() {
		return listStatusActual;
	}

	public void setListStatusActual(List<FlujoStatusEmpleado> listStatusActual) {
		this.listStatusActual = listStatusActual;
	}

	public List<FlujoStatusEmpleado> getListStatusNuevos() {
		return listStatusNuevos;
	}

	public void setListStatusNuevos(List<FlujoStatusEmpleado> listStatusNuevos) {
		this.listStatusNuevos = listStatusNuevos;
	}

	public List<PlanillaDetalle> getListPlanillaDetalle() {
		return listPlanillaDetalle;
	}

	public void setListPlanillaDetalle(List<PlanillaDetalle> listPlanillaDetalle) {
		this.listPlanillaDetalle = listPlanillaDetalle;
	}
	
	
	
	
	
}
