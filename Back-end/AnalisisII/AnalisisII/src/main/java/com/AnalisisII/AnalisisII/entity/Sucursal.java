package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2864088576847245280L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idsucursal")
	private Integer idSucursal;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "idempresa")
	private Integer idEmpresa;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idSucursal")
	private List<Usuario> listUsuarios;
	
	@OneToMany(mappedBy = "idSucursal")
	private List<Empleado> listEmpleados;

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public List<Empleado> getListEmpleados() {
		return listEmpleados;
	}

	public void setListEmpleados(List<Empleado> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}
	
	
	
	
	
}
