package com.AnalisisII.AnalisisII.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4085356561184677749L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	
	@Column(name = "idusuario")
	private String idUsuario;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "idstatususuario")
	private Integer idStatusUsuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "idgenero")
	private Integer idGenero;
	
	@Column(name = "ultimafechaingreso")
	private Date ultimaFechaIngreso;
	
	@Column(name = "intentosdeacceso")
	private Integer intentosDeAcceso;
	
	@Column(name = "sesionactual")
	private String sesionActual;
	
	@Column(name = "ultimafechacambiopassword")
	private Date ultimaFechaCambioPassword;

	@Column(name = "correoelectronico")
	private String correoElectrónico;
	
	@Column(name = "requierecambiarpassword")
	private Integer requiereCambiarPassword;
	
	@Lob
	@Column(name = "fotografia", columnDefinition = "MEDIUMBLOB")
	private byte[] fotografia;
	
	@Column(name = "telefonomovil")
	private String telefonoMovil;
	
	@Column(name = "idsucursal")
	private Integer idSucursal;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "usuariocreacion")
	private String usuarioCreacion;
	
	@Column(name = "fechamodificacion")
	private Date fechaModificacion;

	@Column(name = "usuariomodificacion")
	private String usuarioModificacion;
	
	@OneToMany(mappedBy = "id.idUsuario")
    private List<UsuarioRole> listUsuarioRole;
	
	@OneToMany(mappedBy = "idUsuario")
	private List<UsuarioPregunta> listUsuarioPregunta;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getIdStatusUsuario() {
		return idStatusUsuario;
	}

	public void setIdStatusUsuario(Integer idStatusUsuario) {
		this.idStatusUsuario = idStatusUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public Date getUltimaFechaIngreso() {
		return ultimaFechaIngreso;
	}

	public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
		this.ultimaFechaIngreso = ultimaFechaIngreso;
	}

	public Integer getIntentosDeAcceso() {
		return intentosDeAcceso;
	}

	public void setIntentosDeAcceso(Integer intentosDeAcceso) {
		this.intentosDeAcceso = intentosDeAcceso;
	}

	public String getSesionActual() {
		return sesionActual;
	}

	public void setSesionActual(String sesionActual) {
		this.sesionActual = sesionActual;
	}

	public Date getUltimaFechaCambioPassword() {
		return ultimaFechaCambioPassword;
	}

	public void setUltimaFechaCambioPassword(Date ultimaFechaCambioPassword) {
		this.ultimaFechaCambioPassword = ultimaFechaCambioPassword;
	}

	public String getCorreoElectrónico() {
		return correoElectrónico;
	}

	public void setCorreoElectrónico(String correoElectrónico) {
		this.correoElectrónico = correoElectrónico;
	}

	public Integer getRequiereCambiarPassword() {
		return requiereCambiarPassword;
	}

	public void setRequiereCambiarPassword(Integer requiereCambiarPassword) {
		this.requiereCambiarPassword = requiereCambiarPassword;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
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

	public List<UsuarioRole> getListUsuarioRole() {
		return listUsuarioRole;
	}

	public void setListUsuarioRole(List<UsuarioRole> listUsuarioRole) {
		this.listUsuarioRole = listUsuarioRole;
	}

	public List<UsuarioPregunta> getListUsuarioPregunta() {
		return listUsuarioPregunta;
	}

	public void setListUsuarioPregunta(List<UsuarioPregunta> listUsuarioPregunta) {
		this.listUsuarioPregunta = listUsuarioPregunta;
	}

	
	
	
}
