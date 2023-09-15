package com.AnalisisII.AnalisisII.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.UsuarioRepository;
import com.AnalisisII.AnalisisII.entity.Usuario;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@PostMapping(path = "/logearse", produces = "application/json")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Usuario usuario) {    
	   String usuarioA = usuario.getIdUsuario();
	  
	   
	   
	   Map<String, Object> resultados = metodoConMultiplesValores(usuarioA);
	   boolean usuarioExiste = (boolean) resultados.get("valorBooleano");
	   String mensaje = (String) resultados.get("valorString");

	   
	    if (usuarioExiste) {
		    Map<String, Object> errorResponse = new HashMap<>();
		    errorResponse.put("error", mensaje);
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	       
	    
	    String encryptedPassword = MyCipher.encrypted(usuario.getPassword());
	    
	    Map<String, Object> resultadosContrasenia = validarContrasenia(usuario.getIdUsuario(),encryptedPassword);
    	boolean contraseniaExiste = (boolean) resultadosContrasenia.get("valorBooleano");
    	String mensaje2 = (String) resultadosContrasenia.get("valorString");
    	Usuario user = (Usuario) resultadosContrasenia.get("usuario");
    	   

   	    if (contraseniaExiste) {
   		    Map<String, Object> errorResponse = new HashMap<>();
   		    errorResponse.put("error", mensaje2);
   		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);   
   	    }
    	
        
   	    Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("mensaje", "validacion exitosa");
        successResponse.put("usuario", user);
        return ResponseEntity.ok(successResponse);
	}

	
	
	public Map<String, Object> metodoConMultiplesValores(String idUsuario) {
		
	    boolean boolResult = false;
	    String strResult = "";
	    
	    List<Usuario> usua = usuarioRepository.findByIdUsuario(idUsuario);
	    
	    Map<String, Object> resultados = new HashMap<>();
	    if(usua.isEmpty()) {
	    	boolResult=true;
	    strResult = "El usuario no existe.";
	    resultados.put("valorBooleano", boolResult);
	    resultados.put("valorString", strResult);
	    return resultados;
	    }
	    	 resultados.put("valorBooleano", boolResult);
	 	    resultados.put("valorString", strResult);
	    
	    
	    return resultados;
	}
	
	

	public Map<String, Object> validarContrasenia(String idUsuario, String password) {
		
	    boolean boolResult = false;
	    String strResult = "";
	    
	    List<Usuario> usua = usuarioRepository.findByIdUsuarioAndPassword(idUsuario,password);
	    
	    Map<String, Object> resultados = new HashMap<>();
	    if(usua.isEmpty()) {
	    	boolResult=true;
	    strResult = "La contraseña es invalida.";
	    resultados.put("valorBooleano", boolResult);
	    resultados.put("valorString", strResult);
	    return resultados;
	    }
	    
	    System.out.println(boolResult+"21111111111");
	    Usuario usuario = usua.get(0);
	    	 resultados.put("valorBooleano", boolResult);
	 	    resultados.put("valorString", strResult);
	 	   resultados.put("usuario", usuario);
	    
	    
	    return resultados;
	}
	
}













