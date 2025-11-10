package com.apirest.backend.Service;
import java.util.List;

import com.apirest.backend.Model.RetoLecturaModel;

public interface IRetoLecturaService {
    List<RetoLecturaModel> obtenerTodos();
    RetoLecturaModel guardarReto(RetoLecturaModel reto);
    RetoLecturaModel obtenerPorId(Integer id);
    RetoLecturaModel actualizarReto(Integer id, RetoLecturaModel retoActualizado);
    void eliminarReto(Integer id);
}
