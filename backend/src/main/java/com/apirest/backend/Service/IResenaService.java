package com.apirest.backend.Service;

import java.util.List;

import java.util.List;

import com.apirest.backend.Model.ResenaModel;

public interface IResenaService {
    List<ResenaModel> obtenerTodos();
    ResenaModel guardarResena(ResenaModel resena);
    ResenaModel obtenerPorId(Integer id);
    ResenaModel actualizarResena(Integer id, ResenaModel resenaActualizada);
    void eliminarResena(Integer id);
}
