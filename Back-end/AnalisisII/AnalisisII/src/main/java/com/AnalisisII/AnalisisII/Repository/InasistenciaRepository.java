package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Inasistencia;

@Repository("inasitenciaRepository")
public interface InasistenciaRepository extends JpaRepository<Inasistencia, Serializable> {

	List<Inasistencia> findByIdInasistencia(Integer idInasistencia);

}
