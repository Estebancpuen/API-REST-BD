package com.apirest.backend.Repository;

import com.apirest.backend.Model.ComentarioResenaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioResenaRepository extends JpaRepository<ComentarioResenaModel, Integer> {
}
