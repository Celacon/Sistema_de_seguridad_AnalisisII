package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.AnalisisII.AnalisisII.entity.StatusEmpleado;

@Repository("statusEmpleadoRepository")
public interface StatusEmpleadoRepository extends JpaRepository<StatusEmpleado, Serializable> {

	List<StatusEmpleado> findByIdStatusEmpleado(Integer idStatusEmpleado);

}
