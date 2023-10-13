package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.AnalisisII.AnalisisII.Repository.EmpleadoRepository;
import com.AnalisisII.AnalisisII.Repository.InasistenciaRepository;
import com.AnalisisII.AnalisisII.entity.Empleado;
import com.AnalisisII.AnalisisII.entity.Inasistencia;

@RestController
@RequestMapping("/inasistencia")
@CrossOrigin
public class InasistenciaService {
	
	@Autowired
	InasistenciaRepository inasistenciaRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	
	@GetMapping(path = "/buscar")
	public List<Inasistencia> buscar(){
		return inasistenciaRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idInasistencia}")
	public List<Inasistencia> buscarId (@PathVariable ("idInasistencia") Integer idInasistencia ){
		List<Inasistencia> inasistencia = inasistenciaRepository.findByIdInasistencia(idInasistencia);
		return inasistencia;
	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody Inasistencia inasistencia) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		inasistencia.setFechaCreacion(date);
		Empleado empleado = empleadoRepository.findByIdEmpleado(inasistencia.getIdEmpleado()).get(0);
		Double sueldoDia = empleado.getIngresoSueldoBase()/30;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Integer milisecondsByDay = 86400000;
		Integer dias = (int) (inasistencia.getFechaFinal().getTime()-inasistencia.getFechaInicial().getTime())/milisecondsByDay;	
		Double descuentoInasistencia = sueldoDia * dias;
		empleado.setDescuentoInasistencias(empleado.getDescuentoInasistencias()+descuentoInasistencia);
		
		
		
		
		try {
			empleadoRepository.save(empleado);
			inasistenciaRepository.save(inasistencia);
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
	public ResponseEntity<Map<String, Object>> editar (@RequestBody Inasistencia inasistencia) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		inasistencia.setFechaModificacion(date);
		
		Inasistencia inasistenciaAnterior = inasistenciaRepository.findByIdInasistencia(inasistencia.getIdInasistencia()).get(0);
		
		
		
		Empleado empleado = empleadoRepository.findByIdEmpleado(inasistencia.getIdEmpleado()).get(0);
		Double sueldoDia = empleado.getIngresoSueldoBase()/30;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Integer milisecondsByDay = 86400000;

		Integer diasAnteriores = (int) (inasistenciaAnterior.getFechaFinal().getTime()-inasistenciaAnterior.getFechaInicial().getTime())/milisecondsByDay;
		Double reducirDescuento = sueldoDia * diasAnteriores;
		empleado.setDescuentoInasistencias(empleado.getDescuentoInasistencias()-reducirDescuento);
		
		Integer dias = (int) (inasistencia.getFechaFinal().getTime()-inasistencia.getFechaInicial().getTime())/milisecondsByDay;	
		Double descuentoInasistencia = sueldoDia * dias;
		empleado.setDescuentoInasistencias(empleado.getDescuentoInasistencias()+descuentoInasistencia);
		
		
		
		
		try {
			empleadoRepository.save(empleado);
			inasistenciaRepository.save(inasistencia);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se guardó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo guardar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	
	
	
	
	
	
	@DeleteMapping("/eliminar/{idInasistencia}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("idInasistencia") Integer idInasistencia) {
		
		Inasistencia inasistencia = inasistenciaRepository.findByIdInasistencia(idInasistencia).get(0);
		Empleado empleado = empleadoRepository.findByIdEmpleado(inasistencia.getIdEmpleado()).get(0);
		Double sueldoDia = empleado.getIngresoSueldoBase()/30;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Integer milisecondsByDay = 86400000;
		Integer dias = (int) (inasistencia.getFechaFinal().getTime()-inasistencia.getFechaInicial().getTime())/milisecondsByDay;	
		Double descuentoInasistencia = sueldoDia * dias;
		empleado.setDescuentoInasistencias(empleado.getDescuentoInasistencias()-descuentoInasistencia);
		
		
	    

	      
	      try {
	    	  empleadoRepository.save(empleado);
	          inasistenciaRepository.deleteById(idInasistencia);
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
