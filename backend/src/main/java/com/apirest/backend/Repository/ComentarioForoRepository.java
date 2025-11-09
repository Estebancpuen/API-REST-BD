package com.apirest.backend.Repository;

import com.apirest.backend.Model.ComentarioForoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioForoRepository extends JpaRepository<ComentarioForoModel, Integer> {
}
