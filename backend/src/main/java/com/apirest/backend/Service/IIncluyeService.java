package com.apirest.backend.Service;

import com.apirest.backend.Model.IncluyeModel;
import java.util.List;

public interface IIncluyeService {
    List<IncluyeModel> obtenerTodos();
    IncluyeModel guardarInclusion(IncluyeModel inclusion);
    IncluyeModel obtenerPorId(Integer id);
    IncluyeModel actualizarInclusion(Integer id, IncluyeModel inclusionActualizada);
    void eliminarInclusion(Integer id);
}
