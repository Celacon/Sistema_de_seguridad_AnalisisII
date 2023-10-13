package com.AnalisisII.AnalisisII.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "role_opcion")
public class RoleOpcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3358499086808865998L;

	@EmbeddedId
	private RoleOpcionId id;
	
	@Column(name = "alta")
	private Integer alta;
	
	@Column(name = "baja")
	private Integer baja;
	
	@Column(name = "cambio")
	private Integer cambio;
	
	@Column(name = "imprimir")
	private Integer imprimir;
	
	@Column(name = "exportar")
	private Integer exportar;

	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	

	public RoleOpcionId getId() {
		return id;
	}

	public void setId(RoleOpcionId id) {
		this.id = id;
	}

	public Integer getAlta() {
		return alta;
	}

	public void setAlta(Integer alta) {
		this.alta = alta;
	}

	public Integer getBaja() {
		return baja;
	}

	public void setBaja(Integer baja) {
		this.baja = baja;
	}

	public Integer getCambio() {
		return cambio;
	}

	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}

	public Integer getImprimir() {
		return imprimir;
	}

	public void setImprimir(Integer imprimir) {
		this.imprimir = imprimir;
	}

	public Integer getExportar() {
		return exportar;
	}

	public void setExportar(Integer exportar) {
		this.exportar = exportar;
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
