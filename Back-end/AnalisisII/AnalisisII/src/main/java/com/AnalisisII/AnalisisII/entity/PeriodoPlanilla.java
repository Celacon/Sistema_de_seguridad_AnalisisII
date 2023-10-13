package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "periodo_planilla")
public class PeriodoPlanilla implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1423280311001459681L;

	@EmbeddedId
	private PlanillaId id;
	
	@Column(name = "fechainicio")
	private Date fechaInicio;
	
	@Column(name = "fechafin")
	private Date fechaFin;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToOne
	 @JoinColumns({
        @JoinColumn(name = "Anio", referencedColumnName = "anio"),
        @JoinColumn(name = "Mes", referencedColumnName = "mes")
    })
    private PlanillaCabecera planillaCabecera;

	public PlanillaId getId() {
		return id;
	}

	public void setId(PlanillaId id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	public PlanillaCabecera getPlanillaCabecera() {
		return planillaCabecera;
	}

	public void setPlanillaCabecera(PlanillaCabecera planillaCabecera) {
		this.planillaCabecera = planillaCabecera;
	}
	
	
	
}
