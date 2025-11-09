package com.apirest.backend.Repository;

import com.apirest.backend.Model.ArchivoAdjuntoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoAdjuntoRepository extends JpaRepository<ArchivoAdjuntoModel, Integer> {
}
