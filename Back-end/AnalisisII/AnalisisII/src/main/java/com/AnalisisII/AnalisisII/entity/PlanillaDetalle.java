package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planilla_detalle")
public class PlanillaDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7240213278957727663L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idplanilladetalle")
	private Integer idPlanillaDetalle;
	
	@Column(name = "anio")
	private Integer anio;
	
	@Column(name = "mes")
	private Integer mes;
	
	@Column(name = "idempleado")
	private Integer idEmpleado;
	
	@Column(name = "fechacontratacion")
	private Date fechaContratacion;
	
	@Column(name = "idpuesto")
	private Integer idPuesto;
	
	@Column(name = "idstatusempleado")
	private Integer idStatusEmpleado;
	
	@Column(name = "ingresosueldobase")
	private Double ingresoSueldoBase;
	
	@Column(name = "ingresobonificaciondecreto")
	private Double ingresoBonificacionDecreto;
	
	@Column(name = "ingresootrosingresos")
	private Double ingresoOtrosIngresos;
	
	@Column(name = "descuentoigss")
	private Double descuentoIgss;
	
	@Column(name = "descuentoisr")
	private Double descuentoIsr;
	
	@Column(name = "descuentoinasistencias")
	private Double descuentoInasistencias;
	
	@Column(name = "salarioneto")
	private Double salarioNeto;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	public Integer getIdPlanillaDetalle() {
		return idPlanillaDetalle;
	}

	public void setIdPlanillaDetalle(Integer idPlanillaDetalle) {
		this.idPlanillaDetalle = idPlanillaDetalle;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public Double getIngresoBonificacionDecreto() {
		return ingresoBonificacionDecreto;
	}

	public void setIngresoBonificacionDecreto(Double ingresoBonificacionDecreto) {
		this.ingresoBonificacionDecreto = ingresoBonificacionDecreto;
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

	public Double getSalarioNeto() {
		return salarioNeto;
	}

	public void setSalarioNeto(Double salarioNeto) {
		this.salarioNeto = salarioNeto;
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

	
	
	

}
