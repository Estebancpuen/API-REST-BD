package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ReunionModel;

public interface IReunionService {
    List<ReunionModel> obtenerTodos();
    ReunionModel guardarReunion(ReunionModel reunion);
    ReunionModel obtenerPorId(Integer id);
    ReunionModel actualizarReunion(Integer id, ReunionModel reunionActualizada);
    void eliminarReunion(Integer id);
}