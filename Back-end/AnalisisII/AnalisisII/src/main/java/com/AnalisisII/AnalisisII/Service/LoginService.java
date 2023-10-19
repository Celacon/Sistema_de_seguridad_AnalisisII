package com.AnalisisII.AnalisisII.Service;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.util.Date;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.AnalisisII.AnalisisII.Repository.EmpresaRepository;
import com.AnalisisII.AnalisisII.Repository.SucursalRepository;
import com.AnalisisII.AnalisisII.Repository.UsuarioRepository;
import com.AnalisisII.AnalisisII.entity.Empresa;

import com.AnalisisII.AnalisisII.entity.Sucursal;
import com.AnalisisII.AnalisisII.entity.Usuario;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	SucursalRepository sucursalRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	@PostMapping(path = "/logearse", produces = "application/json")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {
		String usuarioA = usuario.getIdUsuario();
		String sesion = usuario.getSesionActual();

		Map<String, Object> resultados = metodoConMultiplesValores(usuarioA);
		boolean usuarioExiste = (boolean) resultados.get("valorBooleano");
		String mensaje = (String) resultados.get("valorString");
		Usuario usuarioExistente = (Usuario) resultados.get("usuario");
		
		String userAgent = getUserAgent();
		System.out.println(userAgent);
	
		

		if (usuarioExiste) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("mensaje", mensaje);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
		Empresa empresa = buscarEmpresa(usuarioExistente.getIdSucursal());

		String encryptedPassword = MyCipher.encrypted(usuario.getPassword());

		Map<String, Object> resultadosContrasenia = validarContrasenia(usuario.getIdUsuario(), encryptedPassword);
		boolean contraseniaExiste = (boolean) resultadosContrasenia.get("valorBooleano");
		String mensaje2 = (String) resultadosContrasenia.get("valorString");
		Usuario user = (Usuario) resultadosContrasenia.get("usuario");

		if (contraseniaExiste) {
			bloquearUsuario(usuarioExistente, empresa.getPasswordCantidadCaducidadDias());
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("mensaje", mensaje2);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
		
		
		// ver de como ese dos no quede quemado 
		
		if (usuarioExistente.getIdStatusUsuario() == 2) {
			Map<String, Object> successResponse = new HashMap<>();
			successResponse.put("mensaje", "Su usuario actualmente esta bloqueado.");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(successResponse);
		}////////
		
		String sesionActual = user.getSesionActual();
		if (sesionActual!=null) {
			Map<String, Object> successResponse = new HashMap<>();
			successResponse.put("mensaje", "El usuario actualemente tiene una seciona activa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(successResponse);
		}
		
		
		boolean validarCaducidad= caducidadPassword(user.getUltimaFechaCambioPassword(),empresa.getPasswordCantidadCaducidadDias());
		
		if (validarCaducidad) {
			Map<String, Object> successResponse = new HashMap<>();
			LocalDate fechaHoy = LocalDate.now();
	    	Date date = Date.valueOf(fechaHoy);
	    	user.setSesionActual(sesion);
	    	
	    	user.setIntentosDeAcceso(0);
	  		user.setUltimaFechaIngreso(date);
			successResponse.put("usuario", user);
			successResponse.put("pagina", "actualizarPassword");
			return ResponseEntity.ok(successResponse);
			
		}
		
		if (user.getListUsuarioPregunta().size()<empresa.getPasswordCantidadPreguntasValidar()) {
			Map<String, Object> successResponse = new HashMap<>();
			LocalDate fechaHoy = LocalDate.now();
	    	Date date = Date.valueOf(fechaHoy);
	    	user.setSesionActual(sesion);
	    	user.setIntentosDeAcceso(0);
	  		user.setUltimaFechaIngreso(date);
			successResponse.put("usuario", user);
			successResponse.put("pagina", "agregar_preguntas");
			
			usuarioRepository.save(user);
			return ResponseEntity.ok(successResponse);
		}
		
		
		

		Map<String, Object> successResponse = new HashMap<>();
		LocalDate fechaHoy = LocalDate.now();
    	Date date = Date.valueOf(fechaHoy);
    	
    	user.setSesionActual(sesion);
    	user.setIntentosDeAcceso(0);
  		user.setUltimaFechaIngreso(date);
		successResponse.put("mensaje", "validacion exitosa");
		successResponse.put("usuario", user);
		successResponse.put("pagina", "home");
		
		usuarioRepository.save(user);
		return ResponseEntity.ok(successResponse);
	}
	
	
	
	
	

	public Map<String, Object> metodoConMultiplesValores(String idUsuario) {

		boolean boolResult = false;
		String strResult = "";
		Usuario usuario = null;
		List<Usuario> usua = usuarioRepository.findByIdUsuario(idUsuario);

		Map<String, Object> resultados = new HashMap<>();
		if (usua.isEmpty()) {
			boolResult = true;
			strResult = "El usuario no existe.";
			resultados.put("valorBooleano", boolResult);
			resultados.put("valorString", strResult);
			return resultados;
		} else {
			usuario = usua.get(0);
		}
		resultados.put("valorBooleano", boolResult);
		resultados.put("valorString", strResult);
		resultados.put("usuario", usuario);

		return resultados;
	}

	
	
	
	
	public Map<String, Object> validarContrasenia(String idUsuario, String password) {

		boolean boolResult = false;
		String strResult = "";

		List<Usuario> usua = usuarioRepository.findByIdUsuarioAndPassword(idUsuario, password);

		Map<String, Object> resultados = new HashMap<>();
		if (usua.isEmpty()) {
			boolResult = true;
			strResult = "La contraseña es invalida.";
			resultados.put("valorBooleano", boolResult);
			resultados.put("valorString", strResult);
			return resultados;
		}

		//System.out.println(boolResult + "21111111111");
		Usuario usuario = usua.get(0);
		resultados.put("valorBooleano", boolResult);
		resultados.put("valorString", strResult);
		resultados.put("usuario", usuario);
		return resultados;
	}
	
	
	
	

	public Empresa buscarEmpresa(Integer idSucursal) {
		List<Sucursal> sucursal = sucursalRepository.findByIdSucursal(idSucursal);
		List<Empresa> empresa = empresaRepository.findByIdEmpresa(sucursal.get(0).getIdEmpresa());
		return empresa.get(0);
	}
	
	

	public void bloquearUsuario(Usuario usuario, Integer cantIntentosPermitidos) {

		if (usuario.getIntentosDeAcceso() < cantIntentosPermitidos) {
			usuario.setIntentosDeAcceso(usuario.getIntentosDeAcceso() + 1);
			usuario.setIdUsuario(usuario.getIdUsuario());
			usuarioRepository.save(usuario);
		} else if (usuario.getIntentosDeAcceso() == cantIntentosPermitidos) {
			usuario.setIdStatusUsuario(2);
			usuario.setIdUsuario(usuario.getIdUsuario());
			usuarioRepository.save(usuario);
		}
	}
	
	public boolean caducidadPassword(Date ultimaFechaDeModificacion,Integer diasValidos) {
		boolean validar = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha2 =sdf.format(ultimaFechaDeModificacion);
		   LocalDate fecha = LocalDate.parse(fecha2);
	       fecha = fecha.plusDays(diasValidos);
	       
	        LocalDate fechaActual = LocalDate.now();
	        
	       
	        if (fecha.isEqual(fechaActual)||fechaActual.isAfter(fecha)) {
	            System.out.println("La fecha calculada es igual a la fecha actual.");
	            validar = true;
	        } 
		
		return validar;
	}
	
	
	@PostMapping(path = "/cerrar", produces = "application/json")
	
	public ResponseEntity<Map<String, String>> cerrar(@RequestBody Usuario usuario) {    
		
		List<Usuario> usu = usuarioRepository.findByIdUsuario(usuario.getIdUsuario());
		Usuario usu2 = usu.get(0);
		
		usu2.setSesionActual(null);
		
		usuarioRepository.save(usu2);
	   
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("mensaje", "Cierre de sesion exitosa");
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	
	   private String getUserAgent() {
	        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

	        if (requestAttributes instanceof ServletRequestAttributes) {
	            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
	            String userAgent = request.getHeader("User-Agent");
	            return userAgent;
	        } else {
	            return "User-Agent not available";
	        }
	    }
	
	


}
