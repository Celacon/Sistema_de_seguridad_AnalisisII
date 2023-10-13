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

import com.AnalisisII.AnalisisII.Repository.TipoDocumentoRepository;
import com.AnalisisII.AnalisisII.entity.TipoDocumento;

@RestController
@RequestMapping("/tipoDocumento")
@CrossOrigin
public class TipoDocumentoService {
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	@GetMapping(path = "/buscar")
	public List<TipoDocumento> buscar(){
		return tipoDocumentoRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idTipoDocumento}")
	public List<TipoDocumento> bancoId (@PathVariable ("idTipoDocumento") Integer idTipoDocumento ){
		List<TipoDocumento> tipoDocumento = tipoDocumentoRepository.findByIdTipoDocumento(idTipoDocumento);
		return tipoDocumento;
	}

	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody TipoDocumento tipoDocumento ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		tipoDocumento.setFechaCreacion(date);
		
		try {
			tipoDocumentoRepository.save(tipoDocumento);
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
	public ResponseEntity<Map<String, Object>> editar (@RequestBody TipoDocumento tipoDocumento ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		tipoDocumento.setFechaModificacion(date);
		
		try {
			tipoDocumentoRepository.save(tipoDocumento);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	@DeleteMapping("/eliminar/{idTipoDocumento}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idTipoDocumento") Integer idTipoDocumento) {
	    

	      
	      try {
	          tipoDocumentoRepository.deleteById(idTipoDocumento);
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
