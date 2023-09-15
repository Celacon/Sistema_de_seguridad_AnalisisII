package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "bitacora_acceso")
public class BitacoraAcceso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1365149312645710314L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idbitacoraacceso")
	private Integer idBitacoraAcceso;
	
	@Column(name = "idusuario")
	private String idUsuario;
	
	@Column(name = "idtipoacceso")
	private Integer idTipoAcceso;
	
	@Column(name = "fechaacceso")
	private Date fechaAcceso;
	
	@Column(name = "httpuseragent")
	private String httpUserAgent;
	
	@Column(name = "direccionip")
	private String direccionIp;
	
	@Column(name = "accion")
	private String accion;

	@Column(name = "sistemaoperativo")
	private String sistemaOperativo;
	
	@Column(name = "dispositivo")
	private String dispositivo;
	
	@Column(name = "browser")
	private String browser;
	
	@Column(name = "sesion")
	private String sesion;

	public Integer getIdBitacoraAcceso() {
		return idBitacoraAcceso;
	}

	public void setIdBitacoraAcceso(Integer idBitacoraAcceso) {
		this.idBitacoraAcceso = idBitacoraAcceso;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdTipoAcceso() {
		return idTipoAcceso;
	}

	public void setIdTipoAcceso(Integer idTipoAcceso) {
		this.idTipoAcceso = idTipoAcceso;
	}

	public Date getFechaAcceso() {
		return fechaAcceso;
	}

	public void setFechaAcceso(Date fechaAcceso) {
		this.fechaAcceso = fechaAcceso;
	}

	public String getHttpUserAgent() {
		return httpUserAgent;
	}

	public void setHttpUserAgent(String httpUserAgent) {
		this.httpUserAgent = httpUserAgent;
	}

	

	public String getDireccionIp() {
		return direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	
}
