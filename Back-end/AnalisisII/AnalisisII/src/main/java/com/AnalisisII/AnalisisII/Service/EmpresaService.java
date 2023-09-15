package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.EmpresaRepository;
import com.AnalisisII.AnalisisII.entity.Empresa;

@RestController
@RequestMapping("/empresa")
@CrossOrigin
public class EmpresaService {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Empresa> buscar (){
		return empresaRepository.findAll();
	} 

	@GetMapping(path = "/buscarId/{idEmpresa}")
	public List<Empresa> buscarId (@PathVariable ("idEmpresa") Integer idEmpresa){
		return empresaRepository.findByIdEmpresa(idEmpresa);
	} 
}
