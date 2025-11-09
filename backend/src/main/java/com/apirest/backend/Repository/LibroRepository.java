package com.apirest.backend.Repository;

import com.apirest.backend.Model.LibroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroModel, Integer> {
}
