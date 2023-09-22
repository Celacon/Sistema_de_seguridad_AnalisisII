//UsuarioPreguntaService.java

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

import com.AnalisisII.AnalisisII.Repository.UsuarioPreguntaRepository;
import com.AnalisisII.AnalisisII.entity.UsuarioPregunta;

@RestController
@RequestMapping("/usuario-pregunta")
@CrossOrigin
public class UsuarioPreguntaService {
	
	@Autowired
	UsuarioPreguntaRepository usuarioPreguntaRepository;
	
	@GetMapping(path = "/buscar")
	public List<UsuarioPregunta> buscar(){
		return usuarioPreguntaRepository.findAll();
	}
@GetMapping ("/ConsultaUsuarioPregunta")
	public Optional <UsuarioPregunta> ConsultaUsuarioPregunta (@RequestParam Integer idPregunta)
	{
		return usuarioPreguntaRepository.findById(idPregunta);
	}
	@PostMapping (path="/InserteUsuarioPregunta")
	public UsuarioPregunta InserteUsuarioPregunta (@RequestBody UsuarioPregunta usuarioPregunta ) {
	usuarioPreguntaRepository.save(usuarioPregunta);
	return usuarioPregunta;
	} 
	@DeleteMapping("/EliminaUsuarioPregunta/{idUsuarioPregunta}")
	  public ResponseEntity<Map<String, Object>> EliminaTipoAcceso(
	      @PathVariable("idUsuarioPregunta") Integer idUsuarioPregunta){
	      

			
	      
	      try {
	          usuarioPreguntaRepository.deleteById(idUsuarioPregunta);
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
