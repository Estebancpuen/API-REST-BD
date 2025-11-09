package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.VehiculoModel;

public interface IVehiculoService {
    VehiculoModel crearVehiculo(VehiculoModel vehiculo);
    //otros métodos como obtener, actualizar, eliminar
    List<VehiculoModel> listarVehiculos();
}
