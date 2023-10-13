package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.PlanillaDetalle;

@Repository("planilaDetalleRepository")
public interface PlanillaDetalleRepository extends JpaRepository<PlanillaDetalle, Serializable> {

}
