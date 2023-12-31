package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.CuentaBancariaEmpleado;

@Repository("cuentaBancariaEmpleadoRepository")
public interface CuentaBancariaEmpleadoRepository extends JpaRepository<CuentaBancariaEmpleado, Serializable> {

	List <CuentaBancariaEmpleado> findByIdCuentaBancaria (Integer idCuentaBancaria);
}
