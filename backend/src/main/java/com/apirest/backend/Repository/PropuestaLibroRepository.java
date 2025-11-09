package com.apirest.backend.Repository;

import com.apirest.backend.Model.PropuestaLibroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropuestaLibroRepository extends JpaRepository<PropuestaLibroModel, Integer> {
}