//RoleService.java

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.RoleRepository;

import com.AnalisisII.AnalisisII.entity.Role;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleService {
	
	@Autowired 
	RoleRepository roleRepository;
	
	@GetMapping(path = "/buscar")
	public List<Role> buscar(){
		return roleRepository.findAll();
	}
	@GetMapping ("/ConsultaRole")
	public Optional <Role> ConsultaRole (@RequestParam Integer idRole)
	{
		return roleRepository.findById(idRole);
	}
	
	
	@GetMapping(path = "/buscarId/{idRole}")
	public Optional <Role> ConsultaRole2 (@PathVariable Integer idRole)
	{
		return roleRepository.findById(idRole);

	}
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> InserteRole (@RequestBody Role role ) {
		 LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			role.setFechaCreacion(date);
			
			try {
				roleRepository.save(role);
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
	public ResponseEntity<Map<String, Object>> editarRole (@RequestBody Role role ) {
		 LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			role.setFechaModificacion(date);
			
			try {
				roleRepository.save(role);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	}
	
	
	@DeleteMapping("/EliminarRole/{idRole}")
	  public ResponseEntity<Map<String, Object>> EliminarRole(
	      @PathVariable("idRole") Integer idRole){
	      

			
	      
	      try {
	          roleRepository.deleteById(idRole);
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