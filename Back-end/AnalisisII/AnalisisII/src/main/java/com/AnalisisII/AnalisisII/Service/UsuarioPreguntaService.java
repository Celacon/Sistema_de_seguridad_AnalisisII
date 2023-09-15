package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.UsuarioPreguntaRepository;
import com.AnalisisII.AnalisisII.entity.UsuarioPregunta;

@RestController
@RequestMapping("/usuario-pregunta")
@CrossOrigin
public class UsuarioPreguntaService {
	
	@Autowired
	UsuarioPreguntaRepository usuarioPreguntaRepository;
	
	@GetMapping(path = "/buscar")
	public List<UsuarioPregunta> buscar(){
		return usuarioPreguntaRepository.findAll();
	}

}
