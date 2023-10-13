package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="status_usuario")
public class StatusUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3598481711696898106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idstatususuario")
	private Integer idStatusUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idStatusUsuario")
	private List<Usuario> listUsuarios;

	public Integer getIdStatusUsuario() {
		return idStatusUsuario;
	}

	public void setIdStatusUsuario(Integer idStatusUsuario) {
		this.idStatusUsuario = idStatusUsuario;
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

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	
	
	
}
