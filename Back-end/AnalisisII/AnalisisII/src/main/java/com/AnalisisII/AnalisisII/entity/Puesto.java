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
@Table(name = "puesto")
public class Puesto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1857171948193853383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idpuesto")
	private Integer idPuesto;
		
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "iddepartamento")
	private Integer idDepartamento;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idPuesto")
	private List<Empleado> listEmpleados;
	
	@OneToMany(mappedBy = "idPuesto")
	private List<PlanillaDetalle> listPlanillaDetalle;

	public Integer getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
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

	public List<PlanillaDetalle> getListPlanillaDetalle() {
		return listPlanillaDetalle;
	}

	public void setListPlanillaDetalle(List<PlanillaDetalle> listPlanillaDetalle) {
		this.listPlanillaDetalle = listPlanillaDetalle;
	}
	
	
	
	
	
}
