package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.IncluyeModel;

public interface IIncluyeService {
    List<IncluyeModel> obtenerTodos();
    IncluyeModel guardarInclusion(IncluyeModel inclusion);
    IncluyeModel obtenerPorId(Integer id);
    IncluyeModel actualizarInclusion(Integer id, IncluyeModel inclusionActualizada);
    void eliminarInclusion(Integer id);
}
