package com.AnalisisII.AnalisisII.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(path ="buscar")
	public List<Modulo> buscar(){
		return moduloRepository.findAll();
	}

	@GetMapping ("/ConsultaModulo")
	public Optional <Modulo> ConsultaModulo (@RequestParam Integer idModulo)
	{
		return moduloRepository.findById(idModulo);
	}
	
	
	@GetMapping(path = "/buscarId/{idModulo}")
	public Optional <Modulo> ConsultaModulo2 (@PathVariable Integer idModulo)
	{
		return moduloRepository.findById(idModulo);

	}
	
	
	@PostMapping (path="/guardar")
	public ResponseEntity<Map<String, Object>> InserteModulo (@RequestBody Modulo modulo ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		modulo.setFechaCreacion(date);
		
		try {
			moduloRepository.save(modulo);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se guardó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo guardar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	} 
	
	@PostMapping (path="/editar")
	public ResponseEntity<Map<String, Object>> editarModulo (@RequestBody Modulo modulo ) {
		LocalDate fechaHoy = LocalDate.now();
		Date date = Date.valueOf(fechaHoy);
		modulo.setFechaModificacion(date);
		
		try {
			moduloRepository.save(modulo);
			  Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro se editó exitosamente");
	          return ResponseEntity.ok(successResponse);	
		}catch(Exception e){
			 Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("mensaje", "El registro no se pudo editar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
		}
	}
	
	
	
	
	@DeleteMapping("/EliminarModulo/{idModulo}")
	  public ResponseEntity<Map<String, Object>> EliminarModulo(
	      @PathVariable("idModulo") Integer idModulo){
	      

			
	      
	      try {
	          moduloRepository.deleteById(idModulo);
	          Map<String, Object> successResponse = new HashMap<>();
	          successResponse.put("mensaje", "Registro borrado exitosamente");
	         
	          return ResponseEntity.ok(successResponse);
	      } catch (Exception e) {
	    	  Map<String, Object> errorResponse = new HashMap<>();
			    errorResponse.put("error", "El registro no se pudo borrar");
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		   }

}
	
	
	
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
