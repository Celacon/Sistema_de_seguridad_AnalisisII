package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.PlanillaCabeceraRepository;
import com.AnalisisII.AnalisisII.Repository.PlanillaDetalleRepository;
import com.AnalisisII.AnalisisII.entity.PlanillaCabecera;
import com.AnalisisII.AnalisisII.entity.PlanillaId;

@RestController
@RequestMapping("/planillaCabecera")
@CrossOrigin
public class PlanillaCabeceraService {
	@Autowired
	PlanillaCabeceraRepository planillaCabeceraRepository;
	
	@Autowired
	PlanillaDetalleRepository planillaDetalleRepository;
	
	@GetMapping(path = "/buscar")
	public List<PlanillaCabecera> buscar (){
		return planillaCabeceraRepository.findAll();
	}

	@GetMapping("/buscarId/{anio}/{mes}")
    public List<PlanillaCabecera> geById(@PathVariable ("anio")Integer anio, @PathVariable ("mes")Integer mes) {
        PlanillaId id = new PlanillaId(anio, mes);
        List<PlanillaCabecera> result = planillaCabeceraRepository.findById(id);
        //RoleOpcion us = result.get(0);
        return  result;
    }
	
}
