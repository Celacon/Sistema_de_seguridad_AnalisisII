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

import com.AnalisisII.AnalisisII.Repository.RoleOpcionRepository;
import com.AnalisisII.AnalisisII.entity.RoleOpcion;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;

@RestController
@RequestMapping("/role-opcion")
@CrossOrigin
public class RoleOpcionService {

	@Autowired
	RoleOpcionRepository roleOpcionRepository;
	
	@GetMapping(path = "/buscar")
	public List <RoleOpcion> buscar(){
		return roleOpcionRepository.findAll();
	}
	
	  @GetMapping("/buscarId/{idRole}/{idOpcion}")
	    public List<RoleOpcion> getRoleOpcionById(@PathVariable ("idRole")Integer idRole, @PathVariable ("idOpcion")Integer idOpcion) {
	        RoleOpcionId id = new RoleOpcionId(idRole, idOpcion);
	        List<RoleOpcion> result = roleOpcionRepository.findById(id);
	        //RoleOpcion us = result.get(0);
	        return  result;
	    }
	  
	  @PostMapping("/guardar")
	  public ResponseEntity<Map<String, Object>> guardarRoleOpcion(@RequestBody RoleOpcion roleOpcion) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			roleOpcion.setFechaCreacion(date);
			
			try {
				roleOpcionRepository.save(roleOpcion);
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
	  public ResponseEntity<Map<String, Object>> editar(@RequestBody RoleOpcion roleOpcion) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			roleOpcion.setFechaModificacion(date);
			
			try {
				roleOpcionRepository.save(roleOpcion);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	  }
	  
	  
	  
	  @DeleteMapping("/eliminarRoleOpcion/{idRole}/{idOpcion}")
	  public ResponseEntity<Map<String, Object>> eliminarRoleOpcion(
	      @PathVariable("idRole") Integer idRole,
	      @PathVariable("idOpcion") Integer idOpcion) {

	      RoleOpcionId id = new RoleOpcionId(idRole, idOpcion);
	      
	      try {
	          roleOpcionRepository.deleteById(id);
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

