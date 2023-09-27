

package com.AnalisisII.AnalisisII.Service;


import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.AnalisisII.AnalisisII.Repository.GeneroRepository;

import com.AnalisisII.AnalisisII.entity.Genero;

@RestController
@RequestMapping("/genero")
@CrossOrigin
public class GeneroService {
	@Autowired
	GeneroRepository generoRepository;
	
	@GetMapping(path = "/buscar")
	public List<Genero> buscar(){
		return generoRepository.findAll();
	}
	@GetMapping ("/ConsultaGenero")
	public Optional <Genero> ConsultaGenero (@RequestParam Integer par_idGenero)
	{
		return generoRepository.findById(par_idGenero);
	}
	
	
	@GetMapping(path = "/buscarId/{par_idGenero}")
	public Optional <Genero> ConsultaGenero2 (@PathVariable Integer par_idGenero)
	{
		return generoRepository.findById(par_idGenero);

	}
	@PostMapping (path="/InserteGenero")
	public Genero InserteGenero (@RequestBody Genero genero ) {
	generoRepository.save(genero);
	return genero;
	} 


	@DeleteMapping("/eliminarGenero/{idGenero}")
	  public ResponseEntity<Map<String, Object>> eliminarGenero(
	      @PathVariable("idGenero") Integer idGenero) {
	    

	      
	      try {
	          generoRepository.deleteById(idGenero);
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
