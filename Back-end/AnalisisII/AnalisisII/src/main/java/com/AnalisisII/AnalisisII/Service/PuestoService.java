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

import com.AnalisisII.AnalisisII.Repository.PuestoRepository;
import com.AnalisisII.AnalisisII.entity.Puesto;

@RestController
@RequestMapping("/puesto")
@CrossOrigin
public class PuestoService {
	
	@Autowired
	PuestoRepository puestoRepository;
	
	@GetMapping(path ="/buscar")
	public List<Puesto> buscar(){
		return puestoRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idPuesto}")
	public List<Puesto> buscarId (@PathVariable ("idPuesto") Integer idPuesto){
		List<Puesto> puesto = puestoRepository.findByIdPuesto(idPuesto);
		return puesto;
	}
	

	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody Puesto puesto ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		puesto.setFechaCreacion(date);
		
		try {
			puestoRepository.save(puesto);
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
	public ResponseEntity<Map<String, Object>> editar (@RequestBody Puesto puesto ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		puesto.setFechaModificacion(date);
		
		try {
			puestoRepository.save(puesto);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	@DeleteMapping("/eliminar/{idPuesto}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idPuesto") Integer idPuesto) {
	    

	      
	      try {
	          puestoRepository.deleteById(idPuesto);
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
