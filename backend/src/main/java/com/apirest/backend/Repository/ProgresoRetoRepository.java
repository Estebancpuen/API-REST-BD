package com.apirest.backend.Repository;

import com.apirest.backend.Model.ProgresoRetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgresoRetoRepository extends JpaRepository<ProgresoRetoModel, Integer> {
}
