package com.apirest.backend.Repository;

import com.apirest.backend.Model.ValoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoraRepository extends JpaRepository<ValoraModel, Integer> {
}
