package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.TipoAcceso;

@Repository("tipoAccesoRepository")
public interface TipoAccesoRepository extends JpaRepository<TipoAcceso, Serializable> {

}
