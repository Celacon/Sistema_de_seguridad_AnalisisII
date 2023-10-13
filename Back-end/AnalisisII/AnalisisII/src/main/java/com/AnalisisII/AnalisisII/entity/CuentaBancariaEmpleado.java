package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria_empleado")
public class CuentaBancariaEmpleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7007981853312985020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idcuentabancaria")
	private Integer idCuentaBancaria;
	
	@Column(name = "idempleado")
	private Integer idEmpleado;
	
	@Column(name = "idbanco")
	private Integer idBanco;
	
	@Column(name = "numerodecuenta")
	private String numeroDeCuenta;
	
	@Column(name = "activa")
	private char activa;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;

	public Integer getIdCuentaBancaria() {
		return idCuentaBancaria;
	}

	public void setIdCuentaBancaria(Integer idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public char getActiva() {
		return activa;
	}

	public void setActiva(char activa) {
		this.activa = activa;
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
