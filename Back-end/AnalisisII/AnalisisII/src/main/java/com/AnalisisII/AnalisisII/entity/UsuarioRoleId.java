package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioRoleId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 78339654995120792L;

	@Column(name = "idusuario")
	private String idUsuario;
	
	
	@Column(name = "idrole")
	private Integer idRole;

	public UsuarioRoleId() {
		
	}
	
	public UsuarioRoleId(String idUsuario, Integer idRole) {
		this.idUsuario = idUsuario;
		this.idRole = idRole;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRole, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRoleId other = (UsuarioRoleId) obj;
		return Objects.equals(idRole, other.idRole) && Objects.equals(idUsuario, other.idUsuario);
	}
	
	

	
}
