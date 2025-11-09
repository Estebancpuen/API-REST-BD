package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.EmpleadoModel;

public interface IEmpleadoService {
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado);
    public List<EmpleadoModel> listarEmpleados();
    public EmpleadoModel buscarEmpleadoPorId(Integer id);
    public EmpleadoModel actualizarEmpleado(Integer id, EmpleadoModel empleado);
    public String eliminarEmpleado(Integer id);
}

