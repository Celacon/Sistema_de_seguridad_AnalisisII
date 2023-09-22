//RoleService.java

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
	@PostMapping (path="/InserteRole")
	public Role InserteRole (@RequestBody Role role ) {
	roleRepository.save(role);
	return role;
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