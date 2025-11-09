package com.apirest.backend.Service;

import com.apirest.backend.Model.PropuestaLibroModel;
import java.util.List;

public interface IPropuestaLibroService {
    List<PropuestaLibroModel> obtenerTodos();
    PropuestaLibroModel guardarPropuesta(PropuestaLibroModel propuesta);
    PropuestaLibroModel obtenerPorId(Integer id);
    PropuestaLibroModel actualizarPropuesta(Integer id, PropuestaLibroModel propuestaActualizada);
    void eliminarPropuesta(Integer id);
}
