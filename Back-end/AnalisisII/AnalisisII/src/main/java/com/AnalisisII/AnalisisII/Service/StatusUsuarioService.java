//StatusUsuario.java

package com.AnalisisII.AnalisisII.Service;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.StatusUsuarioRepository;
import com.AnalisisII.AnalisisII.entity.StatusUsuario;

@RestController
@RequestMapping("/status-usuario")
@CrossOrigin
public class StatusUsuarioService {
	@Autowired
	StatusUsuarioRepository statusUsuarioRepository;
	
	@GetMapping(path = "/buscar")
	public List<StatusUsuario> buscar(){
		return statusUsuarioRepository.findAll();
	}
@GetMapping ("/ConsultaStatusUsuario")
	public Optional <StatusUsuario> ConsultaStatusUsuario (@RequestParam Integer idStatuUsuario)
	{
		return statusUsuarioRepository.findById(idStatuUsuario);
	}
	@PostMapping (path="/InserteStatusUsuario")
	public StatusUsuario InserteStatusUsuario (@RequestBody StatusUsuario statusUsuario ) {
	statusUsuarioRepository.save(statusUsuario);
	return statusUsuario;
	} 
	@DeleteMapping("/EliminarEstatusUsuario/{idStatusUsuario}")
	  public ResponseEntity<Map<String, Object>> EliminarEstatusUsuario(
	      @PathVariable("idStatusUsuario") Integer idStatusUsuario){
	      

			
	      
	      try {
	          statusUsuarioRepository.deleteById(idStatusUsuario);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("error", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }

}
}
