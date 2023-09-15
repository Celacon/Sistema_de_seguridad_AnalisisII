package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.RoleOpcion;
import com.AnalisisII.AnalisisII.entity.RoleOpcionId;

@Repository("roleOpcionREpository")
public interface RoleOpcionRepository extends JpaRepository<RoleOpcion, Serializable> {
   List<RoleOpcion> findById (RoleOpcionId id);
		
}
