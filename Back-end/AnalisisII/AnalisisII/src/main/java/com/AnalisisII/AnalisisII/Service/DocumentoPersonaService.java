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

import com.AnalisisII.AnalisisII.Repository.DocumentoPersonaRepository;
import com.AnalisisII.AnalisisII.entity.DocumentoPersona;
import com.AnalisisII.AnalisisII.entity.DocumentoPersonaId;

@RestController
@RequestMapping("/documento-persona")
@CrossOrigin
public class DocumentoPersonaService {
	
	@Autowired
	DocumentoPersonaRepository documentoPersonaRepository;
	
	
	@GetMapping(path = "/buscar")
	public List <DocumentoPersona> buscar(){
		return documentoPersonaRepository.findAll();
	}
	
	 @GetMapping("/buscarId/{idTipoDocumento}/{idPersona}")
	    public List<DocumentoPersona> buscarId(
	    		@PathVariable ("idTipoDocumento")Integer idTipoDocumento, 
	    		@PathVariable ("idPersona")Integer idPersona) {
		 
	        DocumentoPersonaId id = new DocumentoPersonaId(idTipoDocumento, idPersona);
	        List<DocumentoPersona> result = documentoPersonaRepository.findById(id);
	        return  result;
	    }

	 @PostMapping("/guardar")
	  public ResponseEntity<Map<String, Object>> guardarRoleOpcion(@RequestBody DocumentoPersona documentoPersona) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			documentoPersona.setFechaCreacion(date);
			
			try {
				documentoPersonaRepository.save(documentoPersona);
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
	  public ResponseEntity<Map<String, Object>> editar(@RequestBody DocumentoPersona documentoPersona) {
		  LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			documentoPersona.setFechaModificacion(date);
			
			try {
				documentoPersonaRepository.save(documentoPersona);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se editó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo editar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
	  }
	 
	  @DeleteMapping("/eliminar/{idTipoDocumento}/{idPersona}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idTipoDocumento") Integer idTipoDocumento,
	      @PathVariable("idPersona") Integer idPersona) {

	      DocumentoPersonaId id = new DocumentoPersonaId(idTipoDocumento, idPersona);
	      
	      try {
	          documentoPersonaRepository.deleteById(id);
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
