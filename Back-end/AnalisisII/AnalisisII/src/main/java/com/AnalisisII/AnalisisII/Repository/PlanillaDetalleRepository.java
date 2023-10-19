package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.PlanillaDetalle;

@Repository("planilaDetalleRepository")
public interface PlanillaDetalleRepository extends JpaRepository<PlanillaDetalle, Serializable> {

	List<PlanillaDetalle> findByAnioAndMes(Integer anio, Integer mes);
}
