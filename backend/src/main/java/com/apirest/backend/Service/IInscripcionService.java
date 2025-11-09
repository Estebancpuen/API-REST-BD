package com.apirest.backend.Service;

import com.apirest.backend.Model.InscripcionModel;
import java.util.List;

public interface IInscripcionService {
    List<InscripcionModel> obtenerTodos();
    InscripcionModel guardarInscripcion(InscripcionModel inscripcion);
    InscripcionModel obtenerPorId(Integer id);
    InscripcionModel actualizarInscripcion(Integer id, InscripcionModel inscripcionActualizada);
    void eliminarInscripcion(Integer id);
}
