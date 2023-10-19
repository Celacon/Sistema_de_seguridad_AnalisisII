package com.AnalisisII.AnalisisII.entity;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Vplanilla {

	
	private Integer idPlanillaDetalle;
	
	
	private Integer anio;
	
	
	private Integer mes;
	
	
	private Integer idEmpleado;
	
	private Integer idPersona;
	
	private String nombre;
	
	private String apellido;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaContratacion;
	
	
	private Integer idPuesto;
	
	private String puesto;

	private Integer idStatusEmpleado;
	private String status;

	private Double ingresoSueldoBase;
	
	
	private Double ingresoBonificacionDecreto;
	

	private Double ingresoOtrosIngresos;
	
	
	private Double descuentoIgss;
	
	
	private Double descuentoIsr;
	
	
	private Double descuentoInasistencias;
	
	
	private Double salarioNeto;


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


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	
}
