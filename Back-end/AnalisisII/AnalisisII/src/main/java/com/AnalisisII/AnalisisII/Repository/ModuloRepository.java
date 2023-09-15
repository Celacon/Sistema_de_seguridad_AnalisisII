package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Modulo;

@Repository("moduloRepository")
public interface ModuloRepository extends JpaRepository<Modulo, Serializable> {

}
