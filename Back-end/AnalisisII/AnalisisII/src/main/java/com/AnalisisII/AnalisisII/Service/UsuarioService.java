package com.AnalisisII.AnalisisII.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.EmpresaRepository;
import com.AnalisisII.AnalisisII.Repository.SucursalRepository;
import com.AnalisisII.AnalisisII.Repository.UsuarioRepository;
import com.AnalisisII.AnalisisII.entity.Empresa;
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
	    	usuarioRepository.save(usuario);
	    	
	        Map<String, String> successResponse = new HashMap<>();
	        successResponse.put("mensaje", "Usuario creado exitosamente");
	        return ResponseEntity.ok(successResponse);
	    }
	    
	    Map<String, String> errorResponse = new HashMap<>();
	    errorResponse.put("error", respuestaError);
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	
	
	
	
	
	public String validarPassword(Integer idSucursal, String password) {
			
		List<Sucursal> sucu = sucursalRepository.findByIdSucursal(idSucursal);
		Integer i = sucu.get(0).getIdEmpresa();
		
	    List<Empresa> em = empresaRepository.findByIdEmpresa(i);
		Empresa jsonObject = em.get(0);
		
		String  k= ValidarContrasenia.validar(password, jsonObject);
		
		return k;
		}
}
