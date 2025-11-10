package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ProgresoRetoModel;

public interface IProgresoRetoService {
    List<ProgresoRetoModel> obtenerTodos();
    ProgresoRetoModel guardarProgreso(ProgresoRetoModel progreso);
    ProgresoRetoModel obtenerPorId(Integer id);
    ProgresoRetoModel actualizarProgreso(Integer id, ProgresoRetoModel progresoActualizado);
    void eliminarProgreso(Integer id);
}
