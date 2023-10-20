package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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
import com.AnalisisII.AnalisisII.Repository.PlanillaCabeceraRepository;
import com.AnalisisII.AnalisisII.Repository.PlanillaDetalleRepository;
import com.AnalisisII.AnalisisII.entity.Empleado;
import com.AnalisisII.AnalisisII.entity.PlanillaCabecera;
import com.AnalisisII.AnalisisII.entity.PlanillaDetalle;
import com.AnalisisII.AnalisisII.entity.PlanillaId;
import com.AnalisisII.AnalisisII.entity.RoleOpcion;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;

@RestController
@RequestMapping("/planillaCabecera")
@CrossOrigin
public class PlanillaCabeceraService {
	@Autowired
	PlanillaCabeceraRepository planillaCabeceraRepository;
	
	@Autowired
	PlanillaDetalleRepository planillaDetalleRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@GetMapping(path = "/buscar")
	public List<PlanillaCabecera> buscar (){
		return planillaCabeceraRepository.findAll();
	}

	@GetMapping("/buscarId/{anio}/{mes}")
    public List<PlanillaCabecera> geById(@PathVariable ("anio")Integer anio, @PathVariable ("mes")Integer mes) {
        PlanillaId id = new PlanillaId(anio, mes);
        List<PlanillaCabecera> result = planillaCabeceraRepository.findByIdPlanillaCabecera(id);
        //RoleOpcion us = result.get(0);
        return  result;
    }
	
