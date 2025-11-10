package com.apirest.backend.Service;

import java.util.List;

import com.apirest.backend.Model.ValoraModel;

public interface IValoraService {
    List<ValoraModel> obtenerTodos();
    ValoraModel guardarValoracion(ValoraModel valoracion);
    ValoraModel obtenerPorId(Integer id);
    ValoraModel actualizarValoracion(Integer id, ValoraModel valoracionActualizada);
    void eliminarValoracion(Integer id);
}