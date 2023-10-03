//MenuService.java

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

import com.AnalisisII.AnalisisII.Repository.MenuRepository;

import com.AnalisisII.AnalisisII.entity.Menu;


@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	@GetMapping(path ="/buscar")
	public List <Menu> buscar(){
		return menuRepository.findAll();
	}
	
	@GetMapping ("/ConsultaMenu")
	public Optional <Menu> ConsultaMenu (@RequestParam Integer idMenu)
	{
		return menuRepository.findById(idMenu);
	}
	@GetMapping(path = "/buscarId/{idMenu}")
	public Optional <Menu> ConsultaMenu2 (@PathVariable Integer idMenu)
	{
		return menuRepository.findById(idMenu);

	}
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String,Object>> InserteMenu (@RequestBody Menu menu ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		menu.setFechaCreacion(date);
		
		try {
			menuRepository.save(menu);
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
	public ResponseEntity<Map<String,Object>> editarMenu (@RequestBody Menu menu ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		menu.setFechaModificacion(date);
		
		try {
			menuRepository.save(menu);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	
	
	
	
	
	@DeleteMapping("/EliminarMenu/{idMenu}")
	  public ResponseEntity<Map<String, Object>> eliminarMenu(
	      @PathVariable("idMenu") Integer idMenu){
	      

			
	      
	      try {
	          menuRepository.deleteById(idMenu);
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





