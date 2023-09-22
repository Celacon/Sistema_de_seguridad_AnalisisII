package com.AnalisisII.AnalisisII.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AnalisisII.AnalisisII.Repository.MenuRepository;
import com.AnalisisII.AnalisisII.Repository.ModuloRepository;
import com.AnalisisII.AnalisisII.Repository.OpcionRepository;
import com.AnalisisII.AnalisisII.Repository.RoleOpcionRepository;
import com.AnalisisII.AnalisisII.entity.Menu;
import com.AnalisisII.AnalisisII.entity.Modulo;
import com.AnalisisII.AnalisisII.entity.Opcion;
import com.AnalisisII.AnalisisII.entity.RoleOpcion;

@RestController
@RequestMapping("/modulo")
@CrossOrigin
public class ModuloService {

	@Autowired
	ModuloRepository moduloRepository;
	
	@Autowired
	RoleOpcionRepository roleOpcionRepository;
	
	@Autowired
	OpcionRepository opcionRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
	
	@GetMapping(path ="/buscar")
	public List<Modulo> buscar(){
		return moduloRepository.findAll();
	}
	
	/*
	@GetMapping(path ="/buscarIdRole/{idRole}")
	public List<Modulo> buscarIdRole(@PathVariable ("idRole")Integer idRole){
		List<Modulo> todoModulo = moduloRepository.findAll();
		
		List<Modulo> modulo = new ArrayList<>();  // Crear una lista para almacenar los módulos
	    List<Menu> menu = new ArrayList<>();      // Crear una lista para almacenar los menús
	    List<Opcion> opcion = new ArrayList<>(); 
		
		
		
		for (Modulo modulo1 : todoModulo) {   
	
			
			List<Menu> todoMenu = modulo1.getListMenu();
		
					for (Menu menu1: todoMenu) {
						List<Opcion> todoOpcion= menu1.getListOpcion();
						
						for (Opcion opcion1: todoOpcion) {
								List<RoleOpcion> todoRoleOpcion= opcion1.getListRoleOpcion();
								
								for (RoleOpcion roleOpcion1: todoRoleOpcion ) {
									if(roleOpcion1.getId().getIdRole().equals(idRole)) {
										opcion.add(opcion1);
										System.out.println("Hola            "+"opcion");
										
									}
									
								}
								
						}
						
						if(!opcion.isEmpty()) {
						menu.add(menu1);
							System.out.println("Hola            "+"menu");
						}
						
					}
					
						if(!menu.isEmpty()) {
							modulo.add(modulo1);
							System.out.println("Hola            "+"modulo");
						}
		
	        }
		
		
		
		
		
		return modulo;
	}*/
	
	
	@GetMapping(path ="/buscarIdRole/{idRole}")
	public List<Modulo> buscarIdRole(@PathVariable ("idRole")Integer idRole){
		
		List<RoleOpcion> roleOpcionTodo = roleOpcionRepository.findAll();
		
		List<Opcion> opcion = opcionRepository.findAll();
		
		List<Menu> menu = menuRepository.findAll();
		
		List<Modulo> modulo = moduloRepository.findAll();
		
		
		
		List<RoleOpcion> roleOpcionNuevos = new ArrayList<>();
		
		List<Opcion> opcionNuevos = new ArrayList<>();
		
		List<Menu> menuNuevos = new ArrayList<>();
		
		List<Modulo> moduloNuevos = new ArrayList<>();
		
		for(RoleOpcion roleOpcion: roleOpcionTodo) {
			if(roleOpcion.getId().getIdRole().equals(idRole)) {
				roleOpcionNuevos.add(roleOpcion);
				
			}
		}
		

		
		for(RoleOpcion roleOpcion: roleOpcionNuevos) {
			
				for (Opcion op: opcion) {
					if (roleOpcion.getId().getIdOpcion()== op.getIdOpcion()) {
						opcionNuevos.add(op);
						
					}
				}	
			
		}
		
		List<Opcion> opcionSinDuplicar = new ArrayList<>();
		for (Opcion elemento : opcionNuevos) {
		    if (!opcionSinDuplicar.contains(elemento)) {
		        opcionSinDuplicar.add(elemento);
		    }
		}
		
		
		
		
		for (Opcion op : opcionSinDuplicar) {
		    
			for (Menu men : menu) {
				if(op.getIdMenu()==men.getIdMenu()) {
					menuNuevos.add(men);
				}
			    
			}
		}
		
		
		List<Menu> menuSinDuplicar = new ArrayList<>();
		for (Menu men : menuNuevos) {
		    if (!menuSinDuplicar.contains(men)) {
		        menuSinDuplicar.add(men);
		    }
		}
		

		for (Menu men : menuSinDuplicar) {
		    
			for (Modulo mod : modulo) {
				if(men.getIdModulo()==mod.getIdModulo()) {
					moduloNuevos.add(mod);
				}
			    
			}
		}
		
		
		List<Modulo> moduloSinDuplicar = new ArrayList<>();
		for (Modulo men : moduloNuevos) {
		    if (!moduloSinDuplicar.contains(men)) {
		        moduloSinDuplicar.add(men);
		    }
		}
		
		
		
		
		for (Menu men: menuSinDuplicar) {
			List<Opcion> opc = new ArrayList<>();
			for(Opcion op: opcionSinDuplicar) {
				if(men.getIdMenu()==op.getIdMenu()) {
					opc.add(op);
				}
			}
			
			men.setListOpcion(opc);
		}
		
		
		for (Modulo mod: moduloSinDuplicar) {
			List<Menu> mnu = new ArrayList<>();
			for(Menu men: menuSinDuplicar) {
				if(mod.getIdModulo()==men.getIdModulo()) {
					mnu.add(men);
				}
			}
			
		mod.setListMenu(mnu);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		return moduloSinDuplicar;
	}
	
	
	
	
	
}
