package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.BitacoraAcceso;

@Repository("bitacoraAccesoRepository")
public interface BitacoraAccesoRepository extends JpaRepository<BitacoraAcceso, Serializable> {

}
