//OpcionService.java

package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import java.util.Optional;
import java.util.Map;
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

import com.AnalisisII.AnalisisII.Repository.OpcionRepository;

import com.AnalisisII.AnalisisII.entity.Opcion;

@RestController
@RequestMapping("/opcion")
@CrossOrigin
public class OpcionService {

	@Autowired
	OpcionRepository opcionRepository;
	
	@GetMapping(path = "/buscar")
	public List<Opcion> buscar(){
		return opcionRepository.findAll();
	}

	@GetMapping ("/ConsultaOpcion")
	public Optional <Opcion> ConsultaOpcion (@RequestParam Integer idOpcion)
	{
		return opcionRepository.findById(idOpcion);
	}
	
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String,Object>> InserteOpcion (@RequestBody Opcion opcion ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		opcion.setFechaCreacion(date);
		
		try {
			opcionRepository.save(opcion);
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
	public ResponseEntity<Map<String,Object>> editarOpcion (@RequestBody Opcion opcion ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		opcion.setFechaModificacion(date);
		
		try {
			opcionRepository.save(opcion);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	
	
	@DeleteMapping("/EliminarOpcion/{idOpcion}")
	  public ResponseEntity<Map<String, Object>> EliminarOpcion(
	      @PathVariable("idOpcion") Integer idOpcion){
	 	
	      
	      try {
	          opcionRepository.deleteById(idOpcion);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }

}
}
	