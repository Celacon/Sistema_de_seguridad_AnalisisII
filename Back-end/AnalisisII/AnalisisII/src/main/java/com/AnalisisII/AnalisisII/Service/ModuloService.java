package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.ModuloRepository;
import com.AnalisisII.AnalisisII.entity.Modulo;

@RestController
@RequestMapping("/modulo")
@CrossOrigin
public class ModuloService {

	@Autowired
	ModuloRepository moduloRepository;
	
	@GetMapping(path ="buscar")
	public List<Modulo> buscar(){
		return moduloRepository.findAll();
	}
	
}
