package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.GeneroRepository;
import com.AnalisisII.AnalisisII.entity.Genero;

@RestController
@RequestMapping("/genero")
@CrossOrigin
public class GeneroService {
	@Autowired
	GeneroRepository generoRepository;
	
	@GetMapping(path = "/buscar")
	public List<Genero> buscar(){
		return generoRepository.findAll();
	}
	
	

}
