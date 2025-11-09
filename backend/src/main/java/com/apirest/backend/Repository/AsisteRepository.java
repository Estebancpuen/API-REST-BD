package com.apirest.backend.Repository;

import com.apirest.backend.Model.AsisteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsisteRepository extends JpaRepository<AsisteModel, Integer> {
}
