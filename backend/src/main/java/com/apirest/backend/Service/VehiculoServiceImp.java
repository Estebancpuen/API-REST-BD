package com.apirest.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.EmpleadoModel;
import com.apirest.backend.Model.VehiculoModel;
import com.apirest.backend.Repository.IVehiculoRepository;

@Service
public class VehiculoServiceImp implements IVehiculoService{
    @Autowired IVehiculoRepository vehiculoRepository;
    @Autowired IEmpleadoService empleadoService;
    @Override
    public VehiculoModel crearVehiculo(VehiculoModel vehiculo) {
        //verificamos si el empleado existe
        EmpleadoModel empleadoExiste = empleadoService.
        buscarEmpleadoPorId(vehiculo.getEmpleado().getIdEmpleado());
        vehiculo.setEmpleado(empleadoExiste);
        return vehiculoRepository.save(vehiculo);
    }
    @Override
    public List<VehiculoModel> listarVehiculos() {
        return vehiculoRepository.findAll();
    }
}
