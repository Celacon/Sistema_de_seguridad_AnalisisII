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

import com.AnalisisII.AnalisisII.Repository.CuentaBancariaEmpleadoRepository;
import com.AnalisisII.AnalisisII.entity.CuentaBancariaEmpleado;

@RestController
@RequestMapping("/cuentaBancariaEmpleado")
@CrossOrigin
public class CuentaBancariaEmpleadoService {

	@Autowired
	CuentaBancariaEmpleadoRepository cuentaBancariaEmpleadoRepository;

	@GetMapping(path = "/buscar")
	public List<CuentaBancariaEmpleado> buscar(){
		return cuentaBancariaEmpleadoRepository.findAll();
	}
	
	
	@GetMapping(path = "/buscarId/{idCuentaBancaria}")
	public List<CuentaBancariaEmpleado> buscarId (@PathVariable ("idCuentaBancaria") Integer idCuentaBancaria ){
		List<CuentaBancariaEmpleado> cuentasBancarias = cuentaBancariaEmpleadoRepository.findByIdCuentaBancaria(idCuentaBancaria);
		return cuentasBancarias;
	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody CuentaBancariaEmpleado cuentaBancaria ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		cuentaBancaria.setFechaCreacion(date);
		
		try {
			cuentaBancariaEmpleadoRepository.save(cuentaBancaria);
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
	public ResponseEntity<Map<String, Object>> editar(@RequestBody CuentaBancariaEmpleado cuentaBancaria ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		cuentaBancaria.setFechaModificacion(date);
		
		try {
			cuentaBancariaEmpleadoRepository.save(cuentaBancaria);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	

	@DeleteMapping("/eliminar/{idCuentaBancaria}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idCuentaBancaria") Integer idCuentaBancaria) {
	    

	      
	      try {
	          cuentaBancariaEmpleadoRepository.deleteById(idCuentaBancaria);
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
