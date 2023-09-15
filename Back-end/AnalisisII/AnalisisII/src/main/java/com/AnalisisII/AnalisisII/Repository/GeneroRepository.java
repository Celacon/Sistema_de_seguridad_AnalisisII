package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Genero;
@Repository("generoRepository")
public interface GeneroRepository extends JpaRepository<Genero,Serializable> {

	public List<Genero> findByIdGenero(Integer idgenero);
}
