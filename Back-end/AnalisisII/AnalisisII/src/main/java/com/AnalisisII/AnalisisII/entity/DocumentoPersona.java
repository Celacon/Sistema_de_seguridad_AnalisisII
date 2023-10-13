package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "documento_persona")
public class DocumentoPersona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -349834081573789200L;

	
	@EmbeddedId
	private DocumentoPersonaId id;
	
	@Column(name = "nodocumento")
	private String noDocumento;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	

	public DocumentoPersonaId getId() {
		return id;
	}

	public void setId(DocumentoPersonaId id) {
		this.id = id;
	}

	public String getNoDocumento() {
		return noDocumento;
	}

	public void setNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
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
