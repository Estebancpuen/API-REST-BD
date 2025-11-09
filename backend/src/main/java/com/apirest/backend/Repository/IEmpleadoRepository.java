package com.apirest.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.Model.EmpleadoModel;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoModel, Integer> {
    ///
}
