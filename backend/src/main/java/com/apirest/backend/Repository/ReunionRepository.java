package com.apirest.backend.Repository;

import com.apirest.backend.Model.ReunionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionRepository extends JpaRepository<ReunionModel, Integer> {
}