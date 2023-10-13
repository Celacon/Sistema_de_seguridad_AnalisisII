package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.FlujoStatusEmpleado;
import com.AnalisisII.AnalisisII.entity.FlujoStatusEmpleadoId;


@Repository("flujoStatusEmpleadoRepository")
public interface FlujoStatusEmpleadoRepository extends JpaRepository<FlujoStatusEmpleado, Serializable> {

	List<FlujoStatusEmpleado> findById (FlujoStatusEmpleadoId id);
	
	
}
