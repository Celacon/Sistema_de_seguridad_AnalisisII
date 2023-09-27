package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.EmpresaRepository;
import com.AnalisisII.AnalisisII.Repository.SucursalRepository;
import com.AnalisisII.AnalisisII.Repository.UsuarioRepository;
import com.AnalisisII.AnalisisII.entity.Empresa;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;
import com.AnalisisII.AnalisisII.entity.Sucursal;
import com.AnalisisII.AnalisisII.entity.Usuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	SucursalRepository sucursalRepository;
	
	@Autowired
	
	EmpresaRepository empresaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Usuario> buscar(){
		return usuarioRepository.findAll();
	}


	
	@PostMapping(path = "/guardar2", produces = "application/json")
	public ResponseEntity<Map<String, String>> guardar2(@RequestBody Usuario usuario) {    
	    String respuestaError = validarPassword(usuario.getIdSucursal(), usuario.getPassword());
	    
	    if (respuestaError.trim().isEmpty()) {
	    	String encryptedPassword = MyCipher.encrypted(usuario.getPassword());
	    	usuario.setPassword(encryptedPassword);
	    	LocalDate fechaHoy = LocalDate.now();
		    
	    	  Date date = Date.valueOf(fechaHoy);
	    	  usuario.setFechaCreacion(date);
	    	usuarioRepository.save(usuario);
	    	
	        Map<String, String> successResponse = new HashMap<>();
	        successResponse.put("mensaje", "Usuario creado exitosamente");
	        return ResponseEntity.ok(successResponse);
	    }
	    
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("mensaje", respuestaError);
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	
	
	@PostMapping(path = "/actualizarUsuario", produces = "application/json")
	public ResponseEntity<Map<String, String>> actualizarUsuario(@RequestBody Usuario usuario) {    
	    String respuestaError = validarPassword(usuario.getIdSucursal(), usuario.getPassword());
	    
	    if (respuestaError.trim().isEmpty()) {
	    	String encryptedPassword = MyCipher.encrypted(usuario.getPassword());
	    	usuario.setPassword(encryptedPassword);
	    	LocalDate fechaHoy = LocalDate.now();
		    
	    	  Date date = Date.valueOf(fechaHoy);
	    	  usuario.setFechaModificacion(date);
	    	usuarioRepository.save(usuario);
	    	
	        Map<String, String> successResponse = new HashMap<>();
	        successResponse.put("mensaje", "Usuario actualizado exitosamente");
	        return ResponseEntity.ok(successResponse);
	    }
	    
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("mensaje", respuestaError);
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	
	
	
	
	@PostMapping(path = "/actualizarPassword", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizarPassword(@RequestBody Usuario usuario) { 
		String password = MyCipher.encrypted(usuario.getPassword());

		Map<String, Object> resultados = validarUsuarioPassword(usuario.getIdUsuario(),password);
		boolean usuarioPasswordValido = (boolean) resultados.get("valorBooleano");
		String mensaje = (String) resultados.get("valorString");
		Usuario usuarioExistente = (Usuario) resultados.get("usuario");
		
		if (!usuarioPasswordValido) {
			
			
			if(usuario.getNewPassword().equals(usuario.getConfirmarNewPassword())) {
				
			
				String respuestaError = validarPassword(usuarioExistente.getIdSucursal(), usuario.getNewPassword());
			    
			    if (respuestaError.trim().isEmpty()) {
			    	
			    	String encryptedPassword = MyCipher.encrypted(usuario.getNewPassword());
			    	LocalDate fechaHoy = LocalDate.now();
			    
			    	  Date date = Date.valueOf(fechaHoy);
			    
			        
			    	usuarioExistente.setPassword(encryptedPassword);
			    	usuarioExistente.setUltimaFechaCambioPassword(date);
			    	usuarioExistente.setUsuarioModificacion(usuario.getUsuarioModificacion());
			    	
			    	usuarioRepository.save(usuarioExistente);
			    	
			        Map<String, Object> successResponse = new HashMap<>();
			        successResponse.put("mensaje", "Su contraseña ha sido actualizada");
			        successResponse.put("usuario",usuarioExistente);
			        successResponse.put("pagina", "home");
			        return ResponseEntity.ok(successResponse);
			    }
			    
			    Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", respuestaError);
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
				
			}else {
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "Compruebe que la contraseña nueva y la confirmacion sean iguales ");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
				
			}
			
		
			
		}
		
		
		Map<String, Object> errorResponse = new HashMap<>();
	    errorResponse.put("mensaje", mensaje);
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		
		
		
		
		
	    
	}
	
	
	  @DeleteMapping("/eliminar/{idUsuario}")
	  public ResponseEntity<Map<String, Object>> eliminarUsuario(
	      @PathVariable("idUsuario") String idUsuario) {

	    
	      
	      try {
	          usuarioRepository.deleteById(idUsuario);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }
	  }
	  

	
	
		
	public String validarPassword(Integer idSucursal, String password) {
			
		List<Sucursal> sucu = sucursalRepository.findByIdSucursal(idSucursal);
		Integer i = sucu.get(0).getIdEmpresa();
		
	    List<Empresa> em = empresaRepository.findByIdEmpresa(i);
		Empresa jsonObject = em.get(0);
		
		String  k= ValidarContrasenia.validar(password, jsonObject);
		
		return k;
		}
	

	public Map<String, Object> validarUsuarioPassword(String idUsuario, String password) {

		boolean boolResult = false;
		String strResult = "";

		List<Usuario> usua = usuarioRepository.findByIdUsuarioAndPassword(idUsuario, password);

		Map<String, Object> resultados = new HashMap<>();
		if (usua.isEmpty()) {
			boolResult = true;
			System.out.println(boolResult + "21111111111");
			strResult = "La contraseña anterior es invalida.";
			resultados.put("valorBooleano", boolResult);
			resultados.put("valorString", strResult);
			return resultados;
		}

		
		Usuario usuario = usua.get(0);
		resultados.put("valorBooleano", boolResult);
		resultados.put("valorString", strResult);
		resultados.put("usuario", usuario);
		return resultados;
	}

}
