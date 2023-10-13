package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
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

import com.AnalisisII.AnalisisII.Repository.EstadoCivilRepository;
import com.AnalisisII.AnalisisII.entity.EstadoCivil;

@RestController
@RequestMapping("/estadoCivil")
@CrossOrigin
public class EstadoCivilService {
	
	@Autowired
	EstadoCivilRepository estadoCivilRepository;

	@GetMapping(path ="/buscar")
	public List <EstadoCivil> buscar(){
		return estadoCivilRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idEstadoCivil}")
	public List<EstadoCivil> departamentoId (@PathVariable ("idEstadoCivil") Integer idEstadoCivil ){
		List<EstadoCivil> estadoCivil = estadoCivilRepository.findByIdEstadoCivil(idEstadoCivil);
		return estadoCivil;
	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody EstadoCivil estadoCivil ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		estadoCivil.setFechaCreacion(date);
		
		try {
			estadoCivilRepository.save(estadoCivil);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se guardó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo guardar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	@PostMapping (path="/editar")
	public ResponseEntity<Map<String, Object>> editar (@RequestBody EstadoCivil estadoCivil ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
	    
		estadoCivil.setFechaModificacion(date);
		
		try {
			estadoCivilRepository.save(estadoCivil);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	@DeleteMapping("/eliminar/{idEstadoCivil}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idEstadoCivil") Integer idEstadoCivil) {
	    

	      
	      try {
	          estadoCivilRepository.deleteById(idEstadoCivil);
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
