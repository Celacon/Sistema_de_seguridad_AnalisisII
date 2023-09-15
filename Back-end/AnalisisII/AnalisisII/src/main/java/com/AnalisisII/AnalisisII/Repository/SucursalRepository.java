package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.Sucursal;

@Repository("sucursalRespository")
public interface SucursalRepository extends JpaRepository<Sucursal, Serializable> {
	
	public List<Sucursal> findByIdSucursal(Integer idSucursal);

}
