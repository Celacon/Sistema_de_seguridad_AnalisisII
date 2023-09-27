
//SucursalService.java

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

import com.AnalisisII.AnalisisII.Repository.SucursalRepository;

import com.AnalisisII.AnalisisII.entity.Sucursal;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin
public class SucursalService {
	@Autowired
	SucursalRepository sucursalRepository;
	
	@GetMapping(path = "/buscar")
	public List<Sucursal> buscar(){
		return sucursalRepository.findAll();
	}
	@PostMapping (path="/InserteSucursal")
	public Sucursal InserteSucursal (@RequestBody Sucursal sucursal ) {
	sucursalRepository.save(sucursal);
	return sucursal;
	} 
	
	
	@DeleteMapping("/EliminaSucursal/{idSucursal}")
	  public ResponseEntity<Map<String, Object>> EliminaSucursal(
	      @PathVariable("idSucursal") Integer idSucursal){
	      

			
	      
	      try {
	          sucursalRepository.deleteById(idSucursal);
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

