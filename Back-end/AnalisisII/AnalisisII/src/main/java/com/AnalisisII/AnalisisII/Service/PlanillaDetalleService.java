package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.EmpleadoRepository;
import com.AnalisisII.AnalisisII.Repository.PersonaRepository;
import com.AnalisisII.AnalisisII.Repository.PlanillaDetalleRepository;
import com.AnalisisII.AnalisisII.Repository.PuestoRepository;
import com.AnalisisII.AnalisisII.Repository.StatusEmpleadoRepository;
import com.AnalisisII.AnalisisII.entity.Empleado;
import com.AnalisisII.AnalisisII.entity.Genero;
import com.AnalisisII.AnalisisII.entity.Persona;
import com.AnalisisII.AnalisisII.entity.PlanillaCabecera;
import com.AnalisisII.AnalisisII.entity.PlanillaDetalle;
import com.AnalisisII.AnalisisII.entity.PlanillaId;
import com.AnalisisII.AnalisisII.entity.Puesto;
import com.AnalisisII.AnalisisII.entity.StatusEmpleado;
import com.AnalisisII.AnalisisII.entity.Vplanilla;

@RestController
@RequestMapping("/planillaDetalle")
@CrossOrigin
public class PlanillaDetalleService {

	@Autowired
	PlanillaDetalleRepository planillaDetalleRepository; 
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	StatusEmpleadoRepository statusRepository;
	
	@Autowired
	PuestoRepository puestoRepository;
	
	@GetMapping("/buscarId/{anio}/{mes}")
    public List<PlanillaDetalle> geById(@PathVariable ("anio")Integer anio, @PathVariable ("mes")Integer mes) {
      
        List<PlanillaDetalle> result = planillaDetalleRepository.findByAnioAndMes(anio, mes);
        //RoleOpcion us = result.get(0);
        return  result;
    }
	
	@GetMapping("/buscarId2/{anio}/{mes}")
    public List<Vplanilla> geById2(@PathVariable ("anio")Integer anio, @PathVariable ("mes")Integer mes) {
		List<Vplanilla> vplanilla = new ArrayList<>();
		
        List<PlanillaDetalle> result = planillaDetalleRepository.findByAnioAndMes(anio, mes);
      for(PlanillaDetalle pl: result) {
    	  Vplanilla vp = new Vplanilla();
    	  vp.setIdPlanillaDetalle(pl.getIdPlanillaDetalle());
    	  vp.setAnio(pl.getAnio());
    	  vp.setMes(pl.getMes());
    	  vp.setIdEmpleado(pl.getIdEmpleado());
    	  vp.setFechaContratacion(pl.getFechaContratacion());
    	  vp.setIdPuesto(pl.getIdPuesto());
    	  vp.setIdStatusEmpleado(pl.getIdStatusEmpleado());
    	  vp.setIngresoSueldoBase(pl.getIngresoSueldoBase());
    	  vp.setIngresoBonificacionDecreto(pl.getIngresoBonificacionDecreto());
    	  vp.setIngresoOtrosIngresos(pl.getIngresoOtrosIngresos());
    	  vp.setDescuentoIgss(pl.getDescuentoIgss());
    	  vp.setDescuentoIsr(pl.getDescuentoIsr());
    	  vp.setDescuentoInasistencias(pl.getDescuentoInasistencias());
    	  vp.setSalarioNeto(pl.getSalarioNeto());
    	  
    	  vplanilla.add(vp);
      }
        List<Empleado> empleado =empleadoRepository.findAll();
        
        for(Vplanilla vp: vplanilla) {
        	for (Empleado em: empleado) {
        		if (vp.getIdEmpleado()==em.getIdEmpleado()) {
        			vp.setIdPersona(em.getIdPersona());
        		}
        	}
        }
        
        List<Persona> persona =personaRepository.findAll();
        
        for(Vplanilla vp: vplanilla) {
        	for (Persona em: persona) {
        		if (vp.getIdPersona()==em.getIdPersona()) {
        			vp.setNombre(em.getNombre());
        			vp.setApellido(em.getApellido());
        		}
        	}
        }
        
        
        List<Puesto> puesto =puestoRepository.findAll();
        
        for(Vplanilla vp: vplanilla) {
        	for (Puesto em: puesto) {
        		if (vp.getIdPuesto()==em.getIdPuesto()) {
        			vp.setPuesto(em.getNombre());
        		}
        	}
        }
        
        List<StatusEmpleado> status =statusRepository.findAll();
        
        for(Vplanilla vp: vplanilla) {
        	for (StatusEmpleado em: status) {
        		if (vp.getIdStatusEmpleado()==em.getIdStatusEmpleado()) {
        			vp.setStatus(em.getNombre());
        		}
        	}
        }
        
        
        
        
        //RoleOpcion us = result.get(0);
        return  vplanilla;
    }
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> guardar (@RequestBody PlanillaDetalle planillaDetalle ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		planillaDetalle.setFechaCreacion(date);
		
		try {
			planillaDetalleRepository.save(planillaDetalle);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se guardó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo guardar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
}
