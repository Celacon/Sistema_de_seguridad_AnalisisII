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
@Table(name = "modulo")
public class Modulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2653477000758291780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idmodulo")
	private Integer idModulo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ordenmenu")
	private Integer ordenMenu;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idModulo")
	private List<Menu> listMenu;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrdenMenu() {
		return ordenMenu;
	}

	public void setOrdenMenu(Integer ordenMenu) {
		this.ordenMenu = ordenMenu;
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

	public List<Menu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
	}
	
	
	
	
}
