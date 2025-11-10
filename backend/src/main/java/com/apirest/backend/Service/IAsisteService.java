package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.AsisteModel;

public interface IAsisteService {
    List<AsisteModel> obtenerTodos();
    AsisteModel guardarAsistencia(AsisteModel asistencia);
    AsisteModel obtenerPorId(Integer id);
    AsisteModel actualizarAsistencia(Integer id, AsisteModel asistenciaActualizada);
    void eliminarAsistencia(Integer id);
}
