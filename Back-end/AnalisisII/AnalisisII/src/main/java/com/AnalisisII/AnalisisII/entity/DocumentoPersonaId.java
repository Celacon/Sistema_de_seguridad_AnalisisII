package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentoPersonaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 360231935988119655L;

	@Column(name = "idtipodocumento")
	private Integer idTipoDocumento;
	
	@Column(name = "idpersona")
	private Integer idPersona;

	public DocumentoPersonaId() {
	
	}

	public DocumentoPersonaId(Integer idTipoDocumento, Integer idPersona) {
		this.idTipoDocumento = idTipoDocumento;
		this.idPersona = idPersona;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona, idTipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoPersonaId other = (DocumentoPersonaId) obj;
		return Objects.equals(idPersona, other.idPersona) && Objects.equals(idTipoDocumento, other.idTipoDocumento);
	}
	
	
	
	
	
	
}
