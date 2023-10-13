package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnalisisII.AnalisisII.entity.TipoDocumento;

@Repository("tipoDocumentoRepository")
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Serializable> {

	List<TipoDocumento> findByIdTipoDocumento(Integer idTipoDocumento);
}
