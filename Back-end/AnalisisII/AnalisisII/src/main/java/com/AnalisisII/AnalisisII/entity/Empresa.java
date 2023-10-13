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
@Table(name = "empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1322596255296703187L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idempresa")
	private Integer idEmpresa;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "nit")
	private String nit;
	
	@Column(name = "passwordcantidadmayusculas")
	private Integer passswordCantidadMayusculas;
	
	@Column(name = "passwordcantidadminusculas")
	private Integer passwordCantidadMinusculas;
	
	@Column(name = "passwordcantidadcaracteresespeciales")
	private Integer passwordCantidadCaracteresEspeciales;
	
	@Column(name = "passwordcantidadcaducidaddias")
	private Integer passwordCantidadCaducidadDias;
	
	@Column(name = "passwordlargo")
	private Integer passwordLargo;
	
	@Column(name = "passwordintentosantesdebloquear")
	private Integer passwordIntentosAntesDeBloquear;
	
	@Column(name = "passwordcantidadnumeros")
	private Integer passwordCantidadNumeros;
	
	@Column(name = "passwordcantidadpreguntasvalidar")
	private Integer passwordCantidadPreguntasValidar;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "idEmpresa")
	private List<Sucursal> listSucursal;
	
	@OneToMany(mappedBy = "idEmpresa")
	private List<Departamento> listDepartamento;
	

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Integer getPassswordCantidadMayusculas() {
		return passswordCantidadMayusculas;
	}

	public void setPassswordCantidadMayusculas(Integer passswordCantidadMayusculas) {
		this.passswordCantidadMayusculas = passswordCantidadMayusculas;
	}

	public Integer getPasswordCantidadMinusculas() {
		return passwordCantidadMinusculas;
	}

	public void setPasswordCantidadMinusculas(Integer passwordCantidadMinusculas) {
		this.passwordCantidadMinusculas = passwordCantidadMinusculas;
	}

	public Integer getPasswordCantidadCaracteresEspeciales() {
		return passwordCantidadCaracteresEspeciales;
	}

	public void setPasswordCantidadCaracteresEspeciales(Integer passwordCantidadCaracteresEspeciales) {
		this.passwordCantidadCaracteresEspeciales = passwordCantidadCaracteresEspeciales;
	}

	public Integer getPasswordCantidadCaducidadDias() {
		return passwordCantidadCaducidadDias;
	}

	public void setPasswordCantidadCaducidadDias(Integer passwordCantidadCaducidadDias) {
		this.passwordCantidadCaducidadDias = passwordCantidadCaducidadDias;
	}

	public Integer getPasswordLargo() {
		return passwordLargo;
	}

	public void setPasswordLargo(Integer passwordLargo) {
		this.passwordLargo = passwordLargo;
	}

	public Integer getPasswordIntentosAntesDeBloquear() {
		return passwordIntentosAntesDeBloquear;
	}

	public void setPasswordIntentosAntesDeBloquear(Integer passwordIntentosAntesDeBloquear) {
		this.passwordIntentosAntesDeBloquear = passwordIntentosAntesDeBloquear;
	}

	public Integer getPasswordCantidadNumeros() {
		return passwordCantidadNumeros;
	}

	public void setPasswordCantidadNumeros(Integer passwordCantidadNumeros) {
		this.passwordCantidadNumeros = passwordCantidadNumeros;
	}

	public Integer getPasswordCantidadPreguntasValidar() {
		return passwordCantidadPreguntasValidar;
	}

	public void setPasswordCantidadPreguntasValidar(Integer passwordCantidadPreguntasValidar) {
		this.passwordCantidadPreguntasValidar = passwordCantidadPreguntasValidar;
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

	public List<Sucursal> getListSucursal() {
		return listSucursal;
	}

	public void setListSucursal(List<Sucursal> listSucursal) {
		this.listSucursal = listSucursal;
	}

	public List<Departamento> getListDepartamento() {
		return listDepartamento;
	}

	public void setListDepartamento(List<Departamento> listDepartamento) {
		this.listDepartamento = listDepartamento;
	}
	
	
	
	
}
