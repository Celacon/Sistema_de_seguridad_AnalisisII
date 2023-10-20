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

import com.AnalisisII.AnalisisII.Repository.PeriodoPlanillaRepository;
import com.AnalisisII.AnalisisII.entity.PeriodoPlanilla;
import com.AnalisisII.AnalisisII.entity.PlanillaId;
import com.AnalisisII.AnalisisII.entity.RoleOpcion;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;

@RestController
@RequestMapping("/periodoPlanilla")
@CrossOrigin
public class PeriodoPlanillaService {

	@Autowired
	PeriodoPlanillaRepository periodoPlanillaRepository;
	
	@GetMapping(path = "/buscar")
	public List<PeriodoPlanilla> buscar (){
		return periodoPlanillaRepository.findAll();
	}
	
	 @GetMapping("/buscarId/{anio}/{mes}")
	    public List<PeriodoPlanilla> geById(@PathVariable ("anio")Integer anio, @PathVariable ("mes")Integer mes) {
	        PlanillaId id = new PlanillaId(anio, mes);
	        List<PeriodoPlanilla> result = periodoPlanillaRepository.findById(id);
	       
	        return  result;
	    }
	 
	 
	 @PostMapping("/guardar")
	  public ResponseEntity<Map<String, Object>> guardar(@RequestBody PeriodoPlanilla periodoPlanilla) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			periodoPlanilla.setFechaCreacion(date);
			
			try {
				periodoPlanillaRepository.save(periodoPlanilla);
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
	  public ResponseEntity<Map<String, Object>> editar(@RequestBody PeriodoPlanilla periodoPlanilla) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			periodoPlanilla.setFechaModificacion(date);
			
			try {
				periodoPlanillaRepository.save(periodoPlanilla);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	  }
	 
	 @DeleteMapping("/eliminar/{anio}/{mes}")
	  public ResponseEntity<Map<String, Object>> eliminarRoleOpcion(
	      @PathVariable("anio") Integer anio,
	      @PathVariable("mes") Integer mes) {

	      PlanillaId id = new PlanillaId(anio, mes);
	      
	      try {
	          periodoPlanillaRepository.deleteById(id);
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
