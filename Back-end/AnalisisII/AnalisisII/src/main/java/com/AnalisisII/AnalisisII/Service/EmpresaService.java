package com.AnalisisII.AnalisisII.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
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

import com.AnalisisII.AnalisisII.Repository.EmpresaRepository;
import com.AnalisisII.AnalisisII.entity.Empresa;


@RestController
@RequestMapping("/empresa")
@CrossOrigin
public class EmpresaService {
	
	@Autowired
	
	 EmpresaRepository empresaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Empresa> buscar (){
		return empresaRepository.findAll();
	} 

	@GetMapping ("/ConsultaEmpresa")
	public Optional <Empresa> ConsultarEmpresa (@RequestParam Integer par_idEmpresa){
	return empresaRepository.findById(par_idEmpresa);
	
	
	}
	@GetMapping(path = "/buscarId/{idEmpresa}")
	public List<Empresa> buscarId (@PathVariable ("idEmpresa") Integer idEmpresa){
		return empresaRepository.findByIdEmpresa(idEmpresa);
	}
	@PostMapping (path="/InsertaEmpresa")
	public Empresa InserteEmpresa(@RequestBody Empresa empresa ) {
	empresaRepository.save(empresa);
	return empresa;
	} 


	@DeleteMapping("/eliminarEmpresa/{idEmpresa}")
	  public ResponseEntity<Map<String, Object>> eliminarEmpresa(
	      @PathVariable("idEmpresa") Integer idEmpresa) {
	      
	      try {
	          empresaRepository.deleteById(idEmpresa);
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

