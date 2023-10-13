package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoleOpcionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4082990363631443398L;

	@Column(name = "idrole")
	private Integer idRole;
		
	@Column(name = "idopcion")
	private Integer idOpcion;

	public RoleOpcionId() {
	}
	
	public RoleOpcionId(Integer idRole, Integer idOpcion) {
		this.idRole = idRole;
		this.idOpcion = idOpcion;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOpcion, idRole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleOpcionId other = (RoleOpcionId) obj;
		return Objects.equals(idOpcion, other.idOpcion) && Objects.equals(idRole, other.idRole);
	}
}
