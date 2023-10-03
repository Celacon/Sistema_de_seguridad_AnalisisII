//TipoAccesoService.java 

package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
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

import com.AnalisisII.AnalisisII.Repository.TipoAccesoRepository;

import com.AnalisisII.AnalisisII.entity.TipoAcceso;

@RestController
@RequestMapping("/tipo-acceso")
@CrossOrigin
public class TipoAccesoService {
	@Autowired
	TipoAccesoRepository tipoAccesoRepository;
	

	@GetMapping(path = "/buscar")
	public List<TipoAcceso> buscar(){
		return tipoAccesoRepository.findAll();
	}
	@GetMapping ("/ConsultaTipoAcceso")
	public Optional <TipoAcceso> ConsultaTipoAcceso (@RequestParam Integer idTipoAcceso)
	{
		return tipoAccesoRepository.findById(idTipoAcceso);
	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> InserteTipoAcceso (@RequestBody TipoAcceso tipoAcceso ) {
		 LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			tipoAcceso.setFechaCreacion(date);
			
			try {
				tipoAccesoRepository.save(tipoAcceso);
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
	public ResponseEntity<Map<String, Object>> editarTipoAcceso (@RequestBody TipoAcceso tipoAcceso ) {
		 LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			tipoAcceso.setFechaModificacion(date);
			
			try {
				tipoAccesoRepository.save(tipoAcceso);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	}
	
	@DeleteMapping("/EliminaTipoAcceso/{idTipoAcceso}")
	  public ResponseEntity<Map<String, Object>> EliminaTipoAcceso(
	      @PathVariable("idTipoAcceso") Integer idTipoAcceso){
	      

			
	      
	      try {
	          tipoAccesoRepository.deleteById(idTipoAcceso);
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
