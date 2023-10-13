package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

@Entity
@Table(name = "usuario_role")
public class UsuarioRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5854024797867344608L;

	@EmbeddedId
	private UsuarioRoleId id;

	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	

	public UsuarioRoleId getId() {
		return id;
	}

	public void setId(UsuarioRoleId id) {
		this.id = id;
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
