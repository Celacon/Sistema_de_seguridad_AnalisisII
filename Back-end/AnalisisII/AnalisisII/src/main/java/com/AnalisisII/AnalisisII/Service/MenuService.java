package com.AnalisisII.AnalisisII.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.MenuRepository;
import com.AnalisisII.AnalisisII.entity.Menu;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;
	
	@GetMapping(path ="/buscar")
	public List <Menu> buscar(){
		return menuRepository.findAll();
	}

}
