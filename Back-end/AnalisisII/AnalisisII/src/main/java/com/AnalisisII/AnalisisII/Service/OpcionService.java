package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.OpcionRepository;
import com.AnalisisII.AnalisisII.entity.Opcion;

@RestController
@RequestMapping("/opcion")
@CrossOrigin
public class OpcionService {

	@Autowired
	OpcionRepository opcionRepository;
	
	@GetMapping(path = "/buscar")
	public List<Opcion> buscar(){
		return opcionRepository.findAll();
	}
}
