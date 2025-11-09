package com.apirest.backend.Service;

import com.apirest.backend.Model.ResenaModel;
import java.util.List;

public interface IResenaService {
    List<ResenaModel> obtenerTodos();
    ResenaModel guardarResena(ResenaModel resena);
    ResenaModel obtenerPorId(Integer id);
    ResenaModel actualizarResena(Integer id, ResenaModel resenaActualizada);
    void eliminarResena(Integer id);
}
