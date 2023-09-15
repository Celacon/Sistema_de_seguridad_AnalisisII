package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.StatusUsuarioRepository;
import com.AnalisisII.AnalisisII.entity.StatusUsuario;

@RestController
@RequestMapping("/status-usuario")
@CrossOrigin
public class StatusUsuarioService {
	@Autowired
	StatusUsuarioRepository statusUsuarioRepository;
	
	@GetMapping(path = "/buscar")
	public List<StatusUsuario> buscar(){
		return statusUsuarioRepository.findAll();
	}

}
