package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlanillaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1245863284302665558L;
	
	@Column(name = "anio")
	private Integer anio;

	@Column(name = "mes")
	private Integer mes;
	
	public PlanillaId() {
	}

	public PlanillaId(Integer anio, Integer mes) {
		this.anio = anio;
		this.mes = mes;
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

	@Override
	public int hashCode() {
		return Objects.hash(anio, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanillaId other = (PlanillaId) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(mes, other.mes);
	}
	
	
	
	
	
	
}
