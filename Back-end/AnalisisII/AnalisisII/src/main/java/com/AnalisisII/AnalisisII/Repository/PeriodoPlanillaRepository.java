package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.PeriodoPlanilla;
import com.AnalisisII.AnalisisII.entity.PlanillaId;
@Repository("periodoPlanillaRepository")
public interface PeriodoPlanillaRepository extends JpaRepository<PeriodoPlanilla, Serializable> {

	List<PeriodoPlanilla> findById(PlanillaId id);
}
