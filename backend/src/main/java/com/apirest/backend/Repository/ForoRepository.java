package com.apirest.backend.Repository;

import com.apirest.backend.Model.ForoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForoRepository extends JpaRepository<ForoModel, Integer> {
}
