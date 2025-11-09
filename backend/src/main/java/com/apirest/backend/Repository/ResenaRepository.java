package com.apirest.backend.Repository;

import com.apirest.backend.Model.ResenaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaRepository extends JpaRepository<ResenaModel, Integer> {
}