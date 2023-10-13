package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.EstadoCivil;

@Repository("estadoCivilRepository")
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Serializable> {

	List<EstadoCivil> findByIdEstadoCivil(Integer idEstadoCivil);

}
