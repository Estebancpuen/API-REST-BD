package com.apirest.backend.Repository;

import com.apirest.backend.Model.RetoLecturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetoLecturaRepository extends JpaRepository<RetoLecturaModel, Integer> {
}