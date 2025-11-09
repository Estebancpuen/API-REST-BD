package com.apirest.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.Model.VehiculoModel;

public interface IVehiculoRepository extends JpaRepository<VehiculoModel, Integer>{
    //queries personalizadas
}
