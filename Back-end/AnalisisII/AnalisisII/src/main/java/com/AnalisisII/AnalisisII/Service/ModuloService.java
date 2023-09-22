package com.AnalisisII.AnalisisII.Service;

import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.ModuloRepository;

import com.AnalisisII.AnalisisII.entity.Modulo;

@RestController
@RequestMapping("/modulo")
@CrossOrigin
public class ModuloService {

	@Autowired
	ModuloRepository moduloRepository;
	
	@GetMapping(path ="buscar")
	public List<Modulo> buscar(){
		return moduloRepository.findAll();
	}

	@GetMapping ("/ConsultaModulo")
	public Optional <Modulo> ConsultaModulo (@RequestParam Integer idModulo)
	{
		return moduloRepository.findById(idModulo);
	}
	@GetMapping(path = "/buscarId/{idModulo}")
	public Optional <Modulo> ConsultaModulo2 (@PathVariable Integer idModulo)
	{
		return moduloRepository.findById(idModulo);

	}
	@PostMapping (path="/InserteModulo")
	public Modulo InserteModulo (@RequestBody Modulo modulo ) {
	moduloRepository.save(modulo);
	return modulo;
	} 
	@DeleteMapping("/EliminarModulo/{idModulo}")
	  public ResponseEntity<Map<String, Object>> EliminarModulo(
	      @PathVariable("idModulo") Integer idModulo){
	      

			
	      
	      try {
	          moduloRepository.deleteById(idModulo);
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
