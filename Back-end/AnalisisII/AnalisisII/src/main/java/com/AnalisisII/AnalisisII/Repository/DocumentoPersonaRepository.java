package com.AnalisisII.AnalisisII.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.AnalisisII.AnalisisII.entity.DocumentoPersona;
import com.AnalisisII.AnalisisII.entity.DocumentoPersonaId;

@Repository("documentoPersonaRepository")
public interface DocumentoPersonaRepository extends JpaRepository<DocumentoPersona, Serializable> {

	   List<DocumentoPersona> findById (DocumentoPersonaId id);
}
