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
@Table(name = "empleado")
public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9210593411263963669L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idempleado")
	private Integer idEmpleado;

	@Column(name = "idpersona")
	private Integer idPersona;
	
	@Column(name = "idsucursal")
	private Integer idSucursal;
	
	@Column(name = "fechacontratacion")
	private Date fechaContratacion;
	
	@Column(name = "idpuesto")
	private Integer idPuesto;
	
	@Column(name = "idstatusempleado")
	private Integer idStatusEmpleado;
	
	@Column(name = "ingresosueldobase")
	private Double ingresoSueldoBase;
	
	@Column(name = "ingresobonificaciondecreto")
	private Double ingresobonificacionDecreto;
	
	@Column(name = "ingresootrosingresos")
	private Double ingresoOtrosIngresos;
	
	@Column(name = "descuentoigss")
	private Double descuentoIgss;
	
	@Column(name = "descuentoisr")
	private Double descuentoIsr;
	
	@Column(name = "descuentoinasistencias")
	private Double descuentoInasistencias;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idEmpleado")
    private List<Inasistencia> listInasistencias;
	
	@OneToMany(mappedBy = "idEmpleado")
    private List<CuentaBancariaEmpleado> listCuentasBancarias;
	
	@OneToMany(mappedBy = "idEmpleado")
    private List<PlanillaDetalle> listPlanillaDetalle;
	

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Integer getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}

	public Integer getIdStatusEmpleado() {
		return idStatusEmpleado;
	}

	public void setIdStatusEmpleado(Integer idStatusEmpleado) {
		this.idStatusEmpleado = idStatusEmpleado;
	}

	public Double getIngresoSueldoBase() {
		return ingresoSueldoBase;
	}

	public void setIngresoSueldoBase(Double ingresoSueldoBase) {
		this.ingresoSueldoBase = ingresoSueldoBase;
	}

	public Double getIngresobonificacionDecreto() {
		return ingresobonificacionDecreto;
	}

	public void setIngresobonificacionDecreto(Double ingresobonificacionDecreto) {
		this.ingresobonificacionDecreto = ingresobonificacionDecreto;
	}

	public Double getIngresoOtrosIngresos() {
		return ingresoOtrosIngresos;
	}

	public void setIngresoOtrosIngresos(Double ingresoOtrosIngresos) {
		this.ingresoOtrosIngresos = ingresoOtrosIngresos;
	}

	public Double getDescuentoIgss() {
		return descuentoIgss;
	}

	public void setDescuentoIgss(Double descuentoIgss) {
		this.descuentoIgss = descuentoIgss;
	}

	public Double getDescuentoIsr() {
		return descuentoIsr;
	}

	public void setDescuentoIsr(Double descuentoIsr) {
		this.descuentoIsr = descuentoIsr;
	}

	public Double getDescuentoInasistencias() {
		return descuentoInasistencias;
	}

	public void setDescuentoInasistencias(Double descuentoInasistencias) {
		this.descuentoInasistencias = descuentoInasistencias;
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

	public List<Inasistencia> getListInasistencias() {
		return listInasistencias;
	}

	public void setListInasistencias(List<Inasistencia> listInasistencias) {
		this.listInasistencias = listInasistencias;
	}

	public List<CuentaBancariaEmpleado> getListCuentasBancarias() {
		return listCuentasBancarias;
	}

	public void setListCuentasBancarias(List<CuentaBancariaEmpleado> listCuentasBancarias) {
		this.listCuentasBancarias = listCuentasBancarias;
	}

	public List<PlanillaDetalle> getListPlanillaDetalle() {
		return listPlanillaDetalle;
	}

	public void setListPlanillaDetalle(List<PlanillaDetalle> listPlanillaDetalle) {
		this.listPlanillaDetalle = listPlanillaDetalle;
	}

	
	
	
	
	
	
}
