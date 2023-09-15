package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.UsuarioRole;
import com.AnalisisII.AnalisisII.entity.UsuarioRoleId;

@Repository("usuarioRoleRepository")
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRole, Serializable> {
	List<UsuarioRole> findById(UsuarioRoleId id);
	
}
