package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.PropuestaLibroModel;

public interface IPropuestaLibroService {
    List<PropuestaLibroModel> obtenerTodos();
    PropuestaLibroModel guardarPropuesta(PropuestaLibroModel propuesta);
    PropuestaLibroModel obtenerPorId(Integer id);
    PropuestaLibroModel actualizarPropuesta(Integer id, PropuestaLibroModel propuestaActualizada);
    void eliminarPropuesta(Integer id);
}
