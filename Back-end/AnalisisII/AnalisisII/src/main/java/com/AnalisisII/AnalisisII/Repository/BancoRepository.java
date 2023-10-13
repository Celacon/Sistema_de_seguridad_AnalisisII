package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AnalisisII.AnalisisII.entity.Banco;

@Repository("bancoRepository")
public interface BancoRepository extends JpaRepository<Banco, Serializable> {
 
	public List<Banco> findByIdBanco(Integer idBanco);
}
