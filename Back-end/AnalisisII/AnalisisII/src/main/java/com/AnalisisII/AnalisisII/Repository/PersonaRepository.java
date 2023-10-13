package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnalisisII.AnalisisII.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Serializable> {

	Optional<Persona> findByIdPersona(Integer idPersona);

}
