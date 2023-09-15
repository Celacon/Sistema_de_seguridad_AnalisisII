package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.SucursalRepository;
import com.AnalisisII.AnalisisII.entity.Sucursal;

@RestController
@RequestMapping("/sucursal")
@CrossOrigin
public class SucursalService {
	@Autowired
	SucursalRepository sucursalRepository;
	
	@GetMapping(path = "/buscar")
	public List<Sucursal> buscar(){
		return sucursalRepository.findAll();
	}
	
	@GetMapping(path = "/buscarIdSucursal/{idSucursal}")
	public List<Sucursal> buscarIdSucursal(@PathVariable ("idSucursal") Integer idSucursal){
		return sucursalRepository.findByIdSucursal(idSucursal);
	}

}
