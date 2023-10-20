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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "inasistencia")
public class Inasistencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8764628041431389741L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idinasistencia")
	private Integer idInasistencia;

	@Column(name = "idempleado")
	private Integer idEmpleado;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechainicial")
	private Date fechaInicial;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechafinal")
	private Date fechaFinal;
	
	@Column(name = "motivoinasistencia")
	private String motivoInasistencia;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaprocesado")
	private Date fechaProcesado;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;


	public Integer getIdInasistencia() {
		return idInasistencia;
	}

	public void setIdInasistencia(Integer idInasistencia) {
		this.idInasistencia = idInasistencia;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getMotivoInasistencia() {
		return motivoInasistencia;
	}

	public void setMotivoInasistencia(String motivoInasistencia) {
		this.motivoInasistencia = motivoInasistencia;
	}

	public Date getFechaProcesado() {
		return fechaProcesado;
	}

	public void setFechaProcesado(Date fechaProcesado) {
		this.fechaProcesado = fechaProcesado;
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
