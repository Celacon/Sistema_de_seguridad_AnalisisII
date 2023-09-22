package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Opcion;

@Repository("opcionRepository")
public interface OpcionRepository extends JpaRepository<Opcion, Serializable> {
	   List<Opcion> findByIdOpcion (Integer idOpcion);

}
