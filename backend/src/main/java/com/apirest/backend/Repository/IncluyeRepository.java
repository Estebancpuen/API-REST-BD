package com.apirest.backend.Repository;

import com.apirest.backend.Model.IncluyeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncluyeRepository extends JpaRepository<IncluyeModel, Integer> {
}