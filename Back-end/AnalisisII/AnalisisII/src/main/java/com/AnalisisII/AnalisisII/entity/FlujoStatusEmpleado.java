package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flujo_status_empleado")
public class FlujoStatusEmpleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229600682084527476L;


	@EmbeddedId
	private FlujoStatusEmpleadoId id;
	
	@Column(name = "nombreevento")
	private String nombreEvento;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	public FlujoStatusEmpleadoId getId() {
		return id;
	}

	public void setId(FlujoStatusEmpleadoId id) {
		this.id = id;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
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
