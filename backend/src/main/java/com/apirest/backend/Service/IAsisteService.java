package com.apirest.backend.Service;

import com.apirest.backend.Model.AsisteModel;
import java.util.List;

public interface IAsisteService {
    List<AsisteModel> obtenerTodos();
    AsisteModel guardarAsistencia(AsisteModel asistencia);
    AsisteModel obtenerPorId(Integer id);
    AsisteModel actualizarAsistencia(Integer id, AsisteModel asistenciaActualizada);
    void eliminarAsistencia(Integer id);
}
