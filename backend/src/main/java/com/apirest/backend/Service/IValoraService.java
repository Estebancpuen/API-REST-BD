package com.apirest.backend.Service;

import com.apirest.backend.Model.ValoraModel;
import java.util.List;

public interface IValoraService {
    List<ValoraModel> obtenerTodos();
    ValoraModel guardarValoracion(ValoraModel valoracion);
    ValoraModel obtenerPorId(Integer id);
    ValoraModel actualizarValoracion(Integer id, ValoraModel valoracionActualizada);
    void eliminarValoracion(Integer id);
}