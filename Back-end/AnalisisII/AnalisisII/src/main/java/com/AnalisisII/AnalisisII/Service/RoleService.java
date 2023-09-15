package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.RoleRepository;
import com.AnalisisII.AnalisisII.entity.Role;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleService {
	
	@Autowired 
	RoleRepository roleRepository;
	
	@GetMapping(path = "/buscar")
	public List<Role> buscar(){
		return roleRepository.findAll();
	}
	

}
