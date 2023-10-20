package com.AnalisisII.AnalisisII.Repository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Empleado;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable> {

	List<Empleado> findByIdEmpleado(Integer idEmpleado);
	List<Empleado> findByIdStatusEmpleado(Integer idStatusEmpleado);
	
	

}
