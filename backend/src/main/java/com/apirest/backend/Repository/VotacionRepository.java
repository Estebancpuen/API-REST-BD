package com.apirest.backend.Repository;

import com.apirest.backend.Model.VotacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacionRepository extends JpaRepository<VotacionModel, Integer> {
}
