package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AnalisisII.AnalisisII.entity.PlanillaCabecera;
import com.AnalisisII.AnalisisII.entity.PlanillaId;

@Repository("planillaCabeceraRepository")
public interface PlanillaCabeceraRepository extends JpaRepository<PlanillaCabecera, Serializable> {
	List<PlanillaCabecera> findById (PlanillaId id);
}
