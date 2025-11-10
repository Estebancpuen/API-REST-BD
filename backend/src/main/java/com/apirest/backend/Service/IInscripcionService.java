package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.InscripcionModel;

public interface IInscripcionService {
    List<InscripcionModel> obtenerTodos();
    InscripcionModel guardarInscripcion(InscripcionModel inscripcion);
    InscripcionModel obtenerPorId(Integer id);
    InscripcionModel actualizarInscripcion(Integer id, InscripcionModel inscripcionActualizada);
    void eliminarInscripcion(Integer id);
}