	@PostMapping("/guardar")
	  public ResponseEntity<Map<String, Object>> guardar(@RequestBody PlanillaCabecera planillaCabecera) {
		
		boolean validarcabeceraPlanilla = true;
		boolean validarDetallesPlanilla = true;
		Double totalIngresos = 0.00;
		Double totalDescuentos = 0.00;
		Double totalSalarioNeto = 0.00;
		
		
		LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
			planillaCabecera.setFechaCreacion(date);
			
			
		
			  
			PlanillaId id = new PlanillaId(planillaCabecera.getIdPlanillaCabecera().getAnio(),planillaCabecera.getIdPlanillaCabecera().getMes());
		    List<PlanillaCabecera> result = planillaCabeceraRepository.findByIdPlanillaCabecera(id);
			
		        
		        if (!result.isEmpty()) {
				Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "La planilla ya fue calculada");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);	
			}else {
			try {
				
				planillaCabecera.setTotalIngreso(totalIngresos);
				planillaCabecera.setTotalDescuento(totalDescuentos);
				planillaCabecera.setSalarioNeto(totalSalarioNeto);
				planillaCabecera.setFechaHoraProcesada(date);
				planillaCabeceraRepository.save(planillaCabecera);
				
			}catch(Exception e){
				validarcabeceraPlanilla =false;
				
				Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "La lanilla no se pudo guardar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);	
				
			}
			}
				
				if(validarcabeceraPlanilla ) {
				
				List<Empleado> empleadoSinCalcular = empleadoRepository.findByIdStatusEmpleado(1);
				Map<String, Object> resultados = setPlanillaDetalle(empleadoSinCalcular,planillaCabecera.getIdPlanillaCabecera().getAnio(),planillaCabecera.getIdPlanillaCabecera().getMes(),planillaCabecera.getUsuarioCreacion());
				validarDetallesPlanilla = (boolean) resultados.get("validar");
				totalIngresos = (Double) resultados.get("totalIngresos");
				totalDescuentos = (Double) resultados.get("totalDescuentos");
				totalSalarioNeto = (Double) resultados.get("totalSalarioNeto");
				
				planillaCabecera.setTotalIngreso(totalIngresos);
				planillaCabecera.setTotalDescuento(totalDescuentos);
				planillaCabecera.setSalarioNeto(totalSalarioNeto);
				planillaCabecera.setFechaHoraProcesada(date);
				}
			
			
			
			
			
			
			if(!validarDetallesPlanilla) {
				
				System.out.println("falal en detalles");
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo guardar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);	
				
				
			}
			
			
			try {
				planillaCabeceraRepository.save(planillaCabecera);
				  Map<String, Object> successResponse = new HashMap<>();
		          successResponse.put("mensaje", "Registro se guardó exitosamente");
		          return ResponseEntity.ok(successResponse);	
			}catch(Exception e){
				 Map<String, Object> errorResponse = new HashMap<>();
				    errorResponse.put("mensaje", "El registro no se pudo guardar");
				    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
			}
			
			
	  }
	
	
	
	
	
	public Map<String, Object> setPlanillaDetalle(List<Empleado> empleadoSinCalcular,Integer anio,Integer mes,String usuarioCreacion) {
	
		
		boolean validar = true;
	   Double totalIngresos = 0.00;
	   Double totalDescuentos = 0.00;
	   Double totalSalarioNeto = 0.00;
			
		 List<PlanillaDetalle> listPlanillaDetalle = new ArrayList<>();
		 
		 
		 LocalDate fechaHoy = LocalDate.now();
			Date date = Date.valueOf(fechaHoy);
	    for(Empleado usu:empleadoSinCalcular) {
	    	PlanillaDetalle detallePlanilla = new PlanillaDetalle();
	    	//periodo o cabecera
	    	detallePlanilla.setAnio(anio);
	    	detallePlanilla.setMes(mes);
	    	
	    	//detalle del empleado
	    	detallePlanilla.setIdEmpleado(usu.getIdEmpleado());
	    	detallePlanilla.setFechaContratacion(usu.getFechaContratacion());
	    	detallePlanilla.setIdPuesto(usu.getIdPuesto());
	    	detallePlanilla.setIdStatusEmpleado(usu.getIdStatusEmpleado());
	    	
	    	//ingresos
	    	detallePlanilla.setIngresoSueldoBase(usu.getIngresoSueldoBase());
	    	detallePlanilla.setIngresoBonificacionDecreto(usu.getIngresobonificacionDecreto());
	    	detallePlanilla.setIngresoOtrosIngresos(usu.getIngresoOtrosIngresos());
	    	
	    	//suma de ingresos del empleado
	    	Double sumaIngresos	= 
	    			detallePlanilla.getIngresoSueldoBase()+
	    			detallePlanilla.getIngresoBonificacionDecreto()+
	    			detallePlanilla.getIngresoOtrosIngresos();
	    	
	    	//descuentos del empleado 
	    	detallePlanilla.setDescuentoIgss(usu.getDescuentoIgss());
	    	detallePlanilla.setDescuentoIsr(usu.getDescuentoIsr());
	    	detallePlanilla.setDescuentoInasistencias(usu.getDescuentoInasistencias());
	    	
	    	//suma de descuentos del empleado
	    	Double sumaDescuentos	= 
	    			detallePlanilla.getDescuentoIgss()+
	    			detallePlanilla.getDescuentoIsr()+
	    			detallePlanilla.getDescuentoInasistencias();
	    	
	    	//salario neto
	    	Double salarioNetoEmpleado = sumaIngresos - sumaDescuentos;
	    	detallePlanilla.setSalarioNeto(salarioNetoEmpleado);
	    	
	    	//agregar la fecha 
	    	detallePlanilla.setFechaCreacion(date);
	    	detallePlanilla.setUsuarioCreacion(usuarioCreacion);
	    	
	    	//suma a totales
	    	totalIngresos= totalIngresos +sumaIngresos;
	    	totalDescuentos = totalDescuentos + sumaDescuentos;
	    	totalSalarioNeto = totalSalarioNeto + salarioNetoEmpleado; 
	    	
	    	//agregar al listado de detalle de Planilla
	    	
	    	listPlanillaDetalle.add(detallePlanilla);

	    	
	    	
	    }
	
	    
	    try {
	    	for (PlanillaDetalle pd: listPlanillaDetalle) {
	    		
	    		planillaDetalleRepository.save(pd);
	    	
	    		
	    		
	    	}
	    }catch (Exception e) {
	    	
	    	 List<PlanillaDetalle> detalleGuardados =planillaDetalleRepository.findByAnioAndMes(anio,mes);
		    	for (PlanillaDetalle pd: detalleGuardados) {
		    		planillaDetalleRepository.delete(pd);
		    	}
	    	
	    	validar = false;
	    	System.out.println(e.getCause() + " Mensaje -> " + e.getMessage());
	    }
		
		if(!validar) {
			Map<String, Object> valores = new HashMap<>();
		    valores.put("totalIngresos", 0.00);
		    valores.put("totalDescuentos", 0.00);
		    valores.put("totalSalarioNeto",0.00);
		    valores.put("validar", validar);
		    return valores;
			
		}
			
		
		Map<String, Object> valores = new HashMap<>();
	    valores.put("totalIngresos", totalIngresos);
	    valores.put("totalDescuentos", totalDescuentos);
	    valores.put("totalSalarioNeto",totalSalarioNeto);
	    valores.put("validar", validar);
	    return valores;
	}
	
	
	
	  @DeleteMapping("/eliminar/{anio}/{mes}")
	  public ResponseEntity<Map<String, Object>> eliminar(
	      @PathVariable("anio") Integer anio,
	      @PathVariable("mes") Integer mes) {

	      PlanillaId id = new PlanillaId(anio, mes);
	      
	      try {
	    	  
	    	  List<PlanillaDetalle> detalleGuardados =planillaDetalleRepository.findByAnioAndMes(anio,mes);
		    	for (PlanillaDetalle pd: detalleGuardados) {
		    		planillaDetalleRepository.delete(pd);
		    	}
	    	  
	    	  
	    	
	    	  
	    	  
	          planillaCabeceraRepository.deleteById(id);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  System.out.println(e.getMessage());
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("error", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }
	  }
	
}
