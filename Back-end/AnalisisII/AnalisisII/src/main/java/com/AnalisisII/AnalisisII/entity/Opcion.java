package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Basic;

@Entity
@Table(name = "opcion")
public class Opcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710773339395864169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idopcion")
	private Integer idOpcion;

	@Column(name = "idmenu")
	private Integer idMenu;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ordenmenu")
	private Integer ordenMenu;
	
	@Column(name = "pagina")
	private String pagina;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "id.idOpcion")
	private List<RoleOpcion> listRoleOpcion;

	public Integer getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
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

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
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

	public List<RoleOpcion> getListRoleOpcion() {
		return listRoleOpcion;
	}

	public void setListRoleOpcion(List<RoleOpcion> listRoleOpcion) {
		this.listRoleOpcion = listRoleOpcion;
	}
	
	
	

}
