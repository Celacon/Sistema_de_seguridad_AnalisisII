package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FlujoStatusEmpleadoId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5047908083247957398L;

	@Column(name = "idstatusactual")
	private Integer idStatusActual;
	
	@Column(name = "idstatusnuevo")
	private Integer idStatusNuevo;

	public FlujoStatusEmpleadoId() {
	}

	public FlujoStatusEmpleadoId(Integer idStatusActual, Integer idStatusNuevo) {
		this.idStatusActual = idStatusActual;
		this.idStatusNuevo = idStatusNuevo;
	}

	public Integer getIdStatusActual() {
		return idStatusActual;
	}

	public void setIdStatusActual(Integer idStatusActual) {
		this.idStatusActual = idStatusActual;
	}

	public Integer getIdStatusNuevo() {
		return idStatusNuevo;
	}

	public void setIdStatusNuevo(Integer idStatusNuevo) {
		this.idStatusNuevo = idStatusNuevo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStatusActual, idStatusNuevo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlujoStatusEmpleadoId other = (FlujoStatusEmpleadoId) obj;
		return Objects.equals(idStatusActual, other.idStatusActual)
				&& Objects.equals(idStatusNuevo, other.idStatusNuevo);
	}
	
	
	
	
	
}
