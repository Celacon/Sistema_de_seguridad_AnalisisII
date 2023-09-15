package com.AnalisisII.AnalisisII.Service;

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

import com.AnalisisII.AnalisisII.Repository.UsuarioRoleRepository;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;
import com.AnalisisII.AnalisisII.entity.UsuarioRole;
import com.AnalisisII.AnalisisII.entity.UsuarioRoleId;

@RestController
@RequestMapping("/usuario-role")
@CrossOrigin
public class UsuarioRoleService {
	
	@Autowired 
	UsuarioRoleRepository usuarioRoleRepository;
	
	@GetMapping(path = "/buscar")
	public List<UsuarioRole> buscar() {
		return usuarioRoleRepository.findAll();
	}
	
	@GetMapping("/buscarId/{idUsuario}/{idRole}")
	public List<UsuarioRole> getUsuarioRoleById(@PathVariable ("idUsuario")String idUsuario, @PathVariable ("idRole")Integer idRole){
		UsuarioRoleId id = new UsuarioRoleId(idUsuario,idRole);
		List <UsuarioRole> result = usuarioRoleRepository.findById(id);
		return result;
	}
	
	@PostMapping("/guardarUsuarioRole")
	public UsuarioRole guardarUsuarioRole(@RequestBody UsuarioRole usuarioRole) {
		usuarioRoleRepository.save(usuarioRole);
		return usuarioRole;
	}
	
     @DeleteMapping("/eliminarUsuarioRole/{idUsuario}/{idRole}")
	  public ResponseEntity<Map<String, Object>> eliminarUsuarioRole(
	      @PathVariable("idUsuario") String idUsuario,
	      @PathVariable("idRole") Integer idRole) {

	      UsuarioRoleId id = new UsuarioRoleId(idUsuario, idRole);
	      
	      try {
	          usuarioRoleRepository.deleteById(id);
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
