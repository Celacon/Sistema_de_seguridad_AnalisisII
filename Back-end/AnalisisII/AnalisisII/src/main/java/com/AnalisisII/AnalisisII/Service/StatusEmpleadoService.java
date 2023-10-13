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
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.StatusEmpleadoRepository;

import com.AnalisisII.AnalisisII.entity.StatusEmpleado;

@RestController
@RequestMapping("/statusEmpleado")
@CrossOrigin
public class StatusEmpleadoService {
	
	@Autowired
	StatusEmpleadoRepository statusEmpleadoRepository;

	@GetMapping(path = "/buscar")
	public List<StatusEmpleado> buscar(){
		return statusEmpleadoRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idStatusEmpleado}")
	public List<StatusEmpleado> buscarId (@PathVariable Integer idStatusEmpleado)
	{
		return statusEmpleadoRepository.findByIdStatusEmpleado(idStatusEmpleado);

	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar(@RequestBody StatusEmpleado statusEmpleado ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		statusEmpleado.setFechaCreacion(date);
		
		try {
			statusEmpleadoRepository.save(statusEmpleado);
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
	public ResponseEntity<Map<String, Object>> editar (@RequestBody StatusEmpleado statusEmpleado ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		statusEmpleado.setFechaModificacion(date);
		
		try {
			statusEmpleadoRepository.save(statusEmpleado);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	}
	
	@DeleteMapping("/eliminar/{idStatusEmpleado}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idStatusEmpleado") Integer idStatusEmpleado) {
	    

	      
	      try {
	          statusEmpleadoRepository.deleteById(idStatusEmpleado);
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
