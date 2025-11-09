package com.apirest.backend.Repository;

import com.apirest.backend.Model.InscripcionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionModel, Integer> {
}
