package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
import com.AnalisisII.AnalisisII.Repository.PersonaRepository;
import com.AnalisisII.AnalisisII.entity.Empleado;
import com.AnalisisII.AnalisisII.entity.Persona;


@RestController
@RequestMapping("/empleado")
@CrossOrigin
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired 
	PersonaRepository personaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Empleado> buscar (){
		return empleadoRepository.findAll();
	}
	
	@GetMapping(path = "/buscarId/{idEmpleado}")
	public List <Empleado> buscarId (@PathVariable Integer idEmpleado){
		
		
		return empleadoRepository.findByIdEmpleado(idEmpleado);

	}
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody Empleado empleado ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		
		
		Double igss = calculoIgss(empleado.getIngresoSueldoBase());
		Double isr = calculoISR(empleado.getIngresoSueldoBase(),igss,empleado.getIngresobonificacionDecreto(),empleado.getIngresoOtrosIngresos());
	
		
		try {
			empleado.setFechaCreacion(date);
			empleado.setDescuentoIgss(igss);
			empleado.setDescuentoIsr(isr);
			
			empleadoRepository.save(empleado);
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
	public ResponseEntity<Map<String, Object>> editar (@RequestBody Empleado empleado ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		
		
		Double igss = calculoIgss(empleado.getIngresoSueldoBase());
		Double isr = calculoISR(empleado.getIngresoSueldoBase(),igss,empleado.getIngresobonificacionDecreto(),empleado.getIngresoOtrosIngresos());
	
		
		try {
			empleado.setFechaModificacion(date);
			empleado.setDescuentoIgss(igss);
			empleado.setDescuentoIsr(isr);
			
			empleadoRepository.save(empleado);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public Double calculoIgss(Double salarioBase) {
		
		Double resultado = salarioBase*0.0483;
		DecimalFormat formato = new DecimalFormat("#.00");
	    String resultadoFormateado = formato.format(resultado);
		Double resultadoFinal = Double.parseDouble(resultadoFormateado);
		    
		    return resultadoFinal;
	}
	
	@DeleteMapping("/eliminar/{idEmpleado}")
	public ResponseEntity<Map<String, Object>> eliminar(
	    @PathVariable("idEmpleado") Integer idEmpleado) {
	    
	    try {
	        empleadoRepository.deleteById(idEmpleado);
	        Map<String, Object> successResponse = new HashMap<>();
	        successResponse.put("mensaje", "Registro borrado exitosamente");
	       
	        return ResponseEntity.ok(successResponse);
	    } catch (Exception e) {
	  	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("error", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }
	}
	
public Double calculoISR(Double salarioBase,Double igss, Double bonificacionDecreto,Double otrosIngresos) {
	
	Double resultado = 0.00;
	
	Double gastosPersonales = 48000.00;	
	
	Double salarioAnual = salarioBase * 12;
	Double bonificacionAnual = bonificacionDecreto * 12;
	Double otrosIngresosAnual =otrosIngresos *12;
	
	Double igssAnual = igss * 12;
	
	Double ingresosAnuales = salarioAnual+bonificacionAnual+otrosIngresosAnual;
	Double deduccionesLegales = gastosPersonales + igssAnual;
	
	Double rentaImponible = ingresosAnuales - deduccionesLegales;
	System.out.println(rentaImponible);
	
	if (rentaImponible>=300000.01) {
		Double excedente = rentaImponible -300000.00;
		Double importeFijo = 15000.00;
		resultado =(excedente *0.07)+importeFijo;
		resultado = resultado/12;
	}else {
		resultado = rentaImponible*0.05;
		resultado = resultado/12;
	}
    
	DecimalFormat formato = new DecimalFormat("#.00");
	String resultadoFormateado = formato.format(resultado);
    Double resultadoFinal = Double.parseDouble(resultadoFormateado);
		    
			if (resultadoFinal<0.00) {
				resultadoFinal =0.00;
				
			}
		    
		    return resultadoFinal;
	}



	
	
	
	

}
