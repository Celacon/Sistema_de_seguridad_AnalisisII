package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Puesto;

@Repository("puestoRepository")
public interface PuestoRepository extends JpaRepository<Puesto, Serializable> {

	List<Puesto> findByIdPuesto(Integer idPuesto);
}
