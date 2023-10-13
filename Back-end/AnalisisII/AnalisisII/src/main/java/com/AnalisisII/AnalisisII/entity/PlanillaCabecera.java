package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "planilla_cabecera")
public class PlanillaCabecera implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3628778525126858040L;

	@EmbeddedId
	private PlanillaId idPlanillaCabecera;
	
	@Column(name = "totalingresos")
	private Double totalIngreso;
	
	@Column(name = "totaldescuentos")
	private Double totalDescuento;
	
	@Column(name = "salarioneto")
	private Double salarioNeto;
	
	
	@Column(name = "fechahoraprocesada")
	private Date fechaHoraProcesada;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	 @OneToMany
	    @JoinColumns({
	        @JoinColumn(name = "anio", referencedColumnName = "anio"),
	        @JoinColumn(name = "mes", referencedColumnName = "mes")
	    })
	    private List<PlanillaDetalle> listPlanillaDetalles;

	public PlanillaId getIdPlanillaCabecera() {
		return idPlanillaCabecera;
	}

	public void setIdPlanillaCabecera(PlanillaId idPlanillaCabecera) {
		this.idPlanillaCabecera = idPlanillaCabecera;
	}

	public Double getTotalIngreso() {
		return totalIngreso;
	}

	public void setTotalIngreso(Double totalIngreso) {
		this.totalIngreso = totalIngreso;
	}

	public Double getTotalDescuento() {
		return totalDescuento;
	}

	public void setTotalDescuento(Double totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	public Double getSalarioNeto() {
		return salarioNeto;
	}

	public void setSalarioNeto(Double salarioNeto) {
		this.salarioNeto = salarioNeto;
	}

	public Date getFechaHoraProcesada() {
		return fechaHoraProcesada;
	}

	public void setFechaHoraProcesada(Date fechaHoraProcesada) {
		this.fechaHoraProcesada = fechaHoraProcesada;
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

	public List<PlanillaDetalle> getListPlanillaDetalles() {
		return listPlanillaDetalles;
	}

	public void setListPlanillaDetalles(List<PlanillaDetalle> listPlanillaDetalles) {
		this.listPlanillaDetalles = listPlanillaDetalles;
	}
	
}
