package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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

import com.AnalisisII.AnalisisII.Repository.FlujoStatusEmpleadoRepository;
import com.AnalisisII.AnalisisII.entity.FlujoStatusEmpleado;
import com.AnalisisII.AnalisisII.entity.FlujoStatusEmpleadoId;


@RestController
@RequestMapping("/flujoStatusEmpleado")
@CrossOrigin
public class FlujoStatusEmpleadoService {
	
	@Autowired
	FlujoStatusEmpleadoRepository flujoStatusEmpleadoRepository;

	@GetMapping(path ="buscar")
	public List<FlujoStatusEmpleado> buscar(){
		return flujoStatusEmpleadoRepository.findAll();
	}
	
	  @GetMapping("/buscarId/{idStatusActual}/{idStatusNuevo}")
	    public List<FlujoStatusEmpleado> getRoleOpcionById(@PathVariable ("idStatusActual")Integer idStatusActual, @PathVariable ("idStatusNuevo")Integer idStatusNuevo) {
	        FlujoStatusEmpleadoId id = new FlujoStatusEmpleadoId(idStatusActual, idStatusNuevo);
	        List<FlujoStatusEmpleado> result = flujoStatusEmpleadoRepository.findById(id);
	    
	        return  result;
	    }
	  
	  @PostMapping("/guardar")
	  public ResponseEntity<Map<String, Object>> guardar(@RequestBody FlujoStatusEmpleado flujoStatusEmpleado) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			flujoStatusEmpleado.setFechaCreacion(date);
			
			try {
				flujoStatusEmpleadoRepository.save(flujoStatusEmpleado);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se guardó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo guardar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	  }
	  
	  @PostMapping("/editar")
	  public ResponseEntity<Map<String, Object>> editar(@RequestBody FlujoStatusEmpleado flujoStatusEmpleado) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			flujoStatusEmpleado.setFechaModificacion(date);
			
			try {
				flujoStatusEmpleadoRepository.save(flujoStatusEmpleado);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	  }
	  
	  @DeleteMapping("/eliminar/{idStatusActual}/{idStatusNuevo}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idStatusActual") Integer idStatusActual,
	      @PathVariable("idStatusNuevo") Integer idStatusNuevo) {

	      FlujoStatusEmpleadoId id = new FlujoStatusEmpleadoId(idStatusActual, idStatusNuevo);
	      
	      try {
	          flujoStatusEmpleadoRepository.deleteById(id);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("error", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }
	  }
	  
	  @GetMapping("/buscarIdStatusActual/{idStatusActual}")
	  public List<FlujoStatusEmpleado> getFlujoStatusEmpleadoByIdStatusActual(@PathVariable("idStatusActual") Integer idStatusActual) {
		 
		  List<FlujoStatusEmpleado> todos = flujoStatusEmpleadoRepository.findAll();
		  List<FlujoStatusEmpleado> result = new ArrayList<>();
		  
		  for(FlujoStatusEmpleado nuevo: todos) {
				if(nuevo.getId().getIdStatusActual().equals(idStatusActual)) {
					result.add(nuevo);

				}
			}
	      
	      return result;
	  }
	
}
