package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.TipoAccesoRepository;
import com.AnalisisII.AnalisisII.entity.TipoAcceso;

@RestController
@RequestMapping("/tipo-acceso")
@CrossOrigin
public class TipoAccesoService {
	@Autowired
	TipoAccesoRepository tipoAccesoRepository;
	

	@GetMapping(path = "/buscar")
	public List<TipoAcceso> buscar(){
		return tipoAccesoRepository.findAll();
	}
}
