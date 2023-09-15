package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.BitacoraAccesoRepository;
import com.AnalisisII.AnalisisII.entity.BitacoraAcceso;

@RestController
@RequestMapping("bitacora-acceso")
@CrossOrigin
public class BitacoraAccesoService {
	
	@Autowired 
	BitacoraAccesoRepository bitacoraAccesoRepository;

	@GetMapping(path = "/buscar")
	public List<BitacoraAcceso> buscar(){
		return bitacoraAccesoRepository.findAll();
	}
}
